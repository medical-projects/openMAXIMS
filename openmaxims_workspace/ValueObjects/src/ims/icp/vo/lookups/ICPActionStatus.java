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

package ims.icp.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ICPActionStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ICPActionStatus()
	{
		super();
	}
	public ICPActionStatus(int id)
	{
		super(id, "", true);
	}
	public ICPActionStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ICPActionStatus(int id, String text, boolean active, ICPActionStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ICPActionStatus(int id, String text, boolean active, ICPActionStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ICPActionStatus(int id, String text, boolean active, ICPActionStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ICPActionStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ICPActionStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ICPActionStatus)super.getParentInstance();
	}
	public ICPActionStatus getParent()
	{
		return (ICPActionStatus)super.getParentInstance();
	}
	public void setParent(ICPActionStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ICPActionStatus[] typedChildren = new ICPActionStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ICPActionStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ICPActionStatus)
		{
			super.addChild((ICPActionStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ICPActionStatus)
		{
			super.removeChild((ICPActionStatus)child);
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
		ICPActionStatusCollection result = new ICPActionStatusCollection();
		result.add(NOTINSCOPE);
		result.add(OUTSTANDING);
		result.add(MET);
		result.add(NOT_MET);
		return result;
	}
	public static ICPActionStatus[] getNegativeInstances()
	{
		ICPActionStatus[] instances = new ICPActionStatus[4];
		instances[0] = NOTINSCOPE;
		instances[1] = OUTSTANDING;
		instances[2] = MET;
		instances[3] = NOT_MET;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "NOTINSCOPE";
		negativeInstances[1] = "OUTSTANDING";
		negativeInstances[2] = "MET";
		negativeInstances[3] = "NOT_MET";
		return negativeInstances;
	}
	public static ICPActionStatus getNegativeInstance(String name)
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
	public static ICPActionStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ICPActionStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1181014;
	public static final ICPActionStatus NOTINSCOPE = new ICPActionStatus(-1752, "Not In Scope", true, null, null, Color.Default);
	public static final ICPActionStatus OUTSTANDING = new ICPActionStatus(-1753, "Outstanding", true, null, new ims.framework.utils.ImagePath(118110, "Images/ICP/ACTION_OUTSANDING_16.png"), Color.Default);
	public static final ICPActionStatus MET = new ICPActionStatus(-1754, "Met", true, null, new ims.framework.utils.ImagePath(118108, "Images/ICP/ACION_MET_16.png"), Color.Default);
	public static final ICPActionStatus NOT_MET = new ICPActionStatus(-1755, "Not Met", true, null, new ims.framework.utils.ImagePath(118109, "Images/ICP/ACTION_NOT_MET_16.png"), Color.Default);
}
