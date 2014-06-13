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

package ims.therapies.forms.massage;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdConnectiveColAreaLookup();
	abstract protected void bindgrdConnectiveColLateralityLookup();
	abstract protected void bindgrdFrictionColLateralityLookup();
	abstract protected void bindgrdTissueColTypeofMassageLookup();
	abstract protected void bindgrdTissueColAreaLookup();
	abstract protected void bindgrdTissueColLateralityLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbAuthoringCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdConnectiveSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdFrictionSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdFrictionMutableComboBoxSelected(int column, GenForm.grdFrictionRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTissueSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrMassageValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
			}
		});
		this.form.qmbAuthoringCP().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbAuthoringCPTextSubmited(value);
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.grdConnective().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdConnectiveSelectionChanged();
			}
		});
		this.form.grdFriction().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFrictionSelectionChanged();
			}
		});
		this.form.grdFriction().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFrictionMutableComboBoxSelected(column, new GenForm.grdFrictionRow(row), value);
			}
		});
		this.form.grdTissue().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTissueSelectionChanged();
			}
		});
		this.form.recbrMassage().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrMassageValueChanged();
			}
		});
		this.form.getContextMenus().getMassageConnectiveAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageConnective.Add, sender);
			}
		});
		this.form.getContextMenus().getMassageConnectiveRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageConnective.Remove, sender);
			}
		});
		this.form.getContextMenus().getMassageDeepAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageDeep.Add, sender);
			}
		});
		this.form.getContextMenus().getMassageDeepRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageDeep.Remove, sender);
			}
		});
		this.form.getContextMenus().getMassageSoftAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageSoft.Add, sender);
			}
		});
		this.form.getContextMenus().getMassageSoftRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MassageSoft.Remove, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdConnectiveColAreaLookup();
		bindgrdConnectiveColLateralityLookup();
		bindgrdFrictionColLateralityLookup();
		bindgrdTissueColTypeofMassageLookup();
		bindgrdTissueColAreaLookup();
		bindgrdTissueColLateralityLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdConnectiveColAreaLookup();
		bindgrdConnectiveColLateralityLookup();
		bindgrdFrictionColLateralityLookup();
		bindgrdTissueColTypeofMassageLookup();
		bindgrdTissueColAreaLookup();
		bindgrdTissueColLateralityLookup();
	}
	protected void defaultAllLookupValues()
	{
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
