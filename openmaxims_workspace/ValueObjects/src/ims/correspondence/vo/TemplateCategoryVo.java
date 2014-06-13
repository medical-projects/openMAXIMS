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

package ims.correspondence.vo;

/**
 * Linked to correspondence.configuration.TemplateCategory business object (ID: 1053100002).
 */
public class TemplateCategoryVo extends ims.correspondence.configuration.vo.TemplateCategoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TemplateCategoryVo()
	{
	}
	public TemplateCategoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public TemplateCategoryVo(ims.correspondence.vo.beans.TemplateCategoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getTemplate().getId()), bean.getTemplate().getVersion());
		this.dischargecategories = ims.correspondence.vo.lookups.HeaderCollection.buildFromBeanCollection(bean.getDischargeCategories());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.TemplateCategoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getTemplate().getId()), bean.getTemplate().getVersion());
		this.dischargecategories = ims.correspondence.vo.lookups.HeaderCollection.buildFromBeanCollection(bean.getDischargeCategories());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.TemplateCategoryVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.TemplateCategoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.TemplateCategoryVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		if(fieldName.equals("DISCHARGECATEGORIES"))
			return getDischargeCategories();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.core.admin.vo.TemplateBoRefVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.core.admin.vo.TemplateBoRefVo value)
	{
		this.isValidated = false;
		this.template = value;
	}
	public boolean getDischargeCategoriesIsNotNull()
	{
		return this.dischargecategories != null;
	}
	public ims.correspondence.vo.lookups.HeaderCollection getDischargeCategories()
	{
		return this.dischargecategories;
	}
	public void setDischargeCategories(ims.correspondence.vo.lookups.HeaderCollection value)
	{
		this.isValidated = false;
		this.dischargecategories = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.template == null)
			listOfErrors.add("template is mandatory");
		if(this.dischargecategories == null || this.dischargecategories.size() == 0)
			listOfErrors.add("One header must be selected in order to save a record");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TemplateCategoryVo clone = new TemplateCategoryVo(this.id, this.version);
		
		clone.template = this.template;
		if(this.dischargecategories == null)
			clone.dischargecategories = null;
		else
			clone.dischargecategories = (ims.correspondence.vo.lookups.HeaderCollection)this.dischargecategories.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TemplateCategoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TemplateCategoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TemplateCategoryVo compareObj = (TemplateCategoryVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_TemplateCategory() == null && compareObj.getID_TemplateCategory() != null)
				return -1;
			if(this.getID_TemplateCategory() != null && compareObj.getID_TemplateCategory() == null)
				return 1;
			if(this.getID_TemplateCategory() != null && compareObj.getID_TemplateCategory() != null)
				retVal = this.getID_TemplateCategory().compareTo(compareObj.getID_TemplateCategory());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.template != null)
			count++;
		if(this.dischargecategories != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.admin.vo.TemplateBoRefVo template;
	protected ims.correspondence.vo.lookups.HeaderCollection dischargecategories;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
