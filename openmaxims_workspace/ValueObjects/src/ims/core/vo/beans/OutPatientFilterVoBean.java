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

public class OutPatientFilterVoBean extends ims.vo.ValueObjectBean
{
	public OutPatientFilterVoBean()
	{
	}
	public OutPatientFilterVoBean(ims.core.vo.OutPatientFilterVo vo)
	{
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getClinic().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getConsultant().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getSpecialty().getBean();
		this.clinicdatefrom = vo.getClinicDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDateFrom().getBean();
		this.clinicdateto = vo.getClinicDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDateTo().getBean();
		this.docstatus = vo.getDocStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.OutPatientFilterVo vo)
	{
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getClinic().getBean(map);
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getConsultant().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getSpecialty().getBean(map);
		this.clinicdatefrom = vo.getClinicDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDateFrom().getBean();
		this.clinicdateto = vo.getClinicDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDateTo().getBean();
		this.docstatus = vo.getDocStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocStatus().getBean();
	}

	public ims.core.vo.OutPatientFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.OutPatientFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.OutPatientFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.OutPatientFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.OutPatientFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.LocMostVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.beans.LocMostVoBean value)
	{
		this.clinic = value;
	}
	public ims.core.vo.beans.MedicVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicVoBean value)
	{
		this.consultant = value;
	}
	public ims.core.vo.beans.ServiceVoBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.beans.ServiceVoBean value)
	{
		this.specialty = value;
	}
	public ims.framework.utils.beans.DateBean getClinicDateFrom()
	{
		return this.clinicdatefrom;
	}
	public void setClinicDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.clinicdatefrom = value;
	}
	public ims.framework.utils.beans.DateBean getClinicDateTo()
	{
		return this.clinicdateto;
	}
	public void setClinicDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.clinicdateto = value;
	}
	public ims.vo.LookupInstanceBean getDocStatus()
	{
		return this.docstatus;
	}
	public void setDocStatus(ims.vo.LookupInstanceBean value)
	{
		this.docstatus = value;
	}

	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.LocMostVoBean clinic;
	private ims.core.vo.beans.MedicVoBean consultant;
	private ims.core.vo.beans.ServiceVoBean specialty;
	private ims.framework.utils.beans.DateBean clinicdatefrom;
	private ims.framework.utils.beans.DateBean clinicdateto;
	private ims.vo.LookupInstanceBean docstatus;
}
