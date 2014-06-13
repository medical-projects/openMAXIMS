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

package ims.ocs_if.vo;

/**
 * Linked to OCRR.Configuration.InvestigationIndex business object (ID: 1061100003).
 */
public class IfInvestigationIndexVo extends ims.ocrr.configuration.vo.InvestigationIndexRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfInvestigationIndexVo()
	{
	}
	public IfInvestigationIndexVo(Integer id, int version)
	{
		super(id, version);
	}
	public IfInvestigationIndexVo(ims.ocs_if.vo.beans.IfInvestigationIndexVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.colour = bean.getColour() == null ? null : bean.getColour().buildColor();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.isprofile = bean.getIsProfile();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfInvestigationIndexVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.colour = bean.getColour() == null ? null : bean.getColour().buildColor();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.isprofile = bean.getIsProfile();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfInvestigationIndexVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfInvestigationIndexVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfInvestigationIndexVoBean();
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
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("COLOUR"))
			return getColour();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("ISPROFILE"))
			return getIsProfile();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.ocrr.vo.lookups.Category getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.ocrr.vo.lookups.Category value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 200;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
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
	public boolean getColourIsNotNull()
	{
		return this.colour != null;
	}
	public ims.framework.utils.Color getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.colour = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getIsProfileIsNotNull()
	{
		return this.isprofile != null;
	}
	public Boolean getIsProfile()
	{
		return this.isprofile;
	}
	public void setIsProfile(Boolean value)
	{
		this.isValidated = false;
		this.isprofile = value;
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
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 200)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocs_if.vo.IfInvestigationIndexVo] is too big. It should be less or equal to 200");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.ocs_if.vo.IfInvestigationIndexVo] is too big. It should be less or equal to 255");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.isprofile == null)
			listOfErrors.add("isProfile is mandatory");
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
	
		IfInvestigationIndexVo clone = new IfInvestigationIndexVo(this.id, this.version);
		
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.ocrr.vo.lookups.Category)this.category.clone();
		clone.name = this.name;
		clone.description = this.description;
		if(this.colour == null)
			clone.colour = null;
		else
			clone.colour = (ims.framework.utils.Color)this.colour.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		clone.isprofile = this.isprofile;
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
		if (!(IfInvestigationIndexVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfInvestigationIndexVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IfInvestigationIndexVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IfInvestigationIndexVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.category != null)
			count++;
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.colour != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.isprofile != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.ocrr.vo.lookups.Category category;
	protected String name;
	protected String description;
	protected ims.framework.utils.Color colour;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected Boolean isprofile;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
