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

public class ReferralToSpecialtyTeamVoBean extends ims.vo.ValueObjectBean
{
	public ReferralToSpecialtyTeamVoBean()
	{
	}
	public ReferralToSpecialtyTeamVoBean(ims.emergency.vo.ReferralToSpecialtyTeamVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.teamconsultant = vo.getTeamConsultant() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamConsultant().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.referreddatetime = vo.getReferredDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReferredDateTime().getBean();
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
		this.completiondatetime = vo.getCompletionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletionDateTime().getBean();
		this.referredby = vo.getReferredBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferredBy().getBean();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.notaccepted = vo.getNotAccepted();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.ReferralToSpecialtyTeamVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.teamconsultant = vo.getTeamConsultant() == null ? null : (ims.vo.LookupInstanceBean)vo.getTeamConsultant().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.referreddatetime = vo.getReferredDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReferredDateTime().getBean();
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
		this.completiondatetime = vo.getCompletionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletionDateTime().getBean();
		this.referredby = vo.getReferredBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferredBy().getBean(map);
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
		this.notaccepted = vo.getNotAccepted();
	}

	public ims.emergency.vo.ReferralToSpecialtyTeamVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.ReferralToSpecialtyTeamVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.ReferralToSpecialtyTeamVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.ReferralToSpecialtyTeamVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.ReferralToSpecialtyTeamVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.RefVoBean getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.vo.RefVoBean value)
	{
		this.trackingarea = value;
	}
	public ims.vo.LookupInstanceBean getTeamConsultant()
	{
		return this.teamconsultant;
	}
	public void setTeamConsultant(ims.vo.LookupInstanceBean value)
	{
		this.teamconsultant = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReferredDateTime()
	{
		return this.referreddatetime;
	}
	public void setReferredDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.referreddatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSeenDateTime()
	{
		return this.seendatetime;
	}
	public void setSeenDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.seendatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletionDateTime()
	{
		return this.completiondatetime;
	}
	public void setCompletionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completiondatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReferredBy()
	{
		return this.referredby;
	}
	public void setReferredBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.referredby = value;
	}
	public ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] getComments()
	{
		return this.comments;
	}
	public void setComments(ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] value)
	{
		this.comments = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}
	public Boolean getNotAccepted()
	{
		return this.notaccepted;
	}
	public void setNotAccepted(Boolean value)
	{
		this.notaccepted = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean attendance;
	private ims.vo.RefVoBean trackingarea;
	private ims.vo.LookupInstanceBean teamconsultant;
	private ims.vo.LookupInstanceBean specialty;
	private ims.framework.utils.beans.DateTimeBean referreddatetime;
	private ims.framework.utils.beans.DateTimeBean seendatetime;
	private ims.framework.utils.beans.DateTimeBean completiondatetime;
	private ims.core.vo.beans.HcpLiteVoBean referredby;
	private ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] comments;
	private ims.vo.SysInfoBean systeminformation;
	private Boolean notaccepted;
}
