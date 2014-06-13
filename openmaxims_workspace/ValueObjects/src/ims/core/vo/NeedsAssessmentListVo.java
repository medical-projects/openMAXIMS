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
 * Linked to clinical.NeedsAssessment business object (ID: 1072100026).
 */
public class NeedsAssessmentListVo extends ims.clinical.vo.NeedsAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NeedsAssessmentListVo()
	{
	}
	public NeedsAssessmentListVo(Integer id, int version)
	{
		super(id, version);
	}
	public NeedsAssessmentListVo(ims.core.vo.beans.NeedsAssessmentListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goalplanmeetingdate = bean.getGoalPlanMeetingDate() == null ? null : bean.getGoalPlanMeetingDate().buildDate();
		this.needassessmentnumber = bean.getNeedAssessmentNumber() == null ? null : ims.clinical.vo.lookups.NeedsAssessmentNumber.buildLookup(bean.getNeedAssessmentNumber());
		this.hadbooklet = bean.getHadBooklet() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getHadBooklet());
		this.attachbooklettosummarysheet = bean.getAttachBookletToSummarySheet() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAttachBookletToSummarySheet());
		this.datestarted = bean.getDateStarted() == null ? null : bean.getDateStarted().buildDateTime();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.NeedsAssessmentListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.goalplanmeetingdate = bean.getGoalPlanMeetingDate() == null ? null : bean.getGoalPlanMeetingDate().buildDate();
		this.needassessmentnumber = bean.getNeedAssessmentNumber() == null ? null : ims.clinical.vo.lookups.NeedsAssessmentNumber.buildLookup(bean.getNeedAssessmentNumber());
		this.hadbooklet = bean.getHadBooklet() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getHadBooklet());
		this.attachbooklettosummarysheet = bean.getAttachBookletToSummarySheet() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAttachBookletToSummarySheet());
		this.datestarted = bean.getDateStarted() == null ? null : bean.getDateStarted().buildDateTime();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.NeedsAssessmentListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.NeedsAssessmentListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.NeedsAssessmentListVoBean();
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
		if(fieldName.equals("GOALPLANMEETINGDATE"))
			return getGoalPlanMeetingDate();
		if(fieldName.equals("NEEDASSESSMENTNUMBER"))
			return getNeedAssessmentNumber();
		if(fieldName.equals("HADBOOKLET"))
			return getHadBooklet();
		if(fieldName.equals("ATTACHBOOKLETTOSUMMARYSHEET"))
			return getAttachBookletToSummarySheet();
		if(fieldName.equals("DATESTARTED"))
			return getDateStarted();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGoalPlanMeetingDateIsNotNull()
	{
		return this.goalplanmeetingdate != null;
	}
	public ims.framework.utils.Date getGoalPlanMeetingDate()
	{
		return this.goalplanmeetingdate;
	}
	public void setGoalPlanMeetingDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.goalplanmeetingdate = value;
	}
	public boolean getNeedAssessmentNumberIsNotNull()
	{
		return this.needassessmentnumber != null;
	}
	public ims.clinical.vo.lookups.NeedsAssessmentNumber getNeedAssessmentNumber()
	{
		return this.needassessmentnumber;
	}
	public void setNeedAssessmentNumber(ims.clinical.vo.lookups.NeedsAssessmentNumber value)
	{
		this.isValidated = false;
		this.needassessmentnumber = value;
	}
	public boolean getHadBookletIsNotNull()
	{
		return this.hadbooklet != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getHadBooklet()
	{
		return this.hadbooklet;
	}
	public void setHadBooklet(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.hadbooklet = value;
	}
	public boolean getAttachBookletToSummarySheetIsNotNull()
	{
		return this.attachbooklettosummarysheet != null;
	}
	public ims.core.vo.lookups.YesNo getAttachBookletToSummarySheet()
	{
		return this.attachbooklettosummarysheet;
	}
	public void setAttachBookletToSummarySheet(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.attachbooklettosummarysheet = value;
	}
	public boolean getDateStartedIsNotNull()
	{
		return this.datestarted != null;
	}
	public ims.framework.utils.DateTime getDateStarted()
	{
		return this.datestarted;
	}
	public void setDateStarted(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datestarted = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.Hcp getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
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
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
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
		if(this.needassessmentnumber == null)
			listOfErrors.add("NeedAssessmentNumber is mandatory");
		if(this.hadbooklet == null)
			listOfErrors.add("HadBooklet is mandatory");
		if(this.authoringhcp == null)
			listOfErrors.add("AuthoringHCP is mandatory");
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
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
	
		NeedsAssessmentListVo clone = new NeedsAssessmentListVo(this.id, this.version);
		
		if(this.goalplanmeetingdate == null)
			clone.goalplanmeetingdate = null;
		else
			clone.goalplanmeetingdate = (ims.framework.utils.Date)this.goalplanmeetingdate.clone();
		if(this.needassessmentnumber == null)
			clone.needassessmentnumber = null;
		else
			clone.needassessmentnumber = (ims.clinical.vo.lookups.NeedsAssessmentNumber)this.needassessmentnumber.clone();
		if(this.hadbooklet == null)
			clone.hadbooklet = null;
		else
			clone.hadbooklet = (ims.core.vo.lookups.YesNoUnknown)this.hadbooklet.clone();
		if(this.attachbooklettosummarysheet == null)
			clone.attachbooklettosummarysheet = null;
		else
			clone.attachbooklettosummarysheet = (ims.core.vo.lookups.YesNo)this.attachbooklettosummarysheet.clone();
		if(this.datestarted == null)
			clone.datestarted = null;
		else
			clone.datestarted = (ims.framework.utils.DateTime)this.datestarted.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.Hcp)this.authoringhcp.clone();
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
		if (!(NeedsAssessmentListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeedsAssessmentListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NeedsAssessmentListVo compareObj = (NeedsAssessmentListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_NeedsAssessment() == null && compareObj.getID_NeedsAssessment() != null)
				return -1;
			if(this.getID_NeedsAssessment() != null && compareObj.getID_NeedsAssessment() == null)
				return 1;
			if(this.getID_NeedsAssessment() != null && compareObj.getID_NeedsAssessment() != null)
				retVal = this.getID_NeedsAssessment().compareTo(compareObj.getID_NeedsAssessment());
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
		if(this.goalplanmeetingdate != null)
			count++;
		if(this.needassessmentnumber != null)
			count++;
		if(this.hadbooklet != null)
			count++;
		if(this.attachbooklettosummarysheet != null)
			count++;
		if(this.datestarted != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.Date goalplanmeetingdate;
	protected ims.clinical.vo.lookups.NeedsAssessmentNumber needassessmentnumber;
	protected ims.core.vo.lookups.YesNoUnknown hadbooklet;
	protected ims.core.vo.lookups.YesNo attachbooklettosummarysheet;
	protected ims.framework.utils.DateTime datestarted;
	protected ims.core.vo.Hcp authoringhcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
