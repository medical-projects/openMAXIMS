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

package ims.coe.forms.assessbladder;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.coe.domain.AssessBladder.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.coe.domain.AssessBladder domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onanswerBoxEmptySpontaneouslyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxEmptySpontaneously().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxEmptySpontaneouslyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxEmptySpontaneouslyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxEmptySpontaneously().addOption(instance);
		}
	}
	protected final void bindanswerBoxEmptySpontaneouslyLookup()
	{
		this.form.container1().answerBoxEmptySpontaneously().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxEmptySpontaneously().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxEmptySpontaneouslyLookupValue()
	{
		this.form.container1().answerBoxEmptySpontaneously().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncomboBoxNightValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxNight().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ContinenceDayNight existingInstance = (ims.nursing.vo.lookups.ContinenceDayNight)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxNightLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.ContinenceDayNight)
		{
			ims.nursing.vo.lookups.ContinenceDayNight instance = (ims.nursing.vo.lookups.ContinenceDayNight)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxNightLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ContinenceDayNight existingInstance = (ims.nursing.vo.lookups.ContinenceDayNight)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxNight().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxNightLookup()
	{
		this.form.container1().comboBoxNight().clear();
		ims.nursing.vo.lookups.ContinenceDayNightCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getContinenceDayNight(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxNight().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxNightLookupValue(int id)
	{
		ims.nursing.vo.lookups.ContinenceDayNight instance = ims.nursing.vo.lookups.LookupHelper.getContinenceDayNightInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxNight().setValue(instance);
	}
	protected final void defaultcomboBoxNightLookupValue()
	{
		this.form.container1().comboBoxNight().setValue((ims.nursing.vo.lookups.ContinenceDayNight)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.ContinenceDayNight.class, engine.getFormName().getID(), ims.nursing.vo.lookups.ContinenceDayNight.TYPE_ID));
	}
	protected final void oncomboBoxDayValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxDay().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ContinenceDayNight existingInstance = (ims.nursing.vo.lookups.ContinenceDayNight)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxDayLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.ContinenceDayNight)
		{
			ims.nursing.vo.lookups.ContinenceDayNight instance = (ims.nursing.vo.lookups.ContinenceDayNight)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxDayLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ContinenceDayNight existingInstance = (ims.nursing.vo.lookups.ContinenceDayNight)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxDay().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxDayLookup()
	{
		this.form.container1().comboBoxDay().clear();
		ims.nursing.vo.lookups.ContinenceDayNightCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getContinenceDayNight(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxDay().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxDayLookupValue(int id)
	{
		ims.nursing.vo.lookups.ContinenceDayNight instance = ims.nursing.vo.lookups.LookupHelper.getContinenceDayNightInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxDay().setValue(instance);
	}
	protected final void defaultcomboBoxDayLookupValue()
	{
		this.form.container1().comboBoxDay().setValue((ims.nursing.vo.lookups.ContinenceDayNight)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.ContinenceDayNight.class, engine.getFormName().getID(), ims.nursing.vo.lookups.ContinenceDayNight.TYPE_ID));
	}
	protected final void oncomboBoxDiversionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxDiversion().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.UrinaryDiversion existingInstance = (ims.nursing.vo.lookups.UrinaryDiversion)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxDiversionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.UrinaryDiversion)
		{
			ims.nursing.vo.lookups.UrinaryDiversion instance = (ims.nursing.vo.lookups.UrinaryDiversion)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxDiversionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.UrinaryDiversion existingInstance = (ims.nursing.vo.lookups.UrinaryDiversion)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxDiversion().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxDiversionLookup()
	{
		this.form.container1().comboBoxDiversion().clear();
		ims.nursing.vo.lookups.UrinaryDiversionCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getUrinaryDiversion(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxDiversion().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxDiversionLookupValue(int id)
	{
		ims.nursing.vo.lookups.UrinaryDiversion instance = ims.nursing.vo.lookups.LookupHelper.getUrinaryDiversionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxDiversion().setValue(instance);
	}
	protected final void defaultcomboBoxDiversionLookupValue()
	{
		this.form.container1().comboBoxDiversion().setValue((ims.nursing.vo.lookups.UrinaryDiversion)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.UrinaryDiversion.class, engine.getFormName().getID(), ims.nursing.vo.lookups.UrinaryDiversion.TYPE_ID));
	}
	protected final void bindgridManagementColMethodLookup()
	{
		this.form.container1().gridManagement().ColMethodComboBox().clear();
		ims.nursing.vo.lookups.BladderManagementMethodCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBladderManagementMethod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().gridManagement().ColMethodComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgridManagementColTypeLookup()
	{
		this.form.container1().gridManagement().ColTypeComboBox().clear();
		ims.nursing.vo.lookups.BladderManagementTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBladderManagementType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().gridManagement().ColTypeComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgridSkillscolDependencyLookup()
	{
		this.form.container1().gridSkills().colDependencyComboBox().clear();
		ims.nursing.vo.lookups.AbilityCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getAbility(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().gridSkills().colDependencyComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void onanswerBoxRequireAssistanceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxRequireAssistance().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxRequireAssistanceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxRequireAssistanceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxRequireAssistance().addOption(instance);
		}
	}
	protected final void bindanswerBoxRequireAssistanceLookup()
	{
		this.form.container1().answerBoxRequireAssistance().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxRequireAssistance().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxRequireAssistanceLookupValue()
	{
		this.form.container1().answerBoxRequireAssistance().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.coe.domain.AssessBladder domain;
}
