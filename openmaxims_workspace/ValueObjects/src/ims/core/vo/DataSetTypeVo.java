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
 * Linked to core.charting.DatasetType business object (ID: 1081100001).
 */
public class DataSetTypeVo extends ims.core.charting.vo.DatasetTypeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DataSetTypeVo()
	{
	}
	public DataSetTypeVo(Integer id, int version)
	{
		super(id, version);
	}
	public DataSetTypeVo(ims.core.vo.beans.DataSetTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DataSetCategory.buildLookup(bean.getCategory());
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.defaultlinetype = bean.getDefaultLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getDefaultLineType());
		this.deflinecolpticon = bean.getDefLineColPtIcon() == null ? null : ims.core.vo.lookups.LineColourPointIcon.buildLookup(bean.getDefLineColPtIcon());
		this.normalbandmaxvaluemale = bean.getNormalBandMaxValueMale();
		this.normalbandminvaluemale = bean.getNormalBandMinValueMale();
		this.normalbandmaxvaluefemale = bean.getNormalBandMaxValueFemale();
		this.normalbandminvaluefemale = bean.getNormalBandMinValueFemale();
		this.isactive = bean.getIsActive();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DataSetTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DataSetCategory.buildLookup(bean.getCategory());
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.defaultlinetype = bean.getDefaultLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getDefaultLineType());
		this.deflinecolpticon = bean.getDefLineColPtIcon() == null ? null : ims.core.vo.lookups.LineColourPointIcon.buildLookup(bean.getDefLineColPtIcon());
		this.normalbandmaxvaluemale = bean.getNormalBandMaxValueMale();
		this.normalbandminvaluemale = bean.getNormalBandMinValueMale();
		this.normalbandmaxvaluefemale = bean.getNormalBandMaxValueFemale();
		this.normalbandminvaluefemale = bean.getNormalBandMinValueFemale();
		this.isactive = bean.getIsActive();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DataSetTypeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DataSetTypeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DataSetTypeVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("MAXFACTOR"))
			return getMaxFactor();
		if(fieldName.equals("MINFACTOR"))
			return getMinFactor();
		if(fieldName.equals("DEFAULTLINETYPE"))
			return getDefaultLineType();
		if(fieldName.equals("DEFLINECOLPTICON"))
			return getDefLineColPtIcon();
		if(fieldName.equals("NORMALBANDMAXVALUEMALE"))
			return getNormalBandMaxValueMale();
		if(fieldName.equals("NORMALBANDMINVALUEMALE"))
			return getNormalBandMinValueMale();
		if(fieldName.equals("NORMALBANDMAXVALUEFEMALE"))
			return getNormalBandMaxValueFemale();
		if(fieldName.equals("NORMALBANDMINVALUEFEMALE"))
			return getNormalBandMinValueFemale();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("UNITOFMEASURE"))
			return getUnitOfMeasure();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.DataSetCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.DataSetCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getMaxFactorIsNotNull()
	{
		return this.maxfactor != null;
	}
	public Integer getMaxFactor()
	{
		return this.maxfactor;
	}
	public void setMaxFactor(Integer value)
	{
		this.isValidated = false;
		this.maxfactor = value;
	}
	public boolean getMinFactorIsNotNull()
	{
		return this.minfactor != null;
	}
	public Integer getMinFactor()
	{
		return this.minfactor;
	}
	public void setMinFactor(Integer value)
	{
		this.isValidated = false;
		this.minfactor = value;
	}
	public boolean getDefaultLineTypeIsNotNull()
	{
		return this.defaultlinetype != null;
	}
	public ims.core.vo.lookups.LineType getDefaultLineType()
	{
		return this.defaultlinetype;
	}
	public void setDefaultLineType(ims.core.vo.lookups.LineType value)
	{
		this.isValidated = false;
		this.defaultlinetype = value;
	}
	public boolean getDefLineColPtIconIsNotNull()
	{
		return this.deflinecolpticon != null;
	}
	public ims.core.vo.lookups.LineColourPointIcon getDefLineColPtIcon()
	{
		return this.deflinecolpticon;
	}
	public void setDefLineColPtIcon(ims.core.vo.lookups.LineColourPointIcon value)
	{
		this.isValidated = false;
		this.deflinecolpticon = value;
	}
	public boolean getNormalBandMaxValueMaleIsNotNull()
	{
		return this.normalbandmaxvaluemale != null;
	}
	public Float getNormalBandMaxValueMale()
	{
		return this.normalbandmaxvaluemale;
	}
	public void setNormalBandMaxValueMale(Float value)
	{
		this.isValidated = false;
		this.normalbandmaxvaluemale = value;
	}
	public boolean getNormalBandMinValueMaleIsNotNull()
	{
		return this.normalbandminvaluemale != null;
	}
	public Float getNormalBandMinValueMale()
	{
		return this.normalbandminvaluemale;
	}
	public void setNormalBandMinValueMale(Float value)
	{
		this.isValidated = false;
		this.normalbandminvaluemale = value;
	}
	public boolean getNormalBandMaxValueFemaleIsNotNull()
	{
		return this.normalbandmaxvaluefemale != null;
	}
	public Float getNormalBandMaxValueFemale()
	{
		return this.normalbandmaxvaluefemale;
	}
	public void setNormalBandMaxValueFemale(Float value)
	{
		this.isValidated = false;
		this.normalbandmaxvaluefemale = value;
	}
	public boolean getNormalBandMinValueFemaleIsNotNull()
	{
		return this.normalbandminvaluefemale != null;
	}
	public Float getNormalBandMinValueFemale()
	{
		return this.normalbandminvaluefemale;
	}
	public void setNormalBandMinValueFemale(Float value)
	{
		this.isValidated = false;
		this.normalbandminvaluefemale = value;
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
	public boolean getUnitOfMeasureIsNotNull()
	{
		return this.unitofmeasure != null;
	}
	public ims.ocrr.vo.lookups.ResultUnitOfMeasure getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.ocrr.vo.lookups.ResultUnitOfMeasure value)
	{
		this.isValidated = false;
		this.unitofmeasure = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.DataSetTypeVo] is too big. It should be less or equal to 100");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.defaultlinetype == null)
			listOfErrors.add("Line Type is mandatory");
		if(this.deflinecolpticon == null)
			listOfErrors.add("Line Colour / Point Icon is mandatory");
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
	
		DataSetTypeVo clone = new DataSetTypeVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.DataSetCategory)this.category.clone();
		clone.maxfactor = this.maxfactor;
		clone.minfactor = this.minfactor;
		if(this.defaultlinetype == null)
			clone.defaultlinetype = null;
		else
			clone.defaultlinetype = (ims.core.vo.lookups.LineType)this.defaultlinetype.clone();
		if(this.deflinecolpticon == null)
			clone.deflinecolpticon = null;
		else
			clone.deflinecolpticon = (ims.core.vo.lookups.LineColourPointIcon)this.deflinecolpticon.clone();
		clone.normalbandmaxvaluemale = this.normalbandmaxvaluemale;
		clone.normalbandminvaluemale = this.normalbandminvaluemale;
		clone.normalbandmaxvaluefemale = this.normalbandmaxvaluefemale;
		clone.normalbandminvaluefemale = this.normalbandminvaluefemale;
		clone.isactive = this.isactive;
		if(this.unitofmeasure == null)
			clone.unitofmeasure = null;
		else
			clone.unitofmeasure = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)this.unitofmeasure.clone();
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
		if (!(DataSetTypeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DataSetTypeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DataSetTypeVo compareObj = (DataSetTypeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
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
		if(this.name != null)
			count++;
		if(this.category != null)
			count++;
		if(this.maxfactor != null)
			count++;
		if(this.minfactor != null)
			count++;
		if(this.defaultlinetype != null)
			count++;
		if(this.deflinecolpticon != null)
			count++;
		if(this.normalbandmaxvaluemale != null)
			count++;
		if(this.normalbandminvaluemale != null)
			count++;
		if(this.normalbandmaxvaluefemale != null)
			count++;
		if(this.normalbandminvaluefemale != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.unitofmeasure != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String name;
	protected ims.core.vo.lookups.DataSetCategory category;
	protected Integer maxfactor;
	protected Integer minfactor;
	protected ims.core.vo.lookups.LineType defaultlinetype;
	protected ims.core.vo.lookups.LineColourPointIcon deflinecolpticon;
	protected Float normalbandmaxvaluemale;
	protected Float normalbandminvaluemale;
	protected Float normalbandmaxvaluefemale;
	protected Float normalbandminvaluefemale;
	protected Boolean isactive;
	protected ims.ocrr.vo.lookups.ResultUnitOfMeasure unitofmeasure;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
