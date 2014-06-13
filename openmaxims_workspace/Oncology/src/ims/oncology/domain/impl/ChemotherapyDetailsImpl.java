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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.53 build 2648.26779)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.ccosched.vo.PatTreatPlanActionLiteVo;
import ims.ccosched.vo.PatTreatmentPlanLiteVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.CareSpellRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocSiteLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.domain.ClinicVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.LocSiteLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;
import ims.domain.lookups.LookupInstance;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.vo.ChemotherapyDetailsListVoCollection;
import ims.ocrr.vo.ChemotherapyDetailsShortVoCollection;
import ims.ocrr.vo.ChemotherapyDetailsVo;
import ims.ocrr.vo.domain.ChemotherapyDetailsListVoAssembler;
import ims.ocrr.vo.domain.ChemotherapyDetailsShortVoAssembler;
import ims.ocrr.vo.domain.ChemotherapyDetailsVoAssembler;
import ims.oncology.configuration.domain.objects.ChemoRegimensConfig;
import ims.oncology.domain.PatientsChemoTreatmentPlanActionsDialog;
import ims.oncology.domain.base.impl.BaseChemotherapyDetailsImpl;
import ims.oncology.domain.objects.ChemotherapyDetails;
import ims.oncology.vo.ChemoRegimensConfigVo;
import ims.oncology.vo.ChemotherapyDetailsRefVo;
import ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection;
import ims.oncology.vo.domain.ChemoRegimensConfigVoAssembler;
import ims.oncology.vo.domain.ChemotherapyDetailsLiteDialogVoAssembler;
import ims.oncology.vo.lookups.TreatmentHospital;
import ims.oncology.vo.lookups.TreatmentHospitalCollection;
import ims.vo.LookupInstVo;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.List;
public class ChemotherapyDetailsImpl extends BaseChemotherapyDetailsImpl
{
	
	private static final long	serialVersionUID	= 1L;

