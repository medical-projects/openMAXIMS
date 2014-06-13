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

package ims.nursing.forms.careplanoverview;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.CarePlanOverview.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.CarePlanOverview domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncbFilterValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cbFilter().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.CarePlanStatus existingInstance = (ims.nursing.vo.lookups.CarePlanStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcbFilterLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.CarePlanStatus)
		{
			ims.nursing.vo.lookups.CarePlanStatus instance = (ims.nursing.vo.lookups.CarePlanStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcbFilterLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.CarePlanStatus existingInstance = (ims.nursing.vo.lookups.CarePlanStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cbFilter().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcbFilterLookup()
	{
		this.form.cbFilter().clear();
		ims.nursing.vo.lookups.CarePlanStatusCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getCarePlanStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cbFilter().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcbFilterLookupValue(int id)
	{
		ims.nursing.vo.lookups.CarePlanStatus instance = ims.nursing.vo.lookups.LookupHelper.getCarePlanStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cbFilter().setValue(instance);
	}
	protected final void defaultcbFilterLookupValue()
	{
		this.form.cbFilter().setValue((ims.nursing.vo.lookups.CarePlanStatus)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.CarePlanStatus.class, engine.getFormName().getID(), ims.nursing.vo.lookups.CarePlanStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.CarePlanOverview domain;
}
