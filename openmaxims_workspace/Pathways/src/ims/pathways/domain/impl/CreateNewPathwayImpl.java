//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.60 build 2874.17009)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.IAppUser;
import ims.framework.utils.Date;
import ims.pathways.configuration.domain.objects.Pathway;
import ims.pathways.configuration.domain.objects.Target;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.PathwaySearchAndSelect;
import ims.pathways.domain.base.impl.BaseCreateNewPathwayImpl;
import ims.pathways.domain.objects.JourneyTargetStatus;
import ims.pathways.domain.objects.PatientJourneyTarget;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.PathwayHistoryVo;
import ims.pathways.vo.PathwayHistoryVoCollection;
import ims.pathways.vo.PathwayLiteVo;
import ims.pathways.vo.PathwayLiteVoCollection;
import ims.pathways.vo.PatientJourneyShortVo;
import ims.pathways.vo.PatientJourneyVo;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.domain.PathwayLiteVoAssembler;
import ims.pathways.vo.domain.PatientJourneyShortVoAssembler;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.lookups.PatientTargetStatus;
import ims.vo.interfaces.IMos;

public class CreateNewPathwayImpl extends BaseCreateNewPathwayImpl
{

	private static final long	serialVersionUID	= 1L;

	public PatientJourneyVo getPatientJourney(PatientPathwayJourneyRefVo journey)
	{
		if (journey.getID_PatientPathwayJourney() == null)
			throw new CodingRuntimeException("No id provided for PatientJourney in method getPatientJourney");

		return PatientJourneyVoAssembler.create((PatientPathwayJourney) getDomainFactory().getDomainObject(journey));
	}

	public PatientJourneyShortVo getPatientJourneyShort(PatientPathwayJourneyRefVo journey)
	{
		if (journey.getID_PatientPathwayJourney() == null)
			throw new CodingRuntimeException("No id provided for PatientJourney in method getPatientJourney");

		return PatientJourneyShortVoAssembler.create((PatientPathwayJourney) getDomainFactory().getDomainObject(journey));
	}
	
	public PatientJourneyVo updatePatientJourney(PatientJourneyVo patientJourney, PathwayLiteVo pathway, ims.framework.interfaces.IAppUser currentUser) throws StaleObjectException,DomainInterfaceException
	{
		// Set the pathway in PatienJourney to pathway.
		// Get the History collection and add existing pathway
		// Call savePatientJourney in HL7PathwayIml
		
		PathwayHistoryVoCollection historyColl = patientJourney.getPathwayHistory();
		if(historyColl == null)
			historyColl = new PathwayHistoryVoCollection();
				
		if (patientJourney.getPathway().getID_PathwayIsNotNull())
		{
			PathwayHistoryVo history = new PathwayHistoryVo();
			history.setStartDate(patientJourney.getPathway().getSysInfo().getCreationDateTime().getDate());
			history.setEndedOnDate(new Date());
			history.setPathway(patientJourney.getPathway());
			patientJourney.getPathwayHistory().add(history);
		}		
		
		patientJourney.setPathway(pathway);
		
		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
		patientJourney = impl.createPatientJourney(patientJourney, null, null, null,null);
		
		// wdev-7919  
		// Now that the journey is created, we want to figure out what is required for the targets
		updateTargetStatus(impl, patientJourney, currentUser);
		
		return patientJourney;
	}

