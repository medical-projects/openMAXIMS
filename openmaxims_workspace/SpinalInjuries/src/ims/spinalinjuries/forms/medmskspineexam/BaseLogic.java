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

package ims.spinalinjuries.forms.medmskspineexam;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.MedMskSpineExam.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.MedMskSpineExam domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdSiteFindingcolFindingLookup()
	{
		this.form.grdSiteFinding().colFindingComboBox().clear();
		ims.spinalinjuries.vo.lookups.SpineExaminationFindingCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getSpineExaminationFinding(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdSiteFinding().colFindingComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.MedMskSpineExam domain;
}
