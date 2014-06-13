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
 * Linked to core.configuration.DrawingGraphicImage business object (ID: 1028100007).
 */
public class DrawingGraphicImageVo extends ims.core.vo.DrawingGraphicImageShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DrawingGraphicImageVo()
	{
	}
	public DrawingGraphicImageVo(Integer id, int version)
	{
		super(id, version);
	}
	public DrawingGraphicImageVo(ims.core.vo.beans.DrawingGraphicImageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagename = bean.getImageName();
		this.imagedescription = bean.getImageDescription();
		this.versionnumber = bean.getVersionNumber();
		this.imagestatus = bean.getImageStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getImageStatus());
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo();
		this.rootgroup = bean.getRootGroup() == null ? null : bean.getRootGroup().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DrawingGraphicImageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagename = bean.getImageName();
		this.imagedescription = bean.getImageDescription();
		this.versionnumber = bean.getVersionNumber();
		this.imagestatus = bean.getImageStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getImageStatus());
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo(map);
		this.rootgroup = bean.getRootGroup() == null ? null : bean.getRootGroup().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DrawingGraphicImageVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DrawingGraphicImageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DrawingGraphicImageVoBean();
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
		if(fieldName.equals("IMAGE"))
			return getImage();
		if(fieldName.equals("ROOTGROUP"))
			return getRootGroup();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getImageIsNotNull()
	{
		return this.image != null;
	}
	public ims.admin.vo.AppImageVo getImage()
	{
		return this.image;
	}
	public void setImage(ims.admin.vo.AppImageVo value)
	{
		this.isValidated = false;
		this.image = value;
	}
	public boolean getRootGroupIsNotNull()
	{
		return this.rootgroup != null;
	}
	public ims.core.vo.GraphicGroupVo getRootGroup()
	{
		return this.rootgroup;
	}
	public void setRootGroup(ims.core.vo.GraphicGroupVo value)
	{
		this.isValidated = false;
		this.rootgroup = value;
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
		if(this.image != null)
		{
			if(!this.image.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.rootgroup != null)
		{
			if(!this.rootgroup.isValidated())
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
		if(this.imagename == null || this.imagename.length() == 0)
			listOfErrors.add("Please Enter Drawing Configuration Name");
		else if(this.imagename.length() > 70)
			listOfErrors.add("The length of the field [imagename] in the value object [ims.core.vo.DrawingGraphicImageVo] is too big. It should be less or equal to 70");
		if(this.imagedescription != null)
			if(this.imagedescription.length() > 255)
				listOfErrors.add("The length of the field [imagedescription] in the value object [ims.core.vo.DrawingGraphicImageVo] is too big. It should be less or equal to 255");
		if(this.versionnumber == null)
			listOfErrors.add("Please Enter Drawing Version Number");
		if(this.imagestatus == null)
			listOfErrors.add("ImageStatus is mandatory");
		if(this.image == null)
			listOfErrors.add("Please Enter Drawing Configuration Image");
		if(this.image != null)
		{
			String[] listOfOtherErrors = this.image.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.rootgroup != null)
		{
			String[] listOfOtherErrors = this.rootgroup.validate();
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
	
		DrawingGraphicImageVo clone = new DrawingGraphicImageVo(this.id, this.version);
		
		clone.imagename = this.imagename;
		clone.imagedescription = this.imagedescription;
		clone.versionnumber = this.versionnumber;
		if(this.imagestatus == null)
			clone.imagestatus = null;
		else
			clone.imagestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.imagestatus.clone();
		if(this.image == null)
			clone.image = null;
		else
			clone.image = (ims.admin.vo.AppImageVo)this.image.clone();
		if(this.rootgroup == null)
			clone.rootgroup = null;
		else
			clone.rootgroup = (ims.core.vo.GraphicGroupVo)this.rootgroup.clone();
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
		if (!(DrawingGraphicImageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DrawingGraphicImageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DrawingGraphicImageVo compareObj = (DrawingGraphicImageVo)obj;
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
		int count = super.countFieldsWithValue();
		if(this.image != null)
			count++;
		if(this.rootgroup != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.admin.vo.AppImageVo image;
	protected ims.core.vo.GraphicGroupVo rootgroup;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
