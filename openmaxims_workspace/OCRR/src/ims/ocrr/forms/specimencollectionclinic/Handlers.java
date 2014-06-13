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

package ims.ocrr.forms.specimencollectionclinic;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindcmbSexLookup();
	abstract protected void defaultcmbSexLookupValue();
	abstract protected void bindcmbTitleLookup();
	abstract protected void defaultcmbTitleLookupValue();
	abstract protected void bindcmbSIDTypeLookup();
	abstract protected void defaultcmbSIDTypeLookupValue();
	abstract protected void bindcmbSSexLookup();
	abstract protected void defaultcmbSSexLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdCollectCellTextSubmited(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdCollectCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdCollectCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void oncmbSexValueSet(Object value);
	abstract protected void oncmbTitleValueSet(Object value);
	abstract protected void onGrdPatientListSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSIDTypeValueSet(Object value);
	abstract protected void oncmbSSexValueSet(Object value);

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
				// Checking lookups usage
				if(getLookupUsageErrors() != null && getLookupUsageErrors().length > 0)
					throw new ims.framework.exceptions.FormMandatoryLookupMissingException(ims.framework.exceptions.FormMandatoryLookupMissingException.getError(getLookupUsageErrors()));
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.GroupStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupStatusValueChanged();
			}
		});
		this.form.btnPrint().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPrintClick();
			}
		});
		this.form.dyngrdCollect().setDynamicGridCellTextSubmitedEvent(new DynamicGridCellTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdCollectCellTextSubmited(cell);
			}
		});
		this.form.dyngrdCollect().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdCollectCellButtonClicked(cell);
			}
		});
		this.form.dyngrdCollect().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdCollectCellValueChanged(cell);
			}
		});
		this.form.lyrPatDetails().tabPagePatientDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatDetailstabPagePatientDetailsActivated();
			}
		});
		this.form.lyrPatDetails().tabPagePatientList().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPatDetailstabPagePatientListActivated();
			}
		});
		this.form.lyrPatDetails().tabPagePatientDetails().cmbSex().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSexValueSet(value);
			}
		});
		this.form.lyrPatDetails().tabPagePatientDetails().cmbTitle().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTitleValueSet(value);
			}
		});
		this.form.lyrPatDetails().tabPagePatientList().grdPatient().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdPatientListSelectionChanged();
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
		this.form.cmbSIDType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSIDTypeValueSet(value);
			}
		});
		this.form.cmbSSex().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSSexValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSexLookup();
		bindcmbTitleLookup();
		bindcmbSIDTypeLookup();
		bindcmbSSexLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSexLookup();
		bindcmbTitleLookup();
		bindcmbSIDTypeLookup();
		bindcmbSSexLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSexLookupValue();
		defaultcmbTitleLookupValue();
		defaultcmbSIDTypeLookupValue();
		defaultcmbSSexLookupValue();
	}
	private void onlyrPatDetailstabPagePatientDetailsActivated()
	{
		this.form.lyrPatDetails().showtabPagePatientDetails();
	}
	private void onlyrPatDetailstabPagePatientListActivated()
	{
		this.form.lyrPatDetails().showtabPagePatientList();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
