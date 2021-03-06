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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.53 build 2643.26724)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import java.util.List;

import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.domain.LocSiteLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.domain.base.impl.BaseImagingEventsImpl;
import ims.oncology.domain.objects.Imagingevents;
import ims.oncology.vo.domain.ImagingEventsVoAssembler;

public class ImagingEventsImpl extends BaseImagingEventsImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* list Location Site
	*/
	public ims.core.vo.LocSiteLiteVoCollection listLocSite(String locationName)
	{
		String location = locationName != null ? locationName.toUpperCase() + "%" : "%%";

		StringBuffer hql = new StringBuffer();
		hql.append(" from LocSite as ls");
		hql.append(" where");
		hql.append(" ls.upperName like :locationName");
		hql.append(" and ls.isActive =:active");
		hql.append(" and ls.isRIE is null");
		hql.append(" and ls.isVirtual =:virtual");//wdev-2730
		hql.append(" and ls.type.id != " + LocationType.SURGERY.getID());

		List list = getDomainFactory().find(hql.toString(), new String[]{"locationName", "active", "virtual"}, new Object[]{location, Boolean.TRUE, Boolean.FALSE});

		return LocSiteLiteVoAssembler.createLocSiteLiteVoCollectionFromLocSite(list);

//		OrganisationAndLocation orgLocImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
//		return orgLocImpl.listLocSite(locationName);
	}

	/**
	* List Imaging Events
	*/
	public ims.oncology.vo.ImagingEventsVoCollection listImagingEventsVo(EpisodeOfCareRefVo refVoEpisodeOfCare)
	{
		if(refVoEpisodeOfCare.getID_EpisodeOfCare() == null)
			throw new DomainRuntimeException("careSpellRefVo.getID_CareSpell is null in listImagingEventsVo");

		DomainFactory factory = getDomainFactory();
		//wdev-11556 ----
		StringBuffer hql = new StringBuffer("from Imagingevents i1_1 ");
		hql.append(" where i1_1.episodeOfCare.id = " + refVoEpisodeOfCare.getID_EpisodeOfCare());
		//-----------
		return ImagingEventsVoAssembler.createImagingEventsVoCollectionFromImagingevents(factory.find(hql.toString()));
	}

	/**
	* Save ImagingEventVo
	*/
	public ims.oncology.vo.ImagingEventsVo saveImagingEventVo(ims.oncology.vo.ImagingEventsVo imagingEventVo) throws ims.domain.exceptions.StaleObjectException
	{
		if (!imagingEventVo.isValidated())
			throw new DomainRuntimeException("ImagingEvent has not been validated");

		DomainFactory factory = getDomainFactory();
		Imagingevents domImgEve = ImagingEventsVoAssembler.extractImagingevents(factory, imagingEventVo);
		factory.save(domImgEve);
		
		return ImagingEventsVoAssembler.create(domImgEve);
	}

	/**
	* Get a Imaging Evnet record
	*/
	public ims.oncology.vo.ImagingEventsVo getImagingEventVo(ims.oncology.vo.ImagingeventsRefVo imagingEventRefVo)
	{
		return ImagingEventsVoAssembler.create((Imagingevents)getDomainFactory().getDomainObject(Imagingevents.class, imagingEventRefVo.getID_Imagingevents()));
	}

}
