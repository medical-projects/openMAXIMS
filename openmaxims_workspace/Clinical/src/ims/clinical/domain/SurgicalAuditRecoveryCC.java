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
public interface SurgicalAuditRecoveryCC extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveLocationsAtTheSameLevelWithLocation(ims.core.resource.place.vo.LocationRefVo locationRef);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listLocationsByParentLocation(ims.core.resource.place.vo.LocationRefVo locationRef);

	// Generated from form domain interface definition
	public ims.clinical.vo.SurgicalAuditOperationDetailVo save(ims.clinical.vo.SurgicalAuditOperationDetailVo surgicalAuditDetailToSave) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.clinical.vo.SurgicalAuditOperationDetailVo getSurgicalAuditOperationDetail(ims.clinical.vo.SurgicalAuditOperationDetailRefVo surgicalAuditOpRef);

	// Generated from form domain interface definition
	public Boolean isStale(ims.clinical.vo.SurgicalAuditOperationDetailVo surgAudit);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getLocationLiteVo(ims.core.resource.place.vo.LocSiteRefVo locSiteRef);

	// Generated from form domain interface definition
	public Boolean isStaleSurgicalAuditRecovery(ims.clinical.vo.SurgicalAuditRecoveryVo surgAuditRecoveryToSave);

	// Generated from form domain interface definition
	public ims.clinical.vo.SurgicalAuditRecoveryVo saveSurgicalAuditRecovery(ims.clinical.vo.SurgicalAuditRecoveryVo surgicalAuditRecoveryToSave) throws ims.domain.exceptions.StaleObjectException;
}
