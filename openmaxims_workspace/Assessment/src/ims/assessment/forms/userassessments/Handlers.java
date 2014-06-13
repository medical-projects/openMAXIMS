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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.assessment.forms.userassessments;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindcmbCategoryLookup();
	abstract protected void defaultcmbCategoryLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbCategoryValueSet(Object value);
	abstract protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.btnPreview().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviewClick();
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.cmbCategory().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCategoryValueSet(value);
			}
		});
		this.form.grdDetails().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDetailsSelectionChanged();
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.ADD, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentDPPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.DPP, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentFALLRISKItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.FALLRISK, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentADLItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.ADL, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentSKINItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.SKIN, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentBLADItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.BLAD, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentBWELItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.BWEL, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentMOBItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.MOB, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentWCItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.WC, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentCOMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.COM, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentDISItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.DIS, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentPSYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.PSY, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentNURSEDISCHARGECHKLSTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.NURSEDISCHARGECHKLST, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentPREOPPOSSUMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.PREOPPOSSUM, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentOPERATIVEDETAILSPOSSUMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.OPERATIVEDETAILSPOSSUM, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentNEW_NON_SCORINGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.NEW_NON_SCORING, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentDISCHARGECHECKLISTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.DISCHARGECHECKLIST, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentNURSING_DISCHARGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.NURSING_DISCHARGE, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentNURSING_DISCHARGE_PLANNINGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.NURSING_DISCHARGE_PLANNING, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentADD_NEW_BASED_ON_PREVIOUSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.ADD_NEW_BASED_ON_PREVIOUS, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentMANCHESTERTRIAGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.MANCHESTERTRIAGE, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.EDIT, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.VIEW, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentPREVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.PREVIEW, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentMOVE_UPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.MOVE_UP, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentMOVE_DOWNItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.MOVE_DOWN, sender);
			}
		});
		this.form.getContextMenus().Assessment.getUserAssessmentINTRODUCTORY_PHONE_CALLItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.AssessmentNamespace.UserAssessment.INTRODUCTORY_PHONE_CALL, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbStatusLookup();
		bindcmbCategoryLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbStatusLookup();
		bindcmbCategoryLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbStatusLookupValue();
		defaultcmbCategoryLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
