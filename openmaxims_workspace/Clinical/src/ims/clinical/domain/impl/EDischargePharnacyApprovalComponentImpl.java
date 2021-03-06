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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.80 build 3952.27656)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseEDischargePharmacyApprovalComponentImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.edischarge.vo.SummaryRefVo;
import ims.framework.utils.Date;

public class EDischargePharnacyApprovalComponentImpl extends BaseEDischargePharmacyApprovalComponentImpl
{
	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.TTAMedicationAndPharmacyVo getTTAMedicationAndPharmacy(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getTTAMedicationAndPharmacy(careContextRefvo);
	}
	
	public ims.core.vo.HcpLiteVo getHcp(ims.core.resource.people.vo.HcpRefVo voRef)
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getHcp(voRef);
	}

	public ims.clinical.vo.TTAMedicationAndPharmacyVo save(ims.clinical.vo.TTAMedicationAndPharmacyVo record, SummaryRefVo summary) throws ims.domain.exceptions.StaleObjectException, DomainInterfaceException, UniqueKeyViolationException
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.save(record, summary);
	}

	public Date getEstimatedDischargeDate(SummaryRefVo summary) 
	{
		IEDischargeHelper impl = (IEDischargeHelper)getDomainImpl(EDischargeHelper.class);
		return impl.getEstimatedDischargeDate(summary);
	}
}
