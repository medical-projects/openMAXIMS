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

package ims.core.vo;


public class DocumentWorklistSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DocumentWorklistSearchCriteriaVo()
	{
	}
	public DocumentWorklistSearchCriteriaVo(ims.core.vo.beans.DocumentWorklistSearchCriteriaVoBean bean)
	{
		this.author = bean.getAuthor() == null ? null : bean.getAuthor().buildVo();
		// Interface field type not supported.
		// Interface field type not supported.
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo();
		this.documentstatus = bean.getDocumentStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocumentStatus());
		this.documenttype = bean.getDocumentType() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getDocumentType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.responsible = bean.getResponsible() == null ? null : bean.getResponsible().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.patientid = bean.getPatientId() == null ? null : bean.getPatientId().buildVo();
		this.excludecompleted = bean.getExcludeCompleted();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DocumentWorklistSearchCriteriaVoBean bean)
	{
		this.author = bean.getAuthor() == null ? null : bean.getAuthor().buildVo(map);
		// Interface field type not supported.
		// Interface field type not supported.
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo(map);
		this.documentstatus = bean.getDocumentStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getDocumentStatus());
		this.documenttype = bean.getDocumentType() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getDocumentType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.responsible = bean.getResponsible() == null ? null : bean.getResponsible().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.patientid = bean.getPatientId() == null ? null : bean.getPatientId().buildVo(map);
		this.excludecompleted = bean.getExcludeCompleted();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DocumentWorklistSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DocumentWorklistSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DocumentWorklistSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getAuthorIsNotNull()
	{
		return this.author != null;
	}
	public ims.core.vo.HcpLiteVo getAuthor()
	{
		return this.author;
	}
	public void setAuthor(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.author = value;
	}
	public boolean getTypistIsNotNull()
	{
		return this.typist != null;
	}
	public ims.vo.interfaces.IMos getTypist()
	{
		return this.typist;
	}
	public void setTypist(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.typist = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.framework.interfaces.ILocation getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.framework.interfaces.ILocation value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getClinicIsNotNull()
	{
		return this.clinic != null;
	}
	public ims.core.vo.ClinicLiteVo getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.ClinicLiteVo value)
	{
		this.isValidated = false;
		this.clinic = value;
	}
	public boolean getDocumentStatusIsNotNull()
	{
		return this.documentstatus != null;
	}
	public ims.core.vo.lookups.DocumentStatus getDocumentStatus()
	{
		return this.documentstatus;
	}
	public void setDocumentStatus(ims.core.vo.lookups.DocumentStatus value)
	{
		this.isValidated = false;
		this.documentstatus = value;
	}
	public boolean getDocumentTypeIsNotNull()
	{
		return this.documenttype != null;
	}
	public ims.core.vo.lookups.DocumentCategory getDocumentType()
	{
		return this.documenttype;
	}
	public void setDocumentType(ims.core.vo.lookups.DocumentCategory value)
	{
		this.isValidated = false;
		this.documenttype = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getResponsibleIsNotNull()
	{
		return this.responsible != null;
	}
	public ims.core.vo.HcpLiteVo getResponsible()
	{
		return this.responsible;
	}
	public void setResponsible(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsible = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getPatientIdIsNotNull()
	{
		return this.patientid != null;
	}
	public ims.core.vo.PatientIdListVo getPatientId()
	{
		return this.patientid;
	}
	public void setPatientId(ims.core.vo.PatientIdListVo value)
	{
		this.isValidated = false;
		this.patientid = value;
	}
	public boolean getExcludeCompletedIsNotNull()
	{
		return this.excludecompleted != null;
	}
	public Boolean getExcludeCompleted()
	{
		return this.excludecompleted;
	}
	public void setExcludeCompleted(Boolean value)
	{
		this.isValidated = false;
		this.excludecompleted = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.author != null)
			sb.append(this.author);
		if(this.typist != null)
			sb.append(this.typist);
		if(this.clinic != null)
			sb.append(this.clinic);
		if(this.documentstatus != null)
			sb.append(this.documentstatus);
		if(this.documenttype != null)
			sb.append(this.documenttype);
		if(this.specialty != null)
			sb.append(this.specialty);
		if(this.datefrom != null)
			sb.append(this.datefrom);
		if(this.dateto != null)
			sb.append(this.dateto);
		if(this.patient != null)
			sb.append(this.patient);
		if(this.patientid != null)
			sb.append(this.patientid);
		return sb.toString();
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof DocumentWorklistSearchCriteriaVo))
			return false;
		DocumentWorklistSearchCriteriaVo compareObj = (DocumentWorklistSearchCriteriaVo)obj;
		if(this.getAuthor() == null && compareObj.getAuthor() != null)
			return false;
		if(this.getAuthor() != null && compareObj.getAuthor() == null)
			return false;
		if(this.getAuthor() != null && compareObj.getAuthor() != null)
			return this.getAuthor().equals(compareObj.getAuthor());
		return super.equals(obj);
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
	
		DocumentWorklistSearchCriteriaVo clone = new DocumentWorklistSearchCriteriaVo();
		
		if(this.author == null)
			clone.author = null;
		else
			clone.author = (ims.core.vo.HcpLiteVo)this.author.clone();
		clone.typist = this.typist;
		clone.location = this.location;
		if(this.clinic == null)
			clone.clinic = null;
		else
			clone.clinic = (ims.core.vo.ClinicLiteVo)this.clinic.clone();
		if(this.documentstatus == null)
			clone.documentstatus = null;
		else
			clone.documentstatus = (ims.core.vo.lookups.DocumentStatus)this.documentstatus.clone();
		if(this.documenttype == null)
			clone.documenttype = null;
		else
			clone.documenttype = (ims.core.vo.lookups.DocumentCategory)this.documenttype.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
		if(this.responsible == null)
			clone.responsible = null;
		else
			clone.responsible = (ims.core.vo.HcpLiteVo)this.responsible.clone();
		clone.patient = this.patient;
		if(this.patientid == null)
			clone.patientid = null;
		else
			clone.patientid = (ims.core.vo.PatientIdListVo)this.patientid.clone();
		clone.excludecompleted = this.excludecompleted;
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
		if (!(DocumentWorklistSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DocumentWorklistSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DocumentWorklistSearchCriteriaVo compareObj = (DocumentWorklistSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAuthor() == null && compareObj.getAuthor() != null)
				return -1;
			if(this.getAuthor() != null && compareObj.getAuthor() == null)
				return 1;
			if(this.getAuthor() != null && compareObj.getAuthor() != null)
				retVal = this.getAuthor().compareTo(compareObj.getAuthor());
		}
		if (retVal == 0)
		{
			if(this.getClinic() == null && compareObj.getClinic() != null)
				return -1;
			if(this.getClinic() != null && compareObj.getClinic() == null)
				return 1;
			if(this.getClinic() != null && compareObj.getClinic() != null)
				retVal = this.getClinic().compareTo(compareObj.getClinic());
		}
		if (retVal == 0)
		{
			if(this.getDocumentStatus() == null && compareObj.getDocumentStatus() != null)
				return -1;
			if(this.getDocumentStatus() != null && compareObj.getDocumentStatus() == null)
				return 1;
			if(this.getDocumentStatus() != null && compareObj.getDocumentStatus() != null)
				retVal = this.getDocumentStatus().compareTo(compareObj.getDocumentStatus());
		}
		if (retVal == 0)
		{
			if(this.getDocumentType() == null && compareObj.getDocumentType() != null)
				return -1;
			if(this.getDocumentType() != null && compareObj.getDocumentType() == null)
				return 1;
			if(this.getDocumentType() != null && compareObj.getDocumentType() != null)
				retVal = this.getDocumentType().compareTo(compareObj.getDocumentType());
		}
		if (retVal == 0)
		{
			if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
				return -1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
				return 1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
				retVal = this.getSpecialty().compareTo(compareObj.getSpecialty());
		}
		if (retVal == 0)
		{
			if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
				return -1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
				return 1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
				retVal = this.getDateFrom().compareTo(compareObj.getDateFrom());
		}
		if (retVal == 0)
		{
			if(this.getDateTo() == null && compareObj.getDateTo() != null)
				return -1;
			if(this.getDateTo() != null && compareObj.getDateTo() == null)
				return 1;
			if(this.getDateTo() != null && compareObj.getDateTo() != null)
				retVal = this.getDateTo().compareTo(compareObj.getDateTo());
		}
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
		}
		if (retVal == 0)
		{
			if(this.getPatientId() == null && compareObj.getPatientId() != null)
				return -1;
			if(this.getPatientId() != null && compareObj.getPatientId() == null)
				return 1;
			if(this.getPatientId() != null && compareObj.getPatientId() != null)
				retVal = this.getPatientId().compareTo(compareObj.getPatientId());
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
		if(this.author != null)
			count++;
		if(this.typist != null)
			count++;
		if(this.location != null)
			count++;
		if(this.clinic != null)
			count++;
		if(this.documentstatus != null)
			count++;
		if(this.documenttype != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.responsible != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.patientid != null)
			count++;
		if(this.excludecompleted != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.vo.HcpLiteVo author;
	protected ims.vo.interfaces.IMos typist;
	protected ims.framework.interfaces.ILocation location;
	protected ims.core.vo.ClinicLiteVo clinic;
	protected ims.core.vo.lookups.DocumentStatus documentstatus;
	protected ims.core.vo.lookups.DocumentCategory documenttype;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	protected ims.core.vo.HcpLiteVo responsible;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.PatientIdListVo patientid;
	protected Boolean excludecompleted;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
