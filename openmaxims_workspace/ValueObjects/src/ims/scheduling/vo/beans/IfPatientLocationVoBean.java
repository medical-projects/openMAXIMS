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

package ims.scheduling.vo.beans;

public class IfPatientLocationVoBean extends ims.vo.ValueObjectBean
{
	public IfPatientLocationVoBean()
	{
	}
	public IfPatientLocationVoBean(ims.scheduling.vo.IfPatientLocationVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.locmapping = vo.getLocMapping() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getLocMapping().getBean();
		this.appointmentid = vo.getAppointmentID();
		this.referralid = vo.getReferralID();
		this.parentlocmapping = vo.getParentLocMapping() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getParentLocMapping().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.IfPatientLocationVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.locmapping = vo.getLocMapping() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getLocMapping().getBean(map);
		this.appointmentid = vo.getAppointmentID();
		this.referralid = vo.getReferralID();
		this.parentlocmapping = vo.getParentLocMapping() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getParentLocMapping().getBean(map);
	}

	public ims.scheduling.vo.IfPatientLocationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.IfPatientLocationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.IfPatientLocationVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.IfPatientLocationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.IfPatientLocationVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getLocMapping()
	{
		return this.locmapping;
	}
	public void setLocMapping(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.locmapping = value;
	}
	public String getAppointmentID()
	{
		return this.appointmentid;
	}
	public void setAppointmentID(String value)
	{
		this.appointmentid = value;
	}
	public String getReferralID()
	{
		return this.referralid;
	}
	public void setReferralID(String value)
	{
		this.referralid = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getParentLocMapping()
	{
		return this.parentlocmapping;
	}
	public void setParentLocMapping(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.parentlocmapping = value;
	}

	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.LocShortMappingsVoBean locmapping;
	private String appointmentid;
	private String referralid;
	private ims.core.vo.beans.LocShortMappingsVoBean parentlocmapping;
}
