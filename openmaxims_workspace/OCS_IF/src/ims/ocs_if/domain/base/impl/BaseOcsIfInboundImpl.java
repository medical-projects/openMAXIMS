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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocs_if.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseOcsIfInboundImpl extends DomainImpl implements ims.ocs_if.domain.OcsIfInbound, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesavePathResult(ims.ocs_if.vo.IfOrderSpecimenVo specimenVo, String placerNum, String fillerNum, String hl7App, Boolean statusChecked, ims.ocs_if.vo.IfResultDetailsVoCollection historicResultDetails, ims.ocs_if.vo.IfOrderInvestigationVo orderInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo ocsOrder)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAnalyte(String extCode, String extTxt, ims.ocs_if.vo.IfProviderInvSearchVo providerInvSearch, ims.ocrr.vo.lookups.ResultUnitOfMeasure unitOfMeasure)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderByPlacerOrFiller(String placerOrdNum, String fillerOrdNum, ims.ocrr.vo.lookups.Category category)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrder(ims.ocs_if.vo.IfOcsOrderVo order)
	{
	}

	@SuppressWarnings("unused")
	public void validategetInvestigationByHl7AppInvAndService(ims.ocs_if.vo.IfProviderInvSearchVo searchCriteria)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveRadResult(ims.ocs_if.vo.IfOrdInvResultVo ordInvResultVo, String placerNum, String fillerNum, String hl7App)
	{
	}

	@SuppressWarnings("unused")
	public void validategetServiceByTaxonomy(String externalCode, ims.core.vo.lookups.TaxonomyType taxonomy)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecimenByPlacerOrFiller(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo order, String placerNum, String fillerNum, ims.ocs_if.vo.IfOrderInvestigationVo orderInv)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigation(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo order, ims.ocs_if.vo.IfInvestigationLiteVo investigation, ims.ocrr.vo.lookups.SpecimenSite specimenSite, ims.ocrr.orderingresults.vo.OrderSpecimenRefVo orderSpecimen, String placerNum, String fillerNum)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServicesWithAlternateCode(String alternateCode)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateInvestigationStatus(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo invRef, ims.ocs_if.vo.IfOrderInvCurrentStatusVo newStatus)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrderInvestigation(ims.ocs_if.vo.IfOrderInvestigationVo ordInv)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrderInvestigation(ims.ocs_if.vo.IfOrderInvestigationVo ordInv, Boolean isChangeInv, ims.core.admin.vo.ProviderSystemRefVo providerSystem)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrderSpecimen(ims.ocs_if.vo.IfOrderSpecimenVo ordSpec)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocParentByTaxType(String extId, ims.core.vo.lookups.TaxonomyType taxType)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveLocation(ims.ocs_if.vo.IfLocParentVo location)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrderLevelItems(ims.ocs_if.vo.IfOcsOrderShortVo order)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateInvDisplayDateTime(ims.ocs_if.vo.IfOrderSpecimenVo specimen)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateNonResultableInvestigations(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo specimen)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderFromInv(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo inv)
	{
	}

	@SuppressWarnings("unused")
	public void validategetFirstSpecimenTypeForResultSpecimenType(ims.ocrr.vo.lookups.ResultSpecimenTypes resultSpecimenType)
	{
	}

	@SuppressWarnings("unused")
	public void validatecalculateExpectedDateTime(ims.ocrr.configuration.vo.InvestigationRefVo investigation, ims.framework.utils.DateTime dateTimeReceived)
	{
		if(investigation == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'investigation' of type 'ims.ocrr.configuration.vo.InvestigationRefVo' cannot be null.");
		if(dateTimeReceived == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'dateTimeReceived' of type 'ims.framework.utils.DateTime' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveOrderAsUnprocessed(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderSession)
	{
	}
}
