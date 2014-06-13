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

package ims.dtomove.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to dto_move.Action business object (ID: 1105100008).
 */
public class ActionVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ActionVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ActionVo> col = new ArrayList<ActionVo>();
	public String getBoClassName()
	{
		return "ims.dto_move.domain.objects.Action";
	}
	public boolean add(ActionVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ActionVo value)
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
	public int indexOf(ActionVo instance)
	{
		return col.indexOf(instance);
	}
	public ActionVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ActionVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ActionVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ActionVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ActionVoCollection clone = new ActionVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ActionVo)this.col.get(x).clone());
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
	public ActionVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ActionVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ActionVoCollection sort(SortOrder order)
	{
		return sort(new ActionVoComparator(order));
	}
	public ActionVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ActionVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ActionVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.dto_move.vo.ActionRefVoCollection toRefVoCollection()
	{
		ims.dto_move.vo.ActionRefVoCollection result = new ims.dto_move.vo.ActionRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ActionVo[] toArray()
	{
		ActionVo[] arr = new ActionVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ActionVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ActionVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ActionVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ActionVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ActionVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ActionVo voObj1 = (ActionVo)obj1;
			ActionVo voObj2 = (ActionVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.dtomove.vo.beans.ActionVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.dtomove.vo.beans.ActionVoBean[] getBeanCollectionArray()
	{
		ims.dtomove.vo.beans.ActionVoBean[] result = new ims.dtomove.vo.beans.ActionVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ActionVo vo = ((ActionVo)col.get(i));
			result[i] = (ims.dtomove.vo.beans.ActionVoBean)vo.getBean();
		}
		return result;
	}
	public static ActionVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ActionVoCollection coll = new ActionVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.dtomove.vo.beans.ActionVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ActionVoCollection buildFromBeanCollection(ims.dtomove.vo.beans.ActionVoBean[] beans)
	{
		ActionVoCollection coll = new ActionVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
