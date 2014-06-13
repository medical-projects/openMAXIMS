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

package ims.nursing.forms.careplantemplatedetail;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.CarePlanTemplateDetail.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.CarePlanTemplateDetail domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncomboBoxComponentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxComponent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.AssessmentComponentType existingInstance = (ims.nursing.vo.lookups.AssessmentComponentType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxComponentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.AssessmentComponentType)
		{
			ims.nursing.vo.lookups.AssessmentComponentType instance = (ims.nursing.vo.lookups.AssessmentComponentType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxComponentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.AssessmentComponentType existingInstance = (ims.nursing.vo.lookups.AssessmentComponentType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxComponent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxComponentLookup()
	{
		this.form.comboBoxComponent().clear();
		ims.nursing.vo.lookups.AssessmentComponentTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getAssessmentComponentType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxComponent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxComponentLookupValue(int id)
	{
		ims.nursing.vo.lookups.AssessmentComponentType instance = ims.nursing.vo.lookups.LookupHelper.getAssessmentComponentTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxComponent().setValue(instance);
	}
	protected final void defaultcomboBoxComponentLookupValue()
	{
		this.form.comboBoxComponent().setValue((ims.nursing.vo.lookups.AssessmentComponentType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.AssessmentComponentType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.AssessmentComponentType.TYPE_ID));
	}
	protected final void bindgridInterventionsColManOptLookup()
	{
		this.form.gridInterventions().ColManOptComboBox().clear();
		ims.nursing.vo.lookups.CarePlanInterventionManOptCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getCarePlanInterventionManOpt(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.gridInterventions().ColManOptComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.CarePlanTemplateDetail domain;
}
