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

package ims.ccosched.vo;

/**
 * Linked to Oncology.PatTreatmentPlan business object (ID: 1105100037).
 */
public class PatTreatmentPlanLiteVo extends ims.oncology.vo.PatTreatmentPlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatTreatmentPlanLiteVo()
	{
	}
	public PatTreatmentPlanLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatTreatmentPlanLiteVo(ims.ccosched.vo.beans.PatTreatmentPlanLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentintent = bean.getTreatmentIntent() == null ? null : ims.ccosched.vo.lookups.TreatmentIntent.buildLookup(bean.getTreatmentIntent());
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.decisiontotreat = bean.getDecisionToTreat() == null ? null : bean.getDecisionToTreat().buildDate();
		this.actions = ims.ccosched.vo.PatTreatPlanActionVoCollection.buildFromBeanCollection(bean.getActions());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.pkey = bean.getPkey();
		this.rkey = bean.getRkey();
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.treatmentplancomment = bean.getTreatmentplanComment();
		this.activestatus = bean.getActiveStatus();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.primarytumourhistology = bean.getPrimaryTumourHistology() == null ? null : bean.getPrimaryTumourHistology().buildVo();
		this.ecad_date = bean.getEcad_date() == null ? null : bean.getEcad_date().buildDate();
		this.primarytumourgroup = bean.getPrimaryTumourGroup() == null ? null : bean.getPrimaryTumourGroup().buildVo();
		this.primarytumoursite = bean.getPrimaryTumourSite() == null ? null : bean.getPrimaryTumourSite().buildVo();
		this.treatmentsites = ims.oncology.vo.lookups.TreatmentGroupSiteCollection.buildFromBeanCollection(bean.getTreatmentSites());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.beans.PatTreatmentPlanLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentintent = bean.getTreatmentIntent() == null ? null : ims.ccosched.vo.lookups.TreatmentIntent.buildLookup(bean.getTreatmentIntent());
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.decisiontotreat = bean.getDecisionToTreat() == null ? null : bean.getDecisionToTreat().buildDate();
		this.actions = ims.ccosched.vo.PatTreatPlanActionVoCollection.buildFromBeanCollection(bean.getActions());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.pkey = bean.getPkey();
		this.rkey = bean.getRkey();
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.treatmentplancomment = bean.getTreatmentplanComment();
		this.activestatus = bean.getActiveStatus();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.primarytumourhistology = bean.getPrimaryTumourHistology() == null ? null : bean.getPrimaryTumourHistology().buildVo(map);
		this.ecad_date = bean.getEcad_date() == null ? null : bean.getEcad_date().buildDate();
		this.primarytumourgroup = bean.getPrimaryTumourGroup() == null ? null : bean.getPrimaryTumourGroup().buildVo(map);
		this.primarytumoursite = bean.getPrimaryTumourSite() == null ? null : bean.getPrimaryTumourSite().buildVo(map);
		this.treatmentsites = ims.oncology.vo.lookups.TreatmentGroupSiteCollection.buildFromBeanCollection(bean.getTreatmentSites());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.beans.PatTreatmentPlanLiteVoBean bean = null;
		if(map != null)
			bean = (ims.ccosched.vo.beans.PatTreatmentPlanLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ccosched.vo.beans.PatTreatmentPlanLiteVoBean();
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
		if(fieldName.equals("TREATMENTINTENT"))
			return getTreatmentIntent();
		if(fieldName.equals("DATESEEN"))
			return getDateSeen();
		if(fieldName.equals("DECISIONTOTREAT"))
			return getDecisionToTreat();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("PKEY"))
			return getPkey();
		if(fieldName.equals("RKEY"))
			return getRkey();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("TREATMENTPLANCOMMENT"))
			return getTreatmentplanComment();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("PRIMARYTUMOURHISTOLOGY"))
			return getPrimaryTumourHistology();
		if(fieldName.equals("ECAD_DATE"))
			return getEcad_date();
		if(fieldName.equals("PRIMARYTUMOURGROUP"))
			return getPrimaryTumourGroup();
		if(fieldName.equals("PRIMARYTUMOURSITE"))
			return getPrimaryTumourSite();
		if(fieldName.equals("TREATMENTSITES"))
			return getTreatmentSites();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentIntentIsNotNull()
	{
		return this.treatmentintent != null;
	}
	public ims.ccosched.vo.lookups.TreatmentIntent getTreatmentIntent()
	{
		return this.treatmentintent;
	}
	public void setTreatmentIntent(ims.ccosched.vo.lookups.TreatmentIntent value)
	{
		this.isValidated = false;
		this.treatmentintent = value;
	}
	public boolean getDateSeenIsNotNull()
	{
		return this.dateseen != null;
	}
	public ims.framework.utils.Date getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateseen = value;
	}
	public boolean getDecisionToTreatIsNotNull()
	{
		return this.decisiontotreat != null;
	}
	public ims.framework.utils.Date getDecisionToTreat()
	{
		return this.decisiontotreat;
	}
	public void setDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.decisiontotreat = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.ccosched.vo.PatTreatPlanActionVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.ccosched.vo.PatTreatPlanActionVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
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
	public boolean getPkeyIsNotNull()
	{
		return this.pkey != null;
	}
	public Integer getPkey()
	{
		return this.pkey;
	}
	public void setPkey(Integer value)
	{
		this.isValidated = false;
		this.pkey = value;
	}
	public boolean getRkeyIsNotNull()
	{
		return this.rkey != null;
	}
	public Integer getRkey()
	{
		return this.rkey;
	}
	public void setRkey(Integer value)
	{
		this.isValidated = false;
		this.rkey = value;
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
	public boolean getTreatmentplanCommentIsNotNull()
	{
		return this.treatmentplancomment != null;
	}
	public String getTreatmentplanComment()
	{
		return this.treatmentplancomment;
	}
	public static int getTreatmentplanCommentMaxLength()
	{
		return 255;
	}
	public void setTreatmentplanComment(String value)
	{
		this.isValidated = false;
		this.treatmentplancomment = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public Boolean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(Boolean value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getPrimaryTumourHistologyIsNotNull()
	{
		return this.primarytumourhistology != null;
	}
	public ims.clinicaladmin.vo.TumourHistologyLiteVo getPrimaryTumourHistology()
	{
		return this.primarytumourhistology;
	}
	public void setPrimaryTumourHistology(ims.clinicaladmin.vo.TumourHistologyLiteVo value)
	{
		this.isValidated = false;
		this.primarytumourhistology = value;
	}
	public boolean getEcad_dateIsNotNull()
	{
		return this.ecad_date != null;
	}
	public ims.framework.utils.Date getEcad_date()
	{
		return this.ecad_date;
	}
	public void setEcad_date(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.ecad_date = value;
	}
	public boolean getPrimaryTumourGroupIsNotNull()
	{
		return this.primarytumourgroup != null;
	}
	public ims.clinicaladmin.vo.TumourGroupLiteVo getPrimaryTumourGroup()
	{
		return this.primarytumourgroup;
	}
	public void setPrimaryTumourGroup(ims.clinicaladmin.vo.TumourGroupLiteVo value)
	{
		this.isValidated = false;
		this.primarytumourgroup = value;
	}
	public boolean getPrimaryTumourSiteIsNotNull()
	{
		return this.primarytumoursite != null;
	}
	public ims.clinicaladmin.vo.TumourSiteLiteVo getPrimaryTumourSite()
	{
		return this.primarytumoursite;
	}
	public void setPrimaryTumourSite(ims.clinicaladmin.vo.TumourSiteLiteVo value)
	{
		this.isValidated = false;
		this.primarytumoursite = value;
	}
	public boolean getTreatmentSitesIsNotNull()
	{
		return this.treatmentsites != null;
	}
	public ims.oncology.vo.lookups.TreatmentGroupSiteCollection getTreatmentSites()
	{
		return this.treatmentsites;
	}
	public void setTreatmentSites(ims.oncology.vo.lookups.TreatmentGroupSiteCollection value)
	{
		this.isValidated = false;
		this.treatmentsites = value;
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
		if(this.actions != null)
		{
			if(!this.actions.isValidated())
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
		if(this.actions != null)
		{
			String[] listOfOtherErrors = this.actions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.treatmentplancomment != null)
			if(this.treatmentplancomment.length() > 255)
				listOfErrors.add("The length of the field [treatmentplancomment] in the value object [ims.ccosched.vo.PatTreatmentPlanLiteVo] is too big. It should be less or equal to 255");
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
	
		PatTreatmentPlanLiteVo clone = new PatTreatmentPlanLiteVo(this.id, this.version);
		
		if(this.treatmentintent == null)
			clone.treatmentintent = null;
		else
			clone.treatmentintent = (ims.ccosched.vo.lookups.TreatmentIntent)this.treatmentintent.clone();
		if(this.dateseen == null)
			clone.dateseen = null;
		else
			clone.dateseen = (ims.framework.utils.Date)this.dateseen.clone();
		if(this.decisiontotreat == null)
			clone.decisiontotreat = null;
		else
			clone.decisiontotreat = (ims.framework.utils.Date)this.decisiontotreat.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.ccosched.vo.PatTreatPlanActionVoCollection)this.actions.clone();
		clone.patient = this.patient;
		clone.pkey = this.pkey;
		clone.rkey = this.rkey;
		clone.episode = this.episode;
		clone.treatmentplancomment = this.treatmentplancomment;
		clone.activestatus = this.activestatus;
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.primarytumourhistology == null)
			clone.primarytumourhistology = null;
		else
			clone.primarytumourhistology = (ims.clinicaladmin.vo.TumourHistologyLiteVo)this.primarytumourhistology.clone();
		if(this.ecad_date == null)
			clone.ecad_date = null;
		else
			clone.ecad_date = (ims.framework.utils.Date)this.ecad_date.clone();
		if(this.primarytumourgroup == null)
			clone.primarytumourgroup = null;
		else
			clone.primarytumourgroup = (ims.clinicaladmin.vo.TumourGroupLiteVo)this.primarytumourgroup.clone();
		if(this.primarytumoursite == null)
			clone.primarytumoursite = null;
		else
			clone.primarytumoursite = (ims.clinicaladmin.vo.TumourSiteLiteVo)this.primarytumoursite.clone();
		if(this.treatmentsites == null)
			clone.treatmentsites = null;
		else
			clone.treatmentsites = (ims.oncology.vo.lookups.TreatmentGroupSiteCollection)this.treatmentsites.clone();
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
		if (!(PatTreatmentPlanLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatTreatmentPlanLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatTreatmentPlanLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatTreatmentPlanLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentintent != null)
			count++;
		if(this.dateseen != null)
			count++;
		if(this.decisiontotreat != null)
			count++;
		if(this.actions != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.pkey != null)
			count++;
		if(this.rkey != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.treatmentplancomment != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.primarytumourhistology != null)
			count++;
		if(this.ecad_date != null)
			count++;
		if(this.primarytumourgroup != null)
			count++;
		if(this.primarytumoursite != null)
			count++;
		if(this.treatmentsites != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.ccosched.vo.lookups.TreatmentIntent treatmentintent;
	protected ims.framework.utils.Date dateseen;
	protected ims.framework.utils.Date decisiontotreat;
	protected ims.ccosched.vo.PatTreatPlanActionVoCollection actions;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected Integer pkey;
	protected Integer rkey;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected String treatmentplancomment;
	protected Boolean activestatus;
	protected ims.core.vo.HcpLiteVo consultant;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.clinicaladmin.vo.TumourHistologyLiteVo primarytumourhistology;
	protected ims.framework.utils.Date ecad_date;
	protected ims.clinicaladmin.vo.TumourGroupLiteVo primarytumourgroup;
	protected ims.clinicaladmin.vo.TumourSiteLiteVo primarytumoursite;
	protected ims.oncology.vo.lookups.TreatmentGroupSiteCollection treatmentsites;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
