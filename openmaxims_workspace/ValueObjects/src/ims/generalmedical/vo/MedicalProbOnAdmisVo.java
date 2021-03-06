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

package ims.generalmedical.vo;

/**
 * Linked to core.clinical.PatientProblem business object (ID: 1023100001).
 */
public class MedicalProbOnAdmisVo extends ims.core.clinical.vo.PatientProblemRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MedicalProbOnAdmisVo()
	{
	}
	public MedicalProbOnAdmisVo(Integer id, int version)
	{
		super(id, version);
	}
	public MedicalProbOnAdmisVo(ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.problemcontext = bean.getProblemContext();
		this.patientproblem = bean.getPatientProblem();
		this.isactive = bean.getIsActive();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.problemcontext = bean.getProblemContext();
		this.patientproblem = bean.getPatientProblem();
		this.isactive = bean.getIsActive();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean();
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
		if(fieldName.equals("PROBLEMCONTEXT"))
			return getProblemContext();
		if(fieldName.equals("PATIENTPROBLEM"))
			return getPatientProblem();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProblemContextIsNotNull()
	{
		return this.problemcontext != null;
	}
	public String getProblemContext()
	{
		return this.problemcontext;
	}
	public static int getProblemContextMaxLength()
	{
		return 100;
	}
	public void setProblemContext(String value)
	{
		this.isValidated = false;
		this.problemcontext = value;
	}
	public boolean getPatientProblemIsNotNull()
	{
		return this.patientproblem != null;
	}
	public String getPatientProblem()
	{
		return this.patientproblem;
	}
	public static int getPatientProblemMaxLength()
	{
		return 255;
	}
	public void setPatientProblem(String value)
	{
		this.isValidated = false;
		this.patientproblem = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
		if(this.problemcontext != null)
			if(this.problemcontext.length() > 100)
				listOfErrors.add("The length of the field [problemcontext] in the value object [ims.generalmedical.vo.MedicalProbOnAdmisVo] is too big. It should be less or equal to 100");
		if(this.patientproblem == null || this.patientproblem.length() == 0)
			listOfErrors.add("Patient Problem is mandatory.");
		else if(this.patientproblem.length() > 255)
			listOfErrors.add("The length of the field [patientproblem] in the value object [ims.generalmedical.vo.MedicalProbOnAdmisVo] is too big. It should be less or equal to 255");
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
	
		MedicalProbOnAdmisVo clone = new MedicalProbOnAdmisVo(this.id, this.version);
		
		clone.problemcontext = this.problemcontext;
		clone.patientproblem = this.patientproblem;
		clone.isactive = this.isactive;
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		clone.carecontext = this.carecontext;
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
		if (!(MedicalProbOnAdmisVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MedicalProbOnAdmisVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MedicalProbOnAdmisVo compareObj = (MedicalProbOnAdmisVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getProblemContext() == null && compareObj.getProblemContext() != null)
				return -1;
			if(this.getProblemContext() != null && compareObj.getProblemContext() == null)
				return 1;
			if(this.getProblemContext() != null && compareObj.getProblemContext() != null)
			{
				if(caseInsensitive)
					retVal = this.getProblemContext().toLowerCase().compareTo(compareObj.getProblemContext().toLowerCase());
				else
					retVal = this.getProblemContext().compareTo(compareObj.getProblemContext());
			}
		}
		if (retVal == 0)
		{
			if(this.getPatientProblem() == null && compareObj.getPatientProblem() != null)
				return -1;
			if(this.getPatientProblem() != null && compareObj.getPatientProblem() == null)
				return 1;
			if(this.getPatientProblem() != null && compareObj.getPatientProblem() != null)
			{
				if(caseInsensitive)
					retVal = this.getPatientProblem().toLowerCase().compareTo(compareObj.getPatientProblem().toLowerCase());
				else
					retVal = this.getPatientProblem().compareTo(compareObj.getPatientProblem());
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
		if(this.problemcontext != null)
			count++;
		if(this.patientproblem != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String problemcontext;
	protected String patientproblem;
	protected Boolean isactive;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
