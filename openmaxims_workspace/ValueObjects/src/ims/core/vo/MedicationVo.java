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

/**
 * Linked to core.clinical.Medication business object (ID: 1003100024).
 */
public class MedicationVo extends ims.core.vo.MedicationLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.ICciFull
{
	private static final long serialVersionUID = 1L;

	public MedicationVo()
	{
	}
	public MedicationVo(Integer id, int version)
	{
		super(id, version);
	}
	public MedicationVo(ims.core.vo.beans.MedicationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medicationname = bean.getMedicationName();
		this.isactive = bean.getIsActive();
		this.iscontrolleddrug = bean.getIsControlledDrug();
		this.frequencydefault = bean.getFrequencyDefault() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyDefault());
		this.noofdayssupplydefault = bean.getNoOfDaysSupplyDefault();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MedicationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medicationname = bean.getMedicationName();
		this.isactive = bean.getIsActive();
		this.iscontrolleddrug = bean.getIsControlledDrug();
		this.frequencydefault = bean.getFrequencyDefault() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyDefault());
		this.noofdayssupplydefault = bean.getNoOfDaysSupplyDefault();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MedicationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MedicationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MedicationVoBean();
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
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		if(fieldName.equals("KEYWORDS"))
			return getKeywords();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	public boolean getKeywordsIsNotNull()
	{
		return this.keywords != null;
	}
	public ims.core.vo.KeywordVoCollection getKeywords()
	{
		return this.keywords;
	}
	public void setKeywords(ims.core.vo.KeywordVoCollection value)
	{
		this.isValidated = false;
		this.keywords = value;
	}
	/**
	* ICciFull Interface Methods
	*/
	public TaxonomyMapCollection getCciMappings() 
	{
		return this.getTaxonomyMap();
	}
	
	public KeywordVoCollection getCciKeywords() 
	{
		return this.getKeywords();
	}
	
	public void setCciKeywords(KeywordVoCollection cciKeywords) 
	{
		this.setKeywords(cciKeywords);
	}
	
	public void setCciMappings(TaxonomyMapCollection cciMappings) 
	{
		this.setTaxonomyMap(cciMappings);
	}
	
	public void setCciAllergenType(ims.core.vo.lookups.AllergenType type)
	{
		// this function is only for the allergen vo. 
	}
	
	public ims.core.vo.lookups.AllergenType getCciAllergenType()
	{
		return null; // this function is only for the allergen vo.
	}
	
	public Integer getCciProcedureDuration()
	{
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureDuration(Integer duration)
	{
		// this function is only for the procedure vo. 
	}
	
	public Integer getCciProcedureLOS()
	{
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureLOS(Integer intLOS)
	{
		// this function is only for the procedure vo. 
	}
	
	public Integer getCciTCILagTime()
	{
		return null; // this function is only for the procedure vo.
	}
	
	public void setCciTCILagTime(Integer tciLagTime)
	{
		// this function is only for the procedure vo. 		
	}
	
	public String[] validateCci()
	{
		return this.validate();
	}
		
	public Boolean isValidatedCci()
	{
		return Boolean.valueOf(this.isValidated());
	}
	public void setCciTreatmentInterventionType(ims.clinical.vo.lookups.TreatmentInterventionType type)
	{
		// this function is only for the TreatmentIntervention vo
	}
	
	public ims.clinical.vo.lookups.TreatmentInterventionType getCciTreatmentInterventionType()
	{
		return null; // this function is only for the TreatmentIntervention vo
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getSurgeonCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setSurgeonCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getAnaesthetistCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setAnaesthetistCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	 // used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getHospitalCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setHospitalCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
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
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.keywords != null)
		{
			if(!this.keywords.isValidated())
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
		if(this.medicationname == null || this.medicationname.length() == 0)
			listOfErrors.add("Please enter a Medication name");
		else if(this.medicationname.length() > 700)
			listOfErrors.add("The length of the field [medicationname] in the value object [ims.core.vo.MedicationVo] is too big. It should be less or equal to 700");
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.keywords != null)
		{
			String[] listOfOtherErrors = this.keywords.validate();
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
	
		MedicationVo clone = new MedicationVo(this.id, this.version);
		
		clone.medicationname = this.medicationname;
		clone.isactive = this.isactive;
		clone.iscontrolleddrug = this.iscontrolleddrug;
		if(this.frequencydefault == null)
			clone.frequencydefault = null;
		else
			clone.frequencydefault = (ims.core.vo.lookups.MedicationFrequency)this.frequencydefault.clone();
		clone.noofdayssupplydefault = this.noofdayssupplydefault;
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		if(this.keywords == null)
			clone.keywords = null;
		else
			clone.keywords = (ims.core.vo.KeywordVoCollection)this.keywords.clone();
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
		if (!(MedicationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MedicationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MedicationVo compareObj = (MedicationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMedicationName() == null && compareObj.getMedicationName() != null)
				return -1;
			if(this.getMedicationName() != null && compareObj.getMedicationName() == null)
				return 1;
			if(this.getMedicationName() != null && compareObj.getMedicationName() != null)
			{
				if(caseInsensitive)
					retVal = this.getMedicationName().toLowerCase().compareTo(compareObj.getMedicationName().toLowerCase());
				else
					retVal = this.getMedicationName().compareTo(compareObj.getMedicationName());
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
		int count = super.countFieldsWithValue();
		if(this.taxonomymap != null)
			count++;
		if(this.keywords != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected ims.core.vo.KeywordVoCollection keywords;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
