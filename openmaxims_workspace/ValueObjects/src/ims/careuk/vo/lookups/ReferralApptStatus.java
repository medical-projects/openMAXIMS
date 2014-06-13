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

package ims.careuk.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ReferralApptStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferralApptStatus()
	{
		super();
	}
	public ReferralApptStatus(int id)
	{
		super(id, "", true);
	}
	public ReferralApptStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferralApptStatus(int id, String text, boolean active, ReferralApptStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferralApptStatus(int id, String text, boolean active, ReferralApptStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferralApptStatus(int id, String text, boolean active, ReferralApptStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferralApptStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferralApptStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferralApptStatus)super.getParentInstance();
	}
	public ReferralApptStatus getParent()
	{
		return (ReferralApptStatus)super.getParentInstance();
	}
	public void setParent(ReferralApptStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferralApptStatus[] typedChildren = new ReferralApptStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferralApptStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferralApptStatus)
		{
			super.addChild((ReferralApptStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferralApptStatus)
		{
			super.removeChild((ReferralApptStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		ReferralApptStatusCollection result = new ReferralApptStatusCollection();
		result.add(REFERRAL_ACCEPTED);
		result.add(REFERRAL_REJECTED);
		result.add(DISCHARGED);
		result.add(APPOINTMENTBOOKED);
		result.add(WAITING_ON_GP_REFERRAL);
		result.add(REFERRAL_RECEIVED);
		result.add(CAB_CANCELLATION);
		result.add(REFERRAL_CANCELLED_BY_PROVIDER);
		result.add(MANUAL_REFERRAL_REGISTERED);
		result.add(PROVISIONAL_REJECTION);
		result.add(AWAITING_TRIAGE);
		result.add(FURTHER_MANAGEMENT_REQUIRED);
		result.add(ACTIVE_MONITORING);
		result.add(END_OF_CARE);
		result.add(ONWARDREFERRALREQUESTED);
		return result;
	}
	public static ReferralApptStatus[] getNegativeInstances()
	{
		ReferralApptStatus[] instances = new ReferralApptStatus[15];
		instances[0] = REFERRAL_ACCEPTED;
		instances[1] = REFERRAL_REJECTED;
		instances[2] = DISCHARGED;
		instances[3] = APPOINTMENTBOOKED;
		instances[4] = WAITING_ON_GP_REFERRAL;
		instances[5] = REFERRAL_RECEIVED;
		instances[6] = CAB_CANCELLATION;
		instances[7] = REFERRAL_CANCELLED_BY_PROVIDER;
		instances[8] = MANUAL_REFERRAL_REGISTERED;
		instances[9] = PROVISIONAL_REJECTION;
		instances[10] = AWAITING_TRIAGE;
		instances[11] = FURTHER_MANAGEMENT_REQUIRED;
		instances[12] = ACTIVE_MONITORING;
		instances[13] = END_OF_CARE;
		instances[14] = ONWARDREFERRALREQUESTED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[15];
		negativeInstances[0] = "REFERRAL_ACCEPTED";
		negativeInstances[1] = "REFERRAL_REJECTED";
		negativeInstances[2] = "DISCHARGED";
		negativeInstances[3] = "APPOINTMENTBOOKED";
		negativeInstances[4] = "WAITING_ON_GP_REFERRAL";
		negativeInstances[5] = "REFERRAL_RECEIVED";
		negativeInstances[6] = "CAB_CANCELLATION";
		negativeInstances[7] = "REFERRAL_CANCELLED_BY_PROVIDER";
		negativeInstances[8] = "MANUAL_REFERRAL_REGISTERED";
		negativeInstances[9] = "PROVISIONAL_REJECTION";
		negativeInstances[10] = "AWAITING_TRIAGE";
		negativeInstances[11] = "FURTHER_MANAGEMENT_REQUIRED";
		negativeInstances[12] = "ACTIVE_MONITORING";
		negativeInstances[13] = "END_OF_CARE";
		negativeInstances[14] = "ONWARDREFERRALREQUESTED";
		return negativeInstances;
	}
	public static ReferralApptStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static ReferralApptStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferralApptStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1341000;
	public static final ReferralApptStatus REFERRAL_ACCEPTED = new ReferralApptStatus(-1447, "Referral Accepted", true, null, null, Color.Default);
	public static final ReferralApptStatus REFERRAL_REJECTED = new ReferralApptStatus(-1448, "Referral Rejected", true, null, null, Color.Default);
	public static final ReferralApptStatus DISCHARGED = new ReferralApptStatus(-1451, "Discharged", true, null, null, Color.Default);
	public static final ReferralApptStatus APPOINTMENTBOOKED = new ReferralApptStatus(-1453, "Appointment Booked", true, null, null, Color.Default);
	public static final ReferralApptStatus WAITING_ON_GP_REFERRAL = new ReferralApptStatus(-1455, "Waiting on GP Referral", true, null, null, Color.Default);
	public static final ReferralApptStatus REFERRAL_RECEIVED = new ReferralApptStatus(-1492, "Referral Received", true, null, null, Color.Default);
	public static final ReferralApptStatus CAB_CANCELLATION = new ReferralApptStatus(-1541, "C and B Cancellation", true, null, null, Color.Default);
	public static final ReferralApptStatus REFERRAL_CANCELLED_BY_PROVIDER = new ReferralApptStatus(-1542, "Referral Cancelled by Provider", true, null, null, Color.Default);
	public static final ReferralApptStatus MANUAL_REFERRAL_REGISTERED = new ReferralApptStatus(-1543, "Manual Referral Registered", true, null, null, Color.Default);
	public static final ReferralApptStatus PROVISIONAL_REJECTION = new ReferralApptStatus(-1544, "Second Opinion Required", true, null, null, Color.Default);
	public static final ReferralApptStatus AWAITING_TRIAGE = new ReferralApptStatus(-1549, "Awaiting Triage", true, null, null, Color.Default);
	public static final ReferralApptStatus FURTHER_MANAGEMENT_REQUIRED = new ReferralApptStatus(-1570, "Further Management Required", true, null, null, Color.Default);
	public static final ReferralApptStatus ACTIVE_MONITORING = new ReferralApptStatus(-2053, "Active Monitoring", true, null, null, Color.Default);
	public static final ReferralApptStatus END_OF_CARE = new ReferralApptStatus(-2134, "End Of Care", true, null, null, Color.Default);
	public static final ReferralApptStatus ONWARDREFERRALREQUESTED = new ReferralApptStatus(-2161, "Onward Referral Requested", true, null, null, Color.Default);
}
