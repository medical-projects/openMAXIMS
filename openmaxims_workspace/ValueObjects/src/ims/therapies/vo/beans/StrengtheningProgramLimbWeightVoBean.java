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

package ims.therapies.vo.beans;

public class StrengtheningProgramLimbWeightVoBean extends ims.vo.ValueObjectBean
{
	public StrengtheningProgramLimbWeightVoBean()
	{
	}
	public StrengtheningProgramLimbWeightVoBean(ims.therapies.vo.StrengtheningProgramLimbWeightVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.limbtype = vo.getLimbType() == null ? null : (ims.vo.LookupInstanceBean)vo.getLimbType().getBean();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
		this.kgs = vo.getKgs();
		this.repetitions = vo.getRepetitions();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.StrengtheningProgramLimbWeightVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.limbtype = vo.getLimbType() == null ? null : (ims.vo.LookupInstanceBean)vo.getLimbType().getBean();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
		this.kgs = vo.getKgs();
		this.repetitions = vo.getRepetitions();
	}

	public ims.therapies.vo.StrengtheningProgramLimbWeightVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.StrengtheningProgramLimbWeightVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.StrengtheningProgramLimbWeightVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.StrengtheningProgramLimbWeightVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.StrengtheningProgramLimbWeightVo();
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
	public ims.vo.LookupInstanceBean getLimbType()
	{
		return this.limbtype;
	}
	public void setLimbType(ims.vo.LookupInstanceBean value)
	{
		this.limbtype = value;
	}
	public ims.vo.LookupInstanceBean getAction()
	{
		return this.action;
	}
	public void setAction(ims.vo.LookupInstanceBean value)
	{
		this.action = value;
	}
	public Integer getKgs()
	{
		return this.kgs;
	}
	public void setKgs(Integer value)
	{
		this.kgs = value;
	}
	public Integer getRepetitions()
	{
		return this.repetitions;
	}
	public void setRepetitions(Integer value)
	{
		this.repetitions = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean limbtype;
	private ims.vo.LookupInstanceBean action;
	private Integer kgs;
	private Integer repetitions;
}
