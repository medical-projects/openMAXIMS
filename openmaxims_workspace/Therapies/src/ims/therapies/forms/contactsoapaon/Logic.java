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
// This code was generated by Peter Martin using IMS Development Environment (version 1.45 build 2265.41281)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.contactsoapaon;

import java.util.ArrayList;

import ims.clinical.vo.SoapNoteVo;
import ims.clinical.vo.SoapNoteVoCollection;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.SOAPVo;
import ims.core.vo.lookups.AreaOfNeedCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		form.lblBrowserStatus().setVisible(false);  //added as part of resolution for wdev-694
		prepopulateControls();
		open();
	}

	private void prepopulateControls()
	{
		GenForm.gridNeedsRow row;
		AreaOfNeedCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAreaOfNeed(domain.getLookupService());
		for (int i = 0; i < lookupCollection.size(); i++)
		{
			row = form.gridNeeds().getRows().newRow();
			row.setColAreaofNeed(lookupCollection.get(i).getText());
			row.setValue(lookupCollection.get(i));
		}
	}

	private void open()
	{
		form.setMode(FormMode.VIEW);
		clearScreen();
		fillRecordBrowser(domain.listSoapNotesVo(form.getGlobalContext().Core.getCurrentCareContext()));
	}

	private void fillRecordBrowser(SoapNoteVoCollection collection)
	{
		form.recbrSOAP().clear();
		boolean selectedClinicalContactFound = false;
		CareContextShortVo voSelectedCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		form.recbrSOAP().newRow(voSelectedCareContext, voSelectedCareContext.getRecordBrowserText());
		
		if(collection != null)
		{
			for(int i = 0 ; i < collection.size() ; i++)
			{
				ClinicalContactShortVo voClinicalContactShort = collection.get(i).getClinicalContact();
				if(voSelectedClinicalContact != null && voClinicalContactShort.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
				{
					selectedClinicalContactFound = true;
					form.recbrSOAP().newRow(voClinicalContactShort, "\t\t\t\tClinical Contact: " + voClinicalContactShort.getStartDateTime().toString() + " - " + voClinicalContactShort.getSeenBy().toString(), Color.Green);
					form.recbrSOAP().setValue(voClinicalContactShort);
				}
				else
				{
					form.recbrSOAP().newRow(voClinicalContactShort, "\t\t\t\tClinical Contact: " + voClinicalContactShort.getStartDateTime().toString() + " - " + voClinicalContactShort.getSeenBy().toString());
				}
			}
		}
		
		if(!selectedClinicalContactFound && voSelectedClinicalContact != null)
		{
			form.recbrSOAP().newRow(voSelectedClinicalContact, "\t\t\t\tClinical Contact: " + voSelectedClinicalContact.getStartDateTime().toString() + " - " + voSelectedClinicalContact.getSeenBy(), Color.Green);
			form.recbrSOAP().setValue(voSelectedClinicalContact);
		}
		browseRecord();
	}

	protected void populateScreenFromData(SoapNoteVo voSoapNote)
	{
		super.populateScreenFromData(voSoapNote);
		populateAuthoringControlsFromData(voSoapNote);
		populateAreaOfNeedGridFromData(voSoapNote);
	}

	private void populateAreaOfNeedGridFromData(SoapNoteVo voSoapNote)
	{
		if(voSoapNote == null)
			return;
		
		AreaOfNeedCollection lkpCollection = voSoapNote.getAreaofNeed();
		for (int i = 0; lkpCollection != null && i < lkpCollection.size(); i++)
		{
			GenForm.gridNeedsRow row = form.gridNeeds().getRowByValue(lkpCollection.get(i));
			if(row != null)
			{
				row.setColSelect(true);
				//TODO - clarify with analysts
				//row.setColNotes(????)
			}
		}
		
		voSoapNote.setAreaofNeed(lkpCollection);
	}

	private void populateAuthoringControlsFromData(SoapNoteVo voSoapNote)
	{
		if(voSoapNote == null)
			return;
		
		if (voSoapNote.getAuthoringInformationIsNotNull())
			form.customControlAuthoringInfo().setValue(voSoapNote.getAuthoringInformation());
	}

	protected void clearScreen()
	{
		form.customControlAuthoringInfo().setValue(null);

		GenForm.gridNeedsRow rowNeeds;
		for (int j = 0; j < form.gridNeeds().getRows().size(); j++)
		{
			rowNeeds = form.gridNeeds().getRows().get(j);
			rowNeeds.setColSelect(false);
			rowNeeds.setColNotes("");
		}
		super.clearScreen();
	}

	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setDefaultValues();
		resetNeedsGrid();
		form.setMode(FormMode.EDIT);
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(true);
	}

	private void setDefaultValues()
	{
		ClinicalContactShortVo contact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(contact == null)
			return;

		form.customControlAuthoringInfo().initializeComponent();
		
		form.textSubjective().setFocus();
	}

	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	private boolean save()
	{
		SoapNoteVo voSoapNote = form.getLocalContext().getSoapNoteVo();
		voSoapNote = populateDataFromScreem(voSoapNote);
			
		if(form.customControlAuthoringInfo() == null || form.customControlAuthoringInfo().getValue() == null || form.customControlAuthoringInfo().getValue().getAuthoringHcp()==null || form.customControlAuthoringInfo().getValue().getAuthoringDateTime()==null)
		{
			String[] authErrors = new String[]{"Authoring Hcp is mandatory."};
			engine.showErrors("Validation Errors",authErrors);
			return false;
		}
					
		String[] arrErrors = voSoapNote.validate();
		
		if(arrErrors != null && arrErrors.length != 0)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return false;
		}

		try
		{
			form.getLocalContext().setSoapNoteVo(domain.saveSoapNoteVo(voSoapNote));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		
		return true;
	}
	
	private String[] addScreenErrorsToVOErrors(ArrayList screenErrors, String[] arrErrors)
	{
		String[] arrAllErrors = null;
		
		if(arrErrors != null)
		{
			arrAllErrors = new String[screenErrors.size() + arrErrors.length];
			for(int i=0;i<screenErrors.size();i++)
				arrAllErrors[i] = (String)screenErrors.get(i);
			
			int i=0;	
			for(int p=screenErrors.size();p<arrAllErrors.length;p++)
			{
				arrAllErrors[p] = arrErrors[i];
				i++;
			}
		}	
		else
		{
			arrAllErrors = new String[screenErrors.size()];		
			
			for(int i=0;i<screenErrors.size();i++)
				arrAllErrors[i] = (String)screenErrors.get(i);	
		}	
		
		return arrAllErrors;
	}

	protected SoapNoteVo populateDataFromScreem(SoapNoteVo voSoapNote)
	{
		if (voSoapNote == null)
			voSoapNote = new SoapNoteVo();

		if (voSoapNote.getClinicalContact() == null)
			voSoapNote.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		if (voSoapNote.getCareContext() == null)
			voSoapNote.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		voSoapNote.setClinicalNote(getClinicalNoteRecord(voSoapNote));
		voSoapNote.setAuthoringInformation(form.customControlAuthoringInfo().getValue());
		populateAreaOfNeedDataFromScreen(voSoapNote);

		return super.populateDataFromScreen(voSoapNote);
	}

	private void populateAreaOfNeedDataFromScreen(SoapNoteVo voSoapNote)
	{
		AreaOfNeedCollection collAreaOfNeed = new AreaOfNeedCollection();
		for (int i = 0; i < form.gridNeeds().getRows().size(); i++)
		{
			if (form.gridNeeds().getRows().get(i).getColSelect())
				collAreaOfNeed.add(form.gridNeeds().getRows().get(i).getValue());
		}
		voSoapNote.setAreaofNeed(collAreaOfNeed);
	}

	private ClinicalNotesVo getClinicalNoteRecord(SoapNoteVo voSoapNote)
	{
		ClinicalNotesVo voClinicalNotes = voSoapNote.getClinicalNote();
		if (voClinicalNotes == null)
			voClinicalNotes = new ClinicalNotesVo();

		if (voClinicalNotes.getID_ClinicalNotes() == null)
		{
			HcpLiteVo hcp = null;
			if (domain.getHcpLiteUser() != null){
				hcp = (HcpLiteVo) domain.getHcpLiteUser();
				voClinicalNotes.setRecordingUser(hcp.getMos());
			}
			voClinicalNotes.setRecordingDateTime(new DateTime());
			voClinicalNotes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			voClinicalNotes.setIsDerivedNote(Boolean.TRUE);
			//WDEV-2382 
			voClinicalNotes.setCurrentStatus(getStatus());
			voClinicalNotes.setDiscipline(HcpDisType.THERAPY);
		}
		voClinicalNotes.setAuthoringInfo(form.customControlAuthoringInfo().getValue());

		SOAPVo voSOAP = new SOAPVo();
		
		voSOAP.setSubjectiveNote(form.textSubjective().getValue() != null ? form.textSubjective().getValue() : "");
		voSOAP.setObjectiveNote(form.textObjective().getValue() != null ? form.textObjective().getValue() : "");
		voSOAP.setAnalysisNote(form.textAnalysis().getValue() != null ? form.textAnalysis().getValue() : "");
		voSOAP.setPlanNote(form.textPlan().getValue() != null ? form.textPlan().getValue() : "");
		voClinicalNotes.setClinicalNote(voSOAP.getRichTextString());

//		voClinicalNotes.setClinicalNote(form.textAnalysis().getValue() 
//				+ " " + form.textObjective().getValue() 
//				+ " " + form.textSubjective().getValue() 
//				+ " " + form.textPlan().getValue());
		return voClinicalNotes;
	}

	private ims.core.vo.ClinicalNoteStatusVo getStatus()
	{
		ims.core.vo.ClinicalNoteStatusVo voStat = new ims.core.vo.ClinicalNoteStatusVo();
		voStat.setStatus(ims.core.vo.lookups.ClinicalNotesStatus.ACTIVE);
		voStat.setDateTime(new DateTime());
		voStat.setMOS((ims.core.vo.MemberOfStaffShortVo)domain.getMosUser());
		return voStat;
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}

	protected void onFormModeChanged()
	{
		setControlsState();
	}
	
	private void setControlsState()
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			form.setcustomControlAuthoringInfoEnabled(!isAuthDateTimeDataSaved());
		}
	}
	private boolean isAuthDateTimeDataSaved()
	{
		SoapNoteVo voSoapNote = form.getLocalContext().getSoapNoteVo();
		return voSoapNote != null && voSoapNote.getAuthoringInformationIsNotNull() && voSoapNote.getAuthoringInformation().getAuthoringDateTimeIsNotNull();
	}
	
	protected void onRecbrSOAPValueChanged() throws PresentationLogicException 
	{
		browseRecord();
	}
	private void clearControls()
	{
		form.customControlAuthoringInfo().setValue(null);
		form.textAnalysis().setValue(null);
		form.textObjective().setValue(null);
		form.textPlan().setValue(null);
		form.textSubjective().setValue(null);	
//		form.gridNeeds().getRows().clear();		//WDEV-2095
	}
	private void browseRecord()
	{
		//Commented out the following line as part
		//of the resolution for issue number wdev-694
		//updateBrowseInformation();
		clearControls();
		resetNeedsGrid();
		
		if(form.recbrSOAP().getValue() instanceof ClinicalContactShortVo)
		{
			ClinicalContactShortVo voClinicalContact = (ClinicalContactShortVo) form.recbrSOAP().getValue();
			form.getLocalContext().setSoapNoteVo(domain.getSoapNoteVo(voClinicalContact));
			if(form.getLocalContext().getSoapNoteVoIsNotNull())
				populateScreenFromData(form.getLocalContext().getSoapNoteVo());
		}
		isRecordEditable();
	}
	private void resetNeedsGrid() 
	{
		form.gridNeeds().getRows().clear();
		prepopulateControls();
	}

	private void isRecordEditable()
	{
		boolean isEditable = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			if(form.recbrSOAP().getValue() instanceof ClinicalContactShortVo)
			{
				ClinicalContactShortVo voContact = (ClinicalContactShortVo) form.recbrSOAP().getValue();
				if(voContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
					isEditable = true;
			}
		}
		
		form.bNew().setVisible(isEditable);
		form.btnUpdate().setVisible(isEditable);
		
		if(isEditable)
		{
			if(form.getLocalContext().getSoapNoteVoIsNotNull())
			{
				form.bNew().setEnabled(false);
				form.bNew().setVisible(false);
				form.btnUpdate().setEnabled(true);
				form.btnUpdate().setVisible(true);
			}
			else
			{
				form.bNew().setEnabled(true);
				form.bNew().setVisible(true);
				form.btnUpdate().setEnabled(false);
				form.btnUpdate().setVisible(false);
			}
		}
	}

	@Override
	protected void onRIEDialogClosed(DialogResult result) throws PresentationLogicException
	{
		if(DialogResult.OK.equals(result) || DialogResult.YES.equals(result))
		{
			if(!form.getLocalContext().getSoapNoteVoIsNotNull())
				return;
			
			ClinicalNotesVo clinicalNotes = form.getLocalContext().getSoapNoteVo().getClinicalNote();
			
			if(clinicalNotes == null)
				return;
			
			clinicalNotes.setIsRIE(true);
			
			clinicalNotes.validate();
			
			Integer patientId=null, contactId=null, careContextId=null;
			
			if (form.getGlobalContext().Core.getPatientShortIsNotNull())
				patientId = form.getGlobalContext().Core.getPatientShort().getID_Patient();
			if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
				contactId = form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact();
			if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
				careContextId = form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext();
			
			try 
			{
				domain.markAsRie(clinicalNotes, engine.getFormName(), patientId, contactId, careContextId, "");
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				onFormOpen();
				return;
			}
		}
	}
}
