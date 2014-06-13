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

package ims.clinical.forms.edischargeopsprocscomponent;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
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
			private ims.framework.Context context;
		}

		public boolean getClinicalDIAssociationVoCollectionIsNotNull()
		{
			return !cx_ClinicalClinicalDIAssociationVoCollection.getValueIsNull(context);
		}
		public ims.clinical.vo.ClinicalDIAssociationVoCollection getClinicalDIAssociationVoCollection()
		{
			return (ims.clinical.vo.ClinicalDIAssociationVoCollection)cx_ClinicalClinicalDIAssociationVoCollection.getValue(context);
		}
		public void setClinicalDIAssociationVoCollection(ims.clinical.vo.ClinicalDIAssociationVoCollection value)
		{
			cx_ClinicalClinicalDIAssociationVoCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalDIAssociationVoCollection = new ims.framework.ContextVariable("Clinical.ClinicalDIAssociationVoCollection", "_cv_Clinical.ClinicalDIAssociationVoCollection");
		public boolean getDialogFormNameIsNotNull()
		{
			return !cx_ClinicalDialogFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getDialogFormName()
		{
			return (ims.framework.FormName)cx_ClinicalDialogFormName.getValue(context);
		}
		public void setDialogFormName(ims.framework.FormName value)
		{
			cx_ClinicalDialogFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalDialogFormName = new ims.framework.ContextVariable("Clinical.DialogFormName", "_cv_Clinical.DialogFormName");
		public boolean geteDischargeDisableTabsIsNotNull()
		{
			return !cx_ClinicaleDischargeDisableTabs.getValueIsNull(context);
		}
		public Boolean geteDischargeDisableTabs()
		{
			return (Boolean)cx_ClinicaleDischargeDisableTabs.getValue(context);
		}
		public void seteDischargeDisableTabs(Boolean value)
		{
			cx_ClinicaleDischargeDisableTabs.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargeDisableTabs = new ims.framework.ContextVariable("Clinical.eDischargeDisableTabs", "_cv_Clinical.eDischargeDisableTabs");
		public boolean getSelectedPatientProcedureFromNursingAdmissionIsNotNull()
		{
			return !cx_ClinicalSelectedPatientProcedureFromNursingAdmission.getValueIsNull(context);
		}
		public ims.core.clinical.vo.PatientProcedureRefVo getSelectedPatientProcedureFromNursingAdmission()
		{
			return (ims.core.clinical.vo.PatientProcedureRefVo)cx_ClinicalSelectedPatientProcedureFromNursingAdmission.getValue(context);
		}
		public void setSelectedPatientProcedureFromNursingAdmission(ims.core.clinical.vo.PatientProcedureRefVo value)
		{
			cx_ClinicalSelectedPatientProcedureFromNursingAdmission.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientProcedureFromNursingAdmission = new ims.framework.ContextVariable("Clinical.SelectedPatientProcedureFromNursingAdmission", "_cv_Clinical.SelectedPatientProcedureFromNursingAdmission");
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
		public boolean geteDischargeCompletedIsNotNull()
		{
			return !cx_ClinicaleDischargeCompleted.getValueIsNull(context);
		}
		public Boolean geteDischargeCompleted()
		{
			return (Boolean)cx_ClinicaleDischargeCompleted.getValue(context);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargeCompleted = new ims.framework.ContextVariable("Clinical.eDischargeCompleted", "_cv_Clinical.eDischargeCompleted");
		public boolean getClinicalDIassociationsFormModeIsNotNull()
		{
			return !cx_ClinicalClinicalDIassociationsFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getClinicalDIassociationsFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_ClinicalClinicalDIassociationsFormMode.getValue(context);
		}
		public void setClinicalDIassociationsFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_ClinicalClinicalDIassociationsFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalDIassociationsFormMode = new ims.framework.ContextVariable("Clinical.ClinicalDIassociationsFormMode", "_cv_Clinical.ClinicalDIassociationsFormMode");
		public boolean getReturnToFormCDIDescriptionIsNotNull()
		{
			return !cx_ClinicalReturnToFormCDIDescription.getValueIsNull(context);
		}
		public String getReturnToFormCDIDescription()
		{
			return (String)cx_ClinicalReturnToFormCDIDescription.getValue(context);
		}
		public void setReturnToFormCDIDescription(String value)
		{
			cx_ClinicalReturnToFormCDIDescription.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormCDIDescription = new ims.framework.ContextVariable("Clinical.ReturnToFormCDIDescription", "_cv_Clinical.ReturnToFormCDIDescription");
		public boolean getReturnToFormCDITitleIsNotNull()
		{
			return !cx_ClinicalReturnToFormCDITitle.getValueIsNull(context);
		}
		public String getReturnToFormCDITitle()
		{
			return (String)cx_ClinicalReturnToFormCDITitle.getValue(context);
		}
		public void setReturnToFormCDITitle(String value)
		{
			cx_ClinicalReturnToFormCDITitle.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormCDITitle = new ims.framework.ContextVariable("Clinical.ReturnToFormCDITitle", "_cv_Clinical.ReturnToFormCDITitle");
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
		public boolean geteDischargeClinicalCompleteIsNotNull()
		{
			return !cx_ClinicaleDischargeClinicalComplete.getValueIsNull(context);
		}
		public Boolean geteDischargeClinicalComplete()
		{
			return (Boolean)cx_ClinicaleDischargeClinicalComplete.getValue(context);
		}
		public void seteDischargeClinicalComplete(Boolean value)
		{
			cx_ClinicaleDischargeClinicalComplete.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargeClinicalComplete = new ims.framework.ContextVariable("Clinical.eDischargeClinicalComplete", "_cv_Clinical.eDischargeClinicalComplete");

		public PatientSummaryContext PatientSummary;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getRieMessageIsNotNull()
		{
			return !cx_CoreRieMessage.getValueIsNull(context);
		}
		public String getRieMessage()
		{
			return (String)cx_CoreRieMessage.getValue(context);
		}
		public void setRieMessage(String value)
		{
			cx_CoreRieMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreRieMessage = new ims.framework.ContextVariable("Core.RieMessage", "_cv_Core.RieMessage");
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
		public boolean getSelectedPatientProcedureIsNotNull()
		{
			return !cx_CoreSelectedPatientProcedure.getValueIsNull(context);
		}
		public ims.core.vo.PatientProcedureVo getSelectedPatientProcedure()
		{
			return (ims.core.vo.PatientProcedureVo)cx_CoreSelectedPatientProcedure.getValue(context);
		}
		public void setSelectedPatientProcedure(ims.core.vo.PatientProcedureVo value)
		{
			cx_CoreSelectedPatientProcedure.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedPatientProcedure = new ims.framework.ContextVariable("Core.SelectedPatientProcedure", "_cv_Core.SelectedPatientProcedure");
		public boolean getTaxonomyMapIsNotNull()
		{
			return !cx_CoreTaxonomyMap.getValueIsNull(context);
		}
		public ims.core.vo.TaxonomyMap getTaxonomyMap()
		{
			return (ims.core.vo.TaxonomyMap)cx_CoreTaxonomyMap.getValue(context);
		}
		public void setTaxonomyMap(ims.core.vo.TaxonomyMap value)
		{
			cx_CoreTaxonomyMap.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomyMap = new ims.framework.ContextVariable("Core.TaxonomyMap", "_cv_Core.TaxonomyMap");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public CoreContext Core;
}
