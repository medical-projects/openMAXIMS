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

package ims.correspondence.forms.glossaryadminconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.correspondence.domain.GlossaryAdminConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.correspondence.domain.GlossaryAdminConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.ctnGlossary().richText().setValue(null);
	}
	protected void populateScreenFromData(ims.correspondence.vo.GlossaryVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.ctnGlossary().richText().setValue(value.getGlossaryTextIsNotNull() ? value.getGlossaryText(): null);
	}
	protected ims.correspondence.vo.GlossaryVo populateDataFromScreen(ims.correspondence.vo.GlossaryVo value)
	{
		if(value == null)
			value = new ims.correspondence.vo.GlossaryVo();

		value.setGlossaryText(this.form.ctnGlossary().richText().getValue());

		return value;
	}
	protected ims.correspondence.vo.GlossaryVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.correspondence.vo.GlossaryVo());
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.correspondence.domain.GlossaryAdminConfiguration domain;
}
