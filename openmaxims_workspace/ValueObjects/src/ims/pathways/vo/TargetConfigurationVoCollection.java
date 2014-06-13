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

package ims.pathways.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Pathways.Configuration.Target business object (ID: 1089100001).
 */
public class TargetConfigurationVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TargetConfigurationVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TargetConfigurationVo> col = new ArrayList<TargetConfigurationVo>();
	public String getBoClassName()
	{
		return "ims.pathways.configuration.domain.objects.Target";
	}
	public boolean add(TargetConfigurationVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TargetConfigurationVo value)
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
	public int indexOf(TargetConfigurationVo instance)
	{
		return col.indexOf(instance);
	}
	public TargetConfigurationVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TargetConfigurationVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TargetConfigurationVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TargetConfigurationVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TargetConfigurationVoCollection clone = new TargetConfigurationVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TargetConfigurationVo)this.col.get(x).clone());
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
	public TargetConfigurationVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TargetConfigurationVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TargetConfigurationVoCollection sort(SortOrder order)
	{
		return sort(new TargetConfigurationVoComparator(order));
	}
	public TargetConfigurationVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TargetConfigurationVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TargetConfigurationVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.pathways.configuration.vo.TargetRefVoCollection toRefVoCollection()
	{
		ims.pathways.configuration.vo.TargetRefVoCollection result = new ims.pathways.configuration.vo.TargetRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TargetConfigurationVo[] toArray()
	{
		TargetConfigurationVo[] arr = new TargetConfigurationVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TargetConfigurationVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TargetConfigurationVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TargetConfigurationVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TargetConfigurationVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TargetConfigurationVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TargetConfigurationVo voObj1 = (TargetConfigurationVo)obj1;
			TargetConfigurationVo voObj2 = (TargetConfigurationVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.pathways.vo.beans.TargetConfigurationVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.pathways.vo.beans.TargetConfigurationVoBean[] getBeanCollectionArray()
	{
		ims.pathways.vo.beans.TargetConfigurationVoBean[] result = new ims.pathways.vo.beans.TargetConfigurationVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TargetConfigurationVo vo = ((TargetConfigurationVo)col.get(i));
			result[i] = (ims.pathways.vo.beans.TargetConfigurationVoBean)vo.getBean();
		}
		return result;
	}
	public static TargetConfigurationVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TargetConfigurationVoCollection coll = new TargetConfigurationVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.pathways.vo.beans.TargetConfigurationVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TargetConfigurationVoCollection buildFromBeanCollection(ims.pathways.vo.beans.TargetConfigurationVoBean[] beans)
	{
		TargetConfigurationVoCollection coll = new TargetConfigurationVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
