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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.clinical.domain.base.impl.BaseEDischargeListImpl;
import ims.clinical.vo.DischargeDetailsVoCollection;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.DischargeReportDetailVoCollection;
import ims.clinical.vo.EDischargeSearchCriteriaVo;
import ims.clinical.vo.domain.DischargeDetailsVoAssembler;
import ims.clinical.vo.domain.DischargeReportDetailVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.Alerts;
import ims.core.domain.impl.AlertsImpl;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.vo.MedicRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextForEdischargeVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.domain.CareContextForEdischargeVoAssembler;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.ChannelType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.YesNo;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class EDischargeListImpl extends BaseEDischargeListImpl
{

	private static final long serialVersionUID = 1L;
		
	private LocationRefVo getHospital(ims.core.resource.place.vo.LocationRefVo voRef)
	{
		LocMostVo voLocation = LocMostVoAssembler.create((Location)getDomainFactory().getDomainObject(voRef));
		
		if(voLocation != null && voLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return (LocationRefVo) voLocation;

		while(voLocation != null && voLocation.getParentLocation() != null)
		{
			voLocation = voLocation.getParentLocation();
			if((voLocation instanceof LocMostVo) && (voLocation.getType().equals(LocationType.HOSP)))
				return (LocationRefVo) voLocation;
		}

		return voRef;
	}
	public LocationLiteVoCollection listActiveWardsForHospitalLite(LocationRefVo hospital) 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveWardsForHospitalLite(getHospital(hospital));
	}

	public CareContextForEdischargeVo getCareContext(CareContextRefVo voRef) 
	{
		if(voRef == null ||
				voRef.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContextRefVo is null or id not provided for getCareContext");	
		
		return CareContextForEdischargeVoAssembler.create((CareContext)getDomainFactory().getDomainObject(CareContext.class, voRef.getID_CareContext()));
	}
	
	public CareContextShortVo getCareContextShort(CareContextRefVo voRef) 
	{
		if(voRef == null ||
				voRef.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContextRefVo is null or id not provided for getCareContext");	
		
		return CareContextShortVoAssembler.create((CareContext)getDomainFactory().getDomainObject(CareContext.class, voRef.getID_CareContext()));
	}
	
	public PatientShort getPatientByCareContext(CareContextRefVo careContext)	
	{
		if(careContext == null ||
				careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContextRefVo is null or id not provided for getPatientByCareContext");	
		
		DomainFactory factory = getDomainFactory();
		List<?> domainObjectList = factory.find("select p from CareContext as cc left join cc.episodeOfCare as eoc left join eoc.careSpell as cs left join cs.patient as p where (cc.id = :idCareContext)", new String[]{"idCareContext"}, new Object[]{careContext.getID_CareContext()});
		PatientShortCollection patient = PatientShortAssembler.createPatientShortCollectionFromPatient(domainObjectList);
		return patient != null && patient.size() > 0 ? (patient.get(0) != null ? patient.get(0) : null) : null;
	}
	
	public DischargeReportDetailVo getDischargeReportDetailsForCareContext(CareContextRefVo careContext)	
	{
		if(careContext == null ||
				careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContext is null or id not provided for getDischargeDetailsForCareContext");	
		
		DomainFactory factory = getDomainFactory();
		List<?> domainObjectList = factory.find("select drd from DischargeReportDetail as drd left join drd.careContext as cc where cc.id = :idCareContext", new String[]{"idCareContext"}, new Object[]{careContext.getID_CareContext()});
		DischargeReportDetailVoCollection reportDetail = DischargeReportDetailVoAssembler.createDischargeReportDetailVoCollectionFromDischargeReportDetail(domainObjectList);		
		
		return reportDetail != null && reportDetail.size() > 0 ? (reportDetail.get(0) != null ? reportDetail.get(0) : null) : null;
	}
	
	public MedicVo getMedicVo(MedicRefVo medic) 
	{
		if(medic == null || medic.getID_Hcp() == null)
			throw new CodingRuntimeException("MedicRefVo is null or id not provided for getMedicVo");
		
		return MedicVoAssembler.create((Medic) getDomainFactory().getDomainObject(medic));
	}
	
	
	public DischargeDetailsVoCollection searchByCriteria(EDischargeSearchCriteriaVo searchCriteria) 
	{
		StringBuilder queryJoin = new StringBuilder("select distinct dd from DischargeDetails as dd "); 
		StringBuilder conditions =  new StringBuilder();
		ArrayList<String > paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		String andStr = "";
		if (searchCriteria.getInitiatingHCPIsNotNull())
		{
			conditions.append("dd.initiatingHCP.id = :InitiatingHCP_id");
			paramNames.add("InitiatingHCP_id");
			paramValues.add(searchCriteria.getInitiatingHCP().getID_Hcp());
			andStr = " and ";
		}
		if (searchCriteria.getWardIsNotNull())
		{
			
			conditions.append(andStr);
			conditions.append("dd.dischargingWard.id = :Ward_id");
			paramNames.add("Ward_id");
			paramValues.add(searchCriteria.getWard().getID_Location());
			andStr = " and ";
			
		}
		if (searchCriteria.getStatusIsNotNull())
		{
			conditions.append(andStr);
			conditions.append("dd.dischargeLetterStatus.id = :Status_id ");
			paramNames.add("Status_id");
			paramValues.add(searchCriteria.getStatus().getID());
			andStr = " and ";
		}
		
		if (searchCriteria.getFromDateIsNotNull()&& searchCriteria.getToDateIsNotNull())
		{
			conditions.append(andStr);
			conditions.append("(dd.systemInformation.creationDateTime >= :fromDate and dd.systemInformation.creationDateTime < :toDate)");
			paramNames.add("fromDate");
			paramNames.add("toDate");
			paramValues.add(searchCriteria.getFromDate().getDate());
			paramValues.add(searchCriteria.getToDate().addDay(1).getDate());	
			andStr = " and ";
		}
		boolean eocAdded = false;
		if (searchCriteria.getResponsibleHCPIsNotNull())
		{
			eocAdded = true;
			queryJoin.append("left join dd.careContext as cc left join cc.episodeOfCare as eoc " );
			conditions.append(andStr);
			conditions.append("eoc.responsibleHCP.id = :ResponsibleHCP_id");
			paramNames.add("ResponsibleHCP_id");
			paramValues.add(searchCriteria.getResponsibleHCP().getID_Hcp());
			andStr = " and ";
			
		}
		if (searchCriteria.getSpecialtyIsNotNull())
		{
			if (!eocAdded)
				queryJoin.append("left join dd.careContext as cc left join cc.episodeOfCare as eoc " );
			conditions.append(andStr);
			conditions.append("eoc.specialty.id  = :Speciality_id");
			paramNames.add("Speciality_id");
			paramValues.add(searchCriteria.getSpecialty().getID());
			andStr = " and ";
		}
		boolean drdAdded = false;
		if (searchCriteria.getCompletingHCPIsNotNull())
		{
			drdAdded = true;
			queryJoin.append(" , DischargeReportDetail as drd ");
			conditions.append(andStr);
			conditions.append("drd.careContext.id = dd.careContext.id and drd.completingHCP.id = :CompletingHCP_id");
			paramNames.add("CompletingHCP_id");
			paramValues.add(searchCriteria.getCompletingHCP().getID_Hcp());
			andStr = " and ";
		}
		if (searchCriteria.getClinicaDetailsCompleteIsNotNull())
		{
			if (!drdAdded)
			{
				drdAdded = true;
				queryJoin.append(" , DischargeReportDetail as drd ");
			}
			conditions.append(andStr);
			
			conditions.append(YesNo.YES.equals(searchCriteria.getClinicaDetailsComplete())?"drd.careContext.id = dd.careContext.id and drd.isClinicalDetailsComplete  = 1":
				" dd.careContext.id not in (select d1_1.careContext.id  from DischargeReportDetail as d1_1  where   (d1_1.isClinicalDetailsComplete = 1)) ");
			andStr = " and ";
		}
		if (searchCriteria.getNonCornishIsNotNull() && searchCriteria.getNonCornish())
		{
			if (!drdAdded)
			{
				drdAdded = true;
				queryJoin.append(" , DischargeReportDetail as drd ");
				

			}
			queryJoin.append(" left join drd.gpRecipients as gr left join gr.commChannels as comm left join comm.channelType as ct");
			conditions.append(andStr);
			conditions.append("drd.careContext.id = dd.careContext.id and gr.id is not null " +
			"and (comm is null or comm not in (select ccs from gr as c1 left join c1.commChannels as  ccs where ccs.channelType = :eMail))");

			paramNames.add("eMail");
			paramValues.add(getDomLookup(ChannelType.EMAIL));
			andStr = " and ";			
		}
		boolean mdAdded = false;
		if (searchCriteria.getTTAIsNotNull())
		{	
			mdAdded = true;
			queryJoin.append(", MedicationDetails as md ");
			conditions.append(andStr);
			conditions.append("md.careContext.id = dd.careContext.id and md.tTARequired.id = :TTARequired_id");
			paramNames.add("TTARequired_id");
			paramValues.add(searchCriteria.getTTA().getID());
			andStr = " and ";	
		}
		if (searchCriteria.getTTAFeedBackIsNotNull() && searchCriteria.getTTAFeedBack())
		{
			if (!mdAdded)
			{
				queryJoin.append(", MedicationDetails as md ");
				conditions.append(andStr);
				conditions.append("md.careContext.id = dd.careContext.id");
				andStr = " and ";	
			}
			queryJoin.append("left join md.tTAs as ttas");
			conditions.append(andStr);
			conditions.append("ttas is null");
		}
		String hqlString = queryJoin+" where ( "+conditions+" ) order by dd.systemInformation.creationDateTime asc";
		List<?> domObjs = getDomainFactory().find(hqlString,paramNames,paramValues);
		return DischargeDetailsVoAssembler.createDischargeDetailsVoCollectionFromDischargeDetails(domObjs);	
			
	}

	public LocationLiteVo getWard(LocationRefVo voWardRef) 
	{
		if (voWardRef != null && voWardRef.getID_LocationIsNotNull())
		{	
			DomainFactory factory = getDomainFactory();
			Location domLoc = (Location) factory.getDomainObject(Location.class, voWardRef.getID_Location());
			return LocationLiteVoAssembler.create(domLoc);
		}
		return null;
	}
	
	//WDEV-14654
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeOfCareRefVo)
	{
		Alerts impl = (Alerts) getDomainImpl(AlertsImpl.class);
		return impl.getPIDDiagnosisInfo(careContextRefVo, episodeOfCareRefVo);
	}
}
