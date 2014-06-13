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

package ims.clinical.vo;


public class EMISProblemsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISProblemsVo()
	{
	}
	public EMISProblemsVo(ims.clinical.vo.beans.EMISProblemsVoBean bean)
	{
		this.observation = bean.getObservation();
		this.observations = ims.clinical.vo.EMISObservationVoCollection.buildFromBeanCollection(bean.getObservations());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISProblemsVoBean bean)
	{
		this.observation = bean.getObservation();
		this.observations = ims.clinical.vo.EMISObservationVoCollection.buildFromBeanCollection(bean.getObservations());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISProblemsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISProblemsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISProblemsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getObservationIsNotNull()
	{
		return this.observation != null;
	}
	public String getObservation()
	{
		return this.observation;
	}
	public static int getObservationMaxLength()
	{
		return 255;
	}
	public void setObservation(String value)
	{
		this.isValidated = false;
		this.observation = value;
	}
	public boolean getObservationsIsNotNull()
	{
		return this.observations != null;
	}
	public ims.clinical.vo.EMISObservationVoCollection getObservations()
	{
		return this.observations;
	}
	public void setObservations(ims.clinical.vo.EMISObservationVoCollection value)
	{
		this.isValidated = false;
		this.observations = value;
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
		if(!(obj instanceof EMISProblemsVo))
			return false;
		EMISProblemsVo compareObj = (EMISProblemsVo)obj;
		if(this.getObservation() == null && compareObj.getObservation() != null)
			return false;
		if(this.getObservation() != null && compareObj.getObservation() == null)
			return false;
		if(this.getObservation() != null && compareObj.getObservation() != null)
			return this.getObservation().equals(compareObj.getObservation());
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
		if(this.observations != null)
		{
			if(!this.observations.isValidated())
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
		if(this.observations != null)
		{
			String[] listOfOtherErrors = this.observations.validate();
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
	
		EMISProblemsVo clone = new EMISProblemsVo();
		
		clone.observation = this.observation;
		if(this.observations == null)
			clone.observations = null;
		else
			clone.observations = (ims.clinical.vo.EMISObservationVoCollection)this.observations.clone();
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
		if (!(EMISProblemsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISProblemsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISProblemsVo compareObj = (EMISProblemsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getObservation() == null && compareObj.getObservation() != null)
				return -1;
			if(this.getObservation() != null && compareObj.getObservation() == null)
				return 1;
			if(this.getObservation() != null && compareObj.getObservation() != null)
			{
				if(caseInsensitive)
					retVal = this.getObservation().toLowerCase().compareTo(compareObj.getObservation().toLowerCase());
				else
					retVal = this.getObservation().compareTo(compareObj.getObservation());
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
		if(this.observation != null)
			count++;
		if(this.observations != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String observation;
	protected ims.clinical.vo.EMISObservationVoCollection observations;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
