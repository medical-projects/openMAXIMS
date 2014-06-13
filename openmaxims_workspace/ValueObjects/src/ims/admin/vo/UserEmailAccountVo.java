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

/**
 * Linked to core.admin.UserEmailAccount business object (ID: 1004100026).
 */
public class UserEmailAccountVo extends ims.core.admin.vo.UserEmailAccountRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IEmailAuthor, ims.framework.interfaces.IEmailAuthentication
{
	private static final long serialVersionUID = 1L;

	public UserEmailAccountVo()
	{
	}
	public UserEmailAccountVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserEmailAccountVo(ims.admin.vo.beans.UserEmailAccountVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pop = bean.getPOP();
		this.smtp = bean.getSMTP();
		this.userlogon = bean.getUserLogon();
		this.userpassword = bean.getUserPassword();
		this.popport = bean.getPOPPort();
		this.smtpport = bean.getSMTPPort();
		this.emailaddress = bean.getEmailAddress();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.UserEmailAccountVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pop = bean.getPOP();
		this.smtp = bean.getSMTP();
		this.userlogon = bean.getUserLogon();
		this.userpassword = bean.getUserPassword();
		this.popport = bean.getPOPPort();
		this.smtpport = bean.getSMTPPort();
		this.emailaddress = bean.getEmailAddress();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.UserEmailAccountVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.UserEmailAccountVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.UserEmailAccountVoBean();
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
		if(fieldName.equals("POP"))
			return getPOP();
		if(fieldName.equals("SMTP"))
			return getSMTP();
		if(fieldName.equals("USERLOGON"))
			return getUserLogon();
		if(fieldName.equals("USERPASSWORD"))
			return getUserPassword();
		if(fieldName.equals("POPPORT"))
			return getPOPPort();
		if(fieldName.equals("SMTPPORT"))
			return getSMTPPort();
		if(fieldName.equals("EMAILADDRESS"))
			return getEmailAddress();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPOPIsNotNull()
	{
		return this.pop != null;
	}
	public String getPOP()
	{
		return this.pop;
	}
	public static int getPOPMaxLength()
	{
		return 150;
	}
	public void setPOP(String value)
	{
		this.isValidated = false;
		this.pop = value;
	}
	public boolean getSMTPIsNotNull()
	{
		return this.smtp != null;
	}
	public String getSMTP()
	{
		return this.smtp;
	}
	public static int getSMTPMaxLength()
	{
		return 150;
	}
	public void setSMTP(String value)
	{
		this.isValidated = false;
		this.smtp = value;
	}
	public boolean getUserLogonIsNotNull()
	{
		return this.userlogon != null;
	}
	public String getUserLogon()
	{
		return this.userlogon;
	}
	public static int getUserLogonMaxLength()
	{
		return 150;
	}
	public void setUserLogon(String value)
	{
		this.isValidated = false;
		this.userlogon = value;
	}
	public boolean getUserPasswordIsNotNull()
	{
		return this.userpassword != null;
	}
	public String getUserPassword()
	{
		return this.userpassword;
	}
	public static int getUserPasswordMaxLength()
	{
		return 150;
	}
	public void setUserPassword(String value)
	{
		this.isValidated = false;
		this.userpassword = value;
	}
	public boolean getPOPPortIsNotNull()
	{
		return this.popport != null;
	}
	public String getPOPPort()
	{
		return this.popport;
	}
	public static int getPOPPortMaxLength()
	{
		return 150;
	}
	public void setPOPPort(String value)
	{
		this.isValidated = false;
		this.popport = value;
	}
	public boolean getSMTPPortIsNotNull()
	{
		return this.smtpport != null;
	}
	public String getSMTPPort()
	{
		return this.smtpport;
	}
	public static int getSMTPPortMaxLength()
	{
		return 150;
	}
	public void setSMTPPort(String value)
	{
		this.isValidated = false;
		this.smtpport = value;
	}
	public boolean getEmailAddressIsNotNull()
	{
		return this.emailaddress != null;
	}
	public String getEmailAddress()
	{
		return this.emailaddress;
	}
	public static int getEmailAddressMaxLength()
	{
		return 50;
	}
	public void setEmailAddress(String value)
	{
		this.isValidated = false;
		this.emailaddress = value;
	}
	/**
	* IEmailAuthentication Interface methods
	*/
		public String getAuthenticationName()
		{
			return this.userlogon;
		}
		public String getAuthenticationPassword()
		{
			return this.userpassword;
		}
		
		private String getCommChannel(ims.core.vo.CommChannelVoCollection voCollCommChannel,ims.core.vo.lookups.ChannelType lkChannelType )
		{
			if (voCollCommChannel != null && voCollCommChannel.size() > 0)
			{
				for(int i=0; i < voCollCommChannel.size(); i++)
					if (voCollCommChannel.get(i).getChannelType().equals(lkChannelType))
						return voCollCommChannel.get(i).getCommValue();
			}
			return null;
		}
				
		public String getPOPServer() 
		{
			return this.pop;
		}
	
		public String getSMTPServer() 
		{
			return this.smtp;
		}
		
		public void setAutentication(String userName, String password) 
		{			
			auth = new EmailAuthenticator(userName,password);
		}		
	
		public javax.mail.Authenticator getAuthentication()
		{
			return auth;
		}
		
		public class EmailAuthenticator extends javax.mail.Authenticator
		{
			private String username;
			private String password;
				EmailAuthenticator(String username,String password)
			{
				this.password = password;
				this.username = username;
			}
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
			{
				return new javax.mail.PasswordAuthentication(username,password);
			}
		}
		
		private EmailAuthenticator auth;
	
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
		if(this.pop != null)
			if(this.pop.length() > 150)
				listOfErrors.add("The length of the field [pop] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.smtp == null || this.smtp.length() == 0)
			listOfErrors.add("SMTP is mandatory");
		else if(this.smtp.length() > 150)
			listOfErrors.add("The length of the field [smtp] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.userlogon == null || this.userlogon.length() == 0)
			listOfErrors.add("UserLogon is mandatory");
		else if(this.userlogon.length() > 150)
			listOfErrors.add("The length of the field [userlogon] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.userpassword == null || this.userpassword.length() == 0)
			listOfErrors.add("UserPassword is mandatory");
		else if(this.userpassword.length() > 150)
			listOfErrors.add("The length of the field [userpassword] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.popport != null)
			if(this.popport.length() > 150)
				listOfErrors.add("The length of the field [popport] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.smtpport != null)
			if(this.smtpport.length() > 150)
				listOfErrors.add("The length of the field [smtpport] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 150");
		if(this.emailaddress != null)
			if(this.emailaddress.length() > 50)
				listOfErrors.add("The length of the field [emailaddress] in the value object [ims.admin.vo.UserEmailAccountVo] is too big. It should be less or equal to 50");
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
	
		UserEmailAccountVo clone = new UserEmailAccountVo(this.id, this.version);
		
		clone.pop = this.pop;
		clone.smtp = this.smtp;
		clone.userlogon = this.userlogon;
		clone.userpassword = this.userpassword;
		clone.popport = this.popport;
		clone.smtpport = this.smtpport;
		clone.emailaddress = this.emailaddress;
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
		if (!(UserEmailAccountVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserEmailAccountVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((UserEmailAccountVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((UserEmailAccountVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pop != null)
			count++;
		if(this.smtp != null)
			count++;
		if(this.userlogon != null)
			count++;
		if(this.userpassword != null)
			count++;
		if(this.popport != null)
			count++;
		if(this.smtpport != null)
			count++;
		if(this.emailaddress != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String pop;
	protected String smtp;
	protected String userlogon;
	protected String userpassword;
	protected String popport;
	protected String smtpport;
	protected String emailaddress;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
