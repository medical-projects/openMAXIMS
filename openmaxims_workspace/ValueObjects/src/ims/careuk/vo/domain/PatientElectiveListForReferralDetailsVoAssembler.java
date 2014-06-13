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
package ims.careuk.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Bogdan Tofei
 */
public class PatientElectiveListForReferralDetailsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.PatientElectiveListForReferralDetailsVo copy(ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObjectDest, ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatientElectiveList(valueObjectSrc.getID_PatientElectiveList());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ElectiveList
		valueObjectDest.setElectiveList(valueObjectSrc.getElectiveList());
		// DateOnList
		valueObjectDest.setDateOnList(valueObjectSrc.getDateOnList());
		// ElectiveListStatus
		valueObjectDest.setElectiveListStatus(valueObjectSrc.getElectiveListStatus());
		// TCIHistory
		valueObjectDest.setTCIHistory(valueObjectSrc.getTCIHistory());
		// TCIDetails
		valueObjectDest.setTCIDetails(valueObjectSrc.getTCIDetails());
		// PrimaryProcedure
		valueObjectDest.setPrimaryProcedure(valueObjectSrc.getPrimaryProcedure());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.PatientElectiveList objects.
	 */
	public static ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(java.util.Set domainObjectSet)	
	{
		return createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.PatientElectiveList objects.
	 */
	public static ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voList = new ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.PatientElectiveList domainObject = (ims.careuk.domain.objects.PatientElectiveList) iterator.next();
			ims.careuk.vo.PatientElectiveListForReferralDetailsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.careuk.domain.objects.PatientElectiveList objects.
	 */
	public static ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(java.util.List domainObjectList) 
	{
		return createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.PatientElectiveList objects.
	 */
	public static ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection createPatientElectiveListForReferralDetailsVoCollectionFromPatientElectiveList(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voList = new ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.PatientElectiveList domainObject = (ims.careuk.domain.objects.PatientElectiveList) domainObjectList.get(i);
			ims.careuk.vo.PatientElectiveListForReferralDetailsVo vo = create(map, domainObject);

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
	 * Create the ims.careuk.domain.objects.PatientElectiveList set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatientElectiveListSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voCollection) 
	 {
	 	return extractPatientElectiveListSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatientElectiveListSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.PatientElectiveListForReferralDetailsVo vo = voCollection.get(i);
			ims.careuk.domain.objects.PatientElectiveList domainObject = PatientElectiveListForReferralDetailsVoAssembler.extractPatientElectiveList(domainFactory, vo, domMap);

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
	 * Create the ims.careuk.domain.objects.PatientElectiveList list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatientElectiveListList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voCollection) 
	 {
	 	return extractPatientElectiveListList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatientElectiveListList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.PatientElectiveListForReferralDetailsVo vo = voCollection.get(i);
			ims.careuk.domain.objects.PatientElectiveList domainObject = PatientElectiveListForReferralDetailsVoAssembler.extractPatientElectiveList(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.careuk.domain.objects.PatientElectiveList object.
	 * @param domainObject ims.careuk.domain.objects.PatientElectiveList
	 */
	 public static ims.careuk.vo.PatientElectiveListForReferralDetailsVo create(ims.careuk.domain.objects.PatientElectiveList domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.PatientElectiveList object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.PatientElectiveListForReferralDetailsVo create(DomainObjectMap map, ims.careuk.domain.objects.PatientElectiveList domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObject = (ims.careuk.vo.PatientElectiveListForReferralDetailsVo) map.getValueObject(domainObject, ims.careuk.vo.PatientElectiveListForReferralDetailsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.PatientElectiveListForReferralDetailsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.PatientElectiveList
	 */
	 public static ims.careuk.vo.PatientElectiveListForReferralDetailsVo insert(ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObject, ims.careuk.domain.objects.PatientElectiveList domainObject) 
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
	 * @param domainObject ims.careuk.domain.objects.PatientElectiveList
	 */
	 public static ims.careuk.vo.PatientElectiveListForReferralDetailsVo insert(DomainObjectMap map, ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObject, ims.careuk.domain.objects.PatientElectiveList domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatientElectiveList(domainObject.getId());
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
			
		// ElectiveList
		valueObject.setElectiveList(ims.careuk.vo.domain.PatientElectiveListConfigForReferralDetailsVoAssembler.create(map, domainObject.getElectiveList()) );
		// DateOnList
		java.util.Date DateOnList = domainObject.getDateOnList();
		if ( null != DateOnList ) 
		{
			valueObject.setDateOnList(new ims.framework.utils.Date(DateOnList) );
		}
		// ElectiveListStatus
		valueObject.setElectiveListStatus(ims.careuk.vo.domain.ElectiveListStatusVoAssembler.create(map, domainObject.getElectiveListStatus()) );
		// TCIHistory
		ims.careuk.vo.TCIForPatientElectiveListRefVoCollection TCIHistory = new ims.careuk.vo.TCIForPatientElectiveListRefVoCollection();
		for(java.util.Iterator iterator = domainObject.getTCIHistory().iterator(); iterator.hasNext(); ) 
		{
			ims.careuk.domain.objects.TCIForPatientElectiveList tmp = (ims.careuk.domain.objects.TCIForPatientElectiveList)iterator.next();
			if (tmp != null)
				TCIHistory.add(new ims.careuk.vo.TCIForPatientElectiveListRefVo(tmp.getId(),tmp.getVersion()));
		}
		valueObject.setTCIHistory(TCIHistory);
		// TCIDetails
		valueObject.setTCIDetails(ims.careuk.vo.domain.ElectiveTCIForReferralDetailsVoAssembler.create(map, domainObject.getTCIDetails()) );
		// PrimaryProcedure
		valueObject.setPrimaryProcedure(ims.core.vo.domain.ProcedureLiteVoAssembler.create(map, domainObject.getPrimaryProcedure()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.PatientElectiveList extractPatientElectiveList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObject) 
	{
		return 	extractPatientElectiveList(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.PatientElectiveList extractPatientElectiveList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.PatientElectiveListForReferralDetailsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatientElectiveList();
		ims.careuk.domain.objects.PatientElectiveList domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.PatientElectiveList)domMap.get(valueObject);
			}
			// ims.careuk.vo.PatientElectiveListForReferralDetailsVo ID_PatientElectiveList field is unknown
			domainObject = new ims.careuk.domain.objects.PatientElectiveList();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatientElectiveList());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.PatientElectiveList)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.PatientElectiveList) domainFactory.getDomainObject(ims.careuk.domain.objects.PatientElectiveList.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatientElectiveList());

		domainObject.setElectiveList(ims.careuk.vo.domain.PatientElectiveListConfigForReferralDetailsVoAssembler.extractElectiveListConfiguration(domainFactory, valueObject.getElectiveList(), domMap));
		java.util.Date value2 = null;
		ims.framework.utils.Date date2 = valueObject.getDateOnList();		
		if ( date2 != null ) 
		{
			value2 = date2.getDate();
		}
		domainObject.setDateOnList(value2);
		domainObject.setElectiveListStatus(ims.careuk.vo.domain.ElectiveListStatusVoAssembler.extractElectiveListStatus(domainFactory, valueObject.getElectiveListStatus(), domMap));

		ims.careuk.vo.TCIForPatientElectiveListRefVoCollection refCollection4 = valueObject.getTCIHistory();
		int size4 = (null == refCollection4) ? 0 : refCollection4.size();		
		java.util.List domainTCIHistory4 = domainObject.getTCIHistory();
		if (domainTCIHistory4 == null)
		{
			domainTCIHistory4 = new java.util.ArrayList();
		}
		for(int i=0; i < size4; i++) 
		{
			ims.careuk.vo.TCIForPatientElectiveListRefVo vo = refCollection4.get(i);			
			ims.careuk.domain.objects.TCIForPatientElectiveList dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.careuk.domain.objects.TCIForPatientElectiveList)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.careuk.domain.objects.TCIForPatientElectiveList)domainFactory.getDomainObject( ims.careuk.domain.objects.TCIForPatientElectiveList.class, vo.getBoId());
				}
			}

			int domIdx = domainTCIHistory4.indexOf(dom);
			if (domIdx == -1)
			{
				domainTCIHistory4.add(i, dom);
			}
			else if (i != domIdx && i < domainTCIHistory4.size())
			{
				Object tmp = domainTCIHistory4.get(i);
				domainTCIHistory4.set(i, domainTCIHistory4.get(domIdx));
				domainTCIHistory4.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i4 = domainTCIHistory4.size();
		while (i4 > size4)
		{
			domainTCIHistory4.remove(i4-1);
			i4 = domainTCIHistory4.size();
		}
		
		domainObject.setTCIHistory(domainTCIHistory4);		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.careuk.domain.objects.TCIForPatientElectiveList value5 = null;
		if ( null != valueObject.getTCIDetails() ) 
		{
			if (valueObject.getTCIDetails().getBoId() == null)
			{
				if (domMap.get(valueObject.getTCIDetails()) != null)
				{
					value5 = (ims.careuk.domain.objects.TCIForPatientElectiveList)domMap.get(valueObject.getTCIDetails());
				}
			}
			else
			{
				value5 = (ims.careuk.domain.objects.TCIForPatientElectiveList)domainFactory.getDomainObject(ims.careuk.domain.objects.TCIForPatientElectiveList.class, valueObject.getTCIDetails().getBoId());
			}
		}
		domainObject.setTCIDetails(value5);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Procedure value6 = null;
		if ( null != valueObject.getPrimaryProcedure() ) 
		{
			if (valueObject.getPrimaryProcedure().getBoId() == null)
			{
				if (domMap.get(valueObject.getPrimaryProcedure()) != null)
				{
					value6 = (ims.core.clinical.domain.objects.Procedure)domMap.get(valueObject.getPrimaryProcedure());
				}
			}
			else
			{
				value6 = (ims.core.clinical.domain.objects.Procedure)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Procedure.class, valueObject.getPrimaryProcedure().getBoId());
			}
		}
		domainObject.setPrimaryProcedure(value6);

		return domainObject;
	}

}
