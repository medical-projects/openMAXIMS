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

public class HydrotherapyVoBean extends ims.vo.ValueObjectBean
{
	public HydrotherapyVoBean()
	{
	}
	public HydrotherapyVoBean(ims.therapies.vo.HydrotherapyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.levelofassistance = vo.getLevelOfAssistance() == null ? null : (ims.vo.LookupInstanceBean)vo.getLevelOfAssistance().getBean();
		this.transferin = vo.getTransferIn() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferIn().getBean();
		this.transferout = vo.getTransferOut() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferOut().getBean();
		this.comment = vo.getComment();
		this.modalities = vo.getModalities() == null ? null : vo.getModalities().getBeanCollection();
		this.equipment = vo.getEquipment() == null ? null : vo.getEquipment().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.HydrotherapyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.levelofassistance = vo.getLevelOfAssistance() == null ? null : (ims.vo.LookupInstanceBean)vo.getLevelOfAssistance().getBean();
		this.transferin = vo.getTransferIn() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferIn().getBean();
		this.transferout = vo.getTransferOut() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferOut().getBean();
		this.comment = vo.getComment();
		this.modalities = vo.getModalities() == null ? null : vo.getModalities().getBeanCollection();
		this.equipment = vo.getEquipment() == null ? null : vo.getEquipment().getBeanCollection();
	}

	public ims.therapies.vo.HydrotherapyVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.HydrotherapyVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.HydrotherapyVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.HydrotherapyVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.HydrotherapyVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.vo.LookupInstanceBean getLevelOfAssistance()
	{
		return this.levelofassistance;
	}
	public void setLevelOfAssistance(ims.vo.LookupInstanceBean value)
	{
		this.levelofassistance = value;
	}
	public ims.vo.LookupInstanceBean getTransferIn()
	{
		return this.transferin;
	}
	public void setTransferIn(ims.vo.LookupInstanceBean value)
	{
		this.transferin = value;
	}
	public ims.vo.LookupInstanceBean getTransferOut()
	{
		return this.transferout;
	}
	public void setTransferOut(ims.vo.LookupInstanceBean value)
	{
		this.transferout = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public java.util.Collection getModalities()
	{
		return this.modalities;
	}
	public void setModalities(java.util.Collection value)
	{
		this.modalities = value;
	}
	public void addModalities(java.util.Collection value)
	{
		if(this.modalities == null)
			this.modalities = new java.util.ArrayList();
		this.modalities.add(value);
	}
	public java.util.Collection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(java.util.Collection value)
	{
		this.equipment = value;
	}
	public void addEquipment(java.util.Collection value)
	{
		if(this.equipment == null)
			this.equipment = new java.util.ArrayList();
		this.equipment.add(value);
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.core.vo.beans.HcpBean authoringcp;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.vo.LookupInstanceBean levelofassistance;
	private ims.vo.LookupInstanceBean transferin;
	private ims.vo.LookupInstanceBean transferout;
	private String comment;
	private java.util.Collection modalities;
	private java.util.Collection equipment;
}
