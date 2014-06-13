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

public class PACSClientType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PACSClientType()
	{
		super();
	}
	public PACSClientType(int id)
	{
		super(id, "", true);
	}
	public PACSClientType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PACSClientType(int id, String text, boolean active, PACSClientType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PACSClientType(int id, String text, boolean active, PACSClientType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PACSClientType(int id, String text, boolean active, PACSClientType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PACSClientType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PACSClientType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PACSClientType)super.getParentInstance();
	}
	public PACSClientType getParent()
	{
		return (PACSClientType)super.getParentInstance();
	}
	public void setParent(PACSClientType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PACSClientType[] typedChildren = new PACSClientType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PACSClientType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PACSClientType)
		{
			super.addChild((PACSClientType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PACSClientType)
		{
			super.removeChild((PACSClientType)child);
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
		PACSClientTypeCollection result = new PACSClientTypeCollection();
		result.add(CENTRICITY);
		result.add(CARESTREAM);
		return result;
	}
	public static PACSClientType[] getNegativeInstances()
	{
		PACSClientType[] instances = new PACSClientType[2];
		instances[0] = CENTRICITY;
		instances[1] = CARESTREAM;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "CENTRICITY";
		negativeInstances[1] = "CARESTREAM";
		return negativeInstances;
	}
	public static PACSClientType getNegativeInstance(String name)
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
	public static PACSClientType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PACSClientType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021286;
	public static final PACSClientType CENTRICITY = new PACSClientType(-2542, "Centricity", true, null, null, Color.Default);
	public static final PACSClientType CARESTREAM = new PACSClientType(-2543, "Carestream", true, null, null, Color.Default);
}
