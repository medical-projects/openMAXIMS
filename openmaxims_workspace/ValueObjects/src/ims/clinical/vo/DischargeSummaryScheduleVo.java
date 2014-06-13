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
 * Linked to eDischarge.DischargeSummarySchedule business object (ID: 1099100005).
 */
public class DischargeSummaryScheduleVo extends ims.edischarge.vo.DischargeSummaryScheduleRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeSummaryScheduleVo()
	{
	}
	public DischargeSummaryScheduleVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeSummaryScheduleVo(ims.clinical.vo.beans.DischargeSummaryScheduleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.printagentto = bean.getPrintAgentTo();
		this.triggerfrequency = bean.getTriggerFrequency();
		this.repeatinterval = bean.getRepeatInterval();
		this.jobtype = bean.getJobType() == null ? null : ims.clinical.vo.lookups.DischargeSummaryJobType.buildLookup(bean.getJobType());
		this.generatedleettersno = bean.getGeneratedLeettersNo();
		this.successfulemailsno = bean.getSuccessfulEmailsNo();
		this.failedemailsno = bean.getFailedEmailsNo();
		this.printedlettersno = bean.getPrintedLettersNo();
		this.failedemails = ims.clinical.vo.FailedEmailsDetailsVoCollection.buildFromBeanCollection(bean.getFailedEmails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DischargeSummaryScheduleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.printagentto = bean.getPrintAgentTo();
		this.triggerfrequency = bean.getTriggerFrequency();
		this.repeatinterval = bean.getRepeatInterval();
		this.jobtype = bean.getJobType() == null ? null : ims.clinical.vo.lookups.DischargeSummaryJobType.buildLookup(bean.getJobType());
		this.generatedleettersno = bean.getGeneratedLeettersNo();
		this.successfulemailsno = bean.getSuccessfulEmailsNo();
		this.failedemailsno = bean.getFailedEmailsNo();
		this.printedlettersno = bean.getPrintedLettersNo();
		this.failedemails = ims.clinical.vo.FailedEmailsDetailsVoCollection.buildFromBeanCollection(bean.getFailedEmails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DischargeSummaryScheduleVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DischargeSummaryScheduleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DischargeSummaryScheduleVoBean();
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
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("LASTRUN"))
			return getLastRun();
		if(fieldName.equals("NEXTRUN"))
			return getNextRun();
		if(fieldName.equals("PRINTAGENTTO"))
			return getPrintAgentTo();
		if(fieldName.equals("TRIGGERFREQUENCY"))
			return getTriggerFrequency();
		if(fieldName.equals("REPEATINTERVAL"))
			return getRepeatInterval();
		if(fieldName.equals("JOBTYPE"))
			return getJobType();
		if(fieldName.equals("GENERATEDLEETTERSNO"))
			return getGeneratedLeettersNo();
		if(fieldName.equals("SUCCESSFULEMAILSNO"))
			return getSuccessfulEmailsNo();
		if(fieldName.equals("FAILEDEMAILSNO"))
			return getFailedEmailsNo();
		if(fieldName.equals("PRINTEDLETTERSNO"))
			return getPrintedLettersNo();
		if(fieldName.equals("FAILEDEMAILS"))
			return getFailedEmails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.Date getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.creationdate = value;
	}
	public boolean getLastRunIsNotNull()
	{
		return this.lastrun != null;
	}
	public ims.framework.utils.DateTime getLastRun()
	{
		return this.lastrun;
	}
	public void setLastRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastrun = value;
	}
	public boolean getNextRunIsNotNull()
	{
		return this.nextrun != null;
	}
	public ims.framework.utils.DateTime getNextRun()
	{
		return this.nextrun;
	}
	public void setNextRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.nextrun = value;
	}
	public boolean getPrintAgentToIsNotNull()
	{
		return this.printagentto != null;
	}
	public String getPrintAgentTo()
	{
		return this.printagentto;
	}
	public static int getPrintAgentToMaxLength()
	{
		return 500;
	}
	public void setPrintAgentTo(String value)
	{
		this.isValidated = false;
		this.printagentto = value;
	}
	public boolean getTriggerFrequencyIsNotNull()
	{
		return this.triggerfrequency != null;
	}
	public String getTriggerFrequency()
	{
		return this.triggerfrequency;
	}
	public static int getTriggerFrequencyMaxLength()
	{
		return 255;
	}
	public void setTriggerFrequency(String value)
	{
		this.isValidated = false;
		this.triggerfrequency = value;
	}
	public boolean getRepeatIntervalIsNotNull()
	{
		return this.repeatinterval != null;
	}
	public String getRepeatInterval()
	{
		return this.repeatinterval;
	}
	public static int getRepeatIntervalMaxLength()
	{
		return 255;
	}
	public void setRepeatInterval(String value)
	{
		this.isValidated = false;
		this.repeatinterval = value;
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
	public boolean getGeneratedLeettersNoIsNotNull()
	{
		return this.generatedleettersno != null;
	}
	public Integer getGeneratedLeettersNo()
	{
		return this.generatedleettersno;
	}
	public void setGeneratedLeettersNo(Integer value)
	{
		this.isValidated = false;
		this.generatedleettersno = value;
	}
	public boolean getSuccessfulEmailsNoIsNotNull()
	{
		return this.successfulemailsno != null;
	}
	public Integer getSuccessfulEmailsNo()
	{
		return this.successfulemailsno;
	}
	public void setSuccessfulEmailsNo(Integer value)
	{
		this.isValidated = false;
		this.successfulemailsno = value;
	}
	public boolean getFailedEmailsNoIsNotNull()
	{
		return this.failedemailsno != null;
	}
	public Integer getFailedEmailsNo()
	{
		return this.failedemailsno;
	}
	public void setFailedEmailsNo(Integer value)
	{
		this.isValidated = false;
		this.failedemailsno = value;
	}
	public boolean getPrintedLettersNoIsNotNull()
	{
		return this.printedlettersno != null;
	}
	public Integer getPrintedLettersNo()
	{
		return this.printedlettersno;
	}
	public void setPrintedLettersNo(Integer value)
	{
		this.isValidated = false;
		this.printedlettersno = value;
	}
	public boolean getFailedEmailsIsNotNull()
	{
		return this.failedemails != null;
	}
	public ims.clinical.vo.FailedEmailsDetailsVoCollection getFailedEmails()
	{
		return this.failedemails;
	}
	public void setFailedEmails(ims.clinical.vo.FailedEmailsDetailsVoCollection value)
	{
		this.isValidated = false;
		this.failedemails = value;
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
		if(this.failedemails != null)
		{
			if(!this.failedemails.isValidated())
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
		if(this.nextrun == null)
			listOfErrors.add("NextRun is mandatory");
		if(this.printagentto != null)
			if(this.printagentto.length() > 500)
				listOfErrors.add("The length of the field [printagentto] in the value object [ims.clinical.vo.DischargeSummaryScheduleVo] is too big. It should be less or equal to 500");
		if(this.triggerfrequency != null)
			if(this.triggerfrequency.length() > 255)
				listOfErrors.add("The length of the field [triggerfrequency] in the value object [ims.clinical.vo.DischargeSummaryScheduleVo] is too big. It should be less or equal to 255");
		if(this.repeatinterval != null)
			if(this.repeatinterval.length() > 255)
				listOfErrors.add("The length of the field [repeatinterval] in the value object [ims.clinical.vo.DischargeSummaryScheduleVo] is too big. It should be less or equal to 255");
		if(this.jobtype == null)
			listOfErrors.add("JobType is mandatory");
		if(this.failedemails != null)
		{
			String[] listOfOtherErrors = this.failedemails.validate();
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
	
		DischargeSummaryScheduleVo clone = new DischargeSummaryScheduleVo(this.id, this.version);
		
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.Date)this.creationdate.clone();
		if(this.lastrun == null)
			clone.lastrun = null;
		else
			clone.lastrun = (ims.framework.utils.DateTime)this.lastrun.clone();
		if(this.nextrun == null)
			clone.nextrun = null;
		else
			clone.nextrun = (ims.framework.utils.DateTime)this.nextrun.clone();
		clone.printagentto = this.printagentto;
		clone.triggerfrequency = this.triggerfrequency;
		clone.repeatinterval = this.repeatinterval;
		if(this.jobtype == null)
			clone.jobtype = null;
		else
			clone.jobtype = (ims.clinical.vo.lookups.DischargeSummaryJobType)this.jobtype.clone();
		clone.generatedleettersno = this.generatedleettersno;
		clone.successfulemailsno = this.successfulemailsno;
		clone.failedemailsno = this.failedemailsno;
		clone.printedlettersno = this.printedlettersno;
		if(this.failedemails == null)
			clone.failedemails = null;
		else
			clone.failedemails = (ims.clinical.vo.FailedEmailsDetailsVoCollection)this.failedemails.clone();
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
		if (!(DischargeSummaryScheduleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeSummaryScheduleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeSummaryScheduleVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeSummaryScheduleVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.creationdate != null)
			count++;
		if(this.lastrun != null)
			count++;
		if(this.nextrun != null)
			count++;
		if(this.printagentto != null)
			count++;
		if(this.triggerfrequency != null)
			count++;
		if(this.repeatinterval != null)
			count++;
		if(this.jobtype != null)
			count++;
		if(this.generatedleettersno != null)
			count++;
		if(this.successfulemailsno != null)
			count++;
		if(this.failedemailsno != null)
			count++;
		if(this.printedlettersno != null)
			count++;
		if(this.failedemails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.framework.utils.Date creationdate;
	protected ims.framework.utils.DateTime lastrun;
	protected ims.framework.utils.DateTime nextrun;
	protected String printagentto;
	protected String triggerfrequency;
	protected String repeatinterval;
	protected ims.clinical.vo.lookups.DischargeSummaryJobType jobtype;
	protected Integer generatedleettersno;
	protected Integer successfulemailsno;
	protected Integer failedemailsno;
	protected Integer printedlettersno;
	protected ims.clinical.vo.FailedEmailsDetailsVoCollection failedemails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
