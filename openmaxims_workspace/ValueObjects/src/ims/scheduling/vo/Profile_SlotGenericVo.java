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
 * Linked to Scheduling.Profile_Slot business object (ID: 1055100000).
 */
public class Profile_SlotGenericVo extends ims.scheduling.vo.Profile_SlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Profile_SlotGenericVo()
	{
	}
	public Profile_SlotGenericVo(Integer id, int version)
	{
		super(id, version);
	}
	public Profile_SlotGenericVo(ims.scheduling.vo.beans.Profile_SlotGenericVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.duration = bean.getDuration();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.numberslotsreq = bean.getNumberSlotsReq();
		this.noofinstances = bean.getNoOfInstances();
		this.deallocnoofdays = bean.getDeallocNoOfDays();
		this.isactive = bean.getIsActive();
		this.type = bean.getType() == null ? null : ims.scheduling.vo.lookups.SchedCABSlotType.buildLookup(bean.getType());
		this.directoryofservice = ims.scheduling.vo.SlotDirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryOfService());
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo();
		if(bean.getFunctions() != null)
		{
			this.functions = new ims.core.clinical.vo.ServiceFunctionRefVoCollection();
			for(int functions_i = 0; functions_i < bean.getFunctions().length; functions_i++)
			{
				this.functions.add(new ims.core.clinical.vo.ServiceFunctionRefVo(new Integer(bean.getFunctions()[functions_i].getId()), bean.getFunctions()[functions_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Profile_SlotGenericVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.duration = bean.getDuration();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.numberslotsreq = bean.getNumberSlotsReq();
		this.noofinstances = bean.getNoOfInstances();
		this.deallocnoofdays = bean.getDeallocNoOfDays();
		this.isactive = bean.getIsActive();
		this.type = bean.getType() == null ? null : ims.scheduling.vo.lookups.SchedCABSlotType.buildLookup(bean.getType());
		this.directoryofservice = ims.scheduling.vo.SlotDirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryOfService());
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo(map);
		if(bean.getFunctions() != null)
		{
			this.functions = new ims.core.clinical.vo.ServiceFunctionRefVoCollection();
			for(int functions_i = 0; functions_i < bean.getFunctions().length; functions_i++)
			{
				this.functions.add(new ims.core.clinical.vo.ServiceFunctionRefVo(new Integer(bean.getFunctions()[functions_i].getId()), bean.getFunctions()[functions_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Profile_SlotGenericVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Profile_SlotGenericVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Profile_SlotGenericVoBean();
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
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("NUMBERSLOTSREQ"))
			return getNumberSlotsReq();
		if(fieldName.equals("NOOFINSTANCES"))
			return getNoOfInstances();
		if(fieldName.equals("DEALLOCNOOFDAYS"))
			return getDeallocNoOfDays();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("DIRECTORYOFSERVICE"))
			return getDirectoryOfService();
		if(fieldName.equals("SLOTRESP"))
			return getSlotResp();
		if(fieldName.equals("FUNCTIONS"))
			return getFunctions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityVo value)
	{
		this.isValidated = false;
		this.activity = value;
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
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
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
	public boolean getNumberSlotsReqIsNotNull()
	{
		return this.numberslotsreq != null;
	}
	public Integer getNumberSlotsReq()
	{
		return this.numberslotsreq;
	}
	public void setNumberSlotsReq(Integer value)
	{
		this.isValidated = false;
		this.numberslotsreq = value;
	}
	public boolean getNoOfInstancesIsNotNull()
	{
		return this.noofinstances != null;
	}
	public Integer getNoOfInstances()
	{
		return this.noofinstances;
	}
	public void setNoOfInstances(Integer value)
	{
		this.isValidated = false;
		this.noofinstances = value;
	}
	public boolean getDeallocNoOfDaysIsNotNull()
	{
		return this.deallocnoofdays != null;
	}
	public Integer getDeallocNoOfDays()
	{
		return this.deallocnoofdays;
	}
	public void setDeallocNoOfDays(Integer value)
	{
		this.isValidated = false;
		this.deallocnoofdays = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.scheduling.vo.lookups.SchedCABSlotType getType()
	{
		return this.type;
	}
	public void setType(ims.scheduling.vo.lookups.SchedCABSlotType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getDirectoryOfServiceIsNotNull()
	{
		return this.directoryofservice != null;
	}
	public ims.scheduling.vo.SlotDirectoryOfServiceVoCollection getDirectoryOfService()
	{
		return this.directoryofservice;
	}
	public void setDirectoryOfService(ims.scheduling.vo.SlotDirectoryOfServiceVoCollection value)
	{
		this.isValidated = false;
		this.directoryofservice = value;
	}
	public boolean getSlotRespIsNotNull()
	{
		return this.slotresp != null;
	}
	public ims.scheduling.vo.Profile_ListOwnerVo getSlotResp()
	{
		return this.slotresp;
	}
	public void setSlotResp(ims.scheduling.vo.Profile_ListOwnerVo value)
	{
		this.isValidated = false;
		this.slotresp = value;
	}
	public boolean getFunctionsIsNotNull()
	{
		return this.functions != null;
	}
	public ims.core.clinical.vo.ServiceFunctionRefVoCollection getFunctions()
	{
		return this.functions;
	}
	public void setFunctions(ims.core.clinical.vo.ServiceFunctionRefVoCollection value)
	{
		this.isValidated = false;
		this.functions = value;
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
		if(this.activity != null)
		{
			if(!this.activity.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.directoryofservice != null)
		{
			if(!this.directoryofservice.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.slotresp != null)
		{
			if(!this.slotresp.isValidated())
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
		if(this.activity == null)
			listOfErrors.add("Activity is a mandatory field");
		if(this.activity != null)
		{
			String[] listOfOtherErrors = this.activity.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.starttm == null)
			listOfErrors.add("Start Time is mandatory");
		if(this.duration == null)
			listOfErrors.add("Slot Interval is mandatory");
		if(this.priority == null)
			listOfErrors.add("Priority is mandatory");
		if(this.numberslotsreq == null)
			listOfErrors.add("No. Of Slots is mandatory");
		if(this.noofinstances == null)
			listOfErrors.add("No. Of Appts is mandatory");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.directoryofservice != null)
		{
			String[] listOfOtherErrors = this.directoryofservice.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.slotresp != null)
		{
			String[] listOfOtherErrors = this.slotresp.validate();
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
	
		Profile_SlotGenericVo clone = new Profile_SlotGenericVo(this.id, this.version);
		
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityVo)this.activity.clone();
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		clone.duration = this.duration;
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		clone.numberslotsreq = this.numberslotsreq;
		clone.noofinstances = this.noofinstances;
		clone.deallocnoofdays = this.deallocnoofdays;
		clone.isactive = this.isactive;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.scheduling.vo.lookups.SchedCABSlotType)this.type.clone();
		if(this.directoryofservice == null)
			clone.directoryofservice = null;
		else
			clone.directoryofservice = (ims.scheduling.vo.SlotDirectoryOfServiceVoCollection)this.directoryofservice.clone();
		if(this.slotresp == null)
			clone.slotresp = null;
		else
			clone.slotresp = (ims.scheduling.vo.Profile_ListOwnerVo)this.slotresp.clone();
		clone.functions = this.functions;
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
		if (!(Profile_SlotGenericVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Profile_SlotGenericVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		Profile_SlotGenericVo compareObj = (Profile_SlotGenericVo)obj;
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
		if(this.activity != null)
			count++;
		if(this.starttm != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.numberslotsreq != null)
			count++;
		if(this.noofinstances != null)
			count++;
		if(this.deallocnoofdays != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.type != null)
			count++;
		if(this.directoryofservice != null)
			count++;
		if(this.slotresp != null)
			count++;
		if(this.functions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.core.vo.ActivityVo activity;
	protected ims.framework.utils.Time starttm;
	protected Integer duration;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected Integer numberslotsreq;
	protected Integer noofinstances;
	protected Integer deallocnoofdays;
	protected Boolean isactive;
	protected ims.scheduling.vo.lookups.SchedCABSlotType type;
	protected ims.scheduling.vo.SlotDirectoryOfServiceVoCollection directoryofservice;
	protected ims.scheduling.vo.Profile_ListOwnerVo slotresp;
	protected ims.core.clinical.vo.ServiceFunctionRefVoCollection functions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
