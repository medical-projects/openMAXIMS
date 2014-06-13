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
 * Linked to therapies.treatment.FunctionalTransfersTechnique business object (ID: 1019100030).
 */
public class FunctionalTransfersTechniqueVo extends ims.therapies.treatment.vo.FunctionalTransfersTechniqueRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FunctionalTransfersTechniqueVo()
	{
	}
	public FunctionalTransfersTechniqueVo(Integer id, int version)
	{
		super(id, version);
	}
	public FunctionalTransfersTechniqueVo(ims.therapies.vo.beans.FunctionalTransfersTechniqueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startposition = bean.getStartPosition() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferPosition.buildLookup(bean.getStartPosition());
		this.startheight = bean.getStartHeight();
		this.starttarget = bean.getStartTarget();
		this.finishposition = bean.getFinishPosition() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferPosition.buildLookup(bean.getFinishPosition());
		this.finishheight = bean.getFinishHeight();
		this.finishtarget = bean.getFinishTarget();
		this.fimscore = bean.getFIMScore();
		this.risk = bean.getRisk() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferRisk.buildLookup(bean.getRisk());
		this.equipment = ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.technique = ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection.buildFromBeanCollection(bean.getTechnique());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.FunctionalTransfersTechniqueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startposition = bean.getStartPosition() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferPosition.buildLookup(bean.getStartPosition());
		this.startheight = bean.getStartHeight();
		this.starttarget = bean.getStartTarget();
		this.finishposition = bean.getFinishPosition() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferPosition.buildLookup(bean.getFinishPosition());
		this.finishheight = bean.getFinishHeight();
		this.finishtarget = bean.getFinishTarget();
		this.fimscore = bean.getFIMScore();
		this.risk = bean.getRisk() == null ? null : ims.spinalinjuries.vo.lookups.FunctionalTransferRisk.buildLookup(bean.getRisk());
		this.equipment = ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.technique = ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection.buildFromBeanCollection(bean.getTechnique());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.FunctionalTransfersTechniqueVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.FunctionalTransfersTechniqueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.FunctionalTransfersTechniqueVoBean();
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
		if(fieldName.equals("STARTPOSITION"))
			return getStartPosition();
		if(fieldName.equals("STARTHEIGHT"))
			return getStartHeight();
		if(fieldName.equals("STARTTARGET"))
			return getStartTarget();
		if(fieldName.equals("FINISHPOSITION"))
			return getFinishPosition();
		if(fieldName.equals("FINISHHEIGHT"))
			return getFinishHeight();
		if(fieldName.equals("FINISHTARGET"))
			return getFinishTarget();
		if(fieldName.equals("FIMSCORE"))
			return getFIMScore();
		if(fieldName.equals("RISK"))
			return getRisk();
		if(fieldName.equals("EQUIPMENT"))
			return getEquipment();
		if(fieldName.equals("TECHNIQUE"))
			return getTechnique();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartPositionIsNotNull()
	{
		return this.startposition != null;
	}
	public ims.spinalinjuries.vo.lookups.FunctionalTransferPosition getStartPosition()
	{
		return this.startposition;
	}
	public void setStartPosition(ims.spinalinjuries.vo.lookups.FunctionalTransferPosition value)
	{
		this.isValidated = false;
		this.startposition = value;
	}
	public boolean getStartHeightIsNotNull()
	{
		return this.startheight != null;
	}
	public Integer getStartHeight()
	{
		return this.startheight;
	}
	public void setStartHeight(Integer value)
	{
		this.isValidated = false;
		this.startheight = value;
	}
	public boolean getStartTargetIsNotNull()
	{
		return this.starttarget != null;
	}
	public Integer getStartTarget()
	{
		return this.starttarget;
	}
	public void setStartTarget(Integer value)
	{
		this.isValidated = false;
		this.starttarget = value;
	}
	public boolean getFinishPositionIsNotNull()
	{
		return this.finishposition != null;
	}
	public ims.spinalinjuries.vo.lookups.FunctionalTransferPosition getFinishPosition()
	{
		return this.finishposition;
	}
	public void setFinishPosition(ims.spinalinjuries.vo.lookups.FunctionalTransferPosition value)
	{
		this.isValidated = false;
		this.finishposition = value;
	}
	public boolean getFinishHeightIsNotNull()
	{
		return this.finishheight != null;
	}
	public Integer getFinishHeight()
	{
		return this.finishheight;
	}
	public void setFinishHeight(Integer value)
	{
		this.isValidated = false;
		this.finishheight = value;
	}
	public boolean getFinishTargetIsNotNull()
	{
		return this.finishtarget != null;
	}
	public Integer getFinishTarget()
	{
		return this.finishtarget;
	}
	public void setFinishTarget(Integer value)
	{
		this.isValidated = false;
		this.finishtarget = value;
	}
	public boolean getFIMScoreIsNotNull()
	{
		return this.fimscore != null;
	}
	public Integer getFIMScore()
	{
		return this.fimscore;
	}
	public void setFIMScore(Integer value)
	{
		this.isValidated = false;
		this.fimscore = value;
	}
	public boolean getRiskIsNotNull()
	{
		return this.risk != null;
	}
	public ims.spinalinjuries.vo.lookups.FunctionalTransferRisk getRisk()
	{
		return this.risk;
	}
	public void setRisk(ims.spinalinjuries.vo.lookups.FunctionalTransferRisk value)
	{
		this.isValidated = false;
		this.risk = value;
	}
	public boolean getEquipmentIsNotNull()
	{
		return this.equipment != null;
	}
	public ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection value)
	{
		this.isValidated = false;
		this.equipment = value;
	}
	public boolean getTechniqueIsNotNull()
	{
		return this.technique != null;
	}
	public ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection getTechnique()
	{
		return this.technique;
	}
	public void setTechnique(ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection value)
	{
		this.isValidated = false;
		this.technique = value;
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
		if(this.startposition == null)
			listOfErrors.add("Start Position is mandatory");
		if(this.finishposition == null)
			listOfErrors.add("Finish Position is mandatory");
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
	
		FunctionalTransfersTechniqueVo clone = new FunctionalTransfersTechniqueVo(this.id, this.version);
		
		if(this.startposition == null)
			clone.startposition = null;
		else
			clone.startposition = (ims.spinalinjuries.vo.lookups.FunctionalTransferPosition)this.startposition.clone();
		clone.startheight = this.startheight;
		clone.starttarget = this.starttarget;
		if(this.finishposition == null)
			clone.finishposition = null;
		else
			clone.finishposition = (ims.spinalinjuries.vo.lookups.FunctionalTransferPosition)this.finishposition.clone();
		clone.finishheight = this.finishheight;
		clone.finishtarget = this.finishtarget;
		clone.fimscore = this.fimscore;
		if(this.risk == null)
			clone.risk = null;
		else
			clone.risk = (ims.spinalinjuries.vo.lookups.FunctionalTransferRisk)this.risk.clone();
		if(this.equipment == null)
			clone.equipment = null;
		else
			clone.equipment = (ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection)this.equipment.clone();
		if(this.technique == null)
			clone.technique = null;
		else
			clone.technique = (ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection)this.technique.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(FunctionalTransfersTechniqueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FunctionalTransfersTechniqueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FunctionalTransfersTechniqueVo compareObj = (FunctionalTransfersTechniqueVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
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
		if(this.startposition != null)
			count++;
		if(this.startheight != null)
			count++;
		if(this.starttarget != null)
			count++;
		if(this.finishposition != null)
			count++;
		if(this.finishheight != null)
			count++;
		if(this.finishtarget != null)
			count++;
		if(this.fimscore != null)
			count++;
		if(this.risk != null)
			count++;
		if(this.equipment != null)
			count++;
		if(this.technique != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.spinalinjuries.vo.lookups.FunctionalTransferPosition startposition;
	protected Integer startheight;
	protected Integer starttarget;
	protected ims.spinalinjuries.vo.lookups.FunctionalTransferPosition finishposition;
	protected Integer finishheight;
	protected Integer finishtarget;
	protected Integer fimscore;
	protected ims.spinalinjuries.vo.lookups.FunctionalTransferRisk risk;
	protected ims.spinalinjuries.vo.lookups.FunctionalTransferEquipmentCollection equipment;
	protected ims.spinalinjuries.vo.lookups.FunctionalTransferTechniqueCollection technique;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
