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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2396.26491)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.LocShortMappingsVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.Time;
import ims.ocrr.domain.base.impl.BaseWardSpecimenCollectionImpl;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.SpecimenWorkListItem;
import ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVo;
import ims.ocrr.vo.SpecimenWorkListItemListVo;
import ims.ocrr.vo.SpecimenWorkListItemListVoCollection;
import ims.ocrr.vo.domain.SpecimenWorkListItemListVoAssembler;
import ims.ocrr.vo.lookups.OcsDisplayFlag;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;

import java.util.ArrayList;
import java.util.List;

public class WardSpecimenCollectionImpl extends BaseWardSpecimenCollectionImpl
{
	private static final long	serialVersionUID	= -7616908400372023674L;

	public Boolean isLocationAWard(Integer locationId)
	{
		if (locationId == null)
			throw new CodingRuntimeException("Cannot get Location for null id");
		String hql = " select loc.id, count(loc.id) from Location loc where loc.id = :LOCID and loc.type = :WARDID group by loc.id";
		List list = getDomainFactory().find(hql.toString(), new String[]{"LOCID", "WARDID"}, new Object[]{locationId, getDomLookup(LocationType.WARD)});
		return new Boolean(list.size() > 0);
	}

	public SpecimenWorkListItemListVoCollection listWorkListItems(Integer wardId, SpecimenCollectionMethod specimenType, SpecimenCollectionStatus specimenStatus, SpecimenCollectionStatus secondStatus, Date startDate, Time startTime, Date endDate, Time endTime)
	{
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		//WDEV-16232
		//StringBuffer hql = new StringBuffer(" from SpecimenWorkListItem sp where");
		StringBuffer hql = new StringBuffer(" select sp from SpecimenWorkListItem as sp left join sp.specimen as spec left join spec.specimenCollectionStatus as specStatus left join spec.order as ord left join ord.patient as pat left join sp.dFTOrderInvestigation as dft left join dft.orderDetails as dftDetails left join dftDetails.patient as dftPat where ");
		
		if (wardId != null)
		{
			//hql.append(" sp.specimen.order.patient.ward.id = :WARDID ");
			hql.append(" ((spec is not null and pat.ward.id = :WARDID) OR (spec is null and dftPat.ward.id = :WARDID)) ");
			markers.add("WARDID");
			values.add(wardId);
		}
		
		if (specimenType != null)
		{
			hql.append(" and ");
			hql.append("sp.listType = :LT ");
			markers.add("LT");
			values.add(getDomLookup(specimenType));
		}
		if (specimenStatus != null)
		{
			boolean hasSecondStatus = secondStatus != null;

			hql.append(" and ");
			if(hasSecondStatus)
				hql.append(" (");
			
			hql.append(" sp.collectionStatus = :COLSTAT ");
			markers.add("COLSTAT");
			values.add(getDomLookup(specimenStatus));
			
			if(hasSecondStatus)
			{
				hql.append(" or ");
				hql.append(" sp.collectionStatus = :COLSTAT2 ");
				markers.add("COLSTAT2");
				values.add(getDomLookup(secondStatus));
			}
			
			if(hasSecondStatus)
				hql.append(")");
		}
		else
		{
			//WDEV-12906
			hql.append(" and ");
			hql.append(" ( sp.collectionStatus <> :COLSTAT and (specStatus.reason is not null OR (specStatus.reason is null and sp.collectionStatus <> :COLSTAT2 ))) "); //WDEV-16732
			markers.add("COLSTAT");
			values.add(getDomLookup(SpecimenCollectionStatus.AWAITING_AUTHORISATION));
			markers.add("COLSTAT2");
			values.add(getDomLookup(SpecimenCollectionStatus.CANCELLED));
		}

		String startDateTimeQuery = "((sp.dateToCollect >= :STARTDATE and sp.timeToCollect = null) or (sp.dateToCollect > :STARTDATE or (sp.dateToCollect = :STARTDATE and sp.timeToCollect >= :STARTTIME)))";
		String endDateTimeQuery   = "((sp.dateToCollect <= :ENDDATE   and sp.timeToCollect = null) or (sp.dateToCollect < :ENDDATE   or (sp.dateToCollect = :ENDDATE   and sp.timeToCollect <= :ENDTIME)))";
		if(startTime == null && endTime == null)
		{
			hql.append(" and ");
			hql.append("(sp.dateToCollect  between :STARTDATE and :ENDDATE)");
			markers.add("STARTDATE");
			markers.add("ENDDATE");
			values.add(startDate.getDate());
			values.add(endDate.getDate());
		}
		else if(startTime != null && endTime != null)
		{
			hql.append(" and ");
			hql.append(startDateTimeQuery);
			hql.append(" and ");
			hql.append(endDateTimeQuery);
			markers.add("STARTDATE");
			markers.add("STARTTIME");
			markers.add("ENDDATE");
			markers.add("ENDTIME");
			values.add(startDate.getDate());
			values.add(startTime.toString());
			values.add(endDate.getDate());
			values.add(endTime.toString());
		}
		else if(startTime != null && endTime == null)
		{
			hql.append(" and ");
			hql.append(startDateTimeQuery);
			hql.append(" and ");
			hql.append("(sp.dateToCollect <= :ENDDATE)");
			markers.add("STARTDATE");
			markers.add("STARTTIME");
			markers.add("ENDDATE");
			values.add(startDate.getDate());
			values.add(startTime.toString());
			values.add(endDate.getDate());
		}
		else if(startTime == null && endTime != null)
		{
			hql.append(" and ");
			hql.append("(sp.dateToCollect >= :STARTDATE)");
			hql.append(" and ");
			hql.append(endDateTimeQuery);
			markers.add("STARTDATE");
			markers.add("ENDDATE");
			markers.add("ENDTIME");
			values.add(startDate.getDate());
			values.add(endDate.getDate());
			values.add(endTime.toString());
		}
		
		hql.append(" order by sp.dateToCollect asc, sp.timeToCollect asc");

		List list = getDomainFactory().find(hql.toString(), markers, values);
		return SpecimenWorkListItemListVoAssembler.createSpecimenWorkListItemListVoCollectionFromSpecimenWorkListItem(list).sort();
	}
	
