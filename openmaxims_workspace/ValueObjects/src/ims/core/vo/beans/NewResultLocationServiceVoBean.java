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

public class NewResultLocationServiceVoBean extends ims.vo.ValueObjectBean
{
	public NewResultLocationServiceVoBean()
	{
	}
	public NewResultLocationServiceVoBean(ims.core.vo.NewResultLocationServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.contact = vo.getContact() == null ? null : (ims.core.vo.beans.ServiceContactVoBean)vo.getContact().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.NewResultLocationServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.contact = vo.getContact() == null ? null : (ims.core.vo.beans.ServiceContactVoBean)vo.getContact().getBean(map);
	}

	public ims.core.vo.NewResultLocationServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.NewResultLocationServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.NewResultLocationServiceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.NewResultLocationServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.NewResultLocationServiceVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.ServiceContactVoBean getContact()
	{
		return this.contact;
	}
	public void setContact(ims.core.vo.beans.ServiceContactVoBean value)
	{
		this.contact = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.core.vo.beans.ServiceContactVoBean contact;
}
