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

package ims.clinical.forms.deathdetails;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getParentFormModeIsNotNull()
		{
			return !cx_CoreParentFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getParentFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreParentFormMode.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreParentFormMode = new ims.framework.ContextVariable("Core.ParentFormMode", "_cv_Core.ParentFormMode");
		public boolean getTaxonomyMapIsNotNull()
		{
			return !cx_CoreTaxonomyMap.getValueIsNull(context);
		}
		public ims.core.vo.TaxonomyMap getTaxonomyMap()
		{
			return (ims.core.vo.TaxonomyMap)cx_CoreTaxonomyMap.getValue(context);
		}
		public void setTaxonomyMap(ims.core.vo.TaxonomyMap value)
		{
			cx_CoreTaxonomyMap.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomyMap = new ims.framework.ContextVariable("Core.TaxonomyMap", "_cv_Core.TaxonomyMap");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
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

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedPatientDiagnosisListVoIsNotNull()
		{
			return !cx_ClinicalSelectedPatientDiagnosisListVo.getValueIsNull(context);
		}
		public ims.core.vo.PatientDiagnosisListVo getSelectedPatientDiagnosisListVo()
		{
			return (ims.core.vo.PatientDiagnosisListVo)cx_ClinicalSelectedPatientDiagnosisListVo.getValue(context);
		}
		public void setSelectedPatientDiagnosisListVo(ims.core.vo.PatientDiagnosisListVo value)
		{
			cx_ClinicalSelectedPatientDiagnosisListVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientDiagnosisListVo = new ims.framework.ContextVariable("Clinical.SelectedPatientDiagnosisListVo", "_cv_Clinical.SelectedPatientDiagnosisListVo");
		public boolean getSelectedDiagnosisIsNotNull()
		{
			return !cx_ClinicalSelectedDiagnosis.getValueIsNull(context);
		}
		public ims.core.vo.DiagLiteVoCollection getSelectedDiagnosis()
		{
			return (ims.core.vo.DiagLiteVoCollection)cx_ClinicalSelectedDiagnosis.getValue(context);
		}
		public void setSelectedDiagnosis(ims.core.vo.DiagLiteVoCollection value)
		{
			cx_ClinicalSelectedDiagnosis.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedDiagnosis = new ims.framework.ContextVariable("Clinical.SelectedDiagnosis", "_cv_Clinical.SelectedDiagnosis");
		public boolean getLocallyConfiguredDiagnosisIsNotNull()
		{
			return !cx_ClinicalLocallyConfiguredDiagnosis.getValueIsNull(context);
		}
		public Boolean getLocallyConfiguredDiagnosis()
		{
			return (Boolean)cx_ClinicalLocallyConfiguredDiagnosis.getValue(context);
		}
		public void setLocallyConfiguredDiagnosis(Boolean value)
		{
			cx_ClinicalLocallyConfiguredDiagnosis.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalLocallyConfiguredDiagnosis = new ims.framework.ContextVariable("Clinical.LocallyConfiguredDiagnosis", "_cv_Clinical.LocallyConfiguredDiagnosis");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public ClinicalContext Clinical;
}
