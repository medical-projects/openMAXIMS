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

package ims.nursing.domain;

// Generated from form domain impl
public interface NursingAdmission extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Save an admission detaisl record
	*/
	public ims.nursing.vo.AdmissionDetailsVo saveNursingAdmission(ims.nursing.vo.AdmissionDetailsVo voAdmissionDetails) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get a nursing admission record
	*/
	public ims.nursing.vo.AdmissionDetailsVo getNursingAdmission(ims.core.vo.CareContextLiteVo voCareContextLite);

	// Generated from form domain interface definition
	/**
	* Save a SupportNetworkFamily record
	*/
	public void saveSupportNetworkFamily(ims.core.vo.SupportNetworkFamilyCollection voSupportNetworkFamily) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Return a collection of supportnetworkFamily records.
	*/
	public ims.core.vo.SupportNetworkFamilyCollection listSupportNetworkFamily(Boolean active, ims.core.vo.PatientShort voPatient);

	// Generated from form domain interface definition
	/**
	* Return a list of Diagnosis
	*/
	public ims.core.vo.DiagLiteVoCollection listDiagnosis(String filter);

	// Generated from form domain interface definition
	/**
	* Return a list of diagnosis for a patient
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listPatientDiagnoses(ims.core.patient.vo.PatientRefVo patRefVo);

	// Generated from form domain interface definition
	/**
	* Return a list of patient procedures.
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listPatientProcedures(ims.core.patient.vo.PatientRefVo patRefVo);

	// Generated from form domain interface definition
	/**
	* Return a collection of diagnosis
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listEpisodeOfCareDiagnoses(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* Return a collection of procedures based on episode of care
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);
}
