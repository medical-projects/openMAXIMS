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

public class FollowUpNoteVoBean extends ims.vo.ValueObjectBean
{
	public FollowUpNoteVoBean()
	{
	}
	public FollowUpNoteVoBean(ims.careuk.vo.FollowUpNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean();
		this.followupnote = vo.getFollowUpNote();
		this.followuptype = vo.getFollowUpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getFollowUpType().getBean();
		this.includeincatsreport = vo.getIncludeInCatsReport();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.FollowUpNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean(map);
		this.followupnote = vo.getFollowUpNote();
		this.followuptype = vo.getFollowUpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getFollowUpType().getBean();
		this.includeincatsreport = vo.getIncludeInCatsReport();
	}

	public ims.careuk.vo.FollowUpNoteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.FollowUpNoteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.FollowUpNoteVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.FollowUpNoteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.FollowUpNoteVo();
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
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.recordinginformation = value;
	}
	public String getFollowUpNote()
	{
		return this.followupnote;
	}
	public void setFollowUpNote(String value)
	{
		this.followupnote = value;
	}
	public ims.vo.LookupInstanceBean getFollowUpType()
	{
		return this.followuptype;
	}
	public void setFollowUpType(ims.vo.LookupInstanceBean value)
	{
		this.followuptype = value;
	}
	public Boolean getIncludeInCatsReport()
	{
		return this.includeincatsreport;
	}
	public void setIncludeInCatsReport(Boolean value)
	{
		this.includeincatsreport = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.AuthoringInformationVoBean recordinginformation;
	private String followupnote;
	private ims.vo.LookupInstanceBean followuptype;
	private Boolean includeincatsreport;
}
