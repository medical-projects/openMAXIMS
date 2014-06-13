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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.clinical.domain.base.impl.BaseExtendedCarePlanClinicalNotesImpl;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.lookups.LookupMapping;
import ims.framework.exceptions.CodingRuntimeException;
import ims.nursing.domain.objects.NursingClinicalNotes;
import ims.nursing.vo.domain.CarePlanTitleAssembler;
import ims.nursing.vo.domain.NursingClinicalNotesVoAssembler;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ExtendedCarePlanClinicalNotesImpl extends BaseExtendedCarePlanClinicalNotesImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Gets the Clinical Notes Details for the given Clinical Note ID
	*/
	public ims.nursing.vo.NursingClinicalNotesVo getClinicalNotes(ims.core.vo.ClinicalNotesVo clinicalNoteVo)
	{
		//WDEV-14428
		if (clinicalNoteVo == null || clinicalNoteVo.getID_ClinicalNotes() == null)
		{
			throw new CodingRuntimeException("Cannot get ClinicalNotesVo on null Id ");
		}
		
		DomainFactory factory = getDomainFactory();
		NursingClinicalNotes notes = (NursingClinicalNotes)factory.getDomainObject(NursingClinicalNotes.class, clinicalNoteVo.getID_ClinicalNotes());
		
		return NursingClinicalNotesVoAssembler.create(notes);
	}

	/**
	* Saves Clinical Note Details
	*/
	public ims.nursing.vo.NursingClinicalNotesVo saveClinicalNotes(ims.nursing.vo.NursingClinicalNotesVo notesVo) throws ims.domain.exceptions.StaleObjectException
	{
		if (!notesVo.isValidated())
			throw new DomainRuntimeException("This Clinical Note has not been validated");
			
		DomainFactory factory = getDomainFactory();
				
		NursingClinicalNotes domNotes = NursingClinicalNotesVoAssembler.extractNursingClinicalNotes(factory, notesVo);				
					
		// Save is needed as we then need to save this off with the careplans too being a bidirectional relationship
		factory.save(domNotes);
		 
	 	return NursingClinicalNotesVoAssembler.create(domNotes);
	}

	/**
	* Lists careplans for an episode 
	*/
	public ims.nursing.vo.CarePlanTitleCollection listCarePlans(ims.core.vo.CareContextShortVo careContextShortVo)
	{
		DomainFactory factory = getDomainFactory();	
		StringBuffer hql = new StringBuffer(" ");
		String query = "from CarePlan careplan ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";

		if (careContextShortVo != null)
		{
			hql.append(andStr + " careplan.careContext.id = :rcc");
			markers.add("rcc");
			values.add(careContextShortVo.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		List<?> cpTitle = factory.find(query, markers, values);		  					
		
		return(CarePlanTitleAssembler.createCarePlanTitleCollectionFromCarePlan(cpTitle).sort()); //this is the problem
	}

	/**
	* Return mappings for a Lookup Instance
	*/
	public ims.vo.LookupInstVo getMappings(ims.vo.LookupInstVo instance)
	{
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.LookupInstance doInst = factory.getLookupInstance(instance.getId());
		Set mappings = doInst.getMappings();
		LookupMappingVoCollection mapColl = new LookupMappingVoCollection();
		Iterator iter = mappings.iterator();
		LookupMapping doMapping;
		while (iter.hasNext())
		{
			doMapping = (LookupMapping) iter.next();
			mapColl.add(new LookupMappingVo(doMapping.getExtSystem(), doMapping.getExtCode()));
		}
		mapColl.sort();
		instance.setMappings(mapColl);
		return instance;
	}

	public HcpLiteVo getHCPLite(MemberOfStaffShortVo mos)
	{
		if (mos == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		MemberOfStaffVo mosVo = mosAdmin.getMemberOfStaff(mos);
		
		Hcp doHcp = (Hcp) factory.getDomainObject(Hcp.class, mosVo.getHcp().getID_Hcp());
		return HcpLiteVoAssembler.create(doHcp);		
	}

	public MemberOfStaffVo getMemberOfStaff(MemberOfStaffShortVo mos)
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdmin.getMemberOfStaff(mos);
	}

}
