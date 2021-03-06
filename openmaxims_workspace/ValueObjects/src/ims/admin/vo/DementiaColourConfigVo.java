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

package ims.admin.vo;

/**
 * Linked to core.admin.DementiaColourConfig business object (ID: 1004100058).
 */
public class DementiaColourConfigVo extends ims.core.admin.vo.DementiaColourConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DementiaColourConfigVo()
	{
	}
	public DementiaColourConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public DementiaColourConfigVo(ims.admin.vo.beans.DementiaColourConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.fromhours = bean.getFromHours();
		this.tohours = bean.getToHours();
		this.worklistentrycolour = bean.getWorklistEntryColour() == null ? null : bean.getWorklistEntryColour().buildColor();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.DementiaColourConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.fromhours = bean.getFromHours();
		this.tohours = bean.getToHours();
		this.worklistentrycolour = bean.getWorklistEntryColour() == null ? null : bean.getWorklistEntryColour().buildColor();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.DementiaColourConfigVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.DementiaColourConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.DementiaColourConfigVoBean();
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
		if(fieldName.equals("FROMHOURS"))
			return getFromHours();
		if(fieldName.equals("TOHOURS"))
			return getToHours();
		if(fieldName.equals("WORKLISTENTRYCOLOUR"))
			return getWorklistEntryColour();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFromHoursIsNotNull()
	{
		return this.fromhours != null;
	}
	public Integer getFromHours()
	{
		return this.fromhours;
	}
	public void setFromHours(Integer value)
	{
		this.isValidated = false;
		this.fromhours = value;
	}
	public boolean getToHoursIsNotNull()
	{
		return this.tohours != null;
	}
	public Integer getToHours()
	{
		return this.tohours;
	}
	public void setToHours(Integer value)
	{
		this.isValidated = false;
		this.tohours = value;
	}
	public boolean getWorklistEntryColourIsNotNull()
	{
		return this.worklistentrycolour != null;
	}
	public ims.framework.utils.Color getWorklistEntryColour()
	{
		return this.worklistentrycolour;
	}
	public void setWorklistEntryColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.worklistentrycolour = value;
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
		if(this.fromhours == null)
			listOfErrors.add("'Start (hours)' is mandatory!");
		if(this.tohours == null)
			listOfErrors.add("'End (hours)' is mandatory!");
		if(this.worklistentrycolour == null)
			listOfErrors.add("'Colour' is mandatory!");
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
	
		DementiaColourConfigVo clone = new DementiaColourConfigVo(this.id, this.version);
		
		clone.fromhours = this.fromhours;
		clone.tohours = this.tohours;
		if(this.worklistentrycolour == null)
			clone.worklistentrycolour = null;
		else
			clone.worklistentrycolour = (ims.framework.utils.Color)this.worklistentrycolour.clone();
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
		if (!(DementiaColourConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DementiaColourConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DementiaColourConfigVo compareObj = (DementiaColourConfigVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getFromHours() == null && compareObj.getFromHours() != null)
				return -1;
			if(this.getFromHours() != null && compareObj.getFromHours() == null)
				return 1;
			if(this.getFromHours() != null && compareObj.getFromHours() != null)
				retVal = this.getFromHours().compareTo(compareObj.getFromHours());
		}
		if (retVal == 0)
		{
			if(this.getToHours() == null && compareObj.getToHours() != null)
				return -1;
			if(this.getToHours() != null && compareObj.getToHours() == null)
				return 1;
			if(this.getToHours() != null && compareObj.getToHours() != null)
				retVal = this.getToHours().compareTo(compareObj.getToHours());
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
		if(this.fromhours != null)
			count++;
		if(this.tohours != null)
			count++;
		if(this.worklistentrycolour != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer fromhours;
	protected Integer tohours;
	protected ims.framework.utils.Color worklistentrycolour;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
