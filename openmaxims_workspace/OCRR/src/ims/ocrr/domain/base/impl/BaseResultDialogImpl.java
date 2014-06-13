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

package ims.ocrr.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseResultDialogImpl extends DomainImpl implements ims.ocrr.domain.ResultDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetSpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo id)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpecimen(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orvInvRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalImagingResult(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAssignedReports(Integer formId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReportAndTemplate(Integer reportId, Integer templateId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSystemReportAndTemplate(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo refOrderInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNewResultOcsOrderVo(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCentricityPacsAccessionNumber(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo voOrderInvRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validateaddViewedToStatusHistory(ims.ocrr.vo.OcsPathRadResultVo pathRadResultVo)
	{
		if(pathRadResultVo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'pathRadResultVo' of type 'ims.ocrr.vo.OcsPathRadResultVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatewasSecondaryMatching(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInvestigation)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateRadResultStatus(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderInv, ims.vo.LookupInstVo newStatus, ims.core.resource.people.vo.HcpRefVo hcp)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdatePathologyResultStatus(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo ordInvRef, ims.vo.LookupInstVo newStatus, ims.core.resource.people.vo.HcpRefVo hcp)
	{
	}

	@SuppressWarnings("unused")
	public void validateresetAllocatedReviewHCP(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientClericalTask(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultSelectedId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMappingForResultStatusLookup(ims.ocrr.vo.lookups.ResultStatus resultStatusInstance, ims.core.vo.lookups.TaxonomyType extSystem)
	{
	}

	@SuppressWarnings("unused")
	public void validaterefreshCurrentPathRadResult(ims.ocrr.vo.OcsPathRadResultVo currentPathRadResult)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalResult(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo resultId)
	{
	}
}
