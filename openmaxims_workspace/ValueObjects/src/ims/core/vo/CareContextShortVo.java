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
 * Linked to core.admin.CareContext business object (ID: 1004100019).
 */
public class CareContextShortVo extends ims.core.vo.CareContextLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CareContextShortVo()
	{
	}
	public CareContextShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public CareContextShortVo(ims.core.vo.beans.CareContextShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.context = bean.getContext() == null ? null : ims.core.vo.lookups.ContextType.buildLookup(bean.getContext());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.estimateddischargedate = bean.getEstimatedDischargeDate() == null ? null : bean.getEstimatedDischargeDate().buildDate();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.locationtype = bean.getLocationType() == null ? null : ims.core.vo.lookups.ContactLocation.buildLookup(bean.getLocationType());
		// Interface field type not supported.
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CareContextShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.context = bean.getContext() == null ? null : ims.core.vo.lookups.ContextType.buildLookup(bean.getContext());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.estimateddischargedate = bean.getEstimatedDischargeDate() == null ? null : bean.getEstimatedDischargeDate().buildDate();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.locationtype = bean.getLocationType() == null ? null : ims.core.vo.lookups.ContactLocation.buildLookup(bean.getLocationType());
		// Interface field type not supported.
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CareContextShortVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CareContextShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CareContextShortVoBean();
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
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("ENDDATETIME"))
			return getEndDateTime();
		if(fieldName.equals("LOCATIONTYPE"))
			return getLocationType();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getEndDateTimeIsNotNull()
	{
		return this.enddatetime != null;
	}
	public ims.framework.utils.DateTime getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.enddatetime = value;
	}
	public boolean getLocationTypeIsNotNull()
	{
		return this.locationtype != null;
	}
	public ims.core.vo.lookups.ContactLocation getLocationType()
	{
		return this.locationtype;
	}
	public void setLocationType(ims.core.vo.lookups.ContactLocation value)
	{
		this.isValidated = false;
		this.locationtype = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.vo.interfaces.IHcp getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.vo.interfaces.IHcp value)
	{
		this.isValidated = false;
		this.responsiblehcp = (ims.core.vo.HcpLiteVo)value;
	}
	/**
	* getRecordBrowserText() - Returns the text to be displayed in a Record Browser when displaying Care Context Details
	*/
	public String getRecordBrowserText()
	{
		java.lang.StringBuffer sb = new java.lang.StringBuffer("");
	
		if (this.context != null)
			sb.append(this.context + " ");
			
		sb.append("Care Context - ");
	
		if (this.episodeofcare != null && this.episodeofcare.responsiblehcp != null
			 && this.episodeofcare.responsiblehcp.mos != null)
				sb.append(this.episodeofcare.responsiblehcp.mos + "  ");
			
		if (this.startdatetime != null)
			sb.append(this.startdatetime);
				
	
		return sb.toString();
	}	
	/**
	* toString()
	*/
	public String toString()
	{
		String strCareContext = this.getStartDateTimeIsNotNull() ? this.getStartDateTime().toString() : "";
	
		if (this.getContextIsNotNull())
			strCareContext += this.getEndDateTimeIsNotNull() ? " - " + this.getEndDateTime().toString() + " - Discharged " : " - Ongoing";
	
		return strCareContext;
	}
	/**
	* createDisplayString
	*/
	public String createDisplayString()
	{
		String strCareContext = this.getStartDateTimeIsNotNull() ? this.getStartDateTime().toString() : "";
	
		if (this.getContextIsNotNull())
			strCareContext += this.getEndDateTimeIsNotNull() ? " - " + this.getEndDateTime().toString() + " - Discharged " : " - Ongoing";
	
		return strCareContext;
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
		if(this.pasevent != null)
		{
			if(!this.pasevent.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.episodeofcare != null)
		{
			if(!this.episodeofcare.isValidated())
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
		if(this.pasevent != null)
		{
			String[] listOfOtherErrors = this.pasevent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.context == null)
			listOfErrors.add("Context is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.episodeofcare != null)
		{
			String[] listOfOtherErrors = this.episodeofcare.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.startdatetime == null)
			listOfErrors.add("Start Date for 'Care Context' is mandatory.");
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
	
		CareContextShortVo clone = new CareContextShortVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventVo)this.pasevent.clone();
		if(this.context == null)
			clone.context = null;
		else
			clone.context = (ims.core.vo.lookups.ContextType)this.context.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeofCareLiteVo)this.episodeofcare.clone();
		clone.orderinghospital = this.orderinghospital;
		if(this.estimateddischargedate == null)
			clone.estimateddischargedate = null;
		else
			clone.estimateddischargedate = (ims.framework.utils.Date)this.estimateddischargedate.clone();
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.enddatetime == null)
			clone.enddatetime = null;
		else
			clone.enddatetime = (ims.framework.utils.DateTime)this.enddatetime.clone();
		if(this.locationtype == null)
			clone.locationtype = null;
		else
			clone.locationtype = (ims.core.vo.lookups.ContactLocation)this.locationtype.clone();
		clone.responsiblehcp = this.responsiblehcp;
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
		if (!(CareContextShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CareContextShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CareContextShortVo compareObj = (CareContextShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStartDateTime() == null && compareObj.getStartDateTime() != null)
				return -1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() == null)
				return 1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() != null)
				retVal = this.getStartDateTime().compareTo(compareObj.getStartDateTime());
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
		if(this.startdatetime != null)
			count++;
		if(this.enddatetime != null)
			count++;
		if(this.locationtype != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.framework.utils.DateTime enddatetime;
	protected ims.core.vo.lookups.ContactLocation locationtype;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
