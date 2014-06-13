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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.patientmerge;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientFilter;
import ims.core.vo.PatientId;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateFormat;

import java.util.Vector;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
		initialize();	
	}
	private void open() 
	{
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.imbMerge().setVisible(false);
		form.imbMerge().setEnabled(false);
		form.cmbFromIdType().setValue(dispIdType);
		form.txtFromId().setValue(null);
		form.cmbToIdType().setValue(dispIdType);
		form.txtToId().setValue(null);
		PatIdType disIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.getLocalContext().setPatientType(disIdType.getIItemText());
		form.grdFromPatDetails().setcolHospCaption(form.getLocalContext().getPatientType());
		form.grdToPatDetails().setcolHospCaption(form.getLocalContext().getPatientType());
	}
	private void initialize() 
	{
		Integer[] patients = domain.listPatientsWaitingToBeMerged();
		if (patients!=null)
		{
			Vector<Integer> patIds=new Vector<Integer>();
		
			for (int i=0;i<patients.length;i++)
			{
				patIds.add(patients[i]);
			}
			form.getLocalContext().setMergedPatients(patIds);
		}
	}
	@Override
	protected void onImbFromClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchFields(form.grdFromPatDetails());
		form.grdFromPatDetails().getRows().clear();
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.cmbFromIdType().setValue(dispIdType);
		form.txtFromId().setValue(null);
		updateControlState();
	}
	@Override
	protected void onImbFromSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		searchPatients(form.grdFromPatDetails());
		form.getLocalContext().setPatientFrom(null);
		updateControlState();
	}
	private void searchPatients(Object sender) 
	{
		PatientFilter voPatientFilter = new PatientFilter();
		PatientShortCollection voCollPatientShort = new PatientShortCollection();
		
		if(sender.equals(form.grdFromPatDetails()))	
		{
			form.grdFromPatDetails().getRows().clear();
			
			//WDEV-16617
			if (form.txtFromId().getValue() != null && form.cmbFromIdType().getValue() == null)
			{
				engine.showMessage("Please select a Patient ID Type.");
				return;
			}
		
			if (form.txtFromId().getValue() != null && form.txtFromId().getValue().length() > 0)
			{
				PatientId pid = new PatientId();
				pid.setType(form.cmbFromIdType().getValue());	
				pid.setValue(form.txtFromId().getValue());			
				voPatientFilter.setPersId(pid);
				clearSearchFields(sender);
			}
			else 
			{
				if (form.txtFromSurname().getValue() == null || form.txtFromSurname().getValue().length() == 0)
				{
					engine.showMessage("Please enter a surname search string");
					return;				
				}
				
				if(ims.configuration.gen.ConfigFlag.UI.SEARCH_REQ_FORENAME.getValue() )
				{
					//Mandatory Search on forname
					if (form.txtFromForename().getValue() == null || form.txtFromForename().getValue().length() == 0)
					{
					   engine.showMessage("Please enter at least the first character of the forename");
					   return;
					}
				}
						
				voPatientFilter.setSurname(form.txtFromSurname().getValue());
				voPatientFilter.setForename(form.txtFromForename().getValue());
				voPatientFilter.setDob(form.pdtFromDOB().getValue());
				voPatientFilter.setSex(form.cmbFromSex().getValue());
				
			}					
		}
		else
		{
			form.grdToPatDetails().getRows().clear();
			
			//WDEV-16617
			if (form.txtToId().getValue() != null && form.cmbToIdType().getValue() == null)
			{
				engine.showMessage("Please select a Patient ID Type.");
				return;
			}
			
			if (form.txtToId().getValue() != null && form.txtToId().getValue().length() > 0)
			{
				PatientId pid = new PatientId();
				pid.setType(form.cmbToIdType().getValue());	
				pid.setValue(form.txtToId().getValue());			
				voPatientFilter.setPersId(pid);
				clearSearchFields(sender);
			}
			else 
			{
				if (form.txtToSurname().getValue() == null || form.txtToSurname().getValue().length() == 0)
				{
					engine.showMessage("Please enter a surname search string");
					return;				
				}
				
				if(ims.configuration.gen.ConfigFlag.UI.SEARCH_REQ_FORENAME.getValue() )
				{
					//Mandatory Search on forname
					if (form.txtToForename().getValue() == null || form.txtToForename().getValue().length() == 0)
					{
					   engine.showMessage("Please enter at least the first character of the forename");
					   return;
					}
				}
						
				voPatientFilter.setSurname(form.txtToSurname().getValue());
				voPatientFilter.setForename(form.txtToForename().getValue());
				voPatientFilter.setDob(form.pdtToDOB().getValue());
				voPatientFilter.setSex(form.cmbToSex().getValue());
				
			}					
		}
		
		try  
		{
			voCollPatientShort = domain.searchPatients(voPatientFilter);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		if (voCollPatientShort.size() == 0) 
		{
			engine.showMessage("No patients found");
			return;
		}		
		
		populatePatientsGrid(sender, voCollPatientShort);
	}
	private void clearSearchFields(Object sender) 

	{
		if(sender.equals(form.grdFromPatDetails()))
		{
			form.txtFromSurname().setValue("");
			form.txtFromForename().setValue("");
			form.pdtFromDOB().setValue(null);
			form.cmbFromSex().setValue(null);
			form.getLocalContext().setPatientFrom(null);
		}
		else
		{
			form.txtToSurname().setValue("");
			form.txtToForename().setValue("");
			form.pdtToDOB().setValue(null);
			form.cmbToSex().setValue(null);
			form.getLocalContext().setPatientTo(null);
		}
	}
	private void populatePatientsGrid(Object sender, PatientShortCollection voCollPatientShort) 
	{
		boolean bPopulategrdFromPatDetails;
		if(sender.equals(form.grdFromPatDetails()))
			bPopulategrdFromPatDetails = true;
		else
			bPopulategrdFromPatDetails = false;
		
		GenForm.grdFromPatDetailsRow fromRow = null;
		GenForm.grdToPatDetailsRow toRow = null;
		PatientShort voPatientShort;
		for(int i=0;i<voCollPatientShort.size();i++)
		{
			voPatientShort = voCollPatientShort.get(i);
			
			if(bPopulategrdFromPatDetails)
				fromRow = form.grdFromPatDetails().getRows().newRow();
			else
				toRow = form.grdToPatDetails().getRows().newRow();
			

			if(voPatientShort.getPpsn() != null)
			{
				String strPPSN = voPatientShort.getPpsn().getValue();
				if(bPopulategrdFromPatDetails)
					fromRow.setcolFromPps(strPPSN);
				else
					toRow.setcolPpsNo(strPPSN);
			}
				
			if (voPatientShort.getDisplayId() != null) 
			{
				//String strNTPFN = voPatientShort.getDisplayId().getValue();
				if(bPopulategrdFromPatDetails)
					displayID(voPatientShort, fromRow);
				else
					displayID(voPatientShort, toRow);
			}
						
			
			if(bPopulategrdFromPatDetails)
				fromRow.setcolFromName(voPatientShort.getName().toString());
			else
				toRow.setcolPatientName(voPatientShort.getName().toString());
				
			if (voPatientShort.getSex() != null)
			{
				String strSex = voPatientShort.getSex().getText();
				if(bPopulategrdFromPatDetails)
					fromRow.setcolFromSex(strSex);
				else
					toRow.setcolSex(strSex);
			}
								
			if (voPatientShort.getDob() != null)
			{
				String strDob = voPatientShort.getDob().toString(DateFormat.STANDARD);
				if(bPopulategrdFromPatDetails)
					fromRow.setcolFromDOB(strDob);
				else
					toRow.setcolDOB(strDob);
			}
			if(bPopulategrdFromPatDetails)
			{
				fromRow.setValue(voPatientShort);
				
				if (voPatientShort.getIsDead().booleanValue())
					fromRow.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());
				if (form.getLocalContext().getMergedPatients()!=null)
					if (form.getLocalContext().getMergedPatients().contains(voPatientShort.getID_Patient()))
						fromRow.setBackColor(Color.Bisque);
			}
			else
			{
				toRow.setValue(voPatientShort);
				if (voPatientShort.getIsDead().booleanValue())
					toRow.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());
				if (form.getLocalContext().getMergedPatients()!=null)
					if (voPatientShort.getID_PatientIsNotNull())
						if (form.getLocalContext().getMergedPatients().contains(voPatientShort.getID_Patient()))
							toRow.setBackColor(Color.Bisque);
			}	
					
		}
	}
	
	@Override
	protected void onGrdFromPatDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdFromPatDetails().getValue()!=null)
		{
			form.getLocalContext().setPatientFrom(form.grdFromPatDetails().getValue().toPatientRefVo());
		}
		else
			form.getLocalContext().setPatientFrom(null);
		
		updateControlState();
			
	}
	private void updateControlState() {
		if (form.getLocalContext().getPatientToIsNotNull()&&form.getLocalContext().getPatientFromIsNotNull())
		{
			form.imbMerge().setVisible(true);
			form.imbMerge().setEnabled(true);
		}
		else
		{
			form.imbMerge().setVisible(false);
			form.imbMerge().setEnabled(false);
		}
	}
	
