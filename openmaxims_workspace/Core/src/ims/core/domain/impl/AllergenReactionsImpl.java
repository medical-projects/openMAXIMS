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
// This code was generated by Callum Wells using IMS Development Environment (version 1.20 build 40820.730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.core.vo.AllergenTypeReactions;
import ims.core.vo.AllergenTypeReactionsCollection;
import ims.core.vo.domain.AllergenTypeReactionsAssembler;
import ims.core.clinical.domain.objects.AllergenTypeReaction;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;

public class AllergenReactionsImpl extends DomainImpl implements ims.core.domain.AllergenReactions, ims.domain.impl.Transactional
{
	public AllergenTypeReactionsCollection listAllergenTypeReactions(ims.core.vo.lookups.AllergenType allergenType) 
	{
		DomainFactory factory = getDomainFactory();
		String whereAnd = " where ";
					
		StringBuffer hql = new StringBuffer("from AllergenTypeReaction r ");
		if (allergenType != null)
		{
			hql.append(" where r.allergenType = :allergenType"); 
			whereAnd = " and ";
		}
		hql.append(whereAnd + " r.isActive = :isActive");

		java.util.List reactions = factory.find(hql.toString(), new String[]{"isActive","allergenType"}, new Object[]{Boolean.TRUE, getDomLookup(allergenType)});
		return (AllergenTypeReactionsAssembler.createAllergenTypeReactionsCollectionFromAllergenTypeReaction(reactions)).sort();
	}


	public AllergenTypeReactionsCollection saveAllergenTypeReaction(ims.core.vo.lookups.AllergenType allergenType, AllergenTypeReactionsCollection allergenTypeReactions) throws ForeignKeyViolationException, StaleObjectException
	{
		if (!allergenTypeReactions.isValidated())
		{
			throw new DomainRuntimeException("Allergen Type Reaction Collection has not been validated");
		}
		
		//Quicker and easier to delete all existing reactions for a type, and re-insert them.
		//Will ensure the uniqueness of AllergenType + Reaction is maintained		
		DomainFactory factory = getDomainFactory();
		String hql1 = " from AllergenTypeReaction r " +
		" where r.allergenType.id = " +  allergenType.getId();
	
		factory.delete(hql1);
			
		for (int i = 0; i < allergenTypeReactions.size(); i++)
		{
			AllergenTypeReactions reaction = allergenTypeReactions.get(i);
			if (!reaction.getAllergenType().equals(allergenType))
			{
				throw new DomainRuntimeException("All reactions in an AllergenTypeReaction Collection must be for the same Allergen Type ");
			}
			reaction.setID_AllergenTypeReaction(null);
			AllergenTypeReaction domAllergenTypeReaction = AllergenTypeReactionsAssembler.extractAllergenTypeReaction(factory, reaction);
			factory.save(domAllergenTypeReaction);
			reaction.setID_AllergenTypeReaction(domAllergenTypeReaction.getId());			
		}
		return allergenTypeReactions;
	}
}
