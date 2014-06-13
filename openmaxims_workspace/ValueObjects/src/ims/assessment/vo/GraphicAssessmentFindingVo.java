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
 * Linked to Assessment.Configuration.GraphicAssessmentFinding business object (ID: 1028100014).
 */
public class GraphicAssessmentFindingVo extends ims.assessment.configuration.vo.GraphicAssessmentFindingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GraphicAssessmentFindingVo()
	{
	}
	public GraphicAssessmentFindingVo(Integer id, int version)
	{
		super(id, version);
	}
	public GraphicAssessmentFindingVo(ims.assessment.vo.beans.GraphicAssessmentFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.finding = bean.getFinding() == null ? null : bean.getFinding().buildVo();
		this.sequence = bean.getSequence();
		this.findingstage = ims.assessment.vo.FindingStageQuestionsVoCollection.buildFromBeanCollection(bean.getFindingStage());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.GraphicAssessmentFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.finding = bean.getFinding() == null ? null : bean.getFinding().buildVo(map);
		this.sequence = bean.getSequence();
		this.findingstage = ims.assessment.vo.FindingStageQuestionsVoCollection.buildFromBeanCollection(bean.getFindingStage());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.GraphicAssessmentFindingVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.GraphicAssessmentFindingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.GraphicAssessmentFindingVoBean();
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
		if(fieldName.equals("FINDING"))
			return getFinding();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("FINDINGSTAGE"))
			return getFindingStage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFindingIsNotNull()
	{
		return this.finding != null;
	}
	public ims.core.vo.DrawingGraphicFindingVo getFinding()
	{
		return this.finding;
	}
	public void setFinding(ims.core.vo.DrawingGraphicFindingVo value)
	{
		this.isValidated = false;
		this.finding = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getFindingStageIsNotNull()
	{
		return this.findingstage != null;
	}
	public ims.assessment.vo.FindingStageQuestionsVoCollection getFindingStage()
	{
		return this.findingstage;
	}
	public void setFindingStage(ims.assessment.vo.FindingStageQuestionsVoCollection value)
	{
		this.isValidated = false;
		this.findingstage = value;
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
		if(this.findingstage != null)
		{
			if(!this.findingstage.isValidated())
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
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.findingstage != null)
		{
			String[] listOfOtherErrors = this.findingstage.validate();
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
	
		GraphicAssessmentFindingVo clone = new GraphicAssessmentFindingVo(this.id, this.version);
		
		if(this.finding == null)
			clone.finding = null;
		else
			clone.finding = (ims.core.vo.DrawingGraphicFindingVo)this.finding.clone();
		clone.sequence = this.sequence;
		if(this.findingstage == null)
			clone.findingstage = null;
		else
			clone.findingstage = (ims.assessment.vo.FindingStageQuestionsVoCollection)this.findingstage.clone();
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
		if (!(GraphicAssessmentFindingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GraphicAssessmentFindingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		GraphicAssessmentFindingVo compareObj = (GraphicAssessmentFindingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
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
		if(this.finding != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.findingstage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.DrawingGraphicFindingVo finding;
	protected Integer sequence;
	protected ims.assessment.vo.FindingStageQuestionsVoCollection findingstage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
