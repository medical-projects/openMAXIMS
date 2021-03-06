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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.43 build 2229.25474)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.treatmentequipmentconfig;

import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.therapies.vo.TreatmentEquipmentConfigVo;
import ims.therapies.vo.TreatmentEquipmentConfigVoCollection;
import ims.vo.ValueObject;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	private void open()
	{
		populateListControl(domain.list(null));
		
		//set selection back
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			form.grdDetails().setValue(form.getLocalContext().getSelectedRecord());
			populateInstanceControl(form.grdDetails().getValue());
			updateControlsState();			
		}
		else		
			form.ctnConfig().setCollapsed(true);
		
		form.setMode(FormMode.VIEW);
	}
	protected void onFormModeChanged()
	{
		updateControlsState(); 
	}
	private void populateListControl(TreatmentEquipmentConfigVoCollection voTreatEquipConfigColl)
	{
		clear();
		
		if (voTreatEquipConfigColl != null)
		{
			GenForm.grdDetailsRow row;
			for (int i =0; i < voTreatEquipConfigColl.size();i++)
			{
				row = form.grdDetails().getRows().newRow();
				row.setValue(voTreatEquipConfigColl.get(i));
				
				row.setColEquipType(voTreatEquipConfigColl.get(i).getType().toString());			
				row.setColDesc(voTreatEquipConfigColl.get(i).getDescription());
				row.setColModel(voTreatEquipConfigColl.get(i).getModel());
				row.setColSerial(voTreatEquipConfigColl.get(i).getSerialNumber());								
			}
		}
	}
	private void clear()
	{
		form.grdDetails().getRows().clear();
		clearInstanceControls();	
	}
	private void clearInstanceControls()
	{
		form.ctnConfig().cmbMachineType().setValue(null);
		form.ctnConfig().txtDescription().setValue(null);
		form.ctnConfig().txtModel().setValue(null);
		form.ctnConfig().txtSerialNr().setValue(null);
	}
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	private void newInstance()
	{
		// initalise the screen for a new record
		form.getLocalContext().setSelectedRecord(new TreatmentEquipmentConfigVo());
		form.grdDetails().setValue(null);
		form.ctnConfig().txtDescription().setFocus();
		clearInstanceControls();
		form.ctnConfig().setCollapsed(false);
		form.setMode(FormMode.EDIT);		
	}
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();	
	}
	private boolean save()
	{
		TreatmentEquipmentConfigVo voTreatEquipConfig = populateInstanceData();
				
		//validate Vo
		String[] arrErrors =  voTreatEquipConfig.validate();	
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.save(voTreatEquipConfig));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}
	private TreatmentEquipmentConfigVo populateInstanceData()
	{
		return super.populateDataFromScreen(form.getLocalContext().getSelectedRecord());
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (menuItemID == form.getContextMenus().getLIPNewItem().getID())
			newInstance();
		else if (menuItemID == form.getContextMenus().getLIPUpdateItem().getID())
			updateInstance();	
	}
	private void updateInstance()
	{
		if (allowUpdate())
		{
			form.setMode(FormMode.EDIT);
			form.ctnConfig().setCollapsed(false);
		}
	}
	private boolean allowUpdate()
	{
		return (form.getLocalContext().getSelectedRecordIsNotNull()); 
	}
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		//Display Panel and detail
		if(form.grdDetails().getValue() != null)
		{
			form.getLocalContext().setSelectedRecord((TreatmentEquipmentConfigVo) form.grdDetails().getValue());
			populateInstanceControl(form.grdDetails().getValue());
			form.ctnConfig().setCollapsed(false);
		}
		updateControlsState();
	}
	private void populateInstanceControl(ValueObject voRef)
	{
		clearInstanceControls();
		
		if (voRef != null)
			super.populateScreenFromData((TreatmentEquipmentConfigVo) voRef);
	}
	private void updateControlsState()
	{
		//TODO: will be set as default to New. remove the "New " when this is complete.
		form.getContextMenus().getLIPNewItem().setText("New");

		if (form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().getLIPNewItem().setVisible(false);
			form.getContextMenus().getLIPUpdateItem().setVisible(false);
			form.btnUpdate().setVisible(false);			
		}
		else
		{
			if (form.grdDetails().getSelectedRowIndex()>=0)
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(true);
				if (form.grdDetails().getSelectedRowIndex()>=0)
					form.btnUpdate().setVisible(true);
				else
					form.btnUpdate().setVisible(false);
			}
			else
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(false);
				form.btnUpdate().setVisible(false);
			}
		}	
	}
}
