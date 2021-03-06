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

package ims.oncology.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class BrachyTherapyType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public BrachyTherapyType()
	{
		super();
	}
	public BrachyTherapyType(int id)
	{
		super(id, "", true);
	}
	public BrachyTherapyType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public BrachyTherapyType(int id, String text, boolean active, BrachyTherapyType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public BrachyTherapyType(int id, String text, boolean active, BrachyTherapyType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public BrachyTherapyType(int id, String text, boolean active, BrachyTherapyType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static BrachyTherapyType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new BrachyTherapyType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (BrachyTherapyType)super.getParentInstance();
	}
	public BrachyTherapyType getParent()
	{
		return (BrachyTherapyType)super.getParentInstance();
	}
	public void setParent(BrachyTherapyType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		BrachyTherapyType[] typedChildren = new BrachyTherapyType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (BrachyTherapyType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof BrachyTherapyType)
		{
			super.addChild((BrachyTherapyType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof BrachyTherapyType)
		{
			super.removeChild((BrachyTherapyType)child);
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
		BrachyTherapyTypeCollection result = new BrachyTherapyTypeCollection();
		result.add(INTERSTITIAL);
		result.add(INTRACAVITY);
		result.add(UNSEALED);
		return result;
	}
	public static BrachyTherapyType[] getNegativeInstances()
	{
		BrachyTherapyType[] instances = new BrachyTherapyType[3];
		instances[0] = INTERSTITIAL;
		instances[1] = INTRACAVITY;
		instances[2] = UNSEALED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "INTERSTITIAL";
		negativeInstances[1] = "INTRACAVITY";
		negativeInstances[2] = "UNSEALED";
		return negativeInstances;
	}
	public static BrachyTherapyType getNegativeInstance(String name)
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
	public static BrachyTherapyType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		BrachyTherapyType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1251023;
	public static final BrachyTherapyType INTERSTITIAL = new BrachyTherapyType(-2017, "Interstitial", true, null, null, Color.Default);
	public static final BrachyTherapyType INTRACAVITY = new BrachyTherapyType(-2018, "Intracavity", true, null, null, Color.Default);
	public static final BrachyTherapyType UNSEALED = new BrachyTherapyType(-2019, "Unsealed", true, null, null, Color.Default);
}
