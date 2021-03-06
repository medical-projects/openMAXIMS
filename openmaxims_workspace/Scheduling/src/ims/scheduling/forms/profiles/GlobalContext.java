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

package ims.scheduling.forms.profiles;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Scheduling = new SchedulingContext(context);
		Admin = new AdminContext(context);
		Core = new CoreContext(context);
		Pathway = new PathwayContext(context);
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDirectoryofServicesCollectionIsNotNull()
		{
			return !cx_SchedulingDirectoryofServicesCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.DirectoryOfServiceVoCollection getDirectoryofServicesCollection()
		{
			return (ims.scheduling.vo.DirectoryOfServiceVoCollection)cx_SchedulingDirectoryofServicesCollection.getValue(context);
		}
		public void setDirectoryofServicesCollection(ims.scheduling.vo.DirectoryOfServiceVoCollection value)
		{
			cx_SchedulingDirectoryofServicesCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingDirectoryofServicesCollection = new ims.framework.ContextVariable("Scheduling.DirectoryofServicesCollection", "_cv_Scheduling.DirectoryofServicesCollection");
		public boolean getProfileSlotGenericIsNotNull()
		{
			return !cx_SchedulingProfileSlotGeneric.getValueIsNull(context);
		}
		public ims.scheduling.vo.Profile_SlotGenericVo getProfileSlotGeneric()
		{
			return (ims.scheduling.vo.Profile_SlotGenericVo)cx_SchedulingProfileSlotGeneric.getValue(context);
		}
		public void setProfileSlotGeneric(ims.scheduling.vo.Profile_SlotGenericVo value)
		{
			cx_SchedulingProfileSlotGeneric.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileSlotGeneric = new ims.framework.ContextVariable("Scheduling.ProfileSlotGeneric", "_cv_Scheduling.ProfileSlotGeneric");
		public boolean getProfileEndTimeIsNotNull()
		{
			return !cx_SchedulingProfileEndTime.getValueIsNull(context);
		}
		public ims.framework.utils.Time getProfileEndTime()
		{
			return (ims.framework.utils.Time)cx_SchedulingProfileEndTime.getValue(context);
		}
		public void setProfileEndTime(ims.framework.utils.Time value)
		{
			cx_SchedulingProfileEndTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileEndTime = new ims.framework.ContextVariable("Scheduling.ProfileEndTime", "_cv_Scheduling.ProfileEndTime");
		public boolean getListOwnerCollectionIsNotNull()
		{
			return !cx_SchedulingListOwnerCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.Profile_ListOwnerVoCollection getListOwnerCollection()
		{
			return (ims.scheduling.vo.Profile_ListOwnerVoCollection)cx_SchedulingListOwnerCollection.getValue(context);
		}
		public void setListOwnerCollection(ims.scheduling.vo.Profile_ListOwnerVoCollection value)
		{
			cx_SchedulingListOwnerCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingListOwnerCollection = new ims.framework.ContextVariable("Scheduling.ListOwnerCollection", "_cv_Scheduling.ListOwnerCollection");
		public boolean getProfileServiceIsNotNull()
		{
			return !cx_SchedulingProfileService.getValueIsNull(context);
		}
		public ims.core.clinical.vo.ServiceRefVo getProfileService()
		{
			return (ims.core.clinical.vo.ServiceRefVo)cx_SchedulingProfileService.getValue(context);
		}
		public void setProfileService(ims.core.clinical.vo.ServiceRefVo value)
		{
			cx_SchedulingProfileService.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileService = new ims.framework.ContextVariable("Scheduling.ProfileService", "_cv_Scheduling.ProfileService");
		public boolean getProfileStartTimeIsNotNull()
		{
			return !cx_SchedulingProfileStartTime.getValueIsNull(context);
		}
		public ims.framework.utils.Time getProfileStartTime()
		{
			return (ims.framework.utils.Time)cx_SchedulingProfileStartTime.getValue(context);
		}
		public void setProfileStartTime(ims.framework.utils.Time value)
		{
			cx_SchedulingProfileStartTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileStartTime = new ims.framework.ContextVariable("Scheduling.ProfileStartTime", "_cv_Scheduling.ProfileStartTime");
		public boolean getProfileParentChildSlotIsNotNull()
		{
			return !cx_SchedulingProfileParentChildSlot.getValueIsNull(context);
		}
		public ims.scheduling.vo.ProfileParentChildSlotVo getProfileParentChildSlot()
		{
			return (ims.scheduling.vo.ProfileParentChildSlotVo)cx_SchedulingProfileParentChildSlot.getValue(context);
		}
		public void setProfileParentChildSlot(ims.scheduling.vo.ProfileParentChildSlotVo value)
		{
			cx_SchedulingProfileParentChildSlot.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileParentChildSlot = new ims.framework.ContextVariable("Scheduling.ProfileParentChildSlot", "_cv_Scheduling.ProfileParentChildSlot");
		public boolean getProfileTheatreSlotIsNotNull()
		{
			return !cx_SchedulingProfileTheatreSlot.getValueIsNull(context);
		}
		public ims.scheduling.vo.ProfileTheatreTCISlotVo getProfileTheatreSlot()
		{
			return (ims.scheduling.vo.ProfileTheatreTCISlotVo)cx_SchedulingProfileTheatreSlot.getValue(context);
		}
		public void setProfileTheatreSlot(ims.scheduling.vo.ProfileTheatreTCISlotVo value)
		{
			cx_SchedulingProfileTheatreSlot.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingProfileTheatreSlot = new ims.framework.ContextVariable("Scheduling.ProfileTheatreSlot", "_cv_Scheduling.ProfileTheatreSlot");

		private ims.framework.Context context;
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getProfileLocationIsNotNull()
		{
			return !cx_AdminProfileLocation.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getProfileLocation()
		{
			return (ims.core.vo.LocShortVo)cx_AdminProfileLocation.getValue(context);
		}
		public void setProfileLocation(ims.core.vo.LocShortVo value)
		{
			cx_AdminProfileLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminProfileLocation = new ims.framework.ContextVariable("Admin.ProfileLocation", "_cv_Admin.ProfileLocation");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReportTemplateRefIsNotNull()
		{
			return !cx_CoreReportTemplateRef.getValueIsNull(context);
		}
		public ims.core.admin.vo.TemplateBoRefVo getReportTemplateRef()
		{
			return (ims.core.admin.vo.TemplateBoRefVo)cx_CoreReportTemplateRef.getValue(context);
		}
		public void setReportTemplateRef(ims.core.admin.vo.TemplateBoRefVo value)
		{
			cx_CoreReportTemplateRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportTemplateRef = new ims.framework.ContextVariable("Core.ReportTemplateRef", "_cv_Core.ReportTemplateRef");
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

		private ims.framework.Context context;
	}
	public final class PathwayContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwayContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedEventLiteVoIsNotNull()
		{
			return !cx_PathwaySelectedEventLiteVo.getValueIsNull(context);
		}
		public ims.pathways.vo.EventLiteVo getSelectedEventLiteVo()
		{
			return (ims.pathways.vo.EventLiteVo)cx_PathwaySelectedEventLiteVo.getValue(context);
		}
		public void setSelectedEventLiteVo(ims.pathways.vo.EventLiteVo value)
		{
			cx_PathwaySelectedEventLiteVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaySelectedEventLiteVo = new ims.framework.ContextVariable("Pathway.SelectedEventLiteVo", "_cv_Pathway.SelectedEventLiteVo");

		private ims.framework.Context context;
	}

	public SchedulingContext Scheduling;
	public AdminContext Admin;
	public CoreContext Core;
	public PathwayContext Pathway;
}
