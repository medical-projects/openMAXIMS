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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.40 build 2181.23522)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.massage;

import java.util.ArrayList;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.DeepFrictionMassageAreaStructure;
import ims.spinalinjuries.vo.lookups.DeepFrictionMassageAreaStructureCollection;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.therapies.forms.massage.GenForm.grdFrictionRow;
import ims.therapies.vo.ConnectiveTissueMassageVo;
import ims.therapies.vo.ConnectiveTissueMassageVoCollection;
import ims.therapies.vo.DeepFrictionMassageVo;
import ims.therapies.vo.DeepFrictionMassageVoCollection;
import ims.therapies.vo.MassageShortVo;
import ims.therapies.vo.MassageShortVoCollection;
import ims.therapies.vo.MassageVo;
import ims.therapies.vo.SoftTissueMassageVo;
import ims.therapies.vo.SoftTissueMassageVoCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}

	private void loadLookupsIntoGrid(grdFrictionRow rowFriction)
	{
		DeepFrictionMassageAreaStructureCollection collDeepFriction = LookupHelper.getDeepFrictionMassageAreaStructure(domain.getLookupService());
	
		TreeNode[] rootNodes = null;

		rootNodes = collDeepFriction.getRootNodes();
		
		if(rowFriction == null)
			rowFriction = form.grdFriction().getRows().newRow();
		
		rowFriction.getColArea().clear();
		for (int j = 0; j < rootNodes.length; j++)
		{
			DeepFrictionMassageAreaStructure inst = (DeepFrictionMassageAreaStructure) rootNodes[j];
			rowFriction.getColArea().newRow(inst, inst.getText());
		}
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);	

		form.dtimAuthoringDateTime().setValue(new DateTime());
		Hcp hcp = (Hcp) domain.getHcpUser();
		if(hcp != null)
		{
			form.qmbAuthoringCP().newRow(hcp, hcp.toString());
			form.qmbAuthoringCP().setValue(hcp);
		}
		enableAuthoringControls(true);
	}
	
	private void enableAuthoringControls(boolean enable)
	{
		form.dtimAuthoringDateTime().setEnabled(enable);
		form.qmbAuthoringCP().setEnabled(enable);		
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		enableAuthoringControls(false);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	private boolean save()
	{
		if (!populateDataFromScreen())
			return false;
			
		MassageVo voMassage = form.getLocalContext().getCurrentMassageVo();
		String[] messages = voMassage.validate();
		
		if (messages != null)
		{
			engine.showErrors("Validation Errors for MassageVo", messages);
			return false;
		}
		try
		{
			form.getLocalContext().setCurrentMassageVo(domain.saveMassageVo(voMassage));
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;				
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Massage record already exists for this Clinical Contact. " + e.getMessage());
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

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if (sender.equals(form.grdTissue()) )
		{
			if (menuItemID == form.getContextMenus().getMassageSoftAddItem().getID())
				newSoftTissueInstance();
			else if (menuItemID == form.getContextMenus().getMassageSoftRemoveItem().getID())
				removeSoftTissueInstance();
		}
		else if (sender.equals(form.grdFriction()) )
		{
			if (menuItemID == form.getContextMenus().getMassageDeepAddItem().getID())
				newDeepFriction();
			else if (menuItemID == form.getContextMenus().getMassageDeepRemoveItem().getID())
				removeDeepFriction();
		}
		else if (sender.equals(form.grdConnective()) )
		{
			if (menuItemID == form.getContextMenus().getMassageConnectiveAddItem().getID())
				newConnectiveTissue();
			else if (menuItemID == form.getContextMenus().getMassageConnectiveRemoveItem().getID())
				removeConnectiveTissue();
		}
					
	}
	
	private void removeConnectiveTissue() {
		if(form.grdConnective().getSelectedRowIndex()!=-1)
			form.grdConnective().getRows().remove(form.grdConnective().getSelectedRowIndex());		
		
		form.getContextMenus().getMassageConnectiveRemoveItem().setVisible(false);
	}

	private void removeDeepFriction() {
		if(form.grdFriction().getSelectedRowIndex()!=-1)
			form.grdFriction().getRows().remove(form.grdFriction().getSelectedRowIndex());
		
		form.getContextMenus().getMassageDeepRemoveItem().setVisible(false);
	}

	private void removeSoftTissueInstance() {
		if(form.grdTissue().getSelectedRowIndex()!=-1)
			form.grdTissue().getRows().remove(form.grdTissue().getSelectedRowIndex());
		
		form.getContextMenus().getMassageSoftRemoveItem().setVisible(false);
	}

	private void newConnectiveTissue()
	{
		form.grdConnective().getRows().newRow();
	}

	private void newDeepFriction()
	{
		loadLookupsIntoGrid(null);
	}

	private void newSoftTissueInstance()
	{
		form.grdTissue().getRows().newRow();
	}

	protected void displayHeaderData() 
	{
		//Display the current contexts header data.
		MassageVo voMassage = form.getLocalContext().getCurrentMassageVo();
		
		form.dtimAuthoringDateTime().setValue(voMassage.getAuthoringDateTimeIsNotNull() ? voMassage.getAuthoringDateTime(): null);					
		if (voMassage.getAuthoringCPIsNotNull())
			form.qmbAuthoringCP().newRow(voMassage.getAuthoringCP(), voMassage.getAuthoringCP().toString());				
		form.qmbAuthoringCP().setEditedText(voMassage.getAuthoringCPIsNotNull() ? voMassage.getAuthoringCP().toString(): null);
	}

	private void clearScreen() 
	{
		form.dtimAuthoringDateTime().setValue(null);
		form.qmbAuthoringCP().setValue(null);
		form.grdTissue().getRows().clear();
		form.grdConnective().getRows().clear();
		form.grdFriction().getRows().clear();
	}
	
	private void open() 
	{
		form.setMode(FormMode.VIEW);	
		fillRecordBrowser();
	}
	
	private void fillRecordBrowser()
	{
		MassageShortVoCollection voMassageShortVoColl = domain.listMassageByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		loadCurrentCareContext();
		boolean currentClinicalContactFound = false;
		if(voMassageShortVoColl != null)
		{
			if(engine.isRIEMode()){
				for(int i=0; i<voMassageShortVoColl.size(); i++)
				{
					MassageShortVo voMassageShort = voMassageShortVoColl.get(i);
					if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact().equals(voMassageShort.getClinicalContact().getID_ClinicalContact()))
						form.recbrMassage().newRow(voMassageShort, "\t\t\t\tClinical Contact: "+ voMassageShort.getClinicalContact().getStartDateTime().toString() +" - " +voMassageShort.getClinicalContact().getSeenBy().toString(), Color.Green);
					else
						form.recbrMassage().newRow(voMassageShort, "\t\t\t\tClinical Contact: "+ voMassageShort.getClinicalContact().getStartDateTime().toString() +" - " +voMassageShort.getClinicalContact().getSeenBy().toString());
				}
				if(voMassageShortVoColl.size()>0)
					form.recbrMassage().setValue(voMassageShortVoColl.get(voMassageShortVoColl.size()-1));
			}
			else{
				for(int i=0; i<voMassageShortVoColl.size(); i++)
				{
					ClinicalContactShortVo voClinicalContact = voMassageShortVoColl.get(i).getClinicalContact();
					if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact().equals(voClinicalContact.getID_ClinicalContact()))
					{
						currentClinicalContactFound = true;
						loadCurrentClinicalContact(voClinicalContact);
					}
					else
						form.recbrMassage().newRow(voClinicalContact, "\t\t\t\tClinical Contact: "+ voClinicalContact.getStartDateTime().toString() +" - " +voClinicalContact.getSeenBy().toString());
				}
			}
		}
		
		if(!currentClinicalContactFound && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && !engine.isRIEMode())
			loadCurrentClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		browseRecored();
		
	}

	private void browseRecored()
	{
		clearScreen();
		updateBrowseInformation();
		form.getLocalContext().setCurrentMassageVo(null);
		if(form.recbrMassage().getValue() != null)
		{
			if(engine.isRIEMode()){
				if(form.recbrMassage().getValue() instanceof MassageShortVo){
					MassageShortVo voMassageShort = (MassageShortVo)form.recbrMassage().getValue();
					form.getLocalContext().setCurrentMassageVo(domain.getMassageVo(voMassageShort.getID_Massage()));
					populateScreenFromData();
				}
			}
			else if(form.recbrMassage().getValue() instanceof ClinicalContactShortVo)
			{
				form.getLocalContext().setCurrentMassageVo(domain.getMassageVoByClinicalContact((ClinicalContactRefVo) form.recbrMassage().getValue()));
				populateScreenFromData();
			}
		}
		isRecordEditable();
	}

	private void isRecordEditable()
	{
		boolean isEditable = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			if(form.recbrMassage().getValue() instanceof ClinicalContactShortVo)
			{
				ClinicalContactShortVo voContact = (ClinicalContactShortVo) form.recbrMassage().getValue();
				if(voContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
					isEditable = true;
			}
		}
		
		form.btnNew().setVisible(isEditable);
		form.btnUpdate().setVisible(isEditable);
		
		if(isEditable)
		{
			if (form.getLocalContext().getCurrentMassageVoIsNotNull() )
			{
				form.btnNew().setVisible(false);
				form.btnUpdate().setEnabled(true);
			}
			else
			{
				form.btnNew().setEnabled(true);
				form.btnUpdate().setVisible(false);
			}
		}
	}

	private void loadCurrentClinicalContact(ClinicalContactShortVo voCurrentClinicalContact)
	{
		form.recbrMassage().newRow(voCurrentClinicalContact,  "\t\t\t\tClinical Contact: "+ voCurrentClinicalContact.getStartDateTime().toString() +" - " +voCurrentClinicalContact.getSeenBy().toString(), Color.Green);
		form.recbrMassage().setValue(voCurrentClinicalContact);
	}

	private void loadCurrentCareContext()
	{
		CareContextShortVo voCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		form.recbrMassage().newRow(voCareContext, voCareContext.getRecordBrowserText());
		
	}

	private boolean populateDataFromScreen()
	{
		MassageVo voMassage = form.getLocalContext().getCurrentMassageVo();

		if (voMassage == null)
			voMassage = new MassageVo();
		
		voMassage.setAuthoringDateTime(form.dtimAuthoringDateTime().getValue() != null ? form.dtimAuthoringDateTime().getValue() : null);					
		voMassage.setAuthoringCP(form.qmbAuthoringCP().getValue() != null ? form.qmbAuthoringCP().getValue() : null);
	
		SoftTissueMassageVoCollection voSoftTissueMassageColl = new SoftTissueMassageVoCollection();
		SoftTissueMassageVo voSoftTissueMassage = new SoftTissueMassageVo();
		for (int i = 0 ; i < form.grdTissue().getRows().size() ; i++)
		{
			voSoftTissueMassage = null;
			
			voSoftTissueMassage = form.grdTissue().getRows().get(i).getValue();
			GenForm.grdTissueRow rowTissue = form.grdTissue().getRows().get(i);
			
			if (voSoftTissueMassage == null) //New record
			{
				voSoftTissueMassage = new SoftTissueMassageVo();
				voSoftTissueMassage.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			}

			voSoftTissueMassage.setSTMassageArea(rowTissue.getColArea() != null ? rowTissue.getColArea() : null);
			voSoftTissueMassage.setSTMassageType(rowTissue.getColTypeofMassage() != null ? rowTissue.getColTypeofMassage() : null);
			voSoftTissueMassage.setSTMassageAreaDescription(rowTissue.getColAreaDescription() != null ? rowTissue.getColAreaDescription() : null);
			voSoftTissueMassage.setLaterality(rowTissue.getColLaterality() != null ? rowTissue.getColLaterality() : null);
			voSoftTissueMassage.setDuration(rowTissue.getColDuration() != null ? rowTissue.getColDuration() : null);
			voSoftTissueMassage.setNotes(rowTissue.getColNotes() != null ? rowTissue.getColNotes() : null);
			
			voSoftTissueMassageColl.add(voSoftTissueMassage);
		}
		voMassage.setSoftTissueMassage(voSoftTissueMassageColl);
		
		DeepFrictionMassageVoCollection voDeepFrictionColl = new DeepFrictionMassageVoCollection();
		DeepFrictionMassageVo voDeepFrictionMassage = new DeepFrictionMassageVo();
		for (int i = 0 ; i < form.grdFriction().getRows().size() ; i++)
		{
			voDeepFrictionMassage = null;
			
			voDeepFrictionMassage = form.grdFriction().getRows().get(i).getValue();
			GenForm.grdFrictionRow rowFriction = form.grdFriction().getRows().get(i);
			
			if (voDeepFrictionMassage == null) //New record
			{
				voDeepFrictionMassage = new DeepFrictionMassageVo();
				voDeepFrictionMassage.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			}
			
			voDeepFrictionMassage.setDFMassageArea(rowFriction.getColArea() != null ? (DeepFrictionMassageAreaStructure)rowFriction.getColArea().getValue() : null);
			voDeepFrictionMassage.setDFMassageStructure(rowFriction.getColStructure() != null ? (DeepFrictionMassageAreaStructure)rowFriction.getColStructure().getValue() : null);
			voDeepFrictionMassage.setLaterality(rowFriction.getColLaterality() != null ? rowFriction.getColLaterality() : null);
			voDeepFrictionMassage.setDuration(rowFriction.getColDuration() != null ? rowFriction.getColDuration() : null);
			voDeepFrictionMassage.setNotes(rowFriction.getColNotes() != null ? rowFriction.getColNotes() : null);
			
			voDeepFrictionColl.add(voDeepFrictionMassage);
		}
		voMassage.setDeepFriction(voDeepFrictionColl);
		
		ConnectiveTissueMassageVoCollection voConnectiveTissueMassageColl = new ConnectiveTissueMassageVoCollection();
		ConnectiveTissueMassageVo voConnTissueMassage = new ConnectiveTissueMassageVo();
		for (int i = 0 ; i < form.grdConnective().getRows().size() ; i++)
		{
			voConnTissueMassage = null;
			
			voConnTissueMassage = form.grdConnective().getRows().get(i).getValue();
			GenForm.grdConnectiveRow rowConn = form.grdConnective().getRows().get(i);
			
			if (voConnTissueMassage == null) //New record
			{
				voConnTissueMassage = new ConnectiveTissueMassageVo();
				voConnTissueMassage.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			}

			voConnTissueMassage.setCTMassageArea(rowConn.getColArea() != null ? rowConn.getColArea() : null);
			voConnTissueMassage.setCTMassageAreaDescription(rowConn.getColAreaDescription() != null ? rowConn.getColAreaDescription() : null);
			voConnTissueMassage.setLaterality(rowConn.getColLaterality() != null ? rowConn.getColLaterality() : null);
			voConnTissueMassage.setDuration(rowConn.getColDuration() != null ? rowConn.getColDuration() : null);
			voConnTissueMassage.setNotes(rowConn.getColNotes() != null ? rowConn.getColNotes() : null);
			
			voConnectiveTissueMassageColl.add(voConnTissueMassage);
		}
		voMassage.setConnectiveTissueMassage(voConnectiveTissueMassageColl);
		
		if (!voMassage.getClinicalContactIsNotNull())
			voMassage.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		form.getLocalContext().setCurrentMassageVo(voMassage);
		return true;
	}

	private void populateScreenFromData() 
	{
		MassageVo voMassage = form.getLocalContext().getCurrentMassageVo();

		if (voMassage == null)
			return;
		
		displayHeaderData();
		
		//Soft Tissue
		if (voMassage.getSoftTissueMassageIsNotNull())
		{
			for (int i = 0 ; i < voMassage.getSoftTissueMassage().size(); i++)
			{
				SoftTissueMassageVo voSoftTissueMassage = voMassage.getSoftTissueMassage().get(i);
				
				GenForm.grdTissueRow rowTissue = form.grdTissue().getRows().newRow();
				
				rowTissue.setColTypeofMassage(voSoftTissueMassage.getSTMassageTypeIsNotNull()?voSoftTissueMassage.getSTMassageType():null);
				rowTissue.setColArea(voSoftTissueMassage.getSTMassageAreaIsNotNull()?voSoftTissueMassage.getSTMassageArea():null);
				rowTissue.setColAreaDescription(voSoftTissueMassage.getSTMassageAreaDescriptionIsNotNull()?voSoftTissueMassage.getSTMassageAreaDescription().toString():null);
				rowTissue.setColLaterality(voSoftTissueMassage.getLateralityIsNotNull()?voSoftTissueMassage.getLaterality():null);
				rowTissue.setColDuration(voSoftTissueMassage.getDurationIsNotNull()?voSoftTissueMassage.getDuration():null);
				rowTissue.setColNotes(voSoftTissueMassage.getNotesIsNotNull()?voSoftTissueMassage.getNotes():null);

				rowTissue.setValue(voSoftTissueMassage);
			}
		}
	
		//Deep Friction
		if (voMassage.getDeepFrictionIsNotNull())
		{
			for (int i = 0 ; i < voMassage.getDeepFriction().size(); i++)
			{
				DeepFrictionMassageVo voDeepFrictionMassage = voMassage.getDeepFriction().get(i);
				
				GenForm.grdFrictionRow rowFriction = form.grdFriction().getRows().newRow();
				loadLookupsIntoGrid(rowFriction);
				
				rowFriction.getColArea().setValue(voDeepFrictionMassage.getDFMassageArea());
				//if(voDeepFrictionMassage.getDFMassageAreaIsNotNull())
				//	rowFriction.getColArea().newRow(voDeepFrictionMassage.getDFMassageArea(), voDeepFrictionMassage.getDFMassageArea().toString());
				
				
				loadStructure(rowFriction);
			
				
				rowFriction.getColStructure().setValue(voDeepFrictionMassage.getDFMassageStructureIsNotNull()? (DeepFrictionMassageAreaStructure)voDeepFrictionMassage.getDFMassageStructure() : null);
				
				rowFriction.setColLaterality(voDeepFrictionMassage.getLateralityIsNotNull()?voDeepFrictionMassage.getLaterality():null);
				rowFriction.setColDuration(voDeepFrictionMassage.getDurationIsNotNull()?voDeepFrictionMassage.getDuration():null);
				rowFriction.setColNotes(voDeepFrictionMassage.getNotesIsNotNull()?voDeepFrictionMassage.getNotes():null);

				rowFriction.setValue(voDeepFrictionMassage);
			}
		}
		
		//Connective Tissue
		if (voMassage.getConnectiveTissueMassageIsNotNull())
		{
			for (int i = 0 ; i < voMassage.getConnectiveTissueMassage().size(); i++)
			{
				ConnectiveTissueMassageVo voConnTissueMassage = voMassage.getConnectiveTissueMassage().get(i);
				
				GenForm.grdConnectiveRow rowConnTissue = form.grdConnective().getRows().newRow();
				
				rowConnTissue.setColArea(voConnTissueMassage.getCTMassageAreaIsNotNull()?voConnTissueMassage.getCTMassageArea():null);
				rowConnTissue.setColAreaDescription(voConnTissueMassage.getCTMassageAreaDescriptionIsNotNull()?voConnTissueMassage.getCTMassageAreaDescription().toString():null);
				rowConnTissue.setColLaterality(voConnTissueMassage.getLateralityIsNotNull()?voConnTissueMassage.getLaterality():null);
				rowConnTissue.setColDuration(voConnTissueMassage.getDurationIsNotNull()?voConnTissueMassage.getDuration():null);
				rowConnTissue.setColNotes(voConnTissueMassage.getNotesIsNotNull()?voConnTissueMassage.getNotes():null);

				rowConnTissue.setValue(voConnTissueMassage);
			}
		}
	}

	protected void onQmbAuthoringCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbAuthoringCP().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.qmbAuthoringCP().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.qmbAuthoringCP().showOpened();		
		}		
	}
	
	protected void updateContextMenus()
	{
		form.getContextMenus().getMassageSoftAddItem().setVisible(form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getMassageDeepAddItem().setVisible(form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getMassageConnectiveAddItem().setVisible(form.getMode().equals(FormMode.EDIT));
		
		if(form.getMode().equals(FormMode.VIEW)){
			form.getContextMenus().getMassageSoftRemoveItem().setVisible(false);
			form.getContextMenus().getMassageDeepRemoveItem().setVisible(false);
			form.getContextMenus().getMassageConnectiveRemoveItem().setVisible(false);
		}
	}

	protected void onGrdFrictionMutableComboBoxSelected(int column, grdFrictionRow row, Object value) throws PresentationLogicException 
	{
		if (column == 0)
		{
			loadStructure(row);
		}
	}

	private void loadStructure(grdFrictionRow row)
	{
		DeepFrictionMassageAreaStructureCollection collDeepFriction = LookupHelper.getDeepFrictionMassageAreaStructure(domain.getLookupService());
		
		TreeNode[] rootNodes = null;
		ArrayList childColl = null;

		DeepFrictionMassageAreaStructure childFrictionInst = null;
		rootNodes = collDeepFriction.getRootNodes();

		for (int j = 0; j < rootNodes.length; j++)
		{
			DeepFrictionMassageAreaStructure inst = (DeepFrictionMassageAreaStructure) rootNodes[j];

			if (row.getColArea().getValue().equals(inst))
			{	
				childColl = inst.getChildInstances();

				row.getColStructure().clear();
				if (childColl != null)
				{
					for (int p = 0; p < childColl.size(); p++)
					{
						childFrictionInst = (DeepFrictionMassageAreaStructure) childColl.get(p);
						row.getColStructure().newRow(childFrictionInst, childFrictionInst.getText());
					}
				}
			}
		}
	}
	private void updateBrowseInformation()
	{
		form.lblBrowserStatus().setValue(form.recbrMassage().getRecordState("Assessment", "Assessments"));
	}

	protected void onRecbrMassageValueChanged() throws PresentationLogicException
	{
		browseRecored();
	}

	protected void onFormModeChanged()
	{
		updateContextMenus();
	}

	protected void onGrdConnectiveSelectionChanged() throws PresentationLogicException {
		if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getMassageConnectiveRemoveItem().setVisible(true);		
	}

	protected void onGrdFrictionSelectionChanged() throws PresentationLogicException {
		if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getMassageDeepRemoveItem().setVisible(true);		
	}

	protected void onGrdTissueSelectionChanged() throws PresentationLogicException {
		if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getMassageSoftRemoveItem().setVisible(true);		
	}

}
