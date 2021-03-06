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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.domain.base.impl.BaseTriagePatientMedsImpl;
import ims.emergency.domain.objects.PatientMedicationOnAttendance;
import ims.emergency.domain.objects.Triage;
import ims.emergency.vo.EmergencyAttendanceForPatientMedsVo;
import ims.emergency.vo.HistoryOfPatientMedsVo;
import ims.emergency.vo.HistoryOfPatientMedsVoCollection;
import ims.emergency.vo.PatientMedicationOnAttendanceRefVo;
import ims.emergency.vo.PatientMedsVo;
import ims.emergency.vo.PatientMedsVoCollection;
import ims.emergency.vo.TriageForPatientMedsVo;
import ims.emergency.vo.TriageForPatientMedsVoCollection;
import ims.emergency.vo.domain.EmergencyAttendanceForPatientMedsVoAssembler;
import ims.emergency.vo.domain.HistoryOfPatientMedsVoAssembler;
import ims.emergency.vo.domain.PatientMedsVoAssembler;
import ims.emergency.vo.domain.TriageForPatientMedsVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class TriagePatientMedsImpl extends BaseTriagePatientMedsImpl
{

	private static final long serialVersionUID = 1L;

	public PatientMedsVo save(PatientMedsVo patientMedsToSave) throws StaleObjectException, UniqueKeyViolationException
	{
		if (patientMedsToSave == null)
			throw new CodingRuntimeException("Cannot save null PatientMeds ");

		if (!patientMedsToSave.isValidated())
			throw new DomainRuntimeException("PatientMedsVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		PatientMedicationOnAttendance domainPatientMeds = PatientMedsVoAssembler.extractPatientMedicationOnAttendance(factory, patientMedsToSave);

		factory.save(domainPatientMeds);

		return PatientMedsVoAssembler.create(domainPatientMeds);
	}

	
	public Boolean isStale(PatientMedsVo patientMedsToSave)
	{
		if (patientMedsToSave == null || patientMedsToSave.getID_PatientMedicationOnAttendance() == null)
		{
			throw new CodingRuntimeException("Cannot get PatientMedsVo on null Id ");
		}
				
		DomainFactory factory = getDomainFactory();
		PatientMedicationOnAttendance domainPatientMeds = (PatientMedicationOnAttendance) factory.getDomainObject(PatientMedicationOnAttendance.class, patientMedsToSave.getID_PatientMedicationOnAttendance());
		
		if(domainPatientMeds==null)
		{
			return true;
		}
		
		if (domainPatientMeds.getVersion() > patientMedsToSave.getVersion_PatientMedicationOnAttendance())
		{
			return true;
		}
		
		return false;
	}

	public PatientMedsVo getPatientMeds(PatientMedicationOnAttendanceRefVo patientMeds)
	{
		if (patientMeds == null || patientMeds.getID_PatientMedicationOnAttendance() == null)
		{
			throw new CodingRuntimeException("Cannot get PatientMedsVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		PatientMedicationOnAttendance domainPatientMeds = (PatientMedicationOnAttendance) factory.getDomainObject(PatientMedicationOnAttendance.class, patientMeds.getID_PatientMedicationOnAttendance());
		
		return PatientMedsVoAssembler.create(domainPatientMeds);
	}

	public TriageForPatientMedsVoCollection getAllTriagePatientMeds(PatientRefVo patientRef)
	{
		DomainFactory factory = getDomainFactory();
		
		if (patientRef == null || patientRef.getID_Patient() == null)
		{
			throw new CodingRuntimeException("Cannot get patientRefVo on null Id ");
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("select triage from Triage as triage left join triage.patient as pat where pat.id = :patientID ");
		hql.append(" order by triage.attendance.startDateTime desc");
	
		List<?> list = factory.find(hql.toString(), new String[] {"patientID"}, new Object[] {patientRef.getID_Patient()});
			
		return TriageForPatientMedsVoAssembler.createTriageForPatientMedsVoCollectionFromTriage(list);
	}


	public PatientMedsVo getPatientMedsForCareContext(CareContextRefVo careContextRef)
	{
		DomainFactory factory = getDomainFactory();
		
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get patientMedicationOnAttendance on null Id ");
		}
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select patmed from PatientMedicationOnAttendance as patmed  left join patmed.attendance as att where att.id = :careContextID ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"careContextID"}, new Object[] {careContextRef.getID_CareContext()});
			
		if (list!=null && list.size()>0)
			return PatientMedsVoAssembler.createPatientMedsVoCollectionFromPatientMedicationOnAttendance(list).get(0);
		
		return null;
	}


	public EmergencyAttendanceForPatientMedsVo getEmergencyAttendanceByCareContext(CareContextRefVo careContextRef)
	{
		DomainFactory factory = getDomainFactory();
		
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get EmergencyAttendanceForPatientMedsVo on null Id ");
		}
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select emergAtt from EmergencyAttendance as emergAtt where emergAtt.careContext.id = :careContextID ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"careContextID"}, new Object[] {careContextRef.getID_CareContext()});
			
		if (list!=null && list.size()>0)
			return EmergencyAttendanceForPatientMedsVoAssembler.createEmergencyAttendanceForPatientMedsVoCollectionFromEmergencyAttendance(list).get(0);
		
		return null;	
	}


	//wdev-15932
	public String getNHSNumber(PatientRefVo patientRef)
	{
		if( patientRef == null )
			throw new CodingRuntimeException("PatientRefVo is null.");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		
		hql.append("select p2_1.value from Patient as p1_1 left join p1_1.identifiers as p2_1 left join p2_1.type as l1_1 where (p1_1.id  = :patientId and l1_1.id = :nhsnumber ) ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"patientId","nhsnumber"}, new Object[] {patientRef.getID_Patient(),PatIdType.NHSN.getID()});
		if( list != null && list.size() > 0)
			return (String) list.get(0);
		
		return null;
	}


	//wdev-15932
	public HistoryOfPatientMedsVoCollection getHistoryOfPatientMeds(String nHSNumber)
	{
		 
		if( nHSNumber == null )
			return null;
			
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		
		hql.append("select h1_1 from HistoryOfPatientMeds as h1_1 where	(h1_1.nHSNumber = :nhsnumber)");
	
		List<?> list = factory.find(hql.toString(), new String[] {"nhsnumber"}, new Object[] {nHSNumber});
		if( list != null && list.size() > 0)
			return HistoryOfPatientMedsVoAssembler.createHistoryOfPatientMedsVoCollectionFromHistoryOfPatientMeds(list);

		return null;
	}


	//wdev-15932
	public HistoryOfPatientMedsVo getHistoryOfPatientMedsVo(String nHSNumber)
	{
		if( nHSNumber == null )
			return null;
			
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		
		hql.append("select h1_1 from HistoryOfPatientMeds as h1_1 where	(h1_1.nHSNumber = :nhsnumber) order by h1_1.systemInformation.creationDateTime desc");
	
		List<?> list = factory.find(hql.toString(), new String[] {"nhsnumber"}, new Object[] {nHSNumber});
		if( list != null && list.size() > 0)
		{
			HistoryOfPatientMedsVoCollection tempColl = HistoryOfPatientMedsVoAssembler.createHistoryOfPatientMedsVoCollectionFromHistoryOfPatientMeds(list);
			if( tempColl != null && tempColl.size() == 1)	//wdev-17117
				return tempColl.get(0);
			
		}

		return null;
	}

	//WDEV-17602
	public PatientMedsVoCollection getAllPatientMeds(PatientRefVo patientRef)//WDEV-17602
	{
		DomainFactory factory = getDomainFactory();
		
		if (patientRef == null || patientRef.getID_Patient() == null)
		{
			throw new CodingRuntimeException("Cannot get patientRefVo on null Id ");
		}
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select patMed from PatientMedicationOnAttendance as patMed left join patMed.patient as pat where pat.id = :patientID ");
		hql.append(" order by patMed.attendance.startDateTime desc");
		
		List<?> list = factory.find(hql.toString(), new String[] {"patientID"}, new Object[] {patientRef.getID_Patient()});
		
		return PatientMedsVoAssembler.createPatientMedsVoCollectionFromPatientMedicationOnAttendance(list);
	}

	//WDEV-17602
	public TriageForPatientMedsVo getTriageByCareContext(CareContextRefVo careContextRef)
	{
		DomainFactory factory = getDomainFactory();
		
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get TriageForPatientMedsVo on null Id ");
		}
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select triage from Triage as triage where triage.attendance.id = :careContextID ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"careContextID"}, new Object[] {careContextRef.getID_CareContext()});
			
		if (list!=null && list.size()>0)
			return TriageForPatientMedsVoAssembler.create((Triage)list.get(0));
		
		return null;	
	}

}
