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

public class IfLookupVoBean extends ims.vo.ValueObjectBean
{
	public IfLookupVoBean()
	{
	}
	public IfLookupVoBean(ims.core.vo.IfLookupVo vo)
	{
		this.lookuptype = vo.getLookupType();
		this.instances = vo.getInstances() == null ? null : vo.getInstances().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.IfLookupVo vo)
	{
		this.lookuptype = vo.getLookupType();
		this.instances = vo.getInstances() == null ? null : vo.getInstances().getBeanCollection();
	}

	public ims.core.vo.IfLookupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.IfLookupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.IfLookupVo vo = null;
		if(map != null)
			vo = (ims.core.vo.IfLookupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.IfLookupVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getLookupType()
	{
		return this.lookuptype;
	}
	public void setLookupType(String value)
	{
		this.lookuptype = value;
	}
	public ims.core.vo.beans.IfLookupInstanceVoBean[] getInstances()
	{
		return this.instances;
	}
	public void setInstances(ims.core.vo.beans.IfLookupInstanceVoBean[] value)
	{
		this.instances = value;
	}

	private String lookuptype;
	private ims.core.vo.beans.IfLookupInstanceVoBean[] instances;
}
