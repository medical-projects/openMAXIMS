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
 * Linked to core.admin.ICABReferral business object (ID: 1090100005).
 */
public class ICABReferralVo extends ims.core.admin.vo.ICABReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICABReferralVo()
	{
	}
	public ICABReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICABReferralVo(ims.core.vo.beans.ICABReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
		this.details = bean.getDetails();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.extreferralkey = bean.getExtReferralKey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.ubrn = bean.getUBRN();
		this.status = bean.getStatus() == null ? null : ims.careuk.vo.lookups.ICABReferralStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ICABReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
		this.details = bean.getDetails();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.extreferralkey = bean.getExtReferralKey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.ubrn = bean.getUBRN();
		this.status = bean.getStatus() == null ? null : ims.careuk.vo.lookups.ICABReferralStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ICABReferralVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ICABReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ICABReferralVoBean();
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
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("REFERRALTYPE"))
			return getReferralType();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("EXTREFERRALKEY"))
			return getExtReferralKey();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("UBRN"))
			return getUBRN();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getReferralTypeIsNotNull()
	{
		return this.referraltype != null;
	}
	public ims.core.vo.lookups.ReferralType getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.core.vo.lookups.ReferralType value)
	{
		this.isValidated = false;
		this.referraltype = value;
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getExtReferralKeyIsNotNull()
	{
		return this.extreferralkey != null;
	}
	public String getExtReferralKey()
	{
		return this.extreferralkey;
	}
	public static int getExtReferralKeyMaxLength()
	{
		return 50;
	}
	public void setExtReferralKey(String value)
	{
		this.isValidated = false;
		this.extreferralkey = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getUBRNIsNotNull()
	{
		return this.ubrn != null;
	}
	public String getUBRN()
	{
		return this.ubrn;
	}
	public static int getUBRNMaxLength()
	{
		return 200;
	}
	public void setUBRN(String value)
	{
		this.isValidated = false;
		this.ubrn = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.careuk.vo.lookups.ICABReferralStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.careuk.vo.lookups.ICABReferralStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(this.details != null)
			if(this.details.length() > 255)
				listOfErrors.add("The length of the field [details] in the value object [ims.core.vo.ICABReferralVo] is too big. It should be less or equal to 255");
		if(this.extreferralkey != null)
			if(this.extreferralkey.length() > 50)
				listOfErrors.add("The length of the field [extreferralkey] in the value object [ims.core.vo.ICABReferralVo] is too big. It should be less or equal to 50");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.ubrn != null)
			if(this.ubrn.length() > 200)
				listOfErrors.add("The length of the field [ubrn] in the value object [ims.core.vo.ICABReferralVo] is too big. It should be less or equal to 200");
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
	
		ICABReferralVo clone = new ICABReferralVo(this.id, this.version);
		
		clone.authoringcp = this.authoringcp;
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.referraltype == null)
			clone.referraltype = null;
		else
			clone.referraltype = (ims.core.vo.lookups.ReferralType)this.referraltype.clone();
		clone.details = this.details;
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		clone.extreferralkey = this.extreferralkey;
		clone.patient = this.patient;
		clone.ubrn = this.ubrn;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.careuk.vo.lookups.ICABReferralStatus)this.status.clone();
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
		if (!(ICABReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICABReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICABReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICABReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.referraltype != null)
			count++;
		if(this.details != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.extreferralkey != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.ubrn != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.resource.people.vo.HcpRefVo authoringcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.lookups.ReferralType referraltype;
	protected String details;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected String extreferralkey;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected String ubrn;
	protected ims.careuk.vo.lookups.ICABReferralStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
