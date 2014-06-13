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
// This code was generated by Callum Wells using IMS Development Environment (version 1.20 build 40908.2130)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.clinicalnotedialog;

import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.lookups.ClinicalNoteType;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.nursing.vo.CarePlan;
import ims.nursing.vo.CarePlanTitleCollection;
import ims.nursing.vo.NursingClinicalNotesVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{

	protected void onFormOpen() throws FormOpenException
	{
		form.customAuthoring().initializeComponent();
		form.customAuthoring().setIsRequiredPropertyToControls(true);
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		NursingClinicalNotesVo voClinicalNotes = new NursingClinicalNotesVo();
		ArrayList<String> screenErrors = new ArrayList<String>();

		if (form.txtClinicalNote().getValue() != null)
			voClinicalNotes.setClinicalNote(form.txtClinicalNote().getValue());

		if (form.customAuthoring().getValue() != null)
			voClinicalNotes.setAuthoringInfo(form.customAuthoring().getValue());
		
		if (form.chkHospitalReport() != null)
			voClinicalNotes.setInHospitalReport(new Boolean(form.chkHospitalReport().getValue()));

		// Clinical notes default to nursing type
		voClinicalNotes.setDiscipline(HcpDisType.NURSING);

		if (voClinicalNotes.getClinicalContact() == null)
			voClinicalNotes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (voClinicalNotes.getCareContext() == null)
			voClinicalNotes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		if (form.getGlobalContext().Core.getPatientShort().getWard() != null)
			voClinicalNotes.setWard(form.getGlobalContext().Core.getPatientShort().getWard());

		//voClinicalNotes.setIsActive(Boolean.TRUE);
		if ( ! voClinicalNotes.getNoteTypeIsNotNull())
			   voClinicalNotes.setNoteType(ClinicalNoteType.CLINICALNOTE);	
		voClinicalNotes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		voClinicalNotes.setRecordingDateTime(form.customAuthoring().getValue() != null ?  form.customAuthoring().getValue().getAuthoringDateTime() : null);
		voClinicalNotes.setRecordingUser(form.customAuthoring().getValue() != null ?  (form.customAuthoring().getValue().getAuthoringHcpIsNotNull() ? form.customAuthoring().getValue().getAuthoringHcp().getMos() : null) : null);
		
		//voClinicalNotes.setAuthoringDateTime(new DateTime());
		voClinicalNotes.setIsDerivedNote(Boolean.FALSE);		
		
		// add the currently associated care plan title to the clinical note VO
		if (form.getGlobalContext().COE.getCarePlan() == null)
		{
			engine.showMessage("No valid Care Plan. Cannot save Clinical Note.");
			engine.close(DialogResult.CANCEL);
		}
		else
		{
			CarePlan voCarePlan = form.getGlobalContext().COE.getCarePlan();
			CarePlanTitleCollection voCollCarePlanTitle = voClinicalNotes.getCarePlans();
			if(voCollCarePlanTitle == null)
				voCollCarePlanTitle = new CarePlanTitleCollection();
			
			voCollCarePlanTitle.add(voCarePlan);

			voClinicalNotes.setCarePlans(voCollCarePlanTitle);
		}

		if (voClinicalNotes.getClinicalContact() == null)
			voClinicalNotes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (voClinicalNotes.getCareContext() == null)
			voClinicalNotes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		//WDEV-2382 
		voClinicalNotes.setCurrentStatus(getStatus(voClinicalNotes));
		
		if (voClinicalNotes.getAuthoringInfoIsNotNull() && 
				(voClinicalNotes.getAuthoringInfo().getAuthoringDateTime()==null ||voClinicalNotes.getAuthoringInfo().getAuthoringHcp()==null))
		{
			screenErrors.add("'Authoring Info' is mandatory.");
		}
		
		String[] arrErrors = voClinicalNotes.validate();
		String[] arrScreenAndVoErrors = addScreenErrorsToVOErrors(screenErrors, arrErrors);
		if (arrScreenAndVoErrors.length == 0){
			try
			{
				domain.saveClinicalNotes(voClinicalNotes);
			}
			catch (StaleObjectException e)
			{
				form.getGlobalContext().Core.setYesNoDialogMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.open(form.getForms().Core.OkDialog, "Data Warning");
				return;
			}
		}
		else
		{
			engine.showErrors(arrScreenAndVoErrors);
			return;
		}
		engine.close(DialogResult.OK);
	}
	
	private String[] addScreenErrorsToVOErrors(ArrayList screenErrors, String[] arrErrors)
	{
		String[] arrAllErrors = null;

		if (arrErrors != null)
		{
			arrAllErrors = new String[screenErrors.size() + arrErrors.length];
			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);

			int i = 0;
			for (int p = screenErrors.size(); p < arrAllErrors.length; p++)
			{
				arrAllErrors[p] = arrErrors[i];
				i++;
			}
		}
		else
		{
			arrAllErrors = new String[screenErrors.size()];

			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);
		}

		return arrAllErrors;
	}

	private ClinicalNoteStatusVo getStatus(NursingClinicalNotesVo voClinicalNotes)
	{
		ClinicalNoteStatusVo voStatus = voClinicalNotes.getCurrentStatus();
		if(voStatus == null)
		{
			voStatus = new ClinicalNoteStatusVo();
			voStatus.setStatus(ims.core.vo.lookups.ClinicalNotesStatus.ACTIVE);
			voStatus.setDateTime(new DateTime());
			voStatus.setMOS((ims.core.vo.MemberOfStaffShortVo)domain.getMosUser());
			
			voStatus.setCorrectionConfirmed(Boolean.FALSE); //WDEV-5674
		}
		return voStatus;
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
