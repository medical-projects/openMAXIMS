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

package ims.emergency.vo;

/**
 * Linked to emergency.SystemsReview business object (ID: 1086100022).
 */
public class SystemReviewVo extends ims.emergency.vo.SystemsReviewRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SystemReviewVo()
	{
	}
	public SystemReviewVo(Integer id, int version)
	{
		super(id, version);
	}
	public SystemReviewVo(ims.emergency.vo.beans.SystemReviewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.systemreviewnote = bean.getSystemReviewNote();
		this.systems = bean.getSystems() == null ? null : ims.clinical.vo.lookups.BodySystem.buildLookup(bean.getSystems());
		this.iscorrected = bean.getIsCorrected();
		this.correctedauthoringinformation = bean.getCorrectedAuthoringInformation() == null ? null : bean.getCorrectedAuthoringInformation().buildVo();
		this.correctioncomments = bean.getCorrectionComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.SystemReviewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.systemreviewnote = bean.getSystemReviewNote();
		this.systems = bean.getSystems() == null ? null : ims.clinical.vo.lookups.BodySystem.buildLookup(bean.getSystems());
		this.iscorrected = bean.getIsCorrected();
		this.correctedauthoringinformation = bean.getCorrectedAuthoringInformation() == null ? null : bean.getCorrectedAuthoringInformation().buildVo(map);
		this.correctioncomments = bean.getCorrectionComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.SystemReviewVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.SystemReviewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.SystemReviewVoBean();
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
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("SYSTEMREVIEWNOTE"))
			return getSystemReviewNote();
		if(fieldName.equals("SYSTEMS"))
			return getSystems();
		if(fieldName.equals("ISCORRECTED"))
			return getIsCorrected();
		if(fieldName.equals("CORRECTEDAUTHORINGINFORMATION"))
			return getCorrectedAuthoringInformation();
		if(fieldName.equals("CORRECTIONCOMMENTS"))
			return getCorrectionComments();
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
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getSystemReviewNoteIsNotNull()
	{
		return this.systemreviewnote != null;
	}
	public String getSystemReviewNote()
	{
		return this.systemreviewnote;
	}
	public static int getSystemReviewNoteMaxLength()
	{
		return 10000;
	}
	public void setSystemReviewNote(String value)
	{
		this.isValidated = false;
		this.systemreviewnote = value;
	}
	public boolean getSystemsIsNotNull()
	{
		return this.systems != null;
	}
	public ims.clinical.vo.lookups.BodySystem getSystems()
	{
		return this.systems;
	}
	public void setSystems(ims.clinical.vo.lookups.BodySystem value)
	{
		this.isValidated = false;
		this.systems = value;
	}
	public boolean getIsCorrectedIsNotNull()
	{
		return this.iscorrected != null;
	}
	public Boolean getIsCorrected()
	{
		return this.iscorrected;
	}
	public void setIsCorrected(Boolean value)
	{
		this.isValidated = false;
		this.iscorrected = value;
	}
	public boolean getCorrectedAuthoringInformationIsNotNull()
	{
		return this.correctedauthoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getCorrectedAuthoringInformation()
	{
		return this.correctedauthoringinformation;
	}
	public void setCorrectedAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.correctedauthoringinformation = value;
	}
	public boolean getCorrectionCommentsIsNotNull()
	{
		return this.correctioncomments != null;
	}
	public String getCorrectionComments()
	{
		return this.correctioncomments;
	}
	public static int getCorrectionCommentsMaxLength()
	{
		return 10000;
	}
	public void setCorrectionComments(String value)
	{
		this.isValidated = false;
		this.correctioncomments = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.correctedauthoringinformation != null)
		{
			if(!this.correctedauthoringinformation.isValidated())
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
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.systemreviewnote == null || this.systemreviewnote.length() == 0)
			listOfErrors.add("SystemReviewNote is mandatory");
		if(this.systems == null)
			listOfErrors.add("Systems is mandatory");
		if(this.correctedauthoringinformation != null)
		{
			String[] listOfOtherErrors = this.correctedauthoringinformation.validate();
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
	
		SystemReviewVo clone = new SystemReviewVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.systemreviewnote = this.systemreviewnote;
		if(this.systems == null)
			clone.systems = null;
		else
			clone.systems = (ims.clinical.vo.lookups.BodySystem)this.systems.clone();
		clone.iscorrected = this.iscorrected;
		if(this.correctedauthoringinformation == null)
			clone.correctedauthoringinformation = null;
		else
			clone.correctedauthoringinformation = (ims.core.vo.AuthoringInformationVo)this.correctedauthoringinformation.clone();
		clone.correctioncomments = this.correctioncomments;
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
		if (!(SystemReviewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SystemReviewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SystemReviewVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SystemReviewVo)obj).getBoId());
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
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.systemreviewnote != null)
			count++;
		if(this.systems != null)
			count++;
		if(this.iscorrected != null)
			count++;
		if(this.correctedauthoringinformation != null)
			count++;
		if(this.correctioncomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected String systemreviewnote;
	protected ims.clinical.vo.lookups.BodySystem systems;
	protected Boolean iscorrected;
	protected ims.core.vo.AuthoringInformationVo correctedauthoringinformation;
	protected String correctioncomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
