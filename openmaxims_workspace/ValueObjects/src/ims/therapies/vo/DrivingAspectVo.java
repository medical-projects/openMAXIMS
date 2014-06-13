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

package ims.therapies.vo;

/**
 * Linked to therapies.workLeisureDriving.DrivingAspect business object (ID: 1019100077).
 */
public class DrivingAspectVo extends ims.therapies.workleisuredriving.vo.DrivingAspectRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DrivingAspectVo()
	{
	}
	public DrivingAspectVo(Integer id, int version)
	{
		super(id, version);
	}
	public DrivingAspectVo(ims.therapies.vo.beans.DrivingAspectVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.aspect = bean.getAspect() == null ? null : ims.spinalinjuries.vo.lookups.DrivingAspect.buildLookup(bean.getAspect());
		this.status = bean.getStatus();
		this.comment = bean.getComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.DrivingAspectVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.aspect = bean.getAspect() == null ? null : ims.spinalinjuries.vo.lookups.DrivingAspect.buildLookup(bean.getAspect());
		this.status = bean.getStatus();
		this.comment = bean.getComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.DrivingAspectVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.DrivingAspectVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.DrivingAspectVoBean();
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
		if(fieldName.equals("ASPECT"))
			return getAspect();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("COMMENT"))
			return getComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAspectIsNotNull()
	{
		return this.aspect != null;
	}
	public ims.spinalinjuries.vo.lookups.DrivingAspect getAspect()
	{
		return this.aspect;
	}
	public void setAspect(ims.spinalinjuries.vo.lookups.DrivingAspect value)
	{
		this.isValidated = false;
		this.aspect = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public String getStatus()
	{
		return this.status;
	}
	public static int getStatusMaxLength()
	{
		return 50;
	}
	public void setStatus(String value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
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
		if(this.aspect == null)
			listOfErrors.add("Please select Driving/Car option.");
		if(this.status != null)
			if(this.status.length() > 50)
				listOfErrors.add("The length of the field [status] in the value object [ims.therapies.vo.DrivingAspectVo] is too big. It should be less or equal to 50");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.therapies.vo.DrivingAspectVo] is too big. It should be less or equal to 255");
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
	
		DrivingAspectVo clone = new DrivingAspectVo(this.id, this.version);
		
		if(this.aspect == null)
			clone.aspect = null;
		else
			clone.aspect = (ims.spinalinjuries.vo.lookups.DrivingAspect)this.aspect.clone();
		clone.status = this.status;
		clone.comment = this.comment;
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
		if (!(DrivingAspectVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DrivingAspectVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DrivingAspectVo compareObj = (DrivingAspectVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_DrivingAspect() == null && compareObj.getID_DrivingAspect() != null)
				return -1;
			if(this.getID_DrivingAspect() != null && compareObj.getID_DrivingAspect() == null)
				return 1;
			if(this.getID_DrivingAspect() != null && compareObj.getID_DrivingAspect() != null)
				retVal = this.getID_DrivingAspect().compareTo(compareObj.getID_DrivingAspect());
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
		if(this.aspect != null)
			count++;
		if(this.status != null)
			count++;
		if(this.comment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.DrivingAspect aspect;
	protected String status;
	protected String comment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
