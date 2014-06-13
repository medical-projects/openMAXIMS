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

public class StretchingDetailsVoBean extends ims.vo.ValueObjectBean
{
	public StretchingDetailsVoBean()
	{
	}
	public StretchingDetailsVoBean(ims.therapies.vo.StretchingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.stretchingarea = vo.getStretchingArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getStretchingArea().getBean();
		this.active = vo.getActive();
		this.passive = vo.getPassive();
		this.comment = vo.getComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.StretchingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.stretchingarea = vo.getStretchingArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getStretchingArea().getBean();
		this.active = vo.getActive();
		this.passive = vo.getPassive();
		this.comment = vo.getComment();
	}

	public ims.therapies.vo.StretchingDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.StretchingDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.StretchingDetailsVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.StretchingDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.StretchingDetailsVo();
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
	public ims.vo.LookupInstanceBean getStretchingArea()
	{
		return this.stretchingarea;
	}
	public void setStretchingArea(ims.vo.LookupInstanceBean value)
	{
		this.stretchingarea = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public Boolean getPassive()
	{
		return this.passive;
	}
	public void setPassive(Boolean value)
	{
		this.passive = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean stretchingarea;
	private Boolean active;
	private Boolean passive;
	private String comment;
}
