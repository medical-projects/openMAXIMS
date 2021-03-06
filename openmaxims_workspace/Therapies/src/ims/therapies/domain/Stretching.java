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

package ims.therapies.domain;

// Generated from form domain impl
public interface Stretching extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* return a list of stretching records
	*/
	public ims.therapies.vo.StretchingShortVoCollection listStretchingByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext);

	// Generated from form domain interface definition
	/**
	* Get the current Stretchingrecord for the Clinical Contact 
	*/
	public ims.therapies.vo.StretchingVo getStretchingVo(ims.therapies.treatment.vo.StretchingRefVo stretchingRef);

	// Generated from form domain interface definition
	/**
	* Save a stretching Record for a Clinical Contact
	*/
	public ims.therapies.vo.StretchingVo saveStretchingVo(ims.therapies.vo.StretchingVo voStretching) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* list HCPs
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	public void deleteStretchingVo(ims.therapies.vo.StretchingShortVo voStretchingShort) throws ims.domain.exceptions.ForeignKeyViolationException;
}
