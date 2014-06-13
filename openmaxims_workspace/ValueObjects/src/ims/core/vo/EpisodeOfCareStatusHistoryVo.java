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
 * Linked to core.admin.EpisodeOfCareStatusHistory business object (ID: 1004100053).
 */
public class EpisodeOfCareStatusHistoryVo extends ims.core.admin.vo.EpisodeOfCareStatusHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeOfCareStatusHistoryVo()
	{
	}
	public EpisodeOfCareStatusHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeOfCareStatusHistoryVo(ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.EpisodeOfCareStatus.buildLookup(bean.getStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.EpisodeOfCareStatus.buildLookup(bean.getStatus());
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean();
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
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.EpisodeOfCareStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.EpisodeOfCareStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getStatusDateTimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDateTime is mandatory");
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
	
		EpisodeOfCareStatusHistoryVo clone = new EpisodeOfCareStatusHistoryVo(this.id, this.version);
		
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.EpisodeOfCareStatus)this.status.clone();
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
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
		if (!(EpisodeOfCareStatusHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeOfCareStatusHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeOfCareStatusHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeOfCareStatusHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.status != null)
			count++;
		if(this.statusdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.EpisodeOfCareStatus status;
	protected ims.framework.utils.DateTime statusdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
