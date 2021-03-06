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

package ims.core.vo.beans;

public class PatientDocumentforDocumentWorklistVoBean extends ims.vo.ValueObjectBean
{
	public PatientDocumentforDocumentWorklistVoBean()
	{
	}
	public PatientDocumentforDocumentWorklistVoBean(ims.core.vo.PatientDocumentforDocumentWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean();
		this.currentdocumentstatus = vo.getCurrentDocumentStatus() == null ? null : (ims.core.vo.beans.PatientDocumentStatusVoBean)vo.getCurrentDocumentStatus().getBean();
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForDocumentWorklistVoBean)vo.getPatient().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean();
		this.noofcopies = vo.getNoOfCopies();
		this.name = vo.getName();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean();
		this.wasprinted = vo.getWasPrinted();
		this.emailstatus = vo.getEmailStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getEmailStatus().getBean();
		this.copypatientoncorrespondence = vo.getCopyPatientOnCorrespondence();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDocumentforDocumentWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean(map);
		this.currentdocumentstatus = vo.getCurrentDocumentStatus() == null ? null : (ims.core.vo.beans.PatientDocumentStatusVoBean)vo.getCurrentDocumentStatus().getBean(map);
		this.documentdate = vo.getDocumentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDocumentDate().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientForDocumentWorklistVoBean)vo.getPatient().getBean(map);
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean(map);
		this.noofcopies = vo.getNoOfCopies();
		this.name = vo.getName();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean(map);
		this.wasprinted = vo.getWasPrinted();
		this.emailstatus = vo.getEmailStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getEmailStatus().getBean();
		this.copypatientoncorrespondence = vo.getCopyPatientOnCorrespondence();
	}

	public ims.core.vo.PatientDocumentforDocumentWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDocumentforDocumentWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDocumentforDocumentWorklistVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDocumentforDocumentWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDocumentforDocumentWorklistVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.core.vo.beans.PatientDocumentStatusVoBean getCurrentDocumentStatus()
	{
		return this.currentdocumentstatus;
	}
	public void setCurrentDocumentStatus(ims.core.vo.beans.PatientDocumentStatusVoBean value)
	{
		this.currentdocumentstatus = value;
	}
	public ims.framework.utils.beans.DateBean getDocumentDate()
	{
		return this.documentdate;
	}
	public void setDocumentDate(ims.framework.utils.beans.DateBean value)
	{
		this.documentdate = value;
	}
	public ims.core.vo.beans.PatientForDocumentWorklistVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientForDocumentWorklistVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.recordinguser = value;
	}
	public Integer getNoOfCopies()
	{
		return this.noofcopies;
	}
	public void setNoOfCopies(Integer value)
	{
		this.noofcopies = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.wasprinted = value;
	}
	public ims.vo.LookupInstanceBean getEmailStatus()
	{
		return this.emailstatus;
	}
	public void setEmailStatus(ims.vo.LookupInstanceBean value)
	{
		this.emailstatus = value;
	}
	public Boolean getCopyPatientOnCorrespondence()
	{
		return this.copypatientoncorrespondence;
	}
	public void setCopyPatientOnCorrespondence(Boolean value)
	{
		this.copypatientoncorrespondence = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean authoringhcp;
	private ims.core.vo.beans.PatientDocumentStatusVoBean currentdocumentstatus;
	private ims.framework.utils.beans.DateBean documentdate;
	private ims.core.vo.beans.PatientForDocumentWorklistVoBean patient;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean recordinguser;
	private Integer noofcopies;
	private String name;
	private ims.vo.LookupInstanceBean category;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private Boolean wasprinted;
	private ims.vo.LookupInstanceBean emailstatus;
	private Boolean copypatientoncorrespondence;
}
