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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.42 build 2218.20551)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.needsassessmentcomponentedit;

import ims.assessment.vo.PatientAssessmentDataVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.core.vo.NeedsAssessmentComponentEditVo;
import ims.core.vo.NeedsAssessmentComponentScoreVo;
import ims.core.vo.NeedsAssessmentComponentScoreVoCollection;
import ims.core.vo.PatientAssessmentInfoVo;
import ims.core.vo.lookups.PatientAssessmentStatusReason;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.exceptions.StaleObjectException;
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
	protected void onFormModeChanged()
	{
		updateControlsState();		
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
		{
			form.getGlobalContext().SpinalInjuries.NeedsAssessment.setEditedComponentIsNew(Boolean.FALSE);
			form.setMode(FormMode.VIEW);
			open();
		}
	}
	public void initialize()
	{
		if(form.getGlobalContext().SpinalInjuries.NeedsAssessment.getEditComponentIsNotNull() && form.getGlobalContext().SpinalInjuries.NeedsAssessment.getEditComponent().booleanValue())
		{
			form.setMode(FormMode.EDIT);
		}
	}
	public void open()
	{		
		form.getLocalContext().setCurrentAssessment(domain.get(form.getGlobalContext().SpinalInjuries.NeedsAssessment.getSelectedAssessment())); 
		PatientAssessmentVo editedAssessment = domain.getPatientAssessment(form.getGlobalContext().SpinalInjuries.NeedsAssessment.getEditedAssessment());
		
		if(editedAssessment.getStatus() != null && editedAssessment.getStatus().equals(PatientAssessmentStatusReason.COMPLETED))
		{
			form.chkCompleted().setValue(true);			
		}
		
		//WDEV-11366
		form.componentEdit().setPatientAssessment(editedAssessment,false,PatientAssessmentInfoVo.getInstance(form.getGlobalContext().Core.getPatientShort()));
		updateControlsState();
	}	

	private void returnToParent()
	{
		engine.open(form.getForms().SpinalInjuries.NeedsAssessment);		
	}
	private boolean save() 
	{	
		if(form.chkCompleted().getValue())
		{
			String[] herrors = form.componentEdit().validateData();
			if(herrors != null && herrors.length > 0)
			{
				engine.showErrors("Validation error(s)", herrors);
				return false;
			}
		}
		
		PatientAssessmentVo assessment =  form.componentEdit().getPatientAssessment();
		if(form.chkCompleted().getValue())
			assessment.setStatus(PatientAssessmentStatusReason.COMPLETED);
		else
			assessment.setStatus(PatientAssessmentStatusReason.INPROGRESS);
		
		NeedsAssessmentComponentEditVo currentAssessment = form.getLocalContext().getCurrentAssessment();

		
		//calculate score for current assessment
		NeedsAssessmentComponentScoreVoCollection scores = currentAssessment.getComponentScore();
		if(scores == null)
			scores = new NeedsAssessmentComponentScoreVoCollection();	
		PatientAssessmentDataVo assessmentData = assessment.getAssessmentData();
		if (assessment.getAssessmentDataIsNotNull() && assessmentData.getUserAssessmentIsNotNull()
				&& assessmentData.getUserAssessment().getAssessmentTypeIsNotNull())
		{
			NeedsAssessmentComponentScoreVo component = getComponentScoreByType(scores, assessmentData.getUserAssessment().getAssessmentType());
			if (component == null)
				component = new NeedsAssessmentComponentScoreVo();
			component.setComponentType(assessmentData.getUserAssessment().getAssessmentType());
			component.setScore(calculateScore(assessmentData));
			scores.add(component); //WDEV-15537
			
		}
		currentAssessment.setComponentScore(scores);

		
		String[] errors = currentAssessment.validate(assessment.validate());
		if(errors != null && errors.length > 0)
		{
			engine.showErrors("Validation error(s)", errors);
			return false;
		}
		
		try
		{
			currentAssessment = domain.save(currentAssessment,assessment);
			form.getLocalContext().setCurrentAssessment(currentAssessment);
			
			form.getGlobalContext().SpinalInjuries.NeedsAssessment.setSelectedAssessment(currentAssessment);
			
			form.getGlobalContext().SpinalInjuries.NeedsAssessment.setEditedAssessment(assessment);
			
		}
		catch (StaleObjectException e) 
		{			
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.setMode(FormMode.VIEW);
			open();
			return false;
		}		
		
		return true;
	}
	private int calculateScore(PatientAssessmentDataVo assessmentData)
	{
		int score = 0;
		if(assessmentData.getAnswerGroupsIsNotNull())
		{
			for(int j = 0; j < assessmentData.getAnswerGroups().size(); j++)
			{
				if(assessmentData.getAnswerGroups().get(j) != null && assessmentData.getAnswerGroups().get(j).getCurrentScore() != null)
				{
					score += assessmentData.getAnswerGroups().get(j).getCurrentScore().intValue();
				}
			}
		}
		return score;
	}
	private NeedsAssessmentComponentScoreVo getComponentScoreByType(NeedsAssessmentComponentScoreVoCollection scores, UserDefinedAssessmentType assessmentType)
	{
		if(scores == null || assessmentType == null)
			return null;
		
		for (int i = 0; i < scores.size(); i++)
		{
			if(assessmentType.equals(scores.get(i).getComponentType()))
				return scores.get(i);
		}
		
		return null;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isNewComponent())
			returnToParent();
		else
		{
			form.setMode(FormMode.VIEW);
			open();
		}
	}
	protected void onLnkReturnClick() throws PresentationLogicException
	{
		returnToParent();		
	}
	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	private boolean isNewComponent()
	{
		if(form.getGlobalContext().SpinalInjuries.NeedsAssessment.getEditedComponentIsNew() == null)
			return true;
		return form.getGlobalContext().SpinalInjuries.NeedsAssessment.getEditedComponentIsNew().booleanValue();
	}
	private void updateControlsState()
	{
		if(form.getMode() == FormMode.VIEW)
		{
			form.btnUpdate().setVisible(!form.chkCompleted().getValue());
			form.componentEdit().setEnabled(Boolean.TRUE);
			form.componentEdit().setReadOnly(Boolean.TRUE);
		}
		else
		{
			form.componentEdit().setReadOnly(Boolean.FALSE);
		}
	}
}
