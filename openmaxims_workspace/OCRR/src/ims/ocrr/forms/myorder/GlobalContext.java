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

package ims.ocrr.forms.myorder;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
		CareUk = new CareUkContext(context);
		Rotherham = new RotherhamContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

			PrintOrder = new PrintOrderContext(context);
			PathologyResults = new PathologyResultsContext(context);
		}
		public final class PrintOrderContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PrintOrderContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getNotLocalInvestigationsIsNotNull()
			{
				return !cx_OCRRPrintOrderNotLocalInvestigations.getValueIsNull(context);
			}
			public ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection getNotLocalInvestigations()
			{
				return (ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection)cx_OCRRPrintOrderNotLocalInvestigations.getValue(context);
			}
		public void setNotLocalInvestigations(ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection value)
		{
				cx_OCRRPrintOrderNotLocalInvestigations.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPrintOrderNotLocalInvestigations = new ims.framework.ContextVariable("OCRR.PrintOrder.NotLocalInvestigations", "_cv_OCRR.PrintOrder.NotLocalInvestigations");
			public boolean getExecuteAutomaticPrintIsNotNull()
			{
				return !cx_OCRRPrintOrderExecuteAutomaticPrint.getValueIsNull(context);
			}
			public Boolean getExecuteAutomaticPrint()
			{
				return (Boolean)cx_OCRRPrintOrderExecuteAutomaticPrint.getValue(context);
			}
		public void setExecuteAutomaticPrint(Boolean value)
		{
				cx_OCRRPrintOrderExecuteAutomaticPrint.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPrintOrderExecuteAutomaticPrint = new ims.framework.ContextVariable("OCRR.PrintOrder.ExecuteAutomaticPrint", "_cv_OCRR.PrintOrder.ExecuteAutomaticPrint");
			private ims.framework.Context context;
		}
		public final class PathologyResultsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathologyResultsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getOrderIsNotNull()
			{
				return !cx_OCRRPathologyResultsOrder.getValueIsNull(context);
			}
			public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrder()
			{
				return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRRPathologyResultsOrder.getValue(context);
			}
		public void setOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
				cx_OCRRPathologyResultsOrder.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPathologyResultsOrder = new ims.framework.ContextVariable("OCRR.PathologyResults.Order", "_cv_OCRR.PathologyResults.Order");
			private ims.framework.Context context;
		}

		public boolean getMyOrderComponentsIsNotNull()
		{
			return !cx_OCRRMyOrderComponents.getValueIsNull(context);
		}
		public ims.ocrr.vo.MyOrderComponentVoCollection getMyOrderComponents()
		{
			return (ims.ocrr.vo.MyOrderComponentVoCollection)cx_OCRRMyOrderComponents.getValue(context);
		}
		public void setMyOrderComponents(ims.ocrr.vo.MyOrderComponentVoCollection value)
		{
			cx_OCRRMyOrderComponents.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRMyOrderComponents = new ims.framework.ContextVariable("OCRR.MyOrderComponents", "_cv_OCRR.MyOrderComponents");
		public boolean getMyOrderQuestionsIsNotNull()
		{
			return !cx_OCRRMyOrderQuestions.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsQASessionVo getMyOrderQuestions()
		{
			return (ims.ocrr.vo.OcsQASessionVo)cx_OCRRMyOrderQuestions.getValue(context);
		}
		public void setMyOrderQuestions(ims.ocrr.vo.OcsQASessionVo value)
		{
			cx_OCRRMyOrderQuestions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRMyOrderQuestions = new ims.framework.ContextVariable("OCRR.MyOrderQuestions", "_cv_OCRR.MyOrderQuestions");
		public boolean getGPSearchStringIsNotNull()
		{
			return !cx_OCRRGPSearchString.getValueIsNull(context);
		}
		public String getGPSearchString()
		{
			return (String)cx_OCRRGPSearchString.getValue(context);
		}
		public void setGPSearchString(String value)
		{
			cx_OCRRGPSearchString.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRGPSearchString = new ims.framework.ContextVariable("OCRR.GPSearchString", "_cv_OCRR.GPSearchString");
		public boolean getOrderInvestigationCollectionIsNotNull()
		{
			return !cx_OCRROrderInvestigationCollection.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderInvestigationVoCollection getOrderInvestigationCollection()
		{
			return (ims.ocrr.vo.OrderInvestigationVoCollection)cx_OCRROrderInvestigationCollection.getValue(context);
		}
		public void setOrderInvestigationCollection(ims.ocrr.vo.OrderInvestigationVoCollection value)
		{
			cx_OCRROrderInvestigationCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderInvestigationCollection = new ims.framework.ContextVariable("OCRR.OrderInvestigationCollection", "_cv_OCRR.OrderInvestigationCollection");
		public boolean getSelectedOrderPriorityIsNotNull()
		{
			return !cx_OCRRSelectedOrderPriority.getValueIsNull(context);
		}
		public ims.ocrr.vo.lookups.OrderPriority getSelectedOrderPriority()
		{
			return (ims.ocrr.vo.lookups.OrderPriority)cx_OCRRSelectedOrderPriority.getValue(context);
		}
		public void setSelectedOrderPriority(ims.ocrr.vo.lookups.OrderPriority value)
		{
			cx_OCRRSelectedOrderPriority.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedOrderPriority = new ims.framework.ContextVariable("OCRR.SelectedOrderPriority", "_cv_OCRR.SelectedOrderPriority");
		public boolean getPatientOrNowOnlyIsNotNull()
		{
			return !cx_OCRRPatientOrNowOnly.getValueIsNull(context);
		}
		public Boolean getPatientOrNowOnly()
		{
			return (Boolean)cx_OCRRPatientOrNowOnly.getValue(context);
		}
		public void setPatientOrNowOnly(Boolean value)
		{
			cx_OCRRPatientOrNowOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPatientOrNowOnly = new ims.framework.ContextVariable("OCRR.PatientOrNowOnly", "_cv_OCRR.PatientOrNowOnly");
		public boolean getQuestionTooltipsIsNotNull()
		{
			return !cx_OCRRQuestionTooltips.getValueIsNull(context);
		}
		public ims.ocrr.vo.QuestionTooltipVoCollection getQuestionTooltips()
		{
			return (ims.ocrr.vo.QuestionTooltipVoCollection)cx_OCRRQuestionTooltips.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRRQuestionTooltips = new ims.framework.ContextVariable("OCRR.QuestionTooltips", "_cv_OCRR.QuestionTooltips");
		public boolean getMyOrderPotentialSpecimensIsNotNull()
		{
			return !cx_OCRRMyOrderPotentialSpecimens.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderSpecimenVoCollection getMyOrderPotentialSpecimens()
		{
			return (ims.ocrr.vo.OrderSpecimenVoCollection)cx_OCRRMyOrderPotentialSpecimens.getValue(context);
		}
		public void setMyOrderPotentialSpecimens(ims.ocrr.vo.OrderSpecimenVoCollection value)
		{
			cx_OCRRMyOrderPotentialSpecimens.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRMyOrderPotentialSpecimens = new ims.framework.ContextVariable("OCRR.MyOrderPotentialSpecimens", "_cv_OCRR.MyOrderPotentialSpecimens");
		public boolean getOrderAwaitingAuthorisationIsNotNull()
		{
			return !cx_OCRROrderAwaitingAuthorisation.getValueIsNull(context);
		}
		public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderAwaitingAuthorisation()
		{
			return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRROrderAwaitingAuthorisation.getValue(context);
		}
		public void setOrderAwaitingAuthorisation(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
			cx_OCRROrderAwaitingAuthorisation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderAwaitingAuthorisation = new ims.framework.ContextVariable("OCRR.OrderAwaitingAuthorisation", "_cv_OCRR.OrderAwaitingAuthorisation");
		public boolean getOrderInvestigationToAmendIsNotNull()
		{
			return !cx_OCRROrderInvestigationToAmend.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderInvestigationLiteVo getOrderInvestigationToAmend()
		{
			return (ims.ocrr.vo.OrderInvestigationLiteVo)cx_OCRROrderInvestigationToAmend.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRROrderInvestigationToAmend = new ims.framework.ContextVariable("OCRR.OrderInvestigationToAmend", "_cv_OCRR.OrderInvestigationToAmend");
		public boolean getRoleDisciplineSecurityLevelsIsNotNull()
		{
			return !cx_OCRRRoleDisciplineSecurityLevels.getValueIsNull(context);
		}
		public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels()
		{
			return (ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo)cx_OCRRRoleDisciplineSecurityLevels.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRRRoleDisciplineSecurityLevels = new ims.framework.ContextVariable("OCRR.RoleDisciplineSecurityLevels", "_cvp_OCRR.RoleDisciplineSecurityLevels");
		public boolean getReWrittenOrderInvestigationsIsNotNull()
		{
			return !cx_OCRRReWrittenOrderInvestigations.getValueIsNull(context);
		}
		public ims.ocrr.vo.OrderInvestigationVoCollection getReWrittenOrderInvestigations()
		{
			return (ims.ocrr.vo.OrderInvestigationVoCollection)cx_OCRRReWrittenOrderInvestigations.getValue(context);
		}
		public void setReWrittenOrderInvestigations(ims.ocrr.vo.OrderInvestigationVoCollection value)
		{
			cx_OCRRReWrittenOrderInvestigations.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRReWrittenOrderInvestigations = new ims.framework.ContextVariable("OCRR.ReWrittenOrderInvestigations", "_cv_OCRR.ReWrittenOrderInvestigations");

		public PrintOrderContext PrintOrder;
		public PathologyResultsContext PathologyResults;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			CareContextSelectDialog = new CareContextSelectDialogContext(context);
		}
		public final class CareContextSelectDialogContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CareContextSelectDialogContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getChosenCareContextIsNotNull()
			{
				return !cx_CoreCareContextSelectDialogChosenCareContext.getValueIsNull(context);
			}
			public ims.core.vo.CareContextPasVo getChosenCareContext()
			{
				return (ims.core.vo.CareContextPasVo)cx_CoreCareContextSelectDialogChosenCareContext.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreCareContextSelectDialogChosenCareContext = new ims.framework.ContextVariable("Core.CareContextSelectDialog.ChosenCareContext", "_cv_Core.CareContextSelectDialog.ChosenCareContext");
			private ims.framework.Context context;
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

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getReportIsNotNull()
		{
			return !cx_CoreReport.getValueIsNull(context);
		}
		public String getReport()
		{
			return (String)cx_CoreReport.getValue(context);
		}
		public void setReport(String value)
		{
			cx_CoreReport.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReport = new ims.framework.ContextVariable("Core.Report", "_cv_Core.Report");
		public boolean getTemplateIsNotNull()
		{
			return !cx_CoreTemplate.getValueIsNull(context);
		}
		public String getTemplate()
		{
			return (String)cx_CoreTemplate.getValue(context);
		}
		public void setTemplate(String value)
		{
			cx_CoreTemplate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplate = new ims.framework.ContextVariable("Core.Template", "_cv_Core.Template");
		public boolean getGPDetailsIsNotNull()
		{
			return !cx_CoreGPDetails.getValueIsNull(context);
		}
		public ims.core.vo.GpShortVo getGPDetails()
		{
			return (ims.core.vo.GpShortVo)cx_CoreGPDetails.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreGPDetails = new ims.framework.ContextVariable("Core.GPDetails", "_cv_Core.GPDetails");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getPrepareForPrintingIsNotNull()
		{
			return !cx_CorePrepareForPrinting.getValueIsNull(context);
		}
		public Boolean getPrepareForPrinting()
		{
			return (Boolean)cx_CorePrepareForPrinting.getValue(context);
		}
		public void setPrepareForPrinting(Boolean value)
		{
			cx_CorePrepareForPrinting.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrepareForPrinting = new ims.framework.ContextVariable("Core.PrepareForPrinting", "_cv_Core.PrepareForPrinting");
		public boolean getPrinterSelectIsNotNull()
		{
			return !cx_CorePrinterSelect.getValueIsNull(context);
		}
		public String getPrinterSelect()
		{
			return (String)cx_CorePrinterSelect.getValue(context);
		}
		public void setPrinterSelect(String value)
		{
			cx_CorePrinterSelect.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrinterSelect = new ims.framework.ContextVariable("Core.PrinterSelect", "_cv_Core.PrinterSelect");
		public boolean getItemsIsNotNull()
		{
			return !cx_CoreItems.getValueIsNull(context);
		}
		public ims.admin.vo.SelectItemVoCollection getItems()
		{
			return (ims.admin.vo.SelectItemVoCollection)cx_CoreItems.getValue(context);
		}
		public void setItems(ims.admin.vo.SelectItemVoCollection value)
		{
			cx_CoreItems.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreItems = new ims.framework.ContextVariable("Core.Items", "_cv_Core.Items");
		public boolean getSelectedLocationForOrderingIsNotNull()
		{
			return !cx_CoreSelectedLocationForOrdering.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getSelectedLocationForOrdering()
		{
			return (ims.core.vo.LocShortVo)cx_CoreSelectedLocationForOrdering.getValue(context);
		}
		public void setSelectedLocationForOrdering(ims.core.vo.LocShortVo value)
		{
			cx_CoreSelectedLocationForOrdering.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedLocationForOrdering = new ims.framework.ContextVariable("Core.SelectedLocationForOrdering", "_cv_Core.SelectedLocationForOrdering");
		public boolean getSelectingPatientFormIsNotNull()
		{
			return !cx_CoreSelectingPatientForm.getValueIsNull(context);
		}
		public ims.framework.FormName getSelectingPatientForm()
		{
			return (ims.framework.FormName)cx_CoreSelectingPatientForm.getValue(context);
		}
		public void setSelectingPatientForm(ims.framework.FormName value)
		{
			cx_CoreSelectingPatientForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectingPatientForm = new ims.framework.ContextVariable("Core.SelectingPatientForm", "_cvp_Core.SelectingPatientForm");
		public boolean getOutpatientAttendanceForOrderIsNotNull()
		{
			return !cx_CoreOutpatientAttendanceForOrder.getValueIsNull(context);
		}
		public ims.core.vo.OutPatientListVo getOutpatientAttendanceForOrder()
		{
			return (ims.core.vo.OutPatientListVo)cx_CoreOutpatientAttendanceForOrder.getValue(context);
		}
		public void setOutpatientAttendanceForOrder(ims.core.vo.OutPatientListVo value)
		{
			cx_CoreOutpatientAttendanceForOrder.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreOutpatientAttendanceForOrder = new ims.framework.ContextVariable("Core.OutpatientAttendanceForOrder", "_cv_Core.OutpatientAttendanceForOrder");

		public CareContextSelectDialogContext CareContextSelectDialog;
		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_CareUkCatsReferral.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.careuk.vo.CatsReferralRefVo)cx_CareUkCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
		{
			cx_CareUkCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferral = new ims.framework.ContextVariable("CareUk.CatsReferral", "_cvp_CareUk.CatsReferral");
		public boolean getOrderingHCPIsNotNull()
		{
			return !cx_CareUkOrderingHCP.getValueIsNull(context);
		}
		public ims.core.vo.MemberOfStaffLiteVo getOrderingHCP()
		{
			return (ims.core.vo.MemberOfStaffLiteVo)cx_CareUkOrderingHCP.getValue(context);
		}
		public void setOrderingHCP(ims.core.vo.MemberOfStaffLiteVo value)
		{
			cx_CareUkOrderingHCP.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkOrderingHCP = new ims.framework.ContextVariable("CareUk.OrderingHCP", "_cv_CareUk.OrderingHCP");

		private ims.framework.Context context;
	}
	public final class RotherhamContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RotherhamContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAppointmentToLinkIsNotNull()
		{
			return !cx_RotherhamAppointmentToLink.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getAppointmentToLink()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_RotherhamAppointmentToLink.getValue(context);
		}
		public void setAppointmentToLink(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_RotherhamAppointmentToLink.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RotherhamAppointmentToLink = new ims.framework.ContextVariable("Rotherham.AppointmentToLink", "_cv_Rotherham.AppointmentToLink");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
	public CoreContext Core;
	public CareUkContext CareUk;
	public RotherhamContext Rotherham;
}
