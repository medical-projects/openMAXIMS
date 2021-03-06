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
public class WorkAllocationVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.WorkAllocationVo copy(ims.careuk.vo.WorkAllocationVo valueObjectDest, ims.careuk.vo.WorkAllocationVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_WorkAllocation(valueObjectSrc.getID_WorkAllocation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AllocatedBy
		valueObjectDest.setAllocatedBy(valueObjectSrc.getAllocatedBy());
		// DateAllocated
		valueObjectDest.setDateAllocated(valueObjectSrc.getDateAllocated());
		// AllocatedTo
		valueObjectDest.setAllocatedTo(valueObjectSrc.getAllocatedTo());
		// CompletedDateTime
		valueObjectDest.setCompletedDateTime(valueObjectSrc.getCompletedDateTime());
		// CompletedBy
		valueObjectDest.setCompletedBy(valueObjectSrc.getCompletedBy());
		// UnallocatedBy
		valueObjectDest.setUnallocatedBy(valueObjectSrc.getUnallocatedBy());
		// UnallocatedDate
		valueObjectDest.setUnallocatedDate(valueObjectSrc.getUnallocatedDate());
		// ReferralStatus
		valueObjectDest.setReferralStatus(valueObjectSrc.getReferralStatus());
		// CatsReferral
		valueObjectDest.setCatsReferral(valueObjectSrc.getCatsReferral());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createWorkAllocationVoCollectionFromWorkAllocation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.WorkAllocation objects.
	 */
	public static ims.careuk.vo.WorkAllocationVoCollection createWorkAllocationVoCollectionFromWorkAllocation(java.util.Set domainObjectSet)	
	{
		return createWorkAllocationVoCollectionFromWorkAllocation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.WorkAllocation objects.
	 */
	public static ims.careuk.vo.WorkAllocationVoCollection createWorkAllocationVoCollectionFromWorkAllocation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.WorkAllocationVoCollection voList = new ims.careuk.vo.WorkAllocationVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.WorkAllocation domainObject = (ims.careuk.domain.objects.WorkAllocation) iterator.next();
			ims.careuk.vo.WorkAllocationVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.careuk.domain.objects.WorkAllocation objects.
	 */
	public static ims.careuk.vo.WorkAllocationVoCollection createWorkAllocationVoCollectionFromWorkAllocation(java.util.List domainObjectList) 
	{
		return createWorkAllocationVoCollectionFromWorkAllocation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.WorkAllocation objects.
	 */
	public static ims.careuk.vo.WorkAllocationVoCollection createWorkAllocationVoCollectionFromWorkAllocation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.WorkAllocationVoCollection voList = new ims.careuk.vo.WorkAllocationVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.WorkAllocation domainObject = (ims.careuk.domain.objects.WorkAllocation) domainObjectList.get(i);
			ims.careuk.vo.WorkAllocationVo vo = create(map, domainObject);

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
	 * Create the ims.careuk.domain.objects.WorkAllocation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractWorkAllocationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVoCollection voCollection) 
	 {
	 	return extractWorkAllocationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractWorkAllocationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.WorkAllocationVo vo = voCollection.get(i);
			ims.careuk.domain.objects.WorkAllocation domainObject = WorkAllocationVoAssembler.extractWorkAllocation(domainFactory, vo, domMap);

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
	 * Create the ims.careuk.domain.objects.WorkAllocation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractWorkAllocationList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVoCollection voCollection) 
	 {
	 	return extractWorkAllocationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractWorkAllocationList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.WorkAllocationVo vo = voCollection.get(i);
			ims.careuk.domain.objects.WorkAllocation domainObject = WorkAllocationVoAssembler.extractWorkAllocation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.careuk.domain.objects.WorkAllocation object.
	 * @param domainObject ims.careuk.domain.objects.WorkAllocation
	 */
	 public static ims.careuk.vo.WorkAllocationVo create(ims.careuk.domain.objects.WorkAllocation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.WorkAllocation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.WorkAllocationVo create(DomainObjectMap map, ims.careuk.domain.objects.WorkAllocation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.WorkAllocationVo valueObject = (ims.careuk.vo.WorkAllocationVo) map.getValueObject(domainObject, ims.careuk.vo.WorkAllocationVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.WorkAllocationVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.WorkAllocation
	 */
	 public static ims.careuk.vo.WorkAllocationVo insert(ims.careuk.vo.WorkAllocationVo valueObject, ims.careuk.domain.objects.WorkAllocation domainObject) 
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
	 * @param domainObject ims.careuk.domain.objects.WorkAllocation
	 */
	 public static ims.careuk.vo.WorkAllocationVo insert(DomainObjectMap map, ims.careuk.vo.WorkAllocationVo valueObject, ims.careuk.domain.objects.WorkAllocation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_WorkAllocation(domainObject.getId());
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
			
		// AllocatedBy
		valueObject.setAllocatedBy(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getAllocatedBy()) );
		// DateAllocated
		java.util.Date DateAllocated = domainObject.getDateAllocated();
		if ( null != DateAllocated ) 
		{
			valueObject.setDateAllocated(new ims.framework.utils.DateTime(DateAllocated) );
		}
		// AllocatedTo
		valueObject.setAllocatedTo(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getAllocatedTo()) );
		// CompletedDateTime
		java.util.Date CompletedDateTime = domainObject.getCompletedDateTime();
		if ( null != CompletedDateTime ) 
		{
			valueObject.setCompletedDateTime(new ims.framework.utils.DateTime(CompletedDateTime) );
		}
		// CompletedBy
		if (domainObject.getCompletedBy() != null)
		{
			if(domainObject.getCompletedBy() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCompletedBy();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCompletedBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(id, -1));				
			}
			else
			{
				valueObject.setCompletedBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(domainObject.getCompletedBy().getId(), domainObject.getCompletedBy().getVersion()));
			}
		}
		// UnallocatedBy
		if (domainObject.getUnallocatedBy() != null)
		{
			if(domainObject.getUnallocatedBy() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getUnallocatedBy();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setUnallocatedBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(id, -1));				
			}
			else
			{
				valueObject.setUnallocatedBy(new ims.core.resource.people.vo.MemberOfStaffRefVo(domainObject.getUnallocatedBy().getId(), domainObject.getUnallocatedBy().getVersion()));
			}
		}
		// UnallocatedDate
		java.util.Date UnallocatedDate = domainObject.getUnallocatedDate();
		if ( null != UnallocatedDate ) 
		{
			valueObject.setUnallocatedDate(new ims.framework.utils.DateTime(UnallocatedDate) );
		}
		// ReferralStatus
		ims.domain.lookups.LookupInstance instance8 = domainObject.getReferralStatus();
		if ( null != instance8 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance8.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance8.getImage().getImageId(), instance8.getImage().getImagePath());
			}
			color = instance8.getColor();
			if (color != null) 
				color.getValue();

			ims.careuk.vo.lookups.ReferralApptStatus voLookup8 = new ims.careuk.vo.lookups.ReferralApptStatus(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.careuk.vo.lookups.ReferralApptStatus parentVoLookup8 = voLookup8;
			ims.domain.lookups.LookupInstance parent8 = instance8.getParent();
			while (parent8 != null)
			{
				if (parent8.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent8.getImage().getImageId(), parent8.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent8.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup8.setParent(new ims.careuk.vo.lookups.ReferralApptStatus(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setReferralStatus(voLookup8);
		}
				// CatsReferral
		if (domainObject.getCatsReferral() != null)
		{
			if(domainObject.getCatsReferral() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCatsReferral();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCatsReferral(new ims.careuk.vo.CatsReferralRefVo(id, -1));				
			}
			else
			{
				valueObject.setCatsReferral(new ims.careuk.vo.CatsReferralRefVo(domainObject.getCatsReferral().getId(), domainObject.getCatsReferral().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.WorkAllocation extractWorkAllocation(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVo valueObject) 
	{
		return 	extractWorkAllocation(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.WorkAllocation extractWorkAllocation(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.WorkAllocationVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_WorkAllocation();
		ims.careuk.domain.objects.WorkAllocation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.WorkAllocation)domMap.get(valueObject);
			}
			// ims.careuk.vo.WorkAllocationVo ID_WorkAllocation field is unknown
			domainObject = new ims.careuk.domain.objects.WorkAllocation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_WorkAllocation());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.WorkAllocation)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.WorkAllocation) domainFactory.getDomainObject(ims.careuk.domain.objects.WorkAllocation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_WorkAllocation());

		domainObject.setAllocatedBy(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.extractMemberOfStaff(domainFactory, valueObject.getAllocatedBy(), domMap));
		ims.framework.utils.DateTime dateTime2 = valueObject.getDateAllocated();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setDateAllocated(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.MemberOfStaff value3 = null;
		if ( null != valueObject.getAllocatedTo() ) 
		{
			if (valueObject.getAllocatedTo().getBoId() == null)
			{
				if (domMap.get(valueObject.getAllocatedTo()) != null)
				{
					value3 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getAllocatedTo());
				}
			}
			else
			{
				value3 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getAllocatedTo().getBoId());
			}
		}
		domainObject.setAllocatedTo(value3);
		ims.framework.utils.DateTime dateTime4 = valueObject.getCompletedDateTime();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setCompletedDateTime(value4);
		ims.core.resource.people.domain.objects.MemberOfStaff value5 = null;
		if ( null != valueObject.getCompletedBy() ) 
		{
			if (valueObject.getCompletedBy().getBoId() == null)
			{
				if (domMap.get(valueObject.getCompletedBy()) != null)
				{
					value5 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getCompletedBy());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value5 = domainObject.getCompletedBy();	
			}
			else
			{
				value5 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getCompletedBy().getBoId());
			}
		}
		domainObject.setCompletedBy(value5);
		ims.core.resource.people.domain.objects.MemberOfStaff value6 = null;
		if ( null != valueObject.getUnallocatedBy() ) 
		{
			if (valueObject.getUnallocatedBy().getBoId() == null)
			{
				if (domMap.get(valueObject.getUnallocatedBy()) != null)
				{
					value6 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getUnallocatedBy());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value6 = domainObject.getUnallocatedBy();	
			}
			else
			{
				value6 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getUnallocatedBy().getBoId());
			}
		}
		domainObject.setUnallocatedBy(value6);
		ims.framework.utils.DateTime dateTime7 = valueObject.getUnallocatedDate();
		java.util.Date value7 = null;
		if ( dateTime7 != null ) 
		{
			value7 = dateTime7.getJavaDate();
		}
		domainObject.setUnallocatedDate(value7);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getReferralStatus() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getReferralStatus().getID());
		}
		domainObject.setReferralStatus(value8);
		ims.careuk.domain.objects.CatsReferral value9 = null;
		if ( null != valueObject.getCatsReferral() ) 
		{
			if (valueObject.getCatsReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCatsReferral()) != null)
				{
					value9 = (ims.careuk.domain.objects.CatsReferral)domMap.get(valueObject.getCatsReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value9 = domainObject.getCatsReferral();	
			}
			else
			{
				value9 = (ims.careuk.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.careuk.domain.objects.CatsReferral.class, valueObject.getCatsReferral().getBoId());
			}
		}
		domainObject.setCatsReferral(value9);

		return domainObject;
	}

}
