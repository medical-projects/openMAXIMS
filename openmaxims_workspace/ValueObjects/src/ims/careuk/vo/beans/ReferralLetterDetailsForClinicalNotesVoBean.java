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

public class ReferralLetterDetailsForClinicalNotesVoBean extends ims.vo.ValueObjectBean
{
	public ReferralLetterDetailsForClinicalNotesVoBean()
	{
	}
	public ReferralLetterDetailsForClinicalNotesVoBean(ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.service = vo.getService() == null ? null : (ims.careuk.vo.beans.ServiceForClinicaNotesVoBean)vo.getService().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dateofreferral = vo.getDateOfReferral() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfReferral().getBean();
		this.service = vo.getService() == null ? null : (ims.careuk.vo.beans.ServiceForClinicaNotesVoBean)vo.getService().getBean(map);
	}

	public ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo();
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
	public ims.framework.utils.beans.DateBean getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.beans.DateBean value)
	{
		this.dateofreferral = value;
	}
	public ims.careuk.vo.beans.ServiceForClinicaNotesVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.careuk.vo.beans.ServiceForClinicaNotesVoBean value)
	{
		this.service = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean dateofreferral;
	private ims.careuk.vo.beans.ServiceForClinicaNotesVoBean service;
}
