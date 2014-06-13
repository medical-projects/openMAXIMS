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
 * Linked to CAREUK.SuitableForSurgeryAssessment business object (ID: 1096100015).
 */
public class SuitableForSurgeryAssessmentLiteVo extends ims.careuk.vo.SuitableForSurgeryAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SuitableForSurgeryAssessmentLiteVo()
	{
	}
	public SuitableForSurgeryAssessmentLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public SuitableForSurgeryAssessmentLiteVo(ims.careuk.vo.beans.SuitableForSurgeryAssessmentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.historyprescomplaint = bean.getHistoryPresComplaint();
		this.examination = bean.getExamination();
		this.conclusions = bean.getConclusions();
		this.notsuitableforsurgeycomments = bean.getNotSuitableForSurgeyComments();
		this.suitableforsurgery = bean.getSuitableForSurgery() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSuitableForSurgery());
		this.reasonnotsuitable = bean.getReasonNotSuitable() == null ? null : ims.careuk.vo.lookups.ReasonNotSuitableForSurgery.buildLookup(bean.getReasonNotSuitable());
		this.comments = ims.careuk.vo.SuitableForSurgeryCommentVoCollection.buildFromBeanCollection(bean.getComments());
		this.procedureperformed = bean.getProcedurePerformed();
		this.suitableforsurgerydate = bean.getSuitableForSurgeryDate() == null ? null : bean.getSuitableForSurgeryDate().buildDate();
		this.requireddurationinmins = bean.getRequiredDurationInMins();
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.namedsurgeon = bean.getNamedSurgeon() == null ? null : bean.getNamedSurgeon().buildVo();
		this.specialequipmentrequired = bean.getSpecialEquipmentRequired();
		this.specialequipmentcomments = bean.getSpecialEquipmentComments();
		this.specialinstructionsrequired = bean.getSpecialInstructionsRequired();
		this.specialinstructionscomments = bean.getSpecialInstructionsComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.SuitableForSurgeryAssessmentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.theatretype = bean.getTheatreType() == null ? null : ims.scheduling.vo.lookups.TheatreType.buildLookup(bean.getTheatreType());
		this.historyprescomplaint = bean.getHistoryPresComplaint();
		this.examination = bean.getExamination();
		this.conclusions = bean.getConclusions();
		this.notsuitableforsurgeycomments = bean.getNotSuitableForSurgeyComments();
		this.suitableforsurgery = bean.getSuitableForSurgery() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSuitableForSurgery());
		this.reasonnotsuitable = bean.getReasonNotSuitable() == null ? null : ims.careuk.vo.lookups.ReasonNotSuitableForSurgery.buildLookup(bean.getReasonNotSuitable());
		this.comments = ims.careuk.vo.SuitableForSurgeryCommentVoCollection.buildFromBeanCollection(bean.getComments());
		this.procedureperformed = bean.getProcedurePerformed();
		this.suitableforsurgerydate = bean.getSuitableForSurgeryDate() == null ? null : bean.getSuitableForSurgeryDate().buildDate();
		this.requireddurationinmins = bean.getRequiredDurationInMins();
		this.anaesthetictype = bean.getAnaestheticType() == null ? null : ims.clinical.vo.lookups.AnaestheticType.buildLookup(bean.getAnaestheticType());
		this.namedsurgeon = bean.getNamedSurgeon() == null ? null : bean.getNamedSurgeon().buildVo(map);
		this.specialequipmentrequired = bean.getSpecialEquipmentRequired();
		this.specialequipmentcomments = bean.getSpecialEquipmentComments();
		this.specialinstructionsrequired = bean.getSpecialInstructionsRequired();
		this.specialinstructionscomments = bean.getSpecialInstructionsComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.SuitableForSurgeryAssessmentLiteVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.SuitableForSurgeryAssessmentLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.SuitableForSurgeryAssessmentLiteVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("THEATRETYPE"))
			return getTheatreType();
		if(fieldName.equals("HISTORYPRESCOMPLAINT"))
			return getHistoryPresComplaint();
		if(fieldName.equals("EXAMINATION"))
			return getExamination();
		if(fieldName.equals("CONCLUSIONS"))
			return getConclusions();
		if(fieldName.equals("NOTSUITABLEFORSURGEYCOMMENTS"))
			return getNotSuitableForSurgeyComments();
		if(fieldName.equals("SUITABLEFORSURGERY"))
			return getSuitableForSurgery();
		if(fieldName.equals("REASONNOTSUITABLE"))
			return getReasonNotSuitable();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("PROCEDUREPERFORMED"))
			return getProcedurePerformed();
		if(fieldName.equals("SUITABLEFORSURGERYDATE"))
			return getSuitableForSurgeryDate();
		if(fieldName.equals("REQUIREDDURATIONINMINS"))
			return getRequiredDurationInMins();
		if(fieldName.equals("ANAESTHETICTYPE"))
			return getAnaestheticType();
		if(fieldName.equals("NAMEDSURGEON"))
			return getNamedSurgeon();
		if(fieldName.equals("SPECIALEQUIPMENTREQUIRED"))
			return getSpecialEquipmentRequired();
		if(fieldName.equals("SPECIALEQUIPMENTCOMMENTS"))
			return getSpecialEquipmentComments();
		if(fieldName.equals("SPECIALINSTRUCTIONSREQUIRED"))
			return getSpecialInstructionsRequired();
		if(fieldName.equals("SPECIALINSTRUCTIONSCOMMENTS"))
			return getSpecialInstructionsComments();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.PatientProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.PatientProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getTheatreTypeIsNotNull()
	{
		return this.theatretype != null;
	}
	public ims.scheduling.vo.lookups.TheatreType getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.scheduling.vo.lookups.TheatreType value)
	{
		this.isValidated = false;
		this.theatretype = value;
	}
	public boolean getHistoryPresComplaintIsNotNull()
	{
		return this.historyprescomplaint != null;
	}
	public String getHistoryPresComplaint()
	{
		return this.historyprescomplaint;
	}
	public static int getHistoryPresComplaintMaxLength()
	{
		return 10000;
	}
	public void setHistoryPresComplaint(String value)
	{
		this.isValidated = false;
		this.historyprescomplaint = value;
	}
	public boolean getExaminationIsNotNull()
	{
		return this.examination != null;
	}
	public String getExamination()
	{
		return this.examination;
	}
	public static int getExaminationMaxLength()
	{
		return 10000;
	}
	public void setExamination(String value)
	{
		this.isValidated = false;
		this.examination = value;
	}
	public boolean getConclusionsIsNotNull()
	{
		return this.conclusions != null;
	}
	public String getConclusions()
	{
		return this.conclusions;
	}
	public static int getConclusionsMaxLength()
	{
		return 10000;
	}
	public void setConclusions(String value)
	{
		this.isValidated = false;
		this.conclusions = value;
	}
	public boolean getNotSuitableForSurgeyCommentsIsNotNull()
	{
		return this.notsuitableforsurgeycomments != null;
	}
	public String getNotSuitableForSurgeyComments()
	{
		return this.notsuitableforsurgeycomments;
	}
	public static int getNotSuitableForSurgeyCommentsMaxLength()
	{
		return 10000;
	}
	public void setNotSuitableForSurgeyComments(String value)
	{
		this.isValidated = false;
		this.notsuitableforsurgeycomments = value;
	}
	public boolean getSuitableForSurgeryIsNotNull()
	{
		return this.suitableforsurgery != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getSuitableForSurgery()
	{
		return this.suitableforsurgery;
	}
	public void setSuitableForSurgery(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.suitableforsurgery = value;
	}
	public boolean getReasonNotSuitableIsNotNull()
	{
		return this.reasonnotsuitable != null;
	}
	public ims.careuk.vo.lookups.ReasonNotSuitableForSurgery getReasonNotSuitable()
	{
		return this.reasonnotsuitable;
	}
	public void setReasonNotSuitable(ims.careuk.vo.lookups.ReasonNotSuitableForSurgery value)
	{
		this.isValidated = false;
		this.reasonnotsuitable = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public ims.careuk.vo.SuitableForSurgeryCommentVoCollection getComments()
	{
		return this.comments;
	}
	public void setComments(ims.careuk.vo.SuitableForSurgeryCommentVoCollection value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getProcedurePerformedIsNotNull()
	{
		return this.procedureperformed != null;
	}
	public Boolean getProcedurePerformed()
	{
		return this.procedureperformed;
	}
	public void setProcedurePerformed(Boolean value)
	{
		this.isValidated = false;
		this.procedureperformed = value;
	}
	public boolean getSuitableForSurgeryDateIsNotNull()
	{
		return this.suitableforsurgerydate != null;
	}
	public ims.framework.utils.Date getSuitableForSurgeryDate()
	{
		return this.suitableforsurgerydate;
	}
	public void setSuitableForSurgeryDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.suitableforsurgerydate = value;
	}
	public boolean getRequiredDurationInMinsIsNotNull()
	{
		return this.requireddurationinmins != null;
	}
	public Integer getRequiredDurationInMins()
	{
		return this.requireddurationinmins;
	}
	public void setRequiredDurationInMins(Integer value)
	{
		this.isValidated = false;
		this.requireddurationinmins = value;
	}
	public boolean getAnaestheticTypeIsNotNull()
	{
		return this.anaesthetictype != null;
	}
	public ims.clinical.vo.lookups.AnaestheticType getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.clinical.vo.lookups.AnaestheticType value)
	{
		this.isValidated = false;
		this.anaesthetictype = value;
	}
	public boolean getNamedSurgeonIsNotNull()
	{
		return this.namedsurgeon != null;
	}
	public ims.core.vo.MedicLiteVo getNamedSurgeon()
	{
		return this.namedsurgeon;
	}
	public void setNamedSurgeon(ims.core.vo.MedicLiteVo value)
	{
		this.isValidated = false;
		this.namedsurgeon = value;
	}
	public boolean getSpecialEquipmentRequiredIsNotNull()
	{
		return this.specialequipmentrequired != null;
	}
	public Boolean getSpecialEquipmentRequired()
	{
		return this.specialequipmentrequired;
	}
	public void setSpecialEquipmentRequired(Boolean value)
	{
		this.isValidated = false;
		this.specialequipmentrequired = value;
	}
	public boolean getSpecialEquipmentCommentsIsNotNull()
	{
		return this.specialequipmentcomments != null;
	}
	public String getSpecialEquipmentComments()
	{
		return this.specialequipmentcomments;
	}
	public static int getSpecialEquipmentCommentsMaxLength()
	{
		return 1000;
	}
	public void setSpecialEquipmentComments(String value)
	{
		this.isValidated = false;
		this.specialequipmentcomments = value;
	}
	public boolean getSpecialInstructionsRequiredIsNotNull()
	{
		return this.specialinstructionsrequired != null;
	}
	public Boolean getSpecialInstructionsRequired()
	{
		return this.specialinstructionsrequired;
	}
	public void setSpecialInstructionsRequired(Boolean value)
	{
		this.isValidated = false;
		this.specialinstructionsrequired = value;
	}
	public boolean getSpecialInstructionsCommentsIsNotNull()
	{
		return this.specialinstructionscomments != null;
	}
	public String getSpecialInstructionsComments()
	{
		return this.specialinstructionscomments;
	}
	public static int getSpecialInstructionsCommentsMaxLength()
	{
		return 1000;
	}
	public void setSpecialInstructionsComments(String value)
	{
		this.isValidated = false;
		this.specialinstructionscomments = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.procedure != null)
		{
			if(!this.procedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.comments != null)
		{
			if(!this.comments.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
		if(this.procedure != null)
		{
			String[] listOfOtherErrors = this.procedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
		{
			String[] listOfOtherErrors = this.comments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.specialequipmentcomments != null)
			if(this.specialequipmentcomments.length() > 1000)
				listOfErrors.add("The length of the field [specialequipmentcomments] in the value object [ims.careuk.vo.SuitableForSurgeryAssessmentLiteVo] is too big. It should be less or equal to 1000");
		if(this.specialinstructionscomments != null)
			if(this.specialinstructionscomments.length() > 1000)
				listOfErrors.add("The length of the field [specialinstructionscomments] in the value object [ims.careuk.vo.SuitableForSurgeryAssessmentLiteVo] is too big. It should be less or equal to 1000");
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
	
		SuitableForSurgeryAssessmentLiteVo clone = new SuitableForSurgeryAssessmentLiteVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.PatientProcedureLiteVo)this.procedure.clone();
		if(this.theatretype == null)
			clone.theatretype = null;
		else
			clone.theatretype = (ims.scheduling.vo.lookups.TheatreType)this.theatretype.clone();
		clone.historyprescomplaint = this.historyprescomplaint;
		clone.examination = this.examination;
		clone.conclusions = this.conclusions;
		clone.notsuitableforsurgeycomments = this.notsuitableforsurgeycomments;
		if(this.suitableforsurgery == null)
			clone.suitableforsurgery = null;
		else
			clone.suitableforsurgery = (ims.core.vo.lookups.YesNoUnknown)this.suitableforsurgery.clone();
		if(this.reasonnotsuitable == null)
			clone.reasonnotsuitable = null;
		else
			clone.reasonnotsuitable = (ims.careuk.vo.lookups.ReasonNotSuitableForSurgery)this.reasonnotsuitable.clone();
		if(this.comments == null)
			clone.comments = null;
		else
			clone.comments = (ims.careuk.vo.SuitableForSurgeryCommentVoCollection)this.comments.clone();
		clone.procedureperformed = this.procedureperformed;
		if(this.suitableforsurgerydate == null)
			clone.suitableforsurgerydate = null;
		else
			clone.suitableforsurgerydate = (ims.framework.utils.Date)this.suitableforsurgerydate.clone();
		clone.requireddurationinmins = this.requireddurationinmins;
		if(this.anaesthetictype == null)
			clone.anaesthetictype = null;
		else
			clone.anaesthetictype = (ims.clinical.vo.lookups.AnaestheticType)this.anaesthetictype.clone();
		if(this.namedsurgeon == null)
			clone.namedsurgeon = null;
		else
			clone.namedsurgeon = (ims.core.vo.MedicLiteVo)this.namedsurgeon.clone();
		clone.specialequipmentrequired = this.specialequipmentrequired;
		clone.specialequipmentcomments = this.specialequipmentcomments;
		clone.specialinstructionsrequired = this.specialinstructionsrequired;
		clone.specialinstructionscomments = this.specialinstructionscomments;
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
		if (!(SuitableForSurgeryAssessmentLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SuitableForSurgeryAssessmentLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SuitableForSurgeryAssessmentLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SuitableForSurgeryAssessmentLiteVo)obj).getBoId());
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
		if(this.authoringinformation != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.theatretype != null)
			count++;
		if(this.historyprescomplaint != null)
			count++;
		if(this.examination != null)
			count++;
		if(this.conclusions != null)
			count++;
		if(this.notsuitableforsurgeycomments != null)
			count++;
		if(this.suitableforsurgery != null)
			count++;
		if(this.reasonnotsuitable != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.procedureperformed != null)
			count++;
		if(this.suitableforsurgerydate != null)
			count++;
		if(this.requireddurationinmins != null)
			count++;
		if(this.anaesthetictype != null)
			count++;
		if(this.namedsurgeon != null)
			count++;
		if(this.specialequipmentrequired != null)
			count++;
		if(this.specialequipmentcomments != null)
			count++;
		if(this.specialinstructionsrequired != null)
			count++;
		if(this.specialinstructionscomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 20;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.PatientProcedureLiteVo procedure;
	protected ims.scheduling.vo.lookups.TheatreType theatretype;
	protected String historyprescomplaint;
	protected String examination;
	protected String conclusions;
	protected String notsuitableforsurgeycomments;
	protected ims.core.vo.lookups.YesNoUnknown suitableforsurgery;
	protected ims.careuk.vo.lookups.ReasonNotSuitableForSurgery reasonnotsuitable;
	protected ims.careuk.vo.SuitableForSurgeryCommentVoCollection comments;
	protected Boolean procedureperformed;
	protected ims.framework.utils.Date suitableforsurgerydate;
	protected Integer requireddurationinmins;
	protected ims.clinical.vo.lookups.AnaestheticType anaesthetictype;
	protected ims.core.vo.MedicLiteVo namedsurgeon;
	protected Boolean specialequipmentrequired;
	protected String specialequipmentcomments;
	protected Boolean specialinstructionsrequired;
	protected String specialinstructionscomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