	public MemberOfStaffShortVoCollection listMembersOfStaff(MemberOfStaffShortVo filter)
	{
		MosAdmin adminImpl = (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return adminImpl.listMembersOfStaff(filter);
	}
	
	public SpecimenWorkListItemListVo saveWorkListItem(SpecimenWorkListItemListVo orderSpecimenVo) throws StaleObjectException
	{
		if (orderSpecimenVo == null)
			throw new CodingRuntimeException("Cannot save null SpecimenWorkListItemListVo");
		DomainFactory factory = getDomainFactory();

		SpecimenWorkListItem doSpecimenWorkListItem = SpecimenWorkListItemListVoAssembler.extractSpecimenWorkListItem(factory, orderSpecimenVo);

		if(doSpecimenWorkListItem.getSpecimen()!=null && orderSpecimenVo.getCollectionStatusIsNotNull() && orderSpecimenVo.getCollectionStatus().equals(SpecimenCollectionStatus.COLLECTIONCOMPLETE))
		{
			java.util.Set investigations = doSpecimenWorkListItem.getSpecimen().getInvestigations();
			for (java.util.Iterator iter = investigations.iterator(); iter.hasNext();)
			{
				Object obj = iter.next();
				if (obj instanceof OrderInvestigation)
				{
					OrderInvestigation element = (OrderInvestigation) obj;
					element.setDisplayDateTime(orderSpecimenVo.getSpecimen().getCollDateTimePlacer().getJavaDate());
					element.setDisplayFlag(getDomLookup(OcsDisplayFlag.SPEC_COLL));
				}
			}
		}
		
		factory.save(doSpecimenWorkListItem);
		return SpecimenWorkListItemListVoAssembler.create(doSpecimenWorkListItem);
	}

	public SpecimenWorkListItemListVoCollection markWorkListItemsAsPrinted(SpecimenWorkListItemListVoCollection workListItemCollection) throws StaleObjectException
	{
		SpecimenWorkListItemListVoCollection voColl = new SpecimenWorkListItemListVoCollection();
		DomainFactory factory = getDomainFactory();
		for (int i = 0; i < workListItemCollection.size(); i++)
		{
			SpecimenWorkListItem doSpecimenWorkListItem = SpecimenWorkListItemListVoAssembler.extractSpecimenWorkListItem(factory, workListItemCollection.get(i));
			factory.save(doSpecimenWorkListItem);
			voColl.add(SpecimenWorkListItemListVoAssembler.create(doSpecimenWorkListItem));
		}
		return voColl;
	}
	public LocShortMappingsVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl  = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitals();
	}

