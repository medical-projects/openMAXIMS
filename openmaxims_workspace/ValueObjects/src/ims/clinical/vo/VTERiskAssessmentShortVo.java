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
 * Linked to core.clinical.VTERiskAssessment business object (ID: 1072100100).
 */
public class VTERiskAssessmentShortVo extends ims.core.clinical.vo.VTERiskAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VTERiskAssessmentShortVo()
	{
	}
	public VTERiskAssessmentShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public VTERiskAssessmentShortVo(ims.clinical.vo.beans.VTERiskAssessmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.vteassessmentstatus = bean.getVTEAssessmentStatus() == null ? null : ims.clinical.vo.lookups.VTEAsessmentStatus.buildLookup(bean.getVTEAssessmentStatus());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.VTERiskAssessmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.vteassessmentstatus = bean.getVTEAssessmentStatus() == null ? null : ims.clinical.vo.lookups.VTEAsessmentStatus.buildLookup(bean.getVTEAssessmentStatus());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.VTERiskAssessmentShortVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.VTERiskAssessmentShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.VTERiskAssessmentShortVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("VTEASSESSMENTSTATUS"))
			return getVTEAssessmentStatus();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientForVTERiskAssessmentVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientForVTERiskAssessmentVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getVTEAssessmentStatusIsNotNull()
	{
		return this.vteassessmentstatus != null;
	}
	public ims.clinical.vo.lookups.VTEAsessmentStatus getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.clinical.vo.lookups.VTEAsessmentStatus value)
	{
		this.isValidated = false;
		this.vteassessmentstatus = value;
	}
	public boolean getRecordingInformationIsNotNull()
	{
		return this.recordinginformation != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginformation = value;
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
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.vteassessmentstatus == null)
			listOfErrors.add("VTEAssessmentStatus is mandatory");
		if(this.recordinginformation == null)
			listOfErrors.add("RecordingInformation is mandatory");
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
	
		VTERiskAssessmentShortVo clone = new VTERiskAssessmentShortVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientForVTERiskAssessmentVo)this.patient.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.vteassessmentstatus == null)
			clone.vteassessmentstatus = null;
		else
			clone.vteassessmentstatus = (ims.clinical.vo.lookups.VTEAsessmentStatus)this.vteassessmentstatus.clone();
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.RecordingUserInformationVo)this.recordinginformation.clone();
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
		if (!(VTERiskAssessmentShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VTERiskAssessmentShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((VTERiskAssessmentShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((VTERiskAssessmentShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.vteassessmentstatus != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.PatientForVTERiskAssessmentVo patient;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.clinical.vo.lookups.VTEAsessmentStatus vteassessmentstatus;
	protected ims.core.vo.RecordingUserInformationVo recordinginformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
