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

package ims.oncology.forms.internalreferrallist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Oncology = new OncologyContext(context);
		Core = new CoreContext(context);
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getInternalReferralRefIsNotNull()
		{
			return !cx_OncologyInternalReferralRef.getValueIsNull(context);
		}
		public ims.oncology.vo.InternalReferralRefVo getInternalReferralRef()
		{
			return (ims.oncology.vo.InternalReferralRefVo)cx_OncologyInternalReferralRef.getValue(context);
		}
		public void setInternalReferralRef(ims.oncology.vo.InternalReferralRefVo value)
		{
			cx_OncologyInternalReferralRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyInternalReferralRef = new ims.framework.ContextVariable("Oncology.InternalReferralRef", "_cv_Oncology.InternalReferralRef");
		public boolean getInternalReferralListFilterIsNotNull()
		{
			return !cx_OncologyInternalReferralListFilter.getValueIsNull(context);
		}
		public ims.oncology.vo.InternalReferralListFilterVo getInternalReferralListFilter()
		{
			return (ims.oncology.vo.InternalReferralListFilterVo)cx_OncologyInternalReferralListFilter.getValue(context);
		}
		public void setInternalReferralListFilter(ims.oncology.vo.InternalReferralListFilterVo value)
		{
			cx_OncologyInternalReferralListFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyInternalReferralListFilter = new ims.framework.ContextVariable("Oncology.InternalReferralListFilter", "_cvp_Oncology.InternalReferralListFilter");

		private ims.framework.Context context;
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

		private ims.framework.Context context;
	}

	public OncologyContext Oncology;
	public CoreContext Core;
}
