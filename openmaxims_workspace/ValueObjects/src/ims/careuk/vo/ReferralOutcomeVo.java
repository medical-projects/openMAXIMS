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
 * Linked to CAREUK.ReferralOutcome business object (ID: 1096100005).
 */
public class ReferralOutcomeVo extends ims.careuk.vo.ReferralOutcomeLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralOutcomeVo()
	{
	}
	public ReferralOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralOutcomeVo(ims.careuk.vo.beans.ReferralOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.referraldischarge = bean.getReferralDischarge() == null ? null : bean.getReferralDischarge().buildVo();
		this.furthermanagementdetails = ims.careuk.vo.FurtherManagementDetailsVoCollection.buildFromBeanCollection(bean.getFurtherManagementDetails());
		this.prescriptions = ims.careuk.vo.PrescriptionsVoCollection.buildFromBeanCollection(bean.getPrescriptions());
		this.referraldischargehistory = ims.careuk.vo.ReferralDischargeVoCollection.buildFromBeanCollection(bean.getReferralDischargeHistory());
		this.catsfinalreportstatus = bean.getCatsFinalReportStatus() == null ? null : ims.careuk.vo.lookups.ReportStatus.buildLookup(bean.getCatsFinalReportStatus());
		this.activemonitoring = bean.getActiveMonitoring() == null ? null : bean.getActiveMonitoring().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.referraldischarge = bean.getReferralDischarge() == null ? null : bean.getReferralDischarge().buildVo(map);
		this.furthermanagementdetails = ims.careuk.vo.FurtherManagementDetailsVoCollection.buildFromBeanCollection(bean.getFurtherManagementDetails());
		this.prescriptions = ims.careuk.vo.PrescriptionsVoCollection.buildFromBeanCollection(bean.getPrescriptions());
		this.referraldischargehistory = ims.careuk.vo.ReferralDischargeVoCollection.buildFromBeanCollection(bean.getReferralDischargeHistory());
		this.catsfinalreportstatus = bean.getCatsFinalReportStatus() == null ? null : ims.careuk.vo.lookups.ReportStatus.buildLookup(bean.getCatsFinalReportStatus());
		this.activemonitoring = bean.getActiveMonitoring() == null ? null : bean.getActiveMonitoring().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralOutcomeVoBean();
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
		if(fieldName.equals("REFERRALDISCHARGE"))
			return getReferralDischarge();
		if(fieldName.equals("FURTHERMANAGEMENTDETAILS"))
			return getFurtherManagementDetails();
		if(fieldName.equals("PRESCRIPTIONS"))
			return getPrescriptions();
		if(fieldName.equals("REFERRALDISCHARGEHISTORY"))
			return getReferralDischargeHistory();
		if(fieldName.equals("CATSFINALREPORTSTATUS"))
			return getCatsFinalReportStatus();
		if(fieldName.equals("ACTIVEMONITORING"))
			return getActiveMonitoring();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralDischargeIsNotNull()
	{
		return this.referraldischarge != null;
	}
	public ims.careuk.vo.ReferralDischargeVo getReferralDischarge()
	{
		return this.referraldischarge;
	}
	public void setReferralDischarge(ims.careuk.vo.ReferralDischargeVo value)
	{
		this.isValidated = false;
		this.referraldischarge = value;
	}
	public boolean getFurtherManagementDetailsIsNotNull()
	{
		return this.furthermanagementdetails != null;
	}
	public ims.careuk.vo.FurtherManagementDetailsVoCollection getFurtherManagementDetails()
	{
		return this.furthermanagementdetails;
	}
	public void setFurtherManagementDetails(ims.careuk.vo.FurtherManagementDetailsVoCollection value)
	{
		this.isValidated = false;
		this.furthermanagementdetails = value;
	}
	public boolean getPrescriptionsIsNotNull()
	{
		return this.prescriptions != null;
	}
	public ims.careuk.vo.PrescriptionsVoCollection getPrescriptions()
	{
		return this.prescriptions;
	}
	public void setPrescriptions(ims.careuk.vo.PrescriptionsVoCollection value)
	{
		this.isValidated = false;
		this.prescriptions = value;
	}
	public boolean getReferralDischargeHistoryIsNotNull()
	{
		return this.referraldischargehistory != null;
	}
	public ims.careuk.vo.ReferralDischargeVoCollection getReferralDischargeHistory()
	{
		return this.referraldischargehistory;
	}
	public void setReferralDischargeHistory(ims.careuk.vo.ReferralDischargeVoCollection value)
	{
		this.isValidated = false;
		this.referraldischargehistory = value;
	}
	public boolean getCatsFinalReportStatusIsNotNull()
	{
		return this.catsfinalreportstatus != null;
	}
	public ims.careuk.vo.lookups.ReportStatus getCatsFinalReportStatus()
	{
		return this.catsfinalreportstatus;
	}
	public void setCatsFinalReportStatus(ims.careuk.vo.lookups.ReportStatus value)
	{
		this.isValidated = false;
		this.catsfinalreportstatus = value;
	}
	public boolean getActiveMonitoringIsNotNull()
	{
		return this.activemonitoring != null;
	}
	public ims.careuk.vo.ActiveMonitoringVo getActiveMonitoring()
	{
		return this.activemonitoring;
	}
	public void setActiveMonitoring(ims.careuk.vo.ActiveMonitoringVo value)
	{
		this.isValidated = false;
		this.activemonitoring = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.referraldischarge != null)
		{
			if(!this.referraldischarge.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.furthermanagementdetails != null)
		{
			if(!this.furthermanagementdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.prescriptions != null)
		{
			if(!this.prescriptions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.referraldischargehistory != null)
		{
			if(!this.referraldischargehistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activemonitoring != null)
		{
			if(!this.activemonitoring.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.referraldischarge != null)
		{
			String[] listOfOtherErrors = this.referraldischarge.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.furthermanagementdetails != null)
		{
			String[] listOfOtherErrors = this.furthermanagementdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.prescriptions != null)
		{
			String[] listOfOtherErrors = this.prescriptions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.referraldischargehistory != null)
		{
			String[] listOfOtherErrors = this.referraldischargehistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activemonitoring != null)
		{
			String[] listOfOtherErrors = this.activemonitoring.validate();
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
	
		ReferralOutcomeVo clone = new ReferralOutcomeVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.referraldischarge == null)
			clone.referraldischarge = null;
		else
			clone.referraldischarge = (ims.careuk.vo.ReferralDischargeVo)this.referraldischarge.clone();
		if(this.furthermanagementdetails == null)
			clone.furthermanagementdetails = null;
		else
			clone.furthermanagementdetails = (ims.careuk.vo.FurtherManagementDetailsVoCollection)this.furthermanagementdetails.clone();
		if(this.prescriptions == null)
			clone.prescriptions = null;
		else
			clone.prescriptions = (ims.careuk.vo.PrescriptionsVoCollection)this.prescriptions.clone();
		if(this.referraldischargehistory == null)
			clone.referraldischargehistory = null;
		else
			clone.referraldischargehistory = (ims.careuk.vo.ReferralDischargeVoCollection)this.referraldischargehistory.clone();
		if(this.catsfinalreportstatus == null)
			clone.catsfinalreportstatus = null;
		else
			clone.catsfinalreportstatus = (ims.careuk.vo.lookups.ReportStatus)this.catsfinalreportstatus.clone();
		if(this.activemonitoring == null)
			clone.activemonitoring = null;
		else
			clone.activemonitoring = (ims.careuk.vo.ActiveMonitoringVo)this.activemonitoring.clone();
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
		if (!(ReferralOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralOutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralOutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.referraldischarge != null)
			count++;
		if(this.furthermanagementdetails != null)
			count++;
		if(this.prescriptions != null)
			count++;
		if(this.referraldischargehistory != null)
			count++;
		if(this.catsfinalreportstatus != null)
			count++;
		if(this.activemonitoring != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.careuk.vo.ReferralDischargeVo referraldischarge;
	protected ims.careuk.vo.FurtherManagementDetailsVoCollection furthermanagementdetails;
	protected ims.careuk.vo.PrescriptionsVoCollection prescriptions;
	protected ims.careuk.vo.ReferralDischargeVoCollection referraldischargehistory;
	protected ims.careuk.vo.lookups.ReportStatus catsfinalreportstatus;
	protected ims.careuk.vo.ActiveMonitoringVo activemonitoring;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
