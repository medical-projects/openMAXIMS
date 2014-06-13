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

public class VSABGO2SatsVoBean extends ims.vo.ValueObjectBean
{
	public VSABGO2SatsVoBean()
	{
	}
	public VSABGO2SatsVoBean(ims.core.vo.VSABGO2SatsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.oxygensaturation = vo.getOxygenSaturation() == null ? null : (ims.core.vo.beans.VSOxygenSaturationBean)vo.getOxygenSaturation().getBean();
		this.arterialbloodgas = vo.getArterialBloodGas() == null ? null : (ims.core.vo.beans.VSArterialBloodGasBean)vo.getArterialBloodGas().getBean();
		this.vitalstakendatetime = vo.getVitalsTakenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getVitalsTakenDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.VSABGO2SatsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.oxygensaturation = vo.getOxygenSaturation() == null ? null : (ims.core.vo.beans.VSOxygenSaturationBean)vo.getOxygenSaturation().getBean(map);
		this.arterialbloodgas = vo.getArterialBloodGas() == null ? null : (ims.core.vo.beans.VSArterialBloodGasBean)vo.getArterialBloodGas().getBean(map);
		this.vitalstakendatetime = vo.getVitalsTakenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getVitalsTakenDateTime().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.core.vo.VSABGO2SatsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.VSABGO2SatsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.VSABGO2SatsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.VSABGO2SatsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.VSABGO2SatsVo();
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
	public ims.core.vo.beans.VSOxygenSaturationBean getOxygenSaturation()
	{
		return this.oxygensaturation;
	}
	public void setOxygenSaturation(ims.core.vo.beans.VSOxygenSaturationBean value)
	{
		this.oxygensaturation = value;
	}
	public ims.core.vo.beans.VSArterialBloodGasBean getArterialBloodGas()
	{
		return this.arterialbloodgas;
	}
	public void setArterialBloodGas(ims.core.vo.beans.VSArterialBloodGasBean value)
	{
		this.arterialbloodgas = value;
	}
	public ims.framework.utils.beans.DateTimeBean getVitalsTakenDateTime()
	{
		return this.vitalstakendatetime;
	}
	public void setVitalsTakenDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.vitalstakendatetime = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.VSOxygenSaturationBean oxygensaturation;
	private ims.core.vo.beans.VSArterialBloodGasBean arterialbloodgas;
	private ims.framework.utils.beans.DateTimeBean vitalstakendatetime;
	private ims.vo.SysInfoBean sysinfo;
}
