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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41027.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
// 11/05/2006 WDEV-703 fix

package ims.core.forms.supportnetworkfamily;

import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffMinVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.RecordingUserInformationVo;
import ims.core.vo.SupportNetworkFamily;
import ims.core.vo.SupportNetworkFamilyCollection;
import ims.core.vo.lookups.SupportNetworkEmergencyContact;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final String	MAIN_CARER	= "Main Carer";

	protected void onFormOpen() throws PresentationLogicException
	{
		
		initialize();
		open();	
	}
	
	@Override
	public void initialize() throws FormOpenException {
		super.initialize();
		boolean isCCOspecific = ConfigFlag.GEN.SUPPORT_NETWORK_FAMILY_TYPE.getValue().equals("CCO");
		form.ctnFamilySupport().lblEmail().setVisible(!isCCOspecific);
		form.ctnFamilySupport().txtEmailAddress().setVisible(!isCCOspecific);
		form.ctnFamilySupport().chkFit().setVisible(isCCOspecific);
		form.ctnFamilySupport().chkAware().setVisible(isCCOspecific);
		form.ctnFamilySupport().chkPermission().setVisible(isCCOspecific);
		form.groupFilter().setValue(GenForm.groupFilterEnumeration.rdoActive);
		form.ctnFamilySupport().customControlAuth().setIsRequiredPropertyToControls(Boolean.TRUE);
		
	}

	public void open() throws PresentationLogicException
	{
		clearInstanceControls();
		listSupportNetworkFamily();
		form.setMode(FormMode.VIEW);
		form.ctnFamilySupport().setCollapsed(true);
	}

	private void listSupportNetworkFamily() 
	{
		form.grdFamily().getRows().clear();
		setInactiveBtnVisible(false);
		form.btnReactivate().setEnabled(false);
		form.btnReactivate().setVisible(false);
		
		Boolean bActiveOnly = Boolean.FALSE;
		if(form.groupFilter().getValue().equals(GenForm.groupFilterEnumeration.rdoActive))
		{
			bActiveOnly = Boolean.TRUE;
		}
		
		SupportNetworkFamilyCollection voCollFamily = domain.listSupportNetworkFamily(bActiveOnly, form.getGlobalContext().Core.getPatientShort(), engine.isRIEMode());
		SupportNetworkFamily voFamily = null;	
		
		GenForm.grdFamilyRow row = null;
		if(voCollFamily == null)
			return;

		for(int i=0;i<voCollFamily.size();i++)
		{
			voFamily = voCollFamily.get(i);
			row = form.grdFamily().getRows().newRow();
			row.setColName(voFamily.getCarerName());
			row.setColPhone(voFamily.getCarerHomePhone());
			row.setColMobile(voFamily.getCarerMobilePhone());  //change request 
			if(voFamily.getCarerRelationship() != null)
				row.setColRelationship(voFamily.getCarerRelationship().getText());
			
			String strStatus = "";
			if(voFamily.getIsMainCarerIsNotNull() && voFamily.getIsMainCarer().booleanValue())
			{
				
				if(voFamily.getEmergencyContactOrder() != null)
				{
					strStatus = voFamily.getEmergencyContactOrder().getText();
					strStatus += " - " + MAIN_CARER;
				}
				else
				{
					//WDEV-703
					strStatus += MAIN_CARER;
				}
			}
			else
			{
				if(voFamily.getEmergencyContactOrder() != null)
				{
					strStatus += voFamily.getEmergencyContactOrder().getText();
				}
			}
			row.setColStatus(strStatus);
			 
			if(voFamily.getIsCurrentlyActiveFamilySupportIsNotNull() && voFamily.getIsCurrentlyActiveFamilySupport().booleanValue())
				row.setcolActive(form.getImages().Core.AnswerBox_Yes);
			else{
				row.setBackColor(Color.LightGray);
				row.setcolActive(form.getImages().Core.AnswerBox_No);
				
				row.setTooltipForcolActive(createInactivateTooltip(voFamily));	//WDEV-12384
			}
				
			row.setValue(voFamily);
		}
		
		//set selection back
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			//need to get timestamp from record retrieved from List call.
			GenForm.grdFamilyRow row1 = form.grdFamily().getRowByValue(form.getLocalContext().getSelectedRecord());
			if (row1 != null && row1.getValue() != null)
			{			
				form.getLocalContext().setSelectedRecord(row1.getValue());
				form.grdFamily().setValue(form.getLocalContext().getSelectedRecord());
				populateInstanceControl(form.grdFamily().getValue());
			}
			else
			{
				clearInstanceControls();
				form.getLocalContext().setSelectedRecord(null);
			}
			updateControlsState();			
		}
		else
		{
			form.ctnFamilySupport().setCollapsed(true);
			clearInstanceControls();
		}
		
	}

	//WDEV-12384
	private String createInactivateTooltip(SupportNetworkFamily voFamily)
	{
		if(voFamily == null)
			return null;
		
		StringBuffer sb = new StringBuffer();
		
		if(voFamily.getInactivatingUserIsNotNull())
		{
    		sb.append("<b>Inactivating User : </b>");
    		sb.append(voFamily.getInactivatingUser().getIMosName());
    		sb.append("<br>");
		}
		
		if(voFamily.getInactivatingDateTimeIsNotNull())
		{
    		sb.append("<b>Inactivating Date : </b>");
    		sb.append(voFamily.getInactivatingDateTime().toString());
    		sb.append("<br>");
		}

		return sb.toString();
	}

	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.YesNoDialog))
		{
			if (result.equals(DialogResult.YES))
			{
				setRecordActive();
				if (save())
					open();
			}
			else //WDEV-17868
				open();
		}					
	}
	

	public boolean save() throws PresentationLogicException 
	{
		SupportNetworkFamily voSupportFamily = populateInstanceData();
		
		if(isEmergencyContactUsed())
		{
			engine.showMessage("This Emergency contact is already in use.");
			return false;
		}
		
		if (isMainCarerSavedPreviously(voSupportFamily))
		{
			engine.showMessage("A " + MAIN_CARER + " has already been saved");
			return false;
		}
			
		String[] arrErrors = voSupportFamily.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		try 
		{
			// The old return from domain wasn't being used, modified it to take
			// patient and the Global Context will be updated accordingly
			domain.saveSupportNetworkFamily(voSupportFamily);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		return true;
	}

	//WDEV-703
	private boolean isMainCarerSavedPreviously(SupportNetworkFamily voSupportNetworkFamily) 
	{
		boolean bMainCarerSavedPrev = false;
		
		if (form.ctnFamilySupport().chkCarer().getValue())
		{
			GenForm.grdFamilyRow row = null;
			for(int i=0;i<form.grdFamily().getRows().size();i++)
			{
				row = form.grdFamily().getRows().get(i);
				SupportNetworkFamily voFamily = row.getValue();
				if(voFamily.getIsCurrentlyActiveFamilySupportIsNotNull() && voFamily.getIsCurrentlyActiveFamilySupport().booleanValue())
				{
					//Don't check the current vo
					if(voSupportNetworkFamily != null && voSupportNetworkFamily.equals(voFamily) == false)
					{
						if(voFamily.getIsMainCarerIsNotNull() && voFamily.getIsMainCarer().equals(Boolean.TRUE))		
						{
							bMainCarerSavedPrev = true;
							break;
						}
					}
				}
			}
		}
		return bMainCarerSavedPrev;
	}

	private boolean isEmergencyContactUsed() 
	{
		boolean bContactUsed = false;
		
		SupportNetworkEmergencyContact contact = form.ctnFamilySupport().cmbEmergency().getValue();
		SupportNetworkFamily voFamily = form.grdFamily().getValue();
		
		if(contact == null)
			return false;

		GenForm.grdFamilyRow row = null;
		for(int i=0;i<form.grdFamily().getRows().size();i++)
		{
			row = form.grdFamily().getRows().get(i);
			if(row.getValue().getIsCurrentlyActiveFamilySupport().booleanValue())
			{
				if(contact.equals(row.getValue().getEmergencyContactOrder()) && voFamily != row.getValue())	
				{
					bContactUsed = true;
				}
			}
		}
		return bContactUsed;
	}

	protected void onRadioButtongroupFilterValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdFamily().setValue(null);
		listSupportNetworkFamily();
		form.setMode(FormMode.VIEW);
	}
	
	protected void onGridFamilySelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		onGridSelectionChanged();
	}

	private void onGridSelectionChanged()
	{
		if (form.grdFamily().getValue() != null)
		{
			populateInstanceControl(domain.getSupportNetworkFamily(form.grdFamily().getValue()));
			updateControlsState();
		}
	}
	
	public void populateInstanceControl(ims.core.vo.SupportNetworkFamily voSupNet)
	{
		if (voSupNet != null)
		{
			form.getLocalContext().setSelectedRecord(voSupNet);
			populateScreenFromData(voSupNet);
			form.btnUpdate().setEnabled(true);
			form.btnUpdate().setVisible(true);
			
			if(voSupNet.getIsCurrentlyActiveFamilySupportIsNotNull() && voSupNet.getIsCurrentlyActiveFamilySupport().booleanValue())
			{
				setInactiveBtnVisible(true);
				form.btnReactivate().setVisible(false);
				form.btnReactivate().setEnabled(false);
			}	
			else if(voSupNet.getIsCurrentlyActiveFamilySupportIsNotNull() && !voSupNet.getIsCurrentlyActiveFamilySupport().booleanValue())
			{
				form.btnReactivate().setVisible(true);
				form.btnReactivate().setEnabled(true);
				setInactiveBtnVisible(false);
				form.btnUpdate().setVisible(false);
			}
			else if(voSupNet.getIsCurrentlyActiveFamilySupport() == null)
			{
				form.btnReactivate().setVisible(true);
				form.btnReactivate().setEnabled(true);
				setInactiveBtnVisible(false);
				form.btnUpdate().setVisible(false);
			}			
		}
	}
	
	protected void onBNewFamilyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();		
	}
	
	protected void onBtnUpdateFamilyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	protected void onBtnInactiveRecordFamClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setHideCancelButton(Boolean.TRUE);
		form.getGlobalContext().Core.setYesNoDialogMessage("Are you sure you wish to inactivate this record");
		engine.open(form.getForms().Core.YesNoDialog);
	}
	
	protected void onBtnSaveFamilyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
		{
			open();
		}
	}
	
	 
	private void setRecordActive() 
	{
		SupportNetworkFamily voFamily = form.getLocalContext().getSelectedRecord();
		
		voFamily.setInactivatingUser(null);	//WDEV-12384
		voFamily.setInactivatingDateTime(null);	//WDEV-12384
		
		if(voFamily.getIsCurrentlyActiveFamilySupportIsNotNull() && voFamily.getIsCurrentlyActiveFamilySupport().equals(Boolean.TRUE)) //if its true,goes to false (inactivate)
		{
			voFamily.setIsCurrentlyActiveFamilySupport(Boolean.FALSE);	//if its false already,goes to true (reactivate)
			
			Object mos = domain.getMosUser();
			if(mos instanceof MemberOfStaffShortVo)
			{
				voFamily.setInactivatingUser((MemberOfStaffLiteVo) mos);	//WDEV-12384
			}
			
			voFamily.setInactivatingDateTime(new DateTime());	//WDEV-12384
		}
		else if(voFamily.getIsCurrentlyActiveFamilySupportIsNotNull() && voFamily.getIsCurrentlyActiveFamilySupport().equals(Boolean.FALSE)) //if its true,goes to false (inactivate)
			voFamily.setIsCurrentlyActiveFamilySupport(Boolean.TRUE);
		else if(voFamily.getIsCurrentlyActiveFamilySupport() == null)
			voFamily.setIsCurrentlyActiveFamilySupport(Boolean.TRUE);
		
		form.getLocalContext().setSelectedRecord(voFamily);	
	}

	protected void onBtnCancelFamilyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		form.setMode(FormMode.VIEW);
		onGridFamilySelectionChanged();
		open();
	}
	
	protected SupportNetworkFamily populateInstanceData() 
	{
		SupportNetworkFamily vo = super.populateDataFromScreen(form.getLocalContext().getSelectedRecord());
		
		vo.setPatient(form.getGlobalContext().Core.getPatientShort());
		//default currently active to true
		if(vo.getIsCurrentlyActiveFamilySupport() == null)
			vo.setIsCurrentlyActiveFamilySupport(Boolean.TRUE);
		
		//set authoring information only for new records.
		if (vo.getID_SupportNetworkFamily() == null)
			vo.setAuthoringInfo(form.ctnFamilySupport().customControlAuth().getValue());
		
		//WDEV-12901 set Recording Information
		if(vo.getRecordingInformation()==null){
			RecordingUserInformationVo voRecordingUserInformation = new RecordingUserInformationVo();
			voRecordingUserInformation.setRecordingUser(form.ctnFamilySupport().cmbRecordingHCP().getValue());
			voRecordingUserInformation.setRecordingDateTime(new DateTime());
			vo.setRecordingInformation(voRecordingUserInformation);
		}
		
		return vo;
	}

	protected void populateScreenFromData(SupportNetworkFamily value) 
	{
		clearInstanceControls();
		super.populateScreenFromData(value);
		form.ctnFamilySupport().customControlAuth().setValue(value.getAuthoringInfo());			
		form.ctnFamilySupport().setCollapsed(false);
		if(value.getRecordingInformationIsNotNull()){
			MemberOfStaffLiteVo mos = value.getRecordingInformation().getRecordingUser();
			if(mos!=null){
				form.ctnFamilySupport().cmbRecordingHCP().newRow(mos, mos.toString());
				form.ctnFamilySupport().cmbRecordingHCP().setValue(mos);	
			}
			form.ctnFamilySupport().dtimRecordingDateTime().setValue(value.getRecordingInformation().getRecordingDateTime());
		}
	}

	/* 
	 * Reactive an inactive record (change request)
	 */
	protected void onBtnReactivateClick() throws PresentationLogicException 
	{
		form.getGlobalContext().Core.setYesNoDialogMessage("Are you sure you wish to reactivate this record");
		engine.open(form.getForms().Core.YesNoDialog);	
	}
	
	public void clearInstanceControls()
	{
		super.clearScreen();
		form.ctnFamilySupport().customControlAuth().setValue(null);		
		form.ctnFamilySupport().cmbRecordingHCP().setValue(null);
		form.ctnFamilySupport().dtimRecordingDateTime().setValue(null);
	}

	public void newInstance() throws PresentationLogicException
	{
		clearInstanceControls();
		form.grdFamily().setValue(null); //WDEV-16078
		form.ctnFamilySupport().txtName().setFocus();
		//form.btnReactivate().setEnabled(false);
		SupportNetworkFamily voFamily = new SupportNetworkFamily();
		
		form.ctnFamilySupport().customControlAuth().initializeComponent();
		
		voFamily.setIsCurrentlyActiveFamilySupport(Boolean.TRUE); 
		form.getLocalContext().setSelectedRecord(voFamily);
		
		form.setMode(FormMode.EDIT);
		form.ctnFamilySupport().setcustomControlAuthEnabled(true);
		
		Object mos = domain.getMosUser();
		if(mos != null){
			form.ctnFamilySupport().cmbRecordingHCP().newRow((MemberOfStaffLiteVo)mos, mos.toString());
			form.ctnFamilySupport().cmbRecordingHCP().setValue((MemberOfStaffLiteVo)mos);
		}
		form.ctnFamilySupport().dtimRecordingDateTime().setValue(new DateTime());
		
	}
	
	private void newInstanceFromNOK()
	{
		form.ctnFamilySupport().customControlAuth().initializeComponent();			
		form.getLocalContext().setSelectedRecord(new SupportNetworkFamily());
		//wdev-16515
		Object mos = domain.getMosUser();
		if(mos != null){
			form.ctnFamilySupport().cmbRecordingHCP().newRow((MemberOfStaffLiteVo)mos, mos.toString());
			form.ctnFamilySupport().cmbRecordingHCP().setValue((MemberOfStaffLiteVo)mos);
		}
		form.ctnFamilySupport().dtimRecordingDateTime().setValue(new DateTime());
		//----------
		
		if (form.getLocalContext().getNextOfKinIsNotNull())
		{
			form.ctnFamilySupport().txtName().setValue(form.getLocalContext().getNextOfKin().getNameIsNotNull()?form.getLocalContext().getNextOfKin().getName().toString():null);
			form.ctnFamilySupport().txtAddress().setValue(form.getLocalContext().getNextOfKin().getAddressIsNotNull()?form.getLocalContext().getNextOfKin().getAddress().toDisplayStringForMultiLineTextBox():null);
			form.ctnFamilySupport().txtHomePhone().setValue(form.getLocalContext().getNextOfKin().getAddressIsNotNull()?form.getLocalContext().getNextOfKin().getAddress().getPhone():null);
			form.ctnFamilySupport().txtMobilrPhone().setValue(form.getLocalContext().getNextOfKin().getMobile() != null?form.getLocalContext().getNextOfKin().getMobile().getCommValue():null);
			form.ctnFamilySupport().txtWorkPhone().setValue(form.getLocalContext().getNextOfKin().getWorkPhoneNumber() != null?form.getLocalContext().getNextOfKin().getWorkPhoneNumber().getCommValue():null);
			form.ctnFamilySupport().txtEmailAddress().setValue(form.getLocalContext().getNextOfKin().getMobile() != null?form.getLocalContext().getNextOfKin().getMobile().getCommValue():null);
			
			form.setMode(FormMode.EDIT);
		}
	}

	public void updateControlsState()
	{
		
		boolean isCCOspecific = ConfigFlag.GEN.SUPPORT_NETWORK_FAMILY_TYPE.getValue().equals("CCO");
		boolean isEditMode = form.getMode().equals(FormMode.EDIT);
		form.ctnFamilySupport().txtEmailAddress().setEnabled(isEditMode);
		form.ctnFamilySupport().chkFit().setEnabled(isEditMode);
		form.ctnFamilySupport().chkAware().setEnabled(isEditMode);
		form.ctnFamilySupport().chkPermission().setEnabled(isEditMode);
		
		form.btnCopyPA().setVisible(isCCOspecific && isEditMode);
		
		if (isEditMode)
		{
			form.btnUpdate().setVisible(false);
			form.ctnFamilySupport().setCollapsed(false);
			form.getContextMenus().hideAllSupportNetworkFamilyGridMenuItems();
			
			if ((form.getLocalContext().getSelectedRecord() == null) || (form.getLocalContext().getSelectedRecordIsNotNull() && form.getLocalContext().getSelectedRecord().getID_SupportNetworkFamily() == null))
			{
				form.ctnFamilySupport().setcustomControlAuthEnabled(true);
			}
			setInactiveBtnVisible(false);
			form.btnReactivate().setVisible(false);
		}
		else if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnUpdate().setVisible(form.grdFamily().getValue() != null);
			setInactiveBtnVisible(enableInactivateButton(form.grdFamily().getValue()));
						
			form.btnReactivate().setVisible(form.grdFamily().getValue() != null && form.grdFamily().getValue().getIsCurrentlyActiveFamilySupportIsNotNull() && !form.grdFamily().getValue().getIsCurrentlyActiveFamilySupport().booleanValue());
			if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			{
				try
				{
					Patient pat = domain.getPatient(form.getGlobalContext().Core.getPatientShort());
					form.getContextMenus().getSupportNetworkFamilyGridNewFromNextofkinItem().setVisible(pat.getNokIsNotNull());
					form.getLocalContext().setNextOfKin(pat.getNok());
				}
				catch ( StaleObjectException se)
				{
					engine.showMessage(se.getMessage());
				}
			}
			else
				form.getContextMenus().getSupportNetworkFamilyGridNewFromNextofkinItem().setVisible(false);
						
			form.getContextMenus().getSupportNetworkFamilyGridNewItem().setVisible(true);
			form.getContextMenus().getSupportNetworkFamilyGridUpdateItem().setVisible(form.grdFamily().getSelectedRow() != null);
		}
		
	}

	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
		form.btnUpdate().setEnabled(false);
		form.ctnFamilySupport().setcustomControlAuthEnabled(false);
	}

	protected void onFormModeChanged()
	{
		updateControlsState();		
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.SupportNetworkFamilyGrid.New:
				newInstance();
			break;
			case GenForm.ContextMenus.SupportNetworkFamilyGrid.Update:
				updateInstance();
			break;
			case GenForm.ContextMenus.SupportNetworkFamilyGrid.NewFromNextofkin:
				newInstanceFromNOK();
			break;			
		}		
		
	}

	private boolean enableInactivateButton(ims.core.vo.SupportNetworkFamily voSupNet)
	{
		if (voSupNet == null || voSupNet.getIsCurrentlyActiveFamilySupport() == null)
			return false;

		return voSupNet.getIsCurrentlyActiveFamilySupport().booleanValue() && form.getMode().equals(FormMode.VIEW);
	}

	private void setInactiveBtnVisible(boolean value)
	{
		form.btnInactive().setVisible(value);
		form.btnInactive().setEnabled(value);
	}

	@Override
	protected void onBtnCopyPAClick() throws PresentationLogicException 
	{
		doCopyPA();
		
	}
	private void doCopyPA()
	{
		PatientShort pa = form.getGlobalContext().Core.getPatientShort();
		if (pa != null && pa.getAddressIsNotNull())
		{
			form.ctnFamilySupport().txtAddress().setValue(pa.getAddress().toDisplayStringForMultiLineTextBox());
		}
				
	}
}
