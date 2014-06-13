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

package ims.emergency.vo.beans;

public class TrackingMovementTimesForEventHistoryVoBean extends ims.vo.ValueObjectBean
{
	public TrackingMovementTimesForEventHistoryVoBean()
	{
	}
	public TrackingMovementTimesForEventHistoryVoBean(ims.emergency.vo.TrackingMovementTimesForEventHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.areamovedto = vo.getAreaMovedTo() == null ? null : (ims.emergency.vo.beans.TrackingAreaLiteVoBean)vo.getAreaMovedTo().getBean();
		this.moveddatetime = vo.getMovedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMovedDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingMovementTimesForEventHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.areamovedto = vo.getAreaMovedTo() == null ? null : (ims.emergency.vo.beans.TrackingAreaLiteVoBean)vo.getAreaMovedTo().getBean(map);
		this.moveddatetime = vo.getMovedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMovedDateTime().getBean();
	}

	public ims.emergency.vo.TrackingMovementTimesForEventHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingMovementTimesForEventHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingMovementTimesForEventHistoryVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingMovementTimesForEventHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingMovementTimesForEventHistoryVo();
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
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.emergency.vo.beans.TrackingAreaLiteVoBean getAreaMovedTo()
	{
		return this.areamovedto;
	}
	public void setAreaMovedTo(ims.emergency.vo.beans.TrackingAreaLiteVoBean value)
	{
		this.areamovedto = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMovedDateTime()
	{
		return this.moveddatetime;
	}
	public void setMovedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.moveddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean attendance;
	private ims.emergency.vo.beans.TrackingAreaLiteVoBean areamovedto;
	private ims.framework.utils.beans.DateTimeBean moveddatetime;
}
