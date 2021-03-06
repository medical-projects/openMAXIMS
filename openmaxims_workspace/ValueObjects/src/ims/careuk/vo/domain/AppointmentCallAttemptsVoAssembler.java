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
 * @author Rory Fitzpatrick
 */
public class AppointmentCallAttemptsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.AppointmentCallAttemptsVo copy(ims.careuk.vo.AppointmentCallAttemptsVo valueObjectDest, ims.careuk.vo.AppointmentCallAttemptsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AppointmentCallAttempts(valueObjectSrc.getID_AppointmentCallAttempts());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// CallDateTime
		valueObjectDest.setCallDateTime(valueObjectSrc.getCallDateTime());
		// Caller
		valueObjectDest.setCaller(valueObjectSrc.getCaller());
		// AppointmentService
		valueObjectDest.setAppointmentService(valueObjectSrc.getAppointmentService());
		// Reason
		valueObjectDest.setReason(valueObjectSrc.getReason());
		// CallerComments
		valueObjectDest.setCallerComments(valueObjectSrc.getCallerComments());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.AppointmentCallAttempts objects.
	 */
	public static ims.careuk.vo.AppointmentCallAttemptsVoCollection createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(java.util.Set domainObjectSet)	
	{
		return createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.AppointmentCallAttempts objects.
	 */
	public static ims.careuk.vo.AppointmentCallAttemptsVoCollection createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.AppointmentCallAttemptsVoCollection voList = new ims.careuk.vo.AppointmentCallAttemptsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.AppointmentCallAttempts domainObject = (ims.careuk.domain.objects.AppointmentCallAttempts) iterator.next();
			ims.careuk.vo.AppointmentCallAttemptsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.careuk.domain.objects.AppointmentCallAttempts objects.
	 */
	public static ims.careuk.vo.AppointmentCallAttemptsVoCollection createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(java.util.List domainObjectList) 
	{
		return createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.AppointmentCallAttempts objects.
	 */
	public static ims.careuk.vo.AppointmentCallAttemptsVoCollection createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.AppointmentCallAttemptsVoCollection voList = new ims.careuk.vo.AppointmentCallAttemptsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.AppointmentCallAttempts domainObject = (ims.careuk.domain.objects.AppointmentCallAttempts) domainObjectList.get(i);
			ims.careuk.vo.AppointmentCallAttemptsVo vo = create(map, domainObject);

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
	 * Create the ims.careuk.domain.objects.AppointmentCallAttempts set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAppointmentCallAttemptsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVoCollection voCollection) 
	 {
	 	return extractAppointmentCallAttemptsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAppointmentCallAttemptsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.AppointmentCallAttemptsVo vo = voCollection.get(i);
			ims.careuk.domain.objects.AppointmentCallAttempts domainObject = AppointmentCallAttemptsVoAssembler.extractAppointmentCallAttempts(domainFactory, vo, domMap);

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
	 * Create the ims.careuk.domain.objects.AppointmentCallAttempts list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAppointmentCallAttemptsList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVoCollection voCollection) 
	 {
	 	return extractAppointmentCallAttemptsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAppointmentCallAttemptsList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.AppointmentCallAttemptsVo vo = voCollection.get(i);
			ims.careuk.domain.objects.AppointmentCallAttempts domainObject = AppointmentCallAttemptsVoAssembler.extractAppointmentCallAttempts(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.careuk.domain.objects.AppointmentCallAttempts object.
	 * @param domainObject ims.careuk.domain.objects.AppointmentCallAttempts
	 */
	 public static ims.careuk.vo.AppointmentCallAttemptsVo create(ims.careuk.domain.objects.AppointmentCallAttempts domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.AppointmentCallAttempts object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.AppointmentCallAttemptsVo create(DomainObjectMap map, ims.careuk.domain.objects.AppointmentCallAttempts domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.AppointmentCallAttemptsVo valueObject = (ims.careuk.vo.AppointmentCallAttemptsVo) map.getValueObject(domainObject, ims.careuk.vo.AppointmentCallAttemptsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.AppointmentCallAttemptsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.AppointmentCallAttempts
	 */
	 public static ims.careuk.vo.AppointmentCallAttemptsVo insert(ims.careuk.vo.AppointmentCallAttemptsVo valueObject, ims.careuk.domain.objects.AppointmentCallAttempts domainObject) 
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
	 * @param domainObject ims.careuk.domain.objects.AppointmentCallAttempts
	 */
	 public static ims.careuk.vo.AppointmentCallAttemptsVo insert(DomainObjectMap map, ims.careuk.vo.AppointmentCallAttemptsVo valueObject, ims.careuk.domain.objects.AppointmentCallAttempts domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AppointmentCallAttempts(domainObject.getId());
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
			
		// CallDateTime
		java.util.Date CallDateTime = domainObject.getCallDateTime();
		if ( null != CallDateTime ) 
		{
			valueObject.setCallDateTime(new ims.framework.utils.DateTime(CallDateTime) );
		}
		// Caller
		valueObject.setCaller(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getCaller()) );
		// AppointmentService
		valueObject.setAppointmentService(ims.core.vo.domain.ServiceLiteVoAssembler.create(map, domainObject.getAppointmentService()) );
		// Reason
		ims.domain.lookups.LookupInstance instance4 = domainObject.getReason();
		if ( null != instance4 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance4.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance4.getImage().getImageId(), instance4.getImage().getImagePath());
			}
			color = instance4.getColor();
			if (color != null) 
				color.getValue();

			ims.careuk.vo.lookups.CallPurpose voLookup4 = new ims.careuk.vo.lookups.CallPurpose(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.careuk.vo.lookups.CallPurpose parentVoLookup4 = voLookup4;
			ims.domain.lookups.LookupInstance parent4 = instance4.getParent();
			while (parent4 != null)
			{
				if (parent4.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent4.getImage().getImageId(), parent4.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent4.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup4.setParent(new ims.careuk.vo.lookups.CallPurpose(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setReason(voLookup4);
		}
				// CallerComments
		valueObject.setCallerComments(domainObject.getCallerComments());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.AppointmentCallAttempts extractAppointmentCallAttempts(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVo valueObject) 
	{
		return 	extractAppointmentCallAttempts(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.AppointmentCallAttempts extractAppointmentCallAttempts(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.AppointmentCallAttemptsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AppointmentCallAttempts();
		ims.careuk.domain.objects.AppointmentCallAttempts domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.AppointmentCallAttempts)domMap.get(valueObject);
			}
			// ims.careuk.vo.AppointmentCallAttemptsVo ID_AppointmentCallAttempts field is unknown
			domainObject = new ims.careuk.domain.objects.AppointmentCallAttempts();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AppointmentCallAttempts());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.AppointmentCallAttempts)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.AppointmentCallAttempts) domainFactory.getDomainObject(ims.careuk.domain.objects.AppointmentCallAttempts.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AppointmentCallAttempts());

		ims.framework.utils.DateTime dateTime1 = valueObject.getCallDateTime();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setCallDateTime(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.MemberOfStaff value2 = null;
		if ( null != valueObject.getCaller() ) 
		{
			if (valueObject.getCaller().getBoId() == null)
			{
				if (domMap.get(valueObject.getCaller()) != null)
				{
					value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getCaller());
				}
			}
			else
			{
				value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getCaller().getBoId());
			}
		}
		domainObject.setCaller(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Service value3 = null;
		if ( null != valueObject.getAppointmentService() ) 
		{
			if (valueObject.getAppointmentService().getBoId() == null)
			{
				if (domMap.get(valueObject.getAppointmentService()) != null)
				{
					value3 = (ims.core.clinical.domain.objects.Service)domMap.get(valueObject.getAppointmentService());
				}
			}
			else
			{
				value3 = (ims.core.clinical.domain.objects.Service)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Service.class, valueObject.getAppointmentService().getBoId());
			}
		}
		domainObject.setAppointmentService(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getReason() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getReason().getID());
		}
		domainObject.setReason(value4);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getCallerComments() != null && valueObject.getCallerComments().equals(""))
		{
			valueObject.setCallerComments(null);
		}
		domainObject.setCallerComments(valueObject.getCallerComments());

		return domainObject;
	}

}
