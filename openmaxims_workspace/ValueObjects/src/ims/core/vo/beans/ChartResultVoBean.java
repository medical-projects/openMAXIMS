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

public class ChartResultVoBean extends ims.vo.ValueObjectBean
{
	public ChartResultVoBean()
	{
	}
	public ChartResultVoBean(ims.core.vo.ChartResultVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyte = vo.getAnalyte() == null ? null : (ims.ocrr.vo.beans.ChartResultAnalyteVoBean)vo.getAnalyte().getBean();
		this.resultval = vo.getResultVal();
		this.isabnormal = vo.getIsAbnormal();
		this.obsdatetime = vo.getObsDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getObsDateTime().getBean();
		this.obstimesupplied = vo.getObsTimeSupplied();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.refrange = vo.getRefRange();
		this.investigationdata = vo.getInvestigationData() == null ? null : (ims.ocrr.vo.beans.OrderInvestigationChartVoBean)vo.getInvestigationData().getBean();
		this.specimencomments = vo.getSpecimenComments() == null ? null : (ims.ocrr.vo.beans.OrderSpecimenLabSpecCommentsVoBean)vo.getSpecimenComments().getBean();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
		this.pathologyresultid = vo.getPathologyResultId();
		this.resvaltype = vo.getResValType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResValType().getBean();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ChartResultVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyte = vo.getAnalyte() == null ? null : (ims.ocrr.vo.beans.ChartResultAnalyteVoBean)vo.getAnalyte().getBean(map);
		this.resultval = vo.getResultVal();
		this.isabnormal = vo.getIsAbnormal();
		this.obsdatetime = vo.getObsDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getObsDateTime().getBean();
		this.obstimesupplied = vo.getObsTimeSupplied();
		this.comments = vo.getComments() == null ? null : vo.getComments().getBeanCollection();
		this.refrange = vo.getRefRange();
		this.investigationdata = vo.getInvestigationData() == null ? null : (ims.ocrr.vo.beans.OrderInvestigationChartVoBean)vo.getInvestigationData().getBean(map);
		this.specimencomments = vo.getSpecimenComments() == null ? null : (ims.ocrr.vo.beans.OrderSpecimenLabSpecCommentsVoBean)vo.getSpecimenComments().getBean(map);
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
		this.pathologyresultid = vo.getPathologyResultId();
		this.resvaltype = vo.getResValType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResValType().getBean();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
	}

	public ims.core.vo.ChartResultVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ChartResultVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ChartResultVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ChartResultVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ChartResultVo();
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
	public ims.ocrr.vo.beans.ChartResultAnalyteVoBean getAnalyte()
	{
		return this.analyte;
	}
	public void setAnalyte(ims.ocrr.vo.beans.ChartResultAnalyteVoBean value)
	{
		this.analyte = value;
	}
	public String getResultVal()
	{
		return this.resultval;
	}
	public void setResultVal(String value)
	{
		this.resultval = value;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isabnormal = value;
	}
	public ims.framework.utils.beans.DateTimeBean getObsDateTime()
	{
		return this.obsdatetime;
	}
	public void setObsDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.obsdatetime = value;
	}
	public Boolean getObsTimeSupplied()
	{
		return this.obstimesupplied;
	}
	public void setObsTimeSupplied(Boolean value)
	{
		this.obstimesupplied = value;
	}
	public ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] getComments()
	{
		return this.comments;
	}
	public void setComments(ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] value)
	{
		this.comments = value;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public void setRefRange(String value)
	{
		this.refrange = value;
	}
	public ims.ocrr.vo.beans.OrderInvestigationChartVoBean getInvestigationData()
	{
		return this.investigationdata;
	}
	public void setInvestigationData(ims.ocrr.vo.beans.OrderInvestigationChartVoBean value)
	{
		this.investigationdata = value;
	}
	public ims.ocrr.vo.beans.OrderSpecimenLabSpecCommentsVoBean getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.ocrr.vo.beans.OrderSpecimenLabSpecCommentsVoBean value)
	{
		this.specimencomments = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.vo.LookupInstanceBean getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstanceBean value)
	{
		this.resultspecimentype = value;
	}
	public Integer getPathologyResultId()
	{
		return this.pathologyresultid;
	}
	public void setPathologyResultId(Integer value)
	{
		this.pathologyresultid = value;
	}
	public ims.vo.LookupInstanceBean getResValType()
	{
		return this.resvaltype;
	}
	public void setResValType(ims.vo.LookupInstanceBean value)
	{
		this.resvaltype = value;
	}
	public ims.vo.LookupInstanceBean getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.vo.LookupInstanceBean value)
	{
		this.unitofmeasure = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.ChartResultAnalyteVoBean analyte;
	private String resultval;
	private Boolean isabnormal;
	private ims.framework.utils.beans.DateTimeBean obsdatetime;
	private Boolean obstimesupplied;
	private ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] comments;
	private String refrange;
	private ims.ocrr.vo.beans.OrderInvestigationChartVoBean investigationdata;
	private ims.ocrr.vo.beans.OrderSpecimenLabSpecCommentsVoBean specimencomments;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.vo.LookupInstanceBean resultspecimentype;
	private Integer pathologyresultid;
	private ims.vo.LookupInstanceBean resvaltype;
	private ims.vo.LookupInstanceBean unitofmeasure;
}
