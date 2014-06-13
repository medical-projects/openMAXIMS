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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.54 build 2714.21485)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.core.clinical.domain.objects.PatientNotification;
import ims.core.clinical.domain.objects.PatientOCSNewResults;
import ims.core.clinical.domain.objects.PatientOCSSeenResults;
import ims.core.patient.domain.objects.Patient;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.domain.base.impl.BaseOrderInvStatusHistoryImpl;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection;
import ims.ocrr.vo.OcsPathRadResultVoCollection;
import ims.ocrr.vo.OrderedInvestigationStatusVo;
import ims.ocrr.vo.OrderedInvestigationStatusVoCollection;
import ims.ocrr.vo.domain.OrderedInvestigationStatusVoAssembler;
import ims.ocrr.vo.lookups.OrderInvStatus;

import java.util.Iterator;
import java.util.List;

public class OrderInvStatusHistoryImpl extends BaseOrderInvStatusHistoryImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listStatusHistory
	*/
	public ims.ocrr.vo.OrderedInvestigationStatusVoCollection listStatusHistory(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo ordInv)
	{
		if(ordInv == null || ordInv.getID_OrderInvestigation() == null)
			throw new CodingRuntimeException("ordInv parameter is null or id not supplied in method listStatusHistory");
			
		OrderInvestigation doOrderInv = (OrderInvestigation) getDomainFactory().getDomainObject(ordInv);
		
		//WDEV-6436 - construct the collection manually avoiding the equals method calls that only add one record if status etc. is the same
		OrderedInvestigationStatusVoCollection voColOrderedInvestigationStatus = new OrderedInvestigationStatusVoCollection();
		int dummyId = 1;
		Iterator it = doOrderInv.getOrdInvStatusHistory().iterator();
		while(it.hasNext())
		{
			OrderedInvestigationStatus doStatus = (OrderedInvestigationStatus) it.next();
			OrderedInvestigationStatusVo voStatus = OrderedInvestigationStatusVoAssembler.create(doStatus);
			
			if (voStatus != null) //WDEV-16769
			{
				voStatus.setID_OrderedInvestigationStatus(Integer.valueOf(dummyId));
				dummyId++;
				voColOrderedInvestigationStatus.add(voStatus);
			}
		}
		
		//reset original id
		for (OrderedInvestigationStatusVo voStatus : voColOrderedInvestigationStatus)
			voStatus.setID_OrderedInvestigationStatus(doOrderInv.getId());
		
		return voColOrderedInvestigationStatus;
	}

	// 	WDEV-15894
	public Boolean resetResultStatusToNew(OrderInvestigationRefVoCollection investigations) throws StaleObjectException
	{
		if(investigations == null || investigations.size() == 0)
			throw new DomainRuntimeException("Investigation must be specified to update status.");
		
		DomainFactory factory = getDomainFactory();
		
		
		for (OrderInvestigationRefVo investigation : investigations)
		{
    		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(OrderInvestigation.class, investigation.getID_OrderInvestigation());
    		if (domOrdInv.getVersion() != investigation.getVersion_OrderInvestigation())
    			throw new StaleObjectException(domOrdInv, "Data has been updated by another user");
    		
    		OrderedInvestigationStatus currStatus = domOrdInv.getOrdInvCurrentStatus();
    		
    		if (!getDomLookup(OrderInvStatus.NEW_RESULT).equals(currStatus.getOrdInvStatus())
    				&& !getDomLookup(OrderInvStatus.UPDATED_RESULT).equals(currStatus.getOrdInvStatus())
    				&& !getDomLookup(OrderInvStatus.RESULTED).equals(currStatus.getOrdInvStatus()))
    		{

    			// Get Patient OCS Notification
    			Patient patient = (Patient) factory.getDomainObject(Patient.class, domOrdInv.getOrderDetails().getPatient().getId());
    			PatientNotification notification = patient.getOCSNotification();

    			if (notification == null)
    			{
    				notification = new PatientNotification();
    				notification.setPatient(domOrdInv.getOrderDetails().getPatient());
    				patient.setOCSNotification(notification);
    			}

    			if (notification.getNewResults() == null)
    			{
    				PatientOCSNewResults newResults = new PatientOCSNewResults();
    				newResults.setPatient(domOrdInv.getOrderDetails().getPatient());
    				newResults.setNewCount(0);
    				notification.setNewResults(newResults);
    			}

    			if (notification.getSeenResults() == null)
    			{
    				PatientOCSSeenResults seenResults = new PatientOCSSeenResults();
    				seenResults.setPatient(domOrdInv.getOrderDetails().getPatient());
    				seenResults.setSeenCount(0);
    				notification.setSeenResults(seenResults);
    			}

    			notification.incrementNewResults();

    			factory.save(patient);
    		}

			
			domOrdInv.getOrdInvStatusHistory().add(currStatus);
    		currStatus.setOrdInvStatus(getDomLookup(OrderInvStatus.NEW_RESULT));
    		currStatus.setChangeDateTime(new java.util.Date());
    		currStatus.setProcessedDateTime(new java.util.Date());
    		currStatus.setChangeUser(this.getSession().getUser().getUserRealName());
    		currStatus.setStatusReason("Status changed by user.");
    		    		
    		factory.save(domOrdInv);
		}
		
		return true;
	}

	// 	WDEV-15894
	public OcsPathRadResultVoCollection refreshOcsPathRadResultVo(OcsPathRadResultVoCollection results) 
	{
		if(results == null || results.size() == 0)
			return null;
		
		String ids = "";
		for(int i=0; i<results.size(); i++)
		{
			if(results.get(i) == null || results.get(i).getOrderInvestigation() == null || results.get(i).getOrderInvestigation().getID_OrderInvestigation() == null)
				continue;
			
			ids += (ids.length() > 0 ? "," : "") + results.get(i).getOrderInvestigation().getID_OrderInvestigation();
		}
		
		if(ids.length() == 0)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select orderInv from OrderInvestigation as orderInv where orderInv.id in ( " + ids + " )";
		List<?> list = factory.find(query);
		
		if(list == null || list.size() == 0)
			return null;
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i) instanceof OrderInvestigation)
			{
				OrderInvestigationRefVo invRef = new OrderInvestigationRefVo(((OrderInvestigation) list.get(i)).getId(), ((OrderInvestigation) list.get(i)).getVersion());
				
				OrderInvStatus orderInvStatus = null;// 	WDEV-15894
				
				// 	WDEV-15894
				if(((OrderInvestigation) list.get(i)).getOrdInvCurrentStatus() != null)
				{
					LookupInstance currentStatus = ((OrderInvestigation) list.get(i)).getOrdInvCurrentStatus().getOrdInvStatus();
					orderInvStatus = assembleOrderInvStatusLookupItem(currentStatus);
				}
				
				updateOcsPathRadResult(invRef, orderInvStatus, results);
			}
		}
		
		return results;
	}

	//WDEV-15894
	private void updateOcsPathRadResult(OrderInvestigationRefVo invRef, OrderInvStatus orderInvStatus, OcsPathRadResultVoCollection results)// 	WDEV-15894 
	{
		if(invRef == null || results == null || results.size() == 0)
			return;
		
		for(int i=0; i<results.size(); i++)
		{
			if(invRef.getID_OrderInvestigation().equals(results.get(i).getOrderInvestigation().getID_OrderInvestigation()))
			{
				results.get(i).setOrderInvestigation(invRef);
				results.get(i).setCurrentInvestigationStatus(orderInvStatus);// 	WDEV-15894
				break;
			}
		}
	}
	
	// 	WDEV-15894
	private OrderInvStatus assembleOrderInvStatusLookupItem(LookupInstance orderInv) 
	{
		if(orderInv == null)
			return null;
		
		ims.framework.utils.ImagePath img = null;
		ims.framework.utils.Color color = null;		
		img = null;
		
		if (orderInv.getImage() != null) 
		{
			img = new ims.framework.utils.ImagePath(orderInv.getImage().getImageId(), orderInv.getImage().getImagePath());
		}
		
		color = orderInv.getColor();
		
		if (color != null) 
			color.getValue();

		OrderInvStatus voLookup = new OrderInvStatus(orderInv.getId(),orderInv.getText(), orderInv.isActive(), null, img, color);
		OrderInvStatus parentVoLookup = voLookup;
		ims.domain.lookups.LookupInstance parent = orderInv.getParent();
		
		while (parent != null)
		{
			if (parent.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(parent.getImage().getImageId(), parent.getImage().getImagePath() );
			}
			else 
			{
				img = null;
			}
			
			color = parent.getColor();
			
			if (color != null) 
				color.getValue();
			
			parentVoLookup.setParent(new OrderInvStatus(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
			parentVoLookup = parentVoLookup.getParent();
			parent = parent.getParent();
		}	
		
		return voLookup;
	}
}
