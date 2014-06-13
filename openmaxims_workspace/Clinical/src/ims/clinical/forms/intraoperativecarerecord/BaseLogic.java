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

package ims.clinical.forms.intraoperativecarerecord;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.IntraOperativeCareRecord.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.IntraOperativeCareRecord domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAnaestheticUsedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AnaestheticUsed existingInstance = (ims.clinical.vo.lookups.AnaestheticUsed)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAnaestheticUsedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.AnaestheticUsed)
		{
			ims.clinical.vo.lookups.AnaestheticUsed instance = (ims.clinical.vo.lookups.AnaestheticUsed)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAnaestheticUsedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AnaestheticUsed existingInstance = (ims.clinical.vo.lookups.AnaestheticUsed)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAnaestheticUsedLookup()
	{
		this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().clear();
		ims.clinical.vo.lookups.AnaestheticUsedCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getAnaestheticUsed(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAnaestheticUsedLookupValue(int id)
	{
		ims.clinical.vo.lookups.AnaestheticUsed instance = ims.clinical.vo.lookups.LookupHelper.getAnaestheticUsedInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().setValue(instance);
	}
	protected final void defaultcmbAnaestheticUsedLookupValue()
	{
		this.form.lyr1().tabCareRecord().cmbAnaestheticUsed().setValue((ims.clinical.vo.lookups.AnaestheticUsed)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.AnaestheticUsed.class, engine.getFormName().getID(), ims.clinical.vo.lookups.AnaestheticUsed.TYPE_ID));
	}
	protected final void oncmbPresureValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabDetails().ctn1().cmbPresure().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TourniquetPressure existingInstance = (ims.clinical.vo.lookups.TourniquetPressure)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPresureLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.TourniquetPressure)
		{
			ims.clinical.vo.lookups.TourniquetPressure instance = (ims.clinical.vo.lookups.TourniquetPressure)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPresureLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TourniquetPressure existingInstance = (ims.clinical.vo.lookups.TourniquetPressure)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabDetails().ctn1().cmbPresure().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPresureLookup()
	{
		this.form.lyr1().tabDetails().ctn1().cmbPresure().clear();
		ims.clinical.vo.lookups.TourniquetPressureCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getTourniquetPressure(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabDetails().ctn1().cmbPresure().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPresureLookupValue(int id)
	{
		ims.clinical.vo.lookups.TourniquetPressure instance = ims.clinical.vo.lookups.LookupHelper.getTourniquetPressureInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabDetails().ctn1().cmbPresure().setValue(instance);
	}
	protected final void defaultcmbPresureLookupValue()
	{
		this.form.lyr1().tabDetails().ctn1().cmbPresure().setValue((ims.clinical.vo.lookups.TourniquetPressure)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.TourniquetPressure.class, engine.getFormName().getID(), ims.clinical.vo.lookups.TourniquetPressure.TYPE_ID));
	}
	protected final void oncmbPositionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabDetails().ctn1().cmbPosition().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TourniquetPosition existingInstance = (ims.clinical.vo.lookups.TourniquetPosition)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPositionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.TourniquetPosition)
		{
			ims.clinical.vo.lookups.TourniquetPosition instance = (ims.clinical.vo.lookups.TourniquetPosition)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPositionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TourniquetPosition existingInstance = (ims.clinical.vo.lookups.TourniquetPosition)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabDetails().ctn1().cmbPosition().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPositionLookup()
	{
		this.form.lyr1().tabDetails().ctn1().cmbPosition().clear();
		ims.clinical.vo.lookups.TourniquetPositionCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getTourniquetPosition(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabDetails().ctn1().cmbPosition().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPositionLookupValue(int id)
	{
		ims.clinical.vo.lookups.TourniquetPosition instance = ims.clinical.vo.lookups.LookupHelper.getTourniquetPositionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabDetails().ctn1().cmbPosition().setValue(instance);
	}
	protected final void defaultcmbPositionLookupValue()
	{
		this.form.lyr1().tabDetails().ctn1().cmbPosition().setValue((ims.clinical.vo.lookups.TourniquetPosition)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.TourniquetPosition.class, engine.getFormName().getID(), ims.clinical.vo.lookups.TourniquetPosition.TYPE_ID));
	}
	protected final void oncmbDiathermyPlateValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DiathermyType existingInstance = (ims.clinical.vo.lookups.DiathermyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDiathermyPlateLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.DiathermyType)
		{
			ims.clinical.vo.lookups.DiathermyType instance = (ims.clinical.vo.lookups.DiathermyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDiathermyPlateLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DiathermyType existingInstance = (ims.clinical.vo.lookups.DiathermyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDiathermyPlateLookup()
	{
		this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().clear();
		ims.clinical.vo.lookups.DiathermyTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getDiathermyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDiathermyPlateLookupValue(int id)
	{
		ims.clinical.vo.lookups.DiathermyType instance = ims.clinical.vo.lookups.LookupHelper.getDiathermyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().setValue(instance);
	}
	protected final void defaultcmbDiathermyPlateLookupValue()
	{
		this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlate().setValue((ims.clinical.vo.lookups.DiathermyType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.DiathermyType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.DiathermyType.TYPE_ID));
	}
	protected final void oncmbDiathermyPlateSite2ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DiathermyType existingInstance = (ims.clinical.vo.lookups.DiathermyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDiathermyPlateSite2Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.DiathermyType)
		{
			ims.clinical.vo.lookups.DiathermyType instance = (ims.clinical.vo.lookups.DiathermyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDiathermyPlateSite2Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.DiathermyType existingInstance = (ims.clinical.vo.lookups.DiathermyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDiathermyPlateSite2Lookup()
	{
		this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().clear();
		ims.clinical.vo.lookups.DiathermyTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getDiathermyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDiathermyPlateSite2LookupValue(int id)
	{
		ims.clinical.vo.lookups.DiathermyType instance = ims.clinical.vo.lookups.LookupHelper.getDiathermyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().setValue(instance);
	}
	protected final void defaultcmbDiathermyPlateSite2LookupValue()
	{
		this.form.lyr1().tabDetails().ctn1().cmbDiathermyPlateSite2().setValue((ims.clinical.vo.lookups.DiathermyType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.DiathermyType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.DiathermyType.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.IntraOperativeCareRecord domain;
}
