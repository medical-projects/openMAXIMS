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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseSurgicalOpNotesListImpl extends DomainImpl implements ims.clinical.domain.SurgicalOpNotesList, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistHcpLite(String nameFilter, ims.core.vo.lookups.HcpDisType hcpType)
	{
		if(nameFilter == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'nameFilter' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistProcedures(String filterName)
	{
		if(filterName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'filterName' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistDiagnosis(String filterName)
	{
		if(filterName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'filterName' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistDiagrams(String nameFilter)
	{
		if(nameFilter == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'nameFilter' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistHospitals(String filterName)
	{
		if(filterName == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'filterName' of type 'String' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSurgicalOpNotes(ims.clinical.vo.SurgicalOPNotesFilterVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContext(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if(careContextRef == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'careContextRef' of type 'ims.core.admin.vo.CareContextRefVo' cannot be null.");
	}
}
