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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.CancerImagingHotlist business object (ID: 1073100018).
 */
public class CancerImagingHotlistShortVo extends ims.clinical.configuration.vo.CancerImagingHotlistRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlistShort
{
	private static final long serialVersionUID = 1L;

	public CancerImagingHotlistShortVo()
	{
	}
	public CancerImagingHotlistShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancerImagingHotlistShortVo(ims.clinicaladmin.vo.beans.CancerImagingHotlistShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.CancerImagingHotlistShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getUser().getId()), bean.getUser().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.CancerImagingHotlistShortVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.CancerImagingHotlistShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.CancerImagingHotlistShortVoBean();
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
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("ISGLOBAL"))
			return getIsGlobal();
		if(fieldName.equals("USER"))
			return getUser();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getIsGlobalIsNotNull()
	{
		return this.isglobal != null;
	}
	public Boolean getIsGlobal()
	{
		return this.isglobal;
	}
	public void setIsGlobal(Boolean value)
	{
		this.isValidated = false;
		this.isglobal = value;
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public ims.core.resource.people.vo.MedicRefVo getUser()
	{
		return this.user;
	}
	public void setUser(ims.core.resource.people.vo.MedicRefVo value)
	{
		this.isValidated = false;
		this.user = value;
	}
	/**
	* IHotlistShort
	*/
	public Boolean getISpecialtyIsNotNull() 
	{
		return Boolean.valueOf(this.getSpecialtyIsNotNull());
	}
		
	public ims.core.vo.lookups.Specialty getISpecialty() 
	{
		return this.getSpecialty();
	}
	
	public Integer getIHotlistShortID() 
	{
		return this.getID_CancerImagingHotlist();
	}
	
	public void setISpecialty(ims.core.vo.lookups.Specialty specialty) 
	{
		this.setSpecialty(specialty);
	}
		
	public void setIisGlobal(Boolean isGlobal) 
	{
		this.setIisGlobal(isGlobal);
	}
	
	public Boolean isIValidated() 
	{
		return Boolean.valueOf(this.isValidated());
	}
	
	public String[] iValidate(String[] strText)
	{
		return this.validate(strText);
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
	
		CancerImagingHotlistShortVo clone = new CancerImagingHotlistShortVo(this.id, this.version);
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.isglobal = this.isglobal;
		clone.user = this.user;
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
		if (!(CancerImagingHotlistShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancerImagingHotlistShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancerImagingHotlistShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancerImagingHotlistShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.specialty != null)
			count++;
		if(this.isglobal != null)
			count++;
		if(this.user != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	protected Boolean isglobal;
	protected ims.core.resource.people.vo.MedicRefVo user;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
