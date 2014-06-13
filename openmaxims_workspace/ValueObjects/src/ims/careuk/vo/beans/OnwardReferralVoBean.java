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

public class OnwardReferralVoBean extends ims.vo.ValueObjectBean
{
	public OnwardReferralVoBean()
	{
	}
	public OnwardReferralVoBean(ims.careuk.vo.OnwardReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.onwardreferralorg = vo.getOnwardReferralOrg() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getOnwardReferralOrg().getBean();
		this.onwardreferral = vo.getOnwardReferral();
		this.rejecteddate = vo.getRejectedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRejectedDate().getBean();
		this.rejectionreason = vo.getRejectionReason();
		this.rejectedby = vo.getRejectedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getRejectedBy().getBean();
		this.onwardreferralreason = vo.getOnwardReferralReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getOnwardReferralReason().getBean();
		this.copytogp = vo.getCopyToGP();
		this.copytopatient = vo.getCopyToPatient();
		this.copytosecondarycare = vo.getCopyToSecondaryCare();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.OnwardReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.onwardreferralorg = vo.getOnwardReferralOrg() == null ? null : (ims.core.vo.beans.OrgLiteVoBean)vo.getOnwardReferralOrg().getBean(map);
		this.onwardreferral = vo.getOnwardReferral();
		this.rejecteddate = vo.getRejectedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRejectedDate().getBean();
		this.rejectionreason = vo.getRejectionReason();
		this.rejectedby = vo.getRejectedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getRejectedBy().getBean();
		this.onwardreferralreason = vo.getOnwardReferralReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getOnwardReferralReason().getBean();
		this.copytogp = vo.getCopyToGP();
		this.copytopatient = vo.getCopyToPatient();
		this.copytosecondarycare = vo.getCopyToSecondaryCare();
	}

	public ims.careuk.vo.OnwardReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.OnwardReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.OnwardReferralVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.OnwardReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.OnwardReferralVo();
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
	public ims.framework.utils.beans.DateBean getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargedate = value;
	}
	public ims.core.vo.beans.OrgLiteVoBean getOnwardReferralOrg()
	{
		return this.onwardreferralorg;
	}
	public void setOnwardReferralOrg(ims.core.vo.beans.OrgLiteVoBean value)
	{
		this.onwardreferralorg = value;
	}
	public String getOnwardReferral()
	{
		return this.onwardreferral;
	}
	public void setOnwardReferral(String value)
	{
		this.onwardreferral = value;
	}
	public ims.framework.utils.beans.DateBean getRejectedDate()
	{
		return this.rejecteddate;
	}
	public void setRejectedDate(ims.framework.utils.beans.DateBean value)
	{
		this.rejecteddate = value;
	}
	public String getRejectionReason()
	{
		return this.rejectionreason;
	}
	public void setRejectionReason(String value)
	{
		this.rejectionreason = value;
	}
	public ims.vo.LookupInstanceBean getRejectedBy()
	{
		return this.rejectedby;
	}
	public void setRejectedBy(ims.vo.LookupInstanceBean value)
	{
		this.rejectedby = value;
	}
	public ims.vo.LookupInstanceBean getOnwardReferralReason()
	{
		return this.onwardreferralreason;
	}
	public void setOnwardReferralReason(ims.vo.LookupInstanceBean value)
	{
		this.onwardreferralreason = value;
	}
	public Boolean getCopyToGP()
	{
		return this.copytogp;
	}
	public void setCopyToGP(Boolean value)
	{
		this.copytogp = value;
	}
	public Boolean getCopyToPatient()
	{
		return this.copytopatient;
	}
	public void setCopyToPatient(Boolean value)
	{
		this.copytopatient = value;
	}
	public Boolean getCopyToSecondaryCare()
	{
		return this.copytosecondarycare;
	}
	public void setCopyToSecondaryCare(Boolean value)
	{
		this.copytosecondarycare = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean dischargedate;
	private ims.core.vo.beans.OrgLiteVoBean onwardreferralorg;
	private String onwardreferral;
	private ims.framework.utils.beans.DateBean rejecteddate;
	private String rejectionreason;
	private ims.vo.LookupInstanceBean rejectedby;
	private ims.vo.LookupInstanceBean onwardreferralreason;
	private Boolean copytogp;
	private Boolean copytopatient;
	private Boolean copytosecondarycare;
}
