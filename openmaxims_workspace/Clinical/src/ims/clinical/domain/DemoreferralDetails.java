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

package ims.clinical.domain;

// Generated from form domain impl
public interface DemoreferralDetails extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* saveReferralsRecording
	*/
	public ims.clinical.vo.ReferralsRecordingVo saveReferralsRecording(ims.clinical.vo.ReferralsRecordingVo referVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* geStagingClassification
	*/
	public ims.clinical.vo.ReferralsRecordingVo getPrimaryPreecedingReferralRecording(ims.core.admin.vo.CareSpellRefVo csRefVo);

	// Generated from form domain interface definition
	/**
	* listReferralsRecording
	*/
	public ims.clinical.vo.ReferralsRecordingShortVoCollection listReferralsRecording(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* list Hcps by a HcpFilter and then a subtype(e.g) MedicType - The class will be detemined by the hcptype populated in the HcpFilter
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter, ims.core.vo.lookups.HcpDisType subType);

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	public ims.core.vo.OrganisationWithSitesVoCollection listPractice(ims.admin.vo.PracticeSearchCriteriaVo filter);

	// Generated from form domain interface definition
	/**
	* listGPsBySurname
	*/
	public ims.core.vo.GpShortVoCollection listGPsBySurname(String surname);

	// Generated from form domain interface definition
	/**
	* get Specific record by id
	*/
	public ims.clinical.vo.ReferralsRecordingVo getReferralRecording(ims.clinical.vo.ReferralsRecordingRefVo rrRefVo);

	// Generated from form domain interface definition
	/**
	* List Oraganisations
	*/
	public ims.core.vo.OrganisationVoCollection listOrganisation(ims.core.vo.OrganisationVo organisation);

	// Generated from form domain interface definition
	/**
	* Get a GP by ID
	*/
	public ims.core.vo.GP getGP(ims.core.resource.people.vo.GpRefVo gpRefVo);

	// Generated from form domain interface definition
	/**
	* getMemberOfStaff
	*/
	public ims.core.vo.MemberOfStaffShortVo getMemberOfStaff(ims.core.resource.people.vo.MemberOfStaffRefVo mosRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.LocationServiceVo getLocationService(ims.core.vo.LocShortVo locShort, ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	public ims.core.vo.LocShortVoCollection listLocationsForMemberOfStaff(ims.core.resource.people.vo.MemberOfStaffRefVo mos);

	// Generated from form domain interface definition
	/**
	* Returns a HcpLiteVo
	*/
	public ims.core.vo.HcpLiteVo getHcpLiteById(ims.core.resource.people.vo.HcpRefVo refId);
}
