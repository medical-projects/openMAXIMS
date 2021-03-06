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
 * Linked to Pathways.Configuration.AppointmentOutcomeConfig business object (ID: 1004100065).
 */
public class AppointmentOutcomeConfigVo extends ims.pathways.configuration.vo.AppointmentOutcomeConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppointmentOutcomeConfigVo()
	{
	}
	public AppointmentOutcomeConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppointmentOutcomeConfigVo(ims.admin.vo.beans.AppointmentOutcomeConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentoutcomereasons = ims.admin.vo.AppointmentOutcomeReasonVoCollection.buildFromBeanCollection(bean.getAppointmentOutcomeReasons());
		this.showfirstdefinitivetreatment = bean.getShowFirstDefinitiveTreatment();
		this.canaddtowaitinglist = bean.getCanAddtoWaitingList();
		this.canaddtobookedlist = bean.getCanAddtoBookedList();
		this.canaddtoplannedlist = bean.getCanAddtoPlannedList();
		this.canmakeappointment = bean.getCanMakeAppointment();
		this.canmakeonwardreferral = bean.getCanMakeOnwardReferral();
		this.cantransfer = bean.getCanTransfer();
		this.appointmentoutcome = bean.getAppointmentOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getAppointmentOutcome());
		this.firstdefinitivetreatmentevent = bean.getFirstDefinitiveTreatmentEvent() == null ? null : bean.getFirstDefinitiveTreatmentEvent().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppointmentOutcomeConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentoutcomereasons = ims.admin.vo.AppointmentOutcomeReasonVoCollection.buildFromBeanCollection(bean.getAppointmentOutcomeReasons());
		this.showfirstdefinitivetreatment = bean.getShowFirstDefinitiveTreatment();
		this.canaddtowaitinglist = bean.getCanAddtoWaitingList();
		this.canaddtobookedlist = bean.getCanAddtoBookedList();
		this.canaddtoplannedlist = bean.getCanAddtoPlannedList();
		this.canmakeappointment = bean.getCanMakeAppointment();
		this.canmakeonwardreferral = bean.getCanMakeOnwardReferral();
		this.cantransfer = bean.getCanTransfer();
		this.appointmentoutcome = bean.getAppointmentOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getAppointmentOutcome());
		this.firstdefinitivetreatmentevent = bean.getFirstDefinitiveTreatmentEvent() == null ? null : bean.getFirstDefinitiveTreatmentEvent().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppointmentOutcomeConfigVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppointmentOutcomeConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppointmentOutcomeConfigVoBean();
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
		if(fieldName.equals("APPOINTMENTOUTCOMEREASONS"))
			return getAppointmentOutcomeReasons();
		if(fieldName.equals("SHOWFIRSTDEFINITIVETREATMENT"))
			return getShowFirstDefinitiveTreatment();
		if(fieldName.equals("CANADDTOWAITINGLIST"))
			return getCanAddtoWaitingList();
		if(fieldName.equals("CANADDTOBOOKEDLIST"))
			return getCanAddtoBookedList();
		if(fieldName.equals("CANADDTOPLANNEDLIST"))
			return getCanAddtoPlannedList();
		if(fieldName.equals("CANMAKEAPPOINTMENT"))
			return getCanMakeAppointment();
		if(fieldName.equals("CANMAKEONWARDREFERRAL"))
			return getCanMakeOnwardReferral();
		if(fieldName.equals("CANTRANSFER"))
			return getCanTransfer();
		if(fieldName.equals("APPOINTMENTOUTCOME"))
			return getAppointmentOutcome();
		if(fieldName.equals("FIRSTDEFINITIVETREATMENTEVENT"))
			return getFirstDefinitiveTreatmentEvent();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentOutcomeReasonsIsNotNull()
	{
		return this.appointmentoutcomereasons != null;
	}
	public ims.admin.vo.AppointmentOutcomeReasonVoCollection getAppointmentOutcomeReasons()
	{
		return this.appointmentoutcomereasons;
	}
	public void setAppointmentOutcomeReasons(ims.admin.vo.AppointmentOutcomeReasonVoCollection value)
	{
		this.isValidated = false;
		this.appointmentoutcomereasons = value;
	}
	public boolean getShowFirstDefinitiveTreatmentIsNotNull()
	{
		return this.showfirstdefinitivetreatment != null;
	}
	public Boolean getShowFirstDefinitiveTreatment()
	{
		return this.showfirstdefinitivetreatment;
	}
	public void setShowFirstDefinitiveTreatment(Boolean value)
	{
		this.isValidated = false;
		this.showfirstdefinitivetreatment = value;
	}
	public boolean getCanAddtoWaitingListIsNotNull()
	{
		return this.canaddtowaitinglist != null;
	}
	public Boolean getCanAddtoWaitingList()
	{
		return this.canaddtowaitinglist;
	}
	public void setCanAddtoWaitingList(Boolean value)
	{
		this.isValidated = false;
		this.canaddtowaitinglist = value;
	}
	public boolean getCanAddtoBookedListIsNotNull()
	{
		return this.canaddtobookedlist != null;
	}
	public Boolean getCanAddtoBookedList()
	{
		return this.canaddtobookedlist;
	}
	public void setCanAddtoBookedList(Boolean value)
	{
		this.isValidated = false;
		this.canaddtobookedlist = value;
	}
	public boolean getCanAddtoPlannedListIsNotNull()
	{
		return this.canaddtoplannedlist != null;
	}
	public Boolean getCanAddtoPlannedList()
	{
		return this.canaddtoplannedlist;
	}
	public void setCanAddtoPlannedList(Boolean value)
	{
		this.isValidated = false;
		this.canaddtoplannedlist = value;
	}
	public boolean getCanMakeAppointmentIsNotNull()
	{
		return this.canmakeappointment != null;
	}
	public Boolean getCanMakeAppointment()
	{
		return this.canmakeappointment;
	}
	public void setCanMakeAppointment(Boolean value)
	{
		this.isValidated = false;
		this.canmakeappointment = value;
	}
	public boolean getCanMakeOnwardReferralIsNotNull()
	{
		return this.canmakeonwardreferral != null;
	}
	public Boolean getCanMakeOnwardReferral()
	{
		return this.canmakeonwardreferral;
	}
	public void setCanMakeOnwardReferral(Boolean value)
	{
		this.isValidated = false;
		this.canmakeonwardreferral = value;
	}
	public boolean getCanTransferIsNotNull()
	{
		return this.cantransfer != null;
	}
	public Boolean getCanTransfer()
	{
		return this.cantransfer;
	}
	public void setCanTransfer(Boolean value)
	{
		this.isValidated = false;
		this.cantransfer = value;
	}
	public boolean getAppointmentOutcomeIsNotNull()
	{
		return this.appointmentoutcome != null;
	}
	public ims.scheduling.vo.lookups.ApptOutcome getAppointmentOutcome()
	{
		return this.appointmentoutcome;
	}
	public void setAppointmentOutcome(ims.scheduling.vo.lookups.ApptOutcome value)
	{
		this.isValidated = false;
		this.appointmentoutcome = value;
	}
	public boolean getFirstDefinitiveTreatmentEventIsNotNull()
	{
		return this.firstdefinitivetreatmentevent != null;
	}
	public ims.pathways.vo.EventLiteVo getFirstDefinitiveTreatmentEvent()
	{
		return this.firstdefinitivetreatmentevent;
	}
	public void setFirstDefinitiveTreatmentEvent(ims.pathways.vo.EventLiteVo value)
	{
		this.isValidated = false;
		this.firstdefinitivetreatmentevent = value;
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
		if(this.appointmentoutcomereasons != null)
		{
			if(!this.appointmentoutcomereasons.isValidated())
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
		if(this.appointmentoutcomereasons != null)
		{
			String[] listOfOtherErrors = this.appointmentoutcomereasons.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.showfirstdefinitivetreatment == null)
			listOfErrors.add("ShowFirstDefinitiveTreatment is mandatory");
		if(this.canaddtowaitinglist == null)
			listOfErrors.add("CanAddtoWaitingList is mandatory");
		if(this.canaddtobookedlist == null)
			listOfErrors.add("CanAddtoBookedList is mandatory");
		if(this.canaddtoplannedlist == null)
			listOfErrors.add("CanAddtoPlannedList is mandatory");
		if(this.canmakeappointment == null)
			listOfErrors.add("CanMakeAppointment is mandatory");
		if(this.canmakeonwardreferral == null)
			listOfErrors.add("CanMakeOnwardReferral is mandatory");
		if(this.cantransfer == null)
			listOfErrors.add("CanTransfer is mandatory");
		if(this.appointmentoutcome == null)
			listOfErrors.add("AppointmentOutcome is mandatory");
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
	
		AppointmentOutcomeConfigVo clone = new AppointmentOutcomeConfigVo(this.id, this.version);
		
		if(this.appointmentoutcomereasons == null)
			clone.appointmentoutcomereasons = null;
		else
			clone.appointmentoutcomereasons = (ims.admin.vo.AppointmentOutcomeReasonVoCollection)this.appointmentoutcomereasons.clone();
		clone.showfirstdefinitivetreatment = this.showfirstdefinitivetreatment;
		clone.canaddtowaitinglist = this.canaddtowaitinglist;
		clone.canaddtobookedlist = this.canaddtobookedlist;
		clone.canaddtoplannedlist = this.canaddtoplannedlist;
		clone.canmakeappointment = this.canmakeappointment;
		clone.canmakeonwardreferral = this.canmakeonwardreferral;
		clone.cantransfer = this.cantransfer;
		if(this.appointmentoutcome == null)
			clone.appointmentoutcome = null;
		else
			clone.appointmentoutcome = (ims.scheduling.vo.lookups.ApptOutcome)this.appointmentoutcome.clone();
		if(this.firstdefinitivetreatmentevent == null)
			clone.firstdefinitivetreatmentevent = null;
		else
			clone.firstdefinitivetreatmentevent = (ims.pathways.vo.EventLiteVo)this.firstdefinitivetreatmentevent.clone();
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
		if (!(AppointmentOutcomeConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppointmentOutcomeConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppointmentOutcomeConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppointmentOutcomeConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.appointmentoutcomereasons != null)
			count++;
		if(this.showfirstdefinitivetreatment != null)
			count++;
		if(this.canaddtowaitinglist != null)
			count++;
		if(this.canaddtobookedlist != null)
			count++;
		if(this.canaddtoplannedlist != null)
			count++;
		if(this.canmakeappointment != null)
			count++;
		if(this.canmakeonwardreferral != null)
			count++;
		if(this.cantransfer != null)
			count++;
		if(this.appointmentoutcome != null)
			count++;
		if(this.firstdefinitivetreatmentevent != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.admin.vo.AppointmentOutcomeReasonVoCollection appointmentoutcomereasons;
	protected Boolean showfirstdefinitivetreatment;
	protected Boolean canaddtowaitinglist;
	protected Boolean canaddtobookedlist;
	protected Boolean canaddtoplannedlist;
	protected Boolean canmakeappointment;
	protected Boolean canmakeonwardreferral;
	protected Boolean cantransfer;
	protected ims.scheduling.vo.lookups.ApptOutcome appointmentoutcome;
	protected ims.pathways.vo.EventLiteVo firstdefinitivetreatmentevent;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
