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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderSpecimen business object (ID: 1070100010).
 */
public class OrderSpecimenListVo extends ims.ocrr.orderingresults.vo.OrderSpecimenRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderSpecimenListVo()
	{
	}
	public OrderSpecimenListVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderSpecimenListVo(ims.ocrr.vo.beans.OrderSpecimenListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.colldatetimeplacer = bean.getCollDateTimePlacer() == null ? null : bean.getCollDateTimePlacer().buildDateTime();
		this.collectingmos = bean.getCollectingMos() == null ? null : bean.getCollectingMos().buildVo();
		this.collectorcomment = bean.getCollectorComment();
		this.isawaitingcollection = bean.getIsAwaitingCollection();
		this.discipline = bean.getDiscipline() == null ? null : bean.getDiscipline().buildVo();
		this.investigations = ims.ocrr.vo.OrderInvestigationListVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.order = bean.getOrder() == null ? null : bean.getOrder().buildVo();
		this.containers = ims.ocrr.vo.OrderSpecimenContainerListVoCollection.buildFromBeanCollection(bean.getContainers());
		this.instructionstocollector = bean.getInstructionsToCollector();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.specimencollectionstatus = ims.ocrr.vo.SpecimenCollectionStatusVoCollection.buildFromBeanCollection(bean.getSpecimenCollectionStatus());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.OrderSpecimenListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.colldatetimeplacer = bean.getCollDateTimePlacer() == null ? null : bean.getCollDateTimePlacer().buildDateTime();
		this.collectingmos = bean.getCollectingMos() == null ? null : bean.getCollectingMos().buildVo(map);
		this.collectorcomment = bean.getCollectorComment();
		this.isawaitingcollection = bean.getIsAwaitingCollection();
		this.discipline = bean.getDiscipline() == null ? null : bean.getDiscipline().buildVo(map);
		this.investigations = ims.ocrr.vo.OrderInvestigationListVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.order = bean.getOrder() == null ? null : bean.getOrder().buildVo(map);
		this.containers = ims.ocrr.vo.OrderSpecimenContainerListVoCollection.buildFromBeanCollection(bean.getContainers());
		this.instructionstocollector = bean.getInstructionsToCollector();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.specimencollectionstatus = ims.ocrr.vo.SpecimenCollectionStatusVoCollection.buildFromBeanCollection(bean.getSpecimenCollectionStatus());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.OrderSpecimenListVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.OrderSpecimenListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.OrderSpecimenListVoBean();
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
		if(fieldName.equals("COLLDATETIMEPLACER"))
			return getCollDateTimePlacer();
		if(fieldName.equals("COLLECTINGMOS"))
			return getCollectingMos();
		if(fieldName.equals("COLLECTORCOMMENT"))
			return getCollectorComment();
		if(fieldName.equals("ISAWAITINGCOLLECTION"))
			return getIsAwaitingCollection();
		if(fieldName.equals("DISCIPLINE"))
			return getDiscipline();
		if(fieldName.equals("INVESTIGATIONS"))
			return getInvestigations();
		if(fieldName.equals("ORDER"))
			return getOrder();
		if(fieldName.equals("CONTAINERS"))
			return getContainers();
		if(fieldName.equals("INSTRUCTIONSTOCOLLECTOR"))
			return getInstructionsToCollector();
		if(fieldName.equals("SPECIMENSOURCE"))
			return getSpecimenSource();
		if(fieldName.equals("SITECD"))
			return getSiteCd();
		if(fieldName.equals("SPECIMENCOLLECTIONSTATUS"))
			return getSpecimenCollectionStatus();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("PLACERORDNUM"))
			return getPlacerOrdNum();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCollDateTimePlacerIsNotNull()
	{
		return this.colldatetimeplacer != null;
	}
	public ims.framework.utils.DateTime getCollDateTimePlacer()
	{
		return this.colldatetimeplacer;
	}
	public void setCollDateTimePlacer(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.colldatetimeplacer = value;
	}
	public boolean getCollectingMosIsNotNull()
	{
		return this.collectingmos != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getCollectingMos()
	{
		return this.collectingmos;
	}
	public void setCollectingMos(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.collectingmos = value;
	}
	public boolean getCollectorCommentIsNotNull()
	{
		return this.collectorcomment != null;
	}
	public String getCollectorComment()
	{
		return this.collectorcomment;
	}
	public static int getCollectorCommentMaxLength()
	{
		return 500;
	}
	public void setCollectorComment(String value)
	{
		this.isValidated = false;
		this.collectorcomment = value;
	}
	public boolean getIsAwaitingCollectionIsNotNull()
	{
		return this.isawaitingcollection != null;
	}
	public Boolean getIsAwaitingCollection()
	{
		return this.isawaitingcollection;
	}
	public void setIsAwaitingCollection(Boolean value)
	{
		this.isValidated = false;
		this.isawaitingcollection = value;
	}
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.ServiceLiteVo getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getInvestigationsIsNotNull()
	{
		return this.investigations != null;
	}
	public ims.ocrr.vo.OrderInvestigationListVoCollection getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.OrderInvestigationListVoCollection value)
	{
		this.isValidated = false;
		this.investigations = value;
	}
	public boolean getOrderIsNotNull()
	{
		return this.order != null;
	}
	public ims.ocrr.vo.OcsOrderListVo getOrder()
	{
		return this.order;
	}
	public void setOrder(ims.ocrr.vo.OcsOrderListVo value)
	{
		this.isValidated = false;
		this.order = value;
	}
	public boolean getContainersIsNotNull()
	{
		return this.containers != null;
	}
	public ims.ocrr.vo.OrderSpecimenContainerListVoCollection getContainers()
	{
		return this.containers;
	}
	public void setContainers(ims.ocrr.vo.OrderSpecimenContainerListVoCollection value)
	{
		this.isValidated = false;
		this.containers = value;
	}
	public boolean getInstructionsToCollectorIsNotNull()
	{
		return this.instructionstocollector != null;
	}
	public String getInstructionsToCollector()
	{
		return this.instructionstocollector;
	}
	public static int getInstructionsToCollectorMaxLength()
	{
		return 10000;
	}
	public void setInstructionsToCollector(String value)
	{
		this.isValidated = false;
		this.instructionstocollector = value;
	}
	public boolean getSpecimenSourceIsNotNull()
	{
		return this.specimensource != null;
	}
	public ims.ocrr.vo.lookups.SpecimenType getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.ocrr.vo.lookups.SpecimenType value)
	{
		this.isValidated = false;
		this.specimensource = value;
	}
	public boolean getSiteCdIsNotNull()
	{
		return this.sitecd != null;
	}
	public ims.ocrr.vo.lookups.SpecimenSite getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.ocrr.vo.lookups.SpecimenSite value)
	{
		this.isValidated = false;
		this.sitecd = value;
	}
	public boolean getSpecimenCollectionStatusIsNotNull()
	{
		return this.specimencollectionstatus != null;
	}
	public ims.ocrr.vo.SpecimenCollectionStatusVoCollection getSpecimenCollectionStatus()
	{
		return this.specimencollectionstatus;
	}
	public void setSpecimenCollectionStatus(ims.ocrr.vo.SpecimenCollectionStatusVoCollection value)
	{
		this.isValidated = false;
		this.specimencollectionstatus = value;
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
	public boolean getPlacerOrdNumIsNotNull()
	{
		return this.placerordnum != null;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public static int getPlacerOrdNumMaxLength()
	{
		return 20;
	}
	public void setPlacerOrdNum(String value)
	{
		this.isValidated = false;
		this.placerordnum = value;
	}
	/**
	* getOCSNumber
	*/
	/**
	 * @method getOCSNumber()
	 * @return String 
	 * method will pad out the OrderSpecimen.Id to 9 zeros e.g "000000001"
	 */
	public String getOCSNumber() 
	{
		String ocsNumber = " OCS Number: ";
		if(this.id != null)
		{
			String idString = this.id.toString();
			int padSize = 9 - idString.length();
			for(int i=0; i<padSize; i++)
				ocsNumber += "0";
			
			ocsNumber += idString;
		}
			
		return ocsNumber;
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
		if(this.collectingmos != null)
		{
			if(!this.collectingmos.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.discipline != null)
		{
			if(!this.discipline.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigations != null)
		{
			if(!this.investigations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.order != null)
		{
			if(!this.order.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.containers != null)
		{
			if(!this.containers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.specimencollectionstatus != null)
		{
			if(!this.specimencollectionstatus.isValidated())
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
		if(this.collectingmos != null)
		{
			String[] listOfOtherErrors = this.collectingmos.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.collectorcomment != null)
			if(this.collectorcomment.length() > 500)
				listOfErrors.add("The length of the field [collectorcomment] in the value object [ims.ocrr.vo.OrderSpecimenListVo] is too big. It should be less or equal to 500");
		if(this.isawaitingcollection == null)
			listOfErrors.add("IsAwaitingCollection is mandatory");
		if(this.discipline == null)
			listOfErrors.add("Discipline is mandatory");
		if(this.discipline != null)
		{
			String[] listOfOtherErrors = this.discipline.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigations != null)
		{
			String[] listOfOtherErrors = this.investigations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.order != null)
		{
			String[] listOfOtherErrors = this.order.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.containers != null)
		{
			String[] listOfOtherErrors = this.containers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.specimensource == null)
			listOfErrors.add("SpecimenSource is mandatory");
		if(this.specimencollectionstatus != null)
		{
			String[] listOfOtherErrors = this.specimencollectionstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.placerordnum == null || this.placerordnum.length() == 0)
			listOfErrors.add("PlacerOrdNum is mandatory");
		else if(this.placerordnum.length() > 20)
			listOfErrors.add("The length of the field [placerordnum] in the value object [ims.ocrr.vo.OrderSpecimenListVo] is too big. It should be less or equal to 20");
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
	
		OrderSpecimenListVo clone = new OrderSpecimenListVo(this.id, this.version);
		
		if(this.colldatetimeplacer == null)
			clone.colldatetimeplacer = null;
		else
			clone.colldatetimeplacer = (ims.framework.utils.DateTime)this.colldatetimeplacer.clone();
		if(this.collectingmos == null)
			clone.collectingmos = null;
		else
			clone.collectingmos = (ims.core.vo.MemberOfStaffLiteVo)this.collectingmos.clone();
		clone.collectorcomment = this.collectorcomment;
		clone.isawaitingcollection = this.isawaitingcollection;
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.ServiceLiteVo)this.discipline.clone();
		if(this.investigations == null)
			clone.investigations = null;
		else
			clone.investigations = (ims.ocrr.vo.OrderInvestigationListVoCollection)this.investigations.clone();
		if(this.order == null)
			clone.order = null;
		else
			clone.order = (ims.ocrr.vo.OcsOrderListVo)this.order.clone();
		if(this.containers == null)
			clone.containers = null;
		else
			clone.containers = (ims.ocrr.vo.OrderSpecimenContainerListVoCollection)this.containers.clone();
		clone.instructionstocollector = this.instructionstocollector;
		if(this.specimensource == null)
			clone.specimensource = null;
		else
			clone.specimensource = (ims.ocrr.vo.lookups.SpecimenType)this.specimensource.clone();
		if(this.sitecd == null)
			clone.sitecd = null;
		else
			clone.sitecd = (ims.ocrr.vo.lookups.SpecimenSite)this.sitecd.clone();
		if(this.specimencollectionstatus == null)
			clone.specimencollectionstatus = null;
		else
			clone.specimencollectionstatus = (ims.ocrr.vo.SpecimenCollectionStatusVoCollection)this.specimencollectionstatus.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.placerordnum = this.placerordnum;
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
		if (!(OrderSpecimenListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderSpecimenListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderSpecimenListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderSpecimenListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.colldatetimeplacer != null)
			count++;
		if(this.collectingmos != null)
			count++;
		if(this.collectorcomment != null)
			count++;
		if(this.isawaitingcollection != null)
			count++;
		if(this.discipline != null)
			count++;
		if(this.investigations != null)
			count++;
		if(this.order != null)
			count++;
		if(this.containers != null)
			count++;
		if(this.instructionstocollector != null)
			count++;
		if(this.specimensource != null)
			count++;
		if(this.sitecd != null)
			count++;
		if(this.specimencollectionstatus != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.placerordnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.framework.utils.DateTime colldatetimeplacer;
	protected ims.core.vo.MemberOfStaffLiteVo collectingmos;
	protected String collectorcomment;
	protected Boolean isawaitingcollection;
	protected ims.core.vo.ServiceLiteVo discipline;
	protected ims.ocrr.vo.OrderInvestigationListVoCollection investigations;
	protected ims.ocrr.vo.OcsOrderListVo order;
	protected ims.ocrr.vo.OrderSpecimenContainerListVoCollection containers;
	protected String instructionstocollector;
	protected ims.ocrr.vo.lookups.SpecimenType specimensource;
	protected ims.ocrr.vo.lookups.SpecimenSite sitecd;
	protected ims.ocrr.vo.SpecimenCollectionStatusVoCollection specimencollectionstatus;
	protected ims.vo.SystemInformation sysinfo;
	protected String placerordnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
