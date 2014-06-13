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

package ims.pathways.vo.beans;

public class EventRTTEventVoBean extends ims.vo.ValueObjectBean
{
	public EventRTTEventVoBean()
	{
	}
	public EventRTTEventVoBean(ims.pathways.vo.EventRTTEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventVoBean)vo.getEvent().getBean();
		this.rttevent = vo.getRTTEvent() == null ? null : (ims.pathways.vo.beans.RTTEventVoBean)vo.getRTTEvent().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.activatedby = vo.getActivatedBy() == null ? null : (ims.admin.vo.beans.AppUserShortVoBean)vo.getActivatedBy().getBean();
		this.activateddatetime = vo.getActivatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getActivatedDateTime().getBean();
		this.inactivatedby = vo.getInactivatedBy() == null ? null : (ims.admin.vo.beans.AppUserShortVoBean)vo.getInactivatedBy().getBean();
		this.inactivateddatetime = vo.getInactivatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInactivatedDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.EventRTTEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventVoBean)vo.getEvent().getBean(map);
		this.rttevent = vo.getRTTEvent() == null ? null : (ims.pathways.vo.beans.RTTEventVoBean)vo.getRTTEvent().getBean(map);
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.activatedby = vo.getActivatedBy() == null ? null : (ims.admin.vo.beans.AppUserShortVoBean)vo.getActivatedBy().getBean(map);
		this.activateddatetime = vo.getActivatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getActivatedDateTime().getBean();
		this.inactivatedby = vo.getInactivatedBy() == null ? null : (ims.admin.vo.beans.AppUserShortVoBean)vo.getInactivatedBy().getBean(map);
		this.inactivateddatetime = vo.getInactivatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInactivatedDateTime().getBean();
	}

	public ims.pathways.vo.EventRTTEventVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.EventRTTEventVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.EventRTTEventVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.EventRTTEventVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.EventRTTEventVo();
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
	public ims.pathways.vo.beans.EventVoBean getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.beans.EventVoBean value)
	{
		this.event = value;
	}
	public ims.pathways.vo.beans.RTTEventVoBean getRTTEvent()
	{
		return this.rttevent;
	}
	public void setRTTEvent(ims.pathways.vo.beans.RTTEventVoBean value)
	{
		this.rttevent = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.admin.vo.beans.AppUserShortVoBean getActivatedBy()
	{
		return this.activatedby;
	}
	public void setActivatedBy(ims.admin.vo.beans.AppUserShortVoBean value)
	{
		this.activatedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getActivatedDateTime()
	{
		return this.activateddatetime;
	}
	public void setActivatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.activateddatetime = value;
	}
	public ims.admin.vo.beans.AppUserShortVoBean getInactivatedBy()
	{
		return this.inactivatedby;
	}
	public void setInactivatedBy(ims.admin.vo.beans.AppUserShortVoBean value)
	{
		this.inactivatedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getInactivatedDateTime()
	{
		return this.inactivateddatetime;
	}
	public void setInactivatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.inactivateddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.pathways.vo.beans.EventVoBean event;
	private ims.pathways.vo.beans.RTTEventVoBean rttevent;
	private ims.vo.LookupInstanceBean status;
	private ims.admin.vo.beans.AppUserShortVoBean activatedby;
	private ims.framework.utils.beans.DateTimeBean activateddatetime;
	private ims.admin.vo.beans.AppUserShortVoBean inactivatedby;
	private ims.framework.utils.beans.DateTimeBean inactivateddatetime;
}
