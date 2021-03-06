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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2434.20780)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.configuration.domain.objects.GraphicAssessment;
import ims.assessment.domain.base.impl.BasePatientGraphicStagesImpl;
import ims.assessment.instantiation.domain.objects.PatientAssessment;
import ims.assessment.instantiation.domain.objects.PatientGraphicAssessment;
import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.assessment.vo.GraphicAssessmentVo;
import ims.assessment.vo.PatientAssessmentListVo;
import ims.assessment.vo.PatientAssessmentListVoCollection;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.domain.GraphicAssessmentVoAssembler;
import ims.assessment.vo.domain.PatientAssessmentListVoAssembler;
import ims.assessment.vo.domain.PatientAssessmentVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.helper.DrawingControlReportHelper;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class PatientGraphicStagesImpl extends BasePatientGraphicStagesImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listAssessments
	*/
	//WDEV-11526 - starts here
	public ims.assessment.vo.PatientAssessmentListVoCollection listAssessments(UserDefinedAssessmentType type, PatientRefVo patient, EpisodeOfCareRefVo episodeOfCare, CareContextRefVo careContext)
	{
		//WDEV-11721
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Ca not list PatientAssessment on null Patient Id.");
		
		//WDEV-11721
		if(type == null)
			throw new CodingRuntimeException("Can not list PatientAssessment on null UserDefinedAssessmentType.");
		
		DomainFactory factory = getDomainFactory();		
		StringBuffer hql = new StringBuffer();
		String query = " from PatientAssessment a";
		ArrayList<String> markers= new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		//WDEV-11721
		hql.append(" where a.assessmentData.graphic.assessmentType.id = :TYPE");
		markers.add("TYPE");
		values.add(type.getID());
		
		if(careContext != null && careContext.getID_CareContextIsNotNull())
		{
			hql.append(" and a.careContext.id = :CARE_CONTEXT");
			markers.add("CARE_CONTEXT");
			values.add(careContext.getID_CareContext());
		}
		
		//WDEV-11721 - starts here
		else if(episodeOfCare != null && episodeOfCare.getID_EpisodeOfCareIsNotNull())
		{
			hql.append(" and a.episodeOfCare.id = :ec");
			markers.add("ec");
			values.add(episodeOfCare.getID_EpisodeOfCare());
		}
		else if(patient != null && patient.getID_PatientIsNotNull())
		{
			hql.append(" and a.patient.id = :pat");
			markers.add("pat");
			values.add(patient.getID_Patient());
		}
		//WDEV-11721 - ends here
		
		query += hql.toString();	
		
		query += " order by a.authoringInformation.authoringDateTime desc";
		
		return PatientAssessmentListVoAssembler.createPatientAssessmentListVoCollectionFromPatientAssessment(factory.find(query, markers, values));
	}
	//WDEV-11526 - ends here
	
	
	public PatientAssessmentListVo getLastCompletedAssessment(UserDefinedAssessmentType type, CareContextRefVo careContext, Boolean isCurrentForType)
	{
		List list = getDomainFactory().find("from PatientAssessment as p1_1 where p1_1.assessmentData.graphic.assessmentType.id = :TYPE and p1_1.careContext.id = :CARE_CONTEXT order by p1_1.authoringInformation.authoringDateTime desc", new String[] {"TYPE", "CARE_CONTEXT"}, new Object[] {new Integer(type.getID()), careContext.getID_CareContext()});
		
		//Get only the first record (to optimise the work of the assembler)
		if(list != null && list.size() > 1)
		{
			Object firstItem = list.get(0);
			list.removeAll(list);
			list.add(firstItem);
		}
		
		PatientAssessmentListVoCollection voColl = PatientAssessmentListVoAssembler.createPatientAssessmentListVoCollectionFromPatientAssessment(list);
		if(voColl != null && voColl.size() > 0)
			return voColl.get(0);
			
		return null;
	}

	public GraphicAssessmentVo getActiveGraphicAssessment(UserDefinedAssessmentType type)
	{
		List list = getDomainFactory().find("from GraphicAssessment as g1_1 where g1_1.assessmentType.id = :TYPE and g1_1.activeStatus.id = :STATUS", new String[] {"TYPE", "STATUS"}, new Object[] {new Integer(type.getID()), new Integer(PreActiveActiveInactiveStatus.ACTIVE.getID())});

		if(list == null || list.size() == 0)
			return null;
		
		return GraphicAssessmentVoAssembler.create((GraphicAssessment) list.get(0));
	}

	public PatientAssessmentVo savePatientAssessment(PatientAssessmentVo patientAssessment) throws StaleObjectException
	{
		if(patientAssessment == null)
			throw new RuntimeException("Cannot save null value for PatientAssessmentVo");
		if(patientAssessment.isValidated() == false)
			throw new CodingRuntimeException("PatientAssessmentVo not validated");
		
		DomainFactory factory = getDomainFactory();
		
		if(patientAssessment.getID_PatientAssessment() == null)
		{
			//update the other assessments and make them inactive
			//WDEV-11526, WDEV-11721
			PatientAssessmentListVoCollection coll = listAssessments(patientAssessment.getAssessmentData().getGraphic().getAssessmentType(), patientAssessment.getPatient(), patientAssessment.getEpisodeOfCare(), patientAssessment.getCareContext());
			
			if(coll != null)
			{
				for (int i = 0; i < coll.size(); i++)
				{
					PatientAssessment doPatientAssessment = (PatientAssessment)factory.getDomainObject(PatientAssessment.class, coll.get(i).getID_PatientAssessment());
					doPatientAssessment.setIsCurrentForType(Boolean.FALSE);
					factory.save(doPatientAssessment);
				}
			}
		}
		
		PatientAssessment doPatientAssessment = PatientAssessmentVoAssembler.extractPatientAssessment(factory, patientAssessment);
		
		//save every PatientGraphicAssessment as a rendered MHT - used by reports only
		DrawingControlReportHelper helper = new DrawingControlReportHelper();
		if(patientAssessment.getAssessmentDataIsNotNull() && patientAssessment.getAssessmentData().getGraphicFindingsIsNotNull())
		{
			for (int i = 0; i < patientAssessment.getAssessmentData().getGraphicFindings().size(); i++)
			{
				PatientGraphicAssessment pga = (PatientGraphicAssessment) doPatientAssessment.getAssessmentData().getGraphicFindings().get(i);
				pga.setRenderedMHT(helper.CreateDrawingControlSeed(patientAssessment.getAssessmentData().getGraphicFindings().get(i), 800, 400));
			}
		}
		factory.save(doPatientAssessment);
		
		return PatientAssessmentVoAssembler.create(doPatientAssessment);
	}

	public PatientAssessmentVo getPatientAssessment(PatientAssessmentRefVo ref)
	{
		return PatientAssessmentVoAssembler.create((PatientAssessment) getDomainFactory().getDomainObject(PatientAssessment.class, ref.getID_PatientAssessment()));
	}
}
