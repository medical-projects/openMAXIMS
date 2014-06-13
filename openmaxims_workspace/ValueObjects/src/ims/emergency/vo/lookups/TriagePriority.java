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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TriagePriority extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TriagePriority()
	{
		super();
	}
	public TriagePriority(int id)
	{
		super(id, "", true);
	}
	public TriagePriority(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TriagePriority(int id, String text, boolean active, TriagePriority parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TriagePriority(int id, String text, boolean active, TriagePriority parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TriagePriority(int id, String text, boolean active, TriagePriority parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TriagePriority buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TriagePriority(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TriagePriority)super.getParentInstance();
	}
	public TriagePriority getParent()
	{
		return (TriagePriority)super.getParentInstance();
	}
	public void setParent(TriagePriority parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TriagePriority[] typedChildren = new TriagePriority[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TriagePriority)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TriagePriority)
		{
			super.addChild((TriagePriority)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TriagePriority)
		{
			super.removeChild((TriagePriority)child);
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
		TriagePriorityCollection result = new TriagePriorityCollection();
		result.add(PRIORITY1);
		result.add(PRIORITY2);
		result.add(PRIORITY3);
		result.add(PRIORITY4);
		result.add(PRIORITY5);
		result.add(SKIPPED_TRIAGE);
		return result;
	}
	public static TriagePriority[] getNegativeInstances()
	{
		TriagePriority[] instances = new TriagePriority[6];
		instances[0] = PRIORITY1;
		instances[1] = PRIORITY2;
		instances[2] = PRIORITY3;
		instances[3] = PRIORITY4;
		instances[4] = PRIORITY5;
		instances[5] = SKIPPED_TRIAGE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[6];
		negativeInstances[0] = "PRIORITY1";
		negativeInstances[1] = "PRIORITY2";
		negativeInstances[2] = "PRIORITY3";
		negativeInstances[3] = "PRIORITY4";
		negativeInstances[4] = "PRIORITY5";
		negativeInstances[5] = "SKIPPED_TRIAGE";
		return negativeInstances;
	}
	public static TriagePriority getNegativeInstance(String name)
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
	public static TriagePriority getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TriagePriority[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1291020;
	public static final TriagePriority PRIORITY1 = new TriagePriority(-2333, "P1", true, null, null, Color.Red);
	public static final TriagePriority PRIORITY2 = new TriagePriority(-2334, "P2", true, null, null, Color.Orange);
	public static final TriagePriority PRIORITY3 = new TriagePriority(-2335, "P3", true, null, null, Color.Yellow);
	public static final TriagePriority PRIORITY4 = new TriagePriority(-2336, "P4", true, null, null, Color.Green);
	public static final TriagePriority PRIORITY5 = new TriagePriority(-2337, "P5", true, null, null, Color.Blue);
	public static final TriagePriority SKIPPED_TRIAGE = new TriagePriority(-2339, "Skipped Triage", true, null, null, Color.Purple);
}
