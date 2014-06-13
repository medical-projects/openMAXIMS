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

package ims.careuk.vo.beans;

public class TheatreProcedureServiceAndConsultantLiteVoBean extends ims.vo.ValueObjectBean
{
	public TheatreProcedureServiceAndConsultantLiteVoBean()
	{
	}
	public TheatreProcedureServiceAndConsultantLiteVoBean(ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo vo)
	{
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		// Interface field type not supported.
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo vo)
	{
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		// Interface field type not supported.
	}

	public ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.TheatreProcedureServiceAndConsultantLiteVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}

	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private ims.core.vo.beans.ServiceLiteVoBean service;
}