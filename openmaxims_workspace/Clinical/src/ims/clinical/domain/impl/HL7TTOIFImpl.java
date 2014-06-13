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
// This code was generated by Michael Noonan using IMS Development Environment (version 1.70 build 3434.14399)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;
import java.util.Set;

import ims.clinical.domain.base.impl.BaseHL7TTOIFImpl;
import ims.clinical.vo.AdmissionMedicationChangesVo;
import ims.clinical.vo.domain.AdmissionMedicationChangesVoAssembler;
import ims.clinical.vo.domain.TTODetailsIFVoAssembler;
import ims.clinical.vo.lookups.TTORequired;
import ims.core.admin.domain.objects.CareContext;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.ContextType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.MedicationDetails;

public class HL7TTOIFImpl extends BaseHL7TTOIFImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Impl for  TTO HL7 messages you finds the current I/P care context for the patient in the message (Note there will always be one open(no end/discharge date) I/P care context), then the MedicationDetails record for the care context and  replace the TTO coll
	*/
	public void setPatientCareContextTTORecord(ims.clinical.vo.PatientTTOIfVo patientTTOs)
	{
		if(patientTTOs==null)
			throw new DomainRuntimeException("Message details are null, cannot process message");
		if(patientTTOs.getPatient()==null)
			throw new DomainRuntimeException("Patient details are null, cannot process message");
		
		DomainFactory factory = getDomainFactory();
		CareContext careContext = getOpenInPatientCareContext(patientTTOs.getPatient());
		if (careContext==null)
			throw new DomainRuntimeException("Open inpatient care context cannot be found for patient");
		MedicationDetails md = getMedicationDetailsFromCareContext(careContext);
		if (md==null)
			throw new DomainRuntimeException("Failed to get or create Medication Details record");
		
		md.getTTAs().clear();
		md.getAdmissionMedicationChanges().clear();
		Set<?> ttoFromMessage=TTODetailsIFVoAssembler.extractTTAMedicationSet(factory,patientTTOs.getTTOs() );
		md.getTTAs().addAll(ttoFromMessage);
		
		Set<?> medChanges=AdmissionMedicationChangesVoAssembler.extractAdmissionMedicationChangesSet(factory, patientTTOs.getMedicationChanges());
		md.getAdmissionMedicationChanges().addAll(medChanges);
		try {
			factory.save(md);
		} catch(StaleObjectException soe)
		{
			throw new DomainRuntimeException(soe);
		}
	}
	
	private CareContext getOpenInPatientCareContext(PatientRefVo patientVo)
	{
		if(patientVo == null)
			throw new DomainRuntimeException("Invalid Argument: null Patient provided");

		DomainFactory factory = getDomainFactory();
		
		List<?> domCareContexts =	factory.find("select cc from CareContext cc left join cc.episodeOfCare " +
				" as e1_1 left join e1_1.careSpell as c2_1 left join c2_1.patient as p1_1" +
				" where p1_1.id = :PAT and cc.endDateTime is null and cc.context=:ContextType" , 
						new String[] {"PAT","ContextType"}, new Object[] { patientVo.getID_Patient(),getDomLookup(ContextType.INPATIENT)});
		if (domCareContexts!=null&&domCareContexts.size()!=0)
		{
			CareContext domCareContext = (CareContext)domCareContexts.get(0);
			return domCareContext;
		}
		else return null;
	}
	
	private MedicationDetails getMedicationDetailsFromCareContext(CareContext careContext)
	{
		DomainFactory factory = getDomainFactory();
		MedicationDetails md;
		List<?> medicationDetailsList = factory.find("select md from MedicationDetails md left join md.careContext cc where cc.id = :CC",
				new String[] {"CC"},new Object[]{careContext.getId()});
		if (medicationDetailsList==null||medicationDetailsList.size()==0||medicationDetailsList.get(0)==null)
		{
			// Create one
			md= new MedicationDetails();
			md.setCareContext(careContext);
			md.setTTARequired(getDomLookup(TTORequired.REQUIRED));
			return md;
		}
	return (MedicationDetails)medicationDetailsList.get(0);
	}
}
