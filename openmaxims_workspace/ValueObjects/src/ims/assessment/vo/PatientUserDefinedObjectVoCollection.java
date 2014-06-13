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

package ims.assessment.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Assessment.Instantiation.PatientUserDefinedObject business object (ID: 1085100000).
 */
public class PatientUserDefinedObjectVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientUserDefinedObjectVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientUserDefinedObjectVo> col = new ArrayList<PatientUserDefinedObjectVo>();
	public String getBoClassName()
	{
		return "ims.assessment.instantiation.domain.objects.PatientUserDefinedObject";
	}
	public boolean add(PatientUserDefinedObjectVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientUserDefinedObjectVo value)
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
	public int indexOf(PatientUserDefinedObjectVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientUserDefinedObjectVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientUserDefinedObjectVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientUserDefinedObjectVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientUserDefinedObjectVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientUserDefinedObjectVoCollection clone = new PatientUserDefinedObjectVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientUserDefinedObjectVo)this.col.get(x).clone());
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
	public PatientUserDefinedObjectVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientUserDefinedObjectVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientUserDefinedObjectVoCollection sort(SortOrder order)
	{
		return sort(new PatientUserDefinedObjectVoComparator(order));
	}
	public PatientUserDefinedObjectVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientUserDefinedObjectVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientUserDefinedObjectVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVoCollection toRefVoCollection()
	{
		ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVoCollection result = new ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientUserDefinedObjectVo[] toArray()
	{
		PatientUserDefinedObjectVo[] arr = new PatientUserDefinedObjectVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientUserDefinedObjectVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientUserDefinedObjectVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientUserDefinedObjectVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientUserDefinedObjectVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientUserDefinedObjectVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientUserDefinedObjectVo voObj1 = (PatientUserDefinedObjectVo)obj1;
			PatientUserDefinedObjectVo voObj2 = (PatientUserDefinedObjectVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.assessment.vo.beans.PatientUserDefinedObjectVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.assessment.vo.beans.PatientUserDefinedObjectVoBean[] getBeanCollectionArray()
	{
		ims.assessment.vo.beans.PatientUserDefinedObjectVoBean[] result = new ims.assessment.vo.beans.PatientUserDefinedObjectVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientUserDefinedObjectVo vo = ((PatientUserDefinedObjectVo)col.get(i));
			result[i] = (ims.assessment.vo.beans.PatientUserDefinedObjectVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientUserDefinedObjectVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientUserDefinedObjectVoCollection coll = new PatientUserDefinedObjectVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.assessment.vo.beans.PatientUserDefinedObjectVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientUserDefinedObjectVoCollection buildFromBeanCollection(ims.assessment.vo.beans.PatientUserDefinedObjectVoBean[] beans)
	{
		PatientUserDefinedObjectVoCollection coll = new PatientUserDefinedObjectVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
