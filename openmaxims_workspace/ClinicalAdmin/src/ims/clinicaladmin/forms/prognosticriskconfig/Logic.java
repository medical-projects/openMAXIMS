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
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.prognosticriskconfig;

import java.util.ArrayList;
import java.util.List;

import ims.clinicaladmin.forms.prognosticriskconfig.GenForm.grdRisksRow;
import ims.clinicaladmin.forms.tnmstagingclassificationversionconfig.GenForm;
import ims.clinicaladmin.vo.PrognosticRiskConfigVo;
import ims.clinicaladmin.vo.PrognosticRiskConfigVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

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
		
		form.getLocalContext().setCurrentPrognosticRisk(null);
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
		
		populateRisksGrid();
	
		form.getLocalContext().setCurrentPrognosticRisk(domain.getPrognosticRisk(form.getLocalContext().getCurrentPrognosticRisk()));
		form.grdRisks().setValue(form.getLocalContext().getCurrentPrognosticRisk());

		populateScreenFromData(form.getLocalContext().getCurrentPrognosticRisk());
		
		form.setMode(FormMode.VIEW);
	}
	
	private void populateRisksGrid()
	{
		form.grdRisks().getRows().clear();

		PrognosticRiskConfigVoCollection voCollRisks = domain.listPrognosticRisks();
		
		if (voCollRisks == null || voCollRisks.size() == 0)
			return;
			
		for (int i=0 ; i<voCollRisks.size(); i++)
		{
			PrognosticRiskConfigVo voRisk = voCollRisks.get(i);
			
			if (voRisk == null)
				continue;
			
			grdRisksRow row = form.grdRisks().getRows().newRow();
			
			if (row != null)
			{
				row.setColName(voRisk.getRiskNameIsNotNull() ? voRisk.getRiskName():null);
				row.setColDescription(voRisk.getRiskDescriptionIsNotNull() ? voRisk.getRiskDescription():null);
				row.setTooltipForColDescription(voRisk.getRiskDescriptionIsNotNull() ? voRisk.getRiskDescription():null);

				if(voRisk.getIsActiveIsNotNull() && voRisk.getIsActive().booleanValue() == true)
					row.setColActive(form.getImages().Core.Tick);
				else
				{
					row.setColActive(form.getImages().Core.Delete);
					row.setBackColor(Color.LightGray);
				}

				row.setValue(voRisk);
			}
		}		
	}
	
	public void clearInstanceControls()
	{
		super.clearScreen();
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setCurrentPrognosticRisk(null);

		clearInstanceControls();
		
		form.ctnDetails().chkActive().setValue(true);
		
		form.setMode(FormMode.EDIT);
	}

	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		PrognosticRiskConfigVo voRisk = populateDataFromScreen(form.getLocalContext().getCurrentPrognosticRisk());
		
		String[] errors = voRisk.validate(validateUIRules());
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setCurrentPrognosticRisk(domain.savePrognosticRisk(voRisk));
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
		
		return true;
	}
	
	public String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		String[] voValidate = new String[uiErrors.size()];
		uiErrors.toArray(voValidate);
		
		return voValidate;
	}
	
	public void updateControlsState()
	{
		form.ctnDetails().setCollapsed(FormMode.VIEW.equals(form.getMode()) && !form.getLocalContext().getCurrentPrognosticRiskIsNotNull());

		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnEdit().setEnabled(true);
			form.btnEdit().setVisible(form.getLocalContext().getCurrentPrognosticRiskIsNotNull() && form.grdRisks().getValue() != null);
		}
		
		updateContextMenuState();
	}
	
	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onFormModeChanged() 
	{
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
		form.getContextMenus().getLIPUpdateItem().setVisible(FormMode.VIEW.equals(form.getMode()) && form.grdRisks().getValue() != null);
	}

	@Override
	protected void onGrdRisksSelectionChanged()	throws PresentationLogicException 
	{
		form.getLocalContext().setCurrentPrognosticRisk(domain.getPrognosticRisk(form.grdRisks().getValue()));
		
		populateScreenFromData(form.getLocalContext().getCurrentPrognosticRisk());
				
		updateControlsState();
	}

}
