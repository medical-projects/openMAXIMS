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

package ims.vo.interfaces;

/*
 * Patient Journey Interface - used to display the Journey by the Core.PatientJourney component
 */
public interface IPatientJourney extends Comparable
{
	/*
	 * Journey Events
	 */
	 ims.vo.interfaces.IPatientJourneyEvent[] getIPatientJourneyJourneyEvents();
	/*
	 * Journey Targets
	 */
	 ims.vo.interfaces.IPatientJourneyTarget[] getIPatientJourneyJourneyTargets();
	/*
	 * Profile Title
	 */
	 String getIPatientJourneyProfileTitle();
	/*
	 * Journey Title
	 */
	 String getIPatientJourneyJourneyTitle();
	/*
	 * Pathway Targets
	 */
	 ims.vo.interfaces.IPatientJourneyPathwayTarget[] getIPatientJourneyPathwayTargets();
	/*
	 * Start Date
	 */
	 ims.framework.utils.Date getIPatientJourneyStartDate();
	/*
	 * End Date
	 */
	 ims.framework.utils.Date getIPatientJourneyEndDate();
	/*
	 * Clock History
	 */
	 ims.vo.interfaces.IPatientJourneyClock[] getIPatientJourneyClockHistory();
	/*
	 * Status
	 */
	 ims.vo.interfaces.IPatientJourneyStatus getIPatientJourneyStatus();
	/*
	 * Status History
	 */
	 ims.vo.interfaces.IPatientJourneyStatus[] getIPatientJourneyStatusHistory();
	/*
	 * Number of Weeks
	 */
	 Integer getIPatientJourneyNumberOfWeeks();
	/*
	 * getIPatientJourneyReferralReceivedDate
	 */
	 ims.framework.utils.Date getIPatientJourneyReferralReceivedDate();
	/*
	 * Returns the Original Referral Date
	 */
	 ims.framework.utils.Date getIPatientJourneyOriginalReferralDate();
}
