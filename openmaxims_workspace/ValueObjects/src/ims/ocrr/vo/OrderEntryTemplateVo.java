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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.OrderEntryTemplate business object (ID: 1061100005).
 */
public class OrderEntryTemplateVo extends ims.ocrr.vo.OrderEntryTemplateBaseVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderEntryTemplateVo()
	{
	}
	public OrderEntryTemplateVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderEntryTemplateVo(ims.ocrr.vo.beans.OrderEntryTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.formname = bean.getFormName();
		this.menuname = bean.getMenuName();
		this.description = bean.getDescription();
		this.components = ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection.buildFromBeanCollection(bean.getComponents());
		this.templatecategory = bean.getTemplateCategory() == null ? null : ims.ocrr.vo.lookups.TemplateCategories.buildLookup(bean.getTemplateCategory());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.templateslocations = ims.ocrr.vo.TemplateLocationShortVoCollection.buildFromBeanCollection(bean.getTemplatesLocations());
		this.columns = ims.ocrr.vo.OrderEntryTemplateColumnVoCollection.buildFromBeanCollection(bean.getColumns());
		this.templateroles = ims.ocrr.vo.TemplateRoleShortVoCollection.buildFromBeanCollection(bean.getTemplateRoles());
		this.formtext = bean.getFormText();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderEntryTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.formname = bean.getFormName();
		this.menuname = bean.getMenuName();
		this.description = bean.getDescription();
		this.components = ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection.buildFromBeanCollection(bean.getComponents());
		this.templatecategory = bean.getTemplateCategory() == null ? null : ims.ocrr.vo.lookups.TemplateCategories.buildLookup(bean.getTemplateCategory());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.templateslocations = ims.ocrr.vo.TemplateLocationShortVoCollection.buildFromBeanCollection(bean.getTemplatesLocations());
		this.columns = ims.ocrr.vo.OrderEntryTemplateColumnVoCollection.buildFromBeanCollection(bean.getColumns());
		this.templateroles = ims.ocrr.vo.TemplateRoleShortVoCollection.buildFromBeanCollection(bean.getTemplateRoles());
		this.formtext = bean.getFormText();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderEntryTemplateVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderEntryTemplateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderEntryTemplateVoBean();
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
		if(fieldName.equals("MENUNAME"))
			return getMenuName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("COMPONENTS"))
			return getComponents();
		if(fieldName.equals("TEMPLATECATEGORY"))
			return getTemplateCategory();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("TEMPLATESLOCATIONS"))
			return getTemplatesLocations();
		if(fieldName.equals("COLUMNS"))
			return getColumns();
		if(fieldName.equals("TEMPLATEROLES"))
			return getTemplateRoles();
		if(fieldName.equals("FORMTEXT"))
			return getFormText();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMenuNameIsNotNull()
	{
		return this.menuname != null;
	}
	public String getMenuName()
	{
		return this.menuname;
	}
	public static int getMenuNameMaxLength()
	{
		return 255;
	}
	public void setMenuName(String value)
	{
		this.isValidated = false;
		this.menuname = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getComponentsIsNotNull()
	{
		return this.components != null;
	}
	public ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection getComponents()
	{
		return this.components;
	}
	public void setComponents(ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection value)
	{
		this.isValidated = false;
		this.components = value;
	}
	public boolean getTemplateCategoryIsNotNull()
	{
		return this.templatecategory != null;
	}
	public ims.ocrr.vo.lookups.TemplateCategories getTemplateCategory()
	{
		return this.templatecategory;
	}
	public void setTemplateCategory(ims.ocrr.vo.lookups.TemplateCategories value)
	{
		this.isValidated = false;
		this.templatecategory = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getTemplatesLocationsIsNotNull()
	{
		return this.templateslocations != null;
	}
	public ims.ocrr.vo.TemplateLocationShortVoCollection getTemplatesLocations()
	{
		return this.templateslocations;
	}
	public void setTemplatesLocations(ims.ocrr.vo.TemplateLocationShortVoCollection value)
	{
		this.isValidated = false;
		this.templateslocations = value;
	}
	public boolean getColumnsIsNotNull()
	{
		return this.columns != null;
	}
	public ims.ocrr.vo.OrderEntryTemplateColumnVoCollection getColumns()
	{
		return this.columns;
	}
	public void setColumns(ims.ocrr.vo.OrderEntryTemplateColumnVoCollection value)
	{
		this.isValidated = false;
		this.columns = value;
	}
	public boolean getTemplateRolesIsNotNull()
	{
		return this.templateroles != null;
	}
	public ims.ocrr.vo.TemplateRoleShortVoCollection getTemplateRoles()
	{
		return this.templateroles;
	}
	public void setTemplateRoles(ims.ocrr.vo.TemplateRoleShortVoCollection value)
	{
		this.isValidated = false;
		this.templateroles = value;
	}
	public boolean getFormTextIsNotNull()
	{
		return this.formtext != null;
	}
	public String getFormText()
	{
		return this.formtext;
	}
	public static int getFormTextMaxLength()
	{
		return 4001;
	}
	public void setFormText(String value)
	{
		this.isValidated = false;
		this.formtext = value;
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
		if(this.components != null)
		{
			if(!this.components.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.templateslocations != null)
		{
			if(!this.templateslocations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.columns != null)
		{
			if(!this.columns.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.templateroles != null)
		{
			if(!this.templateroles.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.formname == null || this.formname.length() == 0)
			listOfErrors.add("The field 'Form Name' cannot be empty.");
		else if(this.formname.length() > 255)
			listOfErrors.add("The length of the field [formname] in the value object [ims.ocrr.vo.OrderEntryTemplateVo] is too big. It should be less or equal to 255");
		if(this.menuname == null || this.menuname.length() == 0)
			listOfErrors.add("The field 'Menu Name' cannot be empty.");
		else if(this.menuname.length() > 255)
			listOfErrors.add("The length of the field [menuname] in the value object [ims.ocrr.vo.OrderEntryTemplateVo] is too big. It should be less or equal to 255");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("The field 'Description' cannot be empty.");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.ocrr.vo.OrderEntryTemplateVo] is too big. It should be less or equal to 255");
		if(this.components != null)
		{
			String[] listOfOtherErrors = this.components.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.templatecategory == null)
			listOfErrors.add("The field 'Category' cannot be empty.");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.templateslocations != null)
		{
			String[] listOfOtherErrors = this.templateslocations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.columns != null)
		{
			String[] listOfOtherErrors = this.columns.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.templateroles != null)
		{
			String[] listOfOtherErrors = this.templateroles.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		OrderEntryTemplateVo clone = new OrderEntryTemplateVo(this.id, this.version);
		
		clone.formname = this.formname;
		clone.menuname = this.menuname;
		clone.description = this.description;
		if(this.components == null)
			clone.components = null;
		else
			clone.components = (ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection)this.components.clone();
		if(this.templatecategory == null)
			clone.templatecategory = null;
		else
			clone.templatecategory = (ims.ocrr.vo.lookups.TemplateCategories)this.templatecategory.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.templateslocations == null)
			clone.templateslocations = null;
		else
			clone.templateslocations = (ims.ocrr.vo.TemplateLocationShortVoCollection)this.templateslocations.clone();
		if(this.columns == null)
			clone.columns = null;
		else
			clone.columns = (ims.ocrr.vo.OrderEntryTemplateColumnVoCollection)this.columns.clone();
		if(this.templateroles == null)
			clone.templateroles = null;
		else
			clone.templateroles = (ims.ocrr.vo.TemplateRoleShortVoCollection)this.templateroles.clone();
		clone.formtext = this.formtext;
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
		if (!(OrderEntryTemplateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderEntryTemplateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OrderEntryTemplateVo compareObj = (OrderEntryTemplateVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OrderEntryTemplate() == null && compareObj.getID_OrderEntryTemplate() != null)
				return -1;
			if(this.getID_OrderEntryTemplate() != null && compareObj.getID_OrderEntryTemplate() == null)
				return 1;
			if(this.getID_OrderEntryTemplate() != null && compareObj.getID_OrderEntryTemplate() != null)
				retVal = this.getID_OrderEntryTemplate().compareTo(compareObj.getID_OrderEntryTemplate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.menuname != null)
			count++;
		if(this.description != null)
			count++;
		if(this.components != null)
			count++;
		if(this.templatecategory != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.templateslocations != null)
			count++;
		if(this.columns != null)
			count++;
		if(this.templateroles != null)
			count++;
		if(this.formtext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected String menuname;
	protected String description;
	protected ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection components;
	protected ims.ocrr.vo.lookups.TemplateCategories templatecategory;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.ocrr.vo.TemplateLocationShortVoCollection templateslocations;
	protected ims.ocrr.vo.OrderEntryTemplateColumnVoCollection columns;
	protected ims.ocrr.vo.TemplateRoleShortVoCollection templateroles;
	protected String formtext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
