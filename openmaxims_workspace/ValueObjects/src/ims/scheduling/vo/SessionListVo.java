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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionListVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionListVo()
	{
	}
	public SessionListVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionListVo(ims.scheduling.vo.beans.SessionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.bookingrights = ims.scheduling.vo.Session_BookingRightVoCollection.buildFromBeanCollection(bean.getBookingRights());
		this.description = bean.getDescription();
		this.isfixed = bean.getIsFixed();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.bookingrights = ims.scheduling.vo.Session_BookingRightVoCollection.buildFromBeanCollection(bean.getBookingRights());
		this.description = bean.getDescription();
		this.isfixed = bean.getIsFixed();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionListVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionListVoBean();
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
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("BOOKINGRIGHTS"))
			return getBookingRights();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ISFIXED"))
			return getIsFixed();
		return super.getFieldValueByFieldName(fieldName);
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationListVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationListVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getBookingRightsIsNotNull()
	{
		return this.bookingrights != null;
	}
	public ims.scheduling.vo.Session_BookingRightVoCollection getBookingRights()
	{
		return this.bookingrights;
	}
	public void setBookingRights(ims.scheduling.vo.Session_BookingRightVoCollection value)
	{
		this.isValidated = false;
		this.bookingrights = value;
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
	public boolean getIsFixedIsNotNull()
	{
		return this.isfixed != null;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isValidated = false;
		this.isfixed = value;
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.SessionListVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.SessionListVo] is too big. It should be less or equal to 255");
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
	
		SessionListVo clone = new SessionListVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationListVo)this.location.clone();
		if(this.bookingrights == null)
			clone.bookingrights = null;
		else
			clone.bookingrights = (ims.scheduling.vo.Session_BookingRightVoCollection)this.bookingrights.clone();
		clone.description = this.description;
		clone.isfixed = this.isfixed;
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
		if (!(SessionListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionListVo)obj).getBoId());
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
		if(this.location != null)
			count++;
		if(this.bookingrights != null)
			count++;
		if(this.description != null)
			count++;
		if(this.isfixed != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String name;
	protected ims.core.vo.LocationListVo location;
	protected ims.scheduling.vo.Session_BookingRightVoCollection bookingrights;
	protected String description;
	protected Boolean isfixed;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
