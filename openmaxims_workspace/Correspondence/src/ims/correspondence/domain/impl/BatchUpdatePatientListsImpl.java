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
// This code was generated by Peter Martin using IMS Development Environment (version 1.62 build 3100.30141)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.domain.objects.OutpatientAttendance;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.vo.DischargedEpisodeVoCollection;
import ims.core.vo.InpatientEpisodeVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.OutPatientAttendanceVoCollection;
import ims.core.vo.OutPatientListSearchCriteriaVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.InpatientEpisodeVoAssembler;
import ims.core.vo.domain.OutPatientAttendanceVoAssembler;
import ims.core.vo.domain.PasEventVoAssembler;
import ims.core.vo.lookups.DocumentStatus;
import ims.correspondence.domain.CorrespondenceInpatientList;
import ims.correspondence.domain.CorrespondenceOutpatientList;
import ims.correspondence.domain.base.impl.BaseBatchUpdatePatientListsImpl;
import ims.correspondence.domain.objects.CorrespondenceDetails;
import ims.correspondence.vo.CorrespondenceDetailsVo;
import ims.correspondence.vo.CorrespondencePatientListsVoCollection;
import ims.correspondence.vo.CorrespondenceStatusHistoryVo;
import ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection;
import ims.correspondence.vo.domain.CorrespondenceDetailsVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

public class BatchUpdatePatientListsImpl extends BaseBatchUpdatePatientListsImpl
{

	private static final long serialVersionUID = 1L;

	public CorrespondencePatientListsVoCollection listInPatients(ims.core.vo.PatientListsFilterVo filter, Boolean listByReqAndNotReqStatus)
	{
		CorrespondenceInpatientList inpatientList = (CorrespondenceInpatientList)getDomainImpl(CorrespondenceInpatientListImpl.class);
		return inpatientList.listInPatients(filter, listByReqAndNotReqStatus, false);
	}

	public void saveInpatientEpisodes(InpatientEpisodeVoCollection collInpatientEpisodeVo, MemberOfStaffShortVo mos) throws DomainInterfaceException, StaleObjectException {
		for(int i=0; i<collInpatientEpisodeVo.size(); i++){
			if (!collInpatientEpisodeVo.get(i).isValidated())
			{
				throw new DomainRuntimeException("Episode VO has not been validated!");
			}
		
			DomainFactory factory = getDomainFactory();		
			InpatientEpisode ipDo = InpatientEpisodeVoAssembler.extractInpatientEpisode(factory, collInpatientEpisodeVo.get(i));
			
			factory.save(ipDo);
			saveDocumentStatus(collInpatientEpisodeVo.get(i).getPasEvent().getCspDocumentStatus(), collInpatientEpisodeVo.get(i).getPasEvent(), mos);
		}
	}

	private void saveDocumentStatus(DocumentStatus cspDocumentStatus, PASEventRefVo pasEventRef, MemberOfStaffShortVo mos) throws StaleObjectException {
		DomainFactory factory = getDomainFactory();
		
		CorrespondenceDetails domCspDet = CorrespondenceDetails.getCorrespondenceDetailsFromPasEvent(factory, pasEventRef.getID_PASEvent());
		CorrespondenceDetailsVo voCorrespondenceDetails = CorrespondenceDetailsVoAssembler.create(domCspDet);
		
		voCorrespondenceDetails.setCspStatusHistory(updateHistoryStatus(voCorrespondenceDetails,cspDocumentStatus, mos));
		voCorrespondenceDetails.setCurrentStatus(cspDocumentStatus);
		
		
		CorrespondenceDetails domDocDetails = null;
		
		domDocDetails = CorrespondenceDetailsVoAssembler.extractCorrespondenceDetails(factory,voCorrespondenceDetails);
		
		factory.save(domDocDetails);
		
		
		
		
		
	}
	
	private CorrespondenceStatusHistoryVoCollection updateHistoryStatus(CorrespondenceDetailsVo voDocumentDetails, DocumentStatus docStatus, MemberOfStaffShortVo mos)
	{
		CorrespondenceStatusHistoryVoCollection voColl = null;

		if (voDocumentDetails.getCspStatusHistoryIsNotNull())
			voColl = voDocumentDetails.getCspStatusHistory();
		else
			voColl = new CorrespondenceStatusHistoryVoCollection();

		CorrespondenceStatusHistoryVo vo = new CorrespondenceStatusHistoryVo();

		if (voDocumentDetails.getCurrentDocumentIsNotNull() && voDocumentDetails.getCurrentDocument().getTemplateIsNotNull())
			vo.setTemplateName(voDocumentDetails.getCurrentDocument().getTemplate().getNameIsNotNull() ? voDocumentDetails.getCurrentDocument().getTemplate().getName() : "");
		else
			vo.setTemplateName("");

		vo.setStatus(docStatus);
		vo.setMos(mos);
		if (voDocumentDetails.getCurrentDocument().getTemplateIsNotNull())
			vo.setTemplateName(voDocumentDetails.getCurrentDocument().getTemplate().getNameIsNotNull() ? voDocumentDetails.getCurrentDocument().getTemplate().getName() : "");
		voColl.add(vo);
		return voColl;
	}

	public void saveDischargeEpisodes(DischargedEpisodeVoCollection collDischargedEpisodeVo, MemberOfStaffShortVo mos) throws DomainInterfaceException, StaleObjectException {
		for(int i=0; i<collDischargedEpisodeVo.size(); i++){
			if (!collDischargedEpisodeVo.get(i).isValidated())
			{
				throw new DomainRuntimeException("Episode VO has not been validated!");
			}
		
			DomainFactory factory = getDomainFactory();		
			DischargedEpisode diDo = DischargedEpisodeVoAssembler.extractDischargedEpisode(factory, collDischargedEpisodeVo.get(i));
			
			factory.save(diDo);
			saveDocumentStatus(collDischargedEpisodeVo.get(i).getPasEvent().getCspDocumentStatus(), collDischargedEpisodeVo.get(i).getPasEvent(), mos);
		}		
	}

	public CorrespondencePatientListsVoCollection listOutpatients(OutPatientListSearchCriteriaVo filter, Boolean listByReqAndNotReqStatus) {
		CorrespondenceOutpatientList outpatientList = (CorrespondenceOutpatientList)getDomainImpl(CorrespondenceOutpatientListImpl.class);
		return outpatientList.listOutpatients(filter, listByReqAndNotReqStatus);
	}

	public void saveOutPatientEpisodes(OutPatientAttendanceVoCollection collOutPatientAttendanceVo, MemberOfStaffShortVo mos) throws DomainInterfaceException, StaleObjectException {
		for(int i=0; i<collOutPatientAttendanceVo.size(); i++){
			if (!collOutPatientAttendanceVo.get(i).isValidated())
			{
				throw new DomainRuntimeException("Episode VO has not been validated!");
			}
		
			DomainFactory factory = getDomainFactory();		
			OutpatientAttendance ouDo = OutPatientAttendanceVoAssembler.extractOutpatientAttendance(factory, collOutPatientAttendanceVo.get(i));
			
			factory.save(ouDo);
			saveDocumentStatus(collOutPatientAttendanceVo.get(i).getPasEvent().getCspDocumentStatus(), collOutPatientAttendanceVo.get(i).getPasEvent(), mos);
		}				
	}
}
