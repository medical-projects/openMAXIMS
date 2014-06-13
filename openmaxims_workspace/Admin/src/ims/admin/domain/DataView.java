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

package ims.admin.domain;

// Generated from form domain impl
public interface DataView extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listClassesWithTemplates
	*/
	public ims.admin.vo.ReportTemplateBoRefLiteVoCollection listClassesWithTemplates();

	// Generated from form domain interface definition
	/**
	* listAuditRecords
	*/
	public ims.core.vo.AuditVoCollection listAuditRecords(String clazz, ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, ims.core.admin.vo.CareContextRefVoCollection voCareContextColl, ims.core.admin.vo.ClinicalContactRefVo clinicalContact, ims.core.patient.vo.PatientRefVo pid);

	// Generated from form domain interface definition
	/**
	* getLinkedTemplate
	*/
	public ims.admin.vo.ReportTemplateVo getLinkedTemplate(String className);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVoCollection listCareContexts(ims.core.admin.vo.EpisodeOfCareRefVo episodeofCareRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalContactShortVoCollection listClinicalContacts(ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareShortVoCollection listEpisodeOfCaresByPatient(ims.core.patient.vo.PatientRefVo patientVo);
}
