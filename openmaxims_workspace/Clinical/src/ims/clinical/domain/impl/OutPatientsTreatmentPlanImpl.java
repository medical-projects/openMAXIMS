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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2309.16238)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseOutPatientsTreatmentPlanImpl;
import ims.clinical.domain.objects.OutpatientNotesOutcome;
import ims.clinical.vo.OutpatientNotesOutcomeVo;
import ims.clinical.vo.domain.OutpatientNotesOutcomeVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.domain.HcpAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class OutPatientsTreatmentPlanImpl extends BaseOutPatientsTreatmentPlanImpl
{

	private static final long serialVersionUID = 1L;

	public HcpCollection listHcp(HcpFilter hcpFilter)
	{
		if(hcpFilter == null)
			throw new CodingRuntimeException("Cannot list Hcps for null HcpFilter");
		
		HcpAdmin hcpAdminIml = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdminIml.listHCPs(hcpFilter);
	}

	public OutpatientNotesOutcomeVo getLastOutpatientNotesOutcome(CareContextRefVo careContext)
	{
		if(careContext == null)
			throw new CodingRuntimeException("null careContext passed to getLastOutpatientNotesOutcome() !");
		
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("from OutpatientNotesOutcome as o1_1 where	o1_1.careContext.id = :CONTEXTID order by o1_1.id asc ",
				new String[] {"CONTEXTID"}, 
				new Object[] {careContext.getID_CareContext()});
		
		return list.size() == 0 ? null : OutpatientNotesOutcomeVoAssembler.create((OutpatientNotesOutcome)list.get(0));
	}

	public OutpatientNotesOutcomeVo saveOutpatientNotesOutcome(OutpatientNotesOutcomeVo record) throws StaleObjectException, UniqueKeyViolationException
	{
		if(record == null)
			throw new CodingRuntimeException("null record passed to saveClinicalCorrespondence() !");

		if(!record.isValidated())
			throw new CodingRuntimeException("OutpatientNotesOutcome not validated !");

		DomainFactory factory = getDomainFactory();
		OutpatientNotesOutcome boOutpatientNotesOutcome = OutpatientNotesOutcomeVoAssembler.extractOutpatientNotesOutcome(factory, record);		
		factory.save(boOutpatientNotesOutcome);
		
		return OutpatientNotesOutcomeVoAssembler.create(boOutpatientNotesOutcome);
	}

	public Hcp getHcpById(HcpRefVo refId)
	{
		if(refId == null)
			throw new CodingRuntimeException("null refId passed to getHcpById() !");

		DomainFactory factory = getDomainFactory();
		
		ims.core.resource.people.domain.objects.Hcp boHcp = (ims.core.resource.people.domain.objects.Hcp)factory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, refId.getID_Hcp());
		
		return HcpAssembler.create(boHcp);
	}
	
	public HcpLiteVo getHcpLiteById(HcpRefVo refId)
	{
		if(refId == null)
			throw new CodingRuntimeException("null refId passed to getHcpById() !");

		DomainFactory factory = getDomainFactory();
		
		ims.core.resource.people.domain.objects.Hcp boHcp = (ims.core.resource.people.domain.objects.Hcp)factory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, refId.getID_Hcp());
		
		return HcpLiteVoAssembler.create(boHcp);
	}
	
}
