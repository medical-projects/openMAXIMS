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

public class CategoryQuestionVoBean extends ims.vo.ValueObjectBean
{
	public CategoryQuestionVoBean()
	{
	}
	public CategoryQuestionVoBean(ims.ocrr.vo.CategoryQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ismandatory = vo.getIsMandatory();
		this.questioninformation = vo.getQuestionInformation() == null ? null : (ims.core.vo.beans.QuestionInformationVoBean)vo.getQuestionInformation().getBean();
		this.ocrrcategory = vo.getOCRRCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getOCRRCategory().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.CategoryQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ismandatory = vo.getIsMandatory();
		this.questioninformation = vo.getQuestionInformation() == null ? null : (ims.core.vo.beans.QuestionInformationVoBean)vo.getQuestionInformation().getBean(map);
		this.ocrrcategory = vo.getOCRRCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getOCRRCategory().getBean();
	}

	public ims.ocrr.vo.CategoryQuestionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.CategoryQuestionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.CategoryQuestionVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.CategoryQuestionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.CategoryQuestionVo();
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
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.ismandatory = value;
	}
	public ims.core.vo.beans.QuestionInformationVoBean getQuestionInformation()
	{
		return this.questioninformation;
	}
	public void setQuestionInformation(ims.core.vo.beans.QuestionInformationVoBean value)
	{
		this.questioninformation = value;
	}
	public ims.vo.LookupInstanceBean getOCRRCategory()
	{
		return this.ocrrcategory;
	}
	public void setOCRRCategory(ims.vo.LookupInstanceBean value)
	{
		this.ocrrcategory = value;
	}

	private Integer id;
	private int version;
	private Boolean ismandatory;
	private ims.core.vo.beans.QuestionInformationVoBean questioninformation;
	private ims.vo.LookupInstanceBean ocrrcategory;
}
