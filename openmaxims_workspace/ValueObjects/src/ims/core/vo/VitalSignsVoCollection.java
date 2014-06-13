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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.vitals.VitalSigns business object (ID: 1022100004).
 */
public class VitalSignsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<VitalSignsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<VitalSignsVo> col = new ArrayList<VitalSignsVo>();
	public String getBoClassName()
	{
		return "ims.core.vitals.domain.objects.VitalSigns";
	}
	public boolean add(VitalSignsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, VitalSignsVo value)
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
	public int indexOf(VitalSignsVo instance)
	{
		return col.indexOf(instance);
	}
	public VitalSignsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, VitalSignsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(VitalSignsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(VitalSignsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		VitalSignsVoCollection clone = new VitalSignsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((VitalSignsVo)this.col.get(x).clone());
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
	public VitalSignsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public VitalSignsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public VitalSignsVoCollection sort(SortOrder order)
	{
		return sort(new VitalSignsVoComparator(order));
	}
	public VitalSignsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new VitalSignsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public VitalSignsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.vitals.vo.VitalSignsRefVoCollection toRefVoCollection()
	{
		ims.core.vitals.vo.VitalSignsRefVoCollection result = new ims.core.vitals.vo.VitalSignsRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public VitalSignsVo[] toArray()
	{
		VitalSignsVo[] arr = new VitalSignsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<VitalSignsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class VitalSignsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public VitalSignsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public VitalSignsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public VitalSignsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			VitalSignsVo voObj1 = (VitalSignsVo)obj1;
			VitalSignsVo voObj2 = (VitalSignsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.VitalSignsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.VitalSignsVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.VitalSignsVoBean[] result = new ims.core.vo.beans.VitalSignsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			VitalSignsVo vo = ((VitalSignsVo)col.get(i));
			result[i] = (ims.core.vo.beans.VitalSignsVoBean)vo.getBean();
		}
		return result;
	}
	public static VitalSignsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		VitalSignsVoCollection coll = new VitalSignsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.VitalSignsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static VitalSignsVoCollection buildFromBeanCollection(ims.core.vo.beans.VitalSignsVoBean[] beans)
	{
		VitalSignsVoCollection coll = new VitalSignsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
