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

public class EpisodeofCareVoBean extends ims.vo.ValueObjectBean
{
	public EpisodeofCareVoBean()
	{
	}
	public EpisodeofCareVoBean(ims.core.vo.EpisodeofCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carespell = vo.getCareSpell() == null ? null : new ims.vo.RefVoBean(vo.getCareSpell().getBoId(), vo.getCareSpell().getBoVersion());
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.carecontexts = vo.getCareContexts() == null ? null : vo.getCareContexts().getBeanCollection();
		if(vo.getLinkedReferrals() != null)
		{
			this.linkedreferrals = new ims.vo.RefVoBean[vo.getLinkedReferrals().size()];
			for(int linkedreferrals_i = 0; linkedreferrals_i < vo.getLinkedReferrals().size(); linkedreferrals_i++)
			{
				this.linkedreferrals[linkedreferrals_i] = new ims.vo.RefVoBean(vo.getLinkedReferrals().get(linkedreferrals_i).getBoId(),vo.getLinkedReferrals().get(linkedreferrals_i).getBoVersion());
			}
		}
		if(vo.getLinkedReferralsHistory() != null)
		{
			this.linkedreferralshistory = new ims.vo.RefVoBean[vo.getLinkedReferralsHistory().size()];
			for(int linkedreferralshistory_i = 0; linkedreferralshistory_i < vo.getLinkedReferralsHistory().size(); linkedreferralshistory_i++)
			{
				this.linkedreferralshistory[linkedreferralshistory_i] = new ims.vo.RefVoBean(vo.getLinkedReferralsHistory().get(linkedreferralshistory_i).getBoId(),vo.getLinkedReferralsHistory().get(linkedreferralshistory_i).getBoVersion());
			}
		}
		this.currentreferral = vo.getCurrentReferral() == null ? null : new ims.vo.RefVoBean(vo.getCurrentReferral().getBoId(), vo.getCurrentReferral().getBoVersion());
		this.episodeofcarehistory = vo.getEpisodeOfCareHistory() == null ? null : vo.getEpisodeOfCareHistory().getBeanCollection();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.EpisodeofCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carespell = vo.getCareSpell() == null ? null : new ims.vo.RefVoBean(vo.getCareSpell().getBoId(), vo.getCareSpell().getBoVersion());
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.relationship = vo.getRelationship() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationship().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.carecontexts = vo.getCareContexts() == null ? null : vo.getCareContexts().getBeanCollection();
		if(vo.getLinkedReferrals() != null)
		{
			this.linkedreferrals = new ims.vo.RefVoBean[vo.getLinkedReferrals().size()];
			for(int linkedreferrals_i = 0; linkedreferrals_i < vo.getLinkedReferrals().size(); linkedreferrals_i++)
			{
				this.linkedreferrals[linkedreferrals_i] = new ims.vo.RefVoBean(vo.getLinkedReferrals().get(linkedreferrals_i).getBoId(),vo.getLinkedReferrals().get(linkedreferrals_i).getBoVersion());
			}
		}
		if(vo.getLinkedReferralsHistory() != null)
		{
			this.linkedreferralshistory = new ims.vo.RefVoBean[vo.getLinkedReferralsHistory().size()];
			for(int linkedreferralshistory_i = 0; linkedreferralshistory_i < vo.getLinkedReferralsHistory().size(); linkedreferralshistory_i++)
			{
				this.linkedreferralshistory[linkedreferralshistory_i] = new ims.vo.RefVoBean(vo.getLinkedReferralsHistory().get(linkedreferralshistory_i).getBoId(),vo.getLinkedReferralsHistory().get(linkedreferralshistory_i).getBoVersion());
			}
		}
		this.currentreferral = vo.getCurrentReferral() == null ? null : new ims.vo.RefVoBean(vo.getCurrentReferral().getBoId(), vo.getCurrentReferral().getBoVersion());
		this.episodeofcarehistory = vo.getEpisodeOfCareHistory() == null ? null : vo.getEpisodeOfCareHistory().getBeanCollection();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
	}

	public ims.core.vo.EpisodeofCareVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.EpisodeofCareVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.EpisodeofCareVo vo = null;
		if(map != null)
			vo = (ims.core.vo.EpisodeofCareVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.EpisodeofCareVo();
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
	public ims.vo.RefVoBean getCareSpell()
	{
		return this.carespell;
	}
	public void setCareSpell(ims.vo.RefVoBean value)
	{
		this.carespell = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getRelationship()
	{
		return this.relationship;
	}
	public void setRelationship(ims.vo.LookupInstanceBean value)
	{
		this.relationship = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public ims.core.vo.beans.CareContextVoBean[] getCareContexts()
	{
		return this.carecontexts;
	}
	public void setCareContexts(ims.core.vo.beans.CareContextVoBean[] value)
	{
		this.carecontexts = value;
	}
	public ims.vo.RefVoBean[] getLinkedReferrals()
	{
		return this.linkedreferrals;
	}
	public void setLinkedReferrals(ims.vo.RefVoBean[] value)
	{
		this.linkedreferrals = value;
	}
	public ims.vo.RefVoBean[] getLinkedReferralsHistory()
	{
		return this.linkedreferralshistory;
	}
	public void setLinkedReferralsHistory(ims.vo.RefVoBean[] value)
	{
		this.linkedreferralshistory = value;
	}
	public ims.vo.RefVoBean getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.vo.RefVoBean value)
	{
		this.currentreferral = value;
	}
	public ims.core.vo.beans.EpisodeOfCareHistoryVoBean[] getEpisodeOfCareHistory()
	{
		return this.episodeofcarehistory;
	}
	public void setEpisodeOfCareHistory(ims.core.vo.beans.EpisodeOfCareHistoryVoBean[] value)
	{
		this.episodeofcarehistory = value;
	}
	public ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] value)
	{
		this.statushistory = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carespell;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean relationship;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
	private ims.core.vo.beans.CareContextVoBean[] carecontexts;
	private ims.vo.RefVoBean[] linkedreferrals;
	private ims.vo.RefVoBean[] linkedreferralshistory;
	private ims.vo.RefVoBean currentreferral;
	private ims.core.vo.beans.EpisodeOfCareHistoryVoBean[] episodeofcarehistory;
	private ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean currentstatus;
	private ims.core.vo.beans.EpisodeOfCareStatusHistoryVoBean[] statushistory;
}
