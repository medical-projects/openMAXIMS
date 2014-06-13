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

package ims.careuk.vo;

/**
 * Linked to core.configuration.ContractConfig business object (ID: 1096100047).
 */
public class ContractConfigLiteVo extends ims.core.configuration.vo.ContractConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ContractConfigLiteVo()
	{
	}
	public ContractConfigLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ContractConfigLiteVo(ims.careuk.vo.beans.ContractConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contractid = bean.getContractId();
		this.contractname = bean.getContractName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ContractConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contractid = bean.getContractId();
		this.contractname = bean.getContractName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ContractConfigLiteVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ContractConfigLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ContractConfigLiteVoBean();
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
		if(fieldName.equals("CONTRACTID"))
			return getContractId();
		if(fieldName.equals("CONTRACTNAME"))
			return getContractName();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getContractIdIsNotNull()
	{
		return this.contractid != null;
	}
	public String getContractId()
	{
		return this.contractid;
	}
	public static int getContractIdMaxLength()
	{
		return 25;
	}
	public void setContractId(String value)
	{
		this.isValidated = false;
		this.contractid = value;
	}
	public boolean getContractNameIsNotNull()
	{
		return this.contractname != null;
	}
	public String getContractName()
	{
		return this.contractname;
	}
	public static int getContractNameMaxLength()
	{
		return 255;
	}
	public void setContractName(String value)
	{
		this.isValidated = false;
		this.contractname = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(this.contractid == null || this.contractid.length() == 0)
			listOfErrors.add("ContractId is mandatory");
		else if(this.contractid.length() > 25)
			listOfErrors.add("The length of the field [contractid] in the value object [ims.careuk.vo.ContractConfigLiteVo] is too big. It should be less or equal to 25");
		if(this.contractname == null || this.contractname.length() == 0)
			listOfErrors.add("ContractName is mandatory");
		else if(this.contractname.length() > 255)
			listOfErrors.add("The length of the field [contractname] in the value object [ims.careuk.vo.ContractConfigLiteVo] is too big. It should be less or equal to 255");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		ContractConfigLiteVo clone = new ContractConfigLiteVo(this.id, this.version);
		
		clone.contractid = this.contractid;
		clone.contractname = this.contractname;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
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
		if (!(ContractConfigLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ContractConfigLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ContractConfigLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ContractConfigLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.contractid != null)
			count++;
		if(this.contractname != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String contractid;
	protected String contractname;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
