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

package ims.core.forms.questionanswertype;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.domain.DomainInterface.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.domain.DomainInterface domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdAnswerOptioncolExtCodeTypeLookup()
	{
		this.form.grdAnswerOption().colExtCodeTypeComboBox().clear();
		ims.core.vo.lookups.TaxonomyTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTaxonomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdAnswerOption().colExtCodeTypeComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbAnswerTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAnswerType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.QuestionAnswerType existingInstance = (ims.core.vo.lookups.QuestionAnswerType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAnswerTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.QuestionAnswerType)
		{
			ims.core.vo.lookups.QuestionAnswerType instance = (ims.core.vo.lookups.QuestionAnswerType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAnswerTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.QuestionAnswerType existingInstance = (ims.core.vo.lookups.QuestionAnswerType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAnswerType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAnswerTypeLookup()
	{
		this.form.cmbAnswerType().clear();
		ims.core.vo.lookups.QuestionAnswerTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getQuestionAnswerType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAnswerType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAnswerTypeLookupValue(int id)
	{
		ims.core.vo.lookups.QuestionAnswerType instance = ims.core.vo.lookups.LookupHelper.getQuestionAnswerTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAnswerType().setValue(instance);
	}
	protected final void defaultcmbAnswerTypeLookupValue()
	{
		this.form.cmbAnswerType().setValue((ims.core.vo.lookups.QuestionAnswerType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.QuestionAnswerType.class, engine.getFormName().getID(), ims.core.vo.lookups.QuestionAnswerType.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.intMaxMultiselect().setValue(null);
		this.form.intCustomWidth().setValue(null);
		this.form.txtSeparator().setValue("");
		this.form.chkActive().setValue(false);
		this.form.txtValidationMsg().setValue("");
		this.form.chkIsMandatory().setValue(false);
		this.form.cmbAnswerType().setValue(null);
	}
	protected void populateScreenFromData(ims.core.vo.QuestionAnswerTypeVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.intMaxMultiselect().setValue(value.getMaxMultiselectAllowedIsNotNull() ? value.getMaxMultiselectAllowed() : null);
		this.form.intCustomWidth().setValue(value.getAnswerWidthIsNotNull() ? value.getAnswerWidth() : null);
		this.form.txtSeparator().setValue(value.getSeparatorTextIsNotNull() ? value.getSeparatorText(): null);
		if(value.getActiveStatusIsNotNull())
			this.form.chkActive().setValue(value.getActiveStatus().booleanValue());
		this.form.txtValidationMsg().setValue(value.getMandatoryValMessageIsNotNull() ? value.getMandatoryValMessage(): null);
		if(value.getIsMandatoryIsNotNull())
			this.form.chkIsMandatory().setValue(value.getIsMandatory().booleanValue());
		this.form.cmbAnswerType().setValue(value.getAnswerTypeIsNotNull() ? value.getAnswerType() : null);
	}
	protected ims.core.vo.QuestionAnswerTypeVo populateDataFromScreen(ims.core.vo.QuestionAnswerTypeVo value)
	{
		if(value == null)
			value = new ims.core.vo.QuestionAnswerTypeVo();

		value.setMaxMultiselectAllowed(this.form.intMaxMultiselect().getValue());
		value.setAnswerWidth(this.form.intCustomWidth().getValue());
		value.setSeparatorText(this.form.txtSeparator().getValue());
		value.setActiveStatus(new Boolean(this.form.chkActive().getValue()));
		value.setMandatoryValMessage(this.form.txtValidationMsg().getValue());
		value.setIsMandatory(new Boolean(this.form.chkIsMandatory().getValue()));
		value.setAnswerType(this.form.cmbAnswerType().getValue());

		return value;
	}
	protected ims.core.vo.QuestionAnswerTypeVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.QuestionAnswerTypeVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.domain.DomainInterface domain;
}
