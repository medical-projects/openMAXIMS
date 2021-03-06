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
public class ReferralErodForCancellationVo extends ims.careuk.vo.ReferralERODRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralErodForCancellationVo()
	{
	}
	public ReferralErodForCancellationVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralErodForCancellationVo(ims.careuk.vo.beans.ReferralErodForCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isactive = bean.getIsActive();
		this.erodstatus = bean.getErodStatus() == null ? null : ims.careuk.vo.lookups.ERODStatus.buildLookup(bean.getErodStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralErodForCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isactive = bean.getIsActive();
		this.erodstatus = bean.getErodStatus() == null ? null : ims.careuk.vo.lookups.ERODStatus.buildLookup(bean.getErodStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralErodForCancellationVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralErodForCancellationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralErodForCancellationVoBean();
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
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ERODSTATUS"))
			return getErodStatus();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getErodStatusIsNotNull()
	{
		return this.erodstatus != null;
	}
	public ims.careuk.vo.lookups.ERODStatus getErodStatus()
	{
		return this.erodstatus;
	}
	public void setErodStatus(ims.careuk.vo.lookups.ERODStatus value)
	{
		this.isValidated = false;
		this.erodstatus = value;
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
	
		ReferralErodForCancellationVo clone = new ReferralErodForCancellationVo(this.id, this.version);
		
		clone.isactive = this.isactive;
		if(this.erodstatus == null)
			clone.erodstatus = null;
		else
			clone.erodstatus = (ims.careuk.vo.lookups.ERODStatus)this.erodstatus.clone();
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
		if (!(ReferralErodForCancellationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralErodForCancellationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralErodForCancellationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralErodForCancellationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.isactive != null)
			count++;
		if(this.erodstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Boolean isactive;
	protected ims.careuk.vo.lookups.ERODStatus erodstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
