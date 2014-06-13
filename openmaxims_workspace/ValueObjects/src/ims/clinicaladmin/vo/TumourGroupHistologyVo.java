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
 * Linked to Oncology.Configuration.TumourGroupHistology business object (ID: 1075100011).
 */
public class TumourGroupHistologyVo extends ims.oncology.configuration.vo.TumourGroupHistologyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourGroupHistologyVo()
	{
	}
	public TumourGroupHistologyVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourGroupHistologyVo(ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedhistology = bean.getAssociatedHistology() == null ? null : bean.getAssociatedHistology().buildVo();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedhistology = bean.getAssociatedHistology() == null ? null : bean.getAssociatedHistology().buildVo(map);
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean();
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
		if(fieldName.equals("ASSOCIATEDHISTOLOGY"))
			return getAssociatedHistology();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssociatedHistologyIsNotNull()
	{
		return this.associatedhistology != null;
	}
	public ims.clinicaladmin.vo.TumourHistologyLiteVo getAssociatedHistology()
	{
		return this.associatedhistology;
	}
	public void setAssociatedHistology(ims.clinicaladmin.vo.TumourHistologyLiteVo value)
	{
		this.isValidated = false;
		this.associatedhistology = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
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
		if(this.associatedhistology == null)
			listOfErrors.add("AssociatedHistology is mandatory");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		TumourGroupHistologyVo clone = new TumourGroupHistologyVo(this.id, this.version);
		
		if(this.associatedhistology == null)
			clone.associatedhistology = null;
		else
			clone.associatedhistology = (ims.clinicaladmin.vo.TumourHistologyLiteVo)this.associatedhistology.clone();
		clone.isactive = this.isactive;
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
		if (!(TumourGroupHistologyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourGroupHistologyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourGroupHistologyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourGroupHistologyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.associatedhistology != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinicaladmin.vo.TumourHistologyLiteVo associatedhistology;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
