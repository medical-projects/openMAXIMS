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

public abstract class BaseClinicLetterBatchCreateImpl extends DomainImpl implements ims.core.domain.ClinicLetterBatchCreate, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistClinicsforLocation(Integer locationId, String strClinicName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutPatients(ims.core.resource.place.vo.ClinicRefVo clinic, ims.framework.utils.Date clinicDate)
	{
	}

	@SuppressWarnings("unused")
	public void validatesearchReports(String templateName, String listOfMandatorySeeds, ims.core.vo.lookups.DocumentCategory documentType, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTemplate(ims.core.admin.vo.TemplateBoRefVo templateBoRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContextByPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientDocument(ims.core.vo.PatientDocumentVo document)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDocCatConfig(ims.core.admin.vo.TemplateBoRefVo template)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeletePatientDocument(ims.core.documents.vo.PatientDocumentRefVo patDocRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSummaryNotes(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLastSummaryNote(ims.core.patient.vo.PatientRefVo patient)
	{
	}
}
