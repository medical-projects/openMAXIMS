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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.55 build 2718.17958)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.emergency.domain.impl;

import ims.admin.vo.EDAttendanceControlsConfigVoCollection;
import ims.admin.vo.lookups.EDAttendenceControlType;
import ims.clinical.domain.PatientSummary;
import ims.clinical.domain.impl.PatientSummaryImpl;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.domain.objects.EmergencyEpisode;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.domain.objects.RTA;
import ims.core.admin.domain.objects.TIIG;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EmergencyAttendanceRefVo;
import ims.core.admin.vo.EmergencyEpisodeRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.SpecialInterestDetail;
import ims.core.domain.Demographics;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Gp;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.EDAttendanceformsConfigVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.GpLiteWithNameVo;
import ims.core.vo.GpShortVo;
import ims.core.vo.GpShortVoCollection;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.Patient;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.domain.EpisodeofCareVoAssembler;
import ims.core.vo.domain.GpLiteWithNameVoAssembler;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.LocSiteShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.LocationDepartmentTypes;
import ims.emergency.domain.base.impl.BaseAttendanceDetailsImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.helper.EmergencyHelper;
import ims.emergency.helper.IEmergencyHelper;
import ims.emergency.vo.AttendanceDetailsVo;
import ims.emergency.vo.AttendanceDetailsVoCollection;
import ims.emergency.vo.ChartRequestedVo;
import ims.emergency.vo.EmergencyAttendanceBillingVo;
import ims.emergency.vo.EpisodeDetailsVo;
import ims.emergency.vo.EpisodeDetailsVoCollection;
import ims.emergency.vo.EpisodeOfcareLiteVo;
import ims.emergency.vo.LocationDepartmentTypesVo;
import ims.emergency.vo.RTAVo;
import ims.emergency.vo.TIIGVo;
import ims.emergency.vo.TrackingSendToAreaVo;
import ims.emergency.vo.domain.AttendanceDetailsVoAssembler;
import ims.emergency.vo.domain.EpisodeDetailsVoAssembler;
import ims.emergency.vo.domain.EpisodeOfcareLiteVoAssembler;
import ims.emergency.vo.domain.LocationDepartmentTypesVoAssembler;
import ims.emergency.vo.domain.RTAVoAssembler;
import ims.emergency.vo.domain.TIIGVoAssembler;
import ims.emergency.vo.domain.TrackingSendToAreaVoAssembler;
import ims.emergency.vo.enums.AttendanceHistoryDialog;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.Iterator;
import java.util.List;

public class AttendanceDetailsImpl extends BaseAttendanceDetailsImpl
{
	private static final long serialVersionUID = 1L;

	public CareSpellVo getCareSpellByEpisodeOfCare(Integer id)
	{
		if(id == null)
			throw new CodingRuntimeException("Patient not provided");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select cs from EpisodeOfCare as eoc left join eoc.careSpell as cs";
		hsql += " where eoc.id = :id";
		
		List careSpell = factory.find(hsql, new String[] {"id"}, new Object[] {id.intValue()});

		return CareSpellVoAssembler.createCareSpellVoCollectionFromCareSpell(careSpell).get(0);
	}
		
