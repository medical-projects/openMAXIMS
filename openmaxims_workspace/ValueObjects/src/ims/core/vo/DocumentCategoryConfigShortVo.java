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

package ims.core.vo;

/**
 * Linked to core.Documents.DocumentCategoryConfig business object (ID: 1068100004).
 */
public class DocumentCategoryConfigShortVo extends ims.core.documents.vo.DocumentCategoryConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DocumentCategoryConfigShortVo()
	{
	}
	public DocumentCategoryConfigShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public DocumentCategoryConfigShortVo(ims.core.vo.beans.DocumentCategoryConfigShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo();
		this.specialty = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialty());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DocumentCategoryConfigShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo(map);
		this.specialty = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialty());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DocumentCategoryConfigShortVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DocumentCategoryConfigShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DocumentCategoryConfigShortVoBean();
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
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.core.vo.TemplateForPatientDocumentVo getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.core.vo.TemplateForPatientDocumentVo value)
	{
		this.isValidated = false;
		this.template = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.SpecialtyCollection getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.SpecialtyCollection value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.DocumentCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.DocumentCategory value)
	{
		this.isValidated = false;
		this.category = value;
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
			listOfErrors.add("Template is mandatory");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
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
	
		DocumentCategoryConfigShortVo clone = new DocumentCategoryConfigShortVo(this.id, this.version);
		
		if(this.template == null)
			clone.template = null;
		else
			clone.template = (ims.core.vo.TemplateForPatientDocumentVo)this.template.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.SpecialtyCollection)this.specialty.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.DocumentCategory)this.category.clone();
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
		if (!(DocumentCategoryConfigShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DocumentCategoryConfigShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DocumentCategoryConfigShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DocumentCategoryConfigShortVo)obj).getBoId());
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
		if(this.specialty != null)
			count++;
		if(this.category != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.TemplateForPatientDocumentVo template;
	protected ims.core.vo.lookups.SpecialtyCollection specialty;
	protected ims.core.vo.lookups.DocumentCategory category;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
