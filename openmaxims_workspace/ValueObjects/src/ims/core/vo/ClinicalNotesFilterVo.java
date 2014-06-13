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
 * Linked to core.clinical.Clinical Notes business object (ID: 1011100000).
 */
public class ClinicalNotesFilterVo extends ims.core.clinical.vo.ClinicalNotesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalNotesFilterVo()
	{
	}
	public ClinicalNotesFilterVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalNotesFilterVo(ims.core.vo.beans.ClinicalNotesFilterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ClinicalNotesStatus.buildLookup(bean.getStatus());
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.ClinicalNoteType.buildLookup(bean.getNoteType());
		this.forreview = bean.getForReview();
		this.forreviewdiscipline = bean.getForReviewDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getForReviewDiscipline());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ClinicalNotesFilterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.ClinicalNotesStatus.buildLookup(bean.getStatus());
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.ClinicalNoteType.buildLookup(bean.getNoteType());
		this.forreview = bean.getForReview();
		this.forreviewdiscipline = bean.getForReviewDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getForReviewDiscipline());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ClinicalNotesFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ClinicalNotesFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ClinicalNotesFilterVoBean();
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
		if(fieldName.equals("DISCIPLINE"))
			return getDiscipline();
		if(fieldName.equals("DATEFROM"))
			return getDateFrom();
		if(fieldName.equals("DATETO"))
			return getDateTo();
		if(fieldName.equals("RECORDINGUSER"))
			return getRecordingUser();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("NOTETYPE"))
			return getNoteType();
		if(fieldName.equals("FORREVIEW"))
			return getForReview();
		if(fieldName.equals("FORREVIEWDISCIPLINE"))
			return getForReviewDiscipline();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.lookups.HcpDisType getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.DateTime getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.DateTime getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getRecordingUserIsNotNull()
	{
		return this.recordinguser != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.recordinguser = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.ClinicalNotesStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.ClinicalNotesStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
	public boolean getNoteTypeIsNotNull()
	{
		return this.notetype != null;
	}
	public ims.core.vo.lookups.ClinicalNoteType getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.core.vo.lookups.ClinicalNoteType value)
	{
		this.isValidated = false;
		this.notetype = value;
	}
	public boolean getForReviewIsNotNull()
	{
		return this.forreview != null;
	}
	public Boolean getForReview()
	{
		return this.forreview;
	}
	public void setForReview(Boolean value)
	{
		this.isValidated = false;
		this.forreview = value;
	}
	public boolean getForReviewDisciplineIsNotNull()
	{
		return this.forreviewdiscipline != null;
	}
	public ims.core.vo.lookups.HcpDisType getForReviewDiscipline()
	{
		return this.forreviewdiscipline;
	}
	public void setForReviewDiscipline(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.forreviewdiscipline = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.Hcp getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
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
		if(this.recordinguser != null)
		{
			if(!this.recordinguser.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
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
		if(this.recordinguser != null)
		{
			String[] listOfOtherErrors = this.recordinguser.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
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
	
		ClinicalNotesFilterVo clone = new ClinicalNotesFilterVo(this.id, this.version);
		
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisType)this.discipline.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.DateTime)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.DateTime)this.dateto.clone();
		if(this.recordinguser == null)
			clone.recordinguser = null;
		else
			clone.recordinguser = (ims.core.vo.MemberOfStaffShortVo)this.recordinguser.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.ClinicalNotesStatus)this.status.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		clone.episodeofcare = this.episodeofcare;
		clone.carecontext = this.carecontext;
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.core.vo.lookups.ClinicalNoteType)this.notetype.clone();
		clone.forreview = this.forreview;
		if(this.forreviewdiscipline == null)
			clone.forreviewdiscipline = null;
		else
			clone.forreviewdiscipline = (ims.core.vo.lookups.HcpDisType)this.forreviewdiscipline.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.Hcp)this.authoringhcp.clone();
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
		if (!(ClinicalNotesFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalNotesFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalNotesFilterVo compareObj = (ClinicalNotesFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDiscipline() == null && compareObj.getDiscipline() != null)
				return -1;
			if(this.getDiscipline() != null && compareObj.getDiscipline() == null)
				return 1;
			if(this.getDiscipline() != null && compareObj.getDiscipline() != null)
				retVal = this.getDiscipline().compareTo(compareObj.getDiscipline());
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
		if(this.discipline != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.recordinguser != null)
			count++;
		if(this.status != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.notetype != null)
			count++;
		if(this.forreview != null)
			count++;
		if(this.forreviewdiscipline != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.core.vo.lookups.HcpDisType discipline;
	protected ims.framework.utils.DateTime datefrom;
	protected ims.framework.utils.DateTime dateto;
	protected ims.core.vo.MemberOfStaffShortVo recordinguser;
	protected ims.core.vo.lookups.ClinicalNotesStatus status;
	protected ims.core.vo.PatientShort patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.lookups.ClinicalNoteType notetype;
	protected Boolean forreview;
	protected ims.core.vo.lookups.HcpDisType forreviewdiscipline;
	protected ims.core.vo.Hcp authoringhcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
