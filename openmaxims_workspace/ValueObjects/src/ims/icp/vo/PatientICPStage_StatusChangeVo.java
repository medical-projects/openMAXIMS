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

package ims.icp.vo;

/**
 * Linked to ICPs.Instantiation.PatientICPStage business object (ID: 1100100001).
 */
public class PatientICPStage_StatusChangeVo extends ims.icps.instantiation.vo.PatientICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPStage_StatusChangeVo()
	{
	}
	public PatientICPStage_StatusChangeVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStage_StatusChangeVo(ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.icps.instantiation.vo.PatientICPStageStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
		this.stagephases = ims.icp.vo.PatientICPPhase_StatusChangeVoCollection.buildFromBeanCollection(bean.getStagePhases());
		this.stage = bean.getStage() == null ? null : new ims.icps.configuration.vo.ICPStageRefVo(new Integer(bean.getStage().getId()), bean.getStage().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		if(bean.getStatusHistory() != null)
		{
			this.statushistory = new ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection();
			for(int statushistory_i = 0; statushistory_i < bean.getStatusHistory().length; statushistory_i++)
			{
				this.statushistory.add(new ims.icps.instantiation.vo.PatientICPStageStatusRefVo(new Integer(bean.getStatusHistory()[statushistory_i].getId()), bean.getStatusHistory()[statushistory_i].getVersion()));
			}
		}
		this.stagephases = ims.icp.vo.PatientICPPhase_StatusChangeVoCollection.buildFromBeanCollection(bean.getStagePhases());
		this.stage = bean.getStage() == null ? null : new ims.icps.configuration.vo.ICPStageRefVo(new Integer(bean.getStage().getId()), bean.getStage().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStage_StatusChangeVoBean();
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
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("STAGEPHASES"))
			return getStagePhases();
		if(fieldName.equals("STAGE"))
			return getStage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPStageStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPStageStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getStagePhasesIsNotNull()
	{
		return this.stagephases != null;
	}
	public ims.icp.vo.PatientICPPhase_StatusChangeVoCollection getStagePhases()
	{
		return this.stagephases;
	}
	public void setStagePhases(ims.icp.vo.PatientICPPhase_StatusChangeVoCollection value)
	{
		this.isValidated = false;
		this.stagephases = value;
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.icps.configuration.vo.ICPStageRefVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.icps.configuration.vo.ICPStageRefVo value)
	{
		this.isValidated = false;
		this.stage = value;
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
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.stagephases != null)
		{
			if(!this.stagephases.isValidated())
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
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
		if(this.stagephases != null)
		{
			String[] listOfOtherErrors = this.stagephases.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
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
	
		PatientICPStage_StatusChangeVo clone = new PatientICPStage_StatusChangeVo(this.id, this.version);
		
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPStageStatusVo)this.currentstatus.clone();
		clone.statushistory = this.statushistory;
		if(this.stagephases == null)
			clone.stagephases = null;
		else
			clone.stagephases = (ims.icp.vo.PatientICPPhase_StatusChangeVoCollection)this.stagephases.clone();
		clone.stage = this.stage;
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
		if (!(PatientICPStage_StatusChangeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStage_StatusChangeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStage_StatusChangeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStage_StatusChangeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.stagephases != null)
			count++;
		if(this.stage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.icp.vo.PatientICPStageStatusVo currentstatus;
	protected ims.icps.instantiation.vo.PatientICPStageStatusRefVoCollection statushistory;
	protected ims.icp.vo.PatientICPPhase_StatusChangeVoCollection stagephases;
	protected ims.icps.configuration.vo.ICPStageRefVo stage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
