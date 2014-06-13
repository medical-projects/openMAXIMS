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

package ims.icp.vo.beans;

public class PatientICPStagesFullVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPStagesFullVoBean()
	{
	}
	public PatientICPStagesFullVoBean(ims.icp.vo.PatientICPStagesFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.stage = vo.getStage() == null ? null : new ims.vo.RefVoBean(vo.getStage().getBoId(), vo.getStage().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.completedondate = vo.getCompletedOnDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedOnDate().getBean();
		this.stagephases = vo.getStagePhases() == null ? null : vo.getStagePhases().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPStagesFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.stage = vo.getStage() == null ? null : new ims.vo.RefVoBean(vo.getStage().getBoId(), vo.getStage().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.completedondate = vo.getCompletedOnDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedOnDate().getBean();
		this.stagephases = vo.getStagePhases() == null ? null : vo.getStagePhases().getBeanCollection();
	}

	public ims.icp.vo.PatientICPStagesFullVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPStagesFullVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPStagesFullVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPStagesFullVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPStagesFullVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.vo.RefVoBean value)
	{
		this.icp = value;
	}
	public ims.vo.RefVoBean getStage()
	{
		return this.stage;
	}
	public void setStage(ims.vo.RefVoBean value)
	{
		this.stage = value;
	}
	public ims.icp.vo.beans.PatientICPStageStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.beans.PatientICPStageStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.icp.vo.beans.PatientICPStageStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icp.vo.beans.PatientICPStageStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedOnDate()
	{
		return this.completedondate;
	}
	public void setCompletedOnDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completedondate = value;
	}
	public ims.icp.vo.beans.PatientICPPhasesFullVoBean[] getStagePhases()
	{
		return this.stagephases;
	}
	public void setStagePhases(ims.icp.vo.beans.PatientICPPhasesFullVoBean[] value)
	{
		this.stagephases = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean icp;
	private ims.vo.RefVoBean stage;
	private ims.icp.vo.beans.PatientICPStageStatusVoBean currentstatus;
	private ims.icp.vo.beans.PatientICPStageStatusVoBean[] statushistory;
	private ims.framework.utils.beans.DateTimeBean completedondate;
	private ims.icp.vo.beans.PatientICPPhasesFullVoBean[] stagephases;
}
