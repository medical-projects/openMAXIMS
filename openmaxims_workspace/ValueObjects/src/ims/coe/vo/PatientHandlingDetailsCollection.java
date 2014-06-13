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

package ims.coe.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to coe.assessment tools.Patient MovementHandling Screening Details business object (ID: 1013100007).
 */
public class PatientHandlingDetailsCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientHandlingDetails>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientHandlingDetails> col = new ArrayList<PatientHandlingDetails>();
	public String getBoClassName()
	{
		return "ims.coe.assessmenttools.domain.objects.PatientMovementHandlingScreeningDetails";
	}
	public boolean add(PatientHandlingDetails value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientHandlingDetails value)
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
	public int indexOf(PatientHandlingDetails instance)
	{
		return col.indexOf(instance);
	}
	public PatientHandlingDetails get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientHandlingDetails value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientHandlingDetails instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientHandlingDetails instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientHandlingDetailsCollection clone = new PatientHandlingDetailsCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientHandlingDetails)this.col.get(x).clone());
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
	public PatientHandlingDetailsCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientHandlingDetailsCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientHandlingDetailsCollection sort(SortOrder order)
	{
		return sort(new PatientHandlingDetailsComparator(order));
	}
	public PatientHandlingDetailsCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientHandlingDetailsComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientHandlingDetailsCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.coe.assessmenttools.vo.PatientMovementHandlingScreeningDetailsRefVoCollection toRefVoCollection()
	{
		ims.coe.assessmenttools.vo.PatientMovementHandlingScreeningDetailsRefVoCollection result = new ims.coe.assessmenttools.vo.PatientMovementHandlingScreeningDetailsRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientHandlingDetails[] toArray()
	{
		PatientHandlingDetails[] arr = new PatientHandlingDetails[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientHandlingDetails> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientHandlingDetailsComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientHandlingDetailsComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientHandlingDetailsComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientHandlingDetailsComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientHandlingDetails voObj1 = (PatientHandlingDetails)obj1;
			PatientHandlingDetails voObj2 = (PatientHandlingDetails)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.coe.vo.beans.PatientHandlingDetailsBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.coe.vo.beans.PatientHandlingDetailsBean[] getBeanCollectionArray()
	{
		ims.coe.vo.beans.PatientHandlingDetailsBean[] result = new ims.coe.vo.beans.PatientHandlingDetailsBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientHandlingDetails vo = ((PatientHandlingDetails)col.get(i));
			result[i] = (ims.coe.vo.beans.PatientHandlingDetailsBean)vo.getBean();
		}
		return result;
	}
	public static PatientHandlingDetailsCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientHandlingDetailsCollection coll = new PatientHandlingDetailsCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.coe.vo.beans.PatientHandlingDetailsBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientHandlingDetailsCollection buildFromBeanCollection(ims.coe.vo.beans.PatientHandlingDetailsBean[] beans)
	{
		PatientHandlingDetailsCollection coll = new PatientHandlingDetailsCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
