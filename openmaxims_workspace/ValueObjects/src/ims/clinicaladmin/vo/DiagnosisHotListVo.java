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
 * Linked to clinical.configuration.DiagnosisHotlist business object (ID: 1073100006).
 */
public class DiagnosisHotListVo extends ims.clinicaladmin.vo.DiagnosisHotListShortVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlist
{
	private static final long serialVersionUID = 1L;

	public DiagnosisHotListVo()
	{
	}
	public DiagnosisHotListVo(Integer id, int version)
	{
		super(id, version);
	}
	public DiagnosisHotListVo(ims.clinicaladmin.vo.beans.DiagnosisHotListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo();
		this.hotlistitems = ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection.buildFromBeanCollection(bean.getHotListItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.DiagnosisHotListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.isglobal = bean.getIsGlobal();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo(map);
		this.hotlistitems = ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection.buildFromBeanCollection(bean.getHotListItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.DiagnosisHotListVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.DiagnosisHotListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.DiagnosisHotListVoBean();
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
		if(fieldName.equals("ISGLOBAL"))
			return getIsGlobal();
		if(fieldName.equals("USER"))
			return getUser();
		if(fieldName.equals("HOTLISTITEMS"))
			return getHotListItems();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsGlobalIsNotNull()
	{
		return this.isglobal != null;
	}
	public Boolean getIsGlobal()
	{
		return this.isglobal;
	}
	public void setIsGlobal(Boolean value)
	{
		this.isValidated = false;
		this.isglobal = value;
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public ims.core.vo.MedicVo getUser()
	{
		return this.user;
	}
	public void setUser(ims.core.vo.MedicVo value)
	{
		this.isValidated = false;
		this.user = value;
	}
	public boolean getHotListItemsIsNotNull()
	{
		return this.hotlistitems != null;
	}
	public ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection getHotListItems()
	{
		return this.hotlistitems;
	}
	public void setHotListItems(ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection value)
	{
		this.isValidated = false;
		this.hotlistitems = value;
	}
	/**
	* list the Diagnoses associated with this hotlist
	*/
	public ims.core.vo.DiagLiteVoCollection listDiagnoses()
	{
		ims.core.vo.DiagLiteVoCollection voCollExistingDiagnoses = new ims.core.vo.DiagLiteVoCollection();
		if (this.getHotListItems() != null)
		{
			for (int x=0; x < this.getHotListItems().size();x++)
				voCollExistingDiagnoses.add(this.getHotListItems().get(x).getDiagnosis());
		}
		return voCollExistingDiagnoses;
	}
	/**
	* IHotlist
	*/
	public ims.vo.interfaces.IHotlistItem[] getIHotlistItems() 
	{
		return this.getHotListItems().toIHotlistItemArray();
	}
	
	public void removeIHotlistItem(ims.vo.interfaces.IHotlistItem iHotlistItem) 
	{
		this.getHotListItems().remove((DiagnosisHotlistItemVo)iHotlistItem);
	}
	
	public void addIHotlistItem(ims.vo.interfaces.IGenericItemInfo cciItem) 
	{
		DiagnosisHotlistItemVo newItem = new DiagnosisHotlistItemVo();
		newItem.setDiagnosis((ims.core.vo.DiagLiteVo)cciItem);
		this.getHotListItems().add(newItem);
	}
	
	public void setIHotlistItems(ims.vo.interfaces.IHotlistItem[] iHotlistItems) 
	{
		if (iHotlistItems == null)
			return;
		
		DiagnosisHotlistItemVoCollection voColl = new DiagnosisHotlistItemVoCollection();
		for (int i = 0; i < iHotlistItems.length; i++)
		{
			voColl.add((DiagnosisHotlistItemVo)iHotlistItems[i]);
		}
		this.setHotListItems(voColl);
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
		if(this.user != null)
		{
			if(!this.user.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.hotlistitems != null)
		{
			if(!this.hotlistitems.isValidated())
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
		if(this.user != null)
		{
			String[] listOfOtherErrors = this.user.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.hotlistitems != null)
		{
			String[] listOfOtherErrors = this.hotlistitems.validate();
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
	
		DiagnosisHotListVo clone = new DiagnosisHotListVo(this.id, this.version);
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.isglobal = this.isglobal;
		if(this.user == null)
			clone.user = null;
		else
			clone.user = (ims.core.vo.MedicVo)this.user.clone();
		if(this.hotlistitems == null)
			clone.hotlistitems = null;
		else
			clone.hotlistitems = (ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection)this.hotlistitems.clone();
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
		if (!(DiagnosisHotListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiagnosisHotListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DiagnosisHotListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DiagnosisHotListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.isglobal != null)
			count++;
		if(this.user != null)
			count++;
		if(this.hotlistitems != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected Boolean isglobal;
	protected ims.core.vo.MedicVo user;
	protected ims.clinicaladmin.vo.DiagnosisHotlistItemVoCollection hotlistitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
