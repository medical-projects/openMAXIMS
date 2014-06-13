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

package ims.clinical.vo.beans;

public class PatientMeetingVoBean extends ims.vo.ValueObjectBean
{
	public PatientMeetingVoBean()
	{
	}
	public PatientMeetingVoBean(ims.clinical.vo.PatientMeetingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.meetingdatetime = vo.getMeetingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMeetingDateTime().getBean();
		this.nextmeetingdate = vo.getNextMeetingDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getNextMeetingDate().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.meetingnotes = vo.getMeetingNotes();
		this.attendees = vo.getAttendees() == null ? null : vo.getAttendees().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientMeetingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.meetingdatetime = vo.getMeetingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMeetingDateTime().getBean();
		this.nextmeetingdate = vo.getNextMeetingDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getNextMeetingDate().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.meetingnotes = vo.getMeetingNotes();
		this.attendees = vo.getAttendees() == null ? null : vo.getAttendees().getBeanCollection();
	}

	public ims.clinical.vo.PatientMeetingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientMeetingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientMeetingVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientMeetingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientMeetingVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMeetingDateTime()
	{
		return this.meetingdatetime;
	}
	public void setMeetingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.meetingdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getNextMeetingDate()
	{
		return this.nextmeetingdate;
	}
	public void setNextMeetingDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.nextmeetingdate = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public String getMeetingNotes()
	{
		return this.meetingnotes;
	}
	public void setMeetingNotes(String value)
	{
		this.meetingnotes = value;
	}
	public ims.clinical.vo.beans.PatientMeetingInviteeVoBean[] getAttendees()
	{
		return this.attendees;
	}
	public void setAttendees(ims.clinical.vo.beans.PatientMeetingInviteeVoBean[] value)
	{
		this.attendees = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.framework.utils.beans.DateTimeBean meetingdatetime;
	private ims.framework.utils.beans.DateTimeBean nextmeetingdate;
	private ims.vo.LookupInstanceBean status;
	private String meetingnotes;
	private ims.clinical.vo.beans.PatientMeetingInviteeVoBean[] attendees;
}
