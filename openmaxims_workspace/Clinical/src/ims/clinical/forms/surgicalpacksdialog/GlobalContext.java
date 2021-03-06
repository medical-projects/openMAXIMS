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

package ims.clinical.forms.surgicalpacksdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSurgicalAuditSurgicalPackIsNotNull()
		{
			return !cx_ClinicalSurgicalAuditSurgicalPack.getValueIsNull(context);
		}
		public ims.clinical.vo.SurgicalAuditSurgicalPackVo getSurgicalAuditSurgicalPack()
		{
			return (ims.clinical.vo.SurgicalAuditSurgicalPackVo)cx_ClinicalSurgicalAuditSurgicalPack.getValue(context);
		}
		public void setSurgicalAuditSurgicalPack(ims.clinical.vo.SurgicalAuditSurgicalPackVo value)
		{
			cx_ClinicalSurgicalAuditSurgicalPack.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSurgicalAuditSurgicalPack = new ims.framework.ContextVariable("Clinical.SurgicalAuditSurgicalPack", "_cv_Clinical.SurgicalAuditSurgicalPack");
		public boolean getSurgicalAuditAddEditSurgicalPackIsNotNull()
		{
			return !cx_ClinicalSurgicalAuditAddEditSurgicalPack.getValueIsNull(context);
		}
		public Boolean getSurgicalAuditAddEditSurgicalPack()
		{
			return (Boolean)cx_ClinicalSurgicalAuditAddEditSurgicalPack.getValue(context);
		}
		public void setSurgicalAuditAddEditSurgicalPack(Boolean value)
		{
			cx_ClinicalSurgicalAuditAddEditSurgicalPack.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSurgicalAuditAddEditSurgicalPack = new ims.framework.ContextVariable("Clinical.SurgicalAuditAddEditSurgicalPack", "_cv_Clinical.SurgicalAuditAddEditSurgicalPack");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
}
