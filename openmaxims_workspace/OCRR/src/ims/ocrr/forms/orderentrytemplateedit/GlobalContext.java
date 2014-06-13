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

package ims.ocrr.forms.orderentrytemplateedit;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getOrderEntryTemplateListSearchCriteriaIsNotNull()
		{
			return !cx_OCRROrderEntryTemplateListSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderEntryTemplateListSearchCriteriaVo getOrderEntryTemplateListSearchCriteria()
		{
			return (ims.ocrr.vo.OrderEntryTemplateListSearchCriteriaVo)cx_OCRROrderEntryTemplateListSearchCriteria.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRROrderEntryTemplateListSearchCriteria = new ims.framework.ContextVariable("OCRR.OrderEntryTemplateListSearchCriteria", "_cv_OCRR.OrderEntryTemplateListSearchCriteria");
		public boolean getOrderEntryTemplateEditorReadOnlyIsNotNull()
		{
			return !cx_OCRROrderEntryTemplateEditorReadOnly.getValueIsNull(context);
		}
		public Boolean getOrderEntryTemplateEditorReadOnly()
		{
			return (Boolean)cx_OCRROrderEntryTemplateEditorReadOnly.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRROrderEntryTemplateEditorReadOnly = new ims.framework.ContextVariable("OCRR.OrderEntryTemplateEditorReadOnly", "_cv_OCRR.OrderEntryTemplateEditorReadOnly");
		public boolean getPreviewedOrderEntryTemplateIsNotNull()
		{
			return !cx_OCRRPreviewedOrderEntryTemplate.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderEntryTemplateVo getPreviewedOrderEntryTemplate()
		{
			return (ims.ocrr.vo.OrderEntryTemplateVo)cx_OCRRPreviewedOrderEntryTemplate.getValue(context);
		}
		public void setPreviewedOrderEntryTemplate(ims.ocrr.vo.OrderEntryTemplateVo value)
		{
			cx_OCRRPreviewedOrderEntryTemplate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPreviewedOrderEntryTemplate = new ims.framework.ContextVariable("OCRR.PreviewedOrderEntryTemplate", "_cv_OCRR.PreviewedOrderEntryTemplate");
		public boolean getSelectedOrderEntryTemplateIDIsNotNull()
		{
			return !cx_OCRRSelectedOrderEntryTemplateID.getValueIsNull(context);
		}
		public Integer getSelectedOrderEntryTemplateID()
		{
			return (Integer)cx_OCRRSelectedOrderEntryTemplateID.getValue(context);
		}
		public void setSelectedOrderEntryTemplateID(Integer value)
		{
			cx_OCRRSelectedOrderEntryTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedOrderEntryTemplateID = new ims.framework.ContextVariable("OCRR.SelectedOrderEntryTemplateID", "_cv_OCRR.SelectedOrderEntryTemplateID");
		public boolean getItemSelectionTypeIsNotNull()
		{
			return !cx_OCRRItemSelectionType.getValueIsNull(context);
		}
		public ims.ocrr.vo.lookups.ItemSelectionType getItemSelectionType()
		{
			return (ims.ocrr.vo.lookups.ItemSelectionType)cx_OCRRItemSelectionType.getValue(context);
		}
		public void setItemSelectionType(ims.ocrr.vo.lookups.ItemSelectionType value)
		{
			cx_OCRRItemSelectionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRItemSelectionType = new ims.framework.ContextVariable("OCRR.ItemSelectionType", "_cv_OCRR.ItemSelectionType");
		public boolean getSelectedInvestigationsIsNotNull()
		{
			return !cx_OCRRSelectedInvestigations.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestShortVoCollection getSelectedInvestigations()
		{
			return (ims.ocrr.vo.InvestShortVoCollection)cx_OCRRSelectedInvestigations.getValue(context);
		}
		public void setSelectedInvestigations(ims.ocrr.vo.InvestShortVoCollection value)
		{
			cx_OCRRSelectedInvestigations.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedInvestigations = new ims.framework.ContextVariable("OCRR.SelectedInvestigations", "_cv_OCRR.SelectedInvestigations");
		public boolean getSelectedProfilesIsNotNull()
		{
			return !cx_OCRRSelectedProfiles.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestShortVoCollection getSelectedProfiles()
		{
			return (ims.ocrr.vo.InvestShortVoCollection)cx_OCRRSelectedProfiles.getValue(context);
		}
		public void setSelectedProfiles(ims.ocrr.vo.InvestShortVoCollection value)
		{
			cx_OCRRSelectedProfiles.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedProfiles = new ims.framework.ContextVariable("OCRR.SelectedProfiles", "_cv_OCRR.SelectedProfiles");
		public boolean getSelectedOrderSetsIsNotNull()
		{
			return !cx_OCRRSelectedOrderSets.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderSetShortVoCollection getSelectedOrderSets()
		{
			return (ims.ocrr.vo.OrderSetShortVoCollection)cx_OCRRSelectedOrderSets.getValue(context);
		}
		public void setSelectedOrderSets(ims.ocrr.vo.OrderSetShortVoCollection value)
		{
			cx_OCRRSelectedOrderSets.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedOrderSets = new ims.framework.ContextVariable("OCRR.SelectedOrderSets", "_cv_OCRR.SelectedOrderSets");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
