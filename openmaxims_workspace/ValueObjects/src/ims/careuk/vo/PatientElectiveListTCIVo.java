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

package ims.careuk.vo;

/**
 * Linked to CAREUK.TCIForPatientElectiveList business object (ID: 1096100064).
 */
public class PatientElectiveListTCIVo extends ims.careuk.vo.TCIForPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListTCIVo()
	{
	}
	public PatientElectiveListTCIVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListTCIVo(ims.careuk.vo.beans.PatientElectiveListTCIVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tcioffermethod = bean.getTCIOfferMethod() == null ? null : ims.core.vo.lookups.TCIOfferMethod.buildLookup(bean.getTCIOfferMethod());
		this.datetciaccepted = bean.getDateTCIAccepted() == null ? null : bean.getDateTCIAccepted().buildDate();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
		this.comments = bean.getComments();
		this.planningelective = bean.getPlanningElective() == null ? null : ims.careuk.vo.lookups.PlanningElective.buildLookup(bean.getPlanningElective());
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo();
		this.tcibed = bean.getTCIBed();
		this.tciconsultant = bean.getTCIConsultant() == null ? null : bean.getTCIConsultant().buildVo();
		this.datetcioffered = bean.getDateTCIOffered() == null ? null : bean.getDateTCIOffered().buildDate();
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo();
		this.outcomehistory = ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getOutcomeHistory());
		this.isactive = bean.getIsActive();
		this.kpiexceededreason = bean.getKPIExceededReason() == null ? null : ims.careuk.vo.lookups.KPIExceededReason.buildLookup(bean.getKPIExceededReason());
		this.tcihospital = bean.getTCIHospital() == null ? null : bean.getTCIHospital().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientElectiveListTCIVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.tcioffermethod = bean.getTCIOfferMethod() == null ? null : ims.core.vo.lookups.TCIOfferMethod.buildLookup(bean.getTCIOfferMethod());
		this.datetciaccepted = bean.getDateTCIAccepted() == null ? null : bean.getDateTCIAccepted().buildDate();
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
		this.comments = bean.getComments();
		this.planningelective = bean.getPlanningElective() == null ? null : ims.careuk.vo.lookups.PlanningElective.buildLookup(bean.getPlanningElective());
		this.tciward = bean.getTCIWard() == null ? null : bean.getTCIWard().buildVo(map);
		this.tcibed = bean.getTCIBed();
		this.tciconsultant = bean.getTCIConsultant() == null ? null : bean.getTCIConsultant().buildVo(map);
		this.datetcioffered = bean.getDateTCIOffered() == null ? null : bean.getDateTCIOffered().buildDate();
		this.currentoutcome = bean.getCurrentOutcome() == null ? null : bean.getCurrentOutcome().buildVo(map);
		this.outcomehistory = ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getOutcomeHistory());
		this.isactive = bean.getIsActive();
		this.kpiexceededreason = bean.getKPIExceededReason() == null ? null : ims.careuk.vo.lookups.KPIExceededReason.buildLookup(bean.getKPIExceededReason());
		this.tcihospital = bean.getTCIHospital() == null ? null : bean.getTCIHospital().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientElectiveListTCIVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientElectiveListTCIVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientElectiveListTCIVoBean();
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
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("TCIOFFERMETHOD"))
			return getTCIOfferMethod();
		if(fieldName.equals("DATETCIACCEPTED"))
			return getDateTCIAccepted();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("PLANNINGELECTIVE"))
			return getPlanningElective();
		if(fieldName.equals("TCIWARD"))
			return getTCIWard();
		if(fieldName.equals("TCIBED"))
			return getTCIBed();
		if(fieldName.equals("TCICONSULTANT"))
			return getTCIConsultant();
		if(fieldName.equals("DATETCIOFFERED"))
			return getDateTCIOffered();
		if(fieldName.equals("CURRENTOUTCOME"))
			return getCurrentOutcome();
		if(fieldName.equals("OUTCOMEHISTORY"))
			return getOutcomeHistory();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("KPIEXCEEDEDREASON"))
			return getKPIExceededReason();
		if(fieldName.equals("TCIHOSPITAL"))
			return getTCIHospital();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
	}
	public boolean getTCITimeIsNotNull()
	{
		return this.tcitime != null;
	}
	public ims.framework.utils.Time getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tcitime = value;
	}
	public boolean getTCIOfferMethodIsNotNull()
	{
		return this.tcioffermethod != null;
	}
	public ims.core.vo.lookups.TCIOfferMethod getTCIOfferMethod()
	{
		return this.tcioffermethod;
	}
	public void setTCIOfferMethod(ims.core.vo.lookups.TCIOfferMethod value)
	{
		this.isValidated = false;
		this.tcioffermethod = value;
	}
	public boolean getDateTCIAcceptedIsNotNull()
	{
		return this.datetciaccepted != null;
	}
	public ims.framework.utils.Date getDateTCIAccepted()
	{
		return this.datetciaccepted;
	}
	public void setDateTCIAccepted(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datetciaccepted = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.careuk.vo.Booking_AppointmentElectiveListVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.careuk.vo.Booking_AppointmentElectiveListVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.Sch_SessionRefVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.Sch_SessionRefVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getPlanningElectiveIsNotNull()
	{
		return this.planningelective != null;
	}
	public ims.careuk.vo.lookups.PlanningElective getPlanningElective()
	{
		return this.planningelective;
	}
	public void setPlanningElective(ims.careuk.vo.lookups.PlanningElective value)
	{
		this.isValidated = false;
		this.planningelective = value;
	}
	public boolean getTCIWardIsNotNull()
	{
		return this.tciward != null;
	}
	public ims.core.vo.LocationLiteVo getTCIWard()
	{
		return this.tciward;
	}
	public void setTCIWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.tciward = value;
	}
	public boolean getTCIBedIsNotNull()
	{
		return this.tcibed != null;
	}
	public String getTCIBed()
	{
		return this.tcibed;
	}
	public static int getTCIBedMaxLength()
	{
		return 255;
	}
	public void setTCIBed(String value)
	{
		this.isValidated = false;
		this.tcibed = value;
	}
	public boolean getTCIConsultantIsNotNull()
	{
		return this.tciconsultant != null;
	}
	public ims.core.vo.HcpLiteVo getTCIConsultant()
	{
		return this.tciconsultant;
	}
	public void setTCIConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.tciconsultant = value;
	}
	public boolean getDateTCIOfferedIsNotNull()
	{
		return this.datetcioffered != null;
	}
	public ims.framework.utils.Date getDateTCIOffered()
	{
		return this.datetcioffered;
	}
	public void setDateTCIOffered(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datetcioffered = value;
	}
	public boolean getCurrentOutcomeIsNotNull()
	{
		return this.currentoutcome != null;
	}
	public ims.careuk.vo.TCIOutcomeForPatientElectiveListVo getCurrentOutcome()
	{
		return this.currentoutcome;
	}
	public void setCurrentOutcome(ims.careuk.vo.TCIOutcomeForPatientElectiveListVo value)
	{
		this.isValidated = false;
		this.currentoutcome = value;
	}
	public boolean getOutcomeHistoryIsNotNull()
	{
		return this.outcomehistory != null;
	}
	public ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection getOutcomeHistory()
	{
		return this.outcomehistory;
	}
	public void setOutcomeHistory(ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection value)
	{
		this.isValidated = false;
		this.outcomehistory = value;
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
	public boolean getKPIExceededReasonIsNotNull()
	{
		return this.kpiexceededreason != null;
	}
	public ims.careuk.vo.lookups.KPIExceededReason getKPIExceededReason()
	{
		return this.kpiexceededreason;
	}
	public void setKPIExceededReason(ims.careuk.vo.lookups.KPIExceededReason value)
	{
		this.isValidated = false;
		this.kpiexceededreason = value;
	}
	public boolean getTCIHospitalIsNotNull()
	{
		return this.tcihospital != null;
	}
	public ims.core.vo.LocationLiteVo getTCIHospital()
	{
		return this.tcihospital;
	}
	public void setTCIHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.tcihospital = value;
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
		if(this.currentoutcome != null)
		{
			if(!this.currentoutcome.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.outcomehistory != null)
		{
			if(!this.outcomehistory.isValidated())
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
		if(this.tcidate == null)
			listOfErrors.add("TCIDate is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 1000)
				listOfErrors.add("The length of the field [comments] in the value object [ims.careuk.vo.PatientElectiveListTCIVo] is too big. It should be less or equal to 1000");
		if(this.tcibed != null)
			if(this.tcibed.length() > 255)
				listOfErrors.add("The length of the field [tcibed] in the value object [ims.careuk.vo.PatientElectiveListTCIVo] is too big. It should be less or equal to 255");
		if(this.datetcioffered == null)
			listOfErrors.add("DateTCIOffered is mandatory");
		if(this.currentoutcome != null)
		{
			String[] listOfOtherErrors = this.currentoutcome.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.outcomehistory != null)
		{
			String[] listOfOtherErrors = this.outcomehistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
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
	
		PatientElectiveListTCIVo clone = new PatientElectiveListTCIVo(this.id, this.version);
		
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
		if(this.tcioffermethod == null)
			clone.tcioffermethod = null;
		else
			clone.tcioffermethod = (ims.core.vo.lookups.TCIOfferMethod)this.tcioffermethod.clone();
		if(this.datetciaccepted == null)
			clone.datetciaccepted = null;
		else
			clone.datetciaccepted = (ims.framework.utils.Date)this.datetciaccepted.clone();
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.careuk.vo.Booking_AppointmentElectiveListVo)this.appointment.clone();
		clone.session = this.session;
		clone.comments = this.comments;
		if(this.planningelective == null)
			clone.planningelective = null;
		else
			clone.planningelective = (ims.careuk.vo.lookups.PlanningElective)this.planningelective.clone();
		if(this.tciward == null)
			clone.tciward = null;
		else
			clone.tciward = (ims.core.vo.LocationLiteVo)this.tciward.clone();
		clone.tcibed = this.tcibed;
		if(this.tciconsultant == null)
			clone.tciconsultant = null;
		else
			clone.tciconsultant = (ims.core.vo.HcpLiteVo)this.tciconsultant.clone();
		if(this.datetcioffered == null)
			clone.datetcioffered = null;
		else
			clone.datetcioffered = (ims.framework.utils.Date)this.datetcioffered.clone();
		if(this.currentoutcome == null)
			clone.currentoutcome = null;
		else
			clone.currentoutcome = (ims.careuk.vo.TCIOutcomeForPatientElectiveListVo)this.currentoutcome.clone();
		if(this.outcomehistory == null)
			clone.outcomehistory = null;
		else
			clone.outcomehistory = (ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection)this.outcomehistory.clone();
		clone.isactive = this.isactive;
		if(this.kpiexceededreason == null)
			clone.kpiexceededreason = null;
		else
			clone.kpiexceededreason = (ims.careuk.vo.lookups.KPIExceededReason)this.kpiexceededreason.clone();
		if(this.tcihospital == null)
			clone.tcihospital = null;
		else
			clone.tcihospital = (ims.core.vo.LocationLiteVo)this.tcihospital.clone();
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
		if (!(PatientElectiveListTCIVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListTCIVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListTCIVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListTCIVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.tcioffermethod != null)
			count++;
		if(this.datetciaccepted != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.session != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.planningelective != null)
			count++;
		if(this.tciward != null)
			count++;
		if(this.tcibed != null)
			count++;
		if(this.tciconsultant != null)
			count++;
		if(this.datetcioffered != null)
			count++;
		if(this.currentoutcome != null)
			count++;
		if(this.outcomehistory != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.kpiexceededreason != null)
			count++;
		if(this.tcihospital != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected ims.core.vo.lookups.TCIOfferMethod tcioffermethod;
	protected ims.framework.utils.Date datetciaccepted;
	protected ims.careuk.vo.Booking_AppointmentElectiveListVo appointment;
	protected ims.scheduling.vo.Sch_SessionRefVo session;
	protected String comments;
	protected ims.careuk.vo.lookups.PlanningElective planningelective;
	protected ims.core.vo.LocationLiteVo tciward;
	protected String tcibed;
	protected ims.core.vo.HcpLiteVo tciconsultant;
	protected ims.framework.utils.Date datetcioffered;
	protected ims.careuk.vo.TCIOutcomeForPatientElectiveListVo currentoutcome;
	protected ims.careuk.vo.TCIOutcomeForPatientElectiveListVoCollection outcomehistory;
	protected Boolean isactive;
	protected ims.careuk.vo.lookups.KPIExceededReason kpiexceededreason;
	protected ims.core.vo.LocationLiteVo tcihospital;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
