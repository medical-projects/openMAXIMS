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
 * Linked to Scheduling.Session_Slot business object (ID: 1055100016).
 */
public class SessionSlotClinicListListVo extends ims.scheduling.vo.Session_SlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionSlotClinicListListVo()
	{
	}
	public SessionSlotClinicListListVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionSlotClinicListListVo(ims.scheduling.vo.beans.SessionSlotClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
		this.activity = bean.getActivity() == null ? null : new ims.core.resource.place.vo.ActivityRefVo(new Integer(bean.getActivity().getId()), bean.getActivity().getVersion());
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionSlotClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
		this.activity = bean.getActivity() == null ? null : new ims.core.resource.place.vo.ActivityRefVo(new Integer(bean.getActivity().getId()), bean.getActivity().getVersion());
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionSlotClinicListListVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionSlotClinicListListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionSlotClinicListListVoBean();
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
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("SESSION"))
			return getSession();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartTmIsNotNull()
	{
		return this.starttm != null;
	}
	public ims.framework.utils.Time getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttm = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.scheduling.vo.lookups.SchedulingPriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.scheduling.vo.lookups.SchedulingPriority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.BookingAppointmentClinicListListVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.BookingAppointmentClinicListListVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.resource.place.vo.ActivityRefVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.resource.place.vo.ActivityRefVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.SessionClinicListListVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.SessionClinicListListVo value)
	{
		this.isValidated = false;
		this.session = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		SessionSlotClinicListListVo clone = new SessionSlotClinicListListVo(this.id, this.version);
		
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.scheduling.vo.BookingAppointmentClinicListListVo)this.appointment.clone();
		clone.activity = this.activity;
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.scheduling.vo.SessionClinicListListVo)this.session.clone();
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
		if (!(SessionSlotClinicListListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionSlotClinicListListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SessionSlotClinicListListVo compareObj = (SessionSlotClinicListListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStartTm() == null && compareObj.getStartTm() != null)
				return -1;
			if(this.getStartTm() != null && compareObj.getStartTm() == null)
				return 1;
			if(this.getStartTm() != null && compareObj.getStartTm() != null)
				retVal = this.getStartTm().compareTo(compareObj.getStartTm());
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
		if(this.starttm != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.status != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.session != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.Time starttm;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected ims.scheduling.vo.lookups.Status_Reason status;
	protected ims.scheduling.vo.BookingAppointmentClinicListListVo appointment;
	protected ims.core.resource.place.vo.ActivityRefVo activity;
	protected ims.scheduling.vo.SessionClinicListListVo session;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
