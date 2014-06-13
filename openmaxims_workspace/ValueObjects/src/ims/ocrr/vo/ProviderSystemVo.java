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
 * Linked to core.admin.ProviderSystem business object (ID: 1061100004).
 */
public class ProviderSystemVo extends ims.core.admin.vo.ProviderSystemRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProviderSystemVo()
	{
	}
	public ProviderSystemVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProviderSystemVo(ims.ocrr.vo.beans.ProviderSystemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.systemname = bean.getSystemName();
		this.description = bean.getDescription();
		this.ipaddress = bean.getIPAddress();
		this.ipport = bean.getIPPort();
		this.hl7application = bean.getHl7Application();
		this.codesystem = bean.getCodeSystem() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getCodeSystem());
		this.idtypecomponent = bean.getIdtypeComponent();
		this.primarypatientid = bean.getPrimaryPatientId() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getPrimaryPatientId());
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.configitems = ims.admin.vo.ConfigPropertyVoCollection.buildFromBeanCollection(bean.getConfigItems());
		this.sendreferralletter = bean.getSendReferralLetter();
		this.sendquestionnaire = bean.getSendQuestionnaire();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ProviderSystemVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.systemname = bean.getSystemName();
		this.description = bean.getDescription();
		this.ipaddress = bean.getIPAddress();
		this.ipport = bean.getIPPort();
		this.hl7application = bean.getHl7Application();
		this.codesystem = bean.getCodeSystem() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getCodeSystem());
		this.idtypecomponent = bean.getIdtypeComponent();
		this.primarypatientid = bean.getPrimaryPatientId() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getPrimaryPatientId());
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.configitems = ims.admin.vo.ConfigPropertyVoCollection.buildFromBeanCollection(bean.getConfigItems());
		this.sendreferralletter = bean.getSendReferralLetter();
		this.sendquestionnaire = bean.getSendQuestionnaire();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ProviderSystemVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ProviderSystemVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ProviderSystemVoBean();
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
		if(fieldName.equals("SYSTEMNAME"))
			return getSystemName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("IPADDRESS"))
			return getIPAddress();
		if(fieldName.equals("IPPORT"))
			return getIPPort();
		if(fieldName.equals("HL7APPLICATION"))
			return getHl7Application();
		if(fieldName.equals("CODESYSTEM"))
			return getCodeSystem();
		if(fieldName.equals("IDTYPECOMPONENT"))
			return getIdtypeComponent();
		if(fieldName.equals("PRIMARYPATIENTID"))
			return getPrimaryPatientId();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("CONFIGITEMS"))
			return getConfigItems();
		if(fieldName.equals("SENDREFERRALLETTER"))
			return getSendReferralLetter();
		if(fieldName.equals("SENDQUESTIONNAIRE"))
			return getSendQuestionnaire();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSystemNameIsNotNull()
	{
		return this.systemname != null;
	}
	public String getSystemName()
	{
		return this.systemname;
	}
	public static int getSystemNameMaxLength()
	{
		return 50;
	}
	public void setSystemName(String value)
	{
		this.isValidated = false;
		this.systemname = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getIPAddressIsNotNull()
	{
		return this.ipaddress != null;
	}
	public String getIPAddress()
	{
		return this.ipaddress;
	}
	public static int getIPAddressMaxLength()
	{
		return 255;
	}
	public void setIPAddress(String value)
	{
		this.isValidated = false;
		this.ipaddress = value;
	}
	public boolean getIPPortIsNotNull()
	{
		return this.ipport != null;
	}
	public Integer getIPPort()
	{
		return this.ipport;
	}
	public void setIPPort(Integer value)
	{
		this.isValidated = false;
		this.ipport = value;
	}
	public boolean getHl7ApplicationIsNotNull()
	{
		return this.hl7application != null;
	}
	public String getHl7Application()
	{
		return this.hl7application;
	}
	public static int getHl7ApplicationMaxLength()
	{
		return 100;
	}
	public void setHl7Application(String value)
	{
		this.isValidated = false;
		this.hl7application = value;
	}
	public boolean getCodeSystemIsNotNull()
	{
		return this.codesystem != null;
	}
	public ims.core.vo.lookups.TaxonomyType getCodeSystem()
	{
		return this.codesystem;
	}
	public void setCodeSystem(ims.core.vo.lookups.TaxonomyType value)
	{
		this.isValidated = false;
		this.codesystem = value;
	}
	public boolean getIdtypeComponentIsNotNull()
	{
		return this.idtypecomponent != null;
	}
	public Integer getIdtypeComponent()
	{
		return this.idtypecomponent;
	}
	public void setIdtypeComponent(Integer value)
	{
		this.isValidated = false;
		this.idtypecomponent = value;
	}
	public boolean getPrimaryPatientIdIsNotNull()
	{
		return this.primarypatientid != null;
	}
	public ims.core.vo.lookups.PatIdType getPrimaryPatientId()
	{
		return this.primarypatientid;
	}
	public void setPrimaryPatientId(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.primarypatientid = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.ocrr.vo.lookups.Category getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.ocrr.vo.lookups.Category value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getConfigItemsIsNotNull()
	{
		return this.configitems != null;
	}
	public ims.admin.vo.ConfigPropertyVoCollection getConfigItems()
	{
		return this.configitems;
	}
	public void setConfigItems(ims.admin.vo.ConfigPropertyVoCollection value)
	{
		this.isValidated = false;
		this.configitems = value;
	}
	public boolean getSendReferralLetterIsNotNull()
	{
		return this.sendreferralletter != null;
	}
	public Boolean getSendReferralLetter()
	{
		return this.sendreferralletter;
	}
	public void setSendReferralLetter(Boolean value)
	{
		this.isValidated = false;
		this.sendreferralletter = value;
	}
	public boolean getSendQuestionnaireIsNotNull()
	{
		return this.sendquestionnaire != null;
	}
	public Boolean getSendQuestionnaire()
	{
		return this.sendquestionnaire;
	}
	public void setSendQuestionnaire(Boolean value)
	{
		this.isValidated = false;
		this.sendquestionnaire = value;
	}
	/**
	* getConfigurationProperty
	*/
		public ims.admin.vo.ConfigPropertyVo getConfigurationProperty(String property)
		{
			if (configitems == null) return null;
			for (int i = 0; i < configitems.size(); i++)
			{
				ims.admin.vo.ConfigPropertyVo vo = configitems.get(i);
				if (vo.getPropertyName().equals(property))
				{
					return vo;
				}
			}
			return null;
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
		if(this.configitems != null)
		{
			if(!this.configitems.isValidated())
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
		if(this.systemname == null || this.systemname.length() == 0)
			listOfErrors.add("System Name is mandatory");
		else if(this.systemname.length() > 50)
			listOfErrors.add("The length of the field [systemname] in the value object [ims.ocrr.vo.ProviderSystemVo] is too big. It should be less or equal to 50");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.ocrr.vo.ProviderSystemVo] is too big. It should be less or equal to 500");
		if(this.ipaddress == null || this.ipaddress.length() == 0)
			listOfErrors.add("IP Address or Host Name is mandatory");
		else if(this.ipaddress.length() > 255)
			listOfErrors.add("The length of the field [ipaddress] in the value object [ims.ocrr.vo.ProviderSystemVo] is too big. It should be less or equal to 255");
		if(this.ipport == null)
			listOfErrors.add("Port is mandatory");
		if(this.hl7application == null || this.hl7application.length() == 0)
			listOfErrors.add("HL7 Application is mandatory");
		else if(this.hl7application.length() > 100)
			listOfErrors.add("The length of the field [hl7application] in the value object [ims.ocrr.vo.ProviderSystemVo] is too big. It should be less or equal to 100");
		if(this.codesystem == null)
			listOfErrors.add("Code System is mandatory");
		if(this.idtypecomponent == null)
			listOfErrors.add("ID Component is mandatory");
		if(this.primarypatientid == null)
			listOfErrors.add("PrimaryPatientId is mandatory");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.configitems != null)
		{
			String[] listOfOtherErrors = this.configitems.validate();
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
	
		ProviderSystemVo clone = new ProviderSystemVo(this.id, this.version);
		
		clone.systemname = this.systemname;
		clone.description = this.description;
		clone.ipaddress = this.ipaddress;
		clone.ipport = this.ipport;
		clone.hl7application = this.hl7application;
		if(this.codesystem == null)
			clone.codesystem = null;
		else
			clone.codesystem = (ims.core.vo.lookups.TaxonomyType)this.codesystem.clone();
		clone.idtypecomponent = this.idtypecomponent;
		if(this.primarypatientid == null)
			clone.primarypatientid = null;
		else
			clone.primarypatientid = (ims.core.vo.lookups.PatIdType)this.primarypatientid.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.ocrr.vo.lookups.Category)this.category.clone();
		if(this.configitems == null)
			clone.configitems = null;
		else
			clone.configitems = (ims.admin.vo.ConfigPropertyVoCollection)this.configitems.clone();
		clone.sendreferralletter = this.sendreferralletter;
		clone.sendquestionnaire = this.sendquestionnaire;
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
		if (!(ProviderSystemVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProviderSystemVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ProviderSystemVo compareObj = (ProviderSystemVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSystemName() == null && compareObj.getSystemName() != null)
				return -1;
			if(this.getSystemName() != null && compareObj.getSystemName() == null)
				return 1;
			if(this.getSystemName() != null && compareObj.getSystemName() != null)
			{
				if(caseInsensitive)
					retVal = this.getSystemName().toLowerCase().compareTo(compareObj.getSystemName().toLowerCase());
				else
					retVal = this.getSystemName().compareTo(compareObj.getSystemName());
			}
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
		if(this.systemname != null)
			count++;
		if(this.description != null)
			count++;
		if(this.ipaddress != null)
			count++;
		if(this.ipport != null)
			count++;
		if(this.hl7application != null)
			count++;
		if(this.codesystem != null)
			count++;
		if(this.idtypecomponent != null)
			count++;
		if(this.primarypatientid != null)
			count++;
		if(this.category != null)
			count++;
		if(this.configitems != null)
			count++;
		if(this.sendreferralletter != null)
			count++;
		if(this.sendquestionnaire != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String systemname;
	protected String description;
	protected String ipaddress;
	protected Integer ipport;
	protected String hl7application;
	protected ims.core.vo.lookups.TaxonomyType codesystem;
	protected Integer idtypecomponent;
	protected ims.core.vo.lookups.PatIdType primarypatientid;
	protected ims.ocrr.vo.lookups.Category category;
	protected ims.admin.vo.ConfigPropertyVoCollection configitems;
	protected Boolean sendreferralletter;
	protected Boolean sendquestionnaire;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
