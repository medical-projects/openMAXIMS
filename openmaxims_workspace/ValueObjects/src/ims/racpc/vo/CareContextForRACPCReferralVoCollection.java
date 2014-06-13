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

package ims.racpc.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.CareContext business object (ID: 1004100019).
 */
public class CareContextForRACPCReferralVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<CareContextForRACPCReferralVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CareContextForRACPCReferralVo> col = new ArrayList<CareContextForRACPCReferralVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.domain.objects.CareContext";
	}
	public boolean add(CareContextForRACPCReferralVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, CareContextForRACPCReferralVo value)
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
	public int indexOf(CareContextForRACPCReferralVo instance)
	{
		return col.indexOf(instance);
	}
	public CareContextForRACPCReferralVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, CareContextForRACPCReferralVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(CareContextForRACPCReferralVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(CareContextForRACPCReferralVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		CareContextForRACPCReferralVoCollection clone = new CareContextForRACPCReferralVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((CareContextForRACPCReferralVo)this.col.get(x).clone());
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
	public CareContextForRACPCReferralVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public CareContextForRACPCReferralVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public CareContextForRACPCReferralVoCollection sort(SortOrder order)
	{
		return sort(new CareContextForRACPCReferralVoComparator(order));
	}
	public CareContextForRACPCReferralVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new CareContextForRACPCReferralVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public CareContextForRACPCReferralVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.vo.CareContextRefVoCollection toRefVoCollection()
	{
		ims.core.admin.vo.CareContextRefVoCollection result = new ims.core.admin.vo.CareContextRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public CareContextForRACPCReferralVo[] toArray()
	{
		CareContextForRACPCReferralVo[] arr = new CareContextForRACPCReferralVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<CareContextForRACPCReferralVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class CareContextForRACPCReferralVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public CareContextForRACPCReferralVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public CareContextForRACPCReferralVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public CareContextForRACPCReferralVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			CareContextForRACPCReferralVo voObj1 = (CareContextForRACPCReferralVo)obj1;
			CareContextForRACPCReferralVo voObj2 = (CareContextForRACPCReferralVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.racpc.vo.beans.CareContextForRACPCReferralVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.racpc.vo.beans.CareContextForRACPCReferralVoBean[] getBeanCollectionArray()
	{
		ims.racpc.vo.beans.CareContextForRACPCReferralVoBean[] result = new ims.racpc.vo.beans.CareContextForRACPCReferralVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			CareContextForRACPCReferralVo vo = ((CareContextForRACPCReferralVo)col.get(i));
			result[i] = (ims.racpc.vo.beans.CareContextForRACPCReferralVoBean)vo.getBean();
		}
		return result;
	}
	public static CareContextForRACPCReferralVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		CareContextForRACPCReferralVoCollection coll = new CareContextForRACPCReferralVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.racpc.vo.beans.CareContextForRACPCReferralVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static CareContextForRACPCReferralVoCollection buildFromBeanCollection(ims.racpc.vo.beans.CareContextForRACPCReferralVoBean[] beans)
	{
		CareContextForRACPCReferralVoCollection coll = new CareContextForRACPCReferralVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
