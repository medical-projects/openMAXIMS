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

package ims.clinical.vo.beans;

public class EMISAcuteVoBean extends ims.vo.ValueObjectBean
{
	public EMISAcuteVoBean()
	{
	}
	public EMISAcuteVoBean(ims.clinical.vo.EMISAcuteVo vo)
	{
		this.startdate = vo.getStartDate();
		this.recordtype = vo.getRecordType();
		this.specialityname = vo.getSpecialityName();
		this.description = vo.getDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.EMISAcuteVo vo)
	{
		this.startdate = vo.getStartDate();
		this.recordtype = vo.getRecordType();
		this.specialityname = vo.getSpecialityName();
		this.description = vo.getDescription();
	}

	public ims.clinical.vo.EMISAcuteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.EMISAcuteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.EMISAcuteVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.EMISAcuteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.EMISAcuteVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(String value)
	{
		this.startdate = value;
	}
	public String getRecordType()
	{
		return this.recordtype;
	}
	public void setRecordType(String value)
	{
		this.recordtype = value;
	}
	public String getSpecialityName()
	{
		return this.specialityname;
	}
	public void setSpecialityName(String value)
	{
		this.specialityname = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}

	private String startdate;
	private String recordtype;
	private String specialityname;
	private String description;
}