	public EpisodeDetailsVoCollection listEmergencyEpisodeByPatient(PatientRefVo patientRefVo, 
			Integer maxRecords,
				AttendanceHistoryDialog type, 
					DateTime scheduledDate, 
						DateTime unscheduledDate)
	{
		if(patientRefVo == null || patientRefVo.getID_Patient() == null)
			throw new CodingRuntimeException("Patient not provided");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = " select e1_1 from EmergencyEpisode as e1_1 ";
		hsql += " left join e1_1.episodeOfCare as e2_1 ";
		hsql += " left join e2_1.careSpell as c1_1 ";
		hsql += " left join c1_1.patient as p1_1 ";
		hsql += " where e1_1.isRIE is null and p1_1.id = :idPatient";
		
		if (type != null)
		{
			if (type.equals(AttendanceHistoryDialog.SCHEDULED))
			{
				hsql += " and e1_1.injuryDateTime >= :scheduledDate";
			}
			if (type.equals(AttendanceHistoryDialog.UNSCHEDULED))
			{
				hsql += " and (e1_1.injuryDateTime >= :unscheduledDate and e1_1.injuryDateTime < :scheduledDate)";
			}
		}
		hsql += " order by e2_1.startDate desc";		//wdev-16070
		
		List episodeDetails = null;
		
		if (maxRecords != 0)
		{
			if (type != null)
			{
				if (type.equals(AttendanceHistoryDialog.SCHEDULED))
				{
					episodeDetails = factory.find(hsql, new String[] {"scheduledDate","idPatient"}, new Object[] {scheduledDate.getJavaDate(), patientRefVo.getID_Patient()},maxRecords);
				}
				if (type.equals(AttendanceHistoryDialog.UNSCHEDULED))
				{
					episodeDetails = factory.find(hsql, new String[] {"scheduledDate","unscheduledDate","idPatient"}, new Object[] {scheduledDate.getJavaDate(), unscheduledDate.getJavaDate(), patientRefVo.getID_Patient()},maxRecords);
				}
			}
			else
			{
				episodeDetails = factory.find(hsql, new String[] {"idPatient"}, new Object[] {patientRefVo.getID_Patient()},maxRecords);
			}
		}
		else
		{
			if (type != null)
			{
				if (type.equals(AttendanceHistoryDialog.SCHEDULED))
				{
					episodeDetails = factory.find(hsql, new String[] {"scheduledDate","idPatient"}, new Object[] {scheduledDate.getJavaDate(), patientRefVo.getID_Patient()});
				}
				if (type.equals(AttendanceHistoryDialog.UNSCHEDULED))
				{
					episodeDetails = factory.find(hsql, new String[] {"scheduledDate","unscheduledDate","idPatient"}, new Object[] {scheduledDate.getJavaDate(), unscheduledDate.getJavaDate(), patientRefVo.getID_Patient()});
				}
			}
			else
			{
				episodeDetails = factory.find(hsql, new String[] {"idPatient"}, new Object[] {patientRefVo.getID_Patient()});
			}
		}
		
		
		if ( episodeDetails != null && episodeDetails.size() > 0)
			 return EpisodeDetailsVoAssembler.createEpisodeDetailsVoCollectionFromEmergencyEpisode(episodeDetails).sort(SortOrder.DESCENDING);
			
		
		return null;
	}
	
	public Patient getPatient(PatientRefVo patientRef)
	{
		Demographics impl = (Demographics) getDomainImpl(DemographicsImpl.class);
		return impl.getPatient(patientRef);
	}
	
