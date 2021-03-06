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

package ims.core.domain;

// Generated from form domain impl
public interface BoneJointConfiguration extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.MskGroupVoCollection listMskGroup(Boolean activeOnly);

	// Generated from form domain interface definition
	public ims.core.vo.MskGroupVo saveMskGroup(ims.core.vo.MskGroupVo group) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List Active joints
	*/
	public ims.generalmedical.vo.RangeOfMovementJointVoCollection listJoints();

	// Generated from form domain interface definition
	/**
	* listJoints
	*/
	public ims.core.vo.MskJointVoCollection listJoints(String strName);

	// Generated from form domain interface definition
	public ims.spinalinjuries.vo.lookups.MskJointsMovementsCollection listMovementsForJoint(ims.core.clinical.vo.MskJointsRefVo refJoint);

	// Generated from form domain interface definition
	public ims.core.vo.MskJointVoCollection listJointsForGroupType(ims.spinalinjuries.vo.lookups.MSKGroupType lkpGroupType);

	// Generated from form domain interface definition
	public ims.core.vo.MskJointVoCollection listJointsForGroup(ims.core.clinical.vo.MskGroupsRefVo voRefMskGroup);

	// Generated from form domain interface definition
	public ims.core.vo.MskGroupLiteVoCollection listGroupsForGroupType(ims.spinalinjuries.vo.lookups.MSKGroupType lkpGroupType);

	// Generated from form domain interface definition
	/**
	* listJointWithGroupTypeDigit
	*/
	public ims.core.vo.MskJointVoCollection listJointWithGroupTypeDigit(Boolean isDigitType);
}
