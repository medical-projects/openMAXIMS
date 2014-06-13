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

package ims.ocrr.domain;

// Generated from form domain impl
public interface PathologyResults extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listClinicians
	*/
	public ims.core.vo.HcpLiteVoCollection listClinicians(String name);

	// Generated from form domain interface definition
	public ims.ocrr.vo.InvestigationIndexLiteVoCollection listInvestigationTypes(String name);

	// Generated from form domain interface definition
	public ims.ocrr.vo.PathologyResultListShortVoCollection listResults(ims.core.patient.vo.PatientRefVo patient, ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate, ims.ocrr.configuration.vo.InvestigationIndexRefVo investigationType, ims.core.vo.ServiceLiteVo discipline, ims.core.resource.people.vo.HcpRefVo clinician, Boolean resultsOnly) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceLiteVoCollection listDiscipline();

	// Generated from form domain interface definition
	/**
	* Lists all configured chart types
	*/
	public ims.core.vo.ChartTypeShortVoCollection listChartTypes();

	// Generated from form domain interface definition
	public ims.core.vo.ChartResultVoCollection listChartResults(ims.core.patient.vo.PatientRefVo patient, ims.core.charting.vo.ChartTypeRefVo chartType, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, Boolean isTabularView) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getChartType
	*/
	public ims.core.vo.ChartTypeVo getChartType(ims.core.charting.vo.ChartTypeRefVo id);

	// Generated from form domain interface definition
	/**
	* listInvestigationTypesSynonyms
	*/
	public ims.ocrr.vo.InvestigationIndexLiteVoCollection listInvestigationTypesSynonyms(String name, Boolean beginWith);

	// Generated from form domain interface definition
	/**
	* getRoleDisciplineSecurityLevels
	*/
	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role);

	// Generated from form domain interface definition
	public String[] getSystemReportAndTemplate(Integer imsId);

	// Generated from form domain interface definition
	/**
	* getSpecimenWorkListItemDateToCollectBySpecimen
	*/
	public ims.framework.utils.Date getSpecimenWorkListItemDateToCollectBySpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo specimen);

	// Generated from form domain interface definition
	public String getMappingForResultStatusLookup(ims.ocrr.vo.lookups.ResultStatus resultStatusInstance, ims.core.vo.lookups.TaxonomyType extSystem);

	// Generated from form domain interface definition
	public ims.framework.utils.Date getSpecimenWorkListItemDateToCollectByInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigation);

	// Generated from form domain interface definition
	public ims.ocrr.vo.SpecimenWorkListItemDateToCollectVoCollection getSpecimensWithDateToCollect(String specimensIds);
}
