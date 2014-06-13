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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseSupportNetworkProfessionalServicesImpl extends DomainImpl implements ims.core.domain.SupportNetworkProfessionalServices, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkProfessionalByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupportNetworkProfessional(ims.core.vo.SupportNetworkProfessionalVo supportNetworkProfessional, ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter, ims.core.vo.lookups.HcpDisType subType)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupportNetworkService(ims.core.vo.SupportNetworkServicesVo supportNetworkService, ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkServiceByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocations(ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validatecopyPreviousProfessionalData(ims.core.vo.SupportNetworkProfessionalVoCollection professionalVoCollection, ims.core.vo.CareContextShortVo careContextShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatecopyPreviousServiceData(ims.core.vo.SupportNetworkServicesVoCollection serviceVoCollection, ims.core.vo.CareContextShortVo careContextShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistService(ims.core.vo.lookups.ServiceCategory serviceType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationService(ims.core.vo.LocShortVo locShort, ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMembersOfStaffWithPrimaryLocations(ims.core.vo.MemberOfStaffShortVo voMemberOfStaffShortVo, ims.core.vo.lookups.HcpDisType hcpSUbtype)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcp(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistCareContexts(ims.core.patient.vo.PatientRefVo voPatientRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcps(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkProfessionalByPatient(Boolean activeOnly, ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupportNetworkProfessionaForPatient(ims.core.vo.SupportNetworkProfessionalVo voSupportNetworkProfessional, ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSupportNetworkServicesByPatient(Boolean activeOnly, ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSupportNetworkServicesForPatient(ims.core.vo.SupportNetworkServicesVo voSupportNetworkServices, ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistLocationsForMemberOfStaff(ims.core.resource.people.vo.MemberOfStaffRefVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGPDetails(ims.core.patient.vo.PatientRefVo patientRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistService(ims.core.vo.lookups.ServiceCategoryCollection excludedServices)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGpSurgeryByPatient(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientNoSupportNetworkServicesInfo(ims.core.vo.PatientNoSupportNetworkServicesInfoVo patientCoreClinicalDataVo)
	{
		if(patientCoreClinicalDataVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patientCoreClinicalDataVo' of type 'ims.core.vo.PatientNoSupportNetworkServicesInfoVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesavePatientNoSupportNetworkStatusInfo(ims.core.vo.PatientNoSupportNetworkStatusInfoVo voPatientNoSupportNetworkStatusInfo)
	{
		if(voPatientNoSupportNetworkStatusInfo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'voPatientNoSupportNetworkStatusInfo' of type 'ims.core.vo.PatientNoSupportNetworkStatusInfoVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPatientNoSupportNetworkServicesInfo(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
		if(patientRefVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patientRefVo' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPatientNoSupportNetworkStatusInfo(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
		if(patientRefVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patientRefVo' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
	}
}
