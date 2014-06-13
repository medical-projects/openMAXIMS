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

package ims.nursing.vo.beans;

public class AssessmentNewBean extends ims.vo.ValueObjectBean
{
	public AssessmentNewBean()
	{
	}
	public AssessmentNewBean(ims.nursing.vo.AssessmentNew vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.components = vo.getComponents() == null ? null : vo.getComponents().getBeanCollection();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : new ims.vo.RefVoBean(vo.getHcpInitiated().getBoId(), vo.getHcpInitiated().getBoVersion());
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.AssessmentNew vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.components = vo.getComponents() == null ? null : vo.getComponents().getBeanCollection();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : new ims.vo.RefVoBean(vo.getHcpInitiated().getBoId(), vo.getHcpInitiated().getBoVersion());
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.nursing.vo.AssessmentNew buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.AssessmentNew buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.AssessmentNew vo = null;
		if(map != null)
			vo = (ims.nursing.vo.AssessmentNew)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.AssessmentNew();
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
	public java.util.Collection getComponents()
	{
		return this.components;
	}
	public void setComponents(java.util.Collection value)
	{
		this.components = value;
	}
	public void addComponents(java.util.Collection value)
	{
		if(this.components == null)
			this.components = new java.util.ArrayList();
		this.components.add(value);
	}
	public ims.vo.LookupInstanceBean getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.vo.LookupInstanceBean value)
	{
		this.assessmenttype = value;
	}
	public ims.vo.RefVoBean getHcpInitiated()
	{
		return this.hcpinitiated;
	}
	public void setHcpInitiated(ims.vo.RefVoBean value)
	{
		this.hcpinitiated = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeInitiated()
	{
		return this.datetimeinitiated;
	}
	public void setDateTimeInitiated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeinitiated = value;
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
	private java.util.Collection components;
	private ims.vo.LookupInstanceBean assessmenttype;
	private ims.vo.RefVoBean hcpinitiated;
	private ims.framework.utils.beans.DateTimeBean datetimeinitiated;
	private ims.vo.RefVoBean clinicalcontact;
}
