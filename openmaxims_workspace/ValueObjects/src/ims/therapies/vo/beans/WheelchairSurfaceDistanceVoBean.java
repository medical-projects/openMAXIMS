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

package ims.therapies.vo.beans;

public class WheelchairSurfaceDistanceVoBean extends ims.vo.ValueObjectBean
{
	public WheelchairSurfaceDistanceVoBean()
	{
	}
	public WheelchairSurfaceDistanceVoBean(ims.therapies.vo.WheelchairSurfaceDistanceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.surface = vo.getSurface() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurface().getBean();
		this.distance = vo.getDistance();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.WheelchairSurfaceDistanceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.surface = vo.getSurface() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurface().getBean();
		this.distance = vo.getDistance();
	}

	public ims.therapies.vo.WheelchairSurfaceDistanceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.WheelchairSurfaceDistanceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.WheelchairSurfaceDistanceVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.WheelchairSurfaceDistanceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.WheelchairSurfaceDistanceVo();
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
	public ims.vo.LookupInstanceBean getSurface()
	{
		return this.surface;
	}
	public void setSurface(ims.vo.LookupInstanceBean value)
	{
		this.surface = value;
	}
	public String getDistance()
	{
		return this.distance;
	}
	public void setDistance(String value)
	{
		this.distance = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean surface;
	private String distance;
}
