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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.specimenconfiguration;

import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.forms.specimenconfiguration.GenForm.grdAdultSpecContRow;
import ims.ocrr.forms.specimenconfiguration.GenForm.grdAltPaedContRow;
import ims.ocrr.forms.specimenconfiguration.GenForm.grdPaedContRow;
import ims.ocrr.vo.SpecimenContainerVo;
import ims.ocrr.vo.SpecimenContainerVoCollection;
import ims.ocrr.vo.SpecimenVo;
import ims.ocrr.vo.lookups.LookupHelper;
import ims.ocrr.vo.lookups.SpecimenContainerType;
import ims.ocrr.vo.lookups.SpecimenTypeCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	public void initialise()
	{
		populateSpecimenCombo();
		form.getLocalContext().setdisableSpecimenType(Boolean.FALSE);
	}

	private void populateSpecimenCombo()
	{
		SpecimenTypeCollection specimenTypes = LookupHelper.getSpecimenType(domain.getLookupService());

		for (int i = 0; specimenTypes != null && i < specimenTypes.size(); i++)
		{
			form.cmbSpecimenType().newRow(specimenTypes.get(i), specimenTypes.get(i).getText());
		}
	}

	@Override
	protected void onGrdAltPaedContSelectionChanged()
	{
		form.getGlobalContext().OCRR.setAlternativePaediatricsContainer(form.grdAltPaedCont().getValue());
		updateControlsState();
	}

	@Override
	protected void onGrdPaedContSelectionChanged()
	{
		form.getGlobalContext().OCRR.setPaediatricsContainer(form.grdPaedCont().getValue());
		updateControlsState();
	}

	@Override
	protected void onGrdAdultSpecContSelectionChanged()
	{
		form.getGlobalContext().OCRR.setAdultSpecimenContainer(form.grdAdultSpecCont().getValue());
		updateControlsState();
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.OCRRNamespace.AdultSpecimenContainer.ADD:
				setAdultSpecimenContainer();
				updateControlsState();
				break;
			case GenForm.ContextMenus.OCRRNamespace.AdultSpecimenContainer.EDIT:
				clearForAdultSpecimenContainer();
				engine.open(form.getForms().OCRR.AlternativeContainerDialog);
				break;
			case GenForm.ContextMenus.OCRRNamespace.AdultSpecimenContainer.REMOVE:
				clearForAdultSpecimenContainer();
				form.grdAdultSpecCont().removeSelectedRow();
				updateControlsState();
				break;
			case GenForm.ContextMenus.OCRRNamespace.PaediatricContainer.ADD:
				setPaediatricContainer();
				updateControlsState();
				break;
			case GenForm.ContextMenus.OCRRNamespace.PaediatricContainer.EDIT:
				clearForPaediatricContainer();
				engine.open(form.getForms().OCRR.AlternativeContainerDialog);
				break;
			case GenForm.ContextMenus.OCRRNamespace.PaediatricContainer.REMOVE:
				clearForPaediatricContainer();
				checkRowCanBeRemoved(); //WDEV-16469
				updateControlsState();
				break;
			case GenForm.ContextMenus.OCRRNamespace.AlternatePaediatricContainer.ADD:
				setAlternatePaediatricContainer();
				updateControlsState();
				break;
			case GenForm.ContextMenus.OCRRNamespace.AlternatePaediatricContainer.EDIT:
				clearForAlternatePaedContainer();
				engine.open(form.getForms().OCRR.AlternativeContainerDialog);
				break;
			case GenForm.ContextMenus.OCRRNamespace.AlternatePaediatricContainer.REMOVE:
				clearForAlternatePaedContainer();
				form.grdAltPaedCont().removeSelectedRow();
				updateControlsState();
				break;
		}
	}

	private void checkRowCanBeRemoved()
	{
		if (form.grdAltPaedCont().getRows().size() > 0 && form.grdPaedCont().getRows().size() == 1 )
		{
			engine.showMessage("Please remove the Alternative Paediatric Containers before removing the Paediatric Container.");
			return;
		}
		
		form.grdPaedCont().removeSelectedRow();
	}

	private void clearForAlternatePaedContainer()
	{
		form.grdAdultSpecCont().setValue(null);
		form.getGlobalContext().OCRR.setAdultSpecimenContainer(null);
		form.grdPaedCont().setValue(null);
		form.getGlobalContext().OCRR.setPaediatricsContainer(null);
	}

	private void clearForAdultSpecimenContainer()
	{
		form.getGlobalContext().OCRR.setPaediatricsContainer(null);
		form.grdPaedCont().setValue(null);
		form.getGlobalContext().OCRR.setAlternativePaediatricsContainer(null);
		form.grdAltPaedCont().setValue(null);
	}

	private void clearForPaediatricContainer()
	{
		form.getGlobalContext().OCRR.setAdultSpecimenContainer(null);
		form.grdAdultSpecCont().setValue(null);
		form.getGlobalContext().OCRR.setAlternativePaediatricsContainer(null);
		form.grdAltPaedCont().setValue(null);
	}

	private void setAlternatePaediatricContainer()
	{
		form.grdAltPaedCont().setValue(null);
		clearForAlternatePaedContainer();

		SpecimenContainerVo alternatePaediatricContainer = new SpecimenContainerVo();

		alternatePaediatricContainer.setType(SpecimenContainerType.ALTERNATE_PAEDIATRIC);
		// adultSpecimenContainer.setVolumeUnits(PathVolumeUnits.MLS);

		form.getGlobalContext().OCRR.setAlternativePaediatricsContainer(alternatePaediatricContainer);
		engine.open(form.getForms().OCRR.AlternativeContainerDialog);
	}

	private void setPaediatricContainer()
	{
		if (form.grdPaedCont().getRows().size() == 1 && form.grdAltPaedCont().getRows().size() > 0)
		{
			engine.showMessage("Please remove the Alternative Paediatric Containers before adding a new Paediatric Container.");
			return;
		}
		
		form.grdPaedCont().setValue(null);
		clearForPaediatricContainer();

		SpecimenContainerVo paediatricContainer = new SpecimenContainerVo();

		paediatricContainer.setType(SpecimenContainerType.PAEDIATRIC);
		// adultSpecimenContainer.setVolumeUnits(PathVolumeUnits.MLS);

		form.getGlobalContext().OCRR.setPaediatricsContainer(paediatricContainer);
		engine.open(form.getForms().OCRR.AlternativeContainerDialog);
	}

	private void setAdultSpecimenContainer()
	{
		form.grdAdultSpecCont().setValue(null);
		clearForAdultSpecimenContainer();

		SpecimenContainerVo adultSpecimenContainer = new SpecimenContainerVo();

		adultSpecimenContainer.setType(SpecimenContainerType.ADULT);
		// adultSpecimenContainer.setVolumeUnits(PathVolumeUnits.MLS);

		form.getGlobalContext().OCRR.setAdultSpecimenContainer(adultSpecimenContainer);
		engine.open(form.getForms().OCRR.AlternativeContainerDialog);
	}

	private void populateScreenFromData(SpecimenVo specimen)
	{

		if (specimen == null)
			return;

		clearScreen();
		
		//WDEV-16831
		if (Boolean.FALSE.equals(specimen.getType().isActive()))
		{
			form.cmbSpecimenType().newRow(specimen.getType(), specimen.getType().getText());
		}
		
		form.cmbSpecimenType().setValue(specimen.getType());

		populateAdultSpecimenContainerGrid(specimen);
		populatePaediatricContainerGrid(specimen);
		populateAlternativePaediatricContainerGrid(specimen);
	}

	private void populateAlternativePaediatricContainerGrid(SpecimenVo specimen)
	{
		if (specimen.getAlternativePaediatricContainers() == null)
			return;

		for (int i = 0; i < specimen.getAlternativePaediatricContainers().size(); i++)
		{
			addEditAlternatePaediatricContainer(specimen.getAlternativePaediatricContainers().get(i));
		}
	}

	private void populatePaediatricContainerGrid(SpecimenVo specimen)
	{
		if (specimen.getPaediatricContainers() == null)
			return;

		for (int i = 0; i < specimen.getPaediatricContainers().size(); i++)
		{
			addEditPaediatricContainer(specimen.getPaediatricContainers().get(i));
		}

	}

	private void populateAdultSpecimenContainerGrid(SpecimenVo specimen)
	{
		if (specimen.getAdultContainers() == null)
			return;

		for (int i = 0; i < specimen.getAdultContainers().size(); i++)
		{
			addEditAdultSpecimenContainer(specimen.getAdultContainers().get(i));
		}
	}

	private void clearScreen()
	{
		//WDEV-16831
		if (form.cmbSpecimenType().getValue() != null && form.getLocalContext().getSpecimen() != null && (! form.cmbSpecimenType().getValue().isActive()) && form.cmbSpecimenType().getValue().equals(form.getLocalContext().getSpecimen().getType()))
		{
			form.cmbSpecimenType().removeRow(form.getLocalContext().getSpecimen().getType());
		}
		
		form.cmbSpecimenType().setValue(null);
		form.grdAdultSpecCont().getRows().clear();
		form.grdAltPaedCont().getRows().clear();
		form.grdPaedCont().getRows().clear();
	}

	private void updateControlsState()
	{
		form.getContextMenus().OCRR.getAdultSpecimenContainerADDItem().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.getContextMenus().OCRR.getAdultSpecimenContainerEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAdultSpecCont().getValue() != null);
		form.getContextMenus().OCRR.getAdultSpecimenContainerREMOVEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAdultSpecCont().getValue() != null);

		form.getContextMenus().OCRR.getPaediatricContainerADDItem().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.getContextMenus().OCRR.getPaediatricContainerEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdPaedCont().getValue() != null);
		form.getContextMenus().OCRR.getPaediatricContainerREMOVEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdPaedCont().getValue() != null);

		form.getContextMenus().OCRR.getAlternatePaediatricContainerADDItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdPaedCont().getRows().size() == 1);
		form.getContextMenus().OCRR.getAlternatePaediatricContainerEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAltPaedCont().getValue() != null);
		form.getContextMenus().OCRR.getAlternatePaediatricContainerREMOVEItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdAltPaedCont().getValue() != null);
		
		form.grdAltPaedCont().setEnabled(FormMode.EDIT.equals(form.getMode()) && Boolean.FALSE.equals(form.getLocalContext().getisDftInvestigation()));
		form.cmbSpecimenType().setEnabled(FormMode.EDIT.equals(form.getMode()) && (! Boolean.TRUE.equals(form.getLocalContext().getdisableSpecimenType())) );
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().OCRR.AlternativeContainerDialog) && result.equals(DialogResult.OK))
		{
			if (form.getGlobalContext().OCRR.getAdultSpecimenContainerIsNotNull())
			{
				addEditAdultSpecimenContainer(form.getGlobalContext().OCRR.getAdultSpecimenContainer());
			}
			else if (form.getGlobalContext().OCRR.getPaediatricsContainerIsNotNull())
			{
				addEditPaediatricContainer(form.getGlobalContext().OCRR.getPaediatricsContainer());
			}
			else if (form.getGlobalContext().OCRR.getAlternativePaediatricsContainerIsNotNull())
			{
				addEditAlternatePaediatricContainer(form.getGlobalContext().OCRR.getAlternativePaediatricsContainer());
			}
		}

		updateControlsState();
	}

	private void addEditAlternatePaediatricContainer(SpecimenContainerVo specimenContainerVo)
	{
		//check if container was already added
		for (int i=0; i < form.grdAltPaedCont().getRows().size(); i++)
		{
			if (form.grdAltPaedCont().getSelectedRow() != null && specimenContainerVo.equals(form.grdAltPaedCont().getSelectedRow().getValue()))
				continue;
			
			if (form.grdAltPaedCont().getRows().get(i).getValue().getSpecContainer().getID_PathSpecimenContainer().equals(specimenContainerVo.getSpecContainer().getID_PathSpecimenContainer()))
			{
				engine.showMessage("This container was already added to Alternative Paediatric Containers.");
				return;
			}
		}
		
		grdAltPaedContRow newRow;

		if (form.grdAltPaedCont().getValue() != null)
		{
			newRow = form.grdAltPaedCont().getSelectedRow();
		}
		else
			newRow = form.grdAltPaedCont().getRows().newRow();

		SpecimenContainerVo altPaedCont = specimenContainerVo;

		newRow.setColContainer(altPaedCont.getSpecContainer().getName());
		
		if (altPaedCont.getVolume() ==0)
		{
			newRow.setColVolume("N/A");
		}
		else
			newRow.setColVolume(altPaedCont.getVolume().toString());
		
		newRow.setColLblSuffix(altPaedCont.getLabelSuffix());
		newRow.setValue(altPaedCont);
	}

	private void addEditPaediatricContainer(SpecimenContainerVo specimenContainerVo)
	{
		//check if container was already added
		for (int i=0; i < form.grdPaedCont().getRows().size(); i++)
		{
			if (form.grdPaedCont().getSelectedRow() != null && specimenContainerVo.equals(form.grdPaedCont().getSelectedRow().getValue()))
				continue;
			
			if (form.grdPaedCont().getRows().get(i).getValue().getSpecContainer().getID_PathSpecimenContainer().equals(specimenContainerVo.getSpecContainer().getID_PathSpecimenContainer()))
			{
				engine.showMessage("This container was already added to Paediatric Containers.");
				return;
			}
		}
		
		grdPaedContRow newRow;

		if (form.grdPaedCont().getValue() != null)
		{
			newRow = form.grdPaedCont().getSelectedRow();
		}
		else
			newRow = form.grdPaedCont().getRows().newRow();

		SpecimenContainerVo paedCont = specimenContainerVo;

		newRow.setColContainer(paedCont.getSpecContainer().getName());
		
		if (paedCont.getVolume() ==0)
		{
			newRow.setColVolume("N/A");
		}
		else
			newRow.setColVolume(paedCont.getVolume().toString());
		
		newRow.setColLblSuffix(paedCont.getLabelSuffix());

		newRow.setValue(paedCont);
	}

	
	private void addEditAdultSpecimenContainer(SpecimenContainerVo specimenContainerVo)
	{
		
		//check if container was already added
		for (int i=0; i < form.grdAdultSpecCont().getRows().size(); i++)
		{
			if (form.grdAdultSpecCont().getSelectedRow() != null && specimenContainerVo.equals(form.grdAdultSpecCont().getSelectedRow().getValue()))
				continue;
			
			if (form.grdAdultSpecCont().getRows().get(i).getValue().getSpecContainer().getID_PathSpecimenContainer().equals(specimenContainerVo.getSpecContainer().getID_PathSpecimenContainer()))
			{
				engine.showMessage("This container was already added to Adult Specimen Containers.");
				return;
			}
		}

		grdAdultSpecContRow newRow;
		
		if (form.grdAdultSpecCont().getValue() != null)
		{
			newRow = form.grdAdultSpecCont().getSelectedRow();
		}
		else
			newRow = form.grdAdultSpecCont().getRows().newRow();

		SpecimenContainerVo adultCont = specimenContainerVo;

		newRow.setColContainer(adultCont.getSpecContainer().getName());
		
		if (adultCont.getVolume() ==0)
		{
			newRow.setColVolume("N/A");
		}
		else
			newRow.setColVolume(adultCont.getVolume().toString());
		
		newRow.setColLblSuffix(adultCont.getLabelSuffix());
		newRow.setValue(adultCont);
	}

	public SpecimenVo getValue()
	{
		return populateSpecimen(form.getLocalContext().getSpecimen());
	}

	private SpecimenVo populateSpecimen(SpecimenVo specimen)
	{
		if (specimen == null)
		{
			specimen = new SpecimenVo();
		}
		specimen.setType(form.cmbSpecimenType().getValue());
		specimen.setAdultContainers(getAdultContainers(specimen.getAdultContainers()));
		specimen.setPaediatricContainers(getPaediatricContainers(specimen.getPaediatricContainers()));
		specimen.setAlternativePaediatricContainers(getAlternativePaediatricContainers(specimen.getAlternativePaediatricContainers()));

		form.getLocalContext().setSpecimen(specimen);

		return specimen;
	}

	private SpecimenContainerVoCollection getAlternativePaediatricContainers(SpecimenContainerVoCollection altPaedContainers)
	{

		if (altPaedContainers == null)
		{
			altPaedContainers = new SpecimenContainerVoCollection();
		}
		else
		{
			altPaedContainers.clear();
		}

		for (int i = 0; i < form.grdAltPaedCont().getRows().size(); i++)
		{
			altPaedContainers.add(form.grdAltPaedCont().getRows().get(i).getValue());
		}

		return altPaedContainers;
	}

	private SpecimenContainerVoCollection getPaediatricContainers(SpecimenContainerVoCollection paedContainers)
	{

		if (paedContainers == null)
		{
			paedContainers = new SpecimenContainerVoCollection();
		}
		else
		{
			paedContainers.clear();
		}

		for (int i = 0; i < form.grdPaedCont().getRows().size(); i++)
		{
			paedContainers.add(form.grdPaedCont().getRows().get(i).getValue());
		}

		return paedContainers;
	}

	private SpecimenContainerVoCollection getAdultContainers(SpecimenContainerVoCollection adultContainers)
	{

		if (adultContainers == null)
		{
			adultContainers = new SpecimenContainerVoCollection();
		}
		else
		{
			adultContainers.clear();
		}

		for (int i = 0; i < form.grdAdultSpecCont().getRows().size(); i++)
		{
			adultContainers.add(form.grdAdultSpecCont().getRows().get(i).getValue());
		}

		return adultContainers;
	}

	public void setValue(SpecimenVo specimen)
	{
		form.getLocalContext().setSpecimen(specimen);
		populateScreenFromData(form.getLocalContext().getSpecimen());
	}

	public void clear()
	{
		clearScreen();
		form.getLocalContext().setSpecimen(null);
	}

	public void disableSpecimenType()
	{
		form.cmbSpecimenType().setEnabled(Boolean.FALSE);
		form.getLocalContext().setdisableSpecimenType(Boolean.TRUE);
	}

	public void isDftInvestigation(Boolean isDFT)
	{
		form.getLocalContext().setisDftInvestigation(isDFT);
	}

}
