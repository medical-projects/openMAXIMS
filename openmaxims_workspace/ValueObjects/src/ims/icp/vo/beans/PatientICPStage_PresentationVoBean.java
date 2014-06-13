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

public class PatientICPStage_PresentationVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPStage_PresentationVoBean()
	{
	}
	public PatientICPStage_PresentationVoBean(ims.icp.vo.PatientICPStage_PresentationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.stage = vo.getStage() == null ? null : (ims.icp.vo.beans.ICPStageLiteVoBean)vo.getStage().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean();
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPStage_PresentationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.stage = vo.getStage() == null ? null : (ims.icp.vo.beans.ICPStageLiteVoBean)vo.getStage().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
	}

	public ims.icp.vo.PatientICPStage_PresentationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPStage_PresentationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPStage_PresentationVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPStage_PresentationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPStage_PresentationVo();
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
	public ims.vo.RefVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.vo.RefVoBean value)
	{
		this.icp = value;
	}
	public ims.icp.vo.beans.ICPStageLiteVoBean getStage()
	{
		return this.stage;
	}
	public void setStage(ims.icp.vo.beans.ICPStageLiteVoBean value)
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
	public ims.icp.vo.beans.PatientICPPhase_PresentationVoBean[] getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.beans.PatientICPPhase_PresentationVoBean[] value)
	{
		this.phases = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean icp;
	private ims.icp.vo.beans.ICPStageLiteVoBean stage;
	private ims.icp.vo.beans.PatientICPStageStatusVoBean currentstatus;
	private ims.icp.vo.beans.PatientICPPhase_PresentationVoBean[] phases;
}
