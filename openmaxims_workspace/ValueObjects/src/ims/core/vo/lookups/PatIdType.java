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

public class PatIdType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PatIdType()
	{
		super();
	}
	public PatIdType(int id)
	{
		super(id, "", true);
	}
	public PatIdType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PatIdType(int id, String text, boolean active, PatIdType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PatIdType(int id, String text, boolean active, PatIdType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PatIdType(int id, String text, boolean active, PatIdType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PatIdType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PatIdType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PatIdType)super.getParentInstance();
	}
	public PatIdType getParent()
	{
		return (PatIdType)super.getParentInstance();
	}
	public void setParent(PatIdType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PatIdType[] typedChildren = new PatIdType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PatIdType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PatIdType)
		{
			super.addChild((PatIdType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PatIdType)
		{
			super.removeChild((PatIdType)child);
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
		PatIdTypeCollection result = new PatIdTypeCollection();
		result.add(PKEY);
		result.add(HOSPNUM);
		result.add(NHSN);
		result.add(PPSN);
		result.add(CHARTNUM);
		result.add(NTPFNUM);
		result.add(SENTNUM);
		result.add(DISTRICT);
		result.add(CASENUM);
		result.add(EMPI);
		result.add(CLIENTID);
		result.add(GMSID);
		result.add(PASID);
		result.add(PATNUM);
		result.add(PXNUMBER);
		result.add(MRNNUM);
		return result;
	}
	public static PatIdType[] getNegativeInstances()
	{
		PatIdType[] instances = new PatIdType[16];
		instances[0] = PKEY;
		instances[1] = HOSPNUM;
		instances[2] = NHSN;
		instances[3] = PPSN;
		instances[4] = CHARTNUM;
		instances[5] = NTPFNUM;
		instances[6] = SENTNUM;
		instances[7] = DISTRICT;
		instances[8] = CASENUM;
		instances[9] = EMPI;
		instances[10] = CLIENTID;
		instances[11] = GMSID;
		instances[12] = PASID;
		instances[13] = PATNUM;
		instances[14] = PXNUMBER;
		instances[15] = MRNNUM;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[16];
		negativeInstances[0] = "PKEY";
		negativeInstances[1] = "HOSPNUM";
		negativeInstances[2] = "NHSN";
		negativeInstances[3] = "PPSN";
		negativeInstances[4] = "CHARTNUM";
		negativeInstances[5] = "NTPFNUM";
		negativeInstances[6] = "SENTNUM";
		negativeInstances[7] = "DISTRICT";
		negativeInstances[8] = "CASENUM";
		negativeInstances[9] = "EMPI";
		negativeInstances[10] = "CLIENTID";
		negativeInstances[11] = "GMSID";
		negativeInstances[12] = "PASID";
		negativeInstances[13] = "PATNUM";
		negativeInstances[14] = "PXNUMBER";
		negativeInstances[15] = "MRNNUM";
		return negativeInstances;
	}
	public static PatIdType getNegativeInstance(String name)
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
	public static PatIdType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PatIdType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 624;
	public static final PatIdType PKEY = new PatIdType(-149, "Patient Key", true, null, null, Color.Black);
	public static final PatIdType HOSPNUM = new PatIdType(-150, "Hospital No.", true, null, null, Color.Black);
	public static final PatIdType NHSN = new PatIdType(-9, "NHS Number", true, null, null, Color.Black);
	public static final PatIdType PPSN = new PatIdType(-151, "PPSN", true, null, null, Color.Black);
	public static final PatIdType CHARTNUM = new PatIdType(-44, "Chart Number", true, null, null, Color.Black);
	public static final PatIdType NTPFNUM = new PatIdType(-439, "NTPF No.", true, null, null, Color.Default);
	public static final PatIdType SENTNUM = new PatIdType(-624, "Sentence Number", true, null, null, Color.Default);
	public static final PatIdType DISTRICT = new PatIdType(-904, "District Number", true, null, null, Color.Default);
	public static final PatIdType CASENUM = new PatIdType(-1223, "Case Number", true, null, null, Color.Default);
	public static final PatIdType EMPI = new PatIdType(-1418, "eMPI", true, null, null, Color.Default);
	public static final PatIdType CLIENTID = new PatIdType(-1422, "Client ID", true, null, null, Color.Default);
	public static final PatIdType GMSID = new PatIdType(-1423, "GMSID", true, null, null, Color.Default);
	public static final PatIdType PASID = new PatIdType(-1867, "PASID", true, null, null, Color.Default);
	public static final PatIdType PATNUM = new PatIdType(-1905, "Patient Number", true, null, null, Color.Default);
	public static final PatIdType PXNUMBER = new PatIdType(-2211, "PXNUMBER", true, null, null, Color.Default);
	public static final PatIdType MRNNUM = new PatIdType(-2404, "MRN Number", true, null, null, Color.Default);
}
