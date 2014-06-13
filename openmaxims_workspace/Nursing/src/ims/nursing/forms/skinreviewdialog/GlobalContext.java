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

package ims.nursing.forms.skinreviewdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		COE = new COEContext(context);
		Core = new CoreContext(context);
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

			SkinBodyChart = new SkinBodyChartContext(context);
		}
		public final class SkinBodyChartContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SkinBodyChartContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getReviewVOIsNotNull()
			{
				return !cx_COESkinBodyChartReviewVO.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessmentReview getReviewVO()
			{
				return (ims.nursing.vo.SkinAssessmentReview)cx_COESkinBodyChartReviewVO.getValue(context);
			}
		public void setReviewVO(ims.nursing.vo.SkinAssessmentReview value)
		{
				cx_COESkinBodyChartReviewVO.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartReviewVO = new ims.framework.ContextVariable("COE.SkinBodyChart.ReviewVO", "_cv_COE.SkinBodyChart.ReviewVO");
			public boolean getGroupsIsNotNull()
			{
				return !cx_COESkinBodyChartGroups.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlGroupCollection getGroups()
			{
				return (ims.framework.controls.DrawingControlGroupCollection)cx_COESkinBodyChartGroups.getValue(context);
			}

			private ims.framework.ContextVariable cx_COESkinBodyChartGroups = new ims.framework.ContextVariable("COE.SkinBodyChart.Groups", "_cv_COE.SkinBodyChart.Groups");
			public boolean getSelectedSkinAssessmentIsNotNull()
			{
				return !cx_COESkinBodyChartSelectedSkinAssessment.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessment getSelectedSkinAssessment()
			{
				return (ims.nursing.vo.SkinAssessment)cx_COESkinBodyChartSelectedSkinAssessment.getValue(context);
			}

			private ims.framework.ContextVariable cx_COESkinBodyChartSelectedSkinAssessment = new ims.framework.ContextVariable("COE.SkinBodyChart.SelectedSkinAssessment", "_cv_COE.SkinBodyChart.SelectedSkinAssessment");
			public boolean getAreasIsNotNull()
			{
				return !cx_COESkinBodyChartAreas.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlAreaCollection getAreas()
			{
				return (ims.framework.controls.DrawingControlAreaCollection)cx_COESkinBodyChartAreas.getValue(context);
			}

			private ims.framework.ContextVariable cx_COESkinBodyChartAreas = new ims.framework.ContextVariable("COE.SkinBodyChart.Areas", "_cv_COE.SkinBodyChart.Areas");
			public boolean getFindingsVOIsNotNull()
			{
				return !cx_COESkinBodyChartFindingsVO.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessmentFindings getFindingsVO()
			{
				return (ims.nursing.vo.SkinAssessmentFindings)cx_COESkinBodyChartFindingsVO.getValue(context);
			}
		public void setFindingsVO(ims.nursing.vo.SkinAssessmentFindings value)
		{
				cx_COESkinBodyChartFindingsVO.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartFindingsVO = new ims.framework.ContextVariable("COE.SkinBodyChart.FindingsVO", "_cv_COE.SkinBodyChart.FindingsVO");
			public boolean getReviewDialogIsNotNull()
			{
				return !cx_COESkinBodyChartReviewDialog.getValueIsNull(context);
			}
			public Boolean getReviewDialog()
			{
				return (Boolean)cx_COESkinBodyChartReviewDialog.getValue(context);
			}
		public void setReviewDialog(Boolean value)
		{
				cx_COESkinBodyChartReviewDialog.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartReviewDialog = new ims.framework.ContextVariable("COE.SkinBodyChart.ReviewDialog", "_cv_COE.SkinBodyChart.ReviewDialog");
			private ims.framework.Context context;
		}


		public SkinBodyChartContext SkinBodyChart;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public CoreContext Core;
}
