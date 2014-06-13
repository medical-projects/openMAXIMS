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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.Configuration.TumourCategory business object (ID: 1074100008).
 */
public class TumourCategoryListVo extends ims.oncology.configuration.vo.TumourCategoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourCategoryListVo()
	{
	}
	public TumourCategoryListVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourCategoryListVo(ims.clinicaladmin.vo.beans.TumourCategoryListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.categoryname = bean.getCategoryName();
		this.categorydescription = bean.getCategoryDescription();
		this.isactive = bean.getIsActive();
		if(bean.getVersionGroups() != null)
		{
			this.versiongroups = new ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVoCollection();
			for(int versiongroups_i = 0; versiongroups_i < bean.getVersionGroups().length; versiongroups_i++)
			{
				this.versiongroups.add(new ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVo(new Integer(bean.getVersionGroups()[versiongroups_i].getId()), bean.getVersionGroups()[versiongroups_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourCategoryListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.categoryname = bean.getCategoryName();
		this.categorydescription = bean.getCategoryDescription();
		this.isactive = bean.getIsActive();
		if(bean.getVersionGroups() != null)
		{
			this.versiongroups = new ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVoCollection();
			for(int versiongroups_i = 0; versiongroups_i < bean.getVersionGroups().length; versiongroups_i++)
			{
				this.versiongroups.add(new ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVo(new Integer(bean.getVersionGroups()[versiongroups_i].getId()), bean.getVersionGroups()[versiongroups_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourCategoryListVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourCategoryListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourCategoryListVoBean();
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
		if(fieldName.equals("CATEGORYNAME"))
			return getCategoryName();
		if(fieldName.equals("CATEGORYDESCRIPTION"))
			return getCategoryDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("VERSIONGROUPS"))
			return getVersionGroups();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCategoryNameIsNotNull()
	{
		return this.categoryname != null;
	}
	public String getCategoryName()
	{
		return this.categoryname;
	}
	public static int getCategoryNameMaxLength()
	{
		return 255;
	}
	public void setCategoryName(String value)
	{
		this.isValidated = false;
		this.categoryname = value;
	}
	public boolean getCategoryDescriptionIsNotNull()
	{
		return this.categorydescription != null;
	}
	public String getCategoryDescription()
	{
		return this.categorydescription;
	}
	public static int getCategoryDescriptionMaxLength()
	{
		return 255;
	}
	public void setCategoryDescription(String value)
	{
		this.isValidated = false;
		this.categorydescription = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getVersionGroupsIsNotNull()
	{
		return this.versiongroups != null;
	}
	public ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVoCollection getVersionGroups()
	{
		return this.versiongroups;
	}
	public void setVersionGroups(ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVoCollection value)
	{
		this.isValidated = false;
		this.versiongroups = value;
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
		if(this.categoryname == null || this.categoryname.length() == 0)
			listOfErrors.add("CategoryName is mandatory");
		else if(this.categoryname.length() > 255)
			listOfErrors.add("The length of the field [categoryname] in the value object [ims.clinicaladmin.vo.TumourCategoryListVo] is too big. It should be less or equal to 255");
		if(this.categorydescription != null)
			if(this.categorydescription.length() > 255)
				listOfErrors.add("The length of the field [categorydescription] in the value object [ims.clinicaladmin.vo.TumourCategoryListVo] is too big. It should be less or equal to 255");
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
	
		TumourCategoryListVo clone = new TumourCategoryListVo(this.id, this.version);
		
		clone.categoryname = this.categoryname;
		clone.categorydescription = this.categorydescription;
		clone.isactive = this.isactive;
		clone.versiongroups = this.versiongroups;
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
		if (!(TumourCategoryListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourCategoryListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourCategoryListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourCategoryListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.categoryname != null)
			count++;
		if(this.categorydescription != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.versiongroups != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String categoryname;
	protected String categorydescription;
	protected Boolean isactive;
	protected ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVoCollection versiongroups;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
