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
public class NewResultsSearchListVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewResultsSearchListVo()
	{
	}
	public NewResultsSearchListVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewResultsSearchListVo(ims.ocrr.vo.beans.NewResultsSearchListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.specimen = ims.ocrr.vo.OrderSpecimenCommentsVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.allocateddateforreview = bean.getAllocatedDateForReview() == null ? null : bean.getAllocatedDateForReview().buildDateTime();
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo();
		this.forreview = bean.getForReview();
		this.reviewrequestedby = bean.getReviewRequestedBy();
		this.abnormalresults = bean.getAbnormalResults();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NewResultsSearchListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.specimen = ims.ocrr.vo.OrderSpecimenCommentsVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.orderdetails = bean.getOrderDetails() == null ? null : bean.getOrderDetails().buildVo(map);
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.allocateddateforreview = bean.getAllocatedDateForReview() == null ? null : bean.getAllocatedDateForReview().buildDateTime();
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.allocatedhcpforreview = bean.getAllocatedHCPforReview() == null ? null : bean.getAllocatedHCPforReview().buildVo(map);
		this.forreview = bean.getForReview();
		this.reviewrequestedby = bean.getReviewRequestedBy();
		this.abnormalresults = bean.getAbnormalResults();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NewResultsSearchListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NewResultsSearchListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NewResultsSearchListVoBean();
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
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("ALLOCATEDDATEFORREVIEW"))
			return getAllocatedDateForReview();
		if(fieldName.equals("RESULTSORTDATE"))
			return getResultSortDate();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("ALLOCATEDHCPFORREVIEW"))
			return getAllocatedHCPforReview();
		if(fieldName.equals("FORREVIEW"))
			return getForReview();
		if(fieldName.equals("REVIEWREQUESTEDBY"))
			return getReviewRequestedBy();
		if(fieldName.equals("ABNORMALRESULTS"))
			return getAbnormalResults();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("RESULTCONCLUSIONCOMMENTS"))
			return getResultConclusionComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.NewResultsSearchInvestigationVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.NewResultsSearchInvestigationVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.OrderSpecimenCommentsVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.OrderSpecimenCommentsVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.vo.NewResultsSearchOrderSessionVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.NewResultsSearchOrderSessionVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
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
	public boolean getAllocatedDateForReviewIsNotNull()
	{
		return this.allocateddateforreview != null;
	}
	public ims.framework.utils.DateTime getAllocatedDateForReview()
	{
		return this.allocateddateforreview;
	}
	public void setAllocatedDateForReview(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.allocateddateforreview = value;
	}
	public boolean getResultSortDateIsNotNull()
	{
		return this.resultsortdate != null;
	}
	public ims.framework.utils.DateTime getResultSortDate()
	{
		return this.resultsortdate;
	}
	public void setResultSortDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.resultsortdate = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.OrderedInvestigationStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getAllocatedHCPforReviewIsNotNull()
	{
		return this.allocatedhcpforreview != null;
	}
	public ims.core.vo.HcpMinVo getAllocatedHCPforReview()
	{
		return this.allocatedhcpforreview;
	}
	public void setAllocatedHCPforReview(ims.core.vo.HcpMinVo value)
	{
		this.isValidated = false;
		this.allocatedhcpforreview = value;
	}
	public boolean getForReviewIsNotNull()
	{
		return this.forreview != null;
	}
	public Boolean getForReview()
	{
		return this.forreview;
	}
	public void setForReview(Boolean value)
	{
		this.isValidated = false;
		this.forreview = value;
	}
	public boolean getReviewRequestedByIsNotNull()
	{
		return this.reviewrequestedby != null;
	}
	public String getReviewRequestedBy()
	{
		return this.reviewrequestedby;
	}
	public static int getReviewRequestedByMaxLength()
	{
		return 50;
	}
	public void setReviewRequestedBy(String value)
	{
		this.isValidated = false;
		this.reviewrequestedby = value;
	}
	public boolean getAbnormalResultsIsNotNull()
	{
		return this.abnormalresults != null;
	}
	public Boolean getAbnormalResults()
	{
		return this.abnormalresults;
	}
	public void setAbnormalResults(Boolean value)
	{
		this.isValidated = false;
		this.abnormalresults = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForNewResultsListVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForNewResultsListVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
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
		if(this.specimen != null)
		{
			if(!this.specimen.isValidated())
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
		if(this.specimen != null)
		{
			String[] listOfOtherErrors = this.specimen.validate();
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
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.reviewrequestedby != null)
			if(this.reviewrequestedby.length() > 50)
				listOfErrors.add("The length of the field [reviewrequestedby] in the value object [ims.ocrr.vo.NewResultsSearchListVo] is too big. It should be less or equal to 50");
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
	
		NewResultsSearchListVo clone = new NewResultsSearchListVo(this.id, this.version);
		
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.NewResultsSearchInvestigationVo)this.investigation.clone();
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.OrderSpecimenCommentsVoCollection)this.specimen.clone();
		if(this.orderdetails == null)
			clone.orderdetails = null;
		else
			clone.orderdetails = (ims.ocrr.vo.NewResultsSearchOrderSessionVo)this.orderdetails.clone();
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		if(this.allocateddateforreview == null)
			clone.allocateddateforreview = null;
		else
			clone.allocateddateforreview = (ims.framework.utils.DateTime)this.allocateddateforreview.clone();
		if(this.resultsortdate == null)
			clone.resultsortdate = null;
		else
			clone.resultsortdate = (ims.framework.utils.DateTime)this.resultsortdate.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		if(this.allocatedhcpforreview == null)
			clone.allocatedhcpforreview = null;
		else
			clone.allocatedhcpforreview = (ims.core.vo.HcpMinVo)this.allocatedhcpforreview.clone();
		clone.forreview = this.forreview;
		clone.reviewrequestedby = this.reviewrequestedby;
		clone.abnormalresults = this.abnormalresults;
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForNewResultsListVo)this.resultdetails.clone();
		if(this.resultconclusioncomments == null)
			clone.resultconclusioncomments = null;
		else
			clone.resultconclusioncomments = (ims.ocrr.vo.ResultCommentsLiteVoCollection)this.resultconclusioncomments.clone();
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
		if (!(NewResultsSearchListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewResultsSearchListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewResultsSearchListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewResultsSearchListVo)obj).getBoId());
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
		if(this.specimen != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.allocateddateforreview != null)
			count++;
		if(this.resultsortdate != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.allocatedhcpforreview != null)
			count++;
		if(this.forreview != null)
			count++;
		if(this.reviewrequestedby != null)
			count++;
		if(this.abnormalresults != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.resultconclusioncomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.ocrr.vo.NewResultsSearchInvestigationVo investigation;
	protected ims.ocrr.vo.OrderSpecimenCommentsVoCollection specimen;
	protected ims.ocrr.vo.NewResultsSearchOrderSessionVo orderdetails;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.framework.utils.DateTime repdatetime;
	protected ims.framework.utils.DateTime allocateddateforreview;
	protected ims.framework.utils.DateTime resultsortdate;
	protected ims.ocrr.vo.OrderedInvestigationStatusVo ordinvcurrentstatus;
	protected ims.core.vo.HcpMinVo allocatedhcpforreview;
	protected Boolean forreview;
	protected String reviewrequestedby;
	protected Boolean abnormalresults;
	protected ims.ocrr.vo.ResultDetailsForNewResultsListVo resultdetails;
	protected ims.ocrr.vo.ResultCommentsLiteVoCollection resultconclusioncomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
