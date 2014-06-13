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

package ims.nursing.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicalNotesViewImpl extends DomainImpl implements ims.nursing.domain.ClinicalNotesView, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistClinicNotes(ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate, Boolean activeOnly, ims.core.vo.CareContextShortVo careContextVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReportAndTemplate(Integer reportID, Integer templateID)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalNoteById(Integer idClinicalNote)
	{
		if(idClinicalNote == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'idClinicalNote' of type 'Integer' cannot be null.");
	}
}