	/**
	 * wdev-7919
	 * updateTargetStatus
	 * @param impl 
	 * @param patientJourney  The journey to be affected
	 * @param currentUser 
	 */
	private void updateTargetStatus(HL7PathwayIf impl, PatientJourneyVo patientJourney, IAppUser currentUser) 
	{
		DomainFactory factory = (DomainFactory) getDomainFactory();
		
		/* Look at all the targets for this patientJourney and apply the following rules...
		1. The assumption is that the following will take place for targets found within the current clock only and target dates will NOT be recalculated. 
		2. If a target status is currently set to achieved, the target will remain visible and achieved. 
		3. If a target status is currently set to in-scope or event scheduled, and that target is part of a pathway-target for the new pathway, the target will remain with the same status. 
		4. If a target status is currently set to in-scope, and that target is NOT part of a pathway-target for the new pathway, it's status will be changed so that it will not be visible. This could be a new status e.g. NOT-IN-CURRENT-PATHWAY. 
		5. Point 4 will then allow us to reset the target back to in-scope with it's original values should the pathway type be reset back to it's original value. 
		6. The other status values for targets are EventCancelled, DNA, CLOCKSTOP, Pause, Unpause - If these status are set for a target, they will remain the same.
		*/ 
		
		// Get the current clock
		int pjtClockId=0;
		int curClockId = patientJourney.getCurrentClock().getID_PathwayClock();
		for (int i=0; i<patientJourney.getPatientTargets().size(); i++)
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) factory.getDomainObject(PatientJourneyTarget.class, patientJourney.getPatientTargets().get(i).getID_PatientJourneyTarget());
			if (domPjt.getJourneyClock() != null)
				pjtClockId = domPjt.getJourneyClock().getId();
			
			if (pjtClockId != curClockId)
				continue;
			
			JourneyTargetStatus stat = domPjt.getCurrentStatus();
			// For current in-scope or scheduled targets, we may need to set their status to inscope_prev_pathway
			if (stat.getStatus().getId() == PatientTargetStatus.INSCOPE.getId() || stat.getStatus().getId() == PatientTargetStatus.EVENTSCHEDULED.getId())
			{
				// If this target is not part of new pathway, update it's status so it will not be visible
				if (!inNewPathway(factory, domPjt.getPathwayTarget().getTarget(), patientJourney))
				{
					JourneyTargetStatus newStat = new JourneyTargetStatus();
					newStat.setDate(new java.util.Date());
					newStat.setChangedBy(currentUser == null ? "Unknown" : currentUser.getUsername());
					newStat.setStatus(getDomLookup(PatientTargetStatus.INSCOPE_PREV_PATHWAY));
					domPjt.getStatusHistory().add(newStat);
					domPjt.setCurrentStatus(newStat);
				}
			}
			// For current targets with a status of inscope_prev_pathway, we may need to set their status
			// back to in-scope if they are now in use for this pathway
			else if (stat.getStatus().getId() == PatientTargetStatus.INSCOPE_PREV_PATHWAY.getId())
			{
				// If this target is part of new pathway (and wasn't the old one i.e. status is inscope_prev_pathway
				// set status back to inscope
				if (inNewPathway(factory, domPjt.getPathwayTarget().getTarget(), patientJourney))
				{
					JourneyTargetStatus newStat = new JourneyTargetStatus();
					newStat.setDate(new java.util.Date());
					newStat.setChangedBy(currentUser == null ? "Unknown" : currentUser.getUsername());
					newStat.setStatus(getDomLookup(PatientTargetStatus.INSCOPE));
					domPjt.getStatusHistory().add(newStat);
					domPjt.setCurrentStatus(newStat);
				}
			}
				
			
		}
		
		
	}

	/**
	 * wdev-7919
	 * inNewPathway
	 * If the target specified is part of the new pathway, return true, otherwise, return false
	 * @param factory
	 * @param target
	 * @param patientJourney 
	 * @return
	 */
	private boolean inNewPathway(DomainFactory factory, Target target, PatientJourneyVo patientJourney)
	{
		String hql=" from PathwayTarget pt where pt.target = :target and pt.pathway = :pathway and pt.status = :status";
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("target");
		labels.add("pathway");
		labels.add("status");
		values.add(target);
		values.add(factory.getDomainObject(Pathway.class, patientJourney.getPathway().getID_Pathway()));
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 0)
			return true;

		return false;
	}
	

	public PathwayLiteVoCollection listPathway(String name, Specialty specialty, IMos consultant, PreActiveActiveInactiveStatus status) 
	{
		// TODO temporary measure until component or new control created
		if (name != null)
			name = name.replaceAll("%", "");

		List pathways = ((PathwaySearchAndSelect) getDomainImpl(PathwaySearchAndSelectImpl.class)).listDomainPathway(name, specialty, consultant, status);
		return PathwayLiteVoAssembler.createPathwayLiteVoCollectionFromPathway(pathways).sort();

	}
}
