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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Sch_Profile business object (ID: 1005100001).
 */
public class Sch_ProfileRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<Sch_ProfileRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Sch_ProfileRefVo> col = new ArrayList<Sch_ProfileRefVo>();
	public final String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Sch_Profile";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(Sch_ProfileRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Sch_ProfileRefVo value)
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
	public int indexOf(Sch_ProfileRefVo instance)
	{
		return col.indexOf(instance);
	}
	public Sch_ProfileRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Sch_ProfileRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Sch_ProfileRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Sch_ProfileRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Sch_ProfileRefVoCollection clone = new Sch_ProfileRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Sch_ProfileRefVo)this.col.get(x).clone());
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
	public Sch_ProfileRefVo[] toArray()
	{
		Sch_ProfileRefVo[] arr = new Sch_ProfileRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Sch_ProfileRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Sch_ProfileRefVoCollection sort(SortOrder order)
	{
		return sort(new Sch_ProfileRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public Sch_ProfileRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<Sch_ProfileRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Sch_ProfileRefVoComparator implements Comparator
	{
		private int direction = 1;
		public Sch_ProfileRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Sch_ProfileRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			Sch_ProfileRefVo voObj1 = (Sch_ProfileRefVo)obj1;
			Sch_ProfileRefVo voObj2 = (Sch_ProfileRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
