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

package ims.emergency.vo;

/**
 * Linked to emergency.Configuration.TrackingArea business object (ID: 1087100001).
 */
public class TrackingAreaShortVo extends ims.emergency.configuration.vo.TrackingAreaRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingAreaShortVo()
	{
	}
	public TrackingAreaShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingAreaShortVo(ims.emergency.vo.beans.TrackingAreaShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.edlocation = bean.getEDLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getEDLocation().getId()), bean.getEDLocation().getVersion());
		this.areanamedescription = bean.getAreaNameDescription();
		this.areadisplayname = bean.getAreaDisplayName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isoverallview = bean.getIsOverallView();
		this.isregistrationarea = bean.getIsRegistrationArea();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingAreaShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.edlocation = bean.getEDLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getEDLocation().getId()), bean.getEDLocation().getVersion());
		this.areanamedescription = bean.getAreaNameDescription();
		this.areadisplayname = bean.getAreaDisplayName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.isoverallview = bean.getIsOverallView();
		this.isregistrationarea = bean.getIsRegistrationArea();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingAreaShortVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingAreaShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingAreaShortVoBean();
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
		if(fieldName.equals("EDLOCATION"))
			return getEDLocation();
		if(fieldName.equals("AREANAMEDESCRIPTION"))
			return getAreaNameDescription();
		if(fieldName.equals("AREADISPLAYNAME"))
			return getAreaDisplayName();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("ISOVERALLVIEW"))
			return getIsOverallView();
		if(fieldName.equals("ISREGISTRATIONAREA"))
			return getIsRegistrationArea();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEDLocationIsNotNull()
	{
		return this.edlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.edlocation = value;
	}
	public boolean getAreaNameDescriptionIsNotNull()
	{
		return this.areanamedescription != null;
	}
	public String getAreaNameDescription()
	{
		return this.areanamedescription;
	}
	public static int getAreaNameDescriptionMaxLength()
	{
		return 150;
	}
	public void setAreaNameDescription(String value)
	{
		this.isValidated = false;
		this.areanamedescription = value;
	}
	public boolean getAreaDisplayNameIsNotNull()
	{
		return this.areadisplayname != null;
	}
	public String getAreaDisplayName()
	{
		return this.areadisplayname;
	}
	public static int getAreaDisplayNameMaxLength()
	{
		return 15;
	}
	public void setAreaDisplayName(String value)
	{
		this.isValidated = false;
		this.areadisplayname = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getIsOverallViewIsNotNull()
	{
		return this.isoverallview != null;
	}
	public Boolean getIsOverallView()
	{
		return this.isoverallview;
	}
	public void setIsOverallView(Boolean value)
	{
		this.isValidated = false;
		this.isoverallview = value;
	}
	public boolean getIsRegistrationAreaIsNotNull()
	{
		return this.isregistrationarea != null;
	}
	public Boolean getIsRegistrationArea()
	{
		return this.isregistrationarea;
	}
	public void setIsRegistrationArea(Boolean value)
	{
		this.isValidated = false;
		this.isregistrationarea = value;
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
		if(this.edlocation == null)
			listOfErrors.add("EDLocation is mandatory");
		if(this.areanamedescription == null || this.areanamedescription.length() == 0)
			listOfErrors.add("AreaNameDescription is mandatory");
		else if(this.areanamedescription.length() > 150)
			listOfErrors.add("The length of the field [areanamedescription] in the value object [ims.emergency.vo.TrackingAreaShortVo] is too big. It should be less or equal to 150");
		if(this.areadisplayname == null || this.areadisplayname.length() == 0)
			listOfErrors.add("AreaDisplayName is mandatory");
		else if(this.areadisplayname.length() > 15)
			listOfErrors.add("The length of the field [areadisplayname] in the value object [ims.emergency.vo.TrackingAreaShortVo] is too big. It should be less or equal to 15");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.isoverallview == null)
			listOfErrors.add("isOverallView is mandatory");
		if(this.isregistrationarea == null)
			listOfErrors.add("isRegistrationArea is mandatory");
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
	
		TrackingAreaShortVo clone = new TrackingAreaShortVo(this.id, this.version);
		
		clone.edlocation = this.edlocation;
		clone.areanamedescription = this.areanamedescription;
		clone.areadisplayname = this.areadisplayname;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.isoverallview = this.isoverallview;
		clone.isregistrationarea = this.isregistrationarea;
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
		if (!(TrackingAreaShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingAreaShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingAreaShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingAreaShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.edlocation != null)
			count++;
		if(this.areanamedescription != null)
			count++;
		if(this.areadisplayname != null)
			count++;
		if(this.status != null)
			count++;
		if(this.isoverallview != null)
			count++;
		if(this.isregistrationarea != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.resource.place.vo.LocationRefVo edlocation;
	protected String areanamedescription;
	protected String areadisplayname;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected Boolean isoverallview;
	protected Boolean isregistrationarea;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
