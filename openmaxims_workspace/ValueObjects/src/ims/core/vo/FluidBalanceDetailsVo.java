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
 * Linked to core.vitals.Fluids Balance Details business object (ID: 1022100017).
 */
public class FluidBalanceDetailsVo extends ims.core.vitals.vo.FluidsBalanceDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FluidBalanceDetailsVo()
	{
	}
	public FluidBalanceDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public FluidBalanceDetailsVo(ims.core.vo.beans.FluidBalanceDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.FluidBalanceType.buildLookup(bean.getType());
		this.value = bean.getValue();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.FluidBalanceDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.FluidBalanceType.buildLookup(bean.getType());
		this.value = bean.getValue();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.FluidBalanceDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.FluidBalanceDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.FluidBalanceDetailsVoBean();
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
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("VALUE"))
			return getValue();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.core.vo.lookups.FluidBalanceType getType()
	{
		return this.type;
	}
	public void setType(ims.core.vo.lookups.FluidBalanceType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getValueIsNotNull()
	{
		return this.value != null;
	}
	public Integer getValue()
	{
		return this.value;
	}
	public void setValue(Integer value)
	{
		this.isValidated = false;
		this.value = value;
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
	
		FluidBalanceDetailsVo clone = new FluidBalanceDetailsVo(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.FluidBalanceType)this.type.clone();
		clone.value = this.value;
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
		if (!(FluidBalanceDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FluidBalanceDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FluidBalanceDetailsVo compareObj = (FluidBalanceDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_FluidsBalanceDetails() == null && compareObj.getID_FluidsBalanceDetails() != null)
				return -1;
			if(this.getID_FluidsBalanceDetails() != null && compareObj.getID_FluidsBalanceDetails() == null)
				return 1;
			if(this.getID_FluidsBalanceDetails() != null && compareObj.getID_FluidsBalanceDetails() != null)
				retVal = this.getID_FluidsBalanceDetails().compareTo(compareObj.getID_FluidsBalanceDetails());
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
		if(this.type != null)
			count++;
		if(this.value != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.FluidBalanceType type;
	protected Integer value;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
