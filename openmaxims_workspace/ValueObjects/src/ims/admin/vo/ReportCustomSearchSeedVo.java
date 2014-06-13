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


public class ReportCustomSearchSeedVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReportCustomSearchSeedVo()
	{
	}
	public ReportCustomSearchSeedVo(ims.admin.vo.beans.ReportCustomSearchSeedVoBean bean)
	{
		this.id = bean.getID();
		this.displaystring = bean.getDisplayString();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.ReportCustomSearchSeedVoBean bean)
	{
		this.id = bean.getID();
		this.displaystring = bean.getDisplayString();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.ReportCustomSearchSeedVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.ReportCustomSearchSeedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.ReportCustomSearchSeedVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIDIsNotNull()
	{
		return this.id != null;
	}
	public String getID()
	{
		return this.id;
	}
	public static int getIDMaxLength()
	{
		return 255;
	}
	public void setID(String value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public boolean getDisplayStringIsNotNull()
	{
		return this.displaystring != null;
	}
	public String getDisplayString()
	{
		return this.displaystring;
	}
	public static int getDisplayStringMaxLength()
	{
		return 255;
	}
	public void setDisplayString(String value)
	{
		this.isValidated = false;
		this.displaystring = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.displaystring != null)
			sb.append(this.displaystring);
		return sb.toString();
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
	
		ReportCustomSearchSeedVo clone = new ReportCustomSearchSeedVo();
		
		clone.id = this.id;
		clone.displaystring = this.displaystring;
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
		if (!(ReportCustomSearchSeedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReportCustomSearchSeedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReportCustomSearchSeedVo compareObj = (ReportCustomSearchSeedVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID() == null && compareObj.getID() != null)
				return -1;
			if(this.getID() != null && compareObj.getID() == null)
				return 1;
			if(this.getID() != null && compareObj.getID() != null)
			{
				if(caseInsensitive)
					retVal = this.getID().toLowerCase().compareTo(compareObj.getID().toLowerCase());
				else
					retVal = this.getID().compareTo(compareObj.getID());
			}
		}
		if (retVal == 0)
		{
			if(this.getDisplayString() == null && compareObj.getDisplayString() != null)
				return -1;
			if(this.getDisplayString() != null && compareObj.getDisplayString() == null)
				return 1;
			if(this.getDisplayString() != null && compareObj.getDisplayString() != null)
			{
				if(caseInsensitive)
					retVal = this.getDisplayString().toLowerCase().compareTo(compareObj.getDisplayString().toLowerCase());
				else
					retVal = this.getDisplayString().compareTo(compareObj.getDisplayString());
			}
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
		if(this.id != null)
			count++;
		if(this.displaystring != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String id;
	protected String displaystring;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
