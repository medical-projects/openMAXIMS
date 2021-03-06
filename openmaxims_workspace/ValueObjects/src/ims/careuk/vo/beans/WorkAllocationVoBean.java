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

public class WorkAllocationVoBean extends ims.vo.ValueObjectBean
{
	public WorkAllocationVoBean()
	{
	}
	public WorkAllocationVoBean(ims.careuk.vo.WorkAllocationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.allocatedby = vo.getAllocatedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedBy().getBean();
		this.dateallocated = vo.getDateAllocated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateAllocated().getBean();
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.completedby = vo.getCompletedBy() == null ? null : new ims.vo.RefVoBean(vo.getCompletedBy().getBoId(), vo.getCompletedBy().getBoVersion());
		this.unallocatedby = vo.getUnallocatedBy() == null ? null : new ims.vo.RefVoBean(vo.getUnallocatedBy().getBoId(), vo.getUnallocatedBy().getBoVersion());
		this.unallocateddate = vo.getUnallocatedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getUnallocatedDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.WorkAllocationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.allocatedby = vo.getAllocatedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedBy().getBean(map);
		this.dateallocated = vo.getDateAllocated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateAllocated().getBean();
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean(map);
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.completedby = vo.getCompletedBy() == null ? null : new ims.vo.RefVoBean(vo.getCompletedBy().getBoId(), vo.getCompletedBy().getBoVersion());
		this.unallocatedby = vo.getUnallocatedBy() == null ? null : new ims.vo.RefVoBean(vo.getUnallocatedBy().getBoId(), vo.getUnallocatedBy().getBoVersion());
		this.unallocateddate = vo.getUnallocatedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getUnallocatedDate().getBean();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public ims.careuk.vo.WorkAllocationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.WorkAllocationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.WorkAllocationVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.WorkAllocationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.WorkAllocationVo();
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
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAllocatedBy()
	{
		return this.allocatedby;
	}
	public void setAllocatedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.allocatedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateAllocated()
	{
		return this.dateallocated;
	}
	public void setDateAllocated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dateallocated = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAllocatedTo()
	{
		return this.allocatedto;
	}
	public void setAllocatedTo(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.allocatedto = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.vo.RefVoBean getCompletedBy()
	{
		return this.completedby;
	}
	public void setCompletedBy(ims.vo.RefVoBean value)
	{
		this.completedby = value;
	}
	public ims.vo.RefVoBean getUnallocatedBy()
	{
		return this.unallocatedby;
	}
	public void setUnallocatedBy(ims.vo.RefVoBean value)
	{
		this.unallocatedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getUnallocatedDate()
	{
		return this.unallocateddate;
	}
	public void setUnallocatedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.unallocateddate = value;
	}
	public ims.vo.LookupInstanceBean getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.vo.LookupInstanceBean value)
	{
		this.referralstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean allocatedby;
	private ims.framework.utils.beans.DateTimeBean dateallocated;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean allocatedto;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.vo.RefVoBean completedby;
	private ims.vo.RefVoBean unallocatedby;
	private ims.framework.utils.beans.DateTimeBean unallocateddate;
	private ims.vo.LookupInstanceBean referralstatus;
}
