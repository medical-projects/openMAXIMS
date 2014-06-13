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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.55 build 2722.20556)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.helper.Keywords;
import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.vo.UserAssessmentShortVoCollection;
import ims.assessment.vo.domain.UserAssessmentShortVoAssembler;
import ims.clinical.configuration.vo.ClinicalProblemRefVo;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.clinicaladmin.domain.base.impl.BaseManchesterTreatmentProtocolAdminImpl;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserAssessmentCategory;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupService;
import ims.emergency.configuration.domain.objects.ProblemTriageProtocol;
import ims.emergency.configuration.vo.ProblemTriageProtocolRefVo;
import ims.emergency.vo.ProblemTriageProtocolVo;
import ims.emergency.vo.ProblemTriageProtocolVoCollection;
import ims.emergency.vo.domain.ProblemTriageProtocolVoAssembler;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.reports.ReportEngine;
import ims.vo.ValueObject;

public class ManchesterTreatmentProtocolAdminImpl extends BaseManchesterTreatmentProtocolAdminImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.ClinicalProblemShortVoCollection listActiveProblems(String pcName) throws ims.domain.exceptions.DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from ClinicalProblem x join x.keywords as kw");
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		hql.append(" where x.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	
		
		List resultsList = Keywords.searchByKeywords(factory, pcName, hql.toString(), names, values);
		return ClinicalProblemShortVoAssembler.createClinicalProblemShortVoCollectionFromClinicalProblem(resultsList);
	}

	public UserAssessmentShortVoCollection listAssessments(String name, UserAssessmentCategory category, UserDefinedAssessmentType assessmentType) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from UserAssessment u ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (name != null && name.length() > 0)
		{
			hql.append(andStr + " upper(u.name) like :name");
			markers.add("name");
			values.add(name.toUpperCase());
			andStr = " and ";

		}
		if (category != null)
		{
			hql.append(andStr + " u.category.id =:category");
			markers.add("category");
			values.add(new Integer(category.getId()));
			andStr = " and ";
		}

		hql.append(andStr);
		hql.append(" u.assessmentType.id =:assessmentType");
		markers.add("assessmentType");
		values.add(assessmentType.getID());
		andStr = " or ";

		hql.append(andStr);
		hql.append(" u.activeStatus =:isactive");
		markers.add("isactive");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));	
		
		hql.append(")");	

		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();

		List list = factory.find(query, markers, values);

		return UserAssessmentShortVoAssembler.createUserAssessmentShortVoCollectionFromUserAssessment(list).sort();
	}

	public ProblemTriageProtocolVoCollection listProblemTriageProtocols(Boolean activeOnly) 
	{
		if (activeOnly.booleanValue())
			return ProblemTriageProtocolVoAssembler.createProblemTriageProtocolVoCollectionFromProblemTriageProtocol(getDomainFactory().find(" from ProblemTriageProtocol ptp where ptp.isActive = " + activeOnly)).sort();
		else
			return ProblemTriageProtocolVoAssembler.createProblemTriageProtocolVoCollectionFromProblemTriageProtocol(getDomainFactory().find(" from ProblemTriageProtocol ")).sort();
	}

	public ProblemTriageProtocolVo saveProblemTriageProtocol(ProblemTriageProtocolVo ptProtocolVo) throws StaleObjectException 
	{
		if(ptProtocolVo == null)
			throw new DomainRuntimeException("Invalid record");
		if(!ptProtocolVo.isValidated())
			throw new CodingRuntimeException("Record not validated");
		
		DomainFactory factory = getDomainFactory();
		ProblemTriageProtocol doPTP = ProblemTriageProtocolVoAssembler.extractProblemTriageProtocol(factory, ptProtocolVo);
		factory.save(doPTP);
		return ProblemTriageProtocolVoAssembler.create(doPTP);

	}

	public ProblemTriageProtocolVo getProblemTriageProtocol(ProblemTriageProtocolRefVo probtriProtocolRefVo) 
	{
		if(probtriProtocolRefVo == null || probtriProtocolRefVo.getID_ProblemTriageProtocol() == null)
			throw new DomainRuntimeException("Invalid record");
		
		return ProblemTriageProtocolVoAssembler.create((ProblemTriageProtocol)getDomainFactory().getDomainObject(ProblemTriageProtocol.class, probtriProtocolRefVo.getID_ProblemTriageProtocol()));
	}

	public Boolean checkForConfiguredAssessment(UserAssessmentRefVo userAssessmentShortVoRef) 
	{
		if (userAssessmentShortVoRef == null)
			return false;

		DomainFactory factory = getDomainFactory();
		String hql = " from ProblemTriageProtocol ptp " +
		" where ptp.triageProtocol.id = :tp "; 

		List tpList = factory.find(hql,new String[]{"tp"}, new Object[]{userAssessmentShortVoRef.getID_UserAssessment()});

		if (tpList != null && tpList.size() > 0)
			return true;

		return false;
	}

	public Boolean checkForConfiguredClinicalProblem(ClinicalProblemRefVo clinicalProblemShortRefVo) 
	{
		if (clinicalProblemShortRefVo == null)
			return false;

		DomainFactory factory = getDomainFactory();
		String hql = " from ProblemTriageProtocol ptp " +
		" where ptp.problem.id = :p "; 

		List tpList = factory.find(hql,new String[]{"p"}, new Object[]{clinicalProblemShortRefVo.getID_ClinicalProblem()});

		if (tpList != null && tpList.size() > 0)
			return true;

		return false;
	}
}
