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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseSupportNetworkFamilyImpl extends DomainImpl implements ims.core.domain.SupportNetworkFamily, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkFamily(Boolean active, ims.core.vo.PatientShort patient, Boolean isRieMode)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupportNetworkFamily(ims.core.vo.SupportNetworkFamily voSupportNetworkFamily)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcps(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcp(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort voPatientShort)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSupportNetworkFamily(ims.core.clinical.vo.SupportNetworkFamilyRefVo refVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkFamily(Boolean active, ims.core.vo.PatientShort patient)
	{
	}
}
