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

package ims.emergency.vo.beans;

public class AttendanceKPIConfigVoBean extends ims.vo.ValueObjectBean
{
	public AttendanceKPIConfigVoBean()
	{
	}
	public AttendanceKPIConfigVoBean(ims.emergency.vo.AttendanceKPIConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.awaitingtriagebreachwarningkpi = vo.getAwaitingTriageBreachWarningKPI();
		this.awaitingtriagebreachedkpi = vo.getAwaitingTriageBreachedKPI();
		this.triageprioritykpis = vo.getTriagePriorityKPIs() == null ? null : vo.getTriagePriorityKPIs().getBeanCollection();
		this.awaitingclinicianbreachwarningkpi = vo.getAwaitingClinicianBreachWarningKPI();
		this.awaitingclinicianbreachedkpi = vo.getAwaitingClinicianBreachedKPI();
		this.losbreachwarningkpi = vo.getLosBreachWarningKPI();
		this.losbreachedkpi = vo.getLosBreachedKPI();
		this.awaitingtriagebreachwarningkpitextcolour = vo.getAwaitingTriageBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPITextColour().getBean();
		this.awaitingtriagebreachwarningkpiflashingtext = vo.getAwaitingTriageBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachWarningKPIFlashingText().getBean();
		this.awaitingtriagebreachwarningkpiflashingtextcolour = vo.getAwaitingTriageBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachwarningkpibackgroundcolour = vo.getAwaitingTriageBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIBackgroundColour().getBean();
		this.awaitingtriagebreachkpitextcolour = vo.getAwaitingTriageBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPITextColour().getBean();
		this.awaitingtriagebreachkpiflashingtext = vo.getAwaitingTriageBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachKPIFlashingText().getBean();
		this.awaitingtriagebreachkpiflashingtextcolour = vo.getAwaitingTriageBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachkpibackgroundcolour = vo.getAwaitingTriageBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIBackgroundColour().getBean();
		this.awaitingclinicianbreachwarningkpitextcolour = vo.getAwaitingClinicianBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPITextColour().getBean();
		this.awaitingclinicianbreachwarningkpiflashingtext = vo.getAwaitingClinicianBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingClinicianBreachWarningKPIFlashingText().getBean();
		this.awaitingclinicianbreachwarningkpiflashingtextcolour = vo.getAwaitingClinicianBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingclinicianbreachwarningkpibackgroundcolour = vo.getAwaitingClinicianBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPIBackgroundColour().getBean();
		this.awaitingclinicianbreachkpitextcolour = vo.getAwaitingClinicianBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPITextColour().getBean();
		this.awaitingclinicianbreachkpiflashingtext = vo.getAwaitingClinicianBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingClinicianBreachKPIFlashingText().getBean();
		this.awaitingclinicianbreachkpiflashingtextcolour = vo.getAwaitingClinicianBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPIFlashingTextColour().getBean();
		this.awaitingclinicianbreachkpibackgroundcolour = vo.getAwaitingClinicianBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPIBackgroundColour().getBean();
		this.losbreachwarningkpitextcolour = vo.getLosBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPITextColour().getBean();
		this.losbreachwarningkpiflashingtext = vo.getLosBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getLosBreachWarningKPIFlashingText().getBean();
		this.losbreachwarningkpiflashingtextcolour = vo.getLosBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPIFlashingTextColour().getBean();
		this.losbreachwarningkpibackgroundcolour = vo.getLosBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPIBackgroundColour().getBean();
		this.losbreachkpitextcolour = vo.getLosBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachKPITextColour().getBean();
		this.losbreachedkpiflashingtext = vo.getLosBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getLosBreachedKPIFlashingText().getBean();
		this.losbreachedkpiflashingtextcolour = vo.getLosBreachedKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachedKPIFlashingTextColour().getBean();
		this.losbreachedkpibackgroundcolour = vo.getLosBreachedKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachedKPIBackgroundColour().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AttendanceKPIConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.awaitingtriagebreachwarningkpi = vo.getAwaitingTriageBreachWarningKPI();
		this.awaitingtriagebreachedkpi = vo.getAwaitingTriageBreachedKPI();
		this.triageprioritykpis = vo.getTriagePriorityKPIs() == null ? null : vo.getTriagePriorityKPIs().getBeanCollection();
		this.awaitingclinicianbreachwarningkpi = vo.getAwaitingClinicianBreachWarningKPI();
		this.awaitingclinicianbreachedkpi = vo.getAwaitingClinicianBreachedKPI();
		this.losbreachwarningkpi = vo.getLosBreachWarningKPI();
		this.losbreachedkpi = vo.getLosBreachedKPI();
		this.awaitingtriagebreachwarningkpitextcolour = vo.getAwaitingTriageBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPITextColour().getBean();
		this.awaitingtriagebreachwarningkpiflashingtext = vo.getAwaitingTriageBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachWarningKPIFlashingText().getBean();
		this.awaitingtriagebreachwarningkpiflashingtextcolour = vo.getAwaitingTriageBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachwarningkpibackgroundcolour = vo.getAwaitingTriageBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIBackgroundColour().getBean();
		this.awaitingtriagebreachkpitextcolour = vo.getAwaitingTriageBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPITextColour().getBean();
		this.awaitingtriagebreachkpiflashingtext = vo.getAwaitingTriageBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachKPIFlashingText().getBean();
		this.awaitingtriagebreachkpiflashingtextcolour = vo.getAwaitingTriageBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachkpibackgroundcolour = vo.getAwaitingTriageBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIBackgroundColour().getBean();
		this.awaitingclinicianbreachwarningkpitextcolour = vo.getAwaitingClinicianBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPITextColour().getBean();
		this.awaitingclinicianbreachwarningkpiflashingtext = vo.getAwaitingClinicianBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingClinicianBreachWarningKPIFlashingText().getBean();
		this.awaitingclinicianbreachwarningkpiflashingtextcolour = vo.getAwaitingClinicianBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingclinicianbreachwarningkpibackgroundcolour = vo.getAwaitingClinicianBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachWarningKPIBackgroundColour().getBean();
		this.awaitingclinicianbreachkpitextcolour = vo.getAwaitingClinicianBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPITextColour().getBean();
		this.awaitingclinicianbreachkpiflashingtext = vo.getAwaitingClinicianBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingClinicianBreachKPIFlashingText().getBean();
		this.awaitingclinicianbreachkpiflashingtextcolour = vo.getAwaitingClinicianBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPIFlashingTextColour().getBean();
		this.awaitingclinicianbreachkpibackgroundcolour = vo.getAwaitingClinicianBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingClinicianBreachKPIBackgroundColour().getBean();
		this.losbreachwarningkpitextcolour = vo.getLosBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPITextColour().getBean();
		this.losbreachwarningkpiflashingtext = vo.getLosBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getLosBreachWarningKPIFlashingText().getBean();
		this.losbreachwarningkpiflashingtextcolour = vo.getLosBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPIFlashingTextColour().getBean();
		this.losbreachwarningkpibackgroundcolour = vo.getLosBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachWarningKPIBackgroundColour().getBean();
		this.losbreachkpitextcolour = vo.getLosBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachKPITextColour().getBean();
		this.losbreachedkpiflashingtext = vo.getLosBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getLosBreachedKPIFlashingText().getBean();
		this.losbreachedkpiflashingtextcolour = vo.getLosBreachedKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachedKPIFlashingTextColour().getBean();
		this.losbreachedkpibackgroundcolour = vo.getLosBreachedKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLosBreachedKPIBackgroundColour().getBean();
	}

