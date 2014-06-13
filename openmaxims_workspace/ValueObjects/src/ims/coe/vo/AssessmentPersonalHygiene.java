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
public class AssessmentPersonalHygiene extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentPersonalHygiene()
	{
	}
	public AssessmentPersonalHygiene(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentPersonalHygiene(ims.coe.vo.beans.AssessmentPersonalHygieneBean bean)
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
		this.preferredbathingpattern = bean.getPreferredBathingPattern();
		this.assisstancewithpersonalhygiene = bean.getAssisstanceWithPersonalHygiene() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssisstanceWithPersonalHygiene());
		this.hygieneactivities = ims.nursing.vo.HygieneActivitiesCollection.buildFromBeanCollection(bean.getHygieneActivities());
		this.personalhygienefeet = bean.getPersonalHygieneFeet() == null ? null : bean.getPersonalHygieneFeet().buildVo();
		this.conditionofhair = bean.getConditionOfHair() == null ? null : ims.coe.vo.lookups.ConditionOfHair.buildLookup(bean.getConditionOfHair());
		this.evidenceofhairinfestation = bean.getEvidenceOfHairInfestation() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEvidenceOfHairInfestation());
		this.conditionofnails = bean.getConditionOfNails() == null ? null : ims.coe.vo.lookups.ConditionOfNails.buildLookup(bean.getConditionOfNails());
		this.conditionofskin = bean.getConditionOfSkin();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentPersonalHygieneBean bean)
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
		this.preferredbathingpattern = bean.getPreferredBathingPattern();
		this.assisstancewithpersonalhygiene = bean.getAssisstanceWithPersonalHygiene() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAssisstanceWithPersonalHygiene());
		this.hygieneactivities = ims.nursing.vo.HygieneActivitiesCollection.buildFromBeanCollection(bean.getHygieneActivities());
		this.personalhygienefeet = bean.getPersonalHygieneFeet() == null ? null : bean.getPersonalHygieneFeet().buildVo(map);
		this.conditionofhair = bean.getConditionOfHair() == null ? null : ims.coe.vo.lookups.ConditionOfHair.buildLookup(bean.getConditionOfHair());
		this.evidenceofhairinfestation = bean.getEvidenceOfHairInfestation() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEvidenceOfHairInfestation());
		this.conditionofnails = bean.getConditionOfNails() == null ? null : ims.coe.vo.lookups.ConditionOfNails.buildLookup(bean.getConditionOfNails());
		this.conditionofskin = bean.getConditionOfSkin();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentPersonalHygieneBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentPersonalHygieneBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentPersonalHygieneBean();
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
		if(fieldName.equals("PREFERREDBATHINGPATTERN"))
			return getPreferredBathingPattern();
		if(fieldName.equals("ASSISSTANCEWITHPERSONALHYGIENE"))
			return getAssisstanceWithPersonalHygiene();
		if(fieldName.equals("HYGIENEACTIVITIES"))
			return getHygieneActivities();
		if(fieldName.equals("PERSONALHYGIENEFEET"))
			return getPersonalHygieneFeet();
		if(fieldName.equals("CONDITIONOFHAIR"))
			return getConditionOfHair();
		if(fieldName.equals("EVIDENCEOFHAIRINFESTATION"))
			return getEvidenceOfHairInfestation();
		if(fieldName.equals("CONDITIONOFNAILS"))
			return getConditionOfNails();
		if(fieldName.equals("CONDITIONOFSKIN"))
			return getConditionOfSkin();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPreferredBathingPatternIsNotNull()
	{
		return this.preferredbathingpattern != null;
	}
	public String getPreferredBathingPattern()
	{
		return this.preferredbathingpattern;
	}
	public static int getPreferredBathingPatternMaxLength()
	{
		return 255;
	}
	public void setPreferredBathingPattern(String value)
	{
		this.isValidated = false;
		this.preferredbathingpattern = value;
	}
	public boolean getAssisstanceWithPersonalHygieneIsNotNull()
	{
		return this.assisstancewithpersonalhygiene != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAssisstanceWithPersonalHygiene()
	{
		return this.assisstancewithpersonalhygiene;
	}
	public void setAssisstanceWithPersonalHygiene(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.assisstancewithpersonalhygiene = value;
	}
	public boolean getHygieneActivitiesIsNotNull()
	{
		return this.hygieneactivities != null;
	}
	public ims.nursing.vo.HygieneActivitiesCollection getHygieneActivities()
	{
		return this.hygieneactivities;
	}
	public void setHygieneActivities(ims.nursing.vo.HygieneActivitiesCollection value)
	{
		this.isValidated = false;
		this.hygieneactivities = value;
	}
	public boolean getPersonalHygieneFeetIsNotNull()
	{
		return this.personalhygienefeet != null;
	}
	public ims.coe.vo.PersonalHygieneFeetVo getPersonalHygieneFeet()
	{
		return this.personalhygienefeet;
	}
	public void setPersonalHygieneFeet(ims.coe.vo.PersonalHygieneFeetVo value)
	{
		this.isValidated = false;
		this.personalhygienefeet = value;
	}
	public boolean getConditionOfHairIsNotNull()
	{
		return this.conditionofhair != null;
	}
	public ims.coe.vo.lookups.ConditionOfHair getConditionOfHair()
	{
		return this.conditionofhair;
	}
	public void setConditionOfHair(ims.coe.vo.lookups.ConditionOfHair value)
	{
		this.isValidated = false;
		this.conditionofhair = value;
	}
	public boolean getEvidenceOfHairInfestationIsNotNull()
	{
		return this.evidenceofhairinfestation != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getEvidenceOfHairInfestation()
	{
		return this.evidenceofhairinfestation;
	}
	public void setEvidenceOfHairInfestation(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.evidenceofhairinfestation = value;
	}
	public boolean getConditionOfNailsIsNotNull()
	{
		return this.conditionofnails != null;
	}
	public ims.coe.vo.lookups.ConditionOfNails getConditionOfNails()
	{
		return this.conditionofnails;
	}
	public void setConditionOfNails(ims.coe.vo.lookups.ConditionOfNails value)
	{
		this.isValidated = false;
		this.conditionofnails = value;
	}
	public boolean getConditionOfSkinIsNotNull()
	{
		return this.conditionofskin != null;
	}
	public String getConditionOfSkin()
	{
		return this.conditionofskin;
	}
	public static int getConditionOfSkinMaxLength()
	{
		return 255;
	}
	public void setConditionOfSkin(String value)
	{
		this.isValidated = false;
		this.conditionofskin = value;
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
		if(this.hygieneactivities != null)
		{
			if(!this.hygieneactivities.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.personalhygienefeet != null)
		{
			if(!this.personalhygienefeet.isValidated())
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
		if(this.hygieneactivities != null)
		{
			String[] listOfOtherErrors = this.hygieneactivities.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.personalhygienefeet != null)
		{
			String[] listOfOtherErrors = this.personalhygienefeet.validate();
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
	
		AssessmentPersonalHygiene clone = new AssessmentPersonalHygiene(this.id, this.version);
		
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
		clone.preferredbathingpattern = this.preferredbathingpattern;
		if(this.assisstancewithpersonalhygiene == null)
			clone.assisstancewithpersonalhygiene = null;
		else
			clone.assisstancewithpersonalhygiene = (ims.core.vo.lookups.YesNoUnknown)this.assisstancewithpersonalhygiene.clone();
		if(this.hygieneactivities == null)
			clone.hygieneactivities = null;
		else
			clone.hygieneactivities = (ims.nursing.vo.HygieneActivitiesCollection)this.hygieneactivities.clone();
		if(this.personalhygienefeet == null)
			clone.personalhygienefeet = null;
		else
			clone.personalhygienefeet = (ims.coe.vo.PersonalHygieneFeetVo)this.personalhygienefeet.clone();
		if(this.conditionofhair == null)
			clone.conditionofhair = null;
		else
			clone.conditionofhair = (ims.coe.vo.lookups.ConditionOfHair)this.conditionofhair.clone();
		if(this.evidenceofhairinfestation == null)
			clone.evidenceofhairinfestation = null;
		else
			clone.evidenceofhairinfestation = (ims.core.vo.lookups.YesNoUnknown)this.evidenceofhairinfestation.clone();
		if(this.conditionofnails == null)
			clone.conditionofnails = null;
		else
			clone.conditionofnails = (ims.coe.vo.lookups.ConditionOfNails)this.conditionofnails.clone();
		clone.conditionofskin = this.conditionofskin;
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
		if (!(AssessmentPersonalHygiene.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentPersonalHygiene object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentPersonalHygiene compareObj = (AssessmentPersonalHygiene)obj;
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
		if(this.preferredbathingpattern != null)
			count++;
		if(this.assisstancewithpersonalhygiene != null)
			count++;
		if(this.hygieneactivities != null)
			count++;
		if(this.personalhygienefeet != null)
			count++;
		if(this.conditionofhair != null)
			count++;
		if(this.evidenceofhairinfestation != null)
			count++;
		if(this.conditionofnails != null)
			count++;
		if(this.conditionofskin != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 8;
	}
	protected String preferredbathingpattern;
	protected ims.core.vo.lookups.YesNoUnknown assisstancewithpersonalhygiene;
	protected ims.nursing.vo.HygieneActivitiesCollection hygieneactivities;
	protected ims.coe.vo.PersonalHygieneFeetVo personalhygienefeet;
	protected ims.coe.vo.lookups.ConditionOfHair conditionofhair;
	protected ims.core.vo.lookups.YesNoUnknown evidenceofhairinfestation;
	protected ims.coe.vo.lookups.ConditionOfNails conditionofnails;
	protected String conditionofskin;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
