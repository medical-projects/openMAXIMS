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


public class IfPatientLocationVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfPatientLocationVo()
	{
	}
	public IfPatientLocationVo(ims.scheduling.vo.beans.IfPatientLocationVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.locmapping = bean.getLocMapping() == null ? null : bean.getLocMapping().buildVo();
		this.appointmentid = bean.getAppointmentID();
		this.referralid = bean.getReferralID();
		this.parentlocmapping = bean.getParentLocMapping() == null ? null : bean.getParentLocMapping().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.IfPatientLocationVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.locmapping = bean.getLocMapping() == null ? null : bean.getLocMapping().buildVo(map);
		this.appointmentid = bean.getAppointmentID();
		this.referralid = bean.getReferralID();
		this.parentlocmapping = bean.getParentLocMapping() == null ? null : bean.getParentLocMapping().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.IfPatientLocationVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.IfPatientLocationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.IfPatientLocationVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getLocMappingIsNotNull()
	{
		return this.locmapping != null;
	}
	public ims.core.vo.LocShortMappingsVo getLocMapping()
	{
		return this.locmapping;
	}
	public void setLocMapping(ims.core.vo.LocShortMappingsVo value)
	{
		this.isValidated = false;
		this.locmapping = value;
	}
	public boolean getAppointmentIDIsNotNull()
	{
		return this.appointmentid != null;
	}
	public String getAppointmentID()
	{
		return this.appointmentid;
	}
	public static int getAppointmentIDMaxLength()
	{
		return 255;
	}
	public void setAppointmentID(String value)
	{
		this.isValidated = false;
		this.appointmentid = value;
	}
	public boolean getReferralIDIsNotNull()
	{
		return this.referralid != null;
	}
	public String getReferralID()
	{
		return this.referralid;
	}
	public static int getReferralIDMaxLength()
	{
		return 255;
	}
	public void setReferralID(String value)
	{
		this.isValidated = false;
		this.referralid = value;
	}
	public boolean getParentLocMappingIsNotNull()
	{
		return this.parentlocmapping != null;
	}
	public ims.core.vo.LocShortMappingsVo getParentLocMapping()
	{
		return this.parentlocmapping;
	}
	public void setParentLocMapping(ims.core.vo.LocShortMappingsVo value)
	{
		this.isValidated = false;
		this.parentlocmapping = value;
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
		if(!(obj instanceof IfPatientLocationVo))
			return false;
		IfPatientLocationVo compareObj = (IfPatientLocationVo)obj;
		if(this.getPatient() == null && compareObj.getPatient() != null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() == null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() != null)
			if(!this.getPatient().equals(compareObj.getPatient()))
				return false;
		if(this.getLocMapping() == null && compareObj.getLocMapping() != null)
			return false;
		if(this.getLocMapping() != null && compareObj.getLocMapping() == null)
			return false;
		if(this.getLocMapping() != null && compareObj.getLocMapping() != null)
			return this.getLocMapping().equals(compareObj.getLocMapping());
		return super.equals(obj);
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
		if(this.locmapping != null)
		{
			if(!this.locmapping.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.parentlocmapping != null)
		{
			if(!this.parentlocmapping.isValidated())
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
		if(this.locmapping != null)
		{
			String[] listOfOtherErrors = this.locmapping.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentlocmapping != null)
		{
			String[] listOfOtherErrors = this.parentlocmapping.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		IfPatientLocationVo clone = new IfPatientLocationVo();
		
		clone.patient = this.patient;
		if(this.locmapping == null)
			clone.locmapping = null;
		else
			clone.locmapping = (ims.core.vo.LocShortMappingsVo)this.locmapping.clone();
		clone.appointmentid = this.appointmentid;
		clone.referralid = this.referralid;
		if(this.parentlocmapping == null)
			clone.parentlocmapping = null;
		else
			clone.parentlocmapping = (ims.core.vo.LocShortMappingsVo)this.parentlocmapping.clone();
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
		if (!(IfPatientLocationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfPatientLocationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		IfPatientLocationVo compareObj = (IfPatientLocationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
		}
		if (retVal == 0)
		{
			if(this.getLocMapping() == null && compareObj.getLocMapping() != null)
				return -1;
			if(this.getLocMapping() != null && compareObj.getLocMapping() == null)
				return 1;
			if(this.getLocMapping() != null && compareObj.getLocMapping() != null)
				retVal = this.getLocMapping().compareTo(compareObj.getLocMapping());
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
		if(this.patient != null)
			count++;
		if(this.locmapping != null)
			count++;
		if(this.appointmentid != null)
			count++;
		if(this.referralid != null)
			count++;
		if(this.parentlocmapping != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.LocShortMappingsVo locmapping;
	protected String appointmentid;
	protected String referralid;
	protected ims.core.vo.LocShortMappingsVo parentlocmapping;
	private boolean isValidated = false;
	private boolean isBusy = false;
}