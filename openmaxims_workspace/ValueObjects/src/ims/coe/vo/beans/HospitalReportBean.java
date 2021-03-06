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

package ims.coe.vo.beans;

public class HospitalReportBean extends ims.vo.ValueObjectBean
{
	public HospitalReportBean()
	{
	}
	public HospitalReportBean(ims.coe.vo.HospitalReport vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getWard().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.HospitalReport vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getWard().getBean(map);
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.coe.vo.HospitalReport buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.HospitalReport buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.HospitalReport vo = null;
		if(map != null)
			vo = (ims.coe.vo.HospitalReport)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.HospitalReport();
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
	public String getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(String value)
	{
		this.clinicalnote = value;
	}
	public ims.core.vo.beans.LocShortVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocShortVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
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
	private String clinicalnote;
	private ims.core.vo.beans.LocShortVoBean ward;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.vo.RefVoBean carecontext;
}
