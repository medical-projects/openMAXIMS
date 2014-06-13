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
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.80 build 4041.27591)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.tnmstagingclassificationversionconfig;

import java.util.ArrayList;
import java.util.List;

import ims.admin.vo.lookups.LookupHelper;
import ims.clinicaladmin.forms.tnmstagingclassificationversionconfig.GenForm.grdVersionsRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.oncology.vo.TNMStagingClassificationVersionVo;
import ims.oncology.vo.TNMStagingClassificationVersionVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	@Override
	public void initialize() throws FormOpenException
	{
		super.initialize();
		
		form.getLocalContext().setClassificationVersion(null);
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
		if(save())
		{
			open();
		}
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{	
		clearInstanceControls();
		
		populateGridVersions();
	
		form.getLocalContext().setClassificationVersion(domain.getClassificationVersion(form.getLocalContext().getClassificationVersion()));
		form.grdVersions().setValue(form.getLocalContext().getClassificationVersion());

		populateScreenFromData(form.getLocalContext().getClassificationVersion());
		
		form.setMode(FormMode.VIEW);
	}
	
	private void populateGridVersions()
	{
		form.grdVersions().getRows().clear();

		TNMStagingClassificationVersionVoCollection voCollClassificationVersions = domain.listClassificationVersions();
		
		if (voCollClassificationVersions == null || voCollClassificationVersions.size() == 0)
			return;
			
		for (int i=0 ; i<voCollClassificationVersions.size(); i++)
		{
			TNMStagingClassificationVersionVo voClassificationVersion = voCollClassificationVersions.get(i);
			
			if (voClassificationVersion == null)
				continue;
			
			grdVersionsRow row = form.grdVersions().getRows().newRow();
			
			if (row != null)
			{
				row.setcolVersionNumber(voClassificationVersion.getVersionNumber());
				row.setcolVersionDescription(voClassificationVersion.getVersionDescriptionIsNotNull() ? voClassificationVersion.getVersionDescription():null);
				row.setTooltipForcolVersionDescription(voClassificationVersion.getVersionDescriptionIsNotNull() ? voClassificationVersion.getVersionDescription():null);
				row.setcolActiveFrom(voClassificationVersion.getActiveFromIsNotNull() ? voClassificationVersion.getActiveFrom().toString():null);
				row.setcolActiveTo(voClassificationVersion.getActiveToIsNotNull() ? voClassificationVersion.getActiveTo().toString():null);
				row.setcolStatus(voClassificationVersion.getStatus());
				
				if (row.getcolStatus().equals(PreActiveActiveInactiveStatus.INACTIVE))
					row.setBackColor(Color.LightGray);
					
				row.setValue(voClassificationVersion);
			}
		}		
	}
	
	public void clearInstanceControls()
	{	
		clearScreen();
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setClassificationVersion(null);

		clearScreen();
		//wdev-13276
		form.dteActiveFrom().setRequired(false);
		form.dteActiveTo().setRequired(false);
		//--------

		form.setMode(FormMode.EDIT);
	}
	
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		TNMStagingClassificationVersionVo voClassificationVersion = populateDataFromScreen(form.getLocalContext().getClassificationVersion());
		
		String[] errors = voClassificationVersion.validate(validateUIRules());
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setClassificationVersion(domain.saveClassificationVersion(voClassificationVersion));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage(), "Error");
			return false;
		}
		
		return true;
	}
	
	public String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if (form.cmbStatus().getValue() != null)
		{
			if (form.cmbStatus().getValue().equals(PreActiveActiveInactiveStatus.ACTIVE) && form.dteActiveFrom().getValue() == null)
				uiErrors.add("Please enter Active From date value.");
		
			if (form.cmbStatus().getValue().equals(PreActiveActiveInactiveStatus.INACTIVE) && (form.dteActiveFrom().getValue() == null || form.dteActiveTo().getValue() == null))
				uiErrors.add("Please enter Active From and Active To date values.");
			
		}
		
		// Validate Active To date not to be set into future if version status is inactive
		if (PreActiveActiveInactiveStatus.INACTIVE.equals(form.cmbStatus().getValue()) && form.dteActiveTo().getValue() != null && form.dteActiveTo().getValue().isGreaterThan(new Date()))
			uiErrors.add("Active To date can not be set into future if version status is inactive");
		
		if (form.dteActiveFrom().getValue() != null && form.dteActiveTo().getValue() != null)
			if (form.dteActiveFrom().getValue().isGreaterThan(form.dteActiveTo().getValue()))
				uiErrors.add("Active From date must be before Active To date.");
		
		String[] voValidate = new String[uiErrors.size()];
		uiErrors.toArray(voValidate);
		
		return voValidate;
	}
	
	public void updateControlsState()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setEnabled(form.grdVersions().getValue() != null); 
			form.btnEdit().setVisible(true);
		}
		updateContextMenuState();
	}
	
	public void updateInstance()
	{
		form.getLocalContext().setClassificationVersion(domain.getClassificationVersion(form.grdVersions().getValue()));

		populateScreenFromData(form.getLocalContext().getClassificationVersion());
		
		//wdev-13276
		TNMStagingClassificationVersionVo value = form.getLocalContext().getClassificationVersion();
		if(value != null)
		{
			if(value.getStatusIsNotNull())
			{
				if(PreActiveActiveInactiveStatus.ACTIVE.equals(value.getStatus()))
				{
					form.dteActiveFrom().setRequired(true);
					form.dteActiveTo().setRequired(false);
				}
				else if(PreActiveActiveInactiveStatus.INACTIVE.equals(value.getStatus()))
				{
					form.dteActiveFrom().setRequired(true);
					form.dteActiveTo().setRequired(true);
				}
				else
				{
					form.dteActiveFrom().setRequired(false);
					form.dteActiveTo().setRequired(false);
				}
				
			}
			else
			{
				form.dteActiveFrom().setRequired(false);
				form.dteActiveTo().setRequired(false);
			}
			
		}
		
		//--------
		
		form.setMode(FormMode.EDIT);
	}

	// WDEV-17672 
	private void removePreActiveActiveStatus() 
	{
		PreActiveActiveInactiveStatus status = form.cmbStatus().getValue();
		form.cmbStatus().clear();

		PreActiveActiveInactiveStatusCollection lookupColl = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(domain.getLookupService());

		for (int i = 0; lookupColl != null && i < lookupColl.size(); i++)
		{
			if (isStatusActive() && lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE))
				continue;

			if (isStatusInactive() && (lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE) || lookupColl.get(i).equals(PreActiveActiveInactiveStatus.ACTIVE)))
				continue;

			form.cmbStatus().newRow(lookupColl.get(i), lookupColl.get(i).toString(), lookupColl.get(i).getImage(), lookupColl.get(i).getColor());
		}

		form.cmbStatus().setValue(status);
	}

	private boolean isStatusInactive()
	{
		TNMStagingClassificationVersionVo version = form.getLocalContext().getClassificationVersion();
		return version != null && version.getStatusIsNotNull() && PreActiveActiveInactiveStatus.INACTIVE.equals(version.getStatus());
	}

	private boolean isStatusActive() 
	{
		TNMStagingClassificationVersionVo version = form.getLocalContext().getClassificationVersion();
		return version != null && version.getStatusIsNotNull() && PreActiveActiveInactiveStatus.ACTIVE.equals(version.getStatus());
	}

	@Override
	protected void onGrdVersionsSelectionChanged() throws PresentationLogicException
	{
		form.getLocalContext().setClassificationVersion(domain.getClassificationVersion(form.grdVersions().getValue()));
		
		populateScreenFromData(form.getLocalContext().getClassificationVersion());
		
		
				
		updateControlsState();
	}

	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
		// WDEV-17672 
		if(FormMode.EDIT.equals(form.getMode()))
		{
			removePreActiveActiveStatus();
		}
	}

	@Override
	protected void onGrdVersionsSelectionCleared() throws PresentationLogicException 
	{
		form.getLocalContext().setClassificationVersion(null);
		
		clearScreen();
		
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.LIP.New:
				newInstance();
				break;
				
			case GenForm.ContextMenus.LIP.Update:
				updateInstance();
				break;
		}
	}
	
	private void updateContextMenuState()
	{
		form.getContextMenus().getLIPNewItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getLIPUpdateItem().setVisible(FormMode.VIEW.equals(form.getMode()) && form.grdVersions().getValue() != null);
	}

	//wdev-13276
	protected void onCmbStatusValueChanged() throws PresentationLogicException 
	{
		if( PreActiveActiveInactiveStatus.ACTIVE.equals(form.cmbStatus().getValue()) )
		{
			form.dteActiveFrom().setRequired(true);
			form.dteActiveTo().setRequired(false);
		}
		else if(PreActiveActiveInactiveStatus.INACTIVE.equals(form.cmbStatus().getValue()))
		{
			form.dteActiveFrom().setRequired(true);
			form.dteActiveTo().setRequired(true);
		}
		else if(PreActiveActiveInactiveStatus.PREACTIVE.equals(form.cmbStatus().getValue()))
		{
			form.dteActiveFrom().setRequired(false);
			form.dteActiveTo().setRequired(false);
		}
		else
		{
			form.dteActiveFrom().setRequired(false);
			form.dteActiveTo().setRequired(false);
		}
		
	}
}
