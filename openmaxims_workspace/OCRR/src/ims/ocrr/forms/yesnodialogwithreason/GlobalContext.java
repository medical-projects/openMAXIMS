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

package ims.ocrr.forms.yesnodialogwithreason;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

			SelectAndOrder = new SelectAndOrderContext(context);
		}
		public final class SelectAndOrderContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SelectAndOrderContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getLaunchYesNoGenderDialogIsNotNull()
			{
				return !cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.getValueIsNull(context);
			}
			public Boolean getLaunchYesNoGenderDialog()
			{
				return (Boolean)cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.getValue(context);
			}
		public void setLaunchYesNoGenderDialog(Boolean value)
		{
				cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRSelectAndOrderLaunchYesNoGenderDialog = new ims.framework.ContextVariable("OCRR.SelectAndOrder.LaunchYesNoGenderDialog", "_cv_OCRR.SelectAndOrder.LaunchYesNoGenderDialog");
			private ims.framework.Context context;
		}

		public boolean getYesNoDialogWithReasonMessageIsNotNull()
		{
			return !cx_OCRRYesNoDialogWithReasonMessage.getValueIsNull(context);
		}
		public ims.ocrr.vo.ReOrderPeriodMessageVoCollection getYesNoDialogWithReasonMessage()
		{
			return (ims.ocrr.vo.ReOrderPeriodMessageVoCollection)cx_OCRRYesNoDialogWithReasonMessage.getValue(context);
		}
		public void setYesNoDialogWithReasonMessage(ims.ocrr.vo.ReOrderPeriodMessageVoCollection value)
		{
			cx_OCRRYesNoDialogWithReasonMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRYesNoDialogWithReasonMessage = new ims.framework.ContextVariable("OCRR.YesNoDialogWithReasonMessage", "_cv_OCRR.YesNoDialogWithReasonMessage");
		public boolean getReasonForReOrderIsNotNull()
		{
			return !cx_OCRRReasonForReOrder.getValueIsNull(context);
		}
		public String getReasonForReOrder()
		{
			return (String)cx_OCRRReasonForReOrder.getValue(context);
		}
		public void setReasonForReOrder(String value)
		{
			cx_OCRRReasonForReOrder.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRReasonForReOrder = new ims.framework.ContextVariable("OCRR.ReasonForReOrder", "_cv_OCRR.ReasonForReOrder");
		public boolean getRefusedInvestigationIsNotNull()
		{
			return !cx_OCRRRefusedInvestigation.getValueIsNull(context);
		}
		public ims.ocrr.configuration.vo.InvestigationRefVoCollection getRefusedInvestigation()
		{
			return (ims.ocrr.configuration.vo.InvestigationRefVoCollection)cx_OCRRRefusedInvestigation.getValue(context);
		}
		public void setRefusedInvestigation(ims.ocrr.configuration.vo.InvestigationRefVoCollection value)
		{
			cx_OCRRRefusedInvestigation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRRefusedInvestigation = new ims.framework.ContextVariable("OCRR.RefusedInvestigation", "_cv_OCRR.RefusedInvestigation");

		public SelectAndOrderContext SelectAndOrder;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getYesNoDialogLaunchedFromSelfIsNotNull()
		{
			return !cx_CoreYesNoDialogLaunchedFromSelf.getValueIsNull(context);
		}
		public Boolean getYesNoDialogLaunchedFromSelf()
		{
			return (Boolean)cx_CoreYesNoDialogLaunchedFromSelf.getValue(context);
		}
		public void setYesNoDialogLaunchedFromSelf(Boolean value)
		{
			cx_CoreYesNoDialogLaunchedFromSelf.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogLaunchedFromSelf = new ims.framework.ContextVariable("Core.YesNoDialogLaunchedFromSelf", "_cv_Core.YesNoDialogLaunchedFromSelf");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
	public CoreContext Core;
}
