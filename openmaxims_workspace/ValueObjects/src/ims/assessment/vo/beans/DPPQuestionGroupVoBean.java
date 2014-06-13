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

package ims.assessment.vo.beans;

public class DPPQuestionGroupVoBean extends ims.vo.ValueObjectBean
{
	public DPPQuestionGroupVoBean()
	{
	}
	public DPPQuestionGroupVoBean(ims.assessment.vo.DPPQuestionGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessment = vo.getUserAssessment() == null ? null : (ims.assessment.vo.beans.UserAssessmentLiteVoBean)vo.getUserAssessment().getBean();
		this.group = vo.getGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroup().getBean();
		this.isactive = vo.getIsActive();
		if(vo.getAssessmentQuestions() != null)
		{
			this.assessmentquestions = new ims.vo.RefVoBean[vo.getAssessmentQuestions().size()];
			for(int assessmentquestions_i = 0; assessmentquestions_i < vo.getAssessmentQuestions().size(); assessmentquestions_i++)
			{
				this.assessmentquestions[assessmentquestions_i] = new ims.vo.RefVoBean(vo.getAssessmentQuestions().get(assessmentquestions_i).getBoId(),vo.getAssessmentQuestions().get(assessmentquestions_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.DPPQuestionGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessment = vo.getUserAssessment() == null ? null : (ims.assessment.vo.beans.UserAssessmentLiteVoBean)vo.getUserAssessment().getBean(map);
		this.group = vo.getGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getGroup().getBean();
		this.isactive = vo.getIsActive();
		if(vo.getAssessmentQuestions() != null)
		{
			this.assessmentquestions = new ims.vo.RefVoBean[vo.getAssessmentQuestions().size()];
			for(int assessmentquestions_i = 0; assessmentquestions_i < vo.getAssessmentQuestions().size(); assessmentquestions_i++)
			{
				this.assessmentquestions[assessmentquestions_i] = new ims.vo.RefVoBean(vo.getAssessmentQuestions().get(assessmentquestions_i).getBoId(),vo.getAssessmentQuestions().get(assessmentquestions_i).getBoVersion());
			}
		}
	}

	public ims.assessment.vo.DPPQuestionGroupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.DPPQuestionGroupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.DPPQuestionGroupVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.DPPQuestionGroupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.DPPQuestionGroupVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.assessment.vo.beans.UserAssessmentLiteVoBean getUserAssessment()
	{
		return this.userassessment;
	}
	public void setUserAssessment(ims.assessment.vo.beans.UserAssessmentLiteVoBean value)
	{
		this.userassessment = value;
	}
	public ims.vo.LookupInstanceBean getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.vo.LookupInstanceBean value)
	{
		this.group = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.RefVoBean[] getAssessmentQuestions()
	{
		return this.assessmentquestions;
	}
	public void setAssessmentQuestions(ims.vo.RefVoBean[] value)
	{
		this.assessmentquestions = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.UserAssessmentLiteVoBean userassessment;
	private ims.vo.LookupInstanceBean group;
	private Boolean isactive;
	private ims.vo.RefVoBean[] assessmentquestions;
}
