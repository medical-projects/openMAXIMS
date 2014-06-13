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

package ims.clinicaladmin.forms.gleasonconfiguration;

import ims.clinicaladmin.forms.gleasonconfiguration.GenForm.grdGleasonsRow;
import ims.clinicaladmin.vo.GleasonConfigLiteVo;
import ims.clinicaladmin.vo.GleasonConfigLiteVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers region
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
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
	protected void onGrdGleasonsSelectionChanged()
	{
		// Update local context
		form.getLocalContext().setSelectedGleason(domain.getGleason(form.grdGleasons().getValue()));
		
		// Populate instance controls
		populateInstanceControlsFromData(form.getLocalContext().getSelectedGleason());
		
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onGrdGleasonsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear local context
		form.getLocalContext().setSelectedGleason(null);
		
		// Clear instance controls
		clearInstanceControls();
		
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
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

	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		// Clear local context
		form.getLocalContext().setSelectedGleason(null);
		
		// Hide all context menu options && set text for context menu
		form.getContextMenus().hideAllGenericGridMenuItems();

		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clear();

		// List Gleason records from domain
		populateGleasonGrid(domain.listGleasons());

		// Refresh local context (first attempt to select in grid, then retrieve the value from domain, and then populate instance controls)
		form.grdGleasons().setValue(form.getLocalContext().getSelectedGleason());
		form.getLocalContext().setSelectedGleason(domain.getGleason(form.grdGleasons().getValue()));
		populateInstanceControlsFromData(form.getLocalContext().getSelectedGleason());

		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear instance controls
		clearInstanceControls();

		// Clear local context && grid selection
		form.getLocalContext().setSelectedGleason(null);
		form.grdGleasons().setValue(null);

		// Set active as TRUE by default
		form.ctnDetails().chkActive().setValue(Boolean.TRUE);

		// Set form to EDIT mode
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
			form.getLocalContext().setSelectedGleason(populateDataFromInstanceControls(form.getLocalContext().getSelectedGleason()));

			// Validate instance data
			String[] errors = form.getLocalContext().getSelectedGleason().validate();

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Attempt to save
			form.getLocalContext().setSelectedGleason(domain.saveGleason(form.getLocalContext().getSelectedGleason()));
			
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
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
	}

	public void clear()
	{
		// Clear Gleason grid
		form.grdGleasons().getRows().clear();
		
		// Clear instance controls
		clearInstanceControls();
	}
	
	public void clearInstanceControls()
	{
		this.form.ctnDetails().txtDescription().setValue(null);
		this.form.ctnDetails().txtName().setValue(null);
		this.form.ctnDetails().chkActive().setValue(false);
	}
	
	
	public void updateControlsState()
	{
		// Collapse / expand details container
		form.ctnDetails().setCollapsed(FormMode.VIEW.equals(form.getMode()) && !form.getLocalContext().getSelectedGleasonIsNotNull());

		// Update controls for VIEW mode
		if (FormMode.VIEW.equals(form.getMode()))
		{
			// EDIT button
			form.btnEdit().setEnabled(form.getLocalContext().getSelectedGleasonIsNotNull() && form.grdGleasons().getValue() != null);
			form.btnEdit().setVisible(true);
		}

		// Update context menu options
		updateContextMenuState();
	}
	
	private void updateContextMenuState()
	{
		// NEW option should be visible in VIEW mode always, EDIT options should have the same rules as EDIT button
		form.getContextMenus().getGenericGridAddItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getLocalContext().getSelectedGleasonIsNotNull() && form.grdGleasons().getValue() != null);
	}

	
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange functions
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void populateGleasonGrid(GleasonConfigLiteVoCollection gleasonCollection)
	{
		// Clear grid
		form.grdGleasons().getRows().clear();
		
		// Terminate function on null value parameter
		if (gleasonCollection == null)
			return;
		
		// Iterate through gleason collection
		for (GleasonConfigLiteVo gleason : gleasonCollection)
		{
			if (gleason == null)
				continue;
			
			// Add each gleason to a grid row
			grdGleasonsRow gleasonRow = form.grdGleasons().getRows().newRow(true);
			
			// Set histology row columns
			gleasonRow.setColName(gleason.getGleasonName());
			gleasonRow.setColDescription(gleason.getGleasonDescription());
			gleasonRow.setColActive(Boolean.TRUE.equals(gleason.getIsActive()));
			
			// Grey out inactive record
			gleasonRow.setTextColor(Boolean.TRUE.equals(gleason.getIsActive()) ? Color.Black : Color.Gray);
			
			gleasonRow.setValue(gleason);
		}
	}

	private void populateInstanceControlsFromData(GleasonConfigLiteVo gleason)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Terminate function on null value parameter
		if (gleason == null)
			return;
		
		// Set value to instance controls
		form.ctnDetails().txtName().setValue(gleason.getGleasonName());
		form.ctnDetails().txtDescription().setValue(gleason.getGleasonDescription());
		form.ctnDetails().chkActive().setValue(Boolean.TRUE.equals(gleason.getIsActive()));
	}

	private GleasonConfigLiteVo populateDataFromInstanceControls(GleasonConfigLiteVo gleason)
	{
		// Check for an instantiated parameter (instantiate it if null)
		if (gleason == null)
		{
			gleason = new GleasonConfigLiteVo();
		}
		
		// Get instance data from screen
		gleason.setGleasonName(form.ctnDetails().txtName().getValue());
		gleason.setGleasonDescription(form.ctnDetails().txtDescription().getValue());
		gleason.setIsActive(Boolean.TRUE.equals(form.ctnDetails().chkActive().getValue()));

		return gleason;
	}
}
