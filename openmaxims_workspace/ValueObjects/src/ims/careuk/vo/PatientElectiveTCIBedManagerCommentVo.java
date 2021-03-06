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
 * Linked to CAREUK.TCIForPatientElectiveList business object (ID: 1096100064).
 */
public class PatientElectiveTCIBedManagerCommentVo extends ims.careuk.vo.TCIForPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveTCIBedManagerCommentVo()
	{
	}
	public PatientElectiveTCIBedManagerCommentVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveTCIBedManagerCommentVo(ims.careuk.vo.beans.PatientElectiveTCIBedManagerCommentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedmanagercomment = bean.getBedManagerComment();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientElectiveTCIBedManagerCommentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedmanagercomment = bean.getBedManagerComment();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientElectiveTCIBedManagerCommentVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientElectiveTCIBedManagerCommentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientElectiveTCIBedManagerCommentVoBean();
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
		if(fieldName.equals("BEDMANAGERCOMMENT"))
			return getBedManagerComment();
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBedManagerCommentIsNotNull()
	{
		return this.bedmanagercomment != null;
	}
	public String getBedManagerComment()
	{
		return this.bedmanagercomment;
	}
	public static int getBedManagerCommentMaxLength()
	{
		return 1000;
	}
	public void setBedManagerComment(String value)
	{
		this.isValidated = false;
		this.bedmanagercomment = value;
	}
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
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
		if(this.bedmanagercomment != null)
			if(this.bedmanagercomment.length() > 1000)
				listOfErrors.add("The length of the field [bedmanagercomment] in the value object [ims.careuk.vo.PatientElectiveTCIBedManagerCommentVo] is too big. It should be less or equal to 1000");
		if(this.tcidate == null)
			listOfErrors.add("TCIDate is mandatory");
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
	
		PatientElectiveTCIBedManagerCommentVo clone = new PatientElectiveTCIBedManagerCommentVo(this.id, this.version);
		
		clone.bedmanagercomment = this.bedmanagercomment;
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
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
		if (!(PatientElectiveTCIBedManagerCommentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveTCIBedManagerCommentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveTCIBedManagerCommentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveTCIBedManagerCommentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.bedmanagercomment != null)
			count++;
		if(this.tcidate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String bedmanagercomment;
	protected ims.framework.utils.Date tcidate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
