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
 * Linked to core.resource.people.ServiceContact business object (ID: 1006100002).
 */
public class ServiceContactVo extends ims.core.resource.people.vo.ServiceContactRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ServiceContactVo()
	{
	}
	public ServiceContactVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceContactVo(ims.core.vo.beans.ServiceContactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.contactnumber = bean.getContactNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ServiceContactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.contactnumber = bean.getContactNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ServiceContactVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ServiceContactVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ServiceContactVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("CONTACTNUMBER"))
			return getContactNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getContactNumberIsNotNull()
	{
		return this.contactnumber != null;
	}
	public String getContactNumber()
	{
		return this.contactnumber;
	}
	public static int getContactNumberMaxLength()
	{
		return 255;
	}
	public void setContactNumber(String value)
	{
		this.isValidated = false;
		this.contactnumber = value;
	}
	/**
	* toString()
	*/
	public String toString() 
	{
		StringBuffer strBuffer = new StringBuffer();
		if(this.name != null)
		{
			if(this.name.getForenameIsNotNull() && this.name.getSurnameIsNotNull())
			{
				strBuffer.append("Name: ");
				strBuffer.append(this.name.getForename() + " ");
				strBuffer.append(this.name.getSurname());
			}
		}
		if(this.contactnumber != null)
		{
			strBuffer.append(", Phone: ");
			strBuffer.append(this.contactnumber);
		}
			
		return strBuffer.toString();
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
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
	
		ServiceContactVo clone = new ServiceContactVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		clone.contactnumber = this.contactnumber;
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
		if (!(ServiceContactVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceContactVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ServiceContactVo compareObj = (ServiceContactVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ServiceContact() == null && compareObj.getID_ServiceContact() != null)
				return -1;
			if(this.getID_ServiceContact() != null && compareObj.getID_ServiceContact() == null)
				return 1;
			if(this.getID_ServiceContact() != null && compareObj.getID_ServiceContact() != null)
				retVal = this.getID_ServiceContact().compareTo(compareObj.getID_ServiceContact());
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
		if(this.contactnumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.PersonName name;
	protected String contactnumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
