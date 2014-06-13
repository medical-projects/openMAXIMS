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

public class InvestigationQuestionsSelectOrderVoBean extends ims.vo.ValueObjectBean
{
	public InvestigationQuestionsSelectOrderVoBean()
	{
	}
	public InvestigationQuestionsSelectOrderVoBean(ims.ocrr.vo.InvestigationQuestionsSelectOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assocquestions = vo.getAssocQuestions() == null ? null : vo.getAssocQuestions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestigationQuestionsSelectOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assocquestions = vo.getAssocQuestions() == null ? null : vo.getAssocQuestions().getBeanCollection();
	}

	public ims.ocrr.vo.InvestigationQuestionsSelectOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestigationQuestionsSelectOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestigationQuestionsSelectOrderVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestigationQuestionsSelectOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestigationQuestionsSelectOrderVo();
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
	public ims.ocrr.vo.beans.InvestigationQuestionShortVoBean[] getAssocQuestions()
	{
		return this.assocquestions;
	}
	public void setAssocQuestions(ims.ocrr.vo.beans.InvestigationQuestionShortVoBean[] value)
	{
		this.assocquestions = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationQuestionShortVoBean[] assocquestions;
}
