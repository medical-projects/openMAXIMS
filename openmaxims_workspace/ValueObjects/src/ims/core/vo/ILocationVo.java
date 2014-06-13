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


public class ILocationVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.ILocation
{
	private static final long serialVersionUID = 1L;

	public ILocationVo()
	{
	}
	public ILocationVo(ims.core.vo.beans.ILocationVoBean bean)
	{
		this.name = bean.getName();
		this.id = bean.getId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ILocationVoBean bean)
	{
		this.name = bean.getName();
		this.id = bean.getId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ILocationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ILocationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ILocationVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getIdIsNotNull()
	{
		return this.id != null;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ILocationVo))
			return false;
		ILocationVo compareObj = (ILocationVo)obj;
		if(this.getName() == null && compareObj.getName() != null)
			return false;
		if(this.getName() != null && compareObj.getName() == null)
			return false;
		if(this.getName() != null && compareObj.getName() != null)
			return this.getName().equals(compareObj.getName());
		return super.equals(obj);
	}
	/**
	* ILocation implementation
	*/
	public int getID()
	{
		return this.getId() == null ? 0 : this.getId().intValue();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ILocationVo clone = new ILocationVo();
		
		clone.name = this.name;
		clone.id = this.id;
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
		if (!(ILocationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ILocationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ILocationVo compareObj = (ILocationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.id != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String name;
	protected Integer id;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
