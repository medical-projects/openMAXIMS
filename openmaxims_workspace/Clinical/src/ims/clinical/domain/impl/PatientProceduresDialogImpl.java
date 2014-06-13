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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BasePatientProceduresDialogImpl;
import ims.clinical.vo.domain.PatientProcedureForSurgicalAuditPreOpChecksVoAssembler;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class PatientProceduresDialogImpl extends BasePatientProceduresDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo save(ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo patProcedureToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if(patProcedureToSave == null)
			throw new CodingRuntimeException("Cannot save a null PatientProcedureForSurgicalAuditPreOpChecksVo.");
		
		if(!patProcedureToSave.isValidated())
			throw new CodingRuntimeException("PatientProcedureForSurgicalAuditPreOpChecksVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PatientProcedure doProcedure = PatientProcedureForSurgicalAuditPreOpChecksVoAssembler.extractPatientProcedure(factory, patProcedureToSave);

		factory.save(doProcedure);
		
		return PatientProcedureForSurgicalAuditPreOpChecksVoAssembler.create(doProcedure);
	}
}
