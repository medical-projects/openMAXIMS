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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseEDischargeSTHKImpl extends DomainImpl implements ims.clinical.domain.EDischargeSTHK, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDischargeDetails(ims.clinical.vo.DischargeDetailsVo voDischargeDetails)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupplementaryAndDDAndSummary(ims.clinical.vo.DischargeSupplementaryNotesVo voDischSupp, ims.clinical.vo.DischargeDetailsVo voDD, ims.clinical.vo.EDischargeSTHKSummaryVo voSumm)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSupplementary(ims.core.admin.vo.CareContextRefVo voCareContextRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSystemReportAndTemplate(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDischargeReportDetailsForCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSummaryByCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
	}

	@SuppressWarnings("unused")
	public void validateisPasEventMissing(ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(careContext == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'careContext' of type 'ims.core.admin.vo.CareContextRefVo' cannot be null.");
	}
}
