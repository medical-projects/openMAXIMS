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

package ims.careuk.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to CAREUK.ConsultationTime business object (ID: 1096100006).
 */
public class ConsultationTimeRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<ConsultationTimeRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ConsultationTimeRefVo> col = new ArrayList<ConsultationTimeRefVo>();
	public final String getBoClassName()
	{
		return "ims.careuk.domain.objects.ConsultationTime";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(ConsultationTimeRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ConsultationTimeRefVo value)
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
	public int indexOf(ConsultationTimeRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ConsultationTimeRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ConsultationTimeRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ConsultationTimeRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ConsultationTimeRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ConsultationTimeRefVoCollection clone = new ConsultationTimeRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ConsultationTimeRefVo)this.col.get(x).clone());
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
	public ConsultationTimeRefVo[] toArray()
	{
		ConsultationTimeRefVo[] arr = new ConsultationTimeRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ConsultationTimeRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ConsultationTimeRefVoCollection sort(SortOrder order)
	{
		return sort(new ConsultationTimeRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public ConsultationTimeRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<ConsultationTimeRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ConsultationTimeRefVoComparator implements Comparator
	{
		private int direction = 1;
		public ConsultationTimeRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ConsultationTimeRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ConsultationTimeRefVo voObj1 = (ConsultationTimeRefVo)obj1;
			ConsultationTimeRefVo voObj2 = (ConsultationTimeRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
