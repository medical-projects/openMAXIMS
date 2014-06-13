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

public class SmokingCurrentHistoric extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SmokingCurrentHistoric()
	{
		super();
	}
	public SmokingCurrentHistoric(int id)
	{
		super(id, "", true);
	}
	public SmokingCurrentHistoric(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SmokingCurrentHistoric(int id, String text, boolean active, SmokingCurrentHistoric parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SmokingCurrentHistoric(int id, String text, boolean active, SmokingCurrentHistoric parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SmokingCurrentHistoric(int id, String text, boolean active, SmokingCurrentHistoric parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SmokingCurrentHistoric buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SmokingCurrentHistoric(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SmokingCurrentHistoric)super.getParentInstance();
	}
	public SmokingCurrentHistoric getParent()
	{
		return (SmokingCurrentHistoric)super.getParentInstance();
	}
	public void setParent(SmokingCurrentHistoric parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SmokingCurrentHistoric[] typedChildren = new SmokingCurrentHistoric[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SmokingCurrentHistoric)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SmokingCurrentHistoric)
		{
			super.addChild((SmokingCurrentHistoric)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SmokingCurrentHistoric)
		{
			super.removeChild((SmokingCurrentHistoric)child);
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
		SmokingCurrentHistoricCollection result = new SmokingCurrentHistoricCollection();
		result.add(CURRENT);
		result.add(HISTORIC);
		return result;
	}
	public static SmokingCurrentHistoric[] getNegativeInstances()
	{
		SmokingCurrentHistoric[] instances = new SmokingCurrentHistoric[2];
		instances[0] = CURRENT;
		instances[1] = HISTORIC;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "CURRENT";
		negativeInstances[1] = "HISTORIC";
		return negativeInstances;
	}
	public static SmokingCurrentHistoric getNegativeInstance(String name)
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
	public static SmokingCurrentHistoric getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SmokingCurrentHistoric[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021016;
	public static final SmokingCurrentHistoric CURRENT = new SmokingCurrentHistoric(-66, "Current", true, null, null, Color.Black);
	public static final SmokingCurrentHistoric HISTORIC = new SmokingCurrentHistoric(-128, "Historic", true, null, null, Color.Black);
}
