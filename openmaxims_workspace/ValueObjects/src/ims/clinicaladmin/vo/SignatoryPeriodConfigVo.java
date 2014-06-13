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

package ims.clinicaladmin.vo;

/**
 * Linked to core.configuration.SignatoryPeriod business object (ID: 1028100025).
 */
public class SignatoryPeriodConfigVo extends ims.core.configuration.vo.SignatoryPeriodRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SignatoryPeriodConfigVo()
	{
	}
	public SignatoryPeriodConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public SignatoryPeriodConfigVo(ims.clinicaladmin.vo.beans.SignatoryPeriodConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.timeperiods = ims.core.vo.lookups.DailyTimePeriodsCollection.buildFromBeanCollection(bean.getTimePeriods());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.SignatoryPeriodConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.timeperiods = ims.core.vo.lookups.DailyTimePeriodsCollection.buildFromBeanCollection(bean.getTimePeriods());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.SignatoryPeriodConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.SignatoryPeriodConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.SignatoryPeriodConfigVoBean();
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
		if(fieldName.equals("TIMEPERIODS"))
			return getTimePeriods();
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
		return 30;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getTimePeriodsIsNotNull()
	{
		return this.timeperiods != null;
	}
	public ims.core.vo.lookups.DailyTimePeriodsCollection getTimePeriods()
	{
		return this.timeperiods;
	}
	public void setTimePeriods(ims.core.vo.lookups.DailyTimePeriodsCollection value)
	{
		this.isValidated = false;
		this.timeperiods = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 30)
			listOfErrors.add("The length of the field [name] in the value object [ims.clinicaladmin.vo.SignatoryPeriodConfigVo] is too big. It should be less or equal to 30");
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
	
		SignatoryPeriodConfigVo clone = new SignatoryPeriodConfigVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.timeperiods == null)
			clone.timeperiods = null;
		else
			clone.timeperiods = (ims.core.vo.lookups.DailyTimePeriodsCollection)this.timeperiods.clone();
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
		if (!(SignatoryPeriodConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SignatoryPeriodConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SignatoryPeriodConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SignatoryPeriodConfigVo)obj).getBoId());
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
		if(this.timeperiods != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String name;
	protected ims.core.vo.lookups.DailyTimePeriodsCollection timeperiods;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
