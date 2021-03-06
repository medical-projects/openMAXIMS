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

package ims.assessment.forms.patientassessment;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.CareContextShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.CareContextShortVo' of the global context variable 'Core.CurrentCareContext' is not supported.");
		if(!context.isValidContextType(ims.core.vo.ClinicalContactShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.ClinicalContactShortVo' of the global context variable 'Core.CurrentClinicalContact' is not supported.");
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
		if(!context.isValidContextType(ims.core.vo.EpisodeofCareShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.EpisodeofCareShortVo' of the global context variable 'Core.EpisodeofCareShort' is not supported.");
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'Core.PatientShort' is not available.");
	}
	public boolean supportsRecordedInError()
	{
		return true;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return this.getLocalContext().getVoPatientAssessment();
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
			validateMandatoryContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuPatientAssessment = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuPatientAssessmentAddItem = factory.createMenuItem(startControlID.intValue() + 1, "Search/Select Assessment from Favourites", true, false, new Integer(102164), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentAddItem);
		contextMenus.contextMenuPatientAssessmentUpdateItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit Patient Assessment", true, false, new Integer(102150), true, true);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentUpdateItem);
		contextMenus.contextMenuPatientAssessmentAddGraphicAssessmentItem = factory.createMenuItem(startControlID.intValue() + 3, "New Graphical Assessment", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentAddGraphicAssessmentItem);
		contextMenus.contextMenuPatientAssessmentUpdateGraphicAssessmentItem = factory.createMenuItem(startControlID.intValue() + 4, "Edit Graphical Assessment", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentUpdateGraphicAssessmentItem);
		contextMenus.contextMenuPatientAssessmentViewGraphicAssessmentItem = factory.createMenuItem(startControlID.intValue() + 5, "View Graphical Assessment", true, false, new Integer(102223), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentViewGraphicAssessmentItem);
		contextMenus.contextMenuPatientAssessmentAddUserAssessmentItem = factory.createMenuItem(startControlID.intValue() + 6, "New Structured Assessment", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentAddUserAssessmentItem);
		contextMenus.contextMenuPatientAssessmentUpdateUserAssessmentItem = factory.createMenuItem(startControlID.intValue() + 7, "Edit Structured Assessment", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentUpdateUserAssessmentItem);
		contextMenus.contextMenuPatientAssessmentViewUserAssessmentItem = factory.createMenuItem(startControlID.intValue() + 8, "View Structured Assessment", true, false, new Integer(102223), true, false);
		contextMenus.contextMenuPatientAssessment.add(contextMenus.contextMenuPatientAssessmentViewUserAssessmentItem);
		form.registerMenu(contextMenus.contextMenuPatientAssessment);


		// Button Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 677, 592, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 757, 592, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 816, 560, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(-1), ControlState.EDITABLE, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL, contextMenus.contextMenuPatientAssessment, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnSave()
	{
		return (Button)super.getControl(0);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(1);
	}
	public DynamicGrid dyngrdAssessments()
	{
		return (DynamicGrid)super.getControl(2);
	}

	public static class Forms implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			private LocalFormName(int name)
			{
				super(name);
			}
		}

		private Forms()
		{
			Assessment = new AssessmentForms();
		}
		public final class AssessmentForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AssessmentForms()
			{
				UserDefinedFormSelect = new LocalFormName(102208);
				GraphicAssessmentInstantiation = new LocalFormName(102211);
				UserAssessmentInstantiation = new LocalFormName(123116);
				UserAssessmentInstantiationWithComponent = new LocalFormName(127108);
				PatientAssessment = new LocalFormName(102205);
			}
			public final FormName UserDefinedFormSelect;
			public final FormName GraphicAssessmentInstantiation;
			public final FormName UserAssessmentInstantiation;
			public final FormName UserAssessmentInstantiationWithComponent;
			public final FormName PatientAssessment;
		}

		public AssessmentForms Assessment;
	}


	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			Admin = new AdminImages();
			ICP = new ICPImages();
			Core = new CoreImages();
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				Image = new ImageHelper(103114, "Images/Admin/Image.gif", new Integer(16), new Integer(16));
				Color = new ImageHelper(103120, "Images/Admin/Color.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image Image;
			public final ims.framework.utils.Image Color;
		}
		public final class ICPImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private ICPImages()
			{
				Stage = new ImageHelper(118103, "Images/ICP/VSObject_Delegate.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image Stage;
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				TextBox = new ImageHelper(102240, "Images/Core/Textbox.gif", new Integer(16), new Integer(16));
				Information = new ImageHelper(102217, "Images/Core/Information.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image TextBox;
			public final ims.framework.utils.Image Information;
		}
		public final AdminImages Admin;
		public final ICPImages ICP;
		public final CoreImages Core;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}
	public LocalContext getLocalContext()
	{
		return (LocalContext)super.getLocalCtx();
	}
	public class LocalContext extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
		
		public LocalContext(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			super.setContext(context);
			String prefix = formInfo.getLocalVariablesPrefix();
			cxl_VoPatientAssessment = new ims.framework.ContextVariable("VoPatientAssessment", prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier + "");
			cxl_isFormOpenedFromGraphicImage = new ims.framework.ContextVariable("isFormOpenedFromGraphicImage", prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__isFormOpenedFromGraphicImage_" + componentIdentifier + "");
			cxl_PatientUserDefinedObjectListVoCollection = new ims.framework.ContextVariable("PatientUserDefinedObjectListVoCollection", prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__PatientUserDefinedObjectListVoCollection_" + componentIdentifier + "");
		}
		
		public boolean getVoPatientAssessmentIsNotNull()
		{
			return !cxl_VoPatientAssessment.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientAssessmentListVo getVoPatientAssessment()
		{
			return (ims.assessment.vo.PatientAssessmentListVo)cxl_VoPatientAssessment.getValue(context);
		}
		public void setVoPatientAssessment(ims.assessment.vo.PatientAssessmentListVo value)
		{
			cxl_VoPatientAssessment.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_VoPatientAssessment = null;
		public boolean getisFormOpenedFromGraphicImageIsNotNull()
		{
			return !cxl_isFormOpenedFromGraphicImage.getValueIsNull(context);
		}
		public Boolean getisFormOpenedFromGraphicImage()
		{
			return (Boolean)cxl_isFormOpenedFromGraphicImage.getValue(context);
		}
		public void setisFormOpenedFromGraphicImage(Boolean value)
		{
			cxl_isFormOpenedFromGraphicImage.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_isFormOpenedFromGraphicImage = null;
		public boolean getPatientUserDefinedObjectListVoCollectionIsNotNull()
		{
			return !cxl_PatientUserDefinedObjectListVoCollection.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientUserDefinedObjectListVoCollection getPatientUserDefinedObjectListVoCollection()
		{
			return (ims.assessment.vo.PatientUserDefinedObjectListVoCollection)cxl_PatientUserDefinedObjectListVoCollection.getValue(context);
		}
		public void setPatientUserDefinedObjectListVoCollection(ims.assessment.vo.PatientUserDefinedObjectListVoCollection value)
		{
			cxl_PatientUserDefinedObjectListVoCollection.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_PatientUserDefinedObjectListVoCollection = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class PatientAssessment implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int Add = 1;
			public static final int Update = 2;
			public static final int AddGraphicAssessment = 3;
			public static final int UpdateGraphicAssessment = 4;
			public static final int ViewGraphicAssessment = 5;
			public static final int AddUserAssessment = 6;
			public static final int UpdateUserAssessment = 7;
			public static final int ViewUserAssessment = 8;
		}
		public void disableAllPatientAssessmentMenuItems()
		{
			this.contextMenuPatientAssessmentAddItem.setEnabled(false);
			this.contextMenuPatientAssessmentUpdateItem.setEnabled(false);
			this.contextMenuPatientAssessmentAddGraphicAssessmentItem.setEnabled(false);
			this.contextMenuPatientAssessmentUpdateGraphicAssessmentItem.setEnabled(false);
			this.contextMenuPatientAssessmentViewGraphicAssessmentItem.setEnabled(false);
			this.contextMenuPatientAssessmentAddUserAssessmentItem.setEnabled(false);
			this.contextMenuPatientAssessmentUpdateUserAssessmentItem.setEnabled(false);
			this.contextMenuPatientAssessmentViewUserAssessmentItem.setEnabled(false);
		}
		public void hideAllPatientAssessmentMenuItems()
		{
			this.contextMenuPatientAssessmentAddItem.setVisible(false);
			this.contextMenuPatientAssessmentUpdateItem.setVisible(false);
			this.contextMenuPatientAssessmentAddGraphicAssessmentItem.setVisible(false);
			this.contextMenuPatientAssessmentUpdateGraphicAssessmentItem.setVisible(false);
			this.contextMenuPatientAssessmentViewGraphicAssessmentItem.setVisible(false);
			this.contextMenuPatientAssessmentAddUserAssessmentItem.setVisible(false);
			this.contextMenuPatientAssessmentUpdateUserAssessmentItem.setVisible(false);
			this.contextMenuPatientAssessmentViewUserAssessmentItem.setVisible(false);
		}
		private Menu contextMenuPatientAssessment;
		public MenuItem getPatientAssessmentAddItem()
		{
			return this.contextMenuPatientAssessmentAddItem;
		}
		private MenuItem contextMenuPatientAssessmentAddItem;
		public MenuItem getPatientAssessmentUpdateItem()
		{
			return this.contextMenuPatientAssessmentUpdateItem;
		}
		private MenuItem contextMenuPatientAssessmentUpdateItem;
		public MenuItem getPatientAssessmentAddGraphicAssessmentItem()
		{
			return this.contextMenuPatientAssessmentAddGraphicAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentAddGraphicAssessmentItem;
		public MenuItem getPatientAssessmentUpdateGraphicAssessmentItem()
		{
			return this.contextMenuPatientAssessmentUpdateGraphicAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentUpdateGraphicAssessmentItem;
		public MenuItem getPatientAssessmentViewGraphicAssessmentItem()
		{
			return this.contextMenuPatientAssessmentViewGraphicAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentViewGraphicAssessmentItem;
		public MenuItem getPatientAssessmentAddUserAssessmentItem()
		{
			return this.contextMenuPatientAssessmentAddUserAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentAddUserAssessmentItem;
		public MenuItem getPatientAssessmentUpdateUserAssessmentItem()
		{
			return this.contextMenuPatientAssessmentUpdateUserAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentUpdateUserAssessmentItem;
		public MenuItem getPatientAssessmentViewUserAssessmentItem()
		{
			return this.contextMenuPatientAssessmentViewUserAssessmentItem;
		}
		private MenuItem contextMenuPatientAssessmentViewUserAssessmentItem;
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[88];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_CareUk.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Core.UserDefinedObjectSelected", "BO-1028100004-ID", "ID_UserDefinedObject");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Core.UserDefinedObjectSelected", "BO-1028100004-NAME", "Name");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Core.UserDefinedObjectSelected", "BO-1028100004-OBJECTTYPE", "ObjectType");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_Core.UserDefinedObjectSelected", "BO-1028100004-ACTIVESTATUS", "ActiveStatus");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_Assessment.PatientUserDefinedObject", "BO-1085100000-ID", "ID_PatientUserDefinedObject");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_Clinical.PatientAssessment.EditedComponent", "BO-1028100005-ID", "ID_UserDefinedObjectComponent");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_Clinical.PatientAssessment.SelectedAssessment", "BO-1003100048-ID", "ID_PatientAssessment");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-ID", "ID_PatientAssessment");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-CLINICALCONTACT", "ClinicalContact");
			fields[80] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-CARECONTEXT", "CareContext");
			fields[81] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-STATUS", "Status");
			fields[82] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-STATUSREASON", "StatusReason");
			fields[83] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-ISCURRENTFORTYPE", "IsCurrentForType");
			fields[84] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-DPPTYPE", "DPPType");
			fields[85] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-COMPLETEDDATETIME", "CompletedDateTime");
			fields[86] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-EPISODEOFCARE", "EpisodeOfCare");
			fields[87] = new ims.framework.ReportField(this.context, prefix + "_lv_Assessment.PatientAssessment.__internal_x_context__VoPatientAssessment_" + componentIdentifier, "BO-1003100048-PATIENT", "Patient");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
