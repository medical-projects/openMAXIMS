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

package ims.clinical.vo;

/**
 * Linked to core.clinical.ProceduresPerformedByHCP business object (ID: 1003100100).
 */
public class ProceduresPerformedByHCPVo extends ims.core.clinical.vo.ProceduresPerformedByHCPRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProceduresPerformedByHCPVo()
	{
	}
	public ProceduresPerformedByHCPVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProceduresPerformedByHCPVo(ims.clinical.vo.beans.ProceduresPerformedByHCPVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.performinghcp = bean.getPerformingHCP() == null ? null : bean.getPerformingHCP().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.procedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedures());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ProceduresPerformedByHCPVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.performinghcp = bean.getPerformingHCP() == null ? null : bean.getPerformingHCP().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.procedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedures());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ProceduresPerformedByHCPVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ProceduresPerformedByHCPVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ProceduresPerformedByHCPVoBean();
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
		if(fieldName.equals("PERFORMINGHCP"))
			return getPerformingHCP();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("PROCEDURES"))
			return getProcedures();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPerformingHCPIsNotNull()
	{
		return this.performinghcp != null;
	}
	public ims.core.vo.HcpLiteVo getPerformingHCP()
	{
		return this.performinghcp;
	}
	public void setPerformingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.performinghcp = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getProceduresIsNotNull()
	{
		return this.procedures != null;
	}
	public ims.core.vo.ProcedureLiteVoCollection getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.core.vo.ProcedureLiteVoCollection value)
	{
		this.isValidated = false;
		this.procedures = value;
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
		if(this.performinghcp == null)
			listOfErrors.add("HCP Name is mandatory");
		if(this.service == null)
			listOfErrors.add("Service Name is mandatory");
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
	
		ProceduresPerformedByHCPVo clone = new ProceduresPerformedByHCPVo(this.id, this.version);
		
		if(this.performinghcp == null)
			clone.performinghcp = null;
		else
			clone.performinghcp = (ims.core.vo.HcpLiteVo)this.performinghcp.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.procedures == null)
			clone.procedures = null;
		else
			clone.procedures = (ims.core.vo.ProcedureLiteVoCollection)this.procedures.clone();
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
		if (!(ProceduresPerformedByHCPVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProceduresPerformedByHCPVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProceduresPerformedByHCPVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProceduresPerformedByHCPVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.performinghcp != null)
			count++;
		if(this.service != null)
			count++;
		if(this.procedures != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.HcpLiteVo performinghcp;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.ProcedureLiteVoCollection procedures;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
