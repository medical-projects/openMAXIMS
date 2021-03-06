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

public class AppointmentOutcomeActionVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentOutcomeActionVoBean()
	{
	}
	public AppointmentOutcomeActionVoBean(ims.scheduling.vo.AppointmentOutcomeActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentaction = vo.getAppointmentAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentAction().getBean();
		this.outcomeofaction = vo.getOutcomeOfAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeOfAction().getBean();
		this.futureappointmentdetails = vo.getFutureAppointmentDetails() == null ? null : (ims.scheduling.vo.beans.FutureAppointmentDetailsVoBean)vo.getFutureAppointmentDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.AppointmentOutcomeActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentaction = vo.getAppointmentAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentAction().getBean();
		this.outcomeofaction = vo.getOutcomeOfAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeOfAction().getBean();
		this.futureappointmentdetails = vo.getFutureAppointmentDetails() == null ? null : (ims.scheduling.vo.beans.FutureAppointmentDetailsVoBean)vo.getFutureAppointmentDetails().getBean(map);
	}

	public ims.scheduling.vo.AppointmentOutcomeActionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.AppointmentOutcomeActionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.AppointmentOutcomeActionVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.AppointmentOutcomeActionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.AppointmentOutcomeActionVo();
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
	public ims.vo.LookupInstanceBean getAppointmentAction()
	{
		return this.appointmentaction;
	}
	public void setAppointmentAction(ims.vo.LookupInstanceBean value)
	{
		this.appointmentaction = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeOfAction()
	{
		return this.outcomeofaction;
	}
	public void setOutcomeOfAction(ims.vo.LookupInstanceBean value)
	{
		this.outcomeofaction = value;
	}
	public ims.scheduling.vo.beans.FutureAppointmentDetailsVoBean getFutureAppointmentDetails()
	{
		return this.futureappointmentdetails;
	}
	public void setFutureAppointmentDetails(ims.scheduling.vo.beans.FutureAppointmentDetailsVoBean value)
	{
		this.futureappointmentdetails = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean appointmentaction;
	private ims.vo.LookupInstanceBean outcomeofaction;
	private ims.scheduling.vo.beans.FutureAppointmentDetailsVoBean futureappointmentdetails;
}
