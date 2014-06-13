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

package ims.generalmedical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to medical.OPDErectDysfxn business object (ID: 1031100008).
 */
public class OPDErectDysfxnVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<OPDErectDysfxnVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OPDErectDysfxnVo> col = new ArrayList<OPDErectDysfxnVo>();
	public String getBoClassName()
	{
		return "ims.medical.domain.objects.OPDErectDysfxn";
	}
	public boolean add(OPDErectDysfxnVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OPDErectDysfxnVo value)
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
	public int indexOf(OPDErectDysfxnVo instance)
	{
		return col.indexOf(instance);
	}
	public OPDErectDysfxnVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OPDErectDysfxnVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OPDErectDysfxnVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OPDErectDysfxnVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OPDErectDysfxnVoCollection clone = new OPDErectDysfxnVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OPDErectDysfxnVo)this.col.get(x).clone());
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
	public OPDErectDysfxnVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OPDErectDysfxnVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public OPDErectDysfxnVoCollection sort(SortOrder order)
	{
		return sort(new OPDErectDysfxnVoComparator(order));
	}
	public OPDErectDysfxnVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new OPDErectDysfxnVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public OPDErectDysfxnVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.medical.vo.OPDErectDysfxnRefVoCollection toRefVoCollection()
	{
		ims.medical.vo.OPDErectDysfxnRefVoCollection result = new ims.medical.vo.OPDErectDysfxnRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public OPDErectDysfxnVo[] toArray()
	{
		OPDErectDysfxnVo[] arr = new OPDErectDysfxnVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<OPDErectDysfxnVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OPDErectDysfxnVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public OPDErectDysfxnVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OPDErectDysfxnVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public OPDErectDysfxnVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			OPDErectDysfxnVo voObj1 = (OPDErectDysfxnVo)obj1;
			OPDErectDysfxnVo voObj2 = (OPDErectDysfxnVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.generalmedical.vo.beans.OPDErectDysfxnVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.generalmedical.vo.beans.OPDErectDysfxnVoBean[] getBeanCollectionArray()
	{
		ims.generalmedical.vo.beans.OPDErectDysfxnVoBean[] result = new ims.generalmedical.vo.beans.OPDErectDysfxnVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			OPDErectDysfxnVo vo = ((OPDErectDysfxnVo)col.get(i));
			result[i] = (ims.generalmedical.vo.beans.OPDErectDysfxnVoBean)vo.getBean();
		}
		return result;
	}
	public static OPDErectDysfxnVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		OPDErectDysfxnVoCollection coll = new OPDErectDysfxnVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.generalmedical.vo.beans.OPDErectDysfxnVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static OPDErectDysfxnVoCollection buildFromBeanCollection(ims.generalmedical.vo.beans.OPDErectDysfxnVoBean[] beans)
	{
		OPDErectDysfxnVoCollection coll = new OPDErectDysfxnVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
