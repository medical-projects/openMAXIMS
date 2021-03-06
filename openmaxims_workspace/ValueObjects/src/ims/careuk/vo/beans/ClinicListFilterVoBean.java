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

public class ClinicListFilterVoBean extends ims.vo.ValueObjectBean
{
	public ClinicListFilterVoBean()
	{
	}
	public ClinicListFilterVoBean(ims.careuk.vo.ClinicListFilterVo vo)
	{
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileShortVoBean)vo.getProfile().getBean();
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
		// Interface field type not supported.
		this.contract = vo.getContract() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getContract().getBean();
		this.wastimeron = vo.getWasTimerOn();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ClinicListFilterVo vo)
	{
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileShortVoBean)vo.getProfile().getBean(map);
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
		// Interface field type not supported.
		this.contract = vo.getContract() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getContract().getBean(map);
		this.wastimeron = vo.getWasTimerOn();
	}

	public ims.careuk.vo.ClinicListFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ClinicListFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ClinicListFilterVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ClinicListFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ClinicListFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.scheduling.vo.beans.ProfileShortVoBean getProfile()
	{
		return this.profile;
	}
	public void setProfile(ims.scheduling.vo.beans.ProfileShortVoBean value)
	{
		this.profile = value;
	}
	public ims.framework.utils.beans.DateBean getClinicDate()
	{
		return this.clinicdate;
	}
	public void setClinicDate(ims.framework.utils.beans.DateBean value)
	{
		this.clinicdate = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.RefVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.vo.RefVoBean value)
	{
		this.session = value;
	}
	public ims.core.vo.beans.OrganisationLiteVoBean getContract()
	{
		return this.contract;
	}
	public void setContract(ims.core.vo.beans.OrganisationLiteVoBean value)
	{
		this.contract = value;
	}
	public Boolean getWasTimerOn()
	{
		return this.wastimeron;
	}
	public void setWasTimerOn(Boolean value)
	{
		this.wastimeron = value;
	}

	private ims.scheduling.vo.beans.ProfileShortVoBean profile;
	private ims.framework.utils.beans.DateBean clinicdate;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.RefVoBean session;
	private ims.core.vo.beans.OrganisationLiteVoBean contract;
	private Boolean wastimeron;
}
