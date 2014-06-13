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

package ims.core.vo;

/**
 * Linked to core.resource.place.Clinic business object (ID: 1007100011).
 */
public class ClinicVo extends ims.core.vo.ClinicLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicVo()
	{
	}
	public ClinicVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicVo(ims.core.vo.beans.ClinicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicname = bean.getClinicName();
		this.isactive = bean.getIsActive();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.outpatientdept = bean.getOutpatientDept() == null ? null : bean.getOutpatientDept().buildVo();
		this.cliniclocation = bean.getClinicLocation() == null ? null : bean.getClinicLocation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ClinicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicname = bean.getClinicName();
		this.isactive = bean.getIsActive();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.outpatientdept = bean.getOutpatientDept() == null ? null : bean.getOutpatientDept().buildVo(map);
		this.cliniclocation = bean.getClinicLocation() == null ? null : bean.getClinicLocation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ClinicVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ClinicVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ClinicVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CLINICLOCATION"))
			return getClinicLocation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicLocationIsNotNull()
	{
		return this.cliniclocation != null;
	}
	public ims.core.vo.LocShortVo getClinicLocation()
	{
		return this.cliniclocation;
	}
	public void setClinicLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.cliniclocation = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.clinicname != null)
			sb.append(this.clinicname);
		return sb.toString();
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.cliniclocation != null)
		{
			if(!this.cliniclocation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.clinicname != null)
			if(this.clinicname.length() > 255)
				listOfErrors.add("The length of the field [clinicname] in the value object [ims.core.vo.ClinicVo] is too big. It should be less or equal to 255");
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.cliniclocation != null)
		{
			String[] listOfOtherErrors = this.cliniclocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ClinicVo clone = new ClinicVo(this.id, this.version);
		
		clone.clinicname = this.clinicname;
		clone.isactive = this.isactive;
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.outpatientdept == null)
			clone.outpatientdept = null;
		else
			clone.outpatientdept = (ims.core.vo.LocShortMappingsVo)this.outpatientdept.clone();
		if(this.cliniclocation == null)
			clone.cliniclocation = null;
		else
			clone.cliniclocation = (ims.core.vo.LocShortVo)this.cliniclocation.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ClinicVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.cliniclocation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.LocShortVo cliniclocation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
