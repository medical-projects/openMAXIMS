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

public class DefaultEDLocationDeptTypeVoBean extends ims.vo.ValueObjectBean
{
	public DefaultEDLocationDeptTypeVoBean()
	{
	}
	public DefaultEDLocationDeptTypeVoBean(ims.emergency.vo.DefaultEDLocationDeptTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.defaultdepttype = vo.getDefaultDeptType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDefaultDeptType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.DefaultEDLocationDeptTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.defaultdepttype = vo.getDefaultDeptType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDefaultDeptType().getBean();
	}

	public ims.emergency.vo.DefaultEDLocationDeptTypeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.DefaultEDLocationDeptTypeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.DefaultEDLocationDeptTypeVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.DefaultEDLocationDeptTypeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.DefaultEDLocationDeptTypeVo();
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
	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.vo.LookupInstanceBean getDefaultDeptType()
	{
		return this.defaultdepttype;
	}
	public void setDefaultDeptType(ims.vo.LookupInstanceBean value)
	{
		this.defaultdepttype = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.vo.LookupInstanceBean defaultdepttype;
}
