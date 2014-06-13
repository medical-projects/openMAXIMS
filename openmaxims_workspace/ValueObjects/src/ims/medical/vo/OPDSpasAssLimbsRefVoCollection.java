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

package ims.medical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to medical.OPDSpasAssLimbs business object (ID: 1031100009).
 */
public class OPDSpasAssLimbsRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<OPDSpasAssLimbsRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OPDSpasAssLimbsRefVo> col = new ArrayList<OPDSpasAssLimbsRefVo>();
	public final String getBoClassName()
	{
		return "ims.medical.domain.objects.OPDSpasAssLimbs";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(OPDSpasAssLimbsRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OPDSpasAssLimbsRefVo value)
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
	public int indexOf(OPDSpasAssLimbsRefVo instance)
	{
		return col.indexOf(instance);
	}
	public OPDSpasAssLimbsRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OPDSpasAssLimbsRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OPDSpasAssLimbsRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OPDSpasAssLimbsRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OPDSpasAssLimbsRefVoCollection clone = new OPDSpasAssLimbsRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OPDSpasAssLimbsRefVo)this.col.get(x).clone());
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
	public OPDSpasAssLimbsRefVo[] toArray()
	{
		OPDSpasAssLimbsRefVo[] arr = new OPDSpasAssLimbsRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public OPDSpasAssLimbsRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OPDSpasAssLimbsRefVoCollection sort(SortOrder order)
	{
		return sort(new OPDSpasAssLimbsRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public OPDSpasAssLimbsRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<OPDSpasAssLimbsRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OPDSpasAssLimbsRefVoComparator implements Comparator
	{
		private int direction = 1;
		public OPDSpasAssLimbsRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OPDSpasAssLimbsRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			OPDSpasAssLimbsRefVo voObj1 = (OPDSpasAssLimbsRefVo)obj1;
			OPDSpasAssLimbsRefVo voObj2 = (OPDSpasAssLimbsRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
