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
 * Linked to Oncology.Configuration.PrognosticRiskConfiguration business object (ID: 1075100018).
 */
public class PrognosticRiskConfigVo extends ims.oncology.configuration.vo.PrognosticRiskConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PrognosticRiskConfigVo()
	{
	}
	public PrognosticRiskConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public PrognosticRiskConfigVo(ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.riskname = bean.getRiskName();
		this.riskdescription = bean.getRiskDescription();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.riskname = bean.getRiskName();
		this.riskdescription = bean.getRiskDescription();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.PrognosticRiskConfigVoBean();
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
		if(fieldName.equals("RISKNAME"))
			return getRiskName();
		if(fieldName.equals("RISKDESCRIPTION"))
			return getRiskDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRiskNameIsNotNull()
	{
		return this.riskname != null;
	}
	public String getRiskName()
	{
		return this.riskname;
	}
	public static int getRiskNameMaxLength()
	{
		return 30;
	}
	public void setRiskName(String value)
	{
		this.isValidated = false;
		this.riskname = value;
	}
	public boolean getRiskDescriptionIsNotNull()
	{
		return this.riskdescription != null;
	}
	public String getRiskDescription()
	{
		return this.riskdescription;
	}
	public static int getRiskDescriptionMaxLength()
	{
		return 100;
	}
	public void setRiskDescription(String value)
	{
		this.isValidated = false;
		this.riskdescription = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.riskname != null)
			sb.append(this.riskname);
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
		if(this.riskname == null || this.riskname.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.riskname.length() > 30)
			listOfErrors.add("The length of the field [riskname] in the value object [ims.clinicaladmin.vo.PrognosticRiskConfigVo] is too big. It should be less or equal to 30");
		if(this.riskdescription == null || this.riskdescription.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.riskdescription.length() > 100)
			listOfErrors.add("The length of the field [riskdescription] in the value object [ims.clinicaladmin.vo.PrognosticRiskConfigVo] is too big. It should be less or equal to 100");
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
	
		PrognosticRiskConfigVo clone = new PrognosticRiskConfigVo(this.id, this.version);
		
		clone.riskname = this.riskname;
		clone.riskdescription = this.riskdescription;
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
		if (!(PrognosticRiskConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PrognosticRiskConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PrognosticRiskConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PrognosticRiskConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.riskname != null)
			count++;
		if(this.riskdescription != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String riskname;
	protected String riskdescription;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