	public ChemotherapyDetailsShortVoCollection listChemotherapies(EpisodeOfCareRefVo episodeOfCare, CareContextRefVo careContext)
	{
		if (episodeOfCare == null || !episodeOfCare.getID_EpisodeOfCareIsNotNull())
			throw new DomainRuntimeException("Null or invalid episode of care passed");
		
		StringBuilder query = new StringBuilder();
		query.append(" from ChemotherapyDetails as ctd where ctd.episodeOfCare.id = :EP_ID order by ctd.startDate desc");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("EP_ID");
		paramValues.add(episodeOfCare.getID_EpisodeOfCare());
		
//		if (careContext == null || !careContext.getID_CareContextIsNotNull())
//		{
//			query.append(" and ctd.careContext.id = :CC_ID");
//			
//			paramNames.add("CC_ID");
//			paramValues.add(careContext.getID_CareContext());
//		}

		return ChemotherapyDetailsShortVoAssembler.createChemotherapyDetailsShortVoCollectionFromChemotherapyDetails(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	/**
	 * list Chemotherapies for Care Context
	 */
	public ChemotherapyDetailsListVoCollection listChemotherapies(CareSpellRefVo voCareSpellRef) 
	{
		if (voCareSpellRef == null)
			throw new RuntimeException("Cannot list Chemotherapy Details for null Care Spell");

		StringBuilder query = new StringBuilder();
		String careSpellId = "CARE_SPELL_ID";
		query.append("from ChemotherapyDetails as c1_1 where c1_1.careContext.episodeOfCare.careSpell.id = :" + careSpellId);
		List list = getDomainFactory().find(query.toString(), careSpellId, voCareSpellRef.getID_CareSpell());

		return ChemotherapyDetailsListVoAssembler.createChemotherapyDetailsListVoCollectionFromChemotherapyDetails(list);
	}

	public ChemotherapyDetailsVo getChemotherapyDetailsVo(ChemotherapyDetailsRefVo voChemotherapyDetailsRef)
	{
		if(voChemotherapyDetailsRef == null || !voChemotherapyDetailsRef.getID_ChemotherapyDetailsIsNotNull())
			return null;
		
		return ChemotherapyDetailsVoAssembler.create((ChemotherapyDetails)getDomainFactory().getDomainObject(ChemotherapyDetails.class, voChemotherapyDetailsRef.getID_ChemotherapyDetails()));
	}

	public LocSiteLiteVoCollection listLocSite(String locationName)
	{
		OrganisationAndLocation organisationAndLocation = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return organisationAndLocation.listLocSite(locationName);
	}

	public MemberOfStaffLiteVoCollection listActiveMosByName(String name)
	{
		return ((MosAdmin)getDomainImpl(MosAdminImpl.class)).listActiveMosByName(name);
	}

	public ChemotherapyDetailsVo saveChemotherapyDetailsVo(ChemotherapyDetailsVo voChemotherapyDetails) throws StaleObjectException
	{
		if(voChemotherapyDetails == null)
			throw new RuntimeException("Cannot save null ChemotherapyDetailsVo");
		
		if(voChemotherapyDetails.isValidated() == false)
			throw new CodingRuntimeException("ChemotherapyDetailsVo is not validated");
			
		DomainFactory factory = getDomainFactory();
		ChemotherapyDetails doChemotherapyDetails = ChemotherapyDetailsVoAssembler.extractChemotherapyDetails(factory, voChemotherapyDetails);
		factory.save(doChemotherapyDetails);
		
		return ChemotherapyDetailsVoAssembler.create(doChemotherapyDetails);
	}
	
	public LocSiteLiteVoCollection listHospitals(String locationName)
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(LocSite.class,factory);
		imsc.equal("type", getDomLookup(LocationType.HOSP));
		imsc.like("name", locationName + "%" );
		imsc.equal("isActive", true);
		List locations = imsc.find();
		if (locations!=null)
			return LocSiteLiteVoAssembler.createLocSiteLiteVoCollectionFromLocSite(locations);
		else
			return null;
	}

	public HcpLiteVo getHcp(IMos iMos)
	{
		if (iMos == null || iMos.getIMosId() == null)
			return null;
		
		String query = "from Hcp as hcp where hcp.isRIE is null and hcp.mos.id = " + iMos.getIMosId().toString();
		
		return HcpLiteVoAssembler.create((Hcp) getDomainFactory().findFirst(query));
	}

	public ChemoRegimensConfigVo getChemoRegimeConfig(LookupInstVo lkupRegime) 
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc = new IMSCriteria(ChemoRegimensConfig.class,factory);
		imsc.equal("regimen", getDomLookup(lkupRegime));
		imsc.equal("status", getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		List regime = imsc.find();
		if (regime != null && regime.size() > 0)
			return ChemoRegimensConfigVoAssembler.createChemoRegimensConfigVoCollectionFromChemoRegimensConfig(regime).get(0);
		else
			return null;
	}

	
	//wdev-12819
	public TreatmentHospitalCollection getHospitals(String text,TreatmentHospital treatmentHospital) 
	{
		StringBuilder query = new StringBuilder();
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("select lkp from LookupInstance as lkp where lkp.type.id = :TYPE and lkp.active = 1 ");
		
		paramNames.add("TYPE"); paramValues.add(TreatmentHospital.TYPE_ID);
				
		if (text != null)
		{
			query.append(" and UPPER(lkp.text) like :NAME");
			
			paramNames.add("NAME"); paramValues.add(text.toUpperCase() + "%");
		}
		
		if (treatmentHospital != null)
		{
			query.append(" or lkp.id = :USED");
			
			paramNames.add("USED"); paramValues.add(treatmentHospital.getID());
		}
		
		List searchResults = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		if (searchResults == null || searchResults.size() == 0)
			return null;
		
		TreatmentHospitalCollection results = new TreatmentHospitalCollection();
		
		for (int i = 0; i < searchResults.size(); i++)
		{
			if (searchResults.get(i) instanceof LookupInstance)
			{
				LookupInstVo treatmentHospitalInstance = getLookupService().getLookupInstance(TreatmentHospital.class, TreatmentHospital.TYPE_ID, ((LookupInstance)searchResults.get(i)).getId());
				results.add(treatmentHospitalInstance);
			}
		}
		
		return results;
	}

	public String getCCOClinicName(String strClinicCode) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql2 = new StringBuffer();
		hql2.append("select clin from Clinic clin left join clin.codeMappings as tax left join tax.taxonomyName as taxTyp where taxTyp = :taxonomyType and tax.taxonomyCode = '" + strClinicCode + "'");
		ClinicVoCollection voClinics = ClinicVoAssembler.createClinicVoCollectionFromClinic(factory.find(hql2.toString(),new String[]{"taxonomyType"},new Object[]{getDomLookup(TaxonomyType.PAS)}));
		if (voClinics != null && voClinics.size() > 0)
			return voClinics.get(0).getClinicName();
		else
			return null;
	}

	public PatTreatmentPlanRadiotherapyDialogVoCollection listActivePatTreatMentPlans(PatientRefVo patient, EpisodeOfCareRefVo episode) 
	{
		PatientsChemoTreatmentPlanActionsDialog impl = (PatientsChemoTreatmentPlanActionsDialog) getDomainImpl(PatientsChemoTreatmentPlanActionsDialogImpl.class);
		return impl.listActivePatTreatMentPlans(patient, episode);
	}

	public Boolean checkIfChosenPlanLinked(PatTreatPlanActionLiteVo patAction)
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		hql = "select actions.id from ChemotherapyDetails as cd left join cd.associatedTreatmentPlanAction as actions where actions.id = :actID and cd.associatedTreatmentPlanAction is not null)"; 
		markers.add("actID");
		values.add(patAction.getID_PatAction());

		List ops = factory.find(hql, markers, values);
		if (ops != null && ops.size() > 0)
			return true;
		else
			return false;
	}

}
