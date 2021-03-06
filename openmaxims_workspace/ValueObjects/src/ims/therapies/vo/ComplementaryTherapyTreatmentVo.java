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
 * Linked to therapies.treatment.ComplementaryTherapyTreatment business object (ID: 1019100003).
 */
public class ComplementaryTherapyTreatmentVo extends ims.therapies.vo.ComplementaryTherapyTreatmentShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ComplementaryTherapyTreatmentVo()
	{
	}
	public ComplementaryTherapyTreatmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public ComplementaryTherapyTreatmentVo(ims.therapies.vo.beans.ComplementaryTherapyTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.complementarytherapy = ims.therapies.vo.ComplementaryTherapyDetailsVoCollection.buildFromBeanCollection(bean.getComplementaryTherapy());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.ComplementaryTherapyTreatmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.complementarytherapy = ims.therapies.vo.ComplementaryTherapyDetailsVoCollection.buildFromBeanCollection(bean.getComplementaryTherapy());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.ComplementaryTherapyTreatmentVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.ComplementaryTherapyTreatmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.ComplementaryTherapyTreatmentVoBean();
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
		if(fieldName.equals("COMPLEMENTARYTHERAPY"))
			return getComplementaryTherapy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getComplementaryTherapyIsNotNull()
	{
		return this.complementarytherapy != null;
	}
	public ims.therapies.vo.ComplementaryTherapyDetailsVoCollection getComplementaryTherapy()
	{
		return this.complementarytherapy;
	}
	public void setComplementaryTherapy(ims.therapies.vo.ComplementaryTherapyDetailsVoCollection value)
	{
		this.isValidated = false;
		this.complementarytherapy = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.complementarytherapy != null)
		{
			if(!this.complementarytherapy.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is a mandatory field");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.complementarytherapy == null || this.complementarytherapy.size() == 0)
			listOfErrors.add("ComplementaryTherapy are mandatory");
		if(this.complementarytherapy != null)
		{
			String[] listOfOtherErrors = this.complementarytherapy.validate();
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
	
		ComplementaryTherapyTreatmentVo clone = new ComplementaryTherapyTreatmentVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.complementarytherapy == null)
			clone.complementarytherapy = null;
		else
			clone.complementarytherapy = (ims.therapies.vo.ComplementaryTherapyDetailsVoCollection)this.complementarytherapy.clone();
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
		if (!(ComplementaryTherapyTreatmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ComplementaryTherapyTreatmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ComplementaryTherapyTreatmentVo compareObj = (ComplementaryTherapyTreatmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ComplementaryTherapyTreatment() == null && compareObj.getID_ComplementaryTherapyTreatment() != null)
				return -1;
			if(this.getID_ComplementaryTherapyTreatment() != null && compareObj.getID_ComplementaryTherapyTreatment() == null)
				return 1;
			if(this.getID_ComplementaryTherapyTreatment() != null && compareObj.getID_ComplementaryTherapyTreatment() != null)
				retVal = this.getID_ComplementaryTherapyTreatment().compareTo(compareObj.getID_ComplementaryTherapyTreatment());
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
		if(this.complementarytherapy != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.therapies.vo.ComplementaryTherapyDetailsVoCollection complementarytherapy;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