	public LocShortVoCollection listActiveWardsForHospital(LocationRefVo hospital, String name)
	{
		OrganisationAndLocation impl  = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveWardsForHospital(hospital, name);
	}
	
	//WDEV-2281
	public Boolean isAtLeastOneActivePhlebMayCollect(SpecimenWorkListItemRefVo specimenWorkListItemRefVo)
	{
		if(specimenWorkListItemRefVo == null)
			return Boolean.FALSE;
		StringBuffer query = new StringBuffer(); 
		query.append("select s1_1.id, i2_1.phlebMayCollect");
		query.append(" from SpecimenWorkListItem as s1_1 left join s1_1.specimen as o1_1 left join o1_1.investigations as o2_1 left join o2_1.investigation as i1_1 left join i1_1.investigationIndex as i2_1");
		query.append(" where");
		query.append(" (i2_1.phlebMayCollect = :ACTIVE and s1_1.id = :ID)");
		query.append(" and s1_1.isRIE is null");
		
		boolean isAtLeastOneActivePhlebMayCollect =  getDomainFactory().find(query.toString(), new String[] {"ACTIVE", "ID"}, new Object[] {Boolean.TRUE, specimenWorkListItemRefVo.getID_SpecimenWorkListItem()}).size() > 0;

		return new Boolean(isAtLeastOneActivePhlebMayCollect);
	}

	public PatientShort getPatient(PatientRefVo patientRefVo)
	{
		if(patientRefVo == null)
			throw new RuntimeException("Cannot get Patient for null PatientRefVo");

		DomainFactory factory = getDomainFactory();
		Patient doPatient = (Patient)factory.getDomainObject(Patient.class, patientRefVo.getID_Patient());
		return PatientShortAssembler.create(doPatient);
	}

	//WDEV-10851
	public LocationLiteVo getWard(Integer wardId) 
	{
		if(wardId == null)
			throw new CodingRuntimeException("Can not get Ward on null Id.");
		
		return LocationLiteVoAssembler.create((Location) getDomainFactory().getDomainObject(Location.class, wardId));
	}

	public PatientShort getPatientById(Integer patientId)
	{
		if(patientId == null)
			throw new CodingRuntimeException("Cannot get Patient on null Id.");
		
		return PatientShortAssembler.create((Patient)getDomainFactory().getDomainObject(Patient.class, patientId));
	}

	//WDEV-16691
	public LocationLiteVo getHospitalForCurrentLocation(Integer locId)
	{
		if (locId == null)
			throw new CodingRuntimeException("Cannot get the Hospital for a null Location.");

		DomainFactory factory = getDomainFactory();
		Location doLocation = (Location) factory.getDomainObject(Location.class, locId);

		return getHospital(doLocation);
	}
	
	private LocShortMappingsVo getHospital(Location doLocation)
	{
		if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
		{
			return LocShortMappingsVoAssembler.create((LocSite) doLocation);
		}

		while (doLocation.getParentLocation() != null)
		{
			doLocation = doLocation.getParentLocation();

			if (doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			{
				return LocShortMappingsVoAssembler.create((LocSite) doLocation);
			}
		}

		return null;
	}

	//WDEV-16708
	public SpecimenWorkListItemListVo getSpecimenWorkListItem(Integer specimenId)
	{
		if(specimenId == null)
			throw new CodingRuntimeException("Cannot get Specimen on null Id.");
		
		return SpecimenWorkListItemListVoAssembler.create((SpecimenWorkListItem) getDomainFactory().getDomainObject(SpecimenWorkListItem.class, specimenId));
	}
}
