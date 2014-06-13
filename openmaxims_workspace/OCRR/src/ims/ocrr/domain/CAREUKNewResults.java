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
public interface CAREUKNewResults extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list HCPs and GPs
	*/
	public ims.core.vo.HcpLiteVoCollection listClinicians(String name);

	// Generated from form domain interface definition
	public ims.core.vo.GpLiteVoCollection listGps(String nameFilter);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listWards(String name, ims.core.resource.place.vo.LocationRefVo voLocRef);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listSurgeries(String nameFilter);

	// Generated from form domain interface definition
	public ims.core.vo.ClinicLiteVoCollection listClinics(String nameFilter, ims.core.resource.place.vo.LocationRefVo voLocRef);

	// Generated from form domain interface definition
	public ims.ocrr.vo.NewResultsListVoCollection listNewResultsByDateRange(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, ims.vo.ValueObject location, ims.vo.ValueObject clinician, ims.ocrr.vo.lookups.OrderInvStatusCollection statuses, Boolean includeCurrentInpatients, Boolean excludeInpatients, Integer orderingHCPId, ims.core.clinical.vo.ServiceRefVo discipline, ims.core.vo.lookups.Specialty specialty, ims.core.vo.HcpLiteVo initiatingHcp);

	// Generated from form domain interface definition
	public ims.ocrr.orderingresults.vo.OrderSpecimenRefVo getSpecimenForResult(Integer orderInvId);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listHospitals();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listErDepts(String nameFilter, ims.core.resource.place.vo.LocationRefVo voLocRef);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listOtherLocations(String nameFilter, ims.core.resource.place.vo.LocationRefVo voLocRef);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceLiteVoCollection listDiscipline();

	// Generated from form domain interface definition
	/**
	* getRoleDisciplineSecurityLevels
	*/
	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	public String getMappingForResultStatusLookup(ims.ocrr.vo.lookups.ResultStatus resultStatusInstance, ims.core.vo.lookups.TaxonomyType extSystem);
}
