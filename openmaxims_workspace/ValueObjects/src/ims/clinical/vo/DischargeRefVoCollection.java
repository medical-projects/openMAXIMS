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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to clinical.Discharge business object (ID: 1017100000).
 */
public class DischargeRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<DischargeRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<DischargeRefVo> col = new ArrayList<DischargeRefVo>();
	public final String getBoClassName()
	{
		return "ims.clinical.domain.objects.Discharge";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(DischargeRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, DischargeRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(DischargeRefVo instance)
	{
		return col.indexOf(instance);
	}
	public DischargeRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, DischargeRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(DischargeRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(DischargeRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		DischargeRefVoCollection clone = new DischargeRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((DischargeRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public DischargeRefVo[] toArray()
	{
		DischargeRefVo[] arr = new DischargeRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public DischargeRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public DischargeRefVoCollection sort(SortOrder order)
	{
		return sort(new DischargeRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public DischargeRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<DischargeRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class DischargeRefVoComparator implements Comparator
	{
		private int direction = 1;
		public DischargeRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public DischargeRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			DischargeRefVo voObj1 = (DischargeRefVo)obj1;
			DischargeRefVo voObj2 = (DischargeRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
