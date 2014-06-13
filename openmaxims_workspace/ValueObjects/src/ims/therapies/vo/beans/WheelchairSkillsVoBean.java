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

public class WheelchairSkillsVoBean extends ims.vo.ValueObjectBean
{
	public WheelchairSkillsVoBean()
	{
	}
	public WheelchairSkillsVoBean(ims.therapies.vo.WheelchairSkillsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.wheelchairskills = vo.getWheelchairSkills() == null ? null : vo.getWheelchairSkills().getBeanCollection();
		this.details = vo.getDetails();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.WheelchairSkillsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.wheelchairskills = vo.getWheelchairSkills() == null ? null : vo.getWheelchairSkills().getBeanCollection();
		this.details = vo.getDetails();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.therapies.vo.WheelchairSkillsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.WheelchairSkillsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.WheelchairSkillsVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.WheelchairSkillsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.WheelchairSkillsVo();
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
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public java.util.Collection getWheelchairSkills()
	{
		return this.wheelchairskills;
	}
	public void setWheelchairSkills(java.util.Collection value)
	{
		this.wheelchairskills = value;
	}
	public void addWheelchairSkills(java.util.Collection value)
	{
		if(this.wheelchairskills == null)
			this.wheelchairskills = new java.util.ArrayList();
		this.wheelchairskills.add(value);
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private java.util.Collection wheelchairskills;
	private String details;
	private ims.vo.RefVoBean clinicalcontact;
}
