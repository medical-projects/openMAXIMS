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

package ims.pathways.vo;

/**
 * Linked to Pathways.PatientEvent business object (ID: 1088100002).
 */
public class PatientJourneyEventInterfaceVo extends ims.pathways.vo.PatientEventRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPatientJourneyEvent
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyEventInterfaceVo()
	{
	}
	public PatientJourneyEventInterfaceVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientJourneyEventInterfaceVo(ims.pathways.vo.beans.PatientJourneyEventInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.patienttarget = bean.getPatientTarget() == null ? null : bean.getPatientTarget().buildVo();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.cliniccode = bean.getClinicCode();
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
		this.eventstatus = bean.getEventStatus() == null ? null : ims.pathways.vo.lookups.EventStatus.buildLookup(bean.getEventStatus());
		this.description = bean.getDescription();
		this.isvirtual = bean.getIsVirtual();
		this.clinicname = bean.getClinicName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneyEventInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.event = bean.getEvent() == null ? null : bean.getEvent().buildVo(map);
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.patienttarget = bean.getPatientTarget() == null ? null : bean.getPatientTarget().buildVo(map);
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.cliniccode = bean.getClinicCode();
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
		this.eventstatus = bean.getEventStatus() == null ? null : ims.pathways.vo.lookups.EventStatus.buildLookup(bean.getEventStatus());
		this.description = bean.getDescription();
		this.isvirtual = bean.getIsVirtual();
		this.clinicname = bean.getClinicName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneyEventInterfaceVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneyEventInterfaceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneyEventInterfaceVoBean();
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
		if(fieldName.equals("EVENT"))
			return getEvent();
		if(fieldName.equals("EVENTDATETIME"))
			return getEventDateTime();
		if(fieldName.equals("PATIENTTARGET"))
			return getPatientTarget();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("CLINICCODE"))
			return getClinicCode();
		if(fieldName.equals("SCHEDULEDDATE"))
			return getScheduledDate();
		if(fieldName.equals("EVENTSTATUS"))
			return getEventStatus();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ISVIRTUAL"))
			return getIsVirtual();
		if(fieldName.equals("CLINICNAME"))
			return getClinicName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEventIsNotNull()
	{
		return this.event != null;
	}
	public ims.pathways.vo.EventLiteVo getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.EventLiteVo value)
	{
		this.isValidated = false;
		this.event = value;
	}
	public boolean getEventDateTimeIsNotNull()
	{
		return this.eventdatetime != null;
	}
	public ims.framework.utils.DateTime getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.eventdatetime = value;
	}
	public boolean getPatientTargetIsNotNull()
	{
		return this.patienttarget != null;
	}
	public ims.pathways.vo.PatientJourneyJourneyTargetInterfaceVo getPatientTarget()
	{
		return this.patienttarget;
	}
	public void setPatientTarget(ims.pathways.vo.PatientJourneyJourneyTargetInterfaceVo value)
	{
		this.isValidated = false;
		this.patienttarget = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getClinicCodeIsNotNull()
	{
		return this.cliniccode != null;
	}
	public String getClinicCode()
	{
		return this.cliniccode;
	}
	public static int getClinicCodeMaxLength()
	{
		return 255;
	}
	public void setClinicCode(String value)
	{
		this.isValidated = false;
		this.cliniccode = value;
	}
	public boolean getScheduledDateIsNotNull()
	{
		return this.scheduleddate != null;
	}
	public ims.framework.utils.DateTime getScheduledDate()
	{
		return this.scheduleddate;
	}
	public void setScheduledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.scheduleddate = value;
	}
	public boolean getEventStatusIsNotNull()
	{
		return this.eventstatus != null;
	}
	public ims.pathways.vo.lookups.EventStatus getEventStatus()
	{
		return this.eventstatus;
	}
	public void setEventStatus(ims.pathways.vo.lookups.EventStatus value)
	{
		this.isValidated = false;
		this.eventstatus = value;
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
		return 2000;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getIsVirtualIsNotNull()
	{
		return this.isvirtual != null;
	}
	public Boolean getIsVirtual()
	{
		return this.isvirtual;
	}
	public void setIsVirtual(Boolean value)
	{
		this.isValidated = false;
		this.isvirtual = value;
	}
	public boolean getClinicNameIsNotNull()
	{
		return this.clinicname != null;
	}
	public String getClinicName()
	{
		return this.clinicname;
	}
	public static int getClinicNameMaxLength()
	{
		return 255;
	}
	public void setClinicName(String value)
	{
		this.isValidated = false;
		this.clinicname = value;
	}
	/**
	* IPatientJourneyEvent
	*/
	public String getIPatientJourneyEventConsultant() 
	{
		return consultant == null ? "" : consultant.toString();
	}
	public ims.framework.utils.DateTime getIPatientJourneyEventDateTime() 
	{
		return eventdatetime;
	}
	public String getIPatientJourneyEventDescription() 
	{
		return description;
	}
	public ims.framework.utils.Image getIPatientJourneyEventImage() 
	{
		return event.getIcon();
	}
	public String getIPatientJourneyEventName() 
	{
		if(event == null || event.getName() == null)
			return "";
		
		return this.event.getName();
	}
	public String getIPatientJourneyEventSpecialty() 
	{
		return specialty == null ? "" : specialty.toString();
	}
	public ims.vo.interfaces.IPatientJourneyTarget getIPatientJourneyEventTarget() 
	{
		return patienttarget;
	}
	public Integer getIPatientJourneyEventWeekNumber(ims.framework.utils.Date startDate) 
	{
		if(eventdatetime == null)
			if(startDate == null)
				throw new ims.framework.exceptions.CodingRuntimeException("Invalid event date");
		if(startDate == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid start date");
		
		long current = eventdatetime.getDate().getDate().getTime();
		long start = startDate.getDate().getTime();			
		long noDays = (current - start) / (1000*60*60*24);
					
		return ((int)noDays / 7) + 1;
	}
	public String getIPatientJourneyEventCliniCode() 
	{
		return cliniccode == null ? "" : cliniccode;
	}
	public ims.framework.utils.DateTime getIPatientJourneyEventScheduledDateTime() 
	{
		return scheduleddate;
	}
	public ims.pathways.vo.lookups.EventStatus getIPatientJourneyEventStatus() 
	{
		return eventstatus; 
	}
	public ims.vo.interfaces.IPatientJourneyClock getIPatientJourneyEventClock() 
	{
		return patienttarget == null ? null : patienttarget.getJourneyClock();
	}
	public Boolean getIPatientJourneyEventIsVirtual ()
	{
		return isvirtual;
	}
	public String getIPatientJourneyEventClinicName ()
	{
		return clinicname;
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
		if(this.event != null)
		{
			if(!this.event.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patienttarget != null)
		{
			if(!this.patienttarget.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultant != null)
		{
			if(!this.consultant.isValidated())
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
		if(this.event == null)
			listOfErrors.add("Event is mandatory");
		if(this.event != null)
		{
			String[] listOfOtherErrors = this.event.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patienttarget != null)
		{
			String[] listOfOtherErrors = this.patienttarget.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultant != null)
		{
			String[] listOfOtherErrors = this.consultant.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.description != null)
			if(this.description.length() > 2000)
				listOfErrors.add("The length of the field [description] in the value object [ims.pathways.vo.PatientJourneyEventInterfaceVo] is too big. It should be less or equal to 2000");
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
	
		PatientJourneyEventInterfaceVo clone = new PatientJourneyEventInterfaceVo(this.id, this.version);
		
		if(this.event == null)
			clone.event = null;
		else
			clone.event = (ims.pathways.vo.EventLiteVo)this.event.clone();
		if(this.eventdatetime == null)
			clone.eventdatetime = null;
		else
			clone.eventdatetime = (ims.framework.utils.DateTime)this.eventdatetime.clone();
		if(this.patienttarget == null)
			clone.patienttarget = null;
		else
			clone.patienttarget = (ims.pathways.vo.PatientJourneyJourneyTargetInterfaceVo)this.patienttarget.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		clone.cliniccode = this.cliniccode;
		if(this.scheduleddate == null)
			clone.scheduleddate = null;
		else
			clone.scheduleddate = (ims.framework.utils.DateTime)this.scheduleddate.clone();
		if(this.eventstatus == null)
			clone.eventstatus = null;
		else
			clone.eventstatus = (ims.pathways.vo.lookups.EventStatus)this.eventstatus.clone();
		clone.description = this.description;
		clone.isvirtual = this.isvirtual;
		clone.clinicname = this.clinicname;
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
		if (!(PatientJourneyEventInterfaceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientJourneyEventInterfaceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientJourneyEventInterfaceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientJourneyEventInterfaceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.event != null)
			count++;
		if(this.eventdatetime != null)
			count++;
		if(this.patienttarget != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.cliniccode != null)
			count++;
		if(this.scheduleddate != null)
			count++;
		if(this.eventstatus != null)
			count++;
		if(this.description != null)
			count++;
		if(this.isvirtual != null)
			count++;
		if(this.clinicname != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.pathways.vo.EventLiteVo event;
	protected ims.framework.utils.DateTime eventdatetime;
	protected ims.pathways.vo.PatientJourneyJourneyTargetInterfaceVo patienttarget;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.HcpLiteVo consultant;
	protected String cliniccode;
	protected ims.framework.utils.DateTime scheduleddate;
	protected ims.pathways.vo.lookups.EventStatus eventstatus;
	protected String description;
	protected Boolean isvirtual;
	protected String clinicname;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
