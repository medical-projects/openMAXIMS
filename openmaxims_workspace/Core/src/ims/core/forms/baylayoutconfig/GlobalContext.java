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

package ims.core.forms.baylayoutconfig;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		STHK = new STHKContext(context);
	}
	public final class STHKContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private STHKContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getWardBayConfigVoIsNotNull()
		{
			return !cx_STHKWardBayConfigVo.getValueIsNull(context);
		}
		public ims.core.vo.WardBayConfigVo getWardBayConfigVo()
		{
			return (ims.core.vo.WardBayConfigVo)cx_STHKWardBayConfigVo.getValue(context);
		}
		public void setWardBayConfigVo(ims.core.vo.WardBayConfigVo value)
		{
			cx_STHKWardBayConfigVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_STHKWardBayConfigVo = new ims.framework.ContextVariable("STHK.WardBayConfigVo", "_cv_STHK.WardBayConfigVo");

		private ims.framework.Context context;
	}

	public STHKContext STHK;
}
