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
 * Linked to core.resource.people.Gp business object (ID: 1006100001).
 */
public class GP extends ims.core.vo.GpShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GP()
	{
	}
	public GP(Integer id, int version)
	{
		super(id, version);
	}
	public GP(ims.core.vo.beans.GPBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.practices = ims.core.vo.GpToPracticesVoCollection.buildFromBeanCollection(bean.getPractices());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.dummyfield = bean.getDummyField();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.GPBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.commchannels = ims.core.vo.CommChannelVoCollection.buildFromBeanCollection(bean.getCommChannels());
		this.practices = ims.core.vo.GpToPracticesVoCollection.buildFromBeanCollection(bean.getPractices());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.dummyfield = bean.getDummyField();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.GPBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.GPBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.GPBean();
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
		if(fieldName.equals("DUMMYFIELD"))
			return getDummyField();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDummyFieldIsNotNull()
	{
		return this.dummyfield != null;
	}
	public String getDummyField()
	{
		return this.dummyfield;
	}
	public static int getDummyFieldMaxLength()
	{
		return 255;
	}
	public void setDummyField(String value)
	{
		this.isValidated = false;
		this.dummyfield = value;
	}
	/**
	* getCommunicationChannel(ims.core.vo.lookups.ChannelType channelType)
	*/
	public ims.core.vo.CommChannelVo getCommunicationChannel(ims.core.vo.lookups.ChannelType channelType)
	{
		if (commchannels == null) return null;
		for (int i = 0; i < commchannels.size(); i++)
		{
			ims.core.vo.CommChannelVo voCommChannel = commchannels.get(i);
			if (voCommChannel.getChannelType().equals(channelType))
			{
				return voCommChannel;
			}
		}
		return null;
	}
	/**
	* ims.core.vo.CommChannelVo getEmail()
	*/
	public ims.core.vo.CommChannelVo getEmail()
	{
		return getCommunicationChannel(ims.core.vo.lookups.ChannelType.EMAIL);
	}
	/**
	* addCommunicationChannel(ims.core.vo.lookups.ChannelType channelType, String val)
	*/
	public void addCommunicationChannel(ims.core.vo.lookups.ChannelType channelType, String val)
	{
		if (commchannels == null) commchannels = new ims.core.vo.CommChannelVoCollection();
		ims.core.vo.CommChannelVo voCommChannell = getCommunicationChannel(channelType);
		if (voCommChannell != null)
		{
			if (val == null || val.length() == 0)
			{
				commchannels.remove(commchannels.indexOf(voCommChannell ));
			}
			else
			{
				voCommChannell.setCommValue(val);
			}	
		}
		else
		{
			if (val != null && val.length() > 0)
			{
				voCommChannell = new ims.core.vo.CommChannelVo();
				voCommChannell .setChannelType(channelType);
				voCommChannell .setCommValue(val);
				commchannels.add(voCommChannell);
			}
				
		}
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.commchannels != null)
		{
			if(!this.commchannels.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.practices != null)
		{
			if(!this.practices.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.commchannels != null)
		{
			String[] listOfOtherErrors = this.commchannels.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.practices != null)
		{
			String[] listOfOtherErrors = this.practices.validate();
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
	
		GP clone = new GP(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.commchannels == null)
			clone.commchannels = null;
		else
			clone.commchannels = (ims.core.vo.CommChannelVoCollection)this.commchannels.clone();
		if(this.practices == null)
			clone.practices = null;
		else
			clone.practices = (ims.core.vo.GpToPracticesVoCollection)this.practices.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.GPStatus)this.status.clone();
		clone.dummyfield = this.dummyfield;
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
		if (!(GP.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GP object cannot be compared an Object of type " + obj.getClass().getName());
		}
		GP compareObj = (GP)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
				retVal = this.getName().compareTo(compareObj.getName());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.dummyfield != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected String dummyfield;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
