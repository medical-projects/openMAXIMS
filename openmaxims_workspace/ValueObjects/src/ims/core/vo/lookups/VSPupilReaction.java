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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class VSPupilReaction extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public VSPupilReaction()
	{
		super();
	}
	public VSPupilReaction(int id)
	{
		super(id, "", true);
	}
	public VSPupilReaction(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public VSPupilReaction(int id, String text, boolean active, VSPupilReaction parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public VSPupilReaction(int id, String text, boolean active, VSPupilReaction parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public VSPupilReaction(int id, String text, boolean active, VSPupilReaction parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static VSPupilReaction buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new VSPupilReaction(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (VSPupilReaction)super.getParentInstance();
	}
	public VSPupilReaction getParent()
	{
		return (VSPupilReaction)super.getParentInstance();
	}
	public void setParent(VSPupilReaction parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		VSPupilReaction[] typedChildren = new VSPupilReaction[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (VSPupilReaction)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof VSPupilReaction)
		{
			super.addChild((VSPupilReaction)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof VSPupilReaction)
		{
			super.removeChild((VSPupilReaction)child);
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
		VSPupilReactionCollection result = new VSPupilReactionCollection();
		result.add(PLUS);
		result.add(MINUS);
		result.add(C);
		return result;
	}
	public static VSPupilReaction[] getNegativeInstances()
	{
		VSPupilReaction[] instances = new VSPupilReaction[3];
		instances[0] = PLUS;
		instances[1] = MINUS;
		instances[2] = C;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PLUS";
		negativeInstances[1] = "MINUS";
		negativeInstances[2] = "C";
		return negativeInstances;
	}
	public static VSPupilReaction getNegativeInstance(String name)
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
	public static VSPupilReaction getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		VSPupilReaction[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021056;
	public static final VSPupilReaction PLUS = new VSPupilReaction(-2371, "+", true, null, null, Color.Default);
	public static final VSPupilReaction MINUS = new VSPupilReaction(-2372, "-", true, null, null, Color.Default);
	public static final VSPupilReaction C = new VSPupilReaction(-2373, "C", true, null, null, Color.Default);
}
