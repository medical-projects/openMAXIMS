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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4646.25174)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.departmenttypeconfig;

import ims.configuration.gen.ConfigFlag;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.LocationDepartmentTypesVo;
import ims.emergency.vo.lookups.DepartmentType;
import ims.emergency.vo.lookups.DepartmentTypeCollection;
import ims.emergency.vo.lookups.LookupHelper;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	public static final Integer COLDEPARTMENT = Integer.valueOf(-1);
	public static final Integer COLSELECTED = Integer.valueOf(-2);
	public static final Integer COLDEFAULT = Integer.valueOf(-3);

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void open() 
	{
		form.setMode(FormMode.VIEW);
		
		if(form.cmbEDLocation().getValue() != null)
		{
			form.getLocalContext().setSelectedInstance(domain.get(form.cmbEDLocation().getValue()));
		}
		
		populateScreenFromData(form.getLocalContext().getSelectedInstance());
		updateControlsState();
	}

	private void populateScreenFromData(LocationDepartmentTypesVo locationDepartmentTypes) 
	{
		populateDepartmentsGrid(locationDepartmentTypes);
	}

	private void populateDepartmentsGrid(LocationDepartmentTypesVo locationDepartmentTypes) 
	{
		form.dyngrdDepartments().getRows().clear();
		
		if(FormMode.EDIT.equals(form.getMode()))
		{
			populateDepartmentsGridWithDefault();
		}
		
		if(locationDepartmentTypes == null || locationDepartmentTypes.getDepartmentTypes() == null)
			return;
		
		for(int i=0; i<locationDepartmentTypes.getDepartmentTypes().size(); i++)
		{
			if(locationDepartmentTypes.getDepartmentTypes().get(i) == null)
				continue;
			
			DynamicGridRow row = getRowByDepartment(locationDepartmentTypes.getDepartmentTypes().get(i));
			
			if(row == null)
				row = form.dyngrdDepartments().getRows().newRow();
			
			DynamicGridCell cell = row.getCells().newCell(getSelectedColumn(COLDEPARTMENT), DynamicCellType.LABEL);
			cell.setValue(locationDepartmentTypes.getDepartmentTypes().get(i).getText());
			cell.setTooltip(locationDepartmentTypes.getDepartmentTypes().get(i).getText());
			cell.setReadOnly(true);
			
			cell = row.getCells().newCell(getSelectedColumn(COLSELECTED), DynamicCellType.BOOL);
			cell.setAutoPostBack(true);
			cell.setValue(true);
			
			cell = row.getCells().newCell(getSelectedColumn(COLDEFAULT), DynamicCellType.BOOL);
			cell.setAutoPostBack(true);
			
			if(locationDepartmentTypes.getDepartmentTypes().get(i).equals(locationDepartmentTypes.getDefaultDepartmentType()))
			{
				cell.setValue(true);
			}
			
			row.setValue(locationDepartmentTypes.getDepartmentTypes().get(i));
		}
	}

	private  DynamicGridRow getRowByDepartment(DepartmentType departmentType) 
	{
		if(departmentType == null)
			return null;
		
		for(int i=0; i<form.dyngrdDepartments().getRows().size(); i++)
		{
			if(departmentType.equals(form.dyngrdDepartments().getRows().get(i).getValue()))
				return form.dyngrdDepartments().getRows().get(i);
		}
		
		return null;
	}

	private void populateDepartmentsGridWithDefault() 
	{
		form.dyngrdDepartments().getRows().clear();
		
		DepartmentTypeCollection departments = LookupHelper.getDepartmentType(domain.getLookupService());
		if(departments == null)
			return;
		
		for(int i=0; i<departments.size(); i++)
		{
			if(departments.get(i) == null)
				continue;
			
			DynamicGridRow row = form.dyngrdDepartments().getRows().newRow();
			DynamicGridCell cell = row.getCells().newCell(getSelectedColumn(COLDEPARTMENT), DynamicCellType.LABEL);
			cell.setValue(departments.get(i).getText());
			cell.setTooltip(departments.get(i).getText());
			cell.setReadOnly(true);
			
			cell = row.getCells().newCell(getSelectedColumn(COLSELECTED), DynamicCellType.BOOL);
			cell.setAutoPostBack(true);
			
			cell = row.getCells().newCell(getSelectedColumn(COLDEFAULT), DynamicCellType.BOOL);
			cell.setAutoPostBack(true);
			
			row.setValue(departments.get(i));
		}
	}
	
	private DynamicGridColumn getSelectedColumn(Integer identifier)
	{
		return form.dyngrdDepartments().getColumns().getByIdentifier(identifier);
	}

	private void initialize() 
	{
		bindEDLocationCombo();
		initializeDepartmentGrid();
	}

	private void initializeDepartmentGrid() 
	{
		form.dyngrdDepartments().clear();

		form.dyngrdDepartments().setSelectable(true);
		
		DynamicGridColumn colDepartment = form.dyngrdDepartments().getColumns().newColumn("Department Type", COLDEPARTMENT);
		colDepartment.setWidth(900);
		colDepartment.setReadOnly(true);
		
		DynamicGridColumn colSelected = form.dyngrdDepartments().getColumns().newColumn("Selected", COLSELECTED);
		colSelected.setWidth(100);
		colSelected.setHeaderAlignment(Alignment.CENTER);
		colSelected.setAlignment(Alignment.CENTER);

		DynamicGridColumn colDefault = form.dyngrdDepartments().getColumns().newColumn("Default", COLDEFAULT);
		colDefault.setWidth(-1);
		colDefault.setHeaderAlignment(Alignment.CENTER);
		colDefault.setAlignment(Alignment.CENTER);
	}

	private void bindEDLocationCombo() 
	{
		form.cmbEDLocation().clear();
		
		LocationLiteVoCollection eds = domain.listAllEDs();
		
		if(eds == null)
			return;
		
		for(LocationLiteVo ed : eds)
		{
			if(ed == null)
				continue;
			
			form.cmbEDLocation().newRow((LocationRefVo)ed, ed.getName());
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	private void updateControlsState() 
	{
		if(FormMode.VIEW.equals(form.getMode()))
		{
			form.btnNew().setVisible(form.cmbEDLocation().getValue() != null && (form.getLocalContext().getSelectedInstance() == null || form.getLocalContext().getSelectedInstance().getID_LocationDepartmentTypes() == null));
			form.btnNew().setEnabled(true);
		
			form.btnEdit().setVisible(form.cmbEDLocation().getValue() != null && (form.getLocalContext().getSelectedInstance() != null && form.getLocalContext().getSelectedInstance().getID_LocationDepartmentTypes() != null));
			form.btnEdit().setEnabled(true);
		}
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	private void updateInstance() 
	{
		form.setMode(FormMode.EDIT);
		
		if(form.getLocalContext().getSelectedInstanceIsNotNull())
		{
			form.getLocalContext().setSelectedInstance(domain.get(form.getLocalContext().getSelectedInstance().getEDLocation()));
		}
		
		populateScreenFromData(form.getLocalContext().getSelectedInstance());
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	
	private boolean save() 
	{
		LocationDepartmentTypesVo locationDepartmentType = populateDataFromScreen(form.getLocalContext().getSelectedInstance());
		
		String[] errors = locationDepartmentType.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try 
		{
			form.getLocalContext().setSelectedInstance(domain.save(locationDepartmentType));
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		return true;
	}

	private LocationDepartmentTypesVo populateDataFromScreen(LocationDepartmentTypesVo selectedInstance) 
	{
		if(selectedInstance == null)
			selectedInstance =  new LocationDepartmentTypesVo();
		
		selectedInstance.setEDLocation(form.cmbEDLocation().getValue());
		
		DepartmentTypeCollection departments = new DepartmentTypeCollection();
		boolean defaultFound = false;
		
		for(int i=0; i<form.dyngrdDepartments().getRows().size(); i++)
		{
			DynamicGridCell cell = form.dyngrdDepartments().getRows().get(i).getCells().get(getSelectedColumn(COLSELECTED));
			if(cell.getValue() instanceof Boolean && (Boolean) cell.getValue())
			{
				departments.add((DepartmentType) form.dyngrdDepartments().getRows().get(i).getValue());
			}
			
			cell = form.dyngrdDepartments().getRows().get(i).getCells().get(getSelectedColumn(COLDEFAULT));
			if(cell.getValue() instanceof Boolean && (Boolean) cell.getValue())
			{
				defaultFound = true;
				selectedInstance.setDefaultDepartmentType((DepartmentType) form.dyngrdDepartments().getRows().get(i).getValue());
			}
		}
		
		if(!defaultFound)
		{
			selectedInstance.setDefaultDepartmentType(null);
		}
		
		selectedInstance.setDepartmentTypes(departments.size() > 0 ? departments : null);
		
		return selectedInstance;
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance() 
	{	
		form.setMode(FormMode.EDIT);
		
		LocationDepartmentTypesVo locationDepartmentType = new LocationDepartmentTypesVo();
		locationDepartmentType.setEDLocation(form.cmbEDLocation().getValue());
		
		populateScreenFromData(locationDepartmentType);
	}

	@Override
	protected void onCmbEDLocationValueChanged() throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedInstance(domain.get(form.cmbEDLocation().getValue()));
		populateScreenFromData(form.getLocalContext().getSelectedInstance());
		updateControlsState();
	}

	private void uncheckOthers(DynamicGridRow row) 
	{
		if(row == null)
			return;
		
		for(int i=0; i<form.dyngrdDepartments().getRows().size(); i++)
		{
			if(!form.dyngrdDepartments().getRows().get(i).equals(row))
			{
				form.dyngrdDepartments().getRows().get(i).getCells().get(getSelectedColumn(COLDEFAULT)).setValue(false);
			}
		}
	}

	@Override
	protected void onDyngrdDepartmentsCellValueChanged(DynamicGridCell cell) 
	{
		if(cell.getColumn().equals(getSelectedColumn(COLDEFAULT)) && cell.getValue() instanceof Boolean && (Boolean) cell.getValue())
		{
			DynamicGridCell cellSelected = cell.getRow().getCells().get(getSelectedColumn(COLSELECTED));
			cellSelected.setValue(cell.getValue());
			
			uncheckOthers(cell.getRow());
		}
		else if(cell.getColumn().equals(getSelectedColumn(COLSELECTED)) && Boolean.FALSE.equals(cell.getValue()))
		{
			DynamicGridCell cellDefault = cell.getRow().getCells().get(getSelectedColumn(COLDEFAULT));
			cellDefault.setValue(cell.getValue());
		}
	}
}
