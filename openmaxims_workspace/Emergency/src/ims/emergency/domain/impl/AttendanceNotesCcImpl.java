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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseAttendanceNotesCcImpl;
import ims.emergency.helper.EmergencyHelper;
import ims.emergency.helper.IEmergencyHelper;
import ims.emergency.vo.AttendanceClinicalNotesRefVo;
import ims.emergency.vo.AttendanceClinicalNotesVoCollection;
import ims.emergency.vo.domain.AttendanceClinicalNotesVoAssembler;
import ims.emergency.vo.lookups.AttendanceClinicalNoteType;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class AttendanceNotesCcImpl extends BaseAttendanceNotesCcImpl
{
	private static final long serialVersionUID = 1L;

	public AttendanceClinicalNotesVoCollection listNotes(PatientRefVo patient, EpisodeOfCareRefVo episodeOfCare, CareContextRefVo careContext, AttendanceClinicalNoteType noteType, HcpDisType discipline, Specialty specialty, Boolean orderType)
	{
		if(patient == null)
			throw new CodingRuntimeException("Cannot list AttendanceClinicalNotes for a null Patient Id.");
		
		String hql = "from AttendanceClinicalNotes as attClinicalNotes ";
		StringBuffer hqlConditions = new StringBuffer();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String andStr = "";
		
		if (patient !=null)
		{	
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.patient.id = :PatientId ");
			markers.add("PatientId");
			values.add(patient.getID_Patient());
			andStr = " and ";
		}
		
		if(careContext != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" attClinicalNotes.attendance.id = :CareContextId ");
			markers.add("CareContextId");
			values.add(careContext.getID_CareContext());
			andStr = " and ";
		}
		
		/*
		if(episodeOfCare != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" attClinicalNotes.episode.id = :EpisodeOfCareId ");
			markers.add("EpisodeOfCareId");
			values.add(episodeOfCare.getID_EpisodeOfCare());
			andStr = " and ";
		}
		*/
		if (noteType!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.noteType.id = :noteTypeId ");
			markers.add("noteTypeId");
			values.add(noteType.getID());
			andStr = " and ";
		}
		
		if (discipline!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.discipline.id = :disciplineId ");
			markers.add("disciplineId");
			values.add(discipline.getID());
			andStr = " and ";
		}
		
		if (specialty!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("attClinicalNotes.specialty.id = :specialtyId ");
			markers.add("specialtyId");
			values.add(specialty.getID());
			andStr = " and ";
		}
		

		if (hqlConditions.length() > 0)
		{
			hqlConditions.insert(0, " where (");
			hqlConditions.append(" ) ");
		}

		DomainFactory factory = getDomainFactory();

		if (Boolean.TRUE.equals(orderType))
		{
			hql=hql + hqlConditions.toString() + " order by attClinicalNotes.authoringInformation.authoringDateTime desc";
		}
		else
		{
			hql=hql + hqlConditions.toString() + " order by attClinicalNotes.authoringInformation.authoringDateTime asc";
		}
		
		List<?> list = factory.find(hql, markers, values);
		
		return AttendanceClinicalNotesVoAssembler.createAttendanceClinicalNotesVoCollectionFromAttendanceClinicalNotes(list);
		
	}

	public Specialty getSpecialtyForHCP(HcpRefVo hcpRef, HcpDisType hcpDisType)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getSpecialtyForHCP(hcpRef, hcpDisType);
	}

	public CareContextShortVoCollection getCareContextsByPatient(PatientRefVo patientRef)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getCareContextsByPatient(patientRef);
	}

	public Boolean isStale(AttendanceClinicalNotesRefVo attendanceClinicalNoteRef)
	{
		if(attendanceClinicalNoteRef == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		List<?> appts = factory.find("select a.id from AttendanceClinicalNotes as a where a.id = :attClinNoteId and a.version > :attClinNoteVersion", new String[] {"attClinNoteId", "attClinNoteVersion"}, new Object[] {attendanceClinicalNoteRef.getID_AttendanceClinicalNotes(), attendanceClinicalNoteRef.getVersion_AttendanceClinicalNotes()});
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}
}
