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

package ims.pathways.vo;


public class PatwayHistoryDummyVo extends ims.pathways.vo.PatientJourneyDummyVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatwayHistoryDummyVo()
	{
	}
	public PatwayHistoryDummyVo(ims.pathways.vo.beans.PatwayHistoryDummyVoBean bean)
	{
		this.patientjourneyid = bean.getPatientJourneyID();
		this.pathwayhistoryid = bean.getPathwayHistoryID();
		this.iterator = bean.getIterator();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatwayHistoryDummyVoBean bean)
	{
		this.patientjourneyid = bean.getPatientJourneyID();
		this.pathwayhistoryid = bean.getPathwayHistoryID();
		this.iterator = bean.getIterator();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatwayHistoryDummyVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatwayHistoryDummyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatwayHistoryDummyVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPathwayHistoryIDIsNotNull()
	{
		return this.pathwayhistoryid != null;
	}
	public Integer getPathwayHistoryID()
	{
		return this.pathwayhistoryid;
	}
	public void setPathwayHistoryID(Integer value)
	{
		this.isValidated = false;
		this.pathwayhistoryid = value;
	}
	public boolean getIteratorIsNotNull()
	{
		return this.iterator != null;
	}
	public Integer getIterator()
	{
		return this.iterator;
	}
	public void setIterator(Integer value)
	{
		this.isValidated = false;
		this.iterator = value;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PatwayHistoryDummyVo))
			return false;
		PatwayHistoryDummyVo compareObj = (PatwayHistoryDummyVo)obj;
		if(this.getPatientJourneyID() == null && compareObj.getPatientJourneyID() != null)
			return false;
		if(this.getPatientJourneyID() != null && compareObj.getPatientJourneyID() == null)
			return false;
		if(this.getPatientJourneyID() != null && compareObj.getPatientJourneyID() != null)
			if(!this.getPatientJourneyID().equals(compareObj.getPatientJourneyID()))
				return false;
		if(this.getPathwayHistoryID() == null && compareObj.getPathwayHistoryID() != null)
			return false;
		if(this.getPathwayHistoryID() != null && compareObj.getPathwayHistoryID() == null)
			return false;
		if(this.getPathwayHistoryID() != null && compareObj.getPathwayHistoryID() != null)
			if(!this.getPathwayHistoryID().equals(compareObj.getPathwayHistoryID()))
				return false;
		if(this.getIterator() == null && compareObj.getIterator() != null)
			return false;
		if(this.getIterator() != null && compareObj.getIterator() == null)
			return false;
		if(this.getIterator() != null && compareObj.getIterator() != null)
			return this.getIterator().equals(compareObj.getIterator());
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
	
		PatwayHistoryDummyVo clone = new PatwayHistoryDummyVo();
		
		clone.patientjourneyid = this.patientjourneyid;
		clone.pathwayhistoryid = this.pathwayhistoryid;
		clone.iterator = this.iterator;
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
		if (!(PatwayHistoryDummyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatwayHistoryDummyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatwayHistoryDummyVo compareObj = (PatwayHistoryDummyVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatientJourneyID() == null && compareObj.getPatientJourneyID() != null)
				return -1;
			if(this.getPatientJourneyID() != null && compareObj.getPatientJourneyID() == null)
				return 1;
			if(this.getPatientJourneyID() != null && compareObj.getPatientJourneyID() != null)
				retVal = this.getPatientJourneyID().compareTo(compareObj.getPatientJourneyID());
		}
		if (retVal == 0)
		{
			if(this.getPathwayHistoryID() == null && compareObj.getPathwayHistoryID() != null)
				return -1;
			if(this.getPathwayHistoryID() != null && compareObj.getPathwayHistoryID() == null)
				return 1;
			if(this.getPathwayHistoryID() != null && compareObj.getPathwayHistoryID() != null)
				retVal = this.getPathwayHistoryID().compareTo(compareObj.getPathwayHistoryID());
		}
		if (retVal == 0)
		{
			if(this.getIterator() == null && compareObj.getIterator() != null)
				return -1;
			if(this.getIterator() != null && compareObj.getIterator() == null)
				return 1;
			if(this.getIterator() != null && compareObj.getIterator() != null)
				retVal = this.getIterator().compareTo(compareObj.getIterator());
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
		if(this.pathwayhistoryid != null)
			count++;
		if(this.iterator != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected Integer pathwayhistoryid;
	protected Integer iterator;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
