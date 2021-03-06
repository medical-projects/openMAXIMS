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

package ims.ntpf.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class CaseType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public CaseType()
	{
		super();
	}
	public CaseType(int id)
	{
		super(id, "", true);
	}
	public CaseType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public CaseType(int id, String text, boolean active, CaseType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public CaseType(int id, String text, boolean active, CaseType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public CaseType(int id, String text, boolean active, CaseType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static CaseType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new CaseType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (CaseType)super.getParentInstance();
	}
	public CaseType getParent()
	{
		return (CaseType)super.getParentInstance();
	}
	public void setParent(CaseType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		CaseType[] typedChildren = new CaseType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (CaseType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof CaseType)
		{
			super.addChild((CaseType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof CaseType)
		{
			super.removeChild((CaseType)child);
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
		CaseTypeCollection result = new CaseTypeCollection();
		result.add(PTR_INP);
		result.add(PTR_OUT);
		result.add(PTR_DAY);
		return result;
	}
	public static CaseType[] getNegativeInstances()
	{
		CaseType[] instances = new CaseType[3];
		instances[0] = PTR_INP;
		instances[1] = PTR_OUT;
		instances[2] = PTR_DAY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PTR_INP";
		negativeInstances[1] = "PTR_OUT";
		negativeInstances[2] = "PTR_DAY";
		return negativeInstances;
	}
	public static CaseType getNegativeInstance(String name)
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
	public static CaseType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		CaseType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1101008;
	public static final CaseType PTR_INP = new CaseType(-957, "Inpatient", true, null, null, Color.Default);
	public static final CaseType PTR_OUT = new CaseType(-958, "PTR Outpatient", true, null, null, Color.Default);
	public static final CaseType PTR_DAY = new CaseType(-959, "Day Case", true, null, null, Color.Default);
}
