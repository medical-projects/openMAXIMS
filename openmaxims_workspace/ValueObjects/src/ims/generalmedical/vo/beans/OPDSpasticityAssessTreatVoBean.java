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

package ims.generalmedical.vo.beans;

public class OPDSpasticityAssessTreatVoBean extends ims.vo.ValueObjectBean
{
	public OPDSpasticityAssessTreatVoBean()
	{
	}
	public OPDSpasticityAssessTreatVoBean(ims.generalmedical.vo.OPDSpasticityAssessTreatVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatgoals = vo.getTreatGoals() == null ? null : vo.getTreatGoals().getBeanCollection();
		this.treatmentplan = vo.getTreatmentPlan() == null ? null : vo.getTreatmentPlan().getBeanCollection();
		this.botulismtreatment = vo.getBotulismTreatment() == null ? null : vo.getBotulismTreatment().getBeanCollection();
		this.jointcontracture = vo.getJointContracture();
		this.limbfinding = vo.getLimbFinding() == null ? null : vo.getLimbFinding().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.OPDSpasticityAssessTreatVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatgoals = vo.getTreatGoals() == null ? null : vo.getTreatGoals().getBeanCollection();
		this.treatmentplan = vo.getTreatmentPlan() == null ? null : vo.getTreatmentPlan().getBeanCollection();
		this.botulismtreatment = vo.getBotulismTreatment() == null ? null : vo.getBotulismTreatment().getBeanCollection();
		this.jointcontracture = vo.getJointContracture();
		this.limbfinding = vo.getLimbFinding() == null ? null : vo.getLimbFinding().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
	}

	public ims.generalmedical.vo.OPDSpasticityAssessTreatVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.OPDSpasticityAssessTreatVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.OPDSpasticityAssessTreatVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.OPDSpasticityAssessTreatVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.OPDSpasticityAssessTreatVo();
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
	public ims.generalmedical.vo.beans.OPDSpasticityAssessTreatGoalVoBean[] getTreatGoals()
	{
		return this.treatgoals;
	}
	public void setTreatGoals(ims.generalmedical.vo.beans.OPDSpasticityAssessTreatGoalVoBean[] value)
	{
		this.treatgoals = value;
	}
	public java.util.Collection getTreatmentPlan()
	{
		return this.treatmentplan;
	}
	public void setTreatmentPlan(java.util.Collection value)
	{
		this.treatmentplan = value;
	}
	public void addTreatmentPlan(java.util.Collection value)
	{
		if(this.treatmentplan == null)
			this.treatmentplan = new java.util.ArrayList();
		this.treatmentplan.add(value);
	}
	public java.util.Collection getBotulismTreatment()
	{
		return this.botulismtreatment;
	}
	public void setBotulismTreatment(java.util.Collection value)
	{
		this.botulismtreatment = value;
	}
	public void addBotulismTreatment(java.util.Collection value)
	{
		if(this.botulismtreatment == null)
			this.botulismtreatment = new java.util.ArrayList();
		this.botulismtreatment.add(value);
	}
	public String getJointContracture()
	{
		return this.jointcontracture;
	}
	public void setJointContracture(String value)
	{
		this.jointcontracture = value;
	}
	public ims.generalmedical.vo.beans.OPDSpasAssLimbsVoBean[] getLimbFinding()
	{
		return this.limbfinding;
	}
	public void setLimbFinding(ims.generalmedical.vo.beans.OPDSpasAssLimbsVoBean[] value)
	{
		this.limbfinding = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}

	private Integer id;
	private int version;
	private ims.generalmedical.vo.beans.OPDSpasticityAssessTreatGoalVoBean[] treatgoals;
	private java.util.Collection treatmentplan;
	private java.util.Collection botulismtreatment;
	private String jointcontracture;
	private ims.generalmedical.vo.beans.OPDSpasAssLimbsVoBean[] limbfinding;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
}
