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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.domain.ScreenProfileConfigurationNew;
import ims.assessment.domain.base.impl.BaseScreeningProfileConfigurationImpl;
import ims.assessment.vo.domain.ScreeningProfileVoAssembler;
import ims.domain.DomainFactory;

import java.util.List;

public class ScreeningProfileConfigurationImpl extends BaseScreeningProfileConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listProfilesByContextType
	*/
	public ims.assessment.vo.ScreeningProfileVoCollection listProfilesByContextType(ims.core.vo.lookups.ContextType contextType)
	{
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("from ScreeningProfile as s1_1	where (s1_1.contextType.id = :CONTEXT_ID)", new String[] {"CONTEXT_ID"}, new Object[] {new Integer(contextType.getID())});
		
		return ScreeningProfileVoAssembler.createScreeningProfileVoCollectionFromScreeningProfile(list);
	}

	/**
	* saveProfile
	*/
	public ims.assessment.vo.ScreeningProfileVo saveProfile(ims.assessment.vo.ScreeningProfileVo profile) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		ScreenProfileConfigurationNew impl = (ScreenProfileConfigurationNew) getDomainImpl(ScreenProfileConfigurationNewImpl.class);
		return impl.saveProfile(profile);	
	}
}
