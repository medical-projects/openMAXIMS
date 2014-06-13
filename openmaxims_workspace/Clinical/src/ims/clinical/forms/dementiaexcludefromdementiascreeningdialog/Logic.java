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
// This code was generated by Ancuta Ciubotaru using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.dementiaexcludefromdementiascreeningdialog;

import java.util.ArrayList;


import ims.clinical.vo.DementiaForWorklistVo;
import ims.clinical.vo.DementiaVo;
import ims.clinical.vo.DementiaWorklistStatusVo;
import ims.clinical.vo.DementiaWorklistStatusVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (args != null)
		{
			if (args.length == 1 && args[0] != null && args[0] instanceof DementiaForWorklistVo)
				form.getLocalContext().setselectedDementia(domain.getDementia((DementiaForWorklistVo) args[0]));
			
		}
		if(form.getLocalContext().getselectedDementiaIsNotNull()&& 
				form.getLocalContext().getselectedDementia().getCurrentWorklistStatusIsNotNull())
		{
			form.cmbReason().setValue(form.getLocalContext().getselectedDementia().getCurrentWorklistStatus().getReasonForExclusion());
		}
		updateControlState();
	}
	
	private void updateControlState() {
		// TODO Auto-generated method stub
		form.btnSave().setEnabled(form.cmbReason().getValue()!=null);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{		
		if(save())
			engine.close(DialogResult.OK);
	}
	private DementiaVo populateDataFromScreen(DementiaVo dementiaVo)
	{
		dementiaVo.setIsExcludedFromWorklist(Boolean.TRUE);
		
		DementiaWorklistStatusVo currentWorkListStatus = new DementiaWorklistStatusVo();		
		currentWorkListStatus.setStatus(ims.core.vo.lookups.DementiaWorklistStatus.EXCLUDED);
		currentWorkListStatus.setReasonForExclusion(form.cmbReason().getValue());
		
		AuthoringInformationVo voAuthor = new AuthoringInformationVo();
		voAuthor.setAuthoringDateTime(new DateTime());
		if (domain.getHcpUser() != null)
			voAuthor.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		
		currentWorkListStatus.setAuthoringInformation(voAuthor);
		
		dementiaVo.setCurrentWorklistStatus(currentWorkListStatus);
		dementiaVo.setIsExcludedFromWorklist(Boolean.TRUE);
		
		DementiaWorklistStatusVoCollection  historyWorkListStatusColl = dementiaVo.getHistoricalWorklistStatus();
		
		if(!form.getLocalContext().getselectedDementia().getHistoricalWorklistStatusIsNotNull())
		{
			historyWorkListStatusColl.add(currentWorkListStatus);
			dementiaVo.setHistoricalWorklistStatus(historyWorkListStatusColl);	
		}
		else if(!form.getLocalContext().getselectedDementia().getHistoricalWorklistStatus().contains(currentWorkListStatus))
		{
			historyWorkListStatusColl.add(currentWorkListStatus);
			dementiaVo.setHistoricalWorklistStatus(historyWorkListStatusColl);			
		}
		
		
		return dementiaVo;
	}
	
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

			if(form.getLocalContext().getselectedDementiaIsNotNull())
			{
				if (form.cmbReason().getValue()==null)
				{
					errors.add("Reason for Exclusion should not be null!");
				}
			}
			else
			{
				errors.add("Selected Dementia is null!");
			}
				
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;


	}
	private boolean save() 
	{
		// TODO Auto-generated method stub
		if(form.getLocalContext().getselectedDementiaIsNotNull() && form.cmbReason().getValue()!=null )
		{
			DementiaVo dementiaToSave = populateDataFromScreen((DementiaVo) form.getLocalContext().getselectedDementia().clone());		

			String[] errors = dementiaToSave.validate(getUIErrors());
			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			try
			{
				domain.saveDementia(dementiaToSave);
			}
			catch (Exception e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());			
				engine.close(DialogResult.CANCEL);//wdev-16364
				return false;
			}
		}
		return true;
	}

	
	protected void onCmbReasonValueChanged() throws PresentationLogicException 
	{
		updateControlState();		
	}
}
