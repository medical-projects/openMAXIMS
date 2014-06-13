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

/**
 * Linked to eDischarge.FailedEmailsDetails business object (ID: 1099100011).
 */
public class FailedEmailsDetailsVo extends ims.edischarge.vo.FailedEmailsDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FailedEmailsDetailsVo()
	{
	}
	public FailedEmailsDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public FailedEmailsDetailsVo(ims.clinical.vo.beans.FailedEmailsDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gpname = bean.getGPName();
		this.emailaddress = bean.getEmailAddress();
		this.successfuldatetime = bean.getSuccessfulDateTime() == null ? null : bean.getSuccessfulDateTime().buildDateTime();
		this.initialdatetime = bean.getInitialDateTime() == null ? null : bean.getInitialDateTime().buildDateTime();
		this.filepath = bean.getFilePath();
		this.faileddatetime = bean.getFailedDateTime() == null ? null : bean.getFailedDateTime().buildDateTime();
		this.patientname = bean.getPatientName();
		this.jobtype = bean.getJobType() == null ? null : ims.clinical.vo.lookups.DischargeSummaryJobType.buildLookup(bean.getJobType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.FailedEmailsDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gpname = bean.getGPName();
		this.emailaddress = bean.getEmailAddress();
		this.successfuldatetime = bean.getSuccessfulDateTime() == null ? null : bean.getSuccessfulDateTime().buildDateTime();
		this.initialdatetime = bean.getInitialDateTime() == null ? null : bean.getInitialDateTime().buildDateTime();
		this.filepath = bean.getFilePath();
		this.faileddatetime = bean.getFailedDateTime() == null ? null : bean.getFailedDateTime().buildDateTime();
		this.patientname = bean.getPatientName();
		this.jobtype = bean.getJobType() == null ? null : ims.clinical.vo.lookups.DischargeSummaryJobType.buildLookup(bean.getJobType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.FailedEmailsDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.FailedEmailsDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.FailedEmailsDetailsVoBean();
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
		if(fieldName.equals("GPNAME"))
			return getGPName();
		if(fieldName.equals("EMAILADDRESS"))
			return getEmailAddress();
		if(fieldName.equals("SUCCESSFULDATETIME"))
			return getSuccessfulDateTime();
		if(fieldName.equals("INITIALDATETIME"))
			return getInitialDateTime();
		if(fieldName.equals("FILEPATH"))
			return getFilePath();
		if(fieldName.equals("FAILEDDATETIME"))
			return getFailedDateTime();
		if(fieldName.equals("PATIENTNAME"))
			return getPatientName();
		if(fieldName.equals("JOBTYPE"))
			return getJobType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGPNameIsNotNull()
	{
		return this.gpname != null;
	}
	public String getGPName()
	{
		return this.gpname;
	}
	public static int getGPNameMaxLength()
	{
		return 255;
	}
	public void setGPName(String value)
	{
		this.isValidated = false;
		this.gpname = value;
	}
	public boolean getEmailAddressIsNotNull()
	{
		return this.emailaddress != null;
	}
	public String getEmailAddress()
	{
		return this.emailaddress;
	}
	public static int getEmailAddressMaxLength()
	{
		return 255;
	}
	public void setEmailAddress(String value)
	{
		this.isValidated = false;
		this.emailaddress = value;
	}
	public boolean getSuccessfulDateTimeIsNotNull()
	{
		return this.successfuldatetime != null;
	}
	public ims.framework.utils.DateTime getSuccessfulDateTime()
	{
		return this.successfuldatetime;
	}
	public void setSuccessfulDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.successfuldatetime = value;
	}
	public boolean getInitialDateTimeIsNotNull()
	{
		return this.initialdatetime != null;
	}
	public ims.framework.utils.DateTime getInitialDateTime()
	{
		return this.initialdatetime;
	}
	public void setInitialDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.initialdatetime = value;
	}
	public boolean getFilePathIsNotNull()
	{
		return this.filepath != null;
	}
	public String getFilePath()
	{
		return this.filepath;
	}
	public static int getFilePathMaxLength()
	{
		return 255;
	}
	public void setFilePath(String value)
	{
		this.isValidated = false;
		this.filepath = value;
	}
	public boolean getFailedDateTimeIsNotNull()
	{
		return this.faileddatetime != null;
	}
	public ims.framework.utils.DateTime getFailedDateTime()
	{
		return this.faileddatetime;
	}
	public void setFailedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.faileddatetime = value;
	}
	public boolean getPatientNameIsNotNull()
	{
		return this.patientname != null;
	}
	public String getPatientName()
	{
		return this.patientname;
	}
	public static int getPatientNameMaxLength()
	{
		return 255;
	}
	public void setPatientName(String value)
	{
		this.isValidated = false;
		this.patientname = value;
	}
	public boolean getJobTypeIsNotNull()
	{
		return this.jobtype != null;
	}
	public ims.clinical.vo.lookups.DischargeSummaryJobType getJobType()
	{
		return this.jobtype;
	}
	public void setJobType(ims.clinical.vo.lookups.DischargeSummaryJobType value)
	{
		this.isValidated = false;
		this.jobtype = value;
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
		if(this.gpname != null)
			if(this.gpname.length() > 255)
				listOfErrors.add("The length of the field [gpname] in the value object [ims.clinical.vo.FailedEmailsDetailsVo] is too big. It should be less or equal to 255");
		if(this.emailaddress != null)
			if(this.emailaddress.length() > 255)
				listOfErrors.add("The length of the field [emailaddress] in the value object [ims.clinical.vo.FailedEmailsDetailsVo] is too big. It should be less or equal to 255");
		if(this.filepath != null)
			if(this.filepath.length() > 255)
				listOfErrors.add("The length of the field [filepath] in the value object [ims.clinical.vo.FailedEmailsDetailsVo] is too big. It should be less or equal to 255");
		if(this.patientname != null)
			if(this.patientname.length() > 255)
				listOfErrors.add("The length of the field [patientname] in the value object [ims.clinical.vo.FailedEmailsDetailsVo] is too big. It should be less or equal to 255");
		if(this.jobtype == null)
			listOfErrors.add("JobType is mandatory");
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
	
		FailedEmailsDetailsVo clone = new FailedEmailsDetailsVo(this.id, this.version);
		
		clone.gpname = this.gpname;
		clone.emailaddress = this.emailaddress;
		if(this.successfuldatetime == null)
			clone.successfuldatetime = null;
		else
			clone.successfuldatetime = (ims.framework.utils.DateTime)this.successfuldatetime.clone();
		if(this.initialdatetime == null)
			clone.initialdatetime = null;
		else
			clone.initialdatetime = (ims.framework.utils.DateTime)this.initialdatetime.clone();
		clone.filepath = this.filepath;
		if(this.faileddatetime == null)
			clone.faileddatetime = null;
		else
			clone.faileddatetime = (ims.framework.utils.DateTime)this.faileddatetime.clone();
		clone.patientname = this.patientname;
		if(this.jobtype == null)
			clone.jobtype = null;
		else
			clone.jobtype = (ims.clinical.vo.lookups.DischargeSummaryJobType)this.jobtype.clone();
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
		if (!(FailedEmailsDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FailedEmailsDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((FailedEmailsDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((FailedEmailsDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.gpname != null)
			count++;
		if(this.emailaddress != null)
			count++;
		if(this.successfuldatetime != null)
			count++;
		if(this.initialdatetime != null)
			count++;
		if(this.filepath != null)
			count++;
		if(this.faileddatetime != null)
			count++;
		if(this.patientname != null)
			count++;
		if(this.jobtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String gpname;
	protected String emailaddress;
	protected ims.framework.utils.DateTime successfuldatetime;
	protected ims.framework.utils.DateTime initialdatetime;
	protected String filepath;
	protected ims.framework.utils.DateTime faileddatetime;
	protected String patientname;
	protected ims.clinical.vo.lookups.DischargeSummaryJobType jobtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
