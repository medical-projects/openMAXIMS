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

public class TrackingSendToAreaVoBean extends ims.vo.ValueObjectBean
{
	public TrackingSendToAreaVoBean()
	{
	}
	public TrackingSendToAreaVoBean(ims.emergency.vo.TrackingSendToAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EpisodeDetailsVoBean)vo.getEpisode().getBean();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.AttendanceDetailsVoBean)vo.getAttendance().getBean();
		this.currentreferral = vo.getCurrentReferral() == null ? null : new ims.vo.RefVoBean(vo.getCurrentReferral().getBoId(), vo.getCurrentReferral().getBoVersion());
		this.triagedetails = vo.getTriageDetails() == null ? null : new ims.vo.RefVoBean(vo.getTriageDetails().getBoId(), vo.getTriageDetails().getBoVersion());
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaVoBean)vo.getCurrentArea().getBean();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean();
		this.isunknownpatient = vo.getIsUnknownPatient();
		this.isprimarycare = vo.getIsPrimaryCare();
		this.currentdnw = vo.getCurrentDNW() == null ? null : new ims.vo.RefVoBean(vo.getCurrentDNW().getBoId(), vo.getCurrentDNW().getBoVersion());
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingSendToAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EpisodeDetailsVoBean)vo.getEpisode().getBean(map);
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.AttendanceDetailsVoBean)vo.getAttendance().getBean(map);
		this.currentreferral = vo.getCurrentReferral() == null ? null : new ims.vo.RefVoBean(vo.getCurrentReferral().getBoId(), vo.getCurrentReferral().getBoVersion());
		this.triagedetails = vo.getTriageDetails() == null ? null : new ims.vo.RefVoBean(vo.getTriageDetails().getBoId(), vo.getTriageDetails().getBoVersion());
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaVoBean)vo.getCurrentArea().getBean(map);
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.isunknownpatient = vo.getIsUnknownPatient();
		this.isprimarycare = vo.getIsPrimaryCare();
		this.currentdnw = vo.getCurrentDNW() == null ? null : new ims.vo.RefVoBean(vo.getCurrentDNW().getBoId(), vo.getCurrentDNW().getBoVersion());
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
	}

	public ims.emergency.vo.TrackingSendToAreaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingSendToAreaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingSendToAreaVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingSendToAreaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingSendToAreaVo();
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
	public ims.emergency.vo.beans.EpisodeDetailsVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.beans.EpisodeDetailsVoBean value)
	{
		this.episode = value;
	}
	public ims.emergency.vo.beans.AttendanceDetailsVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.AttendanceDetailsVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.RefVoBean getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.vo.RefVoBean value)
	{
		this.currentreferral = value;
	}
	public ims.vo.RefVoBean getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.vo.RefVoBean value)
	{
		this.triagedetails = value;
	}
	public ims.emergency.vo.beans.TrackingAreaVoBean getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.vo.beans.TrackingAreaVoBean value)
	{
		this.currentarea = value;
	}
	public ims.vo.RefVoBean getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.vo.RefVoBean value)
	{
		this.edlocation = value;
	}
	public ims.emergency.vo.beans.TrackingAttendanceStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.beans.TrackingAttendanceStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public Boolean getIsUnknownPatient()
	{
		return this.isunknownpatient;
	}
	public void setIsUnknownPatient(Boolean value)
	{
		this.isunknownpatient = value;
	}
	public Boolean getIsPrimaryCare()
	{
		return this.isprimarycare;
	}
	public void setIsPrimaryCare(Boolean value)
	{
		this.isprimarycare = value;
	}
	public ims.vo.RefVoBean getCurrentDNW()
	{
		return this.currentdnw;
	}
	public void setCurrentDNW(ims.vo.RefVoBean value)
	{
		this.currentdnw = value;
	}
	public ims.vo.LookupInstanceBean getDischargeLetterStatus()
	{
		return this.dischargeletterstatus;
	}
	public void setDischargeLetterStatus(ims.vo.LookupInstanceBean value)
	{
		this.dischargeletterstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.emergency.vo.beans.EpisodeDetailsVoBean episode;
	private ims.emergency.vo.beans.AttendanceDetailsVoBean attendance;
	private ims.vo.RefVoBean currentreferral;
	private ims.vo.RefVoBean triagedetails;
	private ims.emergency.vo.beans.TrackingAreaVoBean currentarea;
	private ims.vo.RefVoBean edlocation;
	private ims.emergency.vo.beans.TrackingAttendanceStatusVoBean currentstatus;
	private Boolean isunknownpatient;
	private Boolean isprimarycare;
	private ims.vo.RefVoBean currentdnw;
	private ims.vo.LookupInstanceBean dischargeletterstatus;
}
