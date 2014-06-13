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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.19 build 40709.1515)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.coe.vo.HospitalReportCollection;
import ims.coe.vo.domain.HospitalReportAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.vo.CareContextVo;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocMostVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.ClinicalNotesStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.dto.DTODomainImplementation;
import ims.framework.utils.DateTime;

import java.util.List;

public class HospitalReportImpl extends DTODomainImplementation implements ims.nursing.domain.HospitalReport, ims.nursing.domain.WardHandover, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean dtoOnly()
	{
		return false;
	}

	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	public HospitalReportCollection listHospitalReportsByHospital(LocMostVo voHospital, DateTime fromDateTime, DateTime toDateTime)
	{
		return listHospitalReportsByHospital(voHospital, fromDateTime, toDateTime, Boolean.TRUE,Boolean.TRUE);
	}

	private HospitalReportCollection listHospitalReportsByHospital(LocMostVo voHospital, ims.framework.utils.DateTime fromDateTime, ims.framework.utils.DateTime toDateTime, Boolean hospitalReport,Boolean isCorrected)
	{
		DomainFactory factory = getDomainFactory();
		String[] names;
		Object[] values;
		/*
		 * WDEV-3837
		 * Changing recordingDateTime from recordedDateTime to reflect changes in business object
		*/
		String hql = " from ClinicalNotes cn " + " where cn.recordingDateTime >= :fromDateTime " + " and cn.recordingDateTime <= :toDateTime " + " and cn.currentStatus.status = :isActive " + " and cn.ward.parentLocation = " + voHospital.getID_Location();

		java.util.Date fromDate = fromDateTime.getJavaDate();
		java.util.Date toDate = toDateTime.getJavaDate();

		if(isCorrected != null && hospitalReport != null && hospitalReport.booleanValue())
		{
			hql += " and cn.inHospitalReport = :hospitalReport and cn.currentStatus.correctionConfirmed != :isCorrected";
			names = new String[]{"fromDateTime", "toDateTime", "isActive", "hospitalReport", "isCorrected"};
			values = new Object[]{fromDate, toDate, getDomLookup(ClinicalNotesStatus.ACTIVE), hospitalReport,isCorrected};
			
		}
		else if (hospitalReport != null && hospitalReport.booleanValue())
		{
			hql += " and cn.inHospitalReport = :hospitalReport ";
			names = new String[]{"fromDateTime", "toDateTime", "isActive", "hospitalReport"};
			values = new Object[]{fromDate, toDate, getDomLookup(ClinicalNotesStatus.ACTIVE), hospitalReport};
		}
		else if(isCorrected != null)
		{
		
			hql+= " and cn.currentStatus.correctionConfirmed = :isCorrected";
			names = new String[]{"fromDateTime", "toDateTime", "isCorrected"};
			values = new Object[]{fromDate, toDate, getDomLookup(ClinicalNotesStatus.ACTIVE),isCorrected};
						
		}
		else
		{
			names = new String[]{"fromDateTime", "toDateTime", "isActive"};
			values = new Object[]{fromDate, toDate, getDomLookup(ClinicalNotesStatus.ACTIVE)};
		}

		List notes = factory.find(hql, names, values, 1000);

		return (HospitalReportAssembler.createHospitalReportCollectionFromClinicalNotes(notes).sort());
	}

	public HospitalReportCollection listHospitalReports(LocMostVo voWard, DateTime fromDateTime, DateTime toDateTime)
	{
		return listHospitalReports(voWard, fromDateTime, toDateTime, Boolean.TRUE, Boolean.FALSE);
	}

	public ims.coe.vo.HospitalReportCollection listHospitalReports(LocMostVo voWard, ims.framework.utils.DateTime fromDateTime, ims.framework.utils.DateTime toDateTime, Boolean hospitalReport,Boolean isCorrected)
	{
		DomainFactory factory = getDomainFactory();
		String[] names;
		Object[] values;

		String hql = " from ClinicalNotes cn " + " where cn.recordingDateTime >= :fromDateTime " + " and cn.recordingDateTime <= :toDateTime " + " and cn.ward.id = " + voWard.getID_Location();

		java.util.Date fromDate = fromDateTime.getJavaDate();
		java.util.Date toDate = toDateTime.getJavaDate();

		
		if(isCorrected != null && hospitalReport != null && hospitalReport.booleanValue())
		{
			hql += " and cn.currentStatus.correctionConfirmed = :isCorrected and cn.inHospitalReport = :hospitalReport";
			names = names = new String[]{"fromDateTime", "toDateTime", "hospitalReport","isCorrected"};
			values = new Object[]{fromDate, toDate, hospitalReport,isCorrected};
		}
		else if (hospitalReport != null && hospitalReport.booleanValue())
		{
			hql += " and cn.inHospitalReport = :hospitalReport ";
			names = new String[]{"fromDateTime", "toDateTime", "hospitalReport"};
			values = new Object[]{fromDate, toDate, hospitalReport};
		}
		else if(isCorrected != null)
		{
			hql += " and cn.currentStatus.correctionConfirmed = :isCorrected";
			names = names = new String[]{"fromDateTime", "toDateTime","isCorrected"};
			values = new Object[]{fromDate, toDate,isCorrected};
			
		}
		else
		{
			names = new String[]{"fromDateTime", "toDateTime"};
			values = new Object[]{fromDate, toDate};
		}
		
		List notes = factory.find(hql, names, values, 1000);

		return (HospitalReportAssembler.createHospitalReportCollectionFromClinicalNotes(notes).sort());
	}

	public LocMostVoCollection listLocations(LocMostVo locationFilter)
	{
		OrganisationAndLocation locImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return locImpl.listLocation(locationFilter).sort();
	}

	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws DomainInterfaceException
	{
		Reports impl = (Reports) getDomainImpl(ReportsImpl.class);
		return impl.getReportAndTemplate(nReportId, nTemplateId);
	}

	public PatientShort getPatientFromCareContext(CareContextRefVo voRef)
	{
		String hqlQuery = " select cs.patient from CareSpell cs left join cs.episodes ep left join ep.careContexts cc where cc.id = " + voRef.getID_CareContext();
		List list = getDomainFactory().find(hqlQuery);
		
		if(list != null && list.size() > 0)
		{
			return PatientShortAssembler.createPatientShortCollectionFromPatient(list).get(0);
		}
		
		return null;
	}

	public CareContextVo getCareContext(CareContextRefVo voRef) 
	{
		DomainFactory factory = getDomainFactory();
		CareContext med = (CareContext) factory.getDomainObject(CareContext.class, voRef.getID_CareContext());
		return (CareContextVoAssembler.create(med));
	}

}
