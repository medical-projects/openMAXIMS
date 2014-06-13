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

package ims.clinicaladmin.forms.tumouroverallprognostic;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinicaladmin.domain.TumourOverallPrognostic.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinicaladmin.domain.TumourOverallPrognostic domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbOverallValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOverall().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.PrognosticGroup existingInstance = (ims.oncology.vo.lookups.PrognosticGroup)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOverallLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.PrognosticGroup)
		{
			ims.oncology.vo.lookups.PrognosticGroup instance = (ims.oncology.vo.lookups.PrognosticGroup)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOverallLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.PrognosticGroup existingInstance = (ims.oncology.vo.lookups.PrognosticGroup)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOverall().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOverallLookup()
	{
		this.form.cmbOverall().clear();
		ims.oncology.vo.lookups.PrognosticGroupCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getPrognosticGroup(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOverall().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOverallLookupValue(int id)
	{
		ims.oncology.vo.lookups.PrognosticGroup instance = ims.oncology.vo.lookups.LookupHelper.getPrognosticGroupInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOverall().setValue(instance);
	}
	protected final void defaultcmbOverallLookupValue()
	{
		this.form.cmbOverall().setValue((ims.oncology.vo.lookups.PrognosticGroup)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.PrognosticGroup.class, engine.getFormName().getID(), ims.oncology.vo.lookups.PrognosticGroup.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinicaladmin.domain.TumourOverallPrognostic domain;
}
