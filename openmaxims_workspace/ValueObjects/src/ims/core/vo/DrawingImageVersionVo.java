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
 * Linked to core.configuration.DrawingImageVersion business object (ID: 1021100005).
 */
public class DrawingImageVersionVo extends ims.core.configuration.vo.DrawingImageVersionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DrawingImageVersionVo()
	{
	}
	public DrawingImageVersionVo(Integer id, int version)
	{
		super(id, version);
	}
	public DrawingImageVersionVo(ims.core.vo.beans.DrawingImageVersionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagename = bean.getImageName();
		this.versionnumber = bean.getVersionNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DrawingImageVersionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagename = bean.getImageName();
		this.versionnumber = bean.getVersionNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DrawingImageVersionVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DrawingImageVersionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DrawingImageVersionVoBean();
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
		if(fieldName.equals("IMAGENAME"))
			return getImageName();
		if(fieldName.equals("VERSIONNUMBER"))
			return getVersionNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getImageNameIsNotNull()
	{
		return this.imagename != null;
	}
	public String getImageName()
	{
		return this.imagename;
	}
	public static int getImageNameMaxLength()
	{
		return 255;
	}
	public void setImageName(String value)
	{
		this.isValidated = false;
		this.imagename = value;
	}
	public boolean getVersionNumberIsNotNull()
	{
		return this.versionnumber != null;
	}
	public Integer getVersionNumber()
	{
		return this.versionnumber;
	}
	public void setVersionNumber(Integer value)
	{
		this.isValidated = false;
		this.versionnumber = value;
	}
	/**
	* 2 arg constructor
	*/
	public DrawingImageVersionVo(String imageName, Integer versionNumber)
	{
		this.imagename = imageName;
		this.versionnumber = versionNumber;
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
		if(this.imagename != null)
			if(this.imagename.length() > 255)
				listOfErrors.add("The length of the field [imagename] in the value object [ims.core.vo.DrawingImageVersionVo] is too big. It should be less or equal to 255");
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
	
		DrawingImageVersionVo clone = new DrawingImageVersionVo(this.id, this.version);
		
		clone.imagename = this.imagename;
		clone.versionnumber = this.versionnumber;
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
		if (!(DrawingImageVersionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DrawingImageVersionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DrawingImageVersionVo compareObj = (DrawingImageVersionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getImageName() == null && compareObj.getImageName() != null)
				return -1;
			if(this.getImageName() != null && compareObj.getImageName() == null)
				return 1;
			if(this.getImageName() != null && compareObj.getImageName() != null)
			{
				if(caseInsensitive)
					retVal = this.getImageName().toLowerCase().compareTo(compareObj.getImageName().toLowerCase());
				else
					retVal = this.getImageName().compareTo(compareObj.getImageName());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.imagename != null)
			count++;
		if(this.versionnumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String imagename;
	protected Integer versionnumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
