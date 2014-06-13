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

package ims.core.forms.carecontextselectdialog;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Clinical = new ClinicalForms();
			Core = new CoreForms();
			Therapies = new TherapiesForms();
		}
		public final class ClinicalForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalForms()
			{
				Procedures = new LocalFormName(123119);
				PatientProblems = new LocalFormName(123120);
				DiagnosisComplications = new LocalFormName(123117);
				ClinicalDiAssociations = new LocalFormName(123121);
				ClinicalNoteDrawing = new LocalFormName(102177);
				ClinicalNoteDrawingDialog = new LocalFormName(102175);
				ClinicalNotesDialog = new LocalFormName(102176);
				DiagnosisComplications_Dialog = new LocalFormName(123130);
				PatientProblems_Dialog = new LocalFormName(123129);
				Procedures_Dialog = new LocalFormName(123134);
			}
			public final FormName Procedures;
			public final FormName PatientProblems;
			public final FormName DiagnosisComplications;
			public final FormName ClinicalDiAssociations;
			public final FormName ClinicalNoteDrawing;
			public final FormName ClinicalNoteDrawingDialog;
			public final FormName ClinicalNotesDialog;
			public final FormName DiagnosisComplications_Dialog;
			public final FormName PatientProblems_Dialog;
			public final FormName Procedures_Dialog;
		}
		public final class CoreForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CoreForms()
			{
				CareSpellDialog = new LocalFormName(102216);
			}
			public final FormName CareSpellDialog;
		}
		public final class TherapiesForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private TherapiesForms()
			{
				SOAPNoteDialog = new LocalFormName(112149);
			}
			public final FormName SOAPNoteDialog;
		}

		public ClinicalForms Clinical;
		public CoreForms Core;
		public TherapiesForms Therapies;
	}
}
