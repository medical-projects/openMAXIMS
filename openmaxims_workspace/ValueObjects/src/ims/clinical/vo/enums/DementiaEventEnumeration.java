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

package ims.clinical.vo.enums;

public final class DementiaEventEnumeration extends ims.framework.utils.Enum
{
	public final static DementiaEventEnumeration CANCEL = new DementiaEventEnumeration(0, "Cancel", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration CLOSE = new DementiaEventEnumeration(1, "Close", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration SAVE = new DementiaEventEnumeration(2, "Save", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration NEW = new DementiaEventEnumeration(3, "New", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration EDIT = new DementiaEventEnumeration(4, "EDIT", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration RELOAD_AMTS_BROWSER = new DementiaEventEnumeration(5, "RELOAD_AMTS_BROWSER", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration MARK_RIE = new DementiaEventEnumeration(6, "MARK_RIE", null, ims.framework.utils.Color.Default);
	public final static DementiaEventEnumeration SOE = new DementiaEventEnumeration(7, "SOE", null, ims.framework.utils.Color.Default);

	private DementiaEventEnumeration(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
