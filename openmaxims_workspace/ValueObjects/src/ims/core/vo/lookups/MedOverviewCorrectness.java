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

public class MedOverviewCorrectness extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public MedOverviewCorrectness()
	{
		super();
	}
	public MedOverviewCorrectness(int id)
	{
		super(id, "", true);
	}
	public MedOverviewCorrectness(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public MedOverviewCorrectness(int id, String text, boolean active, MedOverviewCorrectness parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public MedOverviewCorrectness(int id, String text, boolean active, MedOverviewCorrectness parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public MedOverviewCorrectness(int id, String text, boolean active, MedOverviewCorrectness parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static MedOverviewCorrectness buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new MedOverviewCorrectness(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (MedOverviewCorrectness)super.getParentInstance();
	}
	public MedOverviewCorrectness getParent()
	{
		return (MedOverviewCorrectness)super.getParentInstance();
	}
	public void setParent(MedOverviewCorrectness parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		MedOverviewCorrectness[] typedChildren = new MedOverviewCorrectness[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (MedOverviewCorrectness)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof MedOverviewCorrectness)
		{
			super.addChild((MedOverviewCorrectness)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof MedOverviewCorrectness)
		{
			super.removeChild((MedOverviewCorrectness)child);
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
		MedOverviewCorrectnessCollection result = new MedOverviewCorrectnessCollection();
		result.add(INACURATE);
		return result;
	}
	public static MedOverviewCorrectness[] getNegativeInstances()
	{
		MedOverviewCorrectness[] instances = new MedOverviewCorrectness[1];
		instances[0] = INACURATE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[1];
		negativeInstances[0] = "INACURATE";
		return negativeInstances;
	}
	public static MedOverviewCorrectness getNegativeInstance(String name)
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
	public static MedOverviewCorrectness getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		MedOverviewCorrectness[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021183;
	public static final MedOverviewCorrectness INACURATE = new MedOverviewCorrectness(-1092, "Displayed Medications record is not current", true, null, null, Color.Default);
}
