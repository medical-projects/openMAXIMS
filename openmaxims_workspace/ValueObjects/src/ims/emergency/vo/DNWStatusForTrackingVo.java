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
 * Linked to emergency.DNWStatus business object (ID: 1086100008).
 */
public class DNWStatusForTrackingVo extends ims.emergency.vo.DNWStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DNWStatusForTrackingVo()
	{
	}
	public DNWStatusForTrackingVo(Integer id, int version)
	{
		super(id, version);
	}
	public DNWStatusForTrackingVo(ims.emergency.vo.beans.DNWStatusForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.calledamount = bean.getCalledAmount();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.DNWStatusForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.calledamount = bean.getCalledAmount();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.DNWStatusForTrackingVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.DNWStatusForTrackingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.DNWStatusForTrackingVoBean();
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
		if(fieldName.equals("CALLEDAMOUNT"))
			return getCalledAmount();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCalledAmountIsNotNull()
	{
		return this.calledamount != null;
	}
	public Integer getCalledAmount()
	{
		return this.calledamount;
	}
	public void setCalledAmount(Integer value)
	{
		this.isValidated = false;
		this.calledamount = value;
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
		if(this.calledamount == null)
			listOfErrors.add("CalledAmount is mandatory");
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
	
		DNWStatusForTrackingVo clone = new DNWStatusForTrackingVo(this.id, this.version);
		
		clone.calledamount = this.calledamount;
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
		if (!(DNWStatusForTrackingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DNWStatusForTrackingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DNWStatusForTrackingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DNWStatusForTrackingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.calledamount != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected Integer calledamount;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
