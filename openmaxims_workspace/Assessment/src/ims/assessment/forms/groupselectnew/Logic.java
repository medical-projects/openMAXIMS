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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2446.15058)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.forms.groupselectnew;
import ims.core.vo.AssessmentQuestionGroupVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		if(form.getGlobalContext().Core.getUserAssessmentAction() == null)
			throw new FormOpenException("The global context Core.UserAssessmentAction must be set with 'A', 'E' or 'V' !");
		
		open();
		
		if(form.getGlobalContext().Core.getUserAssessmentAction().equals("V"))
		{
			form.btnSave().setVisible(false);//	WDEV-15163
			
			enableControls(false);
		}
		if(form.getGlobalContext().Core.getUserAssessmentAction().equals("A"))
		{
			form.txtName().setFocus();
		}
	}
	private void enableControls(boolean bEnable)
	{
		form.txtDescription().setEnabled(bEnable);
		form.txtName().setEnabled(bEnable);
		form.decScore().setEnabled(bEnable);
		form.cmbStatus().setEnabled(bEnable);
		form.richTextLegend().setEnabled(bEnable);
	}
	private void open()
	{
		super.clearScreen();
		AssessmentQuestionGroupVo group = form.getGlobalContext().Core.getSelectedQuestionGroup();
	
		if(group != null)
		{
			super.populateScreenFromData(group);
		}
		else
		{
			//WDEV-1751 - when adding a new group can we default the 'status combobox' to active. 
			form.cmbStatus().setValue(ims.core.vo.lookups.PreActiveActiveInactiveStatus.ACTIVE);
		}
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}
	private boolean save()
	{
		AssessmentQuestionGroupVo group = null;//WDEV-15163
		
		if(form.getGlobalContext().Core.getSelectedQuestionGroup() != null)//WDEV-15163
		{
			group = (AssessmentQuestionGroupVo) form.getGlobalContext().Core.getSelectedQuestionGroup().clone();
		}
		
		if(group == null)
			group = super.populateDataFromScreen();
		else
			group = super.populateDataFromScreen(group);

		String[] arrErrors = group.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		form.getGlobalContext().Core.setSelectedQuestionGroup(group);
		
		return true;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
