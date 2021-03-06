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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.selectprognosticlocation;

import ims.clinicaladmin.forms.selectprognosticlocation.GenForm.grdRecordsRow;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.oncology.vo.PrognosticLocationConfigVo;
import ims.oncology.vo.PrognosticLocationConfigVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Event Handlers region
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		
		open();
	}
	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().ClinicalAdmin.setSelectedPrognosticLocation(form.grdRecords().getValue());
		
		if (!form.getGlobalContext().ClinicalAdmin.getSelectedPrognosticLocationIsNotNull())
			throw new CodingRuntimeException("ERROR - nothing is selected");
		
		engine.close(DialogResult.OK);
	}


	@Override
	protected void onGrdRecordsSelectionChanged() throws PresentationLogicException
	{
		// Get selection from domain into local context
		form.getLocalContext().setSelctedRecord(domain.getLocation(form.grdRecords().getValue()));
		// Populate instance controls with selected record
		populateInstanceControlsFromData(form.getLocalContext().getSelctedRecord());

		// Update controls state (buttons, context menu options, etc.)
		updateControlsState();
	}

	@Override
	protected void onGrdRecordsSelectionCleared() throws PresentationLogicException
	{
		// Clear selection from local context
		form.getLocalContext().setSelctedRecord(null);
		// Clear instance controls
		clearInstanceControls();

		// Update controls state (buttons, context menu options, etc.)
		updateControlsState();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;

			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
		}
	}

	
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation functions
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		// Clear local context
		form.getLocalContext().setSelctedRecord(null);
		
		// Hide all context menu options & change text if needed
		form.getContextMenus().hideAllGenericGridMenuItems();
		
		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clear();

		// List histology records from domain
		populateLocationRecords(domain.listLocation());

		// Refresh local context (first attempt to select in grid, then retrieve the value from domain, and then populate instance controls)
		form.grdRecords().setValue(form.getLocalContext().getSelctedRecord());
		form.getLocalContext().setSelctedRecord(domain.getLocation(form.grdRecords().getValue()));
		populateInstanceControlsFromData(form.getLocalContext().getSelctedRecord());

		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}

	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context
		form.getLocalContext().setSelctedRecord(null);
		// Clear instance controls
		clearInstanceControls();
		// Clear grid selection
		form.grdRecords().setValue(null);
		// Set form to EDIT Mode
		form.setMode(FormMode.EDIT);
	}
	
	public void updateInstance()
	{
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}
	
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			// Populate instance data from screen
			form.getLocalContext().setSelctedRecord(populateDataFromInstanceControls(form.getLocalContext().getSelctedRecord()));

			// Validate instance data
			String[] errors = form.getLocalContext().getSelctedRecord().validate();

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Attempt to save
			form.getLocalContext().setSelctedRecord(domain.saveLocation(form.getLocalContext().getSelctedRecord()));
			
			// Save was successful
			return true;
		}
		// Treat exceptions
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UnqViolationUncheckedException e)
		{
			e.printStackTrace();
			engine.showMessage("Taxonomy Mapping is registered to another record");
			return false;
		}
	}
	
	public void clear()
	{
		// Clear grid rows
		form.grdRecords().getRows().clear();
		
		// Clear instance controls
		clearInstanceControls();
	}
	
	public void clearInstanceControls()
	{
		form.ctnDetails().txtValue().setValue(null);
		form.ctnDetails().txtDescription().setValue(null);
	}
	
	public void updateControlsState()
	{
		// Select button
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnSelect().setVisible(true);
			form.btnSelect().setEnabled(form.grdRecords().getValue() instanceof PrognosticLocationConfigVo);
		}
		
		// Collapse / expand details container
		form.ctnDetails().setCollapsed(FormMode.VIEW.equals(form.getMode()) && !form.getLocalContext().getSelctedRecordIsNotNull() && form.grdRecords().getValue() == null);

		// Update context menu options
		updateContextMenuState();
	}

	
	private void updateContextMenuState()
	{
		// NEW option should be visible in VIEW mode always, EDIT options should have the same rules as EDIT button
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getLocalContext().getSelctedRecordIsNotNull() && form.grdRecords().getValue() != null);
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange functions
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void populateLocationRecords(PrognosticLocationConfigVoCollection prognosticLocationsRecord)
	{
		// Clear grid
		form.grdRecords().getRows().clear();
		
		// Terminate function on null value parameter
		if (prognosticLocationsRecord == null)
			return;
		
		// Iterate through histology collection
		for (PrognosticLocationConfigVo record : prognosticLocationsRecord)
		{
			if (record == null)
				continue;
			
			// Add each histology to a grid row
			grdRecordsRow recordRow = form.grdRecords().getRows().newRow();
			
			// Set histology row columns
			recordRow.setCoValue(record.getLocationName());
			recordRow.setColDescription(record.getLocationDescription());

			recordRow.setValue(record);
		}
		
	}

	private void populateInstanceControlsFromData(PrognosticLocationConfigVo prognosticLocation)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Terminate function on null value parameter
		if (prognosticLocation == null)
			return;
		
		// Set value to instance controls
		form.ctnDetails().txtValue().setValue(prognosticLocation.getLocationName());
		form.ctnDetails().txtDescription().setValue(prognosticLocation.getLocationDescription());
	}

	private PrognosticLocationConfigVo populateDataFromInstanceControls(PrognosticLocationConfigVo prognosticLocation)
	{
		// Check for an instantiated parameter (instantiate it if null)
		if (prognosticLocation == null)
		{
			prognosticLocation = new PrognosticLocationConfigVo();
			prognosticLocation.setIsActive(Boolean.TRUE);
		}
		
		// Get instance data from screen
		prognosticLocation.setLocationName(form.ctnDetails().txtValue().getValue());
		prognosticLocation.setLocationDescription(form.ctnDetails().txtDescription().getValue());
		
		return prognosticLocation;
	}
}