	public ims.emergency.vo.AttendanceKPIConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AttendanceKPIConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AttendanceKPIConfigVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AttendanceKPIConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AttendanceKPIConfigVo();
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
	public ims.vo.RefVoBean getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.vo.RefVoBean value)
	{
		this.edlocation = value;
	}
	public Integer getAwaitingTriageBreachWarningKPI()
	{
		return this.awaitingtriagebreachwarningkpi;
	}
	public void setAwaitingTriageBreachWarningKPI(Integer value)
	{
		this.awaitingtriagebreachwarningkpi = value;
	}
	public Integer getAwaitingTriageBreachedKPI()
	{
		return this.awaitingtriagebreachedkpi;
	}
	public void setAwaitingTriageBreachedKPI(Integer value)
	{
		this.awaitingtriagebreachedkpi = value;
	}
	public ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] getTriagePriorityKPIs()
	{
		return this.triageprioritykpis;
	}
	public void setTriagePriorityKPIs(ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] value)
	{
		this.triageprioritykpis = value;
	}
	public Integer getAwaitingClinicianBreachWarningKPI()
	{
		return this.awaitingclinicianbreachwarningkpi;
	}
	public void setAwaitingClinicianBreachWarningKPI(Integer value)
	{
		this.awaitingclinicianbreachwarningkpi = value;
	}
	public Integer getAwaitingClinicianBreachedKPI()
	{
		return this.awaitingclinicianbreachedkpi;
	}
	public void setAwaitingClinicianBreachedKPI(Integer value)
	{
		this.awaitingclinicianbreachedkpi = value;
	}
	public Integer getLosBreachWarningKPI()
	{
		return this.losbreachwarningkpi;
	}
	public void setLosBreachWarningKPI(Integer value)
	{
		this.losbreachwarningkpi = value;
	}
	public Integer getLosBreachedKPI()
	{
		return this.losbreachedkpi;
	}
	public void setLosBreachedKPI(Integer value)
	{
		this.losbreachedkpi = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPITextColour()
	{
		return this.awaitingtriagebreachwarningkpitextcolour;
	}
	public void setAwaitingTriageBreachWarningKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingTriageBreachWarningKPIFlashingText()
	{
		return this.awaitingtriagebreachwarningkpiflashingtext;
	}
	public void setAwaitingTriageBreachWarningKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingtriagebreachwarningkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPIFlashingTextColour()
	{
		return this.awaitingtriagebreachwarningkpiflashingtextcolour;
	}
	public void setAwaitingTriageBreachWarningKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPIBackgroundColour()
	{
		return this.awaitingtriagebreachwarningkpibackgroundcolour;
	}
	public void setAwaitingTriageBreachWarningKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPITextColour()
	{
		return this.awaitingtriagebreachkpitextcolour;
	}
	public void setAwaitingTriageBreachKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingTriageBreachKPIFlashingText()
	{
		return this.awaitingtriagebreachkpiflashingtext;
	}
	public void setAwaitingTriageBreachKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingtriagebreachkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPIFlashingTextColour()
	{
		return this.awaitingtriagebreachkpiflashingtextcolour;
	}
	public void setAwaitingTriageBreachKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPIBackgroundColour()
	{
		return this.awaitingtriagebreachkpibackgroundcolour;
	}
	public void setAwaitingTriageBreachKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachWarningKPITextColour()
	{
		return this.awaitingclinicianbreachwarningkpitextcolour;
	}
	public void setAwaitingClinicianBreachWarningKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachwarningkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingClinicianBreachWarningKPIFlashingText()
	{
		return this.awaitingclinicianbreachwarningkpiflashingtext;
	}
	public void setAwaitingClinicianBreachWarningKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingclinicianbreachwarningkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachWarningKPIFlashingTextColour()
	{
		return this.awaitingclinicianbreachwarningkpiflashingtextcolour;
	}
	public void setAwaitingClinicianBreachWarningKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachwarningkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachWarningKPIBackgroundColour()
	{
		return this.awaitingclinicianbreachwarningkpibackgroundcolour;
	}
	public void setAwaitingClinicianBreachWarningKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachwarningkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachKPITextColour()
	{
		return this.awaitingclinicianbreachkpitextcolour;
	}
	public void setAwaitingClinicianBreachKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingClinicianBreachKPIFlashingText()
	{
		return this.awaitingclinicianbreachkpiflashingtext;
	}
	public void setAwaitingClinicianBreachKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingclinicianbreachkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachKPIFlashingTextColour()
	{
		return this.awaitingclinicianbreachkpiflashingtextcolour;
	}
	public void setAwaitingClinicianBreachKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingClinicianBreachKPIBackgroundColour()
	{
		return this.awaitingclinicianbreachkpibackgroundcolour;
	}
	public void setAwaitingClinicianBreachKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingclinicianbreachkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachWarningKPITextColour()
	{
		return this.losbreachwarningkpitextcolour;
	}
	public void setLosBreachWarningKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachwarningkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getLosBreachWarningKPIFlashingText()
	{
		return this.losbreachwarningkpiflashingtext;
	}
	public void setLosBreachWarningKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.losbreachwarningkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachWarningKPIFlashingTextColour()
	{
		return this.losbreachwarningkpiflashingtextcolour;
	}
	public void setLosBreachWarningKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachwarningkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachWarningKPIBackgroundColour()
	{
		return this.losbreachwarningkpibackgroundcolour;
	}
	public void setLosBreachWarningKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachwarningkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachKPITextColour()
	{
		return this.losbreachkpitextcolour;
	}
	public void setLosBreachKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachkpitextcolour = value;
	}
	public ims.vo.LookupInstanceBean getLosBreachedKPIFlashingText()
	{
		return this.losbreachedkpiflashingtext;
	}
	public void setLosBreachedKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.losbreachedkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachedKPIFlashingTextColour()
	{
		return this.losbreachedkpiflashingtextcolour;
	}
	public void setLosBreachedKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachedkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getLosBreachedKPIBackgroundColour()
	{
		return this.losbreachedkpibackgroundcolour;
	}
	public void setLosBreachedKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.losbreachedkpibackgroundcolour = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean edlocation;
	private Integer awaitingtriagebreachwarningkpi;
	private Integer awaitingtriagebreachedkpi;
	private ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] triageprioritykpis;
	private Integer awaitingclinicianbreachwarningkpi;
	private Integer awaitingclinicianbreachedkpi;
	private Integer losbreachwarningkpi;
	private Integer losbreachedkpi;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpitextcolour;
	private ims.vo.LookupInstanceBean awaitingtriagebreachwarningkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpitextcolour;
	private ims.vo.LookupInstanceBean awaitingtriagebreachkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachwarningkpitextcolour;
	private ims.vo.LookupInstanceBean awaitingclinicianbreachwarningkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachwarningkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachwarningkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachkpitextcolour;
	private ims.vo.LookupInstanceBean awaitingclinicianbreachkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingclinicianbreachkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean losbreachwarningkpitextcolour;
	private ims.vo.LookupInstanceBean losbreachwarningkpiflashingtext;
	private ims.framework.utils.beans.ColorBean losbreachwarningkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean losbreachwarningkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean losbreachkpitextcolour;
	private ims.vo.LookupInstanceBean losbreachedkpiflashingtext;
	private ims.framework.utils.beans.ColorBean losbreachedkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean losbreachedkpibackgroundcolour;
}
