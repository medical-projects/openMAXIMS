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
//This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2389.25607)
//Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.correspondenceinpatientlist;

import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PasEventVo;
import ims.core.vo.PatientListsFilterVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.correspondence.vo.ConsultantAccessVoCollection;
import ims.correspondence.vo.CorrespondencePatientListsVoCollection;
import ims.correspondence.vo.UserAccessVo;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
	}

	private void clear()
	{
		clearSearchCriteria();
		clearPatientList();
	}

	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	protected void onCmbHospitalFilterValueChanged()
	{
		if (form.cmbHospital().getValue() == null)
		{
			form.cmbWard().setEnabled(false);
		}
		else
		{
			form.cmbWard().setEnabled(true);

			clearPatientList();

			populateWardCombo();
		}

	}

	private void populateWardCombo()
	{
		form.cmbWard().clear();

		if (form.cmbHospital().getValue().getType() != null && form.cmbHospital().getValue().getType().equals(LocationType.HOSP))
		{
			LocShortMappingsVoCollection voLocShortMapColl = domain.listActiveWardsForHospital(form.cmbHospital().getValue());
			if (voLocShortMapColl != null)
			{
				for (int i = 0; i < voLocShortMapColl.size(); i++)
				{
					LocShortMappingsVo voLocShortMap = voLocShortMapColl.get(i);
					form.cmbWard().newRow(voLocShortMap, voLocShortMap.getName());
				}
			}
		}
	}

	protected void onGrdWardsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue())
		{
			selectionChanged();
		}
	}

	private void selectionChanged()
	{
		setContextVariablesForSelection();
		updateControlsState();
		if (form.isReadOnly())
			engine.showMessage("Read only form");
	}

	private void updateControlsState()
	{
		setContextMenusState();

	}

	/**
	 * 
	 */
	private void setContextMenusState()
	{
		form.getContextMenus().hideAllADTMenuMenuItems();

		if (form.getGlobalContext().Core.getPasEvent() == null)
		{
			setContextMenusForReadOnlyAccess();
			return;
		}

		if (form.getLocalContext().getSelectedCorrespondenceInstanceIsNotNull())
		{
			form.getContextMenus().getADTMenuAddItem().setVisible(false);
			form.getContextMenus().getADTMenuEditItem().setVisible(true);
			form.getContextMenus().getADTMenuViewItem().setVisible(true);
			form.getContextMenus().getADTMenuViewDocumentStatusHistoryItem().setVisible(true);

			enableBatchUpdateMenuItems();
		}
		else
		{
			form.getContextMenus().getADTMenuAddItem().setVisible(true);
			form.getContextMenus().getADTMenuEditItem().setVisible(false);
			form.getContextMenus().getADTMenuViewItem().setVisible(false);
		}

	}

	private void enableBatchUpdateMenuItems()
	{

		boolean enableDictatedItem = false;
		boolean enableNoLetterRequiredItem = false;
		boolean enableSignedItem = false;
		InpatientEpisodeVo voInpatientListRow = null;
		DischargedEpisodeVo voDischargedEpisode = null;
		PasEventVo voPasEvent = null;

		for (int i = 0; i < form.grdInpatients().getRows().size(); i++)
		{
			if (form.grdInpatients().getRows().get(i).getValue() instanceof InpatientEpisodeVo)
			{
				voInpatientListRow = (InpatientEpisodeVo) form.grdInpatients().getRows().get(i).getValue();
				voPasEvent = voInpatientListRow.getPasEvent();
				if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.LETTERREQUIRED))
				{
					enableNoLetterRequiredItem = true;
					enableDictatedItem = true;
				}
				else if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.NOLETTERREQUIRED))
					enableDictatedItem = true;
				else if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.PRINTEDNOSIGNATURE))
					enableSignedItem = true;
			}
			else if (form.grdInpatients().getRows().get(i).getValue() instanceof DischargedEpisodeVo)
			{
				voDischargedEpisode = (DischargedEpisodeVo) form.grdInpatients().getRows().get(i).getValue();
				voPasEvent = voDischargedEpisode.getPasEvent();
				if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.LETTERREQUIRED))
				{
					enableNoLetterRequiredItem = true;
					enableDictatedItem = true;
				}
				else if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.NOLETTERREQUIRED))
					enableDictatedItem = true;
				else if (voPasEvent.getCspDocumentStatus().equals(DocumentStatus.PRINTEDNOSIGNATURE))
					enableDictatedItem = true;
			}
		}

		form.getContextMenus().getADTMenuBatchupdateofstatustoDictatedItem().setVisible(enableDictatedItem);
		form.getContextMenus().getADTMenuBatchupdateofstatustoNoLetterRequiredItem().setVisible(enableNoLetterRequiredItem);
		form.getContextMenus().getADTMenuBatchupdateofstatustoSignedItem().setVisible(enableSignedItem);
	}

	private void setContextMenusForReadOnlyAccess()
	{
		form.getContextMenus().getADTMenuViewItem().setVisible(true);
		form.getContextMenus().getADTMenuViewItem().setEnabled(true);
	}

	private void setContextMenusForNullAccess()
	{
		form.getContextMenus().hideAllADTMenuMenuItems();
	}

	private void clearContextVariables()
	{
		form.getLocalContext().setSelectedCorrespondenceInstance(null);

		form.getGlobalContext().Correspondence.setCorrespondenceDetails(null);
		form.getGlobalContext().Correspondence.setDocDetailIdReportSeed(null);
		form.getGlobalContext().Correspondence.setGenerateFormMode(null);
		form.getGlobalContext().Core.setPasEvent(null);
		form.getGlobalContext().Core.setPatientShort(null);
	}

	private void setContextVariablesForSelection()
	{
		clearContextVariables();
		InpatientEpisodeVo voInpatientListRow = null;
		PASEventRefVo voRefPasEvent = null;

		DischargedEpisodeVo voDischargedEpisode = null;
		PasEventVo voPasEvent = null;

		if (form.grdInpatients().getSelectedRowIndex() >= 0 && form.grdInpatients().getRows().get(form.grdInpatients().getSelectedRowIndex()).getValue() != null)
		{
			if (form.grdInpatients().getSelectedRow().getValue() instanceof InpatientEpisodeVo)
			{
				voInpatientListRow = (InpatientEpisodeVo) form.grdInpatients().getSelectedRow().getValue();
				voPasEvent = voInpatientListRow.getPasEvent();
				voRefPasEvent = voInpatientListRow.getPasEvent();
			}
			else if (form.grdInpatients().getSelectedRow().getValue() instanceof DischargedEpisodeVo)
			{
				voDischargedEpisode = (DischargedEpisodeVo) form.grdInpatients().getSelectedRow().getValue();
				voPasEvent = voDischargedEpisode.getPasEvent();
				voRefPasEvent = voDischargedEpisode.getPasEvent();
			}

			form.getGlobalContext().Core.setPatientShort(voPasEvent.getPatient());

			form.getGlobalContext().Core.setPasEvent(voRefPasEvent);
			form.getLocalContext().setSelectedCorrespondenceInstance(domain.getCorrespondenceDetailsByPasEvent(voRefPasEvent));
			form.getGlobalContext().Correspondence.setCorrespondenceDetails(form.getLocalContext().getSelectedCorrespondenceInstance());

		}
	}

	private void initialize()
	{
		prePopulateControls();

		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.grdInpatients().setcolHospnumCaption(dispIdType.getText());

	}

	private void prePopulateControls()
	{
		populateHospitalListCombo();

		UserAccessVo voUserAccess = domain.getUserAccess(engine.getLoggedInUser().getUserId());

		if (voUserAccess != null)
		{
			form.getLocalContext().setUserAccessVo(voUserAccess);
			form.qmbConsultants().setVisible(false);
			form.cmbConsultant().setVisible(true);
			populateComboConsultants(voUserAccess);
		}
		else
		{
			form.qmbConsultants().setVisible(true);
			form.cmbConsultant().setVisible(false);
			// WDEV-2847
			populateQmbConsultants();
		}
	}

	private void populateComboConsultants(UserAccessVo voUserAccess)
	{
		ConsultantAccessVoCollection collConsultantAccessVo = voUserAccess.getConsultantAccess();
		MedicLiteVo med = null;

		if (collConsultantAccessVo != null)
		{
			for (int i = 0; i < collConsultantAccessVo.size(); i++)
			{
				med = collConsultantAccessVo.get(i).getConsultant();
				form.cmbConsultant().newRow(med, med.toString());
			}
		}
		if (collConsultantAccessVo != null && collConsultantAccessVo.size() == 1)
			form.cmbConsultant().setValue(collConsultantAccessVo.get(0).getConsultant());
		else if (collConsultantAccessVo != null && collConsultantAccessVo.size() > 1)
			form.cmbConsultant().showOpened();

		Integer id = engine.getLoggedInUser().getHcpId();
		if (med != null && id != null && id.equals(med.getID_Hcp()))
			form.cmbConsultant().setValue(med);

	}

	private void populateQmbConsultants()
	{
		MedicLiteVo voMedic = new MedicLiteVo();
		MemberOfStaffLiteVo mosLiteVo = (MemberOfStaffLiteVo) domain.getMosUser();
		if (mosLiteVo != null)
		{
			voMedic.setMos(mosLiteVo);
			voMedic.setID_Hcp(mosLiteVo.getID_MemberOfStaff());
			voMedic.setIsActive(new Boolean(true));
			form.qmbConsultants().newRow(voMedic, voMedic.getName().toString());
			form.qmbConsultants().setValue(voMedic);
		}
	}

	private void open()
	{
		if (form.getGlobalContext().Correspondence.getPatientListSearchCriteriaIsNotNull())
		{
			displayPatientSearchCriteria();
		}

	}

	private void displayPatientSearchCriteria()
	{
		if (form.getGlobalContext().Correspondence.getPatientListSearchCriteria() == null)
			return;

		ims.core.vo.PatientListsFilterVo voFilter = form.getGlobalContext().Correspondence.getPatientListSearchCriteria();
		displayInpatientSearchCriteria(voFilter);
	}

	private void displayInpatientSearchCriteria(ims.core.vo.PatientListsFilterVo voFilter)
	{

		if (voFilter.getConsultantIsNotNull())
			form.qmbConsultants().setValue(voFilter.getConsultant());

		if (voFilter.getHospitalIsNotNull())
		{
			form.cmbHospital().setValue(voFilter.getHospital());
			if (voFilter.getWardIsNotNull())
			{
				form.cmbWard().setEnabled(true);
				populateWardCombo();
				form.cmbWard().setValue(voFilter.getWard());
			}
		}

		search();

	}

	private void clearSearchCriteria()
	{
		form.cmbWard().setEnabled(false);
		form.cmbHospital().setValue(null);
		form.cmbWard().clear();
		form.cmbWard().setValue(null);
		form.qmbConsultants().clear();
		form.qmbConsultants().setValue(null);
	}

	private void clearPatientList()
	{
		form.grdInpatients().getRows().clear();
		setTotalLabel(0);
		form.getContextMenus().hideAllADTMenuMenuItems();
	}

	private void search()
	{
		form.getGlobalContext().Correspondence.setPatientListSearchCriteria(null);

		clearPatientList();

		if (form.cmbWard().getValue() == null && form.qmbConsultants().getValue() == null)
		{
			engine.showMessage("Valid search criteria must be specified - Please select a Ward and/or a Consultant.");
			return;
		}

		ims.core.vo.PatientListsFilterVo voFilter = populateSearchCriteria();

		if (voFilter == null)
			return;

		populateListControl(domain.listInPatients(voFilter, false, form.chkCurrentOnly().getValue()));

		form.getGlobalContext().Correspondence.setPatientListSearchCriteria(voFilter);

		enableBatchUpdateMenuItems();

	}

	private ims.core.vo.PatientListsFilterVo populateSearchCriteria()
	{
		if (form.dteDischargeDateFrom().getValue() != null && form.dteDichargeDateTo().getValue() != null && (form.dteDichargeDateTo().getValue().getDate().before(form.dteDischargeDateFrom().getValue().getDate()) || form.dteDichargeDateTo().getValue().getDate().equals(form.dteDischargeDateFrom().getValue().getDate())))
		{
			engine.showMessage("'Discharge Date To' must be later than 'Discharge Date From'.");
			return null;
		}

		ims.core.vo.PatientListsFilterVo voFilter = new ims.core.vo.PatientListsFilterVo();
		voFilter.setHospital(form.cmbHospital().getValue());
		voFilter.setWard(form.cmbWard().getValue());
		if (form.getLocalContext().getUserAccessVoIsNotNull())
			voFilter.setConsultant(form.cmbConsultant().getValue());
		else
			voFilter.setConsultant(form.qmbConsultants().getValue());
		voFilter.setDictatedBy(form.qmbDictatedBy().getValue());
		voFilter.setDocumentStatus(form.cmbStatusOfLetter().getValue());
		voFilter.setDischargeDateFrom(form.dteDischargeDateFrom().getValue());
		voFilter.setDischargeDateTo(form.dteDichargeDateTo().getValue());

		return voFilter;
	}

	private void populateHospitalListCombo()
	{
		LocShortMappingsVoCollection voLocShortMapColl = domain.listActiveHospitals();
		if (voLocShortMapColl != null)
		{
			int currentLocName;
			for (int i = 0; i < voLocShortMapColl.size(); i++)
			{
				LocShortMappingsVo voLocShortMap = voLocShortMapColl.get(i);
				form.cmbHospital().newRow(voLocShortMap, voLocShortMap.getName());

				if (engine.getCurrentLocation() != null)
				{
					currentLocName = engine.getCurrentLocation().getID();
					if (currentLocName == voLocShortMap.getID())
					{
						form.cmbHospital().setValue(voLocShortMap);
					}
				}
			}
			onCmbHospitalFilterValueChanged();
		}
	}

	private void populateListControl(CorrespondencePatientListsVoCollection voCorrespondencePatientListsEpisColl)
	{

		if (voCorrespondencePatientListsEpisColl != null)
		{
			if (voCorrespondencePatientListsEpisColl.size() == 0)
			{
				engine.showMessage("No matching patients found.");
				return;
			}
			GenForm.grdInpatientsRow row = null;
			for (int i = 0; i < voCorrespondencePatientListsEpisColl.size(); i++)
			{
				InpatientEpisodeVo voInpatient = voCorrespondencePatientListsEpisColl.get(i).getInpatientEpisodeVo();
				DischargedEpisodeVo voDischargedEpisode = voCorrespondencePatientListsEpisColl.get(i).getDischargeEpisodeVo();
				PasEventVo voPasEvent = null;
				if (voInpatient != null && voInpatient.getPasEventIsNotNull())
					voPasEvent = voInpatient.getPasEvent();
				else if (voDischargedEpisode != null && voDischargedEpisode.getPasEventIsNotNull())
					voPasEvent = voDischargedEpisode.getPasEvent();

				form.getGlobalContext().Core.setPasEvent(voPasEvent);

				if (form.cmbConsultant().getValue() == null && form.getLocalContext().getUserAccessVoIsNotNull())
				{
					boolean bIsUserAccessConsultant = false;
					UserAccessVo voUserAccess = form.getLocalContext().getUserAccessVo();
					ConsultantAccessVoCollection collConsultantAccessVo = voUserAccess.getConsultantAccess();
					MedicLiteVo med = null;

					if(form.cmbConsultant().getValue()== null)
						bIsUserAccessConsultant = true;
					
					if (collConsultantAccessVo != null)
					{
						for (int j = 0; j < collConsultantAccessVo.size(); j++)
						{
							med = collConsultantAccessVo.get(j).getConsultant();
							if (voInpatient != null)
							{
								if (voInpatient.getPasEvent().getConsultant() != null)
								{
									if (med.getID_Hcp().equals(voInpatient.getPasEvent().getConsultant().getID_Hcp()))
										bIsUserAccessConsultant = true;
								
								}
							}
						}
					}
					if (!bIsUserAccessConsultant)
						continue;
				}
				if (voPasEvent.getPatientIsNotNull())
				{
					row = form.grdInpatients().getRows().newRow();

					if (voInpatient != null && voInpatient.getIsOnLeaveIsNotNull() && voInpatient.getIsOnLeave().equals(Boolean.TRUE))
					{
						row.setcolLeave(form.getImages().Core.Home);
						row.setTooltipForcolLeave("Patient is currently on Leave");
					}

					if (voPasEvent.getPatient().getNameIsNotNull())
					{
						if (voPasEvent.getPatient().getName().getForenameIsNotNull())
							row.setcolForename(voPasEvent.getPatient().getName().getForename());
						if (voPasEvent.getPatient().getName().getSurnameIsNotNull())
							row.setcolSurname(voPasEvent.getPatient().getName().getSurname());
					}
					voPasEvent.getPatient().calculateAge();
					if (voPasEvent.getPatient().getAgeIsNotNull())
						row.setColAge(voPasEvent.getPatient().getAge().toString());

					ims.core.vo.PatientId voPatId = voPasEvent.getPatient().getDisplayId();
					if (voPatId != null)
						row.setcolHospnum(voPatId.getValue());

					if (voPasEvent.getCspDocumentStatus() == null)
					{
						voPasEvent.setCspDocumentStatus(DocumentStatus.LETTERREQUIRED);

					}

					if (voPasEvent.getPatient().getDobIsNotNull())
						row.setcolDob(voPasEvent.getPatient().getDob().toString());

					if (voPasEvent.getPatient().getAgeIsNotNull())
						row.setColAge(voPasEvent.getPatient().getAge().toString());

					if (voPasEvent.getPatient().getSexIsNotNull())
						row.setcolSex(voPasEvent.getPatient().getSex().getText());

					if (voPasEvent.getLocationIsNotNull())
						row.setcolWard(voPasEvent.getLocation().getName());

					if (voPasEvent.getPatient().getIsDead() != null && voPasEvent.getPatient().getIsDead().booleanValue())
						row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());

					if (voPasEvent.getEventDateTime() != null)
						row.setcolAdmissionDate(voPasEvent.getEventDateTime().getDate().toString());

					if (voPasEvent.getConsultant() != null)
						row.setcolConsultant(voPasEvent.getConsultant().getName().toString());

					if (ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue())
					{
						row.setcolDocStatus(voPasEvent.getCspDocumentStatus().getImage());
						row.setTooltipForcolDocStatus(voPasEvent.getCspDocumentStatus().getText());
					}

					if (voInpatient != null)
						row.setValue(voInpatient);
					else if (voDischargedEpisode != null)
					{
						row.setcolDischarged(form.getImages().NTPF.Discharge);
						row.setTooltipForcolDischarged("Discharged");
						row.setValue(voDischargedEpisode);
					}
				}
			}
		}
		setTotalLabel(form.grdInpatients().getRows().size());

	}

	private void setTotalLabel(int count)
	{
		form.lblTotal().setValue("Total : " + count);
	}

	protected void onQmbConsultantsTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbConsultants().clear();

		if (value != null)
		{
			MedicLiteVo med = null;
			MedicLiteVoCollection voMedicColl = domain.listActiveMedics(value);
			if (voMedicColl != null)
			{
				for (int i = 0; i < voMedicColl.size(); i++)
				{
					med = voMedicColl.get(i);
					form.qmbConsultants().newRow(med, med.toString());
				}
			}
			if (voMedicColl != null && voMedicColl.size() == 1)
				form.qmbConsultants().setValue(voMedicColl.get(0));
			else if (voMedicColl != null && voMedicColl.size() > 1)
				form.qmbConsultants().showOpened();

			Integer id = engine.getLoggedInUser().getHcpId();
			if (med != null && id != null && id.equals(med.getID_Hcp()))
				form.qmbConsultants().setValue(med);
		}

	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK) || result.equals(DialogResult.YES))
			search();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ADTMenu.Transfer :
				transferPatient();
			break;
			case GenForm.ContextMenus.ADTMenu.Discharge :
				dischargePatient();
			break;
			case GenForm.ContextMenus.ADTMenu.Demographics :
				showDemographics();
			break;
			default :
			break;
		}

		if (ConfigFlag.UI.INPAT_CREATE_CORRESPONDENCE_DETAILS.getValue())
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.ADTMenu.Add :
					addDocumentDetails();
				break;
				case GenForm.ContextMenus.ADTMenu.View :
					viewDocumentDetails();
				break;
				case GenForm.ContextMenus.ADTMenu.Edit :
					addDocumentDetails();
				break;
				case GenForm.ContextMenus.ADTMenu.ViewDocumentStatusHistory :
					if (form.getLocalContext().getSelectedCorrespondenceInstanceIsNotNull())
						form.getGlobalContext().Correspondence.setcurrentCspStatusHistory(form.getLocalContext().getSelectedCorrespondenceInstance().getCspStatusHistory());
					engine.open(form.getForms().Correspondence.DocumentStatusDlg);
				break;
				case GenForm.ContextMenus.ADTMenu.BatchupdateofstatustoDictated :
					batchUpdateOfStatusToDictated();
				break;
				case GenForm.ContextMenus.ADTMenu.BatchupdateofstatustoNoLetterRequired :
					batchUpdateOfStatusToNoLetterRequired();
				break;
				case GenForm.ContextMenus.ADTMenu.BatchupdateofstatustoSigned :
					batchUpdateOfStatusToSigned();
				break;
			}
		}
	}

	private void batchUpdateOfStatusToDictated()
	{
		PatientListsFilterVo voPatientListsFilter = populateSearchCriteria();
		voPatientListsFilter.setDocumentStatus(DocumentStatus.NOLETTERREQUIRED);
		form.getGlobalContext().Correspondence.setPatientListSearchCriteria(voPatientListsFilter);
		form.getGlobalContext().Core.setOutPatientSearchCriteria(null);
		form.getGlobalContext().Correspondence.setPatientListsBatchUpdateType(DocumentStatus.DICTATED);
		engine.setCaption(form.getForms().Correspondence.BatchUpdatePatientLists, "Batch Update Of Status To 'Dictated'");
		engine.open(form.getForms().Correspondence.BatchUpdatePatientLists);
	}

	private void batchUpdateOfStatusToNoLetterRequired()
	{
		PatientListsFilterVo voPatientListsFilter = populateSearchCriteria();
		voPatientListsFilter.setDocumentStatus(DocumentStatus.LETTERREQUIRED);
		form.getGlobalContext().Correspondence.setPatientListsBatchUpdateType(DocumentStatus.NOLETTERREQUIRED);
		engine.setCaption(form.getForms().Correspondence.BatchUpdatePatientLists, "Batch Update Of Status To 'No Letter Required'");
		form.getGlobalContext().Correspondence.setPatientListSearchCriteria(voPatientListsFilter);
		form.getGlobalContext().Core.setOutPatientSearchCriteria(null);
		engine.open(form.getForms().Correspondence.BatchUpdatePatientLists);
	}

	private void batchUpdateOfStatusToSigned()
	{
		PatientListsFilterVo voPatientListsFilter = populateSearchCriteria();
		voPatientListsFilter.setDocumentStatus(DocumentStatus.PRINTEDNOSIGNATURE);
		form.getGlobalContext().Correspondence.setPatientListsBatchUpdateType(DocumentStatus.SIGNED);
		engine.setCaption(form.getForms().Correspondence.BatchUpdatePatientLists, "Batch Update Of Status To 'Signed'");
		form.getGlobalContext().Correspondence.setPatientListSearchCriteria(voPatientListsFilter);
		form.getGlobalContext().Core.setOutPatientSearchCriteria(null);
		engine.open(form.getForms().Correspondence.BatchUpdatePatientLists);
	}

	private void dischargePatient()
	{
		InpatientEpisodeVo epis = null;
		PasEventVo voPasEvent = null;
		if (form.grdInpatients().getSelectedRow().getValue() instanceof InpatientEpisodeVo)
		{
			epis = (InpatientEpisodeVo) form.grdInpatients().getValue();
			voPasEvent = epis.getPasEvent();
		}
		else
			return;

		PatientShort ps = voPasEvent.getPatient();
		form.getGlobalContext().Core.setPatientShort(ps);
		engine.open(form.getForms().Core.AdtDischargeDialog, new Object[]{epis});
	}

	private void transferPatient()
	{
		InpatientEpisodeVo epis = null;
		PasEventVo voPasEvent = null;
		if (form.grdInpatients().getSelectedRow().getValue() instanceof InpatientEpisodeVo)
		{
			epis = (InpatientEpisodeVo) form.grdInpatients().getValue();
			voPasEvent = epis.getPasEvent();
		}
		else
			return;

		PatientShort ps = voPasEvent.getPatient();
		form.getGlobalContext().Core.setPatientShort(ps);
		engine.open(form.getForms().Core.AdtTransferDialog, new Object[]{epis});
	}

	private void showDemographics()
	{
		InpatientEpisodeVo epis = null;
		PasEventVo voPasEvent = null;
		if (form.grdInpatients().getSelectedRow().getValue() instanceof InpatientEpisodeVo)
		{
			epis = (InpatientEpisodeVo) form.grdInpatients().getValue();
			voPasEvent = epis.getPasEvent();
		}
		else
			return;

		PatientShort ps = voPasEvent.getPatient();

		form.getGlobalContext().Core.setPatientShort(ps);
		engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
	}

	/**
	 * 
	 */
	private void addDocumentDetails()
	{
		form.getGlobalContext().Correspondence.setGenerateFormMode(FormMode.EDIT);
		engine.open(form.getForms().Correspondence.CorrespondenceDetail);
	}

	/**
	 * 
	 */
	private void viewDocumentDetails()
	{
		form.getGlobalContext().Correspondence.setGenerateFormMode(FormMode.VIEW);
		engine.open(form.getForms().Correspondence.CorrespondenceDetail);
	}

	@Override
	protected void onChkCurrentOnlyValueChanged() throws PresentationLogicException
	{
		if (form.chkCurrentOnly().getValue())
		{
			form.dteDichargeDateTo().setEnabled(false);
			form.dteDischargeDateFrom().setEnabled(false);
			form.dteDichargeDateTo().setValue(null);
			form.dteDischargeDateFrom().setValue(null);
		}
		else
		{
			form.dteDichargeDateTo().setEnabled(true);
			form.dteDischargeDateFrom().setEnabled(true);
		}
	}

	@Override
	protected void onQmbDictatedByTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbDictatedBy().clear();

		if (value != null)
		{
			MemberOfStaffShortVo mos = null;
			MemberOfStaffShortVo filter = new MemberOfStaffShortVo();
			PersonName personName = new PersonName();
			personName.setSurname(value);
			filter.setName(personName);
			filter.setIsActive(Boolean.TRUE);
			MemberOfStaffShortVoCollection voMemberOfStaffShortColl = domain.listMembersOfStaff(filter);
			if (voMemberOfStaffShortColl != null)
			{
				for (int i = 0; i < voMemberOfStaffShortColl.size(); i++)
				{
					mos = voMemberOfStaffShortColl.get(i);
					form.qmbDictatedBy().newRow(mos, mos.toString());
				}
			}
			if (voMemberOfStaffShortColl != null && voMemberOfStaffShortColl.size() == 1)
				form.qmbDictatedBy().setValue(voMemberOfStaffShortColl.get(0));
			else if (voMemberOfStaffShortColl != null && voMemberOfStaffShortColl.size() > 1)
				form.qmbDictatedBy().showOpened();

			Integer id = engine.getLoggedInUser().getMosId();
			if (mos != null && id != null && id.equals(mos.getID_MemberOfStaff()))
				form.qmbDictatedBy().setValue(mos);
		}

	}

}
