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

public class PatientNoSupportNetworkServicesInfoVoBean extends ims.vo.ValueObjectBean
{
	public PatientNoSupportNetworkServicesInfoVoBean()
	{
	}
	public PatientNoSupportNetworkServicesInfoVoBean(ims.core.vo.PatientNoSupportNetworkServicesInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.supportnetworkservicestatus = vo.getSupportNetworkServiceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkServiceStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientNoSupportNetworkServicesInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.supportnetworkservicestatus = vo.getSupportNetworkServiceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSupportNetworkServiceStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
	}

	public ims.core.vo.PatientNoSupportNetworkServicesInfoVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientNoSupportNetworkServicesInfoVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientNoSupportNetworkServicesInfoVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientNoSupportNetworkServicesInfoVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientNoSupportNetworkServicesInfoVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.LookupInstanceBean getSupportNetworkServiceStatus()
	{
		return this.supportnetworkservicestatus;
	}
	public void setSupportNetworkServiceStatus(ims.vo.LookupInstanceBean value)
	{
		this.supportnetworkservicestatus = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.LookupInstanceBean supportnetworkservicestatus;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
}
