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

package ims.coe.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class BowelMedication extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public BowelMedication()
	{
		super();
	}
	public BowelMedication(int id)
	{
		super(id, "", true);
	}
	public BowelMedication(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public BowelMedication(int id, String text, boolean active, BowelMedication parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public BowelMedication(int id, String text, boolean active, BowelMedication parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public BowelMedication(int id, String text, boolean active, BowelMedication parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static BowelMedication buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new BowelMedication(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (BowelMedication)super.getParentInstance();
	}
	public BowelMedication getParent()
	{
		return (BowelMedication)super.getParentInstance();
	}
	public void setParent(BowelMedication parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		BowelMedication[] typedChildren = new BowelMedication[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (BowelMedication)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof BowelMedication)
		{
			super.addChild((BowelMedication)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof BowelMedication)
		{
			super.removeChild((BowelMedication)child);
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
		BowelMedicationCollection result = new BowelMedicationCollection();
		return result;
	}
	public static BowelMedication[] getNegativeInstances()
	{
		return new BowelMedication[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static BowelMedication getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static BowelMedication getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1011012;
}
