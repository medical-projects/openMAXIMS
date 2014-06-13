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
// This code was generated by John MacEnri using IMS Development Environment (version 1.23 build 50318.1600)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.formreports;

import ims.admin.forms.formreports.GenForm.grdAvailableReportsRow;
import ims.admin.forms.formreports.GenForm.grdReportListRow;
import ims.admin.vo.AppFormVo;
import ims.admin.vo.AppFormVoCollection;
import ims.admin.vo.FormReportVo;
import ims.admin.vo.FormReportVoCollection;
import ims.admin.vo.ReportSeedVo;
import ims.admin.vo.ReportVo;
import ims.admin.vo.ReportVoCollection;
import ims.admin.vo.ReportsCategoryLiteVo;
import ims.admin.vo.ReportsCategoryLiteVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.IReportSeed;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;


public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//form.getLocalContext().setRepColl(domain.listReports());
		form.qmbFormName().setFocus();
	}


	private void populateReports(ReportVoCollection repColl) 
	{
		for (int i = 0; i < repColl.size(); i++)
		{
			ReportVo rep = repColl.get(i);
			GenForm.grdReportListRow row = form.grdReportList().getRows().newRow();
			row.setReportName(rep.getReportName());
			//row.setRepAssign(false);
			row.setValue(rep);
		}
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.qmbFormName().getValue() == null)
		{
			engine.showMessage("Please select a form first !");
			return;
		}
		else
		{
			/*
			Integer formId = form.qmbFormName().getValue().getID_AppForm();
			//WDEV-2475 
			if(!(form.qmbFormName().getValue() != null && 
					form.qmbFormName().getValue().getID_AppFormIsNotNull() &&
						getValidReps(formId) != null &&  
							getValidReps(formId).size() > 0))
			{
				engine.showMessage("I can't assign any report to this form !");
				return;
			}
			*/
			
			form.setMode(FormMode.EDIT);
		}
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Integer formId = form.qmbFormName().getValue().getID_AppForm();
		FormReportVoCollection formRepColl = new FormReportVoCollection();
		ReportVoCollection repColl = new ReportVoCollection();
		
		int numRows = form.grdReportList().getRows().size();
		for (int i = 0; i < numRows; i++)
		{
			GenForm.grdReportListRow row = form.grdReportList().getRows().get(i);
			FormReportVo formRepVo = new FormReportVo();
			ReportVo rep = row.getValue();
			formRepVo.setReport(rep);		
			formRepColl.add(formRepVo);
			repColl.add(rep);
		}
		try 
		{
			form.getLocalContext().setAssignedReportsCollection(repColl);
			domain.saveAssignedReports(formId,formRepColl);
		}
		catch (ForeignKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		
		form.setMode(FormMode.VIEW);
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//clearReportSelection(form.qmbFormName().getValue().getID_AppForm());
		populateReportsGridAssignment(form.getLocalContext().getAssignedReportsCollection());
		form.setMode(FormMode.VIEW);
	}

	private ReportVoCollection getValidReps(Integer formId) 
	{	
		ReportVoCollection coll = new ReportVoCollection();
		ReportVoCollection fullColl = form.getLocalContext().getRepColl();
		
		if(fullColl != null)
		{
			for (int i = 0; i < fullColl.size(); i++)
			{
				ReportVo repVo = fullColl.get(i);
				IReportSeed[] iSeeds = getIseeds(repVo);
				
				if (engine.canFormProvideData(getFormNameFromId(formId.intValue()), iSeeds))
				{
					coll.add(repVo);
				}
			}
		}
		
		return coll;
	}
	
	public ims.framework.FormName getFormNameFromId(int id)
	{
    	class FormName extends ims.framework.FormName
		{
			private static final long	serialVersionUID	= 1L;

			FormName(int id)
			{
    			super(id);
    		}
    	}
    	return new FormName(id);
    }

	private IReportSeed[] getIseeds(ReportVo repVo) 
    {
		ReportSeedVo voReportSeed = new ReportSeedVo();
		return voReportSeed.getIseeds(domain.getReportSeeds(repVo));
	}

	private void populateReportsGridAssignment(ReportVoCollection coll)
	{
		form.grdReportList().getRows().clear();
		
		for (int i = 0; i < coll.size(); i++)
		{
			ReportVo rep = coll.get(i);
			GenForm.grdReportListRow row = form.grdReportList().getRows().newRow();
			
			row.setReportName(rep.getReportName());
			row.setValue(rep);
		}
	}



	/*
	private void clearReportSelection(Integer formId) 
	{
		form.grdReportList().getRows().clear();
		ReportVoCollection validReps = getValidReps(formId);
		populateReports(validReps);
		
		int numRows = form.grdReportList().getRows().size();
		for (int i = 0; i < numRows; i++)
		{
			GenForm.grdReportListRow row = form.grdReportList().getRows().get(i);
			//row.setRepAssign(false);
		}
	}
	*/
	
	//WDEV-2254 
	protected void onFormModeChanged()
	{
	}



	@Override
	protected void onBtnAssignAllClick() throws PresentationLogicException
	{
		for(int i = 0; i < form.grdAvailableReports().getRows().size(); i++)
		{
			ReportVo value = form.grdAvailableReports().getRows().get(i).getValue();
			
			if(!hasValue(value))
			{
				grdReportListRow row = form.grdReportList().getRows().newRow();
				
				row.setReportName(value.getReportName());
				row.setValue(value);
			}
		}
	}


	@Override
	protected void onBtnAssignClick() throws PresentationLogicException
	{
		ReportVo value = form.grdAvailableReports().getValue();
		
		if(value == null)
		{
			engine.showMessage("Please select a report to assign !");
			return;
		}

		if(!hasValue(value))
		{
			grdReportListRow row = form.grdReportList().getRows().newRow();
			
			row.setReportName(value.getReportName());
			row.setValue(value);
		}
		else
		{
			engine.showMessage("The selected report is already assigned to '" + form.qmbFormName().getEditedText() + "' form !");
			return;
			
		}
	}


	private boolean hasValue(ReportVo value)
	{
		if(value == null)
			return false;
		
		for(int i = 0; i < form.grdReportList().getRows().size(); i++)
		{
			if(value.equals(form.grdReportList().getRows().get(i).getValue()))
			{
				return true;
			}
		}
		
		return false;
	}


	@Override
	protected void onBtnUnAssignAllClick() throws PresentationLogicException
	{
		form.grdReportList().getRows().clear();
	}


	@Override
	protected void onBtnUnassignClick() throws PresentationLogicException
	{
		ReportVo value = form.grdReportList().getValue();
		
		if(value == null)
		{
			engine.showMessage("Please select a report to unassign !");
			return;
		}

		form.grdReportList().getRows().remove(form.grdReportList().getSelectedRowIndex());
	}


	@Override
	protected void onQmbCategoryTextSubmited(String value) throws PresentationLogicException
	{
		String cat = value;
		
		form.qmbCategory().clear();
		
		if(cat.length() > 48)
			cat = cat.substring(0, 48);

		if(!cat.startsWith("%"))
			cat = "%" + cat;
		if(!cat.endsWith("%"))
			cat = cat + "%";
		
		ReportsCategoryLiteVoCollection coll = domain.searchCategoryByName(cat);
		
		if(coll != null && coll.size() > 0)
		{
			for(ReportsCategoryLiteVo item : coll)
			{
				form.qmbCategory().newRow(item, item.getName());
			}
			
			if(coll.size() == 1)
				form.qmbCategory().setValue(coll.get(0));
			else
				form.qmbCategory().showOpened();
		}
	}


	@Override
	protected void onQmbFormNameTextSubmited(String value) throws PresentationLogicException
	{
		AppFormVoCollection coll = domain.listFormsByName(value);
		form.qmbFormName().clear();
		form.grdReportList().getRows().clear();
		
		for (int i = 0; coll != null && i < coll.size(); i++)
		{
			AppFormVo vo = coll.get(i);

			if(vo.isAlias() == false)
				form.qmbFormName().newRow(vo, vo.getName());
			else
			{
				form.qmbFormName().newRow(vo, vo.getName() + " (" + vo.getAliasName() + ")");
			}
		}

		if(coll.size() == 1)
		{
			form.qmbFormName().setValue(coll.get(0));
			onQmbFormNameValueChanged();
		}
		else
			form.qmbFormName().showOpened();
	}


	@Override
	protected void onQmbFormNameValueChanged() throws PresentationLogicException
	{
		if(form.qmbFormName().getValue() != null)				//wdev-10881
		{
			Integer formId = form.qmbFormName().getValue().getID_AppForm();
	
			ReportVoCollection coll = domain.listAssignedReports(formId);
			form.getLocalContext().setAssignedReportsCollection(coll);
			populateReportsGridAssignment(coll);
			
			form.txtReport().setValue(null);
			form.txtTemplate().setValue(null);
			form.qmbCategory().clear();
			form.grdAvailableReports().getRows().clear();
		}
	}


	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		form.txtReport().setValue(null);
		form.txtTemplate().setValue(null);
		form.qmbCategory().setValue(null);
		form.qmbCategory().clear();
		
		form.grdAvailableReports().getRows().clear();
	}


	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		searchReport();
	}

	private void searchReport()
	{
		form.grdAvailableReports().getRows().clear();

		String reportName = form.txtReport().getValue();
		String templateName = form.txtTemplate().getValue();
		ReportsCategoryLiteVo cat = form.qmbCategory().getValue();
		
		if (reportName == null || reportName.length() == 0)
		{
			reportName = "%";
		}
		else
		{
			if(!reportName.startsWith("%"))
				reportName = "%" + reportName;
			if(!reportName.endsWith("%"))
				reportName = reportName + "%";
		}

		if (templateName == null || templateName.length() == 0)
		{
			templateName = "%";
		}
		else
		{
			if(!templateName.startsWith("%"))
				templateName = "%" + templateName;
			if(!templateName.endsWith("%"))
				templateName = templateName + "%";
		}

		ReportVoCollection reportColl = domain.searchReports(reportName, templateName, cat);

		ReportVoCollection fullColl = form.getLocalContext().getRepColl();
		if(fullColl == null)
			fullColl = new ReportVoCollection();
		else
			fullColl.clear();
		
		FormName formNameFromId = getFormNameFromId(form.qmbFormName().getValue().getID_AppForm().intValue());
		
		for(ReportVo repVo : reportColl)
		{
			IReportSeed[] iSeeds = getIseeds(repVo);
			
			if (engine.canFormProvideData(formNameFromId, iSeeds))
			{
				grdAvailableReportsRow row = form.grdAvailableReports().getRows().newRow();
				
				row.setColReport(repVo.getReportName());
				row.setValue(repVo);
			}
			
		}
		
		form.getLocalContext().setRepColl(fullColl);
		
		if(reportColl == null || reportColl.size() == 0 || form.grdAvailableReports().getRows().size() == 0)
		{
			engine.showMessage("No results matching your search criteria were found !");
			return;
		}
		
	}	
}
