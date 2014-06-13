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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.cliniclistactionsummary;

import ims.admin.vo.enums.ElectiveListDetails;
import ims.clinical.forms.cliniclistactionsummary.GenForm.grdResultsRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.IPandOPSearchCriteriaVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.icp.vo.OutpatientEpisodeWithICPInfoVo;
import ims.icp.vo.OutpatientEpisodeWithICPInfoVoCollection;
import ims.scheduling.vo.AppointmentOutcomeActionVo;
import ims.scheduling.vo.BookingAppointmentOutcomeActionsToSaveVo;
import ims.scheduling.vo.SessionShortVo;
import ims.scheduling.vo.SessionShortVoCollection;
import ims.scheduling.vo.lookups.AppointmentAction;
import ims.scheduling.vo.lookups.OutcomeAction;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int ICP_COL_INDEX = 0;
	private static final int DOB_COL_INDEX = 5;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		refreshSearchCriteria(form.getGlobalContext().Clinical.getClinicListActionSummarySearchCriteria());
	}

	private void refreshSearchCriteria(IPandOPSearchCriteriaVo searchCriteria)
	{
		if (searchCriteria == null)
			return;

		form.cmbHospital().setValue((LocationLiteVo) searchCriteria.getHospital());
		form.dteDate().setValue(searchCriteria.getDate());

		if (form.cmbHospital().getValue() != null && form.dteDate().getValue() != null)
			loadClinics(searchCriteria.getClinicIsNotNull());

		form.cmbClinic().setValue((SessionShortVo) searchCriteria.getClinic());
		form.cmbAppOutcome().setValue(searchCriteria.getApptOutcome());
		form.cmbAction().setValue(searchCriteria.getAppointmentAction());
		form.chkComplete().setValue(searchCriteria.getComplete());
		form.dteFrom().setValue(searchCriteria.getApptDateFrom());
		form.dteTo().setValue(searchCriteria.getApptDateTo());

		search();

	}

	private void initialise()
	{
		form.dteDate().setValue(new Date());

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdResults().setcolHospnumCaption(dispIdType.getText());

		loadHospitals();

		updateControlsState();
	}

	private void searchForClinics()
	{
		if (form.cmbHospital().getValue() != null && form.dteDate().getValue() != null)
			loadClinics(false);
		else if (form.cmbHospital().getValue() == null)
			form.cmbClinic().clear();

	}

	private void loadHospitals()
	{
		LocationLiteVoCollection hospitals = domain.getActiveHospitals(domain.getMosUser() instanceof MemberOfStaffRefVo ? (MemberOfStaffRefVo) domain.getMosUser() : null);
		if (hospitals != null)
		{
			for (LocationLiteVo item : hospitals)
			{
				form.cmbHospital().newRow(item, item.getName());

				if (engine.getCurrentLocation() != null)
				{
					if (engine.getCurrentLocation().getID() == item.getID_Location().intValue() && form.dteDate().getValue() != null)
					{
						form.cmbHospital().setValue(item);
						loadClinics(false);
					}
				}
			}
		}
	}

	private void loadClinics(boolean bKeepClosed)
	{
		if (form.cmbHospital().getValue() == null)
			return;

		form.cmbClinic().clear();

		SessionShortVoCollection listClinics = domain.listClinics(form.cmbHospital().getValue().getID_Location(), form.dteDate().getValue());

		if (listClinics != null)
		{
			for (SessionShortVo item : listClinics)
			{
				StringBuffer sb = new StringBuffer();
				sb.append(item.getName());
				sb.append(" - ");
				sb.append(item.getSessionDate());

				form.cmbClinic().newRow(item, sb.toString());

				if (engine.getCurrentLocation() != null && item.getSchLocationIsNotNull())
				{
					if (engine.getCurrentLocation().getID() == item.getSchLocation().getID())
						form.cmbClinic().setValue(item);
				}
			}

			if (listClinics.size() == 1)
				form.cmbClinic().setValue(listClinics.get(0));

			form.cmbClinic().setTooltip(form.cmbClinic().getValue() != null ? form.cmbClinic().getValue().getDescription() : null);
		}
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getTaskCompleteMessageBoxID() != null && form.getLocalContext().getTaskCompleteMessageBoxID().equals(messageBoxId) && DialogResult.YES.equals(result))
		{
			flagTasksAsComplete();
		}
	}

	private void flagTasksAsComplete()
	{
		if (form.grdResults().getSelectedRow() == null)
			return;

		BookingAppointmentOutcomeActionsToSaveVo appointmentToSave = domain.getOutcomeActionsForAppointment(form.grdResults().getSelectedRow().getValue());

		if (appointmentToSave.getOutcomeActions() == null)
			return;

		for (int i = 0; i < appointmentToSave.getOutcomeActions().size(); i++)
		{
			if (appointmentToSave.getOutcomeActions().get(i) == null)
				continue;

			OutcomeAction outcomeOfAction = appointmentToSave.getOutcomeActions().get(i).getOutcomeOfAction();

			if (!OutcomeAction.DONE_NOW.equals(outcomeOfAction))
			{
				appointmentToSave.getOutcomeActions().get(i).setOutcomeOfAction(OutcomeAction.DONE_NOW);
			}
		}

		try
		{
			domain.saveTasksAsComplete(appointmentToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			search();
			return;
		}

		search();
	}

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().CAREUK.NewElectiveListTCIErodDialog) && DialogResult.ABORT.equals(result)) //abord is actually Close button
		{
			markElectiveListAsComplete();
		}
		else if (formName.equals(form.getForms().CAREUK.BookAppointmentDialog))
		{
			markAppointmentsAsComplete();
		}
		
		search();
	}

	private void markAppointmentsAsComplete()
	{
		if (form.grdResults().getSelectedRow() == null)
			return;

		BookingAppointmentOutcomeActionsToSaveVo appointmentToSave = domain.getOutcomeActionsForAppointment(form.grdResults().getSelectedRow().getValue());

		if (appointmentToSave.getOutcomeActions() == null)
			return;

		for (int i = 0; i < appointmentToSave.getOutcomeActions().size(); i++)
		{
			if (appointmentToSave.getOutcomeActions().get(i) == null)
				continue;

			AppointmentAction appointmentAction = appointmentToSave.getOutcomeActions().get(i).getAppointmentAction();
			OutcomeAction outcomeOfAction = appointmentToSave.getOutcomeActions().get(i).getOutcomeOfAction();

			if (AppointmentAction.BOOK_APPT_ACTION.equals(appointmentAction) && !OutcomeAction.DONE_NOW.equals(outcomeOfAction))
			{
				appointmentToSave.getOutcomeActions().get(i).setOutcomeOfAction(OutcomeAction.DONE_NOW);
				break;
			}
		}

		try
		{
			domain.saveTasksAsComplete(appointmentToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
		
	}

	private void markElectiveListAsComplete()
	{
		if (form.grdResults().getSelectedRow() == null)
			return;

		BookingAppointmentOutcomeActionsToSaveVo appointmentToSave = domain.getOutcomeActionsForAppointment(form.grdResults().getSelectedRow().getValue());

		if (appointmentToSave.getOutcomeActions() == null)
			return;

		for (int i = 0; i < appointmentToSave.getOutcomeActions().size(); i++)
		{
			if (appointmentToSave.getOutcomeActions().get(i) == null)
				continue;

			AppointmentAction appointmentAction = appointmentToSave.getOutcomeActions().get(i).getAppointmentAction();
			OutcomeAction outcomeOfAction = appointmentToSave.getOutcomeActions().get(i).getOutcomeOfAction();

			if ((AppointmentAction.WAITING_LIST_ACTION.equals(appointmentAction) || AppointmentAction.BOOKED_LIST_ACTION.equals(appointmentAction) || AppointmentAction.PLANNED_LIST_ACTION.equals(appointmentAction)) && !OutcomeAction.DONE_NOW.equals(outcomeOfAction))
			{
				appointmentToSave.getOutcomeActions().get(i).setOutcomeOfAction(OutcomeAction.DONE_NOW);
				break;
			}
		}

		try
		{
			domain.saveTasksAsComplete(appointmentToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
	}

	@Override
	protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		searchForClinics();

		if (form.cmbHospital().getValue() == null)
		{
			form.grdResults().getRows().clear();
		}

		updateControlsState();
	}

	private void updateControlsState()
	{
		boolean apptHasOutcome = form.grdResults().getSelectedRow() != null && form.grdResults().getSelectedRow().getValue().getOutcome() != null;

		form.btnViewOutcome().setEnabled(apptHasOutcome);
		form.btnTaskComplete().setEnabled(atLeastOneIncompleteTask());

		form.getContextMenus().Clinical.hideAllClinicListActionSummaryMenuMenuItems();

		form.getContextMenus().Clinical.getClinicListActionSummaryMenuADD_TO_WAITING_LISTItem().setVisible(checkOutstandingWaitingListAction());
		form.getContextMenus().Clinical.getClinicListActionSummaryMenuADD_TO_BOOKED_LISTItem().setVisible(checkOutstandingBookedListAction());
		form.getContextMenus().Clinical.getClinicListActionSummaryMenuADD_TO_PLANNED_LISTItem().setVisible(checkOutstandingPlannedListAction());
		form.getContextMenus().Clinical.getClinicListActionSummaryMenuBOOK_APPOINTMENTItem().setVisible(checkOutstandingBookAppointmentAction());
		
		boolean showApptDates = AppointmentAction.BOOK_APPT_ACTION.equals(form.cmbAction().getValue());
		
		form.lblAppReqBetwwen().setVisible(showApptDates);
		form.dteFrom().setVisible(showApptDates);
		form.lblAnd().setVisible(showApptDates);
		form.dteTo().setVisible(showApptDates);
	}

	private boolean atLeastOneIncompleteTask()
	{
		if (form.grdResults().getSelectedRow() == null)
			return false;

		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getSelectedRow().getValue();

		for (int i = 0; i < temp.getOutcomeActions().size(); i++)
		{
			AppointmentOutcomeActionVo action = temp.getOutcomeActions().get(i);

			if (OutcomeAction.DO_LATER.equals(action.getOutcomeOfAction()))
			{
				return true;
			}
		}

		return false;
	}

	private boolean checkOutstandingBookAppointmentAction()
	{
		if (form.grdResults().getSelectedRow() == null)
			return false;

		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getSelectedRow().getValue();

		for (int i = 0; i < temp.getOutcomeActions().size(); i++)
		{
			AppointmentOutcomeActionVo action = temp.getOutcomeActions().get(i);

			if (AppointmentAction.BOOK_APPT_ACTION.equals(action.getAppointmentAction()) && OutcomeAction.DO_LATER.equals(action.getOutcomeOfAction()))
			{
				return true;
			}
		}

		return false;
	}

	private boolean checkOutstandingPlannedListAction()
	{
		if (form.grdResults().getSelectedRow() == null)
			return false;

		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getSelectedRow().getValue();

		for (int i = 0; i < temp.getOutcomeActions().size(); i++)
		{
			AppointmentOutcomeActionVo action = temp.getOutcomeActions().get(i);

			if (AppointmentAction.PLANNED_LIST_ACTION.equals(action.getAppointmentAction()) && OutcomeAction.DO_LATER.equals(action.getOutcomeOfAction()))
			{
				return true;
			}
		}

		return false;
	}

	private boolean checkOutstandingBookedListAction()
	{
		if (form.grdResults().getSelectedRow() == null)
			return false;

		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getSelectedRow().getValue();

		for (int i = 0; i < temp.getOutcomeActions().size(); i++)
		{
			AppointmentOutcomeActionVo action = temp.getOutcomeActions().get(i);

			if (AppointmentAction.BOOKED_LIST_ACTION.equals(action.getAppointmentAction()) && OutcomeAction.DO_LATER.equals(action.getOutcomeOfAction()))
			{
				return true;
			}
		}

		return false;
	}

	private boolean checkOutstandingWaitingListAction()
	{
		if (form.grdResults().getSelectedRow() == null)
			return false;

		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getSelectedRow().getValue();

		for (int i = 0; i < temp.getOutcomeActions().size(); i++)
		{
			AppointmentOutcomeActionVo action = temp.getOutcomeActions().get(i);

			if (AppointmentAction.WAITING_LIST_ACTION.equals(action.getAppointmentAction()) && OutcomeAction.DO_LATER.equals(action.getOutcomeOfAction()))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	protected void onBtnTaskCompleteClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setTaskCompleteMessageBoxID(engine.showMessage("Are you sure you want to mark all Outcomes as complete for patient " + form.getGlobalContext().Core.getPatientShort().getName() + " ?", "Warning", MessageButtons.YESNO, MessageIcon.WARNING));
	}

	@Override
	protected void onBtnViewOutcomeClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Scheduling.AppointmentOutcomeDialog, new Object[] {FormMode.VIEW});
	}

	@Override
	protected void onGrdResultsGridHeaderClicked(int column) throws ims.framework.exceptions.PresentationLogicException
	{
		OutpatientEpisodeWithICPInfoVo temp = form.grdResults().getValue();

		if (column == ICP_COL_INDEX)
		{
			if (form.getLocalContext().getSortOrderICPImage() == null)
				form.getLocalContext().setSortOrderICPImage(SortOrder.ASCENDING);

			OutpatientEpisodeWithICPInfoVoCollection voIPColl = new OutpatientEpisodeWithICPInfoVoCollection();

			for (int i = 0; i < form.grdResults().getRows().size(); i++)
				voIPColl.add(((OutpatientEpisodeWithICPInfoVo) form.grdResults().getRows().get(i).getValue()));

			voIPColl.sort(OutpatientEpisodeWithICPInfoVo.getICPImageComparator(form.getLocalContext().getSortOrderICPImage()));

			if (form.getLocalContext().getSortOrderICPImage().equals(SortOrder.ASCENDING))
				form.getLocalContext().setSortOrderICPImage(SortOrder.DESCENDING);
			else if (form.getLocalContext().getSortOrderICPImage().equals(SortOrder.DESCENDING))
				form.getLocalContext().setSortOrderICPImage(SortOrder.ASCENDING);

			form.grdResults().getRows().clear();

			populateGrid(voIPColl);
		}

		if (column == DOB_COL_INDEX)
		{
			if (form.getLocalContext().getSortOrderDOB() == null)
				form.getLocalContext().setSortOrderDOB(SortOrder.ASCENDING);

			OutpatientEpisodeWithICPInfoVoCollection voIPColl = new OutpatientEpisodeWithICPInfoVoCollection();

			for (int i = 0; i < form.grdResults().getRows().size(); i++)
				voIPColl.add(((OutpatientEpisodeWithICPInfoVo) form.grdResults().getRows().get(i).getValue()));

			voIPColl.sort(OutpatientEpisodeWithICPInfoVo.getDOBComparator(form.getLocalContext().getSortOrderDOB()));

			if (form.getLocalContext().getSortOrderDOB().equals(SortOrder.ASCENDING))
				form.getLocalContext().setSortOrderDOB(SortOrder.DESCENDING);
			else if (form.getLocalContext().getSortOrderDOB().equals(SortOrder.DESCENDING))
				form.getLocalContext().setSortOrderDOB(SortOrder.ASCENDING);

			form.grdResults().getRows().clear();

			populateGrid(voIPColl);
		}

		form.grdResults().setValue(temp);
		updateControlsState();
	}

	@Override
	protected void onGrdResultsSelectionChanged()
	{
		if (form.grdResults().getSelectedRow() == null || form.grdResults().getSelectedRow().getValue() == null)
			return;

		form.getGlobalContext().Scheduling.setBookingAppointmentRef(form.grdResults().getSelectedRow().getValue());
		form.getGlobalContext().Core.setPatientShort(domain.getPatientShort(form.grdResults().getSelectedRow().getValue().getPatient()));
		form.getGlobalContext().ICP.setPatientICPRecord(form.grdResults().getSelectedRow().getValue().getICPInfo());
		form.getGlobalContext().CareUk.setCatsReferral(form.grdResults().getSelectedRow().getValue().getReferral());

		updateControlsState();
	}

	@Override
	protected void onDteDateValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbHospital().getValue() != null && form.dteDate().getValue() != null)
		{
			loadClinics(false);
		}
		else if (form.dteDate().getValue() == null)
		{
			form.cmbClinic().clear();
			form.grdResults().getRows().clear();
		}

		updateControlsState();
	}

	@Override
	protected void onCmbClinicValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbClinic().setTooltip(form.cmbClinic().getValue() != null ? form.cmbClinic().getValue().getDescription() : null);
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		updateControlsState();
	}

	private void clearScreen()
	{
		form.grdResults().getRows().clear();

		form.cmbHospital().setValue(null);
		form.cmbClinic().clear();
		form.dteDate().setValue(null);
		form.cmbAppOutcome().setValue(null);
		form.cmbAction().setValue(null);
		form.chkComplete().setValue(false);
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		
		form.getGlobalContext().Clinical.setClinicListActionSummarySearchCriteria(null);
		form.lblTotal().setValue("Total: 0");
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	private void search()
	{

		if (!validateSearch())
			return;

		form.grdResults().getRows().clear();

		IPandOPSearchCriteriaVo filterVo = new IPandOPSearchCriteriaVo();

		filterVo = populateSearchFilter(filterVo);

		form.getGlobalContext().Clinical.setClinicListActionSummarySearchCriteria(filterVo);

		OutpatientEpisodeWithICPInfoVoCollection list = domain.listOPEpisodes(filterVo);

		if (list == null || list.size() == 0)
		{
			engine.showMessage("No records match your search criteria.", "No data found", MessageButtons.OK, MessageIcon.WARNING);
			form.lblTotal().setValue("Total: 0");
			updateControlsState();
			return;
		}

		list.sort(OutpatientEpisodeWithICPInfoVo.getTimeComparator(SortOrder.ASCENDING));

		form.lblTotal().setValue("Total: " + list.size());
		populateGrid(list);

		updateControlsState();
	}

	private void populateGrid(OutpatientEpisodeWithICPInfoVoCollection list)
	{
		form.grdResults().getRows().clear();

		for (int i = 0; list != null && i < list.size(); i++)
		{
			grdResultsRow row = form.grdResults().getRows().newRow();
			OutpatientEpisodeWithICPInfoVo outpatientEpisode = list.get(i);

			row.setcolICP(outpatientEpisode.getICPInfoIsNotNull() ? form.getImages().ICP.ICP : null);

			if (outpatientEpisode.getPatient().getDisplayId() != null)
			{
				row.setcolHospnum(outpatientEpisode.getPatient().getDisplayId().getValue());
				row.setTooltipForcolHospnum(outpatientEpisode.getPatient().getDisplayId().getValue());
			}

			row.setcolSurname(outpatientEpisode.getPatient().getNameIsNotNull() ? outpatientEpisode.getPatient().getName().getSurname() : "");
			row.setTooltipForcolSurname(outpatientEpisode.getPatient().getNameIsNotNull() ? outpatientEpisode.getPatient().getName().getSurname() : "");

			row.setcolForename(outpatientEpisode.getPatient().getNameIsNotNull() ? outpatientEpisode.getPatient().getName().getForename() : "");
			row.setTooltipForcolForename(outpatientEpisode.getPatient().getNameIsNotNull() ? outpatientEpisode.getPatient().getName().getForename() : "");

			row.setcolSex(outpatientEpisode.getPatient().getSexIsNotNull() ? outpatientEpisode.getPatient().getSex().toString() : "");
			row.setTooltipForcolSex(outpatientEpisode.getPatient().getSexIsNotNull() ? outpatientEpisode.getPatient().getSex().toString() : "");

			row.setcolDob(outpatientEpisode.getPatient().getDobIsNotNull() ? outpatientEpisode.getPatient().getDob().toString() : "");

			if (outpatientEpisode.getSessionIsNotNull() && outpatientEpisode.getSession().getListOwnersIsNotNull() && outpatientEpisode.getSession().getListOwners().size() > 0 && outpatientEpisode.getSession().getListOwners().get(0).getHcpIsNotNull() && outpatientEpisode.getSession().getListOwners().get(0).getHcp().getName() != null)
			{
				row.setcolConsultant(outpatientEpisode.getSession().getListOwners().get(0).getHcp().getName().toString());
				row.setTooltipForcolConsultant(outpatientEpisode.getSession().getListOwners().get(0).getHcp().getName().toString());
			}

			row.setcolApptTime(outpatientEpisode.getAppointmentTimeIsNotNull() ? outpatientEpisode.getAppointmentTime() : null);
			
			row.setcolOutcome(outpatientEpisode.getOutcome() != null ? outpatientEpisode.getOutcome().getText() : "");
			row.setTooltipForcolOutcome(outpatientEpisode.getOutcome() != null ? outpatientEpisode.getOutcome().getText() : "");

			for (int j = 0; outpatientEpisode.getOutcomeActions() != null && j < outpatientEpisode.getOutcomeActions().size(); j++)
			{
				AppointmentOutcomeActionVo outcomeAction = outpatientEpisode.getOutcomeActions().get(j);

				if (outcomeAction == null)
					continue;

				if (AppointmentAction.WAITING_LIST_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolW(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolW("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolW(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolW("Outstanding Task");
					}
				}
				else if (AppointmentAction.BOOKED_LIST_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolB(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolB("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolB(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolB("Outstanding Task");
					}
				}
				else if (AppointmentAction.PLANNED_LIST_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolP(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolP("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolP(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolP("Outstanding Task");
					}
				}
				else if (AppointmentAction.BOOK_APPT_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolF(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolF("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolF(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolF("Outstanding Task");
					}
				}
				else if (AppointmentAction.ONWARD_REFERRAL_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolO(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolO("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolO(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolO("Outstanding Task");
					}
				}
				else if (AppointmentAction.TRANSFER_ACTION.equals(outcomeAction.getAppointmentAction()))
				{
					if (OutcomeAction.DONE_NOW.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolT(form.getImages().CAREUK.AddNow16);
						row.setTooltipForcolT("Task Complete");
					}
					else if (OutcomeAction.DO_LATER.equals(outcomeAction.getOutcomeOfAction()))
					{
						row.setcolT(form.getImages().CAREUK.AddLater16);
						row.setTooltipForcolT("Outstanding Task");
					}
				}
			}

			row.setValue(outpatientEpisode);
		}
	}

	private IPandOPSearchCriteriaVo populateSearchFilter(IPandOPSearchCriteriaVo filterVo)
	{
		if (form.cmbHospital().getValue() != null)
			filterVo.setHospital(form.cmbHospital().getValue());

		if (form.cmbClinic().getValue() != null)
			filterVo.setClinic(form.cmbClinic().getValue());

		if (form.dteDate().getValue() != null)
			filterVo.setDate(form.dteDate().getValue());

		if (form.cmbAppOutcome().getValue() != null)
			filterVo.setApptOutcome(form.cmbAppOutcome().getValue());

		if (form.cmbAction().getValue() != null)
			filterVo.setAppointmentAction(form.cmbAction().getValue());
		
		if (form.dteFrom().getValue() != null)
			filterVo.setApptDateFrom(form.dteFrom().getValue());
		
		if (form.dteTo().getValue() != null)
			filterVo.setApptDateTo(form.dteTo().getValue());

		filterVo.setComplete(form.chkComplete().getValue());

		return filterVo;
	}

	private boolean validateSearch()
	{
		List<String> uiErrors = new ArrayList<String>();

		if (form.cmbHospital().getValue() == null)
			uiErrors.add("Please select a Hospital");

		if (form.dteFrom().getValue() != null && form.dteTo().getValue() != null && form.dteTo().getValue().isLessThan(form.dteFrom().getValue()))
		{
			uiErrors.add("From date cannot be greater than To date.");
		}
		
		if (uiErrors.size() > 0)
		{
			engine.showErrors(uiErrors.toArray(new String[0]));
			return false;
		}

		return true;
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{

		switch (menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.ClinicListActionSummaryMenu.ADD_TO_WAITING_LIST:
				form.getGlobalContext().CareUk.setPatientElectiveListRef(null);
				engine.open(form.getForms().CAREUK.NewElectiveListTCIErodDialog, new Object[] { ElectiveListDetails.ADDTOWAITINGLIST });
				break;

			case GenForm.ContextMenus.ClinicalNamespace.ClinicListActionSummaryMenu.ADD_TO_BOOKED_LIST:
				form.getGlobalContext().CareUk.setPatientElectiveListRef(null);
				engine.open(form.getForms().CAREUK.NewElectiveListTCIErodDialog, new Object[] { ElectiveListDetails.ADDTOBOOKEDLIST });
				break;

			case GenForm.ContextMenus.ClinicalNamespace.ClinicListActionSummaryMenu.ADD_TO_PLANNED_LIST:
				form.getGlobalContext().CareUk.setPatientElectiveListRef(null);
				engine.open(form.getForms().CAREUK.NewElectiveListTCIErodDialog, new Object[] { ElectiveListDetails.ADDTOPLANNEDLIST });
				break;

			case GenForm.ContextMenus.ClinicalNamespace.ClinicListActionSummaryMenu.BOOK_APPOINTMENT:
				engine.open(form.getForms().CAREUK.BookAppointmentDialog);
				break;
		}
	}

	@Override //WDEV-18664
	protected void onCmbActionValueChanged() throws PresentationLogicException
	{
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		updateControlsState();
		
	}
}
