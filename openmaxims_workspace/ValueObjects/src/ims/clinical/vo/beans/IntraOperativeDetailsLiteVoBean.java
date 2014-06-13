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

public class IntraOperativeDetailsLiteVoBean extends ims.vo.ValueObjectBean
{
	public IntraOperativeDetailsLiteVoBean()
	{
	}
	public IntraOperativeDetailsLiteVoBean(ims.clinical.vo.IntraOperativeDetailsLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.skinpreparationused = vo.getSkinPreparationUsed() == null ? null : vo.getSkinPreparationUsed().getBeanCollection();
		this.dressing = vo.getDressing() == null ? null : vo.getDressing().getBeanCollection();
		this.drains = vo.getDrains() == null ? null : (ims.clinical.vo.beans.DrainsVoBean)vo.getDrains().getBean();
		this.patientposition = vo.getPatientPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientPosition().getBean();
		this.specimentype = vo.getSpecimenType();
		this.histopathology = vo.getHistopathology();
		this.microbiology = vo.getMicrobiology();
		this.haematology = vo.getHaematology();
		this.cytology = vo.getCytology();
		this.otherskinpreparationused = vo.getOtherSkinPreparationUsed();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.IntraOperativeDetailsLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.skinpreparationused = vo.getSkinPreparationUsed() == null ? null : vo.getSkinPreparationUsed().getBeanCollection();
		this.dressing = vo.getDressing() == null ? null : vo.getDressing().getBeanCollection();
		this.drains = vo.getDrains() == null ? null : (ims.clinical.vo.beans.DrainsVoBean)vo.getDrains().getBean(map);
		this.patientposition = vo.getPatientPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientPosition().getBean();
		this.specimentype = vo.getSpecimenType();
		this.histopathology = vo.getHistopathology();
		this.microbiology = vo.getMicrobiology();
		this.haematology = vo.getHaematology();
		this.cytology = vo.getCytology();
		this.otherskinpreparationused = vo.getOtherSkinPreparationUsed();
	}

	public ims.clinical.vo.IntraOperativeDetailsLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.IntraOperativeDetailsLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.IntraOperativeDetailsLiteVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.IntraOperativeDetailsLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.IntraOperativeDetailsLiteVo();
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
	public java.util.Collection getSkinPreparationUsed()
	{
		return this.skinpreparationused;
	}
	public void setSkinPreparationUsed(java.util.Collection value)
	{
		this.skinpreparationused = value;
	}
	public void addSkinPreparationUsed(java.util.Collection value)
	{
		if(this.skinpreparationused == null)
			this.skinpreparationused = new java.util.ArrayList();
		this.skinpreparationused.add(value);
	}
	public java.util.Collection getDressing()
	{
		return this.dressing;
	}
	public void setDressing(java.util.Collection value)
	{
		this.dressing = value;
	}
	public void addDressing(java.util.Collection value)
	{
		if(this.dressing == null)
			this.dressing = new java.util.ArrayList();
		this.dressing.add(value);
	}
	public ims.clinical.vo.beans.DrainsVoBean getDrains()
	{
		return this.drains;
	}
	public void setDrains(ims.clinical.vo.beans.DrainsVoBean value)
	{
		this.drains = value;
	}
	public ims.vo.LookupInstanceBean getPatientPosition()
	{
		return this.patientposition;
	}
	public void setPatientPosition(ims.vo.LookupInstanceBean value)
	{
		this.patientposition = value;
	}
	public String getSpecimenType()
	{
		return this.specimentype;
	}
	public void setSpecimenType(String value)
	{
		this.specimentype = value;
	}
	public Boolean getHistopathology()
	{
		return this.histopathology;
	}
	public void setHistopathology(Boolean value)
	{
		this.histopathology = value;
	}
	public Boolean getMicrobiology()
	{
		return this.microbiology;
	}
	public void setMicrobiology(Boolean value)
	{
		this.microbiology = value;
	}
	public Boolean getHaematology()
	{
		return this.haematology;
	}
	public void setHaematology(Boolean value)
	{
		this.haematology = value;
	}
	public Boolean getCytology()
	{
		return this.cytology;
	}
	public void setCytology(Boolean value)
	{
		this.cytology = value;
	}
	public String getOtherSkinPreparationUsed()
	{
		return this.otherskinpreparationused;
	}
	public void setOtherSkinPreparationUsed(String value)
	{
		this.otherskinpreparationused = value;
	}

	private Integer id;
	private int version;
	private java.util.Collection skinpreparationused;
	private java.util.Collection dressing;
	private ims.clinical.vo.beans.DrainsVoBean drains;
	private ims.vo.LookupInstanceBean patientposition;
	private String specimentype;
	private Boolean histopathology;
	private Boolean microbiology;
	private Boolean haematology;
	private Boolean cytology;
	private String otherskinpreparationused;
}
