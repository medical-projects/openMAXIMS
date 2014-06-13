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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.22 build 41210.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.waterlowdialog;

import ims.coe.vo.RiskAssessment;
import ims.coe.vo.RiskAssessmentCollection;
import ims.coe.vo.RiskDescription;
import ims.core.vo.HcpLiteVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.WaterlowAssessmentDetailsVo;
import ims.nursing.vo.WaterlowAssessmentDetailsVoCollection;
import ims.nursing.vo.WaterlowAssessmentVo;
import ims.spinalinjuries.vo.NurAssessmentSkinVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() 
	{
		RiskAssessmentCollection risks = form.getGlobalContext().Nursing.getWaterlowAssessments();
		
		if(risks == null)
		{
			engine.showMessage("Could not retrieve the Waterlow Assessments !");
			return;
		}
		
		WaterlowAssessmentVo water = form.getGlobalContext().Nursing.getWaterlowRecord();
		
		if(water == null && Boolean.TRUE.equals(form.getGlobalContext().Nursing.getCopyLast()))
		{
			WaterlowAssessmentVo lastRecord = domain.getLastWaterlowForCurrentAdmission(form.getGlobalContext().Core.getCurrentCareContext());
			
			if(lastRecord == null)
			{
				//should not get here as the Copy Last button is only enabled if there is a "last Waterlow" record recorded against a care context
				//that is owned by the current episode of care
				engine.showMessage("Could not get the last waterlow record from database !");
				return;
			}
			
			form.getLocalContext().setLastWaterlow(lastRecord);
			
			water = new WaterlowAssessmentVo();
			
			//current clinical contact
			water.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			//current care context
			water.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			water.setComment(lastRecord.getComment());
			water.setDateTimeInitiated(new DateTime());

			HcpLiteVo voHcp = (HcpLiteVo)domain.getHcpLiteUser();
			water.setHcpInitiated(voHcp);
			
			WaterlowAssessmentDetailsVoCollection detailsColl = new WaterlowAssessmentDetailsVoCollection();
			for(WaterlowAssessmentDetailsVo item : lastRecord.getAssessmentDetails())
			{
				WaterlowAssessmentDetailsVo newItem = new WaterlowAssessmentDetailsVo();
				
				newItem.setAssessment(item.getAssessment());
				newItem.setSelect(item.getSelect());
				
				detailsColl.add(newItem);
			}
			water.setAssessmentDetails(detailsColl);
			
			form.getGlobalContext().Nursing.setWaterlowRecord(water);
		}
		
		form.grdAssessment().getRows().clear();
		for(int i = 0; i < risks.size(); i++)
		{
			RiskAssessment risk = risks.get(i);
			
			GenForm.grdAssessmentRow row = form.grdAssessment().getRows().newRow();
			
			row.setRisk(risk.getName());
			row.setBold(true);
			row.setBackColor(Color.Beige);
			row.setValue(risk.getMultiple().booleanValue() == true ? "Y" : "N");
			row.setTooltip(risk.getDescription());
			
			for (int j = 0; j < risk.getRiskFactors().size(); j++)
			{
				GenForm.grdAssessmentRow child = row.getRows().newRow();
				
				RiskDescription descr = risk.getRiskFactors().get(j);
				
				child.setRisk(descr.getName());
				child.setValue(descr.getId());
				child.setTooltip(descr.getDescription());
				
				if(water == null)
				{
					if(risk.getName().equalsIgnoreCase("Sex"))
					{
						if(descr.getId().equals("1") && form.getGlobalContext().Core.getPatientShort().getSex()!= null && form.getGlobalContext().Core.getPatientShort().getSex().getText().startsWith("M"))
							child.setSelect(true); //male
						else
						if(descr.getId().equals("2") && form.getGlobalContext().Core.getPatientShort().getSex()!= null && form.getGlobalContext().Core.getPatientShort().getSex().getText().startsWith("F"))
							child.setSelect(true); //female
					}
					else
					if(risk.getName().equalsIgnoreCase("Age"))
					{
						if(form.getGlobalContext().Core.getPatientShort().getAge() != null)
						{
		//RF 24/2/2005 Looks wrong....>= 60 and >=14 and <= 49
		//					if(descr.getId().equals("3") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 60  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 14 && form.getGlobalContext().Core.getPatientShort().getAge().intValue() <= 49)
							if(descr.getId().equals("3") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 14 && form.getGlobalContext().Core.getPatientShort().getAge().intValue() <= 49)
								child.setSelect(true); //14-49
							else if(descr.getId().equals("4") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 50  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() <= 64)
								child.setSelect(true); //50-64
							else if(descr.getId().equals("5") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 65  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() <= 74)
								child.setSelect(true); //65-74
							else if(descr.getId().equals("6") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 75  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() <= 80)
								child.setSelect(true); //75-80
							else if(descr.getId().equals("7") && form.getGlobalContext().Core.getPatientShort().getAge().intValue() > 80)
								child.setSelect(true); //80+
						}
					}
					
				}
				else if(water != null)
				{
					//update mode
					for(int k = 0; k < water.getAssessmentDetails().size(); k++)
					{
						if(descr.getId().equals(water.getAssessmentDetails().get(k).getAssessment().toString()))
						{
							child.setSelect(water.getAssessmentDetails().get(k).getSelect().booleanValue());
							break;
						}
					}
				}
			}
			
			row.setExpanded(true);
		}
		
		// make editable if global context Nursing.GetEdit is set to true
		if (form.getGlobalContext().Nursing.getEditIsNotNull())
		{
			form.grdAssessment().setReadOnly(!form.getGlobalContext().Nursing.getEdit().booleanValue());
			form.btnSave().setEnabled(form.getGlobalContext().Nursing.getEdit().booleanValue());
			form.txtComments().setEnabled(form.getGlobalContext().Nursing.getEdit().booleanValue());
		}
		
		if(water == null)
		{
			form.dteDate().setValue(new Date());
			form.timTime().setValue(new Time());
			
			HcpLiteVo voHcp = (HcpLiteVo)domain.getHcpLiteUser();
			form.getLocalContext().setHcp(voHcp);
			
			if(form.getLocalContext().getHcp() != null)
				form.txtHcp().setValue(form.getLocalContext().getHcp().getName().toString());
		}
		else
		{
			form.dteDate().setValue(water.getDateTimeInitiated().getDate());
			form.timTime().setValue(water.getDateTimeInitiated().getTime());
			
			if(water.getHcpInitiated() != null && water.getHcpInitiated().getName() != null)
				form.txtHcp().setValue(water.getHcpInitiated().getName().toString());
			
			form.txtComments().setValue(water.getComment());
		}
		
		// If there is an associated mobility component for this assessment that is complete
		// we want to disable the save button
		AssessmentComponent comp = form.getGlobalContext().Nursing.getAssessmentComponent();
		if (comp != null && comp.getIsComplete().booleanValue() == true)
		{
			form.btnSave().setEnabled(false);
			form.grdAssessment().setReadOnly(true);
		}
		
		//we can update a Braden record which belongs to an Skin assessment via Skin assessment page only  
		if(form.getGlobalContext().Nursing.getWaterlowRecordIsNotNull() && comp == null)
		{
			Boolean bIsPart = null;
			
			try
			{
				if(Boolean.TRUE.equals(form.getGlobalContext().Nursing.getCopyLast()))
					bIsPart = domain.isPartOfSkinAssessment(form.getLocalContext().getLastWaterlow());
				else
					bIsPart = domain.isPartOfSkinAssessment(form.getGlobalContext().Nursing.getWaterlowRecord());
			} catch (DomainInterfaceException e1)
			{
				engine.showMessage("Error retrieving skin assessment record: " + e1.getMessage());
				return;
			}

			if(bIsPart == Boolean.TRUE)
			{
				form.btnSave().setEnabled(false);
				form.grdAssessment().setReadOnly(true);
			}
		}
	}
	protected void onBtnCancelClick() 
	{
		form.getGlobalContext().Nursing.setCopyLast(null);
		engine.close(DialogResult.CANCEL);
	}
	protected void onBtnSaveClick() 
	{
		if(bCheckData() == false)
			return;
		
		WaterlowAssessmentVo record = form.getGlobalContext().Nursing.getWaterlowRecord();
		
		if(record == null)
		{
			//new
			record = populateDataFromScreen();
		}
		else
		{
			//update
			record = populateDataFromScreen(record);
		}	

		if(record == null)
			return;
		
		record.setAssessmentDetails(new WaterlowAssessmentDetailsVoCollection());
		
		for (int i = 0; i < form.grdAssessment().getRows().size(); i++)
		{
			GenForm.grdAssessmentRow row = form.grdAssessment().getRows().get(i);
			
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdAssessmentRow child = row.getRows().get(j);

				WaterlowAssessmentDetailsVo detail = new ims.nursing.vo.WaterlowAssessmentDetailsVo();
				detail.setAssessment(new Integer(child.getValue()));
				detail.setSelect(new Boolean(child.getSelect()));

				record.getAssessmentDetails().add(detail);
			}
		}
 
		record.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		//current care context
		record.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		String[] errors = record.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}	

		try
		{
			// If there is an assesment component in the global context, we want to save that too!
			if(form.getGlobalContext().Nursing.getAssessmentComponent() != null && form.getGlobalContext().Nursing.getAssessmentComponent() instanceof NurAssessmentSkinVo)
			{
				NurAssessmentSkinVo comp = (NurAssessmentSkinVo)form.getGlobalContext().Nursing.getAssessmentComponent();
				comp.setWaterlow(record); 
				comp.setWaterlowScore(new Integer(getAssessmentScore()));
				
				String[] arrErrors = comp.validate();
				if(arrErrors != null)
				{
					engine.showErrors("Validation Errors", arrErrors);
					return;
				}
				AssessmentHeaderInfo headerInfo = domain.saveRecord(record,form.getGlobalContext().Nursing.getAssessmentHeaderInfo(), comp);
				// Go back to the skin assessment form
				form.getGlobalContext().Nursing.setAssessmentHeaderInfo(headerInfo);
			}
			else
			{
				domain.saveRecord(record, null, null);
			}
			
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);
			return;
		}
		catch (DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		if(form.getGlobalContext().Nursing.getDisplayScoreIsNotNull() && form.getGlobalContext().Nursing.getDisplayScore().equals(Boolean.TRUE))
		{
			float fScore = getAssessmentScore();
			form.getGlobalContext().Nursing.setAssessmentScore(new Float(fScore));
		}
		
		form.getGlobalContext().Nursing.setCopyLast(null);		
		engine.close(DialogResult.OK);
	}
	
	private boolean bCheckData()
	{
		String question;
		
		for (int i = 0; i < form.grdAssessment().getRows().size(); i++)
		{
			GenForm.grdAssessmentRow row = form.grdAssessment().getRows().get(i);
			
			question = row.getRisk();
			
			//all mandatory questions must be answered
			int nAnswers = 0;
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdAssessmentRow child = row.getRows().get(j);
				
				if(child.getSelect() == true)
				{
					nAnswers++;
					break;
				}
			}
			if(nAnswers == 0 && isAnswerMandatory(question) == true)
			{
				engine.showMessage("The question '" + row.getRisk() + "' was not answered !");
				return false;
			}
			
			
			if(row.getValue().equalsIgnoreCase("N"))
			{
				int nFound = 0;
				for (int j = 0; j < row.getRows().size(); j++)
				{
					GenForm.grdAssessmentRow child = row.getRows().get(j);
					
					if(child.getSelect() == true)
						nFound++;
				}
				
				if(nFound > 1)
				{
					engine.showMessage("The answers for risk factor '" + row.getRisk() + "' are mutually exclusive. Please select only one answer.");
					return false;
				}
			}
		}
		
		return true;
	}
	
	protected WaterlowAssessmentVo populateDataFromScreen()
	{
		WaterlowAssessmentVo record = super.populateDataFromScreen();
		
		if(form.getLocalContext().getHcp() != null)
			record.setHcpInitiated(form.getLocalContext().getHcp());
		
		record.setDateTimeInitiated(new DateTime(form.dteDate().getValue(), form.timTime().getValue()));
		record.setComment(form.txtComments().getValue());
				
		return record;
	}
	protected WaterlowAssessmentVo populateDataFromScreen(WaterlowAssessmentVo value)
	{
		WaterlowAssessmentVo record = super.populateDataFromScreen(value);

		//we keep the original HCP
		//if(form.getLocalContext().getHcp() != null)
			//record.setHcpInitiated(form.getLocalContext().getHcp());
		
		record.setDateTimeInitiated(new DateTime(form.dteDate().getValue(), form.timTime().getValue()));
		record.setComment(form.txtComments().getValue());
		
		return record;
	}
	protected void populateScreenFromData(WaterlowAssessmentVo value)
	{
		super.populateScreenFromData(value);
		
		if(value != null)
			form.txtComments().setValue(value.getComment());
		else
			form.txtComments().setValue(null);
	}
	
	private int getAssessmentScore()
	{
		int nScore = 0;

		RiskAssessment risk = null;
		RiskDescription descr = null;

		int partScore;
		for (int i = 0; i < form.grdAssessment().getRows().size(); i++)
		{
			GenForm.grdAssessmentRow row = form.grdAssessment().getRows().get(i);

			risk = null;
			partScore = 0;
			
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdAssessmentRow child = row.getRows().get(j);
				
				for(int k = 0; k < form.getGlobalContext().Nursing.getWaterlowAssessments().size(); k++)
				{
					risk = form.getGlobalContext().Nursing.getWaterlowAssessments().get(k);
					
					for(int m = 0; m < risk.getRiskFactors().size(); m++)
					{
						descr = risk.getRiskFactors().get(m);
						
						if(child.getValue().toString().equals(descr.getId()) && child.getSelect() == true)
						{
							partScore += Integer.valueOf(descr.getScore()).intValue();
						}
					}
				}
			}
			
			nScore += partScore;
		}
		
		return nScore;
	}
	
	private boolean isAnswerMandatory(String name)
	{
		RiskAssessmentCollection risks = form.getGlobalContext().Nursing.getWaterlowAssessments();
		
		if(risks == null)
		{
			return false;
		}
		
		for(int i = 0; i < risks.size(); i++)
		{
			RiskAssessment risk = risks.get(i);
			
			if(risk.getName().equalsIgnoreCase(name))
				return risk.getMandatoryAnswer().booleanValue();
		}
		
		return false; 
	}
}
