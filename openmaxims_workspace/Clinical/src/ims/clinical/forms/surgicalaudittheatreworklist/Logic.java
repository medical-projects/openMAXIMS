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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.surgicalaudittheatreworklist;

import ims.clinical.forms.surgicalaudittheatreworklist.GenForm.grdResultsRow;
import ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo;
import ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVoCollection;
import ims.clinical.vo.SurgicalAuditTheatreWorklistSearchCriteriaVo;
import ims.clinical.vo.SurgicalAuditTheatreWorklistVo;
import ims.clinical.vo.SurgicalAuditTheatreWorklistVoCollection;
import ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientIdListVoCollection;
import ims.core.vo.lookups.PatIdType;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

import java.util.ArrayList;
import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open();
	}

	private void initialize()
	{
		populateTheatreCmb();
		//WDEV-15693
		populateStatusCombo();

	}
	
	//WDEV-15693
	private void populateStatusCombo()
	{
		form.cmbStatus().clear();
		ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatusCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getSurgicalAuditOperationDetailStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			if (lookupCollection.get(x).equals(SurgicalAuditOperationDetailStatus.LEFT_HOLDING_BAY)
				|| lookupCollection.get(x).equals(SurgicalAuditOperationDetailStatus.ENTERED_OPERATING_THEATRE)
				|| lookupCollection.get(x).equals(SurgicalAuditOperationDetailStatus.LEFT_OPERATING_THEATRE)
				|| lookupCollection.get(x).equals(SurgicalAuditOperationDetailStatus.HAND_OVER_FROM_RECOVERY_NURSE)
				|| lookupCollection.get(x).equals(SurgicalAuditOperationDetailStatus.CANCELLED_OPERATIONS) 	)
			{
				form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
			}	
		}
	}

	private void populateTheatreCmb()
	{
		form.cmbTheatre().clear();
		LocationLiteVo locVo = null, tempLocVo = null;
		LocSiteLiteVo locSiteVo = null;
		if (domain.getCurrentLocation() instanceof LocationLiteVo)
		{
			locVo = (LocationLiteVo) domain.getCurrentLocation();
		}
		else if (domain.getCurrentLocation() instanceof LocSiteLiteVo)
		{
			locSiteVo = (LocSiteLiteVo) domain.getCurrentLocation();
		}
		if (locVo != null)
		{
			tempLocVo = locVo;
		}
		else if (locSiteVo != null)
		{
			tempLocVo = domain.getLocationLiteVo(locSiteVo);
		}

		if (tempLocVo != null)
		{
			LocationLiteVoCollection tempVoColl = domain.listTheatre(tempLocVo);
			if (tempVoColl != null && tempVoColl.size() > 0)
			{
				tempVoColl.sort(new LocComparator(SortOrder.ASCENDING));
				for (int i = 0; i < tempVoColl.size(); i++)
				{
					form.cmbTheatre().newRow(tempVoColl.get(i), tempVoColl.get(i).getName());
				}
			}
		}

	}

	public class LocComparator implements Comparator
	{
		private int direction = 1;

		public LocComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public LocComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;

		}

		public int compare(Object ob1, Object ob2)
		{
			String locName1 = null;
			String locName2 = null;
			if (ob1 instanceof LocationLiteVo)
			{
				LocationLiteVo loc1 = (LocationLiteVo) ob1;
				locName1 = loc1.getName();
			}
			if (ob2 instanceof LocationLiteVo)
			{
				LocationLiteVo loc2 = (LocationLiteVo) ob2;
				locName2 = loc2.getName();
			}
			if (locName1 != null)
				return locName1.compareTo(locName2) * direction;
			if (locName2 != null)
				return (-1) * direction;

			return 0;
		}

	}

	private void open()
	{
		if (form.getGlobalContext().Clinical.getSurgicalAuditTheatreWorklistSearchCriteriaIsNotNull())
		{
			populateSearchCriteriaScreenFromData(form.getGlobalContext().Clinical.getSurgicalAuditTheatreWorklistSearchCriteria());
			search();
		}
	}

	private void populateSearchCriteriaScreenFromData(SurgicalAuditTheatreWorklistSearchCriteriaVo criteria)
	{
		clearScreen();

		if (criteria == null)
			return;

		form.cmbType().setValue(criteria.getIdType());
		form.txtType().setValue(criteria.getIdValue());
		form.txtSurname().setValue(criteria.getSurname());
		form.txtForename().setValue(criteria.getForename());
		form.cmbTheatre().setValue(criteria.getTheatre());
		form.cmbStatus().setValue(criteria.getStatus());
		form.dteFrom().setValue(criteria.getDateFrom());
		form.dteTo().setValue(criteria.getDateTo());

	}

	private boolean search()
	{

		if (isSearchCriteriaValid())
		{
			populateGridResults(domain.listSurgicalAudit(populateSearchCriteriaFromScreen()));
			// update total
			updateSearchTotal(form.grdResults().getRows().size());

			if (form.grdResults().getRows().size() == 0)
				engine.showMessage("No records found.");

			return true;
		}

		return false;

	}

	private void populateGridResults(SurgicalAuditTheatreWorklistVoCollection listSurgicalAudit)
	{
		form.grdResults().getRows().clear();

		if (listSurgicalAudit == null || listSurgicalAudit.size() == 0)
			return;

		for (int i = 0; i < listSurgicalAudit.size(); i++)
		{
			SurgicalAuditTheatreWorklistVo record = listSurgicalAudit.get(i);
			if (record == null)
				continue;

			addCarePlanWorklistRow(record);

		}
	}

	private void addCarePlanWorklistRow(SurgicalAuditTheatreWorklistVo record)
	{
		if (record == null)
			return;

		grdResultsRow row = form.grdResults().getRows().newRow();

		row.setcolSurname(record.getPatient().getName().getSurname());
		row.setTooltipForcolSurname(record.getPatient().getName().getSurname());
		
		row.setcolForname(record.getPatient().getName().getForename());
		row.setTooltipForcolForname(record.getPatient().getName().getForename());
		
		PatientIdListVoCollection identifiers = record.getPatient().getIdentifiers();

		for (int i = 0; i < identifiers.size(); i++)
		{
			if (identifiers.get(i).getType().equals(PatIdType.MRNNUM))
			{
				row.setcolMRNo(identifiers.get(i).getValue().toString());
				row.setTooltipForcolMRNo(identifiers.get(i).getValue().toString());
			}
		}

		row.setcolStatus(record.getCurrentStatus().getOperationStatus().getText()+" - "+record.getCurrentStatus().getStatusDateTime());
		row.setTooltipForcolStatus(record.getCurrentStatus().getOperationStatus().getText()+" - "+record.getCurrentStatus().getStatusDateTime());

		// Populate Procedure Column & Primary Procedure Column
		PatientProcedureForSurgicalAuditPreOpChecksVoCollection collProcedure = null;
		if (record.getActualProcedureIsNotNull())
			collProcedure = record.getActualProcedure().getPlannedActualProcedures();
		else
			collProcedure = record.getPreOpChecks().getPlannedProcedures();

		StringBuffer textForColProcedure = new StringBuffer();
		StringBuffer tooltipForColProcedure = new StringBuffer();
		PatientProcedureForSurgicalAuditPreOpChecksVo primaryProcedure = null;

		for (int i = 0; i < collProcedure.size(); i++)
		{
			textForColProcedure.append((i != 0 ? "," : "") + collProcedure.get(i).getProcedureDescription());
			tooltipForColProcedure.append(collProcedure.get(i).getProcedureDescription() + "<br>");

			if (collProcedure.get(i).getIsPrimary() !=null && collProcedure.get(i).getIsPrimary())
				primaryProcedure = collProcedure.get(i);

		}

		row.setcolProcedure(textForColProcedure.toString());
		row.setTooltipForcolProcedure(tooltipForColProcedure.toString());
		if (primaryProcedure != null)
		{
			row.setcolPrimaryProc(primaryProcedure.getProcedureDescription());
			row.setTooltipForcolPrimaryProc(primaryProcedure.getProcedureDescription());
		}
		row.setValue(record);

	}

	private void updateSearchTotal(int count)
	{
		form.lblTotal().setValue("Total : " + count);
	}

	private boolean isSearchCriteriaValid()
	{
		if (form.txtType().getValue() != null && form.cmbType().getValue() == null)
		{
			engine.showMessage("Please select a Patient ID Type");
			return false;
		}

		ArrayList<String> uiErrors = new ArrayList<String>();

		Date dateFrom = form.dteFrom().getValue();
		Date dateTo = form.dteTo().getValue();

		if (dateFrom != null && dateTo != null && dateTo.isLessThan(dateFrom))
		{
			uiErrors.add("'Date From' can not be greater than 'Date To'");
		}

		if (uiErrors.size() > 0)
		{
			engine.showErrors(uiErrors.toArray(new String[uiErrors.size()]));
			return false;
		}

		return true;
	}

	private void clearScreen()
	{
		form.cmbType().setValue(null);
		form.txtType().setValue(null);
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		form.cmbTheatre().setValue(null);
		form.cmbStatus().setValue(null);
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.grdResults().setValue(null);
		form.grdResults().getRows().clear();
		form.lblTotal().setValue("Total : 0");
	}

	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		clearScreen();
		form.getGlobalContext().Clinical.setSurgicalAuditTheatreWorklistSearchCriteria(null);
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		if (search())
		{
			form.getGlobalContext().Clinical.setSurgicalAuditTheatreWorklistSearchCriteria(populateSearchCriteriaFromScreen());
		}
	}

	private SurgicalAuditTheatreWorklistSearchCriteriaVo populateSearchCriteriaFromScreen()
	{
		SurgicalAuditTheatreWorklistSearchCriteriaVo criteria = new SurgicalAuditTheatreWorklistSearchCriteriaVo();

		criteria.setIdType(form.cmbType().getValue());
		criteria.setIdValue(form.txtType().getValue());
		criteria.setSurname(form.txtSurname().getValue());
		criteria.setForename(form.txtForename().getValue());
		criteria.setTheatre(form.cmbTheatre().getValue());
		criteria.setStatus(form.cmbStatus().getValue());
		criteria.setDateFrom(form.dteFrom().getValue());
		criteria.setDateTo(form.dteTo().getValue());

		return criteria;
	}

	@Override
	protected void onGrdResultsSelectionChanged() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setCurrentCareContext(form.grdResults().getValue().getCareContext());
		engine.open(form.getForms().Clinical.SurgicalAudit, new Object[] { form.grdResults().getValue() });
	}

}
