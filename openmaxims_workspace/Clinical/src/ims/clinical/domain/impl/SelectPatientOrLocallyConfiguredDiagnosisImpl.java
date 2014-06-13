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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.55 build 2718.17958)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.clinical.domain.base.impl.BaseSelectPatientOrLocallyConfiguredDiagnosisImpl;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.domain.DiagnosisProcedureProblemSearch;
import ims.core.domain.impl.DiagnosisProceduresSearchImpl;
import ims.core.vo.domain.PatientDiagnosisListVoAssembler;
import ims.core.vo.domain.PatientDiagnosisVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class SelectPatientOrLocallyConfiguredDiagnosisImpl extends BaseSelectPatientOrLocallyConfiguredDiagnosisImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listDiagnosis
	*/
	public ims.core.vo.DiagLiteVoCollection listDiagnosis(String filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		DiagnosisProcedureProblemSearch impl = (DiagnosisProcedureProblemSearch)getDomainImpl(DiagnosisProceduresSearchImpl.class);
		return impl.listDiagnosis(filter);
	}

	/**
	* listProcedureShortListVoByPatient
	*/
	public ims.core.vo.PatientDiagnosisListVoCollection listCancerDiagnosisByPatient(ims.core.patient.vo.PatientRefVo patient)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";
 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		condStr.append(andStr + " patdiag.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patient.getID_Patient());
		andStr = " and ";			

		condStr.append(andStr + " patdiag.isComplication = :complication");
		markers.add("complication");
		values.add(Boolean.FALSE);

		condStr.append(andStr + " patdiag.isResolved = :excresolved");
		markers.add("excresolved");
		values.add(Boolean.FALSE);

		hql += " where ";

		hql += condStr.toString();
		List list = factory.find(hql,markers,values);
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(list).sort();
	}

	/**
	* Get OPDEDVo
	*/
	public ims.core.vo.PatientDiagnosisVo getDiagnosisVo(ims.core.clinical.vo.PatientDiagnosisRefVo patdiagrefVo)
	{
		if(patdiagrefVo == null)
			throw new DomainRuntimeException("Cannot get PatientDiagnosisVo for null PatientDiagnosisRefVo");
		
		DomainFactory factory = getDomainFactory();
		PatientDiagnosis doPatientDiagnosis = (PatientDiagnosis)factory.getDomainObject(PatientDiagnosis.class,patdiagrefVo.getID_PatientDiagnosis());
		return PatientDiagnosisVoAssembler.create(doPatientDiagnosis);
	}
}
