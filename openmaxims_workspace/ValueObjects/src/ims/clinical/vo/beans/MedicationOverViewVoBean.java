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

public class MedicationOverViewVoBean extends ims.vo.ValueObjectBean
{
	public MedicationOverViewVoBean()
	{
	}
	public MedicationOverViewVoBean(ims.clinical.vo.MedicationOverViewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.medication = vo.getMedication() == null ? null : vo.getMedication().getBeanCollection();
		this.correctness = vo.getCorrectness() == null ? null : (ims.vo.LookupInstanceBean)vo.getCorrectness().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.MedicationOverViewVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.medication = vo.getMedication() == null ? null : vo.getMedication().getBeanCollection();
		this.correctness = vo.getCorrectness() == null ? null : (ims.vo.LookupInstanceBean)vo.getCorrectness().getBean();
	}

	public ims.clinical.vo.MedicationOverViewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.MedicationOverViewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.MedicationOverViewVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.MedicationOverViewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.MedicationOverViewVo();
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
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.PatientMedicationVoBean[] getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.core.vo.beans.PatientMedicationVoBean[] value)
	{
		this.medication = value;
	}
	public ims.vo.LookupInstanceBean getCorrectness()
	{
		return this.correctness;
	}
	public void setCorrectness(ims.vo.LookupInstanceBean value)
	{
		this.correctness = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.PatientMedicationVoBean[] medication;
	private ims.vo.LookupInstanceBean correctness;
}
