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

package ims.admin.vo;

/**
 * Linked to core.admin.TemplateBo business object (ID: 1004100008).
 */
public class ReportTemplateVo extends ims.core.admin.vo.TemplateBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReportTemplateVo()
	{
	}
	public ReportTemplateVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReportTemplateVo(ims.admin.vo.beans.ReportTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.templatexml = bean.getTemplateXml();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
		this.report = bean.getReport() == null ? null : bean.getReport().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.ReportTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.templatexml = bean.getTemplateXml();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
		this.report = bean.getReport() == null ? null : bean.getReport().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.ReportTemplateVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.ReportTemplateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.ReportTemplateVoBean();
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
		if(fieldName.equals("TEMPLATEXML"))
			return getTemplateXml();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("REPORT"))
			return getReport();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTemplateXmlIsNotNull()
	{
		return this.templatexml != null;
	}
	public String getTemplateXml()
	{
		return this.templatexml;
	}
	public static int getTemplateXmlMaxLength()
	{
		return 200000;
	}
	public void setTemplateXml(String value)
	{
		this.isValidated = false;
		this.templatexml = value;
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
		return 255;
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
	public boolean getReportIsNotNull()
	{
		return this.report != null;
	}
	public ims.admin.vo.ReportVo getReport()
	{
		return this.report;
	}
	public void setReport(ims.admin.vo.ReportVo value)
	{
		this.isValidated = false;
		this.report = value;
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
		if(this.report != null)
		{
			if(!this.report.isValidated())
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
		if(this.templatexml == null || this.templatexml.length() == 0)
			listOfErrors.add("templateXml is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.admin.vo.ReportTemplateVo] is too big. It should be less or equal to 255");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.admin.vo.ReportTemplateVo] is too big. It should be less or equal to 255");
		if(this.report != null)
		{
			String[] listOfOtherErrors = this.report.validate();
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
	
		ReportTemplateVo clone = new ReportTemplateVo(this.id, this.version);
		
		clone.templatexml = this.templatexml;
		clone.name = this.name;
		clone.description = this.description;
		clone.isactive = this.isactive;
		if(this.report == null)
			clone.report = null;
		else
			clone.report = (ims.admin.vo.ReportVo)this.report.clone();
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
		if (!(ReportTemplateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReportTemplateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReportTemplateVo compareObj = (ReportTemplateVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
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
		if(this.templatexml != null)
			count++;
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.report != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String templatexml;
	protected String name;
	protected String description;
	protected Boolean isactive;
	protected ims.admin.vo.ReportVo report;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
