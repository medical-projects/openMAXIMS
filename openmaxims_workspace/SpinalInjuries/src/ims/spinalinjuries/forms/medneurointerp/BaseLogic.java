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

package ims.spinalinjuries.forms.medneurointerp;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.MedNeuroInterp.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.MedNeuroInterp domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAsiaGradeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAsiaGrade().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.AsiaGrade existingInstance = (ims.spinalinjuries.vo.lookups.AsiaGrade)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAsiaGradeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.AsiaGrade)
		{
			ims.spinalinjuries.vo.lookups.AsiaGrade instance = (ims.spinalinjuries.vo.lookups.AsiaGrade)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAsiaGradeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.AsiaGrade existingInstance = (ims.spinalinjuries.vo.lookups.AsiaGrade)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAsiaGrade().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAsiaGradeLookup()
	{
		this.form.cmbAsiaGrade().clear();
		ims.spinalinjuries.vo.lookups.AsiaGradeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getAsiaGrade(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAsiaGrade().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAsiaGradeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.AsiaGrade instance = ims.spinalinjuries.vo.lookups.LookupHelper.getAsiaGradeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAsiaGrade().setValue(instance);
	}
	protected final void defaultcmbAsiaGradeLookupValue()
	{
		this.form.cmbAsiaGrade().setValue((ims.spinalinjuries.vo.lookups.AsiaGrade)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.AsiaGrade.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.AsiaGrade.TYPE_ID));
	}
	protected final void oncmbSpineSyndValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpineSynd().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SpinalSyndrome existingInstance = (ims.spinalinjuries.vo.lookups.SpinalSyndrome)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpineSyndLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.SpinalSyndrome)
		{
			ims.spinalinjuries.vo.lookups.SpinalSyndrome instance = (ims.spinalinjuries.vo.lookups.SpinalSyndrome)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpineSyndLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.SpinalSyndrome existingInstance = (ims.spinalinjuries.vo.lookups.SpinalSyndrome)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpineSynd().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpineSyndLookup()
	{
		this.form.cmbSpineSynd().clear();
		ims.spinalinjuries.vo.lookups.SpinalSyndromeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSpinalSyndrome(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpineSynd().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpineSyndLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.SpinalSyndrome instance = ims.spinalinjuries.vo.lookups.LookupHelper.getSpinalSyndromeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpineSynd().setValue(instance);
	}
	protected final void defaultcmbSpineSyndLookupValue()
	{
		this.form.cmbSpineSynd().setValue((ims.spinalinjuries.vo.lookups.SpinalSyndrome)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.SpinalSyndrome.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.SpinalSyndrome.TYPE_ID));
	}
	protected final void oncmbCompleteInCompValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCompleteInComp().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete existingInstance = (ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCompleteInCompLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete)
		{
			ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete instance = (ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCompleteInCompLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete existingInstance = (ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCompleteInComp().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCompleteInCompLookup()
	{
		this.form.cmbCompleteInComp().clear();
		ims.spinalinjuries.vo.lookups.NeuroCompleteIncompleteCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getNeuroCompleteIncomplete(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCompleteInComp().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCompleteInCompLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete instance = ims.spinalinjuries.vo.lookups.LookupHelper.getNeuroCompleteIncompleteInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCompleteInComp().setValue(instance);
	}
	protected final void defaultcmbCompleteInCompLookupValue()
	{
		this.form.cmbCompleteInComp().setValue((ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.NeuroCompleteIncomplete.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.MedNeuroInterp domain;
}
