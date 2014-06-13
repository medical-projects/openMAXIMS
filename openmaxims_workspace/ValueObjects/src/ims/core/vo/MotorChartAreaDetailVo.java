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
 * Linked to core.clinical.MotorChartAreaDetail business object (ID: 1003100105).
 */
public class MotorChartAreaDetailVo extends ims.core.clinical.vo.MotorChartAreaDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MotorChartAreaDetailVo()
	{
	}
	public MotorChartAreaDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public MotorChartAreaDetailVo(ims.core.vo.beans.MotorChartAreaDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.motorareadescription = bean.getMotorAreaDescription();
		this.isupperlimb = bean.getIsUpperLimb();
		this.islowerlimb = bean.getIsLowerLimb();
		this.isactive = bean.getIsActive();
		this.orderno = bean.getOrderNo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MotorChartAreaDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.motorareadescription = bean.getMotorAreaDescription();
		this.isupperlimb = bean.getIsUpperLimb();
		this.islowerlimb = bean.getIsLowerLimb();
		this.isactive = bean.getIsActive();
		this.orderno = bean.getOrderNo();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MotorChartAreaDetailVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MotorChartAreaDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MotorChartAreaDetailVoBean();
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
		if(fieldName.equals("MOTORAREADESCRIPTION"))
			return getMotorAreaDescription();
		if(fieldName.equals("ISUPPERLIMB"))
			return getIsUpperLimb();
		if(fieldName.equals("ISLOWERLIMB"))
			return getIsLowerLimb();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ORDERNO"))
			return getOrderNo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMotorAreaDescriptionIsNotNull()
	{
		return this.motorareadescription != null;
	}
	public String getMotorAreaDescription()
	{
		return this.motorareadescription;
	}
	public static int getMotorAreaDescriptionMaxLength()
	{
		return 1000;
	}
	public void setMotorAreaDescription(String value)
	{
		this.isValidated = false;
		this.motorareadescription = value;
	}
	public boolean getIsUpperLimbIsNotNull()
	{
		return this.isupperlimb != null;
	}
	public Boolean getIsUpperLimb()
	{
		return this.isupperlimb;
	}
	public void setIsUpperLimb(Boolean value)
	{
		this.isValidated = false;
		this.isupperlimb = value;
	}
	public boolean getIsLowerLimbIsNotNull()
	{
		return this.islowerlimb != null;
	}
	public Boolean getIsLowerLimb()
	{
		return this.islowerlimb;
	}
	public void setIsLowerLimb(Boolean value)
	{
		this.isValidated = false;
		this.islowerlimb = value;
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
	public boolean getOrderNoIsNotNull()
	{
		return this.orderno != null;
	}
	public Integer getOrderNo()
	{
		return this.orderno;
	}
	public void setOrderNo(Integer value)
	{
		this.isValidated = false;
		this.orderno = value;
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
		if(this.motorareadescription == null || this.motorareadescription.length() == 0)
			listOfErrors.add("MotorAreaDescription is mandatory");
		else if(this.motorareadescription.length() > 1000)
			listOfErrors.add("The length of the field [motorareadescription] in the value object [ims.core.vo.MotorChartAreaDetailVo] is too big. It should be less or equal to 1000");
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
	
		MotorChartAreaDetailVo clone = new MotorChartAreaDetailVo(this.id, this.version);
		
		clone.motorareadescription = this.motorareadescription;
		clone.isupperlimb = this.isupperlimb;
		clone.islowerlimb = this.islowerlimb;
		clone.isactive = this.isactive;
		clone.orderno = this.orderno;
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
		if (!(MotorChartAreaDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MotorChartAreaDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((MotorChartAreaDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((MotorChartAreaDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.motorareadescription != null)
			count++;
		if(this.isupperlimb != null)
			count++;
		if(this.islowerlimb != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.orderno != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String motorareadescription;
	protected Boolean isupperlimb;
	protected Boolean islowerlimb;
	protected Boolean isactive;
	protected Integer orderno;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
