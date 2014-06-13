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
 * Linked to ICPs.Instantiation.PatientICP business object (ID: 1100100000).
 */
public class PatientICP_EvaluationNotesVo extends ims.icps.instantiation.vo.PatientICPRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICP_EvaluationNotesVo()
	{
	}
	public PatientICP_EvaluationNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICP_EvaluationNotesVo(ims.icp.vo.beans.PatientICP_EvaluationNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.evaluationnotes = ims.icp.vo.PatientICPEvaluationNoteVoCollection.buildFromBeanCollection(bean.getEvaluationNotes());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICP_EvaluationNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.evaluationnotes = ims.icp.vo.PatientICPEvaluationNoteVoCollection.buildFromBeanCollection(bean.getEvaluationNotes());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICP_EvaluationNotesVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICP_EvaluationNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICP_EvaluationNotesVoBean();
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
		if(fieldName.equals("EVALUATIONNOTES"))
			return getEvaluationNotes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEvaluationNotesIsNotNull()
	{
		return this.evaluationnotes != null;
	}
	public ims.icp.vo.PatientICPEvaluationNoteVoCollection getEvaluationNotes()
	{
		return this.evaluationnotes;
	}
	public void setEvaluationNotes(ims.icp.vo.PatientICPEvaluationNoteVoCollection value)
	{
		this.isValidated = false;
		this.evaluationnotes = value;
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
		if(this.evaluationnotes != null)
		{
			if(!this.evaluationnotes.isValidated())
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
		if(this.evaluationnotes != null)
		{
			String[] listOfOtherErrors = this.evaluationnotes.validate();
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
	
		PatientICP_EvaluationNotesVo clone = new PatientICP_EvaluationNotesVo(this.id, this.version);
		
		if(this.evaluationnotes == null)
			clone.evaluationnotes = null;
		else
			clone.evaluationnotes = (ims.icp.vo.PatientICPEvaluationNoteVoCollection)this.evaluationnotes.clone();
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
		if (!(PatientICP_EvaluationNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICP_EvaluationNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICP_EvaluationNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICP_EvaluationNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.evaluationnotes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.icp.vo.PatientICPEvaluationNoteVoCollection evaluationnotes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
