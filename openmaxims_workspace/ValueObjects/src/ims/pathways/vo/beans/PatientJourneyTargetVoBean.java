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

public class PatientJourneyTargetVoBean extends ims.vo.ValueObjectBean
{
	public PatientJourneyTargetVoBean()
	{
	}
	public PatientJourneyTargetVoBean(ims.pathways.vo.PatientJourneyTargetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathwaytarget = vo.getPathwayTarget() == null ? null : (ims.pathways.vo.beans.PathwayTargetShortVoBean)vo.getPathwayTarget().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.JourneyTargetStatusVoBean)vo.getCurrentStatus().getBean();
		this.pathwayjourney = vo.getPathwayJourney() == null ? null : (ims.pathways.vo.beans.PatientJourneyVoBean)vo.getPathwayJourney().getBean();
		this.weeknumber = vo.getWeekNumber();
		this.targetdate = vo.getTargetDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetDate().getBean();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.targetcalfromdate = vo.getTargetCalFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetCalFromDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.PatientJourneyTargetVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pathwaytarget = vo.getPathwayTarget() == null ? null : (ims.pathways.vo.beans.PathwayTargetShortVoBean)vo.getPathwayTarget().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.pathways.vo.beans.JourneyTargetStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.pathwayjourney = vo.getPathwayJourney() == null ? null : (ims.pathways.vo.beans.PatientJourneyVoBean)vo.getPathwayJourney().getBean(map);
		this.weeknumber = vo.getWeekNumber();
		this.targetdate = vo.getTargetDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetDate().getBean();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.targetcalfromdate = vo.getTargetCalFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTargetCalFromDate().getBean();
	}

	public ims.pathways.vo.PatientJourneyTargetVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.PatientJourneyTargetVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.PatientJourneyTargetVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.PatientJourneyTargetVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.PatientJourneyTargetVo();
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
	public ims.pathways.vo.beans.PathwayTargetShortVoBean getPathwayTarget()
	{
		return this.pathwaytarget;
	}
	public void setPathwayTarget(ims.pathways.vo.beans.PathwayTargetShortVoBean value)
	{
		this.pathwaytarget = value;
	}
	public ims.pathways.vo.beans.JourneyTargetStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.pathways.vo.beans.JourneyTargetStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.pathways.vo.beans.PatientJourneyVoBean getPathwayJourney()
	{
		return this.pathwayjourney;
	}
	public void setPathwayJourney(ims.pathways.vo.beans.PatientJourneyVoBean value)
	{
		this.pathwayjourney = value;
	}
	public Integer getWeekNumber()
	{
		return this.weeknumber;
	}
	public void setWeekNumber(Integer value)
	{
		this.weeknumber = value;
	}
	public ims.framework.utils.beans.DateBean getTargetDate()
	{
		return this.targetdate;
	}
	public void setTargetDate(ims.framework.utils.beans.DateBean value)
	{
		this.targetdate = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}
	public ims.framework.utils.beans.DateBean getTargetCalFromDate()
	{
		return this.targetcalfromdate;
	}
	public void setTargetCalFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.targetcalfromdate = value;
	}

	private Integer id;
	private int version;
	private ims.pathways.vo.beans.PathwayTargetShortVoBean pathwaytarget;
	private ims.pathways.vo.beans.JourneyTargetStatusVoBean currentstatus;
	private ims.pathways.vo.beans.PatientJourneyVoBean pathwayjourney;
	private Integer weeknumber;
	private ims.framework.utils.beans.DateBean targetdate;
	private ims.framework.utils.beans.ColorBean colour;
	private ims.framework.utils.beans.DateBean targetcalfromdate;
}
