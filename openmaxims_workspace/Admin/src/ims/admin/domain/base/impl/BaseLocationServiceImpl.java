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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseLocationServiceImpl extends DomainImpl implements ims.admin.domain.LocationService, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesaveLocationService(ims.core.vo.LocationServiceVo locationService)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrganisation(ims.core.vo.OrganisationVo organisation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationService(ims.core.resource.place.vo.LocationRefVo voLocation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServices(String serviceName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServiceFunction(Integer voServiceId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetService(Integer serviceId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServiceActivity(Integer voServiceId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActivity(ims.core.vo.ActivityVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActivity(ims.core.vo.LocationServiceActivityVo locationServiceActivity)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActivity(ims.core.vo.ActivityVo filterActivity, Boolean checkDuplicate)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationService(ims.core.vo.LocationServiceVo locationServiceFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationServiceActivity(ims.core.vo.LocationServiceVo locationService, ims.core.vo.ActivityVo activity)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistService(Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validateremoveLocationService(ims.core.vo.LocationServiceVo voLocationService)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationServiceActivity(ims.core.vo.LocationServiceVo filterLocationService)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationServiceFunction(ims.core.vo.LocationServiceVo voLocationService, ims.core.vo.ServiceFunctionVo voFunction)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServiceExcludeCategory(String serviceName, ims.core.vo.lookups.ServiceCategory serviceCategory)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationServiceActivityKeyWords(ims.core.vo.LocationServiceVo locationService, ims.core.vo.ActivityVo activity)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProcedureForActivity(ims.core.resource.place.vo.ActivityRefVo activityRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountBatches(ims.core.resource.place.vo.LocationRefVo location)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationServiceLite(ims.core.resource.place.vo.LocationRefVo voLocation)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServicesForLocation(ims.core.resource.place.vo.LocationRefVo location, ims.core.vo.ServiceVo service)
	{
	}
}
