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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePresentingProblemsImpl extends DomainImpl implements ims.clinical.domain.PresentingProblems, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetMappings(ims.vo.LookupInstVo instance)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPresentingProblems(ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHistoryProblems(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.clinical.vo.PresentAbsentHistoryProblemsVo voHistoryProblems)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHCPs(ims.core.vo.Hcp filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPresProblemCheckListConfig(ims.core.vo.lookups.Specialty specialtyLkup)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePresProblemCheckListConfig(ims.clinicaladmin.vo.PresProblemChecklistConfigVo item)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProblemsByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveProblemConfig(ims.clinical.vo.ProblemConfigVo voProblem)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientProblemsByPatient(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientProblems(ims.core.clinical.vo.PatientProblemRefVo refVo)
	{
	}
}
