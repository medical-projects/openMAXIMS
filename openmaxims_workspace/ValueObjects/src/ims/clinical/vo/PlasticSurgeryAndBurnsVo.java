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
 * Linked to eDischarge.PlasticSurgeryAndBurns business object (ID: 1099100012).
 */
public class PlasticSurgeryAndBurnsVo extends ims.edischarge.vo.PlasticSurgeryAndBurnsRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IEDischargeSummary
{
	private static final long serialVersionUID = 1L;

	public PlasticSurgeryAndBurnsVo()
	{
	}
	public PlasticSurgeryAndBurnsVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlasticSurgeryAndBurnsVo(ims.clinical.vo.beans.PlasticSurgeryAndBurnsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.skinforstorage = bean.getSkinForStorage() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinForStorage());
		this.scheduledfirstdressingdate = bean.getScheduledFirstDressingDate() == null ? null : bean.getScheduledFirstDressingDate().buildDate();
		this.scheduledsutureremoval = bean.getScheduledSutureRemoval() == null ? null : bean.getScheduledSutureRemoval().buildDate();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo();
		this.iscomplete = bean.getIsComplete();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PlasticSurgeryAndBurnsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.skinforstorage = bean.getSkinForStorage() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinForStorage());
		this.scheduledfirstdressingdate = bean.getScheduledFirstDressingDate() == null ? null : bean.getScheduledFirstDressingDate().buildDate();
		this.scheduledsutureremoval = bean.getScheduledSutureRemoval() == null ? null : bean.getScheduledSutureRemoval().buildDate();
		this.surgeon = bean.getSurgeon() == null ? null : bean.getSurgeon().buildVo(map);
		this.iscomplete = bean.getIsComplete();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PlasticSurgeryAndBurnsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PlasticSurgeryAndBurnsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PlasticSurgeryAndBurnsVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ANAESTHETICTYPE"))
			return getAnaestheticType();
		if(fieldName.equals("SKINFORSTORAGE"))
			return getSkinForStorage();
		if(fieldName.equals("SCHEDULEDFIRSTDRESSINGDATE"))
			return getScheduledFirstDressingDate();
		if(fieldName.equals("SCHEDULEDSUTUREREMOVAL"))
			return getScheduledSutureRemoval();
		if(fieldName.equals("SURGEON"))
			return getSurgeon();
		if(fieldName.equals("ISCOMPLETE"))
			return getIsComplete();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAnaestheticTypeIsNotNull()
	{
		return this.anaesthetictype != null;
	}
	public ims.clinical.vo.lookups.AnaestheticType getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.clinical.vo.lookups.AnaestheticType value)
	{
		this.isValidated = false;
		this.anaesthetictype = value;
	}
	public boolean getSkinForStorageIsNotNull()
	{
		return this.skinforstorage != null;
	}
	public ims.core.vo.lookups.YesNo getSkinForStorage()
	{
		return this.skinforstorage;
	}
	public void setSkinForStorage(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.skinforstorage = value;
	}
	public boolean getScheduledFirstDressingDateIsNotNull()
	{
		return this.scheduledfirstdressingdate != null;
	}
	public ims.framework.utils.Date getScheduledFirstDressingDate()
	{
		return this.scheduledfirstdressingdate;
	}
	public void setScheduledFirstDressingDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.scheduledfirstdressingdate = value;
	}
	public boolean getScheduledSutureRemovalIsNotNull()
	{
		return this.scheduledsutureremoval != null;
	}
	public ims.framework.utils.Date getScheduledSutureRemoval()
	{
		return this.scheduledsutureremoval;
	}
	public void setScheduledSutureRemoval(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.scheduledsutureremoval = value;
	}
	public boolean getSurgeonIsNotNull()
	{
		return this.surgeon != null;
	}
	public ims.core.vo.HcpLiteVo getSurgeon()
	{
		return this.surgeon;
	}
	public void setSurgeon(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.surgeon = value;
	}
	public boolean getIsCompleteIsNotNull()
	{
		return this.iscomplete != null;
	}
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.isValidated = false;
		this.iscomplete = value;
	}
	/**
	* IEDischargeSummary interface method
	*/
	public Boolean getIEDischargeSummaryIsComplete()
	{
		return iscomplete != null ? iscomplete : false;
	}
	public ims.clinical.vo.lookups.EDischargeSummarySection getIEDischargeSummarySection()
	{
		return ims.clinical.vo.lookups.EDischargeSummarySection.PLASTICS;
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
		if(this.surgeon != null)
		{
			if(!this.surgeon.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.anaesthetictype == null)
			listOfErrors.add("AnaestheticType is mandatory");
		if(this.surgeon == null)
			listOfErrors.add("Surgeon is mandatory");
		if(this.surgeon != null)
		{
			String[] listOfOtherErrors = this.surgeon.validate();
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
	
		PlasticSurgeryAndBurnsVo clone = new PlasticSurgeryAndBurnsVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		if(this.skinforstorage == null)
			clone.skinforstorage = null;
		else
			clone.skinforstorage = (ims.core.vo.lookups.YesNo)this.skinforstorage.clone();
		if(this.scheduledfirstdressingdate == null)
			clone.scheduledfirstdressingdate = null;
		else
			clone.scheduledfirstdressingdate = (ims.framework.utils.Date)this.scheduledfirstdressingdate.clone();
		if(this.scheduledsutureremoval == null)
			clone.scheduledsutureremoval = null;
		else
			clone.scheduledsutureremoval = (ims.framework.utils.Date)this.scheduledsutureremoval.clone();
		if(this.surgeon == null)
			clone.surgeon = null;
		else
			clone.surgeon = (ims.core.vo.HcpLiteVo)this.surgeon.clone();
		clone.iscomplete = this.iscomplete;
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
		if (!(PlasticSurgeryAndBurnsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlasticSurgeryAndBurnsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PlasticSurgeryAndBurnsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PlasticSurgeryAndBurnsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.skinforstorage != null)
			count++;
		if(this.scheduledfirstdressingdate != null)
			count++;
		if(this.scheduledsutureremoval != null)
			count++;
		if(this.surgeon != null)
			count++;
		if(this.iscomplete != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected ims.core.vo.lookups.YesNo skinforstorage;
	protected ims.framework.utils.Date scheduledfirstdressingdate;
	protected ims.framework.utils.Date scheduledsutureremoval;
	protected ims.core.vo.HcpLiteVo surgeon;
	protected Boolean iscomplete;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
