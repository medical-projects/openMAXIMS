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

package ims.ocrr.vo.beans;

public class RoleDisciplineSecurityLevelVoBean extends ims.vo.ValueObjectBean
{
	public RoleDisciplineSecurityLevelVoBean()
	{
	}
	public RoleDisciplineSecurityLevelVoBean(ims.ocrr.vo.RoleDisciplineSecurityLevelVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.role = vo.getRole() == null ? null : new ims.vo.RefVoBean(vo.getRole().getBoId(), vo.getRole().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.orderingsecuritylevel = vo.getOrderingSecurityLevel() == null ? null : new ims.vo.RefVoBean(vo.getOrderingSecurityLevel().getBoId(), vo.getOrderingSecurityLevel().getBoVersion());
		this.viewingsecuritylevel = vo.getViewingSecurityLevel() == null ? null : new ims.vo.RefVoBean(vo.getViewingSecurityLevel().getBoId(), vo.getViewingSecurityLevel().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.RoleDisciplineSecurityLevelVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.role = vo.getRole() == null ? null : new ims.vo.RefVoBean(vo.getRole().getBoId(), vo.getRole().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.orderingsecuritylevel = vo.getOrderingSecurityLevel() == null ? null : new ims.vo.RefVoBean(vo.getOrderingSecurityLevel().getBoId(), vo.getOrderingSecurityLevel().getBoVersion());
		this.viewingsecuritylevel = vo.getViewingSecurityLevel() == null ? null : new ims.vo.RefVoBean(vo.getViewingSecurityLevel().getBoId(), vo.getViewingSecurityLevel().getBoVersion());
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.RoleDisciplineSecurityLevelVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.RoleDisciplineSecurityLevelVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.RoleDisciplineSecurityLevelVo();
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
	public ims.vo.RefVoBean getRole()
	{
		return this.role;
	}
	public void setRole(ims.vo.RefVoBean value)
	{
		this.role = value;
	}
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public ims.vo.RefVoBean getOrderingSecurityLevel()
	{
		return this.orderingsecuritylevel;
	}
	public void setOrderingSecurityLevel(ims.vo.RefVoBean value)
	{
		this.orderingsecuritylevel = value;
	}
	public ims.vo.RefVoBean getViewingSecurityLevel()
	{
		return this.viewingsecuritylevel;
	}
	public void setViewingSecurityLevel(ims.vo.RefVoBean value)
	{
		this.viewingsecuritylevel = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean role;
	private ims.vo.RefVoBean service;
	private ims.vo.RefVoBean orderingsecuritylevel;
	private ims.vo.RefVoBean viewingsecuritylevel;
}
