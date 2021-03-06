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

package ims.emergency.vo;

/**
 * Linked to emergency.InterventionTreatmentDetail business object (ID: 1086100021).
 */
public class InterventionTreatmentDetailLiteVo extends ims.emergency.vo.InterventionTreatmentDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InterventionTreatmentDetailLiteVo()
	{
	}
	public InterventionTreatmentDetailLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public InterventionTreatmentDetailLiteVo(ims.emergency.vo.beans.InterventionTreatmentDetailLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentinterventiondescription = bean.getTreatmentInterventionDescription();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.InterventionTreatmentDetailLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentinterventiondescription = bean.getTreatmentInterventionDescription();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.InterventionTreatmentDetailLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.InterventionTreatmentDetailLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.InterventionTreatmentDetailLiteVoBean();
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
		if(fieldName.equals("TREATMENTINTERVENTIONDESCRIPTION"))
			return getTreatmentInterventionDescription();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentInterventionDescriptionIsNotNull()
	{
		return this.treatmentinterventiondescription != null;
	}
	public String getTreatmentInterventionDescription()
	{
		return this.treatmentinterventiondescription;
	}
	public static int getTreatmentInterventionDescriptionMaxLength()
	{
		return 255;
	}
	public void setTreatmentInterventionDescription(String value)
	{
		this.isValidated = false;
		this.treatmentinterventiondescription = value;
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
		if(this.treatmentinterventiondescription == null || this.treatmentinterventiondescription.length() == 0)
			listOfErrors.add("TreatmentInterventionDescription is mandatory");
		else if(this.treatmentinterventiondescription.length() > 255)
			listOfErrors.add("The length of the field [treatmentinterventiondescription] in the value object [ims.emergency.vo.InterventionTreatmentDetailLiteVo] is too big. It should be less or equal to 255");
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
	
		InterventionTreatmentDetailLiteVo clone = new InterventionTreatmentDetailLiteVo(this.id, this.version);
		
		clone.treatmentinterventiondescription = this.treatmentinterventiondescription;
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
		if (!(InterventionTreatmentDetailLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InterventionTreatmentDetailLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InterventionTreatmentDetailLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InterventionTreatmentDetailLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentinterventiondescription != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected String treatmentinterventiondescription;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
