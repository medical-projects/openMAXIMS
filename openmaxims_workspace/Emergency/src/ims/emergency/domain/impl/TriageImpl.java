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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EmergencyAttendanceRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.EpisodeofCareShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.AttendanceKPIConfig;
import ims.emergency.domain.base.impl.BaseTriageImpl;
import ims.emergency.domain.objects.SeenByHCP;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.AttendanceKPIConfigForTriageVo;
import ims.emergency.vo.EmergencyAttendanceForTriageLiteVo;
import ims.emergency.vo.EmergencyEpisodeForTriageVoCollection;
import ims.emergency.vo.EpisodeOfcareLiteVo;
import ims.emergency.vo.SeenByHCPVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingForTriageVo;
import ims.emergency.vo.TrackingListForTriageVo;
import ims.emergency.vo.TrackingListForTriageVoCollection;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.TriageProtocolAssessmentForTriageVoCollection;
import ims.emergency.vo.domain.AttendanceKPIConfigForTriageVoAssembler;
import ims.emergency.vo.domain.EmergencyAttendanceForTriageLiteVoAssembler;
import ims.emergency.vo.domain.EmergencyEpisodeForTriageVoAssembler;
import ims.emergency.vo.domain.EpisodeOfcareLiteVoAssembler;
import ims.emergency.vo.domain.SeenByHCPVoAssembler;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.emergency.vo.domain.TrackingForTriageVoAssembler;
import ims.emergency.vo.domain.TrackingListForTriageVoAssembler;
import ims.emergency.vo.domain.TriageProtocolAssessmentForTriageVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;

import java.util.ArrayList;
import java.util.List;

public class TriageImpl extends BaseTriageImpl
{
	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TrackingListForTriageVoCollection listPatientsWaiting(ILocation edLocation, ims.emergency.vo.lookups.TrackingStatus trackingStatus, HcpRefVo allocatedHcp)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select tr , (select count (alert.id) from PatientAlert as alert where ( alert.isRIE = false or alert.isRIE is null ) and alert.isCurrentlyActiveAlert = true and alert.patient.id = p.id), (select count (allergy.id) from PatientAllergy as allergy where ( allergy.isRIE = false or allergy.isRIE is null ) and allergy.isCurrentlyActiveAllergy = true and allergy.patient.id = p.id) from Tracking as tr left join tr.patient as p left join tr.attendance as att ");
		StringBuilder hqlConditions = new StringBuilder(" where ((tr.isDischarged is null or tr.isDischarged = 0) and att.outcome is null) ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String and = " and ";
		
		if(edLocation != null)
		{
			hqlJoins.append(" left join tr.eDLocation as loc ");
			
			hqlConditions.append(and);
			hqlConditions.append(" loc.id = :locId ");
			paramNames.add("locId");
			paramValues.add(edLocation.getID());
			and = " and ";
		}
		
		if(trackingStatus != null)
		{
			hqlJoins.append(" left join tr.currentStatus as cs left join cs.status as s ");
			
			hqlConditions.append(and);
			hqlConditions.append(" s.id = :statusId ");
			paramNames.add("statusId");
			paramValues.add(trackingStatus.getID());
			and = " and ";
		}
		
		//WDEV-16816
		if(allocatedHcp != null && allocatedHcp.getID_Hcp() != null)
		{
			HcpLiteVo tempHcpLiteVo = HcpLiteVoAssembler.create((Hcp) factory.getDomainObject(Hcp.class, allocatedHcp.getID_Hcp()));
			
			if (tempHcpLiteVo!=null && HcpDisType.MEDICAL.equals(tempHcpLiteVo.getHcpType()))
			{
				String[] allocatedHcpJoin = {" left join tr.seenBy as seenByHcp left join seenByHcp.allocatedMedic  as medic "};
			
			
    			for(int a=0; a<allocatedHcpJoin.length; a++)
    			{
    				if(hqlJoins.indexOf(allocatedHcpJoin[a]) < 0)
    				{
    					hqlJoins.append(allocatedHcpJoin[a]);
    				}
    			}
    			
    			hqlConditions.append(" and medic.id = :HcpId " );
    			paramNames.add("HcpId");
    			paramValues.add(allocatedHcp.getID_Hcp());
			}
			else if (tempHcpLiteVo!=null && HcpDisType.NURSING.equals(tempHcpLiteVo.getHcpType()))
			{
				String[] allocatedNurseJoin = {" left join tr.seenBy as seenByHcp left join seenByHcp.allocatedNurse as nurse "};
			
    			for(int a=0; a<allocatedNurseJoin.length; a++)
    			{
    				if(hqlJoins.indexOf(allocatedNurseJoin[a]) < 0)
    				{
    					hqlJoins.append(allocatedNurseJoin[a]);
    				}
    			}
    			
    			hqlConditions.append(" and nurse.id = :HcpId ");
    			paramNames.add("HcpId");
    			paramValues.add(allocatedHcp.getID_Hcp());
			}
			
		}
		
		List<?> patients = factory.find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);
		
