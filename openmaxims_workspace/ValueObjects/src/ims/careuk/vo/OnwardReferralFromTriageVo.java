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
 * Linked to CAREUK.OnwardReferralFromTriage business object (ID: 1096100055).
 */
public class OnwardReferralFromTriageVo extends ims.careuk.vo.OnwardReferralFromTriageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OnwardReferralFromTriageVo()
	{
	}
	public OnwardReferralFromTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public OnwardReferralFromTriageVo(ims.careuk.vo.beans.OnwardReferralFromTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.referreddate = bean.getReferredDate() == null ? null : bean.getReferredDate().buildDateTime();
		this.secondarycareprovider = bean.getSecondaryCareProvider() == null ? null : bean.getSecondaryCareProvider().buildVo();
		this.requestedbygp = bean.getRequestedByGP() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRequestedByGP());
		this.agreewithdecision = bean.getAgreeWithDecision() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAgreeWithDecision());
		this.notes = bean.getNotes();
		this.servicereferredinto = bean.getServiceReferredInto() == null ? null : ims.careuk.vo.lookups.ServiceReferredInto.buildLookup(bean.getServiceReferredInto());
		this.referralcomplete = bean.getReferralComplete() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getReferralComplete());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.OnwardReferralFromTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.referreddate = bean.getReferredDate() == null ? null : bean.getReferredDate().buildDateTime();
		this.secondarycareprovider = bean.getSecondaryCareProvider() == null ? null : bean.getSecondaryCareProvider().buildVo(map);
		this.requestedbygp = bean.getRequestedByGP() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getRequestedByGP());
		this.agreewithdecision = bean.getAgreeWithDecision() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAgreeWithDecision());
		this.notes = bean.getNotes();
		this.servicereferredinto = bean.getServiceReferredInto() == null ? null : ims.careuk.vo.lookups.ServiceReferredInto.buildLookup(bean.getServiceReferredInto());
		this.referralcomplete = bean.getReferralComplete() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getReferralComplete());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.OnwardReferralFromTriageVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.OnwardReferralFromTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.OnwardReferralFromTriageVoBean();
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
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("REFERREDDATE"))
			return getReferredDate();
		if(fieldName.equals("SECONDARYCAREPROVIDER"))
			return getSecondaryCareProvider();
		if(fieldName.equals("REQUESTEDBYGP"))
			return getRequestedByGP();
		if(fieldName.equals("AGREEWITHDECISION"))
			return getAgreeWithDecision();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("SERVICEREFERREDINTO"))
			return getServiceReferredInto();
		if(fieldName.equals("REFERRALCOMPLETE"))
			return getReferralComplete();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getReferredDateIsNotNull()
	{
		return this.referreddate != null;
	}
	public ims.framework.utils.DateTime getReferredDate()
	{
		return this.referreddate;
	}
	public void setReferredDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.referreddate = value;
	}
	public boolean getSecondaryCareProviderIsNotNull()
	{
		return this.secondarycareprovider != null;
	}
	public ims.core.vo.OrgLiteVo getSecondaryCareProvider()
	{
		return this.secondarycareprovider;
	}
	public void setSecondaryCareProvider(ims.core.vo.OrgLiteVo value)
	{
		this.isValidated = false;
		this.secondarycareprovider = value;
	}
	public boolean getRequestedByGPIsNotNull()
	{
		return this.requestedbygp != null;
	}
	public ims.core.vo.lookups.YesNo getRequestedByGP()
	{
		return this.requestedbygp;
	}
	public void setRequestedByGP(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.requestedbygp = value;
	}
	public boolean getAgreeWithDecisionIsNotNull()
	{
		return this.agreewithdecision != null;
	}
	public ims.core.vo.lookups.YesNo getAgreeWithDecision()
	{
		return this.agreewithdecision;
	}
	public void setAgreeWithDecision(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.agreewithdecision = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 2000;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
	}
	public boolean getServiceReferredIntoIsNotNull()
	{
		return this.servicereferredinto != null;
	}
	public ims.careuk.vo.lookups.ServiceReferredInto getServiceReferredInto()
	{
		return this.servicereferredinto;
	}
	public void setServiceReferredInto(ims.careuk.vo.lookups.ServiceReferredInto value)
	{
		this.isValidated = false;
		this.servicereferredinto = value;
	}
	public boolean getReferralCompleteIsNotNull()
	{
		return this.referralcomplete != null;
	}
	public ims.core.vo.lookups.YesNo getReferralComplete()
	{
		return this.referralcomplete;
	}
	public void setReferralComplete(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.referralcomplete = value;
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.requestedbygp == null)
			listOfErrors.add("RequestedByGP is mandatory");
		if(this.agreewithdecision == null)
			listOfErrors.add("AgreeWithDecision is mandatory");
		if(this.notes != null)
			if(this.notes.length() > 2000)
				listOfErrors.add("The length of the field [notes] in the value object [ims.careuk.vo.OnwardReferralFromTriageVo] is too big. It should be less or equal to 2000");
		if(this.servicereferredinto == null)
			listOfErrors.add("ServiceReferredInto is mandatory");
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
	
		OnwardReferralFromTriageVo clone = new OnwardReferralFromTriageVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.referreddate == null)
			clone.referreddate = null;
		else
			clone.referreddate = (ims.framework.utils.DateTime)this.referreddate.clone();
		if(this.secondarycareprovider == null)
			clone.secondarycareprovider = null;
		else
			clone.secondarycareprovider = (ims.core.vo.OrgLiteVo)this.secondarycareprovider.clone();
		if(this.requestedbygp == null)
			clone.requestedbygp = null;
		else
			clone.requestedbygp = (ims.core.vo.lookups.YesNo)this.requestedbygp.clone();
		if(this.agreewithdecision == null)
			clone.agreewithdecision = null;
		else
			clone.agreewithdecision = (ims.core.vo.lookups.YesNo)this.agreewithdecision.clone();
		clone.notes = this.notes;
		if(this.servicereferredinto == null)
			clone.servicereferredinto = null;
		else
			clone.servicereferredinto = (ims.careuk.vo.lookups.ServiceReferredInto)this.servicereferredinto.clone();
		if(this.referralcomplete == null)
			clone.referralcomplete = null;
		else
			clone.referralcomplete = (ims.core.vo.lookups.YesNo)this.referralcomplete.clone();
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
		if (!(OnwardReferralFromTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OnwardReferralFromTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OnwardReferralFromTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OnwardReferralFromTriageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.catsreferral != null)
			count++;
		if(this.referreddate != null)
			count++;
		if(this.secondarycareprovider != null)
			count++;
		if(this.requestedbygp != null)
			count++;
		if(this.agreewithdecision != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.servicereferredinto != null)
			count++;
		if(this.referralcomplete != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.careuk.vo.CatsReferralRefVo catsreferral;
	protected ims.framework.utils.DateTime referreddate;
	protected ims.core.vo.OrgLiteVo secondarycareprovider;
	protected ims.core.vo.lookups.YesNo requestedbygp;
	protected ims.core.vo.lookups.YesNo agreewithdecision;
	protected String notes;
	protected ims.careuk.vo.lookups.ServiceReferredInto servicereferredinto;
	protected ims.core.vo.lookups.YesNo referralcomplete;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
