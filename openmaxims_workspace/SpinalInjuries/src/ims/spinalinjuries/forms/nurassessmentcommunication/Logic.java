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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.22 build 41123.1700)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.nurassessmentcommunication;

import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.CommunicationProblems;
import ims.nursing.vo.CommunicationProblemsCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.nursing.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.NurAssessmentCommunicationVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	
	private void open() 
	{
		if(form.getGlobalContext().Core.getAssessmentIsReadOnly() == null || form.getGlobalContext().Core.getAssessmentIsReadOnly() == false )
			form.setMode(FormMode.EDIT);
		else
			form.setMode(FormMode.VIEW);
		form.chkCopy().setEnabled(false);
		
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setAssessment(assmnt);
	
		NurAssessmentCommunicationVo assessCommun = null;
		if (assmnt != null && assmnt.getCurrentComponent() != null)
		{
			assessCommun = (NurAssessmentCommunicationVo)domain.getComponent(assmnt.getCurrentComponent());
			form.getLocalContext().setAssessmentCommunication(assessCommun);
		}
		
		//	Communication Problems
	  	GenForm.grdCommunicationRow row = null;
	  	form.grdCommunication().getRows().clear();
		ims.nursing.vo.lookups.CommunicationProblemsCollection sColl = LookupHelper.getCommunicationProblems(domain.getLookupService());
		for (int i = 0; i < sColl.size(); i++)
		{
			ims.nursing.vo.lookups.CommunicationProblems communicationProblem  = sColl.get(i);
		  	row = form.grdCommunication().getRows().newRow();
		  	row.setColProblems(communicationProblem);
		}
	
		// Care Plans
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.SPINAL_COMMUNICATION);
		if (tempColl != null)
		{
			form.grdCarePlan().getRows().clear();
			GenForm.grdCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.grdCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setColCarePlan(template.getTitle());
			}
		}
			
		checkForPreviousAssessent();
		
		if(assessCommun != null)
			populateScreenFromData(assessCommun);

	}
	
	protected void checkForPreviousAssessent()
	{
		NurAssessmentCommunicationVo prevCommunicationVo = (NurAssessmentCommunicationVo) domain.getLastAssessmentComponentByCareContext(form.getGlobalContext().Core.getCurrentCareContext(), AssessmentComponentType.SPINAL_COMMUNICATION);
	
		if (prevCommunicationVo == null)
		{
			this.form.chkCopy().setValue(false);
			return;
		}
		
		form.getLocalContext().setPreviousAssComm(prevCommunicationVo);
		if(form.getMode().equals(FormMode.EDIT))
			form.chkCopy().setEnabled(true);
	}
	
	protected void populateScreenFromData(NurAssessmentCommunicationVo assessCommun) 
	{
		super.populateScreenFromData(assessCommun);
		
		if (assessCommun.getIsComplete().booleanValue() == true)  // Complete
		{
			form.setMode(FormMode.VIEW);	
		}
		form.chkCopy().setEnabled(false);
				
		CommunicationProblemsCollection problemsColl = assessCommun.getCommunicationProblems();
		if(problemsColl != null)
		{		
			GenForm.grdCommunicationRow rowCommunication;
   			for (int j=0; j<problemsColl.size(); j++)
		    {
				CommunicationProblems communicationProb = problemsColl.get(j);
			   	int i=0;
			   	for (i=0; i<form.grdCommunication().getRows().size(); i++)
			   	{
					rowCommunication = form.grdCommunication().getRows().get(i);
				    if (rowCommunication.getColProblems().equals(communicationProb.getProblemsWith()))
				   	{
						rowCommunication.setColSelect(communicationProb.getStatus());
						rowCommunication.setColDetails(communicationProb.getDetails());
					   	break;
				   	}
			   }
			   if(i == form.grdCommunication().getRows().size())
			   {
					rowCommunication = form.grdCommunication().getRows().newRow();
					rowCommunication.setValue(communicationProb);
					rowCommunication.setColProblems(communicationProb.getProblemsWith());
					rowCommunication.setColSelect(communicationProb.getStatus());
					rowCommunication.setColDetails(communicationProb.getDetails());
			   }
		   }
				 
		}	

		//Care Plans
		if (assessCommun.getCarePlanTemplate() != null && assessCommun.getCarePlanTemplate().size() > 0)
		{
			GenForm.grdCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = assessCommun.getCarePlanTemplate(); 
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.grdCarePlan().getRows().size(); j++)
			{
				cpRow = form.grdCarePlan().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setColSelect(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		NurAssessmentCommunicationVo voCommunication = form.getLocalContext().getAssessmentCommunication();
		if (voCommunication == null)
			voCommunication = new NurAssessmentCommunicationVo();
	
		voCommunication = super.populateDataFromScreen(voCommunication);		
		
//		Save the Preferences grid information
		CommunicationProblemsCollection collCommuncationProb = new CommunicationProblemsCollection();
		GenForm.grdCommunicationRow row = null;	
		for (int i=0; i<form.grdCommunication().getRows().size(); i++)
		{
			row = form.grdCommunication().getRows().get(i);
			CommunicationProblems communicationProb = row.getValue();
			if (communicationProb == null)
			 	communicationProb = new CommunicationProblems();
	
			communicationProb.setDetails(row.getColDetails());
			communicationProb.setProblemsWith(row.getColProblems());
			communicationProb.setStatus(row.getColSelect());						
			collCommuncationProb.add(communicationProb);
		}
		voCommunication.setCommunicationProblems(collCommuncationProb);
		
		//if AssessmentHeaderInfo id == null, check if in the meantime another user from another session has created a new assessment for selected care context
		if(form.getLocalContext().getAssessment() != null)
			if(form.getLocalContext().getAssessment().getID_Assessment() == null)
				if(form.getGlobalContext().Core.getCurrentCareContext() != null)
				{
					AssessmentHeaderInfo tempvo = domain.getAssessmentHeaderInfoByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					if(tempvo != null)
					{
						form.getLocalContext().setAssessment(tempvo);
						form.getGlobalContext().Nursing.setAssessmentHeaderInfo(form.getLocalContext().getAssessment());
					}
				}
		
		String[] arrErrors = voCommunication.validate();
	
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		try
		{
			AssessmentHeaderInfo newAssmnt = domain.saveComponent(form.getLocalContext().getAssessment(), voCommunication);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// We may need to reset the current component value in GC for onFormOpen - if there was none previously
			if (e.getStaleObject() != null)
			{
				 AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
				 if (assmnt != null && assmnt.getCurrentComponent() == null)
				 {
					 ims.nursing.vo.AssessmentComponent comp = new ims.nursing.vo.AssessmentComponent();
					 comp.setID_AssessmentComponent(e.getStaleObject().getId());
					 assmnt.setCurrentComponent(comp);
					 form.getGlobalContext().Nursing.setAssessmentHeaderInfo(assmnt);
				 }
			}
			open();
			return;								
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			AssessmentHeaderInfo newAssmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
			AssessmentHeaderInfo assessheaderinfoVo = form.getLocalContext().getAssessment();	
			newAssmnt.setCurrentComponent( domain.getAssessComponent(assessheaderinfoVo.getID_Assessment(),AssessmentComponentType.SPINAL_COMMUNICATION));
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
			open();
			return;
		}

//		If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.grdCarePlan().getReadOnly() == false)
		{
			  CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
			  GenForm.grdCarePlanRow cpRow;
			  for (int i=0; i<form.grdCarePlan().getRows().size(); i++)
			  {
				  cpRow = form.grdCarePlan().getRows().get(i);
				  if (cpRow.getColSelect() && !cpRow.isReadOnly())
					 templList.add(cpRow.getValue());
			  }
			  if (templList.size() > 0)
			  {
				  form.getGlobalContext().COE.CarePlan.setTemplateList(templList);
				  engine.open(form.getForms().Nursing.CarePlanStep2);
			  }
			  else
				  engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		 }
		 else
			  engine.open(form.getForms().Nursing.AdmissionAssessOverview);	
	}

	protected void onChkCopyValueChanged() throws PresentationLogicException 
	{
		if(form.getLocalContext().getPreviousAssCommIsNotNull())
		{
			NurAssessmentCommunicationVo previousAssCommVo = new NurAssessmentCommunicationVo();
			previousAssCommVo = form.getLocalContext().getPreviousAssComm();
			form.chkCopy().setValue(true);
			form.chkCopy().setEnabled(false);
			previousAssCommVo.setIsComplete(Boolean.FALSE);
			previousAssCommVo.setCopy(Boolean.TRUE);
			previousAssCommVo.setCarePlanTemplate(null);	
			populateScreenFromData(previousAssCommVo);
		}
		else
		{
			form.chkCopy().setValue(false);
			return;
		}	
		
	}

	protected void onLnkInfoClick() throws PresentationLogicException 
	{
		if (form.getLocalContext().getAssessmentCommunication() != null && form.getLocalContext().getAssessmentCommunication().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getAssessmentCommunication().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}				
	}
}
