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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.PathologyDetails business object (ID: 1074100015).
 */
public class PathologyDetailsListVo extends ims.oncology.vo.PathologyDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologyDetailsListVo()
	{
	}
	public PathologyDetailsListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologyDetailsListVo(ims.clinicaladmin.vo.beans.PathologyDetailsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationtype = bean.getInvestigationType() == null ? null : ims.oncology.vo.lookups.InvestigationType.buildLookup(bean.getInvestigationType());
		this.samplereceiptdate = bean.getSampleReceiptDate() == null ? null : bean.getSampleReceiptDate().buildDate();
		this.investigationresultdate = bean.getInvestigationResultDate() == null ? null : bean.getInvestigationResultDate().buildDate();
		// Interface field type not supported.
		this.reportingorganisation = bean.getReportingOrganisation() == null ? null : bean.getReportingOrganisation().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.previousversion = bean.getPreviousVersion() == null ? null : new ims.oncology.vo.PathologyDetailsRefVo(new Integer(bean.getPreviousVersion().getId()), bean.getPreviousVersion().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.PathologyDetailsListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.investigationtype = bean.getInvestigationType() == null ? null : ims.oncology.vo.lookups.InvestigationType.buildLookup(bean.getInvestigationType());
		this.samplereceiptdate = bean.getSampleReceiptDate() == null ? null : bean.getSampleReceiptDate().buildDate();
		this.investigationresultdate = bean.getInvestigationResultDate() == null ? null : bean.getInvestigationResultDate().buildDate();
		// Interface field type not supported.
		this.reportingorganisation = bean.getReportingOrganisation() == null ? null : bean.getReportingOrganisation().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.previousversion = bean.getPreviousVersion() == null ? null : new ims.oncology.vo.PathologyDetailsRefVo(new Integer(bean.getPreviousVersion().getId()), bean.getPreviousVersion().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.PathologyDetailsListVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.PathologyDetailsListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.PathologyDetailsListVoBean();
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
		if(fieldName.equals("INVESTIGATIONTYPE"))
			return getInvestigationType();
		if(fieldName.equals("SAMPLERECEIPTDATE"))
			return getSampleReceiptDate();
		if(fieldName.equals("INVESTIGATIONRESULTDATE"))
			return getInvestigationResultDate();
		if(fieldName.equals("REPORTINGCONSULTANTCODE"))
			return getReportingConsultantCode();
		if(fieldName.equals("REPORTINGORGANISATION"))
			return getReportingOrganisation();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PREVIOUSVERSION"))
			return getPreviousVersion();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationTypeIsNotNull()
	{
		return this.investigationtype != null;
	}
	public ims.oncology.vo.lookups.InvestigationType getInvestigationType()
	{
		return this.investigationtype;
	}
	public void setInvestigationType(ims.oncology.vo.lookups.InvestigationType value)
	{
		this.isValidated = false;
		this.investigationtype = value;
	}
	public boolean getSampleReceiptDateIsNotNull()
	{
		return this.samplereceiptdate != null;
	}
	public ims.framework.utils.Date getSampleReceiptDate()
	{
		return this.samplereceiptdate;
	}
	public void setSampleReceiptDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.samplereceiptdate = value;
	}
	public boolean getInvestigationResultDateIsNotNull()
	{
		return this.investigationresultdate != null;
	}
	public ims.framework.utils.Date getInvestigationResultDate()
	{
		return this.investigationresultdate;
	}
	public void setInvestigationResultDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.investigationresultdate = value;
	}
	public boolean getReportingConsultantCodeIsNotNull()
	{
		return this.reportingconsultantcode != null;
	}
	public ims.vo.interfaces.IMos getReportingConsultantCode()
	{
		return this.reportingconsultantcode;
	}
	public void setReportingConsultantCode(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.reportingconsultantcode = (ims.core.vo.HcpLiteVo)value;
	}
	public boolean getReportingOrganisationIsNotNull()
	{
		return this.reportingorganisation != null;
	}
	public ims.core.vo.OrgLiteVo getReportingOrganisation()
	{
		return this.reportingorganisation;
	}
	public void setReportingOrganisation(ims.core.vo.OrgLiteVo value)
	{
		this.isValidated = false;
		this.reportingorganisation = value;
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
	public boolean getPreviousVersionIsNotNull()
	{
		return this.previousversion != null;
	}
	public ims.oncology.vo.PathologyDetailsRefVo getPreviousVersion()
	{
		return this.previousversion;
	}
	public void setPreviousVersion(ims.oncology.vo.PathologyDetailsRefVo value)
	{
		this.isValidated = false;
		this.previousversion = value;
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
		if(this.reportingorganisation != null)
		{
			if(!this.reportingorganisation.isValidated())
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
		if(this.investigationtype == null)
			listOfErrors.add("InvestigationType is mandatory");
		if(this.samplereceiptdate == null)
			listOfErrors.add("SampleReceiptDate is mandatory");
		if(this.reportingorganisation != null)
		{
			String[] listOfOtherErrors = this.reportingorganisation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		PathologyDetailsListVo clone = new PathologyDetailsListVo(this.id, this.version);
		
		if(this.investigationtype == null)
			clone.investigationtype = null;
		else
			clone.investigationtype = (ims.oncology.vo.lookups.InvestigationType)this.investigationtype.clone();
		if(this.samplereceiptdate == null)
			clone.samplereceiptdate = null;
		else
			clone.samplereceiptdate = (ims.framework.utils.Date)this.samplereceiptdate.clone();
		if(this.investigationresultdate == null)
			clone.investigationresultdate = null;
		else
			clone.investigationresultdate = (ims.framework.utils.Date)this.investigationresultdate.clone();
		clone.reportingconsultantcode = this.reportingconsultantcode;
		if(this.reportingorganisation == null)
			clone.reportingorganisation = null;
		else
			clone.reportingorganisation = (ims.core.vo.OrgLiteVo)this.reportingorganisation.clone();
		clone.carecontext = this.carecontext;
		clone.previousversion = this.previousversion;
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
		if (!(PathologyDetailsListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologyDetailsListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathologyDetailsListVo compareObj = (PathologyDetailsListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPreviousVersion() == null && compareObj.getPreviousVersion() != null)
				return -1;
			if(this.getPreviousVersion() != null && compareObj.getPreviousVersion() == null)
				return 1;
			if(this.getPreviousVersion() != null && compareObj.getPreviousVersion() != null)
				retVal = this.getPreviousVersion().compareTo(compareObj.getPreviousVersion());
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
		if(this.investigationtype != null)
			count++;
		if(this.samplereceiptdate != null)
			count++;
		if(this.investigationresultdate != null)
			count++;
		if(this.reportingconsultantcode != null)
			count++;
		if(this.reportingorganisation != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.previousversion != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.oncology.vo.lookups.InvestigationType investigationtype;
	protected ims.framework.utils.Date samplereceiptdate;
	protected ims.framework.utils.Date investigationresultdate;
	protected ims.core.vo.HcpLiteVo reportingconsultantcode;
	protected ims.core.vo.OrgLiteVo reportingorganisation;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.oncology.vo.PathologyDetailsRefVo previousversion;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
