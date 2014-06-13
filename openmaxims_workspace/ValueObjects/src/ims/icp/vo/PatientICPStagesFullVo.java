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
public class PatientICPStagesFullVo extends ims.icps.instantiation.vo.PatientICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPStagesFullVo()
	{
	}
	public PatientICPStagesFullVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStagesFullVo(ims.icp.vo.beans.PatientICPStagesFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : new ims.icps.configuration.vo.ICPStageRefVo(new Integer(bean.getStage().getId()), bean.getStage().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.icp.vo.PatientICPStageStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.stagephases = ims.icp.vo.PatientICPPhasesFullVoCollection.buildFromBeanCollection(bean.getStagePhases());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStagesFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.stage = bean.getStage() == null ? null : new ims.icps.configuration.vo.ICPStageRefVo(new Integer(bean.getStage().getId()), bean.getStage().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.icp.vo.PatientICPStageStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.stagephases = ims.icp.vo.PatientICPPhasesFullVoCollection.buildFromBeanCollection(bean.getStagePhases());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStagesFullVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStagesFullVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStagesFullVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("COMPLETEDONDATE"))
			return getCompletedOnDate();
		if(fieldName.equals("STAGEPHASES"))
			return getStagePhases();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getICPIsNotNull()
	{
		return this.icp != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.icp = value;
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
	public ims.icp.vo.PatientICPStageStatusVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icp.vo.PatientICPStageStatusVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getCompletedOnDateIsNotNull()
	{
		return this.completedondate != null;
	}
	public ims.framework.utils.DateTime getCompletedOnDate()
	{
		return this.completedondate;
	}
	public void setCompletedOnDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completedondate = value;
	}
	public boolean getStagePhasesIsNotNull()
	{
		return this.stagephases != null;
	}
	public ims.icp.vo.PatientICPPhasesFullVoCollection getStagePhases()
	{
		return this.stagephases;
	}
	public void setStagePhases(ims.icp.vo.PatientICPPhasesFullVoCollection value)
	{
		this.isValidated = false;
		this.stagephases = value;
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
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
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
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		PatientICPStagesFullVo clone = new PatientICPStagesFullVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.carecontext = this.carecontext;
		clone.icp = this.icp;
		clone.stage = this.stage;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPStageStatusVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.icp.vo.PatientICPStageStatusVoCollection)this.statushistory.clone();
		if(this.completedondate == null)
			clone.completedondate = null;
		else
			clone.completedondate = (ims.framework.utils.DateTime)this.completedondate.clone();
		if(this.stagephases == null)
			clone.stagephases = null;
		else
			clone.stagephases = (ims.icp.vo.PatientICPPhasesFullVoCollection)this.stagephases.clone();
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
		if (!(PatientICPStagesFullVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStagesFullVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStagesFullVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStagesFullVo)obj).getBoId());
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
		if(this.carecontext != null)
			count++;
		if(this.icp != null)
			count++;
		if(this.stage != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.completedondate != null)
			count++;
		if(this.stagephases != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icps.configuration.vo.ICPStageRefVo stage;
	protected ims.icp.vo.PatientICPStageStatusVo currentstatus;
	protected ims.icp.vo.PatientICPStageStatusVoCollection statushistory;
	protected ims.framework.utils.DateTime completedondate;
	protected ims.icp.vo.PatientICPPhasesFullVoCollection stagephases;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
