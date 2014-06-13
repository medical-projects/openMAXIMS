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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.sendtoxray;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.SentToXrayVo;
import ims.emergency.vo.SentToXrayVoCollection;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForSendToXRayVo;
import ims.emergency.vo.lookups.TrackingStatus;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()));

		form.btnNew().setEnabled(FormMode.VIEW.equals(form.getMode()) && domain.isMostRecentRecordReturned(form.getGlobalContext().Core.getCurrentCareContext()));

		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);

		form.ccAllocatedBy().isRequired(FormMode.EDIT.equals(form.getMode()));

		// state for Returned DateTime and SetCurrentStatus combo
		form.chkReturned().setVisible(form.recbrSentToXRay().getValue() != null);
		form.chkReturned().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);
		
		form.lblReturnedDateTime().setVisible(form.chkReturned().getValue());
		form.dtimReturned().setVisible(form.chkReturned().getValue());
		form.lblSetCurrent().setVisible(form.chkReturned().getValue());
		form.lblStatusTo().setVisible(form.chkReturned().getValue());
		form.cmbSetCurrentStatus().setVisible(form.chkReturned().getValue());
		form.cmbSetCurrentStatus().setVisible(form.chkReturned().getValue());

		form.dtimReturned().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);
		form.lblSetCurrent().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);
		form.lblStatusTo().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);
		form.cmbSetCurrentStatus().setEnabled(FormMode.EDIT.equals(form.getMode()) && form.recbrSentToXRay().getValue() != null);

		form.dtimReturned().setRequired(form.chkReturned().getValue());

		// in view mode Label for statusCombo should be : "Current Status:", In Edit Mode it should be "Set Current Status To:"
		form.lblSetCurrent().setValue(FormMode.EDIT.equals(form.getMode()) ? "Set Current" : "     Current");
		form.lblStatusTo().setValue(FormMode.EDIT.equals(form.getMode()) ? "Status to:" : "     Status:");

		// in edit mode it should not be a value for statusCombo
		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.cmbSetCurrentStatus().setValue(null);
		}

	}

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setcurrentTracking(domain.getTracking(form.getGlobalContext().Emergency.getTracking()));
		open();
		
		//wdev-17714
		if( form.recbrSentToXRay().size() == 0 || (form.getLocalContext().getcurrentTrackingIsNotNull() && !Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsCurrentlyInXray())) )
		{
			newInstance();
		}
		else if( form.getLocalContext().getcurrentTrackingIsNotNull() && form.getLocalContext().getcurrentTracking().getIsCurrentlyInXrayIsNotNull())
		{
			updateInstance();
			form.chkReturned().setValue(true);
			form.dtimReturned().setValue(new DateTime());
		}
		//end wdev-17714
	}

	private void open()
	{
		populateScreenFromData();
		form.setMode(FormMode.VIEW);
	}

	private void populateScreenFromData()
	{
		populateRecordBrowser();
		populateInstanceControls(form.getLocalContext().getselectedSendToXRay());
	}

	private void populateInstanceControls(SentToXrayVo selectedSendToXRay)
	{
		clearInstanceControls();

		if (selectedSendToXRay == null)
		{
			return;
		}

		selectedSendToXRay = domain.getSentToXRay(selectedSendToXRay);

		form.ccAllocatedBy().setValue(selectedSendToXRay.getSentBy());
		form.dtimSent().setValue(selectedSendToXRay.getSentDateTime());
		form.dtimReturned().setValue(selectedSendToXRay.getReturnedDateTime());
		
		if (selectedSendToXRay.getReturnedDateTime()!=null)
		{
			form.chkReturned().setValue(true);
			form.dtimReturned().setValue(selectedSendToXRay.getReturnedDateTime());
			if (form.getLocalContext().getcurrentTracking().getCurrentStatus()!=null)
			{
				form.cmbSetCurrentStatus().setValue(form.getLocalContext().getcurrentTracking().getCurrentStatus().getStatus());
			}
		}
	}

	private void clearInstanceControls()
	{
		form.ccAllocatedBy().clear();
		form.dtimSent().setValue(null);
		form.dtimReturned().setValue(null);
		form.chkReturned().setValue(null);

	}

	private void populateRecordBrowser()
	{
		form.recbrSentToXRay().clear();

		SentToXrayVoCollection collSentToXRay = domain.getAllSentToXRay(form.getGlobalContext().Core.getCurrentCareContext());

		if (collSentToXRay == null)
		{
			return;
		}

		for (int i = 0; i < collSentToXRay.size(); i++)
		{
			SentToXrayVo sentToXRay = collSentToXRay.get(i);

			StringBuffer string = new StringBuffer();

			if (sentToXRay.getSentDateTimeIsNotNull())
			{
				string.append("Sent on: "+sentToXRay.getSentDateTime());
			}

			if (sentToXRay.getSentByIsNotNull())
			{
				string.append(" - "+sentToXRay.getSentBy().getName());
			}

			if (sentToXRay.getReturnedDateTimeIsNotNull())
			{
				string.append(" - Returned on: "+sentToXRay.getReturnedDateTime());
			}

			form.recbrSentToXRay().newRow(sentToXRay, string.toString());
		}

		if (collSentToXRay.size() > 0 && form.getLocalContext().getselectedSendToXRay() == null)
		{
			form.getLocalContext().setselectedSendToXRay(collSentToXRay.get(0));
		}

		form.recbrSentToXRay().setValue(form.getLocalContext().getselectedSendToXRay());
		populateInstanceControls(form.getLocalContext().getselectedSendToXRay());

	}

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//open();
		engine.close(DialogResult.CANCEL);	//wdev-17714
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			//open();
			engine.close(DialogResult.OK);	//wdev-17714
		}
	}

	private boolean save()
	{
		//WDEV-17251
		SentToXrayVo XRayClone = (form.getLocalContext().getselectedSendToXRay() != null ? (SentToXrayVo)form.getLocalContext().getselectedSendToXRay().clone() : null);
		SentToXrayVo sentToXRayToSave = populateInstanceDataFromScreen(XRayClone);

		String[] errors = sentToXRayToSave.validate(getUIErrors());// 	WDEV-15334

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		// Check SOE
		if (sentToXRayToSave.getID_SentToXrayIsNotNull() && domain.isStale(sentToXRayToSave))
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if (form.getLocalContext().getselectedSendToXRayIsNotNull())
			{
				form.getLocalContext().setselectedSendToXRay(domain.getSentToXRay(form.getLocalContext().getselectedSendToXRay()));
			}
			if (form.getLocalContext().getcurrentTracking() != null)
			{
				form.getLocalContext().setcurrentTracking(domain.getTracking(form.getLocalContext().getcurrentTracking()));
			}
			open();
			return false;
		}

		TrackingForSendToXRayVo trackingToSave = null;
		if (form.getLocalContext().getcurrentTracking().getCurrentAreaIsNotNull() && !Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()))
		{
			trackingToSave = form.getLocalContext().getcurrentTracking();

			//WDEV-17251
			if (sentToXRayToSave.getReturnedDateTime() == null && (sentToXRayToSave.getID_SentToXray() == null || form.getLocalContext().getselectedSendToXRay() != null && form.getLocalContext().getselectedSendToXRay().getReturnedDateTime() != null))
			{
				TrackingAttendanceStatusVo trackingStatusToSave = populateTrackingAttendanceStatus(ims.emergency.vo.lookups.TrackingStatus.SENT_TO_XRAY);
				trackingToSave.setIsCurrentlyInXray(true);
				trackingToSave.setCurrentStatus(trackingStatusToSave);

			}
			else if (sentToXRayToSave.getReturnedDateTimeIsNotNull())
			{
				trackingToSave.setIsCurrentlyInXray(false);

				if (form.cmbSetCurrentStatus().getValue() != null)
				{
					TrackingAttendanceStatusVo trackingStatusToSave = populateTrackingAttendanceStatus(form.cmbSetCurrentStatus().getValue());
					trackingToSave.setCurrentStatus(trackingStatusToSave);
				}
			}
		}

		try
		{
			if (trackingToSave != null)
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				form.getLocalContext().setselectedSendToXRay(domain.save(sentToXRayToSave, trackingToSave));
				form.getLocalContext().setcurrentTracking(domain.getTracking(trackingToSave));
			}
			else
			{
				if (!domain.isMostRecentRecordReturned(form.getGlobalContext().Core.getCurrentCareContext()))
				{
					engine.showMessage("You cannot create a new record Send To XRay if the most recent record is not marked as returned!");
					open();
					return false;
				}
				form.getLocalContext().setselectedSendToXRay(domain.save(sentToXRayToSave, null));
			}
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if (form.getLocalContext().getselectedSendToXRay() != null)
			{
				form.getLocalContext().setselectedSendToXRay(domain.getSentToXRay(form.getLocalContext().getselectedSendToXRay()));
			}
			if (trackingToSave != null)
			{
				form.getLocalContext().setcurrentTracking(domain.getTracking(trackingToSave));
			}
			open();
			return false;
		}

		return true;
	}

	private TrackingAttendanceStatusVo populateTrackingAttendanceStatus(TrackingStatus status)
	{
		TrackingAttendanceStatusVo trackingAttStatus = new TrackingAttendanceStatusVo();

		trackingAttStatus.setPatient(form.getGlobalContext().Core.getPatientShort());
		trackingAttStatus.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		trackingAttStatus.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		trackingAttStatus.setTrackingArea(form.getLocalContext().getcurrentTracking().getCurrentArea());

		trackingAttStatus.setStatusDatetime(new DateTime());

		Object mos = domain.getMosUser();
		if (mos instanceof MemberOfStaffLiteVo)
		{
			trackingAttStatus.setCreatedBy((MemberOfStaffLiteVo) mos);
		}

		trackingAttStatus.setStatus(status);
		//WDEV-16777
		trackingAttStatus.setPrevStatus((form.getLocalContext().getcurrentTracking()!=null && form.getLocalContext().getcurrentTracking().getCurrentStatus()!=null  ) ? form.getLocalContext().getcurrentTracking().getCurrentStatus().getStatus() : null);

		return trackingAttStatus;
	}

	private SentToXrayVo populateInstanceDataFromScreen(SentToXrayVo sentToXRay)
	{
		if (sentToXRay == null)
		{
			sentToXRay = new SentToXrayVo();
		}

		sentToXRay.setPatient(form.getGlobalContext().Core.getPatientShort());
		sentToXRay.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		sentToXRay.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		sentToXRay.setTrackingArea(form.getLocalContext().getcurrentTracking().getCurrentArea());

		sentToXRay.setSentBy((MemberOfStaffLiteVo) form.ccAllocatedBy().getValue());
		sentToXRay.setSentDateTime(form.dtimSent().getValue());
		sentToXRay.setReturnedDateTime(form.dtimReturned().getValue());

		return sentToXRay;
	}

	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

		DateTime attRegistrationDateTime = domain.getAttendanceRegistrationDateTime(form.getGlobalContext().Core.getCurrentCareContext());

		if (form.dtimSent().getValue() != null && form.dtimSent().getValue().isGreaterThan(new DateTime()))//WDEV-15334
		{
			errors.add("Sent Date/Time cannot be in the future!");//WDEV-15334
		}
		
		if (form.dtimSent().getValue() != null && attRegistrationDateTime != null && form.dtimSent().getValue().isLessThan(attRegistrationDateTime))
		{
			errors.add("Sent Date/Time cannot be less than AttendanceRegistration Date/Time!");
		}
		
		if (form.dtimReturned().getValue() != null && form.dtimReturned().getValue().isGreaterThan(new DateTime()))
		{
			errors.add("Returned Date/Time cannot be in the future!");//WDEV-15334
		}
		//wdev-17714
		if( form.chkReturned().getValue() == true )
		{
			if( form.cmbSetCurrentStatus().getValue()== null )
			{
				errors.add("Set Current Status to is mandatory. ");
			}
		}
		if (form.dtimReturned().getValue() != null 
			&& form.dtimSent().getValue() != null 
			&&	(form.dtimReturned().getValue().getDate().isLessThan(form.dtimSent().getValue().getDate()) 
					|| (form.dtimReturned().getValue().getDate().equals(form.dtimSent().getValue().getDate()) 
							&& form.dtimReturned().getValue().getTime().isLessThan(form.dtimSent().getValue().getTime()))))
		{
			errors.add("Returned Date/Time cannot be less than Sent Date/Time!");
		}
		
		if (form.chkReturned().getValue() && form.dtimReturned().getValue()==null)
		{
			errors.add("Returned Date/Time time is mandatory!");
		}
		
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);

			return UIErrors;
		}

		return null;
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}

	private void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		form.recbrSentToXRay().clear();

		form.getLocalContext().setselectedSendToXRay(null);

		clearInstanceControls();

		Object mos = domain.getMosUser();

		if (mos == null)
		{
			engine.showMessage("Current User is not a Member of Staff!");
			return;
		}

		if (mos instanceof MemberOfStaffLiteVo)
		{
			form.ccAllocatedBy().setValue((MemberOfStaffLiteVo) mos);
		}

		form.dtimSent().setValue(new DateTime());
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onRecbrSentToXRayValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		getSelectedInstance();
		updateControlsState();
	}

	private void getSelectedInstance()
	{
		form.getLocalContext().setselectedSendToXRay(domain.getSentToXRay(form.recbrSentToXRay().getValue()));
		populateInstanceControls(form.getLocalContext().getselectedSendToXRay());
	}

	@Override
	protected void onChkReturnedValueChanged() throws PresentationLogicException
	{
		form.dtimReturned().setValue(new DateTime());

		if (!form.chkReturned().getValue())
		{
			if (form.getLocalContext().getselectedSendToXRay() != null && form.getLocalContext().getselectedSendToXRay().getID_SentToXray() != null
				&& domain.isLastEntry(form.getGlobalContext().Core.getCurrentCareContext(), form.getLocalContext().getselectedSendToXRay()) == false)
			{
					engine.showMessage("The option 'Return Patient from X-Ray' cannot be unchecked for this record.");
					form.chkReturned().setValue(true);
			}
			else
			{
			form.dtimReturned().setValue(null);
			form.cmbSetCurrentStatus().setValue(null);
			}
		}
		
		updateControlsState();
	}
}
