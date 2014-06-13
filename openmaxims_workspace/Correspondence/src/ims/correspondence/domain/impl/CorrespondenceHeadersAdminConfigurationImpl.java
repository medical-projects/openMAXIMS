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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.List;

import ims.admin.vo.domain.ReportTemplateVoAssembler;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.correspondence.configuration.domain.objects.TemplateCategory;
import ims.correspondence.domain.base.impl.BaseCorrespondenceHeadersAdminConfigurationImpl;
import ims.correspondence.vo.TemplateCategoryVo;
import ims.correspondence.vo.TemplateCategoryVoCollection;
import ims.correspondence.vo.domain.TemplateCategoryVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

public class CorrespondenceHeadersAdminConfigurationImpl extends BaseCorrespondenceHeadersAdminConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.ReportTemplateVoCollection listTemplates(Boolean activeOnly)
	{
		DomainFactory factory = getDomainFactory();
		
		List templates  = factory.find("from TemplateBo");
	
		return ReportTemplateVoAssembler.createReportTemplateVoCollectionFromTemplateBo(templates).sort();
	}

	public TemplateCategoryVo getTemplateCategory(TemplateBoRefVo template) 
	{
		if (template == null)
			throw new CodingRuntimeException("Invalid Argument: TemplateBoRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		TemplateCategory doTemplateCategory = TemplateCategory.getTemplateCategoryFromTemplate(factory, template.getID_TemplateBo());
		return TemplateCategoryVoAssembler.create(doTemplateCategory);
	}

	public void saveTemplateCategories(TemplateCategoryVoCollection templateCollection,	TemplateCategoryVoCollection deleteCollection) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException 
	{
		if (templateCollection == null)
			throw new CodingRuntimeException("Invalid Argument: Template Category Collection is null");
		if (!templateCollection.isValidated())
			throw new DomainRuntimeException("TemplateCategoryVoCollection not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		for(int i=0; i<templateCollection.size(); i++)
		{
			TemplateCategory domTemplCategory = TemplateCategoryVoAssembler.extractTemplateCategory(factory, templateCollection.get(i));
			factory.save(domTemplCategory);
		}
		
		if(deleteCollection != null && deleteCollection.size() > 0)
		{
			for(int i=0; i<deleteCollection.size(); i++)
			{
				TemplateCategory delTemplCategory = TemplateCategoryVoAssembler.extractTemplateCategory(factory, deleteCollection.get(i));
				factory.delete(delTemplCategory);
			}
		}
	}
}
