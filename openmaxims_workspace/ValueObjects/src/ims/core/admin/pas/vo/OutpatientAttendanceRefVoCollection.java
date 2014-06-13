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

package ims.core.admin.pas.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.pas.Outpatient Attendance business object (ID: 1014100001).
 */
public class OutpatientAttendanceRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<OutpatientAttendanceRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OutpatientAttendanceRefVo> col = new ArrayList<OutpatientAttendanceRefVo>();
	public final String getBoClassName()
	{
		return "ims.core.admin.pas.domain.objects.OutpatientAttendance";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(OutpatientAttendanceRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OutpatientAttendanceRefVo value)
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
	public int indexOf(OutpatientAttendanceRefVo instance)
	{
		return col.indexOf(instance);
	}
	public OutpatientAttendanceRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OutpatientAttendanceRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OutpatientAttendanceRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OutpatientAttendanceRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OutpatientAttendanceRefVoCollection clone = new OutpatientAttendanceRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OutpatientAttendanceRefVo)this.col.get(x).clone());
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
	public OutpatientAttendanceRefVo[] toArray()
	{
		OutpatientAttendanceRefVo[] arr = new OutpatientAttendanceRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public OutpatientAttendanceRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OutpatientAttendanceRefVoCollection sort(SortOrder order)
	{
		return sort(new OutpatientAttendanceRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public OutpatientAttendanceRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<OutpatientAttendanceRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OutpatientAttendanceRefVoComparator implements Comparator
	{
		private int direction = 1;
		public OutpatientAttendanceRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OutpatientAttendanceRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			OutpatientAttendanceRefVo voObj1 = (OutpatientAttendanceRefVo)obj1;
			OutpatientAttendanceRefVo voObj2 = (OutpatientAttendanceRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
