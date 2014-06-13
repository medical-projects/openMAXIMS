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

package ims.careuk.vo.beans;

public class ReportsRequiredForPrintingVoBean extends ims.vo.ValueObjectBean
{
	public ReportsRequiredForPrintingVoBean()
	{
	}
	public ReportsRequiredForPrintingVoBean(ims.careuk.vo.ReportsRequiredForPrintingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.printeddate = vo.getPrintedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPrintedDate().getBean();
		this.printedby = vo.getPrintedBy() == null ? null : new ims.vo.RefVoBean(vo.getPrintedBy().getBoId(), vo.getPrintedBy().getBoVersion());
		this.reportsrequired = vo.getReportsRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getReportsRequired().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReportsRequiredForPrintingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.printeddate = vo.getPrintedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getPrintedDate().getBean();
		this.printedby = vo.getPrintedBy() == null ? null : new ims.vo.RefVoBean(vo.getPrintedBy().getBoId(), vo.getPrintedBy().getBoVersion());
		this.reportsrequired = vo.getReportsRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getReportsRequired().getBean();
	}

	public ims.careuk.vo.ReportsRequiredForPrintingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReportsRequiredForPrintingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReportsRequiredForPrintingVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReportsRequiredForPrintingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReportsRequiredForPrintingVo();
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
	public ims.framework.utils.beans.DateTimeBean getPrintedDate()
	{
		return this.printeddate;
	}
	public void setPrintedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.printeddate = value;
	}
	public ims.vo.RefVoBean getPrintedBy()
	{
		return this.printedby;
	}
	public void setPrintedBy(ims.vo.RefVoBean value)
	{
		this.printedby = value;
	}
	public ims.vo.LookupInstanceBean getReportsRequired()
	{
		return this.reportsrequired;
	}
	public void setReportsRequired(ims.vo.LookupInstanceBean value)
	{
		this.reportsrequired = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean printeddate;
	private ims.vo.RefVoBean printedby;
	private ims.vo.LookupInstanceBean reportsrequired;
}
