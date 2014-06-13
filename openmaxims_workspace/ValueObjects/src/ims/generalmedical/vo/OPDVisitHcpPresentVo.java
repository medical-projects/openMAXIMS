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

package ims.generalmedical.vo;

/**
 * Linked to medical.OPDVisitHcpPresent business object (ID: 1031100002).
 */
public class OPDVisitHcpPresentVo extends ims.medical.vo.OPDVisitHcpPresentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OPDVisitHcpPresentVo()
	{
	}
	public OPDVisitHcpPresentVo(Integer id, int version)
	{
		super(id, version);
	}
	public OPDVisitHcpPresentVo(ims.generalmedical.vo.beans.OPDVisitHcpPresentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.opdvisitdetails = bean.getOPDVisitDetails() == null ? null : bean.getOPDVisitDetails().buildVo();
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.OPDVisitHcpPresentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.opdvisitdetails = bean.getOPDVisitDetails() == null ? null : bean.getOPDVisitDetails().buildVo(map);
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo(map);
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.OPDVisitHcpPresentVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.OPDVisitHcpPresentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.OPDVisitHcpPresentVoBean();
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
		if(fieldName.equals("OPDVISITDETAILS"))
			return getOPDVisitDetails();
		if(fieldName.equals("HCP"))
			return getHCP();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOPDVisitDetailsIsNotNull()
	{
		return this.opdvisitdetails != null;
	}
	public ims.generalmedical.vo.OPDVisitDetailsVo getOPDVisitDetails()
	{
		return this.opdvisitdetails;
	}
	public void setOPDVisitDetails(ims.generalmedical.vo.OPDVisitDetailsVo value)
	{
		this.isValidated = false;
		this.opdvisitdetails = value;
	}
	public boolean getHCPIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.HcpLiteVo getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
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
		if(this.opdvisitdetails != null)
		{
			if(!this.opdvisitdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.hcp != null)
		{
			if(!this.hcp.isValidated())
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
		if(this.opdvisitdetails != null)
		{
			String[] listOfOtherErrors = this.opdvisitdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.hcp != null)
		{
			String[] listOfOtherErrors = this.hcp.validate();
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
	
		OPDVisitHcpPresentVo clone = new OPDVisitHcpPresentVo(this.id, this.version);
		
		if(this.opdvisitdetails == null)
			clone.opdvisitdetails = null;
		else
			clone.opdvisitdetails = (ims.generalmedical.vo.OPDVisitDetailsVo)this.opdvisitdetails.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.HcpLiteVo)this.hcp.clone();
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
		if (!(OPDVisitHcpPresentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OPDVisitHcpPresentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OPDVisitHcpPresentVo compareObj = (OPDVisitHcpPresentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OPDVisitHcpPresent() == null && compareObj.getID_OPDVisitHcpPresent() != null)
				return -1;
			if(this.getID_OPDVisitHcpPresent() != null && compareObj.getID_OPDVisitHcpPresent() == null)
				return 1;
			if(this.getID_OPDVisitHcpPresent() != null && compareObj.getID_OPDVisitHcpPresent() != null)
				retVal = this.getID_OPDVisitHcpPresent().compareTo(compareObj.getID_OPDVisitHcpPresent());
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
		if(this.opdvisitdetails != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.generalmedical.vo.OPDVisitDetailsVo opdvisitdetails;
	protected ims.core.vo.HcpLiteVo hcp;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
