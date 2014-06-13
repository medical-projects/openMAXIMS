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

package ims.emergency.vo;


public class TriageKPIUnboundDBVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TriageKPIUnboundDBVo()
	{
	}
	public TriageKPIUnboundDBVo(ims.emergency.vo.beans.TriageKPIUnboundDBVoBean bean)
	{
		this.breachwarning = bean.getBreachWarning();
		this.breachedkpi = bean.getBreachedKPI();
		this.typerow = bean.getTypeRow();
		this.breachwarningflashingtext = bean.getBreachWarningFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachWarningFlashingText());
		this.breachwarningtextcolour = bean.getBreachWarningTextColour() == null ? null : bean.getBreachWarningTextColour().buildColor();
		this.breachwarningflashingtextcolour = bean.getBreachWarningFlashingTextColour() == null ? null : bean.getBreachWarningFlashingTextColour().buildColor();
		this.breachwarningbackgroundcolour = bean.getBreachWarningBackgroundColour() == null ? null : bean.getBreachWarningBackgroundColour().buildColor();
		this.breachedkpiflashingtext = bean.getBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachedKPIFlashingText());
		this.breachedkpitextcolour = bean.getBreachedKPITextColour() == null ? null : bean.getBreachedKPITextColour().buildColor();
		this.breachedkpiflashingtextcolour = bean.getBreachedKPIFlashingTextColour() == null ? null : bean.getBreachedKPIFlashingTextColour().buildColor();
		this.breachedkpibackgroundcolour = bean.getBreachedKPIBackgroundColour() == null ? null : bean.getBreachedKPIBackgroundColour().buildColor();
		this.defaultrowcolour = bean.getDefaultRowColour() == null ? null : bean.getDefaultRowColour().buildColor();
		this.defaultfontcolour = bean.getDefaultFontColour() == null ? null : bean.getDefaultFontColour().buildColor();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TriageKPIUnboundDBVoBean bean)
	{
		this.breachwarning = bean.getBreachWarning();
		this.breachedkpi = bean.getBreachedKPI();
		this.typerow = bean.getTypeRow();
		this.breachwarningflashingtext = bean.getBreachWarningFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachWarningFlashingText());
		this.breachwarningtextcolour = bean.getBreachWarningTextColour() == null ? null : bean.getBreachWarningTextColour().buildColor();
		this.breachwarningflashingtextcolour = bean.getBreachWarningFlashingTextColour() == null ? null : bean.getBreachWarningFlashingTextColour().buildColor();
		this.breachwarningbackgroundcolour = bean.getBreachWarningBackgroundColour() == null ? null : bean.getBreachWarningBackgroundColour().buildColor();
		this.breachedkpiflashingtext = bean.getBreachedKPIFlashingText() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getBreachedKPIFlashingText());
		this.breachedkpitextcolour = bean.getBreachedKPITextColour() == null ? null : bean.getBreachedKPITextColour().buildColor();
		this.breachedkpiflashingtextcolour = bean.getBreachedKPIFlashingTextColour() == null ? null : bean.getBreachedKPIFlashingTextColour().buildColor();
		this.breachedkpibackgroundcolour = bean.getBreachedKPIBackgroundColour() == null ? null : bean.getBreachedKPIBackgroundColour().buildColor();
		this.defaultrowcolour = bean.getDefaultRowColour() == null ? null : bean.getDefaultRowColour().buildColor();
		this.defaultfontcolour = bean.getDefaultFontColour() == null ? null : bean.getDefaultFontColour().buildColor();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TriageKPIUnboundDBVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TriageKPIUnboundDBVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TriageKPIUnboundDBVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getBreachWarningIsNotNull()
	{
		return this.breachwarning != null;
	}
	public Integer getBreachWarning()
	{
		return this.breachwarning;
	}
	public void setBreachWarning(Integer value)
	{
		this.isValidated = false;
		this.breachwarning = value;
	}
	public boolean getBreachedKPIIsNotNull()
	{
		return this.breachedkpi != null;
	}
	public Integer getBreachedKPI()
	{
		return this.breachedkpi;
	}
	public void setBreachedKPI(Integer value)
	{
		this.isValidated = false;
		this.breachedkpi = value;
	}
	public boolean getTypeRowIsNotNull()
	{
		return this.typerow != null;
	}
	public String getTypeRow()
	{
		return this.typerow;
	}
	public static int getTypeRowMaxLength()
	{
		return 255;
	}
	public void setTypeRow(String value)
	{
		this.isValidated = false;
		this.typerow = value;
	}
	public boolean getBreachWarningFlashingTextIsNotNull()
	{
		return this.breachwarningflashingtext != null;
	}
	public ims.core.vo.lookups.YesNo getBreachWarningFlashingText()
	{
		return this.breachwarningflashingtext;
	}
	public void setBreachWarningFlashingText(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.breachwarningflashingtext = value;
	}
	public boolean getBreachWarningTextColourIsNotNull()
	{
		return this.breachwarningtextcolour != null;
	}
	public ims.framework.utils.Color getBreachWarningTextColour()
	{
		return this.breachwarningtextcolour;
	}
	public void setBreachWarningTextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachwarningtextcolour = value;
	}
	public boolean getBreachWarningFlashingTextColourIsNotNull()
	{
		return this.breachwarningflashingtextcolour != null;
	}
	public ims.framework.utils.Color getBreachWarningFlashingTextColour()
	{
		return this.breachwarningflashingtextcolour;
	}
	public void setBreachWarningFlashingTextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachwarningflashingtextcolour = value;
	}
	public boolean getBreachWarningBackgroundColourIsNotNull()
	{
		return this.breachwarningbackgroundcolour != null;
	}
	public ims.framework.utils.Color getBreachWarningBackgroundColour()
	{
		return this.breachwarningbackgroundcolour;
	}
	public void setBreachWarningBackgroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachwarningbackgroundcolour = value;
	}
	public boolean getBreachedKPIFlashingTextIsNotNull()
	{
		return this.breachedkpiflashingtext != null;
	}
	public ims.core.vo.lookups.YesNo getBreachedKPIFlashingText()
	{
		return this.breachedkpiflashingtext;
	}
	public void setBreachedKPIFlashingText(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.breachedkpiflashingtext = value;
	}
	public boolean getBreachedKPITextColourIsNotNull()
	{
		return this.breachedkpitextcolour != null;
	}
	public ims.framework.utils.Color getBreachedKPITextColour()
	{
		return this.breachedkpitextcolour;
	}
	public void setBreachedKPITextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachedkpitextcolour = value;
	}
	public boolean getBreachedKPIFlashingTextColourIsNotNull()
	{
		return this.breachedkpiflashingtextcolour != null;
	}
	public ims.framework.utils.Color getBreachedKPIFlashingTextColour()
	{
		return this.breachedkpiflashingtextcolour;
	}
	public void setBreachedKPIFlashingTextColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachedkpiflashingtextcolour = value;
	}
	public boolean getBreachedKPIBackgroundColourIsNotNull()
	{
		return this.breachedkpibackgroundcolour != null;
	}
	public ims.framework.utils.Color getBreachedKPIBackgroundColour()
	{
		return this.breachedkpibackgroundcolour;
	}
	public void setBreachedKPIBackgroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.breachedkpibackgroundcolour = value;
	}
	public boolean getDefaultRowColourIsNotNull()
	{
		return this.defaultrowcolour != null;
	}
	public ims.framework.utils.Color getDefaultRowColour()
	{
		return this.defaultrowcolour;
	}
	public void setDefaultRowColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.defaultrowcolour = value;
	}
	public boolean getDefaultFontColourIsNotNull()
	{
		return this.defaultfontcolour != null;
	}
	public ims.framework.utils.Color getDefaultFontColour()
	{
		return this.defaultfontcolour;
	}
	public void setDefaultFontColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.defaultfontcolour = value;
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
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof TriageKPIUnboundDBVo))
			return false;
		TriageKPIUnboundDBVo compareObj = (TriageKPIUnboundDBVo)obj;
		if(this.getBreachedKPI() == null && compareObj.getBreachedKPI() != null)
			return false;
		if(this.getBreachedKPI() != null && compareObj.getBreachedKPI() == null)
			return false;
		if(this.getBreachedKPI() != null && compareObj.getBreachedKPI() != null)
			return this.getBreachedKPI().equals(compareObj.getBreachedKPI());
		return super.equals(obj);
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
	
		TriageKPIUnboundDBVo clone = new TriageKPIUnboundDBVo();
		
		clone.breachwarning = this.breachwarning;
		clone.breachedkpi = this.breachedkpi;
		clone.typerow = this.typerow;
		if(this.breachwarningflashingtext == null)
			clone.breachwarningflashingtext = null;
		else
			clone.breachwarningflashingtext = (ims.core.vo.lookups.YesNo)this.breachwarningflashingtext.clone();
		if(this.breachwarningtextcolour == null)
			clone.breachwarningtextcolour = null;
		else
			clone.breachwarningtextcolour = (ims.framework.utils.Color)this.breachwarningtextcolour.clone();
		if(this.breachwarningflashingtextcolour == null)
			clone.breachwarningflashingtextcolour = null;
		else
			clone.breachwarningflashingtextcolour = (ims.framework.utils.Color)this.breachwarningflashingtextcolour.clone();
		if(this.breachwarningbackgroundcolour == null)
			clone.breachwarningbackgroundcolour = null;
		else
			clone.breachwarningbackgroundcolour = (ims.framework.utils.Color)this.breachwarningbackgroundcolour.clone();
		if(this.breachedkpiflashingtext == null)
			clone.breachedkpiflashingtext = null;
		else
			clone.breachedkpiflashingtext = (ims.core.vo.lookups.YesNo)this.breachedkpiflashingtext.clone();
		if(this.breachedkpitextcolour == null)
			clone.breachedkpitextcolour = null;
		else
			clone.breachedkpitextcolour = (ims.framework.utils.Color)this.breachedkpitextcolour.clone();
		if(this.breachedkpiflashingtextcolour == null)
			clone.breachedkpiflashingtextcolour = null;
		else
			clone.breachedkpiflashingtextcolour = (ims.framework.utils.Color)this.breachedkpiflashingtextcolour.clone();
		if(this.breachedkpibackgroundcolour == null)
			clone.breachedkpibackgroundcolour = null;
		else
			clone.breachedkpibackgroundcolour = (ims.framework.utils.Color)this.breachedkpibackgroundcolour.clone();
		if(this.defaultrowcolour == null)
			clone.defaultrowcolour = null;
		else
			clone.defaultrowcolour = (ims.framework.utils.Color)this.defaultrowcolour.clone();
		if(this.defaultfontcolour == null)
			clone.defaultfontcolour = null;
		else
			clone.defaultfontcolour = (ims.framework.utils.Color)this.defaultfontcolour.clone();
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
		if (!(TriageKPIUnboundDBVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TriageKPIUnboundDBVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TriageKPIUnboundDBVo compareObj = (TriageKPIUnboundDBVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getBreachedKPI() == null && compareObj.getBreachedKPI() != null)
				return -1;
			if(this.getBreachedKPI() != null && compareObj.getBreachedKPI() == null)
				return 1;
			if(this.getBreachedKPI() != null && compareObj.getBreachedKPI() != null)
				retVal = this.getBreachedKPI().compareTo(compareObj.getBreachedKPI());
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
		if(this.breachwarning != null)
			count++;
		if(this.breachedkpi != null)
			count++;
		if(this.typerow != null)
			count++;
		if(this.breachwarningflashingtext != null)
			count++;
		if(this.breachwarningtextcolour != null)
			count++;
		if(this.breachwarningflashingtextcolour != null)
			count++;
		if(this.breachwarningbackgroundcolour != null)
			count++;
		if(this.breachedkpiflashingtext != null)
			count++;
		if(this.breachedkpitextcolour != null)
			count++;
		if(this.breachedkpiflashingtextcolour != null)
			count++;
		if(this.breachedkpibackgroundcolour != null)
			count++;
		if(this.defaultrowcolour != null)
			count++;
		if(this.defaultfontcolour != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected Integer breachwarning;
	protected Integer breachedkpi;
	protected String typerow;
	protected ims.core.vo.lookups.YesNo breachwarningflashingtext;
	protected ims.framework.utils.Color breachwarningtextcolour;
	protected ims.framework.utils.Color breachwarningflashingtextcolour;
	protected ims.framework.utils.Color breachwarningbackgroundcolour;
	protected ims.core.vo.lookups.YesNo breachedkpiflashingtext;
	protected ims.framework.utils.Color breachedkpitextcolour;
	protected ims.framework.utils.Color breachedkpiflashingtextcolour;
	protected ims.framework.utils.Color breachedkpibackgroundcolour;
	protected ims.framework.utils.Color defaultrowcolour;
	protected ims.framework.utils.Color defaultfontcolour;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
