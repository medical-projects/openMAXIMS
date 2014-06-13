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

package ims.clinical.vo;

/**
 * Linked to core.clinical.ReferralLetterDetails business object (ID: 1003100093).
 */
public class ReferralLetterDetailsVo extends ims.core.clinical.vo.ReferralLetterDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralLetterDetailsVo()
	{
	}
	public ReferralLetterDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralLetterDetailsVo(ims.clinical.vo.beans.ReferralLetterDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.referrertype = bean.getReferrerType() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getReferrerType());
		this.gpname = bean.getGPName() == null ? null : bean.getGPName().buildVo();
		this.alliedhealthprofname = bean.getAlliedHealthProfName();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.datereferralreceived = bean.getDateReferralReceived() == null ? null : bean.getDateReferralReceived().buildDate();
		this.end18ww = bean.getEnd18WW() == null ? null : bean.getEnd18WW().buildDate();
		this.interpreterrequired = bean.getInterpreterRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getInterpreterRequired());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.transportrequired = bean.getTransportRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getTransportRequired());
		this.transport = bean.getTransport() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransport());
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.copydischargetopatient = bean.getCopyDischargeToPatient();
		this.pct = bean.getPCT();
		this.function = bean.getFunction() == null ? null : bean.getFunction().buildVo();
		this.otherlanguage = bean.getOtherLanguage();
		this.specialrequirements = bean.getSpecialRequirements();
		this.isdadreferral = bean.getIsDADReferral();
		this.dadubrn = bean.getDadUbrn();
		this.practice = bean.getPractice() == null ? null : bean.getPractice().buildVo();
		this.isreferrerpatientsgp = bean.getIsReferrerPatientsGp();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.enddatekpi = bean.getEndDateKPI() == null ? null : bean.getEndDateKPI().buildDate();
		this.enddateemailkpi = bean.getEndDateEmailKPI() == null ? null : bean.getEndDateEmailKPI().buildDate();
		this.enddatepaperkpi = bean.getEndDatePaperKPI() == null ? null : bean.getEndDatePaperKPI().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.transportrequirements = bean.getTransportRequirements() == null ? null : bean.getTransportRequirements().buildVo();
		this.referringconsultant = bean.getReferringConsultant() == null ? null : bean.getReferringConsultant().buildVo();
		this.originaldateofreferral = bean.getOriginalDateOfReferral() == null ? null : bean.getOriginalDateOfReferral().buildDate();
		this.refereraddress = bean.getRefererAddress();
		this.transferedby = bean.getTransferedBY();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ReferralLetterDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.referrertype = bean.getReferrerType() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getReferrerType());
		this.gpname = bean.getGPName() == null ? null : bean.getGPName().buildVo(map);
		this.alliedhealthprofname = bean.getAlliedHealthProfName();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.datereferralreceived = bean.getDateReferralReceived() == null ? null : bean.getDateReferralReceived().buildDate();
		this.end18ww = bean.getEnd18WW() == null ? null : bean.getEnd18WW().buildDate();
		this.interpreterrequired = bean.getInterpreterRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getInterpreterRequired());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.transportrequired = bean.getTransportRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getTransportRequired());
		this.transport = bean.getTransport() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransport());
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.copydischargetopatient = bean.getCopyDischargeToPatient();
		this.pct = bean.getPCT();
		this.function = bean.getFunction() == null ? null : bean.getFunction().buildVo(map);
		this.otherlanguage = bean.getOtherLanguage();
		this.specialrequirements = bean.getSpecialRequirements();
		this.isdadreferral = bean.getIsDADReferral();
		this.dadubrn = bean.getDadUbrn();
		this.practice = bean.getPractice() == null ? null : bean.getPractice().buildVo(map);
		this.isreferrerpatientsgp = bean.getIsReferrerPatientsGp();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.enddatekpi = bean.getEndDateKPI() == null ? null : bean.getEndDateKPI().buildDate();
		this.enddateemailkpi = bean.getEndDateEmailKPI() == null ? null : bean.getEndDateEmailKPI().buildDate();
		this.enddatepaperkpi = bean.getEndDatePaperKPI() == null ? null : bean.getEndDatePaperKPI().buildDate();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.transportrequirements = bean.getTransportRequirements() == null ? null : bean.getTransportRequirements().buildVo(map);
		this.referringconsultant = bean.getReferringConsultant() == null ? null : bean.getReferringConsultant().buildVo(map);
		this.originaldateofreferral = bean.getOriginalDateOfReferral() == null ? null : bean.getOriginalDateOfReferral().buildDate();
		this.refereraddress = bean.getRefererAddress();
		this.transferedby = bean.getTransferedBY();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ReferralLetterDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ReferralLetterDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ReferralLetterDetailsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("REFERRERTYPE"))
			return getReferrerType();
		if(fieldName.equals("GPNAME"))
			return getGPName();
		if(fieldName.equals("ALLIEDHEALTHPROFNAME"))
			return getAlliedHealthProfName();
		if(fieldName.equals("DATEOFREFERRAL"))
			return getDateOfReferral();
		if(fieldName.equals("DATEREFERRALRECEIVED"))
			return getDateReferralReceived();
		if(fieldName.equals("END18WW"))
			return getEnd18WW();
		if(fieldName.equals("INTERPRETERREQUIRED"))
			return getInterpreterRequired();
		if(fieldName.equals("LANGUAGE"))
			return getLanguage();
		if(fieldName.equals("TRANSPORTREQUIRED"))
			return getTransportRequired();
		if(fieldName.equals("TRANSPORT"))
			return getTransport();
		if(fieldName.equals("AUTHORINGUSER"))
			return getAuthoringUser();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("COPYDISCHARGETOPATIENT"))
			return getCopyDischargeToPatient();
		if(fieldName.equals("PCT"))
			return getPCT();
		if(fieldName.equals("FUNCTION"))
			return getFunction();
		if(fieldName.equals("OTHERLANGUAGE"))
			return getOtherLanguage();
		if(fieldName.equals("SPECIALREQUIREMENTS"))
			return getSpecialRequirements();
		if(fieldName.equals("ISDADREFERRAL"))
			return getIsDADReferral();
		if(fieldName.equals("DADUBRN"))
			return getDadUbrn();
		if(fieldName.equals("PRACTICE"))
			return getPractice();
		if(fieldName.equals("ISREFERRERPATIENTSGP"))
			return getIsReferrerPatientsGp();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("ENDDATEKPI"))
			return getEndDateKPI();
		if(fieldName.equals("ENDDATEEMAILKPI"))
			return getEndDateEmailKPI();
		if(fieldName.equals("ENDDATEPAPERKPI"))
			return getEndDatePaperKPI();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("TRANSPORTREQUIREMENTS"))
			return getTransportRequirements();
		if(fieldName.equals("REFERRINGCONSULTANT"))
			return getReferringConsultant();
		if(fieldName.equals("ORIGINALDATEOFREFERRAL"))
			return getOriginalDateOfReferral();
		if(fieldName.equals("REFERERADDRESS"))
			return getRefererAddress();
		if(fieldName.equals("TRANSFEREDBY"))
			return getTransferedBY();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getReferrerTypeIsNotNull()
	{
		return this.referrertype != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getReferrerType()
	{
		return this.referrertype;
	}
	public void setReferrerType(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.referrertype = value;
	}
	public boolean getGPNameIsNotNull()
	{
		return this.gpname != null;
	}
	public ims.core.vo.GpLiteVo getGPName()
	{
		return this.gpname;
	}
	public void setGPName(ims.core.vo.GpLiteVo value)
	{
		this.isValidated = false;
		this.gpname = value;
	}
	public boolean getAlliedHealthProfNameIsNotNull()
	{
		return this.alliedhealthprofname != null;
	}
	public String getAlliedHealthProfName()
	{
		return this.alliedhealthprofname;
	}
	public static int getAlliedHealthProfNameMaxLength()
	{
		return 150;
	}
	public void setAlliedHealthProfName(String value)
	{
		this.isValidated = false;
		this.alliedhealthprofname = value;
	}
	public boolean getDateOfReferralIsNotNull()
	{
		return this.dateofreferral != null;
	}
	public ims.framework.utils.Date getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofreferral = value;
	}
	public boolean getDateReferralReceivedIsNotNull()
	{
		return this.datereferralreceived != null;
	}
	public ims.framework.utils.Date getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datereferralreceived = value;
	}
	public boolean getEnd18WWIsNotNull()
	{
		return this.end18ww != null;
	}
	public ims.framework.utils.Date getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.end18ww = value;
	}
	public boolean getInterpreterRequiredIsNotNull()
	{
		return this.interpreterrequired != null;
	}
	public ims.core.vo.lookups.YesNo getInterpreterRequired()
	{
		return this.interpreterrequired;
	}
	public void setInterpreterRequired(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.interpreterrequired = value;
	}
	public boolean getLanguageIsNotNull()
	{
		return this.language != null;
	}
	public ims.core.vo.lookups.Language getLanguage()
	{
		return this.language;
	}
	public void setLanguage(ims.core.vo.lookups.Language value)
	{
		this.isValidated = false;
		this.language = value;
	}
	public boolean getTransportRequiredIsNotNull()
	{
		return this.transportrequired != null;
	}
	public ims.core.vo.lookups.YesNo getTransportRequired()
	{
		return this.transportrequired;
	}
	public void setTransportRequired(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.transportrequired = value;
	}
	public boolean getTransportIsNotNull()
	{
		return this.transport != null;
	}
	public ims.scheduling.vo.lookups.ApptTransportType getTransport()
	{
		return this.transport;
	}
	public void setTransport(ims.scheduling.vo.lookups.ApptTransportType value)
	{
		this.isValidated = false;
		this.transport = value;
	}
	public boolean getAuthoringUserIsNotNull()
	{
		return this.authoringuser != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.authoringuser = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getCopyDischargeToPatientIsNotNull()
	{
		return this.copydischargetopatient != null;
	}
	public Boolean getCopyDischargeToPatient()
	{
		return this.copydischargetopatient;
	}
	public void setCopyDischargeToPatient(Boolean value)
	{
		this.isValidated = false;
		this.copydischargetopatient = value;
	}
	public boolean getPCTIsNotNull()
	{
		return this.pct != null;
	}
	public String getPCT()
	{
		return this.pct;
	}
	public static int getPCTMaxLength()
	{
		return 25;
	}
	public void setPCT(String value)
	{
		this.isValidated = false;
		this.pct = value;
	}
	public boolean getFunctionIsNotNull()
	{
		return this.function != null;
	}
	public ims.core.vo.ServiceFunctionLiteVo getFunction()
	{
		return this.function;
	}
	public void setFunction(ims.core.vo.ServiceFunctionLiteVo value)
	{
		this.isValidated = false;
		this.function = value;
	}
	public boolean getOtherLanguageIsNotNull()
	{
		return this.otherlanguage != null;
	}
	public String getOtherLanguage()
	{
		return this.otherlanguage;
	}
	public static int getOtherLanguageMaxLength()
	{
		return 255;
	}
	public void setOtherLanguage(String value)
	{
		this.isValidated = false;
		this.otherlanguage = value;
	}
	public boolean getSpecialRequirementsIsNotNull()
	{
		return this.specialrequirements != null;
	}
	public String getSpecialRequirements()
	{
		return this.specialrequirements;
	}
	public static int getSpecialRequirementsMaxLength()
	{
		return 255;
	}
	public void setSpecialRequirements(String value)
	{
		this.isValidated = false;
		this.specialrequirements = value;
	}
	public boolean getIsDADReferralIsNotNull()
	{
		return this.isdadreferral != null;
	}
	public Boolean getIsDADReferral()
	{
		return this.isdadreferral;
	}
	public void setIsDADReferral(Boolean value)
	{
		this.isValidated = false;
		this.isdadreferral = value;
	}
	public boolean getDadUbrnIsNotNull()
	{
		return this.dadubrn != null;
	}
	public String getDadUbrn()
	{
		return this.dadubrn;
	}
	public static int getDadUbrnMaxLength()
	{
		return 50;
	}
	public void setDadUbrn(String value)
	{
		this.isValidated = false;
		this.dadubrn = value;
	}
	public boolean getPracticeIsNotNull()
	{
		return this.practice != null;
	}
	public ims.core.vo.OrganisationWithSitesVo getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.vo.OrganisationWithSitesVo value)
	{
		this.isValidated = false;
		this.practice = value;
	}
	public boolean getIsReferrerPatientsGpIsNotNull()
	{
		return this.isreferrerpatientsgp != null;
	}
	public Boolean getIsReferrerPatientsGp()
	{
		return this.isreferrerpatientsgp;
	}
	public void setIsReferrerPatientsGp(Boolean value)
	{
		this.isValidated = false;
		this.isreferrerpatientsgp = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getEndDateKPIIsNotNull()
	{
		return this.enddatekpi != null;
	}
	public ims.framework.utils.Date getEndDateKPI()
	{
		return this.enddatekpi;
	}
	public void setEndDateKPI(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddatekpi = value;
	}
	public boolean getEndDateEmailKPIIsNotNull()
	{
		return this.enddateemailkpi != null;
	}
	public ims.framework.utils.Date getEndDateEmailKPI()
	{
		return this.enddateemailkpi;
	}
	public void setEndDateEmailKPI(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddateemailkpi = value;
	}
	public boolean getEndDatePaperKPIIsNotNull()
	{
		return this.enddatepaperkpi != null;
	}
	public ims.framework.utils.Date getEndDatePaperKPI()
	{
		return this.enddatepaperkpi;
	}
	public void setEndDatePaperKPI(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddatepaperkpi = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.vo.EpisodeofCareShortVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.EpisodeofCareShortVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getTransportRequirementsIsNotNull()
	{
		return this.transportrequirements != null;
	}
	public ims.core.vo.PatientTransportRequirementsVo getTransportRequirements()
	{
		return this.transportrequirements;
	}
	public void setTransportRequirements(ims.core.vo.PatientTransportRequirementsVo value)
	{
		this.isValidated = false;
		this.transportrequirements = value;
	}
	public boolean getReferringConsultantIsNotNull()
	{
		return this.referringconsultant != null;
	}
	public ims.core.vo.Hcp getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.referringconsultant = value;
	}
	public boolean getOriginalDateOfReferralIsNotNull()
	{
		return this.originaldateofreferral != null;
	}
	public ims.framework.utils.Date getOriginalDateOfReferral()
	{
		return this.originaldateofreferral;
	}
	public void setOriginalDateOfReferral(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.originaldateofreferral = value;
	}
	public boolean getRefererAddressIsNotNull()
	{
		return this.refereraddress != null;
	}
	public String getRefererAddress()
	{
		return this.refereraddress;
	}
	public static int getRefererAddressMaxLength()
	{
		return 500;
	}
	public void setRefererAddress(String value)
	{
		this.isValidated = false;
		this.refereraddress = value;
	}
	public boolean getTransferedBYIsNotNull()
	{
		return this.transferedby != null;
	}
	public String getTransferedBY()
	{
		return this.transferedby;
	}
	public static int getTransferedBYMaxLength()
	{
		return 100;
	}
	public void setTransferedBY(String value)
	{
		this.isValidated = false;
		this.transferedby = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringuser != null)
		{
			if(!this.authoringuser.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.practice != null)
		{
			if(!this.practice.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.transportrequirements != null)
		{
			if(!this.transportrequirements.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.alliedhealthprofname != null)
			if(this.alliedhealthprofname.length() > 150)
				listOfErrors.add("The length of the field [alliedhealthprofname] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 150");
		if(this.dateofreferral == null)
			listOfErrors.add("DateOfReferral is mandatory");
		if(this.end18ww == null)
			listOfErrors.add("RTT Breach Date is mandatory");
		if(this.authoringuser != null)
		{
			String[] listOfOtherErrors = this.authoringuser.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.pct == null || this.pct.length() == 0)
			listOfErrors.add("PCT is mandatory");
		else if(this.pct.length() > 25)
			listOfErrors.add("The length of the field [pct] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 25");
		if(this.otherlanguage != null)
			if(this.otherlanguage.length() > 255)
				listOfErrors.add("The length of the field [otherlanguage] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 255");
		if(this.specialrequirements != null)
			if(this.specialrequirements.length() > 255)
				listOfErrors.add("The length of the field [specialrequirements] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 255");
		if(this.dadubrn != null)
			if(this.dadubrn.length() > 50)
				listOfErrors.add("The length of the field [dadubrn] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 50");
		if(this.practice != null)
		{
			String[] listOfOtherErrors = this.practice.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.transportrequirements != null)
		{
			String[] listOfOtherErrors = this.transportrequirements.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.refereraddress != null)
			if(this.refereraddress.length() > 500)
				listOfErrors.add("The length of the field [refereraddress] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 500");
		if(this.transferedby != null)
			if(this.transferedby.length() > 100)
				listOfErrors.add("The length of the field [transferedby] in the value object [ims.clinical.vo.ReferralLetterDetailsVo] is too big. It should be less or equal to 100");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ReferralLetterDetailsVo clone = new ReferralLetterDetailsVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.referrertype == null)
			clone.referrertype = null;
		else
			clone.referrertype = (ims.core.vo.lookups.SourceOfReferral)this.referrertype.clone();
		if(this.gpname == null)
			clone.gpname = null;
		else
			clone.gpname = (ims.core.vo.GpLiteVo)this.gpname.clone();
		clone.alliedhealthprofname = this.alliedhealthprofname;
		if(this.dateofreferral == null)
			clone.dateofreferral = null;
		else
			clone.dateofreferral = (ims.framework.utils.Date)this.dateofreferral.clone();
		if(this.datereferralreceived == null)
			clone.datereferralreceived = null;
		else
			clone.datereferralreceived = (ims.framework.utils.Date)this.datereferralreceived.clone();
		if(this.end18ww == null)
			clone.end18ww = null;
		else
			clone.end18ww = (ims.framework.utils.Date)this.end18ww.clone();
		if(this.interpreterrequired == null)
			clone.interpreterrequired = null;
		else
			clone.interpreterrequired = (ims.core.vo.lookups.YesNo)this.interpreterrequired.clone();
		if(this.language == null)
			clone.language = null;
		else
			clone.language = (ims.core.vo.lookups.Language)this.language.clone();
		if(this.transportrequired == null)
			clone.transportrequired = null;
		else
			clone.transportrequired = (ims.core.vo.lookups.YesNo)this.transportrequired.clone();
		if(this.transport == null)
			clone.transport = null;
		else
			clone.transport = (ims.scheduling.vo.lookups.ApptTransportType)this.transport.clone();
		if(this.authoringuser == null)
			clone.authoringuser = null;
		else
			clone.authoringuser = (ims.core.vo.MemberOfStaffLiteVo)this.authoringuser.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		clone.copydischargetopatient = this.copydischargetopatient;
		clone.pct = this.pct;
		if(this.function == null)
			clone.function = null;
		else
			clone.function = (ims.core.vo.ServiceFunctionLiteVo)this.function.clone();
		clone.otherlanguage = this.otherlanguage;
		clone.specialrequirements = this.specialrequirements;
		clone.isdadreferral = this.isdadreferral;
		clone.dadubrn = this.dadubrn;
		if(this.practice == null)
			clone.practice = null;
		else
			clone.practice = (ims.core.vo.OrganisationWithSitesVo)this.practice.clone();
		clone.isreferrerpatientsgp = this.isreferrerpatientsgp;
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
		if(this.enddatekpi == null)
			clone.enddatekpi = null;
		else
			clone.enddatekpi = (ims.framework.utils.Date)this.enddatekpi.clone();
		if(this.enddateemailkpi == null)
			clone.enddateemailkpi = null;
		else
			clone.enddateemailkpi = (ims.framework.utils.Date)this.enddateemailkpi.clone();
		if(this.enddatepaperkpi == null)
			clone.enddatepaperkpi = null;
		else
			clone.enddatepaperkpi = (ims.framework.utils.Date)this.enddatepaperkpi.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeofCareShortVo)this.episodeofcare.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		if(this.transportrequirements == null)
			clone.transportrequirements = null;
		else
			clone.transportrequirements = (ims.core.vo.PatientTransportRequirementsVo)this.transportrequirements.clone();
		if(this.referringconsultant == null)
			clone.referringconsultant = null;
		else
			clone.referringconsultant = (ims.core.vo.Hcp)this.referringconsultant.clone();
		if(this.originaldateofreferral == null)
			clone.originaldateofreferral = null;
		else
			clone.originaldateofreferral = (ims.framework.utils.Date)this.originaldateofreferral.clone();
		clone.refereraddress = this.refereraddress;
		clone.transferedby = this.transferedby;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ReferralLetterDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralLetterDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralLetterDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralLetterDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.referrertype != null)
			count++;
		if(this.gpname != null)
			count++;
		if(this.alliedhealthprofname != null)
			count++;
		if(this.dateofreferral != null)
			count++;
		if(this.datereferralreceived != null)
			count++;
		if(this.end18ww != null)
			count++;
		if(this.interpreterrequired != null)
			count++;
		if(this.language != null)
			count++;
		if(this.transportrequired != null)
			count++;
		if(this.transport != null)
			count++;
		if(this.authoringuser != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.copydischargetopatient != null)
			count++;
		if(this.pct != null)
			count++;
		if(this.function != null)
			count++;
		if(this.otherlanguage != null)
			count++;
		if(this.specialrequirements != null)
			count++;
		if(this.isdadreferral != null)
			count++;
		if(this.dadubrn != null)
			count++;
		if(this.practice != null)
			count++;
		if(this.isreferrerpatientsgp != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.location != null)
			count++;
		if(this.enddatekpi != null)
			count++;
		if(this.enddateemailkpi != null)
			count++;
		if(this.enddatepaperkpi != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.transportrequirements != null)
			count++;
		if(this.referringconsultant != null)
			count++;
		if(this.originaldateofreferral != null)
			count++;
		if(this.refereraddress != null)
			count++;
		if(this.transferedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 34;
	}
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.lookups.SourceOfReferral referrertype;
	protected ims.core.vo.GpLiteVo gpname;
	protected String alliedhealthprofname;
	protected ims.framework.utils.Date dateofreferral;
	protected ims.framework.utils.Date datereferralreceived;
	protected ims.framework.utils.Date end18ww;
	protected ims.core.vo.lookups.YesNo interpreterrequired;
	protected ims.core.vo.lookups.Language language;
	protected ims.core.vo.lookups.YesNo transportrequired;
	protected ims.scheduling.vo.lookups.ApptTransportType transport;
	protected ims.core.vo.MemberOfStaffLiteVo authoringuser;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected Boolean copydischargetopatient;
	protected String pct;
	protected ims.core.vo.ServiceFunctionLiteVo function;
	protected String otherlanguage;
	protected String specialrequirements;
	protected Boolean isdadreferral;
	protected String dadubrn;
	protected ims.core.vo.OrganisationWithSitesVo practice;
	protected Boolean isreferrerpatientsgp;
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.core.vo.LocationLiteVo location;
	protected ims.framework.utils.Date enddatekpi;
	protected ims.framework.utils.Date enddateemailkpi;
	protected ims.framework.utils.Date enddatepaperkpi;
	protected ims.core.vo.EpisodeofCareShortVo episodeofcare;
	protected ims.core.vo.HcpLiteVo consultant;
	protected ims.core.vo.PatientTransportRequirementsVo transportrequirements;
	protected ims.core.vo.Hcp referringconsultant;
	protected ims.framework.utils.Date originaldateofreferral;
	protected String refereraddress;
	protected String transferedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
