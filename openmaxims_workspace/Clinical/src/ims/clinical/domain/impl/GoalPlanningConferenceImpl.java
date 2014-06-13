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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.51 build 2461.19791)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseGoalPlanningMeetingImpl;
import ims.clinical.domain.objects.GoalPlanning;
import ims.clinical.vo.GoalPlanningRefVo;
import ims.clinical.vo.GoalPlanningShortVoCollection;
import ims.clinical.vo.GoalPlanningVo;
import ims.clinical.vo.GoalPlanningVoCollection;
import ims.clinical.vo.domain.GoalPlanningShortVoAssembler;
import ims.clinical.vo.domain.GoalPlanningVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class GoalPlanningConferenceImpl extends BaseGoalPlanningMeetingImpl
{
	private static final long serialVersionUID = 1L;

	public GoalPlanningVoCollection listGoalPlanningMeetings(CareContextLiteVo voCareContextLite) 
	{
		if (voCareContextLite == null)
			throw new CodingRuntimeException("Care Context is a mandatory argument");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from GoalPlanning p ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		hql.append(andStr + " p.careContext.id = :careContext");
		markers.add("careContext");
		values.add(voCareContextLite.getID_CareContext());			
		andStr = " and ";
		
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();

		List goalPlanning = factory.find(query, markers, values, 200);	
		return GoalPlanningVoAssembler.createGoalPlanningVoCollectionFromGoalPlanning(goalPlanning).sort();
	}

	public GoalPlanningVo saveGoalPlanningMeeting(GoalPlanningVo voGoalPlanning) throws StaleObjectException, UniqueKeyViolationException 
	{
		DomainFactory factory = getDomainFactory();	
		
		if (!voGoalPlanning.isValidated())
		{
			throw new DomainRuntimeException("This GoalPlanningMeetingVo has not been validated");
		}
		
		GoalPlanning domGoalPlanning = GoalPlanningVoAssembler.extractGoalPlanning(factory, voGoalPlanning);
		
		factory.save(domGoalPlanning);
			
		return GoalPlanningVoAssembler.create(domGoalPlanning);
	}

	public HcpLiteVoCollection listHcpLiteVoByName(String hcpName) 
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);
	}

	public GoalPlanningShortVoCollection listGoalPlanningShortVo(CareContextRefVo careContext) 
	{
		if (careContext == null)
			throw new CodingRuntimeException("Care Context is a mandatory argument");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from GoalPlanning p ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		hql.append(andStr + " p.careContext.id = :careContext");
		markers.add("careContext");
		values.add(careContext.getID_CareContext());			
		andStr = " and ";
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();

		List goalPlanning = factory.find(query, markers, values, 200);	
		return GoalPlanningShortVoAssembler.createGoalPlanningShortVoCollectionFromGoalPlanning(goalPlanning).sort();
	}

	public GoalPlanningVo getGoalPlanningVo(GoalPlanningRefVo goalPlanningRef) 
	{
		if (goalPlanningRef == null)
			return null;
		
		DomainFactory factory = getDomainFactory();

		GoalPlanning domGoalPlanning = (GoalPlanning) factory.getDomainObject(GoalPlanning.class, goalPlanningRef.getID_GoalPlanning());
		return (GoalPlanningVoAssembler.create(domGoalPlanning));
	}
}
