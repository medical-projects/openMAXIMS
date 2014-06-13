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

package ims.scheduling.vo.beans;

public class DnaBatchUpdateVoBean extends ims.vo.ValueObjectBean
{
	public DnaBatchUpdateVoBean()
	{
	}
	public DnaBatchUpdateVoBean(ims.scheduling.vo.DnaBatchUpdateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCreationDate().getBean();
		this.triggerfrecuency = vo.getTriggerFrecuency();
		this.lastrun = vo.getLastRun() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastRun().getBean();
		this.nextrun = vo.getNextRun() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getNextRun().getBean();
		this.numappointmentsupdated = vo.getNumAppointmentsUpdated();
		this.printagentto = vo.getPrintAgentTo();
		this.jobdetail = vo.getJobDetail();
		this.cron = vo.getCron();
		this.cronfebruary = vo.getCronFebruary();
		this.issimplecron = vo.getIsSimpleCron();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.DnaBatchUpdateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCreationDate().getBean();
		this.triggerfrecuency = vo.getTriggerFrecuency();
		this.lastrun = vo.getLastRun() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastRun().getBean();
		this.nextrun = vo.getNextRun() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getNextRun().getBean();
		this.numappointmentsupdated = vo.getNumAppointmentsUpdated();
		this.printagentto = vo.getPrintAgentTo();
		this.jobdetail = vo.getJobDetail();
		this.cron = vo.getCron();
		this.cronfebruary = vo.getCronFebruary();
		this.issimplecron = vo.getIsSimpleCron();
	}

	public ims.scheduling.vo.DnaBatchUpdateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.DnaBatchUpdateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.DnaBatchUpdateVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.DnaBatchUpdateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.DnaBatchUpdateVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.framework.utils.beans.DateBean getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.beans.DateBean value)
	{
		this.creationdate = value;
	}
	public String getTriggerFrecuency()
	{
		return this.triggerfrecuency;
	}
	public void setTriggerFrecuency(String value)
	{
		this.triggerfrecuency = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLastRun()
	{
		return this.lastrun;
	}
	public void setLastRun(ims.framework.utils.beans.DateTimeBean value)
	{
		this.lastrun = value;
	}
	public ims.framework.utils.beans.DateTimeBean getNextRun()
	{
		return this.nextrun;
	}
	public void setNextRun(ims.framework.utils.beans.DateTimeBean value)
	{
		this.nextrun = value;
	}
	public Integer getNumAppointmentsUpdated()
	{
		return this.numappointmentsupdated;
	}
	public void setNumAppointmentsUpdated(Integer value)
	{
		this.numappointmentsupdated = value;
	}
	public String getPrintAgentTo()
	{
		return this.printagentto;
	}
	public void setPrintAgentTo(String value)
	{
		this.printagentto = value;
	}
	public String getJobDetail()
	{
		return this.jobdetail;
	}
	public void setJobDetail(String value)
	{
		this.jobdetail = value;
	}
	public String getCron()
	{
		return this.cron;
	}
	public void setCron(String value)
	{
		this.cron = value;
	}
	public String getCronFebruary()
	{
		return this.cronfebruary;
	}
	public void setCronFebruary(String value)
	{
		this.cronfebruary = value;
	}
	public Boolean getIsSimpleCron()
	{
		return this.issimplecron;
	}
	public void setIsSimpleCron(Boolean value)
	{
		this.issimplecron = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.framework.utils.beans.DateBean creationdate;
	private String triggerfrecuency;
	private ims.framework.utils.beans.DateTimeBean lastrun;
	private ims.framework.utils.beans.DateTimeBean nextrun;
	private Integer numappointmentsupdated;
	private String printagentto;
	private String jobdetail;
	private String cron;
	private String cronfebruary;
	private Boolean issimplecron;
}
