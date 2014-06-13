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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.60 build 2874.17009)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseNTPFBatchPriceSelectionDialogImpl;
import ims.core.clinical.domain.objects.BatchPricing;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.domain.BatchPricingVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.ntpf.vo.lookups.BatchStatus;

import java.util.ArrayList;
import java.util.List;

public class NTPFBatchPriceSelectionDialogImpl extends BaseNTPFBatchPriceSelectionDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Get
	*/
	public ims.core.vo.BatchPricingVo getBatch(ims.core.clinical.vo.BatchPricingRefVo batchRefVo)
	{
		DomainFactory factory = getDomainFactory();
		BatchPricing domBatch = (BatchPricing) factory.getDomainObject(BatchPricing.class, batchRefVo.getID_BatchPricing());
		return BatchPricingVoAssembler.create(domBatch);
	}

	/**
	* List
	* 
	*/
	@SuppressWarnings("unchecked")
	public ims.core.vo.BatchPricingVoCollection listBatches(ims.core.resource.place.vo.LocationRefVo location)
	{
	    DomainFactory factory = getDomainFactory();		
	    
	    String hql = " from BatchPricing bp "; 
	    ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	  
    	condStr.append(andStr + " bp.location.id = :loc" );
		markers.add("loc");
		values.add(location.getID_Location());		
		andStr = " and ";

    	condStr.append(andStr + " bp.status = :status" );
		markers.add("status");
		values.add(getDomLookup(BatchStatus.PREACTIVE));		
		andStr = " and ";

		if(andStr.equals( " and "))
	    	hql += " where ";
	    
	    hql += condStr.toString();
	    List batches = factory.find(hql,markers,values);
	    return BatchPricingVoAssembler.createBatchPricingVoCollectionFromBatchPricing(batches).sort();
	}

	/**
	* Save
	*/
	public ims.core.vo.BatchPricingVo saveBatch(ims.core.vo.BatchPricingVo batchVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (!batchVo.isValidated())
		{
			throw new DomainRuntimeException("Batch has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		BatchPricing domBatch = BatchPricingVoAssembler.extractBatchPricing(factory, batchVo);
		
		factory.save(domBatch); 		
		return BatchPricingVoAssembler.create(domBatch);
	}

	@SuppressWarnings("unchecked")
	public Integer countBatches(LocationRefVo location)
	{
	    DomainFactory factory = getDomainFactory();		
	    
	    String hql = " from BatchPricing bp "; 
	    ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	  
    	condStr.append(andStr + " bp.location.id = :loc" );
		markers.add("loc");
		values.add(location.getID_Location());		
		andStr = " and ";

    	condStr.append(andStr + " bp.status = :status" );
		markers.add("status");
		values.add(getDomLookup(BatchStatus.PREACTIVE));		
		andStr = " and ";

		if(andStr.equals( " and "))
	    	hql += " where ";
	    
	    hql += condStr.toString();
	    List batches = factory.find(hql,markers,values);
	    return batches.size();
	}

	public String[] getReportAndTemplate(Integer reportID, Integer templateID)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.id = :rid  and t1_1.id = :tid)", new String[] {"rid", "tid"}, new Object[] {reportID, templateID});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}
}
