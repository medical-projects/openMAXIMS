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

package ims.oncology.vo;

/**
 * Linked to Oncology.InternalReferral business object (ID: 1074100041).
 */
public class InternalReferralListVo extends ims.oncology.vo.InternalReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InternalReferralListVo()
	{
	}
	public InternalReferralListVo(Integer id, int version)
	{
		super(id, version);
	}
	public InternalReferralListVo(ims.oncology.vo.beans.InternalReferralListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraldate = bean.getReferralDate() == null ? null : bean.getReferralDate().buildDate();
		this.referraltype = bean.getReferralType() == null ? null : ims.oncology.vo.lookups.InternalReferralTypeAndReason.buildLookup(bean.getReferralType());
		this.referralsource = bean.getReferralSource() == null ? null : ims.oncology.vo.lookups.InternalReferralSource.buildLookup(bean.getReferralSource());
		this.referredby = bean.getReferredBy() == null ? null : bean.getReferredBy().buildVo();
		this.planneddischargedate = bean.getPlannedDischargeDate() == null ? null : bean.getPlannedDischargeDate().buildDate();
		this.treatmentstartdate = bean.getTreatmentStartDate() == null ? null : bean.getTreatmentStartDate().buildDate();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.internalreferraloutcome = bean.getInternalReferralOutcome() == null ? null : bean.getInternalReferralOutcome().buildVo();
		this.referralseen = bean.getReferralSeen();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.InternalReferralListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referraldate = bean.getReferralDate() == null ? null : bean.getReferralDate().buildDate();
		this.referraltype = bean.getReferralType() == null ? null : ims.oncology.vo.lookups.InternalReferralTypeAndReason.buildLookup(bean.getReferralType());
		this.referralsource = bean.getReferralSource() == null ? null : ims.oncology.vo.lookups.InternalReferralSource.buildLookup(bean.getReferralSource());
		this.referredby = bean.getReferredBy() == null ? null : bean.getReferredBy().buildVo(map);
		this.planneddischargedate = bean.getPlannedDischargeDate() == null ? null : bean.getPlannedDischargeDate().buildDate();
		this.treatmentstartdate = bean.getTreatmentStartDate() == null ? null : bean.getTreatmentStartDate().buildDate();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.internalreferraloutcome = bean.getInternalReferralOutcome() == null ? null : bean.getInternalReferralOutcome().buildVo(map);
		this.referralseen = bean.getReferralSeen();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.InternalReferralListVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.InternalReferralListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.InternalReferralListVoBean();
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
		if(fieldName.equals("REFERRALDATE"))
			return getReferralDate();
		if(fieldName.equals("REFERRALTYPE"))
			return getReferralType();
		if(fieldName.equals("REFERRALSOURCE"))
			return getReferralSource();
		if(fieldName.equals("REFERREDBY"))
			return getReferredBy();
		if(fieldName.equals("PLANNEDDISCHARGEDATE"))
			return getPlannedDischargeDate();
		if(fieldName.equals("TREATMENTSTARTDATE"))
			return getTreatmentStartDate();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("INTERNALREFERRALOUTCOME"))
			return getInternalReferralOutcome();
		if(fieldName.equals("REFERRALSEEN"))
			return getReferralSeen();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralDateIsNotNull()
	{
		return this.referraldate != null;
	}
	public ims.framework.utils.Date getReferralDate()
	{
		return this.referraldate;
	}
	public void setReferralDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.referraldate = value;
	}
	public boolean getReferralTypeIsNotNull()
	{
		return this.referraltype != null;
	}
	public ims.oncology.vo.lookups.InternalReferralTypeAndReason getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.oncology.vo.lookups.InternalReferralTypeAndReason value)
	{
		this.isValidated = false;
		this.referraltype = value;
	}
	public boolean getReferralSourceIsNotNull()
	{
		return this.referralsource != null;
	}
	public ims.oncology.vo.lookups.InternalReferralSource getReferralSource()
	{
		return this.referralsource;
	}
	public void setReferralSource(ims.oncology.vo.lookups.InternalReferralSource value)
	{
		this.isValidated = false;
		this.referralsource = value;
	}
	public boolean getReferredByIsNotNull()
	{
		return this.referredby != null;
	}
	public ims.core.vo.HcpLiteVo getReferredBy()
	{
		return this.referredby;
	}
	public void setReferredBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referredby = value;
	}
	public boolean getPlannedDischargeDateIsNotNull()
	{
		return this.planneddischargedate != null;
	}
	public ims.framework.utils.Date getPlannedDischargeDate()
	{
		return this.planneddischargedate;
	}
	public void setPlannedDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.planneddischargedate = value;
	}
	public boolean getTreatmentStartDateIsNotNull()
	{
		return this.treatmentstartdate != null;
	}
	public ims.framework.utils.Date getTreatmentStartDate()
	{
		return this.treatmentstartdate;
	}
	public void setTreatmentStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.treatmentstartdate = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getInternalReferralOutcomeIsNotNull()
	{
		return this.internalreferraloutcome != null;
	}
	public ims.oncology.vo.InternalReferralOutcomeVo getInternalReferralOutcome()
	{
		return this.internalreferraloutcome;
	}
	public void setInternalReferralOutcome(ims.oncology.vo.InternalReferralOutcomeVo value)
	{
		this.isValidated = false;
		this.internalreferraloutcome = value;
	}
	public boolean getReferralSeenIsNotNull()
	{
		return this.referralseen != null;
	}
	public Boolean getReferralSeen()
	{
		return this.referralseen;
	}
	public void setReferralSeen(Boolean value)
	{
		this.isValidated = false;
		this.referralseen = value;
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
		if(this.referraldate == null)
			listOfErrors.add("ReferralDate is mandatory");
		if(this.referraltype == null)
			listOfErrors.add("ReferralType is mandatory");
		if(this.referralsource == null)
			listOfErrors.add("ReferralSource is mandatory");
		if(this.referredby == null)
			listOfErrors.add("ReferredBy is mandatory");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		InternalReferralListVo clone = new InternalReferralListVo(this.id, this.version);
		
		if(this.referraldate == null)
			clone.referraldate = null;
		else
			clone.referraldate = (ims.framework.utils.Date)this.referraldate.clone();
		if(this.referraltype == null)
			clone.referraltype = null;
		else
			clone.referraltype = (ims.oncology.vo.lookups.InternalReferralTypeAndReason)this.referraltype.clone();
		if(this.referralsource == null)
			clone.referralsource = null;
		else
			clone.referralsource = (ims.oncology.vo.lookups.InternalReferralSource)this.referralsource.clone();
		if(this.referredby == null)
			clone.referredby = null;
		else
			clone.referredby = (ims.core.vo.HcpLiteVo)this.referredby.clone();
		if(this.planneddischargedate == null)
			clone.planneddischargedate = null;
		else
			clone.planneddischargedate = (ims.framework.utils.Date)this.planneddischargedate.clone();
		if(this.treatmentstartdate == null)
			clone.treatmentstartdate = null;
		else
			clone.treatmentstartdate = (ims.framework.utils.Date)this.treatmentstartdate.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientListVo)this.patient.clone();
		if(this.internalreferraloutcome == null)
			clone.internalreferraloutcome = null;
		else
			clone.internalreferraloutcome = (ims.oncology.vo.InternalReferralOutcomeVo)this.internalreferraloutcome.clone();
		clone.referralseen = this.referralseen;
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
		if (!(InternalReferralListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InternalReferralListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InternalReferralListVo compareObj = (InternalReferralListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReferralDate() == null && compareObj.getReferralDate() != null)
				return -1;
			if(this.getReferralDate() != null && compareObj.getReferralDate() == null)
				return 1;
			if(this.getReferralDate() != null && compareObj.getReferralDate() != null)
				retVal = this.getReferralDate().compareTo(compareObj.getReferralDate());
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
		if(this.referraldate != null)
			count++;
		if(this.referraltype != null)
			count++;
		if(this.referralsource != null)
			count++;
		if(this.referredby != null)
			count++;
		if(this.planneddischargedate != null)
			count++;
		if(this.treatmentstartdate != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.internalreferraloutcome != null)
			count++;
		if(this.referralseen != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.framework.utils.Date referraldate;
	protected ims.oncology.vo.lookups.InternalReferralTypeAndReason referraltype;
	protected ims.oncology.vo.lookups.InternalReferralSource referralsource;
	protected ims.core.vo.HcpLiteVo referredby;
	protected ims.framework.utils.Date planneddischargedate;
	protected ims.framework.utils.Date treatmentstartdate;
	protected ims.core.vo.PatientListVo patient;
	protected ims.oncology.vo.InternalReferralOutcomeVo internalreferraloutcome;
	protected Boolean referralseen;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
