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

package ims.ocrr.orderingresults.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.OrderingResults.OcsOrderSession business object (ID: 1070100000).
 */
public class OcsOrderSessionRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<OcsOrderSessionRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OcsOrderSessionRefVo> col = new ArrayList<OcsOrderSessionRefVo>();
	public final String getBoClassName()
	{
		return "ims.ocrr.orderingresults.domain.objects.OcsOrderSession";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(OcsOrderSessionRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OcsOrderSessionRefVo value)
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
	public int indexOf(OcsOrderSessionRefVo instance)
	{
		return col.indexOf(instance);
	}
	public OcsOrderSessionRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OcsOrderSessionRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OcsOrderSessionRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OcsOrderSessionRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OcsOrderSessionRefVoCollection clone = new OcsOrderSessionRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OcsOrderSessionRefVo)this.col.get(x).clone());
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
	public OcsOrderSessionRefVo[] toArray()
	{
		OcsOrderSessionRefVo[] arr = new OcsOrderSessionRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public OcsOrderSessionRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OcsOrderSessionRefVoCollection sort(SortOrder order)
	{
		return sort(new OcsOrderSessionRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public OcsOrderSessionRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<OcsOrderSessionRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OcsOrderSessionRefVoComparator implements Comparator
	{
		private int direction = 1;
		public OcsOrderSessionRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OcsOrderSessionRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			OcsOrderSessionRefVo voObj1 = (OcsOrderSessionRefVo)obj1;
			OcsOrderSessionRefVo voObj2 = (OcsOrderSessionRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}