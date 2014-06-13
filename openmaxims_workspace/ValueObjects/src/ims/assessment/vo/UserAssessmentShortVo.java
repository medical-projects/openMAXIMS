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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.UserAssessment business object (ID: 1003100043).
 */
public class UserAssessmentShortVo extends ims.assessment.vo.UserAssessmentLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserAssessmentShortVo()
	{
	}
	public UserAssessmentShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserAssessmentShortVo(ims.assessment.vo.beans.UserAssessmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.helpurl = bean.getHelpURL();
		this.systeminfo = bean.getSystemInfo() == null ? null : bean.getSystemInfo().buildSystemInformation();
		this.scoringmethod = bean.getScoringMethod() == null ? null : ims.core.vo.lookups.UserAssessmentScoringMethod.buildLookup(bean.getScoringMethod());
		this.isflatview = bean.getIsFlatView();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.ismultiplegroup = bean.getIsMultipleGroup();
		this.groupquestionwidth = bean.getGroupQuestionWidth();
		this.storeprintedassessment = bean.getStorePrintedAssessment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.UserAssessmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.helpurl = bean.getHelpURL();
		this.systeminfo = bean.getSystemInfo() == null ? null : bean.getSystemInfo().buildSystemInformation();
		this.scoringmethod = bean.getScoringMethod() == null ? null : ims.core.vo.lookups.UserAssessmentScoringMethod.buildLookup(bean.getScoringMethod());
		this.isflatview = bean.getIsFlatView();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.ismultiplegroup = bean.getIsMultipleGroup();
		this.groupquestionwidth = bean.getGroupQuestionWidth();
		this.storeprintedassessment = bean.getStorePrintedAssessment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.UserAssessmentShortVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.UserAssessmentShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.UserAssessmentShortVoBean();
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
		if(fieldName.equals("SCORINGMETHOD"))
			return getScoringMethod();
		if(fieldName.equals("ISFLATVIEW"))
			return getIsFlatView();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("ISMULTIPLEGROUP"))
			return getIsMultipleGroup();
		if(fieldName.equals("GROUPQUESTIONWIDTH"))
			return getGroupQuestionWidth();
		if(fieldName.equals("STOREPRINTEDASSESSMENT"))
			return getStorePrintedAssessment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getScoringMethodIsNotNull()
	{
		return this.scoringmethod != null;
	}
	public ims.core.vo.lookups.UserAssessmentScoringMethod getScoringMethod()
	{
		return this.scoringmethod;
	}
	public void setScoringMethod(ims.core.vo.lookups.UserAssessmentScoringMethod value)
	{
		this.isValidated = false;
		this.scoringmethod = value;
	}
	public boolean getIsFlatViewIsNotNull()
	{
		return this.isflatview != null;
	}
	public Boolean getIsFlatView()
	{
		return this.isflatview;
	}
	public void setIsFlatView(Boolean value)
	{
		this.isValidated = false;
		this.isflatview = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.UserAssessmentCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.UserAssessmentCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getIsMultipleGroupIsNotNull()
	{
		return this.ismultiplegroup != null;
	}
	public Boolean getIsMultipleGroup()
	{
		return this.ismultiplegroup;
	}
	public void setIsMultipleGroup(Boolean value)
	{
		this.isValidated = false;
		this.ismultiplegroup = value;
	}
	public boolean getGroupQuestionWidthIsNotNull()
	{
		return this.groupquestionwidth != null;
	}
	public Integer getGroupQuestionWidth()
	{
		return this.groupquestionwidth;
	}
	public void setGroupQuestionWidth(Integer value)
	{
		this.isValidated = false;
		this.groupquestionwidth = value;
	}
	public boolean getStorePrintedAssessmentIsNotNull()
	{
		return this.storeprintedassessment != null;
	}
	public Boolean getStorePrintedAssessment()
	{
		return this.storeprintedassessment;
	}
	public void setStorePrintedAssessment(Boolean value)
	{
		this.isValidated = false;
		this.storeprintedassessment = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.assessment.vo.UserAssessmentShortVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.assessment.vo.UserAssessmentShortVo] is too big. It should be less or equal to 500");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 150)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.assessment.vo.UserAssessmentShortVo] is too big. It should be less or equal to 150");
		if(this.isflatview == null)
			listOfErrors.add("isFlatView is mandatory");
		if(this.groupquestionwidth != null && (this.groupquestionwidth.intValue() < 50 || this.groupquestionwidth.intValue() > 600))
			listOfErrors.add("Group Question Width has an invalid value. The valid range of values is between 50 and 600");
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
	
		UserAssessmentShortVo clone = new UserAssessmentShortVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.assessmenttype == null)
			clone.assessmenttype = null;
		else
			clone.assessmenttype = (ims.core.vo.lookups.UserDefinedAssessmentType)this.assessmenttype.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		clone.helpurl = this.helpurl;
		if(this.systeminfo == null)
			clone.systeminfo = null;
		else
			clone.systeminfo = (ims.vo.SystemInformation)this.systeminfo.clone();
		if(this.scoringmethod == null)
			clone.scoringmethod = null;
		else
			clone.scoringmethod = (ims.core.vo.lookups.UserAssessmentScoringMethod)this.scoringmethod.clone();
		clone.isflatview = this.isflatview;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.UserAssessmentCategory)this.category.clone();
		clone.ismultiplegroup = this.ismultiplegroup;
		clone.groupquestionwidth = this.groupquestionwidth;
		clone.storeprintedassessment = this.storeprintedassessment;
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
		if (!(UserAssessmentShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserAssessmentShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserAssessmentShortVo compareObj = (UserAssessmentShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSystemInfo() == null && compareObj.getSystemInfo() != null)
				return -1;
			if(this.getSystemInfo() != null && compareObj.getSystemInfo() == null)
				return 1;
			if(this.getSystemInfo() != null && compareObj.getSystemInfo() != null)
				retVal = this.getSystemInfo().compareTo(compareObj.getSystemInfo());
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
		if(this.scoringmethod != null)
			count++;
		if(this.isflatview != null)
			count++;
		if(this.category != null)
			count++;
		if(this.ismultiplegroup != null)
			count++;
		if(this.groupquestionwidth != null)
			count++;
		if(this.storeprintedassessment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.core.vo.lookups.UserAssessmentScoringMethod scoringmethod;
	protected Boolean isflatview;
	protected ims.core.vo.lookups.UserAssessmentCategory category;
	protected Boolean ismultiplegroup;
	protected Integer groupquestionwidth;
	protected Boolean storeprintedassessment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
