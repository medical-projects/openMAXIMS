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

public class ExtendedAdmissionDetailVoBean extends ims.vo.ValueObjectBean
{
	public ExtendedAdmissionDetailVoBean()
	{
	}
	public ExtendedAdmissionDetailVoBean(ims.core.vo.ExtendedAdmissionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referredfromtype = vo.getReferredFromType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferredFromType().getBean();
		this.referrerdetails = vo.getReferrerDetails() == null ? null : (ims.core.vo.beans.ExternalResourceVoBean)vo.getReferrerDetails().getBean();
		this.admittedfromtype = vo.getAdmittedFromType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmittedFromType().getBean();
		this.admittedfrom = vo.getAdmittedFrom() == null ? null : (ims.core.vo.beans.ExternalResourceVoBean)vo.getAdmittedFrom().getBean();
		this.bednumber = vo.getBedNumber();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ExtendedAdmissionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referredfromtype = vo.getReferredFromType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferredFromType().getBean();
		this.referrerdetails = vo.getReferrerDetails() == null ? null : (ims.core.vo.beans.ExternalResourceVoBean)vo.getReferrerDetails().getBean(map);
		this.admittedfromtype = vo.getAdmittedFromType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmittedFromType().getBean();
		this.admittedfrom = vo.getAdmittedFrom() == null ? null : (ims.core.vo.beans.ExternalResourceVoBean)vo.getAdmittedFrom().getBean(map);
		this.bednumber = vo.getBedNumber();
	}

	public ims.core.vo.ExtendedAdmissionDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ExtendedAdmissionDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ExtendedAdmissionDetailVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ExtendedAdmissionDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ExtendedAdmissionDetailVo();
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
	public ims.vo.LookupInstanceBean getReferredFromType()
	{
		return this.referredfromtype;
	}
	public void setReferredFromType(ims.vo.LookupInstanceBean value)
	{
		this.referredfromtype = value;
	}
	public ims.core.vo.beans.ExternalResourceVoBean getReferrerDetails()
	{
		return this.referrerdetails;
	}
	public void setReferrerDetails(ims.core.vo.beans.ExternalResourceVoBean value)
	{
		this.referrerdetails = value;
	}
	public ims.vo.LookupInstanceBean getAdmittedFromType()
	{
		return this.admittedfromtype;
	}
	public void setAdmittedFromType(ims.vo.LookupInstanceBean value)
	{
		this.admittedfromtype = value;
	}
	public ims.core.vo.beans.ExternalResourceVoBean getAdmittedFrom()
	{
		return this.admittedfrom;
	}
	public void setAdmittedFrom(ims.core.vo.beans.ExternalResourceVoBean value)
	{
		this.admittedfrom = value;
	}
	public Integer getBedNumber()
	{
		return this.bednumber;
	}
	public void setBedNumber(Integer value)
	{
		this.bednumber = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean referredfromtype;
	private ims.core.vo.beans.ExternalResourceVoBean referrerdetails;
	private ims.vo.LookupInstanceBean admittedfromtype;
	private ims.core.vo.beans.ExternalResourceVoBean admittedfrom;
	private Integer bednumber;
}
