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

package ims.assessment.forms.assessmentfavourites;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getGraphicAssessmentsSelectableIsNotNull()
		{
			return !cx_CoreGraphicAssessmentsSelectable.getValueIsNull(context);
		}
		public Boolean getGraphicAssessmentsSelectable()
		{
			return (Boolean)cx_CoreGraphicAssessmentsSelectable.getValue(context);
		}
		public void setGraphicAssessmentsSelectable(Boolean value)
		{
			cx_CoreGraphicAssessmentsSelectable.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGraphicAssessmentsSelectable = new ims.framework.ContextVariable("Core.GraphicAssessmentsSelectable", "_cv_Core.GraphicAssessmentsSelectable");
		public boolean getStructuredAssessmentsSelectableIsNotNull()
		{
			return !cx_CoreStructuredAssessmentsSelectable.getValueIsNull(context);
		}
		public Boolean getStructuredAssessmentsSelectable()
		{
			return (Boolean)cx_CoreStructuredAssessmentsSelectable.getValue(context);
		}
		public void setStructuredAssessmentsSelectable(Boolean value)
		{
			cx_CoreStructuredAssessmentsSelectable.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreStructuredAssessmentsSelectable = new ims.framework.ContextVariable("Core.StructuredAssessmentsSelectable", "_cv_Core.StructuredAssessmentsSelectable");
		public boolean getSelectedUserAssessmentVoIsNotNull()
		{
			return !cx_CoreSelectedUserAssessmentVo.getValueIsNull(context);
		}
		public ims.assessment.vo.UserAssessmentVo getSelectedUserAssessmentVo()
		{
			return (ims.assessment.vo.UserAssessmentVo)cx_CoreSelectedUserAssessmentVo.getValue(context);
		}
		public void setSelectedUserAssessmentVo(ims.assessment.vo.UserAssessmentVo value)
		{
			cx_CoreSelectedUserAssessmentVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedUserAssessmentVo = new ims.framework.ContextVariable("Core.SelectedUserAssessmentVo", "_cv_Core.SelectedUserAssessmentVo");
		public boolean getSelectedGraphicAssessmentVoIsNotNull()
		{
			return !cx_CoreSelectedGraphicAssessmentVo.getValueIsNull(context);
		}
		public ims.assessment.vo.GraphicAssessmentVo getSelectedGraphicAssessmentVo()
		{
			return (ims.assessment.vo.GraphicAssessmentVo)cx_CoreSelectedGraphicAssessmentVo.getValue(context);
		}
		public void setSelectedGraphicAssessmentVo(ims.assessment.vo.GraphicAssessmentVo value)
		{
			cx_CoreSelectedGraphicAssessmentVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedGraphicAssessmentVo = new ims.framework.ContextVariable("Core.SelectedGraphicAssessmentVo", "_cv_Core.SelectedGraphicAssessmentVo");
		public boolean getGraphicAssessmentShortVoIsNotNull()
		{
			return !cx_CoreGraphicAssessmentShortVo.getValueIsNull(context);
		}
		public ims.assessment.vo.GraphicAssessmentShortVo getGraphicAssessmentShortVo()
		{
			return (ims.assessment.vo.GraphicAssessmentShortVo)cx_CoreGraphicAssessmentShortVo.getValue(context);
		}
		public void setGraphicAssessmentShortVo(ims.assessment.vo.GraphicAssessmentShortVo value)
		{
			cx_CoreGraphicAssessmentShortVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGraphicAssessmentShortVo = new ims.framework.ContextVariable("Core.GraphicAssessmentShortVo", "_cv_Core.GraphicAssessmentShortVo");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
