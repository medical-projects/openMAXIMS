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

/**
 * Linked to core.configuration.ContractConfigKPIHistory business object (ID: 1096100048).
 */
public class ContractConfigKPIHistoryVo extends ims.core.configuration.vo.ContractConfigKPIHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ContractConfigKPIHistoryVo()
	{
	}
	public ContractConfigKPIHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public ContractConfigKPIHistoryVo(ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dateinstantiated = bean.getDateInstantiated() == null ? null : bean.getDateInstantiated().buildDate();
		this.daystorttbreachdate = bean.getDaysToRTTBreachDate();
		this.daysto1stappt = bean.getDaysTo1stAppt();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dateinstantiated = bean.getDateInstantiated() == null ? null : bean.getDateInstantiated().buildDate();
		this.daystorttbreachdate = bean.getDaysToRTTBreachDate();
		this.daysto1stappt = bean.getDaysTo1stAppt();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean();
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
		if(fieldName.equals("DATEINSTANTIATED"))
			return getDateInstantiated();
		if(fieldName.equals("DAYSTORTTBREACHDATE"))
			return getDaysToRTTBreachDate();
		if(fieldName.equals("DAYSTO1STAPPT"))
			return getDaysTo1stAppt();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateInstantiatedIsNotNull()
	{
		return this.dateinstantiated != null;
	}
	public ims.framework.utils.Date getDateInstantiated()
	{
		return this.dateinstantiated;
	}
	public void setDateInstantiated(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateinstantiated = value;
	}
	public boolean getDaysToRTTBreachDateIsNotNull()
	{
		return this.daystorttbreachdate != null;
	}
	public Integer getDaysToRTTBreachDate()
	{
		return this.daystorttbreachdate;
	}
	public void setDaysToRTTBreachDate(Integer value)
	{
		this.isValidated = false;
		this.daystorttbreachdate = value;
	}
	public boolean getDaysTo1stApptIsNotNull()
	{
		return this.daysto1stappt != null;
	}
	public Integer getDaysTo1stAppt()
	{
		return this.daysto1stappt;
	}
	public void setDaysTo1stAppt(Integer value)
	{
		this.isValidated = false;
		this.daysto1stappt = value;
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
		if(this.dateinstantiated == null)
			listOfErrors.add("DateInstantiated is mandatory");
		if(this.daystorttbreachdate == null)
			listOfErrors.add("DaysToRTTBreachDate is mandatory");
		if(this.daysto1stappt == null)
			listOfErrors.add("daysTo1stAppt is mandatory");
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
	
		ContractConfigKPIHistoryVo clone = new ContractConfigKPIHistoryVo(this.id, this.version);
		
		if(this.dateinstantiated == null)
			clone.dateinstantiated = null;
		else
			clone.dateinstantiated = (ims.framework.utils.Date)this.dateinstantiated.clone();
		clone.daystorttbreachdate = this.daystorttbreachdate;
		clone.daysto1stappt = this.daysto1stappt;
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
		if (!(ContractConfigKPIHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ContractConfigKPIHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ContractConfigKPIHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ContractConfigKPIHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dateinstantiated != null)
			count++;
		if(this.daystorttbreachdate != null)
			count++;
		if(this.daysto1stappt != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Date dateinstantiated;
	protected Integer daystorttbreachdate;
	protected Integer daysto1stappt;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
