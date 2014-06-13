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

package ims.nursing.forms.skinreview;

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
			ClinicalNotes = new ClinicalNotesContext(context);
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
		public void setGroups(ims.framework.controls.DrawingControlGroupCollection value)
		{
				cx_COESkinBodyChartGroups.setValue(context, value);
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
		public void setSelectedSkinAssessment(ims.nursing.vo.SkinAssessment value)
		{
				cx_COESkinBodyChartSelectedSkinAssessment.setValue(context, value);
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
		public void setAreas(ims.framework.controls.DrawingControlAreaCollection value)
		{
				cx_COESkinBodyChartAreas.setValue(context, value);
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
			public boolean getReadOnlyAssessmentIsNotNull()
			{
				return !cx_COESkinBodyChartReadOnlyAssessment.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessment getReadOnlyAssessment()
			{
				return (ims.nursing.vo.SkinAssessment)cx_COESkinBodyChartReadOnlyAssessment.getValue(context);
			}
		public void setReadOnlyAssessment(ims.nursing.vo.SkinAssessment value)
		{
				cx_COESkinBodyChartReadOnlyAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartReadOnlyAssessment = new ims.framework.ContextVariable("COE.SkinBodyChart.ReadOnlyAssessment", "_cv_COE.SkinBodyChart.ReadOnlyAssessment");
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
		public final class ClinicalNotesContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalNotesContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getCallingFormIsNotNull()
			{
				return !cx_COEClinicalNotesCallingForm.getValueIsNull(context);
			}
			public ims.framework.FormName getCallingForm()
			{
				return (ims.framework.FormName)cx_COEClinicalNotesCallingForm.getValue(context);
			}
		public void setCallingForm(ims.framework.FormName value)
		{
				cx_COEClinicalNotesCallingForm.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COEClinicalNotesCallingForm = new ims.framework.ContextVariable("COE.ClinicalNotes.CallingForm", "_cv_COE.ClinicalNotes.CallingForm");
			private ims.framework.Context context;
		}


		public SkinBodyChartContext SkinBodyChart;
		public ClinicalNotesContext ClinicalNotes;
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
		public boolean getReportIDIsNotNull()
		{
			return !cx_CoreReportID.getValueIsNull(context);
		}
		public Integer getReportID()
		{
			return (Integer)cx_CoreReportID.getValue(context);
		}
		public void setReportID(Integer value)
		{
			cx_CoreReportID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportID = new ims.framework.ContextVariable("Core.ReportID", "_cv_Core.ReportID");
		public boolean getTemplateIDIsNotNull()
		{
			return !cx_CoreTemplateID.getValueIsNull(context);
		}
		public Integer getTemplateID()
		{
			return (Integer)cx_CoreTemplateID.getValue(context);
		}
		public void setTemplateID(Integer value)
		{
			cx_CoreTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplateID = new ims.framework.ContextVariable("Core.TemplateID", "_cv_Core.TemplateID");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public CoreContext Core;
}