		if(patients == null || patients.size() == 0)
			return null;
		
		TrackingListForTriageVoCollection coll = new TrackingListForTriageVoCollection();
		
		for(int i=0; i<patients.size(); i++)
		{
			Object[] items = (Object[]) patients.get(i);
			TrackingListForTriageVo tracking = null;
			
			if(items[0] instanceof Tracking)
			{
				tracking = TrackingListForTriageVoAssembler.create((Tracking) items[0]);
			}
			
			if(items[1] instanceof Long)
			{
				if(tracking != null && tracking.getPatient() != null)
				{
					tracking.getPatient().setHasAlerts(((Long) items[1]) > 0 ? Boolean.TRUE : Boolean.FALSE);
				}
			}
			
			if(items[2] instanceof Long)
			{
				if(tracking != null && tracking.getPatient() != null)
					
				{
					tracking.getPatient().setHasAllergies(((Long) items[2]) > 0 ? Boolean.TRUE : Boolean.FALSE);
				}
			}
			
			coll.add(tracking);
		}
		
		return coll;
	}

	public EmergencyEpisodeForTriageVoCollection listAttendanceHistory(PatientRefVo patient) 
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot list Emergency Episodes for a null Patient Id.");
		
		//String query = "select ee from EmergencyEpisode as ee left join ee.episodeOfCare as ec left join ec.careSpell as cs left join cs.patient as p where p.id = :PatientId order by ee.injuryDateTime desc, ee.emergencyAttendances.arrivalDateTime desc ";
		String query = "select ee from EmergencyEpisode as ee left join ee.episodeOfCare as ec left join ec.careSpell as cs left join cs.patient as p where p.id = :PatientId order by ec.startDate desc, ee.emergencyAttendances.arrivalDateTime desc ";  //wdev-16070
		
		return EmergencyEpisodeForTriageVoAssembler.createEmergencyEpisodeForTriageVoCollectionFromEmergencyEpisode(getDomainFactory().find(query, new String[] {"PatientId"}, new Object[] {patient.getID_Patient()}));
	}

	public ClinicalProblemShortVoCollection listClinicalProblems(String searchText) 
	{
		if(searchText == null)
			return null;
		
		searchText = searchText.trim().toUpperCase();
		
		if(searchText == null || searchText.length() == 0)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select cp from ClinicalProblem as cp left join cp.keywords as k where (upper(cp.pCName) like :ClinicalProblemSearchText or upper(k.keyword) like :ClinicalProblemSearchText) and cp.isActive = 1 order by upper(cp.pCName) asc";
		List<?> clinicalProblemsList = factory.find(query, new String[] {"ClinicalProblemSearchText"}, new Object[] {searchText + "%"});

		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem(clinicalProblemsList);
	}

	public TrackingForTriageVo getTrackingForTriage(TrackingRefVo trackingId) 
	{
		if(trackingId == null || trackingId.getID_Tracking() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Tracking Id.");
		
		return TrackingForTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingId.getID_Tracking()));
	}

	public TrackingForTriageVo saveTracking(TrackingForTriageVo tracking, SeenByHCPVo seenByHCP) throws StaleObjectException     //wdev-15930  //WDEV-16816
	{
		if(tracking == null)
			throw new CodingRuntimeException("Cannot save a null Tracking record.");
		
		if(!tracking.isValidated())
			throw new CodingRuntimeException("Tracking record is not validated.");
		
		DomainFactory factory = getDomainFactory();
		//wdev-15930
		//WDEV-16816
		SeenByHCP doSeenBy = null;
		if( seenByHCP != null ) 
		{
			doSeenBy = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHCP);
			if( doSeenBy != null )
			{
				factory.save(doSeenBy);
				
			}
		}
			
		//-------------wdev-15930------------
		
		Tracking doTracking = TrackingForTriageVoAssembler.extractTracking(factory, tracking);
		if( doSeenBy != null ) //wdev-15930 //WDEV-16816
		{
			doTracking.setSeenBy(doSeenBy); //WDEV-16816
		}
		
		factory.save(doTracking);
		
		return TrackingForTriageVoAssembler.create(doTracking);
	}

	public TrackingForTriageVo geTrackingForTriageByAttendanceId(EmergencyAttendanceRefVo attendanceId) 
	{
		if(attendanceId == null || attendanceId.getID_EmergencyAttendance() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Attendance Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att where att.id = :AttendanceId";
		
		List<?> list = factory.find(query, new String[] {"AttendanceId"}, new Object[] {attendanceId.getID_EmergencyAttendance()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return TrackingForTriageVoAssembler.create((Tracking) list.get(0));
	}

	public AttendanceKPIConfigForTriageVo getAttendanceKPIConfigForTriage(ILocation edLocation) 
	{
		if(edLocation == null)
			throw new CodingRuntimeException("Cannot get AttendanceKPIConfig for a null EDLocation Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select kpi from AttendanceKPIConfig as kpi left join kpi.eDLocation as loc where loc.id = :EDLoc";
		
		List<?> list = factory.find(query, new String[] {"EDLoc"}, new Object[] {edLocation.getID()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return AttendanceKPIConfigForTriageVoAssembler.create((AttendanceKPIConfig) list.get(0));
	}

	public TriageProtocolAssessmentForTriageVoCollection listOtherProblems(CareContextRefVo careContext) 
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot list other problems for a null Care Context Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tpa from TriageProtocolAssessment as tpa left join tpa.attendance as cc where cc.id = :CareContextId and (tpa.isMain is null or tpa.isMain = 0) ";
		
		List<?> otherProblems = factory.find(query, new String[] {"CareContextId"}, new Object[] {careContext.getID_CareContext()});
		
		return TriageProtocolAssessmentForTriageVoAssembler.createTriageProtocolAssessmentForTriageVoCollectionFromTriageProtocolAssessment(otherProblems);
	}

	public TrackingForTriageVo getTrackingForTriageByCareContext(CareContextRefVo careContext) 
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Care Context Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att left join att.careContext as cc where cc.id = :CareContextId";
		
		List<?> trackingList = factory.find(query, new String[] {"CareContextId"}, new Object[] {careContext.getID_CareContext()});
		
		if(trackingList == null || trackingList.size() == 0)
			return null;
		
		return TrackingForTriageVoAssembler.create((Tracking) trackingList.get(0));
	}

	public EpisodeofCareShortVo getEpisodeOfCare(EpisodeOfCareRefVo episodeOfCare) 
	{
		if(episodeOfCare == null || episodeOfCare.getID_EpisodeOfCare() == null)
			throw new CodingRuntimeException("Cannnot get EOC for a null Id.");
		
		return EpisodeofCareShortVoAssembler.create((EpisodeOfCare) getDomainFactory().getDomainObject(EpisodeOfCare.class, episodeOfCare.getID_EpisodeOfCare()));
	}

	public CareContextShortVo getCareContext(CareContextRefVo careContext) 
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot get CC for a null Id.");
	
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContext.getID_CareContext()));
	}

	//WDEV-15815
	public PatientShort getPatientShort(PatientRefVo patientRefVo)
	{
		if(patientRefVo == null || patientRefVo.getID_Patient() == null)
			throw new CodingRuntimeException("Cannnot get EOC for a null Id.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRefVo.getID_Patient()));
	}

	//WDEV-15951
	public TrackingForTriageVo getTrackingForTriageByActiveCareContext(PatientRefVo patientRef)
	{
		if(patientRef == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Patient Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att left join att.careContext as cc left join cc.episodeOfCare as EOC left join EOC.careSpell as CS  left join CS.patient as PAT where cc.endDateTime is null and PAT.id = :PatientId";
		
		List<?> trackingList = factory.find(query, new String[] {"PatientId"}, new Object[] {patientRef.getID_Patient()});
		
		if(trackingList == null || trackingList.size() == 0)
			return null;
		
		return TrackingForTriageVoAssembler.create((Tracking) trackingList.get(0));
	}

	//WDEV-15951
	public EmergencyAttendanceForTriageLiteVo getEmergencyAttendance(EmergencyAttendanceRefVo attendanceRef)
	{
		if(attendanceRef == null)
			throw new CodingRuntimeException("Cannot get Attendance on null Id.");
		
		return EmergencyAttendanceForTriageLiteVoAssembler.create((EmergencyAttendance) getDomainFactory().getDomainObject(EmergencyAttendance.class, attendanceRef.getID_EmergencyAttendance()));
	}

	//wdev-16070
	public EpisodeOfcareLiteVo getEpisodeOfCareLite(EpisodeOfCareRefVo episodeOfCareRef)
	{
		if( episodeOfCareRef == null )
			throw new CodingRuntimeException("EpisodeOfCareRefVo not provided");
		
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, episodeOfCareRef.getID_EpisodeOfCare());
		return EpisodeOfcareLiteVoAssembler.create(doEpisodeOfCare);
	}

	//wdev-17819
	public TrackingForClinicianWorklistAndTriageVo getTrckinGForClonicianWorklosAndTriage(TrackingRefVo trackingRef)
	{
		if(trackingRef == null || trackingRef.getID_Tracking() == null)
			throw new CodingRuntimeException("Cannnot get Tracking for a null Id.");
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingRef.getID_Tracking()));
	
	}

}
