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

package ims.core.vo.enums;

public final class PatientDetailsTab extends ims.framework.utils.Enum
{
	public final static PatientDetailsTab ADDMENU = new PatientDetailsTab(0, "Add_ContextMenu", null, ims.framework.utils.Color.Default);
	public final static PatientDetailsTab REMOVEMENU = new PatientDetailsTab(1, "Remove_ContextMenu", null, ims.framework.utils.Color.Default);
	public final static PatientDetailsTab NOKBUTTON = new PatientDetailsTab(2, "Nok_Button", null, ims.framework.utils.Color.Default);
	public final static PatientDetailsTab GPBUTTON = new PatientDetailsTab(3, "GP_Button", null, ims.framework.utils.Color.Default);
	public final static PatientDetailsTab GPCLEARGPBUTTON = new PatientDetailsTab(4, "GP_ClearButton", null, ims.framework.utils.Color.Default);
	public final static PatientDetailsTab NOKSTARTACTION = new PatientDetailsTab(5, "NOK_Button_Start_Action", null, ims.framework.utils.Color.Default);

	private PatientDetailsTab(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
