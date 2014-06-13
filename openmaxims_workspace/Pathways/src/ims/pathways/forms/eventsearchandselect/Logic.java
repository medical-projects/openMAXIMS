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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.60 build 2838.16667)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.forms.eventsearchandselect;

import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.pathways.forms.eventsearchandselect.GenForm.grdEventsRow;
import ims.pathways.vo.EventLiteVo;
import ims.pathways.vo.EventLiteVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();			
		search(form.getGlobalContext().Pathways.getEventSearchAndSelectFilter());
	}
	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearch();
		form.grdEvents().getRows().clear();
		form.grdEvents().setFooterValue("Total records : " + form.grdEvents().getRows().size());
		updateControlState();
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Pathways.setEventSearchAndSelectFilter(null);
		search(form.getGlobalContext().Pathways.getEventSearchAndSelectFilter());
	}
	
	private void initialize()
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Event");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit Event");
		form.getContextMenus().getGenericGridViewItem().setText("View Event");
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(null);
		
		updateControlState();
	}

	protected void onFormModeChanged()
	{
		updateControlState();
	}

	private void search(EventLiteVo filter)
	{				
		if (filter == null)
			filter = new EventLiteVo();
						
		if (!form.getGlobalContext().Pathways.getEventSearchAndSelectFilterIsNotNull())
		{
			if (form.cmbStatusSearch().getValue() == null) {
				form.cmbStatusSearch().setValue(PreActiveActiveInactiveStatus.ACTIVE);
			}
			
			if (form.txtEventNameSearch().getValue() != null)
				filter.setName(form.txtEventNameSearch().getValue());
			
			if (form.cmbStatusSearch().getValue() != null)
				filter.setStatus(form.cmbStatusSearch().getValue());
			
			form.getGlobalContext().Pathways.setEventSearchAndSelectFilter(filter);			
		}
		else
		{
			form.txtEventNameSearch().setValue(filter.getName());
			form.cmbStatusSearch().setValue(filter.getStatus());				
		}
		
		populateGridFromData(domain.listEvents(filter));
		
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.getContextMenus().getGenericGridViewItem().setVisible(false);
		form.btnEditEvent().setVisible(false);
		
		form.grdEvents().setFooterValue("Total records : " + form.grdEvents().getRows().size());
	}

	private void populateGridFromData(EventLiteVoCollection voCollEvents)
	{
		form.grdEvents().getRows().clear();
		if(voCollEvents == null || voCollEvents.size() == 0)
		{
			engine.showMessage("No matching records found");
			return;
		}
		
		for(int i=0 ; i < voCollEvents.size() ; i++)
		{
			grdEventsRow row = form.grdEvents().getRows().newRow();
			EventLiteVo voEvent = voCollEvents.get(i);
			if(voEvent != null)
			{
				row.setColName(voEvent.getNameIsNotNull() ? voEvent.getName() : "");
				row.setColDescr(voEvent.getDescriptionIsNotNull() ? voEvent.getDescription() : "");
				row.setColEventType(voEvent.getEventType());
				row.setColIcon(voEvent.getIconIsNotNull() ? engine.getRegisteredImage(voEvent.getIcon().getID_AppImage().intValue()) : null);
			
				row.setColStatus(voEvent.getStatusIsNotNull() ? voEvent.getStatus() : null);
				
				row.setValue(voEvent);
			}
		}
	}

	private void clearSearch()
	{		
		form.txtEventNameSearch().setValue(null);
		form.cmbStatusSearch().setValue(null);
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if(sender.equals(form.grdEvents()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add :
					addEvent();
				break;
				case GenForm.ContextMenus.GenericGrid.Update :
					editEvent();
				break;
				case GenForm.ContextMenus.GenericGrid.View :
					viewEvent();
				break;
				default :
				break;
			}
		}
	}

	private void viewEvent()
	{
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(form.grdEvents().getSelectedRow().getValue());
		engine.open(form.getForms().Pathways.EventConfiguration, new Object[] {FormMode.VIEW});
	}

	private void editEvent()
	{
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(form.grdEvents().getSelectedRow().getValue());
		engine.open(form.getForms().Pathways.EventConfiguration, new Object[] {FormMode.EDIT});
	}

	private void addEvent()
	{
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(null);
		engine.open(form.getForms().Pathways.EventConfiguration, new Object[] {FormMode.EDIT});
	}

	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(form.grdEvents().getValue());
		updateControlState();
	}

	private void updateControlState()
	{
		form.getContextMenus().hideAllGenericGridMenuItems();
		
		FormMode mode = form.getMode();

		if(mode.equals(FormMode.VIEW))
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridAddItem().setText("New");
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.getContextMenus().getGenericGridViewItem().setVisible(false);
			if(form.grdEvents().getValue() != null) 
			{
				if (form.grdEvents().getSelectedRow() !=null
					&&	form.grdEvents().getValue().getStatusIsNotNull()
					&& ! form.grdEvents().getValue().getStatus().equals(PreActiveActiveInactiveStatus.INACTIVE))
					form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
				
				if (form.grdEvents().getSelectedRow() !=null)
					form.getContextMenus().getGenericGridViewItem().setVisible(true);
			}
		}
		
		if (form.grdEvents().getSelectedRow() !=null
			&& form.grdEvents().getValue() != null
			&& form.grdEvents().getValue().getStatusIsNotNull()
			&& ! form.grdEvents().getValue().getStatus().equals(PreActiveActiveInactiveStatus.INACTIVE))
		{
			form.btnEditEvent().setVisible(form.grdEvents().getValue() != null);
			form.btnEditEvent().setEnabled(form.grdEvents().getValue() != null);
		}
		else
		{
			form.btnEditEvent().setVisible(false);
			form.btnEditEvent().setEnabled(false);
		}

	}
	
	@Override
	protected void onBtnNewEventClick() throws PresentationLogicException
	{
		addEvent();
	}

	@Override
	protected void onBtnEditEventClick() throws PresentationLogicException 
	{
		editEvent();
	}
	@Override
	protected void onGrdEventsSelectionChanged() throws PresentationLogicException 
	{
		form.getGlobalContext().Pathway.setSelectedEventLiteVo(form.grdEvents().getValue());
		updateControlState();
	}

}
