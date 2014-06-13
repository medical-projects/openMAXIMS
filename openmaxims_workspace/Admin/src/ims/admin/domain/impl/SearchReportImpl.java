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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseSearchReportImpl;
import ims.admin.vo.domain.SystemReportVoAssembler;
import ims.domain.DomainFactory;

import java.util.ArrayList;

public class SearchReportImpl extends BaseSearchReportImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.SystemReportVoCollection listReports(Boolean systemReportsOnly, String reportName)
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();

		hql.append(" FROM ReportBo AS rep ");

		if (Boolean.TRUE.equals(systemReportsOnly) || reportName != null)
		{
			hql.append(" WHERE ");
		}

		if (Boolean.TRUE.equals(systemReportsOnly))
		{
			hql.append("rep.imsId IS NOT NULL ");
		}

		if (reportName != null)
		{
			hql.append(" AND UPPER(rep.reportName) like :reportName ");
			markers.add("reportName");
			values.add("%" + reportName.toUpperCase() + "%");
		}

		hql.append(" order by UPPER(rep.reportName) asc");

		return SystemReportVoAssembler.createSystemReportVoCollectionFromReportBo(factory.find(hql.toString(), markers, values));
	}
}
