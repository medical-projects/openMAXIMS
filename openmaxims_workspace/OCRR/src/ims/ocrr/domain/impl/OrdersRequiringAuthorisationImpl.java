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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.51 build 2461.17017)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.ClinicRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;
import ims.ocrr.domain.MyOrder;
import ims.ocrr.domain.base.impl.BaseOrdersRequiringAuthorisationImpl;
import ims.ocrr.vo.OcsOrderInvVoCollection;
import ims.ocrr.vo.domain.OcsOrderInvVoAssembler;
import ims.ocrr.vo.lookups.AuthorisationOrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrdersRequiringAuthorisationImpl extends BaseOrdersRequiringAuthorisationImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listWardsForHospitalByName
	*/
	public ims.core.vo.LocationLiteVoCollection listWardsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo location, String name)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveWardsForHospitalByNameLite(location, name);
	}

	/**
	* listClinicsForHospitalByName
	*/
	public ims.core.vo.ClinicLiteVoCollection listClinicsForHospitalByNameLite(ims.core.resource.place.vo.LocationRefVo location, String name)
	{
		MyOrder impl = (MyOrder) getDomainImpl(MyOrderImpl.class);
		return impl.listClinicsForHospitalByNameLite(location, name);
	}

	/**
	* List active locations where the location type is hospital
	*/
	public ims.core.vo.LocShortMappingsVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitals();
	}

	/**
	* list from OcsOrder where OrderAuthorisaton = AWAITING_AUTHORISATION
	*/
	public OcsOrderInvVoCollection listOrdersRequiringAuthorisation(Date dateFrom, Date dateTo, ClinicRefVo clinic, LocationRefVo location, HcpRefVo responsibleClinician)
	{
		DomainFactory factory = getDomainFactory();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList values = new ArrayList();
		
		String hql = "from OcsOrderSession ocsOrder where ocsOrder.authorisationOrderStatus = :status "; 
		markers.add("status");
		values.add(getDomLookup(AuthorisationOrderStatus.AWAITING_AUTHORISATION));
		
		StringBuffer condStr = new StringBuffer();
		String andStr = " and ";
	
		if(dateFrom != null)
		{
			condStr.append(andStr + " ocsOrder.systemInformation.creationDateTime >= :dateFrom");
 			markers.add("dateFrom");
			values.add(dateFrom.getDate());
		}	
			
		if(dateTo != null)
		{
			condStr.append(andStr + " ocsOrder.systemInformation.creationDateTime <= :dateTo");
 			markers.add("dateTo");
			values.add(dateTo.addDay(1).getDate());
		}
		
		if(clinic != null)
		{
			condStr.append(andStr + " ocsOrder.patientClinic.id = :clinicId");
			markers.add("clinicId");
			values.add(clinic.getID_Clinic());
		}

		if(location != null)
		{
			condStr.append(andStr + " ocsOrder.patientLocation.id = :locationId");
			markers.add("locationId");
			values.add(location.getID_Location());
		}
		
		if(responsibleClinician != null)
		{
			condStr.append(andStr + " ocsOrder.responsibleClinician.id = :hcpId");
			markers.add("hcpId");
			values.add(responsibleClinician.getID_Hcp());
		}
	
		hql += condStr.toString();
		return OcsOrderInvVoAssembler.createOcsOrderInvVoCollectionFromOcsOrderSession(factory.find(hql,markers,values)).sort();//WDEV-16232
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);
	}

	public LocationLiteVoCollection listAandEForHospitalByNameLite(	LocationRefVo hosp, String name) 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveAandEForHospitalByNameLite(hosp, name);
	}

	public LocationLiteVoCollection listUserEnteredLocationsForHospitalByNameLite(LocationRefVo hosp, String name) 
	{
		if(hosp == null || hosp.getID_Location() == null)
			throw new CodingRuntimeException("Hospital parameter value not supplied for method :listUserEnteredLocationsForHospitalNyNameLite");

		DomainFactory factory = getDomainFactory();
		List locs = factory.find("from Location loc where loc.parentLocation.id = :hospId and loc.upperName like :name and loc.type.id >= 0 and loc.isActive = true and loc.isVirtual = false", new String[]{"hospId", "name"}, new Object[] {hosp.getID_Location(), name.toUpperCase() + "%"});
		if(locs != null && locs.size() > 0)
			return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locs);

		return null;
	}

	//WDEV-17494
	public LocationLiteVo getCurrentHospital(ILocation currentLocation) 
	{
		if(currentLocation == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		Location currentHospital = getHospital((Location) factory.getDomainObject(Location.class, currentLocation.getID()));
		
		if(currentHospital instanceof Location)
			return LocationLiteVoAssembler.create((Location) currentHospital);
		
		return null;
	}
	
	private Location getHospital(Location doLocation)
	{
		if(doLocation == null)
			return null;
		
		if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return doLocation;
	
		while(doLocation.getParentLocation() != null) 
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return doLocation;
		}
		
		return null;
	}
}
