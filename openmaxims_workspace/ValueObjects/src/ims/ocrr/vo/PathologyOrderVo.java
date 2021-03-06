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

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class PathologyOrderVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologyOrderVo()
	{
	}
	public PathologyOrderVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologyOrderVo(ims.ocrr.vo.beans.PathologyOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.specimen = ims.ocrr.vo.OrderSpecimenPathologyVoCollection.buildFromBeanCollection(bean.getSpecimen());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologyOrderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo(map);
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.specimen = ims.ocrr.vo.OrderSpecimenPathologyVoCollection.buildFromBeanCollection(bean.getSpecimen());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologyOrderVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologyOrderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologyOrderVoBean();
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
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationLiteVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationLiteVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.vo.OcsOrderShortVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.OcsOrderShortVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.OrderSpecimenPathologyVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.OrderSpecimenPathologyVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
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
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.orderdetails != null)
		{
			if(!this.orderdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.specimen != null)
		{
			if(!this.specimen.isValidated())
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
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.orderdetails != null)
		{
			String[] listOfOtherErrors = this.orderdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.specimen != null)
		{
			String[] listOfOtherErrors = this.specimen.validate();
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
	
		PathologyOrderVo clone = new PathologyOrderVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationLiteVo)this.investigation.clone();
		if(this.orderdetails == null)
			clone.orderdetails = null;
		else
			clone.orderdetails = (ims.ocrr.vo.OcsOrderShortVo)this.orderdetails.clone();
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.OrderSpecimenPathologyVoCollection)this.specimen.clone();
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
		if (!(PathologyOrderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologyOrderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathologyOrderVo compareObj = (PathologyOrderVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDisplayDateTime() == null && compareObj.getDisplayDateTime() != null)
				return -1;
			if(this.getDisplayDateTime() != null && compareObj.getDisplayDateTime() == null)
				return 1;
			if(this.getDisplayDateTime() != null && compareObj.getDisplayDateTime() != null)
				retVal = this.getDisplayDateTime().compareTo(compareObj.getDisplayDateTime());
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
		if(this.investigation != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.specimen != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.ocrr.vo.InvestigationLiteVo investigation;
	protected ims.ocrr.vo.OcsOrderShortVo orderdetails;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.OrderSpecimenPathologyVoCollection specimen;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
