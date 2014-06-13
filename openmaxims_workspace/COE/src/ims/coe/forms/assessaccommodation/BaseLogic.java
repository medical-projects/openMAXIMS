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

package ims.coe.forms.assessaccommodation;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.coe.domain.AssessAccommodation.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.coe.domain.AssessAccommodation domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansAssistanceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansAssistance().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansAssistanceLookup();
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
					bindansAssistanceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansAssistance().addOption(instance);
		}
	}
	protected final void bindansAssistanceLookup()
	{
		this.form.ansAssistance().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansAssistance().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansAssistanceLookupValue()
	{
		this.form.ansAssistance().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbAccommodationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAccommodation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.AccommodationHousing existingInstance = (ims.coe.vo.lookups.AccommodationHousing)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAccommodationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.AccommodationHousing)
		{
			ims.coe.vo.lookups.AccommodationHousing instance = (ims.coe.vo.lookups.AccommodationHousing)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAccommodationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.AccommodationHousing existingInstance = (ims.coe.vo.lookups.AccommodationHousing)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAccommodation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAccommodationLookup()
	{
		this.form.cmbAccommodation().clear();
		ims.coe.vo.lookups.AccommodationHousingCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getAccommodationHousing(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAccommodation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAccommodationLookupValue(int id)
	{
		ims.coe.vo.lookups.AccommodationHousing instance = ims.coe.vo.lookups.LookupHelper.getAccommodationHousingInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAccommodation().setValue(instance);
	}
	protected final void defaultcmbAccommodationLookupValue()
	{
		this.form.cmbAccommodation().setValue((ims.coe.vo.lookups.AccommodationHousing)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.AccommodationHousing.class, engine.getFormName().getID(), ims.coe.vo.lookups.AccommodationHousing.TYPE_ID));
	}
	protected final void oncmbLivingArrngValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbLivingArrng().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.AccommodationLivingArrangements existingInstance = (ims.coe.vo.lookups.AccommodationLivingArrangements)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLivingArrngLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.AccommodationLivingArrangements)
		{
			ims.coe.vo.lookups.AccommodationLivingArrangements instance = (ims.coe.vo.lookups.AccommodationLivingArrangements)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLivingArrngLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.AccommodationLivingArrangements existingInstance = (ims.coe.vo.lookups.AccommodationLivingArrangements)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbLivingArrng().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLivingArrngLookup()
	{
		this.form.cmbLivingArrng().clear();
		ims.coe.vo.lookups.AccommodationLivingArrangementsCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getAccommodationLivingArrangements(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbLivingArrng().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLivingArrngLookupValue(int id)
	{
		ims.coe.vo.lookups.AccommodationLivingArrangements instance = ims.coe.vo.lookups.LookupHelper.getAccommodationLivingArrangementsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbLivingArrng().setValue(instance);
	}
	protected final void defaultcmbLivingArrngLookupValue()
	{
		this.form.cmbLivingArrng().setValue((ims.coe.vo.lookups.AccommodationLivingArrangements)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.AccommodationLivingArrangements.class, engine.getFormName().getID(), ims.coe.vo.lookups.AccommodationLivingArrangements.TYPE_ID));
	}
	protected final void bindgHomeFacilitiescolStatusLookup()
	{
		this.form.gHomeFacilities().answerBoxColumnClear(1);
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.gHomeFacilities().answerBoxColumnNewOption(1, lookupCollection.get(x));
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.coe.domain.AssessAccommodation domain;
}
