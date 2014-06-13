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

package ims.admin.vo.beans;

public class ReportCustomSearchSeedVoBean extends ims.vo.ValueObjectBean
{
	public ReportCustomSearchSeedVoBean()
	{
	}
	public ReportCustomSearchSeedVoBean(ims.admin.vo.ReportCustomSearchSeedVo vo)
	{
		this.id = vo.getID();
		this.displaystring = vo.getDisplayString();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ReportCustomSearchSeedVo vo)
	{
		this.id = vo.getID();
		this.displaystring = vo.getDisplayString();
	}

	public ims.admin.vo.ReportCustomSearchSeedVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ReportCustomSearchSeedVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ReportCustomSearchSeedVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ReportCustomSearchSeedVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ReportCustomSearchSeedVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getID()
	{
		return this.id;
	}
	public void setID(String value)
	{
		this.id = value;
	}
	public String getDisplayString()
	{
		return this.displaystring;
	}
	public void setDisplayString(String value)
	{
		this.displaystring = value;
	}

	private String id;
	private String displaystring;
}
