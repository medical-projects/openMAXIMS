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

package ims.coe.vo.beans;

public class PatientMovementDetailsBean extends ims.vo.ValueObjectBean
{
	public PatientMovementDetailsBean()
	{
	}
	public PatientMovementDetailsBean(ims.coe.vo.PatientMovementDetails vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movement = vo.getMovement() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovement().getBean();
		this.mechanicalequipment = vo.getMechanicalEquipment() == null ? null : (ims.vo.LookupInstanceBean)vo.getMechanicalEquipment().getBean();
		this.equipmentother = vo.getEquipmentOther() == null ? null : (ims.vo.LookupInstanceBean)vo.getEquipmentOther().getBean();
		this.numberofstaff = vo.getNumberOfStaff();
		this.details = vo.getDetails();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.PatientMovementDetails vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movement = vo.getMovement() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovement().getBean();
		this.mechanicalequipment = vo.getMechanicalEquipment() == null ? null : (ims.vo.LookupInstanceBean)vo.getMechanicalEquipment().getBean();
		this.equipmentother = vo.getEquipmentOther() == null ? null : (ims.vo.LookupInstanceBean)vo.getEquipmentOther().getBean();
		this.numberofstaff = vo.getNumberOfStaff();
		this.details = vo.getDetails();
	}

	public ims.coe.vo.PatientMovementDetails buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.PatientMovementDetails buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.PatientMovementDetails vo = null;
		if(map != null)
			vo = (ims.coe.vo.PatientMovementDetails)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.PatientMovementDetails();
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
	public ims.vo.LookupInstanceBean getMovement()
	{
		return this.movement;
	}
	public void setMovement(ims.vo.LookupInstanceBean value)
	{
		this.movement = value;
	}
	public ims.vo.LookupInstanceBean getMechanicalEquipment()
	{
		return this.mechanicalequipment;
	}
	public void setMechanicalEquipment(ims.vo.LookupInstanceBean value)
	{
		this.mechanicalequipment = value;
	}
	public ims.vo.LookupInstanceBean getEquipmentOther()
	{
		return this.equipmentother;
	}
	public void setEquipmentOther(ims.vo.LookupInstanceBean value)
	{
		this.equipmentother = value;
	}
	public Integer getNumberOfStaff()
	{
		return this.numberofstaff;
	}
	public void setNumberOfStaff(Integer value)
	{
		this.numberofstaff = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean movement;
	private ims.vo.LookupInstanceBean mechanicalequipment;
	private ims.vo.LookupInstanceBean equipmentother;
	private Integer numberofstaff;
	private String details;
}
