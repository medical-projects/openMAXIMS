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

public class OrderSetEditVoBean extends ims.vo.ValueObjectBean
{
	public OrderSetEditVoBean()
	{
	}
	public OrderSetEditVoBean(ims.ocrr.vo.OrderSetEditVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.commonname = vo.getCommonName();
		this.description = vo.getDescription();
		this.component = vo.getComponent() == null ? null : vo.getComponent().getBeanCollection();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.color = vo.getColor() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColor().getBean();
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderSetEditVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.commonname = vo.getCommonName();
		this.description = vo.getDescription();
		this.component = vo.getComponent() == null ? null : vo.getComponent().getBeanCollection();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.color = vo.getColor() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColor().getBean();
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
	}

	public ims.ocrr.vo.OrderSetEditVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderSetEditVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderSetEditVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderSetEditVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderSetEditVo();
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
	public String getCommonName()
	{
		return this.commonname;
	}
	public void setCommonName(String value)
	{
		this.commonname = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.ocrr.vo.beans.OrderSetComponentEditVoBean[] getComponent()
	{
		return this.component;
	}
	public void setComponent(ims.ocrr.vo.beans.OrderSetComponentEditVoBean[] value)
	{
		this.component = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.framework.utils.beans.ColorBean getColor()
	{
		return this.color;
	}
	public void setColor(ims.framework.utils.beans.ColorBean value)
	{
		this.color = value;
	}
	public ims.ocrr.vo.beans.HelpTextVoBean[] getHelpText()
	{
		return this.helptext;
	}
	public void setHelpText(ims.ocrr.vo.beans.HelpTextVoBean[] value)
	{
		this.helptext = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String commonname;
	private String description;
	private ims.ocrr.vo.beans.OrderSetComponentEditVoBean[] component;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.framework.utils.beans.ColorBean color;
	private ims.ocrr.vo.beans.HelpTextVoBean[] helptext;
}
