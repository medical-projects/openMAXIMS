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


public class AppNavAccessRightsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppNavAccessRightsVo()
	{
	}
	public AppNavAccessRightsVo(ims.admin.vo.beans.AppNavAccessRightsVoBean bean)
	{
		this.readonly = bean.getReadOnly();
		this.accessforrip = bean.getAccessForRIP() == null ? null : ims.admin.vo.lookups.FormReadWrite.buildLookup(bean.getAccessForRIP());
		this.accessforepise = bean.getAccessForEPISE() == null ? null : ims.admin.vo.lookups.FormReadWrite.buildLookup(bean.getAccessForEPISE());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppNavAccessRightsVoBean bean)
	{
		this.readonly = bean.getReadOnly();
		this.accessforrip = bean.getAccessForRIP() == null ? null : ims.admin.vo.lookups.FormReadWrite.buildLookup(bean.getAccessForRIP());
		this.accessforepise = bean.getAccessForEPISE() == null ? null : ims.admin.vo.lookups.FormReadWrite.buildLookup(bean.getAccessForEPISE());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppNavAccessRightsVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppNavAccessRightsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppNavAccessRightsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getReadOnlyIsNotNull()
	{
		return this.readonly != null;
	}
	public Boolean getReadOnly()
	{
		return this.readonly;
	}
	public void setReadOnly(Boolean value)
	{
		this.isValidated = false;
		this.readonly = value;
	}
	public boolean getAccessForRIPIsNotNull()
	{
		return this.accessforrip != null;
	}
	public ims.admin.vo.lookups.FormReadWrite getAccessForRIP()
	{
		return this.accessforrip;
	}
	public void setAccessForRIP(ims.admin.vo.lookups.FormReadWrite value)
	{
		this.isValidated = false;
		this.accessforrip = value;
	}
	public boolean getAccessForEPISEIsNotNull()
	{
		return this.accessforepise != null;
	}
	public ims.admin.vo.lookups.FormReadWrite getAccessForEPISE()
	{
		return this.accessforepise;
	}
	public void setAccessForEPISE(ims.admin.vo.lookups.FormReadWrite value)
	{
		this.isValidated = false;
		this.accessforepise = value;
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
		if(!(obj instanceof AppNavAccessRightsVo))
			return false;
		AppNavAccessRightsVo compareObj = (AppNavAccessRightsVo)obj;
		if(this.getReadOnly() == null && compareObj.getReadOnly() != null)
			return false;
		if(this.getReadOnly() != null && compareObj.getReadOnly() == null)
			return false;
		if(this.getReadOnly() != null && compareObj.getReadOnly() != null)
			if(!this.getReadOnly().equals(compareObj.getReadOnly()))
				return false;
		if(this.getAccessForRIP() == null && compareObj.getAccessForRIP() != null)
			return false;
		if(this.getAccessForRIP() != null && compareObj.getAccessForRIP() == null)
			return false;
		if(this.getAccessForRIP() != null && compareObj.getAccessForRIP() != null)
			if(!this.getAccessForRIP().equals(compareObj.getAccessForRIP()))
				return false;
		if(this.getAccessForEPISE() == null && compareObj.getAccessForEPISE() != null)
			return false;
		if(this.getAccessForEPISE() != null && compareObj.getAccessForEPISE() == null)
			return false;
		if(this.getAccessForEPISE() != null && compareObj.getAccessForEPISE() != null)
			return this.getAccessForEPISE().equals(compareObj.getAccessForEPISE());
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
	
		AppNavAccessRightsVo clone = new AppNavAccessRightsVo();
		
		clone.readonly = this.readonly;
		if(this.accessforrip == null)
			clone.accessforrip = null;
		else
			clone.accessforrip = (ims.admin.vo.lookups.FormReadWrite)this.accessforrip.clone();
		if(this.accessforepise == null)
			clone.accessforepise = null;
		else
			clone.accessforepise = (ims.admin.vo.lookups.FormReadWrite)this.accessforepise.clone();
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
		if (!(AppNavAccessRightsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppNavAccessRightsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AppNavAccessRightsVo compareObj = (AppNavAccessRightsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReadOnly() == null && compareObj.getReadOnly() != null)
				return -1;
			if(this.getReadOnly() != null && compareObj.getReadOnly() == null)
				return 1;
			if(this.getReadOnly() != null && compareObj.getReadOnly() != null)
				retVal = this.getReadOnly().compareTo(compareObj.getReadOnly());
		}
		if (retVal == 0)
		{
			if(this.getAccessForRIP() == null && compareObj.getAccessForRIP() != null)
				return -1;
			if(this.getAccessForRIP() != null && compareObj.getAccessForRIP() == null)
				return 1;
			if(this.getAccessForRIP() != null && compareObj.getAccessForRIP() != null)
				retVal = this.getAccessForRIP().compareTo(compareObj.getAccessForRIP());
		}
		if (retVal == 0)
		{
			if(this.getAccessForEPISE() == null && compareObj.getAccessForEPISE() != null)
				return -1;
			if(this.getAccessForEPISE() != null && compareObj.getAccessForEPISE() == null)
				return 1;
			if(this.getAccessForEPISE() != null && compareObj.getAccessForEPISE() != null)
				retVal = this.getAccessForEPISE().compareTo(compareObj.getAccessForEPISE());
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
		if(this.readonly != null)
			count++;
		if(this.accessforrip != null)
			count++;
		if(this.accessforepise != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Boolean readonly;
	protected ims.admin.vo.lookups.FormReadWrite accessforrip;
	protected ims.admin.vo.lookups.FormReadWrite accessforepise;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
