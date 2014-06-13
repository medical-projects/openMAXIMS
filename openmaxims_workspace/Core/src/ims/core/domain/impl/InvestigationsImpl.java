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
//This code was generated by Neil McAnaspie using IMS Development Environment (version 1.22 build 41222.900)
//Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.Investigations;
import ims.core.clinical.vo.InvestigationsRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.EpisodeofCareLiteVo;
import ims.core.vo.InvestigationsVo;
import ims.core.vo.InvestigationsVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.InvestigationsVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

public class InvestigationsImpl extends DomainImpl implements ims.core.domain.Investigations, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Retieving a list of Investigations associated with episode
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(filter);
	}

	/* (non-Javadoc)
	 * @see ims.core.domain.Investigations#listInvestigation(ims.core.vo.ClinicalEpisode)
	 */
	public InvestigationsVoCollection listInvestigation(CareContextRefVo voCareContextRef) 
	{
		if (voCareContextRef == null)
			throw new CodingRuntimeException("Care Context was not supplied. Mandatory argument");
	
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from Investigations t ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		hql.append(andStr + " t.careContext.id like :rcc");
		markers.add("rcc");
		values.add(voCareContextRef.getID_CareContext());
		andStr = " and ";
	
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		List investList = factory.find(query, markers, values);							
		return InvestigationsVoAssembler.createInvestigationsVoCollectionFromInvestigations(investList);
	}
	
	public InvestigationsVo saveInvestigationDetails(InvestigationsVo investigations) throws StaleObjectException
	{
		if (!investigations.isValidated())
		{
			throw new DomainRuntimeException("Investigation has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		
		Investigations doInvestigation = InvestigationsVoAssembler.extractInvestigations(factory, investigations);
		
		factory.save(doInvestigation);
		
		return InvestigationsVoAssembler.create(doInvestigation);
	}

	public InvestigationsVoCollection listInvestigationsByCareContext(CareContextLiteVo voCareContext)
	{
		return listInvestigation(voCareContext);	
	}


	public CareContextShortVoCollection listInvestigationsByCareContextShort(EpisodeofCareLiteVo voEpisodeOfCareLite)
	{
		if (voEpisodeOfCareLite == null)
			throw new CodingRuntimeException("Episode of Care was not supplied. Mandatory argument");
	
		DomainFactory factory = getDomainFactory();
		String hql = "select careContext from Investigations t where t.careContext.episodeOfCare.id = " + voEpisodeOfCareLite.getID_EpisodeOfCare(); 
		List investList = factory.find(hql);							
		return CareContextShortVoAssembler.createCareContextShortVoCollectionFromCareContext(investList).sort(SortOrder.DESCENDING);
	}

	public InvestigationsVo getInvestigation(InvestigationsRefVo investigationId) 
	{
		if(investigationId == null || !investigationId.getID_InvestigationsIsNotNull())
			throw new CodingRuntimeException("Can not get Investigation on null Id.");
		
		return InvestigationsVoAssembler.create((Investigations) getDomainFactory().getDomainObject(Investigations.class, investigationId.getID_Investigations()));
	}
}
