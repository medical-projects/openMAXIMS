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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.trackingstatusdialog;

import java.util.ArrayList;

import ims.core.vo.MemberOfStaffLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.trackingstatusdialog.GenForm.grdTrackingStatusRow;
import ims.emergency.forms.trackingstatusdialog.GenForm.grdTrackingStatusRowCollection;
import ims.emergency.vo.SeenByHCPVo;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForTrackingStatusVo;
import ims.emergency.vo.enums.EDSeenByAndCompleteEvent;
import ims.emergency.vo.lookups.LookupHelper;
import ims.emergency.vo.lookups.TrackingStatus;
import ims.emergency.vo.lookups.TrackingStatusCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
		form.setMode(FormMode.EDIT);
	}

	private void open()
	{
		populateScreenWithLookups();
		populateScreenFromData();
	}

	private void populateScreenFromData()
	{
		form.getLocalContext().setselectedTracking(domain.getTracking(form.getGlobalContext().Emergency.getTracking()));

		TrackingAttendanceStatusVo currentStatus = form.getLocalContext().getselectedTracking().getCurrentStatus();

		if (currentStatus == null)
			return;

		grdTrackingStatusRowCollection statusCollection = form.grdTrackingStatus().getRows();

		for (int i = 0; i < statusCollection.size(); i++)
		{
			if (statusCollection.get(i).getValue().getID() == currentStatus.getStatus().getID())
			{
				statusCollection.get(i).setcolSelect(true);
				break;
			}
		}
	}

	private void populateScreenWithLookups()
	{
		form.grdTrackingStatus().getRows().clear();
		TrackingStatusCollection trackingStatusCollection = LookupHelper.getTrackingStatus(domain.getLookupService());

		if (trackingStatusCollection == null)
			return;

		for (int i = 0; i < trackingStatusCollection.size(); i++)
		{
			//WDEV-16987
			if (TrackingStatus.DISCHARGED.equals(trackingStatusCollection.get(i)))
				continue;
			
			grdTrackingStatusRow newAreaColumn = form.grdTrackingStatus().getRows().newRow();
			newAreaColumn.setcolStatus(trackingStatusCollection.get(i).getIItemText());
			newAreaColumn.setcolSelect(false);
			newAreaColumn.setValue(trackingStatusCollection.get(i));
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-17410
		String[] errors = getUIErrors();;
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		//WDEV-16816
		if (form.getForms().Emergency.EDSeenByAndCompleteDialog.equals(engine.getParentDialogFormName())
				|| form.getForms().Emergency.EDDecisionToAdmitDialog.equals(engine.getParentDialogFormName())
				|| form.getForms().Emergency.BedAwaitingBedAvailable.equals(engine.getParentDialogFormName())
				
				|| form.getForms().Emergency.EDAssessmentDialog.equals(engine.getParentDialogFormName())
				|| form.getForms().Emergency.EDWorklistToAssessmentForm.equals(engine.getPreviosFormName())
				|| form.getForms().Emergency.EDTriageWorklistToAssessmentForm.equals(engine.getPreviosFormName())
				|| form.getForms().Emergency.EDClinicianWorklistToAssessmentForm.equals(engine.getPreviosFormName()))
		{
			form.getGlobalContext().Emergency.setTrackingAttendanceStatus(populateDataFromScreen());
			engine.close(DialogResult.OK);
			return;
		}
		
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}

	//WDEV-17410
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
	
		if (!isStatusSelected())
		{
			errors.add("Please choose a Status. ");
		}
	
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	//WDEV-17410
	private boolean isStatusSelected()
	{
		grdTrackingStatusRowCollection statusCollection = form.grdTrackingStatus().getRows();

		for (int i = 0; i < statusCollection.size(); i++)
		{
			if (statusCollection.get(i).getcolSelect() == true)
			{
				return true;
			}
		}
		
		return false;
	}

	private boolean save()
	{
		TrackingAttendanceStatusVo trackingAttendanceStatus = populateDataFromScreen();

		TrackingForTrackingStatusVo TrackingToSave = form.getLocalContext().getselectedTracking();

		TrackingToSave.setCurrentStatus(trackingAttendanceStatus);

		String[] errors = TrackingToSave.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			domain.saveTracking(TrackingToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}

		return true;
	}

	private TrackingAttendanceStatusVo populateDataFromScreen()
	{
		TrackingAttendanceStatusVo attendanceStatus = new TrackingAttendanceStatusVo();
		grdTrackingStatusRowCollection statusCollection = form.grdTrackingStatus().getRows();

		attendanceStatus.setPatient(form.getGlobalContext().Core.getPatientShort());
		attendanceStatus.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		attendanceStatus.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		attendanceStatus.setTrackingArea(form.getLocalContext().getselectedTracking().getCurrentArea());
		attendanceStatus.setStatusDatetime(new DateTime());
		attendanceStatus.setCreatedBy((MemberOfStaffLiteVo) domain.getMosUser());

		for (int i = 0; i < statusCollection.size(); i++)
		{
			if (statusCollection.get(i).getcolSelect() == true)
			{
				attendanceStatus.setStatus(statusCollection.get(i).getValue());
				break;
			}
		}

		//WDEV-16777
		attendanceStatus.setPrevStatus((form.getLocalContext().getselectedTracking()!=null && form.getLocalContext().getselectedTracking().getCurrentStatus()!=null  ) ? form.getLocalContext().getselectedTracking().getCurrentStatus().getStatus() : null);
		
		return attendanceStatus;
	}

	@Override
	protected void onGrdStatusGridCheckBoxClicked(int column, grdTrackingStatusRow row, boolean isChecked) throws PresentationLogicException
	{
		clearAllRows(row, isChecked);
	}

	private void clearAllRows(grdTrackingStatusRow row, boolean isChecked)
	{
		grdTrackingStatusRowCollection statusCollection = form.grdTrackingStatus().getRows();

		for (int i = 0; i < statusCollection.size(); i++)
		{
			if (statusCollection.get(i).getValue().getID() == row.getValue().getID())
				statusCollection.get(i).setcolSelect(isChecked);
			else
				statusCollection.get(i).setcolSelect(false);
		}
	}
}
