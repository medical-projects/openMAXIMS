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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.hcpswithrecordsforprocedure;


import ims.clinical.forms.hcpswithrecordsforprocedure.GenForm.grdHCPRow;
import ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo;
import ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.btnCopy().setEnabled(false);
		SurgicalOperationDetailsConfigVoCollection tempCol = null;
		if(form.getGlobalContext().ClinicalAdmin.getSurgicalOpDetailsConfig() != null && form.getGlobalContext().ClinicalAdmin.getSurgicalOpDetailsConfig().getProcedureReference() != null)
			tempCol = domain.getSurgicalOpDetailsConfig(form.getGlobalContext().ClinicalAdmin.getSurgicalOpDetailsConfig().getProcedureReference());
		if(tempCol != null && tempCol.size() > 0)
		{
			populateGridHcp(tempCol);
		}
		else
		{
			engine.showMessage("No records found !!!");
		}
	}
	
	protected void onBtnCopyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdHCP().getValue() != null)
		{
			form.getGlobalContext().ClinicalAdmin.setSurgicalOpDetailsConfig(form.grdHCP().getValue());
			engine.close(DialogResult.OK);
		}
		else
			engine.showMessage("Select a HCP !!!");
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	private void populateGridHcp(SurgicalOperationDetailsConfigVoCollection tempCol)
	{
		form.grdHCP().getRows().clear();
		if (tempCol != null)
			for (SurgicalOperationDetailsConfigVo item : tempCol)
			{
				grdHCPRow row = form.grdHCP().getRows().newRow();
				UpdateRow(item,row);
				
			}
		
	}
	private void UpdateRow(SurgicalOperationDetailsConfigVo voSHCp, grdHCPRow gridrow)
	{
		
		if(voSHCp == null)
			return;
		gridrow.setHCP(voSHCp.getSurgeonIsNotNull()? voSHCp.getSurgeon().getIHcpName():null);
		gridrow.setProcedure(voSHCp.getProcedureReferenceIsNotNull()? voSHCp.getProcedureReference().getProcedureName():null);
		
		gridrow.setValue(voSHCp);
		
	}

	
	protected void onGrdHCPSelectionChanged() throws PresentationLogicException 
	{
		
		form.btnCopy().setEnabled(true);
	}
}
