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

public class ServiceShortVoBean extends ims.vo.ValueObjectBean
{
	public ServiceShortVoBean()
	{
	}
	public ServiceShortVoBean(ims.core.vo.ServiceShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.servicename = vo.getServiceName();
		this.servicecategory = vo.getServiceCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getServiceCategory().getBean();
		this.canbescheduled = vo.getCanBeScheduled();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.maternityindicator = vo.getMaternityIndicator();
		this.servicedescription = vo.getServiceDescription();
		this.isactive = vo.getIsActive();
		this.alternateservicecode = vo.getAlternateServiceCode();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ServiceShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.servicename = vo.getServiceName();
		this.servicecategory = vo.getServiceCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getServiceCategory().getBean();
		this.canbescheduled = vo.getCanBeScheduled();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.maternityindicator = vo.getMaternityIndicator();
		this.servicedescription = vo.getServiceDescription();
		this.isactive = vo.getIsActive();
		this.alternateservicecode = vo.getAlternateServiceCode();
	}

	public ims.core.vo.ServiceShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ServiceShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ServiceShortVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ServiceShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ServiceShortVo();
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
	public String getServiceName()
	{
		return this.servicename;
	}
	public void setServiceName(String value)
	{
		this.servicename = value;
	}
	public ims.vo.LookupInstanceBean getServiceCategory()
	{
		return this.servicecategory;
	}
	public void setServiceCategory(ims.vo.LookupInstanceBean value)
	{
		this.servicecategory = value;
	}
	public Boolean getCanBeScheduled()
	{
		return this.canbescheduled;
	}
	public void setCanBeScheduled(Boolean value)
	{
		this.canbescheduled = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public Integer getExpectedTurnaround()
	{
		return this.expectedturnaround;
	}
	public void setExpectedTurnaround(Integer value)
	{
		this.expectedturnaround = value;
	}
	public ims.vo.LookupInstanceBean getTurnaroundMeasure()
	{
		return this.turnaroundmeasure;
	}
	public void setTurnaroundMeasure(ims.vo.LookupInstanceBean value)
	{
		this.turnaroundmeasure = value;
	}
	public Boolean getMaternityIndicator()
	{
		return this.maternityindicator;
	}
	public void setMaternityIndicator(Boolean value)
	{
		this.maternityindicator = value;
	}
	public String getServiceDescription()
	{
		return this.servicedescription;
	}
	public void setServiceDescription(String value)
	{
		this.servicedescription = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public String getAlternateServiceCode()
	{
		return this.alternateservicecode;
	}
	public void setAlternateServiceCode(String value)
	{
		this.alternateservicecode = value;
	}

	private Integer id;
	private int version;
	private String servicename;
	private ims.vo.LookupInstanceBean servicecategory;
	private Boolean canbescheduled;
	private ims.vo.LookupInstanceBean specialty;
	private Integer expectedturnaround;
	private ims.vo.LookupInstanceBean turnaroundmeasure;
	private Boolean maternityindicator;
	private String servicedescription;
	private Boolean isactive;
	private String alternateservicecode;
}
