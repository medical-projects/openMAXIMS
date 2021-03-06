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

package ims.ocs_if.vo.beans;

public class IfOutOcsOrderVoBean extends ims.vo.ValueObjectBean
{
	public IfOutOcsOrderVoBean()
	{
	}
	public IfOutOcsOrderVoBean(ims.ocs_if.vo.IfOutOcsOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.orderedby = vo.getOrderedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getOrderedBy().getBean();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleClinician().getBean();
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpShortVoBean)vo.getResponsibleGp().getBean();
		this.clinicaltrial = vo.getClinicalTrial();
		this.clinicaltrialtxt = vo.getClinicalTrialTxt();
		this.additclinnotes = vo.getAdditClinNotes();
		this.patmobility = vo.getPatMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatMobility().getBean();
		this.ordercategory = vo.getOrderCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderCategory().getBean();
		this.specimens = vo.getSpecimens() == null ? null : vo.getSpecimens().getBeanCollection();
		this.wasprocessed = vo.getWasProcessed();
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getPatientLocation().getBean();
		this.reportto = vo.getReportTo() == null ? null : vo.getReportTo().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontextpas = vo.getCareContextPas() == null ? null : (ims.core.vo.beans.CareContextPasVoBean)vo.getCareContextPas().getBean();
		this.orderinghospital = vo.getOrderingHospital() == null ? null : new ims.vo.RefVoBean(vo.getOrderingHospital().getBoId(), vo.getOrderingHospital().getBoVersion());
		this.sendnumber = vo.getSendNumber();
		this.outpatientdept = vo.getOutpatientDept() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getOutpatientDept().getBean();
		this.summaryclinicalinformation = vo.getSummaryClinicalInformation();
		this.bleepextnumber = vo.getBleepExtNumber();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfOutOcsOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.orderedby = vo.getOrderedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getOrderedBy().getBean(map);
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpBean)vo.getResponsibleClinician().getBean(map);
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpShortVoBean)vo.getResponsibleGp().getBean(map);
		this.clinicaltrial = vo.getClinicalTrial();
		this.clinicaltrialtxt = vo.getClinicalTrialTxt();
		this.additclinnotes = vo.getAdditClinNotes();
		this.patmobility = vo.getPatMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatMobility().getBean();
		this.ordercategory = vo.getOrderCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderCategory().getBean();
		this.specimens = vo.getSpecimens() == null ? null : vo.getSpecimens().getBeanCollection();
		this.wasprocessed = vo.getWasProcessed();
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getPatientLocation().getBean(map);
		this.reportto = vo.getReportTo() == null ? null : vo.getReportTo().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontextpas = vo.getCareContextPas() == null ? null : (ims.core.vo.beans.CareContextPasVoBean)vo.getCareContextPas().getBean(map);
		this.orderinghospital = vo.getOrderingHospital() == null ? null : new ims.vo.RefVoBean(vo.getOrderingHospital().getBoId(), vo.getOrderingHospital().getBoVersion());
		this.sendnumber = vo.getSendNumber();
		this.outpatientdept = vo.getOutpatientDept() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getOutpatientDept().getBean(map);
		this.summaryclinicalinformation = vo.getSummaryClinicalInformation();
		this.bleepextnumber = vo.getBleepExtNumber();
	}

	public ims.ocs_if.vo.IfOutOcsOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfOutOcsOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfOutOcsOrderVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfOutOcsOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfOutOcsOrderVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] value)
	{
		this.investigations = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getOrderedBy()
	{
		return this.orderedby;
	}
	public void setOrderedBy(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.orderedby = value;
	}
	public ims.core.vo.beans.HcpBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.core.vo.beans.GpShortVoBean getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.core.vo.beans.GpShortVoBean value)
	{
		this.responsiblegp = value;
	}
	public Boolean getClinicalTrial()
	{
		return this.clinicaltrial;
	}
	public void setClinicalTrial(Boolean value)
	{
		this.clinicaltrial = value;
	}
	public String getClinicalTrialTxt()
	{
		return this.clinicaltrialtxt;
	}
	public void setClinicalTrialTxt(String value)
	{
		this.clinicaltrialtxt = value;
	}
	public String getAdditClinNotes()
	{
		return this.additclinnotes;
	}
	public void setAdditClinNotes(String value)
	{
		this.additclinnotes = value;
	}
	public ims.vo.LookupInstanceBean getPatMobility()
	{
		return this.patmobility;
	}
	public void setPatMobility(ims.vo.LookupInstanceBean value)
	{
		this.patmobility = value;
	}
	public ims.vo.LookupInstanceBean getOrderCategory()
	{
		return this.ordercategory;
	}
	public void setOrderCategory(ims.vo.LookupInstanceBean value)
	{
		this.ordercategory = value;
	}
	public ims.ocs_if.vo.beans.IfOrderSpecimenVoBean[] getSpecimens()
	{
		return this.specimens;
	}
	public void setSpecimens(ims.ocs_if.vo.beans.IfOrderSpecimenVoBean[] value)
	{
		this.specimens = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.patientclinic = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.ocrr.vo.beans.OcsReportToVoBean[] getReportTo()
	{
		return this.reportto;
	}
	public void setReportTo(ims.ocrr.vo.beans.OcsReportToVoBean[] value)
	{
		this.reportto = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.CareContextPasVoBean getCareContextPas()
	{
		return this.carecontextpas;
	}
	public void setCareContextPas(ims.core.vo.beans.CareContextPasVoBean value)
	{
		this.carecontextpas = value;
	}
	public ims.vo.RefVoBean getOrderingHospital()
	{
		return this.orderinghospital;
	}
	public void setOrderingHospital(ims.vo.RefVoBean value)
	{
		this.orderinghospital = value;
	}
	public Boolean getSendNumber()
	{
		return this.sendnumber;
	}
	public void setSendNumber(Boolean value)
	{
		this.sendnumber = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getOutpatientDept()
	{
		return this.outpatientdept;
	}
	public void setOutpatientDept(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.outpatientdept = value;
	}
	public String getSummaryClinicalInformation()
	{
		return this.summaryclinicalinformation;
	}
	public void setSummaryClinicalInformation(String value)
	{
		this.summaryclinicalinformation = value;
	}
	public String getBleepExtNumber()
	{
		return this.bleepextnumber;
	}
	public void setBleepExtNumber(String value)
	{
		this.bleepextnumber = value;
	}

	private Integer id;
	private int version;
	private ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] investigations;
	private ims.core.vo.beans.MemberOfStaffShortVoBean orderedby;
	private ims.core.vo.beans.HcpBean responsibleclinician;
	private ims.core.vo.beans.GpShortVoBean responsiblegp;
	private Boolean clinicaltrial;
	private String clinicaltrialtxt;
	private String additclinnotes;
	private ims.vo.LookupInstanceBean patmobility;
	private ims.vo.LookupInstanceBean ordercategory;
	private ims.ocs_if.vo.beans.IfOrderSpecimenVoBean[] specimens;
	private Boolean wasprocessed;
	private ims.core.vo.beans.ClinicLiteVoBean patientclinic;
	private ims.core.vo.beans.LocShortMappingsVoBean patientlocation;
	private ims.ocrr.vo.beans.OcsReportToVoBean[] reportto;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.CareContextPasVoBean carecontextpas;
	private ims.vo.RefVoBean orderinghospital;
	private Boolean sendnumber;
	private ims.core.vo.beans.LocShortMappingsVoBean outpatientdept;
	private String summaryclinicalinformation;
	private String bleepextnumber;
}
