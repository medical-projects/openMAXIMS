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

package ims.oncology.domain;

// Generated from form domain impl
public interface RadioTherapyDetails extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Records
	*/
	public ims.oncology.vo.RadiotherapyDetailsShortVoCollection list(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare);

	// Generated from form domain interface definition
	/**
	* save
	*/
	public ims.oncology.vo.RadiotherapyDetailsVo save(ims.oncology.vo.RadiotherapyDetailsVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list Members Of Staff
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	/**
	* get
	*/
	public ims.oncology.vo.RadiotherapyDetailsVo get(ims.oncology.vo.RadiotherapyDetailsRefVo record);

	// Generated from form domain interface definition
	/**
	* list Location Site
	*/
	public ims.core.vo.LocSiteLiteVoCollection listLocSite(String locationName);

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteLiteVoCollection listHospitals(String locationName);

	// Generated from form domain interface definition
	public ims.oncology.vo.lookups.DiseaseStatusCollection listDiseaseStatus();

	// Generated from form domain interface definition
	public ims.oncology.vo.lookups.DiseaseStatusCollection listDiseaseStatusByParent(ims.oncology.vo.lookups.DiseaseStatus diseaseParent);

	// Generated from form domain interface definition
	public ims.core.vo.MedicVo getMedic(ims.core.resource.people.vo.HcpRefVo hcpId);

	// Generated from form domain interface definition
	/**
	* listPatient Diary Events
	*/
	public ims.oncology.vo.PatTreatmentPlanRadiotherapyDialogVoCollection listActivePatTreatMentPlans(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episode);

	// Generated from form domain interface definition
	public Boolean checkIfChosenPlanLinked(ims.ccosched.vo.PatTreatPlanActionLiteVo patAction);
}
