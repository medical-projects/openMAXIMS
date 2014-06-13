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

package ims.oncology.vo;

/**
 * Linked to Oncology.Imagingevents business object (ID: 1074100001).
 */
public class ImagingEventsVo extends ims.oncology.vo.ImagingeventsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ImagingEventsVo()
	{
	}
	public ImagingEventsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ImagingEventsVo(ims.oncology.vo.beans.ImagingEventsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.hospitalsiteofimage = bean.getHospitalSiteOfImage() == null ? null : bean.getHospitalSiteOfImage().buildVo();
		this.imagedate = bean.getImageDate() == null ? null : bean.getImageDate().buildDate();
		this.anatomicalsite = bean.getAnatomicalSite() == null ? null : ims.oncology.vo.lookups.ImageAnatomicalSite.buildLookup(bean.getAnatomicalSite());
		this.reportdate = bean.getReportDate() == null ? null : bean.getReportDate().buildDate();
		this.lesionsize = bean.getLesionSize();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.imagingevent = bean.getImagingEvent() == null ? null : bean.getImagingEvent().buildVo();
		this.imagingeventdescription = bean.getImagingEventDescription();
		this.requesteddate = bean.getRequestedDate() == null ? null : bean.getRequestedDate().buildDate();
		this.investigationresult = bean.getInvestigationResult() == null ? null : ims.oncology.vo.lookups.StagingInvestigationResult.buildLookup(bean.getInvestigationResult());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ImagingEventsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.hospitalsiteofimage = bean.getHospitalSiteOfImage() == null ? null : bean.getHospitalSiteOfImage().buildVo(map);
		this.imagedate = bean.getImageDate() == null ? null : bean.getImageDate().buildDate();
		this.anatomicalsite = bean.getAnatomicalSite() == null ? null : ims.oncology.vo.lookups.ImageAnatomicalSite.buildLookup(bean.getAnatomicalSite());
		this.reportdate = bean.getReportDate() == null ? null : bean.getReportDate().buildDate();
		this.lesionsize = bean.getLesionSize();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.imagingevent = bean.getImagingEvent() == null ? null : bean.getImagingEvent().buildVo(map);
		this.imagingeventdescription = bean.getImagingEventDescription();
		this.requesteddate = bean.getRequestedDate() == null ? null : bean.getRequestedDate().buildDate();
		this.investigationresult = bean.getInvestigationResult() == null ? null : ims.oncology.vo.lookups.StagingInvestigationResult.buildLookup(bean.getInvestigationResult());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ImagingEventsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ImagingEventsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ImagingEventsVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("HOSPITALSITEOFIMAGE"))
			return getHospitalSiteOfImage();
		if(fieldName.equals("IMAGEDATE"))
			return getImageDate();
		if(fieldName.equals("ANATOMICALSITE"))
			return getAnatomicalSite();
		if(fieldName.equals("REPORTDATE"))
			return getReportDate();
		if(fieldName.equals("LESIONSIZE"))
			return getLesionSize();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("IMAGINGEVENT"))
			return getImagingEvent();
		if(fieldName.equals("IMAGINGEVENTDESCRIPTION"))
			return getImagingEventDescription();
		if(fieldName.equals("REQUESTEDDATE"))
			return getRequestedDate();
		if(fieldName.equals("INVESTIGATIONRESULT"))
			return getInvestigationResult();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextLiteVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextLiteVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getHospitalSiteOfImageIsNotNull()
	{
		return this.hospitalsiteofimage != null;
	}
	public ims.core.vo.LocSiteLiteVo getHospitalSiteOfImage()
	{
		return this.hospitalsiteofimage;
	}
	public void setHospitalSiteOfImage(ims.core.vo.LocSiteLiteVo value)
	{
		this.isValidated = false;
		this.hospitalsiteofimage = value;
	}
	public boolean getImageDateIsNotNull()
	{
		return this.imagedate != null;
	}
	public ims.framework.utils.Date getImageDate()
	{
		return this.imagedate;
	}
	public void setImageDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.imagedate = value;
	}
	public boolean getAnatomicalSiteIsNotNull()
	{
		return this.anatomicalsite != null;
	}
	public ims.oncology.vo.lookups.ImageAnatomicalSite getAnatomicalSite()
	{
		return this.anatomicalsite;
	}
	public void setAnatomicalSite(ims.oncology.vo.lookups.ImageAnatomicalSite value)
	{
		this.isValidated = false;
		this.anatomicalsite = value;
	}
	public boolean getReportDateIsNotNull()
	{
		return this.reportdate != null;
	}
	public ims.framework.utils.Date getReportDate()
	{
		return this.reportdate;
	}
	public void setReportDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.reportdate = value;
	}
	public boolean getLesionSizeIsNotNull()
	{
		return this.lesionsize != null;
	}
	public Integer getLesionSize()
	{
		return this.lesionsize;
	}
	public void setLesionSize(Integer value)
	{
		this.isValidated = false;
		this.lesionsize = value;
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
	public boolean getImagingEventIsNotNull()
	{
		return this.imagingevent != null;
	}
	public ims.core.vo.CancerImagingEventLiteVo getImagingEvent()
	{
		return this.imagingevent;
	}
	public void setImagingEvent(ims.core.vo.CancerImagingEventLiteVo value)
	{
		this.isValidated = false;
		this.imagingevent = value;
	}
	public boolean getImagingEventDescriptionIsNotNull()
	{
		return this.imagingeventdescription != null;
	}
	public String getImagingEventDescription()
	{
		return this.imagingeventdescription;
	}
	public static int getImagingEventDescriptionMaxLength()
	{
		return 100;
	}
	public void setImagingEventDescription(String value)
	{
		this.isValidated = false;
		this.imagingeventdescription = value;
	}
	public boolean getRequestedDateIsNotNull()
	{
		return this.requesteddate != null;
	}
	public ims.framework.utils.Date getRequestedDate()
	{
		return this.requesteddate;
	}
	public void setRequestedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.requesteddate = value;
	}
	public boolean getInvestigationResultIsNotNull()
	{
		return this.investigationresult != null;
	}
	public ims.oncology.vo.lookups.StagingInvestigationResult getInvestigationResult()
	{
		return this.investigationresult;
	}
	public void setInvestigationResult(ims.oncology.vo.lookups.StagingInvestigationResult value)
	{
		this.isValidated = false;
		this.investigationresult = value;
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
		if(this.hospitalsiteofimage != null)
		{
			if(!this.hospitalsiteofimage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.imagingevent != null)
		{
			if(!this.imagingevent.isValidated())
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
		if(this.hospitalsiteofimage == null)
			listOfErrors.add("HospitalSiteOfImage is mandatory");
		if(this.hospitalsiteofimage != null)
		{
			String[] listOfOtherErrors = this.hospitalsiteofimage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.imagingevent != null)
		{
			String[] listOfOtherErrors = this.imagingevent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.imagingeventdescription == null || this.imagingeventdescription.length() == 0)
			listOfErrors.add("ImagingEventDescription is mandatory");
		else if(this.imagingeventdescription.length() > 100)
			listOfErrors.add("The length of the field [imagingeventdescription] in the value object [ims.oncology.vo.ImagingEventsVo] is too big. It should be less or equal to 100");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
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
	
		ImagingEventsVo clone = new ImagingEventsVo(this.id, this.version);
		
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextLiteVo)this.carecontext.clone();
		if(this.hospitalsiteofimage == null)
			clone.hospitalsiteofimage = null;
		else
			clone.hospitalsiteofimage = (ims.core.vo.LocSiteLiteVo)this.hospitalsiteofimage.clone();
		if(this.imagedate == null)
			clone.imagedate = null;
		else
			clone.imagedate = (ims.framework.utils.Date)this.imagedate.clone();
		if(this.anatomicalsite == null)
			clone.anatomicalsite = null;
		else
			clone.anatomicalsite = (ims.oncology.vo.lookups.ImageAnatomicalSite)this.anatomicalsite.clone();
		if(this.reportdate == null)
			clone.reportdate = null;
		else
			clone.reportdate = (ims.framework.utils.Date)this.reportdate.clone();
		clone.lesionsize = this.lesionsize;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.imagingevent == null)
			clone.imagingevent = null;
		else
			clone.imagingevent = (ims.core.vo.CancerImagingEventLiteVo)this.imagingevent.clone();
		clone.imagingeventdescription = this.imagingeventdescription;
		if(this.requesteddate == null)
			clone.requesteddate = null;
		else
			clone.requesteddate = (ims.framework.utils.Date)this.requesteddate.clone();
		if(this.investigationresult == null)
			clone.investigationresult = null;
		else
			clone.investigationresult = (ims.oncology.vo.lookups.StagingInvestigationResult)this.investigationresult.clone();
		clone.episodeofcare = this.episodeofcare;
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
		if (!(ImagingEventsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ImagingEventsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ImagingEventsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ImagingEventsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.hospitalsiteofimage != null)
			count++;
		if(this.imagedate != null)
			count++;
		if(this.anatomicalsite != null)
			count++;
		if(this.reportdate != null)
			count++;
		if(this.lesionsize != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.imagingevent != null)
			count++;
		if(this.imagingeventdescription != null)
			count++;
		if(this.requesteddate != null)
			count++;
		if(this.investigationresult != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.core.vo.CareContextLiteVo carecontext;
	protected ims.core.vo.LocSiteLiteVo hospitalsiteofimage;
	protected ims.framework.utils.Date imagedate;
	protected ims.oncology.vo.lookups.ImageAnatomicalSite anatomicalsite;
	protected ims.framework.utils.Date reportdate;
	protected Integer lesionsize;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.CancerImagingEventLiteVo imagingevent;
	protected String imagingeventdescription;
	protected ims.framework.utils.Date requesteddate;
	protected ims.oncology.vo.lookups.StagingInvestigationResult investigationresult;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
