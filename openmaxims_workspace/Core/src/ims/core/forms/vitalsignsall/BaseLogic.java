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

package ims.core.forms.vitalsignsall;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.VitalSignsAll.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.VitalSignsAll domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbPatientConcernValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPatientConcern().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientCausingConcern existingInstance = (ims.core.vo.lookups.PatientCausingConcern)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatientConcernLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatientCausingConcern)
		{
			ims.core.vo.lookups.PatientCausingConcern instance = (ims.core.vo.lookups.PatientCausingConcern)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatientConcernLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatientCausingConcern existingInstance = (ims.core.vo.lookups.PatientCausingConcern)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPatientConcern().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatientConcernLookup()
	{
		this.form.cmbPatientConcern().clear();
		ims.core.vo.lookups.PatientCausingConcernCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatientCausingConcern(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPatientConcern().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatientConcernLookupValue(int id)
	{
		ims.core.vo.lookups.PatientCausingConcern instance = ims.core.vo.lookups.LookupHelper.getPatientCausingConcernInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPatientConcern().setValue(instance);
	}
	protected final void defaultcmbPatientConcernLookupValue()
	{
		this.form.cmbPatientConcern().setValue((ims.core.vo.lookups.PatientCausingConcern)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatientCausingConcern.class, engine.getFormName().getID(), ims.core.vo.lookups.PatientCausingConcern.TYPE_ID));
	}
	protected final void oncmbUrineValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUrine().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UrineOutput existingInstance = (ims.core.vo.lookups.UrineOutput)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUrineLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.UrineOutput)
		{
			ims.core.vo.lookups.UrineOutput instance = (ims.core.vo.lookups.UrineOutput)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUrineLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UrineOutput existingInstance = (ims.core.vo.lookups.UrineOutput)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUrine().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUrineLookup()
	{
		this.form.cmbUrine().clear();
		ims.core.vo.lookups.UrineOutputCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getUrineOutput(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUrine().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUrineLookupValue(int id)
	{
		ims.core.vo.lookups.UrineOutput instance = ims.core.vo.lookups.LookupHelper.getUrineOutputInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUrine().setValue(instance);
	}
	protected final void defaultcmbUrineLookupValue()
	{
		this.form.cmbUrine().setValue((ims.core.vo.lookups.UrineOutput)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.UrineOutput.class, engine.getFormName().getID(), ims.core.vo.lookups.UrineOutput.TYPE_ID));
	}
	protected final void oncmbConsciousValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbConscious().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ConsciousLevel existingInstance = (ims.core.vo.lookups.ConsciousLevel)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbConsciousLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ConsciousLevel)
		{
			ims.core.vo.lookups.ConsciousLevel instance = (ims.core.vo.lookups.ConsciousLevel)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbConsciousLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ConsciousLevel existingInstance = (ims.core.vo.lookups.ConsciousLevel)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbConscious().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbConsciousLookup()
	{
		this.form.cmbConscious().clear();
		ims.core.vo.lookups.ConsciousLevelCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getConsciousLevel(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbConscious().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbConsciousLookupValue(int id)
	{
		ims.core.vo.lookups.ConsciousLevel instance = ims.core.vo.lookups.LookupHelper.getConsciousLevelInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbConscious().setValue(instance);
	}
	protected final void defaultcmbConsciousLookupValue()
	{
		this.form.cmbConscious().setValue((ims.core.vo.lookups.ConsciousLevel)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ConsciousLevel.class, engine.getFormName().getID(), ims.core.vo.lookups.ConsciousLevel.TYPE_ID));
	}
	protected final void oncmbTimePeriodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTimePeriod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CBGMTimePeriod existingInstance = (ims.core.vo.lookups.CBGMTimePeriod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTimePeriodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.CBGMTimePeriod)
		{
			ims.core.vo.lookups.CBGMTimePeriod instance = (ims.core.vo.lookups.CBGMTimePeriod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTimePeriodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.CBGMTimePeriod existingInstance = (ims.core.vo.lookups.CBGMTimePeriod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTimePeriod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTimePeriodLookup()
	{
		this.form.cmbTimePeriod().clear();
		ims.core.vo.lookups.CBGMTimePeriodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getCBGMTimePeriod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTimePeriod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTimePeriodLookupValue(int id)
	{
		ims.core.vo.lookups.CBGMTimePeriod instance = ims.core.vo.lookups.LookupHelper.getCBGMTimePeriodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTimePeriod().setValue(instance);
	}
	protected final void defaultcmbTimePeriodLookupValue()
	{
		this.form.cmbTimePeriod().setValue((ims.core.vo.lookups.CBGMTimePeriod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.CBGMTimePeriod.class, engine.getFormName().getID(), ims.core.vo.lookups.CBGMTimePeriod.TYPE_ID));
	}
	protected final void oncmbVisualRightValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbVisualRight().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSSnellen existingInstance = (ims.core.vo.lookups.VSSnellen)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVisualRightLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSSnellen)
		{
			ims.core.vo.lookups.VSSnellen instance = (ims.core.vo.lookups.VSSnellen)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVisualRightLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSSnellen existingInstance = (ims.core.vo.lookups.VSSnellen)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbVisualRight().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVisualRightLookup()
	{
		this.form.cmbVisualRight().clear();
		ims.core.vo.lookups.VSSnellenCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSSnellen(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbVisualRight().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVisualRightLookupValue(int id)
	{
		ims.core.vo.lookups.VSSnellen instance = ims.core.vo.lookups.LookupHelper.getVSSnellenInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbVisualRight().setValue(instance);
	}
	protected final void defaultcmbVisualRightLookupValue()
	{
		this.form.cmbVisualRight().setValue((ims.core.vo.lookups.VSSnellen)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSSnellen.class, engine.getFormName().getID(), ims.core.vo.lookups.VSSnellen.TYPE_ID));
	}
	protected final void oncmbRightReactionPupilValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbRightReactionPupil().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRightReactionPupilLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSPupilReaction)
		{
			ims.core.vo.lookups.VSPupilReaction instance = (ims.core.vo.lookups.VSPupilReaction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRightReactionPupilLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbRightReactionPupil().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRightReactionPupilLookup()
	{
		this.form.cmbRightReactionPupil().clear();
		ims.core.vo.lookups.VSPupilReactionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSPupilReaction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbRightReactionPupil().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRightReactionPupilLookupValue(int id)
	{
		ims.core.vo.lookups.VSPupilReaction instance = ims.core.vo.lookups.LookupHelper.getVSPupilReactionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbRightReactionPupil().setValue(instance);
	}
	protected final void defaultcmbRightReactionPupilLookupValue()
	{
		this.form.cmbRightReactionPupil().setValue((ims.core.vo.lookups.VSPupilReaction)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSPupilReaction.class, engine.getFormName().getID(), ims.core.vo.lookups.VSPupilReaction.TYPE_ID));
	}
	protected final void oncmbVisualLeftValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbVisualLeft().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSSnellen existingInstance = (ims.core.vo.lookups.VSSnellen)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVisualLeftLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSSnellen)
		{
			ims.core.vo.lookups.VSSnellen instance = (ims.core.vo.lookups.VSSnellen)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVisualLeftLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSSnellen existingInstance = (ims.core.vo.lookups.VSSnellen)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbVisualLeft().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVisualLeftLookup()
	{
		this.form.cmbVisualLeft().clear();
		ims.core.vo.lookups.VSSnellenCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSSnellen(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbVisualLeft().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVisualLeftLookupValue(int id)
	{
		ims.core.vo.lookups.VSSnellen instance = ims.core.vo.lookups.LookupHelper.getVSSnellenInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbVisualLeft().setValue(instance);
	}
	protected final void defaultcmbVisualLeftLookupValue()
	{
		this.form.cmbVisualLeft().setValue((ims.core.vo.lookups.VSSnellen)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSSnellen.class, engine.getFormName().getID(), ims.core.vo.lookups.VSSnellen.TYPE_ID));
	}
	protected final void oncmbLeftReactionPupilValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbLeftReactionPupil().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLeftReactionPupilLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSPupilReaction)
		{
			ims.core.vo.lookups.VSPupilReaction instance = (ims.core.vo.lookups.VSPupilReaction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLeftReactionPupilLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbLeftReactionPupil().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLeftReactionPupilLookup()
	{
		this.form.cmbLeftReactionPupil().clear();
		ims.core.vo.lookups.VSPupilReactionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSPupilReaction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbLeftReactionPupil().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLeftReactionPupilLookupValue(int id)
	{
		ims.core.vo.lookups.VSPupilReaction instance = ims.core.vo.lookups.LookupHelper.getVSPupilReactionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbLeftReactionPupil().setValue(instance);
	}
	protected final void defaultcmbLeftReactionPupilLookupValue()
	{
		this.form.cmbLeftReactionPupil().setValue((ims.core.vo.lookups.VSPupilReaction)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSPupilReaction.class, engine.getFormName().getID(), ims.core.vo.lookups.VSPupilReaction.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.VitalSignsAll domain;
}
