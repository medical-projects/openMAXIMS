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

package ims.core.forms.charttypelist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getLastNameSelectedIsNotNull()
		{
			return !cx_CoreLastNameSelected.getValueIsNull(context);
		}
		public String getLastNameSelected()
		{
			return (String)cx_CoreLastNameSelected.getValue(context);
		}
		public void setLastNameSelected(String value)
		{
			cx_CoreLastNameSelected.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreLastNameSelected = new ims.framework.ContextVariable("Core.LastNameSelected", "_cv_Core.LastNameSelected");
		public boolean getChartTypeRecordIsNotNull()
		{
			return !cx_CoreChartTypeRecord.getValueIsNull(context);
		}
		public ims.core.vo.ChartTypeShortVo getChartTypeRecord()
		{
			return (ims.core.vo.ChartTypeShortVo)cx_CoreChartTypeRecord.getValue(context);
		}
		public void setChartTypeRecord(ims.core.vo.ChartTypeShortVo value)
		{
			cx_CoreChartTypeRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreChartTypeRecord = new ims.framework.ContextVariable("Core.ChartTypeRecord", "_cv_Core.ChartTypeRecord");
		public boolean getDataSetRecordIsNotNull()
		{
			return !cx_CoreDataSetRecord.getValueIsNull(context);
		}
		public ims.core.vo.DataSetTypeVo getDataSetRecord()
		{
			return (ims.core.vo.DataSetTypeVo)cx_CoreDataSetRecord.getValue(context);
		}
		public void setDataSetRecord(ims.core.vo.DataSetTypeVo value)
		{
			cx_CoreDataSetRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreDataSetRecord = new ims.framework.ContextVariable("Core.DataSetRecord", "_cv_Core.DataSetRecord");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
