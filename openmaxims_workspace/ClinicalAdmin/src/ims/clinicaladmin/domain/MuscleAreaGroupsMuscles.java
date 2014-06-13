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

package ims.clinicaladmin.domain;

// Generated from form domain impl
public interface MuscleAreaGroupsMuscles extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all Vertebral Levels
	*/
	public ims.core.vo.VertebrallevelVoCollection listVertebralLevels();

	// Generated from form domain interface definition
	/**
	* Save a MuscleVo
	*/
	public ims.clinicaladmin.vo.MuscleVo saveMuscleVo(ims.clinicaladmin.vo.MuscleVo muscleVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List Muscles
	*/
	public ims.clinicaladmin.vo.MuscleVoCollection listMuscles(ims.clinicaladmin.vo.MuscleVo muscleVo);

	// Generated from form domain interface definition
	/**
	* List Motor Areas
	*/
	public ims.clinicaladmin.vo.MotorAreaVoCollection listMotorAreas();

	// Generated from form domain interface definition
	/**
	* Save a motor Area
	*/
	public ims.clinicaladmin.vo.MotorAreaVo saveMotorArea(ims.clinicaladmin.vo.MotorAreaVo motorAreaVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* get Muscles for Group
	*/
	public ims.clinicaladmin.vo.MuscleGroupsVo getMuscles(ims.clinicaladmin.vo.MuscleGroupsVo voMuscleGroups);
}
