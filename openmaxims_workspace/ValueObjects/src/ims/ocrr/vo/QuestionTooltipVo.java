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

package ims.ocrr.vo;


public class QuestionTooltipVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public QuestionTooltipVo()
	{
	}
	public QuestionTooltipVo(ims.ocrr.vo.beans.QuestionTooltipVoBean bean)
	{
		this.questionid = bean.getQuestionID();
		this.tooltip = bean.getTooltip();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.QuestionTooltipVoBean bean)
	{
		this.questionid = bean.getQuestionID();
		this.tooltip = bean.getTooltip();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.QuestionTooltipVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.QuestionTooltipVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.QuestionTooltipVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getQuestionIDIsNotNull()
	{
		return this.questionid != null;
	}
	public Integer getQuestionID()
	{
		return this.questionid;
	}
	public void setQuestionID(Integer value)
	{
		this.isValidated = false;
		this.questionid = value;
	}
	public boolean getTooltipIsNotNull()
	{
		return this.tooltip != null;
	}
	public String getTooltip()
	{
		return this.tooltip;
	}
	public static int getTooltipMaxLength()
	{
		return 255;
	}
	public void setTooltip(String value)
	{
		this.isValidated = false;
		this.tooltip = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof QuestionTooltipVo))
			return false;
		QuestionTooltipVo compareObj = (QuestionTooltipVo)obj;
		if(this.getQuestionID() == null && compareObj.getQuestionID() != null)
			return false;
		if(this.getQuestionID() != null && compareObj.getQuestionID() == null)
			return false;
		if(this.getQuestionID() != null && compareObj.getQuestionID() != null)
			return this.getQuestionID().equals(compareObj.getQuestionID());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		QuestionTooltipVo clone = new QuestionTooltipVo();
		
		clone.questionid = this.questionid;
		clone.tooltip = this.tooltip;
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
		if (!(QuestionTooltipVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A QuestionTooltipVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		QuestionTooltipVo compareObj = (QuestionTooltipVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getQuestionID() == null && compareObj.getQuestionID() != null)
				return -1;
			if(this.getQuestionID() != null && compareObj.getQuestionID() == null)
				return 1;
			if(this.getQuestionID() != null && compareObj.getQuestionID() != null)
				retVal = this.getQuestionID().compareTo(compareObj.getQuestionID());
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
		if(this.questionid != null)
			count++;
		if(this.tooltip != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Integer questionid;
	protected String tooltip;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
