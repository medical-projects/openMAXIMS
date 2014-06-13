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

package ims.icp.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to ICPs.Configuration.ICPAction business object (ID: 1060100008).
 */
public class ICPActionShortVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ICPActionShortVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ICPActionShortVo> col = new ArrayList<ICPActionShortVo>();
	public String getBoClassName()
	{
		return "ims.icps.configuration.domain.objects.ICPAction";
	}
	public boolean add(ICPActionShortVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ICPActionShortVo value)
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
	public int indexOf(ICPActionShortVo instance)
	{
		return col.indexOf(instance);
	}
	public ICPActionShortVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ICPActionShortVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ICPActionShortVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ICPActionShortVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ICPActionShortVoCollection clone = new ICPActionShortVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ICPActionShortVo)this.col.get(x).clone());
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
	public ICPActionShortVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ICPActionShortVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ICPActionShortVoCollection sort(SortOrder order)
	{
		return sort(new ICPActionShortVoComparator(order));
	}
	public ICPActionShortVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ICPActionShortVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ICPActionShortVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.icps.configuration.vo.ICPActionRefVoCollection toRefVoCollection()
	{
		ims.icps.configuration.vo.ICPActionRefVoCollection result = new ims.icps.configuration.vo.ICPActionRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ICPActionShortVo[] toArray()
	{
		ICPActionShortVo[] arr = new ICPActionShortVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ICPActionShortVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ICPActionShortVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ICPActionShortVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ICPActionShortVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ICPActionShortVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ICPActionShortVo voObj1 = (ICPActionShortVo)obj1;
			ICPActionShortVo voObj2 = (ICPActionShortVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.icp.vo.beans.ICPActionShortVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.icp.vo.beans.ICPActionShortVoBean[] getBeanCollectionArray()
	{
		ims.icp.vo.beans.ICPActionShortVoBean[] result = new ims.icp.vo.beans.ICPActionShortVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ICPActionShortVo vo = ((ICPActionShortVo)col.get(i));
			result[i] = (ims.icp.vo.beans.ICPActionShortVoBean)vo.getBean();
		}
		return result;
	}
	public static ICPActionShortVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ICPActionShortVoCollection coll = new ICPActionShortVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.icp.vo.beans.ICPActionShortVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ICPActionShortVoCollection buildFromBeanCollection(ims.icp.vo.beans.ICPActionShortVoBean[] beans)
	{
		ICPActionShortVoCollection coll = new ICPActionShortVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
