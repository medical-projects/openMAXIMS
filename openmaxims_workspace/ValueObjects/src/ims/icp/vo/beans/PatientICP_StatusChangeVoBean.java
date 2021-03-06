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

public class PatientICP_StatusChangeVoBean extends ims.vo.ValueObjectBean
{
	public PatientICP_StatusChangeVoBean()
	{
	}
	public PatientICP_StatusChangeVoBean(ims.icp.vo.PatientICP_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICP_StatusChangeVoBean)vo.getICP().getBean();
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICP_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICP_StatusChangeVoBean)vo.getICP().getBean(map);
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
	}

	public ims.icp.vo.PatientICP_StatusChangeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICP_StatusChangeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICP_StatusChangeVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICP_StatusChangeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICP_StatusChangeVo();
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
	public ims.icp.vo.beans.ICP_StatusChangeVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icp.vo.beans.ICP_StatusChangeVoBean value)
	{
		this.icp = value;
	}
	public ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean[] getStages()
	{
		return this.stages;
	}
	public void setStages(ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean[] value)
	{
		this.stages = value;
	}
	public Boolean getHasOutstandingAdminActions()
	{
		return this.hasoutstandingadminactions;
	}
	public void setHasOutstandingAdminActions(Boolean value)
	{
		this.hasoutstandingadminactions = value;
	}
	public Boolean getHasOutstandingNursingActions()
	{
		return this.hasoutstandingnursingactions;
	}
	public void setHasOutstandingNursingActions(Boolean value)
	{
		this.hasoutstandingnursingactions = value;
	}
	public Boolean getHasOutstandingPhysioActions()
	{
		return this.hasoutstandingphysioactions;
	}
	public void setHasOutstandingPhysioActions(Boolean value)
	{
		this.hasoutstandingphysioactions = value;
	}
	public Boolean getHasOutstandingClinicalActions()
	{
		return this.hasoutstandingclinicalactions;
	}
	public void setHasOutstandingClinicalActions(Boolean value)
	{
		this.hasoutstandingclinicalactions = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.icp.vo.beans.ICP_StatusChangeVoBean icp;
	private ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean[] stages;
	private Boolean hasoutstandingadminactions;
	private Boolean hasoutstandingnursingactions;
	private Boolean hasoutstandingphysioactions;
	private Boolean hasoutstandingclinicalactions;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
}
