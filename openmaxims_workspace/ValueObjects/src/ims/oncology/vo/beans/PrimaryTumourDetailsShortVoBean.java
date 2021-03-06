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

package ims.oncology.vo.beans;

public class PrimaryTumourDetailsShortVoBean extends ims.vo.ValueObjectBean
{
	public PrimaryTumourDetailsShortVoBean()
	{
	}
	public PrimaryTumourDetailsShortVoBean(ims.oncology.vo.PrimaryTumourDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.tumourgroup = vo.getTumourGroup() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean)vo.getTumourGroup().getBean();
		this.tumoursite = vo.getTumourSite() == null ? null : (ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean)vo.getTumourSite().getBean();
		this.tumourlaterality = vo.getTumourLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTumourLaterality().getBean();
		this.iscurrent = vo.getIsCurrent();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.patientdiagnosis = vo.getPatientDiagnosis() == null ? null : (ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean)vo.getPatientDiagnosis().getBean();
		this.pretreatmentoverall = vo.getPreTreatmentOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean)vo.getPreTreatmentOverall().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.tumourhistology = vo.getTumourHistology() == null ? null : (ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean)vo.getTumourHistology().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.PrimaryTumourDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.tumourgroup = vo.getTumourGroup() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean)vo.getTumourGroup().getBean(map);
		this.tumoursite = vo.getTumourSite() == null ? null : (ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean)vo.getTumourSite().getBean(map);
		this.tumourlaterality = vo.getTumourLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTumourLaterality().getBean();
		this.iscurrent = vo.getIsCurrent();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.patientdiagnosis = vo.getPatientDiagnosis() == null ? null : (ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean)vo.getPatientDiagnosis().getBean(map);
		this.pretreatmentoverall = vo.getPreTreatmentOverall() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean)vo.getPreTreatmentOverall().getBean(map);
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.tumourhistology = vo.getTumourHistology() == null ? null : (ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean)vo.getTumourHistology().getBean(map);
	}

	public ims.oncology.vo.PrimaryTumourDetailsShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.PrimaryTumourDetailsShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.PrimaryTumourDetailsShortVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.PrimaryTumourDetailsShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.PrimaryTumourDetailsShortVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean getTumourGroup()
	{
		return this.tumourgroup;
	}
	public void setTumourGroup(ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean value)
	{
		this.tumourgroup = value;
	}
	public ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean getTumourSite()
	{
		return this.tumoursite;
	}
	public void setTumourSite(ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean value)
	{
		this.tumoursite = value;
	}
	public ims.vo.LookupInstanceBean getTumourLaterality()
	{
		return this.tumourlaterality;
	}
	public void setTumourLaterality(ims.vo.LookupInstanceBean value)
	{
		this.tumourlaterality = value;
	}
	public Boolean getIsCurrent()
	{
		return this.iscurrent;
	}
	public void setIsCurrent(Boolean value)
	{
		this.iscurrent = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean getPatientDiagnosis()
	{
		return this.patientdiagnosis;
	}
	public void setPatientDiagnosis(ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean value)
	{
		this.patientdiagnosis = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean getPreTreatmentOverall()
	{
		return this.pretreatmentoverall;
	}
	public void setPreTreatmentOverall(ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean value)
	{
		this.pretreatmentoverall = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean getTumourHistology()
	{
		return this.tumourhistology;
	}
	public void setTumourHistology(ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean value)
	{
		this.tumourhistology = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.clinicaladmin.vo.beans.TumourGroupLiteVoBean tumourgroup;
	private ims.clinicaladmin.vo.beans.TumourSiteLiteVoBean tumoursite;
	private ims.vo.LookupInstanceBean tumourlaterality;
	private Boolean iscurrent;
	private ims.framework.utils.beans.DateBean enddate;
	private ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean patientdiagnosis;
	private ims.clinicaladmin.vo.beans.TumourGroupSiteOverallStagingVoBean pretreatmentoverall;
	private ims.vo.RefVoBean episodeofcare;
	private ims.clinicaladmin.vo.beans.TumourHistologyLiteVoBean tumourhistology;
}
