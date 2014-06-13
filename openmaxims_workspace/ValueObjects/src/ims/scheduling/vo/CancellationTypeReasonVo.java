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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.CancellationTypeReason business object (ID: 1090100001).
 */
public class CancellationTypeReasonVo extends ims.scheduling.vo.CancellationTypeReasonRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CancellationTypeReasonVo()
	{
	}
	public CancellationTypeReasonVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancellationTypeReasonVo(ims.scheduling.vo.beans.CancellationTypeReasonVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cancellationtype = bean.getCancellationType() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getCancellationType());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.CancellationTypeReasonVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cancellationtype = bean.getCancellationType() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getCancellationType());
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancellationReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.CancellationTypeReasonVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.CancellationTypeReasonVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.CancellationTypeReasonVoBean();
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
		if(fieldName.equals("CANCELLATIONTYPE"))
			return getCancellationType();
		if(fieldName.equals("CANCELLATIONREASON"))
			return getCancellationReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCancellationTypeIsNotNull()
	{
		return this.cancellationtype != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getCancellationType()
	{
		return this.cancellationtype;
	}
	public void setCancellationType(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.cancellationtype = value;
	}
	public boolean getCancellationReasonIsNotNull()
	{
		return this.cancellationreason != null;
	}
	public ims.scheduling.vo.lookups.CancelAppointmentReason getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.scheduling.vo.lookups.CancelAppointmentReason value)
	{
		this.isValidated = false;
		this.cancellationreason = value;
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
		if(this.cancellationtype == null)
			listOfErrors.add("CancellationType is mandatory");
		if(this.cancellationreason == null)
			listOfErrors.add("CancellationReason is mandatory");
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
	
		CancellationTypeReasonVo clone = new CancellationTypeReasonVo(this.id, this.version);
		
		if(this.cancellationtype == null)
			clone.cancellationtype = null;
		else
			clone.cancellationtype = (ims.scheduling.vo.lookups.Status_Reason)this.cancellationtype.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.scheduling.vo.lookups.CancelAppointmentReason)this.cancellationreason.clone();
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
		if (!(CancellationTypeReasonVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancellationTypeReasonVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancellationTypeReasonVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancellationTypeReasonVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.cancellationtype != null)
			count++;
		if(this.cancellationreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.scheduling.vo.lookups.Status_Reason cancellationtype;
	protected ims.scheduling.vo.lookups.CancelAppointmentReason cancellationreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
