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

package ims.emergency.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceForEventHistoryVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<EmergencyAttendanceForEventHistoryVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EmergencyAttendanceForEventHistoryVo> col = new ArrayList<EmergencyAttendanceForEventHistoryVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.domain.objects.EmergencyAttendance";
	}
	public boolean add(EmergencyAttendanceForEventHistoryVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EmergencyAttendanceForEventHistoryVo value)
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
	public int indexOf(EmergencyAttendanceForEventHistoryVo instance)
	{
		return col.indexOf(instance);
	}
	public EmergencyAttendanceForEventHistoryVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EmergencyAttendanceForEventHistoryVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EmergencyAttendanceForEventHistoryVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EmergencyAttendanceForEventHistoryVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EmergencyAttendanceForEventHistoryVoCollection clone = new EmergencyAttendanceForEventHistoryVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EmergencyAttendanceForEventHistoryVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public EmergencyAttendanceForEventHistoryVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EmergencyAttendanceForEventHistoryVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public EmergencyAttendanceForEventHistoryVoCollection sort(SortOrder order)
	{
		return sort(new EmergencyAttendanceForEventHistoryVoComparator(order));
	}
	public EmergencyAttendanceForEventHistoryVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new EmergencyAttendanceForEventHistoryVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public EmergencyAttendanceForEventHistoryVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.vo.EmergencyAttendanceRefVoCollection toRefVoCollection()
	{
		ims.core.admin.vo.EmergencyAttendanceRefVoCollection result = new ims.core.admin.vo.EmergencyAttendanceRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public EmergencyAttendanceForEventHistoryVo[] toArray()
	{
		EmergencyAttendanceForEventHistoryVo[] arr = new EmergencyAttendanceForEventHistoryVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<EmergencyAttendanceForEventHistoryVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EmergencyAttendanceForEventHistoryVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public EmergencyAttendanceForEventHistoryVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EmergencyAttendanceForEventHistoryVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public EmergencyAttendanceForEventHistoryVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			EmergencyAttendanceForEventHistoryVo voObj1 = (EmergencyAttendanceForEventHistoryVo)obj1;
			EmergencyAttendanceForEventHistoryVo voObj2 = (EmergencyAttendanceForEventHistoryVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean[] getBeanCollectionArray()
	{
		ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean[] result = new ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			EmergencyAttendanceForEventHistoryVo vo = ((EmergencyAttendanceForEventHistoryVo)col.get(i));
			result[i] = (ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean)vo.getBean();
		}
		return result;
	}
	public static EmergencyAttendanceForEventHistoryVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		EmergencyAttendanceForEventHistoryVoCollection coll = new EmergencyAttendanceForEventHistoryVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static EmergencyAttendanceForEventHistoryVoCollection buildFromBeanCollection(ims.emergency.vo.beans.EmergencyAttendanceForEventHistoryVoBean[] beans)
	{
		EmergencyAttendanceForEventHistoryVoCollection coll = new EmergencyAttendanceForEventHistoryVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
