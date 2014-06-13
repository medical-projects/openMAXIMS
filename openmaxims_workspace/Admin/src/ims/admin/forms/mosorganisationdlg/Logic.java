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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.26 build 1977.13709)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.mosorganisationdlg;
import ims.admin.helper.OrganisationLocationHelper;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLocationAccreditationHistoryVo;
import ims.core.vo.HcpLocationAccreditationHistoryVoCollection;
import ims.core.vo.HcpLocationVo;
import ims.core.vo.HcpLocationVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocShortVo;
import ims.core.vo.LocSiteVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.OrganisationVo;
import ims.core.vo.OrganisationVoCollection;
import ims.core.vo.lookups.AccreditationLocationStatus;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.StaffType;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellOptions;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.controls.DynamicGridRowCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellDecoratorMode;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.ntpf.vo.lookups.CaseTypeCollection;

import java.text.ParseException;

public class Logic extends BaseLogic
{
	private static final Integer	COL_ORGANISATION_LOCATION	= new Integer(2);
	private static final Integer	COL_ACCREDITATION			= new Integer(3);
	private static final Integer	COL_ACCREDITATION_CASETYPES = new Integer(6);
	private static final Integer	COL_ACCREDITATION_ST_DATE	= new Integer(4);
	private static final Integer	COL_ACCREDITATION_END_DATE	= new Integer(5);

	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{	
		Boolean bShowSave = true;
		if (args != null && args.length == 1)
		{
			if (args[0] instanceof Boolean)
				bShowSave = (Boolean) args[0];
		}

		if (! bShowSave)
			form.btnSave().setText("OK");
		
		if (form.getGlobalContext().Admin.getSelectedMos() == null)
		{
			throw new FormOpenException("Selected MOS context variable not populated.");
			
		}
		if (form.getGlobalContext().Admin.getSelectedMos().getLocations() == null)
		{
			form.getGlobalContext().Admin.getSelectedMos().setLocations(new HcpLocationVoCollection());
		}

		form.setMode(FormMode.EDIT);
		setNameCaption();
		form.getContextMenus().getMosLocationSetPrimaryLocationItem().setVisible(false);
		populateOrganisationTree();
		displaySetPrimaryLocationMenuOption(form.dyngrdOrganisationLocation().getRows());
		
		form.dyngrdOrganisationLocation().setCheckBoxesAutoPostBack(true);
	}
	
	private void setNameCaption() 
	{
		String sCaption = "Set Organisations\\Locations ";
		
		if (form.getGlobalContext().Admin.getSelectedMosIsNotNull())
		{
			if (form.getGlobalContext().Admin.getSelectedMos().getNameIsNotNull())
				sCaption += form.getGlobalContext().Admin.getSelectedMos().getName().toShortForm();
		}
		form.pnlLocations().setValue(sCaption);		
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setisGridFilledCorrectly(Boolean.TRUE);

		checkGridFilledInCorrectly(form.dyngrdOrganisationLocation().getRows());
		if (!form.getLocalContext().getisGridFilledCorrectly().booleanValue())
		{	
			if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue())
				engine.showMessage("Either a location with an Accreditation has not been ticked or a ticked location is missing an Accreditation Start Date or the start and end dates for a location are not chronologically correct, please amend.");
			else
				engine.showMessage("Accreditation has been specified for locations that have not been allocated to the member of staff, please amend.");

			return;
		}
		
