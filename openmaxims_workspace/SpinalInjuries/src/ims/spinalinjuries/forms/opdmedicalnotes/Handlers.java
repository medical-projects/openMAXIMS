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

package ims.spinalinjuries.forms.opdmedicalnotes;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbNxtOpdUnitLookup();
	abstract protected void defaultcmbNxtOpdUnitLookupValue();
	abstract protected void bindcmbAutoDysreflexiaLookup();
	abstract protected void defaultcmbAutoDysreflexiaLookupValue();
	abstract protected void onFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnWheelChairClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRecbrOPDMedicalNotesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbNxtOpdUnitValueSet(Object value);
	abstract protected void onBtnMusculoskeletalInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAutoDysreflexiaValueSet(Object value);

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormClosing(args);
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
		this.form.btnWheelChair().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnWheelChairClick();
			}
		});
		this.form.recbrOPDMedicalNotes().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRecbrOPDMedicalNotesValueChanged();
			}
		});
		this.form.cmbNxtOpdUnit().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbNxtOpdUnitValueSet(value);
			}
		});
		this.form.btnMusculoskeletalInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMusculoskeletalInfoClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBUpdateClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBNewClick();
			}
		});
		this.form.cmbAutoDysreflexia().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAutoDysreflexiaValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbNxtOpdUnitLookup();
		bindcmbAutoDysreflexiaLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbNxtOpdUnitLookup();
		bindcmbAutoDysreflexiaLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbNxtOpdUnitLookupValue();
		defaultcmbAutoDysreflexiaLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
