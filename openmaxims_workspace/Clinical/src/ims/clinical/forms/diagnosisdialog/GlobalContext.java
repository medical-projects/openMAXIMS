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

package ims.clinical.forms.diagnosisdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientDiagnosisAtConsultationListIsNotNull()
		{
			return !cx_CorePatientDiagnosisAtConsultationList.getValueIsNull(context);
		}
		public ims.core.vo.PatientDiagnosisAtConsultationVoCollection getPatientDiagnosisAtConsultationList()
		{
			return (ims.core.vo.PatientDiagnosisAtConsultationVoCollection)cx_CorePatientDiagnosisAtConsultationList.getValue(context);
		}
		public void setPatientDiagnosisAtConsultationList(ims.core.vo.PatientDiagnosisAtConsultationVoCollection value)
		{
			cx_CorePatientDiagnosisAtConsultationList.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDiagnosisAtConsultationList = new ims.framework.ContextVariable("Core.PatientDiagnosisAtConsultationList", "_cv_Core.PatientDiagnosisAtConsultationList");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}
		public void setEpisodeofCareShort(ims.core.vo.EpisodeofCareShortVo value)
		{
			cx_CoreEpisodeofCareShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getPatientDiagnosisAtConsultationIsNotNull()
		{
			return !cx_CorePatientDiagnosisAtConsultation.getValueIsNull(context);
		}
		public ims.core.vo.PatientDiagnosisAtConsultationVo getPatientDiagnosisAtConsultation()
		{
			return (ims.core.vo.PatientDiagnosisAtConsultationVo)cx_CorePatientDiagnosisAtConsultation.getValue(context);
		}
		public void setPatientDiagnosisAtConsultation(ims.core.vo.PatientDiagnosisAtConsultationVo value)
		{
			cx_CorePatientDiagnosisAtConsultation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDiagnosisAtConsultation = new ims.framework.ContextVariable("Core.PatientDiagnosisAtConsultation", "_cv_Core.PatientDiagnosisAtConsultation");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDisableMainCheckboxIsNotNull()
		{
			return !cx_ClinicalDisableMainCheckbox.getValueIsNull(context);
		}
		public Boolean getDisableMainCheckbox()
		{
			return (Boolean)cx_ClinicalDisableMainCheckbox.getValue(context);
		}
		public void setDisableMainCheckbox(Boolean value)
		{
			cx_ClinicalDisableMainCheckbox.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalDisableMainCheckbox = new ims.framework.ContextVariable("Clinical.DisableMainCheckbox", "_cv_Clinical.DisableMainCheckbox");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public ClinicalContext Clinical;
}