	public EpisodeDetailsVo save(EpisodeDetailsVo record, CareSpellVo voCareSpell, EpisodeofCareVo voEpisodeOfCare, CareContextVo voCareContext, TrackingSendToAreaVo trackingVo, TIIGVo tiigrecord, RTAVo rtaRecord) throws StaleObjectException
	{
		if (record == null  || !record.isValidated())
			throw new CodingRuntimeException("Care Spell is null or has not been validated");

		DomainFactory factory = getDomainFactory();
		CareSpell doCareSpell = null;
		EpisodeOfCare doEpisode = null;
		CareContext doCare = null;

		if (voCareSpell != null)
		{
			doCareSpell = CareSpellVoAssembler.extractCareSpell(factory, voCareSpell);			
			factory.save(doCareSpell);
			doEpisode = getEpisodeOfCareDO(doCareSpell);
			doCare = getCareContextDO(doEpisode);
		}
		else
		{
			if(trackingVo != null)
			{
				doCare = CareContextVoAssembler.extractCareContext(factory,voCareContext);
				factory.save(doCare);
			}
		}
		EmergencyEpisode doEpisodeDetails = EpisodeDetailsVoAssembler.extractEmergencyEpisode(factory, record);
		
		if (voCareSpell != null)
		{
			doEpisodeDetails.setEpisodeOfCare(doEpisode);
		}
		Iterator it = doEpisodeDetails.getEmergencyAttendances().iterator();
		while(it.hasNext())
		{
			EmergencyAttendance doEmergencyAttendances = (EmergencyAttendance) it.next();
			if (doEmergencyAttendances.getCareContext() == null ||
					doEmergencyAttendances.getCareContext().getId() == null )
						doEmergencyAttendances.setCareContext(doCare);
		}
		
		Iterator itspec = doEpisodeDetails.getSpecialInterestDetails().iterator();
		while(itspec.hasNext())
		{
			SpecialInterestDetail doSpecialInterestDetail = (SpecialInterestDetail) itspec.next();
			if (doSpecialInterestDetail.getAttendance() == null ||	doSpecialInterestDetail.getAttendance().getId() == null )
				doSpecialInterestDetail.setAttendance(doCare);
			if (doSpecialInterestDetail.getEpisode() == null ||	doSpecialInterestDetail.getEpisode().getId() == null )
				doSpecialInterestDetail.setEpisode(doEpisodeDetails.getEpisodeOfCare());
		}
		//wdev-14582
		if(	record.getTiigIsNotNull() && record.getTiig().getID_TIIG() == null)
		{
			if(	doEpisodeDetails.getTiig().getEpisode() == null || doEpisodeDetails.getTiig().getEpisode().getId() == null)
				doEpisodeDetails.getTiig().setEpisode(doEpisodeDetails.getEpisodeOfCare());
			if( doEpisodeDetails.getTiig().getAttendance() == null || doEpisodeDetails.getTiig().getAttendance().getId() == null)
				doEpisodeDetails.getTiig().setAttendance(doCare);
		}
		//if the emergencyepisodes is edited and the TIIG fields is set to null the old TIIG is marked as RIE
		if(	tiigrecord != null)
		{
			TIIG doTIIG = TIIGVoAssembler.extractTIIG(factory, tiigrecord);
			if(	doTIIG != null)
			{
				doTIIG.setIsRIE(Boolean.TRUE);
				factory.save(doTIIG);
			}
			
			
		}
		//wdev-14615 if the emergencyepisodes is edited and the RTA field is set to null the old RTA is marked as RIE
		if(	rtaRecord != null)
		{
			RTA doRTA =  RTAVoAssembler.extractRTA(factory, rtaRecord);
			if(	doRTA != null)
			{
				doRTA.setIsRIE(Boolean.TRUE);
				factory.save(doRTA);
			}
		}
		
		//--------------
		factory.save(doEpisodeDetails);
		
		
		//wdev-14420
		if(trackingVo != null)
		{
			
			EmergencyAttendance doAttendanceDEt = getAttendanceDetailsByCareContext(doCare,factory );
			Tracking doTracking = TrackingSendToAreaVoAssembler.extractTracking(factory, trackingVo);
			if( doTracking.getEpisode() == null || doTracking.getEpisode().getId() == null)
				doTracking.setEpisode(doEpisodeDetails);
				//doTracking.setEpisode(voCareSpell != null ? doEpisode : doEpisodeDetails.getEpisodeOfCare());
				
			if( doTracking.getCurrentStatus().getEpisode() == null || doTracking.getCurrentStatus().getEpisode().getId()== null)
				doTracking.getCurrentStatus().setEpisode(voCareSpell != null ? doEpisode : doEpisodeDetails.getEpisodeOfCare());				
		
			
			if( doTracking.getAttendance() == null || doTracking.getAttendance().getId() == null )
				doTracking.setAttendance(doAttendanceDEt);
			if( doTracking.getCurrentStatus().getAttendance() == null || doTracking.getCurrentStatus().getAttendance().getId() == null)
				doTracking.getCurrentStatus().setAttendance(doCare);
						
			factory.save(doTracking);
			
		}
		
		//-------

		return EpisodeDetailsVoAssembler.create(doEpisodeDetails);		
	}
	private EmergencyAttendance getAttendanceDetailsByCareContext(CareContext doCare,DomainFactory factory )
	{
		if(doCare == null)
			throw new CodingRuntimeException("Care Context is null");
		
		String hsql = "select e1_1 from EmergencyAttendance as e1_1 left join e1_1.careContext as c1_1	where (c1_1.id =:id)";
		List attendances = factory.find(hsql, new String[] {"id"}, new Object[] {doCare.getId()});
		if(attendances != null && attendances.size() > 0)
		{
			return (EmergencyAttendance) attendances.get(0);
		}
		return null;
	}

