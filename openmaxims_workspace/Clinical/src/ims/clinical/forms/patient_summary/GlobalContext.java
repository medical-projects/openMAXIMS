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

package ims.clinical.forms.patient_summary;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
		ICP = new ICPContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientSummary = new PatientSummaryContext(context);
		}
		public final class PatientSummaryContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientSummaryContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getCareSpellIsNotNull()
			{
				return !cx_ClinicalPatientSummaryCareSpell.getValueIsNull(context);
			}
			public ims.core.vo.CareSpellVo getCareSpell()
			{
				return (ims.core.vo.CareSpellVo)cx_ClinicalPatientSummaryCareSpell.getValue(context);
			}
		public void setCareSpell(ims.core.vo.CareSpellVo value)
		{
				cx_ClinicalPatientSummaryCareSpell.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryCareSpell = new ims.framework.ContextVariable("Clinical.PatientSummary.CareSpell", "_cv_Clinical.PatientSummary.CareSpell");
			public boolean getClinicalContactIsNotNull()
			{
				return !cx_ClinicalPatientSummaryClinicalContact.getValueIsNull(context);
			}
			public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
			{
				return (ims.core.admin.vo.ClinicalContactRefVo)cx_ClinicalPatientSummaryClinicalContact.getValue(context);
			}
		public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
		{
				cx_ClinicalPatientSummaryClinicalContact.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryClinicalContact = new ims.framework.ContextVariable("Clinical.PatientSummary.ClinicalContact", "_cv_Clinical.PatientSummary.ClinicalContact");
			public boolean getEpisodeOfCareIsNotNull()
			{
				return !cx_ClinicalPatientSummaryEpisodeOfCare.getValueIsNull(context);
			}
			public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
			{
				return (ims.core.admin.vo.EpisodeOfCareRefVo)cx_ClinicalPatientSummaryEpisodeOfCare.getValue(context);
			}
		public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
		{
				cx_ClinicalPatientSummaryEpisodeOfCare.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryEpisodeOfCare = new ims.framework.ContextVariable("Clinical.PatientSummary.EpisodeOfCare", "_cv_Clinical.PatientSummary.EpisodeOfCare");
			public boolean getPrimaryAssociationIsNotNull()
			{
				return !cx_ClinicalPatientSummaryPrimaryAssociation.getValueIsNull(context);
			}
			public ims.vo.ValueObject getPrimaryAssociation()
			{
				return (ims.vo.ValueObject)cx_ClinicalPatientSummaryPrimaryAssociation.getValue(context);
			}
		public void setPrimaryAssociation(ims.vo.ValueObject value)
		{
				cx_ClinicalPatientSummaryPrimaryAssociation.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryPrimaryAssociation = new ims.framework.ContextVariable("Clinical.PatientSummary.PrimaryAssociation", "_cv_Clinical.PatientSummary.PrimaryAssociation");
			public boolean getCareContextIsNotNull()
			{
				return !cx_ClinicalPatientSummaryCareContext.getValueIsNull(context);
			}
			public ims.core.admin.vo.CareContextRefVo getCareContext()
			{
				return (ims.core.admin.vo.CareContextRefVo)cx_ClinicalPatientSummaryCareContext.getValue(context);
			}
		public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
		{
				cx_ClinicalPatientSummaryCareContext.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryCareContext = new ims.framework.ContextVariable("Clinical.PatientSummary.CareContext", "_cv_Clinical.PatientSummary.CareContext");
			private ims.framework.Context context;
		}

		public boolean getCareContextWithHistoryIsNotNull()
		{
			return !cx_ClinicalCareContextWithHistory.getValueIsNull(context);
		}
		public ims.core.vo.CareContextSmallVo getCareContextWithHistory()
		{
			return (ims.core.vo.CareContextSmallVo)cx_ClinicalCareContextWithHistory.getValue(context);
		}
		public void setCareContextWithHistory(ims.core.vo.CareContextSmallVo value)
		{
			cx_ClinicalCareContextWithHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalCareContextWithHistory = new ims.framework.ContextVariable("Clinical.CareContextWithHistory", "_cv_Clinical.CareContextWithHistory");
		public boolean getReturnToFormModeIsNotNull()
		{
			return !cx_ClinicalReturnToFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getReturnToFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_ClinicalReturnToFormMode.getValue(context);
		}
		public void setReturnToFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_ClinicalReturnToFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormMode = new ims.framework.ContextVariable("Clinical.ReturnToFormMode", "_cv_Clinical.ReturnToFormMode");
		public boolean getReturnToFormNameIsNotNull()
		{
			return !cx_ClinicalReturnToFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getReturnToFormName()
		{
			return (ims.framework.FormName)cx_ClinicalReturnToFormName.getValue(context);
		}
		public void setReturnToFormName(ims.framework.FormName value)
		{
			cx_ClinicalReturnToFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormName = new ims.framework.ContextVariable("Clinical.ReturnToFormName", "_cv_Clinical.ReturnToFormName");
		public boolean getEpisodeOfCareWithHistoryIsNotNull()
		{
			return !cx_ClinicalEpisodeOfCareWithHistory.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeOfCareSmallVo getEpisodeOfCareWithHistory()
		{
			return (ims.core.vo.EpisodeOfCareSmallVo)cx_ClinicalEpisodeOfCareWithHistory.getValue(context);
		}
		public void setEpisodeOfCareWithHistory(ims.core.vo.EpisodeOfCareSmallVo value)
		{
			cx_ClinicalEpisodeOfCareWithHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalEpisodeOfCareWithHistory = new ims.framework.ContextVariable("Clinical.EpisodeOfCareWithHistory", "_cv_Clinical.EpisodeOfCareWithHistory");
		public boolean getIsDiAssociationDialogOpenedFromPatientSummaryIsNotNull()
		{
			return !cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary.getValueIsNull(context);
		}
		public Boolean getIsDiAssociationDialogOpenedFromPatientSummary()
		{
			return (Boolean)cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary.getValue(context);
		}
		public void setIsDiAssociationDialogOpenedFromPatientSummary(Boolean value)
		{
			cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary = new ims.framework.ContextVariable("Clinical.IsDiAssociationDialogOpenedFromPatientSummary", "_cv_Clinical.IsDiAssociationDialogOpenedFromPatientSummary");
		public boolean getCurrentClinicalNoteIsNotNull()
		{
			return !cx_ClinicalCurrentClinicalNote.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalNotesVo getCurrentClinicalNote()
		{
			return (ims.core.vo.ClinicalNotesVo)cx_ClinicalCurrentClinicalNote.getValue(context);
		}
		public void setCurrentClinicalNote(ims.core.vo.ClinicalNotesVo value)
		{
			cx_ClinicalCurrentClinicalNote.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalCurrentClinicalNote = new ims.framework.ContextVariable("Clinical.CurrentClinicalNote", "_cvp_Clinical.CurrentClinicalNote");
		public boolean getSelectedPatientProcedureFromPatientSummaryIsNotNull()
		{
			return !cx_ClinicalSelectedPatientProcedureFromPatientSummary.getValueIsNull(context);
		}
		public ims.core.clinical.vo.PatientProcedureRefVo getSelectedPatientProcedureFromPatientSummary()
		{
			return (ims.core.clinical.vo.PatientProcedureRefVo)cx_ClinicalSelectedPatientProcedureFromPatientSummary.getValue(context);
		}
		public void setSelectedPatientProcedureFromPatientSummary(ims.core.clinical.vo.PatientProcedureRefVo value)
		{
			cx_ClinicalSelectedPatientProcedureFromPatientSummary.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientProcedureFromPatientSummary = new ims.framework.ContextVariable("Clinical.SelectedPatientProcedureFromPatientSummary", "_cv_Clinical.SelectedPatientProcedureFromPatientSummary");
		public boolean getUnsavedSOAPINformationIsNotNull()
		{
			return !cx_ClinicalUnsavedSOAPINformation.getValueIsNull(context);
		}
		public ims.core.vo.SOAPVo getUnsavedSOAPINformation()
		{
			return (ims.core.vo.SOAPVo)cx_ClinicalUnsavedSOAPINformation.getValue(context);
		}
		public void setUnsavedSOAPINformation(ims.core.vo.SOAPVo value)
		{
			cx_ClinicalUnsavedSOAPINformation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalUnsavedSOAPINformation = new ims.framework.ContextVariable("Clinical.UnsavedSOAPINformation", "_cv_Clinical.UnsavedSOAPINformation");
		public boolean getContextFilterIsNotNull()
		{
			return !cx_ClinicalContextFilter.getValueIsNull(context);
		}
		public ims.clinical.vo.ContextFilterVo getContextFilter()
		{
			return (ims.clinical.vo.ContextFilterVo)cx_ClinicalContextFilter.getValue(context);
		}
		public void setContextFilter(ims.clinical.vo.ContextFilterVo value)
		{
			cx_ClinicalContextFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalContextFilter = new ims.framework.ContextVariable("Clinical.ContextFilter", "_cvp_Clinical.ContextFilter");
		public boolean getIsDiagnosisRecordUpdatedIsNotNull()
		{
			return !cx_ClinicalIsDiagnosisRecordUpdated.getValueIsNull(context);
		}
		public Boolean getIsDiagnosisRecordUpdated()
		{
			return (Boolean)cx_ClinicalIsDiagnosisRecordUpdated.getValue(context);
		}
		public void setIsDiagnosisRecordUpdated(Boolean value)
		{
			cx_ClinicalIsDiagnosisRecordUpdated.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalIsDiagnosisRecordUpdated = new ims.framework.ContextVariable("Clinical.IsDiagnosisRecordUpdated", "_cv_Clinical.IsDiagnosisRecordUpdated");
		public boolean getSelectedPatientDiagnosisFromPatientSummaryIsNotNull()
		{
			return !cx_ClinicalSelectedPatientDiagnosisFromPatientSummary.getValueIsNull(context);
		}
		public ims.core.clinical.vo.PatientDiagnosisRefVo getSelectedPatientDiagnosisFromPatientSummary()
		{
			return (ims.core.clinical.vo.PatientDiagnosisRefVo)cx_ClinicalSelectedPatientDiagnosisFromPatientSummary.getValue(context);
		}
		public void setSelectedPatientDiagnosisFromPatientSummary(ims.core.clinical.vo.PatientDiagnosisRefVo value)
		{
			cx_ClinicalSelectedPatientDiagnosisFromPatientSummary.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientDiagnosisFromPatientSummary = new ims.framework.ContextVariable("Clinical.SelectedPatientDiagnosisFromPatientSummary", "_cv_Clinical.SelectedPatientDiagnosisFromPatientSummary");
		public boolean getSelectedPatientProblemFromPatientSummaryIsNotNull()
		{
			return !cx_ClinicalSelectedPatientProblemFromPatientSummary.getValueIsNull(context);
		}
		public ims.core.clinical.vo.PatientProblemRefVo getSelectedPatientProblemFromPatientSummary()
		{
			return (ims.core.clinical.vo.PatientProblemRefVo)cx_ClinicalSelectedPatientProblemFromPatientSummary.getValue(context);
		}
		public void setSelectedPatientProblemFromPatientSummary(ims.core.clinical.vo.PatientProblemRefVo value)
		{
			cx_ClinicalSelectedPatientProblemFromPatientSummary.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientProblemFromPatientSummary = new ims.framework.ContextVariable("Clinical.SelectedPatientProblemFromPatientSummary", "_cv_Clinical.SelectedPatientProblemFromPatientSummary");

		public PatientSummaryContext PatientSummary;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			CurrentCareContext = new CurrentCareContextContext(context);
		}
		public final class CurrentCareContextContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CurrentCareContextContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getContextTypeIsNotNull()
			{
				return !cx_CoreCurrentCareContextContextType.getValueIsNull(context);
			}
			public Integer getContextType()
			{
				return (Integer)cx_CoreCurrentCareContextContextType.getValue(context);
			}
		public void setContextType(Integer value)
		{
				cx_CoreCurrentCareContextContextType.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CoreCurrentCareContextContextType = new ims.framework.ContextVariable("Core.CurrentCareContext.ContextType", "_cvp_Core.CurrentCareContext.ContextType");
			private ims.framework.Context context;
		}

		public boolean getClinicalContactDialogModeIsNotNull()
		{
			return !cx_CoreClinicalContactDialogMode.getValueIsNull(context);
		}
		public Integer getClinicalContactDialogMode()
		{
			return (Integer)cx_CoreClinicalContactDialogMode.getValue(context);
		}
		public void setClinicalContactDialogMode(Integer value)
		{
			cx_CoreClinicalContactDialogMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalContactDialogMode = new ims.framework.ContextVariable("Core.ClinicalContactDialogMode", "_cv_Core.ClinicalContactDialogMode");
		public boolean getClinicalNotingModeIsNotNull()
		{
			return !cx_CoreClinicalNotingMode.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ClinicalNotingMode getClinicalNotingMode()
		{
			return (ims.core.vo.lookups.ClinicalNotingMode)cx_CoreClinicalNotingMode.getValue(context);
		}
		public void setClinicalNotingMode(ims.core.vo.lookups.ClinicalNotingMode value)
		{
			cx_CoreClinicalNotingMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalNotingMode = new ims.framework.ContextVariable("Core.ClinicalNotingMode", "_cv_Core.ClinicalNotingMode");
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
		public boolean getCareSpellDialogModeIsNotNull()
		{
			return !cx_CoreCareSpellDialogMode.getValueIsNull(context);
		}
		public ims.core.vo.lookups.CareSpellDialogMode getCareSpellDialogMode()
		{
			return (ims.core.vo.lookups.CareSpellDialogMode)cx_CoreCareSpellDialogMode.getValue(context);
		}
		public void setCareSpellDialogMode(ims.core.vo.lookups.CareSpellDialogMode value)
		{
			cx_CoreCareSpellDialogMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCareSpellDialogMode = new ims.framework.ContextVariable("Core.CareSpellDialogMode", "_cv_Core.CareSpellDialogMode");
		public boolean getParentClinContactIsNotNull()
		{
			return !cx_CoreParentClinContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getParentClinContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreParentClinContact.getValue(context);
		}
		public void setParentClinContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreParentClinContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreParentClinContact = new ims.framework.ContextVariable("Core.ParentClinContact", "_cv_Core.ParentClinContact");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getClinicalContactIsNotNull()
		{
			return !cx_CoreClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactVo getClinicalContact()
		{
			return (ims.core.vo.ClinicalContactVo)cx_CoreClinicalContact.getValue(context);
		}
		public void setClinicalContact(ims.core.vo.ClinicalContactVo value)
		{
			cx_CoreClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalContact = new ims.framework.ContextVariable("Core.ClinicalContact", "_cv_Core.ClinicalContact");
		public boolean getClinicalNotesShortIsNotNull()
		{
			return !cx_CoreClinicalNotesShort.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalNotesShortVo getClinicalNotesShort()
		{
			return (ims.core.vo.ClinicalNotesShortVo)cx_CoreClinicalNotesShort.getValue(context);
		}
		public void setClinicalNotesShort(ims.core.vo.ClinicalNotesShortVo value)
		{
			cx_CoreClinicalNotesShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalNotesShort = new ims.framework.ContextVariable("Core.ClinicalNotesShort", "_cv_Core.ClinicalNotesShort");
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

		public CurrentCareContextContext CurrentCareContext;
		private ims.framework.Context context;
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getServiceIsNotNull()
		{
			return !cx_ICPService.getValueIsNull(context);
		}
		public ims.core.clinical.vo.ServiceRefVo getService()
		{
			return (ims.core.clinical.vo.ServiceRefVo)cx_ICPService.getValue(context);
		}
		public void setService(ims.core.clinical.vo.ServiceRefVo value)
		{
			cx_ICPService.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPService = new ims.framework.ContextVariable("ICP.Service", "_cv_ICP.Service");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public CoreContext Core;
	public ICPContext ICP;
}
