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
 * Linked to CAREUK.ReferralEROD business object (ID: 1096100062).
 */
public class ReferralERODHistoryVo extends ims.careuk.vo.ReferralERODRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralERODHistoryVo()
	{
	}
	public ReferralERODHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralERODHistoryVo(ims.careuk.vo.beans.ReferralERODHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eroddate1 = bean.getERODDate1() == null ? null : bean.getERODDate1().buildDate();
		this.eroddate2 = bean.getERODDate2() == null ? null : bean.getERODDate2().buildDate();
		this.patavailfromdate = bean.getPatAvailFromDate() == null ? null : bean.getPatAvailFromDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralERODHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eroddate1 = bean.getERODDate1() == null ? null : bean.getERODDate1().buildDate();
		this.eroddate2 = bean.getERODDate2() == null ? null : bean.getERODDate2().buildDate();
		this.patavailfromdate = bean.getPatAvailFromDate() == null ? null : bean.getPatAvailFromDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralERODHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralERODHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralERODHistoryVoBean();
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
		if(fieldName.equals("ERODDATE1"))
			return getERODDate1();
		if(fieldName.equals("ERODDATE2"))
			return getERODDate2();
		if(fieldName.equals("PATAVAILFROMDATE"))
			return getPatAvailFromDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getERODDate1IsNotNull()
	{
		return this.eroddate1 != null;
	}
	public ims.framework.utils.Date getERODDate1()
	{
		return this.eroddate1;
	}
	public void setERODDate1(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.eroddate1 = value;
	}
	public boolean getERODDate2IsNotNull()
	{
		return this.eroddate2 != null;
	}
	public ims.framework.utils.Date getERODDate2()
	{
		return this.eroddate2;
	}
	public void setERODDate2(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.eroddate2 = value;
	}
	public boolean getPatAvailFromDateIsNotNull()
	{
		return this.patavailfromdate != null;
	}
	public ims.framework.utils.Date getPatAvailFromDate()
	{
		return this.patavailfromdate;
	}
	public void setPatAvailFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.patavailfromdate = value;
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
		if(this.eroddate1 == null)
			listOfErrors.add("ERODDate1 is mandatory");
		if(this.eroddate2 == null)
			listOfErrors.add("ERODDate2 is mandatory");
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
	
		ReferralERODHistoryVo clone = new ReferralERODHistoryVo(this.id, this.version);
		
		if(this.eroddate1 == null)
			clone.eroddate1 = null;
		else
			clone.eroddate1 = (ims.framework.utils.Date)this.eroddate1.clone();
		if(this.eroddate2 == null)
			clone.eroddate2 = null;
		else
			clone.eroddate2 = (ims.framework.utils.Date)this.eroddate2.clone();
		if(this.patavailfromdate == null)
			clone.patavailfromdate = null;
		else
			clone.patavailfromdate = (ims.framework.utils.Date)this.patavailfromdate.clone();
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
		if (!(ReferralERODHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralERODHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralERODHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralERODHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.eroddate1 != null)
			count++;
		if(this.eroddate2 != null)
			count++;
		if(this.patavailfromdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Date eroddate1;
	protected ims.framework.utils.Date eroddate2;
	protected ims.framework.utils.Date patavailfromdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
