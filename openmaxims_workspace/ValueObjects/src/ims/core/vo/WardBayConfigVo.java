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
 * Linked to core.admin.pas.WardBayConfig business object (ID: 1014100014).
 */
public class WardBayConfigVo extends ims.core.admin.pas.vo.WardBayConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardBayConfigVo()
	{
	}
	public WardBayConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardBayConfigVo(ims.core.vo.beans.WardBayConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.bays = ims.core.vo.BayConfigVoCollection.buildFromBeanCollection(bean.getBays());
		this.mainspecialty = bean.getMainSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getMainSpecialty());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.iswaitingarea = bean.getIsWaitingArea();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardBayConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.bays = ims.core.vo.BayConfigVoCollection.buildFromBeanCollection(bean.getBays());
		this.mainspecialty = bean.getMainSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getMainSpecialty());
		this.specialties = ims.core.vo.lookups.SpecialtyCollection.buildFromBeanCollection(bean.getSpecialties());
		this.iswaitingarea = bean.getIsWaitingArea();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardBayConfigVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardBayConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardBayConfigVoBean();
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
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("BAYS"))
			return getBays();
		if(fieldName.equals("MAINSPECIALTY"))
			return getMainSpecialty();
		if(fieldName.equals("SPECIALTIES"))
			return getSpecialties();
		if(fieldName.equals("ISWAITINGAREA"))
			return getIsWaitingArea();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getBaysIsNotNull()
	{
		return this.bays != null;
	}
	public ims.core.vo.BayConfigVoCollection getBays()
	{
		return this.bays;
	}
	public void setBays(ims.core.vo.BayConfigVoCollection value)
	{
		this.isValidated = false;
		this.bays = value;
	}
	public boolean getMainSpecialtyIsNotNull()
	{
		return this.mainspecialty != null;
	}
	public ims.core.vo.lookups.Specialty getMainSpecialty()
	{
		return this.mainspecialty;
	}
	public void setMainSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.mainspecialty = value;
	}
	public boolean getSpecialtiesIsNotNull()
	{
		return this.specialties != null;
	}
	public ims.core.vo.lookups.SpecialtyCollection getSpecialties()
	{
		return this.specialties;
	}
	public void setSpecialties(ims.core.vo.lookups.SpecialtyCollection value)
	{
		this.isValidated = false;
		this.specialties = value;
	}
	public boolean getIsWaitingAreaIsNotNull()
	{
		return this.iswaitingarea != null;
	}
	public Boolean getIsWaitingArea()
	{
		return this.iswaitingarea;
	}
	public void setIsWaitingArea(Boolean value)
	{
		this.isValidated = false;
		this.iswaitingarea = value;
	}
	/**
	* getSpecialtiesTooltip
	*/
		public String getSpecialtiesTooltip()
		{
			StringBuffer strBuffer = new StringBuffer();
			if(this.specialties != null)
			{
				for(int i=0;i<this.specialties.size(); i++)
				{
					strBuffer.append(this.specialties.get(i).getText() + (this.specialties.size() > 1 && (i>=0 && i!= this.specialties.size()-1)? "," : ""));
				}
			}
			
			return strBuffer.toString();
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
		if(this.bays != null)
		{
			if(!this.bays.isValidated())
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
		if(this.ward == null)
			listOfErrors.add("Ward is mandatory");
		if(this.bays == null || this.bays.size() == 0)
			listOfErrors.add("Bays are mandatory");
		if(this.bays != null)
		{
			String[] listOfOtherErrors = this.bays.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mainspecialty == null)
			listOfErrors.add("Main Specialty is mandatory");
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
	
		WardBayConfigVo clone = new WardBayConfigVo(this.id, this.version);
		
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.bays == null)
			clone.bays = null;
		else
			clone.bays = (ims.core.vo.BayConfigVoCollection)this.bays.clone();
		if(this.mainspecialty == null)
			clone.mainspecialty = null;
		else
			clone.mainspecialty = (ims.core.vo.lookups.Specialty)this.mainspecialty.clone();
		if(this.specialties == null)
			clone.specialties = null;
		else
			clone.specialties = (ims.core.vo.lookups.SpecialtyCollection)this.specialties.clone();
		clone.iswaitingarea = this.iswaitingarea;
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
		if (!(WardBayConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardBayConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WardBayConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WardBayConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ward != null)
			count++;
		if(this.bays != null)
			count++;
		if(this.mainspecialty != null)
			count++;
		if(this.specialties != null)
			count++;
		if(this.iswaitingarea != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.BayConfigVoCollection bays;
	protected ims.core.vo.lookups.Specialty mainspecialty;
	protected ims.core.vo.lookups.SpecialtyCollection specialties;
	protected Boolean iswaitingarea;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
