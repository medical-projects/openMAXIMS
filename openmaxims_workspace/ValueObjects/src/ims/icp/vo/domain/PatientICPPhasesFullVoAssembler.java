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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.icp.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Neil McAnaspie
 */
public class PatientICPPhasesFullVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.icp.vo.PatientICPPhasesFullVo copy(ims.icp.vo.PatientICPPhasesFullVo valueObjectDest, ims.icp.vo.PatientICPPhasesFullVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatientICPPhase(valueObjectSrc.getID_PatientICPPhase());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Patient
		valueObjectDest.setPatient(valueObjectSrc.getPatient());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// ICP
		valueObjectDest.setICP(valueObjectSrc.getICP());
		// Phase
		valueObjectDest.setPhase(valueObjectSrc.getPhase());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
		// StatusHistory
		valueObjectDest.setStatusHistory(valueObjectSrc.getStatusHistory());
		// CompletedOnDate
		valueObjectDest.setCompletedOnDate(valueObjectSrc.getCompletedOnDate());
		// PhaseActions
		valueObjectDest.setPhaseActions(valueObjectSrc.getPhaseActions());
		// ParentStage
		valueObjectDest.setParentStage(valueObjectSrc.getParentStage());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatientICPPhasesFullVoCollectionFromPatientICPPhase(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.icps.instantiation.domain.objects.PatientICPPhase objects.
	 */
	public static ims.icp.vo.PatientICPPhasesFullVoCollection createPatientICPPhasesFullVoCollectionFromPatientICPPhase(java.util.Set domainObjectSet)	
	{
		return createPatientICPPhasesFullVoCollectionFromPatientICPPhase(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.icps.instantiation.domain.objects.PatientICPPhase objects.
	 */
	public static ims.icp.vo.PatientICPPhasesFullVoCollection createPatientICPPhasesFullVoCollectionFromPatientICPPhase(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.icp.vo.PatientICPPhasesFullVoCollection voList = new ims.icp.vo.PatientICPPhasesFullVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.icps.instantiation.domain.objects.PatientICPPhase domainObject = (ims.icps.instantiation.domain.objects.PatientICPPhase) iterator.next();
			ims.icp.vo.PatientICPPhasesFullVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.icps.instantiation.domain.objects.PatientICPPhase objects.
	 */
	public static ims.icp.vo.PatientICPPhasesFullVoCollection createPatientICPPhasesFullVoCollectionFromPatientICPPhase(java.util.List domainObjectList) 
	{
		return createPatientICPPhasesFullVoCollectionFromPatientICPPhase(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.icps.instantiation.domain.objects.PatientICPPhase objects.
	 */
	public static ims.icp.vo.PatientICPPhasesFullVoCollection createPatientICPPhasesFullVoCollectionFromPatientICPPhase(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.icp.vo.PatientICPPhasesFullVoCollection voList = new ims.icp.vo.PatientICPPhasesFullVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.icps.instantiation.domain.objects.PatientICPPhase domainObject = (ims.icps.instantiation.domain.objects.PatientICPPhase) domainObjectList.get(i);
			ims.icp.vo.PatientICPPhasesFullVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.icps.instantiation.domain.objects.PatientICPPhase set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatientICPPhaseSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVoCollection voCollection) 
	 {
	 	return extractPatientICPPhaseSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatientICPPhaseSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.PatientICPPhasesFullVo vo = voCollection.get(i);
			ims.icps.instantiation.domain.objects.PatientICPPhase domainObject = PatientICPPhasesFullVoAssembler.extractPatientICPPhase(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.icps.instantiation.domain.objects.PatientICPPhase list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatientICPPhaseList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVoCollection voCollection) 
	 {
	 	return extractPatientICPPhaseList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatientICPPhaseList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.PatientICPPhasesFullVo vo = voCollection.get(i);
			ims.icps.instantiation.domain.objects.PatientICPPhase domainObject = PatientICPPhasesFullVoAssembler.extractPatientICPPhase(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.icps.instantiation.domain.objects.PatientICPPhase object.
	 * @param domainObject ims.icps.instantiation.domain.objects.PatientICPPhase
	 */
	 public static ims.icp.vo.PatientICPPhasesFullVo create(ims.icps.instantiation.domain.objects.PatientICPPhase domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.icps.instantiation.domain.objects.PatientICPPhase object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.icp.vo.PatientICPPhasesFullVo create(DomainObjectMap map, ims.icps.instantiation.domain.objects.PatientICPPhase domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.icp.vo.PatientICPPhasesFullVo valueObject = (ims.icp.vo.PatientICPPhasesFullVo) map.getValueObject(domainObject, ims.icp.vo.PatientICPPhasesFullVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.icp.vo.PatientICPPhasesFullVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.instantiation.domain.objects.PatientICPPhase
	 */
	 public static ims.icp.vo.PatientICPPhasesFullVo insert(ims.icp.vo.PatientICPPhasesFullVo valueObject, ims.icps.instantiation.domain.objects.PatientICPPhase domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.instantiation.domain.objects.PatientICPPhase
	 */
	 public static ims.icp.vo.PatientICPPhasesFullVo insert(DomainObjectMap map, ims.icp.vo.PatientICPPhasesFullVo valueObject, ims.icps.instantiation.domain.objects.PatientICPPhase domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatientICPPhase(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// Patient
		if (domainObject.getPatient() != null)
		{
			if(domainObject.getPatient() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPatient();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(id, -1));				
			}
			else
			{
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(domainObject.getPatient().getId(), domainObject.getPatient().getVersion()));
			}
		}
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
		// ICP
		if (domainObject.getICP() != null)
		{
			if(domainObject.getICP() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getICP();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setICP(new ims.icps.instantiation.vo.PatientICPRefVo(id, -1));				
			}
			else
			{
				valueObject.setICP(new ims.icps.instantiation.vo.PatientICPRefVo(domainObject.getICP().getId(), domainObject.getICP().getVersion()));
			}
		}
		// Phase
		if (domainObject.getPhase() != null)
		{
			if(domainObject.getPhase() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPhase();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPhase(new ims.icps.configuration.vo.ICPPhaseRefVo(id, -1));				
			}
			else
			{
				valueObject.setPhase(new ims.icps.configuration.vo.ICPPhaseRefVo(domainObject.getPhase().getId(), domainObject.getPhase().getVersion()));
			}
		}
		// CurrentStatus
		valueObject.setCurrentStatus(ims.icp.vo.domain.PatientICPPhaseStatusVoAssembler.create(map, domainObject.getCurrentStatus()) );
		// StatusHistory
		valueObject.setStatusHistory(ims.icp.vo.domain.PatientICPPhaseStatusVoAssembler.createPatientICPPhaseStatusVoCollectionFromPatientICPPhaseStatus(map, domainObject.getStatusHistory()) );
		// CompletedOnDate
		java.util.Date CompletedOnDate = domainObject.getCompletedOnDate();
		if ( null != CompletedOnDate ) 
		{
			valueObject.setCompletedOnDate(new ims.framework.utils.DateTime(CompletedOnDate) );
		}
		// PhaseActions
		valueObject.setPhaseActions(ims.icp.vo.domain.PatientICPActionFullVoAssembler.createPatientICPActionFullVoCollectionFromPatientICPAction(map, domainObject.getPhaseActions()) );
		// ParentStage
		if (domainObject.getParentStage() != null)
		{
			if(domainObject.getParentStage() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getParentStage();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setParentStage(new ims.icps.instantiation.vo.PatientICPStageRefVo(id, -1));				
			}
			else
			{
				valueObject.setParentStage(new ims.icps.instantiation.vo.PatientICPStageRefVo(domainObject.getParentStage().getId(), domainObject.getParentStage().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.icps.instantiation.domain.objects.PatientICPPhase extractPatientICPPhase(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVo valueObject) 
	{
		return 	extractPatientICPPhase(domainFactory, valueObject, new HashMap());
	}

	public static ims.icps.instantiation.domain.objects.PatientICPPhase extractPatientICPPhase(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.PatientICPPhasesFullVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatientICPPhase();
		ims.icps.instantiation.domain.objects.PatientICPPhase domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.icps.instantiation.domain.objects.PatientICPPhase)domMap.get(valueObject);
			}
			// ims.icp.vo.PatientICPPhasesFullVo ID_PatientICPPhase field is unknown
			domainObject = new ims.icps.instantiation.domain.objects.PatientICPPhase();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatientICPPhase());
			if (domMap.get(key) != null)
			{
				return (ims.icps.instantiation.domain.objects.PatientICPPhase)domMap.get(key);
			}
			domainObject = (ims.icps.instantiation.domain.objects.PatientICPPhase) domainFactory.getDomainObject(ims.icps.instantiation.domain.objects.PatientICPPhase.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatientICPPhase());

		ims.core.patient.domain.objects.Patient value1 = null;
		if ( null != valueObject.getPatient() ) 
		{
			if (valueObject.getPatient().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatient()) != null)
				{
					value1 = (ims.core.patient.domain.objects.Patient)domMap.get(valueObject.getPatient());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getPatient();	
			}
			else
			{
				value1 = (ims.core.patient.domain.objects.Patient)domainFactory.getDomainObject(ims.core.patient.domain.objects.Patient.class, valueObject.getPatient().getBoId());
			}
		}
		domainObject.setPatient(value1);
		ims.core.admin.domain.objects.CareContext value2 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value2 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getCareContext();	
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value2);
		ims.icps.instantiation.domain.objects.PatientICP value3 = null;
		if ( null != valueObject.getICP() ) 
		{
			if (valueObject.getICP().getBoId() == null)
			{
				if (domMap.get(valueObject.getICP()) != null)
				{
					value3 = (ims.icps.instantiation.domain.objects.PatientICP)domMap.get(valueObject.getICP());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getICP();	
			}
			else
			{
				value3 = (ims.icps.instantiation.domain.objects.PatientICP)domainFactory.getDomainObject(ims.icps.instantiation.domain.objects.PatientICP.class, valueObject.getICP().getBoId());
			}
		}
		domainObject.setICP(value3);
		ims.icps.configuration.domain.objects.ICPPhase value4 = null;
		if ( null != valueObject.getPhase() ) 
		{
			if (valueObject.getPhase().getBoId() == null)
			{
				if (domMap.get(valueObject.getPhase()) != null)
				{
					value4 = (ims.icps.configuration.domain.objects.ICPPhase)domMap.get(valueObject.getPhase());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value4 = domainObject.getPhase();	
			}
			else
			{
				value4 = (ims.icps.configuration.domain.objects.ICPPhase)domainFactory.getDomainObject(ims.icps.configuration.domain.objects.ICPPhase.class, valueObject.getPhase().getBoId());
			}
		}
		domainObject.setPhase(value4);
		domainObject.setCurrentStatus(ims.icp.vo.domain.PatientICPPhaseStatusVoAssembler.extractPatientICPPhaseStatus(domainFactory, valueObject.getCurrentStatus(), domMap));
		domainObject.setStatusHistory(ims.icp.vo.domain.PatientICPPhaseStatusVoAssembler.extractPatientICPPhaseStatusSet(domainFactory, valueObject.getStatusHistory(), domainObject.getStatusHistory(), domMap));		
		ims.framework.utils.DateTime dateTime7 = valueObject.getCompletedOnDate();
		java.util.Date value7 = null;
		if ( dateTime7 != null ) 
		{
			value7 = dateTime7.getJavaDate();
		}
		domainObject.setCompletedOnDate(value7);
		domainObject.setPhaseActions(ims.icp.vo.domain.PatientICPActionFullVoAssembler.extractPatientICPActionSet(domainFactory, valueObject.getPhaseActions(), domainObject.getPhaseActions(), domMap));		
		ims.icps.instantiation.domain.objects.PatientICPStage value9 = null;
		if ( null != valueObject.getParentStage() ) 
		{
			if (valueObject.getParentStage().getBoId() == null)
			{
				if (domMap.get(valueObject.getParentStage()) != null)
				{
					value9 = (ims.icps.instantiation.domain.objects.PatientICPStage)domMap.get(valueObject.getParentStage());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value9 = domainObject.getParentStage();	
			}
			else
			{
				value9 = (ims.icps.instantiation.domain.objects.PatientICPStage)domainFactory.getDomainObject(ims.icps.instantiation.domain.objects.PatientICPStage.class, valueObject.getParentStage().getBoId());
			}
		}
		domainObject.setParentStage(value9);

		return domainObject;
	}

}
