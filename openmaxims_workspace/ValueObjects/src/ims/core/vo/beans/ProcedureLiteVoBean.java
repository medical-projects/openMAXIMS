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

public class ProcedureLiteVoBean extends ims.vo.ValueObjectBean
{
	public ProcedureLiteVoBean()
	{
	}
	public ProcedureLiteVoBean(ims.core.vo.ProcedureLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedurename = vo.getProcedureName();
		this.isactive = vo.getIsActive();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.durationinmins = vo.getDurationInMins();
		this.tcilagtime = vo.getTCILagTime();
		this.los = vo.getLOS();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ProcedureLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedurename = vo.getProcedureName();
		this.isactive = vo.getIsActive();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.durationinmins = vo.getDurationInMins();
		this.tcilagtime = vo.getTCILagTime();
		this.los = vo.getLOS();
	}

	public ims.core.vo.ProcedureLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ProcedureLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ProcedureLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ProcedureLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ProcedureLiteVo();
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
	public String getProcedureName()
	{
		return this.procedurename;
	}
	public void setProcedureName(String value)
	{
		this.procedurename = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.vo.LookupInstanceBean getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.vo.LookupInstanceBean value)
	{
		this.procedurestatus = value;
	}
	public Integer getDurationInMins()
	{
		return this.durationinmins;
	}
	public void setDurationInMins(Integer value)
	{
		this.durationinmins = value;
	}
	public Integer getTCILagTime()
	{
		return this.tcilagtime;
	}
	public void setTCILagTime(Integer value)
	{
		this.tcilagtime = value;
	}
	public Integer getLOS()
	{
		return this.los;
	}
	public void setLOS(Integer value)
	{
		this.los = value;
	}

	private Integer id;
	private int version;
	private String procedurename;
	private Boolean isactive;
	private ims.vo.LookupInstanceBean procedurestatus;
	private Integer durationinmins;
	private Integer tcilagtime;
	private Integer los;
}