//	private void setPatientForRecord(ValueObject voRecord, PatientShort patient) 
//	{
//		if(voRecord instanceof CaseReferralMergeVo)
//		{
//			CaseReferralMergeVo voCase = (CaseReferralMergeVo) voRecord;
//			voCase.setPatient(patient);
//			for(int i=0;i<voCase.getAssociatedCases().size();i++)
//				setPatientForRecord(voCase.getAssociatedCases().get(i), patient);
//		}
//		else if(voRecord instanceof InvoiceMergeVo)
//		{
//			InvoiceMergeVo voInvoice = (InvoiceMergeVo) voRecord;
//			voInvoice.setPatient(patient);
//		}
//		else if(voRecord instanceof OutlierMergeVo)
//		{
//			OutlierMergeVo voOutlier = (OutlierMergeVo) voRecord;
//			voOutlier.setPatient(patient);
//		}
//		else if(voRecord instanceof LocallMergeVo)
//		{
//			LocallMergeVo voLocall = (LocallMergeVo) voRecord;
//			voLocall.setPatient(patient);
//		}
//	}
	@Override
	protected void onImbToClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchFields(form.grdToPatDetails());
		form.grdToPatDetails().getRows().clear();
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.cmbToIdType().setValue(dispIdType);
		form.txtToId().setValue(null);
		updateControlState();
	}
	@Override
	protected void onImbToSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		searchPatients(form.grdToPatDetails());
		form.getLocalContext().setPatientTo(null);
		updateControlState();
	}
	@Override
	protected void onGrdToPatDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdToPatDetails().getValue()!=null)
		{
			form.getLocalContext().setPatientTo(form.grdToPatDetails().getValue().toPatientRefVo());
		}
		else
			form.getLocalContext().setPatientTo(null);
		
		updateControlState();
			
	}
	@Override
	protected void onImbMergeClick() throws PresentationLogicException 
	{
		if ((form.getLocalContext().getPatientFrom().getID_Patient()).equals(form.getLocalContext().getPatientTo().getID_Patient()))
		{
			String [] errors={"You can't merge the same Patient"};
			engine.showErrors(errors);
			return;
		}
		
		engine.showMessage("Are you sure you want to merge these patients?","Patient Merge", MessageButtons.OKCANCEL);
	}
	
	private void setRowsColour(Boolean bMergeColour) 
	{
		GenForm.grdFromPatDetailsRow rowFrom = form.grdFromPatDetails().getRowByValue(form.grdFromPatDetails().getValue());
		if(bMergeColour.booleanValue())
			rowFrom.setBackColor(Color.Bisque);
		else
			rowFrom.setBackColor(Color.White);
		
		GenForm.grdToPatDetailsRow rowTo = form.grdToPatDetails().getRowByValue(form.grdToPatDetails().getValue());
		if(bMergeColour.booleanValue())
			rowTo.setBackColor(Color.Bisque);
		else
			rowTo.setBackColor(Color.White);
	}
	
	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException 
	{
		if (result.equals(DialogResult.OK))
		{
			form.getGlobalContext().Core.setPatientSource(form.grdFromPatDetails().getValue());
			form.getGlobalContext().Core.setPatientDestination(form.grdToPatDetails().getValue());
			engine.open(form.getForms().Core.PatientMergeDemographics);	
		}
		
		initialize();	
	}
	private void displayID(PatientShort patient, GenForm.grdFromPatDetailsRow aRow) 
	{
		if(form.getLocalContext().getPatientType().equals("HOSPNUM"))
		{
			if (patient.getHospnum()!=null)
				aRow.setcolHosp(patient.getHospnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("PKEY"))
		{
			if (patient.getPkey()!=null)
				aRow.setcolHosp(patient.getPkey().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("NHSN"))
		{
			if (patient.getNhsn()!=null)
				aRow.setcolHosp(patient.getNhsn().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("PPSN"))
		{
			if (patient.getPpsn()!=null)
				aRow.setcolHosp(patient.getPpsn().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CHARTNUM"))
		{
			if (patient.getChartnum()!=null)
				aRow.setcolHosp(patient.getChartnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("NTPFNUM"))
		{
			if (patient.getNtpfnum()!=null)
				aRow.setcolHosp(patient.getNtpfnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("SENTNUM"))
		{
			if (patient.getSentnum()!=null)
				aRow.setcolHosp(patient.getSentnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("DISTRICT"))
		{
			if (patient.getDistrict()!=null)
				aRow.setcolHosp(patient.getDistrict().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("EMPI"))
		{
			if (patient.getEmpi()!=null)
				aRow.setcolHosp(patient.getEmpi().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CASENUM"))
		{
			if (patient.getCaseNum()!=null)
				aRow.setcolHosp(patient.getCaseNum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CLIENTID"))
		{
			if (patient.getClientId()!=null)
				aRow.setcolHosp(patient.getClientId().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("GMSID"))
		{
			if (patient.getGmsId()!=null)
				aRow.setcolHosp(patient.getGmsId().getValue());
		}
		
		else
			aRow.setcolHosp(patient.getDisplayId().getValue());
	}

	private void displayID(PatientShort patient, GenForm.grdToPatDetailsRow aRow) 
	{
		if(form.getLocalContext().getPatientType().equals("HOSPNUM"))
		{
			if (patient.getHospnum()!=null)
				aRow.setcolHosp(patient.getHospnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("PKEY"))
		{
			if (patient.getPkey()!=null)
				aRow.setcolHosp(patient.getPkey().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("NHSN"))
		{
			if (patient.getNhsn()!=null)
				aRow.setcolHosp(patient.getNhsn().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("PPSN"))
		{
			if (patient.getPpsn()!=null)
				aRow.setcolHosp(patient.getPpsn().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CHARTNUM"))
		{
			if (patient.getChartnum()!=null)
				aRow.setcolHosp(patient.getChartnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("NTPFNUM"))
		{
			if (patient.getNtpfnum()!=null)
				aRow.setcolHosp(patient.getNtpfnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("SENTNUM"))
		{
			if (patient.getSentnum()!=null)
				aRow.setcolHosp(patient.getSentnum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("DISTRICT"))
		{
			if (patient.getDistrict()!=null)
				aRow.setcolHosp(patient.getDistrict().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("EMPI"))
		{
			if (patient.getEmpi()!=null)
				aRow.setcolHosp(patient.getEmpi().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CASENUM"))
		{
			if (patient.getCaseNum()!=null)
				aRow.setcolHosp(patient.getCaseNum().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("CLIENTID"))
		{
			if (patient.getClientId()!=null)
				aRow.setcolHosp(patient.getClientId().getValue());
		}
		else if(form.getLocalContext().getPatientType().equals("GMSID"))
		{
			if (patient.getGmsId()!=null)
				aRow.setcolHosp(patient.getGmsId().getValue());
		}
		
		else
			aRow.setcolHosp(patient.getDisplayId().getValue());
	}
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(form.getForms().Core.PatientMergeDemographics.equals(formName))
		{
			if(DialogResult.OK.equals(result))
			{
				setRowsColour(Boolean.TRUE);
				form.getLocalContext().setPatientFrom(null);
				form.getLocalContext().setPatientTo(null);
				form.grdFromPatDetails().setValue(null);
				form.grdToPatDetails().setValue(null);
				updateControlState();
			}
		}
	}
}
