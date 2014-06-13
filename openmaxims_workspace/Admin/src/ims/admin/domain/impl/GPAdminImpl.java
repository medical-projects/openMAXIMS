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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.21 build 41006.1700)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ims.admin.helper.Keywords;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.resource.domain.objects.GpToPractice;
import ims.core.resource.people.domain.objects.Gp;
import ims.core.vo.GP;
import ims.core.vo.domain.GPAssembler;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;

public class GPAdminImpl extends DomainImpl implements ims.admin.domain.GPAdmin, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	public GP saveGp(GP gp) throws StaleObjectException, UniqueKeyViolationException
	{
		if(!gp.isValidated()) 
			throw new DomainRuntimeException("Gp Not Validated");
			
		DomainFactory factory = getDomainFactory();
		
		gp.getName().setUppers();
		
		Gp doGp = GPAssembler.extractGp(factory, gp);
		Iterator it = doGp.getPractices().iterator();
		while(it.hasNext())
		{
			GpToPractice gpPract = (GpToPractice) it.next();
			gpPract.setGp(doGp);
		}
		try
		{
			factory.save(doGp);
		}
		catch (UnqViolationUncheckedException e)
		{
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, doGp, "codeMappings", gp.getCodeMappings(), "getName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
		}
		return GPAssembler.create(doGp);
	}


	
	public GP getGPByTaxonomyType(String extId, TaxonomyType taxonomyType) 
	{
		if (extId == null || taxonomyType == null)
			return null;

		DomainFactory factory = getDomainFactory();
		//String hql = " from Gp g where g.localCode=:pasId";
		String hql = " from Gp g " +
		" join g.codeMappings as cm" +
		" where cm.taxonomyName = :taxType " + 
		" and cm.taxonomyCode = :extId ";

		List gpList = factory.find(hql,new String[]{"taxType", "extId"}, new Object[]{getDomLookup(taxonomyType),extId});

		if (gpList != null && gpList.size() > 0)
		{
			Gp gp = (Gp)gpList.get(0);
			return GPAssembler.create(gp);
		}
		return null;
	}

	public GP getGP(Integer id) 
	{
		DomainFactory factory = getDomainFactory();
		
		Gp doGP = (Gp) factory.getDomainObject(Gp.class, id);
		return GPAssembler.create(doGP);
	}

    public ims.core.vo.GpShortVoCollection listGPsBySurname(String surname)
    {
    	if(surname == null)
    		throw new DomainRuntimeException("Invalid GP surname");
    	
    	ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		surname = surname.toUpperCase();
		if(!surname.endsWith("%"))
			surname += "%";
		
		String hql = "from Gp gp where gp.name.upperSurname like :surname order by gp.name.upperSurname";
		names.add("surname");
		values.add(surname);		
		return GpShortVoAssembler.createGpShortVoCollectionFromGp(getDomainFactory().find(hql, names, values));
    }

}