	public GpLiteWithNameVo getGP(Integer id) 
	{
		DomainFactory factory = getDomainFactory();
		Gp doGP = (Gp) factory.getDomainObject(Gp.class, id);
		return GpLiteWithNameVoAssembler.create(doGP);
	}
	
	public EpisodeofCareVo getEpisodeOfCare(Integer id) 
	{
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, id);
		return EpisodeofCareVoAssembler.create(doEpisodeOfCare);
	}
	
	private CareContext getCareContextDO(EpisodeOfCare doEpisode)
	{
		for (Iterator iter = doEpisode.getCareContexts().iterator(); iter.hasNext();)
		{
			CareContext element = (CareContext) iter.next();
				return element;
		}

		return null;
	}

	private EpisodeOfCare getEpisodeOfCareDO(CareSpell doCareSpell)
	{
		for (Iterator iter = doCareSpell.getEpisodes().iterator(); iter.hasNext();)
		{
			EpisodeOfCare element = (EpisodeOfCare) iter.next();
				return element;
		}

		return null;
	}

	
	//wdev-14420
	public TrackingSendToAreaVo isPatientCurrentlyinED(PatientRefVo patient) 
	{
		//WDEV-16673
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.isPatientCurrentlyinED(patient);
	}
	
	public GpShortVo getGpPatient(PatientRefVo patient) 
	{
		if(patient == null)
			throw new CodingRuntimeException("Patient not provided");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select g1_1 from Patient as p1_1 left join p1_1.gp as g1_1 	where	(p1_1.id = :id)";
		 
		List gps = factory.find(hsql, new String[] {"id"}, new Object[] {patient.getID_Patient()});
		if(gps != null && gps.size() > 0)
		{
			GpShortVoCollection gpColl = GpShortVoAssembler.createGpShortVoCollectionFromGp(gps);
			if(gpColl != null && gpColl.size() > 0)
				return gpColl.get(0);
		}
		return null;
	}

	//wdev-14420
	public AttendanceDetailsVo getLastAttendance(PatientRefVo patientRef) 
	{
		if(patientRef == null)
			throw new CodingRuntimeException("Patient not provided");

		DomainFactory factory = getDomainFactory();
		

		String hsql = 	"select e3_1 from EmergencyEpisode as e1_1 left join e1_1.episodeOfCare as e2_1 left join e2_1.careSpell as c1_1 left join c1_1.patient as p1_1 left join e1_1.emergencyAttendances as e3_1 where (e3_1.arrivalDateTime = " +
						"(select  max (xe3_1.arrivalDateTime)   from EmergencyEpisode as xe1_1 left join xe1_1.episodeOfCare as xe2_1 left join xe2_1.careSpell as xc1_1 left join xc1_1.patient as xp1_1 left join xe1_1.emergencyAttendances as xe3_1  " +
						"where (xc1_1.patient.id =:idPatient )) and c1_1.patient.id =:idPatient1 )";
		
			
		List attendances = factory.find(hsql, new String[] {"idPatient","idPatient1"}, new Object[] {patientRef.getID_Patient(),patientRef.getID_Patient()});
		if(attendances != null && attendances.size() > 0)
		{
			AttendanceDetailsVoCollection attColl = AttendanceDetailsVoAssembler.createAttendanceDetailsVoCollectionFromEmergencyAttendance(attendances);
			if( attColl != null && attColl.size() > 0)
				return attColl.get(0);
		}
		return null;
	

	}

	//wdev-14420
	public EpisodeDetailsVo getEmergencyEpisode(EmergencyEpisodeRefVo episodeId) 
	{
		if(	episodeId == null)
			throw new CodingRuntimeException("EmergencyEpisodeRefVo not provided");
		
		DomainFactory factory = getDomainFactory();
		
		String hsql = "select e1_1 from EmergencyEpisode as e1_1 where	(e1_1.id = :id)";
		 
		List emergency = factory.find(hsql, new String[] {"id"}, new Object[] {episodeId.getID_EmergencyEpisode()});
		if(emergency != null && emergency.size() > 0)
		{
			EpisodeDetailsVoCollection EpisodeColl = EpisodeDetailsVoAssembler.createEpisodeDetailsVoCollectionFromEmergencyEpisode(emergency);
			if(EpisodeColl != null && EpisodeColl.size() > 0)
				return EpisodeColl.get(0);
		}
		return null;
		
		
	}

	//wdev-14420
	public LocSiteShortVo getTypeOfLocSite(LocationRefVo locRef) 
	{
		if(	locRef == null )
			throw new CodingRuntimeException("Location not provided");
		
		DomainFactory factory = getDomainFactory();
		LocSite doLocation  =(LocSite) factory.getDomainObject(LocSite.class, locRef.getID_Location());
		return LocSiteShortVoAssembler.create(doLocation);
		
	}

	//WDEV-15821
	public LocationDepartmentTypesVo getLocationDepartmentTypes(LocationRefVo edLocation)
	{
		if(edLocation == null || edLocation.getID_Location() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "from LocationDepartmentTypes as ldt where ldt.eDLocation.id = :EmergencyLocation";
		List<?> departments = factory.find(query, new String[] {"EmergencyLocation"}, new Object[] {edLocation.getID_Location()});
		
		if(departments != null && departments.size() > 0)
		{
			 return LocationDepartmentTypesVoAssembler.create((LocationDepartmentTypes) departments.get(0));
		}
		
		return null;
	}

	//wdev-16070
	public EpisodeOfcareLiteVo getEpisodeOfCareLite(EpisodeOfCareRefVo episodeOfCareRef)
	{
		if( episodeOfCareRef == null )
			throw new CodingRuntimeException("EpisodeOfCareRefVo not provided");
		
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, episodeOfCareRef.getID_EpisodeOfCare());
		return EpisodeOfcareLiteVoAssembler.create(doEpisodeOfCare);
	}

	//wdev-16673
	public EDAttendanceformsConfigVo getEDAttendanceformsConfig()
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getEDAttendanceformsConfig();
		
	}

	//wdev-16673
	public ChartRequestedVo getChartRequestedByEmergencyAttendance(EmergencyAttendanceRefVo emergencyAttendanceRef)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getChartRequestedByEmergencyAttendance(emergencyAttendanceRef);
	}

	//wdev-16673
	public EmergencyAttendanceBillingVo getAttendanceBillingByEmergencyAttendance(EmergencyAttendanceRefVo emergencyAttendanceRef)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getAttendanceBillingByEmergencyAttendance(emergencyAttendanceRef);
	}

	//wdev-16673
	public AttendanceDetailsVo getAttendanceDetails(EmergencyAttendanceRefVo attendanceDetailsRef)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getAttendanceDetails(attendanceDetailsRef);
	}

	//WDEV-17332
	public String getPIDDiagnosisInfo(CareContextRefVo careContextRefVo, EpisodeOfCareRefVo episodeRefVo)
	{
		PatientSummary ps = (PatientSummary) getDomainImpl(PatientSummaryImpl.class);
		return ps.getPIDDiagnosisInfo(careContextRefVo, episodeRefVo, null);
	}

	//WDEV-17804
	public EDAttendanceControlsConfigVoCollection getEDAttendanceControlsConfig(EDAttendenceControlType controlType)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getEDAttendanceControlsConfig(controlType);
	}

}
