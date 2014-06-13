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

package ims.clinical.forms.demoreferrallist;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.DemoReferralList.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.DemoReferralList domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.clinical.vo.lookups.ReferralSourceCollection.class, ims.clinical.vo.lookups.ReferralSource.class, 1231045, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'ReferralSource' (ID: 1231045) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.core.vo.lookups.CoreReferralStatusCollection.class, ims.core.vo.lookups.CoreReferralStatus.class, 1021148, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'CoreReferralStatus' (ID: 1021148) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.clinical.vo.lookups.SpecialtyFunctionCodeCollection.class, ims.clinical.vo.lookups.SpecialtyFunctionCode.class, 1231060, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'SpecialtyFunctionCode' (ID: 1231060) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.clinical.vo.lookups.ReferralDisciplineCollection.class, ims.clinical.vo.lookups.ReferralDiscipline.class, 1231064, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'ReferralDiscipline' (ID: 1231064) must have at least one active instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	protected final void oncmbReferalValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReferal().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralSource existingInstance = (ims.clinical.vo.lookups.ReferralSource)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReferalLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.ReferralSource)
		{
			ims.clinical.vo.lookups.ReferralSource instance = (ims.clinical.vo.lookups.ReferralSource)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReferalLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralSource existingInstance = (ims.clinical.vo.lookups.ReferralSource)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReferal().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReferalLookup()
	{
		this.form.cmbReferal().clear();
		ims.clinical.vo.lookups.ReferralSourceCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getReferralSource(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReferal().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReferalLookupValue(int id)
	{
		ims.clinical.vo.lookups.ReferralSource instance = ims.clinical.vo.lookups.LookupHelper.getReferralSourceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReferal().setValue(instance);
	}
	protected final void defaultcmbReferalLookupValue()
	{
		this.form.cmbReferal().setValue((ims.clinical.vo.lookups.ReferralSource)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.ReferralSource.class, engine.getFormName().getID(), ims.clinical.vo.lookups.ReferralSource.TYPE_ID));
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CoreReferralStatus existingInstance = (ims.core.vo.lookups.CoreReferralStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.CoreReferralStatus)
		{
			ims.core.vo.lookups.CoreReferralStatus instance = (ims.core.vo.lookups.CoreReferralStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CoreReferralStatus existingInstance = (ims.core.vo.lookups.CoreReferralStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.core.vo.lookups.CoreReferralStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getCoreReferralStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.core.vo.lookups.CoreReferralStatus instance = ims.core.vo.lookups.LookupHelper.getCoreReferralStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.core.vo.lookups.CoreReferralStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.CoreReferralStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.CoreReferralStatus.TYPE_ID));
	}
	protected final void oncmbDisciplineValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDiscipline().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralDiscipline existingInstance = (ims.clinical.vo.lookups.ReferralDiscipline)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDisciplineLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.ReferralDiscipline)
		{
			ims.clinical.vo.lookups.ReferralDiscipline instance = (ims.clinical.vo.lookups.ReferralDiscipline)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDisciplineLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReferralDiscipline existingInstance = (ims.clinical.vo.lookups.ReferralDiscipline)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDiscipline().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDisciplineLookup()
	{
		this.form.cmbDiscipline().clear();
		ims.clinical.vo.lookups.ReferralDisciplineCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getReferralDiscipline(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDiscipline().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDisciplineLookupValue(int id)
	{
		ims.clinical.vo.lookups.ReferralDiscipline instance = ims.clinical.vo.lookups.LookupHelper.getReferralDisciplineInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDiscipline().setValue(instance);
	}
	protected final void defaultcmbDisciplineLookupValue()
	{
		this.form.cmbDiscipline().setValue((ims.clinical.vo.lookups.ReferralDiscipline)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.ReferralDiscipline.class, engine.getFormName().getID(), ims.clinical.vo.lookups.ReferralDiscipline.TYPE_ID));
	}
	protected final void oncmbSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.SpecialtyFunctionCode existingInstance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.SpecialtyFunctionCode)
		{
			ims.clinical.vo.lookups.SpecialtyFunctionCode instance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.SpecialtyFunctionCode existingInstance = (ims.clinical.vo.lookups.SpecialtyFunctionCode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyLookup()
	{
		this.form.cmbSpecialty().clear();
		ims.clinical.vo.lookups.SpecialtyFunctionCodeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getSpecialtyFunctionCode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyLookupValue(int id)
	{
		ims.clinical.vo.lookups.SpecialtyFunctionCode instance = ims.clinical.vo.lookups.LookupHelper.getSpecialtyFunctionCodeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialty().setValue(instance);
	}
	protected final void defaultcmbSpecialtyLookupValue()
	{
		this.form.cmbSpecialty().setValue((ims.clinical.vo.lookups.SpecialtyFunctionCode)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.SpecialtyFunctionCode.class, engine.getFormName().getID(), ims.clinical.vo.lookups.SpecialtyFunctionCode.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.DemoReferralList domain;
}
