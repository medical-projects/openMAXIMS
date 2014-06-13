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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.71 build 3580.21784)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.notifications;

import ims.framework.enumerations.FormMode;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	private void open() 
	{
		//engine.getNotificationsProvider().createNotification(engine.getLoggedInUser().getUserId(), NotificationPriority.CRITICAL, "kjhsadhs;adh;ashd;ashdu;shadhsadhsad", "sd;fksdkfosdjf'sdfio;hsd;ofh;osdhf;hasf");
		
		form.ccNotifications().setMode(FormMode.VIEW);
		form.ccNotifications().refreshData();
	}	
}
