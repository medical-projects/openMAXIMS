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

package ims.nursing.vo.beans;

public class CopyCarePlanVoBean extends ims.vo.ValueObjectBean
{
	public CopyCarePlanVoBean()
	{
	}
	public CopyCarePlanVoBean(ims.nursing.vo.CopyCarePlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.lastrevieweddate = vo.getLastReviewedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastReviewedDate().getBean();
		this.lastreviewedby = vo.getLastReviewedBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getLastReviewedBy().getBean();
		this.careplanstatus = vo.getCarePlanStatus() == null ? null : vo.getCarePlanStatus().getBeanCollection();
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean();
		this.newnextevaluationdate = vo.getNewNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNewNextEvaluationDate().getBean();
		this.newnextevaluationtime = vo.getNewNextEvaluationTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getNewNextEvaluationTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.CopyCarePlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.lastrevieweddate = vo.getLastReviewedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLastReviewedDate().getBean();
		this.lastreviewedby = vo.getLastReviewedBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getLastReviewedBy().getBean(map);
		this.careplanstatus = vo.getCarePlanStatus() == null ? null : vo.getCarePlanStatus().getBeanCollection();
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean(map);
		this.newnextevaluationdate = vo.getNewNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNewNextEvaluationDate().getBean();
		this.newnextevaluationtime = vo.getNewNextEvaluationTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getNewNextEvaluationTime().getBean();
	}

	public ims.nursing.vo.CopyCarePlanVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.CopyCarePlanVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.CopyCarePlanVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.CopyCarePlanVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.CopyCarePlanVo();
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
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String value)
	{
		this.title = value;
	}
	public ims.framework.utils.beans.DateBean getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.beans.DateBean value)
	{
		this.nextevaluationdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLastReviewedDate()
	{
		return this.lastrevieweddate;
	}
	public void setLastReviewedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.lastrevieweddate = value;
	}
	public ims.core.vo.beans.HcpBean getLastReviewedBy()
	{
		return this.lastreviewedby;
	}
	public void setLastReviewedBy(ims.core.vo.beans.HcpBean value)
	{
		this.lastreviewedby = value;
	}
	public ims.nursing.vo.beans.CarePlanStatusBean[] getCarePlanStatus()
	{
		return this.careplanstatus;
	}
	public void setCarePlanStatus(ims.nursing.vo.beans.CarePlanStatusBean[] value)
	{
		this.careplanstatus = value;
	}
	public ims.nursing.vo.beans.CarePlanStatusBean getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.beans.CarePlanStatusBean value)
	{
		this.currentcareplanstatus = value;
	}
	public ims.framework.utils.beans.DateBean getNewNextEvaluationDate()
	{
		return this.newnextevaluationdate;
	}
	public void setNewNextEvaluationDate(ims.framework.utils.beans.DateBean value)
	{
		this.newnextevaluationdate = value;
	}
	public ims.framework.utils.beans.TimeBean getNewNextEvaluationTime()
	{
		return this.newnextevaluationtime;
	}
	public void setNewNextEvaluationTime(ims.framework.utils.beans.TimeBean value)
	{
		this.newnextevaluationtime = value;
	}

	private Integer id;
	private int version;
	private String title;
	private ims.framework.utils.beans.DateBean nextevaluationdate;
	private ims.framework.utils.beans.DateTimeBean lastrevieweddate;
	private ims.core.vo.beans.HcpBean lastreviewedby;
	private ims.nursing.vo.beans.CarePlanStatusBean[] careplanstatus;
	private ims.nursing.vo.beans.CarePlanStatusBean currentcareplanstatus;
	private ims.framework.utils.beans.DateBean newnextevaluationdate;
	private ims.framework.utils.beans.TimeBean newnextevaluationtime;
}
