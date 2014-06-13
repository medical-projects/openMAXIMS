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


public class BayLayoutConfigListVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BayLayoutConfigListVo()
	{
	}
	public BayLayoutConfigListVo(ims.core.vo.beans.BayLayoutConfigListVoBean bean)
	{
		this.bayconfigvo = bean.getBayConfigVo() == null ? null : bean.getBayConfigVo().buildVo();
		this.locationlitevo = bean.getLocationLiteVo() == null ? null : bean.getLocationLiteVo().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.BayLayoutConfigListVoBean bean)
	{
		this.bayconfigvo = bean.getBayConfigVo() == null ? null : bean.getBayConfigVo().buildVo(map);
		this.locationlitevo = bean.getLocationLiteVo() == null ? null : bean.getLocationLiteVo().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.BayLayoutConfigListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.BayLayoutConfigListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.BayLayoutConfigListVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getBayConfigVoIsNotNull()
	{
		return this.bayconfigvo != null;
	}
	public ims.core.vo.BayConfigVo getBayConfigVo()
	{
		return this.bayconfigvo;
	}
	public void setBayConfigVo(ims.core.vo.BayConfigVo value)
	{
		this.isValidated = false;
		this.bayconfigvo = value;
	}
	public boolean getLocationLiteVoIsNotNull()
	{
		return this.locationlitevo != null;
	}
	public ims.core.vo.LocationLiteVo getLocationLiteVo()
	{
		return this.locationlitevo;
	}
	public void setLocationLiteVo(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.locationlitevo = value;
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
		if(!(obj instanceof BayLayoutConfigListVo))
			return false;
		BayLayoutConfigListVo compareObj = (BayLayoutConfigListVo)obj;
		if(this.getBayConfigVo() == null && compareObj.getBayConfigVo() != null)
			return false;
		if(this.getBayConfigVo() != null && compareObj.getBayConfigVo() == null)
			return false;
		if(this.getBayConfigVo() != null && compareObj.getBayConfigVo() != null)
			if(!this.getBayConfigVo().equals(compareObj.getBayConfigVo()))
				return false;
		if(this.getLocationLiteVo() == null && compareObj.getLocationLiteVo() != null)
			return false;
		if(this.getLocationLiteVo() != null && compareObj.getLocationLiteVo() == null)
			return false;
		if(this.getLocationLiteVo() != null && compareObj.getLocationLiteVo() != null)
			return this.getLocationLiteVo().equals(compareObj.getLocationLiteVo());
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
		if(this.bayconfigvo != null)
		{
			if(!this.bayconfigvo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.locationlitevo != null)
		{
			if(!this.locationlitevo.isValidated())
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
		if(this.bayconfigvo != null)
		{
			String[] listOfOtherErrors = this.bayconfigvo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.locationlitevo != null)
		{
			String[] listOfOtherErrors = this.locationlitevo.validate();
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
	
		BayLayoutConfigListVo clone = new BayLayoutConfigListVo();
		
		if(this.bayconfigvo == null)
			clone.bayconfigvo = null;
		else
			clone.bayconfigvo = (ims.core.vo.BayConfigVo)this.bayconfigvo.clone();
		if(this.locationlitevo == null)
			clone.locationlitevo = null;
		else
			clone.locationlitevo = (ims.core.vo.LocationLiteVo)this.locationlitevo.clone();
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
		if (!(BayLayoutConfigListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BayLayoutConfigListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BayLayoutConfigListVo compareObj = (BayLayoutConfigListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getBayConfigVo() == null && compareObj.getBayConfigVo() != null)
				return -1;
			if(this.getBayConfigVo() != null && compareObj.getBayConfigVo() == null)
				return 1;
			if(this.getBayConfigVo() != null && compareObj.getBayConfigVo() != null)
				retVal = this.getBayConfigVo().compareTo(compareObj.getBayConfigVo());
		}
		if (retVal == 0)
		{
			if(this.getLocationLiteVo() == null && compareObj.getLocationLiteVo() != null)
				return -1;
			if(this.getLocationLiteVo() != null && compareObj.getLocationLiteVo() == null)
				return 1;
			if(this.getLocationLiteVo() != null && compareObj.getLocationLiteVo() != null)
				retVal = this.getLocationLiteVo().compareTo(compareObj.getLocationLiteVo());
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
		if(this.bayconfigvo != null)
			count++;
		if(this.locationlitevo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.BayConfigVo bayconfigvo;
	protected ims.core.vo.LocationLiteVo locationlitevo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
