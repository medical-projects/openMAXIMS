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

package ims.ocs_if.vo.beans;

public class IfAnalyteVoBean extends ims.vo.ValueObjectBean
{
	public IfAnalyteVoBean()
	{
	}
	public IfAnalyteVoBean(ims.ocs_if.vo.IfAnalyteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyteextcode = vo.getAnalyteExtCode();
		this.analyteexttext = vo.getAnalyteExtText();
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.locationservice = vo.getLocationService() == null ? null : new ims.vo.RefVoBean(vo.getLocationService().getBoId(), vo.getLocationService().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfAnalyteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyteextcode = vo.getAnalyteExtCode();
		this.analyteexttext = vo.getAnalyteExtText();
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.locationservice = vo.getLocationService() == null ? null : new ims.vo.RefVoBean(vo.getLocationService().getBoId(), vo.getLocationService().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
	}

	public ims.ocs_if.vo.IfAnalyteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfAnalyteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfAnalyteVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfAnalyteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfAnalyteVo();
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
	public String getAnalyteExtCode()
	{
		return this.analyteextcode;
	}
	public void setAnalyteExtCode(String value)
	{
		this.analyteextcode = value;
	}
	public String getAnalyteExtText()
	{
		return this.analyteexttext;
	}
	public void setAnalyteExtText(String value)
	{
		this.analyteexttext = value;
	}
	public ims.vo.RefVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.vo.RefVoBean value)
	{
		this.providersystem = value;
	}
	public ims.vo.RefVoBean getLocationService()
	{
		return this.locationservice;
	}
	public void setLocationService(ims.vo.RefVoBean value)
	{
		this.locationservice = value;
	}
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}

	private Integer id;
	private int version;
	private String analyteextcode;
	private String analyteexttext;
	private ims.vo.RefVoBean providersystem;
	private ims.vo.RefVoBean locationservice;
	private ims.vo.RefVoBean service;
}
