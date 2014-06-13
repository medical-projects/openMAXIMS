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
 * Linked to core.resource.place.Activity business object (ID: 1007100005).
 */
public class ActivitySchedVo extends ims.core.vo.ActivityVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActivitySchedVo()
	{
	}
	public ActivitySchedVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActivitySchedVo(ims.core.vo.beans.ActivitySchedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.tmreq = bean.getTmReq();
		this.isactive = bean.getIsActive();
		this.activitytype = bean.getActivityType() == null ? null : ims.core.vo.lookups.ActivityType.buildLookup(bean.getActivityType());
		this.isworkqueue = bean.getIsWorkQueue();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ActivityStatus.buildLookup(bean.getStatus());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.firstappointment = bean.getFirstAppointment();
		this.diagnostic = bean.getDiagnostic();
		this.intreq = bean.getIntReq();
		this.ispatreq = bean.getIsPatReq();
		this.isscheduled = bean.getIsScheduled();
		this.reason = bean.getReason() == null ? null : ims.core.vo.lookups.ActivityReason.buildLookup(bean.getReason());
		this.activityimage = bean.getActivityImage() == null ? null : bean.getActivityImage().buildVo();
		this.specialrequirements = ims.core.vo.lookups.ActivitySpecRequirementsCollection.buildFromBeanCollection(bean.getSpecialRequirements());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ActivitySchedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.tmreq = bean.getTmReq();
		this.isactive = bean.getIsActive();
		this.activitytype = bean.getActivityType() == null ? null : ims.core.vo.lookups.ActivityType.buildLookup(bean.getActivityType());
		this.isworkqueue = bean.getIsWorkQueue();
		this.description = bean.getDescription();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ActivityStatus.buildLookup(bean.getStatus());
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.firstappointment = bean.getFirstAppointment();
		this.diagnostic = bean.getDiagnostic();
		this.intreq = bean.getIntReq();
		this.ispatreq = bean.getIsPatReq();
		this.isscheduled = bean.getIsScheduled();
		this.reason = bean.getReason() == null ? null : ims.core.vo.lookups.ActivityReason.buildLookup(bean.getReason());
		this.activityimage = bean.getActivityImage() == null ? null : bean.getActivityImage().buildVo(map);
		this.specialrequirements = ims.core.vo.lookups.ActivitySpecRequirementsCollection.buildFromBeanCollection(bean.getSpecialRequirements());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ActivitySchedVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ActivitySchedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ActivitySchedVoBean();
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
		if(fieldName.equals("INTREQ"))
			return getIntReq();
		if(fieldName.equals("ISPATREQ"))
			return getIsPatReq();
		if(fieldName.equals("ISSCHEDULED"))
			return getIsScheduled();
		if(fieldName.equals("REASON"))
			return getReason();
		if(fieldName.equals("ACTIVITYIMAGE"))
			return getActivityImage();
		if(fieldName.equals("SPECIALREQUIREMENTS"))
			return getSpecialRequirements();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIntReqIsNotNull()
	{
		return this.intreq != null;
	}
	public Integer getIntReq()
	{
		return this.intreq;
	}
	public void setIntReq(Integer value)
	{
		this.isValidated = false;
		this.intreq = value;
	}
	public boolean getIsPatReqIsNotNull()
	{
		return this.ispatreq != null;
	}
	public Boolean getIsPatReq()
	{
		return this.ispatreq;
	}
	public void setIsPatReq(Boolean value)
	{
		this.isValidated = false;
		this.ispatreq = value;
	}
	public boolean getIsScheduledIsNotNull()
	{
		return this.isscheduled != null;
	}
	public Boolean getIsScheduled()
	{
		return this.isscheduled;
	}
	public void setIsScheduled(Boolean value)
	{
		this.isValidated = false;
		this.isscheduled = value;
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public ims.core.vo.lookups.ActivityReason getReason()
	{
		return this.reason;
	}
	public void setReason(ims.core.vo.lookups.ActivityReason value)
	{
		this.isValidated = false;
		this.reason = value;
	}
	public boolean getActivityImageIsNotNull()
	{
		return this.activityimage != null;
	}
	public ims.admin.vo.AppImageVo getActivityImage()
	{
		return this.activityimage;
	}
	public void setActivityImage(ims.admin.vo.AppImageVo value)
	{
		this.isValidated = false;
		this.activityimage = value;
	}
	public boolean getSpecialRequirementsIsNotNull()
	{
		return this.specialrequirements != null;
	}
	public ims.core.vo.lookups.ActivitySpecRequirementsCollection getSpecialRequirements()
	{
		return this.specialrequirements;
	}
	public void setSpecialRequirements(ims.core.vo.lookups.ActivitySpecRequirementsCollection value)
	{
		this.isValidated = false;
		this.specialrequirements = value;
	}
	/**
	* toString()
	*/
	public String toString()
	{
		return super.toString();
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
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activityimage != null)
		{
			if(!this.activityimage.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.ActivitySchedVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.core.vo.ActivitySchedVo] is too big. It should be less or equal to 255");
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activityimage != null)
		{
			String[] listOfOtherErrors = this.activityimage.validate();
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
	
		ActivitySchedVo clone = new ActivitySchedVo(this.id, this.version);
		
		clone.name = this.name;
		clone.tmreq = this.tmreq;
		clone.isactive = this.isactive;
		if(this.activitytype == null)
			clone.activitytype = null;
		else
			clone.activitytype = (ims.core.vo.lookups.ActivityType)this.activitytype.clone();
		clone.isworkqueue = this.isworkqueue;
		clone.description = this.description;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.ActivityStatus)this.status.clone();
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		clone.firstappointment = this.firstappointment;
		clone.diagnostic = this.diagnostic;
		clone.intreq = this.intreq;
		clone.ispatreq = this.ispatreq;
		clone.isscheduled = this.isscheduled;
		if(this.reason == null)
			clone.reason = null;
		else
			clone.reason = (ims.core.vo.lookups.ActivityReason)this.reason.clone();
		if(this.activityimage == null)
			clone.activityimage = null;
		else
			clone.activityimage = (ims.admin.vo.AppImageVo)this.activityimage.clone();
		if(this.specialrequirements == null)
			clone.specialrequirements = null;
		else
			clone.specialrequirements = (ims.core.vo.lookups.ActivitySpecRequirementsCollection)this.specialrequirements.clone();
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
		if (!(ActivitySchedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActivitySchedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ActivitySchedVo compareObj = (ActivitySchedVo)obj;
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
		int count = super.countFieldsWithValue();
		if(this.intreq != null)
			count++;
		if(this.ispatreq != null)
			count++;
		if(this.isscheduled != null)
			count++;
		if(this.reason != null)
			count++;
		if(this.activityimage != null)
			count++;
		if(this.specialrequirements != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected Integer intreq;
	protected Boolean ispatreq;
	protected Boolean isscheduled;
	protected ims.core.vo.lookups.ActivityReason reason;
	protected ims.admin.vo.AppImageVo activityimage;
	protected ims.core.vo.lookups.ActivitySpecRequirementsCollection specialrequirements;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
