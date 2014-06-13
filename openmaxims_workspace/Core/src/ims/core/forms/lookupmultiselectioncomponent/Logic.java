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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3922.16454)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.lookupmultiselectioncomponent;


import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.controls.DynamicGridRowCollection;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.LookupInstVo;
import ims.vo.LookupInstanceCollection;
import ims.vo.lookups.ClassHelper;

import java.util.Arrays;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final Integer COL_SELECT = new Integer(-1);
	private static final Integer COL_TXT = new Integer(-2);
	private static final int SELECT_WIDTH_N = 25;
	private static final int TXT_WIDTH = -1;

	/**
	* Inits the cc with the specified lookup type
	*/
	public void initialize(Integer lookupTypeId)
	{
		initTree(domain.getLookupService().getLookupType(lookupTypeId));
		form.getLocalContext().setLookupTypeId(lookupTypeId);
	}
	private void initTree(ims.vo.LookupTypeVo lookup)
	{
		if (lookup == null)
			throw new CodingRuntimeException("No lookup type provided");
		
		form.dyngrdLookup().clear();
		
		DynamicGridColumn nCol = null;
		if (!isSingleSelect())
		{
			nCol = form.dyngrdLookup().getColumns().newColumn("",COL_SELECT);
			nCol.setWidth(lookup.isHierarchical()?SELECT_WIDTH_N:SELECT_WIDTH_N);
		}
		
		nCol = form.dyngrdLookup().getColumns().newColumn("",COL_TXT);
		nCol.setWidth(TXT_WIDTH);
		nCol.setDynamicWidthSupported(true);
		
		form.dyngrdLookup().setHeaderHeight(0);
		
	
		
		LookupInstanceCollection lookupCollection = domain.getLookupService().getLookupCollection(lookup.getId(), ClassHelper.getLookupCollectionClass(lookup.getId()),ClassHelper.getLookupClass(lookup.getId()),true, true);

	
		if (lookup.isHierarchical())
			populateRecursive(lookupCollection.getRoots(),null,2);
		else
			populateLinear(lookupCollection);
		
	}
	private void populateLinear(LookupInstanceCollection lookupCollection) {
		if (lookupCollection == null)
			return;
		
		for (int i = 0 ; i < lookupCollection.size() ; i++)
		{
			addRow(null, lookupCollection.getIndex(i),0);
	
			
		}
	}
	private void populateRecursive(LookupInstVo[] lookups,DynamicGridRow parent, int depth)
	{
		if (lookups == null)
			return;
		populateRecursive(Arrays.asList(lookups),parent,depth);
	}
	private void populateRecursive(List<LookupInstVo> lookups,DynamicGridRow parent,int depth)
	{
		if (lookups == null)
			return;
		for (int i = 0 ; i  < lookups.size() ; i++ )
		{
			populateRecursive(lookups.get(i).getChildInstances(),addRow(parent, lookups.get(i),depth),++depth);
			depth--;
		}
	}
	
	private DynamicGridRow addRow(DynamicGridRow parent,LookupInstVo look, int depth)
	{
		if (look == null)
			throw new CodingRuntimeException("Trying to add null value lookup instance");
		DynamicGridRow result ;
		if (parent == null)
			result =  form.dyngrdLookup().getRows().newRow();
		else
			result = parent.getRows().newRow();
		
		result.setSelectable(isSingleSelect());
		result.setCollapsedImage(null);
		result.setExpandedImage(null);
		DynamicGridCell nCell;
		if (!isSingleSelect())
		{
			DynamicGridColumn colSel = getColumn(COL_SELECT);
			if (colSel.getWidth() < depth * SELECT_WIDTH_N)
				colSel.setWidth(depth * SELECT_WIDTH_N);
			nCell = result.getCells().newCell(colSel,DynamicCellType.BOOL);
			nCell.setAutoPostBack(false);
			nCell.setReadOnly(false);
		}
		
		nCell = result.getCells().newCell(getColumn(COL_TXT), DynamicCellType.STRING);
		nCell.setAutoPostBack(false);
		nCell.setReadOnly(true);
		nCell.setValue(look.getText());
		
		result.setValue(look);
		
		return result;
	}
	private DynamicGridColumn getColumn(Integer indentifier)
	{
		return form.dyngrdLookup().getColumns().getByIdentifier(indentifier);
	}

	/**
	* Sets the selected lookups
	*/
	public void setValue(ims.vo.LookupInstanceCollection insts)
	{
		isInitialized();
		populateGridFromData(insts,form.dyngrdLookup().getRows());
	}
	private void populateGridFromData(LookupInstanceCollection insts,DynamicGridRowCollection rows)
	{
		if (rows == null)
			return;
		
		if (isSingleSelect())
		{
			if (insts == null || insts.size() == 0)
			{
				form.dyngrdLookup().setValue(null);
				return;
			}
			if (insts.size() == 1)
			{
				form.dyngrdLookup().setValue(insts.getIndex(0));
				return;
			}
			throw new CodingRuntimeException("When the component is used as single select you can not set a value that contains more that 1 element");
			
	}
	
		for (int i = 0 ; i < rows.size(); i++)
		{
			DynamicGridRow dgr = rows.get(i);

			dgr.getCells().get(getColumn(COL_SELECT)).setValue(insts != null && insts.indexOf((LookupInstVo) dgr.getValue())>-1);
		
			populateGridFromData(insts, dgr.getRows());
		}
		
	}
	private void populateDataFromGrid(LookupInstanceCollection data,DynamicGridRowCollection rows)
	{
		if (data == null)
			throw new CodingRuntimeException("Data is null. Loading to what?");
		if (isSingleSelect())
		{
			if (form.dyngrdLookup().getValue() instanceof LookupInstVo)
			{
				data.add((LookupInstVo) form.dyngrdLookup().getValue());
				
			}
			return;
		}
		if (rows == null)
			return;
		
		for (int i = 0 ; i < rows.size() ; i++)
		{
			if (Boolean.TRUE.equals(rows.get(i).getCells().get(getColumn(COL_SELECT)).getValue()))
				data.add((LookupInstVo) rows.get(i).getValue());
			populateDataFromGrid(data, rows.get(i).getRows());
		}
		
	}
	private void isInitialized() {
		if (form.getLocalContext().getLookupTypeId() == null)
			throw new CodingRuntimeException("The component doesn't seem to be initalized. Did you called initialize ?");
	}

	/**
	* Gets selected values
	*/
	public ims.vo.LookupInstanceCollection getValue()
	{
	
		LookupInstanceCollection result=null;
		try
		{
			result = (LookupInstanceCollection) ClassHelper.getLookupCollectionClass(form.getLocalContext().getLookupTypeId()).newInstance();
		}
		catch (InstantiationException e)
		{			
		}
		catch (IllegalAccessException e)
		{		
		}
		
		if (result == null)
			throw new CodingRuntimeException("Unable to instantiate LookupCollection");
		
		populateDataFromGrid(result, form.dyngrdLookup().getRows());
		if (result.size() == 0)
			return null;
		return result;
	}
	public void initialize(Integer lookupTypeId, Boolean singleSelect)
	{
		form.getLocalContext().setSingleSelect(singleSelect);
		initialize(lookupTypeId);
		
	}
	private boolean isSingleSelect()
	{
		return form.getLocalContext().getSingleSelectIsNotNull() && form.getLocalContext().getSingleSelect();
	}
	
	public void setValue(LookupInstVo insts)
	{
		if (!isSingleSelect())
			throw new CodingRuntimeException("Cannot set value . Component is multiselect and you should use setValue(ims.vo.LookupInstanceCollection)");
		
		isInitialized();
		
		form.dyngrdLookup().setValue(insts);
	}
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}
	private void updateControlsState()
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			if (isSingleSelect())
			{
				form.dyngrdLookup().setEnabled(false);
			}
			else
			{
				form.dyngrdLookup().setReadOnly(true);
			}
		}
		
	}
}
