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
package ims.icps.instantiation.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class PatientICPActionStatus extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1100100006;
	private static final long serialVersionUID = 1100100006L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Date of Status Change */
	private java.util.Date statusDate;
	/** ChangedBy */
	private ims.core.resource.people.domain.objects.MemberOfStaff changedBy;
	/** Status */
	private ims.domain.lookups.LookupInstance status;
	/** Variance Category */
	private ims.domain.lookups.LookupInstance varianceCategory;
	/** Variance Type */
	private ims.domain.lookups.LookupInstance varianceType;
	/** Variance Comment */
	private String varianceComment;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public PatientICPActionStatus (Integer id, int ver)
    {
    	super(id, ver);
    }
    public PatientICPActionStatus ()
    {
    	super();
    }
    public PatientICPActionStatus (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.icps.instantiation.domain.objects.PatientICPActionStatus.class;
	}


	public java.util.Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(java.util.Date statusDate) {
		this.statusDate = statusDate;
	}

	public ims.core.resource.people.domain.objects.MemberOfStaff getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(ims.core.resource.people.domain.objects.MemberOfStaff changedBy) {
		this.changedBy = changedBy;
	}

	public ims.domain.lookups.LookupInstance getStatus() {
		return status;
	}
	public void setStatus(ims.domain.lookups.LookupInstance status) {
		this.status = status;
	}

	public ims.domain.lookups.LookupInstance getVarianceCategory() {
		return varianceCategory;
	}
	public void setVarianceCategory(ims.domain.lookups.LookupInstance varianceCategory) {
		this.varianceCategory = varianceCategory;
	}

	public ims.domain.lookups.LookupInstance getVarianceType() {
		return varianceType;
	}
	public void setVarianceType(ims.domain.lookups.LookupInstance varianceType) {
		this.varianceType = varianceType;
	}

	public String getVarianceComment() {
		return varianceComment;
	}
	public void setVarianceComment(String varianceComment) {
		if ( null != varianceComment && varianceComment.length() > 500 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for varianceComment. Tried to set value: "+
				varianceComment);
		}
		this.varianceComment = varianceComment;
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
		
		auditStr.append("\r\n*statusDate* :");
		auditStr.append(statusDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*changedBy* :");
		if (changedBy != null)
		{
			auditStr.append(toShortClassName(changedBy));
				
		    auditStr.append(changedBy.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*status* :");
		if (status != null)
			auditStr.append(status.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*varianceCategory* :");
		if (varianceCategory != null)
			auditStr.append(varianceCategory.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*varianceType* :");
		if (varianceType != null)
			auditStr.append(varianceType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*varianceComment* :");
		auditStr.append(varianceComment);
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
		
		String keyClassName = "PatientICPActionStatus";
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
		if (this.getStatusDate() != null)
		{
			sb.append("<statusDate>");
			sb.append(new ims.framework.utils.DateTime(this.getStatusDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</statusDate>");		
		}
		if (this.getChangedBy() != null)
		{
			sb.append("<changedBy>");
			sb.append(this.getChangedBy().toXMLString(domMap)); 	
			sb.append("</changedBy>");		
		}
		if (this.getStatus() != null)
		{
			sb.append("<status>");
			sb.append(this.getStatus().toXMLString()); 
			sb.append("</status>");		
		}
		if (this.getVarianceCategory() != null)
		{
			sb.append("<varianceCategory>");
			sb.append(this.getVarianceCategory().toXMLString()); 
			sb.append("</varianceCategory>");		
		}
		if (this.getVarianceType() != null)
		{
			sb.append("<varianceType>");
			sb.append(this.getVarianceType().toXMLString()); 
			sb.append("</varianceType>");		
		}
		if (this.getVarianceComment() != null)
		{
			sb.append("<varianceComment>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getVarianceComment().toString()));
			sb.append("</varianceComment>");		
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
			PatientICPActionStatus domainObject = getPatientICPActionStatusfromXML(itemEl, factory, domMap);

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
			PatientICPActionStatus domainObject = getPatientICPActionStatusfromXML(itemEl, factory, domMap);

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
		
	public static PatientICPActionStatus getPatientICPActionStatusfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getPatientICPActionStatusfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static PatientICPActionStatus getPatientICPActionStatusfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!PatientICPActionStatus.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!PatientICPActionStatus.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the PatientICPActionStatus class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (PatientICPActionStatus)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(PatientICPActionStatus.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		PatientICPActionStatus ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (PatientICPActionStatus)factory.getImportedDomainObject(PatientICPActionStatus.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new PatientICPActionStatus();
		}
		String keyClassName = "PatientICPActionStatus";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (PatientICPActionStatus)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, PatientICPActionStatus obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("statusDate");
		if(fldEl != null)
		{	
    		obj.setStatusDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("changedBy");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setChangedBy(ims.core.resource.people.domain.objects.MemberOfStaff.getMemberOfStafffromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("status");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("varianceCategory");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setVarianceCategory(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("varianceType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setVarianceType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("varianceComment");
		if(fldEl != null)
		{	
    		obj.setVarianceComment(new String(fldEl.getTextTrim()));	
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
		public static final String StatusDate = "statusDate";
		public static final String ChangedBy = "changedBy";
		public static final String Status = "status";
		public static final String VarianceCategory = "varianceCategory";
		public static final String VarianceType = "varianceType";
		public static final String VarianceComment = "varianceComment";
	}
}

