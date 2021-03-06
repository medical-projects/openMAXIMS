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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.newresultsmyresultstabcomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ClinicLiteVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.ocrr.forms.newresultsmyresultstabcomponent.GenForm.ListResultsByEnumeration;
import ims.ocrr.forms.newresultsmyresultstabcomponent.GenForm.OrdLocGrpEnumeration;
import ims.ocrr.forms.newresultsmyresultstabcomponent.GenForm.grdDisciplinesRow;
import ims.ocrr.vo.NewResultsCriteriaVo;
import ims.vo.ValueObject;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final int MYRESULTS = 2;
	
	private static final String OUTPATIENT_DEPARTMENT_LABEL = "Outpatient Dept.:";
	private static final String LOCATION_LABEL = "Location:";
	
	private static final String OUTPATIENT_DEPARTMENT_CONFIG = "Outpatient Department";
	private static final String OUTPATIENT_DEPARTMENT_HIDE_CLINIC_CONFIG = "Outpatient Department - Hide Clinic";

	private static final int ORDERING_LOCATION_TYPE_WARD	= 1;
	private static final int ORDERING_LOCATION_TYPE_CLINIC	= 2;
	private static final int ORDERING_LOCATION_TYPE_ED		= 3;
	private static final int ORDERING_LOCATION_TYPE_OTHER	= 4;

	
	@Override
	protected void onImbAddDisciplineClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().OCRR.setSelectedDisciplines(getDisciplines());
		engine.open(form.getForms().OCRR.SearchDisciplines);
	}
	
	public void initialize()
	{
		clear();
		
		Object hcp = domain.getHcpLiteUser();
		if(!(hcp instanceof HcpLiteVo))
			return;
		
		form.getLocalContext().setCurrentHCP((HcpLiteVo) hcp);
		form.lblHCP().setValue(form.getLocalContext().getCurrentHCP() != null ? form.getLocalContext().getCurrentHCP().getIMosName() : null);
		
		populateHospital();
		setLocationDefaults();
		
		form.chkNew().setValue(true);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(true);
		form.chkCompleted().setVisible(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());//wdev-17322
		form.chkCompleted().setValue(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());//wdev-17322
		
		populateDays(ConfigFlag.DOM.OCS_NEWRES_DAYS_MAX.getValue());
		resetDaysToDefault();
		
		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);
		
		updateControlsState();
	}
	
	private void setLocationDefaults()
	{
		form.OrdLocGrp().setValue(null);
		
		if (form.cmbHospital().getValue() == null)
		{
			form.OrdLocGrp().setValue(OrdLocGrpEnumeration.None);
		}
		else if (form.cmbHospital().getValue() != null && form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.None))
		{
			form.OrdLocGrp().setValue(OrdLocGrpEnumeration.rdoWard);
		}
		
		form.qmbOrderingLocation().setValue(null);
		form.qmbOrderingLocation().clear();
		
		locationRadioButtonValueChange();
	}

	private void resetDaysToDefault() 
	{
		form.cmbDays().setValue(new Integer(ConfigFlag.DOM.OCS_NEWRES_DAYS_DEFAULT.getValue()));
		calculateAndSetDateRange();
	}
	
	private void calculateAndSetDateRange()
	{
		if (form.cmbDays().getValue() != null)
		{
			int days = form.cmbDays().getValue().intValue();
			form.dteTo().setValue(new Date());
			form.dteFrom().setValue(new Date().addDay(-1 * days));
		}
	}

	private void populateHospital() 
	{
		form.cmbHospital().clear();
		
		LocationLiteVoCollection hospColl = domain.listHospitals();
		
		if(hospColl == null)
			return;
		
		for (int i = 0; i < hospColl.size(); i++)
		{
			LocationLiteVo hosp = hospColl.get(i);
			form.cmbHospital().newRow(hosp, hosp.getName());
		}
		
		//LocationLiteVo currentHospital = domain.getCurrentHospital(engine.getCurrentLocation());
		//form.cmbHospital().setValue(currentHospital);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(form.getForms().OCRR.SearchDisciplines.equals(formName))
		{
			if(DialogResult.OK.equals(result))
			{
				populateDisciplineGrid(form.getGlobalContext().OCRR.getSelectedDisciplines());
			}
		}
	}

	private void populateDisciplineGrid(ServiceLiteVoCollection disciplines) 
	{
		form.grdDisciplines().getRows().clear();
		
		if(disciplines == null)
			return;
		
		for(ServiceLiteVo dis : disciplines)
		{
			if(dis == null)
				continue;
			
			if(!disciplineIsAdded(dis))
			{
				grdDisciplinesRow newRow = form.grdDisciplines().getRows().newRow();
				newRow.setColDis(dis.getServiceName());
			
				newRow.setValue(dis);
			}
		}
	}

	private boolean disciplineIsAdded(ServiceLiteVo dis) 
	{
		if(dis == null)
			return false;
		
		for(int i=0; i<form.grdDisciplines().getRows().size(); i++)
		{
			if(dis.equals(form.grdDisciplines().getRows().get(i).getValue()))
				return true;
		}
		
		return false;
	}

	@Override
	protected void onGrdDisciplinesSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.OrdLocGrp().setEnabled(form.cmbHospital().getValue() != null);
		form.qmbOrderingLocation().setEnabled(form.cmbHospital().getValue() != null && form.OrdLocGrp().getValue() != null);
		
		form.imbRemoveDiscipline().setEnabled(form.grdDisciplines().getValue() != null);
		
		boolean isOutpatientDepartmentLabel = getIsOutpatientDepartment();
		form.lblLocation().setValue(isOutpatientDepartmentLabel ? OUTPATIENT_DEPARTMENT_LABEL : LOCATION_LABEL);
		
		form.chkAbnormalPathologyResultsOnly().setVisible(Boolean.TRUE.equals(ConfigFlag.UI.SHOW_ABNORMAL_RESULTS_SEARCH_FILTER.getValue()));
	}
	
	private boolean getIsOutpatientDepartment() 
	{
		boolean isOutpatientDepartmentLabel = false;
		
		String clinicConfig = ConfigFlag.GEN.ORDERING_CLINIC_LOCATION_MANDATORY_FIELDS.getValue();
		
		if(OrdLocGrpEnumeration.rdoClinic.equals(form.OrdLocGrp().getValue()) && (OUTPATIENT_DEPARTMENT_CONFIG.equals(clinicConfig) || OUTPATIENT_DEPARTMENT_HIDE_CLINIC_CONFIG.equals(clinicConfig)))
		{
			isOutpatientDepartmentLabel = true;
		}
		
		return isOutpatientDepartmentLabel;
	}

	@Override
	protected void onImbRemoveDisciplineClick()	throws PresentationLogicException 
	{
		removeDiscipline();
		updateControlsState();
	}

	private void removeDiscipline() 
	{
		if(form.grdDisciplines().getSelectedRowIndex() < 0)
			return;
		
		form.grdDisciplines().getRows().remove(form.grdDisciplines().getSelectedRowIndex());
	}
	
	private void populateDays(int maxDays)
	{
		form.cmbDays().clear();
		for (int x = 1; x <= maxDays; x++)
		{
			form.cmbDays().newRow(new Integer(x), String.valueOf(x));
		}
	}

	public NewResultsCriteriaVo getValue() 
	{
		NewResultsCriteriaVo newResultsSearchCriteria = new NewResultsCriteriaVo();
		
		newResultsSearchCriteria.setSelectedTab(MYRESULTS);
		
		newResultsSearchCriteria.setHospital(form.cmbHospital().getValue());
		
		if(form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoWard))
			newResultsSearchCriteria.setOrderingLocationType(ORDERING_LOCATION_TYPE_WARD);
		else if(form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoED))
			newResultsSearchCriteria.setOrderingLocationType(ORDERING_LOCATION_TYPE_ED);
		else if(form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoClinic))
			newResultsSearchCriteria.setOrderingLocationType(ORDERING_LOCATION_TYPE_CLINIC);
		else if(form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoOther))
			newResultsSearchCriteria.setOrderingLocationType(ORDERING_LOCATION_TYPE_OTHER);
		
		newResultsSearchCriteria.setOrderingLocation(form.qmbOrderingLocation().getValue());
		
		if(getIsOutpatientDepartment() && form.qmbOrderingLocation().getValue() instanceof LocationLiteVo)
		{
			newResultsSearchCriteria.setOutpatientDepartment((LocationLiteVo) form.qmbOrderingLocation().getValue());
		}
		
		if(form.chkCurrentInpatientsOnly().getValue() || form.chkInpatientOrdersPatientDischarged().getValue())
		{
			newResultsSearchCriteria.setInpatientHospital(form.cmbHospital().getValue());
			
			if(form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoWard) && form.qmbOrderingLocation().getValue() instanceof LocationLiteVo)
			{
				newResultsSearchCriteria.setInpatientWard((LocationLiteVo) form.qmbOrderingLocation().getValue());
			}
		}
		
		if(form.getLocalContext().getCurrentHCP() != null && Boolean.TRUE.equals(form.getLocalContext().getCurrentHCP().getIsHCPaResponsibleHCP()))
		{
			newResultsSearchCriteria.setResponsibleHCPForOrder(true);
			newResultsSearchCriteria.setOrder(true);
			newResultsSearchCriteria.setResponsibleHCPForCurrentIP(true);
			newResultsSearchCriteria.setCurrenIP(true);
			newResultsSearchCriteria.setHCP(form.getLocalContext().getCurrentHCP());
			
			if(HcpDisType.MEDICAL.equals(form.getLocalContext().getCurrentHCP().getHcpType()))
			{
				newResultsSearchCriteria.setForReviewByMe(true);
				newResultsSearchCriteria.setReviewingHCP(form.getLocalContext().getCurrentHCP());
			}
		}
		
		newResultsSearchCriteria.setOrderByMe(true);
		newResultsSearchCriteria.setOrderingHCP(form.getLocalContext().getCurrentHCP());
		
		newResultsSearchCriteria.setInpatientOrders(form.chkInpatientOrders().getValue());
		newResultsSearchCriteria.setOutpatientOrders(form.chkOutpatientOrders().getValue());
		newResultsSearchCriteria.setCurrentInpatientsOnly(form.chkCurrentInpatientsOnly().getValue());
		newResultsSearchCriteria.setInpatientOrdersPatientDischarged(form.chkInpatientOrdersPatientDischarged().getValue());
		
		newResultsSearchCriteria.setNewUpdated(form.chkNew().getValue());
		newResultsSearchCriteria.setSeenChecked(form.chkSeenChecked().getValue());
		newResultsSearchCriteria.setChecked(form.chkChecked().getValue());
		newResultsSearchCriteria.setForReview(form.chkReview().getValue());
		newResultsSearchCriteria.setCompleted(form.chkCompleted().getValue());
	
		newResultsSearchCriteria.setFromDate(form.dteFrom().getValue());
		newResultsSearchCriteria.setToDate(form.dteTo().getValue());	
		newResultsSearchCriteria.setDays(form.cmbDays().getValue());
		newResultsSearchCriteria.setNewestFirst(ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()) ? true : false);
		
		newResultsSearchCriteria.setDiscipline(getDisciplines());
		newResultsSearchCriteria.setAbnormalPathologyResultsOnly(form.chkAbnormalPathologyResultsOnly().getValue());
		
		return newResultsSearchCriteria;
	}

	private ServiceLiteVoCollection getDisciplines() 
	{
		if(form.grdDisciplines().getRows().size() == 0)
			return null;
		
		ServiceLiteVoCollection coll = new ServiceLiteVoCollection();
		
		for(int i=0; i<form.grdDisciplines().getRows().size(); i++)
		{
			coll.add(form.grdDisciplines().getRows().get(i).getValue());
		}
		
		return coll;
	}

	@Override
	protected void onCmbDaysValueChanged() throws PresentationLogicException 
	{
		calculateAndSetDateRange();
	}

	@Override
	protected void onRadioButtonOrdLocGrpValueChanged()	throws PresentationLogicException 
	{
		locationRadioButtonValueChange();
		
		updateControlsState();
	}

	private void locationRadioButtonValueChange() 
	{
		form.qmbOrderingLocation().clear();
		form.cmbHospital().setEnabled(true);

		if (form.cmbHospital().getValue() == null)
		{
			form.qmbOrderingLocation().setEnabled(false);
			form.OrdLocGrp().setEnabled(false);
		}
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		setLocationDefaults();
		updateControlsState();
	}

	public String[] validate() 
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.dteFrom().getValue() != null && form.dteTo().getValue() != null)
		{
			if (form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				errors.add("The \"From Date\" is after the \"To Date\"");
			}
		}

		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() == null)
		{
			errors.add("Invalid date range specified.");
		}
		
		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() != null)
		{
			calculateAndSetDateRange();
		}

		if (form.chkNew().getValue() == false && form.chkSeenChecked().getValue() == false && form.chkChecked().getValue() == false && form.chkReview().getValue() == false && form.chkCompleted().getValue() == false)
		{
			errors.add("At least one of the checkboxes for Result Status must be checked");
		}
		
		if(errors != null && errors.size() > 0)
		{
			String[] errorsS = new String[errors.size()];
			errors.toArray(errorsS);
			
			return errorsS;
		}
		
		return null;
	}

	public void setEnabled(Boolean value) 
	{
		boolean val = Boolean.TRUE.equals(value);
		
		form.cmbHospital().setEnabled(val);
		form.OrdLocGrp().setEnabled(val);
		form.qmbOrderingLocation().setEnabled(val);
		
		form.chkInpatientOrders().setEnabled(val);
		form.chkOutpatientOrders().setEnabled(val);
		form.chkCurrentInpatientsOnly().setEnabled(val);
		form.chkInpatientOrdersPatientDischarged().setEnabled(val);

		
		form.chkNew().setEnabled(val);
		form.chkSeenChecked().setEnabled(val);
		form.chkChecked().setEnabled(val);
		form.chkReview().setEnabled(val);
		form.chkCompleted().setEnabled(val);
		form.dteFrom().setEnabled(val);
		form.dteTo().setEnabled(val);
		form.cmbDays().setEnabled(val);
		form.ListResultsBy().setEnabled(val);
		form.grdDisciplines().setEnabled(val);
		form.imbAddDiscipline().setEnabled(val);
		form.imbRemoveDiscipline().setEnabled(val);
		form.chkAbnormalPathologyResultsOnly().setEnabled(val);
		
		if(value)
			updateControlsState();
	}

	public void clear() 
	{
		form.cmbHospital().setValue(null);
		form.OrdLocGrp().setValue(null);
		form.OrdLocGrp().setEnabled(false);
		form.qmbOrderingLocation().setEnabled(false);
		form.qmbOrderingLocation().setValue(null);		
		
		form.chkInpatientOrders().setValue(null);
		form.chkOutpatientOrders().setValue(null);
		form.chkCurrentInpatientsOnly().setValue(null);
		form.chkInpatientOrdersPatientDischarged().setValue(null);

		form.chkNew().setValue(false);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(false);	
		form.chkCompleted().setValue(false); 
		
		form.grdDisciplines().getRows().clear();
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbDays().setValue(null);
		
		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);
		form.chkAbnormalPathologyResultsOnly().setValue(null);
	}

	@Override
	protected void onQmbOrderingLocationTextSubmited(String value) throws PresentationLogicException 
	{
		searchLocations(value);
	}
	
	private void searchLocations(String value)
	{
		if (value == null)
			return;

		form.qmbOrderingLocation().clear();

		LocationLiteVoCollection locations = null;
		ClinicLiteVoCollection clinics = null;
		if (form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoWard))
		{
			locations = domain.listWards(value, form.cmbHospital().getValue());
		}
		else if (form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoED))
		{
			locations = domain.listErDepts(value, form.cmbHospital().getValue());
		}
		else if (form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoClinic))
		{
			if(getIsOutpatientDepartment())
			{
				locations = domain.listOutpatientDepartments(value, form.cmbHospital().getValue());
			}
			else
			{
				clinics = domain.listClinics(value, form.cmbHospital().getValue());
			}
		}
		else if (form.OrdLocGrp().getValue().equals(OrdLocGrpEnumeration.rdoOther))
		{
			locations = domain.listOtherLocations(value, form.cmbHospital().getValue());
		}

		if (locations != null)
		{
			for (int x = 0; x < locations.size(); x++)
			{
				addLocation(locations.get(x));
			}
		}
		else if (clinics != null)
		{
			for (int x = 0; x < clinics.size(); x++)
			{
				addLocation(clinics.get(x));
			}
		}

		if ((locations != null && locations.size() > 1) || (clinics != null && clinics.size() > 1))
			form.qmbOrderingLocation().showOpened();
		else if (locations != null && locations.size() == 1)
			form.qmbOrderingLocation().setValue(locations.get(0));
		else if (clinics != null && clinics.size() == 1)
			form.qmbOrderingLocation().setValue(clinics.get(0));
	}
	
	private void addLocation(ValueObject location)
	{
		addLocation(location, false);
	}

	private void addLocation(ValueObject location, boolean select)
	{
		if (location == null)
			return;
		if (location instanceof LocationLiteVo)
		{
			LocationLiteVo loc = (LocationLiteVo) location;
			form.qmbOrderingLocation().newRow(loc, loc.getNameIsNotNull() ? loc.getName() : "<unknown>");
		}
		else if (location instanceof ClinicLiteVo)
		{
			ClinicLiteVo loc = (ClinicLiteVo) location;
			form.qmbOrderingLocation().newRow(loc, loc.getClinicNameIsNotNull() ? loc.getClinicName() : "<unknown>");
		}
		if (select)
			form.qmbOrderingLocation().setValue(location);
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		// Needed for data binding
	}

	public void setValue(NewResultsCriteriaVo criteria) 
	{
		clear();
		
		if(criteria == null)
			return;
		
		form.cmbHospital().setValue(criteria.getHospital());
		
		if(criteria.getOrderingLocationTypeIsNotNull())
		{
			if(criteria.getOrderingLocationType().equals(ORDERING_LOCATION_TYPE_WARD))
				form.OrdLocGrp().setValue(OrdLocGrpEnumeration.rdoWard);
			else if(criteria.getOrderingLocationType().equals(ORDERING_LOCATION_TYPE_ED))
				form.OrdLocGrp().setValue(OrdLocGrpEnumeration.rdoED);
			else if(criteria.getOrderingLocationType().equals(ORDERING_LOCATION_TYPE_CLINIC))
				form.OrdLocGrp().setValue(OrdLocGrpEnumeration.rdoClinic);
			else if(criteria.getOrderingLocationType().equals(ORDERING_LOCATION_TYPE_OTHER))
				form.OrdLocGrp().setValue(OrdLocGrpEnumeration.rdoOther);
		}
		
		if((criteria.getOrderingLocation() instanceof ClinicLiteVo && !getIsOutpatientDepartment())
				|| (criteria.getOrderingLocation() instanceof LocationLiteVo && (criteria.getOutpatientDepartment() == null || (criteria.getOutpatientDepartment() != null && getIsOutpatientDepartment()))))
		{
			form.qmbOrderingLocation().newRow(criteria.getOrderingLocation(), criteria.getOrderingLocation().toString());
			form.qmbOrderingLocation().setValue(criteria.getOrderingLocation());
		}	
		
		form.chkInpatientOrders().setValue(criteria.getInpatientOrders());
		form.chkOutpatientOrders().setValue(criteria.getOutpatientOrders());
		form.chkCurrentInpatientsOnly().setValue(criteria.getCurrentInpatientsOnly());
		form.chkInpatientOrdersPatientDischarged().setValue(criteria.getInpatientOrdersPatientDischarged());

		form.chkNew().setValue(criteria.getNewUpdated());
		form.chkSeenChecked().setValue(criteria.getSeenChecked());
		form.chkChecked().setValue(criteria.getChecked());
		form.chkReview().setValue(criteria.getForReview());	
		form.chkCompleted().setValue(criteria.getCompleted()); 
		
		populateDisciplineGrid(criteria.getDiscipline());
		
		form.dteFrom().setValue(criteria.getFromDate());
		form.dteTo().setValue(criteria.getToDate());
		form.cmbDays().setValue(criteria.getDays());
		
		form.ListResultsBy().setValue(Boolean.TRUE.equals(criteria.getNewestFirst()) ? ListResultsByEnumeration.rdoNewestFirst : ListResultsByEnumeration.rdoOldestFirst );
		form.chkAbnormalPathologyResultsOnly().setValue(criteria.getAbnormalPathologyResultsOnly());
		
		updateControlsState();
	}

	@Override
	protected void onChkOutpatientOrdersValueChanged()	throws PresentationLogicException 
	{
		if (form.chkOutpatientOrders().getValue())
		{
			if(!OrdLocGrpEnumeration.rdoClinic.equals(form.OrdLocGrp().getValue()))
			{
				form.qmbOrderingLocation().setValue(null);
			}
			
			form.chkCurrentInpatientsOnly().setValue(null);
			form.chkInpatientOrdersPatientDischarged().setValue(null);
		}
	}

	@Override
	protected void onChkInpatientOrdersValueChanged() throws PresentationLogicException 
	{
		if (form.chkInpatientOrders().getValue())
		{
			if(!OrdLocGrpEnumeration.rdoWard.equals(form.OrdLocGrp().getValue()))
			{
				form.qmbOrderingLocation().setValue(null);
			}
			
			form.chkCurrentInpatientsOnly().setValue(null);
			form.chkInpatientOrdersPatientDischarged().setValue(null);
		}
	}

	@Override
	protected void onDteToValueChanged() throws PresentationLogicException 
	{
		if (form.dteTo().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteFrom().getValue() == null)
				form.dteFrom().setValue(form.dteTo().getValue());
		}
	}

	@Override
	protected void onDteFromValueChanged() throws PresentationLogicException 
	{
		if (form.dteFrom().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteTo().getValue() == null)
				form.dteTo().setValue(form.dteFrom().getValue());
		}
	}

	@Override
	protected void onChkCurrentInpatientsOnlyValueChanged()	throws PresentationLogicException 
	{
		if(form.chkCurrentInpatientsOnly().getValue())
		{
			if(!OrdLocGrpEnumeration.rdoWard.equals(form.OrdLocGrp().getValue()))
			{
				form.qmbOrderingLocation().setValue(null);
			}
			form.chkInpatientOrders().setValue(null);
			form.chkOutpatientOrders().setValue(null);
			form.chkInpatientOrdersPatientDischarged().setValue(null);
		}
	}

	@Override
	protected void onChkInpatientOrdersPatientDischargedValueChanged() throws PresentationLogicException 
	{
		if(form.chkInpatientOrdersPatientDischarged().getValue())
		{
			if(!OrdLocGrpEnumeration.rdoWard.equals(form.OrdLocGrp().getValue()))
			{
				form.qmbOrderingLocation().setValue(null);
			}
			form.chkInpatientOrders().setValue(null);
			form.chkOutpatientOrders().setValue(null);
			form.chkCurrentInpatientsOnly().setValue(null);
		}
	}

	public SortOrder getSortOrder() 
	{
		if(ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.DESCENDING;
		else if(ListResultsByEnumeration.rdoOldestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.ASCENDING;
		
		return SortOrder.DESCENDING;
	}
}
