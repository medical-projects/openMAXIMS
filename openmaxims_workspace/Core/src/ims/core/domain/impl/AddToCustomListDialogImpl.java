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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3832.22959)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.clinical.domain.objects.PatientCustomList;
import ims.core.clinical.vo.PatientCustomListRefVo;
import ims.core.configuration.vo.CustomListRefVo;
import ims.core.domain.CustomPatientList;
import ims.core.domain.base.impl.BaseAddToCustomListDialogImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.CustomListVoCollection;
import ims.core.vo.PatientCustomListVo;
import ims.core.vo.domain.PatientCustomListVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import java.util.ArrayList;
import java.util.List;

public class AddToCustomListDialogImpl extends BaseAddToCustomListDialogImpl
{

	private static final long serialVersionUID = 1L;


	/**
	* list custom lists
	*/
	public CustomListVoCollection listCustomLists(MemberOfStaffRefVo mosRefVo)
	{
		CustomPatientList implCL = (CustomPatientList)getDomainImpl(CustomPatientListImpl.class);
		return implCL.listCustomLists(mosRefVo);
	}

	public PatientCustomListVo savePatientCustomList(PatientCustomListVo voCustomList) throws StaleObjectException 
	{
		if (!voCustomList.isValidated())
		{
			throw new DomainRuntimeException("This PatientCustomListVo has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();			
		PatientCustomList domPCL = PatientCustomListVoAssembler.extractPatientCustomList(factory, voCustomList);
		factory.save(domPCL);
		
		return PatientCustomListVoAssembler.create(domPCL);
	}

	public PatientCustomListVo getPatientCustomList(CustomListRefVo voCustomList) 
	{
		CustomPatientList implCL = (CustomPatientList)getDomainImpl(CustomPatientListImpl.class);
		return implCL.getPatientCustomList(voCustomList);
	}

	public Boolean checkIfPatientIsAlreadyOnList(PatientRefVo patRefVo, PatientCustomListRefVo customListRefVo)
	{
		if(patRefVo == null || customListRefVo == null)
			throw new CodingRuntimeException("Mandatory parameter for checkIfPatientIsAlreadyOnList missing");

		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientCustomList pcl left join pcl.listEntry as le");
		hql.append(" where pcl.id = :pclID");
		names.add("pclID");
		values.add(customListRefVo.getID_PatientCustomList());
		
		hql.append (" and le.patient.id = :patID");
		names.add("patID");
		values.add(patRefVo.getID_Patient());	

		List list = factory.find(hql.toString(), names,values);
		if (list.size() > 0 )
			return true;
		else
			return false;
	}
}
