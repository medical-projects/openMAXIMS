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
public interface Notifications extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.NotificationVoCollection getNotifications();

	// Generated from form domain interface definition
	public void markNotificationAsSeen(Integer notificationId);

	// Generated from form domain interface definition
	/**
	* Registeres a mobile device for push notifications
	*/
	public void registerMobileDeviceToPushNotifications(String uniqueDeviceId, String deviceTokenId, String deviceName, String deviceModel, String systemName, String systemVersion, Boolean enablePushNotifications);

	// Generated from form domain interface definition
	/**
	* Returns a patient by Id
	*/
	public ims.core.vo.PatientShort getPatientById(Integer patientId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShortCollection searchPatients(String searchString);

	// Generated from form domain interface definition
	public ims.ocrr.vo.OcsOrderWebServiceVo getOrderById(Integer orderId);

	// Generated from form domain interface definition
	public void markOrderAsSeen(Integer orderId);

	// Generated from form domain interface definition
	/**
	* Returns a patient by Id
	*/
	public byte[] getPatientImage(Integer patientId, Boolean smallImage);

	// Generated from form domain interface definition
	public ims.ocrr.vo.OcsOrderWebServiceListVoCollection getPatientOrders(Integer patientId, Integer lastNumberOfDays);

	// Generated from form domain interface definition
	public ims.core.vo.PatientAllergyCollection getPatientAllergies(Integer patientId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientAlertCollection getPatientAlerts(Integer patientId);

	// Generated from form domain interface definition
	public ims.admin.vo.LoggedInUserInfoWebServiceVo getLoggedInUserInfo();

	// Generated from form domain interface definition
	public ims.core.vo.VitalSignsWebServiceVoCollection getPatientVitalSigns(Integer patientId, Integer lastNumberOfDays);

	// Generated from form domain interface definition
	public Integer getCurrentInpatientCareContext(Integer patientId);

	// Generated from form domain interface definition
	public void recordVitalSigns(Integer patientId, ims.core.vo.VitalSignsWebServiceVo vitalSigns);

	// Generated from form domain interface definition
	/**
	* getPatientDiagnosisForCurrentEpisodeOfCare
	*/
	public ims.core.vo.PatientDiagnosisWebServiceListVoCollection getPatientDiagnosisForCurrentEpisodeOfCare(Integer patientId);

	// Generated from form domain interface definition
	/**
	* getPatientProceduresForCurrentEpisodeOfCare
	*/
	public ims.core.vo.PatientProcedureWebServiceListVoCollection getPatientProceduresForCurrentEpisodeOfCare(Integer patientId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDiagnosisWebServiceVo getPatientDiagnosis(Integer diagnosisId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientProcedureWebServiceVo getPatientProcedure(Integer procedureId);

	// Generated from form domain interface definition
	/**
	* my patients
	*/
	public ims.core.vo.PatientGroupWebServiceVoCollection getMyPatients();

	// Generated from form domain interface definition
	public ims.core.vo.GeoCoOrdVo getGPSCoordinatesForPostCode(String postCode);
}
