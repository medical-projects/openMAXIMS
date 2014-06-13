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

package ims.clinical.vo.beans;

public class IntraOperativeDetailsVoBean extends ims.vo.ValueObjectBean
{
	public IntraOperativeDetailsVoBean()
	{
	}
	public IntraOperativeDetailsVoBean(ims.clinical.vo.IntraOperativeDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.skinpreparationused = vo.getSkinPreparationUsed() == null ? null : vo.getSkinPreparationUsed().getBeanCollection();
		this.dressing = vo.getDressing() == null ? null : vo.getDressing().getBeanCollection();
		this.mlsofwateriballoon = vo.getMlsOfWaterIballoon();
		this.nationaljointregistrycompleted = vo.getNationalJointRegistryCompleted() == null ? null : (ims.vo.LookupInstanceBean)vo.getNationalJointRegistryCompleted().getBean();
		this.diathermyplatedetail = vo.getDiathermyPlateDetail() == null ? null : (ims.clinical.vo.beans.DiathermyPlateDetailVoBean)vo.getDiathermyPlateDetail().getBean();
		this.limbcare = vo.getLimbCare() == null ? null : (ims.clinical.vo.beans.LimbCareVoBean)vo.getLimbCare().getBean();
		this.drains = vo.getDrains() == null ? null : (ims.clinical.vo.beans.DrainsVoBean)vo.getDrains().getBean();
		this.skinclosure = vo.getSkinClosure() == null ? null : vo.getSkinClosure().getBeanCollection();
		this.localanastheticused = vo.getLocalAnastheticUsed() == null ? null : vo.getLocalAnastheticUsed().getBeanCollection();
		this.patientposition = vo.getPatientPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientPosition().getBean();
		this.tourniquetdetail = vo.getTourniquetDetail() == null ? null : (ims.clinical.vo.beans.TourniquetDetailVoBean)vo.getTourniquetDetail().getBean();
		this.specimentype = vo.getSpecimenType();
		this.histopathology = vo.getHistopathology();
		this.microbiology = vo.getMicrobiology();
		this.haematology = vo.getHaematology();
		this.cytology = vo.getCytology();
		this.catheterdetail = vo.getCatheterDetail() == null ? null : (ims.clinical.vo.beans.CatheterDetailVoBean)vo.getCatheterDetail().getBean();
		this.otherskinpreparationused = vo.getOtherSkinPreparationUsed();
		this.nationaljointregistrycompletedby = vo.getNationalJointRegistryCompletedBy() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getNationalJointRegistryCompletedBy().getBean();
		this.diathermyplatedetailsitetwo = vo.getDiathermyPlateDetailSiteTwo() == null ? null : (ims.clinical.vo.beans.DiathermyPlateDetailVoBean)vo.getDiathermyPlateDetailSiteTwo().getBean();
		this.swabcount = vo.getSwabCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getSwabCount().getBean();
		this.needlecount = vo.getNeedleCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedleCount().getBean();
		this.instrumentcount = vo.getInstrumentCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getInstrumentCount().getBean();
		this.scrubnurse = vo.getScrubNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getScrubNurse().getBean();
		this.circulatingnurse = vo.getCirculatingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getCirculatingNurse().getBean();
		this.countcomments = vo.getCountComments();
		this.tabledevices = vo.getTableDevices() == null ? null : vo.getTableDevices().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.IntraOperativeDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.skinpreparationused = vo.getSkinPreparationUsed() == null ? null : vo.getSkinPreparationUsed().getBeanCollection();
		this.dressing = vo.getDressing() == null ? null : vo.getDressing().getBeanCollection();
		this.mlsofwateriballoon = vo.getMlsOfWaterIballoon();
		this.nationaljointregistrycompleted = vo.getNationalJointRegistryCompleted() == null ? null : (ims.vo.LookupInstanceBean)vo.getNationalJointRegistryCompleted().getBean();
		this.diathermyplatedetail = vo.getDiathermyPlateDetail() == null ? null : (ims.clinical.vo.beans.DiathermyPlateDetailVoBean)vo.getDiathermyPlateDetail().getBean(map);
		this.limbcare = vo.getLimbCare() == null ? null : (ims.clinical.vo.beans.LimbCareVoBean)vo.getLimbCare().getBean(map);
		this.drains = vo.getDrains() == null ? null : (ims.clinical.vo.beans.DrainsVoBean)vo.getDrains().getBean(map);
		this.skinclosure = vo.getSkinClosure() == null ? null : vo.getSkinClosure().getBeanCollection();
		this.localanastheticused = vo.getLocalAnastheticUsed() == null ? null : vo.getLocalAnastheticUsed().getBeanCollection();
		this.patientposition = vo.getPatientPosition() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientPosition().getBean();
		this.tourniquetdetail = vo.getTourniquetDetail() == null ? null : (ims.clinical.vo.beans.TourniquetDetailVoBean)vo.getTourniquetDetail().getBean(map);
		this.specimentype = vo.getSpecimenType();
		this.histopathology = vo.getHistopathology();
		this.microbiology = vo.getMicrobiology();
		this.haematology = vo.getHaematology();
		this.cytology = vo.getCytology();
		this.catheterdetail = vo.getCatheterDetail() == null ? null : (ims.clinical.vo.beans.CatheterDetailVoBean)vo.getCatheterDetail().getBean(map);
		this.otherskinpreparationused = vo.getOtherSkinPreparationUsed();
		this.nationaljointregistrycompletedby = vo.getNationalJointRegistryCompletedBy() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getNationalJointRegistryCompletedBy().getBean(map);
		this.diathermyplatedetailsitetwo = vo.getDiathermyPlateDetailSiteTwo() == null ? null : (ims.clinical.vo.beans.DiathermyPlateDetailVoBean)vo.getDiathermyPlateDetailSiteTwo().getBean(map);
		this.swabcount = vo.getSwabCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getSwabCount().getBean();
		this.needlecount = vo.getNeedleCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeedleCount().getBean();
		this.instrumentcount = vo.getInstrumentCount() == null ? null : (ims.vo.LookupInstanceBean)vo.getInstrumentCount().getBean();
		this.scrubnurse = vo.getScrubNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getScrubNurse().getBean(map);
		this.circulatingnurse = vo.getCirculatingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getCirculatingNurse().getBean(map);
		this.countcomments = vo.getCountComments();
		this.tabledevices = vo.getTableDevices() == null ? null : vo.getTableDevices().getBeanCollection();
	}

