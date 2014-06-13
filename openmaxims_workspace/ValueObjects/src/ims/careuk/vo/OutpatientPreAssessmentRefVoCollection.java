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

package ims.careuk.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to CAREUK.OutpatientPreAssessment business object (ID: 1096100027).
 */
public class OutpatientPreAssessmentRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<OutpatientPreAssessmentRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OutpatientPreAssessmentRefVo> col = new ArrayList<OutpatientPreAssessmentRefVo>();
	public final String getBoClassName()
	{
		return "ims.careuk.domain.objects.OutpatientPreAssessment";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(OutpatientPreAssessmentRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OutpatientPreAssessmentRefVo value)
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
	public int indexOf(OutpatientPreAssessmentRefVo instance)
	{
		return col.indexOf(instance);
	}
	public OutpatientPreAssessmentRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OutpatientPreAssessmentRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OutpatientPreAssessmentRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OutpatientPreAssessmentRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OutpatientPreAssessmentRefVoCollection clone = new OutpatientPreAssessmentRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OutpatientPreAssessmentRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public OutpatientPreAssessmentRefVo[] toArray()
	{
		OutpatientPreAssessmentRefVo[] arr = new OutpatientPreAssessmentRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public OutpatientPreAssessmentRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OutpatientPreAssessmentRefVoCollection sort(SortOrder order)
	{
		return sort(new OutpatientPreAssessmentRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public OutpatientPreAssessmentRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<OutpatientPreAssessmentRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OutpatientPreAssessmentRefVoComparator implements Comparator
	{
		private int direction = 1;
		public OutpatientPreAssessmentRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OutpatientPreAssessmentRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			OutpatientPreAssessmentRefVo voObj1 = (OutpatientPreAssessmentRefVo)obj1;
			OutpatientPreAssessmentRefVo voObj2 = (OutpatientPreAssessmentRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
