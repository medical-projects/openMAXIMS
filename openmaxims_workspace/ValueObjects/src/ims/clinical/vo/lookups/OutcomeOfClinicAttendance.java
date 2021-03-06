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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class OutcomeOfClinicAttendance extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public OutcomeOfClinicAttendance()
	{
		super();
	}
	public OutcomeOfClinicAttendance(int id)
	{
		super(id, "", true);
	}
	public OutcomeOfClinicAttendance(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public OutcomeOfClinicAttendance(int id, String text, boolean active, OutcomeOfClinicAttendance parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public OutcomeOfClinicAttendance(int id, String text, boolean active, OutcomeOfClinicAttendance parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public OutcomeOfClinicAttendance(int id, String text, boolean active, OutcomeOfClinicAttendance parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static OutcomeOfClinicAttendance buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new OutcomeOfClinicAttendance(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (OutcomeOfClinicAttendance)super.getParentInstance();
	}
	public OutcomeOfClinicAttendance getParent()
	{
		return (OutcomeOfClinicAttendance)super.getParentInstance();
	}
	public void setParent(OutcomeOfClinicAttendance parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		OutcomeOfClinicAttendance[] typedChildren = new OutcomeOfClinicAttendance[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (OutcomeOfClinicAttendance)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof OutcomeOfClinicAttendance)
		{
			super.addChild((OutcomeOfClinicAttendance)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof OutcomeOfClinicAttendance)
		{
			super.removeChild((OutcomeOfClinicAttendance)child);
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
		OutcomeOfClinicAttendanceCollection result = new OutcomeOfClinicAttendanceCollection();
		result.add(DISCHARGE);
		result.add(SELF_DISCHARGE);
		result.add(OPEN_APPOINTMENT);
		result.add(FOLLOW_UP_APPOINTMENT_REQUIRED);
		result.add(COMMENCE_WATCHFUL_WAIT);
		result.add(FOLLOWING_WATCHFUL_WAIT);
		result.add(FIRST_DEFINITIVE_TREATMENT_COMMENCED_IN_OPD_TODAY);
		return result;
	}
	public static OutcomeOfClinicAttendance[] getNegativeInstances()
	{
		OutcomeOfClinicAttendance[] instances = new OutcomeOfClinicAttendance[7];
		instances[0] = DISCHARGE;
		instances[1] = SELF_DISCHARGE;
		instances[2] = OPEN_APPOINTMENT;
		instances[3] = FOLLOW_UP_APPOINTMENT_REQUIRED;
		instances[4] = COMMENCE_WATCHFUL_WAIT;
		instances[5] = FOLLOWING_WATCHFUL_WAIT;
		instances[6] = FIRST_DEFINITIVE_TREATMENT_COMMENCED_IN_OPD_TODAY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[7];
		negativeInstances[0] = "DISCHARGE";
		negativeInstances[1] = "SELF_DISCHARGE";
		negativeInstances[2] = "OPEN_APPOINTMENT";
		negativeInstances[3] = "FOLLOW_UP_APPOINTMENT_REQUIRED";
		negativeInstances[4] = "COMMENCE_WATCHFUL_WAIT";
		negativeInstances[5] = "FOLLOWING_WATCHFUL_WAIT";
		negativeInstances[6] = "FIRST_DEFINITIVE_TREATMENT_COMMENCED_IN_OPD_TODAY";
		return negativeInstances;
	}
	public static OutcomeOfClinicAttendance getNegativeInstance(String name)
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
	public static OutcomeOfClinicAttendance getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		OutcomeOfClinicAttendance[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231095;
	public static final OutcomeOfClinicAttendance DISCHARGE = new OutcomeOfClinicAttendance(-1800, "Discharge (new or follow up)", true, null, null, Color.Default);
	public static final OutcomeOfClinicAttendance SELF_DISCHARGE = new OutcomeOfClinicAttendance(-1801, "Self Discharge", true, null, null, Color.Default);
	public static final OutcomeOfClinicAttendance OPEN_APPOINTMENT = new OutcomeOfClinicAttendance(-1802, "Open appointment", true, null, null, Color.Default);
	public static final OutcomeOfClinicAttendance FOLLOW_UP_APPOINTMENT_REQUIRED = new OutcomeOfClinicAttendance(-1803, "Follow up appointment required", true, null, null, Color.Default);
	public static final OutcomeOfClinicAttendance COMMENCE_WATCHFUL_WAIT = new OutcomeOfClinicAttendance(-1804, "Commence watchful wait", true, OutcomeOfClinicAttendance.FOLLOW_UP_APPOINTMENT_REQUIRED, null, Color.Default);
	public static final OutcomeOfClinicAttendance FOLLOWING_WATCHFUL_WAIT = new OutcomeOfClinicAttendance(-1805, "Following watchful wait", true, OutcomeOfClinicAttendance.FOLLOW_UP_APPOINTMENT_REQUIRED, null, Color.Default);
	public static final OutcomeOfClinicAttendance FIRST_DEFINITIVE_TREATMENT_COMMENCED_IN_OPD_TODAY = new OutcomeOfClinicAttendance(-1806, "First definitive treatment commenced in OPD today", true, OutcomeOfClinicAttendance.FOLLOW_UP_APPOINTMENT_REQUIRED, null, Color.Default);
}
