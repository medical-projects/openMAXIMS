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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.surgicalauditplannedactualproceduredetails;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.grdPlannedPerformedProcedureRow;
import ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.grdSurgicalPackRow;
import ims.clinical.forms.surgicalauditpreoperationcheckstheatrenurse.Logic.LocComparator;
import ims.clinical.forms.surgicalauditproceduredetails.GenForm.GroupSurgicalCheckListEnumeration;
import ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo;
import ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVoCollection;
import ims.clinical.vo.SurgicalAuditActualProcedureVo;
import ims.clinical.vo.SurgicalAuditOperationDetailRefVo;
import ims.clinical.vo.SurgicalAuditOperationDetailStatusVo;
import ims.clinical.vo.SurgicalAuditOperationDetailStatusVoCollection;
import ims.clinical.vo.SurgicalAuditOperationDetailVo;
import ims.clinical.vo.SurgicalAuditSurgicalPackVo;
import ims.clinical.vo.SurgicalAuditSurgicalPackVoCollection;
import ims.clinical.vo.enums.SurgicalAuditPreOpChecksEvent;
import ims.clinical.vo.enums.SurgicalAuditProcedureDetailsHcp;
import ims.clinical.vo.enums.SurgicalAuditRecoveryEvent;
import ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//open();
		form.getLocalContext().setselectedEvent(SurgicalAuditPreOpChecksEvent.CANCEL);
		form.fireCustomControlValueChanged();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if( save())
		{
			//open();
			form.getLocalContext().setselectedEvent(SurgicalAuditPreOpChecksEvent.SAVE);
			form.fireCustomControlValueChanged();
		}
	}
	private boolean save()
	{
		String[] errors = validateUIRules();
		if (errors != null && errors.length != 0)
		{
			engine.showErrors(errors);
			return false;
		}
		SurgicalAuditOperationDetailVo record = form.getLocalContext().getCurrentSurgicalAuditOperationDetails();
		record = populateDataFromScreen(record);
		errors = record.validate();
		if (errors != null && errors.length != 0)
		{
			engine.showErrors(errors);
			return false;
		}
		try 
		{
			form.getLocalContext().setCurrentSurgicalAuditOperationDetails(domain.saveSurgicalAuditOperationDetail(record));
			/*
			//changes 31/07/2012
			if (record.getActualProcedure()!=null && record.getActualProcedure().getID_SurgicalAuditActualProcedure()==null)
				form.getLocalContext().setCurrentSurgicalAuditOperationDetails(domain.saveSurgicalAuditOperationDetail(record));
			else
				domain.saveSurgicalAuditPlannedActualProcDet(record.getActualProcedure());
			*/	
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return true;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		return true;
	}
	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();

		
		if( form.grdPlannedPerformedProcedure().getRows().size() == 0)
		{
			uiErrors.add("Planned/Performed Procedures are  mandatory.");
		}
		//-----------wdev-15739, wdev-15831
		/*if( form.grdPlannedPerformedProcedure().getRows().size() > 0)
		{
			for( int i = 0; i < form.grdPlannedPerformedProcedure().getRows().size();i++ )
			{
				PatientProcedureForSurgicalAuditPreOpChecksVo tempVo = form.grdPlannedPerformedProcedure().getRows().get(i).getValue();
				if(isPerformedOrCancelled(tempVo) == false)
				{
					uiErrors.add("All Procedures should have Performed or Cancelled status.");
					break;
				}
			}
		}*/
		//--------------------
		if( form.grdSurgicalPack().getRows().size() == 0)
		{
			uiErrors.add("Surgical packs are mandatory.");
		}
		
		//AnaesthetistsStartDate 
		if( form.dtimAnaesthetistaStartDate().getValue() == null)
		{
			uiErrors.add("Anaesthetists Start Date is mandatory.");
		}
		
		if( form.dtimAnaesthetistaStartDate().getValue()!= null && form.dtimAnaesthetistaStartDate().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Anaesthetists Start Date cannot be set in the future!");
		}
		
		//SurgeryStartTime
		if( form.dtimSurgeryStartTime().getValue() == null)
		{
			uiErrors.add("Surgery Start Time is mandatory.");
		}
		
		if( form.dtimSurgeryStartTime().getValue() != null && form.dtimSurgeryStartTime().getValue().isGreaterThan(new DateTime()))
		{
				uiErrors.add("Surgery Start Time cannot be set in the future!");
		}
		
		//SurgeryFinishTime
		if( form.dtimSUrgeryFinishTime().getValue() == null )
		{
			uiErrors.add("Surgery Finish Time is mandatory.");
		}
		if( form.dtimSUrgeryFinishTime().getValue() != null  && form.dtimSUrgeryFinishTime().getValue().isGreaterThan(new DateTime()))
		{
				uiErrors.add("Surgery Finish Time cannot be set in the future!");
		}
		
		//Anaesthetists Finish Time
		
		if( form.dtimAnaesthetistsFinishTime().getValue() == null)
		{
			uiErrors.add("Anaesthetists Finish Time is mandatory.");
		}
		if( form.dtimAnaesthetistsFinishTime().getValue() != null &&  form.dtimAnaesthetistsFinishTime().getValue().isGreaterThan(new DateTime()))
		{
				uiErrors.add("Anaesthetists Finish Time cannot be set in the future!");
		}
		
		if( form.dtimTimePatientLeavesOpTheatre().getValue() == null)
		{
			uiErrors.add("Time Patient Leaves Op Theatre is mandatory.");
		}
		
		if( form.dtimTimePatientLeavesOpTheatre().getValue() != null &&  form.dtimAnaesthetistsFinishTime().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Time Patient Leaves Op Theatre cannot be set in the future!");
		}
		
		if( form.cmbPatientSentTo().getValue() == null)
		{
			uiErrors.add("Patient Sent To is mandatory.");
		}
		if( form.dtimAnaesthetistaStartDate().getValue() != null && form.dtimSurgeryStartTime().getValue() != null  )
		{
			if( form.dtimAnaesthetistaStartDate().getValue().isGreaterThan(form.dtimSurgeryStartTime().getValue()))
				uiErrors.add("Anaesthetists Start Time cannot be greater than Surgery Start Time");
		}
		if( form.dtimSurgeryStartTime().getValue() != null && form.dtimSUrgeryFinishTime().getValue() != null)
		{
			if( form.dtimSurgeryStartTime().getValue().isGreaterThan(form.dtimSUrgeryFinishTime().getValue()))
				uiErrors.add("Surgery Start Time cannot be greater than Surgery Finish Time");
		}
		if( form.dtimSUrgeryFinishTime().getValue() != null && form.dtimAnaesthetistsFinishTime().getValue() != null)
		{
			if( form.dtimSUrgeryFinishTime().getValue().isGreaterThan(form.dtimAnaesthetistsFinishTime().getValue()))
				uiErrors.add("Surgery Finish Time cannot be greater than Anaesthetists Finish Time");
		}
		if( form.dtimAnaesthetistsFinishTime().getValue() != null && form.dtimTimePatientLeavesOpTheatre().getValue() != null)
		{
			//if( form.dtimAnaesthetistsFinishTime().getValue().isGreaterOrEqualThan(form.dtimTimePatientLeavesOpTheatre().getValue()))
			if( form.dtimAnaesthetistsFinishTime().getValue().getDate().isGreaterThan(form.dtimTimePatientLeavesOpTheatre().getValue().getDate()) || (form.dtimAnaesthetistsFinishTime().getValue().getDate().isLessOrEqualThan(form.dtimTimePatientLeavesOpTheatre().getValue().getDate()) && form.dtimAnaesthetistsFinishTime().getValue().getTime().isGreaterThan(form.dtimTimePatientLeavesOpTheatre().getValue().getTime())))
				uiErrors.add("Anaesthetists Finish Time cannot be greater than Time Patient Leaves Op Theatre");
		}
		String[] result = new String[uiErrors.size()];
		uiErrors.toArray(result);
		return result;
	}
	//wdev-15739
	boolean isPerformedOrCancelled(PatientProcedureForSurgicalAuditPreOpChecksVo patproc )
	{
		if( PatientProcedureStatus.PERFORMED.equals(patproc.getProcedureStatus()) || PatientProcedureStatus.CANCELLED.equals(patproc.getProcedureStatus()))
			return true;
		else
			return false;
	}
	//----------------
	private SurgicalAuditOperationDetailVo populateDataFromScreen( SurgicalAuditOperationDetailVo record)
	{
		if( record == null)
			return null;
		
		SurgicalAuditActualProcedureVo actualProcVo = record.getActualProcedure();
		if( actualProcVo == null)
			actualProcVo = new SurgicalAuditActualProcedureVo();
		
		if( actualProcVo.getPatient() == null)
			actualProcVo.setPatient(form.getLocalContext().getPatientRef());
		
		if( actualProcVo.getCareContext() == null)
			actualProcVo.setCareContext(form.getLocalContext().getCareContextRef());
		
		if( actualProcVo.getAuthoringInformation() == null)
		{
			AuthoringInformationVo tempAuthInfVo = new AuthoringInformationVo();
			if( domain.getHcpLiteUser() instanceof HcpLiteVo)
				tempAuthInfVo.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
			
			tempAuthInfVo.setAuthoringDateTime(new DateTime());
			actualProcVo.setAuthoringInformation(tempAuthInfVo);
						
		}
		
		PatientProcedureForSurgicalAuditPreOpChecksVoCollection tempColl = new PatientProcedureForSurgicalAuditPreOpChecksVoCollection();
		for( int i = 0; i < form.grdPlannedPerformedProcedure().getRows().size();i++)
		{
			tempColl.add(form.grdPlannedPerformedProcedure().getRows().get(i).getValue());	
		}
		if( tempColl != null && tempColl.size() > 0)
			actualProcVo.setPlannedActualProcedures(tempColl);
		else
			actualProcVo.setPlannedActualProcedures(null);
		
		SurgicalAuditSurgicalPackVoCollection surColl = new SurgicalAuditSurgicalPackVoCollection();
		for( int j = 0; j < form.grdSurgicalPack().getRows().size();j++)
		{
			surColl.add(form.grdSurgicalPack().getRows().get(j).getValue());
		}
		if(  surColl != null && surColl.size() > 0)
			actualProcVo.setSurgicalPacks(surColl);
		else
			actualProcVo.setSurgicalPacks(null);
		
		actualProcVo.setAnaesthetistsStartTime(form.dtimAnaesthetistaStartDate().getValue());
		actualProcVo.setAnaesthetistsFinishTime(form.dtimAnaesthetistsFinishTime().getValue());
		actualProcVo.setSurgeryStartTime(form.dtimSurgeryStartTime().getValue());
		actualProcVo.setSurgeryFinishTime(form.dtimSUrgeryFinishTime().getValue());
		actualProcVo.setTimeLeftTheatre(form.dtimTimePatientLeavesOpTheatre().getValue());
		actualProcVo.setSent(form.cmbPatientSentTo().getValue());
		
		record.setActualProcedure(actualProcVo);
		//------------------
		
		
		//if( !record.getCurrentStatusIsNotNull() || ( record.getCurrentStatusIsNotNull() && !record.getCurrentStatus().getOperationStatusIsNotNull() ) || ( record.getCurrentStatusIsNotNull() && record.getCurrentStatus().getOperationStatusIsNotNull() && !SurgicalAuditOperationDetailStatus.CANCELLED_OPERATIONS.equals(record.getCurrentStatus().getOperationStatus()) ))
		if( record.getActualProcedureIsNotNull() && record.getActualProcedure().getID_SurgicalAuditActualProcedure() == null 
			&& record.getCurrentStatus() != null && !SurgicalAuditOperationDetailStatus.CANCELLED_OPERATIONS.equals(record.getCurrentStatus().getOperationStatus())
			&&(SurgicalAuditOperationDetailStatus.LEFT_HOLDING_BAY.equals(record.getCurrentStatus().getOperationStatus())|| SurgicalAuditOperationDetailStatus.ENTERED_OPERATING_THEATRE.equals(record.getCurrentStatus().getOperationStatus())))
		{
			HcpLiteVo tempHcp = null;
			if( domain.getHcpLiteUser() instanceof HcpLiteVo)
			{
				tempHcp = ((HcpLiteVo) domain.getHcpLiteUser());
				
			}
			DateTime dTime = new DateTime();
			SurgicalAuditOperationDetailStatusVoCollection surgStatusColl = record.getStatusHistory();
			SurgicalAuditOperationDetailStatusVo surgstatus = populateStatus(SurgicalAuditOperationDetailStatus.ANAESTHETIC_STARTED, dTime, tempHcp != null ? tempHcp.getMos():null);
			surgStatusColl.add(surgstatus);
			surgstatus = populateStatus(SurgicalAuditOperationDetailStatus.SURGERY_STARTED, dTime, tempHcp != null ? tempHcp.getMos():null);
			surgStatusColl.add(surgstatus);
			surgstatus = populateStatus(SurgicalAuditOperationDetailStatus.SURGERY_FINISHED, dTime, tempHcp != null ? tempHcp.getMos():null);
			surgStatusColl.add(surgstatus);
			surgstatus = populateStatus(SurgicalAuditOperationDetailStatus.ANAESTHETIC_FINISHED, dTime, tempHcp != null ? tempHcp.getMos():null);
			surgStatusColl.add(surgstatus);
			surgstatus = populateStatus(SurgicalAuditOperationDetailStatus.LEFT_OPERATING_THEATRE, dTime, tempHcp != null ? tempHcp.getMos():null);
			surgStatusColl.add(surgstatus);
			
			record.setStatusHistory(surgStatusColl);
			record.setCurrentStatus(surgstatus);
		}
		
		//-------------------
		
		
		return record;
	}
	private SurgicalAuditOperationDetailStatusVo populateStatus(SurgicalAuditOperationDetailStatus status, DateTime dateTime, MemberOfStaffLiteVo statusAuthoringUser)
	{
		SurgicalAuditOperationDetailStatusVo statusRecord = new SurgicalAuditOperationDetailStatusVo();
		
		statusRecord.setOperationStatus(status);
		statusRecord.setStatusDateTime(dateTime);
		statusRecord.setAuthoringUser(statusAuthoringUser);
		
		return statusRecord;
	}
	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		HcpLiteVo tempHcp = null;
		if( domain.getHcpLiteUser() instanceof HcpLiteVo)
			tempHcp = (HcpLiteVo) domain.getHcpLiteUser();
		if( tempHcp == null)
		{
			engine.showMessage("The current user is not an HCP");
			return;
		}
			
		// Check SOE on EDIT
		if (form.getLocalContext().getCurrentSurgicalAuditOperationDetails()!=null && form.getLocalContext().getCurrentSurgicalAuditOperationDetails().getID_SurgicalAuditOperationDetailIsNotNull() && domain.isStale(form.getLocalContext().getCurrentSurgicalAuditOperationDetails()))
		{	
			form.getLocalContext().setCurrentSurgicalAuditOperationDetails(domain.getSurgicalAuditOperationDetail(form.getLocalContext().getCurrentSurgicalAuditOperationDetails()));
			clearAll();
			populateScreenFromData(form.getLocalContext().getCurrentSurgicalAuditOperationDetails());
		}
		
		form.getLocalContext().setselectedEvent(SurgicalAuditPreOpChecksEvent.EDIT);
		form.fireCustomControlValueChanged();
		
		form.setMode(FormMode.EDIT);
		
	}
	
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		// TODO Auto-generated method stub
		
	}
	
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		
		if( formName.equals(form.getForms().Clinical.PlannedPerformedProcedureDialog) && result.equals(DialogResult.OK))
		{
			
				if( form.getGlobalContext().Clinical.getSurgicalAuditActualPlannedProcedureIsNotNull() )
				{
					if( Boolean.TRUE.equals(form.getGlobalContext().Clinical.getSurgicalAuditAddEditActualPlannedProcedure()))
						addRowToPlannedPerformedProcedureRow(form.getGlobalContext().Clinical.getSurgicalAuditActualPlannedProcedure(),Boolean.FALSE);
					else
					{
						PatientProcedureForSurgicalAuditPreOpChecksVo tempVo = form.getGlobalContext().Clinical.getSurgicalAuditActualPlannedProcedure(); 
						grdPlannedPerformedProcedureRow row = form.grdPlannedPerformedProcedure().getSelectedRow();
						row.setColumnProcedureName(tempVo.getProcedureDescription());
						row.setTooltipForColumnProcedureName(tempVo.getProcedureDescription());
						row.setColumnProcedureStatus(tempVo.getProcedureStatusIsNotNull() ? tempVo.getProcedureStatus().toString():null);
						row.setTooltipForColumnProcedureStatus(tempVo.getProcedureStatusIsNotNull() ? tempVo.getProcedureStatus().toString():null);
						row.setColumnConsultatntName((tempVo.getConsultantIsNotNull() && tempVo.getConsultant().getMosIsNotNull() && tempVo.getConsultant().getMos().getNameIsNotNull()) ? tempVo.getConsultant().getMos().getName().toString():"");
						row.setTooltipForColumnConsultatntName((tempVo.getConsultantIsNotNull() && tempVo.getConsultant().getMosIsNotNull() && tempVo.getConsultant().getMos().getNameIsNotNull()) ? tempVo.getConsultant().getMos().getName().toString():"");
						row.setColumnSurgeon(tempVo.getPeformedByIsNotNull() && tempVo.getPeformedBy().getMosIsNotNull() && tempVo.getPeformedBy().getMos().getNameIsNotNull() ? tempVo.getPeformedBy().getMos().getName().toString():"");
						row.setTooltipForColumnSurgeon(tempVo.getPeformedByIsNotNull() && tempVo.getPeformedBy().getMosIsNotNull() && tempVo.getPeformedBy().getMos().getNameIsNotNull() ? tempVo.getPeformedBy().getMos().getName().toString():"");
						form.grdPlannedPerformedProcedure().setValue(tempVo);
					}
				}
				updateMenuContext();
						
		}
		if( formName.equals(form.getForms().Clinical.SurgicalPacksDialog) && result.equals(DialogResult.OK))
		{
			grdSurgicalPackRow row = null;
			SurgicalAuditSurgicalPackVo tempVo = form.getGlobalContext().Clinical.getSurgicalAuditSurgicalPack();
			if( tempVo != null)
			{
				
				if( Boolean.TRUE.equals(form.getGlobalContext().Clinical.getSurgicalAuditAddEditSurgicalPack()))
				{
					row = form.grdSurgicalPack().getRows().newRow();
					tempVo.setIsSaved(Boolean.FALSE);
				}
				else
				{
					row = form.grdSurgicalPack().getSelectedRow();
				}
				row.setColumnNameOfSetDevice(tempVo.getSurgicalPack().getIItemText());
				row.setTooltipForColumnNameOfSetDevice(tempVo.getSurgicalPack().getIItemText());
				row.setColumnBarcodeNo(tempVo.getBarcodeNumber());
				row.setTooltipForColumnBarcodeNo(tempVo.getBarcodeNumber());
				row.setColumnFreeText(tempVo.getComment());
				row.setTooltipForColumnFreeText(tempVo.getComment());
				row.setValue(tempVo);
				
			}
			updateMenuContext();
			
		}
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.PlannedActualProcedure.ADD:
				
				form.getGlobalContext().Clinical.setSurgicalAuditAddEditActualPlannedProcedure(Boolean.TRUE); //True  -means add
				form.getGlobalContext().Clinical.setSurgicalAuditActualPlannedProcedure(null);
				form.getGlobalContext().Clinical.setCurrentSurgicalAuditProcedureDetail(domain.getSurgicalAuditOperationDetail(form.getLocalContext().getCurrentSurgicalAuditOperationDetails()).getProcedureDetails());//WDEV-15687
				engine.open(form.getForms().Clinical.PlannedPerformedProcedureDialog);		
				
			break;
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.PlannedActualProcedure.EDIT:
				
				/*form.getGlobalContext().Clinical.setSurgicalAuditAddEditActualPlannedProcedure(Boolean.FALSE); //False - means Edit procedure
				form.getGlobalContext().Clinical.setSurgicalAuditActualPlannedProcedure(form.grdPlannedPerformedProcedure().getValue());
				form.getGlobalContext().Clinical.setCurrentSurgicalAuditProcedureDetail(domain.getSurgicalAuditOperationDetail(form.getLocalContext().getCurrentSurgicalAuditOperationDetails()).getProcedureDetails());//WDEV-15687
				engine.open(form.getForms().Clinical.PlannedPerformedProcedureDialog);*/
				
			break;
			
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.PlannedActualProcedure.CANCEL_THIS_PROCEDURE:
				
				PatientProcedureForSurgicalAuditPreOpChecksVo tempVo = form.grdPlannedPerformedProcedure().getValue();
				if( tempVo != null)
				{
					tempVo.setProcedureStatus(PatientProcedureStatus.CANCELLED);
					tempVo.setConsultant(null);		//wdev-15739
					tempVo.setPeformedBy(null);		//wdev-15739
					
					grdPlannedPerformedProcedureRow row  = form.grdPlannedPerformedProcedure().getSelectedRow();
					row.setColumnProcedureStatus(tempVo.getProcedureStatus().getIItemText());
					row.setTooltipForColumnProcedureStatus(tempVo.getProcedureStatus().getIItemText());
					row.setColumnConsultatntName(null);				//wdev-15739
					row.setTooltipForColumnConsultatntName(null);	//wdev-15739
					row.setColumnSurgeon(null);						//wdev-15739
					row.setTooltipForColumnSurgeon(null);			//wdev-15739
					form.grdPlannedPerformedProcedure().setValue(tempVo);
				}
				updateMenuContext();
				
			break;
			
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.PlannedActualProcedure.SETSTATUSTOPERFORMED:
				
				form.getGlobalContext().Clinical.setSurgicalAuditAddEditActualPlannedProcedure(Boolean.FALSE); //FALSE - means set status to performed
				form.getGlobalContext().Clinical.setSurgicalAuditActualPlannedProcedure(form.grdPlannedPerformedProcedure().getValue());
				form.getGlobalContext().Clinical.setCurrentSurgicalAuditProcedureDetail(domain.getSurgicalAuditOperationDetail(form.getLocalContext().getCurrentSurgicalAuditOperationDetails()).getProcedureDetails());//WDEV-15687
				engine.open(form.getForms().Clinical.PlannedPerformedProcedureDialog);
				
				/*PatientProcedureForSurgicalAuditPreOpChecksVo tempVo1 = form.grdPlannedPerformedProcedure().getValue();
				if( tempVo1 != null)
				{
					tempVo1.setProcedureStatus(PatientProcedureStatus.PERFORMED);
					
					grdPlannedPerformedProcedureRow row  = form.grdPlannedPerformedProcedure().getSelectedRow();
					row.setColumnProcedureStatus(tempVo1.getProcedureStatus().getIItemText());
					row.setTooltipForColumnProcedureStatus(tempVo1.getProcedureStatus().getIItemText());
					form.grdPlannedPerformedProcedure().setValue(tempVo1);
				}*/
				updateMenuContext();
				
			break;
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.PlannedActualProcedure.REMOVE:
				
				if(	form.grdPlannedPerformedProcedure().getValue() != null)
					form.grdPlannedPerformedProcedure().removeSelectedRow();
				
				updateMenuContext();
			break;
			
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.SurgicalAuditSurgicalPacks.ADD:
				
				form.getGlobalContext().Clinical.setSurgicalAuditAddEditSurgicalPack(Boolean.TRUE);    //True means add a surgical pack
				form.getGlobalContext().Clinical.setSurgicalAuditSurgicalPack(null);
				engine.open(form.getForms().Clinical.SurgicalPacksDialog);
				
				
			break;
			
			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.SurgicalAuditSurgicalPacks.EDIT:
				form.getGlobalContext().Clinical.setSurgicalAuditAddEditSurgicalPack(Boolean.FALSE);    //False means edit a surgical pack
				form.getGlobalContext().Clinical.setSurgicalAuditSurgicalPack(form.grdSurgicalPack().getValue());
				engine.open(form.getForms().Clinical.SurgicalPacksDialog);
			break;

			case ims.clinical.forms.surgicalauditplannedactualproceduredetails.GenForm.ContextMenus.ClinicalNamespace.SurgicalAuditSurgicalPacks.REMOVE:
				
				if( form.grdSurgicalPack().getValue() != null )
					form.grdSurgicalPack().removeSelectedRow();
				
				updateMenuContext();
				
			break;
			
		}
		
	}

	public void initialize(PatientRefVo patientRef,	CareContextRefVo careContextRef, SurgicalAuditOperationDetailRefVo surgicalAuditOperationDetailsRef) 
	{
		
		form.getLocalContext().setCareContextRef(careContextRef);
		form.getLocalContext().setPatientRef(patientRef);
		form.getLocalContext().setSurgicalAuditOperationDetailsRef(surgicalAuditOperationDetailsRef);
		populatePatientSentToCombo();
		
		open();
		
	}
	private void open()
	{
		clearAll();
		if(	form.getLocalContext().getSurgicalAuditOperationDetailsRefIsNotNull())
			form.getLocalContext().setCurrentSurgicalAuditOperationDetails(domain.getSurgicalAuditOperationDetail(form.getLocalContext().getSurgicalAuditOperationDetailsRef()));
		else
			form.getLocalContext().setCurrentSurgicalAuditOperationDetails(null);
		
		if( form.getLocalContext().getCurrentSurgicalAuditOperationDetailsIsNotNull() )
		{
			populateScreenFromData(form.getLocalContext().getCurrentSurgicalAuditOperationDetails());
		}
		
		form.setMode(FormMode.VIEW);
		
	}
	
	private void populateScreenFromData(SurgicalAuditOperationDetailVo record)
	{
		if( record == null)
			return;
		
		if( record.getActualProcedureIsNotNull() )
			populateProceduresGrid(record.getActualProcedure().getPlannedActualProcedures());
		else if( record.getPreOpChecksIsNotNull())
			populateProceduresGrid(record.getPreOpChecks().getPlannedProcedures());
	
		if( record.getActualProcedureIsNotNull())
		{
			populateSurgicalPackGrid(record.getActualProcedure().getSurgicalPacks());
			
			form.dtimAnaesthetistaStartDate().setValue(record.getActualProcedure().getAnaesthetistsStartTime());
			form.dtimAnaesthetistsFinishTime().setValue(record.getActualProcedure().getAnaesthetistsFinishTime());
			form.dtimSurgeryStartTime().setValue(record.getActualProcedure().getSurgeryStartTime());
			form.dtimSUrgeryFinishTime().setValue(record.getActualProcedure().getSurgeryFinishTime());
			form.dtimTimePatientLeavesOpTheatre().setValue(record.getActualProcedure().getTimeLeftTheatre());
			
			ArrayList<LocationLiteVo> sentto  = form.cmbPatientSentTo().getValues();
			
			if( sentto != null && record.getActualProcedure().getSentIsNotNull() && !sentto.contains(record.getActualProcedure().getSent()))
				form.cmbPatientSentTo().newRow(record.getActualProcedure().getSent(), record.getActualProcedure().getSent().getName());
			form.cmbPatientSentTo().setValue(record.getActualProcedure().getSent());
		}
		
		
	}
	private void populateProceduresGrid(PatientProcedureForSurgicalAuditPreOpChecksVoCollection recordColl)
	{
		if( recordColl == null || recordColl.size() == 0 )
			return;
		
		
		for(int i = 0; i < recordColl.size();i++)
		{
			PatientProcedureForSurgicalAuditPreOpChecksVo tempVo = recordColl.get(i);
			addRowToPlannedPerformedProcedureRow(tempVo,Boolean.TRUE);		
		}
			
	}
	private void addRowToPlannedPerformedProcedureRow(PatientProcedureForSurgicalAuditPreOpChecksVo tempVo ,Boolean action)
	{
		if( tempVo != null)
		{
			grdPlannedPerformedProcedureRow row = form.grdPlannedPerformedProcedure().getRows().newRow();
			row.setColumnProcedureName(tempVo.getProcedureDescription());
			row.setTooltipForColumnProcedureName(tempVo.getProcedureDescription());
			row.setColumnProcedureStatus(tempVo.getProcedureStatusIsNotNull() ? tempVo.getProcedureStatus().toString():null);
			row.setTooltipForColumnProcedureStatus(tempVo.getProcedureStatusIsNotNull() ? tempVo.getProcedureStatus().toString():null);
			row.setColumnConsultatntName((tempVo.getConsultantIsNotNull() && tempVo.getConsultant().getMosIsNotNull() && tempVo.getConsultant().getMos().getNameIsNotNull()) ? tempVo.getConsultant().getMos().getName().toString():"");
			row.setTooltipForColumnConsultatntName((tempVo.getConsultantIsNotNull() && tempVo.getConsultant().getMosIsNotNull() && tempVo.getConsultant().getMos().getNameIsNotNull()) ? tempVo.getConsultant().getMos().getName().toString():"");
			row.setColumnSurgeon(tempVo.getPeformedByIsNotNull() && tempVo.getPeformedBy().getMosIsNotNull() && tempVo.getPeformedBy().getMos().getNameIsNotNull() ? tempVo.getPeformedBy().getMos().getName().toString():"");
			row.setTooltipForColumnSurgeon(tempVo.getPeformedByIsNotNull() && tempVo.getPeformedBy().getMosIsNotNull() && tempVo.getPeformedBy().getMos().getNameIsNotNull() ? tempVo.getPeformedBy().getMos().getName().toString():"");
			tempVo.setIsSaved(action);
			row.setValue(tempVo);
		}

	}
	private void populateSurgicalPackGrid( SurgicalAuditSurgicalPackVoCollection surgColl)
	{
		if( surgColl != null && surgColl.size() == 0 )
			return;
		for( int i = 0; i < surgColl.size(); i++)
		{
			SurgicalAuditSurgicalPackVo tempVo = surgColl.get(i);
			if( tempVo != null )
			{
				grdSurgicalPackRow row = form.grdSurgicalPack().getRows().newRow();
				row.setColumnNameOfSetDevice(tempVo.getSurgicalPackIsNotNull() ? tempVo.getSurgicalPack().getIItemText():null);
				row.setTooltipForColumnNameOfSetDevice(tempVo.getSurgicalPackIsNotNull() ? tempVo.getSurgicalPack().getIItemText():null);
				row.setColumnBarcodeNo(tempVo.getBarcodeNumber());
				row.setTooltipForColumnBarcodeNo(tempVo.getBarcodeNumber());
				row.setColumnFreeText(tempVo.getComment());
				row.setTooltipForColumnFreeText(tempVo.getComment());
				tempVo.setIsSaved(Boolean.TRUE);
				row.setValue(tempVo);
			}
		}
		
	}
		
	private void clearAll()
	{
		form.grdPlannedPerformedProcedure().getRows().clear();
		form.grdSurgicalPack().getRows().clear();
		form.dtimAnaesthetistaStartDate().setValue(null);
		form.dtimAnaesthetistsFinishTime().setValue(null);
		form.dtimSUrgeryFinishTime().setValue(null);
		form.dtimSurgeryStartTime().setValue(null);
		form.dtimTimePatientLeavesOpTheatre().setValue(null);
		form.cmbPatientSentTo().setValue(null);
		
	}
	private void updateMenuContext()
	{
		form.getContextMenus().Clinical.hideAllPlannedActualProcedureMenuItems();
		form.getContextMenus().Clinical.hideAllSurgicalAuditSurgicalPacksMenuItems();
		
		if( form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().Clinical.getPlannedActualProcedureADDItem().setVisible(true);
			//form.getContextMenus().Clinical.getPlannedActualProcedureEDITItem().setVisible(form.grdPlannedPerformedProcedure().getValue() != null);
			form.getContextMenus().Clinical.getPlannedActualProcedureCANCEL_THIS_PROCEDUREItem().setVisible(form.grdPlannedPerformedProcedure().getValue() != null && !PatientProcedureStatus.CANCELLED.equals(form.grdPlannedPerformedProcedure().getValue().getProcedureStatus()));
			form.getContextMenus().Clinical.getPlannedActualProcedureSETSTATUSTOPERFORMEDItem().setVisible(form.grdPlannedPerformedProcedure().getValue() != null && !PatientProcedureStatus.PERFORMED.equals(form.grdPlannedPerformedProcedure().getValue().getProcedureStatus()));
			form.getContextMenus().Clinical.getPlannedActualProcedureREMOVEItem().setVisible(form.grdPlannedPerformedProcedure().getValue() != null && !Boolean.TRUE.equals(form.grdPlannedPerformedProcedure().getValue().getIsSaved()));
			
			form.getContextMenus().Clinical.getSurgicalAuditSurgicalPacksADDItem().setVisible(true);
			form.getContextMenus().Clinical.getSurgicalAuditSurgicalPacksEDITItem().setVisible(form.grdSurgicalPack().getValue() != null );
			form.getContextMenus().Clinical.getSurgicalAuditSurgicalPacksREMOVEItem().setVisible(form.grdSurgicalPack().getValue() != null && !Boolean.TRUE.equals(form.grdSurgicalPack().getValue().getIsSaved()));
			
		}
		
		
	}

	protected void onFormModeChanged() 
	{
		updateMenuContext();
		updateControlsState();
		
	}
	private void populatePatientSentToCombo()
	{
		form.cmbPatientSentTo().clear();
		
		LocationLiteVo  locVo= null,tempLocVo = null;
		LocSiteLiteVo	locSiteVo = null;
		LocationLiteVoCollection locationColl = null;
		
		if( domain.getCurrentLocation() instanceof LocationLiteVo)
		{
			locVo = (LocationLiteVo) domain.getCurrentLocation();
		}
		else if( domain.getCurrentLocation() instanceof LocSiteLiteVo)
		{
			locSiteVo = (LocSiteLiteVo) domain.getCurrentLocation();
		}
		if( locVo != null )
		{
			tempLocVo = locVo;
		}
		else if( locSiteVo != null)
		{
			tempLocVo = domain.getLocationLiteVo(locSiteVo);
		}
		if( tempLocVo != null)
		{
			if( LocationType.HOSP.equals(tempLocVo.getType()))
				locationColl = domain.listLocationsByParentLocation(tempLocVo);
			else
				locationColl = domain.listActiveLocationsAtTheSameLevelWithLocation(tempLocVo);
			
		}
		if( locationColl != null)
		{
			locationColl.sort(new LocComparator(SortOrder.ASCENDING));
			for(int i = 0; i < locationColl.size();i++)
			{
				form.cmbPatientSentTo().newRow(locationColl.get(i), locationColl.get(i).getName());
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
			String pdate1 = null;
			String pdate2 = null;
			if(ob1 instanceof LocationLiteVo )
			{
				LocationLiteVo ps1 = (LocationLiteVo)ob1;
				pdate1 = ps1.getName();
			}
			if(ob2 instanceof LocationLiteVo)
			{
				LocationLiteVo ps2 = (LocationLiteVo)ob2;
				pdate2 = ps2.getName();
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
	
	protected void onGrdSurgicalPackSelectionChanged() throws PresentationLogicException 
	{
		updateMenuContext();
		
	}

	
	protected void onGrdPlannedPerformedProcedureSelectionChanged() throws PresentationLogicException 
	{
		updateMenuContext();
		
	}

	
	public SurgicalAuditPreOpChecksEvent getSelectedEvent() 
	{
		return form.getLocalContext().getselectedEvent();
	}

	
	public void resetSelectedEvent() 
	{
		form.getLocalContext().setselectedEvent(null);
		
	}

	//changes 31/07/2012
	public void setReadOnly(Boolean argument)
	{
		form.getLocalContext().setisReadOnly(argument);
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && form.getLocalContext().getCurrentSurgicalAuditOperationDetailsIsNotNull());
		form.btnEdit().setEnabled(FormMode.VIEW.equals(form.getMode()) && form.getLocalContext().getCurrentSurgicalAuditOperationDetailsIsNotNull() && Boolean.FALSE.equals(form.getLocalContext().getisReadOnly()));
	
	}
	
}
