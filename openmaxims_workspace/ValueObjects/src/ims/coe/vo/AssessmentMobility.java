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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class AssessmentMobility extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentMobility()
	{
	}
	public AssessmentMobility(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentMobility(ims.coe.vo.beans.AssessmentMobilityBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo();
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.optionalfallassessment = bean.getOptionalFallAssessment() == null ? null : bean.getOptionalFallAssessment().buildVo();
		this.assistancewithmobility = bean.getAssistanceWithMobility() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssistanceWithMobility());
		this.notes = bean.getNotes();
		this.bedtype = bean.getBedType() == null ? null : ims.nursing.vo.lookups.BedType.buildLookup(bean.getBedType());
		this.chairtype = bean.getChairType() == null ? null : ims.nursing.vo.lookups.ChairType.buildLookup(bean.getChairType());
		this.patienthandling = bean.getPatientHandling() == null ? null : bean.getPatientHandling().buildVo();
		this.patientmovement = bean.getPatientMovement() == null ? null : bean.getPatientMovement().buildVo();
		this.fallassessmentscore = bean.getFallAssessmentScore();
		this.environmentchecklist = bean.getEnvironmentChecklist() == null ? null : bean.getEnvironmentChecklist().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentMobilityBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo(map);
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.optionalfallassessment = bean.getOptionalFallAssessment() == null ? null : bean.getOptionalFallAssessment().buildVo(map);
		this.assistancewithmobility = bean.getAssistanceWithMobility() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssistanceWithMobility());
		this.notes = bean.getNotes();
		this.bedtype = bean.getBedType() == null ? null : ims.nursing.vo.lookups.BedType.buildLookup(bean.getBedType());
		this.chairtype = bean.getChairType() == null ? null : ims.nursing.vo.lookups.ChairType.buildLookup(bean.getChairType());
		this.patienthandling = bean.getPatientHandling() == null ? null : bean.getPatientHandling().buildVo(map);
		this.patientmovement = bean.getPatientMovement() == null ? null : bean.getPatientMovement().buildVo(map);
		this.fallassessmentscore = bean.getFallAssessmentScore();
		this.environmentchecklist = bean.getEnvironmentChecklist() == null ? null : bean.getEnvironmentChecklist().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentMobilityBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentMobilityBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentMobilityBean();
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
		if(fieldName.equals("OPTIONALFALLASSESSMENT"))
			return getOptionalFallAssessment();
		if(fieldName.equals("ASSISTANCEWITHMOBILITY"))
			return getAssistanceWithMobility();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("BEDTYPE"))
			return getBedType();
		if(fieldName.equals("CHAIRTYPE"))
			return getChairType();
		if(fieldName.equals("PATIENTHANDLING"))
			return getPatientHandling();
		if(fieldName.equals("PATIENTMOVEMENT"))
			return getPatientMovement();
		if(fieldName.equals("FALLASSESSMENTSCORE"))
			return getFallAssessmentScore();
		if(fieldName.equals("ENVIRONMENTCHECKLIST"))
			return getEnvironmentChecklist();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOptionalFallAssessmentIsNotNull()
	{
		return this.optionalfallassessment != null;
	}
	public ims.coe.vo.FallAssessment getOptionalFallAssessment()
	{
		return this.optionalfallassessment;
	}
	public void setOptionalFallAssessment(ims.coe.vo.FallAssessment value)
	{
		this.isValidated = false;
		this.optionalfallassessment = value;
	}
	public boolean getAssistanceWithMobilityIsNotNull()
	{
		return this.assistancewithmobility != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAssistanceWithMobility()
	{
		return this.assistancewithmobility;
	}
	public void setAssistanceWithMobility(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.assistancewithmobility = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 500;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
	}
	public boolean getBedTypeIsNotNull()
	{
		return this.bedtype != null;
	}
	public ims.nursing.vo.lookups.BedType getBedType()
	{
		return this.bedtype;
	}
	public void setBedType(ims.nursing.vo.lookups.BedType value)
	{
		this.isValidated = false;
		this.bedtype = value;
	}
	public boolean getChairTypeIsNotNull()
	{
		return this.chairtype != null;
	}
	public ims.nursing.vo.lookups.ChairType getChairType()
	{
		return this.chairtype;
	}
	public void setChairType(ims.nursing.vo.lookups.ChairType value)
	{
		this.isValidated = false;
		this.chairtype = value;
	}
	public boolean getPatientHandlingIsNotNull()
	{
		return this.patienthandling != null;
	}
	public ims.coe.vo.PatientHandlingHeader getPatientHandling()
	{
		return this.patienthandling;
	}
	public void setPatientHandling(ims.coe.vo.PatientHandlingHeader value)
	{
		this.isValidated = false;
		this.patienthandling = value;
	}
	public boolean getPatientMovementIsNotNull()
	{
		return this.patientmovement != null;
	}
	public ims.coe.vo.PatientMovementHeader getPatientMovement()
	{
		return this.patientmovement;
	}
	public void setPatientMovement(ims.coe.vo.PatientMovementHeader value)
	{
		this.isValidated = false;
		this.patientmovement = value;
	}
	public boolean getFallAssessmentScoreIsNotNull()
	{
		return this.fallassessmentscore != null;
	}
	public Integer getFallAssessmentScore()
	{
		return this.fallassessmentscore;
	}
	public void setFallAssessmentScore(Integer value)
	{
		this.isValidated = false;
		this.fallassessmentscore = value;
	}
	public boolean getEnvironmentChecklistIsNotNull()
	{
		return this.environmentchecklist != null;
	}
	public ims.nursing.vo.EnvironmentalChecklistVo getEnvironmentChecklist()
	{
		return this.environmentchecklist;
	}
	public void setEnvironmentChecklist(ims.nursing.vo.EnvironmentalChecklistVo value)
	{
		this.isValidated = false;
		this.environmentchecklist = value;
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
		if(this.assessmentinfo != null)
		{
			if(!this.assessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastassessmentinfo != null)
		{
			if(!this.lastassessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplantemplate != null)
		{
			if(!this.careplantemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplans != null)
		{
			if(!this.careplans.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.optionalfallassessment != null)
		{
			if(!this.optionalfallassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patienthandling != null)
		{
			if(!this.patienthandling.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patientmovement != null)
		{
			if(!this.patientmovement.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.environmentchecklist != null)
		{
			if(!this.environmentchecklist.isValidated())
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
		if(this.assessmentinfo != null)
		{
			String[] listOfOtherErrors = this.assessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastassessmentinfo != null)
		{
			String[] listOfOtherErrors = this.lastassessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplantemplate != null)
		{
			String[] listOfOtherErrors = this.careplantemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplans != null)
		{
			String[] listOfOtherErrors = this.careplans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.optionalfallassessment != null)
		{
			String[] listOfOtherErrors = this.optionalfallassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.coe.vo.AssessmentMobility] is too big. It should be less or equal to 500");
		if(this.patienthandling != null)
		{
			String[] listOfOtherErrors = this.patienthandling.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patientmovement != null)
		{
			String[] listOfOtherErrors = this.patientmovement.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.environmentchecklist != null)
		{
			String[] listOfOtherErrors = this.environmentchecklist.validate();
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
	
		AssessmentMobility clone = new AssessmentMobility(this.id, this.version);
		
		clone.iscomplete = this.iscomplete;
		if(this.assessmentinfo == null)
			clone.assessmentinfo = null;
		else
			clone.assessmentinfo = (ims.nursing.vo.AssessmentInfoCollection)this.assessmentinfo.clone();
		clone.copy = this.copy;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.nursing.vo.lookups.AssessmentComponentType)this.componenttype.clone();
		if(this.lastassessmentinfo == null)
			clone.lastassessmentinfo = null;
		else
			clone.lastassessmentinfo = (ims.nursing.vo.AssessmentInfo)this.lastassessmentinfo.clone();
		if(this.careplantemplate == null)
			clone.careplantemplate = null;
		else
			clone.careplantemplate = (ims.nursing.vo.CarePlanTemplateCollection)this.careplantemplate.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanCollection)this.careplans.clone();
		if(this.optionalfallassessment == null)
			clone.optionalfallassessment = null;
		else
			clone.optionalfallassessment = (ims.coe.vo.FallAssessment)this.optionalfallassessment.clone();
		if(this.assistancewithmobility == null)
			clone.assistancewithmobility = null;
		else
			clone.assistancewithmobility = (ims.core.vo.lookups.YesNoUnknown)this.assistancewithmobility.clone();
		clone.notes = this.notes;
		if(this.bedtype == null)
			clone.bedtype = null;
		else
			clone.bedtype = (ims.nursing.vo.lookups.BedType)this.bedtype.clone();
		if(this.chairtype == null)
			clone.chairtype = null;
		else
			clone.chairtype = (ims.nursing.vo.lookups.ChairType)this.chairtype.clone();
		if(this.patienthandling == null)
			clone.patienthandling = null;
		else
			clone.patienthandling = (ims.coe.vo.PatientHandlingHeader)this.patienthandling.clone();
		if(this.patientmovement == null)
			clone.patientmovement = null;
		else
			clone.patientmovement = (ims.coe.vo.PatientMovementHeader)this.patientmovement.clone();
		clone.fallassessmentscore = this.fallassessmentscore;
		if(this.environmentchecklist == null)
			clone.environmentchecklist = null;
		else
			clone.environmentchecklist = (ims.nursing.vo.EnvironmentalChecklistVo)this.environmentchecklist.clone();
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
		if (!(AssessmentMobility.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentMobility object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentMobility compareObj = (AssessmentMobility)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_AssessmentComponent() == null && compareObj.getID_AssessmentComponent() != null)
				return -1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() == null)
				return 1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() != null)
				retVal = this.getID_AssessmentComponent().compareTo(compareObj.getID_AssessmentComponent());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.optionalfallassessment != null)
			count++;
		if(this.assistancewithmobility != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.bedtype != null)
			count++;
		if(this.chairtype != null)
			count++;
		if(this.patienthandling != null)
			count++;
		if(this.patientmovement != null)
			count++;
		if(this.fallassessmentscore != null)
			count++;
		if(this.environmentchecklist != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.coe.vo.FallAssessment optionalfallassessment;
	protected ims.core.vo.lookups.YesNoUnknown assistancewithmobility;
	protected String notes;
	protected ims.nursing.vo.lookups.BedType bedtype;
	protected ims.nursing.vo.lookups.ChairType chairtype;
	protected ims.coe.vo.PatientHandlingHeader patienthandling;
	protected ims.coe.vo.PatientMovementHeader patientmovement;
	protected Integer fallassessmentscore;
	protected ims.nursing.vo.EnvironmentalChecklistVo environmentchecklist;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
