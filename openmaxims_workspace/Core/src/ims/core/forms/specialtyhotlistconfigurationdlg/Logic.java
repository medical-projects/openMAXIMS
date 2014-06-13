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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2327.14692)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.specialtyhotlistconfigurationdlg;

import ims.clinicaladmin.vo.CancerImagingHotlistItemVo;
import ims.clinicaladmin.vo.DiagnosisHotlistItemVo;
import ims.clinicaladmin.vo.ProblemHotlistItemVo;
import ims.clinicaladmin.vo.ProcedureHotlistItemVo;
import ims.clinicaladmin.vo.enums.CciType;
import ims.core.forms.specialtyhotlistconfigurationdlg.GenForm.grdItemsRow;
import ims.core.forms.specialtyhotlistconfigurationdlg.GenForm.grdSelectedItemsRow;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.vo.ValueObject;
import ims.vo.interfaces.IGenericItem;
import ims.vo.interfaces.IHotlist;
import ims.vo.interfaces.IHotlistItem;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	
	private void initialize() 
	{
		if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("P"))
		{
			form.getLocalContext().setCurrentCciType(CciType.PROCEDURE);
			form.grdItems().setcolItemsCaption("Procedure");
			form.grdSelectedItems().setcolItemsCaption("Selected Procedures");		
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("D"))
		{
			form.getLocalContext().setCurrentCciType(CciType.DIAGNOSIS);
			form.grdItems().setcolItemsCaption("Diagnosis");
			form.grdSelectedItems().setcolItemsCaption("Selected Diagnosis");
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("PR"))
		{
			form.getLocalContext().setCurrentCciType(CciType.PROBLEM);
			form.grdItems().setcolItemsCaption("Problem");
			form.grdSelectedItems().setcolItemsCaption("Selected Problem");
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("C"))
		{
			form.getLocalContext().setCurrentCciType(CciType.CANCERIMAGE);
			form.grdItems().setcolItemsCaption("Cancer Imaging Event");
			form.grdSelectedItems().setcolItemsCaption("Selected Cancer Imaging Event");
		}
		else
		{
			throw new DomainRuntimeException("Unexpected PMHConfigSearchType in 'initialise' = " + form.getGlobalContext().Clinical.getPMHConfigSearchType());
		}
	}

	private void open() 
	{		
		form.getLocalContext().setSelectedInstance(form.getGlobalContext().Clinical.getSpecialtyHotlistConfigurationVo());
		populateInstanceControls((IHotlist)form.getGlobalContext().Clinical.getSpecialtyHotlistConfigurationVo());		
		
		form.txtSearch().setFocus();
		form.grdItems().setEnabled(true);
		form.grdItems().setReadOnly(false);

		updateControlsState();
	}
	
	private void populateInstanceControls(IHotlist iHotlist) 
	{
		if (iHotlist == null) return;
		
		// set the specialty combo at the top of the screen to the global context hotlist specialty
		form.cmbSpecialty().newRow(iHotlist.getISpecialty(), iHotlist.getISpecialty().getText());
		form.cmbSpecialty().setValue(iHotlist.getISpecialty());

		if (iHotlist.getIHotlistItems() == null ) return;
		
		// populate the hotlist items grid
		for (int x=0; x< iHotlist.getIHotlistItems().length; x++)
		{
			GenForm.grdSelectedItemsRow newRow = form.grdSelectedItems().getRows().newRow();
			newRow.setValue(iHotlist.getIHotlistItems()[x]);			
			newRow.setcolItems(iHotlist.getIHotlistItems()[x].getIGenericItem().getIGenericItemInfoName());			
		}
	}
	
	private void updateControlsState() 
	{
		boolean itemsExist = form.grdSelectedItems().getRows().size() > 0;
		boolean itemSelected = form.grdSelectedItems().getSelectedRowIndex() >= 0;
		form.getContextMenus().getDPPSelectedListMOVEDOWNItem().setVisible(itemsExist && form.grdSelectedItems().canMoveCurrentDown());
		form.getContextMenus().getDPPSelectedListMOVEUPItem().setVisible(itemsExist && form.grdSelectedItems().canMoveCurrentUp());
		form.getContextMenus().getDPPSelectedListREMOVEItem().setVisible(itemsExist && itemSelected);
		form.getContextMenus().getDPPSelectedListREMOVEALLItem().setVisible(form.grdSelectedItems().getRows().size() > 1);
		form.getContextMenus().getDPPListSELECTALLItem().setVisible(form.grdItems().getRows().size() > 0 &&	!(allRowSelected()));		
		form.getContextMenus().getDPPListDESELECTALLItem().setVisible(someRowsSelected());
	}
	
	private boolean allRowSelected() 
	{
		boolean boolAllSelected = true;
		for (int x=0; x < form.grdItems().getRows().size(); x++)
		{
			if (form.grdItems().getRows().get(x).getColumnSelect() == false)
			{
				boolAllSelected = false;
				break;
			}
		}
		return boolAllSelected;
	}
	
	private boolean someRowsSelected()
	{
		int nSelectedCount=0;
		for (int x=0; x < form.grdItems().getRows().size(); x++)
		{
			if (form.grdItems().getRows().get(x).getColumnSelect() == true)
			{
				if (++nSelectedCount > 1 )
					break;
			}
		}
		return (nSelectedCount > 0 );	//wdev-11050	
	}
	
	protected void onImbClearClick() throws PresentationLogicException 
	{
		clearItemsGrid();
		//wdev-11050
		updateControlsState();
		//-----------
	}
	
	private void clearItemsGrid() 
	{
		form.txtSearch().setValue("");
		form.grdItems().getRows().clear();
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();				
	}
	
	private void search() 
	{
		form.grdItems().getRows().clear();
		IGenericItem[] coll = searchAndDisplayIGenericItems(form.txtSearch().getValue());
		displayIGenericItemCollection(coll);
		updateControlsState();		
	}
	
	/**
	 * Calls the domain function to list the relevant IGenericItems
	 * @param strSearch
	 * @return
	 */
	private IGenericItem[] searchAndDisplayIGenericItems(String strSearch) 
	{
		IGenericItem[] coll = null;
		try 
		{
			coll = domain.listIGenericItems(strSearch, form.getLocalContext().getCurrentCciType());
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return null;
		}
		
		if(coll == null || coll.length == 0)
		{
			engine.showMessage("No records found !");
			return null;
		}
		
		return coll;
	}
	
	/**
	 * Displays a list of IGenericItems in grdItems, if they do not already exist in grdSelectedItems
	 * @param IGenericItem[]
	 * @return void
	 */
	private void displayIGenericItemCollection(IGenericItem[] collIGenericItem)
	{ 
		if ( collIGenericItem == null )
			return;
		
		IHotlistItem[] collSelectedHotlistItems = listSelectedIHotlistItems();
		
		for(int i=0; i < collIGenericItem.length; i++)
		{
			boolean bFound = false;
			// Only add searched procedures to the list that don't already exist
			for (int j=0; j < collSelectedHotlistItems.length; j++)
			{
				if (collIGenericItem[i].getIGenericItemInfoID().equals(collSelectedHotlistItems[j].getIGenericItem().getIGenericItemInfoID()))				
				{
					bFound = true;
					break;
				}				
			}
			
			if (bFound == false)
			{
				IHotlistItem[] collExistingHotlistItems = ((IHotlist)form.getLocalContext().getSelectedInstance()).getIHotlistItems();
				IHotlistItem iHotlistItem = newIHotlistItem();
				boolean bExisting = false;
				// The procedure hasn't been found in the group of selected procedures. Check whether it exists in the currently
				// persisted collection and use that ProcedureItemHotlistVo instance if it is.
				for (int j=0; j < collExistingHotlistItems.length; j++)
				{
					if (collIGenericItem[i].getIGenericItemInfoID().equals(collExistingHotlistItems[j].getIGenericItem().getIGenericItemInfoID()))
					{
						iHotlistItem = collExistingHotlistItems[j];
						bExisting = true;
						break;
					}
				}
				
				if (bExisting == false)
				{
					iHotlistItem.setIGenericItem(collIGenericItem[i]);
				}

				GenForm.grdItemsRow newRow = form.grdItems().getRows().newRow();
				newRow.setcolItems(iHotlistItem.getIGenericItem().getIGenericItemInfoName());
				newRow.setValue(iHotlistItem);		
			}
		}
		updateControlsState();
	}
	
	/**
	 * Returns a new IHotlistItem based on the instance type of the local context. 
	 * @param void
	 * @return IHotlistItem
	 */
	private IHotlistItem newIHotlistItem() 
	{
		if ( form.getLocalContext().getCurrentCciType().equals(CciType.PROBLEM) )
			return new ProblemHotlistItemVo();
		else if ( form.getLocalContext().getCurrentCciType().equals(CciType.PROCEDURE) )
			return new ProcedureHotlistItemVo();
		else if ( form.getLocalContext().getCurrentCciType().equals(CciType.DIAGNOSIS) )
			return new DiagnosisHotlistItemVo();
		else if ( form.getLocalContext().getCurrentCciType().equals(CciType.CANCERIMAGE) )
			return new CancerImagingHotlistItemVo();
		else
			throw new DomainRuntimeException("Unknown CCI type in newIHotlistItem");
	}

	/**
	 * Returns a collection of IHotlistItems based on what is currently in the selected items grid
	 * @param void
	 * @return IGenericItem[]
	 */
	private IHotlistItem[] listSelectedIHotlistItems()
	{
		IHotlistItem[] collIHotlistItem = new IHotlistItem[form.grdSelectedItems().getRows().size()];
		for (int x=0; x < form.grdSelectedItems().getRows().size(); x++)
			collIHotlistItem[x] = (IHotlistItem)form.grdSelectedItems().getRows().get(x).getValue();
		return collIHotlistItem;
	}
	
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addItemToSelectedItems();
		//wdev-11050
		updateControlsState();
		//--------
	}
	
	/**
	 * Loops through grdItems adding any records with checked boxes to the grid
	 * @param void
	 * @return void
	 */
	private void addItemToSelectedItems() 
	{
		for(int i = 0; i < form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);
			
			if(row.getColumnSelect() == false)
				continue;
			
			boolean bFound = false;
			
			//ensure that the item isn't already in the selected items list
			for (int j = 0; j < form.grdSelectedItems().getRows().size(); j++)
			{
				if(row.getValue().equals(form.grdSelectedItems().getRows().get(j).getValue()))
				{
					bFound = true;
					break;
				}
			}
			
			if(bFound == false)
			{
				grdSelectedItemsRow selRow = form.grdSelectedItems().getRows().newRow();
				selRow.setValue(row.getValue());	
				selRow.setcolItems(row.getcolItems());
				form.grdItems().getRows().remove(i);
				i--; // WDEV-2849 now that the record is removed, the index of the next row reverts to the previous number. 
			}
		}
	}
	
	protected void onBtSaveClick() throws PresentationLogicException 
	{
		if (save())
		{
			form.getGlobalContext().Clinical.setSpecialtyHotlistConfigurationVo(form.getLocalContext().getSelectedInstance());
			engine.close(DialogResult.OK);
		}
	}

	/**
	 * Attempts to save an IHotlist populated from the screen data
	 * @param void
	 * @return boolean
	 */
	private boolean save() 
	{
		IHotlist iHotlist = (IHotlist) form.getGlobalContext().Clinical.getSpecialtyHotlistConfigurationVo().clone();
		iHotlist.setIHotlistItems(listSelectedIHotlistItems());
		
		//validate Vo
		String[] arrErrors =  iHotlist.iValidate(validateUIRules());	
		
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			iHotlist = domain.saveIHotlist(iHotlist, form.getLocalContext().getCurrentCciType());
			form.getLocalContext().setSelectedInstance((ValueObject)iHotlist);
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		return true;
	}
	
	public String[] validateUIRules()
	{
		String[] error = new String[1];
		if (form.grdSelectedItems().getRows().size() == 0 )		
		{
			error[0] = "You must enter at least one " + form.getLocalContext().getCurrentCciType().toString();			
		}
		else
		{
			return null;
		}
		return error;	
	}
	
	protected void onGrdSelectedItemsSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();		
	}
	
	protected void onFormModeChanged() 
	{
		updateControlsState();		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdItems()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.DPPList.SELECTALL:
					selectAllItems();					
					break;
				case GenForm.ContextMenus.DPPList.DESELECTALL:
					deSelectAllItems();
					break;
			}
		}
	
		else if (sender.equals(form.grdSelectedItems()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.DPPSelectedList.REMOVE:
					form.grdSelectedItems().removeSelectedRow();
					break;
				case GenForm.ContextMenus.DPPSelectedList.MOVEDOWN:
					form.grdSelectedItems().moveDown();
					break;
				case GenForm.ContextMenus.DPPSelectedList.MOVEUP:
					form.grdSelectedItems().moveUp();					
					break;
				case GenForm.ContextMenus.DPPSelectedList.REMOVEALL:
					form.grdSelectedItems().getRows().clear();
					break;
			}			
		}
		
		updateControlsState();		
	}
	
	private void deSelectAllItems() 
	{
		setAllItemsSelection(false);		
	}

	private void selectAllItems() 
	{
		setAllItemsSelection(true);		
	}
	
	private void setAllItemsSelection(boolean bSelection) 
	{
		for(int i = 0; i < form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);			
			row.setColumnSelect(bSelection);
		}
	}
}
