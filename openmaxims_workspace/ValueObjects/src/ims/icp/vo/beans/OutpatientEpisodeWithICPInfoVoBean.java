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

package ims.icp.vo.beans;

public class OutpatientEpisodeWithICPInfoVoBean extends ims.vo.ValueObjectBean
{
	public OutpatientEpisodeWithICPInfoVoBean()
	{
	}
	public OutpatientEpisodeWithICPInfoVoBean(ims.icp.vo.OutpatientEpisodeWithICPInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.appointmenttime = vo.getAppointmentTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getAppointmentTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteWithListownerVoBean)vo.getSession().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.appointmenttrackingstatus = vo.getAppointmentTrackingStatus() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getAppointmentTrackingStatus().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.careuk.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean();
		this.haselectivelist = vo.getHasElectiveList();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.outcomeactions = vo.getOutcomeActions() == null ? null : vo.getOutcomeActions().getBeanCollection();
		this.casenotespulled = vo.getCaseNotesPulled();
		this.wasselected = vo.getWasSelected();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.OutpatientEpisodeWithICPInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.appointmenttime = vo.getAppointmentTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getAppointmentTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteWithListownerVoBean)vo.getSession().getBean(map);
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean(map);
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean(map);
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.appointmenttrackingstatus = vo.getAppointmentTrackingStatus() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getAppointmentTrackingStatus().getBean(map);
		this.referral = vo.getReferral() == null ? null : (ims.careuk.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean(map);
		this.haselectivelist = vo.getHasElectiveList();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.outcomeactions = vo.getOutcomeActions() == null ? null : vo.getOutcomeActions().getBeanCollection();
		this.casenotespulled = vo.getCaseNotesPulled();
		this.wasselected = vo.getWasSelected();
	}

	public ims.icp.vo.OutpatientEpisodeWithICPInfoVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.OutpatientEpisodeWithICPInfoVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.OutpatientEpisodeWithICPInfoVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.OutpatientEpisodeWithICPInfoVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.OutpatientEpisodeWithICPInfoVo();
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
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.framework.utils.beans.TimeBean getAppointmentTime()
	{
		return this.appointmenttime;
	}
	public void setAppointmentTime(ims.framework.utils.beans.TimeBean value)
	{
		this.appointmenttime = value;
	}
	public ims.scheduling.vo.beans.SessionLiteWithListownerVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionLiteWithListownerVoBean value)
	{
		this.session = value;
	}
	public ims.icp.vo.beans.PatientICPLiteVoBean getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.beans.PatientICPLiteVoBean value)
	{
		this.icpinfo = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean getCurrentApptTrakingStatus()
	{
		return this.currentappttrakingstatus;
	}
	public void setCurrentApptTrakingStatus(ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean value)
	{
		this.currentappttrakingstatus = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean getAppointmentTrackingStatus()
	{
		return this.appointmenttrackingstatus;
	}
	public void setAppointmentTrackingStatus(ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean value)
	{
		this.appointmenttrackingstatus = value;
	}
	public ims.careuk.vo.beans.CatsReferralBreachDatesVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.careuk.vo.beans.CatsReferralBreachDatesVoBean value)
	{
		this.referral = value;
	}
	public Boolean getHasElectiveList()
	{
		return this.haselectivelist;
	}
	public void setHasElectiveList(Boolean value)
	{
		this.haselectivelist = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean[] getOutcomeActions()
	{
		return this.outcomeactions;
	}
	public void setOutcomeActions(ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean[] value)
	{
		this.outcomeactions = value;
	}
	public Boolean getCaseNotesPulled()
	{
		return this.casenotespulled;
	}
	public void setCaseNotesPulled(Boolean value)
	{
		this.casenotespulled = value;
	}
	public Boolean getWasSelected()
	{
		return this.wasselected;
	}
	public void setWasSelected(Boolean value)
	{
		this.wasselected = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.framework.utils.beans.TimeBean appointmenttime;
	private ims.scheduling.vo.beans.SessionLiteWithListownerVoBean session;
	private ims.icp.vo.beans.PatientICPLiteVoBean icpinfo;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean currentappttrakingstatus;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean appointmenttrackingstatus;
	private ims.careuk.vo.beans.CatsReferralBreachDatesVoBean referral;
	private Boolean haselectivelist;
	private ims.vo.LookupInstanceBean outcome;
	private ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean[] outcomeactions;
	private Boolean casenotespulled;
	private Boolean wasselected;
}
