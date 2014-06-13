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
 * Linked to core.layout.BedSpace business object (ID: 1095100003).
 */
public class BedSpaceLiteVo extends ims.core.layout.vo.BedSpaceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BedSpaceLiteVo()
	{
	}
	public BedSpaceLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public BedSpaceLiteVo(ims.core.vo.beans.BedSpaceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedspacetype = bean.getBedSpaceType() == null ? null : ims.core.vo.lookups.BedSpaceType.buildLookup(bean.getBedSpaceType());
		this.description = bean.getDescription();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.BedSpaceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedspacetype = bean.getBedSpaceType() == null ? null : ims.core.vo.lookups.BedSpaceType.buildLookup(bean.getBedSpaceType());
		this.description = bean.getDescription();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.BedSpaceLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.BedSpaceLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.BedSpaceLiteVoBean();
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
		if(fieldName.equals("BEDSPACETYPE"))
			return getBedSpaceType();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBedSpaceTypeIsNotNull()
	{
		return this.bedspacetype != null;
	}
	public ims.core.vo.lookups.BedSpaceType getBedSpaceType()
	{
		return this.bedspacetype;
	}
	public void setBedSpaceType(ims.core.vo.lookups.BedSpaceType value)
	{
		this.isValidated = false;
		this.bedspacetype = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
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
		if(this.bedspacetype == null)
			listOfErrors.add("BedSpaceType is mandatory");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.core.vo.BedSpaceLiteVo] is too big. It should be less or equal to 255");
		if(this.wardtype == null)
			listOfErrors.add("WardType is mandatory");
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
	
		BedSpaceLiteVo clone = new BedSpaceLiteVo(this.id, this.version);
		
		if(this.bedspacetype == null)
			clone.bedspacetype = null;
		else
			clone.bedspacetype = (ims.core.vo.lookups.BedSpaceType)this.bedspacetype.clone();
		clone.description = this.description;
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
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
		if (!(BedSpaceLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BedSpaceLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BedSpaceLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BedSpaceLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.bedspacetype != null)
			count++;
		if(this.description != null)
			count++;
		if(this.wardtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.BedSpaceType bedspacetype;
	protected String description;
	protected ims.core.vo.lookups.WardType wardtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
