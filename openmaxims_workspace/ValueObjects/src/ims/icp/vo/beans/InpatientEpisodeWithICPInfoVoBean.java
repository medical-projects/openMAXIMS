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

package ims.icp.vo.beans;

public class InpatientEpisodeWithICPInfoVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeWithICPInfoVoBean()
	{
	}
	public InpatientEpisodeWithICPInfoVoBean(ims.icp.vo.InpatientEpisodeWithICPInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventShortVoBean)vo.getPasEvent().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean();
		this.bednumber = vo.getBedNumber();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.InpatientEpisodeWithICPInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventShortVoBean)vo.getPasEvent().getBean(map);
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean(map);
		this.bednumber = vo.getBedNumber();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.icp.vo.InpatientEpisodeWithICPInfoVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.InpatientEpisodeWithICPInfoVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.InpatientEpisodeWithICPInfoVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.InpatientEpisodeWithICPInfoVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.InpatientEpisodeWithICPInfoVo();
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
	public ims.core.vo.beans.PasEventShortVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventShortVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.icp.vo.beans.PatientICPLiteVoBean getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.beans.PatientICPLiteVoBean value)
	{
		this.icpinfo = value;
	}
	public String getBedNumber()
	{
		return this.bednumber;
	}
	public void setBedNumber(String value)
	{
		this.bednumber = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventShortVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.icp.vo.beans.PatientICPLiteVoBean icpinfo;
	private String bednumber;
	private ims.vo.RefVoBean carecontext;
}
