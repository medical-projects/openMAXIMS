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


public class EMISObservationVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISObservationVo()
	{
	}
	public EMISObservationVo(ims.clinical.vo.beans.EMISObservationVoBean bean)
	{
		this.observation = bean.getObservation();
		this.effectivedate = bean.getEffectiveDate();
		this.originalterm = bean.getOriginalTerm();
		this.lastreviewdate = bean.getLastReviewDate();
		this.displayname = bean.getDisplayName();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
		this.problemstatus = bean.getProblemStatus();
		this.significance = bean.getSignificance();
		this.parentproblemobservationid = bean.getParentProblemObservationId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISObservationVoBean bean)
	{
		this.observation = bean.getObservation();
		this.effectivedate = bean.getEffectiveDate();
		this.originalterm = bean.getOriginalTerm();
		this.lastreviewdate = bean.getLastReviewDate();
		this.displayname = bean.getDisplayName();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
		this.problemstatus = bean.getProblemStatus();
		this.significance = bean.getSignificance();
		this.parentproblemobservationid = bean.getParentProblemObservationId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISObservationVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISObservationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISObservationVoBean();
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
	public boolean getEffectiveDateIsNotNull()
	{
		return this.effectivedate != null;
	}
	public String getEffectiveDate()
	{
		return this.effectivedate;
	}
	public static int getEffectiveDateMaxLength()
	{
		return 255;
	}
	public void setEffectiveDate(String value)
	{
		this.isValidated = false;
		this.effectivedate = value;
	}
	public boolean getOriginalTermIsNotNull()
	{
		return this.originalterm != null;
	}
	public String getOriginalTerm()
	{
		return this.originalterm;
	}
	public static int getOriginalTermMaxLength()
	{
		return 255;
	}
	public void setOriginalTerm(String value)
	{
		this.isValidated = false;
		this.originalterm = value;
	}
	public boolean getLastReviewDateIsNotNull()
	{
		return this.lastreviewdate != null;
	}
	public String getLastReviewDate()
	{
		return this.lastreviewdate;
	}
	public static int getLastReviewDateMaxLength()
	{
		return 255;
	}
	public void setLastReviewDate(String value)
	{
		this.isValidated = false;
		this.lastreviewdate = value;
	}
	public boolean getDisplayNameIsNotNull()
	{
		return this.displayname != null;
	}
	public String getDisplayName()
	{
		return this.displayname;
	}
	public static int getDisplayNameMaxLength()
	{
		return 255;
	}
	public void setDisplayName(String value)
	{
		this.isValidated = false;
		this.displayname = value;
	}
	public boolean getConfidentialityPolicyIsNotNull()
	{
		return this.confidentialitypolicy != null;
	}
	public String getConfidentialityPolicy()
	{
		return this.confidentialitypolicy;
	}
	public static int getConfidentialityPolicyMaxLength()
	{
		return 255;
	}
	public void setConfidentialityPolicy(String value)
	{
		this.isValidated = false;
		this.confidentialitypolicy = value;
	}
	public boolean getProblemStatusIsNotNull()
	{
		return this.problemstatus != null;
	}
	public String getProblemStatus()
	{
		return this.problemstatus;
	}
	public static int getProblemStatusMaxLength()
	{
		return 255;
	}
	public void setProblemStatus(String value)
	{
		this.isValidated = false;
		this.problemstatus = value;
	}
	public boolean getSignificanceIsNotNull()
	{
		return this.significance != null;
	}
	public String getSignificance()
	{
		return this.significance;
	}
	public static int getSignificanceMaxLength()
	{
		return 255;
	}
	public void setSignificance(String value)
	{
		this.isValidated = false;
		this.significance = value;
	}
	public boolean getParentProblemObservationIdIsNotNull()
	{
		return this.parentproblemobservationid != null;
	}
	public String getParentProblemObservationId()
	{
		return this.parentproblemobservationid;
	}
	public static int getParentProblemObservationIdMaxLength()
	{
		return 255;
	}
	public void setParentProblemObservationId(String value)
	{
		this.isValidated = false;
		this.parentproblemobservationid = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.effectivedate != null)
			sb.append(this.effectivedate);
		sb.append(", ");
		if(this.originalterm != null)
			sb.append(this.originalterm);
		sb.append(", ");
		if(this.lastreviewdate != null)
			sb.append(this.lastreviewdate);
		sb.append(", ");
		if(this.displayname != null)
			sb.append(this.displayname);
		sb.append(", ");
		if(this.confidentialitypolicy != null)
			sb.append(this.confidentialitypolicy);
		sb.append(", ");
		if(this.problemstatus != null)
			sb.append(this.problemstatus);
		sb.append(", ");
		if(this.significance != null)
			sb.append(this.significance);
		sb.append(".");
		return sb.toString();
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof EMISObservationVo))
			return false;
		EMISObservationVo compareObj = (EMISObservationVo)obj;
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
	
		EMISObservationVo clone = new EMISObservationVo();
		
		clone.observation = this.observation;
		clone.effectivedate = this.effectivedate;
		clone.originalterm = this.originalterm;
		clone.lastreviewdate = this.lastreviewdate;
		clone.displayname = this.displayname;
		clone.confidentialitypolicy = this.confidentialitypolicy;
		clone.problemstatus = this.problemstatus;
		clone.significance = this.significance;
		clone.parentproblemobservationid = this.parentproblemobservationid;
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
		if (!(EMISObservationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISObservationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISObservationVo compareObj = (EMISObservationVo)obj;
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
		if(this.effectivedate != null)
			count++;
		if(this.originalterm != null)
			count++;
		if(this.lastreviewdate != null)
			count++;
		if(this.displayname != null)
			count++;
		if(this.confidentialitypolicy != null)
			count++;
		if(this.problemstatus != null)
			count++;
		if(this.significance != null)
			count++;
		if(this.parentproblemobservationid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String observation;
	protected String effectivedate;
	protected String originalterm;
	protected String lastreviewdate;
	protected String displayname;
	protected String confidentialitypolicy;
	protected String problemstatus;
	protected String significance;
	protected String parentproblemobservationid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
