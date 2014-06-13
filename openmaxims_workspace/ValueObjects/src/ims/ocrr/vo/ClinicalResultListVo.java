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
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class ClinicalResultListVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalResultListVo()
	{
	}
	public ClinicalResultListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalResultListVo(ims.ocrr.vo.beans.ClinicalResultListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo();
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ClinicalResultListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo(map);
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo(map);
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.ordinvxostatushistory = ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection.buildFromBeanCollection(bean.getOrdInvXOStatusHistory());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ClinicalResultListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ClinicalResultListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ClinicalResultListVoBean();
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
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("REPTIMESUPPLIED"))
			return getRepTimeSupplied();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("DISPLAYFLAG"))
			return getDisplayFlag();
		if(fieldName.equals("RESULTDEMOGRAPHICS"))
			return getResultDemographics();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("ORDINVXOSTATUSHISTORY"))
			return getOrdInvXOStatusHistory();
		if(fieldName.equals("RESULTCONCLUSIONCOMMENTS"))
			return getResultConclusionComments();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("ALLOCATEDHCPFORREVIEW"))
			return getAllocatedHCPforReview();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.NewResultInvestigationVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.NewResultInvestigationVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.vo.OcsOrderShortVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.OcsOrderShortVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getRepDateTimeIsNotNull()
	{
		return this.repdatetime != null;
	}
	public ims.framework.utils.DateTime getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.repdatetime = value;
	}
	public boolean getRepTimeSuppliedIsNotNull()
	{
		return this.reptimesupplied != null;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.reptimesupplied = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public ims.ocrr.vo.lookups.OcsDisplayFlag getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.ocrr.vo.lookups.OcsDisplayFlag value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getResultDemographicsIsNotNull()
	{
		return this.resultdemographics != null;
	}
	public ims.ocrr.vo.ResultDemographicsVo getResultDemographics()
	{
		return this.resultdemographics;
	}
	public void setResultDemographics(ims.ocrr.vo.ResultDemographicsVo value)
	{
		this.isValidated = false;
		this.resultdemographics = value;
	}
	public boolean getResultStatusIsNotNull()
	{
		return this.resultstatus != null;
	}
	public ims.ocrr.vo.lookups.ResultStatus getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.ocrr.vo.lookups.ResultStatus value)
	{
		this.isValidated = false;
		this.resultstatus = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusClinicalVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.OrderedInvestigationStatusClinicalVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getOrdInvXOStatusHistoryIsNotNull()
	{
		return this.ordinvxostatushistory != null;
	}
	public ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection getOrdInvXOStatusHistory()
	{
		return this.ordinvxostatushistory;
	}
	public void setOrdInvXOStatusHistory(ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection value)
	{
		this.isValidated = false;
		this.ordinvxostatushistory = value;
	}
	public boolean getResultConclusionCommentsIsNotNull()
	{
		return this.resultconclusioncomments != null;
	}
	public ims.ocrr.vo.ResultCommentsLiteVoCollection getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.ResultCommentsLiteVoCollection value)
	{
		this.isValidated = false;
		this.resultconclusioncomments = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForClinicalResultListVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForClinicalResultListVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
	}
	public boolean getAllocatedHCPforReviewIsNotNull()
	{
		return this.allocatedhcpforreview != null;
	}
	public ims.core.vo.HcpLiteVo getAllocatedHCPforReview()
	{
		return this.allocatedhcpforreview;
	}
	public void setAllocatedHCPforReview(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.allocatedhcpforreview = value;
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
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.orderdetails != null)
		{
			if(!this.orderdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdemographics != null)
		{
			if(!this.resultdemographics.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
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
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.orderdetails != null)
		{
			String[] listOfOtherErrors = this.orderdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.displayflag == null)
			listOfErrors.add("DisplayFlag is mandatory");
		if(this.resultdemographics != null)
		{
			String[] listOfOtherErrors = this.resultdemographics.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.ordinvcurrentstatus != null)
		{
			String[] listOfOtherErrors = this.ordinvcurrentstatus.validate();
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
	
		ClinicalResultListVo clone = new ClinicalResultListVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.NewResultInvestigationVo)this.investigation.clone();
		if(this.orderdetails == null)
			clone.orderdetails = null;
		else
			clone.orderdetails = (ims.ocrr.vo.OcsOrderShortVo)this.orderdetails.clone();
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		clone.reptimesupplied = this.reptimesupplied;
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.displayflag == null)
			clone.displayflag = null;
		else
			clone.displayflag = (ims.ocrr.vo.lookups.OcsDisplayFlag)this.displayflag.clone();
		if(this.resultdemographics == null)
			clone.resultdemographics = null;
		else
			clone.resultdemographics = (ims.ocrr.vo.ResultDemographicsVo)this.resultdemographics.clone();
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusClinicalVo)this.ordinvcurrentstatus.clone();
		if(this.ordinvxostatushistory == null)
			clone.ordinvxostatushistory = null;
		else
			clone.ordinvxostatushistory = (ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection)this.ordinvxostatushistory.clone();
		if(this.resultconclusioncomments == null)
			clone.resultconclusioncomments = null;
		else
			clone.resultconclusioncomments = (ims.ocrr.vo.ResultCommentsLiteVoCollection)this.resultconclusioncomments.clone();
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForClinicalResultListVo)this.resultdetails.clone();
		if(this.allocatedhcpforreview == null)
			clone.allocatedhcpforreview = null;
		else
			clone.allocatedhcpforreview = (ims.core.vo.HcpLiteVo)this.allocatedhcpforreview.clone();
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
		if (!(ClinicalResultListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalResultListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalResultListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalResultListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigation != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.reptimesupplied != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.resultdemographics != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.ordinvxostatushistory != null)
			count++;
		if(this.resultconclusioncomments != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.allocatedhcpforreview != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.ocrr.vo.NewResultInvestigationVo investigation;
	protected ims.ocrr.vo.OcsOrderShortVo orderdetails;
	protected ims.framework.utils.DateTime repdatetime;
	protected Boolean reptimesupplied;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.lookups.OcsDisplayFlag displayflag;
	protected ims.ocrr.vo.ResultDemographicsVo resultdemographics;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.ocrr.vo.OrderedInvestigationStatusClinicalVo ordinvcurrentstatus;
	protected ims.ocrr.vo.OrdInvXOStatusHistoryLiteVoCollection ordinvxostatushistory;
	protected ims.ocrr.vo.ResultCommentsLiteVoCollection resultconclusioncomments;
	protected ims.ocrr.vo.ResultDetailsForClinicalResultListVo resultdetails;
	protected ims.core.vo.HcpLiteVo allocatedhcpforreview;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
