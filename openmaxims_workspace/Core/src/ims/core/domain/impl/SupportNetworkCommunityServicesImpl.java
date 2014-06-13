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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.53 build 2510.31460)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;

import ims.core.domain.SupportNetworkProfessionalServices;
import ims.core.domain.impl.SupportNetworkProfessionalServicesImpl;
import ims.core.domain.base.impl.BaseSupportNetworkCommunityServicesImpl;
import ims.core.clinical.domain.objects.CommunityServices;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.SupportNetworkServicesVoCollection;
import ims.core.vo.domain.CommunityServiceVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

public class SupportNetworkCommunityServicesImpl extends BaseSupportNetworkCommunityServicesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.CommunityServiceVo saveCommunitService(ims.core.vo.CommunityServiceVo communityService) throws ims.domain.exceptions.StaleObjectException
	{
		if(!communityService.isValidated())
			throw new DomainRuntimeException("communityService Value Object has not been validated");
				
		DomainFactory factory = getDomainFactory();
		
		CommunityServices doComService = CommunityServiceVoAssembler.extractCommunityServices(factory, communityService);

		factory.save(doComService);
		
		return CommunityServiceVoAssembler.create(doComService);
	}

	public ims.core.vo.CommunityServiceVoCollection listCommunityServicesByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef, Boolean activeOnly)
	{
		if (voCareContextRef == null)
			throw new CodingRuntimeException("Care Context was not supplied. Mandatory argument");
	
		DomainFactory factory = getDomainFactory();
		
		String hqlQuery = " from CommunityServices cs ";
		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markerNames = new ArrayList<String>();
		ArrayList<Object> markerValues = new ArrayList<Object>();
				
		condStr.append(" where ");
		
		if(voCareContextRef != null)
		{
			condStr.append(" cs.careContext.id = :careContext and cs.isCurrentlyActive = :active");
			markerNames.add("careContext");
			markerValues.add(voCareContextRef.getID_CareContext());
			markerNames.add("active");
			markerValues.add(activeOnly);			
		}
		
		hqlQuery += condStr.toString();
		hqlQuery += " order by systemInformation.creationDateTime asc";
		
		java.util.List<?> lst = factory.find(hqlQuery,markerNames,markerValues);	

		return CommunityServiceVoAssembler.createCommunityServiceVoCollectionFromCommunityServices(lst).sort();
		
	}

	public ims.core.vo.LocationServiceVo getLocationService(ims.core.vo.LocShortVo locShort, ims.core.clinical.vo.ServiceRefVo service)
	{
		SupportNetworkProfessionalServices supnetProf = (SupportNetworkProfessionalServices)getDomainImpl(SupportNetworkProfessionalServicesImpl.class);
		return supnetProf.getLocationService(locShort,service);
	}

	public ims.core.vo.ServiceVoCollection listService(ims.core.vo.lookups.ServiceCategoryCollection excludedServices)
	{
		SupportNetworkProfessionalServices supnetProf = (SupportNetworkProfessionalServices)getDomainImpl(SupportNetworkProfessionalServicesImpl.class);
		return supnetProf.listService(excludedServices);
	}

	public LocShortVoCollection listLocations(ServiceRefVo service) 
	{
		SupportNetworkProfessionalServices supnetProf = (SupportNetworkProfessionalServices)getDomainImpl(SupportNetworkProfessionalServicesImpl.class);
		return supnetProf.listLocations(service);	
	}

	public SupportNetworkServicesVoCollection listSupportNetworkServiceByPatient(PatientShort voPatientShort, Boolean activeOnly) 
	{
		SupportNetworkProfessionalServices supnetProf = (SupportNetworkProfessionalServices)getDomainImpl(SupportNetworkProfessionalServicesImpl.class);
		return supnetProf.listSupportNetworkServicesByPatient(activeOnly,voPatientShort);
	}
}
