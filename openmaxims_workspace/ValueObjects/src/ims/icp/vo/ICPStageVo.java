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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPStage business object (ID: 1060100001).
 */
public class ICPStageVo extends ims.icp.vo.ICPStageShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPStageVo()
	{
	}
	public ICPStageVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPStageVo(ims.icp.vo.beans.ICPStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.helpurl = bean.getHelpURL();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.hasphase = bean.getHasPhase();
		this.phases = ims.icp.vo.ICPPhaseLiteVoCollection.buildFromBeanCollection(bean.getPhases());
		this.rules = ims.admin.vo.BusinessRuleVoCollection.buildFromBeanCollection(bean.getRules());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPStageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.helpurl = bean.getHelpURL();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.hasphase = bean.getHasPhase();
		this.phases = ims.icp.vo.ICPPhaseLiteVoCollection.buildFromBeanCollection(bean.getPhases());
		this.rules = ims.admin.vo.BusinessRuleVoCollection.buildFromBeanCollection(bean.getRules());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPStageVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPStageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPStageVoBean();
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
		if(fieldName.equals("RULES"))
			return getRules();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRulesIsNotNull()
	{
		return this.rules != null;
	}
	public ims.admin.vo.BusinessRuleVoCollection getRules()
	{
		return this.rules;
	}
	public void setRules(ims.admin.vo.BusinessRuleVoCollection value)
	{
		this.isValidated = false;
		this.rules = value;
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
		if(this.rules != null)
		{
			if(!this.rules.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPStageVo] is too big. It should be less or equal to 50");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.icp.vo.ICPStageVo] is too big. It should be less or equal to 500");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 255)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPStageVo] is too big. It should be less or equal to 255");
		if(this.rules != null)
		{
			String[] listOfOtherErrors = this.rules.validate();
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
	
		ICPStageVo clone = new ICPStageVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.sequence = this.sequence;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.helpurl = this.helpurl;
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
		clone.hasphase = this.hasphase;
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.icp.vo.ICPPhaseLiteVoCollection)this.phases.clone();
		if(this.rules == null)
			clone.rules = null;
		else
			clone.rules = (ims.admin.vo.BusinessRuleVoCollection)this.rules.clone();
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
		if (!(ICPStageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPStageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPStageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPStageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.rules != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.admin.vo.BusinessRuleVoCollection rules;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
