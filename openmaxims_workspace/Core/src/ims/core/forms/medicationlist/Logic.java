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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.20 build 40902.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.medicationlist;

import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.admin.helper.Keywords;
import ims.core.vo.KeywordVo;
import ims.core.vo.KeywordVoCollection;
import ims.core.vo.MedicationLiteVo;
import ims.core.vo.MedicationLiteVoCollection;
import ims.core.vo.MedicationVo;
import ims.core.forms.medicationlist.GenForm.grdExternalRow;
import ims.core.forms.medicationlist.GenForm.grdKeywordsRow;
import ims.core.forms.medicationlist.GenForm.grdMedicationRow;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}

	public void initialize()
	{
		form.setMode(FormMode.VIEW);
		form.txtMedSearch().setFocus();
		setContextMenuTexts();
	}	

	public void open()
	{
	}

	private void setContextMenuTexts()
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Taxonomy");		
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit Taxonomy");
		form.getContextMenus().getGenericGridRemoveItem().setText("Remove Taxonomy");
	}
	
	protected void onBtnCancelClick() 
	{
		clearInstanceControls();
		if (form.grdMedication().getSelectedRow() != null)
		{
			setInstanceDetails(form.grdMedication().getSelectedRow().getValue());
		}
		form.setMode(FormMode.VIEW);
	}
		
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		save();
	}
	
	private void setInstanceRowDetails(grdMedicationRow row, MedicationLiteVo vo)
	{
		row.setcolMedicationName(vo.getMedicationName());
		row.setValue(vo);			
		if (vo.getIsActiveIsNotNull() && !vo.getIsActive().booleanValue())
		{
			row.setBold(false);
			row.setTextColor(Color.Gray);
		}
		else
		{
			row.setBold(true);
			row.setTextColor(Color.Default);
		}	
	}

	private grdMedicationRow newInstanceRow(MedicationLiteVo vo)
	{
		return newInstanceRow(vo, false);
	}
	
	private grdMedicationRow newInstanceRow(MedicationLiteVo vo, boolean autoSelect)
	{
		grdMedicationRow row = form.grdMedication().getRows().newRow(autoSelect);
		setInstanceRowDetails(row, vo);		
		return row;
	}
	
	protected void onBtnUpdateClick() 
	{
		updateInstance();
	}
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		newInstance();
	}
	
	protected void onGrdMedicationSelectionChanged() 
	{
		setInstanceDetails(form.grdMedication().getValue());
	}

	private void setInstanceDetails(MedicationLiteVo voMedicationLite) 
	{
		clearInstanceControls();		
		if (voMedicationLite == null)
			return;
		
		MedicationVo voMedicationDetail = domain.getMedicationVo(voMedicationLite);		

		form.getLocalContext().setMedicationDetails(voMedicationDetail);			
		form.txtMedicationName().setValue(voMedicationDetail.getMedicationName());			
			
		if (voMedicationDetail.getIsActive() != null)
			form.chkIsActive().setValue(voMedicationDetail.getIsActive().booleanValue());			
		
		TaxonomyMapCollection coll = voMedicationDetail.getTaxonomyMap();
		if (coll != null)
		{
			form.grdExternal().getRows().clear();
				
			GenForm.grdExternalRow row = null;
			for (int i=0; i < coll.size(); i++)
			{
				row = form.grdExternal().getRows().newRow();					
				row.setcolExtCodeType(coll.get(i).getTaxonomyName());					
				row.setcolCode(coll.get(i).getTaxonomyCode());					
				row.setValue(coll.get(i));
			}
		}
		KeywordVoCollection keys = voMedicationDetail.getKeywords();
		if (keys != null)
		{
			form.grdKeywords().getRows().clear();
				
			grdKeywordsRow row = null;
			for (int i=0; i < keys.size(); i++)
			{
				row = form.grdKeywords().getRows().newRow();					
				row.setKeyword(keys.get(i).getKeyword());					
				row.setValue(keys.get(i));
			}
		}		
		updateContextMenu();
	}

	private void updateContextMenu() 
	{
		updateControlsState();
	}

	protected void onBtnSearchClick() 
	{
		if (form.txtMedSearch().getValue() == null || form.txtMedSearch().getValue().length() < 3)
		{
			engine.showMessage("Please specify a search name of at least 3 characters");
			return;				
		}		
		listMedications(form.txtMedSearch().getValue());
		updateContextMenu();
	}
	
	/**
	 * @param szSearchCriteria
	 */
	private void listMedications(String szSearchCriteria) 
	{
		form.grdMedication().getRows().clear();
		clearInstanceControls();
		
		MedicationLiteVoCollection rcColl;
		try 
		{
			rcColl = domain.listMedicationIncludeInactive(szSearchCriteria);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}		
		if (rcColl.size() == 0) 
		{
			engine.showMessage("No matching Medications found");
			return;
		}

		for (int i = 0; i< rcColl.size(); i++)
		{
			newInstanceRow(rcColl.get(i));
		}
		if (rcColl.size() == 1)
		{
			form.grdMedication().setValue(rcColl.get(0));
			onGrdMedicationSelectionChanged();			
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if ( (formName.equals(form.getForms().Core.TaxonomySearch)) && (result.equals(DialogResult.OK)) )
		{
			if(form.getGlobalContext().Core.getTaxonomyMapIsNotNull())
			{
				TaxonomyMap voTaxonomyMap = form.getGlobalContext().Core.getTaxonomyMap();
				grdExternalRow row = form.grdExternal().getRowByValue(voTaxonomyMap);
				if ((row == null) && (form.grdExternal().getSelectedRowIndex() >= 0))
					row = form.grdExternal().getRows().get(form.grdExternal().getSelectedRowIndex());
				else
				{
					engine.showMessage("Please select an External Code row and try again.");
					return;
				}
				
				populateTaxonomy(row, voTaxonomyMap);
					
				//Check if the user wants to change the name of the Procedure
				if(!voTaxonomyMap.getDescription().equals(form.txtMedicationName().getValue()))
				{
					form.getGlobalContext().Core.setYesNoDialogMessage("Do you want to call the Medication - " + voTaxonomyMap.getDescription() + " ?");
					engine.open(form.getForms().Core.YesNoDialog);
				}
				updateContextMenu();
			}
		}
		
		else if ( (formName.equals(form.getForms().Core.YesNoDialog)) && (result.equals(DialogResult.YES)) )
		{
			//Change the name of the Procedure as the one from the Taxonomy Search
			form.txtMedicationName().setValue(form.getGlobalContext().Core.getTaxonomyMap().getDescription());
			updateContextMenu();
		}		
	}
		
	protected void onGrdExternalSelectionChanged() throws PresentationLogicException
	{
		updateContextMenu();
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				addTaxonomy();					
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateTaxonomy();
				break;
			case GenForm.ContextMenus.GenericGrid.Remove:
				removeTaxonomy();			
				break;
			case GenForm.ContextMenus.KeywordAdmin.Add:
				addKeyword();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Remove:
				form.grdKeywords().removeSelectedRow();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveUp:
				form.grdKeywords().moveUp();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveDown:
				form.grdKeywords().moveDown();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.RemoveAll:
				form.grdKeywords().getRows().clear();
				updateControlsState();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Restore:
				setDefaultKeywords();
				updateControlsState();
				break;								
		}
		
	}
	
	private void setDefaultKeywords()
	{
		form.grdKeywords().getRows().clear();
		String[] keys = Keywords.generateKeywords(form.txtMedicationName().getValue());
		for (int i = 0; i < keys.length; i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().newRow();
			row.setValue(new KeywordVo());
			row.setKeyword(keys[i]);
		}
	}

	private void addKeyword()
	{
		form.grdKeywords().getRows().newRow(true).setValue(new KeywordVo());
	}

	protected void onFormModeChanged() 
	{
		updateContextMenu();
		
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.txtMedicationName().setEnabled(form.getLocalContext().getMedicationDetailsIsNotNull() &&
												form.getLocalContext().getMedicationDetails().getID_Medication() == null);
		}
		
		
	}
	
	private void addTaxonomy() 
	{
		form.grdExternal().getRows().newRow(true).setValue(new TaxonomyMap());
		updateContextMenu();
	}
	
	private void populateTaxonomy(grdExternalRow row, TaxonomyMap voTaxonomyMap) 
	{
		if(row != null && voTaxonomyMap != null)
		{
			row.setcolExtCodeType(voTaxonomyMap.getTaxonomyName());
			row.setcolCode(voTaxonomyMap.getTaxonomyCode());
			row.setValue(voTaxonomyMap);
		}
	}
	
	private void updateTaxonomy() 
	{
		if (form.grdExternal().getSelectedRow() != null)
			taxonomySearch(form.grdExternal().getSelectedRow());
	}
	
	private void removeTaxonomy()
	{
		form.grdExternal().removeSelectedRow();
		updateContextMenu();
	}
	
	protected void onGrdExternalGridButtonClicked(int column, grdExternalRow row)
	{
		if(form.getMode().equals(FormMode.EDIT))
			taxonomySearch(row);
		
	}

	private void taxonomySearch(grdExternalRow row)
	{
		if(row.getcolExtCodeType() == null)
		{
			engine.showMessage("Please select External Code Type");
			return;
		}
				
		form.getGlobalContext().Core.setTaxonomySearchForName(form.txtMedicationName().getValue());
		TaxonomyMap voTaxonomyMap = row.getValue();
		if(voTaxonomyMap == null)
			voTaxonomyMap = new TaxonomyMap();
		
		voTaxonomyMap.setTaxonomyName(row.getcolExtCodeType());
		voTaxonomyMap.setTaxonomyCode(row.getcolCode());
		
		form.getGlobalContext().Core.setTaxonomyMap(voTaxonomyMap);		
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	protected void onGrdKeywordsSelectionChanged() throws PresentationLogicException
	{
		updateContextMenu();
	}

	public void clearInstanceControls()
	{
		form.txtMedicationName().setValue(null);
		form.chkIsActive().setValue(false);
		form.grdExternal().getRows().clear();
		form.grdKeywords().getRows().clear();
	}

	public void newInstance()
	{
		String searchString = form.txtMedSearch().getValue();
		form.getLocalContext().setMedicationDetails(new MedicationVo());
		form.grdMedication().setValue(null);
		clearInstanceControls();
		form.chkIsActive().setValue(true);	
		form.txtMedicationName().setValue(searchString);
		if (form.grdMedication().getRows().size() > 0)
			form.txtMedicationName().setValue(null);
		form.txtMedicationName().setFocus();
		form.setMode(FormMode.EDIT);
	}

	public boolean save()
	{
		MedicationVo voMedicationDetails = form.getLocalContext().getMedicationDetails();
		if (voMedicationDetails == null) voMedicationDetails = new MedicationVo();

		voMedicationDetails.setMedicationName(form.txtMedicationName().getValue());		
		voMedicationDetails.setIsActive(new Boolean(form.chkIsActive().getValue()));		
			
		
		TaxonomyMapCollection voCollTaxonomyMapCollection =  new TaxonomyMapCollection();
		for (int i = 0; i < form.grdExternal().getRows().size(); i++)
		{
			grdExternalRow row = form.grdExternal().getRows().get(i);
			TaxonomyMap voTaxonomyMap = row.getValue() != null?row.getValue():new TaxonomyMap();
			voTaxonomyMap.setTaxonomyCode(row.getcolCode());			
			voTaxonomyMap.setTaxonomyName(row.getcolExtCodeType());
			voCollTaxonomyMapCollection.add(voTaxonomyMap);
		}
		voMedicationDetails.setTaxonomyMap(voCollTaxonomyMapCollection);
		
		KeywordVoCollection coll =  new KeywordVoCollection();
		for (int i = 0; i < form.grdKeywords().getRows().size(); i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().get(i);
			KeywordVo vo = row.getValue();
			if (vo == null)
				vo = new KeywordVo();
			if (row.getKeyword() == null || row.getKeyword().equals(""))
				continue;
			
			vo.setKeyword(row.getKeyword());
			coll.add(vo);
		}
		voMedicationDetails.setKeywords(coll);
		
		String[] arrErrors = voMedicationDetails.validate();
		if(arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return false;
		}
		
		try
		{
			voMedicationDetails = domain.saveMedicationVo(voMedicationDetails);
		} 
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			onBtnCancelClick();
			return false;
		} 
		catch(UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}

		grdMedicationRow row = form.grdMedication().getRowByValue(voMedicationDetails);		
		if (row == null)
		{
			form.txtMedSearch().setValue(null);
			form.grdMedication().getRows().clear();
			newInstanceRow(voMedicationDetails, true);
		}
		else
		{
			setInstanceRowDetails(row, voMedicationDetails);
		}
		form.setMode(FormMode.VIEW);
		setInstanceDetails(voMedicationDetails);		
		return true;
	}

	public void updateControlsState()
	{
		boolean editMode  = form.getMode().equals(FormMode.EDIT);
		boolean editable  = form.grdExternal().getValue() != null && editMode;
		boolean removable = form.grdExternal().getSelectedRowIndex()>=0 && editMode;
		
		form.getContextMenus().getGenericGridAddItem().setVisible(editMode);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(editable);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(removable);
		
		boolean keywordSelected = (form.grdKeywords().getSelectedRow() != null);
		form.getContextMenus().getKeywordAdminAddItem().setVisible(editMode);
		form.getContextMenus().getKeywordAdminMoveDownItem().setVisible(editMode && form.grdKeywords().canMoveCurrentDown());
		form.getContextMenus().getKeywordAdminMoveUpItem().setVisible(editMode && form.grdKeywords().canMoveCurrentUp());
		form.getContextMenus().getKeywordAdminRemoveAllItem().setVisible(editMode && form.grdKeywords().getRows().size() > 0);

		form.getContextMenus().getKeywordAdminRestoreItem().setVisible(editMode && form.txtMedicationName().getValue() != null);
		if (form.getLocalContext().getMedicationDetails() != null && form.getLocalContext().getMedicationDetails().getID_Medication() != null)
			form.getContextMenus().getKeywordAdminRestoreItem().setText("Restore defaults");
		else
			form.getContextMenus().getKeywordAdminRestoreItem().setText("Set to default");
		
		form.getContextMenus().getKeywordAdminRemoveItem().setVisible(editMode && keywordSelected);

		if(form.getMode().equals(FormMode.VIEW))
		{
			// sets the update button to be enabled if there is a record selected
			form.btnUpdate().setVisible(true);			
			form.btnUpdate().setEnabled(form.grdMedication().getSelectedRow() != null);
		}		
		
	}

	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}
}
