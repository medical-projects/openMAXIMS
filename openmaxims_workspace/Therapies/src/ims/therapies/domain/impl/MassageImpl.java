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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.40 build 2182.20574)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.clinical.domain.objects.ClinicalNotes;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;
import ims.therapies.treatment.domain.objects.Massage;
import ims.therapies.vo.MassageShortVoCollection;
import ims.therapies.vo.MassageVo;
import ims.therapies.vo.MassageVoCollection;
import ims.therapies.vo.domain.MassageShortVoAssembler;
import ims.therapies.vo.domain.MassageVoAssembler;

public class MassageImpl extends DomainImpl implements ims.therapies.domain.Massage, ims.domain.impl.Transactional
{	
	/**
	* Save a Massage Record for a Clinical Contact
	*/
	public ims.therapies.vo.MassageVo saveMassageVo(ims.therapies.vo.MassageVo voMassage) throws ims.domain.exceptions.StaleObjectException
	{
		// Ensure the value object has been validated
		if (!voMassage.isValidated())
			throw new DomainRuntimeException("Massage has not been validated");
		
		//if a new massage record must be saved check if exist a massage record for this clinical contact (only one massage record must exist per clinical contact) 
		if(voMassage.getID_Massage() == null)
		{
			if(voMassage.getClinicalContactIsNotNull())
			{
				ims.therapies.vo.MassageVo voMassagetemp =  getMassageVoByClinicalContact(voMassage.getClinicalContact());
				if( voMassagetemp != null)
					throw new DomainRuntimeException("A Massage record already exists for the current Clinical Contact");
			}
		}
		
		DomainFactory factory = getDomainFactory();
		Massage doMassage = MassageVoAssembler.extractMassage(factory, voMassage);
		factory.save(doMassage);

		return MassageVoAssembler.create(doMassage);
	}

	/**
	* list HCPs
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(filter);
	}

	public MassageVo getMassageVoByClinicalContact(ClinicalContactRefVo voClinicalContactRef)
	{
		if (voClinicalContactRef == null)
			throw new RuntimeException("Cannot get Massage record for null ClinicalContactRefVo");

		StringBuffer query = new StringBuffer("from Massage as m1_1 where m1_1.clinicalContact.id = :CCID order by m1_1.systemInformation.creationDateTime desc");

		List list = getDomainFactory().find(query.toString(), "CCID", voClinicalContactRef.getID_ClinicalContact());

		if (list == null || list.size() == 0)
			return null;
		
		MassageVoCollection voColl = MassageVoAssembler.createMassageVoCollectionFromMassage(list);
		if (voColl.size() > 0)
			return voColl.get(0);

		return null;
	}

	public MassageShortVoCollection listMassageByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from Massage m ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voCareContextRef != null)
		{
			hql.append(andStr + " m.clinicalContact.careContext.id = :id_CareContext");
			markers.add("id_CareContext");
			values.add(voCareContextRef.getID_CareContext());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		

		List massage = factory.find(query, markers, values);	
		MassageShortVoCollection collMassageShortVo = MassageShortVoAssembler.createMassageShortVoCollectionFromMassage(massage);
		if(collMassageShortVo != null)
			return collMassageShortVo;
		
		return null;
	}

	public MassageVo getMassageVo(Integer massageId) {
		DomainFactory factory = getDomainFactory();
		Massage doMassage = (Massage)factory.getDomainObject(Massage.class, massageId);
		return MassageVoAssembler.create(doMassage);
	}

}
