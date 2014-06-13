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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseSelecPrognosticPSAImpl;
import ims.clinicaladmin.vo.domain.PSAConfigVoAssembler;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.configuration.domain.objects.PSAConfig;

public class SelecPrognosticPSAImpl extends BaseSelecPrognosticPSAImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinicaladmin.vo.PSAConfigVoCollection listPSA()
	{
		String query = " from PSAConfig as psaconfig where psaconfig.isActive = 1 order by psaconfig.pSAName asc";
		return PSAConfigVoAssembler.createPSAConfigVoCollectionFromPSAConfig(getDomainFactory().find(query));
	}

	public ims.clinicaladmin.vo.PSAConfigVo getPSA(ims.oncology.configuration.vo.PSAConfigRefVo psa)
	{
		if (psa == null || !psa.getID_PSAConfigIsNotNull())
			return null;
		
		return PSAConfigVoAssembler.create((PSAConfig) getDomainFactory().getDomainObject(PSAConfig.class, psa.getID_PSAConfig()));
	}

	public ims.clinicaladmin.vo.PSAConfigVo savePSA(ims.clinicaladmin.vo.PSAConfigVo psa) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException
	{
		// Check for value to save
		if (psa == null)
			throw new DomainRuntimeException("Domain Error - Can not save a null pasconfig record");
		
		// Check for validated record
		if (!psa.isValidated())
			throw new DomainRuntimeException("Domain Error - Psaconfig record must be validated before save");
		
		// Get domain object
		PSAConfig psaconfig = PSAConfigVoAssembler.extractPSAConfig(getDomainFactory(), psa);
				
		// Attempt save
		getDomainFactory().save(psaconfig);
				
		return PSAConfigVoAssembler.create(psaconfig);
	}
}
