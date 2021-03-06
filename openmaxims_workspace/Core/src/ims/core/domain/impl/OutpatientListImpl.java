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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.ClinicAdmin;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.ClinicAdminImpl;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.domain.base.impl.BaseOutpatientListImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.core.vo.domain.OutPatientListVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.correspondence.configuration.domain.objects.UserAccess;
import ims.correspondence.vo.UserAccessVo;
import ims.correspondence.vo.domain.UserAccessVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class OutpatientListImpl extends BaseOutpatientListImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.OutPatientListVoCollection listOutpatients(ims.core.resource.place.vo.ClinicRefVo voClinicRef, ims.core.resource.people.vo.MedicRefVo voConsultantRef, ims.core.vo.lookups.Specialty specialty, ims.framework.utils.Date clinicDate)
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();


		
		hql = " from OutpatientAttendance op "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " and ";
		
		condStr.append(" op.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);
	
		if (voClinicRef != null)
		{
			condStr.append(andStr + " op.clinic.id = :clinic");
			markers.add("clinic");
			values.add(voClinicRef.getID_Clinic());
		}
		if (voConsultantRef != null)
		{
			condStr.append(andStr + " op.pasEvent.consultant.id = :cons");
			markers.add("cons");
			values.add(voConsultantRef.getID_Hcp());
		}
		if (specialty != null)
		{
			condStr.append(andStr + " op.pasEvent.specialty = :spec");
			markers.add("spec");
			values.add(getDomLookup(specialty));
		}
		if (clinicDate != null)
		{
			condStr.append(andStr + " op.appointmentDateTime >= :startdate");
			condStr.append(andStr + " op.appointmentDateTime < :enddate");
			markers.add("startdate");
			markers.add("enddate");
			values.add(clinicDate.getDate());
			values.add(clinicDate.copy().addDay(1).getDate());
		}
	
		hql += " where ";
		
		hql += condStr.toString();
		List ops = factory.find(hql, markers, values);
		
		return OutPatientListVoAssembler.createOutPatientListVoCollectionFromOutpatientAttendance(ops).sort();
		
		
	}

	public LocationLiteVoCollection listActiveLocations()
	{
		OrganisationAndLocation orgLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return orgLoc.listActiveLocSiteLite();
	}

	public ClinicLiteVoCollection listClinicsforLocation(LocationRefVo voLocRef, String strClinicName)
	{
		//WDEV-15039
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String prepend = " where clin.isActive = 1 and ";
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer("from Clinic clin ");
		if (voLocRef != null)
		{
			hql.append(prepend + " clin.clinicLocation.id = :idLocation ");
			names.add("idLocation");
			values.add(voLocRef.getID_Location());
			prepend = " and ";
		}		
		if (strClinicName != null && strClinicName.length() > 0)
		{
			hql.append(prepend + " (upper(clin.clinicName) like :clinName) ");
			names.add("clinName");
			values.add("%" + strClinicName.toUpperCase() + "%");
		}
		List clinics = factory.find(hql.toString(), names, values, 1000);
		return ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(clinics).sort(true);
		
	}

	public MedicLiteVoCollection listActiveMedics(String strMedicName)
	{	
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		HcpLiteVoCollection hcpMeds = hcpAdmin.listHcpLiteByNameAndDisciplineType(strMedicName, HcpDisType.MEDICAL);
		//WDEV-8204 - tried to not modify the used vos in the form
		if (hcpMeds == null || hcpMeds.size()==0)
			return null;
		MedicLiteVoCollection medMeds = new MedicLiteVoCollection();
		MedicLiteVo med = null;
		for (int i=0 ; i<hcpMeds.size() ; i++)
		{
			HcpLiteVo hcpLiteVo = hcpMeds.get(i);
			if (hcpLiteVo!=null){
				med = new MedicLiteVo();
				med.setID_Hcp(hcpLiteVo.getID_Hcp());
				med.setMos(hcpLiteVo.getMos());
				medMeds.add(med);
			}
		}
		return medMeds;
		//return hcpAdmin.listActiveMedics(strMedicName);
	}

	public UserAccessVo getUserAccess(Integer userID) {
		if (userID == null)
			throw new CodingRuntimeException("Can not search on null user");
		
		DomainFactory factory = getDomainFactory();
		return UserAccessVoAssembler.create(UserAccess.getUserAccessFromAppUser(factory, userID));	
	}

	public LocationLiteVoCollection listActiveHospitalsLite() {
		OrganisationAndLocation orgLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return orgLoc.listActiveHospitalsLite();
	}
}
