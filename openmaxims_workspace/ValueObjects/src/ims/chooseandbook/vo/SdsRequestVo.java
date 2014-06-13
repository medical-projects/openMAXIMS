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

package ims.chooseandbook.vo;

/**
 * Linked to choose_book.SdsRequest business object (ID: 1069100015).
 */
public class SdsRequestVo extends ims.choose_book.vo.SdsRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SdsRequestVo()
	{
	}
	public SdsRequestVo(Integer id, int version)
	{
		super(id, version);
	}
	public SdsRequestVo(ims.chooseandbook.vo.beans.SdsRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referrersdsid = bean.getReferrerSdsId();
		this.referrersdsroleid = bean.getReferrerSdsRoleId();
		this.referrersdsorgid = bean.getReferrerSdsOrgId();
		this.datetimerequested = bean.getDateTimeRequested() == null ? null : bean.getDateTimeRequested().buildDateTime();
		this.datetimelastchecked = bean.getDateTimeLastChecked() == null ? null : bean.getDateTimeLastChecked().buildDateTime();
		this.active = bean.getActive();
		this.comments = bean.getComments();
		this.appointment = bean.getAppointment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.beans.SdsRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referrersdsid = bean.getReferrerSdsId();
		this.referrersdsroleid = bean.getReferrerSdsRoleId();
		this.referrersdsorgid = bean.getReferrerSdsOrgId();
		this.datetimerequested = bean.getDateTimeRequested() == null ? null : bean.getDateTimeRequested().buildDateTime();
		this.datetimelastchecked = bean.getDateTimeLastChecked() == null ? null : bean.getDateTimeLastChecked().buildDateTime();
		this.active = bean.getActive();
		this.comments = bean.getComments();
		this.appointment = bean.getAppointment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.beans.SdsRequestVoBean bean = null;
		if(map != null)
			bean = (ims.chooseandbook.vo.beans.SdsRequestVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.chooseandbook.vo.beans.SdsRequestVoBean();
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
		if(fieldName.equals("REFERRERSDSID"))
			return getReferrerSdsId();
		if(fieldName.equals("REFERRERSDSROLEID"))
			return getReferrerSdsRoleId();
		if(fieldName.equals("REFERRERSDSORGID"))
			return getReferrerSdsOrgId();
		if(fieldName.equals("DATETIMEREQUESTED"))
			return getDateTimeRequested();
		if(fieldName.equals("DATETIMELASTCHECKED"))
			return getDateTimeLastChecked();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferrerSdsIdIsNotNull()
	{
		return this.referrersdsid != null;
	}
	public String getReferrerSdsId()
	{
		return this.referrersdsid;
	}
	public static int getReferrerSdsIdMaxLength()
	{
		return 50;
	}
	public void setReferrerSdsId(String value)
	{
		this.isValidated = false;
		this.referrersdsid = value;
	}
	public boolean getReferrerSdsRoleIdIsNotNull()
	{
		return this.referrersdsroleid != null;
	}
	public String getReferrerSdsRoleId()
	{
		return this.referrersdsroleid;
	}
	public static int getReferrerSdsRoleIdMaxLength()
	{
		return 50;
	}
	public void setReferrerSdsRoleId(String value)
	{
		this.isValidated = false;
		this.referrersdsroleid = value;
	}
	public boolean getReferrerSdsOrgIdIsNotNull()
	{
		return this.referrersdsorgid != null;
	}
	public String getReferrerSdsOrgId()
	{
		return this.referrersdsorgid;
	}
	public static int getReferrerSdsOrgIdMaxLength()
	{
		return 50;
	}
	public void setReferrerSdsOrgId(String value)
	{
		this.isValidated = false;
		this.referrersdsorgid = value;
	}
	public boolean getDateTimeRequestedIsNotNull()
	{
		return this.datetimerequested != null;
	}
	public ims.framework.utils.DateTime getDateTimeRequested()
	{
		return this.datetimerequested;
	}
	public void setDateTimeRequested(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetimerequested = value;
	}
	public boolean getDateTimeLastCheckedIsNotNull()
	{
		return this.datetimelastchecked != null;
	}
	public ims.framework.utils.DateTime getDateTimeLastChecked()
	{
		return this.datetimelastchecked;
	}
	public void setDateTimeLastChecked(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetimelastchecked = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public Integer getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(Integer value)
	{
		this.isValidated = false;
		this.appointment = value;
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
		if(this.referrersdsid != null)
			if(this.referrersdsid.length() > 50)
				listOfErrors.add("The length of the field [referrersdsid] in the value object [ims.chooseandbook.vo.SdsRequestVo] is too big. It should be less or equal to 50");
		if(this.referrersdsroleid != null)
			if(this.referrersdsroleid.length() > 50)
				listOfErrors.add("The length of the field [referrersdsroleid] in the value object [ims.chooseandbook.vo.SdsRequestVo] is too big. It should be less or equal to 50");
		if(this.referrersdsorgid != null)
			if(this.referrersdsorgid.length() > 50)
				listOfErrors.add("The length of the field [referrersdsorgid] in the value object [ims.chooseandbook.vo.SdsRequestVo] is too big. It should be less or equal to 50");
		if(this.datetimerequested == null)
			listOfErrors.add("dateTimeRequested is mandatory");
		if(this.active == null)
			listOfErrors.add("active is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.chooseandbook.vo.SdsRequestVo] is too big. It should be less or equal to 255");
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
	
		SdsRequestVo clone = new SdsRequestVo(this.id, this.version);
		
		clone.referrersdsid = this.referrersdsid;
		clone.referrersdsroleid = this.referrersdsroleid;
		clone.referrersdsorgid = this.referrersdsorgid;
		if(this.datetimerequested == null)
			clone.datetimerequested = null;
		else
			clone.datetimerequested = (ims.framework.utils.DateTime)this.datetimerequested.clone();
		if(this.datetimelastchecked == null)
			clone.datetimelastchecked = null;
		else
			clone.datetimelastchecked = (ims.framework.utils.DateTime)this.datetimelastchecked.clone();
		clone.active = this.active;
		clone.comments = this.comments;
		clone.appointment = this.appointment;
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
		if (!(SdsRequestVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SdsRequestVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SdsRequestVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SdsRequestVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referrersdsid != null)
			count++;
		if(this.referrersdsroleid != null)
			count++;
		if(this.referrersdsorgid != null)
			count++;
		if(this.datetimerequested != null)
			count++;
		if(this.datetimelastchecked != null)
			count++;
		if(this.active != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.appointment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String referrersdsid;
	protected String referrersdsroleid;
	protected String referrersdsorgid;
	protected ims.framework.utils.DateTime datetimerequested;
	protected ims.framework.utils.DateTime datetimelastchecked;
	protected Boolean active;
	protected String comments;
	protected Integer appointment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
