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

package ims.clinicaladmin.vo;


public class SelectedRecordForOverallStagingDialogVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SelectedRecordForOverallStagingDialogVo()
	{
	}
	public SelectedRecordForOverallStagingDialogVo(ims.clinicaladmin.vo.beans.SelectedRecordForOverallStagingDialogVoBean bean)
	{
		this.tnmvalues = ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection.buildFromBeanCollection(bean.getTNMValues());
		this.histologyvalue = bean.getHistologyValue() == null ? null : bean.getHistologyValue().buildVo();
		this.serummarker = bean.getSerumMarker() == null ? null : bean.getSerumMarker().buildVo();
		this.over45 = bean.getOver45();
		this.differentationvalue = bean.getDifferentationValue() == null ? null : bean.getDifferentationValue().buildVo();
		this.overallvalue = bean.getOverallValue() == null ? null : ims.oncology.vo.lookups.TumourOverallStage.buildLookup(bean.getOverallValue());
		this.selectedsiterecord = bean.getSelectedSiteRecord() == null ? null : new ims.oncology.configuration.vo.TumourSiteRefVo(new Integer(bean.getSelectedSiteRecord().getId()), bean.getSelectedSiteRecord().getVersion());
		this.selectedgrouprecord = bean.getSelectedGroupRecord() == null ? null : new ims.oncology.configuration.vo.TumourGroupRefVo(new Integer(bean.getSelectedGroupRecord().getId()), bean.getSelectedGroupRecord().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.SelectedRecordForOverallStagingDialogVoBean bean)
	{
		this.tnmvalues = ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection.buildFromBeanCollection(bean.getTNMValues());
		this.histologyvalue = bean.getHistologyValue() == null ? null : bean.getHistologyValue().buildVo(map);
		this.serummarker = bean.getSerumMarker() == null ? null : bean.getSerumMarker().buildVo(map);
		this.over45 = bean.getOver45();
		this.differentationvalue = bean.getDifferentationValue() == null ? null : bean.getDifferentationValue().buildVo(map);
		this.overallvalue = bean.getOverallValue() == null ? null : ims.oncology.vo.lookups.TumourOverallStage.buildLookup(bean.getOverallValue());
		this.selectedsiterecord = bean.getSelectedSiteRecord() == null ? null : new ims.oncology.configuration.vo.TumourSiteRefVo(new Integer(bean.getSelectedSiteRecord().getId()), bean.getSelectedSiteRecord().getVersion());
		this.selectedgrouprecord = bean.getSelectedGroupRecord() == null ? null : new ims.oncology.configuration.vo.TumourGroupRefVo(new Integer(bean.getSelectedGroupRecord().getId()), bean.getSelectedGroupRecord().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.SelectedRecordForOverallStagingDialogVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.SelectedRecordForOverallStagingDialogVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.SelectedRecordForOverallStagingDialogVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getTNMValuesIsNotNull()
	{
		return this.tnmvalues != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection getTNMValues()
	{
		return this.tnmvalues;
	}
	public void setTNMValues(ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection value)
	{
		this.isValidated = false;
		this.tnmvalues = value;
	}
	public boolean getHistologyValueIsNotNull()
	{
		return this.histologyvalue != null;
	}
	public ims.clinicaladmin.vo.TumourGroupHistologyVo getHistologyValue()
	{
		return this.histologyvalue;
	}
	public void setHistologyValue(ims.clinicaladmin.vo.TumourGroupHistologyVo value)
	{
		this.isValidated = false;
		this.histologyvalue = value;
	}
	public boolean getSerumMarkerIsNotNull()
	{
		return this.serummarker != null;
	}
	public ims.clinicaladmin.vo.TumourSerumMarkersLiteVo getSerumMarker()
	{
		return this.serummarker;
	}
	public void setSerumMarker(ims.clinicaladmin.vo.TumourSerumMarkersLiteVo value)
	{
		this.isValidated = false;
		this.serummarker = value;
	}
	public boolean getOver45IsNotNull()
	{
		return this.over45 != null;
	}
	public Boolean getOver45()
	{
		return this.over45;
	}
	public void setOver45(Boolean value)
	{
		this.isValidated = false;
		this.over45 = value;
	}
	public boolean getDifferentationValueIsNotNull()
	{
		return this.differentationvalue != null;
	}
	public ims.clinicaladmin.vo.TumourGroupHistopathologyGradeVo getDifferentationValue()
	{
		return this.differentationvalue;
	}
	public void setDifferentationValue(ims.clinicaladmin.vo.TumourGroupHistopathologyGradeVo value)
	{
		this.isValidated = false;
		this.differentationvalue = value;
	}
	public boolean getOverallValueIsNotNull()
	{
		return this.overallvalue != null;
	}
	public ims.oncology.vo.lookups.TumourOverallStage getOverallValue()
	{
		return this.overallvalue;
	}
	public void setOverallValue(ims.oncology.vo.lookups.TumourOverallStage value)
	{
		this.isValidated = false;
		this.overallvalue = value;
	}
	public boolean getSelectedSiteRecordIsNotNull()
	{
		return this.selectedsiterecord != null;
	}
	public ims.oncology.configuration.vo.TumourSiteRefVo getSelectedSiteRecord()
	{
		return this.selectedsiterecord;
	}
	public void setSelectedSiteRecord(ims.oncology.configuration.vo.TumourSiteRefVo value)
	{
		this.isValidated = false;
		this.selectedsiterecord = value;
	}
	public boolean getSelectedGroupRecordIsNotNull()
	{
		return this.selectedgrouprecord != null;
	}
	public ims.oncology.configuration.vo.TumourGroupRefVo getSelectedGroupRecord()
	{
		return this.selectedgrouprecord;
	}
	public void setSelectedGroupRecord(ims.oncology.configuration.vo.TumourGroupRefVo value)
	{
		this.isValidated = false;
		this.selectedgrouprecord = value;
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
		if(this.tnmvalues != null)
		{
			if(!this.tnmvalues.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.histologyvalue != null)
		{
			if(!this.histologyvalue.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.serummarker != null)
		{
			if(!this.serummarker.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.differentationvalue != null)
		{
			if(!this.differentationvalue.isValidated())
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
		if(this.tnmvalues != null)
		{
			String[] listOfOtherErrors = this.tnmvalues.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.histologyvalue != null)
		{
			String[] listOfOtherErrors = this.histologyvalue.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.serummarker != null)
		{
			String[] listOfOtherErrors = this.serummarker.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.differentationvalue != null)
		{
			String[] listOfOtherErrors = this.differentationvalue.validate();
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
	
		SelectedRecordForOverallStagingDialogVo clone = new SelectedRecordForOverallStagingDialogVo();
		
		if(this.tnmvalues == null)
			clone.tnmvalues = null;
		else
			clone.tnmvalues = (ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection)this.tnmvalues.clone();
		if(this.histologyvalue == null)
			clone.histologyvalue = null;
		else
			clone.histologyvalue = (ims.clinicaladmin.vo.TumourGroupHistologyVo)this.histologyvalue.clone();
		if(this.serummarker == null)
			clone.serummarker = null;
		else
			clone.serummarker = (ims.clinicaladmin.vo.TumourSerumMarkersLiteVo)this.serummarker.clone();
		clone.over45 = this.over45;
		if(this.differentationvalue == null)
			clone.differentationvalue = null;
		else
			clone.differentationvalue = (ims.clinicaladmin.vo.TumourGroupHistopathologyGradeVo)this.differentationvalue.clone();
		if(this.overallvalue == null)
			clone.overallvalue = null;
		else
			clone.overallvalue = (ims.oncology.vo.lookups.TumourOverallStage)this.overallvalue.clone();
		clone.selectedsiterecord = this.selectedsiterecord;
		clone.selectedgrouprecord = this.selectedgrouprecord;
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
		if (!(SelectedRecordForOverallStagingDialogVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SelectedRecordForOverallStagingDialogVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SelectedRecordForOverallStagingDialogVo compareObj = (SelectedRecordForOverallStagingDialogVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTNMValues() == null && compareObj.getTNMValues() != null)
				return -1;
			if(this.getTNMValues() != null && compareObj.getTNMValues() == null)
				return 1;
			if(this.getTNMValues() != null && compareObj.getTNMValues() != null)
				retVal = this.getTNMValues().compareTo(compareObj.getTNMValues());
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
		if(this.tnmvalues != null)
			count++;
		if(this.histologyvalue != null)
			count++;
		if(this.serummarker != null)
			count++;
		if(this.over45 != null)
			count++;
		if(this.differentationvalue != null)
			count++;
		if(this.overallvalue != null)
			count++;
		if(this.selectedsiterecord != null)
			count++;
		if(this.selectedgrouprecord != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection tnmvalues;
	protected ims.clinicaladmin.vo.TumourGroupHistologyVo histologyvalue;
	protected ims.clinicaladmin.vo.TumourSerumMarkersLiteVo serummarker;
	protected Boolean over45;
	protected ims.clinicaladmin.vo.TumourGroupHistopathologyGradeVo differentationvalue;
	protected ims.oncology.vo.lookups.TumourOverallStage overallvalue;
	protected ims.oncology.configuration.vo.TumourSiteRefVo selectedsiterecord;
	protected ims.oncology.configuration.vo.TumourGroupRefVo selectedgrouprecord;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
