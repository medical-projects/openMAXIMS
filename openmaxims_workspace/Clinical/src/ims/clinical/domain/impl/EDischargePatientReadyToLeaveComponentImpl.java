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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3499.21395)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.EDischargeHINTConfig;
import ims.admin.domain.impl.EDischargeHINTConfigImpl;
import ims.admin.domain.impl.LocationServiceProviderSysImpl;
import ims.clinical.domain.EDischarge;
import ims.clinical.domain.EDischargeDiagnosisEtcComponent;
import ims.clinical.domain.EDischargeList;
import ims.clinical.domain.EDischargeMedicationComponent;
import ims.clinical.domain.EDischargePreViewComponent;
import ims.clinical.domain.base.impl.BaseEDischargePatientReadyToLeaveComponentImpl;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeMedicationDetailsVo;
import ims.clinical.vo.DischargeReadyToLeaveVo;
import ims.clinical.vo.DischargeReadyToLeaveVoCollection;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.NurseEnabledInstructionsVo;
import ims.clinical.vo.NurseEnabledInstructionsVoCollection;
import ims.clinical.vo.domain.DischargeReadyToLeaveVoAssembler;
import ims.clinical.vo.domain.DischargeReportDetailVoAssembler;
import ims.clinical.vo.domain.NurseEnabledInstructionsVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.domain.objects.Clinic;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ClinicLiteVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocShortVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientDiagnosisEDischargeListVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.domain.LocSiteShortVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeReportDetail;
import ims.edischarge.domain.objects.ReadyToLeave;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.vo.ValueObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargePatientReadyToLeaveComponentImpl extends BaseEDischargePatientReadyToLeaveComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.FieldHelpVo getHintByLookupID(ims.clinicaladmin.vo.lookups.EDischargeHINT voLookup)
	{
		EDischargeHINTConfig impl = (EDischargeHINTConfig)getDomainImpl(EDischargeHINTConfigImpl.class);
		return impl.getHintByLookupID(voLookup);
	}

	public ims.core.vo.LocationLiteVoCollection listActiveWardsForHospitalLite(ims.core.resource.place.vo.LocationRefVo hospital)
	{
		EDischargeList impl = (EDischargeList)getDomainImpl(EDischargeListImpl.class);
		return impl.listActiveWardsForHospitalLite(getHospital(hospital));
	}
	
	private LocationRefVo getHospital(ims.core.resource.place.vo.LocationRefVo voRef)
	{
		LocMostVo voLocation = LocMostVoAssembler.create((Location)getDomainFactory().getDomainObject(voRef));
		
		if(voLocation != null && voLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return (LocationRefVo) voLocation;

		while(voLocation != null && voLocation.getParentLocation() != null)
		{
			voLocation = voLocation.getParentLocation();
			if(voLocation instanceof LocMostVo && voLocation.getType().equals(LocationType.HOSP))
				return (LocationRefVo) voLocation;
		}

		return voRef;
	}
	

	public DischargeReadyToLeaveVo saveReadyToLeave(DischargeReadyToLeaveVo voReady) throws DomainInterfaceException, StaleObjectException 
	{
		if(voReady == null)
			throw new CodingRuntimeException("DischargeReadyToLeaveVo is null");
		
		if(!voReady.isValidated())
			throw new CodingRuntimeException("DischargeReadyToLeaveVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		ReadyToLeave doRTL = DischargeReadyToLeaveVoAssembler.extractReadyToLeave(factory, voReady);

		factory.save(doRTL);
		return DischargeReadyToLeaveVoAssembler.create(doRTL);
	}

	public DischargeReadyToLeaveVo getReadyToLeave(CareContextRefVo careContextRefvo) 
	{
		if(careContextRefvo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRefvo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from ReadyToLeave rtl where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " rtl.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContextRefvo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeReadyToLeaveVoCollection voColl = DischargeReadyToLeaveVoAssembler.createDischargeReadyToLeaveVoCollectionFromReadyToLeave(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public HcpLiteVo getHcp(HcpRefVo voRef) 
	{
		if(voRef == null || voRef.getID_Hcp() == null)
			throw new CodingRuntimeException("HcpRefVo is null or id not provided for getHcp");
		
		return HcpLiteVoAssembler.create((Hcp)getDomainFactory().getDomainObject(voRef));
	}

	public DischargeDetailsVo getDischargeDetails(CareContextRefVo careContextRefvo) 
	{
		EDischarge impl = (EDischarge)getDomainImpl(EDischargeImpl.class);
		return impl.getDischargeDetails(careContextRefvo);
	}

	public PatientDiagnosisEDischargeListVoCollection listComorbidity(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent)getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		return impl.listComorbidity(episodeOfCareRefVo);
	}

	public PatientDiagnosisEDischargeListVoCollection listComplications(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent)getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		return impl.listComplications(episodeOfCareRefVo);
	}

	public String[] getSystemReportAndTemplate(Integer imsId) 
	{
		EDischargePreViewComponent impl = (EDischargePreViewComponent)getDomainImpl(EDischargePreViewComponentImpl.class);
		return impl.getSystemReportAndTemplate(imsId);
	}

	public DischargeReportDetailVo getDischargeReportDetailsForCareContext(CareContextRefVo careContext) 
	{
		EDischargePreViewComponent impl = (EDischargePreViewComponent)getDomainImpl(EDischargePreViewComponentImpl.class);
		return impl.getDischargeReportDetailsForCareContext(careContext);
	}

	public DischargeMedicationDetailsVo getMedication(CareContextRefVo careContextRefvo) 
	{
		EDischargeMedicationComponent impl = (EDischargeMedicationComponent)getDomainImpl(EDischargeMedicationComponentImpl.class);
		return impl.getMedication(careContextRefvo);
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo dischargeDetail) throws StaleObjectException 
	{
		EDischargePreViewComponent impl = (EDischargePreViewComponent)getDomainImpl(EDischargePreViewComponentImpl.class);
		return impl.saveDischargeDetails(dischargeDetail);
	}

	public NurseEnabledInstructionsVo getNurseEnabledInstructions(CareContextRefVo careContextRef)
	{
		if(careContextRef == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRef != null)
		{
			DomainFactory factory = getDomainFactory();
			List list = factory.find("from NurseEnabledInstructions as n1_1	where (n1_1.careContext.id = :ID) " , new String[] {"ID"}, new Object[] {careContextRef.getID_CareContext()}); 
			if(list != null && list.size() > 0)
			{ 
				NurseEnabledInstructionsVoCollection  voColl = NurseEnabledInstructionsVoAssembler.createNurseEnabledInstructionsVoCollectionFromNurseEnabledInstructions(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public DischargeReportDetailVo saveDischargeReportDetails(DischargeReportDetailVo dischargeReportDetail) throws StaleObjectException 
	{
		if (!dischargeReportDetail.isValidated())
			throw new DomainRuntimeException("DischargeReportDetailVo not validated");
		
		DomainFactory factory = getDomainFactory();

		DischargeReportDetail dom = DischargeReportDetailVoAssembler.extractDischargeReportDetail(factory, dischargeReportDetail);
		factory.save(dom);
		return DischargeReportDetailVoAssembler.create(dom);
	}
}
