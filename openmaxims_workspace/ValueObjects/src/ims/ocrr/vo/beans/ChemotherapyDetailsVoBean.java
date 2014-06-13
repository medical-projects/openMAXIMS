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

package ims.ocrr.vo.beans;

public class ChemotherapyDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ChemotherapyDetailsVoBean()
	{
	}
	public ChemotherapyDetailsVoBean(ims.ocrr.vo.ChemotherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.drugtherapytype = vo.getDrugTherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDrugTherapyType().getBean();
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean();
		this.txchangereason = vo.getTxChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTxChangeReason().getBean();
		this.pretreatsurfacearea = vo.getPreTreatSurfaceArea();
		this.creatinineclearance = vo.getCreatinineClearance();
		this.heightvaluecm = vo.getHeightValueCM();
		this.weightvaluekg = vo.getWeightValueKG();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.cycledetails = vo.getCycleDetails() == null ? null : vo.getCycleDetails().getBeanCollection();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.ccocycledetails = vo.getCCOCycleDetails() == null ? null : vo.getCCOCycleDetails().getBeanCollection();
		this.performancestatus = vo.getPerformanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatus().getBean();
		this.delayreason1 = vo.getDelayReason1() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason1().getBean();
		this.delayreason2 = vo.getDelayReason2() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason2().getBean();
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentSite().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.programmenr = vo.getProgrammeNr();
		this.regimennr = vo.getRegimenNr();
		this.comorbidityadjustment = vo.getComorbidityAdjustment() == null ? null : (ims.vo.LookupInstanceBean)vo.getComorbidityAdjustment().getBean();
		this.chemoradiation = vo.getChemoRadiation() == null ? null : (ims.vo.LookupInstanceBean)vo.getChemoRadiation().getBean();
		this.clinicaltrial = vo.getClinicalTrial() == null ? null : (ims.vo.LookupInstanceBean)vo.getClinicalTrial().getBean();
		this.plannedcycles = vo.getPlannedCycles();
		this.outcomedosereduction = vo.getOutcomeDoseReduction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeDoseReduction().getBean();
		this.outcometimedelay = vo.getOutcomeTimeDelay() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeTimeDelay().getBean();
		this.outcomestoppedearly = vo.getOutcomeStoppedEarly() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeStoppedEarly().getBean();
		this.outcomesummary = vo.getOutcomeSummary() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeSummary().getBean();
		this.prescribinghcp = vo.getPrescribingHCP() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getPrescribingHCP().getBean();
		this.prescribeddate = vo.getPrescribedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPrescribedDate().getBean();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.ChemotherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.drugtherapytype = vo.getDrugTherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDrugTherapyType().getBean();
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean(map);
		this.txchangereason = vo.getTxChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTxChangeReason().getBean();
		this.pretreatsurfacearea = vo.getPreTreatSurfaceArea();
		this.creatinineclearance = vo.getCreatinineClearance();
		this.heightvaluecm = vo.getHeightValueCM();
		this.weightvaluekg = vo.getWeightValueKG();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.cycledetails = vo.getCycleDetails() == null ? null : vo.getCycleDetails().getBeanCollection();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.ccocycledetails = vo.getCCOCycleDetails() == null ? null : vo.getCCOCycleDetails().getBeanCollection();
		this.performancestatus = vo.getPerformanceStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatus().getBean();
		this.delayreason1 = vo.getDelayReason1() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason1().getBean();
		this.delayreason2 = vo.getDelayReason2() == null ? null : (ims.vo.LookupInstanceBean)vo.getDelayReason2().getBean();
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentSite().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.programmenr = vo.getProgrammeNr();
		this.regimennr = vo.getRegimenNr();
		this.comorbidityadjustment = vo.getComorbidityAdjustment() == null ? null : (ims.vo.LookupInstanceBean)vo.getComorbidityAdjustment().getBean();
		this.chemoradiation = vo.getChemoRadiation() == null ? null : (ims.vo.LookupInstanceBean)vo.getChemoRadiation().getBean();
		this.clinicaltrial = vo.getClinicalTrial() == null ? null : (ims.vo.LookupInstanceBean)vo.getClinicalTrial().getBean();
		this.plannedcycles = vo.getPlannedCycles();
		this.outcomedosereduction = vo.getOutcomeDoseReduction() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeDoseReduction().getBean();
		this.outcometimedelay = vo.getOutcomeTimeDelay() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeTimeDelay().getBean();
		this.outcomestoppedearly = vo.getOutcomeStoppedEarly() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeStoppedEarly().getBean();
		this.outcomesummary = vo.getOutcomeSummary() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcomeSummary().getBean();
		this.prescribinghcp = vo.getPrescribingHCP() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getPrescribingHCP().getBean(map);
		this.prescribeddate = vo.getPrescribedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPrescribedDate().getBean();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public ims.ocrr.vo.ChemotherapyDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.ChemotherapyDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.ChemotherapyDetailsVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.ChemotherapyDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.ChemotherapyDetailsVo();
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
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.vo.LookupInstanceBean getDrugTherapyType()
	{
		return this.drugtherapytype;
	}
	public void setDrugTherapyType(ims.vo.LookupInstanceBean value)
	{
		this.drugtherapytype = value;
	}
	public ims.vo.LookupInstanceBean getRegimenAcronym()
	{
		return this.regimenacronym;
	}
	public void setRegimenAcronym(ims.vo.LookupInstanceBean value)
	{
		this.regimenacronym = value;
	}
	public ims.vo.LookupInstanceBean getCancerTreatementIntent()
	{
		return this.cancertreatementintent;
	}
	public void setCancerTreatementIntent(ims.vo.LookupInstanceBean value)
	{
		this.cancertreatementintent = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentResponse()
	{
		return this.treatmentresponse;
	}
	public void setTreatmentResponse(ims.vo.LookupInstanceBean value)
	{
		this.treatmentresponse = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.treatingconsultant = value;
	}
	public ims.vo.LookupInstanceBean getTxChangeReason()
	{
		return this.txchangereason;
	}
	public void setTxChangeReason(ims.vo.LookupInstanceBean value)
	{
		this.txchangereason = value;
	}
	public Float getPreTreatSurfaceArea()
	{
		return this.pretreatsurfacearea;
	}
	public void setPreTreatSurfaceArea(Float value)
	{
		this.pretreatsurfacearea = value;
	}
	public Float getCreatinineClearance()
	{
		return this.creatinineclearance;
	}
	public void setCreatinineClearance(Float value)
	{
		this.creatinineclearance = value;
	}
	public Float getHeightValueCM()
	{
		return this.heightvaluecm;
	}
	public void setHeightValueCM(Float value)
	{
		this.heightvaluecm = value;
	}
	public Float getWeightValueKG()
	{
		return this.weightvaluekg;
	}
	public void setWeightValueKG(Float value)
	{
		this.weightvaluekg = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean[] getCycleDetails()
	{
		return this.cycledetails;
	}
	public void setCycleDetails(ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean[] value)
	{
		this.cycledetails = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean[] getCCOCycleDetails()
	{
		return this.ccocycledetails;
	}
	public void setCCOCycleDetails(ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean[] value)
	{
		this.ccocycledetails = value;
	}
	public ims.vo.LookupInstanceBean getPerformanceStatus()
	{
		return this.performancestatus;
	}
	public void setPerformanceStatus(ims.vo.LookupInstanceBean value)
	{
		this.performancestatus = value;
	}
	public ims.vo.LookupInstanceBean getDelayReason1()
	{
		return this.delayreason1;
	}
	public void setDelayReason1(ims.vo.LookupInstanceBean value)
	{
		this.delayreason1 = value;
	}
	public ims.vo.LookupInstanceBean getDelayReason2()
	{
		return this.delayreason2;
	}
	public void setDelayReason2(ims.vo.LookupInstanceBean value)
	{
		this.delayreason2 = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.vo.LookupInstanceBean value)
	{
		this.treatmentsite = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public Integer getProgrammeNr()
	{
		return this.programmenr;
	}
	public void setProgrammeNr(Integer value)
	{
		this.programmenr = value;
	}
	public Integer getRegimenNr()
	{
		return this.regimennr;
	}
	public void setRegimenNr(Integer value)
	{
		this.regimennr = value;
	}
	public ims.vo.LookupInstanceBean getComorbidityAdjustment()
	{
		return this.comorbidityadjustment;
	}
	public void setComorbidityAdjustment(ims.vo.LookupInstanceBean value)
	{
		this.comorbidityadjustment = value;
	}
	public ims.vo.LookupInstanceBean getChemoRadiation()
	{
		return this.chemoradiation;
	}
	public void setChemoRadiation(ims.vo.LookupInstanceBean value)
	{
		this.chemoradiation = value;
	}
	public ims.vo.LookupInstanceBean getClinicalTrial()
	{
		return this.clinicaltrial;
	}
	public void setClinicalTrial(ims.vo.LookupInstanceBean value)
	{
		this.clinicaltrial = value;
	}
	public Integer getPlannedCycles()
	{
		return this.plannedcycles;
	}
	public void setPlannedCycles(Integer value)
	{
		this.plannedcycles = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeDoseReduction()
	{
		return this.outcomedosereduction;
	}
	public void setOutcomeDoseReduction(ims.vo.LookupInstanceBean value)
	{
		this.outcomedosereduction = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeTimeDelay()
	{
		return this.outcometimedelay;
	}
	public void setOutcomeTimeDelay(ims.vo.LookupInstanceBean value)
	{
		this.outcometimedelay = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeStoppedEarly()
	{
		return this.outcomestoppedearly;
	}
	public void setOutcomeStoppedEarly(ims.vo.LookupInstanceBean value)
	{
		this.outcomestoppedearly = value;
	}
	public ims.vo.LookupInstanceBean getOutcomeSummary()
	{
		return this.outcomesummary;
	}
	public void setOutcomeSummary(ims.vo.LookupInstanceBean value)
	{
		this.outcomesummary = value;
	}
	public ims.core.vo.beans.MedicVoBean getPrescribingHCP()
	{
		return this.prescribinghcp;
	}
	public void setPrescribingHCP(ims.core.vo.beans.MedicVoBean value)
	{
		this.prescribinghcp = value;
	}
	public ims.framework.utils.beans.DateBean getPrescribedDate()
	{
		return this.prescribeddate;
	}
	public void setPrescribedDate(ims.framework.utils.beans.DateBean value)
	{
		this.prescribeddate = value;
	}
	public ims.vo.RefVoBean getAssociatedTreatmentPlanAction()
	{
		return this.associatedtreatmentplanaction;
	}
	public void setAssociatedTreatmentPlanAction(ims.vo.RefVoBean value)
	{
		this.associatedtreatmentplanaction = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.vo.LookupInstanceBean drugtherapytype;
	private ims.vo.LookupInstanceBean regimenacronym;
	private ims.vo.LookupInstanceBean cancertreatementintent;
	private ims.vo.LookupInstanceBean treatmentresponse;
	private ims.core.vo.beans.HcpLiteVoBean treatingconsultant;
	private ims.vo.LookupInstanceBean txchangereason;
	private Float pretreatsurfacearea;
	private Float creatinineclearance;
	private Float heightvaluecm;
	private Float weightvaluekg;
	private ims.vo.LookupInstanceBean status;
	private ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean[] cycledetails;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.oncology.vo.beans.ChemoCycleDetailsCCOVoBean[] ccocycledetails;
	private ims.vo.LookupInstanceBean performancestatus;
	private ims.vo.LookupInstanceBean delayreason1;
	private ims.vo.LookupInstanceBean delayreason2;
	private ims.vo.LookupInstanceBean treatmentsite;
	private ims.framework.utils.beans.DateBean enddate;
	private Integer programmenr;
	private Integer regimennr;
	private ims.vo.LookupInstanceBean comorbidityadjustment;
	private ims.vo.LookupInstanceBean chemoradiation;
	private ims.vo.LookupInstanceBean clinicaltrial;
	private Integer plannedcycles;
	private ims.vo.LookupInstanceBean outcomedosereduction;
	private ims.vo.LookupInstanceBean outcometimedelay;
	private ims.vo.LookupInstanceBean outcomestoppedearly;
	private ims.vo.LookupInstanceBean outcomesummary;
	private ims.core.vo.beans.MedicVoBean prescribinghcp;
	private ims.framework.utils.beans.DateBean prescribeddate;
	private ims.vo.RefVoBean associatedtreatmentplanaction;
}
