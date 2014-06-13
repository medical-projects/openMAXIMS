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

public class ChangeOfServiceVoBean extends ims.vo.ValueObjectBean
{
	public ChangeOfServiceVoBean()
	{
	}
	public ChangeOfServiceVoBean(ims.careuk.vo.ChangeOfServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.newservice = vo.getNewService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getNewService().getBean();
		this.originalservice = vo.getOriginalService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getOriginalService().getBean();
		this.changinguser = vo.getChangingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getChangingUser().getBean();
		this.changingdatetime = vo.getChangingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getChangingDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ChangeOfServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.newservice = vo.getNewService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getNewService().getBean(map);
		this.originalservice = vo.getOriginalService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getOriginalService().getBean(map);
		this.changinguser = vo.getChangingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getChangingUser().getBean(map);
		this.changingdatetime = vo.getChangingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getChangingDateTime().getBean();
	}

	public ims.careuk.vo.ChangeOfServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ChangeOfServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ChangeOfServiceVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ChangeOfServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ChangeOfServiceVo();
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
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getNewService()
	{
		return this.newservice;
	}
	public void setNewService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.newservice = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getOriginalService()
	{
		return this.originalservice;
	}
	public void setOriginalService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.originalservice = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getChangingUser()
	{
		return this.changinguser;
	}
	public void setChangingUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.changinguser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getChangingDateTime()
	{
		return this.changingdatetime;
	}
	public void setChangingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.changingdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.ServiceLiteVoBean newservice;
	private ims.core.vo.beans.ServiceLiteVoBean originalservice;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean changinguser;
	private ims.framework.utils.beans.DateTimeBean changingdatetime;
}
