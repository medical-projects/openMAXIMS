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

package ims.emergency.vo.beans;

public class PatientForTriageVoBean extends ims.vo.ValueObjectBean
{
	public PatientForTriageVoBean()
	{
	}
	public PatientForTriageVoBean(ims.emergency.vo.PatientForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean();
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.hasalerts = vo.getHasAlerts();
		this.hasallergies = vo.getHasAllergies();
		this.photo = vo.getPhoto() == null ? null : (ims.core.vo.beans.AppDBImageVoBean)vo.getPhoto().getBean();
		this.isquickregistrationpatient = vo.getIsQuickRegistrationPatient();
		this.ocsnotification = vo.getOCSNotification() == null ? null : (ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean)vo.getOCSNotification().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.PatientForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean(map);
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.hasalerts = vo.getHasAlerts();
		this.hasallergies = vo.getHasAllergies();
		this.photo = vo.getPhoto() == null ? null : (ims.core.vo.beans.AppDBImageVoBean)vo.getPhoto().getBean(map);
		this.isquickregistrationpatient = vo.getIsQuickRegistrationPatient();
		this.ocsnotification = vo.getOCSNotification() == null ? null : (ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean)vo.getOCSNotification().getBean(map);
	}

	public ims.emergency.vo.PatientForTriageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.PatientForTriageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.PatientForTriageVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.PatientForTriageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.PatientForTriageVo();
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
	public ims.core.vo.beans.PersonNameBean getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.beans.PersonNameBean value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getSex()
	{
		return this.sex;
	}
	public void setSex(ims.vo.LookupInstanceBean value)
	{
		this.sex = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public ims.core.vo.beans.PatientIdBean[] getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.beans.PatientIdBean[] value)
	{
		this.identifiers = value;
	}
	public Boolean getHasAlerts()
	{
		return this.hasalerts;
	}
	public void setHasAlerts(Boolean value)
	{
		this.hasalerts = value;
	}
	public Boolean getHasAllergies()
	{
		return this.hasallergies;
	}
	public void setHasAllergies(Boolean value)
	{
		this.hasallergies = value;
	}
	public ims.core.vo.beans.AppDBImageVoBean getPhoto()
	{
		return this.photo;
	}
	public void setPhoto(ims.core.vo.beans.AppDBImageVoBean value)
	{
		this.photo = value;
	}
	public Boolean getIsQuickRegistrationPatient()
	{
		return this.isquickregistrationpatient;
	}
	public void setIsQuickRegistrationPatient(Boolean value)
	{
		this.isquickregistrationpatient = value;
	}
	public ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean getOCSNotification()
	{
		return this.ocsnotification;
	}
	public void setOCSNotification(ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean value)
	{
		this.ocsnotification = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PersonNameBean name;
	private ims.vo.LookupInstanceBean sex;
	private ims.framework.utils.beans.PartialDateBean dob;
	private ims.core.vo.beans.PatientIdBean[] identifiers;
	private Boolean hasalerts;
	private Boolean hasallergies;
	private ims.core.vo.beans.AppDBImageVoBean photo;
	private Boolean isquickregistrationpatient;
	private ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean ocsnotification;
}
