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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseSurgicalOPNotesGeneralDetailsCCImpl;
import ims.clinical.domain.objects.SurgicalOperationNotes;
import ims.clinical.vo.domain.SurgicalOperationNotesGeneralDetailsVoAssembler;

import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.DomainInterfaceException;

public class SurgucalOPNotesGeneralDetailsCCImpl extends BaseSurgicalOPNotesGeneralDetailsCCImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.SurgicalOperationNotesGeneralDetailsVo getSurgicalOpNotesGeneralDetails(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		String hqlQuery = "select s1_1 from SurgicalOperationNotes as s1_1 left join s1_1.careContext as c1_1 where	(c1_1.id = :idCareContext)";
		List record = getDomainFactory().find(hqlQuery, "idCareContext", careContextRef.getID_CareContext());
		if (record == null || record.size() == 0 )
				return null;
		return SurgicalOperationNotesGeneralDetailsVoAssembler.create((SurgicalOperationNotes) record.get(0));
	}

	public ims.clinical.vo.SurgicalOperationNotesGeneralDetailsVo saveSurgicalOPNotesGeneralDetail(ims.clinical.vo.SurgicalOperationNotesGeneralDetailsVo surgicalOpVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (surgicalOpVo == null)
			throw new DomainInterfaceException("Surgical OP Notes vo is null");
		if (!surgicalOpVo.isValidated())
			throw new DomainInterfaceException("Surgical Op Notes vo must be validated");
		//surgicalOpVo
		SurgicalOperationNotes domObj = SurgicalOperationNotesGeneralDetailsVoAssembler.extractSurgicalOperationNotes(getDomainFactory(),surgicalOpVo );
		getDomainFactory().save(domObj);
		return SurgicalOperationNotesGeneralDetailsVoAssembler.create(domObj);
	}

	public HcpLiteVoCollection listHCPS(HcpDisType type, String nameFilter) 
	{
		
			
		HcpAdmin hcpAdminIml = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		/*if (type == null)
		{
		return hcpAdminIml.listHcpLiteByName(nameFilter);	
		}
		else
		{*/
		return hcpAdminIml.listHcpLiteByNameAndDisciplineType(nameFilter, type);
		//}
		
	}
}
