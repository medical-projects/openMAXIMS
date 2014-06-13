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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.53 build 2510.31460)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.vo.ReportVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.domain.PrintReport;
import ims.core.domain.impl.PrintReportImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.configuration.domain.objects.LocSvcProviderSys;
import ims.ocrr.domain.OrderSummaryDialog;
import ims.ocrr.domain.base.impl.BasePrintOrderImpl;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.OrderSpecimenRefVo;
import ims.ocrr.vo.LocSvcProviderSysLiteVo;
import ims.ocrr.vo.domain.LocSvcProviderSysLiteVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class PrintOrderImpl extends BasePrintOrderImpl
{
	private static final long serialVersionUID = 1L;

	public ims.ocrr.vo.OcsOrderSummaryVo getOrderSummary(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrderRef)//WDEV-16232
	{
		OrderSummaryDialog impl = (OrderSummaryDialog) getDomainImpl(OrderSummaryImpl.class);
		return impl.getOrderSummary(voOcsOrderRef);
	}

	public ReportVoCollection listReports(Integer formId)
	{
		PrintReport impl = (PrintReport) getDomainImpl(PrintReportImpl.class);
		return impl.listReports(formId);
	}

	@SuppressWarnings("rawtypes")
	public String getDefaultPrinterByLocationAndService(LocationRefVo requestedLocation, ServiceRefVo service)
	{
		if(requestedLocation == null || service == null)
			throw new CodingRuntimeException("Null parameter passed for requestedLocation or service in method getDefaultPrinterByLocationAndService");
		
		DomainFactory factory = getDomainFactory();
		List printers = factory.find("select locService.defaultPrinter from LocationService as locService where locService.location.id = :idLocation and locService.service.id = :idService" , new String[]{"idLocation","idService"},new Object[]{requestedLocation.getID_Location(),service.getID_Service()});
		if(printers != null && printers.size() == 1)
			return (String)printers.get(0);
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	public LocSvcProviderSysLiteVo getProviderServiceForOrderInv(OrderInvestigationRefVo orderInv)
	{
		if(orderInv == null || orderInv.getID_OrderInvestigation() == null)
			throw new CodingRuntimeException("orderInv parameter is null in method getProviderServiceForOrderInv");
		
		DomainFactory factory = getDomainFactory();
		String hql = "select inv.providerService from OrderInvestigation as orderInv left join orderInv.investigation as inv left join inv.providerService as provSer where orderInv.id = :idOrderInv";
		List providers = factory.find(hql,new String[] {"idOrderInv"},new Object[] {orderInv.getID_OrderInvestigation()});
		if(providers != null && providers.size() == 1)
			return LocSvcProviderSysLiteVoAssembler.create((LocSvcProviderSys) providers.get(0));
		
		return null;
	}

	public String[] getSystemReportAndTemplateByReporMapping(Integer lookupInstanceId, ServiceLiteVo modality, Boolean dft) 
	{
		if(modality != null && dft != null)
		{
			return getSystemReportAndTemplateFromModalityReportsConfiguration(modality, dft);
		}
		else
		{
			return getSystemReportAndTemplateFromMapping(lookupInstanceId);
		}
	}

	private String[] getSystemReportAndTemplateFromModalityReportsConfiguration(ServiceLiteVo modality, Boolean dft)
	{
		String[] result = null;	
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		DomainFactory factory = getDomainFactory();
		
		String reportQuery = "select r1_1.reportXml, t1_1.templateXml from ModalityReports as m1_1 join m1_1.template as t1_1 join t1_1.report as r1_1 where  (m1_1.modality.id = (:MODALITY) and m1_1.dFTReport = (:DFT))";
		
		markers.add("MODALITY");
		values.add(modality.getID_Service());
		markers.add("DFT");
		values.add(dft);

		List<?> lst = factory.find(reportQuery, markers, values);
		
		if(lst == null)
			return null;
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}

	private String[] getSystemReportAndTemplateFromMapping(Integer lookupInstanceId)
	{
		if(lookupInstanceId == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		String reportId = null;
		String query = "select lm.extCode from LookupInstance as li left join li.mappings as lm where (li.id = :LookupInstanceId and lm.extSystem = :TaxonomyType) ";
		
		List<?> list = factory.find(query, new String[] {"LookupInstanceId", "TaxonomyType"}, new Object[] {lookupInstanceId, TaxonomyType.REPORTS.getText()});
		
		if(list != null && list.size() > 0 && list.get(0) instanceof String)
		{
			reportId = (String) list.get(0);
		}
		
		if(reportId == null)	
			return null;
		
		Integer ReportId = null;
		Integer IMSReportId = null;
		
		try
		{
			IMSReportId = Integer.parseInt(reportId);
		}
		catch(NumberFormatException e)
		{
			int idIndex = reportId.indexOf("ID");
			if(idIndex >= 0)
			{
				String reportIdSecond = reportId.substring(idIndex + 2);
				
				try
				{
					ReportId = Integer.parseInt(reportIdSecond);
				}
				catch(NumberFormatException e1)
				{
			
				}
			}
		}
		
		if(IMSReportId == null && ReportId == null)
			return null;
		
		String[] result = null;	
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String reportQuery = "select r.reportXml, t.templateXml from ReportBo as r left join r.templates as t where";
		
		List<?> lst = null;
		
		if(IMSReportId != null)
		{
			reportQuery += " (r.imsId= :imsid)";
			markers.add("imsid");
			values.add(IMSReportId);
		}
		else if(ReportId != null)
		{
			reportQuery += " (r.id= :repid)";
			markers.add("repid");
			values.add(ReportId);
		}
		reportQuery += " order by t.name";
		
		lst = factory.find(reportQuery, markers, values);
		
		if(lst == null)
			return null;
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	public ServiceLiteVo getModality(OrderInvestigationRefVo orderInv)
	{
		if(orderInv == null || orderInv.getID_OrderInvestigation() == null)
			throw new CodingRuntimeException("orderInv parameter is null in method getModality");
		
		DomainFactory factory = getDomainFactory();
		String hql = "select o2_1.discipline from OrderInvestigation as o1_1 join o1_1.specimen as o2_1 where (o1_1.id = (:ID)) ";
		List list = factory.find(hql,new String[] {"ID"},new Object[] {orderInv.getID_OrderInvestigation()});

		if(list.size() > 0)
			return ServiceLiteVoAssembler.create((Service) list.get(0));
		
		//if current OrderInvestigation doesn't have a specimen we get the modality as follows:
		//OrderInvestigation.investigation.providerService.locationService.service
		hql = "select l2_1.service from OrderInvestigation as o1_1 left join o1_1.investigation as i1_1 left join i1_1.providerService as l1_1 left join l1_1.locationService as l2_1 left join l2_1.service as s1_1 where (o1_1.id = :ID)";
		list = factory.find(hql,new String[] {"ID"},new Object[] {orderInv.getID_OrderInvestigation()});

		if(list.size() > 0)
			return ServiceLiteVoAssembler.create((Service) list.get(0));
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	public ServiceLiteVo getModality(OrderSpecimenRefVo orderSpecimen)
	{
		if(orderSpecimen == null || orderSpecimen.getID_OrderSpecimen() == null)
			throw new CodingRuntimeException("orderSpecimen parameter is null in method getModality");
		
		DomainFactory factory = getDomainFactory();
		String hql = "select o1_1.discipline from OrderSpecimen as o1_1 where o1_1.id = (:ID))";
		List list = factory.find(hql,new String[] {"ID"},new Object[] {orderSpecimen.getID_OrderSpecimen()});

		if(list.size() > 0)
			return ServiceLiteVoAssembler.create((Service) list.get(0));
					
		return null;
	}

	public ServiceLiteVo getModality(Integer modalityId)
	{
		DomainFactory factory = getDomainFactory();
		
		return ServiceLiteVoAssembler.create((Service) factory.loadDomainObject(Service.class, modalityId));
	}
}
