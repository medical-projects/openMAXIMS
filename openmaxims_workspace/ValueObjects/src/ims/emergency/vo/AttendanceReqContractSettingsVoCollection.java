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

package ims.emergency.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to emergency.Configuration.AttendanceReqContractSettings business object (ID: 1087100017).
 */
public class AttendanceReqContractSettingsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<AttendanceReqContractSettingsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<AttendanceReqContractSettingsVo> col = new ArrayList<AttendanceReqContractSettingsVo>();
	public String getBoClassName()
	{
		return "ims.emergency.configuration.domain.objects.AttendanceReqContractSettings";
	}
	public boolean add(AttendanceReqContractSettingsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, AttendanceReqContractSettingsVo value)
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
	public int indexOf(AttendanceReqContractSettingsVo instance)
	{
		return col.indexOf(instance);
	}
	public AttendanceReqContractSettingsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, AttendanceReqContractSettingsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(AttendanceReqContractSettingsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(AttendanceReqContractSettingsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		AttendanceReqContractSettingsVoCollection clone = new AttendanceReqContractSettingsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((AttendanceReqContractSettingsVo)this.col.get(x).clone());
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
	public AttendanceReqContractSettingsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public AttendanceReqContractSettingsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public AttendanceReqContractSettingsVoCollection sort(SortOrder order)
	{
		return sort(new AttendanceReqContractSettingsVoComparator(order));
	}
	public AttendanceReqContractSettingsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new AttendanceReqContractSettingsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public AttendanceReqContractSettingsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.emergency.configuration.vo.AttendanceReqContractSettingsRefVoCollection toRefVoCollection()
	{
		ims.emergency.configuration.vo.AttendanceReqContractSettingsRefVoCollection result = new ims.emergency.configuration.vo.AttendanceReqContractSettingsRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public AttendanceReqContractSettingsVo[] toArray()
	{
		AttendanceReqContractSettingsVo[] arr = new AttendanceReqContractSettingsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<AttendanceReqContractSettingsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class AttendanceReqContractSettingsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public AttendanceReqContractSettingsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public AttendanceReqContractSettingsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public AttendanceReqContractSettingsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			AttendanceReqContractSettingsVo voObj1 = (AttendanceReqContractSettingsVo)obj1;
			AttendanceReqContractSettingsVo voObj2 = (AttendanceReqContractSettingsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean[] getBeanCollectionArray()
	{
		ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean[] result = new ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			AttendanceReqContractSettingsVo vo = ((AttendanceReqContractSettingsVo)col.get(i));
			result[i] = (ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean)vo.getBean();
		}
		return result;
	}
	public static AttendanceReqContractSettingsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		AttendanceReqContractSettingsVoCollection coll = new AttendanceReqContractSettingsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static AttendanceReqContractSettingsVoCollection buildFromBeanCollection(ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean[] beans)
	{
		AttendanceReqContractSettingsVoCollection coll = new AttendanceReqContractSettingsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
