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


public class ReferralBookingVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralBookingVo()
	{
	}
	public ReferralBookingVo(ims.careuk.vo.beans.ReferralBookingVoBean bean)
	{
		this.referralletterdetail = bean.getReferralLetterDetail() == null ? null : bean.getReferralLetterDetail().buildVo();
		this.currentappointments = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getCurrentAppointments());
		this.appointmentsrequiringrebook = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getAppointmentsRequiringRebook());
		this.ordersrequiringappt = ims.ocrr.vo.OrderInvestigationBookingVoCollection.buildFromBeanCollection(bean.getOrdersRequiringAppt());
		this.triagedatetime = bean.getTriageDateTime() == null ? null : bean.getTriageDateTime().buildDateTime();
		this.otherappointments = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getOtherAppointments());
		this.isfitforsurgery = bean.getIsFitForSurgery();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.referralerod = bean.getReferralEROD() == null ? null : bean.getReferralEROD().buildVo();
		this.currentclock = bean.getCurrentClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getCurrentClock().getId()), bean.getCurrentClock().getVersion());
		this.iscab = bean.getIsCAB();
		this.referralcategory = bean.getReferralCategory() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getReferralCategory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralBookingVoBean bean)
	{
		this.referralletterdetail = bean.getReferralLetterDetail() == null ? null : bean.getReferralLetterDetail().buildVo(map);
		this.currentappointments = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getCurrentAppointments());
		this.appointmentsrequiringrebook = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getAppointmentsRequiringRebook());
		this.ordersrequiringappt = ims.ocrr.vo.OrderInvestigationBookingVoCollection.buildFromBeanCollection(bean.getOrdersRequiringAppt());
		this.triagedatetime = bean.getTriageDateTime() == null ? null : bean.getTriageDateTime().buildDateTime();
		this.otherappointments = ims.scheduling.vo.BookingAppointmentLiteVoCollection.buildFromBeanCollection(bean.getOtherAppointments());
		this.isfitforsurgery = bean.getIsFitForSurgery();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.referralerod = bean.getReferralEROD() == null ? null : bean.getReferralEROD().buildVo(map);
		this.currentclock = bean.getCurrentClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getCurrentClock().getId()), bean.getCurrentClock().getVersion());
		this.iscab = bean.getIsCAB();
		this.referralcategory = bean.getReferralCategory() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getReferralCategory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralBookingVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralBookingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralBookingVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getReferralLetterDetailIsNotNull()
	{
		return this.referralletterdetail != null;
	}
	public ims.careuk.vo.ReferralLetterDetailsBookingVo getReferralLetterDetail()
	{
		return this.referralletterdetail;
	}
	public void setReferralLetterDetail(ims.careuk.vo.ReferralLetterDetailsBookingVo value)
	{
		this.isValidated = false;
		this.referralletterdetail = value;
	}
	public boolean getCurrentAppointmentsIsNotNull()
	{
		return this.currentappointments != null;
	}
	public ims.scheduling.vo.BookingAppointmentLiteVoCollection getCurrentAppointments()
	{
		return this.currentappointments;
	}
	public void setCurrentAppointments(ims.scheduling.vo.BookingAppointmentLiteVoCollection value)
	{
		this.isValidated = false;
		this.currentappointments = value;
	}
	public boolean getAppointmentsRequiringRebookIsNotNull()
	{
		return this.appointmentsrequiringrebook != null;
	}
	public ims.scheduling.vo.BookingAppointmentLiteVoCollection getAppointmentsRequiringRebook()
	{
		return this.appointmentsrequiringrebook;
	}
	public void setAppointmentsRequiringRebook(ims.scheduling.vo.BookingAppointmentLiteVoCollection value)
	{
		this.isValidated = false;
		this.appointmentsrequiringrebook = value;
	}
	public boolean getOrdersRequiringApptIsNotNull()
	{
		return this.ordersrequiringappt != null;
	}
	public ims.ocrr.vo.OrderInvestigationBookingVoCollection getOrdersRequiringAppt()
	{
		return this.ordersrequiringappt;
	}
	public void setOrdersRequiringAppt(ims.ocrr.vo.OrderInvestigationBookingVoCollection value)
	{
		this.isValidated = false;
		this.ordersrequiringappt = value;
	}
	public boolean getTriageDateTimeIsNotNull()
	{
		return this.triagedatetime != null;
	}
	public ims.framework.utils.DateTime getTriageDateTime()
	{
		return this.triagedatetime;
	}
	public void setTriageDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.triagedatetime = value;
	}
	public boolean getOtherAppointmentsIsNotNull()
	{
		return this.otherappointments != null;
	}
	public ims.scheduling.vo.BookingAppointmentLiteVoCollection getOtherAppointments()
	{
		return this.otherappointments;
	}
	public void setOtherAppointments(ims.scheduling.vo.BookingAppointmentLiteVoCollection value)
	{
		this.isValidated = false;
		this.otherappointments = value;
	}
	public boolean getIsFitForSurgeryIsNotNull()
	{
		return this.isfitforsurgery != null;
	}
	public Boolean getIsFitForSurgery()
	{
		return this.isfitforsurgery;
	}
	public void setIsFitForSurgery(Boolean value)
	{
		this.isValidated = false;
		this.isfitforsurgery = value;
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
	public boolean getReferralERODIsNotNull()
	{
		return this.referralerod != null;
	}
	public ims.careuk.vo.ReferralERODVo getReferralEROD()
	{
		return this.referralerod;
	}
	public void setReferralEROD(ims.careuk.vo.ReferralERODVo value)
	{
		this.isValidated = false;
		this.referralerod = value;
	}
	public boolean getCurrentClockIsNotNull()
	{
		return this.currentclock != null;
	}
	public ims.pathways.vo.PathwayClockRefVo getCurrentClock()
	{
		return this.currentclock;
	}
	public void setCurrentClock(ims.pathways.vo.PathwayClockRefVo value)
	{
		this.isValidated = false;
		this.currentclock = value;
	}
	public boolean getIsCABIsNotNull()
	{
		return this.iscab != null;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.isValidated = false;
		this.iscab = value;
	}
	public boolean getReferralCategoryIsNotNull()
	{
		return this.referralcategory != null;
	}
	public ims.careuk.vo.lookups.CatsReferralCategory getReferralCategory()
	{
		return this.referralcategory;
	}
	public void setReferralCategory(ims.careuk.vo.lookups.CatsReferralCategory value)
	{
		this.isValidated = false;
		this.referralcategory = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ReferralBookingVo))
			return false;
		ReferralBookingVo compareObj = (ReferralBookingVo)obj;
		if(this.getReferralLetterDetail() == null && compareObj.getReferralLetterDetail() != null)
			return false;
		if(this.getReferralLetterDetail() != null && compareObj.getReferralLetterDetail() == null)
			return false;
		if(this.getReferralLetterDetail() != null && compareObj.getReferralLetterDetail() != null)
			return this.getReferralLetterDetail().equals(compareObj.getReferralLetterDetail());
		return super.equals(obj);
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
		if(this.referralletterdetail != null)
		{
			if(!this.referralletterdetail.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentappointments != null)
		{
			if(!this.currentappointments.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.appointmentsrequiringrebook != null)
		{
			if(!this.appointmentsrequiringrebook.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordersrequiringappt != null)
		{
			if(!this.ordersrequiringappt.isValidated())
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
		if(this.referralletterdetail != null)
		{
			String[] listOfOtherErrors = this.referralletterdetail.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentappointments != null)
		{
			String[] listOfOtherErrors = this.currentappointments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.appointmentsrequiringrebook != null)
		{
			String[] listOfOtherErrors = this.appointmentsrequiringrebook.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordersrequiringappt != null)
		{
			String[] listOfOtherErrors = this.ordersrequiringappt.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ReferralBookingVo clone = new ReferralBookingVo();
		
		if(this.referralletterdetail == null)
			clone.referralletterdetail = null;
		else
			clone.referralletterdetail = (ims.careuk.vo.ReferralLetterDetailsBookingVo)this.referralletterdetail.clone();
		if(this.currentappointments == null)
			clone.currentappointments = null;
		else
			clone.currentappointments = (ims.scheduling.vo.BookingAppointmentLiteVoCollection)this.currentappointments.clone();
		if(this.appointmentsrequiringrebook == null)
			clone.appointmentsrequiringrebook = null;
		else
			clone.appointmentsrequiringrebook = (ims.scheduling.vo.BookingAppointmentLiteVoCollection)this.appointmentsrequiringrebook.clone();
		if(this.ordersrequiringappt == null)
			clone.ordersrequiringappt = null;
		else
			clone.ordersrequiringappt = (ims.ocrr.vo.OrderInvestigationBookingVoCollection)this.ordersrequiringappt.clone();
		if(this.triagedatetime == null)
			clone.triagedatetime = null;
		else
			clone.triagedatetime = (ims.framework.utils.DateTime)this.triagedatetime.clone();
		if(this.otherappointments == null)
			clone.otherappointments = null;
		else
			clone.otherappointments = (ims.scheduling.vo.BookingAppointmentLiteVoCollection)this.otherappointments.clone();
		clone.isfitforsurgery = this.isfitforsurgery;
		clone.carecontext = this.carecontext;
		if(this.referralerod == null)
			clone.referralerod = null;
		else
			clone.referralerod = (ims.careuk.vo.ReferralERODVo)this.referralerod.clone();
		clone.currentclock = this.currentclock;
		clone.iscab = this.iscab;
		if(this.referralcategory == null)
			clone.referralcategory = null;
		else
			clone.referralcategory = (ims.careuk.vo.lookups.CatsReferralCategory)this.referralcategory.clone();
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
		if (!(ReferralBookingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralBookingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReferralBookingVo compareObj = (ReferralBookingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReferralLetterDetail() == null && compareObj.getReferralLetterDetail() != null)
				return -1;
			if(this.getReferralLetterDetail() != null && compareObj.getReferralLetterDetail() == null)
				return 1;
			if(this.getReferralLetterDetail() != null && compareObj.getReferralLetterDetail() != null)
				retVal = this.getReferralLetterDetail().compareTo(compareObj.getReferralLetterDetail());
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
		if(this.referralletterdetail != null)
			count++;
		if(this.currentappointments != null)
			count++;
		if(this.appointmentsrequiringrebook != null)
			count++;
		if(this.ordersrequiringappt != null)
			count++;
		if(this.triagedatetime != null)
			count++;
		if(this.otherappointments != null)
			count++;
		if(this.isfitforsurgery != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.referralerod != null)
			count++;
		if(this.currentclock != null)
			count++;
		if(this.iscab != null)
			count++;
		if(this.referralcategory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.careuk.vo.ReferralLetterDetailsBookingVo referralletterdetail;
	protected ims.scheduling.vo.BookingAppointmentLiteVoCollection currentappointments;
	protected ims.scheduling.vo.BookingAppointmentLiteVoCollection appointmentsrequiringrebook;
	protected ims.ocrr.vo.OrderInvestigationBookingVoCollection ordersrequiringappt;
	protected ims.framework.utils.DateTime triagedatetime;
	protected ims.scheduling.vo.BookingAppointmentLiteVoCollection otherappointments;
	protected Boolean isfitforsurgery;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.careuk.vo.ReferralERODVo referralerod;
	protected ims.pathways.vo.PathwayClockRefVo currentclock;
	protected Boolean iscab;
	protected ims.careuk.vo.lookups.CatsReferralCategory referralcategory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
