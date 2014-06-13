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
package ims.ocrr.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Neil McAnaspie
 */
public class NewResultVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.ocrr.vo.NewResultVo copy(ims.ocrr.vo.NewResultVo valueObjectDest, ims.ocrr.vo.NewResultVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_OrderInvestigation(valueObjectSrc.getID_OrderInvestigation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Investigation
		valueObjectDest.setInvestigation(valueObjectSrc.getInvestigation());
		// OrderDetails
		valueObjectDest.setOrderDetails(valueObjectSrc.getOrderDetails());
		// ResultDemographics
		valueObjectDest.setResultDemographics(valueObjectSrc.getResultDemographics());
		// RepTimeSupplied
		valueObjectDest.setRepTimeSupplied(valueObjectSrc.getRepTimeSupplied());
		// ResultStatus
		valueObjectDest.setResultStatus(valueObjectSrc.getResultStatus());
		// DisplayFlag
		valueObjectDest.setDisplayFlag(valueObjectSrc.getDisplayFlag());
		// OrdInvCurrentStatus
		valueObjectDest.setOrdInvCurrentStatus(valueObjectSrc.getOrdInvCurrentStatus());
		// DisplayDateTime
		valueObjectDest.setDisplayDateTime(valueObjectSrc.getDisplayDateTime());
		// AppointmentDate
		valueObjectDest.setAppointmentDate(valueObjectSrc.getAppointmentDate());
		// RepDateTime
		valueObjectDest.setRepDateTime(valueObjectSrc.getRepDateTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createNewResultVoCollectionFromOrderInvestigation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.NewResultVoCollection createNewResultVoCollectionFromOrderInvestigation(java.util.Set domainObjectSet)	
	{
		return createNewResultVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.NewResultVoCollection createNewResultVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.ocrr.vo.NewResultVoCollection voList = new ims.ocrr.vo.NewResultVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) iterator.next();
			ims.ocrr.vo.NewResultVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.NewResultVoCollection createNewResultVoCollectionFromOrderInvestigation(java.util.List domainObjectList) 
	{
		return createNewResultVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.NewResultVoCollection createNewResultVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.ocrr.vo.NewResultVoCollection voList = new ims.ocrr.vo.NewResultVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainObjectList.get(i);
			ims.ocrr.vo.NewResultVo vo = create(map, domainObject);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.NewResultVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = NewResultVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.NewResultVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = NewResultVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.NewResultVo create(ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.ocrr.vo.NewResultVo create(DomainObjectMap map, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.ocrr.vo.NewResultVo valueObject = (ims.ocrr.vo.NewResultVo) map.getValueObject(domainObject, ims.ocrr.vo.NewResultVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.ocrr.vo.NewResultVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.NewResultVo insert(ims.ocrr.vo.NewResultVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
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
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.NewResultVo insert(DomainObjectMap map, ims.ocrr.vo.NewResultVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_OrderInvestigation(domainObject.getId());
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
			
		// Investigation
		valueObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.create(map, domainObject.getInvestigation()) );
		// OrderDetails
		valueObject.setOrderDetails(ims.ocrr.vo.domain.NewResultOcsOrderVoAssembler.create(map, domainObject.getOrderDetails()) );
		// ResultDemographics
		valueObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.create(map, domainObject.getResultDemographics()) );
		// RepTimeSupplied
		valueObject.setRepTimeSupplied( domainObject.isRepTimeSupplied() );
		// ResultStatus
		ims.domain.lookups.LookupInstance instance5 = domainObject.getResultStatus();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.ResultStatus voLookup5 = new ims.ocrr.vo.lookups.ResultStatus(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.ocrr.vo.lookups.ResultStatus parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.ocrr.vo.lookups.ResultStatus(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setResultStatus(voLookup5);
		}
				// DisplayFlag
		ims.domain.lookups.LookupInstance instance6 = domainObject.getDisplayFlag();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.OcsDisplayFlag voLookup6 = new ims.ocrr.vo.lookups.OcsDisplayFlag(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.ocrr.vo.lookups.OcsDisplayFlag parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.ocrr.vo.lookups.OcsDisplayFlag(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setDisplayFlag(voLookup6);
		}
				// OrdInvCurrentStatus
		valueObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusClinicalImagingVoAssembler.create(map, domainObject.getOrdInvCurrentStatus()) );
		// DisplayDateTime
		java.util.Date DisplayDateTime = domainObject.getDisplayDateTime();
		if ( null != DisplayDateTime ) 
		{
			valueObject.setDisplayDateTime(new ims.framework.utils.DateTime(DisplayDateTime) );
		}
		// AppointmentDate
		java.util.Date AppointmentDate = domainObject.getAppointmentDate();
		if ( null != AppointmentDate ) 
		{
			valueObject.setAppointmentDate(new ims.framework.utils.DateTime(AppointmentDate) );
		}
		// RepDateTime
		java.util.Date RepDateTime = domainObject.getRepDateTime();
		if ( null != RepDateTime ) 
		{
			valueObject.setRepDateTime(new ims.framework.utils.DateTime(RepDateTime) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVo valueObject) 
	{
		return 	extractOrderInvestigation(domainFactory, valueObject, new HashMap());
	}

	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.NewResultVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_OrderInvestigation();
		ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(valueObject);
			}
			// ims.ocrr.vo.NewResultVo ID_OrderInvestigation field is unknown
			domainObject = new ims.ocrr.orderingresults.domain.objects.OrderInvestigation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_OrderInvestigation());
			if (domMap.get(key) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(key);
			}
			domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainFactory.getDomainObject(ims.ocrr.orderingresults.domain.objects.OrderInvestigation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_OrderInvestigation());

		domainObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.extractInvestigation(domainFactory, valueObject.getInvestigation(), domMap));
		domainObject.setOrderDetails(ims.ocrr.vo.domain.NewResultOcsOrderVoAssembler.extractOcsOrderSession(domainFactory, valueObject.getOrderDetails(), domMap));
		domainObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.extractMinDemographics(domainFactory, valueObject.getResultDemographics(), domMap));
		domainObject.setRepTimeSupplied(valueObject.getRepTimeSupplied());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getResultStatus() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getResultStatus().getID());
		}
		domainObject.setResultStatus(value5);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getDisplayFlag() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getDisplayFlag().getID());
		}
		domainObject.setDisplayFlag(value6);
		domainObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusClinicalImagingVoAssembler.extractOrderedInvestigationStatus(domainFactory, valueObject.getOrdInvCurrentStatus(), domMap));
		ims.framework.utils.DateTime dateTime8 = valueObject.getDisplayDateTime();
		java.util.Date value8 = null;
		if ( dateTime8 != null ) 
		{
			value8 = dateTime8.getJavaDate();
		}
		domainObject.setDisplayDateTime(value8);
		ims.framework.utils.DateTime dateTime9 = valueObject.getAppointmentDate();
		java.util.Date value9 = null;
		if ( dateTime9 != null ) 
		{
			value9 = dateTime9.getJavaDate();
		}
		domainObject.setAppointmentDate(value9);
		ims.framework.utils.DateTime dateTime10 = valueObject.getRepDateTime();
		java.util.Date value10 = null;
		if ( dateTime10 != null ) 
		{
			value10 = dateTime10.getJavaDate();
		}
		domainObject.setRepDateTime(value10);

		return domainObject;
	}

}
