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

package ims.correspondence.domain;

// Generated from form domain impl
public interface GlossaryAdminConfiguration extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listGlossaryProfiles
	*/
	public ims.vo.interfaces.ICspTypeSpecifier[] listMedicAndSpec(ims.correspondence.vo.lookups.ProfileType profileType, String textToSearch);

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryVoCollection listAllGlossaryItems();

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryVo saveGlossary(ims.correspondence.vo.GlossaryVo voGlossary) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public void deleteGlossary(ims.correspondence.configuration.vo.GlossaryRefVo voGlossaryRef) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryProfileVo saveGlossaryProfile(ims.correspondence.vo.GlossaryProfileVo voGlossaryProfile) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryProfileVo getGlossaryProfile(ims.vo.interfaces.ICspTypeSpecifier iCspTypeSpecifier);

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryVo getGlossary(ims.correspondence.configuration.vo.GlossaryRefVo refVoGlossary);

	// Generated from form domain interface definition
	public ims.correspondence.vo.GlossaryProfileVoCollection listGlossaryProfile(ims.correspondence.vo.GlossaryVo glossary, ims.correspondence.vo.lookups.ProfileType profile);

	// Generated from form domain interface definition
	public ims.vo.interfaces.ICspTypeSpecifier getMedicOrSpec(ims.correspondence.vo.lookups.ProfileType profile, Integer id);
}
