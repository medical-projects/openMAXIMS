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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class SignatoryShiftDetailsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.SignatoryShiftDetailsVo copy(ims.core.vo.SignatoryShiftDetailsVo valueObjectDest, ims.core.vo.SignatoryShiftDetailsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_SignatoryShiftDetails(valueObjectSrc.getID_SignatoryShiftDetails());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// DateTimeSigned
		valueObjectDest.setDateTimeSigned(valueObjectSrc.getDateTimeSigned());
		// SignedOffBy
		valueObjectDest.setSignedOffBy(valueObjectSrc.getSignedOffBy());
		// StartTime
		valueObjectDest.setStartTime(valueObjectSrc.getStartTime());
		// EndTime
		valueObjectDest.setEndTime(valueObjectSrc.getEndTime());
		// ShiftStartDateTime
		valueObjectDest.setShiftStartDateTime(valueObjectSrc.getShiftStartDateTime());
		// ShiftEndDateTime
		valueObjectDest.setShiftEndDateTime(valueObjectSrc.getShiftEndDateTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.vitals.domain.objects.SignatoryShiftDetails objects.
	 */
	public static ims.core.vo.SignatoryShiftDetailsVoCollection createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(java.util.Set domainObjectSet)	
	{
		return createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.vitals.domain.objects.SignatoryShiftDetails objects.
	 */
	public static ims.core.vo.SignatoryShiftDetailsVoCollection createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.SignatoryShiftDetailsVoCollection voList = new ims.core.vo.SignatoryShiftDetailsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject = (ims.core.vitals.domain.objects.SignatoryShiftDetails) iterator.next();
			ims.core.vo.SignatoryShiftDetailsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.vitals.domain.objects.SignatoryShiftDetails objects.
	 */
	public static ims.core.vo.SignatoryShiftDetailsVoCollection createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(java.util.List domainObjectList) 
	{
		return createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.vitals.domain.objects.SignatoryShiftDetails objects.
	 */
	public static ims.core.vo.SignatoryShiftDetailsVoCollection createSignatoryShiftDetailsVoCollectionFromSignatoryShiftDetails(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.SignatoryShiftDetailsVoCollection voList = new ims.core.vo.SignatoryShiftDetailsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject = (ims.core.vitals.domain.objects.SignatoryShiftDetails) domainObjectList.get(i);
			ims.core.vo.SignatoryShiftDetailsVo vo = create(map, domainObject);

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
	 * Create the ims.core.vitals.domain.objects.SignatoryShiftDetails set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSignatoryShiftDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVoCollection voCollection) 
	 {
	 	return extractSignatoryShiftDetailsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSignatoryShiftDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SignatoryShiftDetailsVo vo = voCollection.get(i);
			ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject = SignatoryShiftDetailsVoAssembler.extractSignatoryShiftDetails(domainFactory, vo, domMap);

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
	 * Create the ims.core.vitals.domain.objects.SignatoryShiftDetails list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSignatoryShiftDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVoCollection voCollection) 
	 {
	 	return extractSignatoryShiftDetailsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSignatoryShiftDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.SignatoryShiftDetailsVo vo = voCollection.get(i);
			ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject = SignatoryShiftDetailsVoAssembler.extractSignatoryShiftDetails(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.vitals.domain.objects.SignatoryShiftDetails object.
	 * @param domainObject ims.core.vitals.domain.objects.SignatoryShiftDetails
	 */
	 public static ims.core.vo.SignatoryShiftDetailsVo create(ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.vitals.domain.objects.SignatoryShiftDetails object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.SignatoryShiftDetailsVo create(DomainObjectMap map, ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.SignatoryShiftDetailsVo valueObject = (ims.core.vo.SignatoryShiftDetailsVo) map.getValueObject(domainObject, ims.core.vo.SignatoryShiftDetailsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.SignatoryShiftDetailsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.vitals.domain.objects.SignatoryShiftDetails
	 */
	 public static ims.core.vo.SignatoryShiftDetailsVo insert(ims.core.vo.SignatoryShiftDetailsVo valueObject, ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject) 
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
	 * @param domainObject ims.core.vitals.domain.objects.SignatoryShiftDetails
	 */
	 public static ims.core.vo.SignatoryShiftDetailsVo insert(DomainObjectMap map, ims.core.vo.SignatoryShiftDetailsVo valueObject, ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_SignatoryShiftDetails(domainObject.getId());
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
			
		// DateTimeSigned
		java.util.Date DateTimeSigned = domainObject.getDateTimeSigned();
		if ( null != DateTimeSigned ) 
		{
			valueObject.setDateTimeSigned(new ims.framework.utils.DateTime(DateTimeSigned) );
		}
		// SignedOffBy
		valueObject.setSignedOffBy(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getSignedOffBy()) );
		// StartTime
		ims.domain.lookups.LookupInstance instance3 = domainObject.getStartTime();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.DailyTimePeriods voLookup3 = new ims.core.vo.lookups.DailyTimePeriods(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.DailyTimePeriods parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.DailyTimePeriods(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setStartTime(voLookup3);
		}
				// EndTime
		ims.domain.lookups.LookupInstance instance4 = domainObject.getEndTime();
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

			ims.core.vo.lookups.DailyTimePeriods voLookup4 = new ims.core.vo.lookups.DailyTimePeriods(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.DailyTimePeriods parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.DailyTimePeriods(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setEndTime(voLookup4);
		}
				// ShiftStartDateTime
		java.util.Date ShiftStartDateTime = domainObject.getShiftStartDateTime();
		if ( null != ShiftStartDateTime ) 
		{
			valueObject.setShiftStartDateTime(new ims.framework.utils.DateTime(ShiftStartDateTime) );
		}
		// ShiftEndDateTime
		java.util.Date ShiftEndDateTime = domainObject.getShiftEndDateTime();
		if ( null != ShiftEndDateTime ) 
		{
			valueObject.setShiftEndDateTime(new ims.framework.utils.DateTime(ShiftEndDateTime) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.vitals.domain.objects.SignatoryShiftDetails extractSignatoryShiftDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVo valueObject) 
	{
		return 	extractSignatoryShiftDetails(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.vitals.domain.objects.SignatoryShiftDetails extractSignatoryShiftDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.SignatoryShiftDetailsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_SignatoryShiftDetails();
		ims.core.vitals.domain.objects.SignatoryShiftDetails domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.vitals.domain.objects.SignatoryShiftDetails)domMap.get(valueObject);
			}
			// ims.core.vo.SignatoryShiftDetailsVo ID_SignatoryShiftDetails field is unknown
			domainObject = new ims.core.vitals.domain.objects.SignatoryShiftDetails();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_SignatoryShiftDetails());
			if (domMap.get(key) != null)
			{
				return (ims.core.vitals.domain.objects.SignatoryShiftDetails)domMap.get(key);
			}
			domainObject = (ims.core.vitals.domain.objects.SignatoryShiftDetails) domainFactory.getDomainObject(ims.core.vitals.domain.objects.SignatoryShiftDetails.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_SignatoryShiftDetails());

		ims.framework.utils.DateTime dateTime1 = valueObject.getDateTimeSigned();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setDateTimeSigned(value1);
		domainObject.setSignedOffBy(ims.core.vo.domain.HcpLiteVoAssembler.extractHcp(domainFactory, valueObject.getSignedOffBy(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getStartTime() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getStartTime().getID());
		}
		domainObject.setStartTime(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getEndTime() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getEndTime().getID());
		}
		domainObject.setEndTime(value4);
		ims.framework.utils.DateTime dateTime5 = valueObject.getShiftStartDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setShiftStartDateTime(value5);
		ims.framework.utils.DateTime dateTime6 = valueObject.getShiftEndDateTime();
		java.util.Date value6 = null;
		if ( dateTime6 != null ) 
		{
			value6 = dateTime6.getJavaDate();
		}
		domainObject.setShiftEndDateTime(value6);

		return domainObject;
	}

}
