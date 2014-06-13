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

public abstract class BaseElectiveListConfigurationImpl extends DomainImpl implements ims.admin.domain.ElectiveListConfiguration, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistConsultants(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHospitals(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServices(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.admin.vo.ElectiveListConfigurationVo configurationToSave)
	{
	}

	@SuppressWarnings("unused")
	public void validategetConfiguration(ims.core.configuration.vo.ElectiveListConfigurationRefVo configurationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesearch(ims.admin.vo.ElectiveListConfigSearchCriteriaVo searchCriteria)
	{
	}

	@SuppressWarnings("unused")
	public void validateexistConfigurationWithSameName(String name, ims.core.configuration.vo.ElectiveListConfigurationRefVo waitingListConfigRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateexistConfigurationWithSameCode(String code, ims.core.configuration.vo.ElectiveListConfigurationRefVo waitingListConfigRef, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate)
	{
	}

	@SuppressWarnings("unused")
	public void validateisConsultantMarkedAsDefaultForSameServiceForOtherConfiguration(ims.core.resource.people.vo.HcpRefVo consultantRef, ims.admin.vo.ServiceForElectiveListConfigVo serviceVo, ims.core.configuration.vo.ElectiveListConfigurationRefVo waitingListConfigRef, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate)
	{
	}

	@SuppressWarnings("unused")
	public void validatecanInactivateConfiguration(ims.core.configuration.vo.ElectiveListConfigurationRefVo configRef)
	{
	}
}
