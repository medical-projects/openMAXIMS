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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41209.1630)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.nurassessmentbladder;

import ims.coe.vo.lookups.ContinenceType;
import ims.coe.vo.lookups.ContinenceTypeCollection;
import ims.coe.vo.lookups.LookupHelper;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.BladderManagement;
import ims.nursing.vo.BladderManagementCollection;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.ContinenceVo;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.nursing.vo.lookups.BladderManagementAids;
import ims.nursing.vo.lookups.BladderManagementAidsCollection;
import ims.nursing.vo.lookups.BladderManagementMethod;
import ims.spinalinjuries.vo.NurAssessmentBladderVo;

import java.util.ArrayList;

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

		NurAssessmentBladderVo voBladder =null;
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setAssessment(assmnt);

		if (assmnt != null && assmnt.getCurrentComponent() != null)
		{		
			voBladder = (NurAssessmentBladderVo)domain.getComponent(assmnt.getCurrentComponent());
			form.getLocalContext().setAssessBladder(voBladder);
		}	

		//Aids
		GenForm.grdAidsUsedRow aRow = null;
		form.grdAidsUsed().getRows().clear();
		BladderManagementAidsCollection aColl = ims.nursing.vo.lookups.LookupHelper.getBladderManagementAids(domain.getLookupService());
		for (int i = 0; i < aColl.size(); i++)
		{
			BladderManagementAids bAid = aColl.get(i);
			aRow = form.grdAidsUsed().getRows().newRow();
			aRow.setValue(bAid);
			aRow.setColAidsUsed(bAid.getText());
		}

		//Continence
		GenForm.grdContinenceRow cRow = null;
		form.grdContinence().getRows().clear();
		ContinenceTypeCollection cColl = LookupHelper.getContinenceType(domain.getLookupService());
		for (int i = 0; i < cColl.size(); i++)
		{
			ContinenceType bCont = cColl.get(i);
			cRow = form.grdContinence().getRows().newRow();
			cRow.setValue(bCont);
			cRow.setColType(bCont.getText());
		}
		
		//Care Plans
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.SPINAL_BLADDER);
		if (tempColl != null)
		{
			form.grdCarePlan().getRows().clear();
			GenForm.grdCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.grdCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setcolCarePlans(template.getTitle());
			}
		}
		
		checkForPreviousAssessent();
		
		if(voBladder != null)
		{
			this.populateScreenFromData(voBladder);
			setRemoveMenuVisibility();			
		}
		
	}
	protected void checkForPreviousAssessent()
	{
		NurAssessmentBladderVo assessBladderVo = (NurAssessmentBladderVo) domain.getLastAssessmentComponentByCareContext(form.getGlobalContext().Core.getCurrentCareContext(),AssessmentComponentType.SPINAL_BLADDER);
	
		if (assessBladderVo == null)
		{
			this.form.chkCopy().setValue(false);
			return;
		}
		
		form.getLocalContext().setPreviousAssBladder(assessBladderVo);
		if(form.getMode().equals(FormMode.EDIT))
			form.chkCopy().setEnabled(true);
	}
	protected void onLnkInfoClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getAssessBladder() != null && form.getLocalContext().getAssessBladder().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getAssessBladder().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}				
	}
	
	protected void onChkCopyValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.getLocalContext().getPreviousAssBladderIsNotNull())
		{
			NurAssessmentBladderVo previousBladderVo = new NurAssessmentBladderVo();
			previousBladderVo = form.getLocalContext().getPreviousAssBladder();
			if(previousBladderVo != null)
			{
				previousBladderVo.setIsComplete(Boolean.FALSE);
				previousBladderVo.setCopy(Boolean.TRUE);
				
				form.chkCopy().setValue(true);
				form.chkCopy().setEnabled(false);	

				previousBladderVo.setCarePlanTemplate(null);
				this.populateScreenFromData(previousBladderVo);	
			}
			
		}
		else
		{
			form.chkCopy().setValue(false);
			return;
		}
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//Date Inserted cannot be in the future
		if(form.grdManagement().getRows().size()>0)
		{
			for(int i=0; i<form.grdManagement().getRows().size(); i++)
			{
				if(form.grdManagement().getRows().get(i).getColDateInserted()!=null)
				{
					if(form.grdManagement().getRows().get(i).getColDateInserted().isGreaterThan(new Date()))
					{
						engine.showMessage("'Date Inserted' can not be in the future.");
						return;
					}
				}
			}
		}
		//Date changed can not be earlier than the Insertion Date
		if(form.grdManagement().getRows().size()>0)
		{
			for(int z=0; z<form.grdManagement().getRows().size(); z++)
			{
				if(form.grdManagement().getRows().get(z).getColDateInserted()!=null && form.grdManagement().getRows().get(z).getColDateNextChange()!=null)
				{
					if(form.grdManagement().getRows().get(z).getColDateInserted().isGreaterThan(form.grdManagement().getRows().get(z).getColDateNextChange()))
					{
						engine.showMessage("'Date Next Change' can not be earlier than the 'Date Inserted'");
						return;
					}
				}
			}
		}
		NurAssessmentBladderVo voBladder = form.getLocalContext().getAssessBladder();
		if (voBladder == null)
			voBladder = new NurAssessmentBladderVo();
	
		voBladder = super.populateDataFromScreen(voBladder);
		
		//Continence	
		ContinenceTypeCollection cColl = new ContinenceTypeCollection();	
		GenForm.grdContinenceRow cRow = null;	
		for (int i=0; i<form.grdContinence().getRows().size(); i++)
		{
			cRow = form.grdContinence().getRows().get(i);
			if (cRow.getColSelect())
				cColl.add(cRow.getValue());
		}
		ContinenceVo voContinence = voBladder.getContinence();
		if(voContinence == null)
			voContinence = new ContinenceVo();
		
		voContinence.setProblemType(cColl);
		voContinence.setOtherProblem(form.txtOther().getValue());
		voBladder.setContinence(voContinence);	
		
		//Aids
		BladderManagementAidsCollection aColl = new BladderManagementAidsCollection();	
		GenForm.grdAidsUsedRow aRow = null;	
		for (int i=0; i<form.grdAidsUsed().getRows().size(); i++)
		{
			aRow = form.grdAidsUsed().getRows().get(i);
			if (aRow.getColSelect())
				aColl.add(aRow.getValue());
		}
		voBladder.setAidsUsed(aColl);

		BladderManagementCollection voCollBladderManagement = new BladderManagementCollection();
		BladderManagement voBladderManagement = null;
		GenForm.grdManagementRow bmRow = null;
		for(int i=0; i<form.grdManagement().getRows().size(); i++)
		{
			Boolean allValuesNull ;
			
			voBladderManagement = new BladderManagement();
			bmRow = form.grdManagement().getRows().get(i);
			if(bmRow.getColDateInserted() != null && bmRow.getColDateNextChange() != null)
			{
				if(bmRow.getColDateInserted().isGreaterThan(bmRow.getColDateNextChange()))
				{
					engine.showMessage("'Date Next Change' can not be earlier than the 'Date Inserted'");
					return;
				}
			}
			
			
		
			voBladderManagement.setDateInserted(bmRow.getColDateInserted());
						
			voBladderManagement.setDateNextChange(bmRow.getColDateNextChange());
			
			voBladderManagement.setMethod(bmRow.getColBladderManagement());
			
			voBladderManagement.setType(bmRow.getColType());
			
			voBladderManagement.setSize(bmRow.getColSize());
			
		//WDEV-4406 change
			String[] anError = voBladderManagement.validate(validateUiRules(voBladderManagement));
			if(anError != null )
			{
				
				engine.showErrors(anError);
				return;
			}
			
			voCollBladderManagement.add(voBladderManagement);

		}
		voBladder.setManagement(voCollBladderManagement);
		
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

		try
		{
			String[] messages = voBladder.validate();
			if (messages != null)
			{
				engine.showErrors("Validation Errors", messages);
				return;
			}
			AssessmentHeaderInfo newAssmnt = domain.saveComponent(form.getLocalContext().getAssessment(), voBladder);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}
		catch(StaleObjectException e) 
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
			newAssmnt.setCurrentComponent( domain.getAssessComponent(assessheaderinfoVo.getID_Assessment(),AssessmentComponentType.SPINAL_BLADDER));
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
			open();
			return;
		}
		
		// If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.grdCarePlan().getReadOnly() == false)
		{
			 CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
			 GenForm.grdCarePlanRow cpRow;
			 for (int i=0; i<form.grdCarePlan().getRows().size(); i++)
			 {
				 cpRow = form.grdCarePlan().getRows().get(i);
				 if (cpRow.getcolSelect() && !cpRow.isReadOnly())
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
	
	//WDEV-17372
	private String[] validateUiRules(BladderManagement voBladderManagement)
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (voBladderManagement.getMethod() != null && !BladderManagementMethod.INTERMITTENT_CATHETER.equals(voBladderManagement.getMethod()))
		{
			if (voBladderManagement.getDateInserted() == null)
			{
				listOfErrors.add("Date Inserted is mandatory");
			}
			
			if (voBladderManagement.getDateNextChange() == null)
			{
				listOfErrors.add("Date Next Change is mandatory");
			}
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		return result;
	}

	protected void populateScreenFromData(NurAssessmentBladderVo voBladder) 
	{
		super.populateScreenFromData(voBladder);

		//Continence
		ContinenceVo cont = voBladder.getContinence();
		if (cont != null)
		{
			ContinenceTypeCollection coll = cont.getProblemType();
			GenForm.grdContinenceRow rowCont;
			for (int j=0; j<coll.size(); j++)
			{
				ContinenceType inst = coll.get(j);
				int i=0;
				for (i=0; i<form.grdContinence().getRows().size(); i++)
				{
					rowCont = form.grdContinence().getRows().get(i);
					if (rowCont.getValue().equals(inst))
					{
						rowCont.setColSelect(true);
						break;
					}
				}
				if(i == form.grdContinence().getRows().size())
				{
					rowCont = form.grdContinence().getRows().newRow();
					rowCont.setValue(inst);
					rowCont.setColType(inst.getText());
					rowCont.setColSelect(true);
				}
			}
			form.txtOther().setValue(cont.getOtherProblem());
		}	
	
		//Aids
		BladderManagementAidsCollection bColl = voBladder.getAidsUsed();
		if (bColl != null)
		{
			GenForm.grdAidsUsedRow rowAids;
			for (int j=0; j<bColl.size(); j++)
			{
				BladderManagementAids inst = bColl.get(j);
				int i=0;
				for (i=0; i<form.grdContinence().getRows().size(); i++)
				{
					rowAids = form.grdAidsUsed().getRows().get(i);
					if (rowAids.getValue().equals(inst))
					{
						rowAids.setColSelect(true);
						break;
					}
				}
				if(i == form.grdAidsUsed().getRows().size())
				{
					rowAids = form.grdAidsUsed().getRows().newRow();
					rowAids.setValue(inst);
					rowAids.setColAidsUsed(inst.getText());
					rowAids.setColSelect(true);
				}
			}
		}	
	
		//Bladder Management
		if (voBladder.getManagement() != null)
		{
			 // Fill in the grid if there is any data
			 GenForm.grdManagementRow rowManagement;
			 form.grdManagement().getRows().clear();
			 for (int i=0; i<voBladder.getManagement().size();i++)
			 {
				BladderManagement manage = voBladder.getManagement().get(i);
				rowManagement = form.grdManagement().getRows().newRow();
				rowManagement.setValue(manage);
				rowManagement.setColBladderManagement(manage.getMethod());
				rowManagement.setColType(manage.getType());
				rowManagement.setColSize(manage.getSize());				
				rowManagement.setColDateInserted(manage.getDateInserted());
				rowManagement.setColDateNextChange(manage.getDateNextChange());
			 }
		}
		
		//Care Plans
		if (voBladder.getCarePlanTemplate() != null && voBladder.getCarePlanTemplate().size() > 0)
		{
			GenForm.grdCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = voBladder.getCarePlanTemplate(); 
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
						cpRow.setcolSelect(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
		
		
		if (voBladder.getIsComplete().booleanValue() == true)  // Complete
		{
			form.setMode(FormMode.VIEW);
			form.getContextMenus().getGenericGridAddItem().setVisible(false);
			setRemoveMenuVisibility();
		}
		form.chkCopy().setEnabled(false);	
	}

	
	private void setRemoveMenuVisibility() 
	{
		boolean bVisible = 	form.grdManagement().getSelectedRowIndex() != -1 && 
							form.getMode().equals(FormMode.EDIT);	   
		form.getContextMenus().getGenericGridRemoveItem().setVisible(bVisible);						

		
	}

	protected void onImbDeleteClick()  
	{
		removeBladderManagement();	
	}

	private void removeBladderManagement()
	{
		if (form.grdManagement().getSelectedRowIndex() >= 0)
			form.grdManagement().getRows().remove(form.grdManagement().getSelectedRowIndex());
	}

	protected void onImbNewClick() 
	{
		newBladderManagement();
	}

	private void newBladderManagement() 
	{
		GenForm.grdManagementRow row = form.grdManagement().getRows().newRow();
			row.setValue(new BladderManagement());
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdManagement()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add:
					newBladderManagement();
					break;
				case GenForm.ContextMenus.GenericGrid.Remove:
					removeBladderManagement();
					setRemoveMenuVisibility();					
					break;					
			}
		}
		
	}

	protected void onGrdManagementSelectionChanged() throws PresentationLogicException 
	{
		setRemoveMenuVisibility();		
	}

	protected void onFormModeChanged()
	{	
		boolean bVisible = form.getMode().equals(FormMode.EDIT);		
		form.getContextMenus().getGenericGridAddItem().setVisible(bVisible);		
	}

}
