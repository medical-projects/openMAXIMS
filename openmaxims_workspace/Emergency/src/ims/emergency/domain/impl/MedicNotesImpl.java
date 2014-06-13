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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.emergency.domain.base.impl.BaseMedicNotesImpl;
import ims.emergency.vo.domain.MedicNotesVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class MedicNotesImpl extends BaseMedicNotesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.MedicNotesVoCollection listMedicNotes(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare, ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(patient == null)
			throw new CodingRuntimeException("Cannot list MedicNotes for a null Patient Id.");
		
		String query = "from MedicNotes as mn where ";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		if(careContext != null)
		{
			query += " mn.attendance.id = :CareContextId ";
			paramNames.add("CareContextId");
			paramValues.add(careContext.getID_CareContext());
		}
		else if(episodeOfCare != null)
		{
			query += " mn.episode.id = :EpisodeOfCareId ";
			paramNames.add("EpisodeOfCareId");
			paramValues.add(episodeOfCare.getID_EpisodeOfCare());
		}
		else
		{
			query += " mn.patient.id = :PatientId ";
			paramNames.add("PatientId");
			paramValues.add(patient.getID_Patient());
		}
		
		query += " order by mn.authoringInformation.authoringDateTime desc ";
		
		List<?> notes = getDomainFactory().find(query, paramNames, paramValues);
		
		return MedicNotesVoAssembler.createMedicNotesVoCollectionFromMedicNotes(notes);
	}
}
