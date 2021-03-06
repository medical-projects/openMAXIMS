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

package ims.assessment.domain;

// Generated from form domain impl
public interface FindingQuestions extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.DrawingGraphicFindingVo saveFinding(ims.core.vo.DrawingGraphicFindingVo drawingGraphicFindingVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* list Drawing Graphic Findings
	*/
	public ims.core.vo.DrawingGraphicFindingVoCollection listFindings(String findingName, ims.core.vo.lookups.PreActiveActiveInactiveStatus status);

	// Generated from form domain interface definition
	public ims.admin.vo.AppImageVoCollection listImages(ims.admin.vo.AppImageVo filter);

	// Generated from form domain interface definition
	/**
	* Saving DrawingGraphicFindingQuestionVo
	*/
	public ims.core.vo.DrawingGraphicFindingQuestionVoCollection saveDrawingGraphicFindings(ims.core.vo.DrawingGraphicFindingQuestionVoCollection voColl) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List Drawing Graphic Findings
	*/
	public ims.core.vo.DrawingGraphicFindingQuestionVoCollection listDrawingGraphicFindings(Integer findingId);
}
