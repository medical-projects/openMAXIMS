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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.80 build 3972.30067)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.forms.systemjobnotificationdialog;

import java.util.ArrayList;
import java.util.Comparator;

import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.lookups.NotificationDeliveryCollection;
import ims.admin.vo.lookups.NotificationPriority;
import ims.core.vo.ConfiguredJobNotificationVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.NotificationDelivery;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{	
		form.setMode(FormMode.EDIT);
		form.getLocalContext().setEditedRecord(form.getGlobalContext().Admin.getSystemJobNotification());
		populateScreenFromData(form.getLocalContext().getEditedRecord());	
	}
	
	private void populateScreenFromData(ConfiguredJobNotificationVo vo) 
	{	
		clearAll();
		
		if (vo != null && vo.getUserIsNotNull())
		{
			form.qmbUser().newRow(vo.getUser(), vo.getUser().getUsername());
			form.qmbUser().setValue(vo.getUser());
		}
		
		form.cmbPriority().setValue(vo != null ? (vo.getPriorityIsNotNull() ? vo.getPriority() : NotificationPriority.NORMAL) : NotificationPriority.NORMAL);
		form.txtMessage().setValue(vo != null ? (vo.getUserMessageIsNotNull() ? vo.getUserMessage() : null) : null);
		popuateDeliveryMechanism(vo != null ? (vo.getDeliveryIsNotNull() ? vo.getDelivery() : null) : null);
	}
	
	private void clearAll() 
	{
		form.qmbUser().setValue(null);
		form.cmbPriority().setValue(null);
		form.txtMessage().setValue(null);
		form.chklistDeliveryMechanism().clear();
		//popuateDeliveryMechanism(form.getLocalContext().getEditedRecord().getDelivery());
	}

	private void popuateDeliveryMechanism(NotificationDeliveryCollection coll) 
	{
		
		NotificationDelivery[] deliveryMechanisms = NotificationDelivery.ALL;
		
		for (int i = 0; i < deliveryMechanisms.length; i++) 
		{
			if (deliveryMechanisms[i].equals(NotificationDelivery.UI))
			{
				form.chklistDeliveryMechanism().newRow(ims.admin.vo.lookups.NotificationDelivery.UI, deliveryMechanisms[i].toString(), true, false);
			}
			else if (deliveryMechanisms[i].equals(NotificationDelivery.EMAIL))
			{
				form.chklistDeliveryMechanism().newRow(ims.admin.vo.lookups.NotificationDelivery.EMAIL, deliveryMechanisms[i].toString(), coll != null ? (coll.contains(ims.admin.vo.lookups.NotificationDelivery.EMAIL) ? true : false) : false, true);
			}
			else if (deliveryMechanisms[i].equals(NotificationDelivery.PUSH))
			{
				form.chklistDeliveryMechanism().newRow(ims.admin.vo.lookups.NotificationDelivery.PUSH, deliveryMechanisms[i].toString(), coll != null ? (coll.contains(ims.admin.vo.lookups.NotificationDelivery.PUSH) ? true : false) : false, true);
			}
			else if (deliveryMechanisms[i].equals(NotificationDelivery.SMS))
			{
				form.chklistDeliveryMechanism().newRow(ims.admin.vo.lookups.NotificationDelivery.SMS, deliveryMechanisms[i].toString(), coll != null ? (coll.contains(ims.admin.vo.lookups.NotificationDelivery.SMS) ? true : false) : false, true);
			}
		}		
	}
	
	@Override
	protected void onBtnCancelClick() throws PresentationLogicException 
	{	
		engine.close(DialogResult.CANCEL);
	}
	
	private String[] getUiErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		if (form.qmbUser().getValue() == null) 
		{
			errors.add("User is mandatory");
		}
		if (form.cmbPriority().getValue() == null) 
		{
			errors.add("Notification Priority is mandatory");
		}
		if (form.txtMessage().getValue() == null) 
		{
			errors.add("Message is mandatory");
		}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid Notification", searchErrors);
			return searchErrors;
		}
		return null;
	}
	
	@Override
	protected void onBtnSaveClick() throws PresentationLogicException 
	{	
		String[] uiErrors = getUiErrors();
		if(uiErrors != null && uiErrors.length > 0)
		{
			engine.showErrors(uiErrors);
			return;
		}
		
		ConfiguredJobNotificationVo vo = populateDataFromScreen(form.getLocalContext().getEditedRecord());		
		form.getGlobalContext().Admin.setSystemJobNotification(vo);		
		engine.close(DialogResult.OK);
	}

	private ConfiguredJobNotificationVo populateDataFromScreen(ConfiguredJobNotificationVo vo) 
	{
		if (vo == null)
			vo = new ConfiguredJobNotificationVo();	
		
		vo.setUser(form.qmbUser().getValue());
		
		NotificationDeliveryCollection delivery = new NotificationDeliveryCollection();		
		for (int i = 0; i <form.chklistDeliveryMechanism().getValues().length; i++) 
		{
			if (delivery.contains(form.chklistDeliveryMechanism().getValues()[i]))
			{
				continue;
			}
			else
			{
				delivery.add(form.chklistDeliveryMechanism().getValues()[i]);
			}
		}
		
		vo.setUserMessage(form.txtMessage().getValue());
		vo.setDelivery(delivery);				
		vo.setPriority(form.cmbPriority().getValue());
		
		return vo;
	}
	
	@Override
	protected void onQmbUserTextSubmited(String username) throws PresentationLogicException 
	{	
		form.qmbUser().clear();
		
		AppUserShortVoCollection coll = domain.getAppUsers(username +"%");	
		coll.sort(new UserComparator(SortOrder.ASCENDING));//WDEV-17275
		
		if(coll != null && coll.size() > 0)
		{
			for(AppUserShortVo item : coll)
			{
				form.qmbUser().newRow(item, item.getUsername());
			}
			
			if(coll.size() == 1)
			{
				form.qmbUser().setValue(coll.get(0));
			}
			else
			{
				form.qmbUser().showOpened();
			}
		}
	}
	
	//WDEV-17275
	public class UserComparator implements Comparator
	{
		private int direction = 1;
		
		public UserComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public UserComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			//PersonName userName1 = null;
			String userName2 = null;
			String userName1 = null;
			if(ob1 instanceof AppUserShortVo )
			{
				AppUserShortVo user1 = (AppUserShortVo)ob1;
				userName1 =user1.getUsernameIsNotNull() ? user1.getUsername().toUpperCase():null;
			}
			if(ob2 instanceof AppUserShortVo)
			{
				AppUserShortVo user2 = (AppUserShortVo)ob2;
				userName2 = user2.getUsernameIsNotNull() ? user2.getUsername().toUpperCase():null;
			}
			
			if(userName1 != null )
				return  userName1.compareTo(userName2)*direction;
			if(userName2 != null)
				return (-1)*direction;
			
			return 0;
		}

	}
}
