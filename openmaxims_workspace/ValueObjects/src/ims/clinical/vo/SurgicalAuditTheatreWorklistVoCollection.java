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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to clinical.SurgicalAuditOperationDetail business object (ID: 1072100108).
 */
public class SurgicalAuditTheatreWorklistVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SurgicalAuditTheatreWorklistVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SurgicalAuditTheatreWorklistVo> col = new ArrayList<SurgicalAuditTheatreWorklistVo>();
	public String getBoClassName()
	{
		return "ims.clinical.domain.objects.SurgicalAuditOperationDetail";
	}
	public boolean add(SurgicalAuditTheatreWorklistVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SurgicalAuditTheatreWorklistVo value)
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
	public int indexOf(SurgicalAuditTheatreWorklistVo instance)
	{
		return col.indexOf(instance);
	}
	public SurgicalAuditTheatreWorklistVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SurgicalAuditTheatreWorklistVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SurgicalAuditTheatreWorklistVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SurgicalAuditTheatreWorklistVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SurgicalAuditTheatreWorklistVoCollection clone = new SurgicalAuditTheatreWorklistVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SurgicalAuditTheatreWorklistVo)this.col.get(x).clone());
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
	public SurgicalAuditTheatreWorklistVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SurgicalAuditTheatreWorklistVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SurgicalAuditTheatreWorklistVoCollection sort(SortOrder order)
	{
		return sort(new SurgicalAuditTheatreWorklistVoComparator(order));
	}
	public SurgicalAuditTheatreWorklistVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SurgicalAuditTheatreWorklistVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SurgicalAuditTheatreWorklistVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.clinical.vo.SurgicalAuditOperationDetailRefVoCollection toRefVoCollection()
	{
		ims.clinical.vo.SurgicalAuditOperationDetailRefVoCollection result = new ims.clinical.vo.SurgicalAuditOperationDetailRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SurgicalAuditTheatreWorklistVo[] toArray()
	{
		SurgicalAuditTheatreWorklistVo[] arr = new SurgicalAuditTheatreWorklistVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SurgicalAuditTheatreWorklistVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SurgicalAuditTheatreWorklistVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SurgicalAuditTheatreWorklistVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SurgicalAuditTheatreWorklistVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SurgicalAuditTheatreWorklistVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SurgicalAuditTheatreWorklistVo voObj1 = (SurgicalAuditTheatreWorklistVo)obj1;
			SurgicalAuditTheatreWorklistVo voObj2 = (SurgicalAuditTheatreWorklistVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean[] result = new ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SurgicalAuditTheatreWorklistVo vo = ((SurgicalAuditTheatreWorklistVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean)vo.getBean();
		}
		return result;
	}
	public static SurgicalAuditTheatreWorklistVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SurgicalAuditTheatreWorklistVoCollection coll = new SurgicalAuditTheatreWorklistVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SurgicalAuditTheatreWorklistVoCollection buildFromBeanCollection(ims.clinical.vo.beans.SurgicalAuditTheatreWorklistVoBean[] beans)
	{
		SurgicalAuditTheatreWorklistVoCollection coll = new SurgicalAuditTheatreWorklistVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
