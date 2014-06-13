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
 * Linked to core.admin.pas.PendingTransfers business object (ID: 1014100013).
 */
public class PendingTransfersVo extends ims.core.admin.pas.vo.PendingTransfersRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PendingTransfersVo()
	{
	}
	public PendingTransfersVo(Integer id, int version)
	{
		super(id, version);
	}
	public PendingTransfersVo(ims.core.vo.beans.PendingTransfersVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo();
		this.destinationward = bean.getDestinationWard() == null ? null : bean.getDestinationWard().buildVo();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.transferrequestdatetime = bean.getTransferRequestDateTime() == null ? null : bean.getTransferRequestDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.core.vo.lookups.TransferStatus.buildLookup(bean.getCurrentStatus());
		this.activealerts = bean.getActiveAlerts();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PendingTransfersVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo(map);
		this.destinationward = bean.getDestinationWard() == null ? null : bean.getDestinationWard().buildVo(map);
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.transferrequestdatetime = bean.getTransferRequestDateTime() == null ? null : bean.getTransferRequestDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.core.vo.lookups.TransferStatus.buildLookup(bean.getCurrentStatus());
		this.activealerts = bean.getActiveAlerts();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PendingTransfersVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PendingTransfersVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PendingTransfersVoBean();
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
		if(fieldName.equals("INPATIENTEPISODE"))
			return getInpatientEpisode();
		if(fieldName.equals("DESTINATIONWARD"))
			return getDestinationWard();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("TRANSFERREQUESTDATETIME"))
			return getTransferRequestDateTime();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("ACTIVEALERTS"))
			return getActiveAlerts();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInpatientEpisodeIsNotNull()
	{
		return this.inpatientepisode != null;
	}
	public ims.core.vo.InpatientEpisodeForTransfersVo getInpatientEpisode()
	{
		return this.inpatientepisode;
	}
	public void setInpatientEpisode(ims.core.vo.InpatientEpisodeForTransfersVo value)
	{
		this.isValidated = false;
		this.inpatientepisode = value;
	}
	public boolean getDestinationWardIsNotNull()
	{
		return this.destinationward != null;
	}
	public ims.core.vo.LocationLiteVo getDestinationWard()
	{
		return this.destinationward;
	}
	public void setDestinationWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.destinationward = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
	}
	public boolean getTransferRequestDateTimeIsNotNull()
	{
		return this.transferrequestdatetime != null;
	}
	public ims.framework.utils.DateTime getTransferRequestDateTime()
	{
		return this.transferrequestdatetime;
	}
	public void setTransferRequestDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferrequestdatetime = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.core.vo.lookups.TransferStatus getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.lookups.TransferStatus value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getActiveAlertsIsNotNull()
	{
		return this.activealerts != null;
	}
	public Boolean getActiveAlerts()
	{
		return this.activealerts;
	}
	public void setActiveAlerts(Boolean value)
	{
		this.isValidated = false;
		this.activealerts = value;
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
		if(this.inpatientepisode != null)
		{
			if(!this.inpatientepisode.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.destinationward != null)
		{
			if(!this.destinationward.isValidated())
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
		if(this.inpatientepisode != null)
		{
			String[] listOfOtherErrors = this.inpatientepisode.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.destinationward != null)
		{
			String[] listOfOtherErrors = this.destinationward.validate();
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
	
		PendingTransfersVo clone = new PendingTransfersVo(this.id, this.version);
		
		if(this.inpatientepisode == null)
			clone.inpatientepisode = null;
		else
			clone.inpatientepisode = (ims.core.vo.InpatientEpisodeForTransfersVo)this.inpatientepisode.clone();
		if(this.destinationward == null)
			clone.destinationward = null;
		else
			clone.destinationward = (ims.core.vo.LocationLiteVo)this.destinationward.clone();
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		if(this.transferrequestdatetime == null)
			clone.transferrequestdatetime = null;
		else
			clone.transferrequestdatetime = (ims.framework.utils.DateTime)this.transferrequestdatetime.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.core.vo.lookups.TransferStatus)this.currentstatus.clone();
		clone.activealerts = this.activealerts;
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
		if (!(PendingTransfersVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PendingTransfersVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PendingTransfersVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PendingTransfersVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.inpatientepisode != null)
			count++;
		if(this.destinationward != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.transferrequestdatetime != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.activealerts != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.InpatientEpisodeForTransfersVo inpatientepisode;
	protected ims.core.vo.LocationLiteVo destinationward;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.framework.utils.DateTime transferrequestdatetime;
	protected ims.core.vo.lookups.TransferStatus currentstatus;
	protected Boolean activealerts;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
