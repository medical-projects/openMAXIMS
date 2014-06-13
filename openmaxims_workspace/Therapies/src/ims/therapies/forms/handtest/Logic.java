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
// This code was generated by Peter Martin using IMS Development Environment (version 1.45 build 2263.21661)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.handtest;

import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalContactShortVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.therapies.vo.HandJaymarFindingsVo;
import ims.therapies.vo.HandJaymarFindingsVoCollection;
import ims.therapies.vo.HandJaymarVo;
import ims.therapies.vo.HandJaymarVoCollection;
import ims.therapies.vo.HandTestVo;
import ims.therapies.vo.HandTestVoCollection;
import ims.core.vo.lookups.LateralityLRonly;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void initialize() {
		ClinicalContactShortVo currentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		form.getLocalContext().setClinicalContact(currentClinicalContact);
		if(currentClinicalContact!=null)
			form.getLocalContext().setCurrentClinicalContactId(currentClinicalContact.getID_ClinicalContact());
		
		
	}
	private void open() {
		clearFields();
		form.setMode(FormMode.VIEW);
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getLocalContext().setHandVo(null);
		
		fillRecordBrowser();	
		
		if(form.getLocalContext().getClinicalContactIsNotNull()){
			form.recbrHandTests().setValue(form.getLocalContext().getClinicalContact());
		}
		else{
			form.btnNew().setVisible(false);
			form.btnUpdate().setVisible(false);
		}
		
		if(form.recbrHandTests().size()>0){
			try {
				onRecbrHandTestsValueChanged();
			} catch (PresentationLogicException e) {
				engine.showMessage("Failed to populate Hand Test details.");
			}
		}
	}
	private void fillRecordBrowser() {
		Integer currentContactId = form.getLocalContext().getCurrentClinicalContactId();
		Color textColour = null;
		
		ClinicalContactShortVoCollection collClinicalContactShortVo = domain.listClinicalContactsByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		for(int i=0; i<collClinicalContactShortVo.size(); i++){
			ClinicalContactShortVo voClinicalContactShort =  collClinicalContactShortVo.get(i); 
			if(voClinicalContactShort.getID_ClinicalContact().equals(currentContactId))
				textColour = Color.Green;
			else
				textColour = null;
			form.recbrHandTests().newRow(voClinicalContactShort, "Clinical Contact: " + voClinicalContactShort.getStartDateTime() + " - " + voClinicalContactShort.getSeenBy(), textColour);
		}
		
	}
	private void populateScreenFromData(HandTestVo voHandTest) {
		form.getLocalContext().setHandVo(voHandTest);
		
		if(voHandTest.getAuthoringCPIsNotNull()){
			form.qmbAuthoringHCP().newRow(voHandTest.getAuthoringCP(), voHandTest.getAuthoringCP().getName().toString());
			form.qmbAuthoringHCP().setValue(voHandTest.getAuthoringCP());
		}
		
		if(voHandTest.getAuthoringDateTimeIsNotNull())
			form.dtimAuthoring().setValue(voHandTest.getAuthoringDateTime());
		
		if(voHandTest.getDominantHandIsNotNull())
			form.cmbDominantHand().setValue(voHandTest.getDominantHand());
		if(voHandTest.getLeftPinchStrengthIsNotNull())
			form.intLeftPinch().setValue(voHandTest.getLeftPinchStrength());
		if(voHandTest.getLeftThumbIndexSpanExtensionIsNotNull())
			form.decLeftThumb().setValue(voHandTest.getLeftThumbIndexSpanExtension());
		if(voHandTest.getRightPinchStrengthIsNotNull())
			form.intRightPinch().setValue(voHandTest.getRightPinchStrength());
		if(voHandTest.getRightThumbIndexSpanExtensionIsNotNull())
			form.decRightThumb().setValue(voHandTest.getRightThumbIndexSpanExtension());
		if(voHandTest.getLeftBulbDynamometerIsNotNull())
			form.intLeftBulb().setValue(voHandTest.getLeftBulbDynamometer());
		if(voHandTest.getRightBulbDynamometerIsNotNull())
			form.intRightBulb().setValue(voHandTest.getRightBulbDynamometer());
		
		GenForm.grdGripRow rowGrip;
		if(voHandTest.getGripStrengthIsNotNull())
			for (int i = 0; i< voHandTest.getGripStrength().size(); i++)
			{
				HandJaymarVo voHandJaymar = voHandTest.getGripStrength().get(i);
				
				rowGrip = form.grdGrip().getRows().newRow();
				rowGrip.setcolTree(voHandJaymar.getJaymarLevel());
				if(voHandJaymar.getJaymarFindingIsNotNull()){
					
					for (int j = 0; j< voHandJaymar.getJaymarFinding().size(); j++)
					{
						HandJaymarFindingsVo voHandJaymarFinding = voHandJaymar.getJaymarFinding().get(j);
						if(voHandJaymarFinding.getLaterality().equals(LateralityLRonly.RIGHT)){
							if(voHandJaymarFinding.getTest1IsNotNull())
								rowGrip.setColTest1Right(voHandJaymarFinding.getTest1());
							else
								rowGrip.setColTest1Right(new Float(0));
							
							if(voHandJaymarFinding.getTest2IsNotNull())
								rowGrip.setColTest2Right(voHandJaymarFinding.getTest2());
							else
								rowGrip.setColTest2Right(new Float(0));
							
							if(voHandJaymarFinding.getTest3IsNotNull())
								rowGrip.setColTest3Right(voHandJaymarFinding.getTest3());
							else
								rowGrip.setColTest3Right(new Float(0));
							
							rowGrip.setColAvgRight(voHandJaymarFinding.getLevelAverage());
						}
						else if(voHandJaymarFinding.getLaterality().equals(LateralityLRonly.LEFT)){
							if(voHandJaymarFinding.getTest1IsNotNull())
								rowGrip.setColTest1Left(voHandJaymarFinding.getTest1());
							else
								rowGrip.setColTest1Left(new Float(0));
							
							if(voHandJaymarFinding.getTest2IsNotNull())
								rowGrip.setColTest2Left(voHandJaymarFinding.getTest2());
							else
								rowGrip.setColTest2Left(new Float(0));
							
							if(voHandJaymarFinding.getTest3IsNotNull())
								rowGrip.setColTest3Left(voHandJaymarFinding.getTest3());
							else
								rowGrip.setColTest3Left(new Float(0));
						
							rowGrip.setColAvgLeft(voHandJaymarFinding.getLevelAverage());
						}
					}
				}
			}
	}
	private void clearFields() {
		form.dtimAuthoring().setValue(null);
		form.qmbAuthoringHCP().setValue(null);
		form.cmbDominantHand().setValue(null);
		
		form.intLeftPinch().setValue(null);
		form.decLeftThumb().setValue(null);
		form.intLeftBulb().setValue(null);
		form.intRightBulb().setValue(null);
		form.intRightPinch().setValue(null);
		form.decRightThumb().setValue(null);
		
		form.grdGrip().getRows().clear();	
		
	}
	protected void onQmbAuthoringHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbAuthoringHCP().clear();
		Hcp filter = new Hcp();
		PersonName name = new PersonName();
		name.setSurname("%" + value + "%");
		filter.setQueryName(name);
		//filter.setHcpType(HcpDisType.MEDICAL);
		
		HcpCollection voHCPColl = domain.listHcps(filter);
		
		if(voHCPColl != null)
		{
			for (int i = 0; i < voHCPColl.size(); i++)
			{
				form.qmbAuthoringHCP().newRow(voHCPColl.get(i), voHCPColl.get(i).getName().toString());
			}
			if (voHCPColl.size() == 1)
			{
				form.qmbAuthoringHCP().setValue(voHCPColl.get(0));
			}
			else if (voHCPColl.size() > 1)
			{
				form.qmbAuthoringHCP().showOpened();		
			}
		}
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		HandTestVo voHandTest = form.getLocalContext().getHandVo();
		if (voHandTest == null)
			voHandTest = new HandTestVo();
		
		voHandTest = populateDataFromScreem(voHandTest);
		
		if(voHandTest==null)
			return;
		
		String[] arrErrors = voHandTest.validate();
		if (arrErrors!=null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
	
		//save and update local context
		try 
		{
			form.getLocalContext().setHandVo(domain.saveHandTest(voHandTest));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			open();			
			return;			
		} 
		
		open(); 
	}
	private HandTestVo populateDataFromScreem(HandTestVo voHandTest) {
		if(voHandTest.getClinicalContact()==null)
			voHandTest.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		if(voHandTest.getCareContext()==null)
			voHandTest.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		voHandTest.setAuthoringCP(form.qmbAuthoringHCP().getValue());
		
		
		if(form.dtimAuthoring().getValue()==null || form.dtimAuthoring().getValue().getDate()==null){
			engine.showErrors(new String[]{"Authoring Date/Time is mandatory."});				//wdev-13070
			return null;
		}
		if(form.dtimAuthoring().getValue()==null || form.dtimAuthoring().getValue().getTime()==null){
			engine.showErrors(new String[]{"Authoring Date/Time is mandatory."});				//wdev-13070
			return null;
		}
		
		voHandTest.setAuthoringDateTime(form.dtimAuthoring().getValue());
		
		voHandTest.setDominantHand(form.cmbDominantHand().getValue());
		voHandTest.setLeftPinchStrength(form.intLeftPinch().getValue());
		voHandTest.setLeftThumbIndexSpanExtension(form.decLeftThumb().getValue());
		voHandTest.setRightPinchStrength(form.intRightPinch().getValue());
		voHandTest.setRightThumbIndexSpanExtension(form.decRightThumb().getValue());
		voHandTest.setLeftBulbDynamometer(form.intLeftBulb().getValue());
		voHandTest.setRightBulbDynamometer(form.intRightBulb().getValue());
		
		GenForm.grdGripRow rowGrip;
		HandJaymarVoCollection collHandJaymar = new HandJaymarVoCollection();
		for(int i=0; i<form.grdGrip().getRows().size(); i++){
			
			rowGrip = form.grdGrip().getRows().get(i);
			HandJaymarFindingsVoCollection collHandJaymarFindings = new HandJaymarFindingsVoCollection();
			HandJaymarFindingsVo voHandJaymarRight = new HandJaymarFindingsVo();
			HandJaymarVo voHandJaymar = new HandJaymarVo();
			
			voHandJaymar.setJaymarLevel(rowGrip.getcolTree());
			
			voHandJaymarRight.setLaterality(LateralityLRonly.RIGHT);
			voHandJaymarRight.setTest1(rowGrip.getColTest1Right());
			voHandJaymarRight.setTest2(rowGrip.getColTest2Right());
			voHandJaymarRight.setTest3(rowGrip.getColTest3Right());
			voHandJaymarRight.setLevelAverage(getAverage(rowGrip.getColTest1Right(), rowGrip.getColTest2Right(), rowGrip.getColTest3Right()));
			
			collHandJaymarFindings.add(voHandJaymarRight);
			
			HandJaymarFindingsVo voHandJaymarLeft = new HandJaymarFindingsVo();
			
			voHandJaymarLeft.setLaterality(LateralityLRonly.LEFT);
			voHandJaymarLeft.setTest1(rowGrip.getColTest1Left());
			voHandJaymarLeft.setTest2(rowGrip.getColTest2Left());
			voHandJaymarLeft.setTest3(rowGrip.getColTest3Left());
			voHandJaymarLeft.setLevelAverage(getAverage(rowGrip.getColTest1Left(), rowGrip.getColTest2Left(), rowGrip.getColTest3Left()));
			
			collHandJaymarFindings.add(voHandJaymarLeft);	
			
			voHandJaymar.setJaymarFinding(collHandJaymarFindings);
			
			collHandJaymar.add(voHandJaymar);
		}
			
		voHandTest.setGripStrength(collHandJaymar);
		
		return voHandTest;
	}
	private Float getAverage(Float colTest1, Float colTest2, Float colTest3) {
		
		float fTest1 = 0;
		float fTest2 = 0;
		float fTest3 = 0;
		
		if(colTest1!=null)
			fTest1 = colTest1.floatValue();
		if(colTest2!=null)
			fTest2 = colTest2.floatValue();
		if(colTest3!=null)
			fTest3 = colTest3.floatValue();
				
		return new Float((fTest1+fTest2+fTest3)/3);
	}
	protected void onBUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.qmbAuthoringHCP().setEnabled(false);
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		
		if(form.grdGrip().getRows().size()== 0)
		{
			form.getContextMenus().getGenericGridRemoveItem().setVisible(false);	
		}


	}
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setDefaultValues();
		form.setMode(FormMode.EDIT);
		form.qmbAuthoringHCP().setEnabled(true);
		form.dtimAuthoring().setEnabled(true);
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
	}
	private void setDefaultValues() {
		Hcp hcpUser = (Hcp)domain.getHcpUser();
		if(hcpUser!=null){
			form.qmbAuthoringHCP().newRow(hcpUser, hcpUser.getName().toString());
			form.qmbAuthoringHCP().setValue(hcpUser);
		}
		DateTime dateTime = new DateTime();
		form.dtimAuthoring().setValue(dateTime);
		
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				form.grdGrip().getRows().newRow();	
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				form.grdGrip().removeSelectedRow();
			if(form.grdGrip().getRows().size()== 0 || form.grdGrip().getSelectedRowIndex()< 0)
				form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
				
				
				break;
		}
	}
	protected void onRecbrHandTestsValueChanged() throws PresentationLogicException {
		ClinicalContactShortVo voClinicalContactShort = form.recbrHandTests().getValue();
		
		form.getLocalContext().setClinicalContact(voClinicalContactShort);
		HandTestVoCollection voHandTest = domain.getHandTest(voClinicalContactShort.getID_ClinicalContact());
		
		if(voHandTest!=null && voHandTest.size()>0)
			displayContactAssessment(voHandTest.get(0), voClinicalContactShort);
		else
			displayContactAssessment(null, voClinicalContactShort);
		
	}
	private void displayContactAssessment(HandTestVo voHandTest, ClinicalContactShortVo voClinicalContactShort) {
		Integer currentContactId = form.getLocalContext().getCurrentClinicalContactId();
		
		clearFields();
		
		if(voHandTest!=null){
			populateScreenFromData(voHandTest);
			
			if(voClinicalContactShort.getID_ClinicalContact().equals(currentContactId))
				form.btnUpdate().setVisible(true);
			else
				form.btnUpdate().setVisible(false);
			
			form.btnNew().setVisible(false);
			
		}
		else{
			
			form.getLocalContext().setHandVo(null);
						
			if(voClinicalContactShort.getID_ClinicalContact().equals(currentContactId))
				form.btnNew().setVisible(true);
			else
				form.btnNew().setVisible(false);
			
			form.btnUpdate().setVisible(false);
		}
		
	}

	protected void onGridRowSelected() throws PresentationLogicException
	{
		if(form.getMode() == FormMode.EDIT && form.grdGrip().getRows().size()>0)
		{
			form.getContextMenus().getGenericGridRemoveItem().setVisible(true);
		}
		
	}
}
