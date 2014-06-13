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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.53 build 2663.17474)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.forms.cancerstagingclassifications;

import ims.clinicaladmin.forms.cancerstagingclassifications.GenForm.grdClassificationRow;
import ims.clinicaladmin.forms.cancerstagingclassifications.GenForm.grdTumourGroupsRow;
import ims.clinicaladmin.forms.cancerstagingclassifications.GenForm.lyrValuesLayer.tabClassificationValuesContainer.grdValuesRow;
import ims.clinicaladmin.forms.cancerstagingclassifications.GenForm.lyrValuesLayer.tabValueMappingsContainer.grdTaxonomyRow;
import ims.clinicaladmin.vo.OtherClassificationValueVo;
import ims.clinicaladmin.vo.OtherClassificationValueVoCollection;
import ims.clinicaladmin.vo.StagingClassificationVo;
import ims.clinicaladmin.vo.StagingClassificationVoCollection;
import ims.clinicaladmin.vo.TumourGroupListVo;
import ims.clinicaladmin.vo.TumourGroupListVoCollection;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.LayerBridge;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.oncology.vo.TumourGroupClassificationVo;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.chkActiveClassOnly().setValue(true);
		form.lyrValues().tabClassificationValues().chkActiveValueOnly().setValue(true);

		open();
	}

	private void open()
	{
		clearScreen();

		form.getLocalContext().setIsTgEdited(false);

		form.grdClassification().getRows().clear();
		StagingClassificationVoCollection scVoColl = domain.listStagingClassification(form.chkActiveClassOnly().getValue());
		if (scVoColl != null && scVoColl.size() > 0)
		{
			fillSCGrid(scVoColl);

			if (form.getLocalContext().getSelectStagingClassification() == null)
			{
				scSelectionChanged(form.grdClassification().getRows().get(0));
				form.grdClassification().setValue(form.grdClassification().getRows().get(0).getValue());
			}
			else
				selectSC(form.getLocalContext().getSelectStagingClassification());
		}
	}

	private void selectSC(StagingClassificationVo selectStagingClassification)
	{
		for (int i = 0; i < form.grdClassification().getRows().size(); i++)
		{
			grdClassificationRow row = form.grdClassification().getRows().get(i);
			if (row.getValue().equals(selectStagingClassification))
			{
				form.grdClassification().setValue(selectStagingClassification);
				scSelectionChanged(row);
			}
		}
	}

	private void fillSCGrid(StagingClassificationVoCollection scVoColl)
	{
		form.grdClassification().getRows().clear();

		if (scVoColl == null || scVoColl.size() == 0)
			return;

		for (int i = 0; i < scVoColl.size(); i++)
		{
			if ((scVoColl.get(i).getIsActiveIsNotNull() && scVoColl.get(i).getIsActive().booleanValue() && form.chkActiveClassOnly().getValue() == true) || form.chkActiveClassOnly().getValue() == false)
			{
				grdClassificationRow row = form.grdClassification().getRows().newRow();
				row.setColName(scVoColl.get(i).getName());
				row.setValue(scVoColl.get(i));

				row.setColActive(scVoColl.get(i).getIsActiveIsNotNull() && scVoColl.get(i).getIsActive().booleanValue() ? null : form.getImages().Core.Delete);
			}
		}
	}

	private void scSelectionChanged(grdClassificationRow row)
	{
		if (row == null)
			return;

		StagingClassificationVo scVo = domain.getStagingClassification(row.getValue());//WDEV-16567

		if (scVo == null)
			return;

		updateContextMenus();

		form.getLocalContext().setSelectStagingClassification(scVo);
		clearScreen();
		form.txtClassificationName().setValue(scVo.getName());

		if (scVo.getValues() != null && scVo.getValues().size() > 0)
		{
			for (int i = 0; i < scVo.getValues().size(); i++)
			{
				if ((scVo.getValues().get(i).getIsActiveIsNotNull() && scVo.getValues().get(i).getIsActive().booleanValue() && form.lyrValues().tabClassificationValues().chkActiveValueOnly().getValue() == true) || form.lyrValues().tabClassificationValues().chkActiveValueOnly().getValue() == false)
				{
					grdValuesRow rowValues = form.lyrValues().tabClassificationValues().grdValues().getRows().newRow();
					rowValues.setColValues(scVo.getValues().get(i).getName());
					rowValues.setValue(scVo.getValues().get(i));

					rowValues.setColActive(scVo.getValues().get(i).getIsActiveIsNotNull() && scVo.getValues().get(i).getIsActive().booleanValue() ? null : form.getImages().Core.Delete);
				}
			}
		}

		loadTumourGroupForClassification(scVo);
	}

	private void loadTumourGroupForClassification(StagingClassificationVo scVo)
	{
		form.grdTumourGroups().getRows().clear();

		TumourGroupListVoCollection tumourVoColl = domain.listTumourGroupForClassification(scVo);
		if (tumourVoColl != null && tumourVoColl.size() > 0)
		{
			for (int j = 0; j < tumourVoColl.size(); j++)
			{
				grdTumourGroupsRow rowTumour = form.grdTumourGroups().getRows().newRow();
				rowTumour.setColValues(tumourVoColl.get(j).getGroupName());
				rowTumour.setValue(tumourVoColl.get(j));
			}
		}
	}

	private void clearScreen()
	{
		form.txtClassificationName().setValue(null);
		form.lyrValues().tabClassificationValues().grdValues().getRows().clear();
		form.lyrValues().tabValueMappings().txtValue().setValue(null);
		form.lyrValues().tabValueMappings().grdTaxonomy().getRows().clear();
		form.grdTumourGroups().getRows().clear();
		form.lyrValues().showtabClassificationValues();
	}

	private void populateDataFromScreen()
	{
		StagingClassificationVo saveSC = form.getLocalContext().getSelectStagingClassification();
		if (saveSC == null)
			saveSC = new StagingClassificationVo();

		saveSC.setName(form.txtClassificationName().getValue());

		if (saveSC.getIsActive() == null)
			saveSC.setIsActive(true);

		OtherClassificationValueVoCollection collVo = null;
		if (saveSC.getValues() == null || saveSC.getID_StagingClassification() == null)// always create a new collection its not saved yet.
		// May have tried to save and got a validation error eg no Name value
		// then removed the row and saved again....but blank row is now in the collection to be saved and unremoveable.
		{
			collVo = new OtherClassificationValueVoCollection();
			saveSC.setValues(collVo);
		}
		else
			collVo = saveSC.getValues();

		for (int i = 0; i < form.lyrValues().tabClassificationValues().grdValues().getRows().size(); i++)
		{
			OtherClassificationValueVo ocVo = new OtherClassificationValueVo();
			grdValuesRow row = form.lyrValues().tabClassificationValues().grdValues().getRows().get(i);

			if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRow() != null && row.getValue().equals(form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue()))
			{
				populateValuesTaxonomyMap();

				ocVo = row.getValue();
				ocVo.setName(row.getColValues() != null ? row.getColValues().toString() : "");
			}
			else
			{
				ocVo = row.getValue();

				ocVo.setName(row.getColValues() != null ? row.getColValues().toString() : "");
			}

			if (ocVo.getIsActive() == null)
				ocVo.setIsActive(true);

			boolean bFound = false;
			for (int j = 0; j < collVo.size(); j++)
			{
				if (collVo.get(j).getID_OtherClassificationValueIsNotNull() && ocVo.getID_OtherClassificationValueIsNotNull() && collVo.get(j).getID_OtherClassificationValue().equals(ocVo.getID_OtherClassificationValue()))
				{
					bFound = true;
					collVo.set(j, ocVo);
				}
			}
			if (bFound == false)
				collVo.add(ocVo);
		}

		// remove any records in the collection that have a blank Name in it and are unsaved so far
		for (int k = 0; k < collVo.size(); k++)
		{
			if (collVo.get(k).getID_OtherClassificationValue() == null && (collVo.get(k).getName() == null || collVo.get(k).getName() == ""))
			{
				collVo.remove(k);
				k = 0;
			}
		}

		saveSC.setValues(collVo);

		form.getLocalContext().setSelectStagingClassification(saveSC);
	}

	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().ClinicalAdmin.TumourGroupSelect) && result.equals(DialogResult.OK))
		{
			displayChosenTumourGroup();
			form.getLocalContext().setIsTgEdited(true);
		}
		else if (formName.equals(form.getForms().Core.TaxonomySearch) && result.equals(DialogResult.OK))
		{
			TaxonomyMap taxonomyMap = form.getGlobalContext().Core.getTaxonomyMap();
			if (taxonomyMap != null)
			{
				if (form.lyrValues().tabClassificationValues().isVisible())
				{
					OtherClassificationValueVo ocVo = new OtherClassificationValueVo();
					TaxonomyMapCollection collVo = new TaxonomyMapCollection();
					collVo.add(taxonomyMap);
					ocVo.setTaxonomyMap(collVo);

					grdValuesRow row = form.lyrValues().tabClassificationValues().grdValues().getRows().newRow();
					row.setValue(ocVo);
					row.setColValues(taxonomyMap.getDescription());
					form.lyrValues().tabClassificationValues().grdValues().setValue(ocVo);

					form.lyrValues().tabValueMappings().grdTaxonomy().getRows().clear();
					grdTaxonomyRow rowT = form.lyrValues().tabValueMappings().grdTaxonomy().getRows().newRow();
					rowT.setValue(taxonomyMap);
					rowT.setColExternalCodeType(taxonomyMap.getTaxonomyName());
					rowT.setColValue(taxonomyMap.getTaxonomyCode());
				}
				else
				{
					grdTaxonomyRow row = form.lyrValues().tabValueMappings().grdTaxonomy().getRows().newRow();
					row.setValue(taxonomyMap);
					row.setColExternalCodeType(taxonomyMap.getTaxonomyName());
					row.setColValue(taxonomyMap.getTaxonomyCode());
				}
			}
		}
	}

	private void displayChosenTumourGroup()
	{
		form.grdTumourGroups().getRows().clear();
		for (int j = 0; j < form.getGlobalContext().ClinicalAdmin.getChosenTumourGroupListVoCollection().size(); j++)
		{
			TumourGroupListVo tgVo = form.getGlobalContext().ClinicalAdmin.getChosenTumourGroupListVoCollection().get(j);
			grdTumourGroupsRow rowTumour = form.grdTumourGroups().getRows().newRow();
			rowTumour.setColValues(tgVo.getGroupName());
			rowTumour.setValue(tgVo);
		}
	}

	protected void onFormModeChanged()
	{
		updateContextMenus();

	}

	private void updateContextMenus()
	{
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().Oncology.hideAllStagingClassificationMenuItems();
		form.getContextMenus().hideAllAddContactMenuItems();
		form.getContextMenus().Oncology.hideAllTumourFindingMenuItems();

	

		if (form.getMode().equals(FormMode.EDIT))
		{
			// Main grid
			form.getContextMenus().getGenericGridAddItem().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);

			// Classification
			form.getContextMenus().Oncology.getStagingClassificationAddFindingItem().setVisible(true);
			form.getContextMenus().Oncology.getStagingClassificationRemoveFindingItem().setVisible(false);
			form.getContextMenus().Oncology.getStagingClassificationSelectFindingItem().setVisible(true);

			if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex() >= 0)
			{
				form.getContextMenus().Oncology.getStagingClassificationRemoveFindingItem().setVisible(true);

				if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue() != null && form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue().getIsActiveIsNotNull() && !form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue().getIsActive())
				{
					form.getContextMenus().Oncology.getStagingClassificationREACTIVATEItem().setVisible(true);
					form.getContextMenus().Oncology.getStagingClassificationRemoveFindingItem().setVisible(false);			//wdev-13095
				}
			}

			// Mappings
			form.getContextMenus().Oncology.getTumourFindingADDItem().setVisible(form.lyrValues().tabClassificationValues().grdValues().getSelectedRow() != null ? true : false);
			form.getContextMenus().Oncology.getTumourFindingRemoveItem().setVisible(false);

			int nSelectedIndex = form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex();

			if (nSelectedIndex >= 0)
				form.getContextMenus().Oncology.getTumourFindingRemoveItem().setVisible(true);

			if (nSelectedIndex > 0)
				form.getContextMenus().Oncology.getTumourFindingMoveUpItem().setVisible(true);

			if (nSelectedIndex > 0 && nSelectedIndex < form.lyrValues().tabValueMappings().grdTaxonomy().getRows().size())
				form.getContextMenus().Oncology.getTumourFindingMoveDownItem().setVisible(true);

			// Associated tumour menu
			form.getContextMenus().getAddContactNewContactItem().setVisible(true);
			form.getContextMenus().getAddContactNewContactItem().setText("Select Tumour Group");
		}
		else
		{
			form.getContextMenus().getGenericGridAddItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
			form.getContextMenus().getGenericGridUpdateItem().setEnabled(form.grdClassification().getSelectedRowIndex() >= 0 ? true : false);
			if (form.grdClassification().getSelectedRow() != null)
			{
				if (form.grdClassification().getSelectedRow().getValue().getIsActive() == false)
				{
					form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
				
				}
				else
					form.getContextMenus().getGenericGridRemoveItem().setVisible(true);
			}
			form.getContextMenus().getGenericGridRemoveItem().setEnabled(form.grdClassification().getSelectedRowIndex() >= 0 ? true : false);
			if (form.grdClassification().getSelectedRow() != null && form.grdClassification().getSelectedRow().getValue() != null && form.grdClassification().getSelectedRow().getValue().getIsActiveIsNotNull() && !form.grdClassification().getSelectedRow().getValue().getIsActive())
			{
				form.getContextMenus().getGenericGridReplaceItem().setVisible(true);
				form.getContextMenus().getGenericGridReplaceItem().setText("Re-Activate");
				form.getContextMenus().getGenericGridReplaceItem().setEnabled(form.grdClassification().getSelectedRowIndex() >= 0 ? true : false);
			}
		}
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		clearScreen();

		if (form.getLocalContext().getSelectStagingClassification() != null)
		{
			selectSC(form.getLocalContext().getSelectStagingClassification());
		}
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		save();
	}

	private void save()
	{
		if (validateData())
		{

			populateDataFromScreen();

			try
			{
				String[] errors = form.getLocalContext().getSelectStagingClassification().validate();
				if (errors != null)
				{
					engine.showErrors(errors);
					return;
				}

				form.setMode(FormMode.VIEW);
				StagingClassificationVo scVo = domain.saveStagingClassification(form.getLocalContext().getSelectStagingClassification());

				form.getLocalContext().setSelectStagingClassification(scVo);

				if (form.getLocalContext().getIsTgEdited())
					saveTumourGroups(scVo);
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			open();
		}
	}

	private void saveTumourGroups(StagingClassificationVo scVo) throws StaleObjectException
	{
		TumourGroupListVoCollection savedtumourVoColl = domain.listTumourGroupForClassification(scVo);

		for (int i = 0; i < form.grdTumourGroups().getRows().size(); i++)
		{
			boolean bFoundClass = false;

			grdTumourGroupsRow row = form.grdTumourGroups().getRows().get(i);

			if (savedtumourVoColl.contains(row.getValue()))
				bFoundClass = true;

			if (!bFoundClass)
			{
				row.getValue().setHasOtherClassifications(true);

				TumourGroupClassificationVo voTGClass = new TumourGroupClassificationVo();
				voTGClass.setClassification(form.getLocalContext().getSelectStagingClassification());
				voTGClass.setIsActive(true);

				row.getValue().getOtherClassifications().add(voTGClass);

				String[] errors = row.getValue().validate();
				if (errors != null)
				{
					engine.showErrors(errors);
					return;
				}
				domain.saveTumourGroup(row.getValue());
			}
		}

		// Now check to see if any in the saved collection are no longer in the grid.......unmarked in select dialog
		for (int j = 0; j < savedtumourVoColl.size(); j++)
		{
			boolean bFound = false;
			for (int k = 0; k < form.grdTumourGroups().getRows().size(); k++)
			{
				if (form.grdTumourGroups().getRows().get(k).getValue() != null && form.grdTumourGroups().getRows().get(k).getValue().equals(savedtumourVoColl.get(j)))				//wdev-13095
					bFound = true;
			}

			if (!bFound)
			{
				TumourGroupClassificationVo voTGClassToRemove = new TumourGroupClassificationVo();
				voTGClassToRemove.setClassification(form.getLocalContext().getSelectStagingClassification());

				for (int l = 0; l < savedtumourVoColl.get(j).getOtherClassifications().size(); l++)
				{
					if (savedtumourVoColl.get(j).getOtherClassifications().get(l).getClassification().equals(form.getLocalContext().getSelectStagingClassification()))
						savedtumourVoColl.get(j).getOtherClassifications().remove(savedtumourVoColl.get(j).getOtherClassifications().get(l));
				}

				if (savedtumourVoColl.get(j).getOtherClassifications().size() == 0)
					savedtumourVoColl.get(j).setHasOtherClassifications(false);

				String[] errors = savedtumourVoColl.get(j).validate();
				if (errors != null)
				{
					engine.showErrors(errors);
					return;
				}
				domain.saveTumourGroup(savedtumourVoColl.get(j));
			}
		}
	}

	private boolean validateData()
	{
		if (form.txtClassificationName().getValue() == null || form.txtClassificationName().getValue() == "")
		{
			engine.showMessage("Classification Name is mandatory.");//WDEV-16567, WDEV-17675
			return false;
		}
		// Any others.............

		return true;
	}

	protected void onGrdValuesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenus();

		valueSelectionChanged(form.lyrValues().tabClassificationValues().grdValues().getSelectedRow());
	}

	private void valueSelectionChanged(grdValuesRow selectedRow)
	{
		ims.clinicaladmin.vo.OtherClassificationValueVo valueVo = selectedRow.getValue();
		if (valueVo != null)
		{
			form.lyrValues().tabValueMappings().txtValue().setValue(selectedRow.getColValues() != null ? selectedRow.getColValues().toString() : "");

			form.lyrValues().tabValueMappings().grdTaxonomy().getRows().clear();
			if (valueVo.getTaxonomyMap() != null && valueVo.getTaxonomyMap().size() > 0)
			{
				for (int i = 0; i < valueVo.getTaxonomyMap().size(); i++)
				{
					grdTaxonomyRow rowTaxonomy = form.lyrValues().tabValueMappings().grdTaxonomy().getRows().newRow();
					rowTaxonomy.setColExternalCodeType(valueVo.getTaxonomyMap().get(i).getTaxonomyName());
					rowTaxonomy.setColValue(valueVo.getTaxonomyMap().get(i).getTaxonomyCode());
					rowTaxonomy.setValue(valueVo.getTaxonomyMap().get(i));
				}
			}
		}
	}

	@Override
	protected void onGrdTaxonomySelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenus();
	}

	@Override
	protected void onGrdTumourGroupsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateContextMenus();
	}

	@Override
	protected void onGrdClassificationSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		scSelectionChanged(form.grdClassification().getSelectedRow());
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if (sender.equals(form.grdClassification()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add :
					newClassification();
				break;
				case GenForm.ContextMenus.GenericGrid.Update :
					updateClassification();
				break;
				case GenForm.ContextMenus.GenericGrid.Remove :
					removeClassification();
				break;
				case GenForm.ContextMenus.GenericGrid.Replace :
					reactivateClassification();
				break;
				default :
				break;
			}
		}
		else if (sender.equals(form.lyrValues().tabClassificationValues().grdValues()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.OncologyNamespace.StagingClassification.AddFinding :
					newFinding();
				break;
				case GenForm.ContextMenus.OncologyNamespace.StagingClassification.SelectFinding :
					selectFinding();
				break;
				case GenForm.ContextMenus.OncologyNamespace.StagingClassification.RemoveFinding :
					removeFinding();
				break;
				case GenForm.ContextMenus.OncologyNamespace.StagingClassification.REACTIVATE :
					reactivateFinding();
				break;
				default :
				break;
			}
		}
		else if (sender.equals(form.lyrValues().tabValueMappings().grdTaxonomy()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.OncologyNamespace.TumourFinding.ADD :
					newTaxonomy();
				break;
				case GenForm.ContextMenus.OncologyNamespace.TumourFinding.Remove :
					removeTaxonomy();
				break;
				case GenForm.ContextMenus.OncologyNamespace.TumourFinding.MoveUp :
					moveUpTaxonomy();
				break;
				case GenForm.ContextMenus.OncologyNamespace.TumourFinding.MoveDown :
					moveDownTaxonomy();
				break;
				default :
				break;
			}
		}
		else if (sender.equals(form.grdTumourGroups()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.AddContact.NewContact :
					addTumourGroup();
				break;
				default :
				break;
			}
		}
	}

	private void reactivateClassification()
	{
		StagingClassificationVo saveSC = form.getLocalContext().getSelectStagingClassification();
		saveSC.setIsActive(true);
		form.getLocalContext().setSelectStagingClassification(saveSC);

		save();

		updateContextMenus();

	}

	private void reactivateFinding()
	{
		StagingClassificationVo saveSC = form.getLocalContext().getSelectStagingClassification();

		OtherClassificationValueVo ocVo = form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue();
		populateValuesTaxonomyMap();
		ocVo.setIsActive(true);

		for (int j = 0; j < saveSC.getValues().size(); j++)
		{
			if (saveSC.getValues().get(j).getID_OtherClassificationValueIsNotNull() && ocVo.getID_OtherClassificationValueIsNotNull() && saveSC.getValues().get(j).getID_OtherClassificationValue().equals(ocVo.getID_OtherClassificationValue()))
				saveSC.getValues().set(j, ocVo);
		}

		if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex() >= 0)
			form.lyrValues().tabClassificationValues().grdValues().getRows().get(form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex()).setColActive(null);

		updateContextMenus();

	}

	private void removeClassification()
	{
		StagingClassificationVo saveSC = form.getLocalContext().getSelectStagingClassification();
		saveSC.setIsActive(false);
		form.getLocalContext().setSelectStagingClassification(saveSC);

		save();

		updateContextMenus();

	}

	private void moveDownTaxonomy()
	{
		if (form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex() > 1)
			form.lyrValues().tabValueMappings().grdTaxonomy().moveUp();
	}

	private void moveUpTaxonomy()
	{
		if (form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex() > 0 && form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex() < form.lyrValues().tabValueMappings().grdTaxonomy().getRows().size())
			form.lyrValues().tabValueMappings().grdTaxonomy().moveUp();
	}

	private void addTumourGroup()
	{
		form.getGlobalContext().setSelectedStagingClassificationVo(form.getLocalContext().getSelectStagingClassification());
		
		form.getGlobalContext().ClinicalAdmin.setChosenTumourGroupListVoCollection(populateTumourGroupFromGrid());//WDEV-16567
		engine.open(form.getForms().ClinicalAdmin.TumourGroupSelect);
	}

	//WDEV-16567
	private TumourGroupListVoCollection populateTumourGroupFromGrid() 
	{
		if (form.grdTumourGroups().getRows()==null || form.grdTumourGroups().getRows().size()==0)
			return null;
		
		TumourGroupListVoCollection collTumourGroup=new TumourGroupListVoCollection();
		
		for (int i=0;i<form.grdTumourGroups().getRows().size();i++)
		{
			collTumourGroup.add(form.grdTumourGroups().getRows().get(i).getValue());
		}
		
		return collTumourGroup;
	}

	private void removeTaxonomy()
	{
		if (form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex() >= 0)
			form.lyrValues().tabValueMappings().grdTaxonomy().getRows().remove(form.lyrValues().tabValueMappings().grdTaxonomy().getSelectedRowIndex());

		updateContextMenus();

	}

	private void newTaxonomy()
	{
		form.getGlobalContext().Core.setTaxonomySearchForName(form.lyrValues().tabValueMappings().txtValue().getValue());
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	private void removeFinding()
	{
		StagingClassificationVo saveSC = form.getLocalContext().getSelectStagingClassification();

		if (saveSC != null)
		{
			OtherClassificationValueVo ocVo = form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue();
			populateValuesTaxonomyMap();
			ocVo.setIsActive(false);

			for (int j = 0; j < saveSC.getValues().size(); j++)
			{
				if (saveSC.getValues().get(j).getID_OtherClassificationValueIsNotNull() && ocVo.getID_OtherClassificationValueIsNotNull() && saveSC.getValues().get(j).getID_OtherClassificationValue().equals(ocVo.getID_OtherClassificationValue()))
					saveSC.getValues().set(j, ocVo);
			}
		}

		if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRow() != null)
		{
			if (form.lyrValues().tabClassificationValues().chkActiveValueOnly().getValue())
			{
				if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex() >= 0)
					form.lyrValues().tabClassificationValues().grdValues().getRows().remove(form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex());
			}
			else
			{
				if (form.lyrValues().tabClassificationValues().grdValues().getValue() == null || !form.lyrValues().tabClassificationValues().grdValues().getValue().getID_OtherClassificationValueIsNotNull())
				{
					form.lyrValues().tabClassificationValues().grdValues().getRows().remove(form.lyrValues().tabClassificationValues().grdValues().getSelectedRowIndex());
				}
				else
				{
					form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().setColActive(form.getImages().Core.Delete);
				}
			}
		}

		updateContextMenus();

	}

	private void selectFinding()
	{
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	private void newFinding()
	{
		grdValuesRow row = form.lyrValues().tabClassificationValues().grdValues().getRows().newRow();
		
		OtherClassificationValueVo otherClassification = new OtherClassificationValueVo();
		
		row.setValue(otherClassification);
	}

	private void updateClassification()
	{
		form.setMode(FormMode.EDIT);
		form.getLocalContext().setIsTgEdited(false);
		form.getLocalContext().setSelectStagingClassification(form.grdClassification().getSelectedRow().getValue());
	}

	private void newClassification()
	{
		clearScreen();

		form.setMode(FormMode.EDIT);

		form.lyrValues().showtabClassificationValues();
		form.getLocalContext().setIsTgEdited(false);
		form.getGlobalContext().setSelectedStagingClassificationVo(null);
		form.getLocalContext().setSelectStagingClassification(null);
		form.grdClassification().setValue(null);

		form.txtClassificationName().setFocus();
	}

	@Override
	protected void onlyrValuesTabChanged(LayerBridge tab)
	{
		if (form.lyrValues().tabClassificationValues().grdValues().getSelectedRow() != null)
			populateValuesTaxonomyMap();

	}

	private void populateValuesTaxonomyMap()
	{
		TaxonomyMapCollection collVo = new TaxonomyMapCollection();
		for (int i = 0; i < form.lyrValues().tabValueMappings().grdTaxonomy().getRows().size(); i++)
			collVo.add(form.lyrValues().tabValueMappings().grdTaxonomy().getRows().get(i).getValue());

		form.lyrValues().tabClassificationValues().grdValues().getSelectedRow().getValue().setTaxonomyMap(collVo);
	}

	@Override
	protected void onChkActiveClassOnlyValueChanged() throws PresentationLogicException
	{
		
		open();
		updateContextMenus();		//wdev-13095
	}

	@Override
	protected void onChkActiveValueOnlyValueChanged() throws PresentationLogicException
	{
		scSelectionChanged(form.grdClassification().getSelectedRow());
	}
}
