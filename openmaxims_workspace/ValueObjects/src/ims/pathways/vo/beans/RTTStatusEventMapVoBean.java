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

public class RTTStatusEventMapVoBean extends ims.vo.ValueObjectBean
{
	public RTTStatusEventMapVoBean()
	{
	}
	public RTTStatusEventMapVoBean(ims.pathways.vo.RTTStatusEventMapVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventLiteVoBean)vo.getEvent().getBean();
		this.active = vo.getActive();
		this.encountertype = vo.getEncounterType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEncounterType().getBean();
		this.encounterinstance = vo.getEncounterInstance() == null ? null : (ims.vo.LookupInstanceBean)vo.getEncounterInstance().getBean();
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getCurrentRTTStatus().getBean();
		this.targetrttstatus = vo.getTargetRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getTargetRTTStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.RTTStatusEventMapVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventLiteVoBean)vo.getEvent().getBean(map);
		this.active = vo.getActive();
		this.encountertype = vo.getEncounterType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEncounterType().getBean();
		this.encounterinstance = vo.getEncounterInstance() == null ? null : (ims.vo.LookupInstanceBean)vo.getEncounterInstance().getBean();
		this.currentrttstatus = vo.getCurrentRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getCurrentRTTStatus().getBean(map);
		this.targetrttstatus = vo.getTargetRTTStatus() == null ? null : (ims.pathways.vo.beans.RTTStatusPointVoBean)vo.getTargetRTTStatus().getBean(map);
	}

	public ims.pathways.vo.RTTStatusEventMapVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.RTTStatusEventMapVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.RTTStatusEventMapVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.RTTStatusEventMapVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.RTTStatusEventMapVo();
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
	public ims.pathways.vo.beans.EventLiteVoBean getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.beans.EventLiteVoBean value)
	{
		this.event = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public ims.vo.LookupInstanceBean getEncounterType()
	{
		return this.encountertype;
	}
	public void setEncounterType(ims.vo.LookupInstanceBean value)
	{
		this.encountertype = value;
	}
	public ims.vo.LookupInstanceBean getEncounterInstance()
	{
		return this.encounterinstance;
	}
	public void setEncounterInstance(ims.vo.LookupInstanceBean value)
	{
		this.encounterinstance = value;
	}
	public ims.pathways.vo.beans.RTTStatusPointVoBean getCurrentRTTStatus()
	{
		return this.currentrttstatus;
	}
	public void setCurrentRTTStatus(ims.pathways.vo.beans.RTTStatusPointVoBean value)
	{
		this.currentrttstatus = value;
	}
	public ims.pathways.vo.beans.RTTStatusPointVoBean getTargetRTTStatus()
	{
		return this.targetrttstatus;
	}
	public void setTargetRTTStatus(ims.pathways.vo.beans.RTTStatusPointVoBean value)
	{
		this.targetrttstatus = value;
	}

	private Integer id;
	private int version;
	private ims.pathways.vo.beans.EventLiteVoBean event;
	private Boolean active;
	private ims.vo.LookupInstanceBean encountertype;
	private ims.vo.LookupInstanceBean encounterinstance;
	private ims.pathways.vo.beans.RTTStatusPointVoBean currentrttstatus;
	private ims.pathways.vo.beans.RTTStatusPointVoBean targetrttstatus;
}