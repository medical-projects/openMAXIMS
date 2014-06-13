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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseSurgicalAuditImpl;
import ims.clinical.helper.IESurgicalAuditHelper;
import ims.clinical.helper.SurgicalAuditHelper;
import ims.clinical.vo.SurgicalAuditOperationDetailRefVo;
import ims.clinical.vo.SurgicalAuditOperationDetailVo;
import ims.clinical.vo.SurgicalAuditOperationDetailVoCollection;
import ims.core.admin.vo.CareContextRefVo;

public class SurgicalAuditImpl extends BaseSurgicalAuditImpl
{

	private static final long serialVersionUID = 1L;

	public SurgicalAuditOperationDetailVoCollection listSurgicalAuditOperationDetailByCareContext(CareContextRefVo careContextRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.listSurgicalAuditOperationDetailByCareContext(careContextRef);
	}

	public SurgicalAuditOperationDetailVo getSurgicalAuditOperationDetail(SurgicalAuditOperationDetailRefVo surgicalAuditOpRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.getSurgicalAuditOperationDetail(surgicalAuditOpRef);
	}

}
