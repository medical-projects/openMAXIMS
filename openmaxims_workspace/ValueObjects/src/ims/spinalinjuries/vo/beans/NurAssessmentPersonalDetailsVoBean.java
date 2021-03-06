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

package ims.spinalinjuries.vo.beans;

public class NurAssessmentPersonalDetailsVoBean extends ims.vo.ValueObjectBean
{
	public NurAssessmentPersonalDetailsVoBean()
	{
	}
	public NurAssessmentPersonalDetailsVoBean(ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean();
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.sportsinterestshobbies = vo.getSportsInterestsHobbies();
		this.occupation = vo.getOccupation() == null ? null : (ims.vo.LookupInstanceBean)vo.getOccupation().getBean();
		this.usualsleeppattern = vo.getUsualSleepPattern();
		this.takesnightsedation = vo.getTakesNightSedation() == null ? null : (ims.vo.LookupInstanceBean)vo.getTakesNightSedation().getBean();
		this.notes = vo.getNotes();
		this.sexuality = vo.getSexuality();
		this.notappropriatetoask = vo.getNotAppropriateToAsk();
		this.anxietydying = vo.getAnxietyDying();
		this.occupationother = vo.getOccupationOther();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean(map);
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.sportsinterestshobbies = vo.getSportsInterestsHobbies();
		this.occupation = vo.getOccupation() == null ? null : (ims.vo.LookupInstanceBean)vo.getOccupation().getBean();
		this.usualsleeppattern = vo.getUsualSleepPattern();
		this.takesnightsedation = vo.getTakesNightSedation() == null ? null : (ims.vo.LookupInstanceBean)vo.getTakesNightSedation().getBean();
		this.notes = vo.getNotes();
		this.sexuality = vo.getSexuality();
		this.notappropriatetoask = vo.getNotAppropriateToAsk();
		this.anxietydying = vo.getAnxietyDying();
		this.occupationother = vo.getOccupationOther();
	}

	public ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo vo = null;
		if(map != null)
			vo = (ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo();
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
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean[] getAssessmentInfo()
	{
		return this.assessmentinfo;
	}
	public void setAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean[] value)
	{
		this.assessmentinfo = value;
	}
	public Boolean getCopy()
	{
		return this.copy;
	}
	public void setCopy(Boolean value)
	{
		this.copy = value;
	}
	public ims.vo.LookupInstanceBean getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.vo.LookupInstanceBean value)
	{
		this.componenttype = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean getLastAssessmentInfo()
	{
		return this.lastassessmentinfo;
	}
	public void setLastAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean value)
	{
		this.lastassessmentinfo = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean[] getCarePlanTemplate()
	{
		return this.careplantemplate;
	}
	public void setCarePlanTemplate(ims.nursing.vo.beans.CarePlanTemplateBean[] value)
	{
		this.careplantemplate = value;
	}
	public ims.nursing.vo.beans.CarePlanBean[] getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.beans.CarePlanBean[] value)
	{
		this.careplans = value;
	}
	public String getSportsInterestsHobbies()
	{
		return this.sportsinterestshobbies;
	}
	public void setSportsInterestsHobbies(String value)
	{
		this.sportsinterestshobbies = value;
	}
	public ims.vo.LookupInstanceBean getOccupation()
	{
		return this.occupation;
	}
	public void setOccupation(ims.vo.LookupInstanceBean value)
	{
		this.occupation = value;
	}
	public Integer getUsualSleepPattern()
	{
		return this.usualsleeppattern;
	}
	public void setUsualSleepPattern(Integer value)
	{
		this.usualsleeppattern = value;
	}
	public ims.vo.LookupInstanceBean getTakesNightSedation()
	{
		return this.takesnightsedation;
	}
	public void setTakesNightSedation(ims.vo.LookupInstanceBean value)
	{
		this.takesnightsedation = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public String getSexuality()
	{
		return this.sexuality;
	}
	public void setSexuality(String value)
	{
		this.sexuality = value;
	}
	public Boolean getNotAppropriateToAsk()
	{
		return this.notappropriatetoask;
	}
	public void setNotAppropriateToAsk(Boolean value)
	{
		this.notappropriatetoask = value;
	}
	public String getAnxietyDying()
	{
		return this.anxietydying;
	}
	public void setAnxietyDying(String value)
	{
		this.anxietydying = value;
	}
	public String getOccupationOther()
	{
		return this.occupationother;
	}
	public void setOccupationOther(String value)
	{
		this.occupationother = value;
	}

	private Integer id;
	private int version;
	private Boolean iscomplete;
	private ims.nursing.vo.beans.AssessmentInfoBean[] assessmentinfo;
	private Boolean copy;
	private ims.vo.LookupInstanceBean componenttype;
	private ims.nursing.vo.beans.AssessmentInfoBean lastassessmentinfo;
	private ims.nursing.vo.beans.CarePlanTemplateBean[] careplantemplate;
	private ims.nursing.vo.beans.CarePlanBean[] careplans;
	private String sportsinterestshobbies;
	private ims.vo.LookupInstanceBean occupation;
	private Integer usualsleeppattern;
	private ims.vo.LookupInstanceBean takesnightsedation;
	private String notes;
	private String sexuality;
	private Boolean notappropriatetoask;
	private String anxietydying;
	private String occupationother;
}
