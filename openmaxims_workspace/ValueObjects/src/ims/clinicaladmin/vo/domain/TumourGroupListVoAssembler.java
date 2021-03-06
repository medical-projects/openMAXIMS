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
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.clinicaladmin.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Catalin Tomozei
 */
public class TumourGroupListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinicaladmin.vo.TumourGroupListVo copy(ims.clinicaladmin.vo.TumourGroupListVo valueObjectDest, ims.clinicaladmin.vo.TumourGroupListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TumourGroup(valueObjectSrc.getID_TumourGroup());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// GroupDescription
		valueObjectDest.setGroupDescription(valueObjectSrc.getGroupDescription());
		// hasOtherClassifications
		valueObjectDest.setHasOtherClassifications(valueObjectSrc.getHasOtherClassifications());
		// OtherClassifications
		valueObjectDest.setOtherClassifications(valueObjectSrc.getOtherClassifications());
		// Sites
		valueObjectDest.setSites(valueObjectSrc.getSites());
		// TnmRequiresDiff
		valueObjectDest.setTnmRequiresDiff(valueObjectSrc.getTnmRequiresDiff());
		// TnmRequiresOver45
		valueObjectDest.setTnmRequiresOver45(valueObjectSrc.getTnmRequiresOver45());
		// TnmRequiresHisto
		valueObjectDest.setTnmRequiresHisto(valueObjectSrc.getTnmRequiresHisto());
		// TnmRequiresSMarkers
		valueObjectDest.setTnmRequiresSMarkers(valueObjectSrc.getTnmRequiresSMarkers());
		// GroupName
		valueObjectDest.setGroupName(valueObjectSrc.getGroupName());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
		// hasTNM
		valueObjectDest.setHasTNM(valueObjectSrc.getHasTNM());
		// isPrognosticGroupingRelevant
		valueObjectDest.setIsPrognosticGroupingRelevant(valueObjectSrc.getIsPrognosticGroupingRelevant());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTumourGroupListVoCollectionFromTumourGroup(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.oncology.configuration.domain.objects.TumourGroup objects.
	 */
	public static ims.clinicaladmin.vo.TumourGroupListVoCollection createTumourGroupListVoCollectionFromTumourGroup(java.util.Set domainObjectSet)	
	{
		return createTumourGroupListVoCollectionFromTumourGroup(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.oncology.configuration.domain.objects.TumourGroup objects.
	 */
	public static ims.clinicaladmin.vo.TumourGroupListVoCollection createTumourGroupListVoCollectionFromTumourGroup(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinicaladmin.vo.TumourGroupListVoCollection voList = new ims.clinicaladmin.vo.TumourGroupListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.oncology.configuration.domain.objects.TumourGroup domainObject = (ims.oncology.configuration.domain.objects.TumourGroup) iterator.next();
			ims.clinicaladmin.vo.TumourGroupListVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.oncology.configuration.domain.objects.TumourGroup objects.
	 */
	public static ims.clinicaladmin.vo.TumourGroupListVoCollection createTumourGroupListVoCollectionFromTumourGroup(java.util.List domainObjectList) 
	{
		return createTumourGroupListVoCollectionFromTumourGroup(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.oncology.configuration.domain.objects.TumourGroup objects.
	 */
	public static ims.clinicaladmin.vo.TumourGroupListVoCollection createTumourGroupListVoCollectionFromTumourGroup(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinicaladmin.vo.TumourGroupListVoCollection voList = new ims.clinicaladmin.vo.TumourGroupListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.oncology.configuration.domain.objects.TumourGroup domainObject = (ims.oncology.configuration.domain.objects.TumourGroup) domainObjectList.get(i);
			ims.clinicaladmin.vo.TumourGroupListVo vo = create(map, domainObject);

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
	 * Create the ims.oncology.configuration.domain.objects.TumourGroup set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTumourGroupSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVoCollection voCollection) 
	 {
	 	return extractTumourGroupSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTumourGroupSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinicaladmin.vo.TumourGroupListVo vo = voCollection.get(i);
			ims.oncology.configuration.domain.objects.TumourGroup domainObject = TumourGroupListVoAssembler.extractTumourGroup(domainFactory, vo, domMap);

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
	 * Create the ims.oncology.configuration.domain.objects.TumourGroup list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTumourGroupList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVoCollection voCollection) 
	 {
	 	return extractTumourGroupList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTumourGroupList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinicaladmin.vo.TumourGroupListVo vo = voCollection.get(i);
			ims.oncology.configuration.domain.objects.TumourGroup domainObject = TumourGroupListVoAssembler.extractTumourGroup(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.oncology.configuration.domain.objects.TumourGroup object.
	 * @param domainObject ims.oncology.configuration.domain.objects.TumourGroup
	 */
	 public static ims.clinicaladmin.vo.TumourGroupListVo create(ims.oncology.configuration.domain.objects.TumourGroup domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.oncology.configuration.domain.objects.TumourGroup object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinicaladmin.vo.TumourGroupListVo create(DomainObjectMap map, ims.oncology.configuration.domain.objects.TumourGroup domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinicaladmin.vo.TumourGroupListVo valueObject = (ims.clinicaladmin.vo.TumourGroupListVo) map.getValueObject(domainObject, ims.clinicaladmin.vo.TumourGroupListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinicaladmin.vo.TumourGroupListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.oncology.configuration.domain.objects.TumourGroup
	 */
	 public static ims.clinicaladmin.vo.TumourGroupListVo insert(ims.clinicaladmin.vo.TumourGroupListVo valueObject, ims.oncology.configuration.domain.objects.TumourGroup domainObject) 
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
	 * @param domainObject ims.oncology.configuration.domain.objects.TumourGroup
	 */
	 public static ims.clinicaladmin.vo.TumourGroupListVo insert(DomainObjectMap map, ims.clinicaladmin.vo.TumourGroupListVo valueObject, ims.oncology.configuration.domain.objects.TumourGroup domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TumourGroup(domainObject.getId());
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
			
		// GroupDescription
		valueObject.setGroupDescription(domainObject.getGroupDescription());
		// hasOtherClassifications
		valueObject.setHasOtherClassifications( domainObject.isHasOtherClassifications() );
		// OtherClassifications
		valueObject.setOtherClassifications(ims.oncology.vo.domain.TumourGroupClassificationVoAssembler.createTumourGroupClassificationVoCollectionFromTumourGroupClassification(map, domainObject.getOtherClassifications()) );
		// Sites
		valueObject.setSites(ims.clinicaladmin.vo.domain.TumourSiteLiteVoAssembler.createTumourSiteLiteVoCollectionFromTumourSite(map, domainObject.getSites()) );
		// TnmRequiresDiff
		valueObject.setTnmRequiresDiff( domainObject.isTnmRequiresDiff() );
		// TnmRequiresOver45
		valueObject.setTnmRequiresOver45( domainObject.isTnmRequiresOver45() );
		// TnmRequiresHisto
		valueObject.setTnmRequiresHisto( domainObject.isTnmRequiresHisto() );
		// TnmRequiresSMarkers
		valueObject.setTnmRequiresSMarkers( domainObject.isTnmRequiresSMarkers() );
		// GroupName
		valueObject.setGroupName(domainObject.getGroupName());
		// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
		// hasTNM
		valueObject.setHasTNM( domainObject.isHasTNM() );
		// isPrognosticGroupingRelevant
		valueObject.setIsPrognosticGroupingRelevant( domainObject.isIsPrognosticGroupingRelevant() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.oncology.configuration.domain.objects.TumourGroup extractTumourGroup(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVo valueObject) 
	{
		return 	extractTumourGroup(domainFactory, valueObject, new HashMap());
	}

	public static ims.oncology.configuration.domain.objects.TumourGroup extractTumourGroup(ims.domain.ILightweightDomainFactory domainFactory, ims.clinicaladmin.vo.TumourGroupListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TumourGroup();
		ims.oncology.configuration.domain.objects.TumourGroup domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.oncology.configuration.domain.objects.TumourGroup)domMap.get(valueObject);
			}
			// ims.clinicaladmin.vo.TumourGroupListVo ID_TumourGroup field is unknown
			domainObject = new ims.oncology.configuration.domain.objects.TumourGroup();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TumourGroup());
			if (domMap.get(key) != null)
			{
				return (ims.oncology.configuration.domain.objects.TumourGroup)domMap.get(key);
			}
			domainObject = (ims.oncology.configuration.domain.objects.TumourGroup) domainFactory.getDomainObject(ims.oncology.configuration.domain.objects.TumourGroup.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TumourGroup());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getGroupDescription() != null && valueObject.getGroupDescription().equals(""))
		{
			valueObject.setGroupDescription(null);
		}
		domainObject.setGroupDescription(valueObject.getGroupDescription());
		domainObject.setHasOtherClassifications(valueObject.getHasOtherClassifications());
		domainObject.setOtherClassifications(ims.oncology.vo.domain.TumourGroupClassificationVoAssembler.extractTumourGroupClassificationSet(domainFactory, valueObject.getOtherClassifications(), domainObject.getOtherClassifications(), domMap));		

		// SaveAsRefVO treated as RefValueObject
		ims.oncology.configuration.vo.TumourSiteRefVoCollection refCollection4 = new ims.oncology.configuration.vo.TumourSiteRefVoCollection();
		if (valueObject.getSites() != null)
		{
			for (int i4=0; i4<valueObject.getSites().size(); i4++)
			{
				ims.oncology.configuration.vo.TumourSiteRefVo ref4 = (ims.oncology.configuration.vo.TumourSiteRefVo)valueObject.getSites().get(i4);
				refCollection4.add(ref4);
			}
		}
		int size4 = (null == refCollection4) ? 0 : refCollection4.size();		
		java.util.List domainSites4 = domainObject.getSites();
		if (domainSites4 == null)
		{
			domainSites4 = new java.util.ArrayList();
		}
		for(int i=0; i < size4; i++) 
		{
			ims.oncology.configuration.vo.TumourSiteRefVo vo = refCollection4.get(i);			
			ims.oncology.configuration.domain.objects.TumourSite dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.oncology.configuration.domain.objects.TumourSite)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.oncology.configuration.domain.objects.TumourSite)domainFactory.getDomainObject( ims.oncology.configuration.domain.objects.TumourSite.class, vo.getBoId());
				}
			}

			int domIdx = domainSites4.indexOf(dom);
			if (domIdx == -1)
			{
				domainSites4.add(i, dom);
			}
			else if (i != domIdx && i < domainSites4.size())
			{
				Object tmp = domainSites4.get(i);
				domainSites4.set(i, domainSites4.get(domIdx));
				domainSites4.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i4 = domainSites4.size();
		while (i4 > size4)
		{
			domainSites4.remove(i4-1);
			i4 = domainSites4.size();
		}
		
		domainObject.setSites(domainSites4);		
		domainObject.setTnmRequiresDiff(valueObject.getTnmRequiresDiff());
		domainObject.setTnmRequiresOver45(valueObject.getTnmRequiresOver45());
		domainObject.setTnmRequiresHisto(valueObject.getTnmRequiresHisto());
		domainObject.setTnmRequiresSMarkers(valueObject.getTnmRequiresSMarkers());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getGroupName() != null && valueObject.getGroupName().equals(""))
		{
			valueObject.setGroupName(null);
		}
		domainObject.setGroupName(valueObject.getGroupName());
		domainObject.setIsActive(valueObject.getIsActive());
		domainObject.setHasTNM(valueObject.getHasTNM());
		domainObject.setIsPrognosticGroupingRelevant(valueObject.getIsPrognosticGroupingRelevant());

		return domainObject;
	}

}
