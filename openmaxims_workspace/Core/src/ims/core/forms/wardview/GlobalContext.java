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

package ims.core.forms.wardview;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getBedInfoActionIsNotNull()
		{
			return !cx_CoreBedInfoAction.getValueIsNull(context);
		}
		public ims.core.vo.enums.BedInfoAction getBedInfoAction()
		{
			return (ims.core.vo.enums.BedInfoAction)cx_CoreBedInfoAction.getValue(context);
		}
		public void setBedInfoAction(ims.core.vo.enums.BedInfoAction value)
		{
			cx_CoreBedInfoAction.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreBedInfoAction = new ims.framework.ContextVariable("Core.BedInfoAction", "_cv_Core.BedInfoAction");
		public boolean getSelectedBedSpaceStateIsNotNull()
		{
			return !cx_CoreSelectedBedSpaceState.getValueIsNull(context);
		}
		public ims.core.vo.BedSpaceStateLiteVo getSelectedBedSpaceState()
		{
			return (ims.core.vo.BedSpaceStateLiteVo)cx_CoreSelectedBedSpaceState.getValue(context);
		}
		public void setSelectedBedSpaceState(ims.core.vo.BedSpaceStateLiteVo value)
		{
			cx_CoreSelectedBedSpaceState.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedBedSpaceState = new ims.framework.ContextVariable("Core.SelectedBedSpaceState", "_cv_Core.SelectedBedSpaceState");
		public boolean getADTWardIsNotNull()
		{
			return !cx_CoreADTWard.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getADTWard()
		{
			return (ims.core.vo.LocationLiteVo)cx_CoreADTWard.getValue(context);
		}
		public void setADTWard(ims.core.vo.LocationLiteVo value)
		{
			cx_CoreADTWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTWard = new ims.framework.ContextVariable("Core.ADTWard", "_cv_Core.ADTWard");
		public boolean getHasWaitingAreaIsNotNull()
		{
			return !cx_CoreHasWaitingArea.getValueIsNull(context);
		}
		public Boolean getHasWaitingArea()
		{
			return (Boolean)cx_CoreHasWaitingArea.getValue(context);
		}
		public void setHasWaitingArea(Boolean value)
		{
			cx_CoreHasWaitingArea.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHasWaitingArea = new ims.framework.ContextVariable("Core.HasWaitingArea", "_cv_Core.HasWaitingArea");
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
		public boolean getSelectedWaitingAreaPatientIsNotNull()
		{
			return !cx_CoreSelectedWaitingAreaPatient.getValueIsNull(context);
		}
		public ims.core.vo.InpatientEpisodeLiteVo getSelectedWaitingAreaPatient()
		{
			return (ims.core.vo.InpatientEpisodeLiteVo)cx_CoreSelectedWaitingAreaPatient.getValue(context);
		}
		public void setSelectedWaitingAreaPatient(ims.core.vo.InpatientEpisodeLiteVo value)
		{
			cx_CoreSelectedWaitingAreaPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedWaitingAreaPatient = new ims.framework.ContextVariable("Core.SelectedWaitingAreaPatient", "_cv_Core.SelectedWaitingAreaPatient");
		public boolean getWardViewSearchCriteriaIsNotNull()
		{
			return !cx_CoreWardViewSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.WardViewSearchCriteriaVo getWardViewSearchCriteria()
		{
			return (ims.core.vo.WardViewSearchCriteriaVo)cx_CoreWardViewSearchCriteria.getValue(context);
		}
		public void setWardViewSearchCriteria(ims.core.vo.WardViewSearchCriteriaVo value)
		{
			cx_CoreWardViewSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreWardViewSearchCriteria = new ims.framework.ContextVariable("Core.WardViewSearchCriteria", "_cvp_Core.WardViewSearchCriteria");
		public boolean getPendingElectiveAdmissionIsNotNull()
		{
			return !cx_CorePendingElectiveAdmission.getValueIsNull(context);
		}
		public ims.core.vo.PendingElectiveAdmissionAdmitVo getPendingElectiveAdmission()
		{
			return (ims.core.vo.PendingElectiveAdmissionAdmitVo)cx_CorePendingElectiveAdmission.getValue(context);
		}
		public void setPendingElectiveAdmission(ims.core.vo.PendingElectiveAdmissionAdmitVo value)
		{
			cx_CorePendingElectiveAdmission.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePendingElectiveAdmission = new ims.framework.ContextVariable("Core.PendingElectiveAdmission", "_cv_Core.PendingElectiveAdmission");
		public boolean getSelectingPatientFormIsNotNull()
		{
			return !cx_CoreSelectingPatientForm.getValueIsNull(context);
		}
		public ims.framework.FormName getSelectingPatientForm()
		{
			return (ims.framework.FormName)cx_CoreSelectingPatientForm.getValue(context);
		}
		public void setSelectingPatientForm(ims.framework.FormName value)
		{
			cx_CoreSelectingPatientForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectingPatientForm = new ims.framework.ContextVariable("Core.SelectingPatientForm", "_cvp_Core.SelectingPatientForm");
		public boolean getBedInfoDialogIsNotNull()
		{
			return !cx_CoreBedInfoDialog.getValueIsNull(context);
		}
		public ims.core.vo.BedSpaceInfoDialogVo getBedInfoDialog()
		{
			return (ims.core.vo.BedSpaceInfoDialogVo)cx_CoreBedInfoDialog.getValue(context);
		}
		public void setBedInfoDialog(ims.core.vo.BedSpaceInfoDialogVo value)
		{
			cx_CoreBedInfoDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreBedInfoDialog = new ims.framework.ContextVariable("Core.BedInfoDialog", "_cv_Core.BedInfoDialog");
		public boolean getADTTransfersInIsNotNull()
		{
			return !cx_CoreADTTransfersIn.getValueIsNull(context);
		}
		public ims.core.vo.PendingTransfersLiteVoCollection getADTTransfersIn()
		{
			return (ims.core.vo.PendingTransfersLiteVoCollection)cx_CoreADTTransfersIn.getValue(context);
		}
		public void setADTTransfersIn(ims.core.vo.PendingTransfersLiteVoCollection value)
		{
			cx_CoreADTTransfersIn.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTTransfersIn = new ims.framework.ContextVariable("Core.ADTTransfersIn", "_cv_Core.ADTTransfersIn");
		public boolean getADTTransfersOutIsNotNull()
		{
			return !cx_CoreADTTransfersOut.getValueIsNull(context);
		}
		public ims.core.vo.PendingTransfersLiteVoCollection getADTTransfersOut()
		{
			return (ims.core.vo.PendingTransfersLiteVoCollection)cx_CoreADTTransfersOut.getValue(context);
		}
		public void setADTTransfersOut(ims.core.vo.PendingTransfersLiteVoCollection value)
		{
			cx_CoreADTTransfersOut.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreADTTransfersOut = new ims.framework.ContextVariable("Core.ADTTransfersOut", "_cv_Core.ADTTransfersOut");
		public boolean getCurrentInPatientListWardIsNotNull()
		{
			return !cx_CoreCurrentInPatientListWard.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getCurrentInPatientListWard()
		{
			return (ims.core.vo.LocationLiteVo)cx_CoreCurrentInPatientListWard.getValue(context);
		}
		public void setCurrentInPatientListWard(ims.core.vo.LocationLiteVo value)
		{
			cx_CoreCurrentInPatientListWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentInPatientListWard = new ims.framework.ContextVariable("Core.CurrentInPatientListWard", "_cv_Core.CurrentInPatientListWard");
		public boolean getPatientElectiveListForWardViewVoIsNotNull()
		{
			return !cx_CorePatientElectiveListForWardViewVo.getValueIsNull(context);
		}
		public ims.core.vo.PatientElectiveListForWardViewVo getPatientElectiveListForWardViewVo()
		{
			return (ims.core.vo.PatientElectiveListForWardViewVo)cx_CorePatientElectiveListForWardViewVo.getValue(context);
		}
		public void setPatientElectiveListForWardViewVo(ims.core.vo.PatientElectiveListForWardViewVo value)
		{
			cx_CorePatientElectiveListForWardViewVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientElectiveListForWardViewVo = new ims.framework.ContextVariable("Core.PatientElectiveListForWardViewVo", "_cv_Core.PatientElectiveListForWardViewVo");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
