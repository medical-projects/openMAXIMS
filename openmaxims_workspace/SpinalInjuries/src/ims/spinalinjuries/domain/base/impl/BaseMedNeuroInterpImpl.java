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

package ims.spinalinjuries.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseMedNeuroInterpImpl extends DomainImpl implements ims.spinalinjuries.domain.MedNeuroInterp, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesaveAdmisNeuroInterpret(ims.generalmedical.vo.AdmisNeuroInterpretVo admisNeuroInterpret, ims.core.vo.ClinicalContactShortVo contact)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNeuroMotorRecord(ims.core.vo.ClinicalContactShortVo contact)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistVertebralLevel(Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmisNeuroInterpret(ims.core.vo.ClinicalContactShortVo contact, ims.generalmedical.vo.NeuroInterpretShortVo neuroInterpret)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNeuroSensationExamination(ims.core.vo.ClinicalContactShortVo contact)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistNeuroInterpret(ims.core.vo.ClinicalContactShortVo voClinContact)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistNeuroInterpretByCareContext(ims.core.admin.vo.CareContextRefVo refCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmisNeuroInterpretByCareContext(ims.core.admin.vo.CareContextRefVo careContext, ims.generalmedical.vo.NeuroInterpretShortVo neuroInterpret)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpinalMedicalAdmissionMotorByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpinalMedicalAdmissionSensationByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpinalMedicalAdmissionInterpretByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByName(String hcpName)
	{
	}
}
