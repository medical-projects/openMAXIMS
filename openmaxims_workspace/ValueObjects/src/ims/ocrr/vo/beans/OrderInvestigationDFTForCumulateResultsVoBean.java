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

public class OrderInvestigationDFTForCumulateResultsVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationDFTForCumulateResultsVoBean()
	{
	}
	public OrderInvestigationDFTForCumulateResultsVoBean(ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationForCumulateResultsVoBean)vo.getInvestigation().getBean();
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForCumulateResultsVoBean)vo.getResultDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationForCumulateResultsVoBean)vo.getInvestigation().getBean(map);
		this.resultdetails = vo.getResultDetails() == null ? null : (ims.ocrr.vo.beans.ResultDetailsForCumulateResultsVoBean)vo.getResultDetails().getBean(map);
	}

	public ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderInvestigationDFTForCumulateResultsVo();
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
	public ims.ocrr.vo.beans.InvestigationForCumulateResultsVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationForCumulateResultsVoBean value)
	{
		this.investigation = value;
	}
	public ims.ocrr.vo.beans.ResultDetailsForCumulateResultsVoBean getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.beans.ResultDetailsForCumulateResultsVoBean value)
	{
		this.resultdetails = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationForCumulateResultsVoBean investigation;
	private ims.ocrr.vo.beans.ResultDetailsForCumulateResultsVoBean resultdetails;
}
