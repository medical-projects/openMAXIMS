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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import java.util.List;

import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseDischargeDetails_AdviceTransportImpl;
import ims.emergency.domain.objects.DischargeServicesAndAdvice;
import ims.emergency.vo.AdviceLeafletConfigDisplayVoCollection;
import ims.emergency.vo.DischargeServicesAndAdviceVo;
import ims.emergency.vo.domain.AdviceLeafletConfigDisplayVoAssembler;
import ims.emergency.vo.domain.DischargeServicesAndAdviceVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class DischargeDetails_AdviceTransportImpl extends BaseDischargeDetails_AdviceTransportImpl
{
	private static final long serialVersionUID = 1L;


	public AdviceLeafletConfigDisplayVoCollection getAdviceLeaflets(ClinicalProblemRefVo clinicalProblem)
	{
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT advice FROM AdviceLeafletsConfig AS advice LEFT JOIN advice.problems AS problem ");
		query.append("LEFT JOIN advice.template AS template ");
		query.append("WHERE advice.isGenericAdviceLeaflet = 1 ");
		
		if (clinicalProblem != null && clinicalProblem.getID_ClinicalProblem() != null)
		{
			query.append("OR problem.id = ").append(clinicalProblem.getID_ClinicalProblem());
		}
		
		query.append(" ORDER BY UPPER(template.name) ASC ");
		
		
		return AdviceLeafletConfigDisplayVoAssembler.createAdviceLeafletConfigDisplayVoCollectionFromAdviceLeafletsConfig(getDomainFactory().find(query.toString()));
	}

	
	public DischargeServicesAndAdviceVo getDischargeServiceAndAdvice(CareContextRefVo careContext)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
			return null;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT discharge FROM DischargeServicesAndAdvice AS discharge LEFT JOIN discharge.attendance AS context ");
		query.append("WHERE context.id = ").append(careContext.getID_CareContext());
		
		return DischargeServicesAndAdviceVoAssembler.create((DischargeServicesAndAdvice) getDomainFactory().findFirst(query.toString()));
	}

	
	public DischargeServicesAndAdviceVo save(DischargeServicesAndAdviceVo dischargeServices) throws StaleObjectException
	{
		// Check parameter
		if (dischargeServices == null)
			throw new CodingRuntimeException("Can not save null record");
		
		// Check for validation
		if (!dischargeServices.isValidated())
			throw new CodingRuntimeException("Can not save record not validated");
		
		// Check for a previously saved record
		if (dischargeServices.getID_DischargeServicesAndAdvice() == null)
		{
			StringBuilder query = new StringBuilder();
			query.append("SELECT COUNT(discharge) FROM DischargeServicesAndAdvice AS discharge LEFT JOIN discharge.attendance AS context WHERE context.id = :CONTEXT");
			
			long count = getDomainFactory().countWithHQL(query.toString(), new String[] {"CONTEXT"}, new Object[] {dischargeServices.getAttendance().getID_CareContext()});
			
			if (count > 0)
				throw new StaleObjectException(null);
		}
		
		// Commit to database
		DischargeServicesAndAdvice domainRecord = DischargeServicesAndAdviceVoAssembler.extractDischargeServicesAndAdvice(getDomainFactory(), dischargeServices);
		getDomainFactory().save(domainRecord);
		
		// Return saved object
		return DischargeServicesAndAdviceVoAssembler.create(domainRecord);
	}


	public String[] getReportAndTemplate(TemplateBoRefVo template)
	{
		String[] result = null;
		
		if (template == null || template.getID_TemplateBo() == null)
			return null;
		
		List<?> list = getDomainFactory().find("SELECT rep.reportXml, templ.templateXml from TemplateBo AS templ LEFT JOIN templ.report AS rep WHERE templ.id = :ID", "ID", template.getID_TemplateBo());

		if (list.iterator().hasNext())
		{
			Object[] obj = (Object[]) list.iterator().next();
			
			result = new String[] {(String)  obj[0], (String) obj[1] };
		}
		
		return result;
	}
}
