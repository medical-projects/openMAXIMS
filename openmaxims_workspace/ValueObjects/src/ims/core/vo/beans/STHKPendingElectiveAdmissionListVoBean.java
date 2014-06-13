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

package ims.core.vo.beans;

public class STHKPendingElectiveAdmissionListVoBean extends ims.vo.ValueObjectBean
{
	public STHKPendingElectiveAdmissionListVoBean()
	{
	}
	public STHKPendingElectiveAdmissionListVoBean(ims.core.vo.STHKPendingElectiveAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForSTHKListVoBean)vo.getPasEvent().getBean();
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean();
		this.comments = vo.getComments();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.managementintention = vo.getManagementIntention() == null ? null : (ims.vo.LookupInstanceBean)vo.getManagementIntention().getBean();
		this.procedures = vo.getProcedures() == null ? null : vo.getProcedures().getBeanCollection();
		this.activealerts = vo.getActiveAlerts();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.STHKPendingElectiveAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForSTHKListVoBean)vo.getPasEvent().getBean(map);
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean(map);
		this.comments = vo.getComments();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.managementintention = vo.getManagementIntention() == null ? null : (ims.vo.LookupInstanceBean)vo.getManagementIntention().getBean();
		this.procedures = vo.getProcedures() == null ? null : vo.getProcedures().getBeanCollection();
		this.activealerts = vo.getActiveAlerts();
	}

	public ims.core.vo.STHKPendingElectiveAdmissionListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.STHKPendingElectiveAdmissionListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.STHKPendingElectiveAdmissionListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.STHKPendingElectiveAdmissionListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.STHKPendingElectiveAdmissionListVo();
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
	public ims.core.vo.beans.PasEventForSTHKListVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventForSTHKListVoBean value)
	{
		this.pasevent = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getAllocatedWard()
	{
		return this.allocatedward;
	}
	public void setAllocatedWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.allocatedward = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.framework.utils.beans.DateBean getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.beans.DateBean value)
	{
		this.tcidate = value;
	}
	public ims.framework.utils.beans.TimeBean getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.beans.TimeBean value)
	{
		this.tcitime = value;
	}
	public ims.vo.LookupInstanceBean getManagementIntention()
	{
		return this.managementintention;
	}
	public void setManagementIntention(ims.vo.LookupInstanceBean value)
	{
		this.managementintention = value;
	}
	public ims.core.vo.beans.ProcedureLiteVoBean[] getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.core.vo.beans.ProcedureLiteVoBean[] value)
	{
		this.procedures = value;
	}
	public Boolean getActiveAlerts()
	{
		return this.activealerts;
	}
	public void setActiveAlerts(Boolean value)
	{
		this.activealerts = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventForSTHKListVoBean pasevent;
	private ims.core.vo.beans.LocationLiteVoBean allocatedward;
	private String comments;
	private ims.framework.utils.beans.DateBean tcidate;
	private ims.framework.utils.beans.TimeBean tcitime;
	private ims.vo.LookupInstanceBean managementintention;
	private ims.core.vo.beans.ProcedureLiteVoBean[] procedures;
	private Boolean activealerts;
}
