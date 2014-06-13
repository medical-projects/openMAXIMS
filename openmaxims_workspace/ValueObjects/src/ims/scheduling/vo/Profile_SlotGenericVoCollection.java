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
 * Linked to Scheduling.Profile_Slot business object (ID: 1055100000).
 */
public class Profile_SlotGenericVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Profile_SlotGenericVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Profile_SlotGenericVo> col = new ArrayList<Profile_SlotGenericVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Profile_Slot";
	}
	public boolean add(Profile_SlotGenericVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Profile_SlotGenericVo value)
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
	public int indexOf(Profile_SlotGenericVo instance)
	{
		return col.indexOf(instance);
	}
	public Profile_SlotGenericVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Profile_SlotGenericVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Profile_SlotGenericVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Profile_SlotGenericVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Profile_SlotGenericVoCollection clone = new Profile_SlotGenericVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Profile_SlotGenericVo)this.col.get(x).clone());
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
	public Profile_SlotGenericVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Profile_SlotGenericVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Profile_SlotGenericVoCollection sort(SortOrder order)
	{
		return sort(new Profile_SlotGenericVoComparator(order));
	}
	public Profile_SlotGenericVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Profile_SlotGenericVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Profile_SlotGenericVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Profile_SlotRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Profile_SlotRefVoCollection result = new ims.scheduling.vo.Profile_SlotRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Profile_SlotGenericVo[] toArray()
	{
		Profile_SlotGenericVo[] arr = new Profile_SlotGenericVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Profile_SlotGenericVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Profile_SlotGenericVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Profile_SlotGenericVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Profile_SlotGenericVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Profile_SlotGenericVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Profile_SlotGenericVo voObj1 = (Profile_SlotGenericVo)obj1;
			Profile_SlotGenericVo voObj2 = (Profile_SlotGenericVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] result = new ims.scheduling.vo.beans.Profile_SlotGenericVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Profile_SlotGenericVo vo = ((Profile_SlotGenericVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.Profile_SlotGenericVoBean)vo.getBean();
		}
		return result;
	}
	public static Profile_SlotGenericVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Profile_SlotGenericVoCollection coll = new Profile_SlotGenericVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.Profile_SlotGenericVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Profile_SlotGenericVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] beans)
	{
		Profile_SlotGenericVoCollection coll = new Profile_SlotGenericVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
