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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 2971.25997)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinicaladmin.vo.PMHChecklistConfigVoCollection;
import ims.clinicaladmin.vo.PresProblemChecklistConfigVoCollection;
import ims.clinicaladmin.vo.domain.PMHChecklistConfigVoAssembler;
import ims.clinicaladmin.vo.domain.PresProblemChecklistConfigVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientProblem;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.vo.PatientProblemVo;
import ims.core.vo.PatientProblemVoCollection;
import ims.core.vo.PatientProcedureVo;
import ims.core.vo.domain.PatientProblemVoAssembler;
import ims.core.vo.domain.PatientProcedureVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BasePresentingProblemsAndInterventionsImpl;
import ims.emergency.domain.objects.PresProblemsProceduresPerformed;
import ims.emergency.vo.EmergencyPatientPresentingProblemsVo;
import ims.emergency.vo.domain.EmergencyPatientPresentingProblemsVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class PresentingProblemsAndInterventionsImpl extends BasePresentingProblemsAndInterventionsImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* listPresentingProblems
	*/
	public PresProblemChecklistConfigVoCollection listPresentingProblems()
	{
		DomainFactory factory = getDomainFactory(); 
		List probs = factory.find("select p from PresProblemChecklistConfig as p left join p.presentingProblem as p2_1 left join p2_1.presentingProblem as c1_1 left join p.specialty as l1_1 order by l1_1.text asc, c1_1.pCName asc");	
		
		return PresProblemChecklistConfigVoAssembler.createPresProblemChecklistConfigVoCollectionFromPresProblemChecklistConfig(probs);
	}

	public PatientProblemVoCollection listPatientProblemsByCareContext(CareContextRefVo careContext)
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("No Care context Supplied");
		
		DomainFactory factory = getDomainFactory();
		List problems = factory.find("from PatientProblem p where p.careContext.id = :careContextId order by p.specialty.text, p.problem.pCName", new String[]{"careContextId"},new Object[]{careContext.getID_CareContext()});

		return PatientProblemVoAssembler.createPatientProblemVoCollectionFromPatientProblem(problems); 
	}

	public EmergencyPatientPresentingProblemsVo getEmergencyPresentingProblems(CareContextRefVo careContextRef)
	{
		if(careContextRef == null || careContextRef.getID_CareContext() == null)
			throw new CodingRuntimeException("No Care context Supplied");
		
		DomainFactory factory = getDomainFactory();
		List problems = factory.find("from PresProblemsProceduresPerformed p where p.careContext.id = :careContextId", new String[]{"careContextId"},new Object[]{careContextRef.getID_CareContext()});

		if(problems.size() > 1)
			throw new DomainRuntimeException("More than 1 record found for current Care context !");
		
		return problems.size() == 0 ? null : EmergencyPatientPresentingProblemsVoAssembler.create((PresProblemsProceduresPerformed)problems.get(0)); 
	}

	public EmergencyPatientPresentingProblemsVo saveEmergencyPresentingProblems(EmergencyPatientPresentingProblemsVo problems) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		if(problems == null)
			throw new CodingRuntimeException("No record to save supplied !");

		if(problems.getCareContext() == null)
			throw new CodingRuntimeException("The care context supplied cannot be null !");
		
		DomainFactory domainFactory = getDomainFactory();
		
		if(problems.getID_PresProblemsProceduresPerformed() == null)
		{
			List count = domainFactory.find("select count(p.id) from PresProblemsProceduresPerformed p where p.careContext.id = :careContextId", new String[]{"careContextId"},new Object[]{problems.getCareContext().getID_CareContext()});
	
			if(!count.get(0).toString().equals("0"))
				throw new DomainInterfaceException("There is already a record saved for this care context !");
		}
		
		PresProblemsProceduresPerformed patientPresentingProblems = EmergencyPatientPresentingProblemsVoAssembler.extractPresProblemsProceduresPerformed(domainFactory, problems);
		
		domainFactory.save(patientPresentingProblems);
		
		if(problems.getOrphanProblems() != null)
		{
			for (int i = 0; i < problems.getOrphanProblems().size(); i++)
			{
				PatientProblemVo orphanVo = problems.getOrphanProblems().get(i);
				
				PatientProblem orphan = PatientProblemVoAssembler.extractPatientProblem(domainFactory, orphanVo);
				
				domainFactory.delete(orphan);
			}
		}

		if(problems.getOrphanProcedures() != null)
		{
			for (int i = 0; i < problems.getOrphanProcedures().size(); i++)
			{
				PatientProcedureVo orphanVo = problems.getOrphanProcedures().get(i);
				
				PatientProcedure orphan = PatientProcedureVoAssembler.extractPatientProcedure(domainFactory, orphanVo);
				
				domainFactory.delete(orphan);
			}
		}
		
		return EmergencyPatientPresentingProblemsVoAssembler.create(patientPresentingProblems);
	}

	public PMHChecklistConfigVoCollection listConfiguredProcedures()
	{
		DomainFactory factory = getDomainFactory(); 
		List procs = factory.find("select p from PMHChecklistConfig p order by p.specialty.text asc");	
		
		return PMHChecklistConfigVoAssembler.createPMHChecklistConfigVoCollectionFromPMHChecklistConfig(procs);
	}


}
