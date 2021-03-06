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
 * Linked to Assessment.Instantiation.PatientAssessmentAnswer business object (ID: 1003100061).
 */
public class Patient_AssessmentAnswerVo extends ims.assessment.instantiation.vo.PatientAssessmentAnswerRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Patient_AssessmentAnswerVo()
	{
	}
	public Patient_AssessmentAnswerVo(Integer id, int version)
	{
		super(id, version);
	}
	public Patient_AssessmentAnswerVo(ims.assessment.vo.beans.Patient_AssessmentAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerdetails = ims.assessment.vo.Answer_DetailsVoCollection.buildFromBeanCollection(bean.getAnswerDetails());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : new ims.core.clinical.vo.AuthoringInformationRefVo(new Integer(bean.getAuthoringInfo().getId()), bean.getAuthoringInfo().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.Patient_AssessmentAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerdetails = ims.assessment.vo.Answer_DetailsVoCollection.buildFromBeanCollection(bean.getAnswerDetails());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : new ims.core.clinical.vo.AuthoringInformationRefVo(new Integer(bean.getAuthoringInfo().getId()), bean.getAuthoringInfo().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.Patient_AssessmentAnswerVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.Patient_AssessmentAnswerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.Patient_AssessmentAnswerVoBean();
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
		if(fieldName.equals("ANSWERDETAILS"))
			return getAnswerDetails();
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnswerDetailsIsNotNull()
	{
		return this.answerdetails != null;
	}
	public ims.assessment.vo.Answer_DetailsVoCollection getAnswerDetails()
	{
		return this.answerdetails;
	}
	public void setAnswerDetails(ims.assessment.vo.Answer_DetailsVoCollection value)
	{
		this.isValidated = false;
		this.answerdetails = value;
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.clinical.vo.AuthoringInformationRefVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.clinical.vo.AuthoringInformationRefVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
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
		if(this.answerdetails != null)
		{
			if(!this.answerdetails.isValidated())
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
		if(this.answerdetails != null)
		{
			String[] listOfOtherErrors = this.answerdetails.validate();
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
	
		Patient_AssessmentAnswerVo clone = new Patient_AssessmentAnswerVo(this.id, this.version);
		
		if(this.answerdetails == null)
			clone.answerdetails = null;
		else
			clone.answerdetails = (ims.assessment.vo.Answer_DetailsVoCollection)this.answerdetails.clone();
		clone.authoringinfo = this.authoringinfo;
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
		if (!(Patient_AssessmentAnswerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Patient_AssessmentAnswerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Patient_AssessmentAnswerVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Patient_AssessmentAnswerVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.answerdetails != null)
			count++;
		if(this.authoringinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.assessment.vo.Answer_DetailsVoCollection answerdetails;
	protected ims.core.clinical.vo.AuthoringInformationRefVo authoringinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
