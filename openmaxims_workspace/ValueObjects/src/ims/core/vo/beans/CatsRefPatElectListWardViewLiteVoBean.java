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

public class CatsRefPatElectListWardViewLiteVoBean extends ims.vo.ValueObjectBean
{
	public CatsRefPatElectListWardViewLiteVoBean()
	{
	}
	public CatsRefPatElectListWardViewLiteVoBean(ims.core.vo.CatsRefPatElectListWardViewLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextCatsRefPEListWardViewLiteVoBean)vo.getCareContext().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CatsRefPatElectListWardViewLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextCatsRefPEListWardViewLiteVoBean)vo.getCareContext().getBean(map);
	}

	public ims.core.vo.CatsRefPatElectListWardViewLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CatsRefPatElectListWardViewLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CatsRefPatElectListWardViewLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CatsRefPatElectListWardViewLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CatsRefPatElectListWardViewLiteVo();
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
	public ims.core.vo.beans.CareContextCatsRefPEListWardViewLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextCatsRefPEListWardViewLiteVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.CareContextCatsRefPEListWardViewLiteVoBean carecontext;
}
