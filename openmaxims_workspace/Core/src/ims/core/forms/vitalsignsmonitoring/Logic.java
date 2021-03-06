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
// This code was generated by Callum Wells using IMS Development Environment (version 1.45 build 2420.24822)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.vitalsignsmonitoring;

import java.util.ArrayList;

import ims.core.forms.vitalsignsmonitoring.GenForm.grdDetailsRow;
import ims.core.forms.vitalsignsmonitoring.GenForm.ctnContainer.grdVitalsRow;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.VitalSignItemFrequencyVo;
import ims.core.vo.VitalSignItemFrequencyVoCollection;
import ims.core.vo.VitalSignMonitoringGroupVo;
import ims.core.vo.VitalSignMonitoringGroupVoCollection;
import ims.core.vo.VitalSignMonitoringVo;
import ims.core.vo.VitalSignMonitoringVoCollection;
import ims.core.vo.lookups.VSType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		form.Group1().setValue(GenForm.Group1Enumeration.rdoCurrent);
		
		open();
	}

	private void open()
	{
		clearInstanceControls();

		form.setMode(FormMode.VIEW);
		loadGroupings();
		
		populateGrid();

		if (form.grdDetails().getRows().size() > 0)
		{
			if (form.getLocalContext().getLastRecordIsNotNull())
				form.grdDetails().setValue(form.getLocalContext().getLastRecord());
			else
				form.grdDetails().setValue(form.grdDetails().getValues().get(0));

			try
			{
				onGrdDetailsSelectionChanged();
			}
			catch (PresentationLogicException e)
			{
				engine.showMessage(e.toString());
			}
		}
	}

	private void populateGrid()
	{
		VitalSignMonitoringVoCollection coll = null;

		try
		{
			coll = domain.listVitalSignsMonitoringVo(form.getGlobalContext().Core.getCurrentCareContext());
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}

		form.grdDetails().getRows().clear();
		form.getLocalContext().setVitalSignsMonitoring(null);
		
		if (coll != null)
		{
			populateVitalSignsType(coll);
		}
		enableControls(false);
		form.btnUpdate().setVisible(form.grdDetails().getValue() != null);
	}

	private void populateVitalSignsType(VitalSignMonitoringVoCollection coll)
	{
		VitalSignMonitoringVo item = null;

		boolean bAll = false;
		if (form.Group1().getValue().equals(GenForm.Group1Enumeration.rdoAll))
			bAll = true;

		if (coll != null)
		{
			grdDetailsRow row = null;
			for (int i = 0; i < coll.size(); i++)
			{
				item = coll.get(i);

				if (!bAll)
					if (item.getStoppedDateTimeIsNotNull())
						continue;

				row = form.grdDetails().getRows().newRow();

				if (item.getVitalSignGroupIsNotNull())
					row.setColObservation(item.getVitalSignGroup().getGroupName());
				row.setColDetails(item.getRequestDetails());
				if (item.getGroupFrequencyIsNotNull())
					row.setColFrequency(item.getGroupFrequency().getText());
				if (item.getStartDateTimeIsNotNull())
					row.setColStartDateTime(item.getStartDateTime().toString());
				row.setColDuration(item.getDurationValue().toString() + " " + item.getDurationUnit().getText());
				row.setValue(item);

				row.setExpanded(true);
				row.setBold(true);
				row.setBackColor(Color.Bisque);

				if (item.getItemFrequencyIsNotNull())
					populateVitalSigns(item, row);

			}
		}
	}

	private void populateVitalSigns(VitalSignMonitoringVo item, grdDetailsRow row)
	{
		VitalSignItemFrequencyVo voVSItemFreq;

		if (item.getItemFrequency() != null && row != null)
		{
			for (int i = 0; i < item.getItemFrequency().size(); i++)
			{
				voVSItemFreq = item.getItemFrequency().get(i);
				row = form.grdDetails().getRows().newRow();
				if (voVSItemFreq.getVitalSignTypeIsNotNull())
					row.setColObservation(voVSItemFreq.getVitalSignType().getIItemText());
				if (voVSItemFreq.getFrequencyIsNotNull())
					row.setColFrequency(voVSItemFreq.getFrequency().getText());
				row.setSelectable(false);
				row.setValue(item);
			}
		}
	}

	private void loadGroupings()
	{
		VitalSignMonitoringGroupVoCollection coll = new VitalSignMonitoringGroupVoCollection();
		VitalSignMonitoringGroupVo item = null;

		try
		{
			coll = domain.listVitalSignsMonitoringGroups();
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}
		if (coll != null)
		{
			form.ctn().cmbObservation().clear();
			for (int i = 0; i < coll.size(); i++)
			{
				item = coll.get(i);
				if(item.getIsActive() != null && item.getIsActive().equals(Boolean.TRUE))	//wdev-12484
					form.ctn().cmbObservation().newRow(item, item.getGroupName());
			}
		}
	}

	protected void onCmbObservationValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setVitalSignMonitoringGroup(form.ctn().cmbObservation().getValue());
		form.ctn().cmbFrequency().setValue(null);
		form.ctn().grdVitals().setReadOnly(false);
		VitalSignMonitoringGroupVo item = form.ctn().cmbObservation().getValue();

		if (item != null)
		{
			if (item.getVitalsSigns() != null)
			{
				form.ctn().grdVitals().getRows().clear();

				VSType lkpItem;
				grdVitalsRow row;
				for (int i = 0; i < item.getVitalsSigns().size(); i++)
				{
					lkpItem = item.getVitalsSigns().get(i);

					row = form.ctn().grdVitals().getRows().newRow();
					row.setColVitalSign(lkpItem);
					row.setColSelect(true);
					row.setValue(null);
				}
			}
		}
		else
		{
			form.ctn().grdVitals().getRows().clear(); //WDEV-15302
		}
	}

	protected void onCmbFrequencyValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.ctn().grdVitals().getRows() != null)
		{
			for (int i = 0; i < form.ctn().grdVitals().getRows().size(); i++)
				form.ctn().grdVitals().getRows().get(i).setColFrequency(form.ctn().cmbFrequency().getValue());
		}
	}

	protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setVitalSignsMonitoring(form.grdDetails().getValue());

		clearInstanceControls();
		setInstanceDetails(form.grdDetails().getValue());

		form.btnUpdate().setVisible(true);
		form.btnUpdate().setEnabled(form.grdDetails().getValue() != null);
	}

	private void setInstanceDetails(VitalSignMonitoringVo value)
	{

		form.getLocalContext().setVitalSignMonitoringGroup(form.ctn().cmbObservation().getValue());

		if (value != null)
		{

			if (value.getDurationUnitIsNotNull())
				form.ctn().cmbDuration().setValue(value.getDurationUnit());
			if (value.getGroupFrequencyIsNotNull())
				form.ctn().cmbFrequency().setValue(value.getGroupFrequency());
			if (value.getVitalSignGroupIsNotNull())
			{
				if(form.ctn().cmbObservation().getValues().contains(value.getVitalSignGroup()))			//wdev-12484
					form.ctn().cmbObservation().setValue(value.getVitalSignGroup());
				else
				{
					form.ctn().cmbObservation().newRow(value.getVitalSignGroup(),value.getVitalSignGroup().getGroupName());	//wdev-12484
					form.ctn().cmbObservation().setValue(value.getVitalSignGroup());
				}
			}
			if (value.getAuthoringInformationIsNotNull())
				form.ctn().customControlAuthoringInfo().setValue(value.getAuthoringInformation());
			if (value.getStartDateTimeIsNotNull())
				form.ctn().dtimStart().setValue(value.getStartDateTime());
			if (value.getStoppedDateTimeIsNotNull())
				form.ctn().dtimStopped().setValue(value.getStoppedDateTime());
			if (value.getDurationValueIsNotNull())
				form.ctn().intDuration().setValue(value.getDurationValue());
			if (value.getRequestDetailsIsNotNull())
				form.ctn().txtDetails().setValue(value.getRequestDetails());
			if (value.getStoppedByIsNotNull())
			{
				form.ctn().qmbStopped().newRow(value.getStoppedBy(), value.getStoppedBy().toString());
				form.ctn().qmbStopped().setValue(value.getStoppedBy());
			}
			if (value.getRequestedByIsNotNull())
			{
				form.ctn().qmbRequested().newRow(value.getRequestedBy(), value.getRequestedBy().toString());
				form.ctn().qmbRequested().setValue(value.getRequestedBy());
			}
			if (value.getItemFrequencyIsNotNull())
			{
				VitalSignItemFrequencyVoCollection coll = value.getItemFrequency();
				coll.sort();
				VitalSignItemFrequencyVo item;
				if (coll != null)
				{
					form.ctn().grdVitals().getRows().clear();

					grdVitalsRow row;
					for (int i = 0; i < coll.size(); i++)
					{
						item = coll.get(i);
						row = form.ctn().grdVitals().getRows().newRow();

						if (item.getVitalSignTypeIsNotNull())
							row.setColVitalSign(item.getVitalSignType());
						if (item.getFrequencyIsNotNull())
							row.setColFrequency(item.getFrequency());

						row.setValue(item);
						row.setColSelect(true);
					}
				}
			}
		}
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();

	}

	private void newInstance()
	{
		form.getLocalContext().setVitalSignsMonitoring(new VitalSignMonitoringVo());
		form.getLocalContext().setVitalSignMonitoringGroup(null);
		clearInstanceControls();
		form.setMode(FormMode.EDIT);
		loadGroupings();	//wdev-12484
		setDefaultValues();
		enableControls(true);

	}

	private void setDefaultValues()
	{
		form.ctn().customControlAuthoringInfo().initializeComponent();
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		enableControls(false);
	}

	private void enableControls(boolean b)
	{
		form.ctn().cmbObservation().setEnabled(b);
		form.ctn().cmbFrequency().setEnabled(b);
		form.ctn().dtimStart().setEnabled(b);
		form.ctn().cmbDuration().setEnabled(b);
		form.ctn().intDuration().setEnabled(b);
		form.ctn().setcustomControlAuthoringInfoEnabled(b);
		form.Group1().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.btnUpdate().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.btnNew().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.grdDetails().setEnabled(form.getMode().equals(FormMode.VIEW));
		
		form.ctn().customControlAuthoringInfo().setIsRequiredPropertyToControls(FormMode.EDIT.equals(form.getMode()));//WDEV-17261
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		VitalSignMonitoringVo voVitalSignsMonitoring;

		if (form.getLocalContext().getVitalSignsMonitoringIsNotNull())
			voVitalSignsMonitoring = form.getLocalContext().getVitalSignsMonitoring();
		else
			voVitalSignsMonitoring = new VitalSignMonitoringVo();

		if (form.getGlobalContext().Core.getClinicalContactIsNotNull())
			voVitalSignsMonitoring.setClinicalContact(form.getGlobalContext().Core.getClinicalContact());
		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			voVitalSignsMonitoring.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		voVitalSignsMonitoring.setDurationUnit(form.ctn().cmbDuration().getValue());
		voVitalSignsMonitoring.setDurationValue(form.ctn().intDuration().getValue());
		voVitalSignsMonitoring.setGroupFrequency(form.ctn().cmbFrequency().getValue());
		voVitalSignsMonitoring.setRequestDetails(form.ctn().txtDetails().getValue());
		voVitalSignsMonitoring.setRequestedBy(form.ctn().qmbRequested().getValue());
		voVitalSignsMonitoring.setStartDateTime(form.ctn().dtimStart().getValue());
		voVitalSignsMonitoring.setStoppedBy(form.ctn().qmbStopped().getValue());
		voVitalSignsMonitoring.setStoppedDateTime(form.ctn().dtimStopped().getValue());

		voVitalSignsMonitoring.setAuthoringInformation(form.ctn().customControlAuthoringInfo().getValue());
		
		voVitalSignsMonitoring.setVitalSignGroup(form.getLocalContext().getVitalSignMonitoringGroup());

		VitalSignItemFrequencyVoCollection voVitalSignItemFreqColl = new VitalSignItemFrequencyVoCollection();
		grdVitalsRow row;
		if (form.ctn().grdVitals().getRows() != null)
		{
			for (int i = 0; i < form.ctn().grdVitals().getRows().size(); i++)
			{
				VitalSignItemFrequencyVo voVitalSignItemFreq = new VitalSignItemFrequencyVo();

				row = form.ctn().grdVitals().getRows().get(i);

				if (!row.getColSelect())
					continue;

				if (row.getValue() != null)
					voVitalSignItemFreq = row.getValue();
				voVitalSignItemFreq.setFrequency(row.getColFrequency());
				voVitalSignItemFreq.setVitalSignType(row.getColVitalSign());
				voVitalSignItemFreqColl.add(voVitalSignItemFreq);
			}
			if (voVitalSignItemFreqColl != null)
				voVitalSignsMonitoring.setItemFrequency(voVitalSignItemFreqColl);
		}
		
		
		ArrayList<String> screenErrors = new ArrayList<String>();
		
		if(form.ctn().customControlAuthoringInfo().getErrors()!= null && form.ctn().customControlAuthoringInfo().getErrors().length() > 0 )	
		{
			for (int i = 0; i < form.ctn().customControlAuthoringInfo().getErrors().length(); i++)
			{
				screenErrors.add(form.ctn().customControlAuthoringInfo().getErrors());
			}	
		}
		
		//WDEV-15453
		if (form.ctn().dtimStart().getValue() != null && form.ctn().dtimStopped().getValue() != null && form.ctn().dtimStart().getValue().isGreaterThan(form.ctn().dtimStopped().getValue()))
		{
			screenErrors.add("Stop Date/Time should be greater than Start Date/Time");
		}
		
		
		String[] arrErrors = voVitalSignsMonitoring.validate();
		String[] arrScreenAndVoErrors = addScreenErrorsToVOErrors(screenErrors, arrErrors);
		if (arrScreenAndVoErrors.length != 0)
		{
			engine.showErrors("Validation Errors", arrScreenAndVoErrors);
			return;
		}

		try
		{
			voVitalSignsMonitoring = domain.saveVitalSignsMonitoringVo(voVitalSignsMonitoring);
			form.getLocalContext().setLastRecord(voVitalSignsMonitoring);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			onBtnCancelClick();
			return;
		}

		open();
	}

	private String[] addScreenErrorsToVOErrors(ArrayList screenErrors,  String[] arrErrors)
	{
		String[] arrAllErrors = null;

		if (arrErrors != null)
		{
			arrAllErrors = new String[screenErrors.size() + arrErrors.length];
			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);

			int i = 0;
			for (int p = screenErrors.size(); p < arrAllErrors.length; p++)
			{
				arrAllErrors[p] = arrErrors[i];
				i++;
			}
		}
		else
		{
			arrAllErrors = new String[screenErrors.size()];

			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);
		}

		return arrAllErrors;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		open();
		form.setMode(FormMode.VIEW);
	}

	private void clearInstanceControls()
	{
		form.ctn().cmbDuration().setValue(null);
		form.ctn().cmbFrequency().setValue(null);
		form.ctn().cmbObservation().setValue(null);
		form.ctn().dtimStart().setValue(null);
		form.ctn().dtimStopped().setValue(null);
		form.ctn().grdVitals().setValue(null);
		form.ctn().intDuration().setValue(null);
		form.ctn().qmbRequested().setValue(null);
		form.ctn().qmbStopped().setValue(null);
		form.ctn().txtDetails().setValue(null);
		form.ctn().grdVitals().getRows().clear();
		form.ctn().customControlAuthoringInfo().setValue(null);
	}

	protected void onQmbStoppedTextSubmited(String value) throws PresentationLogicException
	{
		form.ctn().qmbStopped().clear();

		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);

		HcpLiteVoCollection coll = new HcpLiteVoCollection();
		try
		{
			coll = domain.listHCPs(filter);
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}
		for (int i = 0; i < coll.size(); i++)
		{
			HcpLiteVo med = coll.get(i);
			form.ctn().qmbStopped().newRow(med, med.toString());
		}
		if (coll.size() == 1)
		{
			form.ctn().qmbStopped().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctn().qmbStopped().showOpened();
		}
	}

	protected void onQmbRequestedTextSubmited(String value) throws PresentationLogicException
	{
		form.ctn().qmbRequested().clear();

		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);

		HcpLiteVoCollection coll = new HcpLiteVoCollection();
		try
		{
			coll = domain.listHCPs(filter);
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < coll.size(); i++)
		{
			HcpLiteVo med = coll.get(i);
			form.ctn().qmbRequested().newRow(med, med.toString());
		}
		if (coll.size() == 1)
		{
			form.ctn().qmbRequested().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctn().qmbRequested().showOpened();
		}
	}

	protected void onRadioButtonGroup1ValueChanged() throws PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		clearInstanceControls();
		populateGrid();
	}

	protected void onGrdVitalsGridCheckBoxClicked(int column, grdVitalsRow row, boolean isChecked) throws PresentationLogicException
	{
		if (!isChecked)
			row.setBackColor(Color.LightBlue);
		else
			row.setBackColor(Color.White);

		row.setColVitalSignReadOnly(!isChecked);
		row.setColFrequencyReadOnly(!isChecked);
	}
}
