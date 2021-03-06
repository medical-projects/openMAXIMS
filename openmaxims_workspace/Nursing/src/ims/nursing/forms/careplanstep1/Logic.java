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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40628.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplanstep1;

import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException, PresentationLogicException
	{
		if (domain.getHcpLiteUser() == null)//WDEV-15038
		{
			throw new PresentationLogicException("Only HCP Users can access this form.");
		}
		
		//28/10/2004 - Sinead request - Default Contains checkbox
		form.layerControl().tab2().textNewTitle().setFocus();
		form.layerControl().tab1().Group1().setValue(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonContains);
		//-------------------------------------------------------
		if (engine.getPreviousNonDialogFormName().equals(form.getForms().Nursing.CarePlanStep2))
		{
			// Check if anything in Global Context and set the title and object accordingly.
			// Could be from the previous button pressed from the Step 2 form
			if (form.getGlobalContext().COE.getCarePlanTemplateTitle() == null)
			{
				form.layerControl().showtab2();
				if (form.getGlobalContext().COE.getCarePlanTitle() != null)
					form.layerControl().tab2().textNewTitle().setValue(form.getGlobalContext().COE.getCarePlanTitle());
				if (form.getGlobalContext().COE.getCarePlanObjective() != null)
					form.layerControl().tab2().textNewObjective().setValue(form.getGlobalContext().COE.getCarePlanObjective());
			}
			else
			{
				// A template id is there, open the other tab
				form.layerControl().showtab1();
				form.checkBoxYes().setValue(true);
				if (form.getGlobalContext().COE.CarePlan.getSearchToggle() != null)
				{
					if (form.getGlobalContext().COE.CarePlan.getSearchToggle().equals("B"))
						form.layerControl().tab1().Group1().setValue(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonBeginsWith);
					else if (form.getGlobalContext().COE.CarePlan.getSearchToggle().equals("C"))
						form.layerControl().tab1().Group1().setValue(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonContains);
					else
						form.layerControl().tab1().Group1().setValue(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonExactMatch);
				}
				else
				{
					form.layerControl().tab1().Group1().setValue(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonExactMatch);
				}
					
				form.layerControl().tab1().textSearchCriteria().setValue(form.getGlobalContext().COE.CarePlan.getSearchCriteria());
				populateGrid(form.getGlobalContext().COE.CarePlan.getCarePlanTemplates());
			}
		}
		else 
		{
			form.layerControl().showtab2();
		}
	}
	protected void onBSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Ensure that something has been put into the title
		if (form.layerControl().tab1().textSearchCriteria().getValue() == null ||
			form.layerControl().tab1().textSearchCriteria().getValue().equals(""))
			{
				engine.showMessage("Please enter search criteria for the Care Plan Template.");
				return;
			}
			
		String templateStr=form.layerControl().tab1().textSearchCriteria().getValue();
		if (form.layerControl().tab1().Group1().getValue().equals(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonBeginsWith))
			templateStr = templateStr + "%";
		else if (form.layerControl().tab1().Group1().getValue().equals(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonContains))
			templateStr = "%" + templateStr + "%";
		
		CarePlanTemplateCollection searchResults = domain.listTemplates(templateStr);
		
		if (searchResults == null || searchResults.size() == 0)
		{
			engine.showMessage("No results found for search criteria.");
		}
		
		populateGrid(searchResults);
		
	}

	private void populateGrid(CarePlanTemplateCollection coll)
	{
		form.layerControl().tab1().gridCarePlan().getRows().clear();
		if (coll != null)
		{
			GenForm.layerControlLayer.tab1Container.gridCarePlanRow row;
			for (int i=0; i<coll.size(); i++)
			{
				CarePlanTemplate template = coll.get(i);
				row = form.layerControl().tab1().gridCarePlan().getRows().newRow();
				row.setColCPTitle(template.getTitle());
				row.setValue(template);
			}
		}
		form.getLocalContext().setTemplates(coll);
	}
	
	
	protected void onCheckBoxYesValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.checkBoxYes().getValue() == true)
		{
			form.layerControl().showtab1();
			form.layerControl().tab1().textSearchCriteria().setFocus();
		}
		else
		{	
			form.layerControl().showtab2();
			form.layerControl().tab2().textNewTitle().setFocus();
		}
	}
	
	protected void onBNextClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.checkBoxYes().getValue() == true)  // Create from Template
		{
			// Ensure that only one row has been selected
			int count=0, lastRowSelected=0;
			GenForm.layerControlLayer.tab1Container.gridCarePlanRow row;
			for (int i=0; i<form.layerControl().tab1().gridCarePlan().getRows().size(); i++)
			{
				row = form.layerControl().tab1().gridCarePlan().getRows().get(i);
				if (row.getColSel())
				{
					count++;
					lastRowSelected=i;  // If only one selected, we have the row to retrieve again
				}
			}
			if (count == 0)
			{
				engine.showMessage("Please select a Care Plan Template.");
				return;
			}
			else if (count > 1)
			{
				engine.showMessage("Only one Template can be selected for Care Plan creation.");
				return;
			}
			
			// Put the items into the global context and call out to the step2 form
			CarePlanTemplate template = form.layerControl().tab1().gridCarePlan().getRows().get(lastRowSelected).getValue();
			form.getGlobalContext().COE.setCarePlanTitle(template.getTitle());
			form.getGlobalContext().COE.setCarePlanObjective(template.getObjectives().get(0).getObjective());
			form.getGlobalContext().COE.setCarePlanTemplateTitle(template);

			// Store the search criteria in the local context in case the previous
			// button is selected in step2
			if (form.layerControl().tab1().Group1().getValue().equals(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonBeginsWith))
				form.getGlobalContext().COE.CarePlan.setSearchToggle("B");
			else if (form.layerControl().tab1().Group1().getValue().equals(GenForm.layerControlLayer.tab1Container.Group1Enumeration.radioButtonContains))
				form.getGlobalContext().COE.CarePlan.setSearchToggle("C");
			else
				form.getGlobalContext().COE.CarePlan.setSearchToggle("E");
			form.getGlobalContext().COE.CarePlan.setSearchCriteria(form.layerControl().tab1().textSearchCriteria().getValue());
			form.getGlobalContext().COE.CarePlan.setCarePlanTemplates(form.getLocalContext().getTemplates());

		}
		else
		{
			// Ensure the text boxes are not blank.
			if (form.layerControl().tab2().textNewTitle().getValue() == null ||
				form.layerControl().tab2().textNewObjective().getValue() == null)
			{
				engine.showMessage("Title and Objective are mandatory.");
				return;
			}
			
			// Put the items into the global context and call out to the step2 form
			form.getGlobalContext().COE.setCarePlanObjective(form.layerControl().tab2().textNewObjective().getValue());
			form.getGlobalContext().COE.setCarePlanTitle(form.layerControl().tab2().textNewTitle().getValue());
			form.getGlobalContext().COE.setCarePlanTemplateTitle(null);
			form.getGlobalContext().COE.CarePlan.setSearchCriteria(null);
			form.getGlobalContext().COE.CarePlan.setCarePlanTemplates(null);
			form.getGlobalContext().COE.CarePlan.setSearchToggle(null);
		}

		engine.open(form.getForms().Nursing.CarePlanStep2);
	}
	
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.CarePlanOverview);
	}
}
