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

package ims.careuk.vo;


public class ClinicListFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicListFilterVo()
	{
	}
	public ClinicListFilterVo(ims.careuk.vo.beans.ClinicListFilterVoBean bean)
	{
		this.profile = bean.getProfile() == null ? null : bean.getProfile().buildVo();
		this.clinicdate = bean.getClinicDate() == null ? null : bean.getClinicDate().buildDate();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
		// Interface field type not supported.
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo();
		this.wastimeron = bean.getWasTimerOn();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ClinicListFilterVoBean bean)
	{
		this.profile = bean.getProfile() == null ? null : bean.getProfile().buildVo(map);
		this.clinicdate = bean.getClinicDate() == null ? null : bean.getClinicDate().buildDate();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
		// Interface field type not supported.
		this.contract = bean.getContract() == null ? null : bean.getContract().buildVo(map);
		this.wastimeron = bean.getWasTimerOn();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ClinicListFilterVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ClinicListFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ClinicListFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getProfileIsNotNull()
	{
		return this.profile != null;
	}
	public ims.scheduling.vo.ProfileShortVo getProfile()
	{
		return this.profile;
	}
	public void setProfile(ims.scheduling.vo.ProfileShortVo value)
	{
		this.isValidated = false;
		this.profile = value;
	}
	public boolean getClinicDateIsNotNull()
	{
		return this.clinicdate != null;
	}
	public ims.framework.utils.Date getClinicDate()
	{
		return this.clinicdate;
	}
	public void setClinicDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.clinicdate = value;
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
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.Sch_SessionRefVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.Sch_SessionRefVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.framework.interfaces.ILocation getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.framework.interfaces.ILocation value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getContractIsNotNull()
	{
		return this.contract != null;
	}
	public ims.core.vo.OrganisationLiteVo getContract()
	{
		return this.contract;
	}
	public void setContract(ims.core.vo.OrganisationLiteVo value)
	{
		this.isValidated = false;
		this.contract = value;
	}
	public boolean getWasTimerOnIsNotNull()
	{
		return this.wastimeron != null;
	}
	public Boolean getWasTimerOn()
	{
		return this.wastimeron;
	}
	public void setWasTimerOn(Boolean value)
	{
		this.isValidated = false;
		this.wastimeron = value;
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
		if(!(obj instanceof ClinicListFilterVo))
			return false;
		ClinicListFilterVo compareObj = (ClinicListFilterVo)obj;
		if(this.getProfile() == null && compareObj.getProfile() != null)
			return false;
		if(this.getProfile() != null && compareObj.getProfile() == null)
			return false;
		if(this.getProfile() != null && compareObj.getProfile() != null)
			if(!this.getProfile().equals(compareObj.getProfile()))
				return false;
		if(this.getClinicDate() == null && compareObj.getClinicDate() != null)
			return false;
		if(this.getClinicDate() != null && compareObj.getClinicDate() == null)
			return false;
		if(this.getClinicDate() != null && compareObj.getClinicDate() != null)
			return this.getClinicDate().equals(compareObj.getClinicDate());
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
		if(this.profile != null)
		{
			if(!this.profile.isValidated())
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
		if(this.profile != null)
		{
			String[] listOfOtherErrors = this.profile.validate();
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
	
		ClinicListFilterVo clone = new ClinicListFilterVo();
		
		if(this.profile == null)
			clone.profile = null;
		else
			clone.profile = (ims.scheduling.vo.ProfileShortVo)this.profile.clone();
		if(this.clinicdate == null)
			clone.clinicdate = null;
		else
			clone.clinicdate = (ims.framework.utils.Date)this.clinicdate.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		clone.session = this.session;
		clone.location = this.location;
		if(this.contract == null)
			clone.contract = null;
		else
			clone.contract = (ims.core.vo.OrganisationLiteVo)this.contract.clone();
		clone.wastimeron = this.wastimeron;
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
		if (!(ClinicListFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicListFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicListFilterVo compareObj = (ClinicListFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getProfile() == null && compareObj.getProfile() != null)
				return -1;
			if(this.getProfile() != null && compareObj.getProfile() == null)
				return 1;
			if(this.getProfile() != null && compareObj.getProfile() != null)
				retVal = this.getProfile().compareTo(compareObj.getProfile());
		}
		if (retVal == 0)
		{
			if(this.getClinicDate() == null && compareObj.getClinicDate() != null)
				return -1;
			if(this.getClinicDate() != null && compareObj.getClinicDate() == null)
				return 1;
			if(this.getClinicDate() != null && compareObj.getClinicDate() != null)
				retVal = this.getClinicDate().compareTo(compareObj.getClinicDate());
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
		if(this.profile != null)
			count++;
		if(this.clinicdate != null)
			count++;
		if(this.status != null)
			count++;
		if(this.session != null)
			count++;
		if(this.location != null)
			count++;
		if(this.contract != null)
			count++;
		if(this.wastimeron != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.scheduling.vo.ProfileShortVo profile;
	protected ims.framework.utils.Date clinicdate;
	protected ims.scheduling.vo.lookups.Status_Reason status;
	protected ims.scheduling.vo.Sch_SessionRefVo session;
	protected ims.framework.interfaces.ILocation location;
	protected ims.core.vo.OrganisationLiteVo contract;
	protected Boolean wastimeron;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
