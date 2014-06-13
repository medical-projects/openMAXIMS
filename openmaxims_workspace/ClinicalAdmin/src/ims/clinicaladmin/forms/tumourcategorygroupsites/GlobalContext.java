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

package ims.clinicaladmin.forms.tumourcategorygroupsites;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Oncology = new OncologyContext(context);
		ClinicalAdmin = new ClinicalAdminContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getSpecialtiesIsNotNull()
		{
			return !cx_CoreSpecialties.getValueIsNull(context);
		}
		public ims.core.vo.lookups.SpecialtyCollection getSpecialties()
		{
			return (ims.core.vo.lookups.SpecialtyCollection)cx_CoreSpecialties.getValue(context);
		}
		public void setSpecialties(ims.core.vo.lookups.SpecialtyCollection value)
		{
			cx_CoreSpecialties.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSpecialties = new ims.framework.ContextVariable("Core.Specialties", "_cv_Core.Specialties");

		private ims.framework.Context context;
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedRecordForOverallDialogIsNotNull()
		{
			return !cx_OncologySelectedRecordForOverallDialog.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo getSelectedRecordForOverallDialog()
		{
			return (ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo)cx_OncologySelectedRecordForOverallDialog.getValue(context);
		}
		public void setSelectedRecordForOverallDialog(ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo value)
		{
			cx_OncologySelectedRecordForOverallDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologySelectedRecordForOverallDialog = new ims.framework.ContextVariable("Oncology.SelectedRecordForOverallDialog", "_cv_Oncology.SelectedRecordForOverallDialog");
		public boolean getOverallStagingDynamicGridCollectionIsNotNull()
		{
			return !cx_OncologyOverallStagingDynamicGridCollection.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection getOverallStagingDynamicGridCollection()
		{
			return (ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection)cx_OncologyOverallStagingDynamicGridCollection.getValue(context);
		}
		public void setOverallStagingDynamicGridCollection(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection value)
		{
			cx_OncologyOverallStagingDynamicGridCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyOverallStagingDynamicGridCollection = new ims.framework.ContextVariable("Oncology.OverallStagingDynamicGridCollection", "_cv_Oncology.OverallStagingDynamicGridCollection");

		private ims.framework.Context context;
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTumourGroupOtherClassificationIsNotNull()
		{
			return !cx_ClinicalAdminTumourGroupOtherClassification.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.StagingClassificationVoCollection getTumourGroupOtherClassification()
		{
			return (ims.clinicaladmin.vo.StagingClassificationVoCollection)cx_ClinicalAdminTumourGroupOtherClassification.getValue(context);
		}
		public void setTumourGroupOtherClassification(ims.clinicaladmin.vo.StagingClassificationVoCollection value)
		{
			cx_ClinicalAdminTumourGroupOtherClassification.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourGroupOtherClassification = new ims.framework.ContextVariable("ClinicalAdmin.TumourGroupOtherClassification", "_cv_ClinicalAdmin.TumourGroupOtherClassification");
		public boolean getTumourDifferentiaionIsNotNull()
		{
			return !cx_ClinicalAdminTumourDifferentiaion.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.HistopathologicGradeVo getTumourDifferentiaion()
		{
			return (ims.clinicaladmin.vo.HistopathologicGradeVo)cx_ClinicalAdminTumourDifferentiaion.getValue(context);
		}
		public void setTumourDifferentiaion(ims.clinicaladmin.vo.HistopathologicGradeVo value)
		{
			cx_ClinicalAdminTumourDifferentiaion.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourDifferentiaion = new ims.framework.ContextVariable("ClinicalAdmin.TumourDifferentiaion", "_cv_ClinicalAdmin.TumourDifferentiaion");
		public boolean getTumourSerumMarkerIsNotNull()
		{
			return !cx_ClinicalAdminTumourSerumMarker.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourSerumMarkersLiteVo getTumourSerumMarker()
		{
			return (ims.clinicaladmin.vo.TumourSerumMarkersLiteVo)cx_ClinicalAdminTumourSerumMarker.getValue(context);
		}
		public void setTumourSerumMarker(ims.clinicaladmin.vo.TumourSerumMarkersLiteVo value)
		{
			cx_ClinicalAdminTumourSerumMarker.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourSerumMarker = new ims.framework.ContextVariable("ClinicalAdmin.TumourSerumMarker", "_cv_ClinicalAdmin.TumourSerumMarker");
		public boolean getTumourSiteIsNotNull()
		{
			return !cx_ClinicalAdminTumourSite.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourSiteVo getTumourSite()
		{
			return (ims.clinicaladmin.vo.TumourSiteVo)cx_ClinicalAdminTumourSite.getValue(context);
		}
		public void setTumourSite(ims.clinicaladmin.vo.TumourSiteVo value)
		{
			cx_ClinicalAdminTumourSite.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourSite = new ims.framework.ContextVariable("ClinicalAdmin.TumourSite", "_cv_ClinicalAdmin.TumourSite");
		public boolean getTumourHistologyIsNotNull()
		{
			return !cx_ClinicalAdminTumourHistology.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourHistologyLiteVo getTumourHistology()
		{
			return (ims.clinicaladmin.vo.TumourHistologyLiteVo)cx_ClinicalAdminTumourHistology.getValue(context);
		}
		public void setTumourHistology(ims.clinicaladmin.vo.TumourHistologyLiteVo value)
		{
			cx_ClinicalAdminTumourHistology.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourHistology = new ims.framework.ContextVariable("ClinicalAdmin.TumourHistology", "_cv_ClinicalAdmin.TumourHistology");
		public boolean getSelectedPrognosticGleasonIsNotNull()
		{
			return !cx_ClinicalAdminSelectedPrognosticGleason.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.GleasonConfigLiteVo getSelectedPrognosticGleason()
		{
			return (ims.clinicaladmin.vo.GleasonConfigLiteVo)cx_ClinicalAdminSelectedPrognosticGleason.getValue(context);
		}
		public void setSelectedPrognosticGleason(ims.clinicaladmin.vo.GleasonConfigLiteVo value)
		{
			cx_ClinicalAdminSelectedPrognosticGleason.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminSelectedPrognosticGleason = new ims.framework.ContextVariable("ClinicalAdmin.SelectedPrognosticGleason", "_cv_ClinicalAdmin.SelectedPrognosticGleason");
		public boolean getSelectedPrognosticLocationIsNotNull()
		{
			return !cx_ClinicalAdminSelectedPrognosticLocation.getValueIsNull(context);
		}
		public ims.oncology.vo.PrognosticLocationConfigVo getSelectedPrognosticLocation()
		{
			return (ims.oncology.vo.PrognosticLocationConfigVo)cx_ClinicalAdminSelectedPrognosticLocation.getValue(context);
		}
		public void setSelectedPrognosticLocation(ims.oncology.vo.PrognosticLocationConfigVo value)
		{
			cx_ClinicalAdminSelectedPrognosticLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminSelectedPrognosticLocation = new ims.framework.ContextVariable("ClinicalAdmin.SelectedPrognosticLocation", "_cv_ClinicalAdmin.SelectedPrognosticLocation");
		public boolean getSelectedPrognosticPSAIsNotNull()
		{
			return !cx_ClinicalAdminSelectedPrognosticPSA.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.PSAConfigVo getSelectedPrognosticPSA()
		{
			return (ims.clinicaladmin.vo.PSAConfigVo)cx_ClinicalAdminSelectedPrognosticPSA.getValue(context);
		}
		public void setSelectedPrognosticPSA(ims.clinicaladmin.vo.PSAConfigVo value)
		{
			cx_ClinicalAdminSelectedPrognosticPSA.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminSelectedPrognosticPSA = new ims.framework.ContextVariable("ClinicalAdmin.SelectedPrognosticPSA", "_cv_ClinicalAdmin.SelectedPrognosticPSA");
		public boolean getSelectedPrognosticRiskAssessmentIsNotNull()
		{
			return !cx_ClinicalAdminSelectedPrognosticRiskAssessment.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.PrognosticRiskConfigVo getSelectedPrognosticRiskAssessment()
		{
			return (ims.clinicaladmin.vo.PrognosticRiskConfigVo)cx_ClinicalAdminSelectedPrognosticRiskAssessment.getValue(context);
		}
		public void setSelectedPrognosticRiskAssessment(ims.clinicaladmin.vo.PrognosticRiskConfigVo value)
		{
			cx_ClinicalAdminSelectedPrognosticRiskAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminSelectedPrognosticRiskAssessment = new ims.framework.ContextVariable("ClinicalAdmin.SelectedPrognosticRiskAssessment", "_cv_ClinicalAdmin.SelectedPrognosticRiskAssessment");
		public boolean getTumourGroupIsNotNull()
		{
			return !cx_ClinicalAdminTumourGroup.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupVo getTumourGroup()
		{
			return (ims.clinicaladmin.vo.TumourGroupVo)cx_ClinicalAdminTumourGroup.getValue(context);
		}
		public void setTumourGroup(ims.clinicaladmin.vo.TumourGroupVo value)
		{
			cx_ClinicalAdminTumourGroup.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourGroup = new ims.framework.ContextVariable("ClinicalAdmin.TumourGroup", "_cv_ClinicalAdmin.TumourGroup");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public OncologyContext Oncology;
	public ClinicalAdminContext ClinicalAdmin;
}
