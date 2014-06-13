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

package ims.core.forms.demographics;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		CareUk = new CareUkContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");
		public boolean getPatientFilterIsNotNull()
		{
			return !cx_CorePatientFilter.getValueIsNull(context);
		}
		public ims.core.vo.PatientFilter getPatientFilter()
		{
			return (ims.core.vo.PatientFilter)cx_CorePatientFilter.getValue(context);
		}
		public void setPatientFilter(ims.core.vo.PatientFilter value)
		{
			cx_CorePatientFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientFilter = new ims.framework.ContextVariable("Core.PatientFilter", "_cvp_Core.PatientFilter");
		public boolean getGPDetailsIsNotNull()
		{
			return !cx_CoreGPDetails.getValueIsNull(context);
		}
		public ims.core.vo.GpShortVo getGPDetails()
		{
			return (ims.core.vo.GpShortVo)cx_CoreGPDetails.getValue(context);
		}
		public void setGPDetails(ims.core.vo.GpShortVo value)
		{
			cx_CoreGPDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPDetails = new ims.framework.ContextVariable("Core.GPDetails", "_cv_Core.GPDetails");
		public boolean getNOKDetailsIsNotNull()
		{
			return !cx_CoreNOKDetails.getValueIsNull(context);
		}
		public ims.core.vo.NextOfKin getNOKDetails()
		{
			return (ims.core.vo.NextOfKin)cx_CoreNOKDetails.getValue(context);
		}
		public void setNOKDetails(ims.core.vo.NextOfKin value)
		{
			cx_CoreNOKDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreNOKDetails = new ims.framework.ContextVariable("Core.NOKDetails", "_cv_Core.NOKDetails");
		public boolean getOtherNamesIsNotNull()
		{
			return !cx_CoreOtherNames.getValueIsNull(context);
		}
		public ims.core.vo.PersonNameCollection getOtherNames()
		{
			return (ims.core.vo.PersonNameCollection)cx_CoreOtherNames.getValue(context);
		}
		public void setOtherNames(ims.core.vo.PersonNameCollection value)
		{
			cx_CoreOtherNames.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreOtherNames = new ims.framework.ContextVariable("Core.OtherNames", "_cv_Core.OtherNames");
		public boolean getOtherAddressesIsNotNull()
		{
			return !cx_CoreOtherAddresses.getValueIsNull(context);
		}
		public ims.core.vo.PersonAddressCollection getOtherAddresses()
		{
			return (ims.core.vo.PersonAddressCollection)cx_CoreOtherAddresses.getValue(context);
		}
		public void setOtherAddresses(ims.core.vo.PersonAddressCollection value)
		{
			cx_CoreOtherAddresses.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreOtherAddresses = new ims.framework.ContextVariable("Core.OtherAddresses", "_cv_Core.OtherAddresses");
		public boolean getParentFormModeIsNotNull()
		{
			return !cx_CoreParentFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getParentFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreParentFormMode.getValue(context);
		}
		public void setParentFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_CoreParentFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreParentFormMode = new ims.framework.ContextVariable("Core.ParentFormMode", "_cv_Core.ParentFormMode");
		public boolean getGPPracticeIsNotNull()
		{
			return !cx_CoreGPPractice.getValueIsNull(context);
		}
		public ims.core.vo.OrgLiteVo getGPPractice()
		{
			return (ims.core.vo.OrgLiteVo)cx_CoreGPPractice.getValue(context);
		}
		public void setGPPractice(ims.core.vo.OrgLiteVo value)
		{
			cx_CoreGPPractice.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPPractice = new ims.framework.ContextVariable("Core.GPPractice", "_cv_Core.GPPractice");
		public boolean getGPSurgeryIsNotNull()
		{
			return !cx_CoreGPSurgery.getValueIsNull(context);
		}
		public ims.core.vo.LocSiteShortVo getGPSurgery()
		{
			return (ims.core.vo.LocSiteShortVo)cx_CoreGPSurgery.getValue(context);
		}
		public void setGPSurgery(ims.core.vo.LocSiteShortVo value)
		{
			cx_CoreGPSurgery.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPSurgery = new ims.framework.ContextVariable("Core.GPSurgery", "_cv_Core.GPSurgery");
		public boolean getHideCancelButtonIsNotNull()
		{
			return !cx_CoreHideCancelButton.getValueIsNull(context);
		}
		public Boolean getHideCancelButton()
		{
			return (Boolean)cx_CoreHideCancelButton.getValue(context);
		}
		public void setHideCancelButton(Boolean value)
		{
			cx_CoreHideCancelButton.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHideCancelButton = new ims.framework.ContextVariable("Core.HideCancelButton", "_cv_Core.HideCancelButton");
		public boolean getPatientToBeDisplayedIsNotNull()
		{
			return !cx_CorePatientToBeDisplayed.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientToBeDisplayed()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientToBeDisplayed.getValue(context);
		}
		public void setPatientToBeDisplayed(ims.core.vo.PatientShort value)
		{
			cx_CorePatientToBeDisplayed.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientToBeDisplayed = new ims.framework.ContextVariable("Core.PatientToBeDisplayed", "_cv_Core.PatientToBeDisplayed");
		public boolean getDeathDetailsIsNotNull()
		{
			return !cx_CoreDeathDetails.getValueIsNull(context);
		}
		public ims.core.vo.DeathDetailsVo getDeathDetails()
		{
			return (ims.core.vo.DeathDetailsVo)cx_CoreDeathDetails.getValue(context);
		}
		public void setDeathDetails(ims.core.vo.DeathDetailsVo value)
		{
			cx_CoreDeathDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreDeathDetails = new ims.framework.ContextVariable("Core.DeathDetails", "_cv_Core.DeathDetails");
		public boolean getPersonAddressIsNotNull()
		{
			return !cx_CorePersonAddress.getValueIsNull(context);
		}
		public ims.core.vo.PersonAddress getPersonAddress()
		{
			return (ims.core.vo.PersonAddress)cx_CorePersonAddress.getValue(context);
		}
		public void setPersonAddress(ims.core.vo.PersonAddress value)
		{
			cx_CorePersonAddress.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePersonAddress = new ims.framework.ContextVariable("Core.PersonAddress", "_cv_Core.PersonAddress");
		public boolean getAddressSearchTypeIsNotNull()
		{
			return !cx_CoreAddressSearchType.getValueIsNull(context);
		}
		public String getAddressSearchType()
		{
			return (String)cx_CoreAddressSearchType.getValue(context);
		}
		public void setAddressSearchType(String value)
		{
			cx_CoreAddressSearchType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreAddressSearchType = new ims.framework.ContextVariable("Core.AddressSearchType", "_cv_Core.AddressSearchType");
		public boolean getAddressSearchTextIsNotNull()
		{
			return !cx_CoreAddressSearchText.getValueIsNull(context);
		}
		public String getAddressSearchText()
		{
			return (String)cx_CoreAddressSearchText.getValue(context);
		}
		public void setAddressSearchText(String value)
		{
			cx_CoreAddressSearchText.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreAddressSearchText = new ims.framework.ContextVariable("Core.AddressSearchText", "_cv_Core.AddressSearchText");
		public boolean getNOKPersonAddressIsNotNull()
		{
			return !cx_CoreNOKPersonAddress.getValueIsNull(context);
		}
		public ims.core.vo.PersonAddress getNOKPersonAddress()
		{
			return (ims.core.vo.PersonAddress)cx_CoreNOKPersonAddress.getValue(context);
		}
		public void setNOKPersonAddress(ims.core.vo.PersonAddress value)
		{
			cx_CoreNOKPersonAddress.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreNOKPersonAddress = new ims.framework.ContextVariable("Core.NOKPersonAddress", "_cv_Core.NOKPersonAddress");
		public boolean getCommentDialogStringIsNotNull()
		{
			return !cx_CoreCommentDialogString.getValueIsNull(context);
		}
		public String getCommentDialogString()
		{
			return (String)cx_CoreCommentDialogString.getValue(context);
		}
		public void setCommentDialogString(String value)
		{
			cx_CoreCommentDialogString.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogString = new ims.framework.ContextVariable("Core.CommentDialogString", "_cv_Core.CommentDialogString");
		public boolean getPatientImageIsNotNull()
		{
			return !cx_CorePatientImage.getValueIsNull(context);
		}
		public ims.core.vo.AppDBImageVo getPatientImage()
		{
			return (ims.core.vo.AppDBImageVo)cx_CorePatientImage.getValue(context);
		}
		public void setPatientImage(ims.core.vo.AppDBImageVo value)
		{
			cx_CorePatientImage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientImage = new ims.framework.ContextVariable("Core.PatientImage", "_cv_Core.PatientImage");
		public boolean getPatientPhotoTempFilesIsNotNull()
		{
			return !cx_CorePatientPhotoTempFiles.getValueIsNull(context);
		}
		public java.util.ArrayList<String> getPatientPhotoTempFiles()
		{
			return (java.util.ArrayList<String>)cx_CorePatientPhotoTempFiles.getValue(context);
		}
		public void setPatientPhotoTempFiles(java.util.ArrayList<String> value)
		{
			cx_CorePatientPhotoTempFiles.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientPhotoTempFiles = new ims.framework.ContextVariable("Core.PatientPhotoTempFiles", "_cv_Core.PatientPhotoTempFiles");
		public boolean getCommentDialogReadOnlyIsNotNull()
		{
			return !cx_CoreCommentDialogReadOnly.getValueIsNull(context);
		}
		public Boolean getCommentDialogReadOnly()
		{
			return (Boolean)cx_CoreCommentDialogReadOnly.getValue(context);
		}
		public void setCommentDialogReadOnly(Boolean value)
		{
			cx_CoreCommentDialogReadOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogReadOnly = new ims.framework.ContextVariable("Core.CommentDialogReadOnly", "_cv_Core.CommentDialogReadOnly");
		public boolean getCommentDialogTitleIsNotNull()
		{
			return !cx_CoreCommentDialogTitle.getValueIsNull(context);
		}
		public String getCommentDialogTitle()
		{
			return (String)cx_CoreCommentDialogTitle.getValue(context);
		}
		public void setCommentDialogTitle(String value)
		{
			cx_CoreCommentDialogTitle.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommentDialogTitle = new ims.framework.ContextVariable("Core.CommentDialogTitle", "_cv_Core.CommentDialogTitle");
		public boolean getAliasNameIsNotNull()
		{
			return !cx_CoreAliasName.getValueIsNull(context);
		}
		public String getAliasName()
		{
			return (String)cx_CoreAliasName.getValue(context);
		}
		public void setAliasName(String value)
		{
			cx_CoreAliasName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreAliasName = new ims.framework.ContextVariable("Core.AliasName", "_cv_Core.AliasName");
		public boolean getCommChannelsIsNotNull()
		{
			return !cx_CoreCommChannels.getValueIsNull(context);
		}
		public ims.core.vo.CommChannelVoCollection getCommChannels()
		{
			return (ims.core.vo.CommChannelVoCollection)cx_CoreCommChannels.getValue(context);
		}
		public void setCommChannels(ims.core.vo.CommChannelVoCollection value)
		{
			cx_CoreCommChannels.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommChannels = new ims.framework.ContextVariable("Core.CommChannels", "_cv_Core.CommChannels");
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
		public boolean getGPPracticeWithCommIsNotNull()
		{
			return !cx_CoreGPPracticeWithComm.getValueIsNull(context);
		}
		public ims.core.vo.OrganisationWithSitesVo getGPPracticeWithComm()
		{
			return (ims.core.vo.OrganisationWithSitesVo)cx_CoreGPPracticeWithComm.getValue(context);
		}
		public void setGPPracticeWithComm(ims.core.vo.OrganisationWithSitesVo value)
		{
			cx_CoreGPPracticeWithComm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPPracticeWithComm = new ims.framework.ContextVariable("Core.GPPracticeWithComm", "_cv_Core.GPPracticeWithComm");

		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public void clearCatsReferral()
		{
			cx_CareUkCatsReferral.setValue(context, null);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferral = new ims.framework.ContextVariable("CareUk.CatsReferral", "_cvp_CareUk.CatsReferral");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public CareUkContext CareUk;
}
