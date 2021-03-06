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

package ims.ocrr.forms.careuknewresults;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		CareUk = new CareUkContext(context);
		Core = new CoreContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCareUkNewResultsSearchCriteriaIsNotNull()
		{
			return !cx_OCRRCareUkNewResultsSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.NewResultsSearchCriteriaVo getCareUkNewResultsSearchCriteria()
		{
			return (ims.ocrr.vo.NewResultsSearchCriteriaVo)cx_OCRRCareUkNewResultsSearchCriteria.getValue(context);
		}
		public void setCareUkNewResultsSearchCriteria(ims.ocrr.vo.NewResultsSearchCriteriaVo value)
		{
			cx_OCRRCareUkNewResultsSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRCareUkNewResultsSearchCriteria = new ims.framework.ContextVariable("OCRR.CareUkNewResultsSearchCriteria", "_cvp_OCRR.CareUkNewResultsSearchCriteria");
		public boolean getCurrentPathRadResultIsNotNull()
		{
			return !cx_OCRRCurrentPathRadResult.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsPathRadResultVo getCurrentPathRadResult()
		{
			return (ims.ocrr.vo.OcsPathRadResultVo)cx_OCRRCurrentPathRadResult.getValue(context);
		}
		public void setCurrentPathRadResult(ims.ocrr.vo.OcsPathRadResultVo value)
		{
			cx_OCRRCurrentPathRadResult.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRCurrentPathRadResult = new ims.framework.ContextVariable("OCRR.CurrentPathRadResult", "_cv_OCRR.CurrentPathRadResult");
		public boolean getSelectedPathRadResultsIsNotNull()
		{
			return !cx_OCRRSelectedPathRadResults.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsPathRadResultVoCollection getSelectedPathRadResults()
		{
			return (ims.ocrr.vo.OcsPathRadResultVoCollection)cx_OCRRSelectedPathRadResults.getValue(context);
		}
		public void setSelectedPathRadResults(ims.ocrr.vo.OcsPathRadResultVoCollection value)
		{
			cx_OCRRSelectedPathRadResults.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedPathRadResults = new ims.framework.ContextVariable("OCRR.SelectedPathRadResults", "_cv_OCRR.SelectedPathRadResults");
		public boolean getRoleDisciplineSecurityLevelsIsNotNull()
		{
			return !cx_OCRRRoleDisciplineSecurityLevels.getValueIsNull(context);
		}
		public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels()
		{
			return (ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo)cx_OCRRRoleDisciplineSecurityLevels.getValue(context);
		}
		public void setRoleDisciplineSecurityLevels(ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo value)
		{
			cx_OCRRRoleDisciplineSecurityLevels.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRRoleDisciplineSecurityLevels = new ims.framework.ContextVariable("OCRR.RoleDisciplineSecurityLevels", "_cvp_OCRR.RoleDisciplineSecurityLevels");

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
		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_CareUkReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_CareUkReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_CareUkReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkReferralContractTypeForPatient = new ims.framework.ContextVariable("CareUk.ReferralContractTypeForPatient", "_cvp_CareUk.ReferralContractTypeForPatient");

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
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
	public CareUkContext CareUk;
	public CoreContext Core;
}
