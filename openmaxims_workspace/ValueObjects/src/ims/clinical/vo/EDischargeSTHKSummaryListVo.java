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
 * Linked to eDischarge.Summary business object (ID: 1099100018).
 */
public class EDischargeSTHKSummaryListVo extends ims.edischarge.vo.SummaryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EDischargeSTHKSummaryListVo()
	{
	}
	public EDischargeSTHKSummaryListVo(Integer id, int version)
	{
		super(id, version);
	}
	public EDischargeSTHKSummaryListVo(ims.clinical.vo.beans.EDischargeSTHKSummaryListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.dischargeletterstatus = bean.getDischargeLetterStatus() == null ? null : ims.clinical.vo.lookups.DischargeLetterStatus.buildLookup(bean.getDischargeLetterStatus());
		this.summarydetails = ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection.buildFromBeanCollection(bean.getSummaryDetails());
		this.dischargedetails = bean.getDischargeDetails() == null ? null : bean.getDischargeDetails().buildVo();
		this.ttastatus = bean.getTTAStatus() == null ? null : ims.clinical.vo.lookups.TTAStatus.buildLookup(bean.getTTAStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EDischargeSTHKSummaryListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.dischargeletterstatus = bean.getDischargeLetterStatus() == null ? null : ims.clinical.vo.lookups.DischargeLetterStatus.buildLookup(bean.getDischargeLetterStatus());
		this.summarydetails = ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection.buildFromBeanCollection(bean.getSummaryDetails());
		this.dischargedetails = bean.getDischargeDetails() == null ? null : bean.getDischargeDetails().buildVo(map);
		this.ttastatus = bean.getTTAStatus() == null ? null : ims.clinical.vo.lookups.TTAStatus.buildLookup(bean.getTTAStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EDischargeSTHKSummaryListVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EDischargeSTHKSummaryListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EDischargeSTHKSummaryListVoBean();
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
		if(fieldName.equals("DISCHARGELETTERSTATUS"))
			return getDischargeLetterStatus();
		if(fieldName.equals("SUMMARYDETAILS"))
			return getSummaryDetails();
		if(fieldName.equals("DISCHARGEDETAILS"))
			return getDischargeDetails();
		if(fieldName.equals("TTASTATUS"))
			return getTTAStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextEdischargeListVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextEdischargeListVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getDischargeLetterStatusIsNotNull()
	{
		return this.dischargeletterstatus != null;
	}
	public ims.clinical.vo.lookups.DischargeLetterStatus getDischargeLetterStatus()
	{
		return this.dischargeletterstatus;
	}
	public void setDischargeLetterStatus(ims.clinical.vo.lookups.DischargeLetterStatus value)
	{
		this.isValidated = false;
		this.dischargeletterstatus = value;
	}
	public boolean getSummaryDetailsIsNotNull()
	{
		return this.summarydetails != null;
	}
	public ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection getSummaryDetails()
	{
		return this.summarydetails;
	}
	public void setSummaryDetails(ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection value)
	{
		this.isValidated = false;
		this.summarydetails = value;
	}
	public boolean getDischargeDetailsIsNotNull()
	{
		return this.dischargedetails != null;
	}
	public ims.clinical.vo.DischargeDetailsListVo getDischargeDetails()
	{
		return this.dischargedetails;
	}
	public void setDischargeDetails(ims.clinical.vo.DischargeDetailsListVo value)
	{
		this.isValidated = false;
		this.dischargedetails = value;
	}
	public boolean getTTAStatusIsNotNull()
	{
		return this.ttastatus != null;
	}
	public ims.clinical.vo.lookups.TTAStatus getTTAStatus()
	{
		return this.ttastatus;
	}
	public void setTTAStatus(ims.clinical.vo.lookups.TTAStatus value)
	{
		this.isValidated = false;
		this.ttastatus = value;
	}
	/**
	* isSummaryRecordComplete
	*/
	public boolean isSummaryRecordComplete()
	{
		boolean bDetailsComplete = true;
		for (int i =0 ; this.getSummaryDetailsIsNotNull() &&  i < this.getSummaryDetails().size() ; i++)
		{
			if (! (this.getSummaryDetails().get(i).getProgressStatusIsNotNull()
				&& this.getSummaryDetails().get(i).getProgressStatus().equals(ims.clinical.vo.lookups.EDischargeSummarySectionStatus.COMPLETED)))
				bDetailsComplete = false;
		}
			
		if (bDetailsComplete
			&& this.getTTAStatusIsNotNull()
			&& (this.getTTAStatus().equals(ims.clinical.vo.lookups.TTAStatus.NOT_REQUIRED)
					|| this.getTTAStatus().equals(ims.clinical.vo.lookups.TTAStatus.COMPLETED)) )
			return true;
			
		return false;
	}
	
	/**
	* EDischargeSTHKSummaryListVoDateTimeComparator  (class definition)
	*/
	public static class EDischargeSTHKSummaryListVoDateTimeComparator implements java.util.Comparator
	{
		private int direction = 1;
		public EDischargeSTHKSummaryListVoDateTimeComparator ()
		{
			this(ims.framework.enumerations.SortOrder.ASCENDING);
		}
		public EDischargeSTHKSummaryListVoDateTimeComparator (ims.framework.enumerations.SortOrder order)
		{
			if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				direction = -1;
		}
		public int compare(Object obj1, Object obj2)
		{
			DischargeDetailsListVo voObj1 = ((EDischargeSTHKSummaryListVo)obj1).getDischargeDetails();
			DischargeDetailsListVo voObj2 = ((EDischargeSTHKSummaryListVo)obj2).getDischargeDetails();
			if (voObj1 == null
				||voObj1.getDateOfDischarge() == null)
				return -direction;//1;
			
			if (voObj2 == null
				|| voObj2.getDateOfDischarge() == null)
				return direction;//1;			
				
			return direction*(voObj1.getDateOfDischarge().compareTo(voObj2.getDateOfDischarge()));	
		}
		public boolean equals(Object obj)
		{
			return false;
		}	
	}
	
	/**
	* getDateTimeComparator - retrieves a new instance of static class EDischargeSTHKSummaryListVoDateTimeComparator
	*/
	public static EDischargeSTHKSummaryListVoDateTimeComparator getDateTimeComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new EDischargeSTHKSummaryListVo.EDischargeSTHKSummaryListVoDateTimeComparator(sortOrder);
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
		if(this.carecontext != null)
		{
			if(!this.carecontext.isValidated())
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
		if(this.carecontext != null)
		{
			String[] listOfOtherErrors = this.carecontext.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dischargeletterstatus == null)
			listOfErrors.add("DischargeLetterStatus is mandatory");
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
	
		EDischargeSTHKSummaryListVo clone = new EDischargeSTHKSummaryListVo(this.id, this.version);
		
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextEdischargeListVo)this.carecontext.clone();
		if(this.dischargeletterstatus == null)
			clone.dischargeletterstatus = null;
		else
			clone.dischargeletterstatus = (ims.clinical.vo.lookups.DischargeLetterStatus)this.dischargeletterstatus.clone();
		if(this.summarydetails == null)
			clone.summarydetails = null;
		else
			clone.summarydetails = (ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection)this.summarydetails.clone();
		if(this.dischargedetails == null)
			clone.dischargedetails = null;
		else
			clone.dischargedetails = (ims.clinical.vo.DischargeDetailsListVo)this.dischargedetails.clone();
		if(this.ttastatus == null)
			clone.ttastatus = null;
		else
			clone.ttastatus = (ims.clinical.vo.lookups.TTAStatus)this.ttastatus.clone();
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
		if (!(EDischargeSTHKSummaryListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EDischargeSTHKSummaryListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EDischargeSTHKSummaryListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EDischargeSTHKSummaryListVo)obj).getBoId());
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
		if(this.dischargeletterstatus != null)
			count++;
		if(this.summarydetails != null)
			count++;
		if(this.dischargedetails != null)
			count++;
		if(this.ttastatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.CareContextEdischargeListVo carecontext;
	protected ims.clinical.vo.lookups.DischargeLetterStatus dischargeletterstatus;
	protected ims.clinical.vo.EDischargeSTHKSummaryDetailVoCollection summarydetails;
	protected ims.clinical.vo.DischargeDetailsListVo dischargedetails;
	protected ims.clinical.vo.lookups.TTAStatus ttastatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
