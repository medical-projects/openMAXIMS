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

package ims.spinalinjuries.forms.medinjurydetails;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.MedInjuryDetails.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.MedInjuryDetails domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbUnitDurLOCValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUnitDurLOC().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.DurLOCUnit existingInstance = (ims.spinalinjuries.vo.lookups.DurLOCUnit)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUnitDurLOCLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.DurLOCUnit)
		{
			ims.spinalinjuries.vo.lookups.DurLOCUnit instance = (ims.spinalinjuries.vo.lookups.DurLOCUnit)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUnitDurLOCLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.DurLOCUnit existingInstance = (ims.spinalinjuries.vo.lookups.DurLOCUnit)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUnitDurLOC().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUnitDurLOCLookup()
	{
		this.form.cmbUnitDurLOC().clear();
		ims.spinalinjuries.vo.lookups.DurLOCUnitCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getDurLOCUnit(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUnitDurLOC().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUnitDurLOCLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.DurLOCUnit instance = ims.spinalinjuries.vo.lookups.LookupHelper.getDurLOCUnitInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUnitDurLOC().setValue(instance);
	}
	protected final void defaultcmbUnitDurLOCLookupValue()
	{
		this.form.cmbUnitDurLOC().setValue((ims.spinalinjuries.vo.lookups.DurLOCUnit)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.DurLOCUnit.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.DurLOCUnit.TYPE_ID));
	}
	protected final void oncmbReqVentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReqVent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReqVentLookup();
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
					bindcmbReqVentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReqVent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReqVentLookup()
	{
		this.form.cmbReqVent().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReqVent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReqVentLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReqVent().setValue(instance);
	}
	protected final void defaultcmbReqVentLookupValue()
	{
		this.form.cmbReqVent().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbCauseInjuryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCauseInjury().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury existingInstance = (ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCauseInjuryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury)
		{
			ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury instance = (ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCauseInjuryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury existingInstance = (ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCauseInjury().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCauseInjuryLookup()
	{
		this.form.cmbCauseInjury().clear();
		ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjuryCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getInjuryClassCauseofInjury(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCauseInjury().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCauseInjuryLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury instance = ims.spinalinjuries.vo.lookups.LookupHelper.getInjuryClassCauseofInjuryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCauseInjury().setValue(instance);
	}
	protected final void defaultcmbCauseInjuryLookupValue()
	{
		this.form.cmbCauseInjury().setValue((ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.InjuryClassCauseofInjury.TYPE_ID));
	}
	protected final void bindgrdAssocFactorscolFactorLookup()
	{
		this.form.grdAssocFactors().colFactorComboBox().clear();
		ims.spinalinjuries.vo.lookups.InjuryAssociatedFactorCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getInjuryAssociatedFactor(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdAssocFactors().colFactorComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.MedInjuryDetails domain;
}
