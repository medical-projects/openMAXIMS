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

public class TTOMedicationVoBean extends ims.vo.ValueObjectBean
{
	public TTOMedicationVoBean()
	{
	}
	public TTOMedicationVoBean(ims.clinical.vo.TTOMedicationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dispensegivecode = vo.getDispenseGiveCode();
		this.datedispensed = vo.getDateDispensed() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateDispensed().getBean();
		this.actualdispenseamount = vo.getActualDispenseAmount();
		this.actualdispenseunits = vo.getActualDispenseUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getActualDispenseUnits().getBean();
		this.noofrefillsremaining = vo.getNoOfRefillsRemaining();
		this.dispensenotes = vo.getDispenseNotes();
		this.needshumanreview = vo.getNeedsHumanReview() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedsHumanReview().getBean();
		this.specialdispensinginstructions = vo.getSpecialDispensingInstructions();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.TTOMedicationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dispensegivecode = vo.getDispenseGiveCode();
		this.datedispensed = vo.getDateDispensed() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateDispensed().getBean();
		this.actualdispenseamount = vo.getActualDispenseAmount();
		this.actualdispenseunits = vo.getActualDispenseUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getActualDispenseUnits().getBean();
		this.noofrefillsremaining = vo.getNoOfRefillsRemaining();
		this.dispensenotes = vo.getDispenseNotes();
		this.needshumanreview = vo.getNeedsHumanReview() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedsHumanReview().getBean();
		this.specialdispensinginstructions = vo.getSpecialDispensingInstructions();
	}

	public ims.clinical.vo.TTOMedicationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.TTOMedicationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.TTOMedicationVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.TTOMedicationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.TTOMedicationVo();
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
	public String getDispenseGiveCode()
	{
		return this.dispensegivecode;
	}
	public void setDispenseGiveCode(String value)
	{
		this.dispensegivecode = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateDispensed()
	{
		return this.datedispensed;
	}
	public void setDateDispensed(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datedispensed = value;
	}
	public Float getActualDispenseAmount()
	{
		return this.actualdispenseamount;
	}
	public void setActualDispenseAmount(Float value)
	{
		this.actualdispenseamount = value;
	}
	public ims.vo.LookupInstanceBean getActualDispenseUnits()
	{
		return this.actualdispenseunits;
	}
	public void setActualDispenseUnits(ims.vo.LookupInstanceBean value)
	{
		this.actualdispenseunits = value;
	}
	public Integer getNoOfRefillsRemaining()
	{
		return this.noofrefillsremaining;
	}
	public void setNoOfRefillsRemaining(Integer value)
	{
		this.noofrefillsremaining = value;
	}
	public String getDispenseNotes()
	{
		return this.dispensenotes;
	}
	public void setDispenseNotes(String value)
	{
		this.dispensenotes = value;
	}
	public ims.vo.LookupInstanceBean getNeedsHumanReview()
	{
		return this.needshumanreview;
	}
	public void setNeedsHumanReview(ims.vo.LookupInstanceBean value)
	{
		this.needshumanreview = value;
	}
	public String getSpecialDispensingInstructions()
	{
		return this.specialdispensinginstructions;
	}
	public void setSpecialDispensingInstructions(String value)
	{
		this.specialdispensinginstructions = value;
	}

	private Integer id;
	private int version;
	private String dispensegivecode;
	private ims.framework.utils.beans.DateTimeBean datedispensed;
	private Float actualdispenseamount;
	private ims.vo.LookupInstanceBean actualdispenseunits;
	private Integer noofrefillsremaining;
	private String dispensenotes;
	private ims.vo.LookupInstanceBean needshumanreview;
	private String specialdispensinginstructions;
}
