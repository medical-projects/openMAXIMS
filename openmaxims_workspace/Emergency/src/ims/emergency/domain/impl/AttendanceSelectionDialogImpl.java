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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.55 build 2722.20556)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.EmergencyEpisodeRefVo;
import ims.domain.DomainFactory;
import ims.emergency.domain.AttendanceDetails;
import ims.emergency.domain.base.impl.BaseAttendanceHistoryDialogImpl;
import ims.emergency.vo.AttendanceDetailsVoCollection;
import ims.emergency.vo.domain.AttendanceDetailsVoAssembler;
import ims.emergency.vo.enums.AttendanceHistoryDialog;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class AttendanceSelectionDialogImpl extends BaseAttendanceHistoryDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listCareSpellsByPatient
	*/
	public ims.emergency.vo.EpisodeDetailsVoCollection listEmergencyEpisodeByPatient(
			ims.core.patient.vo.PatientRefVo patientRefVo, 
				Integer maxRecords, 
					AttendanceHistoryDialog type, 
						ims.framework.utils.DateTime scheduledDate, 
							ims.framework.utils.DateTime unscheduledDate)
	{
		AttendanceDetails impl = (AttendanceDetails) getDomainImpl(AttendanceDetailsImpl.class);
		return impl.listEmergencyEpisodeByPatient(patientRefVo, maxRecords, type, scheduledDate, unscheduledDate);
	}
	
	public AttendanceDetailsVoCollection listAttendanceByEpisodeDetails(EmergencyEpisodeRefVo voRef)
	{
		if(voRef == null || voRef.getID_EmergencyEpisode() == null)
			throw new CodingRuntimeException("EmergencyEpisode not provided");
		
		DomainFactory factory = getDomainFactory();
		String hsql = " select e1_1 from EmergencyAttendance as e1_1 ";
		hsql += " left join e1_1.emergencyEpisode as e2_1  ";
		hsql += " where e1_1.isRIE is null and e2_1.id = :idEpisode";
		hsql += " order by e1_1.registrationDateTime desc";
		
		List attendances = factory.find(hsql, new String[] {"idEpisode"}, new Object[] {voRef.getID_EmergencyEpisode()});
		
		if (attendances != null && attendances.size() > 0)
			return AttendanceDetailsVoAssembler.createAttendanceDetailsVoCollectionFromEmergencyAttendance(attendances).sort(SortOrder.DESCENDING);
		
		return null;
	}
	
}
