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
package ims.coe.assessment.domain.objects;

/**
 * 
 * @author Sinead McDermott
 * Generated.
 */


public class CommunicationComponent extends ims.nursing.assessment.domain.objects.AssessmentComponent implements java.io.Serializable {
	public static final int CLASSID = 1012100012;
	private static final long serialVersionUID = 1012100012L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.domain.lookups.LookupInstance difficultyInCommunication;
	private ims.coe.assessment.domain.objects.CommunicationSpeechAndLanguage speechAndLanguage;
	private ims.coe.assessment.domain.objects.CommunicationVision vision;
	private ims.coe.assessment.domain.objects.CommunicationHearing hearing;
    public CommunicationComponent (Integer id, int ver)
    {
    	super(id, ver);
    }
    public CommunicationComponent ()
    {
    	super();
    }
    public CommunicationComponent (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.coe.assessment.domain.objects.CommunicationComponent.class;
	}


	public ims.domain.lookups.LookupInstance getDifficultyInCommunication() {
		return difficultyInCommunication;
	}
	public void setDifficultyInCommunication(ims.domain.lookups.LookupInstance difficultyInCommunication) {
		this.difficultyInCommunication = difficultyInCommunication;
	}

	public ims.coe.assessment.domain.objects.CommunicationSpeechAndLanguage getSpeechAndLanguage() {
		return speechAndLanguage;
	}
	public void setSpeechAndLanguage(ims.coe.assessment.domain.objects.CommunicationSpeechAndLanguage speechAndLanguage) {
		this.speechAndLanguage = speechAndLanguage;
	}

	public ims.coe.assessment.domain.objects.CommunicationVision getVision() {
		return vision;
	}
	public void setVision(ims.coe.assessment.domain.objects.CommunicationVision vision) {
		this.vision = vision;
	}

	public ims.coe.assessment.domain.objects.CommunicationHearing getHearing() {
		return hearing;
	}
	public void setHearing(ims.coe.assessment.domain.objects.CommunicationHearing hearing) {
		this.hearing = hearing;
	}

	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
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
		
		auditStr.append(super.toAuditString());
		auditStr.append("\r\n*difficultyInCommunication* :");
		if (difficultyInCommunication != null)
			auditStr.append(difficultyInCommunication.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*speechAndLanguage* :");
		if (speechAndLanguage != null)
		{
			auditStr.append(toShortClassName(speechAndLanguage));
				
		    auditStr.append(speechAndLanguage.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*vision* :");
		if (vision != null)
		{
			auditStr.append(toShortClassName(vision));
				
		    auditStr.append(vision.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*hearing* :");
		if (hearing != null)
		{
			auditStr.append(toShortClassName(hearing));
				
		    auditStr.append(hearing.getId());
		}
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
		
		String keyClassName = "CommunicationComponent";
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
		sb.append(super.fieldsToXMLString(domMap));
		if (this.getDifficultyInCommunication() != null)
		{
			sb.append("<difficultyInCommunication>");
			sb.append(this.getDifficultyInCommunication().toXMLString()); 
			sb.append("</difficultyInCommunication>");		
		}
		if (this.getSpeechAndLanguage() != null)
		{
			sb.append("<speechAndLanguage>");
			sb.append(this.getSpeechAndLanguage().toXMLString(domMap)); 	
			sb.append("</speechAndLanguage>");		
		}
		if (this.getVision() != null)
		{
			sb.append("<vision>");
			sb.append(this.getVision().toXMLString(domMap)); 	
			sb.append("</vision>");		
		}
		if (this.getHearing() != null)
		{
			sb.append("<hearing>");
			sb.append(this.getHearing().toXMLString(domMap)); 	
			sb.append("</hearing>");		
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
			CommunicationComponent domainObject = getCommunicationComponentfromXML(itemEl, factory, domMap);

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
			CommunicationComponent domainObject = getCommunicationComponentfromXML(itemEl, factory, domMap);

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
		
	public static CommunicationComponent getCommunicationComponentfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getCommunicationComponentfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static CommunicationComponent getCommunicationComponentfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!CommunicationComponent.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!CommunicationComponent.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the CommunicationComponent class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (CommunicationComponent)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(CommunicationComponent.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		CommunicationComponent ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (CommunicationComponent)factory.getImportedDomainObject(CommunicationComponent.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new CommunicationComponent();
		}
		String keyClassName = "CommunicationComponent";
		Class clz = ret.getClass().getSuperclass();
		while (!clz.equals(ims.domain.DomainObject.class))
		{
			int dotIndex = clz.getName().lastIndexOf(".") + 1;
			keyClassName = clz.getName().substring(dotIndex); 
			clz = clz.getSuperclass();
		}

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (CommunicationComponent)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, CommunicationComponent obj, java.util.HashMap domMap) throws Exception
	{
		ims.nursing.assessment.domain.objects.AssessmentComponent.fillFieldsfromXML(el, factory, obj, domMap);
		org.dom4j.Element fldEl;
		fldEl = el.element("difficultyInCommunication");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setDifficultyInCommunication(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("speechAndLanguage");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setSpeechAndLanguage(ims.coe.assessment.domain.objects.CommunicationSpeechAndLanguage.getCommunicationSpeechAndLanguagefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("vision");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setVision(ims.coe.assessment.domain.objects.CommunicationVision.getCommunicationVisionfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("hearing");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setHearing(ims.coe.assessment.domain.objects.CommunicationHearing.getCommunicationHearingfromXML(fldEl, factory, domMap)); 
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
		public static final String DifficultyInCommunication = "difficultyInCommunication";
		public static final String SpeechAndLanguage = "speechAndLanguage";
		public static final String Vision = "vision";
		public static final String Hearing = "hearing";
	}
}