		if ( fillHcpLocations())
			engine.close(DialogResult.OK);
	}
	
	private void checkGridFilledInCorrectly(DynamicGridRowCollection rows)
	{
		if (getColByIdentifier(COL_ACCREDITATION) != null)
		{
			for(int i=0; i < rows.size(); i++)
			{
				DynamicGridRow row = rows.get(i);
				
				if ( (row.getValue() instanceof LocSiteVo) || (row.getValue() instanceof HcpLocationVo) )
				{
					DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
					//Acreditation is set..............but row not checked ....report this
					if ( (cell != null ) && (cell.getValue() != null) && (!row.isChecked()))
						form.getLocalContext().setisGridFilledCorrectly(Boolean.FALSE);
					
					if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue())
					{
						if ( (cell != null ) && (cell.getValue() == null) && (row.isChecked()))
							form.getLocalContext().setisGridFilledCorrectly(Boolean.FALSE);

						if (cell != null && (cell.getValue() != null)
							&& getColByIdentifier(COL_ACCREDITATION_ST_DATE) != null)
						{
							DynamicGridCell cellSTDate = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_ST_DATE));
							//Start Date is set..............but row not checked ....report this
							if ( (cellSTDate != null ) && (cellSTDate.getValue() == null) && (row.isChecked())
								&& ((AccreditationLocationStatus)cell.getValue()).equals(AccreditationLocationStatus.ACCREDITED))//wdev-4224
								form.getLocalContext().setisGridFilledCorrectly(Boolean.FALSE);

							DynamicGridCell cellENDDate = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_END_DATE));
							if ( cellENDDate != null && cellENDDate.getValue() != null
								&& cellSTDate != null && cellSTDate.getValue() != null)
							{
								Date stDate = null;
								Date endDate = null;
		   						try
								{
		   							stDate =new Date(cellSTDate.getValue().toString());
								}
								catch (ParseException e)
								{
									engine.showMessage(e.getMessage());
								}
		   						try
								{
									endDate = new Date(cellENDDate.getValue().toString());
								}
								catch (ParseException e)
								{
									engine.showMessage(e.getMessage());
								}
	 
								if (endDate.isLessThan(stDate))
									form.getLocalContext().setisGridFilledCorrectly(Boolean.FALSE);
							}
							
						}
				//		form.getLocalContext().setAccreditationWarningShown(false);

				//		if ( ! checkForValidEndDate(cell, cell.getRow()))
				//			DynamicGridCell cellSTDate = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_ST_DATE));
	    					 
					}
				}
				if(row.getRows() != null )
					checkGridFilledInCorrectly(row.getRows());
			}
		}
	}

	private boolean fillHcpLocations()
	{
		form.getGlobalContext().Admin.getSelectedMos().getLocations().clear();
		return fillHcpLocations(form.dyngrdOrganisationLocation().getRows());
	}
	
	private boolean fillHcpLocations(DynamicGridRowCollection rows)
	{
		HcpLocationVoCollection voCollHcpLocations = form.getGlobalContext().Admin.getSelectedMos().getLocations();
		
		boolean bNewHistoryRecord = false;
		boolean bUpdateHistoryRecord = false;
		for(int i=0; i < rows.size(); i++)
		{
			DynamicGridRow rowLocSiteOrLoc = rows.get(i);
			
			bNewHistoryRecord = false;
			bUpdateHistoryRecord = false;
			
			if(rowLocSiteOrLoc.getValue() instanceof OrganisationVo == false)
			{
				if (rowLocSiteOrLoc.isChecked() == true)
				{
					DynamicGridCell accreditationCell = rowLocSiteOrLoc.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
					HcpLocationVo voHcpLocation = null;
					if (rowLocSiteOrLoc.getValue() instanceof HcpLocationVo )
					{						
                    	// The menu option to set the primary location only changes the colour
                    	// not the value object. So we look a thhis stage for the primaty location.
						voHcpLocation = (HcpLocationVo) rowLocSiteOrLoc.getValue();
  					}
                    else 
                    {
                    	voHcpLocation = new HcpLocationVo();
                    	voHcpLocation.setLocation((LocShortVo) rowLocSiteOrLoc.getValue());
						bNewHistoryRecord = true;
                    }
					
                  	if (rowLocSiteOrLoc.getTextColor() != null)
                		voHcpLocation.setIsPrimary(new Boolean(rowLocSiteOrLoc.getTextColor().equals(Color.Red)));
     				else
    					voHcpLocation.setIsPrimary(null);

       				if (getColByIdentifier(COL_ACCREDITATION) != null)
    				{
    					if (accreditationCell != null && accreditationCell.getValue() != null)
    					{
       						if ( voHcpLocation != null 
        						&& voHcpLocation.getAccreditationStatusIsNotNull() 
        						&& ! voHcpLocation.getAccreditationStatus().equals((AccreditationLocationStatus)accreditationCell.getValue()) )
        						/* WDEV-15423
        						   && (((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITATIONSUSPENDED) 
        						 	|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITED)
        							|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.NOTACCREDITED) ) ) 
        						*/
        						bNewHistoryRecord = true;
 
    						voHcpLocation.setAccreditationStatus((AccreditationLocationStatus)accreditationCell.getValue());
    					}
        				else
        					voHcpLocation.setAccreditationStatus(null);
    				}
    				else
    					voHcpLocation.setAccreditationStatus(null);
    					

      				if (getColByIdentifier(COL_ACCREDITATION_CASETYPES) != null)
      				{
    					DynamicGridCell casetypesCell = rowLocSiteOrLoc.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_CASETYPES));
     					if (casetypesCell != null
     						&& casetypesCell.getIdentifier() instanceof CaseTypeCollection)
     	   					voHcpLocation.setCaseTypes((CaseTypeCollection) casetypesCell.getIdentifier());
      				}

      				DynamicGridCell start_dateCell = rowLocSiteOrLoc.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_ST_DATE));
      				Date stDate = null;
    				if (getColByIdentifier(COL_ACCREDITATION_ST_DATE) != null
    					&& getColByIdentifier(COL_ACCREDITATION) != null)
    				{
    					if (start_dateCell != null && start_dateCell.getValue() != null)
    					{
    						try
							{
								stDate = new Date(start_dateCell.getValue().toString());
							}
							catch (ParseException e)
							{
								engine.showMessage(e.getMessage());
							}
	  						
							if ( voHcpLocation != null 
	  	       					&& voHcpLocation.getAccreditationStatusIsNotNull() 
	  	        				&& voHcpLocation.getStartDateIsNotNull()
	  	        				&& stDate != null
	  	        				&& ! voHcpLocation.getStartDate().equals(stDate)
	  	        				&& voHcpLocation.getAccreditationStatus().equals((AccreditationLocationStatus)accreditationCell.getValue()))
	  	        			/* WDEV-15423
	  	           				&& (((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITATIONSUSPENDED)
	  	           					|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITED)
	  	           					|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.NOTACCREDITED) ) )
	  	           			*/
	  	            			bUpdateHistoryRecord = true;

								Date tempDate = new Date(stDate);
								voHcpLocation.setStartDate(tempDate);
    					}
						else
						{
							if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue()
								&& accreditationCell != null
								&& accreditationCell.getValue() != null
	   							&& ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITED))
							{
								engine.showMessage("There is no Start Date for " + voHcpLocation.getLocation().getName() + ", please amend.");
	     						return false;
							}
							else
								voHcpLocation.setStartDate(null);
						}
      				}
    				else
    					voHcpLocation.setStartDate(null);
    					
      				DynamicGridCell end_dateCell = rowLocSiteOrLoc.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_END_DATE));
     				Date endDate = null;
     				if (getColByIdentifier(COL_ACCREDITATION_END_DATE) != null)
    				{
    					if (end_dateCell != null && end_dateCell.getValue() != null)
    					{
    						try
							{
								endDate = new Date(end_dateCell.getValue().toString());
							}
							catch (ParseException e)
							{
								engine.showMessage(e.getMessage());
							}
							
	  						if ( voHcpLocation != null 
	  	       					&& voHcpLocation.getAccreditationStatusIsNotNull() 
	  	        				&& ( (voHcpLocation.getEndDateIsNotNull() && endDate != null && ! voHcpLocation.getEndDate().equals(endDate))
	  	        					|| voHcpLocation.getEndDate() == null && endDate != null)
	  	        				&& voHcpLocation.getAccreditationStatus().equals((AccreditationLocationStatus)accreditationCell.getValue()))
	  	        			/* WDEV-15423
	  	           				&& (((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITATIONSUSPENDED)
	  	           					|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.ACCREDITED)
	  	           					|| ((AccreditationLocationStatus)accreditationCell.getValue()).equals(AccreditationLocationStatus.NOTACCREDITED) ) )
	  	           			*/
            					bUpdateHistoryRecord = true;

							Date tempDate2 = new Date(endDate);
							voHcpLocation.setEndDate(tempDate2);
    					}
    					else
        					voHcpLocation.setEndDate(null);
    				}
    				else
    					voHcpLocation.setEndDate(null);
      				
       				if (bNewHistoryRecord)
    				{
       					HcpLocationAccreditationHistoryVo voAccreditationHistory = new HcpLocationAccreditationHistoryVo(); //WDEV-15423
       					voAccreditationHistory.setAccreditationStatus(voHcpLocation.getAccreditationStatus());
       					voAccreditationHistory.setStartDate(voHcpLocation.getStartDate());
       					voAccreditationHistory.setEndDate(voHcpLocation.getEndDate());
       					voAccreditationHistory.setIsCurrent(true);
       					voAccreditationHistory.setActive(true);
       					
       					if (voHcpLocation.getAccreditationHistory() == null)
       						voHcpLocation.setAccreditationHistory(new HcpLocationAccreditationHistoryVoCollection());
       					
       					if (voHcpLocation.getAccreditationHistoryIsNotNull())
       					{
       						voHcpLocation.getAccreditationHistory().sort(SortOrder.DESCENDING);
       						for (int j = 0 ; j < voHcpLocation.getAccreditationHistory().size() ; j++)
       						{
       							voHcpLocation.getAccreditationHistory().get(j).setIsCurrent(false);
       							
       							if (j == voHcpLocation.getAccreditationHistory().size() - 1
       								&& stDate != null
       								&& ! voHcpLocation.getAccreditationHistory().get(j).getEndDateIsNotNull())
       							{
       								Date newDate = new Date(stDate.addDay(-1));
       								voHcpLocation.getAccreditationHistory().get(j).setEndDate(newDate );
       							}
       						}
       					}
       					voHcpLocation.getAccreditationHistory().add(voAccreditationHistory);
    				}
       				if (bUpdateHistoryRecord && ! bNewHistoryRecord)
    				{
       					if (voHcpLocation.getAccreditationHistoryIsNotNull() && voHcpLocation.getAccreditationHistory().size() >= 1) //WDEV-15515
       					{
       						voHcpLocation.getAccreditationHistory().get(voHcpLocation.getAccreditationHistory().size() - 1).setStartDate(stDate );
							voHcpLocation.getAccreditationHistory().get(voHcpLocation.getAccreditationHistory().size() - 1).setEndDate(endDate );
						}
    				}
    				voCollHcpLocations.add(voHcpLocation);
				}
			}
			
			if(rowLocSiteOrLoc.getRows() != null )
				fillHcpLocations(rowLocSiteOrLoc.getRows());
		}
		return true;
	}


	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	public void initializeGrid()
	{
		form.dyngrdOrganisationLocation().clear();
		form.dyngrdOrganisationLocation().setSelectable(true);
		form.dyngrdOrganisationLocation().showCheckBoxes(true);
		
		DynamicGridColumn column = form.dyngrdOrganisationLocation().getColumns().newColumn("Organisation / Location");
		column.setIdentifier(COL_ORGANISATION_LOCATION);
		column.setWidth(400);

		MemberOfStaffVo mos = form.getGlobalContext().Admin.getSelectedMos();
		if (mos.getStaffTypeIsNotNull() && mos.getStaffType().equals(StaffType.HCP))
		{
			column.setWidth(360);

			column = form.dyngrdOrganisationLocation().getColumns().newColumn("Accreditation");
			column.setIdentifier(COL_ACCREDITATION);
			column.setWidth(230);

			if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue())
			{
				column.setWidth(170);

				column = form.dyngrdOrganisationLocation().getColumns().newColumn("Case Types");
				column.setIdentifier(COL_ACCREDITATION_CASETYPES);
				column.setWidth(70);
			}

			column = form.dyngrdOrganisationLocation().getColumns().newColumn("Start Date");
			column.setIdentifier(COL_ACCREDITATION_ST_DATE);
			column.setWidth(120);
			
			column = form.dyngrdOrganisationLocation().getColumns().newColumn("End Date");
			column.setIdentifier(COL_ACCREDITATION_END_DATE);
			column.setWidth(-1);
		}
	}

	private void populateOrganisationTree() 
	{	
		OrganisationVoCollection voColl = domain.listRootOrgs().sort();		
		initializeGrid();
		new OrganisationLocationHelper(form.getImages().Admin.Organisation, form.getImages().Admin.LocationSite, form.getImages().Admin.Location).populatOrganisationLocationDynamicGrid(form.dyngrdOrganisationLocation(), voColl, true);
		
		fillAccreditationCombos();
		
		form.dyngrdOrganisationLocation().getRows().expandAll();	

		HcpLocationVoCollection voCollHcpLocations = null;
		MemberOfStaffVo mos = form.getGlobalContext().Admin.getSelectedMos();
		if (mos != null)
		{
			voCollHcpLocations = mos.getLocations();	
			setHcpLocationsInGrid(voCollHcpLocations);
		}		
	}
	
	
	private void setHcpLocationsInGrid(HcpLocationVoCollection voCollHcpLocations)
	{
		for (int j = 0; j < form.dyngrdOrganisationLocation().getRows().size() ; j++) //Go thru top level
		{
			DynamicGridRow row = form.dyngrdOrganisationLocation().getRows().get(j);
				
			if (row.getRows().size() > 0)
				setHcpLocations(voCollHcpLocations, row);
		}
	}

	private void setHcpLocations(HcpLocationVoCollection voCollHcpLocations, DynamicGridRow rowParent)
	{
		for (int i = 0; i < voCollHcpLocations.size(); i++)
		{
			HcpLocationVo hcpLocVo = voCollHcpLocations.get(i);
			
			LocShortVo locVo = hcpLocVo.getLocation();
			
			for (int j = 0; j < rowParent.getRows().size() ; j++)
			{
				DynamicGridRow row = rowParent.getRows().get(j);
				
				if (row.getValue().equals(locVo))
				{
					row.setValue(hcpLocVo);
					
					row.setChecked(true);
							
					String strTooltip = createAccreditationHistoryTooltip(hcpLocVo.getAccreditationHistory(), hcpLocVo.getCaseTypes());
					
					DynamicGridCell cellOrgLoc = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ORGANISATION_LOCATION));
					cellOrgLoc.setTooltip(strTooltip);

					if (hcpLocVo.getIsPrimary() != null && hcpLocVo.getIsPrimary().booleanValue())
					{
						row.setTextColor(Color.Red);
					}

					if (getColByIdentifier(COL_ACCREDITATION) != null)
					{
						DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
						if (cell != null && cell.getType().equals(DynamicCellType.ENUMERATION))
	 					{
							cell.setValue(hcpLocVo.getAccreditationStatusIsNotNull() ? hcpLocVo.getAccreditationStatus() : null);
							cell.setIdentifier(hcpLocVo.getAccreditationStatus());
							cell.setWidth(200);
							cell.setTooltip(strTooltip);
	 					}
						
						//WDEV-15073
						if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue() && cell != null && cell.getValue() != null &&( ((AccreditationLocationStatus)cell.getValue()).equals(AccreditationLocationStatus.RESTICT_ACCRED) 
								|| ((AccreditationLocationStatus)cell.getValue()).equals(AccreditationLocationStatus.RESTRICT_ACCRED_REFERRING)) )
						{
							row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_CASETYPES), DynamicCellType.BUTTON);
						}
						
					}
					
					if (getColByIdentifier(COL_ACCREDITATION_CASETYPES) != null)
					{
						DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_CASETYPES));
						if (cell != null && cell.getType().equals(DynamicCellType.BUTTON))
	 					{
							cell.setIdentifier(hcpLocVo.getCaseTypes());
							cell.setWidth(100);
							cell.setTooltip(strTooltip);
	 					}
					}

					if (getColByIdentifier(COL_ACCREDITATION_ST_DATE) != null)
					{
						DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_ST_DATE));
						if (cell != null && cell.getType().equals(DynamicCellType.DATE))
	 					{
							cell.setValue(hcpLocVo.getStartDateIsNotNull() ? hcpLocVo.getStartDate(): null);
							cell.setIdentifier(hcpLocVo.getStartDate());
							cell.setWidth(120);
							cell.setTooltip(strTooltip);
	 					}
					}
					if (getColByIdentifier(COL_ACCREDITATION_END_DATE) != null)
					{
						DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_END_DATE));
						if (cell != null && cell.getType().equals(DynamicCellType.DATE))
	 					{
							cell.setValue(hcpLocVo.getEndDateIsNotNull() ? hcpLocVo.getEndDate() : null);
							cell.setIdentifier(hcpLocVo.getEndDate());
							cell.setWidth(-1);
							cell.setTooltip(strTooltip);
	 					}
					}
				}
				
				if (row.getRows().size() > 0)
					setHcpLocations(voCollHcpLocations, row);
			}
		}		
	}

	private String createAccreditationHistoryTooltip(HcpLocationAccreditationHistoryVoCollection accreditationHistory, CaseTypeCollection collCaseTypes)
	{
		if (accreditationHistory != null && accreditationHistory.size() > 0 && collCaseTypes != null)
		{
			java.lang.StringBuffer strDetail = new StringBuffer();

			strDetail.append("<font color=\"#FF0000\"><b><u>Accreditation History</b></u></font><br>");
			
			StringBuffer sb = new StringBuffer();

			for (int k = 0 ; k < collCaseTypes.size() ; k++)
			{
				sb.append(collCaseTypes.get(k).getText());
				sb.append(", ");
			}
			if (sb.length() > 0)
			{
				strDetail.append("<b>Case Types:</b> ");
				strDetail.append(sb.substring(0, sb.length() - 2));
				strDetail.append("<br>");
			}
			
			for (int i = 0 ; i < accreditationHistory.size()-1 ; i++)
			{
				strDetail.append("<b>Accreditation:</b> ");
				if (accreditationHistory.get(i).getAccreditationStatusIsNotNull())
					strDetail.append(accreditationHistory.get(i).getAccreditationStatus().getText());

				strDetail.append("     ");
				strDetail.append("<b>Change Date:</b> ");
				if (accreditationHistory.get(i).getSystemInformationIsNotNull())
					strDetail.append(accreditationHistory.get(i).getSystemInformation().getCreationDateTime().getDate().toString());

				strDetail.append("     ");
				strDetail.append("<b>Start Date:</b> ");
				if (accreditationHistory.get(i).getStartDateIsNotNull())
					strDetail.append(accreditationHistory.get(i).getStartDate().toString());

				strDetail.append("     ");
				strDetail.append("<b>End Date:</b> ");
				if (accreditationHistory.get(i).getEndDateIsNotNull())
					strDetail.append(accreditationHistory.get(i).getEndDate().toString());

				strDetail.append("<br>");
			}

			return strDetail.toString();
		}
		return "";
	}

	private void fillAccreditationCombos()
	{
		if (getColByIdentifier(COL_ACCREDITATION) != null)
		{
			form.getLocalContext().setCollAccreditation(LookupHelper.getAccreditationLocationStatus(domain.getLookupService()));
			
			for (int i = 0; i < form.dyngrdOrganisationLocation().getRows().size() ; i++)
			{
				DynamicGridRow row = form.dyngrdOrganisationLocation().getRows().get(i);
				
				if (row.getValue() instanceof OrganisationVo)
				{
					DynamicGridCell cell2 = row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.EMPTY);
					if (cell2 != null)
						cell2.setReadOnly(true);
	
					fillAccreditationForOrganisation(row);
				}
			}
		}		
	}

	private void fillAccreditationForOrganisation(DynamicGridRow row)
	{
		if (getColByIdentifier(COL_ACCREDITATION) != null)
		{
			for (int i = 0; i < row.getRows().size() ; i++)
			{
				DynamicGridRow rowLocSiteOrLoc = row.getRows().get(i);
				
				if (rowLocSiteOrLoc.getValue() instanceof OrganisationVo)
				{
					//Show a Label cell
					DynamicGridCell cell2 = row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.EMPTY);
					if (cell2 != null)
						cell2.setReadOnly(true);
					
					fillAccreditationForOrganisation(rowLocSiteOrLoc);
				}
				else if (rowLocSiteOrLoc.getValue() instanceof LocSiteVo)
				{
					//Show a Label cell
					DynamicGridCell cell2 = rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.ENUMERATION);
					if (cell2 != null)
					{
						cell2.setReadOnly(false);
						cell2.setWidth(-1);
						cell2.setTooltip("Please select an Accreditation");
						cell2.setAutoPostBack(true);
						
						for(int k = 0 ; k < form.getLocalContext().getCollAccreditation().size() ; k++) 
							cell2.getItems().newItem(form.getLocalContext().getCollAccreditation().get(k));
					}
					
					/* WDEV-15073
					if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue()) 
						rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_CASETYPES), DynamicCellType.BUTTON);
					*/
				
					rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_ST_DATE), DynamicCellType.DATE);

					rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_END_DATE), DynamicCellType.DATE);

					fillAccreditationForLocationSite(rowLocSiteOrLoc);
				}
				else if (rowLocSiteOrLoc.getValue() instanceof LocMostVo)
				{
					DynamicGridCell cell2 = rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.EMPTY);
					if (cell2 != null)
						cell2.setReadOnly(true);
				}
			}
		}
	}

	private void fillAccreditationForLocationSite(DynamicGridRow rowLocSiteOrLoc)
	{
		for (int i = 0; i < rowLocSiteOrLoc.getRows().size() ; i++)
		{
			DynamicGridRow row = rowLocSiteOrLoc.getRows().get(i);
			
			if (row.getValue() instanceof LocSiteVo)
			{
				DynamicGridCell cell2 = row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.ENUMERATION);
				
				if (cell2 != null)
				{
					for(int k = 0 ; k < form.getLocalContext().getCollAccreditation().size() ; k++) 
						cell2.getItems().newItem(form.getLocalContext().getCollAccreditation().get(k));
					
					cell2.setReadOnly(false);
					cell2.setTooltip("Please select an Accreditation");
					cell2.setWidth(-1);

				}

				if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue())
					rowLocSiteOrLoc.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_CASETYPES), DynamicCellType.BUTTON);
				
				row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_ST_DATE), DynamicCellType.DATE);

				row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_END_DATE), DynamicCellType.DATE);

				fillAccreditationForLocationSite(row);
			}
