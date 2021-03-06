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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.pathways.domain.objects;

/**
 * 
 * @author Barbara Worwood
 * Generated.
 */


public class RTTStatusEventMap extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1088100009;
	private static final long serialVersionUID = 1088100009L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** The RTT Status Point to be created */
	private ims.pathways.configuration.domain.objects.RTTStatusPoint targetRTTStatus;
	/** The event to be instantiated */
	private ims.pathways.configuration.domain.objects.Event event;
	/** Active / Inactive indicator */
	private Boolean active;
	/** Current RTTStatus point */
	private ims.pathways.configuration.domain.objects.RTTStatusPoint currentRTTStatus;
	/** Encounter type, Clinic Appt or Admin event */
	private ims.domain.lookups.LookupInstance encounterType;
	/** Depending on selected Encounter Type parent type this is used to record an instance */
	private ims.domain.lookups.LookupInstance encounterInstance;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public RTTStatusEventMap (Integer id, int ver)
    {
    	super(id, ver);
    }
    public RTTStatusEventMap ()
    {
    	super();
    }
    public RTTStatusEventMap (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.pathways.domain.objects.RTTStatusEventMap.class;
	}


	public ims.pathways.configuration.domain.objects.RTTStatusPoint getTargetRTTStatus() {
		return targetRTTStatus;
	}
	public void setTargetRTTStatus(ims.pathways.configuration.domain.objects.RTTStatusPoint targetRTTStatus) {
		this.targetRTTStatus = targetRTTStatus;
	}

	public ims.pathways.configuration.domain.objects.Event getEvent() {
		return event;
	}
	public void setEvent(ims.pathways.configuration.domain.objects.Event event) {
		this.event = event;
	}

	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public ims.pathways.configuration.domain.objects.RTTStatusPoint getCurrentRTTStatus() {
		return currentRTTStatus;
	}
	public void setCurrentRTTStatus(ims.pathways.configuration.domain.objects.RTTStatusPoint currentRTTStatus) {
		this.currentRTTStatus = currentRTTStatus;
	}

	public ims.domain.lookups.LookupInstance getEncounterType() {
		return encounterType;
	}
	public void setEncounterType(ims.domain.lookups.LookupInstance encounterType) {
		this.encounterType = encounterType;
	}

	public ims.domain.lookups.LookupInstance getEncounterInstance() {
		return encounterInstance;
	}
	public void setEncounterInstance(ims.domain.lookups.LookupInstance encounterInstance) {
		this.encounterInstance = encounterInstance;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Configuration".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*targetRTTStatus* :");
		if (targetRTTStatus != null)
		{
			auditStr.append(toShortClassName(targetRTTStatus));
				
		    auditStr.append(targetRTTStatus.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*event* :");
		if (event != null)
		{
			auditStr.append(toShortClassName(event));
				
		    auditStr.append(event.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*active* :");
		auditStr.append(active);
	    auditStr.append("; ");
		auditStr.append("\r\n*currentRTTStatus* :");
		if (currentRTTStatus != null)
		{
			auditStr.append(toShortClassName(currentRTTStatus));
				
		    auditStr.append(currentRTTStatus.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*encounterType* :");
		if (encounterType != null)
			auditStr.append(encounterType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*encounterInstance* :");
		if (encounterInstance != null)
			auditStr.append(encounterInstance.getText());
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "RTTStatusEventMap";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getTargetRTTStatus() != null)
		{
			sb.append("<targetRTTStatus>");
			sb.append(this.getTargetRTTStatus().toXMLString(domMap)); 	
			sb.append("</targetRTTStatus>");		
		}
		if (this.getEvent() != null)
		{
			sb.append("<event>");
			sb.append(this.getEvent().toXMLString(domMap)); 	
			sb.append("</event>");		
		}
		if (this.isActive() != null)
		{
			sb.append("<active>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isActive().toString()));
			sb.append("</active>");		
		}
		if (this.getCurrentRTTStatus() != null)
		{
			sb.append("<currentRTTStatus>");
			sb.append(this.getCurrentRTTStatus().toXMLString(domMap)); 	
			sb.append("</currentRTTStatus>");		
		}
		if (this.getEncounterType() != null)
		{
			sb.append("<encounterType>");
			sb.append(this.getEncounterType().toXMLString()); 
			sb.append("</encounterType>");		
		}
		if (this.getEncounterInstance() != null)
		{
			sb.append("<encounterInstance>");
			sb.append(this.getEncounterInstance().toXMLString()); 	
			sb.append(this.getEncounterInstance().toXMLString()); 
			sb.append("</encounterInstance>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			RTTStatusEventMap domainObject = getRTTStatusEventMapfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			RTTStatusEventMap domainObject = getRTTStatusEventMapfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static RTTStatusEventMap getRTTStatusEventMapfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getRTTStatusEventMapfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static RTTStatusEventMap getRTTStatusEventMapfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!RTTStatusEventMap.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!RTTStatusEventMap.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the RTTStatusEventMap class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (RTTStatusEventMap)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(RTTStatusEventMap.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		RTTStatusEventMap ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (RTTStatusEventMap)factory.getImportedDomainObject(RTTStatusEventMap.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new RTTStatusEventMap();
		}
		String keyClassName = "RTTStatusEventMap";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (RTTStatusEventMap)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, RTTStatusEventMap obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("targetRTTStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setTargetRTTStatus(ims.pathways.configuration.domain.objects.RTTStatusPoint.getRTTStatusPointfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("event");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setEvent(ims.pathways.configuration.domain.objects.Event.getEventfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("active");
		if(fldEl != null)
		{	
    		obj.setActive(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("currentRTTStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setCurrentRTTStatus(ims.pathways.configuration.domain.objects.RTTStatusPoint.getRTTStatusPointfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("encounterType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setEncounterType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("encounterInstance");
		if(fldEl != null)
		{	
    		obj.setEncounterInstance(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String TargetRTTStatus = "targetRTTStatus";
		public static final String Event = "event";
		public static final String Active = "active";
		public static final String CurrentRTTStatus = "currentRTTStatus";
		public static final String EncounterType = "encounterType";
		public static final String EncounterInstance = "encounterInstance";
	}
}

