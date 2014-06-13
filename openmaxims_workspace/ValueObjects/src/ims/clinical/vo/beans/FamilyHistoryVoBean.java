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

package ims.clinical.vo.beans;

public class FamilyHistoryVoBean extends ims.vo.ValueObjectBean
{
	public FamilyHistoryVoBean()
	{
	}
	public FamilyHistoryVoBean(ims.clinical.vo.FamilyHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.relativename = vo.getRelativeName();
		this.relativedob = vo.getRelativeDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getRelativeDOB().getBean();
		this.ageatonset = vo.getAgeAtOnset();
		this.relativeliving = vo.getRelativeLiving() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelativeLiving().getBean();
		this.ageatdeath = vo.getAgeAtDeath();
		this.notes = vo.getNotes();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.FamilyHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.relativename = vo.getRelativeName();
		this.relativedob = vo.getRelativeDOB() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getRelativeDOB().getBean();
		this.ageatonset = vo.getAgeAtOnset();
		this.relativeliving = vo.getRelativeLiving() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelativeLiving().getBean();
		this.ageatdeath = vo.getAgeAtDeath();
		this.notes = vo.getNotes();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean(map);
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.FamilyHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.FamilyHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.FamilyHistoryVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.FamilyHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.FamilyHistoryVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.LookupInstanceBean getRelationship()
	{
		return this.relationship;
	}
	public void setRelationship(ims.vo.LookupInstanceBean value)
	{
		this.relationship = value;
	}
	public String getRelativeName()
	{
		return this.relativename;
	}
	public void setRelativeName(String value)
	{
		this.relativename = value;
	}
	public ims.framework.utils.beans.PartialDateBean getRelativeDOB()
	{
		return this.relativedob;
	}
	public void setRelativeDOB(ims.framework.utils.beans.PartialDateBean value)
	{
		this.relativedob = value;
	}
	public Integer getAgeAtOnset()
	{
		return this.ageatonset;
	}
	public void setAgeAtOnset(Integer value)
	{
		this.ageatonset = value;
	}
	public ims.vo.LookupInstanceBean getRelativeLiving()
	{
		return this.relativeliving;
	}
	public void setRelativeLiving(ims.vo.LookupInstanceBean value)
	{
		this.relativeliving = value;
	}
	public Integer getAgeAtDeath()
	{
		return this.ageatdeath;
	}
	public void setAgeAtDeath(Integer value)
	{
		this.ageatdeath = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.core.vo.beans.DiagLiteVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.DiagLiteVoBean value)
	{
		this.diagnosis = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.vo.LookupInstanceBean relationship;
	private String relativename;
	private ims.framework.utils.beans.PartialDateBean relativedob;
	private Integer ageatonset;
	private ims.vo.LookupInstanceBean relativeliving;
	private Integer ageatdeath;
	private String notes;
	private ims.core.vo.beans.DiagLiteVoBean diagnosis;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private String diagnosisdescription;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean carecontext;
}
