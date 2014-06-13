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

package ims.clinical.forms.outpatientnoting;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.OutpatientNoting.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.OutpatientNoting domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmb3ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPageMedication().cmb3().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OutcomeOfClinicAttendance existingInstance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmb3Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.OutcomeOfClinicAttendance)
		{
			ims.clinical.vo.lookups.OutcomeOfClinicAttendance instance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmb3Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OutcomeOfClinicAttendance existingInstance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPageMedication().cmb3().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmb3Lookup()
	{
		this.form.lyrDetails().tabPageMedication().cmb3().clear();
		ims.clinical.vo.lookups.OutcomeOfClinicAttendanceCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getOutcomeOfClinicAttendance(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPageMedication().cmb3().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmb3LookupValue(int id)
	{
		ims.clinical.vo.lookups.OutcomeOfClinicAttendance instance = ims.clinical.vo.lookups.LookupHelper.getOutcomeOfClinicAttendanceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPageMedication().cmb3().setValue(instance);
	}
	protected final void defaultcmb3LookupValue()
	{
		this.form.lyrDetails().tabPageMedication().cmb3().setValue((ims.clinical.vo.lookups.OutcomeOfClinicAttendance)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.OutcomeOfClinicAttendance.class, engine.getFormName().getID(), ims.clinical.vo.lookups.OutcomeOfClinicAttendance.TYPE_ID));
	}
	protected final void oncmbOutcomeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPageMedication().cmbOutcome().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OutcomeOfClinicAttendance existingInstance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOutcomeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.OutcomeOfClinicAttendance)
		{
			ims.clinical.vo.lookups.OutcomeOfClinicAttendance instance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOutcomeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.OutcomeOfClinicAttendance existingInstance = (ims.clinical.vo.lookups.OutcomeOfClinicAttendance)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPageMedication().cmbOutcome().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOutcomeLookup()
	{
		this.form.lyrDetails().tabPageMedication().cmbOutcome().clear();
		ims.clinical.vo.lookups.OutcomeOfClinicAttendanceCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getOutcomeOfClinicAttendance(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPageMedication().cmbOutcome().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOutcomeLookupValue(int id)
	{
		ims.clinical.vo.lookups.OutcomeOfClinicAttendance instance = ims.clinical.vo.lookups.LookupHelper.getOutcomeOfClinicAttendanceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPageMedication().cmbOutcome().setValue(instance);
	}
	protected final void defaultcmbOutcomeLookupValue()
	{
		this.form.lyrDetails().tabPageMedication().cmbOutcome().setValue((ims.clinical.vo.lookups.OutcomeOfClinicAttendance)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.OutcomeOfClinicAttendance.class, engine.getFormName().getID(), ims.clinical.vo.lookups.OutcomeOfClinicAttendance.TYPE_ID));
	}
	protected final void bindgrdProHighCostcolProcHighCostLookup()
	{
		this.form.lyrDetails().tabPageMedication().grdProHighCost().colProcHighCostComboBox().clear();
		ims.clinical.vo.lookups.ProcedureHighCostDrugCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getProcedureHighCostDrug(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPageMedication().grdProHighCost().colProcHighCostComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.OutpatientNoting domain;
}
