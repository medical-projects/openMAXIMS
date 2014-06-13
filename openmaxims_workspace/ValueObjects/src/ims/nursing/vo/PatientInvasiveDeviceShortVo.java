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

package ims.nursing.vo;

/**
 * Linked to clinical.PatientInvasiveDevice business object (ID: 1072100043).
 */
public class PatientInvasiveDeviceShortVo extends ims.clinical.vo.PatientInvasiveDeviceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientInvasiveDeviceShortVo()
	{
	}
	public PatientInvasiveDeviceShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientInvasiveDeviceShortVo(ims.nursing.vo.beans.PatientInvasiveDeviceShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.invasivedevice = bean.getInvasiveDevice() == null ? null : bean.getInvasiveDevice().buildVo();
		this.inserteddatetime = bean.getInsertedDateTime() == null ? null : bean.getInsertedDateTime().buildDateTime();
		this.insertedhcp = bean.getInsertedHCP() == null ? null : bean.getInsertedHCP().buildVo();
		this.vipscore = ims.nursing.vo.PatientInvasiveDeviceVipVoCollection.buildFromBeanCollection(bean.getVIPScore());
		this.removaldatetime = bean.getRemovalDateTime() == null ? null : bean.getRemovalDateTime().buildDateTime();
		this.removalhcp = bean.getRemovalHCP() == null ? null : bean.getRemovalHCP().buildVo();
		this.targetremovaldatetime = bean.getTargetRemovalDateTime() == null ? null : bean.getTargetRemovalDateTime().buildDateTime();
		this.site = bean.getSite();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PatientInvasiveDeviceShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.invasivedevice = bean.getInvasiveDevice() == null ? null : bean.getInvasiveDevice().buildVo(map);
		this.inserteddatetime = bean.getInsertedDateTime() == null ? null : bean.getInsertedDateTime().buildDateTime();
		this.insertedhcp = bean.getInsertedHCP() == null ? null : bean.getInsertedHCP().buildVo(map);
		this.vipscore = ims.nursing.vo.PatientInvasiveDeviceVipVoCollection.buildFromBeanCollection(bean.getVIPScore());
		this.removaldatetime = bean.getRemovalDateTime() == null ? null : bean.getRemovalDateTime().buildDateTime();
		this.removalhcp = bean.getRemovalHCP() == null ? null : bean.getRemovalHCP().buildVo(map);
		this.targetremovaldatetime = bean.getTargetRemovalDateTime() == null ? null : bean.getTargetRemovalDateTime().buildDateTime();
		this.site = bean.getSite();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PatientInvasiveDeviceShortVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PatientInvasiveDeviceShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PatientInvasiveDeviceShortVoBean();
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
		if(fieldName.equals("INVASIVEDEVICE"))
			return getInvasiveDevice();
		if(fieldName.equals("INSERTEDDATETIME"))
			return getInsertedDateTime();
		if(fieldName.equals("INSERTEDHCP"))
			return getInsertedHCP();
		if(fieldName.equals("VIPSCORE"))
			return getVIPScore();
		if(fieldName.equals("REMOVALDATETIME"))
			return getRemovalDateTime();
		if(fieldName.equals("REMOVALHCP"))
			return getRemovalHCP();
		if(fieldName.equals("TARGETREMOVALDATETIME"))
			return getTargetRemovalDateTime();
		if(fieldName.equals("SITE"))
			return getSite();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvasiveDeviceIsNotNull()
	{
		return this.invasivedevice != null;
	}
	public ims.clinicaladmin.vo.InvasiveDeviceConfigShortVo getInvasiveDevice()
	{
		return this.invasivedevice;
	}
	public void setInvasiveDevice(ims.clinicaladmin.vo.InvasiveDeviceConfigShortVo value)
	{
		this.isValidated = false;
		this.invasivedevice = value;
	}
	public boolean getInsertedDateTimeIsNotNull()
	{
		return this.inserteddatetime != null;
	}
	public ims.framework.utils.DateTime getInsertedDateTime()
	{
		return this.inserteddatetime;
	}
	public void setInsertedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.inserteddatetime = value;
	}
	public boolean getInsertedHCPIsNotNull()
	{
		return this.insertedhcp != null;
	}
	public ims.core.vo.HcpLiteVo getInsertedHCP()
	{
		return this.insertedhcp;
	}
	public void setInsertedHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.insertedhcp = value;
	}
	public boolean getVIPScoreIsNotNull()
	{
		return this.vipscore != null;
	}
	public ims.nursing.vo.PatientInvasiveDeviceVipVoCollection getVIPScore()
	{
		return this.vipscore;
	}
	public void setVIPScore(ims.nursing.vo.PatientInvasiveDeviceVipVoCollection value)
	{
		this.isValidated = false;
		this.vipscore = value;
	}
	public boolean getRemovalDateTimeIsNotNull()
	{
		return this.removaldatetime != null;
	}
	public ims.framework.utils.DateTime getRemovalDateTime()
	{
		return this.removaldatetime;
	}
	public void setRemovalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.removaldatetime = value;
	}
	public boolean getRemovalHCPIsNotNull()
	{
		return this.removalhcp != null;
	}
	public ims.core.vo.HcpLiteVo getRemovalHCP()
	{
		return this.removalhcp;
	}
	public void setRemovalHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.removalhcp = value;
	}
	public boolean getTargetRemovalDateTimeIsNotNull()
	{
		return this.targetremovaldatetime != null;
	}
	public ims.framework.utils.DateTime getTargetRemovalDateTime()
	{
		return this.targetremovaldatetime;
	}
	public void setTargetRemovalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.targetremovaldatetime = value;
	}
	public boolean getSiteIsNotNull()
	{
		return this.site != null;
	}
	public String getSite()
	{
		return this.site;
	}
	public static int getSiteMaxLength()
	{
		return 50;
	}
	public void setSite(String value)
	{
		this.isValidated = false;
		this.site = value;
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
		if(this.insertedhcp != null)
		{
			if(!this.insertedhcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.vipscore != null)
		{
			if(!this.vipscore.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.removalhcp != null)
		{
			if(!this.removalhcp.isValidated())
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
		if(this.invasivedevice == null)
			listOfErrors.add("InvasiveDevice is mandatory");
		if(this.inserteddatetime == null)
			listOfErrors.add("InsertedDateTime is mandatory");
		if(this.insertedhcp == null)
			listOfErrors.add("InsertedHCP is mandatory");
		if(this.insertedhcp != null)
		{
			String[] listOfOtherErrors = this.insertedhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vipscore != null)
		{
			String[] listOfOtherErrors = this.vipscore.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.removalhcp != null)
		{
			String[] listOfOtherErrors = this.removalhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.targetremovaldatetime == null)
			listOfErrors.add("TargetRemovalDateTime is mandatory");
		if(this.site != null)
			if(this.site.length() > 50)
				listOfErrors.add("The length of the field [site] in the value object [ims.nursing.vo.PatientInvasiveDeviceShortVo] is too big. It should be less or equal to 50");
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
	
		PatientInvasiveDeviceShortVo clone = new PatientInvasiveDeviceShortVo(this.id, this.version);
		
		if(this.invasivedevice == null)
			clone.invasivedevice = null;
		else
			clone.invasivedevice = (ims.clinicaladmin.vo.InvasiveDeviceConfigShortVo)this.invasivedevice.clone();
		if(this.inserteddatetime == null)
			clone.inserteddatetime = null;
		else
			clone.inserteddatetime = (ims.framework.utils.DateTime)this.inserteddatetime.clone();
		if(this.insertedhcp == null)
			clone.insertedhcp = null;
		else
			clone.insertedhcp = (ims.core.vo.HcpLiteVo)this.insertedhcp.clone();
		if(this.vipscore == null)
			clone.vipscore = null;
		else
			clone.vipscore = (ims.nursing.vo.PatientInvasiveDeviceVipVoCollection)this.vipscore.clone();
		if(this.removaldatetime == null)
			clone.removaldatetime = null;
		else
			clone.removaldatetime = (ims.framework.utils.DateTime)this.removaldatetime.clone();
		if(this.removalhcp == null)
			clone.removalhcp = null;
		else
			clone.removalhcp = (ims.core.vo.HcpLiteVo)this.removalhcp.clone();
		if(this.targetremovaldatetime == null)
			clone.targetremovaldatetime = null;
		else
			clone.targetremovaldatetime = (ims.framework.utils.DateTime)this.targetremovaldatetime.clone();
		clone.site = this.site;
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
		if (!(PatientInvasiveDeviceShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientInvasiveDeviceShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientInvasiveDeviceShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientInvasiveDeviceShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.invasivedevice != null)
			count++;
		if(this.inserteddatetime != null)
			count++;
		if(this.insertedhcp != null)
			count++;
		if(this.vipscore != null)
			count++;
		if(this.removaldatetime != null)
			count++;
		if(this.removalhcp != null)
			count++;
		if(this.targetremovaldatetime != null)
			count++;
		if(this.site != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.clinicaladmin.vo.InvasiveDeviceConfigShortVo invasivedevice;
	protected ims.framework.utils.DateTime inserteddatetime;
	protected ims.core.vo.HcpLiteVo insertedhcp;
	protected ims.nursing.vo.PatientInvasiveDeviceVipVoCollection vipscore;
	protected ims.framework.utils.DateTime removaldatetime;
	protected ims.core.vo.HcpLiteVo removalhcp;
	protected ims.framework.utils.DateTime targetremovaldatetime;
	protected String site;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
