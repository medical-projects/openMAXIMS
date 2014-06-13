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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.39 build 2174.26977)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.therapies.domain.EnvironmentalVisitRooms;
import ims.therapies.domain.EnvironmentalVisitSummary;
import ims.therapies.homeandenvironmentalvisit.domain.objects.EnvironmentalVisit;
import ims.therapies.homeandenvironmentalvisit.vo.EnvironmentalVisitRefVo;
import ims.therapies.vo.EnvironmentalVisitShortVoCollection;
import ims.therapies.vo.EnvironmentalVisitVo;
import ims.therapies.vo.EnvironmentalVisitVoCollection;
import ims.therapies.vo.RoomDetailsVoCollection;
import ims.therapies.vo.domain.EnvironmentalVisitShortVoAssembler;
import ims.therapies.vo.domain.EnvironmentalVisitVoAssembler;
import ims.therapies.vo.domain.RoomDetailsVoAssembler;


public class EnvironmentalVisitImpl extends DomainImpl implements	ims.therapies.domain.EnvironmentalVisit, 
																	EnvironmentalVisitRooms,
																	EnvironmentalVisitSummary,
																	ims.domain.impl.Transactional
{

	public EnvironmentalVisitVo getEnvironmentalVisitByClinicalContact(ClinicalContactRefVo voClinicalContactRef) 
	{
		if(voClinicalContactRef == null || voClinicalContactRef.getID_ClinicalContact() == null)
			throw new DomainRuntimeException("Contact not provided for get call. ");

		DomainFactory factory = getDomainFactory();
		
		java.util.List environVisitList = factory.find("from  EnvironmentalVisit environList where environList.clinicalContact.id = :contactId ", new String[]{"contactId"}, new Object[]{voClinicalContactRef.getID_ClinicalContact()});
		
		EnvironmentalVisitVoCollection  coll = null;
		if  ((environVisitList != null) && (environVisitList.size()>0))
			coll = EnvironmentalVisitVoAssembler.createEnvironmentalVisitVoCollectionFromEnvironmentalVisit(environVisitList);
			
		if(coll != null && coll.size()>0)
			return coll.get(0);
	
		return null;
	}

	public EnvironmentalVisitVo saveEnvironmentalVisit(EnvironmentalVisitVo voEnvironmentalVisit) throws StaleObjectException, UniqueKeyViolationException 
	{
		DomainFactory factory = getDomainFactory();	
		
		if (!voEnvironmentalVisit.isValidated())
		{
			throw new DomainRuntimeException("This EnvironmentalVisitVo has not been validated");
		}
		
		if(voEnvironmentalVisit.getID_EnvironmentalVisit() == null)
		{
			if(voEnvironmentalVisit.getCareContextIsNotNull())
			{
				EnvironmentalVisitVoCollection coll = getEnvironmentalVisitVoByCareContext(voEnvironmentalVisit.getCareContext());
				if(coll != null && coll.size()>0)
					throw new UniqueKeyViolationException("A Environmental Visit record already exists for this CareContext. ");
			}
		}
		
		EnvironmentalVisit domEnvironmentalVisit = EnvironmentalVisitVoAssembler.extractEnvironmentalVisit(factory, voEnvironmentalVisit);
		factory.save(domEnvironmentalVisit);
		return EnvironmentalVisitVoAssembler.create(domEnvironmentalVisit);
	}

	private EnvironmentalVisitVoCollection getEnvironmentalVisitVoByCareContext(CareContextRefVo voCareContext) {
		String hql = new String("from EnvironmentalVisit ev where ev.careContext.id = :CARECONTEXT_ID");

		java.util.List list = getDomainFactory().find(hql, "CARECONTEXT_ID", voCareContext.getID_CareContext());

		return EnvironmentalVisitVoAssembler.createEnvironmentalVisitVoCollectionFromEnvironmentalVisit(list);
	}

	public HcpCollection listHcps(HcpFilter filter) 
	{
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(filter);
	}

	public EnvironmentalVisitShortVoCollection getEnvironmentalVisitByCareContext(CareContextRefVo voCareContextRefVo)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from EnvironmentalVisit ev ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voCareContextRefVo != null)
		{
			hql.append(andStr + " ev.careContext.id = :id_CareContext");
			markers.add("id_CareContext");
			values.add(voCareContextRefVo.getID_CareContext());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		

		List visit = factory.find(query, markers, values);	
		EnvironmentalVisitShortVoCollection collEnvironmentalVisitShortVo = EnvironmentalVisitShortVoAssembler.createEnvironmentalVisitShortVoCollectionFromEnvironmentalVisit(visit);
		if(collEnvironmentalVisitShortVo != null)
			return collEnvironmentalVisitShortVo.sort();
		
		return null;
	}

	public EnvironmentalVisitVo getEnvironmentalVisit(EnvironmentalVisitRefVo voEnvironmentalVisitRef)
	{
		return EnvironmentalVisitVoAssembler.create((EnvironmentalVisit) getDomainFactory().getDomainObject(EnvironmentalVisit.class,voEnvironmentalVisitRef.getID_EnvironmentalVisit()));
	}

	//wdev-13576
	public RoomDetailsVoCollection getRoomDetails(EnvironmentalVisitRefVo recordRef) 
	{
		if( recordRef == null)
			return null;
		String hql = new String("select r1_1 from EnvironmentalVisit as e1_1 left join e1_1.rooms as r1_1 where (e1_1.id = :VISITID) ");

		java.util.List list = getDomainFactory().find(hql, "VISITID", recordRef.getID_EnvironmentalVisit());

		return  RoomDetailsVoAssembler.createRoomDetailsVoCollectionFromRoomDetails(list);
	}
}