	public ims.clinical.vo.IntraOperativeDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.IntraOperativeDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.IntraOperativeDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.IntraOperativeDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.IntraOperativeDetailsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public java.util.Collection getSkinPreparationUsed()
	{
		return this.skinpreparationused;
	}
	public void setSkinPreparationUsed(java.util.Collection value)
	{
		this.skinpreparationused = value;
	}
	public void addSkinPreparationUsed(java.util.Collection value)
	{
		if(this.skinpreparationused == null)
			this.skinpreparationused = new java.util.ArrayList();
		this.skinpreparationused.add(value);
	}
	public java.util.Collection getDressing()
	{
		return this.dressing;
	}
	public void setDressing(java.util.Collection value)
	{
		this.dressing = value;
	}
	public void addDressing(java.util.Collection value)
	{
		if(this.dressing == null)
			this.dressing = new java.util.ArrayList();
		this.dressing.add(value);
	}
	public Integer getMlsOfWaterIballoon()
	{
		return this.mlsofwateriballoon;
	}
	public void setMlsOfWaterIballoon(Integer value)
	{
		this.mlsofwateriballoon = value;
	}
	public ims.vo.LookupInstanceBean getNationalJointRegistryCompleted()
	{
		return this.nationaljointregistrycompleted;
	}
	public void setNationalJointRegistryCompleted(ims.vo.LookupInstanceBean value)
	{
		this.nationaljointregistrycompleted = value;
	}
	public ims.clinical.vo.beans.DiathermyPlateDetailVoBean getDiathermyPlateDetail()
	{
		return this.diathermyplatedetail;
	}
	public void setDiathermyPlateDetail(ims.clinical.vo.beans.DiathermyPlateDetailVoBean value)
	{
		this.diathermyplatedetail = value;
	}
	public ims.clinical.vo.beans.LimbCareVoBean getLimbCare()
	{
		return this.limbcare;
	}
	public void setLimbCare(ims.clinical.vo.beans.LimbCareVoBean value)
	{
		this.limbcare = value;
	}
	public ims.clinical.vo.beans.DrainsVoBean getDrains()
	{
		return this.drains;
	}
	public void setDrains(ims.clinical.vo.beans.DrainsVoBean value)
	{
		this.drains = value;
	}
	public java.util.Collection getSkinClosure()
	{
		return this.skinclosure;
	}
	public void setSkinClosure(java.util.Collection value)
	{
		this.skinclosure = value;
	}
	public void addSkinClosure(java.util.Collection value)
	{
		if(this.skinclosure == null)
			this.skinclosure = new java.util.ArrayList();
		this.skinclosure.add(value);
	}
	public ims.clinical.vo.beans.LocalAnaestheticAdministeredVoBean[] getLocalAnastheticUsed()
	{
		return this.localanastheticused;
	}
	public void setLocalAnastheticUsed(ims.clinical.vo.beans.LocalAnaestheticAdministeredVoBean[] value)
	{
		this.localanastheticused = value;
	}
	public ims.vo.LookupInstanceBean getPatientPosition()
	{
		return this.patientposition;
	}
	public void setPatientPosition(ims.vo.LookupInstanceBean value)
	{
		this.patientposition = value;
	}
	public ims.clinical.vo.beans.TourniquetDetailVoBean getTourniquetDetail()
	{
		return this.tourniquetdetail;
	}
	public void setTourniquetDetail(ims.clinical.vo.beans.TourniquetDetailVoBean value)
	{
		this.tourniquetdetail = value;
	}
	public String getSpecimenType()
	{
		return this.specimentype;
	}
	public void setSpecimenType(String value)
	{
		this.specimentype = value;
	}
	public Boolean getHistopathology()
	{
		return this.histopathology;
	}
	public void setHistopathology(Boolean value)
	{
		this.histopathology = value;
	}
	public Boolean getMicrobiology()
	{
		return this.microbiology;
	}
	public void setMicrobiology(Boolean value)
	{
		this.microbiology = value;
	}
	public Boolean getHaematology()
	{
		return this.haematology;
	}
	public void setHaematology(Boolean value)
	{
		this.haematology = value;
	}
	public Boolean getCytology()
	{
		return this.cytology;
	}
	public void setCytology(Boolean value)
	{
		this.cytology = value;
	}
	public ims.clinical.vo.beans.CatheterDetailVoBean getCatheterDetail()
	{
		return this.catheterdetail;
	}
	public void setCatheterDetail(ims.clinical.vo.beans.CatheterDetailVoBean value)
	{
		this.catheterdetail = value;
	}
	public String getOtherSkinPreparationUsed()
	{
		return this.otherskinpreparationused;
	}
	public void setOtherSkinPreparationUsed(String value)
	{
		this.otherskinpreparationused = value;
	}
	public ims.core.vo.beans.NurseVoBean getNationalJointRegistryCompletedBy()
	{
		return this.nationaljointregistrycompletedby;
	}
	public void setNationalJointRegistryCompletedBy(ims.core.vo.beans.NurseVoBean value)
	{
		this.nationaljointregistrycompletedby = value;
	}
	public ims.clinical.vo.beans.DiathermyPlateDetailVoBean getDiathermyPlateDetailSiteTwo()
	{
		return this.diathermyplatedetailsitetwo;
	}
	public void setDiathermyPlateDetailSiteTwo(ims.clinical.vo.beans.DiathermyPlateDetailVoBean value)
	{
		this.diathermyplatedetailsitetwo = value;
	}
	public ims.vo.LookupInstanceBean getSwabCount()
	{
		return this.swabcount;
	}
	public void setSwabCount(ims.vo.LookupInstanceBean value)
	{
		this.swabcount = value;
	}
	public ims.vo.LookupInstanceBean getNeedleCount()
	{
		return this.needlecount;
	}
	public void setNeedleCount(ims.vo.LookupInstanceBean value)
	{
		this.needlecount = value;
	}
	public ims.vo.LookupInstanceBean getInstrumentCount()
	{
		return this.instrumentcount;
	}
	public void setInstrumentCount(ims.vo.LookupInstanceBean value)
	{
		this.instrumentcount = value;
	}
	public ims.core.vo.beans.NurseVoBean getScrubNurse()
	{
		return this.scrubnurse;
	}
	public void setScrubNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.scrubnurse = value;
	}
	public ims.core.vo.beans.NurseVoBean getCirculatingNurse()
	{
		return this.circulatingnurse;
	}
	public void setCirculatingNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.circulatingnurse = value;
	}
	public String getCountComments()
	{
		return this.countcomments;
	}
	public void setCountComments(String value)
	{
		this.countcomments = value;
	}
	public ims.clinical.vo.beans.TableDeviceVoBean[] getTableDevices()
	{
		return this.tabledevices;
	}
	public void setTableDevices(ims.clinical.vo.beans.TableDeviceVoBean[] value)
	{
		this.tabledevices = value;
	}

	private Integer id;
	private int version;
	private java.util.Collection skinpreparationused;
	private java.util.Collection dressing;
	private Integer mlsofwateriballoon;
	private ims.vo.LookupInstanceBean nationaljointregistrycompleted;
	private ims.clinical.vo.beans.DiathermyPlateDetailVoBean diathermyplatedetail;
	private ims.clinical.vo.beans.LimbCareVoBean limbcare;
	private ims.clinical.vo.beans.DrainsVoBean drains;
	private java.util.Collection skinclosure;
	private ims.clinical.vo.beans.LocalAnaestheticAdministeredVoBean[] localanastheticused;
	private ims.vo.LookupInstanceBean patientposition;
	private ims.clinical.vo.beans.TourniquetDetailVoBean tourniquetdetail;
	private String specimentype;
	private Boolean histopathology;
	private Boolean microbiology;
	private Boolean haematology;
	private Boolean cytology;
	private ims.clinical.vo.beans.CatheterDetailVoBean catheterdetail;
	private String otherskinpreparationused;
	private ims.core.vo.beans.NurseVoBean nationaljointregistrycompletedby;
	private ims.clinical.vo.beans.DiathermyPlateDetailVoBean diathermyplatedetailsitetwo;
	private ims.vo.LookupInstanceBean swabcount;
	private ims.vo.LookupInstanceBean needlecount;
	private ims.vo.LookupInstanceBean instrumentcount;
	private ims.core.vo.beans.NurseVoBean scrubnurse;
	private ims.core.vo.beans.NurseVoBean circulatingnurse;
	private String countcomments;
	private ims.clinical.vo.beans.TableDeviceVoBean[] tabledevices;
}
