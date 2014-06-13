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
 * Linked to core.clinical.GeneralQuestionAnswer business object (ID: 1003100072).
 */
public class GeneralQuestionAnswerVo extends ims.core.clinical.vo.GeneralQuestionAnswerRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IQuestionType
{
	private static final long serialVersionUID = 1L;

	public GeneralQuestionAnswerVo()
	{
	}
	public GeneralQuestionAnswerVo(Integer id, int version)
	{
		super(id, version);
	}
	public GeneralQuestionAnswerVo(ims.core.vo.beans.GeneralQuestionAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patientanswers = ims.assessment.vo.PatientAssessmentAnswerVoCollection.buildFromBeanCollection(bean.getPatientAnswers());
		this.question = bean.getQuestion() == null ? null : bean.getQuestion().buildVo();
		this.questiongroup = bean.getQuestionGroup() == null ? null : ims.ocrr.vo.lookups.OrderQuestionType.buildLookup(bean.getQuestionGroup());
		this.wasmandatory = bean.getWasMandatory();
		this.itemname = bean.getItemName();
		this.itemid = bean.getItemId();
		this.parentid = bean.getParentid();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.GeneralQuestionAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patientanswers = ims.assessment.vo.PatientAssessmentAnswerVoCollection.buildFromBeanCollection(bean.getPatientAnswers());
		this.question = bean.getQuestion() == null ? null : bean.getQuestion().buildVo(map);
		this.questiongroup = bean.getQuestionGroup() == null ? null : ims.ocrr.vo.lookups.OrderQuestionType.buildLookup(bean.getQuestionGroup());
		this.wasmandatory = bean.getWasMandatory();
		this.itemname = bean.getItemName();
		this.itemid = bean.getItemId();
		this.parentid = bean.getParentid();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.GeneralQuestionAnswerVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.GeneralQuestionAnswerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.GeneralQuestionAnswerVoBean();
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
		if(fieldName.equals("PATIENTANSWERS"))
			return getPatientAnswers();
		if(fieldName.equals("QUESTION"))
			return getQuestion();
		if(fieldName.equals("QUESTIONGROUP"))
			return getQuestionGroup();
		if(fieldName.equals("WASMANDATORY"))
			return getWasMandatory();
		if(fieldName.equals("ITEMNAME"))
			return getItemName();
		if(fieldName.equals("ITEMID"))
			return getItemId();
		if(fieldName.equals("PARENTID"))
			return getParentid();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientAnswersIsNotNull()
	{
		return this.patientanswers != null;
	}
	public ims.assessment.vo.PatientAssessmentAnswerVoCollection getPatientAnswers()
	{
		return this.patientanswers;
	}
	public void setPatientAnswers(ims.assessment.vo.PatientAssessmentAnswerVoCollection value)
	{
		this.isValidated = false;
		this.patientanswers = value;
	}
	public boolean getQuestionIsNotNull()
	{
		return this.question != null;
	}
	public ims.core.vo.QuestionInformationShortVo getQuestion()
	{
		return this.question;
	}
	public void setQuestion(ims.core.vo.QuestionInformationShortVo value)
	{
		this.isValidated = false;
		this.question = value;
	}
	public boolean getQuestionGroupIsNotNull()
	{
		return this.questiongroup != null;
	}
	public ims.ocrr.vo.lookups.OrderQuestionType getQuestionGroup()
	{
		return this.questiongroup;
	}
	public void setQuestionGroup(ims.ocrr.vo.lookups.OrderQuestionType value)
	{
		this.isValidated = false;
		this.questiongroup = value;
	}
	public boolean getWasMandatoryIsNotNull()
	{
		return this.wasmandatory != null;
	}
	public Boolean getWasMandatory()
	{
		return this.wasmandatory;
	}
	public void setWasMandatory(Boolean value)
	{
		this.isValidated = false;
		this.wasmandatory = value;
	}
	public boolean getItemNameIsNotNull()
	{
		return this.itemname != null;
	}
	public String getItemName()
	{
		return this.itemname;
	}
	public static int getItemNameMaxLength()
	{
		return 255;
	}
	public void setItemName(String value)
	{
		this.isValidated = false;
		this.itemname = value;
	}
	public boolean getItemIdIsNotNull()
	{
		return this.itemid != null;
	}
	public Integer getItemId()
	{
		return this.itemid;
	}
	public void setItemId(Integer value)
	{
		this.isValidated = false;
		this.itemid = value;
	}
	public boolean getParentidIsNotNull()
	{
		return this.parentid != null;
	}
	public Integer getParentid()
	{
		return this.parentid;
	}
	public void setParentid(Integer value)
	{
		this.isValidated = false;
		this.parentid = value;
	}
	/**
	* getIQuestionType interface methods
	*/
	public ims.core.vo.QuestionInformationShortVo getIQuestionTypeQuestion() 
	{
		return this.question;
	}
	public ims.ocrr.vo.lookups.OrderQuestionType getIQuestionTypeOrderQuestionType() 
	{
		return this.questiongroup;
	}
	public Boolean getIQuestionTypeIsMandatory()
	{
		return getWasMandatory();
	}
	public String getIQuestionTypeItemName()
	{
		return "";
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
		if(this.patientanswers != null)
		{
			if(!this.patientanswers.isValidated())
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
		if(this.patientanswers != null)
		{
			String[] listOfOtherErrors = this.patientanswers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.question == null)
			listOfErrors.add("Question is mandatory");
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
	
		GeneralQuestionAnswerVo clone = new GeneralQuestionAnswerVo(this.id, this.version);
		
		if(this.patientanswers == null)
			clone.patientanswers = null;
		else
			clone.patientanswers = (ims.assessment.vo.PatientAssessmentAnswerVoCollection)this.patientanswers.clone();
		if(this.question == null)
			clone.question = null;
		else
			clone.question = (ims.core.vo.QuestionInformationShortVo)this.question.clone();
		if(this.questiongroup == null)
			clone.questiongroup = null;
		else
			clone.questiongroup = (ims.ocrr.vo.lookups.OrderQuestionType)this.questiongroup.clone();
		clone.wasmandatory = this.wasmandatory;
		clone.itemname = this.itemname;
		clone.itemid = this.itemid;
		clone.parentid = this.parentid;
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
		if (!(GeneralQuestionAnswerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GeneralQuestionAnswerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GeneralQuestionAnswerVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GeneralQuestionAnswerVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patientanswers != null)
			count++;
		if(this.question != null)
			count++;
		if(this.questiongroup != null)
			count++;
		if(this.wasmandatory != null)
			count++;
		if(this.itemname != null)
			count++;
		if(this.itemid != null)
			count++;
		if(this.parentid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.assessment.vo.PatientAssessmentAnswerVoCollection patientanswers;
	protected ims.core.vo.QuestionInformationShortVo question;
	protected ims.ocrr.vo.lookups.OrderQuestionType questiongroup;
	protected Boolean wasmandatory;
	protected String itemname;
	protected Integer itemid;
	protected Integer parentid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
