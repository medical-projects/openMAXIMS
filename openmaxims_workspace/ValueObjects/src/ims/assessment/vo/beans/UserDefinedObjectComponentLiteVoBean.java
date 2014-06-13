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

package ims.assessment.vo.beans;

public class UserDefinedObjectComponentLiteVoBean extends ims.vo.ValueObjectBean
{
	public UserDefinedObjectComponentLiteVoBean()
	{
	}
	public UserDefinedObjectComponentLiteVoBean(ims.assessment.vo.UserDefinedObjectComponentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessments = vo.getUserAssessments() == null ? null : (ims.assessment.vo.beans.UserAssessmentLiteVoBean)vo.getUserAssessments().getBean();
		this.graphic = vo.getGraphic() == null ? null : (ims.assessment.vo.beans.GraphicAssessmentShortVoBean)vo.getGraphic().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.seqno = vo.getSeqNo();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.UserDefinedObjectComponentLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.userassessments = vo.getUserAssessments() == null ? null : (ims.assessment.vo.beans.UserAssessmentLiteVoBean)vo.getUserAssessments().getBean(map);
		this.graphic = vo.getGraphic() == null ? null : (ims.assessment.vo.beans.GraphicAssessmentShortVoBean)vo.getGraphic().getBean(map);
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.seqno = vo.getSeqNo();
	}

	public ims.assessment.vo.UserDefinedObjectComponentLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.UserDefinedObjectComponentLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.UserDefinedObjectComponentLiteVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.UserDefinedObjectComponentLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.UserDefinedObjectComponentLiteVo();
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
	public ims.assessment.vo.beans.UserAssessmentLiteVoBean getUserAssessments()
	{
		return this.userassessments;
	}
	public void setUserAssessments(ims.assessment.vo.beans.UserAssessmentLiteVoBean value)
	{
		this.userassessments = value;
	}
	public ims.assessment.vo.beans.GraphicAssessmentShortVoBean getGraphic()
	{
		return this.graphic;
	}
	public void setGraphic(ims.assessment.vo.beans.GraphicAssessmentShortVoBean value)
	{
		this.graphic = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public Integer getSeqNo()
	{
		return this.seqno;
	}
	public void setSeqNo(Integer value)
	{
		this.seqno = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.UserAssessmentLiteVoBean userassessments;
	private ims.assessment.vo.beans.GraphicAssessmentShortVoBean graphic;
	private ims.vo.LookupInstanceBean activestatus;
	private Integer seqno;
}
