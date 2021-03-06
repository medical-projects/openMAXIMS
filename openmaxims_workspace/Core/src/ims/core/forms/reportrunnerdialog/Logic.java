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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.53 build 2543.28531)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.reportrunnerdialog;

import ims.admin.vo.ReportSeedParsedVo;
import ims.admin.vo.ReportSeedParsedVoCollection;
import ims.core.helper.ReportSeedsHelper;
import ims.core.vo.GpShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.OrgShortVo;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.Sex;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.PartialDate;
import ims.naes.vo.lookups.NAESReferredBy;
import ims.scheduling.vo.lookups.ApptOutcome;
import ims.vo.LookupInstVo;
import ims.vo.LookupInstanceCollection;
import ims.vo.ValueObjectCollection;
import ims.vo.lookups.ClassHelper;

import java.util.ArrayList;


public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;
	

	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Region - Logic static values
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	private static final String	NAME_COLUMN			= "0";
	private static final String	VALUE_COLUMN		= "1";
	private static final String	MANDATORY_COLUMN	= "2";
	
	private static final String	INTEGER			= "java.lang.Integer";
//	private static final String	BIG_INTEGER		= "java.math.BigInteger";
//	private static final String	SHORT			= "java.lang.Short";
//	private static final String	LONG			= "java.lang.Long";
//	private static final String	BOOOLEAN		= "java.lang.Boolean";
//	private static final String	STRING			= "java.lang.String";
//	private static final String	BIG_DECIMAL		= "java.math.BigDecimal";
//	private static final String	FLOAT			= "java.lang.Float";
//	private static final String	DOUBLE			= "java.lang.Double";
//	private static final String	UTIL_DATE		= "java.util.Date";
//	private static final String	SQL_DATE		= "java.sql.Date";
//	private static final String	SQL_TIME		= "java.sql.Time";
	


	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	// Region - Helper classes
	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 *	Class used in populating dynamic grid cell items with
	 *	seeds that use custom search
	 */
	private class CustomSearchSeed
	{
		private Object value;
		private String displayText;
		
		public CustomSearchSeed(Object value, String text)
		{
			this.value = value;
			this.displayText = text;
		}

		public Object getValue()
		{
			return value;
		}

		@Override
		public String toString()
		{
			return displayText;
		}
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	// Region - Event Handlers
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// If form initialisation decides that the form should be presented to the user
		// then call the open() function used to present the form
		if (initialize())
			open();
	}

	
	@Override
	protected void onDyngrdParametersCellTextSubmited(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		if (isCustomSearchSeedCell(cell))
		{
			listCustomSearchSeed(cell);
			return;
		}

		if (cell.getType().equals(DynamicCellType.QUERYCOMBOBOX))
		{
			Object identifier = cell.getIdentifier();
			if (identifier != null)
			{
				if (identifier.equals(ReportSeedsHelper.GP_BO))
				{
					listGps(cell);
				}

				if (identifier.equals(ReportSeedsHelper.HCP_BO))
				{
					listHCPs(cell, null);
				}

				if (identifier.equals(ReportSeedsHelper.MEDIC_BO))
				{
					listHCPs(cell, HcpDisType.MEDICAL);
				}

				if (identifier.equals(ReportSeedsHelper.MOS_BO))
				{
					listMOS(cell);
				}

				if (identifier.equals(ReportSeedsHelper.ORG_BO))
				{
					listOrganisation(cell);
				}

				if (identifier.equals(ReportSeedsHelper.LOCATION_BO))
				{
					listLocation(cell);
				}

				if (identifier.equals(ReportSeedsHelper.LOC_SITE_BO))
				{
					listLocSite(cell);
				}							
			}
		}
	}

	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (saveSeeds())
		{
			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Close dialog with result CANCEL
		// The calling form should not build the report and the
		// seeds entered should be reverted
		engine.close(DialogResult.CANCEL);
	}

	
	
	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Presentation logic function 
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to initialize the form
	 *	@return
	 * 	<li><b>true</b> if the form has been initialised and needs to be presented to the user (there are seeds for the user to chose values)
	 * 	<li><b>false</b> if the seeds collection is null or zero length and the form doesn't need to be presented to the user
	 */
	private boolean initialize()
	{
		// Check to see if there are seeds for the user to select values
		if (!form.getGlobalContext().Admin.getReportSeedParsedIsNotNull() || form.getGlobalContext().Admin.getReportSeedParsed().size() == 0)
		{
			// Close the form and terminate the execution here
			engine.close(DialogResult.OK);
			return false;
		}
		
		// Create dynamic grid columns
		initializeDynamicGrid();
		
		return true;
	}

	
	/**
	 * Function used to initialize the dynamic grid
	 * Will create the columns (set the width, set the label, etc)
	 */
	private void initializeDynamicGrid()
	{
		// Clear dynamic grid completely (all rows, all columns)
		form.dyngrdParameters().clear();
		
		// Create the 'Name' column - used for displaying seeds names
		DynamicGridColumn nameCol = form.dyngrdParameters().getColumns().newColumn("Name", NAME_COLUMN);
		nameCol.setWidth(250);
		nameCol.setBackColor(Color.Gray);
		nameCol.setReadOnly(true);

		// Create the 'Value' column - used for selecting seeds values
		DynamicGridColumn seedCol = form.dyngrdParameters().getColumns().newColumn("Value", VALUE_COLUMN);
		seedCol.setWidth(205);
		
		// Create the 'Mandatory' column - used for marking mandatory seeds
		DynamicGridColumn mandatoryCol = form.dyngrdParameters().getColumns().newColumn("", MANDATORY_COLUMN);
		mandatoryCol.setWidth(-1);
		mandatoryCol.setAlignment(Alignment.CENTER);
	}

	
	/**
	 * Function used to present the form to the user
	 * <br>Will populate screen with data and set the form to <b>EDIT</b> mode
	 */
	private void open()
	{
		populateSeedsToDynamicGrid(form.getGlobalContext().Admin.getReportSeedParsed());
		
		form.setMode(FormMode.EDIT);
	}


	/**
	 * Function used to save the seeds values on screen to be used in the report 
	 */
	private boolean saveSeeds()
	{
		// Perform validation for seeds values (check for mandatory seeds)
		String[] errors = validateUIRules();
		// If validation errors are present display them to the user
		// and exit function 
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		form.getGlobalContext().Admin.setReportSeedParsed(populateSeedsFromDynamicGrid());
		
		return true;
	}


	/**
	 * Function used to perform validation for seed values
	 * @return - String array containing error messages, or <b>null</b> if no errors were found
	 */
	private String[] validateUIRules()
	{
		// Start with an empty errors list
		ArrayList<String> errorList = new ArrayList<String>();
		
		// Analyse the seeds presented to user
		for (int i = 0; i < form.dyngrdParameters().getRows().size(); i++)
		{
			// Get a reference to dynamic grid row
			DynamicGridRow row = form.dyngrdParameters().getRows().get(i);
			// Analyse only the rows containing seed values (ReportSeedParsedVo)
			if (row.getValue() instanceof ReportSeedParsedVo)
			{
				// Get the seed value from the row
				ReportSeedParsedVo seed = (ReportSeedParsedVo) row.getValue();
				// Get a reference to cell containing the value for the seed
				DynamicGridCell valueCell = row.getCells().get(getColumn(VALUE_COLUMN));

				// If the seed is mandatory and the value is null (or zero sized string) then add the error to the list
				// Error message is 'Name' cell value + "is mandatory."
				if (Boolean.FALSE.equals(seed.getCanBeNull()) && (valueCell.getValue() == null || valueCell.getValue().toString().trim().length() == 0))
				{
					DynamicGridCell nameCell = row.getCells().get(getColumn(NAME_COLUMN));

					errorList.add(nameCell.getValue() + " is mandatory.");
				}
			}
		}
		
		// Return errors list (as an array of string)
		return errorList.toArray(new String[errorList.size()]);
	}


	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange function
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to retrieve seeds (with value) from screen
	 */
	private ReportSeedParsedVoCollection populateSeedsFromDynamicGrid()
	{
		// Create a collection for seeds
		ReportSeedParsedVoCollection seeds = new ReportSeedParsedVoCollection();
		
		// Iterate seed dynamic grid rows 
		for (int i = 0; i < form.dyngrdParameters().getRows().size(); i++)
		{
			// Set a reference to row
			DynamicGridRow row = form.dyngrdParameters().getRows().get(i);
			// If the row holds a seed
			if (row.getValue() instanceof ReportSeedParsedVo)
			{
				// Get the seed for the row
				ReportSeedParsedVo seed = (ReportSeedParsedVo) row.getValue();
				// Set a reference to value cell
				DynamicGridCell valueCell = row.getCells().get(getColumn(VALUE_COLUMN));
				// Set the seed value
				seed = setSeedValue(valueCell, seed);
				// After the seed had it's value updated add it to seed collection
				seeds.add(seed);
			}
		}
		
		// Return seed collection
		return seeds;
	}

	/**
	 *	Function used to display seeds in grid
	 *	<br>Will clear the grid, add a row configured for each valid seed and populate with existing values 
	 */
	private void populateSeedsToDynamicGrid(ReportSeedParsedVoCollection reportSeedCollection)
	{
		// Clear the seed grid
		form.dyngrdParameters().getRows().clear();
		
		// If the seed collection used by a report is null then 
		if (reportSeedCollection == null)
			return;

		for (int i = 0; i < reportSeedCollection.size(); i++)
		{
			addSeed(reportSeedCollection.get(i));
		}
	}

	private void addSeed(ReportSeedParsedVo voSeed)
	{
		if (voSeed == null)
			return;

		DynamicGridRow row = form.dyngrdParameters().getRows().newRow();

		DynamicGridCell nameCell = row.getCells().newCell(getColumn(NAME_COLUMN), DynamicCellType.WRAPTEXT);
		String seedName = getReportSeed().getCellName(voSeed);
					
		nameCell.setValue(seedName);
		nameCell.setReadOnly(true);

		// WDEV-12753
		// Determine the seed value cell type
		DynamicCellType cellType = getSeedSearchCellType(voSeed);

		Object value = getReportSeed().getValue(voSeed);

		DynamicGridCell valueCell = row.getCells().newCell(getColumn(VALUE_COLUMN), cellType);
		if (cellType.equals(DynamicCellType.QUERYCOMBOBOX))
		{
			if (value != null)
			{
				String displayString = (voSeed.getDisplayTextIsNotNull() && voSeed.getDisplayText().trim().length() > 0) ? voSeed.getDisplayText() : value.toString(); 
				valueCell.getItems().newItem(value, displayString);
			}
			valueCell.setAutoPostBack(true);
		}
		if (cellType.equals(DynamicCellType.ENUMERATION))
		{
			// WDEV-14289
			// Get lookup values for search-able seed 
			if (voSeed.getSearchTypeIsNotNull() && voSeed.getSearchType().equalsIgnoreCase("S"))
			{
				if (voSeed.getBOName().equalsIgnoreCase("ims.domain.lookups.LookupInstance"))
				{
					if (voSeed.getSearchByIsNotNull() && voSeed.getSearchBy().length >= 1)
					{
						Integer lookupType = domain.getLokupType(voSeed.getSearchBy()[0]);
						
						if (lookupType != null)
						{
							populateComboInstance(valueCell, lookupType);
						}
					}
				}
			}
			else if(seedName.contains("_"))
			{
				String seedNameDisplay=seedName.substring(0, seedName.indexOf('_'));				
			    String  lookupType=seedName.substring(seedName.indexOf('_')+1,seedName.length());
			    seedName=seedNameDisplay;
				if(checkIfNumber(lookupType)) 
				{
					int type=Integer.valueOf(lookupType).intValue();
					nameCell.setValue(seedName);
					nameCell.setReadOnly(true);
									
					populateComboInstance(valueCell,type );						
				}			    
			}				
		}
		if(cellType.equals(DynamicCellType.PARTIALDATE) && value instanceof java.lang.Integer)
		{
			valueCell.setValue(new PartialDate((Integer)value));
		}
		else
		{	
			valueCell.setValue(value);
		}
		
		valueCell.setIdentifier(getReportSeed().getIdentifier(voSeed));

		boolean canBeNull = voSeed == null ? true : voSeed.getCanBeNull().booleanValue();
//		valueCell.setCanBeEmpty(canBeNull);
		
		if(canBeNull == false)
		{
			DynamicGridCell mandatoryCell = row.getCells().newCell(getColumn(MANDATORY_COLUMN), DynamicCellType.HTMLVIEW);
			mandatoryCell.setValue("<font color='#FF0000' size='3'>*</font>");
			mandatoryCell.setTooltip("Required");
			
//			valueCell.setValidationMessage(seedName + " is mandatory");
		}
		
		row.setValue(voSeed);
	}

	// ----------------- Private methods ---------------------------

	/**
	 * WDEV-12753
	 * Function used to determine if the cell holds value for a seed with custom search defined
	 */
	private boolean isCustomSearchSeedCell(DynamicGridCell cell)
	{
		if (cell == null || cell.getRow() == null || !(cell.getRow().getValue() instanceof ReportSeedParsedVo))
			return false;
		
		ReportSeedParsedVo seed = (ReportSeedParsedVo) cell.getRow().getValue();
		
		if (seed.getSearchTypeIsNotNull() && seed.getSearchType().equalsIgnoreCase("S"))
			return true;
		
		return false;
	}


	/**
	 * WDEV-12753
	 * Function used to determine the type of cell used as a value for seed
	 */
	private DynamicCellType getSeedSearchCellType(ReportSeedParsedVo seed)
	{
		// If the seed is marked as 'search'-able seed
		if (seed.getSearchTypeIsNotNull())
		{
			// If the seed is 'search'-able partial date - search type will be the string "PD"
			if (seed.getSearchType().equalsIgnoreCase("PD"))
				return DynamicCellType.PARTIALDATE;
			
			// If the seed is 'search'-able by a collection of strings - the search type will be the string "S"
			if (seed.getSearchType().equalsIgnoreCase("S"))
			{
				// WDEV-14289'
				// For 'Lookup instance' we use a combo-box 
				if (seed.getBOName().equalsIgnoreCase("ims.domain.lookups.LookupInstance"))
				{
					return DynamicCellType.ENUMERATION;
				}
				
				return DynamicCellType.QUERYCOMBOBOX;
			}
		}

		// Keep this for old reports legacy
		if(seed.getType().equalsIgnoreCase(INTEGER) &&
				(seed.getName().equalsIgnoreCase("DOB") || seed.getName().equalsIgnoreCase("DOB_START") || seed.getName().equalsIgnoreCase("DOB_END")
				|| seed.getName().equalsIgnoreCase("DATE_OF_BIRTH_FROM") || seed.getName().equalsIgnoreCase("DATE_OF_BIRTH_TO") || "PD".equalsIgnoreCase(seed.getSearchType())))
		{
			return DynamicCellType.PARTIALDATE;
		}


		return getReportSeed().getCellType(seed);
	}

	private boolean checkIfNumber(String lookupType)
	{
		try
		{
			Integer.parseInt(lookupType);
		}
		catch (NumberFormatException ex)
		{
			return false;
		}

		return true;
	}

	private void populateComboInstance(DynamicGridCell valueCell, int lookupTypeId) 
	{
			
		LookupInstanceCollection instColl;
		
		instColl = domain.getLookupService().getLookupCollection(lookupTypeId, ClassHelper.getLookupCollectionClass(lookupTypeId), ClassHelper.getLookupClass(lookupTypeId), true, true);
		
	    if(instColl == null)
		return;
	    
	   
	    LookupInstVo[] roots = instColl.getRoots();	    
	    for (int i = 0; i < roots.length; i++)
		{
	    	valueCell.getItems().newItem(roots[i], roots[i].toString());
		}
	    valueCell.setAutoPostBack(true);	    	
	}

	private DynamicGridColumn getColumn(String columnIdentifier)
	{
		if (columnIdentifier == null)
			return null;

		return form.dyngrdParameters().getColumns().getByIdentifier(columnIdentifier);
	}

	private ReportSeedsHelper getReportSeed()
	{
		return new ReportSeedsHelper(engine);
	}

	/**
	 * WDEV-12753
	 * Function used to list seeds marked as having custom search by string
	 */
	private void listCustomSearchSeed(DynamicGridCell cell)
	{
		try
		{
			if (cell == null || cell.getRow() == null || !(cell.getRow().getValue() instanceof ReportSeedParsedVo))
				return;

			ReportSeedParsedVo seed = (ReportSeedParsedVo) cell.getRow().getValue();

			ArrayList<Object[]> listCustomSearchSeed = domain.listCustomSearchSeed(seed.getShortBOName(), seed.getBOField(), seed.getDisplayFields(), seed.getSearchBy(), cell.getTypedText());
			
			populateCellItems(cell, listCustomSearchSeed);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			e.printStackTrace();
			return;
		}
	}


	private void listGps(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listGPsBySurname(cell.getTypedText()));
	}

	private void listHCPs(DynamicGridCell cell, HcpDisType hcpDisciplineType)
	{
		if (cell == null)
			return;

		HcpLiteVoCollection voColl = domain.listHcpLiteByNameAndDisciplineType(cell.getTypedText(), hcpDisciplineType);
		populateCellItems(cell, voColl);
	}

	private void listMOS(DynamicGridCell cell)
	{
		MemberOfStaffShortVo filter = new MemberOfStaffShortVo();
		PersonName personName = new PersonName();
		personName.setSurname(cell.getTypedText());
		filter.setName(personName);
		filter.setIsActive(Boolean.TRUE);

		populateCellItems(cell, domain.listMembersOfStaff(filter));
	}

	private void listOrganisation(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		OrgShortVo filter = new OrgShortVo();
		filter.setName(cell.getTypedText());
		filter.setIsActive(Boolean.TRUE);

		populateCellItems(cell, domain.listOrganisationsShort(filter));
	}

	private void listLocSite(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listLocSite(cell.getTypedText()));
	}
			
	private void listLocation(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listLocationByName(cell.getTypedText()));
	}

	private void populateCellItems(DynamicGridCell cell, ArrayList<Object[]> listCustomSearchSeed)
	{
		cell.getItems().clear();
		
		if (listCustomSearchSeed == null || listCustomSearchSeed.size() == 0)
		{
			cell.showOpened();
			return;
		}
		
		for (int i = 0; i < listCustomSearchSeed.size(); i++)
		{
			Object[] elements = listCustomSearchSeed.get(i);
			
			if (elements == null || elements.length != 2)
				continue;
			
			CustomSearchSeed seed = new CustomSearchSeed(elements[0], (String) elements[1]);
			
			cell.getItems().newItem(seed, seed.toString());
			
			if (listCustomSearchSeed.size() == 1)
				cell.setValue(seed);
		}
		
		if (listCustomSearchSeed.size() != 1)
			cell.showOpened();
	}
	
	private void populateCellItems(DynamicGridCell cell, ValueObjectCollection voColl)
	{
		cell.getItems().clear();

		for (int i = 0; voColl != null && i < voColl.getItems().length; i++)
		{
			cell.getItems().newItem(voColl.getItems()[i], (voColl.getItems()[i]).toString());
		}

		if (voColl != null && voColl.getItems() != null)
		{
			if (voColl.getItems().length == 1)
				cell.setValue(voColl.getItems()[0]);
			else if (voColl.getItems().length > 1)
				cell.showOpened();
		}
	}
	
	private ReportSeedParsedVo setSeedValue(DynamicGridCell valueCell, ReportSeedParsedVo seed)
	{
		if (valueCell == null)
			return seed;

		Object value = valueCell.getValue();
		
		// WDEV-12801
		// If the cell value is null then clear the seed value
		if (value == null)
		{
			seed.setValue(null);
			return seed;
		}
		else if (value instanceof CustomSearchSeed)
		{
			seed.setValue(((CustomSearchSeed) value).getValue().toString());
			seed.setDisplayText(((CustomSearchSeed) value).toString());
		}
		else if (value instanceof GpShortVo)
		{
			seed.setValue(((GpShortVo) value).getID_Gp().toString());
			seed.setDisplayText(((GpShortVo) value).toString());
			seed.setGP(((GpShortVo) value));
		}
		else if (value instanceof HcpLiteVo)
		{
			seed.setValue(((HcpLiteVo) value).getID_Hcp().toString());
			seed.setDisplayText(((HcpLiteVo) value).toString());
			seed.setHCP((HcpLiteVo) value);
		}
		else if (value instanceof MemberOfStaffShortVo)
		{
			seed.setValue(((MemberOfStaffShortVo) value).getID_MemberOfStaff().toString());
			seed.setDisplayText(((MemberOfStaffShortVo) value).toString());
			seed.setMOS((MemberOfStaffShortVo) value);
		}
		else if (value instanceof OrgShortVo)
		{
			seed.setValue(((OrgShortVo) value).getID_Organisation().toString());
			seed.setDisplayText(((OrgShortVo) value).toString());
			seed.setOrganisation(((OrgShortVo) value));
		}
		else if (value instanceof LocSiteLiteVo)
		{
			seed.setValue(((LocSiteLiteVo) value).getID_Location().toString());
			seed.setDisplayText(((LocSiteLiteVo) value).toString());
			seed.setLocSite((LocSiteLiteVo) value);
		}
		else if (value instanceof LocationLiteVo)
		{
			seed.setValue(((LocationLiteVo) value).getID_Location().toString());
			seed.setDisplayText(((LocationLiteVo) value).toString());
			seed.setLocation((LocationLiteVo) value);
		}
		else if (value instanceof Sex)
		{
			seed.setValue(String.valueOf(((Sex)value).getId()));
			seed.setDisplayText(((Sex)value).getText());
			seed.setSex((Sex)value);
		}
		else if (value instanceof ApptOutcome)
		{
			seed.setValue(String.valueOf(((ApptOutcome)value).getId()));
			seed.setDisplayText(((ApptOutcome)value).getText());
			seed.setOutcome((ApptOutcome)value);
		}
		else if (value instanceof NAESReferredBy)
		{
			seed.setValue(String.valueOf(((NAESReferredBy)value).getId()));
			seed.setDisplayText(((NAESReferredBy)value).getText());
			seed.setReferralBy((NAESReferredBy)value);
		}
		else if (value instanceof DateTime)
		{
			seed.setValue(((DateTime)value).toString(DateTimeFormat.ISO_SECS));
			seed.setDisplayText(((DateTime)value).toString(DateTimeFormat.ISO_SECS));
		}
		else if (value instanceof PartialDate && seed.getType().equalsIgnoreCase(INTEGER))
		{
			seed.setValue(((PartialDate)value).toInteger().toString());
			seed.setDisplayText(((PartialDate)value).toInteger().toString());
		}
		else if (value instanceof LookupInstVo)
		{
			seed.setValue(String.valueOf(((LookupInstVo)value).getId()));
			seed.setDisplayText(((LookupInstVo)value).getText());
		}
		else
		{
			seed.setValue(value.toString());
		}

		return seed;
	}
	// ----------------- End Private methods -----------------------
	
}
