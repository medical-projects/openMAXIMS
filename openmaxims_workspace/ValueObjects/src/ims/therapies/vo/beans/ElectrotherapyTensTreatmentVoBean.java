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

public class ElectrotherapyTensTreatmentVoBean extends ims.vo.ValueObjectBean
{
	public ElectrotherapyTensTreatmentVoBean()
	{
	}
	public ElectrotherapyTensTreatmentVoBean(ims.therapies.vo.ElectrotherapyTensTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.model = vo.getModel() == null ? null : (ims.vo.LookupInstanceBean)vo.getModel().getBean();
		this.serialnr = vo.getSerialNr();
		this.protocolfollowed = vo.getProtocolFollowed() == null ? null : (ims.vo.LookupInstanceBean)vo.getProtocolFollowed().getBean();
		this.mode = vo.getMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getMode().getBean();
		this.pulserate = vo.getPulseRate();
		this.pulsewidth = vo.getPulseWidth();
		this.duration = vo.getDuration();
		this.dailyusage = vo.getDailyUsage() == null ? null : (ims.vo.LookupInstanceBean)vo.getDailyUsage().getBean();
		this.electrodes = vo.getElectrodes() == null ? null : (ims.vo.LookupInstanceBean)vo.getElectrodes().getBean();
		this.size = vo.getSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSize().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.ElectrotherapyTensTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.model = vo.getModel() == null ? null : (ims.vo.LookupInstanceBean)vo.getModel().getBean();
		this.serialnr = vo.getSerialNr();
		this.protocolfollowed = vo.getProtocolFollowed() == null ? null : (ims.vo.LookupInstanceBean)vo.getProtocolFollowed().getBean();
		this.mode = vo.getMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getMode().getBean();
		this.pulserate = vo.getPulseRate();
		this.pulsewidth = vo.getPulseWidth();
		this.duration = vo.getDuration();
		this.dailyusage = vo.getDailyUsage() == null ? null : (ims.vo.LookupInstanceBean)vo.getDailyUsage().getBean();
		this.electrodes = vo.getElectrodes() == null ? null : (ims.vo.LookupInstanceBean)vo.getElectrodes().getBean();
		this.size = vo.getSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSize().getBean();
	}

	public ims.therapies.vo.ElectrotherapyTensTreatmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.ElectrotherapyTensTreatmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.ElectrotherapyTensTreatmentVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.ElectrotherapyTensTreatmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.ElectrotherapyTensTreatmentVo();
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
	public ims.vo.LookupInstanceBean getArea()
	{
		return this.area;
	}
	public void setArea(ims.vo.LookupInstanceBean value)
	{
		this.area = value;
	}
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public ims.vo.LookupInstanceBean getModel()
	{
		return this.model;
	}
	public void setModel(ims.vo.LookupInstanceBean value)
	{
		this.model = value;
	}
	public String getSerialNr()
	{
		return this.serialnr;
	}
	public void setSerialNr(String value)
	{
		this.serialnr = value;
	}
	public ims.vo.LookupInstanceBean getProtocolFollowed()
	{
		return this.protocolfollowed;
	}
	public void setProtocolFollowed(ims.vo.LookupInstanceBean value)
	{
		this.protocolfollowed = value;
	}
	public ims.vo.LookupInstanceBean getMode()
	{
		return this.mode;
	}
	public void setMode(ims.vo.LookupInstanceBean value)
	{
		this.mode = value;
	}
	public Integer getPulseRate()
	{
		return this.pulserate;
	}
	public void setPulseRate(Integer value)
	{
		this.pulserate = value;
	}
	public Integer getPulseWidth()
	{
		return this.pulsewidth;
	}
	public void setPulseWidth(Integer value)
	{
		this.pulsewidth = value;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.duration = value;
	}
	public ims.vo.LookupInstanceBean getDailyUsage()
	{
		return this.dailyusage;
	}
	public void setDailyUsage(ims.vo.LookupInstanceBean value)
	{
		this.dailyusage = value;
	}
	public ims.vo.LookupInstanceBean getElectrodes()
	{
		return this.electrodes;
	}
	public void setElectrodes(ims.vo.LookupInstanceBean value)
	{
		this.electrodes = value;
	}
	public ims.vo.LookupInstanceBean getSize()
	{
		return this.size;
	}
	public void setSize(ims.vo.LookupInstanceBean value)
	{
		this.size = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean area;
	private ims.vo.LookupInstanceBean laterality;
	private ims.vo.LookupInstanceBean model;
	private String serialnr;
	private ims.vo.LookupInstanceBean protocolfollowed;
	private ims.vo.LookupInstanceBean mode;
	private Integer pulserate;
	private Integer pulsewidth;
	private Integer duration;
	private ims.vo.LookupInstanceBean dailyusage;
	private ims.vo.LookupInstanceBean electrodes;
	private ims.vo.LookupInstanceBean size;
}