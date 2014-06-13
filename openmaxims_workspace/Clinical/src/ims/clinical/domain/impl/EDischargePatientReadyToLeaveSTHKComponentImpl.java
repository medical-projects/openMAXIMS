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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3945.19817)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.EDischargeHINTConfig;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.EDischargeHINTConfigImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.clinical.domain.EDischargeDiagnosisEtcComponent;
import ims.clinical.domain.EDischargePreViewSTHKComponent;
import ims.clinical.domain.EDischargeSTHK;
import ims.clinical.domain.base.impl.BaseEDischargePatientReadyToLeaveSTHKComponentImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeMedicationDetailsVo;
import ims.clinical.vo.DischargeMedicationDetailsVoCollection;
import ims.clinical.vo.DischargeReadyToLeaveVo;
import ims.clinical.vo.DischargeReadyToLeaveVoCollection;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.EDischargeSTHKSummaryVo;
import ims.clinical.vo.EDischargeSTHKSummaryVoCollection;
import ims.clinical.vo.NurseEnabledInstructionsVo;
import ims.clinical.vo.NurseEnabledInstructionsVoCollection;
import ims.clinical.vo.domain.DischargeMedicationDetailsVoAssembler;
import ims.clinical.vo.domain.DischargeReadyToLeaveVoAssembler;
import ims.clinical.vo.domain.DischargeReportDetailVoAssembler;
import ims.clinical.vo.domain.EDischargeSTHKSummaryVoAssembler;
import ims.clinical.vo.domain.NurseEnabledInstructionsVoAssembler;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.clinical.vo.lookups.DischargeSupplementaryLetterStatus;
import ims.clinical.vo.lookups.EDischargeSummarySectionStatus;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Gp;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.AdmissionDetailVoCollection;
import ims.core.vo.CareContextVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.DischargedEpisodeVoCollection;
import ims.core.vo.GP;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientDiagnosisEDischargeListVoCollection;
import ims.core.vo.domain.AdmissionDetailVoAssembler;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.GPAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.lookups.ChannelType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeReportDetail;
import ims.edischarge.domain.objects.ReadyToLeave;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargePatientReadyToLeaveSTHKComponentImpl extends BaseEDischargePatientReadyToLeaveSTHKComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.FieldHelpVo getHintByLookupID(ims.clinicaladmin.vo.lookups.EDischargeHINT voLookup)
	{
		EDischargeHINTConfig impl = (EDischargeHINTConfig)getDomainImpl(EDischargeHINTConfigImpl.class);
		return impl.getHintByLookupID(voLookup);
	}

	public ims.core.vo.LocationLiteVoCollection listActiveWardsForHospitalLite(ims.core.resource.place.vo.LocationRefVo hospital)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveWardsForHospitalLite(hospital);
	}

	public DischargeReadyToLeaveVo saveReadyToLeave(DischargeReadyToLeaveVo voReady, SummaryRefVo voSummary) throws DomainInterfaceException, StaleObjectException 
	{
		if(voReady == null)
			throw new CodingRuntimeException("DischargeReadyToLeaveVo is null");
		
		if(!voReady.isValidated())
			throw new CodingRuntimeException("DischargeReadyToLeaveVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		
		//There is a situation where is possible that the scheduled jobs have run while you
		//are editing the ready to leave record. This should be dealt with by throwing a StaleObjectException
		String hql = "select count(summa.id) from Summary as summa where (summa.id=:sumId and (summa.dischargeLetterStatus.id =:dischLettId  or summa.dischargeSupplementaryLetterStatus.id = :dischSuppLettId))";
		long isCompleted = factory.countWithHQL(hql, new String[]{"sumId","dischLettId","dischSuppLettId"}, new Object[]{voSummary.getID_Summary(),DischargeLetterStatus.GENERATED.getId(),DischargeSupplementaryLetterStatus.GENERATED.getID()});
		if (isCompleted > 0)
		{
			throw new StaleObjectException(null);
		}
		
		ReadyToLeave doRTL = DischargeReadyToLeaveVoAssembler.extractReadyToLeave(factory, voReady);
		factory.save(doRTL);
		
		//updating summary WDEV-11348
		IEDischargeHelper impl = (IEDischargeHelper) getDomainImpl(EDischargeHelper.class); 
		impl.updateSummaryIfRequired(voReady, voSummary, factory);

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
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
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
		EDischargePreViewSTHKComponent impl = (EDischargePreViewSTHKComponent)getDomainImpl(EDischargePreViewSTHKComponentImpl.class);
		return impl.getSystemReportAndTemplate(imsId);
	}

	public DischargeMedicationDetailsVo getMedication(CareContextRefVo careContextRefvo) 
	{
//TODO Put following two lines back in when the MEDS Componetn for STHK is implemented.
	//	EDischargeMedicationComponent impl = (EDischargeMedicationComponent)getDomainImpl(EDischargeMedicationComponentImpl.class);
	//	return impl.getMedication(careContextRefvo);

		if(careContextRefvo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRefvo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from MedicationDetails md where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " md.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContextRefvo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeMedicationDetailsVoCollection voColl = DischargeMedicationDetailsVoAssembler.createDischargeMedicationDetailsVoCollectionFromMedicationDetails(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo dischargeDetail) throws StaleObjectException 
	{
		EDischargeSTHK edischargeImpl = (EDischargeSTHK)getDomainImpl(EDischargeSTHKImpl.class);
		try {
			edischargeImpl.saveDischargeDetails(dischargeDetail);
		} catch (DomainInterfaceException e) {
				throw new CodingRuntimeException(e);
		}
		return null;
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

	public DateTime getAdmissionDateTimeFromAdmissionDetail(CareContextRefVo ccRefVo, PatientRefVo voPatRefVo)
	{
		DomainFactory factory = getDomainFactory();
		CareContextVo voCC = CareContextVoAssembler.create((CareContext)factory.getDomainObject(CareContext.class, ccRefVo.getID_CareContext()));
		
		if (voCC.getPasEvent() == null)
		{
			return null;
		}

		String hql = "from AdmissionDetail ad " + 
		" where ad.pasEvent.patient.id = :patId " + 
		" and ad.pasEvent.id = :eventId ";

		ArrayList<String> labels = new ArrayList<String>();
		labels.add("patId");
		labels.add("eventId");
		
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(voPatRefVo.getID_Patient());
		values.add(voCC.getPasEvent().getID_PASEvent());

		List<?> l = factory.find(hql, labels, values);		
		if (l != null && l.size() > 0)
		{
			if (l.size() > 1)
				throw new DomainRuntimeException("Duplicate data found for Patient and PasEvent");
		
			AdmissionDetailVoCollection  voColl = AdmissionDetailVoAssembler.createAdmissionDetailVoCollectionFromAdmissionDetail(l);
			return voColl.get(0).getAdmissionDateTime();
		}
		return null;
	}

	public DischargedEpisodeVo getDischargedEpisodeDetails(CareContextRefVo ccRefVo, PatientRefVo voPatRefVo)
	{
		DomainFactory factory = getDomainFactory();
		CareContextVo voCC = CareContextVoAssembler.create((CareContext)factory.getDomainObject(CareContext.class, ccRefVo.getID_CareContext()));
		
		if (voCC.getPasEvent() == null)
		{
			return null;
		}
		
		String hql = "from DischargedEpisode de " + 
		" where de.pasEvent.patient.id = :patId " + 
		" and de.pasEvent.id = :eventId ";

		ArrayList<String> labels = new ArrayList<String>();
		labels.add("patId");
		labels.add("eventId");
		
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(voPatRefVo.getID_Patient());
		values.add(voCC.getPasEvent().getID_PASEvent());

		List<?> l = factory.find(hql, labels, values);		
		if (l != null && l.size() > 0)
		{
			if (l.size() > 1)
				throw new DomainRuntimeException("Duplicate data found for Patient and PasEvent");
		
			DischargedEpisodeVoCollection  voColl = DischargedEpisodeVoAssembler.createDischargedEpisodeVoCollectionFromDischargedEpisode(l);
			return voColl.get(0);
		}
		return null;
	}

	public GP getPatientsGP(PatientRefVo patRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		List lst = factory.find("select gp from Patient p where p.id = :patID", new String[]{"patID"}, new Object[]{patRefVo.getID_Patient()});
		if (lst != null && lst.size() > 0)
			return GPAssembler.create((Gp) lst.get(0));
		
		return null;
	}

	public EDischargeSTHKSummaryVo getCurrentSummary(CareContextRefVo ccRefVo) 
	{
		if(ccRefVo == null)
			throw new CodingRuntimeException("ccRefVo Filter not provided for list call. ");

		if(ccRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from Summary summ where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " summ.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(ccRefVo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				EDischargeSTHKSummaryVoCollection voColl = EDischargeSTHKSummaryVoAssembler.createEDischargeSTHKSummaryVoCollectionFromSummary(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}
	
	//WDEV-11822
	public String getDisplayStringAfterSave(SummaryRefVo summaryId)
	{
		//Get number of incomplete sections
		String hql = "select count (detail.id) from Summary as summa left join summa.summaryDetails as detail where " +
				"(summa.id = :summaryId and detail.progressStatus.id <> :progressId and summa.isRIE is null and detail.isRIE is null)";
		DomainFactory df = getDomainFactory();
		long noOfNotCompleted = df.countWithHQL(hql, new String[] {"summaryId","progressId"}, new Object[]{summaryId.getID_Summary(),EDischargeSummarySectionStatus.COMPLETED.getID()});
		if (noOfNotCompleted > 0)
			return null;
		
		//Get GP's email
		hql = "select comm.commValue from Summary as summary left join summary.careContext as cc left join cc.episodeOfCare as eoc " +
				"left join eoc.careSpell as cs left join cs.patient as pat left join pat.gp as gp " +
				"left join gp.commChannels as comm left join comm.channelType as chanType where (summary.id = :summId and chanType.id = :emailId)"; 
		List<?> find = df.find(hql,new String[]{"summId","emailId"},new Object[]{summaryId.getID_Summary(),ChannelType.EMAIL.getID()});
		if (find!=null && find.size() > 0)
		{
			if (find.get(0) instanceof String)
			{
				String email = (String) find.get(0);
				if (email.trim().length()>0)
					return "Discharge Summary Sent to GP";
			}
		}
		return "Discharge Summary Sent to Print";
	}
}
