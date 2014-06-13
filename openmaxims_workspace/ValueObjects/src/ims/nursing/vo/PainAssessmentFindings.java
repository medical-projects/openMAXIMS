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
 * Linked to nursing.assessment tools.Pain Assessment Findings business object (ID: 1016100002).
 */
public class PainAssessmentFindings extends ims.nursing.assessmenttools.vo.PainAssessmentFindingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PainAssessmentFindings()
	{
	}
	public PainAssessmentFindings(Integer id, int version)
	{
		super(id, version);
	}
	public PainAssessmentFindings(ims.nursing.vo.beans.PainAssessmentFindingsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.siteimage = bean.getSiteImage();
		this.sitename = bean.getSiteName();
		this.painhypersensitivity = bean.getPainHypersensitivity() == null ? null : ims.nursing.vo.lookups.PainHypersensitivity.buildLookup(bean.getPainHypersensitivity());
		this.painassessmentreview = ims.nursing.vo.PainAssessmentReviewCollection.buildFromBeanCollection(bean.getPainAssessmentReview());
		this.isdiscontinuedassess = bean.getIsDiscontinuedAssess();
		this.iscontinuedassessment = bean.getIsContinuedAssessment();
		this.sitedetails = bean.getSiteDetails();
		this.type = bean.getType() == null ? null : ims.nursing.vo.lookups.PainType.buildLookup(bean.getType());
		this.severity = bean.getSeverity() == null ? null : ims.nursing.vo.lookups.PainSeverity.buildLookup(bean.getSeverity());
		this.onset = bean.getOnset() == null ? null : ims.nursing.vo.lookups.PainOnset.buildLookup(bean.getOnset());
		this.progression = bean.getProgression() == null ? null : ims.nursing.vo.lookups.PainProgression.buildLookup(bean.getProgression());
		this.depth = bean.getDepth() == null ? null : ims.nursing.vo.lookups.PainDepth.buildLookup(bean.getDepth());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PainAssessmentFindingsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.siteimage = bean.getSiteImage();
		this.sitename = bean.getSiteName();
		this.painhypersensitivity = bean.getPainHypersensitivity() == null ? null : ims.nursing.vo.lookups.PainHypersensitivity.buildLookup(bean.getPainHypersensitivity());
		this.painassessmentreview = ims.nursing.vo.PainAssessmentReviewCollection.buildFromBeanCollection(bean.getPainAssessmentReview());
		this.isdiscontinuedassess = bean.getIsDiscontinuedAssess();
		this.iscontinuedassessment = bean.getIsContinuedAssessment();
		this.sitedetails = bean.getSiteDetails();
		this.type = bean.getType() == null ? null : ims.nursing.vo.lookups.PainType.buildLookup(bean.getType());
		this.severity = bean.getSeverity() == null ? null : ims.nursing.vo.lookups.PainSeverity.buildLookup(bean.getSeverity());
		this.onset = bean.getOnset() == null ? null : ims.nursing.vo.lookups.PainOnset.buildLookup(bean.getOnset());
		this.progression = bean.getProgression() == null ? null : ims.nursing.vo.lookups.PainProgression.buildLookup(bean.getProgression());
		this.depth = bean.getDepth() == null ? null : ims.nursing.vo.lookups.PainDepth.buildLookup(bean.getDepth());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PainAssessmentFindingsBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PainAssessmentFindingsBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PainAssessmentFindingsBean();
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
		if(fieldName.equals("SITEIMAGE"))
			return getSiteImage();
		if(fieldName.equals("SITENAME"))
			return getSiteName();
		if(fieldName.equals("PAINHYPERSENSITIVITY"))
			return getPainHypersensitivity();
		if(fieldName.equals("PAINASSESSMENTREVIEW"))
			return getPainAssessmentReview();
		if(fieldName.equals("ISDISCONTINUEDASSESS"))
			return getIsDiscontinuedAssess();
		if(fieldName.equals("ISCONTINUEDASSESSMENT"))
			return getIsContinuedAssessment();
		if(fieldName.equals("SITEDETAILS"))
			return getSiteDetails();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("SEVERITY"))
			return getSeverity();
		if(fieldName.equals("ONSET"))
			return getOnset();
		if(fieldName.equals("PROGRESSION"))
			return getProgression();
		if(fieldName.equals("DEPTH"))
			return getDepth();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSiteImageIsNotNull()
	{
		return this.siteimage != null;
	}
	public String getSiteImage()
	{
		return this.siteimage;
	}
	public static int getSiteImageMaxLength()
	{
		return 4000;
	}
	public void setSiteImage(String value)
	{
		this.isValidated = false;
		this.siteimage = value;
	}
	public boolean getSiteNameIsNotNull()
	{
		return this.sitename != null;
	}
	public String getSiteName()
	{
		return this.sitename;
	}
	public static int getSiteNameMaxLength()
	{
		return 255;
	}
	public void setSiteName(String value)
	{
		this.isValidated = false;
		this.sitename = value;
	}
	public boolean getPainHypersensitivityIsNotNull()
	{
		return this.painhypersensitivity != null;
	}
	public ims.nursing.vo.lookups.PainHypersensitivity getPainHypersensitivity()
	{
		return this.painhypersensitivity;
	}
	public void setPainHypersensitivity(ims.nursing.vo.lookups.PainHypersensitivity value)
	{
		this.isValidated = false;
		this.painhypersensitivity = value;
	}
	public boolean getPainAssessmentReviewIsNotNull()
	{
		return this.painassessmentreview != null;
	}
	public ims.nursing.vo.PainAssessmentReviewCollection getPainAssessmentReview()
	{
		return this.painassessmentreview;
	}
	public void setPainAssessmentReview(ims.nursing.vo.PainAssessmentReviewCollection value)
	{
		this.isValidated = false;
		this.painassessmentreview = value;
	}
	public boolean getIsDiscontinuedAssessIsNotNull()
	{
		return this.isdiscontinuedassess != null;
	}
	public Boolean getIsDiscontinuedAssess()
	{
		return this.isdiscontinuedassess;
	}
	public void setIsDiscontinuedAssess(Boolean value)
	{
		this.isValidated = false;
		this.isdiscontinuedassess = value;
	}
	public boolean getIsContinuedAssessmentIsNotNull()
	{
		return this.iscontinuedassessment != null;
	}
	public Boolean getIsContinuedAssessment()
	{
		return this.iscontinuedassessment;
	}
	public void setIsContinuedAssessment(Boolean value)
	{
		this.isValidated = false;
		this.iscontinuedassessment = value;
	}
	public boolean getSiteDetailsIsNotNull()
	{
		return this.sitedetails != null;
	}
	public String getSiteDetails()
	{
		return this.sitedetails;
	}
	public static int getSiteDetailsMaxLength()
	{
		return 255;
	}
	public void setSiteDetails(String value)
	{
		this.isValidated = false;
		this.sitedetails = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.nursing.vo.lookups.PainType getType()
	{
		return this.type;
	}
	public void setType(ims.nursing.vo.lookups.PainType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getSeverityIsNotNull()
	{
		return this.severity != null;
	}
	public ims.nursing.vo.lookups.PainSeverity getSeverity()
	{
		return this.severity;
	}
	public void setSeverity(ims.nursing.vo.lookups.PainSeverity value)
	{
		this.isValidated = false;
		this.severity = value;
	}
	public boolean getOnsetIsNotNull()
	{
		return this.onset != null;
	}
	public ims.nursing.vo.lookups.PainOnset getOnset()
	{
		return this.onset;
	}
	public void setOnset(ims.nursing.vo.lookups.PainOnset value)
	{
		this.isValidated = false;
		this.onset = value;
	}
	public boolean getProgressionIsNotNull()
	{
		return this.progression != null;
	}
	public ims.nursing.vo.lookups.PainProgression getProgression()
	{
		return this.progression;
	}
	public void setProgression(ims.nursing.vo.lookups.PainProgression value)
	{
		this.isValidated = false;
		this.progression = value;
	}
	public boolean getDepthIsNotNull()
	{
		return this.depth != null;
	}
	public ims.nursing.vo.lookups.PainDepth getDepth()
	{
		return this.depth;
	}
	public void setDepth(ims.nursing.vo.lookups.PainDepth value)
	{
		this.isValidated = false;
		this.depth = value;
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
		if(this.painassessmentreview != null)
		{
			if(!this.painassessmentreview.isValidated())
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
		if(this.painassessmentreview != null)
		{
			String[] listOfOtherErrors = this.painassessmentreview.validate();
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
	
		PainAssessmentFindings clone = new PainAssessmentFindings(this.id, this.version);
		
		clone.siteimage = this.siteimage;
		clone.sitename = this.sitename;
		if(this.painhypersensitivity == null)
			clone.painhypersensitivity = null;
		else
			clone.painhypersensitivity = (ims.nursing.vo.lookups.PainHypersensitivity)this.painhypersensitivity.clone();
		if(this.painassessmentreview == null)
			clone.painassessmentreview = null;
		else
			clone.painassessmentreview = (ims.nursing.vo.PainAssessmentReviewCollection)this.painassessmentreview.clone();
		clone.isdiscontinuedassess = this.isdiscontinuedassess;
		clone.iscontinuedassessment = this.iscontinuedassessment;
		clone.sitedetails = this.sitedetails;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.nursing.vo.lookups.PainType)this.type.clone();
		if(this.severity == null)
			clone.severity = null;
		else
			clone.severity = (ims.nursing.vo.lookups.PainSeverity)this.severity.clone();
		if(this.onset == null)
			clone.onset = null;
		else
			clone.onset = (ims.nursing.vo.lookups.PainOnset)this.onset.clone();
		if(this.progression == null)
			clone.progression = null;
		else
			clone.progression = (ims.nursing.vo.lookups.PainProgression)this.progression.clone();
		if(this.depth == null)
			clone.depth = null;
		else
			clone.depth = (ims.nursing.vo.lookups.PainDepth)this.depth.clone();
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
		if (!(PainAssessmentFindings.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PainAssessmentFindings object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PainAssessmentFindings compareObj = (PainAssessmentFindings)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PainAssessmentFindings() == null && compareObj.getID_PainAssessmentFindings() != null)
				return -1;
			if(this.getID_PainAssessmentFindings() != null && compareObj.getID_PainAssessmentFindings() == null)
				return 1;
			if(this.getID_PainAssessmentFindings() != null && compareObj.getID_PainAssessmentFindings() != null)
				retVal = this.getID_PainAssessmentFindings().compareTo(compareObj.getID_PainAssessmentFindings());
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
		if(this.siteimage != null)
			count++;
		if(this.sitename != null)
			count++;
		if(this.painhypersensitivity != null)
			count++;
		if(this.painassessmentreview != null)
			count++;
		if(this.isdiscontinuedassess != null)
			count++;
		if(this.iscontinuedassessment != null)
			count++;
		if(this.sitedetails != null)
			count++;
		if(this.type != null)
			count++;
		if(this.severity != null)
			count++;
		if(this.onset != null)
			count++;
		if(this.progression != null)
			count++;
		if(this.depth != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String siteimage;
	protected String sitename;
	protected ims.nursing.vo.lookups.PainHypersensitivity painhypersensitivity;
	protected ims.nursing.vo.PainAssessmentReviewCollection painassessmentreview;
	protected Boolean isdiscontinuedassess;
	protected Boolean iscontinuedassessment;
	protected String sitedetails;
	protected ims.nursing.vo.lookups.PainType type;
	protected ims.nursing.vo.lookups.PainSeverity severity;
	protected ims.nursing.vo.lookups.PainOnset onset;
	protected ims.nursing.vo.lookups.PainProgression progression;
	protected ims.nursing.vo.lookups.PainDepth depth;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
