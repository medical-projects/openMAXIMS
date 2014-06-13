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

package ims.ocrr.domain;

// Generated from form domain impl
public interface PathologyOrders extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Order Investigation
	*/
	public ims.ocrr.vo.PathologyOrderVoCollection listOrderInvestigation(ims.core.clinical.vo.ServiceRefVo serviceRefVo, ims.ocrr.vo.lookups.Category category);

	// Generated from form domain interface definition
	/**
	* List Location
	*/
	public ims.core.vo.LocationLiteVoCollection listLocation(ims.core.vo.lookups.LocationType type, Boolean active);

	// Generated from form domain interface definition
	/**
	* getReportAndTemplate
	*/
	public String[] getReportAndTemplate(Integer reportId, Integer templateId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listAssignedReports
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId);

	// Generated from form domain interface definition
	/**
	* list Service
	*/
	public ims.core.vo.ServiceLiteVoCollection listService(ims.core.resource.place.vo.LocationRefVo locationRefVo, ims.core.vo.lookups.ServiceCategory serviceCategory);

	// Generated from form domain interface definition
	/**
	* getRoleDisciplineSecurityLevels
	*/
	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role);

	// Generated from form domain interface definition
	/**
	* getCatsReferralByOrder
	*/
	public ims.careuk.vo.CatsReferralListVo getCatsReferralByOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrder);

	// Generated from form domain interface definition
	public ims.ocrr.vo.PathologyOrderVoCollection listPathologyOrderInvestigation(ims.core.clinical.vo.ServiceRefVo serviceRefVo, ims.core.resource.place.vo.LocationRefVo locationRefVo, ims.ocrr.vo.lookups.Category category, ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate);
}
