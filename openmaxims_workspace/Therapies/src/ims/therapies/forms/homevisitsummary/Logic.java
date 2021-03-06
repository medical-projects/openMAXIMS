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
// This code was generated by Peter Martin using IMS Development Environment (version 1.39 build 2173.22508)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.homevisitsummary;

import ims.core.vo.ClinicalContactShortVo;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.therapies.vo.HomeDetailsVo;
import ims.therapies.vo.HomeVisitVo;
import ims.therapies.vo.VisitSummaryVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	private void open() 
	{
		clearControls();
		populateScreen(domain.getHomeVisit(form.getGlobalContext().Therapies.getHomeVisit()));
		form.setMode(FormMode.VIEW);
		showButtonsForRecord();		
	}
	private void showButtonsForRecord()
	{
		if(isRecordCurrent())
			setButtonsForRecord();
		else
			displayButtons(false, false);
	}
	private boolean isRecordCurrent()
	{
		ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		HomeVisitVo voHomeVisit = form.getLocalContext().getHomeVisitVo();
		
		if (voHomeVisit== null){
			engine.showMessage("Active Home Visit Access record is required to use this screen. ");
			return false;
		}
		
		if((voHomeVisit.getClinicalContactIsNotNull() && voCurrentClinicalContact != null
		&& voCurrentClinicalContact.getID_ClinicalContact().equals(voHomeVisit.getClinicalContact().getID_ClinicalContact()))
		|| (voHomeVisit.getClinicalContact() == null && voCurrentClinicalContact == null))
		{
			return true;
		}
		return false;
	}
	private void setButtonsForRecord()
	{
		if(form.getLocalContext().getHomeVisitVo().getVisitSummaryIsNotNull())
			displayButtons(false, true);
		else
			displayButtons(true, false);
	}
	private void displayButtons(boolean newVisible, boolean updateVisible)
	{
		form.bNew().setVisible(newVisible);
		form.bUpdate().setVisible(updateVisible);
	}
	private void populateScreen(HomeVisitVo voHomeVisit) 
	{
		form.getLocalContext().setVisitSummaryVo(null);
		if(voHomeVisit == null) return;
		
		form.customControlAuthoring().setValue(voHomeVisit.getAuthoringInformation());
		
		if(voHomeVisit.getHouseDetailsIsNotNull() && voHomeVisit.getHouseDetails().getAddressIsNotNull())
			form.txtAddress().setValue(voHomeVisit.getHouseDetails().getAddress());
		
		VisitSummaryVo voVisitSummary = voHomeVisit.getVisitSummary();
		
		if(voVisitSummary!=null)
		{
			form.txtProblems().setValue(voVisitSummary.getProblemsIdentified());
			form.txtRecommendations().setValue(voVisitSummary.getRecommendations());
			form.txtEquipmentReqs().setValue(voVisitSummary.getEquipment());
			form.txtConclusions().setValue(voVisitSummary.getConclusions());
		}
		
		form.getLocalContext().setHomeVisitVo(voHomeVisit);
		form.getLocalContext().setVisitSummaryVo(voHomeVisit.getVisitSummary());
	}
	private void clearControls() 
	{
		form.customControlAuthoring().setValue(null);
		form.txtAddress().setValue(null);
		form.txtProblems().setValue(null);
		form.txtRecommendations().setValue(null);
		form.txtEquipmentReqs().setValue(null);
		form.txtConclusions().setValue(null);
	}
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		HomeVisitVo voHomeVisitVo = form.getLocalContext().getHomeVisitVo();
		if (voHomeVisitVo == null)
			voHomeVisitVo = new HomeVisitVo();
		
		voHomeVisitVo = populateDataFromScreen(voHomeVisitVo);
		
		if(voHomeVisitVo==null)
			return;
		
		String[] messages = voHomeVisitVo.validate();
		if (messages != null)
		{
			engine.showErrors("Validation Errors", messages);
			return;
		}
	
		//save and update local context
		try 
		{
			form.getLocalContext().setHomeVisitVo(domain.saveHomeVisitAccess(voHomeVisitVo));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A meeting with the same criteria already exists.   " + e.getMessage());
			open();
			return;
		}
		form.getGlobalContext().Therapies.setHomeVisit(form.getLocalContext().getHomeVisitVo());
		open(); 
	}
	private HomeVisitVo populateDataFromScreen(HomeVisitVo voHomeVisitVo) 
	{
		HomeDetailsVo voHomeDetails = voHomeVisitVo.getHouseDetails();
		if(voHomeDetails == null)
				voHomeDetails = new HomeDetailsVo();
			
		voHomeDetails.setAddress(form.txtAddress().getValue());
		voHomeVisitVo.setHouseDetails(voHomeDetails);
		
		VisitSummaryVo voVisitSummary = new VisitSummaryVo();
		voVisitSummary.setProblemsIdentified(form.txtProblems().getValue());
		voVisitSummary.setRecommendations(form.txtRecommendations().getValue());
		voVisitSummary.setEquipment(form.txtEquipmentReqs().getValue());
		voVisitSummary.setConclusions(form.txtConclusions().getValue());
		
		voHomeVisitVo.setVisitSummary(voVisitSummary);
		
		return voHomeVisitVo;
	}
	protected void onBUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);		
	}
	protected void onBCancelClick() throws PresentationLogicException 
	{
		open();
	}
	
}
