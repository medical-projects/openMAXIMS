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

public class PatientICPVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPVoBean()
	{
	}
	public PatientICPVoBean(ims.icp.vo.PatientICPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICPLiteVoBean)vo.getICP().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		if(vo.getAppointments() != null)
		{
			this.appointments = new ims.vo.RefVoBean[vo.getAppointments().size()];
			for(int appointments_i = 0; appointments_i < vo.getAppointments().size(); appointments_i++)
			{
				this.appointments[appointments_i] = new ims.vo.RefVoBean(vo.getAppointments().get(appointments_i).getBoId(),vo.getAppointments().get(appointments_i).getBoVersion());
			}
		}
		if(vo.getCriticalEvents() != null)
		{
			this.criticalevents = new ims.vo.RefVoBean[vo.getCriticalEvents().size()];
			for(int criticalevents_i = 0; criticalevents_i < vo.getCriticalEvents().size(); criticalevents_i++)
			{
				this.criticalevents[criticalevents_i] = new ims.vo.RefVoBean(vo.getCriticalEvents().get(criticalevents_i).getBoId(),vo.getCriticalEvents().get(criticalevents_i).getBoVersion());
			}
		}
		this.starteddatetime = vo.getStartedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartedDateTime().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		if(vo.getEvaluationNotes() != null)
		{
			this.evaluationnotes = new ims.vo.RefVoBean[vo.getEvaluationNotes().size()];
			for(int evaluationnotes_i = 0; evaluationnotes_i < vo.getEvaluationNotes().size(); evaluationnotes_i++)
			{
				this.evaluationnotes[evaluationnotes_i] = new ims.vo.RefVoBean(vo.getEvaluationNotes().get(evaluationnotes_i).getBoId(),vo.getEvaluationNotes().get(evaluationnotes_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICPLiteVoBean)vo.getICP().getBean(map);
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		if(vo.getAppointments() != null)
		{
			this.appointments = new ims.vo.RefVoBean[vo.getAppointments().size()];
			for(int appointments_i = 0; appointments_i < vo.getAppointments().size(); appointments_i++)
			{
				this.appointments[appointments_i] = new ims.vo.RefVoBean(vo.getAppointments().get(appointments_i).getBoId(),vo.getAppointments().get(appointments_i).getBoVersion());
			}
		}
		if(vo.getCriticalEvents() != null)
		{
			this.criticalevents = new ims.vo.RefVoBean[vo.getCriticalEvents().size()];
			for(int criticalevents_i = 0; criticalevents_i < vo.getCriticalEvents().size(); criticalevents_i++)
			{
				this.criticalevents[criticalevents_i] = new ims.vo.RefVoBean(vo.getCriticalEvents().get(criticalevents_i).getBoId(),vo.getCriticalEvents().get(criticalevents_i).getBoVersion());
			}
		}
		this.starteddatetime = vo.getStartedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartedDateTime().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		if(vo.getEvaluationNotes() != null)
		{
			this.evaluationnotes = new ims.vo.RefVoBean[vo.getEvaluationNotes().size()];
			for(int evaluationnotes_i = 0; evaluationnotes_i < vo.getEvaluationNotes().size(); evaluationnotes_i++)
			{
				this.evaluationnotes[evaluationnotes_i] = new ims.vo.RefVoBean(vo.getEvaluationNotes().get(evaluationnotes_i).getBoId(),vo.getEvaluationNotes().get(evaluationnotes_i).getBoVersion());
			}
		}
	}

	public ims.icp.vo.PatientICPVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPVo();
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
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.icp.vo.beans.ICPLiteVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icp.vo.beans.ICPLiteVoBean value)
	{
		this.icp = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.icp.vo.beans.PatientICPStageVoBean[] getStages()
	{
		return this.stages;
	}
	public void setStages(ims.icp.vo.beans.PatientICPStageVoBean[] value)
	{
		this.stages = value;
	}
	public Boolean getHasOutstandingAdminActions()
	{
		return this.hasoutstandingadminactions;
	}
	public void setHasOutstandingAdminActions(Boolean value)
	{
		this.hasoutstandingadminactions = value;
	}
	public Boolean getHasOutstandingNursingActions()
	{
		return this.hasoutstandingnursingactions;
	}
	public void setHasOutstandingNursingActions(Boolean value)
	{
		this.hasoutstandingnursingactions = value;
	}
	public Boolean getHasOutstandingPhysioActions()
	{
		return this.hasoutstandingphysioactions;
	}
	public void setHasOutstandingPhysioActions(Boolean value)
	{
		this.hasoutstandingphysioactions = value;
	}
	public Boolean getHasOutstandingClinicalActions()
	{
		return this.hasoutstandingclinicalactions;
	}
	public void setHasOutstandingClinicalActions(Boolean value)
	{
		this.hasoutstandingclinicalactions = value;
	}
	public ims.vo.RefVoBean[] getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.vo.RefVoBean[] value)
	{
		this.appointments = value;
	}
	public ims.vo.RefVoBean[] getCriticalEvents()
	{
		return this.criticalevents;
	}
	public void setCriticalEvents(ims.vo.RefVoBean[] value)
	{
		this.criticalevents = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartedDateTime()
	{
		return this.starteddatetime;
	}
	public void setStartedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.starteddatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.vo.RefVoBean[] getEvaluationNotes()
	{
		return this.evaluationnotes;
	}
	public void setEvaluationNotes(ims.vo.RefVoBean[] value)
	{
		this.evaluationnotes = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean pasevent;
	private ims.icp.vo.beans.ICPLiteVoBean icp;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.icp.vo.beans.PatientICPStageVoBean[] stages;
	private Boolean hasoutstandingadminactions;
	private Boolean hasoutstandingnursingactions;
	private Boolean hasoutstandingphysioactions;
	private Boolean hasoutstandingclinicalactions;
	private ims.vo.RefVoBean[] appointments;
	private ims.vo.RefVoBean[] criticalevents;
	private ims.framework.utils.beans.DateTimeBean starteddatetime;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.vo.RefVoBean[] evaluationnotes;
}
