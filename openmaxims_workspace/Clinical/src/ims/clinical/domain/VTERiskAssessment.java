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
public interface VTERiskAssessment extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentShortVoCollection listVTERiskAssessments(ims.core.vo.PatientShort patient);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentVo getVTERiskAssessment(ims.core.clinical.vo.VTERiskAssessmentRefVo vTERiskAssRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentShortVo getVTERiskAssessmentShortVo(ims.core.clinical.vo.VTERiskAssessmentRefVo vTERiskRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentVo saveVTERiskAssess(ims.clinical.vo.VTERiskAssessmentVo vteRiskAssess, ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo inpatEpisodeVTEriskAsses, ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo discharge) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo getInpatientEpisodes(ims.core.admin.pas.vo.PASEventRefVo pasRefVo);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentShortVoCollection listVTERiskAssessByPasId(ims.core.admin.pas.vo.PASEventRefVo pasRefVo);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentVo getInProgressVTERiskAsessment(ims.core.admin.pas.vo.PASEventRefVo pasEventRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextByPasEventId(ims.core.admin.pas.vo.PASEventRefVo pasEventRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo saveInpatientEpisode(ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo inpatientEpisode) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentShortVo getVTERiskAssessmentShortVo(ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatEpRef);

	// Generated from form domain interface definition
	public ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo getDischargeEpisode(ims.core.admin.pas.vo.PASEventRefVo pasEvent);

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentShortVo getVTERiskAssessmentShortByDischargeEpisode(ims.core.admin.pas.vo.DischargedEpisodeRefVo dischargeRef);

	// Generated from form domain interface definition
	public ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo saveDischargeEpisode(ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo discharge) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinical.vo.VTERiskAssessmentVo getInProgressVTERiskAssessmentFromDischargeEpisode(ims.core.admin.pas.vo.PASEventRefVo pasEventRef);

	// Generated from form domain interface definition
	public ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo getDischargedEpisodeForVTERiskAssessmentWorklistVo(ims.core.admin.pas.vo.DischargedEpisodeRefVo dischargeRef);
}
