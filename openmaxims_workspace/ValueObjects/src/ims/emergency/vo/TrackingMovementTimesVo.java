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
 * Linked to emergency.TrackingMovementTimes business object (ID: 1086100009).
 */
public class TrackingMovementTimesVo extends ims.emergency.vo.TrackingMovementTimesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingMovementTimesVo()
	{
	}
	public TrackingMovementTimesVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingMovementTimesVo(ims.emergency.vo.beans.TrackingMovementTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.areamovedto = bean.getAreaMovedTo() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getAreaMovedTo().getId()), bean.getAreaMovedTo().getVersion());
		this.moveddatetime = bean.getMovedDateTime() == null ? null : bean.getMovedDateTime().buildDateTime();
		this.movedby = bean.getMovedBy() == null ? null : bean.getMovedBy().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingMovementTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.areamovedto = bean.getAreaMovedTo() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getAreaMovedTo().getId()), bean.getAreaMovedTo().getVersion());
		this.moveddatetime = bean.getMovedDateTime() == null ? null : bean.getMovedDateTime().buildDateTime();
		this.movedby = bean.getMovedBy() == null ? null : bean.getMovedBy().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingMovementTimesVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingMovementTimesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingMovementTimesVoBean();
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
		if(fieldName.equals("AREAMOVEDTO"))
			return getAreaMovedTo();
		if(fieldName.equals("MOVEDDATETIME"))
			return getMovedDateTime();
		if(fieldName.equals("MOVEDBY"))
			return getMovedBy();
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
	public boolean getAreaMovedToIsNotNull()
	{
		return this.areamovedto != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getAreaMovedTo()
	{
		return this.areamovedto;
	}
	public void setAreaMovedTo(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.areamovedto = value;
	}
	public boolean getMovedDateTimeIsNotNull()
	{
		return this.moveddatetime != null;
	}
	public ims.framework.utils.DateTime getMovedDateTime()
	{
		return this.moveddatetime;
	}
	public void setMovedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.moveddatetime = value;
	}
	public boolean getMovedByIsNotNull()
	{
		return this.movedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getMovedBy()
	{
		return this.movedby;
	}
	public void setMovedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.movedby = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.areamovedto == null)
			listOfErrors.add("AreaMovedTo is mandatory");
		if(this.moveddatetime == null)
			listOfErrors.add("MovedDateTime is mandatory");
		if(this.movedby == null)
			listOfErrors.add("MovedBy is mandatory");
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
	
		TrackingMovementTimesVo clone = new TrackingMovementTimesVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		clone.areamovedto = this.areamovedto;
		if(this.moveddatetime == null)
			clone.moveddatetime = null;
		else
			clone.moveddatetime = (ims.framework.utils.DateTime)this.moveddatetime.clone();
		if(this.movedby == null)
			clone.movedby = null;
		else
			clone.movedby = (ims.core.vo.MemberOfStaffLiteVo)this.movedby.clone();
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
		if (!(TrackingMovementTimesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingMovementTimesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingMovementTimesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingMovementTimesVo)obj).getBoId());
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
		if(this.areamovedto != null)
			count++;
		if(this.moveddatetime != null)
			count++;
		if(this.movedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.emergency.configuration.vo.TrackingAreaRefVo areamovedto;
	protected ims.framework.utils.DateTime moveddatetime;
	protected ims.core.vo.MemberOfStaffLiteVo movedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
