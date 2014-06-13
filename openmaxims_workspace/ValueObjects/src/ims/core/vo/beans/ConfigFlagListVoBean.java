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

public class ConfigFlagListVoBean extends ims.vo.ValueObjectBean
{
	public ConfigFlagListVoBean()
	{
	}
	public ConfigFlagListVoBean(ims.core.vo.ConfigFlagListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.value = vo.getValue();
		this.issystem = vo.getIsSystem();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ConfigFlagListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.value = vo.getValue();
		this.issystem = vo.getIsSystem();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public ims.core.vo.ConfigFlagListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ConfigFlagListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ConfigFlagListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ConfigFlagListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ConfigFlagListVo();
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
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public Boolean getIsSystem()
	{
		return this.issystem;
	}
	public void setIsSystem(Boolean value)
	{
		this.issystem = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String value;
	private Boolean issystem;
	private ims.vo.SysInfoBean systeminformation;
}
