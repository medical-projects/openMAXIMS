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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.41 build 2196.21388)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.therapies.domain.base.impl.BaseThermalImpl;
import ims.therapies.treatment.domain.objects.Thermal;
import ims.therapies.treatment.vo.ThermalRefVo;
import ims.therapies.vo.ThermalShortVoCollection;
import ims.therapies.vo.ThermalVo;
import ims.therapies.vo.domain.ThermalShortVoAssembler;
import ims.therapies.vo.domain.ThermalVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class ThermalImpl extends BaseThermalImpl
{
	private static final long serialVersionUID = 1L;

	public ims.therapies.vo.ThermalVo saveThermalDetails(ims.therapies.vo.ThermalVo voThermal) throws StaleObjectException, UniqueKeyViolationException
	{
		if(voThermal == null)
			throw new DomainRuntimeException("Cannot save null Thermal record");
		
		// Ensure the value object has been validated
		if (!voThermal.isValidated())
			throw new DomainRuntimeException("Thermal Record has not been validated");
		
		/*	WDEV-13649if(voThermal.getID_Thermal() == null)
		{
			List list = Thermal.listThermalByClinicalContact(getDomainFactory(), (ims.core.admin.domain.objects.ClinicalContact) getDomainFactory().getDomainObject(voThermal.getClinicalContact()));
			if (list != null && list.size() > 0)
				throw new StaleObjectException((Thermal)list.get(0));
		}*/
		DomainFactory factory = getDomainFactory();
		Thermal domThermal = ThermalVoAssembler.extractThermal(factory, voThermal);

		factory.save(domThermal);

		return ThermalVoAssembler.create(domThermal);
	}

	/**
	* Return a list of HCP's
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(filter);
	}

	public ThermalVo getThermalDetailsByClinicalContact(ClinicalContactRefVo voClinicalContactRef)
	{
		if (voClinicalContactRef == null)
			throw new RuntimeException("Cannot get ThermalVo for null ClinicalContactRefVo");

		List list = Thermal.listThermalByClinicalContact(getDomainFactory(), (ims.core.admin.domain.objects.ClinicalContact) getDomainFactory().getDomainObject(voClinicalContactRef));

		if (list == null || list.size() == 0)
			return null;
		//	WDEV-13649else if (list.size() > 1)
		//	WDEV-13649	throw new CodingRuntimeException("More than one Thermal found for the current Clinical Contact");

		return ThermalVoAssembler.createThermalVoCollectionFromThermal(list).get(0);
	}

	public ThermalShortVoCollection listThermalDetailsByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from Thermal ctt ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContextRef != null)
		{
			hql.append(andStr + " ctt.clinicalContact.careContext.id = :cc");
			markers.add("cc");
			values.add(voCareContextRef.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List thermal = factory.find(query,markers,values);
		ThermalShortVoCollection voThermalShortColl = ThermalShortVoAssembler.createThermalShortVoCollectionFromThermal(thermal);
		
		return voThermalShortColl;
	}

	//	WDEV-13649
	public ThermalVo getThermal(ThermalRefVo thermal)
	{
		if(thermal == null || thermal.getID_Thermal() == null)
			throw new CodingRuntimeException("Can not get Thermal on null Id.");
		
		return ThermalVoAssembler.create((Thermal) getDomainFactory().getDomainObject(Thermal.class, thermal.getID_Thermal()));
	}
}
