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

public class EMISMedicationVoBean extends ims.vo.ValueObjectBean
{
	public EMISMedicationVoBean()
	{
	}
	public EMISMedicationVoBean(ims.clinical.vo.EMISMedicationVo vo)
	{
		this.drugrecord = vo.getDrugRecord();
		this.mostrecentissuedate = vo.getMostRecentIssueDate();
		this.prescriptiontype = vo.getPrescriptionType();
		this.drugname = vo.getDrugName();
		this.originalterm = vo.getOriginalTerm();
		this.dosage = vo.getDosage();
		this.quantityrepresentation = vo.getQuantityRepresentation();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.EMISMedicationVo vo)
	{
		this.drugrecord = vo.getDrugRecord();
		this.mostrecentissuedate = vo.getMostRecentIssueDate();
		this.prescriptiontype = vo.getPrescriptionType();
		this.drugname = vo.getDrugName();
		this.originalterm = vo.getOriginalTerm();
		this.dosage = vo.getDosage();
		this.quantityrepresentation = vo.getQuantityRepresentation();
	}

	public ims.clinical.vo.EMISMedicationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.EMISMedicationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.EMISMedicationVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.EMISMedicationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.EMISMedicationVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getDrugRecord()
	{
		return this.drugrecord;
	}
	public void setDrugRecord(String value)
	{
		this.drugrecord = value;
	}
	public String getMostRecentIssueDate()
	{
		return this.mostrecentissuedate;
	}
	public void setMostRecentIssueDate(String value)
	{
		this.mostrecentissuedate = value;
	}
	public String getPrescriptionType()
	{
		return this.prescriptiontype;
	}
	public void setPrescriptionType(String value)
	{
		this.prescriptiontype = value;
	}
	public String getDrugName()
	{
		return this.drugname;
	}
	public void setDrugName(String value)
	{
		this.drugname = value;
	}
	public String getOriginalTerm()
	{
		return this.originalterm;
	}
	public void setOriginalTerm(String value)
	{
		this.originalterm = value;
	}
	public String getDosage()
	{
		return this.dosage;
	}
	public void setDosage(String value)
	{
		this.dosage = value;
	}
	public String getQuantityRepresentation()
	{
		return this.quantityrepresentation;
	}
	public void setQuantityRepresentation(String value)
	{
		this.quantityrepresentation = value;
	}

	private String drugrecord;
	private String mostrecentissuedate;
	private String prescriptiontype;
	private String drugname;
	private String originalterm;
	private String dosage;
	private String quantityrepresentation;
}
