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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class OrganisationVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.OrganisationVo copy(ims.core.vo.OrganisationVo valueObjectDest, ims.core.vo.OrganisationVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Organisation(valueObjectSrc.getID_Organisation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// relatedOrganisations
		valueObjectDest.setRelatedOrganisations(valueObjectSrc.getRelatedOrganisations());
		// parentOrganisation
		valueObjectDest.setParentOrganisation(valueObjectSrc.getParentOrganisation());
		// LocationSites
		valueObjectDest.setLocationSites(valueObjectSrc.getLocationSites());
		// PctCode
		valueObjectDest.setPctCode(valueObjectSrc.getPctCode());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
		// CodeMappings
		valueObjectDest.setCodeMappings(valueObjectSrc.getCodeMappings());
		// CommChannels
		valueObjectDest.setCommChannels(valueObjectSrc.getCommChannels());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Address
		valueObjectDest.setAddress(valueObjectSrc.getAddress());
		// Type
		valueObjectDest.setType(valueObjectSrc.getType());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createOrganisationVoCollectionFromOrganisation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.core.vo.OrganisationVoCollection createOrganisationVoCollectionFromOrganisation(java.util.Set domainObjectSet)	
	{
		return createOrganisationVoCollectionFromOrganisation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.core.vo.OrganisationVoCollection createOrganisationVoCollectionFromOrganisation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.OrganisationVoCollection voList = new ims.core.vo.OrganisationVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.resource.place.domain.objects.Organisation domainObject = (ims.core.resource.place.domain.objects.Organisation) iterator.next();
			ims.core.vo.OrganisationVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.core.vo.OrganisationVoCollection createOrganisationVoCollectionFromOrganisation(java.util.List domainObjectList) 
	{
		return createOrganisationVoCollectionFromOrganisation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.core.vo.OrganisationVoCollection createOrganisationVoCollectionFromOrganisation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.OrganisationVoCollection voList = new ims.core.vo.OrganisationVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.resource.place.domain.objects.Organisation domainObject = (ims.core.resource.place.domain.objects.Organisation) domainObjectList.get(i);
			ims.core.vo.OrganisationVo vo = create(map, domainObject);

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
	 * Create the ims.core.resource.place.domain.objects.Organisation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrganisationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVoCollection voCollection) 
	 {
	 	return extractOrganisationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrganisationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.OrganisationVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.Organisation domainObject = OrganisationVoAssembler.extractOrganisation(domainFactory, vo, domMap);

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
	 * Create the ims.core.resource.place.domain.objects.Organisation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrganisationList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVoCollection voCollection) 
	 {
	 	return extractOrganisationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrganisationList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.OrganisationVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.Organisation domainObject = OrganisationVoAssembler.extractOrganisation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.resource.place.domain.objects.Organisation object.
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.core.vo.OrganisationVo create(ims.core.resource.place.domain.objects.Organisation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.resource.place.domain.objects.Organisation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.OrganisationVo create(DomainObjectMap map, ims.core.resource.place.domain.objects.Organisation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.OrganisationVo valueObject = (ims.core.vo.OrganisationVo) map.getValueObject(domainObject, ims.core.vo.OrganisationVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.OrganisationVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.core.vo.OrganisationVo insert(ims.core.vo.OrganisationVo valueObject, ims.core.resource.place.domain.objects.Organisation domainObject) 
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
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.core.vo.OrganisationVo insert(DomainObjectMap map, ims.core.vo.OrganisationVo valueObject, ims.core.resource.place.domain.objects.Organisation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Organisation(domainObject.getId());
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
			
		// relatedOrganisations
		valueObject.setRelatedOrganisations(ims.core.vo.domain.OrganisationVoAssembler.createOrganisationVoCollectionFromOrganisation(map, domainObject.getRelatedOrganisations()) );
		// parentOrganisation
		valueObject.setParentOrganisation(ims.core.vo.domain.OrganisationVoAssembler.create(map, domainObject.getParentOrganisation()) );
		// LocationSites
		valueObject.setLocationSites(ims.core.vo.domain.LocSiteVoAssembler.createLocSiteVoCollectionFromLocSite(map, domainObject.getLocationSites()) );
		// PctCode
		valueObject.setPctCode(domainObject.getPctCode());
		// Comment
		valueObject.setComment(domainObject.getComment());
		// CodeMappings
		valueObject.setCodeMappings(ims.core.vo.domain.TaxonomyMapAssembler.createTaxonomyMapCollectionFromTaxonomyMap(map, domainObject.getCodeMappings()) );
		// CommChannels
		valueObject.setCommChannels(ims.core.vo.domain.CommChannelVoAssembler.createCommChannelVoCollectionFromCommunicationChannel(map, domainObject.getCommChannels()) );
		// Name
		valueObject.setName(domainObject.getName());
		// Address
		valueObject.setAddress(ims.core.vo.domain.PersonAddressAssembler.create(map, domainObject.getAddress()) );
		// Type
		ims.domain.lookups.LookupInstance instance10 = domainObject.getType();
		if ( null != instance10 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance10.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance10.getImage().getImageId(), instance10.getImage().getImagePath());
			}
			color = instance10.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.OrganisationType voLookup10 = new ims.core.vo.lookups.OrganisationType(instance10.getId(),instance10.getText(), instance10.isActive(), null, img, color);
			ims.core.vo.lookups.OrganisationType parentVoLookup10 = voLookup10;
			ims.domain.lookups.LookupInstance parent10 = instance10.getParent();
			while (parent10 != null)
			{
				if (parent10.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent10.getImage().getImageId(), parent10.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent10.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup10.setParent(new ims.core.vo.lookups.OrganisationType(parent10.getId(),parent10.getText(), parent10.isActive(), null, img, color));
				parentVoLookup10 = parentVoLookup10.getParent();
								parent10 = parent10.getParent();
			}			
			valueObject.setType(voLookup10);
		}
				// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.resource.place.domain.objects.Organisation extractOrganisation(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVo valueObject) 
	{
		return 	extractOrganisation(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.resource.place.domain.objects.Organisation extractOrganisation(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.OrganisationVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Organisation();
		ims.core.resource.place.domain.objects.Organisation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.resource.place.domain.objects.Organisation)domMap.get(valueObject);
			}
			// ims.core.vo.OrganisationVo ID_Organisation field is unknown
			domainObject = new ims.core.resource.place.domain.objects.Organisation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Organisation());
			if (domMap.get(key) != null)
			{
				return (ims.core.resource.place.domain.objects.Organisation)domMap.get(key);
			}
			domainObject = (ims.core.resource.place.domain.objects.Organisation) domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Organisation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Organisation());

		domainObject.setRelatedOrganisations(ims.core.vo.domain.OrganisationVoAssembler.extractOrganisationSet(domainFactory, valueObject.getRelatedOrganisations(), domainObject.getRelatedOrganisations(), domMap));		
		domainObject.setParentOrganisation(ims.core.vo.domain.OrganisationVoAssembler.extractOrganisation(domainFactory, valueObject.getParentOrganisation(), domMap));
		domainObject.setLocationSites(ims.core.vo.domain.LocSiteVoAssembler.extractLocSiteSet(domainFactory, valueObject.getLocationSites(), domainObject.getLocationSites(), domMap));		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getPctCode() != null && valueObject.getPctCode().equals(""))
		{
			valueObject.setPctCode(null);
		}
		domainObject.setPctCode(valueObject.getPctCode());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());
		domainObject.setCodeMappings(ims.core.vo.domain.TaxonomyMapAssembler.extractTaxonomyMapList(domainFactory, valueObject.getCodeMappings(), domainObject.getCodeMappings(), domMap));		
		domainObject.setCommChannels(ims.core.vo.domain.CommChannelVoAssembler.extractCommunicationChannelList(domainFactory, valueObject.getCommChannels(), domainObject.getCommChannels(), domMap));		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		domainObject.setAddress(ims.core.vo.domain.PersonAddressAssembler.extractAddress(domainFactory, valueObject.getAddress(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value10 = null;
		if ( null != valueObject.getType() ) 
		{
			value10 =
				domainFactory.getLookupInstance(valueObject.getType().getID());
		}
		domainObject.setType(value10);
		domainObject.setIsActive(valueObject.getIsActive());

		return domainObject;
	}

}
