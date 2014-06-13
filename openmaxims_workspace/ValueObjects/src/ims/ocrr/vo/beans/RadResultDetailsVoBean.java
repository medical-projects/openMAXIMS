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

package ims.ocrr.vo.beans;

public class RadResultDetailsVoBean extends ims.vo.ValueObjectBean
{
	public RadResultDetailsVoBean()
	{
	}
	public RadResultDetailsVoBean(ims.ocrr.vo.RadResultDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringradiologistname = vo.getAuthoringRadiologistName();
		this.verifyingradiologistname = vo.getVerifyingRadiologistName();
		this.radiographername = vo.getRadiographerName();
		this.transcribername = vo.getTranscriberName();
		this.reporttext = vo.getReportText();
		this.examdatetime = vo.getExamDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExamDateTime().getBean();
		this.examtimesupplied = vo.getExamTimeSupplied();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.RadResultDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringradiologistname = vo.getAuthoringRadiologistName();
		this.verifyingradiologistname = vo.getVerifyingRadiologistName();
		this.radiographername = vo.getRadiographerName();
		this.transcribername = vo.getTranscriberName();
		this.reporttext = vo.getReportText();
		this.examdatetime = vo.getExamDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExamDateTime().getBean();
		this.examtimesupplied = vo.getExamTimeSupplied();
	}

	public ims.ocrr.vo.RadResultDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.RadResultDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.RadResultDetailsVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.RadResultDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.RadResultDetailsVo();
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
	public String getAuthoringRadiologistName()
	{
		return this.authoringradiologistname;
	}
	public void setAuthoringRadiologistName(String value)
	{
		this.authoringradiologistname = value;
	}
	public String getVerifyingRadiologistName()
	{
		return this.verifyingradiologistname;
	}
	public void setVerifyingRadiologistName(String value)
	{
		this.verifyingradiologistname = value;
	}
	public String getRadiographerName()
	{
		return this.radiographername;
	}
	public void setRadiographerName(String value)
	{
		this.radiographername = value;
	}
	public String getTranscriberName()
	{
		return this.transcribername;
	}
	public void setTranscriberName(String value)
	{
		this.transcribername = value;
	}
	public String getReportText()
	{
		return this.reporttext;
	}
	public void setReportText(String value)
	{
		this.reporttext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExamDateTime()
	{
		return this.examdatetime;
	}
	public void setExamDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.examdatetime = value;
	}
	public Boolean getExamTimeSupplied()
	{
		return this.examtimesupplied;
	}
	public void setExamTimeSupplied(Boolean value)
	{
		this.examtimesupplied = value;
	}

	private Integer id;
	private int version;
	private String authoringradiologistname;
	private String verifyingradiologistname;
	private String radiographername;
	private String transcribername;
	private String reporttext;
	private ims.framework.utils.beans.DateTimeBean examdatetime;
	private Boolean examtimesupplied;
}
