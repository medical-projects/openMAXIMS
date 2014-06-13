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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.StandingSession business object (ID: 1019100071).
 */
public class StandingSessionVo extends ims.therapies.treatment.vo.StandingSessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StandingSessionVo()
	{
	}
	public StandingSessionVo(Integer id, int version)
	{
		super(id, version);
	}
	public StandingSessionVo(ims.therapies.vo.beans.StandingSessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.frameexercise = ims.therapies.vo.FrameExerciseVoCollection.buildFromBeanCollection(bean.getFrameExercise());
		this.tilttableexercise = ims.therapies.vo.TiltExerciseVoCollection.buildFromBeanCollection(bean.getTiltTableExercise());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.StandingSessionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.frameexercise = ims.therapies.vo.FrameExerciseVoCollection.buildFromBeanCollection(bean.getFrameExercise());
		this.tilttableexercise = ims.therapies.vo.TiltExerciseVoCollection.buildFromBeanCollection(bean.getTiltTableExercise());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.StandingSessionVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.StandingSessionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.StandingSessionVoBean();
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
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("FRAMEEXERCISE"))
			return getFrameExercise();
		if(fieldName.equals("TILTTABLEEXERCISE"))
			return getTiltTableExercise();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getFrameExerciseIsNotNull()
	{
		return this.frameexercise != null;
	}
	public ims.therapies.vo.FrameExerciseVoCollection getFrameExercise()
	{
		return this.frameexercise;
	}
	public void setFrameExercise(ims.therapies.vo.FrameExerciseVoCollection value)
	{
		this.isValidated = false;
		this.frameexercise = value;
	}
	public boolean getTiltTableExerciseIsNotNull()
	{
		return this.tilttableexercise != null;
	}
	public ims.therapies.vo.TiltExerciseVoCollection getTiltTableExercise()
	{
		return this.tilttableexercise;
	}
	public void setTiltTableExercise(ims.therapies.vo.TiltExerciseVoCollection value)
	{
		this.isValidated = false;
		this.tilttableexercise = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.frameexercise != null)
		{
			if(!this.frameexercise.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tilttableexercise != null)
		{
			if(!this.tilttableexercise.isValidated())
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
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is a mandatory field");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.frameexercise != null)
		{
			String[] listOfOtherErrors = this.frameexercise.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.tilttableexercise != null)
		{
			String[] listOfOtherErrors = this.tilttableexercise.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.countFieldsWithValue() < 3)
		{
			listOfErrors.add("A minimum of 3 data fields must be entered");
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
	
		StandingSessionVo clone = new StandingSessionVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.frameexercise == null)
			clone.frameexercise = null;
		else
			clone.frameexercise = (ims.therapies.vo.FrameExerciseVoCollection)this.frameexercise.clone();
		if(this.tilttableexercise == null)
			clone.tilttableexercise = null;
		else
			clone.tilttableexercise = (ims.therapies.vo.TiltExerciseVoCollection)this.tilttableexercise.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
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
		if (!(StandingSessionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StandingSessionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		StandingSessionVo compareObj = (StandingSessionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_StandingSession() == null && compareObj.getID_StandingSession() != null)
				return -1;
			if(this.getID_StandingSession() != null && compareObj.getID_StandingSession() == null)
				return 1;
			if(this.getID_StandingSession() != null && compareObj.getID_StandingSession() != null)
				retVal = this.getID_StandingSession().compareTo(compareObj.getID_StandingSession());
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
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.frameexercise != null)
			count++;
		if(this.tilttableexercise != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.therapies.vo.FrameExerciseVoCollection frameexercise;
	protected ims.therapies.vo.TiltExerciseVoCollection tilttableexercise;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
