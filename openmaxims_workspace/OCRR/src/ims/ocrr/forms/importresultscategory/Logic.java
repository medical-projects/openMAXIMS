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
// This code was generated by Peter Martin using IMS Development Environment (version 1.66 build 3243.27592)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.importresultscategory;

import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.LookupHelper;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.ocrr.forms.importresultscategory.GenForm.grdCategoryRow;
import ims.ocrr.vo.ImportResultsConfigVo;
import ims.ocrr.vo.lookups.CategoryCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		
		open();
	}
	private void open() {
		form.grdCategory().getRows().clear();
		
		CategoryCollection lkpCollCategory = LookupHelper.getCategory(domain.getLookupService());
		ImportResultsConfigVo  voImportResultsConfig = domain.getImportResultsConfig();
		
		form.getLocalContext().setImportResultsConfigVo(voImportResultsConfig);
		
		if(lkpCollCategory!=null)
			for (int i = 0 ; i < lkpCollCategory.size() ; i++)
			{
				grdCategoryRow row = form.grdCategory().getRows().newRow();
				
				row.setColCategory(lkpCollCategory.get(i).getText());
				
				row.setValue(lkpCollCategory.get(i));
			}
		
		if(voImportResultsConfig!=null)
			for (int i = 0 ; i < voImportResultsConfig.getCategories().size() ; i++)
			{
				selectCategory(voImportResultsConfig.getCategories().get(i));
			}
		
	}
	private void selectCategory(Category value) {
			
		for (int i = 0 ; i < form.grdCategory().getRows().size() ; i++)
		{
			grdCategoryRow row = form.grdCategory().getRows().get(i);
			if(row.getValue().equals(value)){
				row.setColSelect(true);
				return;
			}
		}
		
		grdCategoryRow row = form.grdCategory().getRows().newRow();
		row.setColCategory(value.getText());
		row.setColSelect(true);
		row.setValue(value);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			form.setMode(FormMode.VIEW);
			open();
		}
	}
	private boolean save() {
		ImportResultsConfigVo  voImportResultsConfig = populateInstancesData();

		String[] errors = voImportResultsConfig.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.saveImportResultsConfig(voImportResultsConfig, form.getLocalContext().getImportResultsConfigVo());
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} catch (ForeignKeyViolationException e) {
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}
	private ImportResultsConfigVo populateInstancesData() {
		
		ImportResultsConfigVo  voImportResultsConfig = new ImportResultsConfigVo();

		CategoryCollection  collCategory = new CategoryCollection();
		for (int i = 0; i < form.grdCategory().getRows().size(); i++)
		{
			grdCategoryRow row = form.grdCategory().getRows().get(i);
			if(row.getColSelect())
				collCategory.add(row.getValue());
		}

		voImportResultsConfig.setCategories(collCategory);
		
		return voImportResultsConfig;
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
}
