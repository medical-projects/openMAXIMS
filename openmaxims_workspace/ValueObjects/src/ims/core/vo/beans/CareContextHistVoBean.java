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

public class CareContextHistVoBean extends ims.vo.ValueObjectBean
{
	public CareContextHistVoBean()
	{
	}
	public CareContextHistVoBean(ims.core.vo.CareContextHistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.locationtype = vo.getLocationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocationType().getBean();
		this.bednumber = vo.getBedNumber();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CareContextHistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.locationtype = vo.getLocationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocationType().getBean();
		this.bednumber = vo.getBedNumber();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean(map);
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public ims.core.vo.CareContextHistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CareContextHistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CareContextHistVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CareContextHistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CareContextHistVo();
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
	public ims.vo.LookupInstanceBean getContext()
	{
		return this.context;
	}
	public void setContext(ims.vo.LookupInstanceBean value)
	{
		this.context = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.enddatetime = value;
	}
	public ims.vo.LookupInstanceBean getLocationType()
	{
		return this.locationtype;
	}
	public void setLocationType(ims.vo.LookupInstanceBean value)
	{
		this.locationtype = value;
	}
	public String getBedNumber()
	{
		return this.bednumber;
	}
	public void setBedNumber(String value)
	{
		this.bednumber = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean context;
	private ims.framework.utils.beans.DateTimeBean startdatetime;
	private ims.framework.utils.beans.DateTimeBean enddatetime;
	private ims.vo.LookupInstanceBean locationtype;
	private String bednumber;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private ims.vo.SysInfoBean systeminformation;
}
