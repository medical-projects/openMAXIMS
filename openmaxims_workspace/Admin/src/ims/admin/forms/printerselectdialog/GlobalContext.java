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

package ims.admin.forms.printerselectdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

	}
	public boolean getPrintersSelectedIsNotNull()
	{
		return !cx_PrintersSelected.getValueIsNull(context);
	}
	public ims.admin.vo.PrinterVoCollection getPrintersSelected()
	{
		return (ims.admin.vo.PrinterVoCollection)cx_PrintersSelected.getValue(context);
	}
		public void setPrintersSelected(ims.admin.vo.PrinterVoCollection value)
		{
		cx_PrintersSelected.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PrintersSelected = new ims.framework.ContextVariable("PrintersSelected", "_cv_PrintersSelected");
	public boolean getDefaultPrinterIsNotNull()
	{
		return !cx_DefaultPrinter.getValueIsNull(context);
	}
	public ims.framework.interfaces.IPrinter getDefaultPrinter()
	{
		return (ims.framework.interfaces.IPrinter)cx_DefaultPrinter.getValue(context);
	}
		public void setDefaultPrinter(ims.framework.interfaces.IPrinter value)
		{
		cx_DefaultPrinter.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_DefaultPrinter = new ims.framework.ContextVariable("DefaultPrinter", "_cv_DefaultPrinter");
	public boolean getDesignatedPrinterForNewResultsIsNotNull()
	{
		return !cx_DesignatedPrinterForNewResults.getValueIsNull(context);
	}
	public ims.framework.interfaces.IPrinter getDesignatedPrinterForNewResults()
	{
		return (ims.framework.interfaces.IPrinter)cx_DesignatedPrinterForNewResults.getValue(context);
	}
		public void setDesignatedPrinterForNewResults(ims.framework.interfaces.IPrinter value)
		{
		cx_DesignatedPrinterForNewResults.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_DesignatedPrinterForNewResults = new ims.framework.ContextVariable("DesignatedPrinterForNewResults", "_cv_DesignatedPrinterForNewResults");
	public boolean getCurrentLocationIDIsNotNull()
	{
		return !cx_CurrentLocationID.getValueIsNull(context);
	}
	public Integer getCurrentLocationID()
	{
		return (Integer)cx_CurrentLocationID.getValue(context);
	}
		public void setCurrentLocationID(Integer value)
		{
		cx_CurrentLocationID.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_CurrentLocationID = new ims.framework.ContextVariable("CurrentLocationID", "_cv_CurrentLocationID");
	public boolean getDesignatedPrinterForOCSOrderIsNotNull()
	{
		return !cx_DesignatedPrinterForOCSOrder.getValueIsNull(context);
	}
	public ims.framework.interfaces.IPrinter getDesignatedPrinterForOCSOrder()
	{
		return (ims.framework.interfaces.IPrinter)cx_DesignatedPrinterForOCSOrder.getValue(context);
	}
		public void setDesignatedPrinterForOCSOrder(ims.framework.interfaces.IPrinter value)
		{
		cx_DesignatedPrinterForOCSOrder.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_DesignatedPrinterForOCSOrder = new ims.framework.ContextVariable("DesignatedPrinterForOCSOrder", "_cv_DesignatedPrinterForOCSOrder");

}