/*			else if (row.getValue() instanceof LocMostVo)
			{
				DynamicGridCell cell2 = row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION), DynamicCellType.EMPTY);
				if (cell2 != null)
				{
					cell2.setReadOnly(true);
					AccreditationLocationStatusCollection coll = LookupHelper.getAccreditationLocationStatus(domain.getLookupService());
					for(int k = 0 ; k < coll.size() ; k++) 
						cell2.getItems().newItem(coll.get(k));
					
					cell2.setReadOnly(false);
					cell2.setTooltip("Please select an Accreditation");
					cell2.setWidth(-1);
				}
			}
*/
		}
	}

	private DynamicGridColumn getColByIdentifier(Object indentifier)
	{
		return form.dyngrdOrganisationLocation().getColumns().getByIdentifier(indentifier);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (menuItemID == form.getContextMenus().getMosLocationSetPrimaryLocationItem().getID())
			setRowAsPrimaryLocation(form.dyngrdOrganisationLocation().getSelectedRow());
	}

	private void setRowAsPrimaryLocation(DynamicGridRow selectedRow)
	{
		if (selectedRow == null )
			return;		
		
		if (selectedRow.getValue() instanceof OrganisationVo)
			return;			
				
		clearPrimaryLocations(form.dyngrdOrganisationLocation().getRows());	
		
		if (selectedRow.getValue() instanceof HcpLocationVo || selectedRow.getValue() instanceof LocShortVo)
		{
			selectedRow.setTextColor(Color.Red);	
			selectedRow.setChecked(true);	
		}		
		form.getContextMenus().getMosLocationSetPrimaryLocationItem().setVisible(false);
	}

	private void clearPrimaryLocations(DynamicGridRowCollection rows)
	{
		for(int i = 0 ; i < rows.size() ; i++)
		{
			DynamicGridRow row = rows.get(i);
			
			if (row.getValue() instanceof OrganisationVo == false)
				row.setTextColor(Color.Default);
			
			if(row.getRows() != null && row.getRows().size() > 0)
				clearPrimaryLocations(row.getRows());
		}
		form.dyngrdOrganisationLocation().getRows().expandAll();	
	}
	
	private void displaySetPrimaryLocationMenuOption(DynamicGridRowCollection rows)
	{
		form.dyngrdOrganisationLocation().getRows().expandAll();	
		for(int i = 0 ; i < rows.size() ; i++)
		{
			DynamicGridRow row = rows.get(i);
			
		//	if (row.isChecked() == true)
		//		form.getContextMenus().getMosLocationSetPrimaryLocationItem().setVisible(true);
			
			if(row.getRows() != null && row.getRows().size() > 0)
				displaySetPrimaryLocationMenuOption(row.getRows());
		}
	}

	protected void onDyngrdOrganisationLocationRowChecked(DynamicGridRow row)
	{
		if (!row.isChecked())
		{
			if ( (row.getValue() instanceof LocSiteVo) || (row.getValue() instanceof HcpLocationVo) )
			{
				DynamicGridCell cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
				if (cell != null)
					cell.setValue(null);

			}
		}

	}

	protected void onDyngrdOrganisationLocationRowSelectionChanged(DynamicGridRow row) 
	{
		form.getContextMenus().getMosLocationSetPrimaryLocationItem().setVisible(form.dyngrdOrganisationLocation().getSelectedRow().getValue() != null && ! (form.dyngrdOrganisationLocation().getSelectedRow().getValue() instanceof OrganisationVo) && ! form.dyngrdOrganisationLocation().getSelectedRow().getTextColor().equals(Color.Red)); //WDEV-15405  //WDEV-15404
	}

	protected void onDyngrdOrganisationLocationCellValueChanged(DynamicGridCell cell)
	{
		if (cell.getType().equals(DynamicCellType.ENUMERATION))
		{
			DynamicGridRow row = cell.getRow();
			if ( (row != null) && (row.getValue() != null) )
			{
				form.dyngrdOrganisationLocation().setSelectedRow(row);

				if (cell.getValue() != null)
					row.setChecked(true);
				else
					row.setChecked(false);
				
				//Find the previous accreditation for this Row....if it was ACCREDITED stop and insist on an end date being saved first
				
				if (ConfigFlag.UI.MANDATORY_MOS_ACCREDITATION_STATUS.getValue())
				{
					if (getColByIdentifier(COL_ACCREDITATION) != null && getColByIdentifier(COL_ACCREDITATION_CASETYPES) != null)
					{
						DynamicGridCell cellAccreditation = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));

						if (cellAccreditation.getValue() != null && (((AccreditationLocationStatus) cellAccreditation.getValue()).equals(AccreditationLocationStatus.RESTICT_ACCRED) || ((AccreditationLocationStatus) cellAccreditation.getValue()).equals(AccreditationLocationStatus.RESTRICT_ACCRED_REFERRING)))
						{
							row.getCells().newCell(getColByIdentifier(COL_ACCREDITATION_CASETYPES), DynamicCellType.BUTTON);
						}
						else
						{
							DynamicGridCell caseTypeCell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_CASETYPES));
							
							if (caseTypeCell != null)
								caseTypeCell.clear();
						}

						DynamicGridCell cellCases = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_CASETYPES));

						if (form.dyngrdOrganisationLocation().getSelectedRow().getValue() instanceof HcpLocationVo)
			           	{
			           		((HcpLocationVo)form.dyngrdOrganisationLocation().getSelectedRow().getValue()).setCaseTypes(null);
			           	}
						else
						if (cellCases != null)
							cellCases.setIdentifier(null);

					}
				}
			}
		}
		
	}

	private boolean checkForValidEndDate(DynamicGridCell cell, DynamicGridRow row)
	{
		DynamicGridCell end_dateCell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_END_DATE));
		 
		if (wasPreviousAccreditationACCREDITED(row.getValue())
  			&& getColByIdentifier(COL_ACCREDITATION_END_DATE) != null
  			&& end_dateCell != null && end_dateCell.getValue() == null)
		{
			engine.showMessage("An Accreditation End date is required for " + ((HcpLocationVo)row.getValue()).getLocation().getName() + ". Please enter one and save.", "Missing End Date", MessageButtons.OK, MessageIcon.ERROR);
					
			if (getColByIdentifier(COL_ACCREDITATION) != null)
			{
				cell = row.getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
				if (cell != null && cell.getType().equals(DynamicCellType.ENUMERATION))
				{
					cell.setValue(AccreditationLocationStatus.ACCREDITED);
					cell.setIdentifier(AccreditationLocationStatus.ACCREDITED);
					cell.setWidth(200);
					cell.setTooltip(createAccreditationHistoryTooltip(((HcpLocationVo)row.getValue()).getAccreditationHistory(), ((HcpLocationVo)row.getValue()).getCaseTypes()));
				}
			}
			return false; 
		}
		return true;
	}

	private Boolean wasPreviousAccreditationACCREDITED(Object value)
	{
		
		if (value instanceof HcpLocationVo)
		{	
			if ( ((HcpLocationVo)value).getAccreditationStatusIsNotNull() 
				&& ((HcpLocationVo)value).getAccreditationStatus().equals(AccreditationLocationStatus.ACCREDITED) )
				return true;
		}
		return false;
	}

	@Override
	protected void onDyngrdOrganisationLocationCellButtonClicked(DynamicGridCell cell)
	{
		form.dyngrdOrganisationLocation().setSelectedRow(cell.getRow());
		
		
		DynamicGridCell cellAccreditation = cell.getRow().getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION));
		if (cellAccreditation.getValue() == null || (cellAccreditation.getValue() != null
			&& ( !((AccreditationLocationStatus)cellAccreditation.getValue()).equals(AccreditationLocationStatus.RESTICT_ACCRED)
				 && !((AccreditationLocationStatus)cellAccreditation.getValue()).equals(AccreditationLocationStatus.RESTRICT_ACCRED_REFERRING))) )
			return;
		
		if (form.dyngrdOrganisationLocation().getSelectedRow() != null
			&& form.dyngrdOrganisationLocation().getSelectedRow().getValue() != null
			&& form.dyngrdOrganisationLocation().getSelectedRow().getValue() instanceof HcpLocationVo )
			form.getGlobalContext().NTPF.setCaseTypes(((HcpLocationVo) form.dyngrdOrganisationLocation().getSelectedRow().getValue()) != null ? ((HcpLocationVo) form.dyngrdOrganisationLocation().getSelectedRow().getValue()).getCaseTypes() : null);
		else if (cell.getIdentifier() != null 
			&& cell.getIdentifier() instanceof CaseTypeCollection)
		{
			form.getGlobalContext().NTPF.setCaseTypes((CaseTypeCollection)cell.getIdentifier());
		}
		else
		{
			form.getGlobalContext().NTPF.setCaseTypes(null);
		}
		
		engine.open(form.getForms().Admin.NTPFCaseTypeConfigDialog);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Admin.NTPFCaseTypeConfigDialog) 
			&& result.equals(DialogResult.OK)
			//&& form.getGlobalContext().NTPF.getCaseTypesIsNotNull()
			//&& form.getGlobalContext().NTPF.getCaseTypes().size() > 0
			&& form.dyngrdOrganisationLocation().getSelectedRow() != null)
		{
			DynamicGridCell cell = form.dyngrdOrganisationLocation().getSelectedRow().getCells().get(form.dyngrdOrganisationLocation().getColumns().getByIdentifier(COL_ACCREDITATION_CASETYPES));
           	cell.setIdentifier(form.getGlobalContext().NTPF.getCaseTypes());
           	
           	if (form.dyngrdOrganisationLocation().getSelectedRow().getValue() instanceof HcpLocationVo)
           	{
           		((HcpLocationVo)form.dyngrdOrganisationLocation().getSelectedRow().getValue()).setCaseTypes(form.getGlobalContext().NTPF.getCaseTypes());
           	}
		}
	}

}