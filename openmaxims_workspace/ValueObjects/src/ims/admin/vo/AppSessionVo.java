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


public class AppSessionVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppSessionVo()
	{
	}
	public AppSessionVo(ims.admin.vo.beans.AppSessionVoBean bean)
	{
		this.sessionid = bean.getSessionId();
		this.username = bean.getUsername();
		this.realname = bean.getRealName();
		this.role = bean.getRole();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildDateTime();
		this.idletime = bean.getIdleTime();
		this.timeout = bean.getTimeout();
		this.currentform = bean.getCurrentForm();
		this.isloggingenabled = bean.getIsLoggingEnabled();
		this.remotehost = bean.getRemoteHost();
		this.remoteaddress = bean.getRemoteAddress();
		this.node = bean.getNode();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppSessionVoBean bean)
	{
		this.sessionid = bean.getSessionId();
		this.username = bean.getUsername();
		this.realname = bean.getRealName();
		this.role = bean.getRole();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildDateTime();
		this.idletime = bean.getIdleTime();
		this.timeout = bean.getTimeout();
		this.currentform = bean.getCurrentForm();
		this.isloggingenabled = bean.getIsLoggingEnabled();
		this.remotehost = bean.getRemoteHost();
		this.remoteaddress = bean.getRemoteAddress();
		this.node = bean.getNode();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppSessionVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppSessionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppSessionVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSessionIdIsNotNull()
	{
		return this.sessionid != null;
	}
	public String getSessionId()
	{
		return this.sessionid;
	}
	public static int getSessionIdMaxLength()
	{
		return 255;
	}
	public void setSessionId(String value)
	{
		this.isValidated = false;
		this.sessionid = value;
	}
	public boolean getUsernameIsNotNull()
	{
		return this.username != null;
	}
	public String getUsername()
	{
		return this.username;
	}
	public static int getUsernameMaxLength()
	{
		return 255;
	}
	public void setUsername(String value)
	{
		this.isValidated = false;
		this.username = value;
	}
	public boolean getRealNameIsNotNull()
	{
		return this.realname != null;
	}
	public String getRealName()
	{
		return this.realname;
	}
	public static int getRealNameMaxLength()
	{
		return 255;
	}
	public void setRealName(String value)
	{
		this.isValidated = false;
		this.realname = value;
	}
	public boolean getRoleIsNotNull()
	{
		return this.role != null;
	}
	public String getRole()
	{
		return this.role;
	}
	public static int getRoleMaxLength()
	{
		return 255;
	}
	public void setRole(String value)
	{
		this.isValidated = false;
		this.role = value;
	}
	public boolean getStartTimeIsNotNull()
	{
		return this.starttime != null;
	}
	public ims.framework.utils.DateTime getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.starttime = value;
	}
	public boolean getIdleTimeIsNotNull()
	{
		return this.idletime != null;
	}
	public Integer getIdleTime()
	{
		return this.idletime;
	}
	public void setIdleTime(Integer value)
	{
		this.isValidated = false;
		this.idletime = value;
	}
	public boolean getTimeoutIsNotNull()
	{
		return this.timeout != null;
	}
	public Integer getTimeout()
	{
		return this.timeout;
	}
	public void setTimeout(Integer value)
	{
		this.isValidated = false;
		this.timeout = value;
	}
	public boolean getCurrentFormIsNotNull()
	{
		return this.currentform != null;
	}
	public String getCurrentForm()
	{
		return this.currentform;
	}
	public static int getCurrentFormMaxLength()
	{
		return 255;
	}
	public void setCurrentForm(String value)
	{
		this.isValidated = false;
		this.currentform = value;
	}
	public boolean getIsLoggingEnabledIsNotNull()
	{
		return this.isloggingenabled != null;
	}
	public Boolean getIsLoggingEnabled()
	{
		return this.isloggingenabled;
	}
	public void setIsLoggingEnabled(Boolean value)
	{
		this.isValidated = false;
		this.isloggingenabled = value;
	}
	public boolean getRemoteHostIsNotNull()
	{
		return this.remotehost != null;
	}
	public String getRemoteHost()
	{
		return this.remotehost;
	}
	public static int getRemoteHostMaxLength()
	{
		return 255;
	}
	public void setRemoteHost(String value)
	{
		this.isValidated = false;
		this.remotehost = value;
	}
	public boolean getRemoteAddressIsNotNull()
	{
		return this.remoteaddress != null;
	}
	public String getRemoteAddress()
	{
		return this.remoteaddress;
	}
	public static int getRemoteAddressMaxLength()
	{
		return 255;
	}
	public void setRemoteAddress(String value)
	{
		this.isValidated = false;
		this.remoteaddress = value;
	}
	public boolean getNodeIsNotNull()
	{
		return this.node != null;
	}
	public String getNode()
	{
		return this.node;
	}
	public static int getNodeMaxLength()
	{
		return 255;
	}
	public void setNode(String value)
	{
		this.isValidated = false;
		this.node = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof AppSessionVo))
			return false;
		AppSessionVo compareObj = (AppSessionVo)obj;
		if(this.getSessionId() == null && compareObj.getSessionId() != null)
			return false;
		if(this.getSessionId() != null && compareObj.getSessionId() == null)
			return false;
		if(this.getSessionId() != null && compareObj.getSessionId() != null)
			return this.getSessionId().equals(compareObj.getSessionId());
		return super.equals(obj);
	}
	/**
	* Dom2Vo: Assembles an AppSessionVo a domain AppSession instance
	*/
	public static ims.admin.vo.AppSessionVo Dom2Vo(ims.domain.admin.AppSession domSess)
	{
		ims.admin.vo.AppSessionVo vo = new ims.admin.vo.AppSessionVo();
		vo.setSessionId(domSess.getSessionId());
		vo.setUsername(domSess.getUserName());
		vo.setRealName(domSess.getRealName());
		vo.setRole(domSess.getRoleName());
		vo.setStartTime(domSess.getStartTime());
		vo.setIdleTime(new Integer((int)domSess.getIdleTime()));
		vo.setTimeout(new Integer(domSess.getSessionTimeOut()));
		vo.setCurrentForm(domSess.getCurrentForm());
		vo.setRemoteHost(domSess.getRemoteHost());
		vo.setRemoteAddress(domSess.getRemoteAddress());
		vo.setIsLoggingEnabled(new Boolean(domSess.loggingEnabled()));	
	
		return vo;
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		AppSessionVo clone = new AppSessionVo();
		
		clone.sessionid = this.sessionid;
		clone.username = this.username;
		clone.realname = this.realname;
		clone.role = this.role;
		if(this.starttime == null)
			clone.starttime = null;
		else
			clone.starttime = (ims.framework.utils.DateTime)this.starttime.clone();
		clone.idletime = this.idletime;
		clone.timeout = this.timeout;
		clone.currentform = this.currentform;
		clone.isloggingenabled = this.isloggingenabled;
		clone.remotehost = this.remotehost;
		clone.remoteaddress = this.remoteaddress;
		clone.node = this.node;
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
		if (!(AppSessionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppSessionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AppSessionVo compareObj = (AppSessionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStartTime() == null && compareObj.getStartTime() != null)
				return -1;
			if(this.getStartTime() != null && compareObj.getStartTime() == null)
				return 1;
			if(this.getStartTime() != null && compareObj.getStartTime() != null)
				retVal = this.getStartTime().compareTo(compareObj.getStartTime());
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
		if(this.sessionid != null)
			count++;
		if(this.username != null)
			count++;
		if(this.realname != null)
			count++;
		if(this.role != null)
			count++;
		if(this.starttime != null)
			count++;
		if(this.idletime != null)
			count++;
		if(this.timeout != null)
			count++;
		if(this.currentform != null)
			count++;
		if(this.isloggingenabled != null)
			count++;
		if(this.remotehost != null)
			count++;
		if(this.remoteaddress != null)
			count++;
		if(this.node != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String sessionid;
	protected String username;
	protected String realname;
	protected String role;
	protected ims.framework.utils.DateTime starttime;
	protected Integer idletime;
	protected Integer timeout;
	protected String currentform;
	protected Boolean isloggingenabled;
	protected String remotehost;
	protected String remoteaddress;
	protected String node;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
