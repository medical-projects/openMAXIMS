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
 * @author George Cristian Josan
 */
public class ICPConfiguration_CreateVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.icp.vo.ICPConfiguration_CreateVo copy(ims.icp.vo.ICPConfiguration_CreateVo valueObjectDest, ims.icp.vo.ICPConfiguration_CreateVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ICP(valueObjectSrc.getID_ICP());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Stages
		valueObjectDest.setStages(valueObjectSrc.getStages());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createICPConfiguration_CreateVoCollectionFromICP(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICP objects.
	 */
	public static ims.icp.vo.ICPConfiguration_CreateVoCollection createICPConfiguration_CreateVoCollectionFromICP(java.util.Set domainObjectSet)	
	{
		return createICPConfiguration_CreateVoCollectionFromICP(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICP objects.
	 */
	public static ims.icp.vo.ICPConfiguration_CreateVoCollection createICPConfiguration_CreateVoCollectionFromICP(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.icp.vo.ICPConfiguration_CreateVoCollection voList = new ims.icp.vo.ICPConfiguration_CreateVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.icps.configuration.domain.objects.ICP domainObject = (ims.icps.configuration.domain.objects.ICP) iterator.next();
			ims.icp.vo.ICPConfiguration_CreateVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICP objects.
	 */
	public static ims.icp.vo.ICPConfiguration_CreateVoCollection createICPConfiguration_CreateVoCollectionFromICP(java.util.List domainObjectList) 
	{
		return createICPConfiguration_CreateVoCollectionFromICP(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICP objects.
	 */
	public static ims.icp.vo.ICPConfiguration_CreateVoCollection createICPConfiguration_CreateVoCollectionFromICP(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.icp.vo.ICPConfiguration_CreateVoCollection voList = new ims.icp.vo.ICPConfiguration_CreateVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.icps.configuration.domain.objects.ICP domainObject = (ims.icps.configuration.domain.objects.ICP) domainObjectList.get(i);
			ims.icp.vo.ICPConfiguration_CreateVo vo = create(map, domainObject);

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
	 * Create the ims.icps.configuration.domain.objects.ICP set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractICPSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVoCollection voCollection) 
	 {
	 	return extractICPSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractICPSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPConfiguration_CreateVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICP domainObject = ICPConfiguration_CreateVoAssembler.extractICP(domainFactory, vo, domMap);

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
	 * Create the ims.icps.configuration.domain.objects.ICP list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractICPList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVoCollection voCollection) 
	 {
	 	return extractICPList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractICPList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPConfiguration_CreateVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICP domainObject = ICPConfiguration_CreateVoAssembler.extractICP(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.icps.configuration.domain.objects.ICP object.
	 * @param domainObject ims.icps.configuration.domain.objects.ICP
	 */
	 public static ims.icp.vo.ICPConfiguration_CreateVo create(ims.icps.configuration.domain.objects.ICP domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.icps.configuration.domain.objects.ICP object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.icp.vo.ICPConfiguration_CreateVo create(DomainObjectMap map, ims.icps.configuration.domain.objects.ICP domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.icp.vo.ICPConfiguration_CreateVo valueObject = (ims.icp.vo.ICPConfiguration_CreateVo) map.getValueObject(domainObject, ims.icp.vo.ICPConfiguration_CreateVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.icp.vo.ICPConfiguration_CreateVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.configuration.domain.objects.ICP
	 */
	 public static ims.icp.vo.ICPConfiguration_CreateVo insert(ims.icp.vo.ICPConfiguration_CreateVo valueObject, ims.icps.configuration.domain.objects.ICP domainObject) 
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
	 * @param domainObject ims.icps.configuration.domain.objects.ICP
	 */
	 public static ims.icp.vo.ICPConfiguration_CreateVo insert(DomainObjectMap map, ims.icp.vo.ICPConfiguration_CreateVo valueObject, ims.icps.configuration.domain.objects.ICP domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ICP(domainObject.getId());
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
			
		// Name
		valueObject.setName(domainObject.getName());
		// Stages
		valueObject.setStages(ims.icp.vo.domain.ICPStageConfiguration_CreateVoAssembler.createICPStageConfiguration_CreateVoCollectionFromICPStage(map, domainObject.getStages()) );
		// Status
		ims.domain.lookups.LookupInstance instance3 = domainObject.getStatus();
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

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup3 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setStatus(voLookup3);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.icps.configuration.domain.objects.ICP extractICP(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVo valueObject) 
	{
		return 	extractICP(domainFactory, valueObject, new HashMap());
	}

	public static ims.icps.configuration.domain.objects.ICP extractICP(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPConfiguration_CreateVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ICP();
		ims.icps.configuration.domain.objects.ICP domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.icps.configuration.domain.objects.ICP)domMap.get(valueObject);
			}
			// ims.icp.vo.ICPConfiguration_CreateVo ID_ICP field is unknown
			domainObject = new ims.icps.configuration.domain.objects.ICP();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ICP());
			if (domMap.get(key) != null)
			{
				return (ims.icps.configuration.domain.objects.ICP)domMap.get(key);
			}
			domainObject = (ims.icps.configuration.domain.objects.ICP) domainFactory.getDomainObject(ims.icps.configuration.domain.objects.ICP.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ICP());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());

		// SaveAsRefVO treated as RefValueObject
		ims.icps.configuration.vo.ICPStageRefVoCollection refCollection2 = new ims.icps.configuration.vo.ICPStageRefVoCollection();
		if (valueObject.getStages() != null)
		{
			for (int i2=0; i2<valueObject.getStages().size(); i2++)
			{
				ims.icps.configuration.vo.ICPStageRefVo ref2 = (ims.icps.configuration.vo.ICPStageRefVo)valueObject.getStages().get(i2);
				refCollection2.add(ref2);
			}
		}
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.List domainStages2 = domainObject.getStages();
		if (domainStages2 == null)
		{
			domainStages2 = new java.util.ArrayList();
		}
		for(int i=0; i < size2; i++) 
		{
			ims.icps.configuration.vo.ICPStageRefVo vo = refCollection2.get(i);			
			ims.icps.configuration.domain.objects.ICPStage dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.icps.configuration.domain.objects.ICPStage)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.icps.configuration.domain.objects.ICPStage)domainFactory.getDomainObject( ims.icps.configuration.domain.objects.ICPStage.class, vo.getBoId());
				}
			}

			int domIdx = domainStages2.indexOf(dom);
			if (domIdx == -1)
			{
				domainStages2.add(i, dom);
			}
			else if (i != domIdx && i < domainStages2.size())
			{
				Object tmp = domainStages2.get(i);
				domainStages2.set(i, domainStages2.get(domIdx));
				domainStages2.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i2 = domainStages2.size();
		while (i2 > size2)
		{
			domainStages2.remove(i2-1);
			i2 = domainStages2.size();
		}
		
		domainObject.setStages(domainStages2);		
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value3);

		return domainObject;
	}

}
