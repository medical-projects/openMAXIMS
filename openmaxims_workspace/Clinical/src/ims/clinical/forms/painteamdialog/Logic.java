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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3742.21224)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.painteamdialog;

import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccAuthoring().setIsRequiredPropertyToControls(true);
		form.ccAuthoring().initializeComponent();
		String[] problem = new String[]
		                   {"Nausea/Vomiting","Puritis","Sedation","Low respiratory rate","Hypotension","Inadequate analgesia",
							"Pump malfunction","Epidural fallen out","Epidural leaking","Pain at epidural site/haematoma/abscess",
							"Motor block","Unilateral block","Inadequate block","Epidural disconnected at filter","No lockit",
							"Post dural headache", "Urinary retention","Other"};
		String[] interventions = new String[]
                            {"Antiemetic","Antihistamine","Naloxone given","Colloid given","Additional analgesia/Change mix",
							 "Stop/Restart pump","New epidural sited","Catheter pulled back","Bolus epidural/change rate",
							 "Flush Epidural","Send epidural tip for M,C & S","Refer to Pain Consultant/Anaesthetist"
							 ,"Set up PCA/Loading dose", "Others" };
		String[] pain = new String[]
		                    {"Epidural site inspected", "Dressing", "Colloid prescribed", "Red warning label", "Correct prescribing yellow label",
							 "Epidural catheter label", "Demands/Good mls/hr","Obs Recorded as guidelines","Pain Scores - Rest/Movement",
							 "Bromage scores(0-4)","Block level"};
		
		form.dyngrdAssesment().setSelectable(false);
		DynamicGridColumn columnDescription = form.dyngrdAssesment().getColumns().newColumn("Pain Nurse Check",new Integer(1));
		columnDescription.setWidth(350);
		DynamicGridColumn columnCheck = form.dyngrdAssesment().getColumns().newColumn("Select",new Integer(2));
		columnCheck.setWidth(50);
		DynamicGridColumn columnComments = form.dyngrdAssesment().getColumns().newColumn("Comment", new Integer(3));
		columnComments.setWidth(-1);
		
		DynamicGridRow newRow = form.dyngrdAssesment().getRows().newRow();
		newRow.setSelectable(false);
		DynamicGridCell newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Problems");
		for (int i = 0 ; i< problem.length ; i++)
		{
			DynamicGridRow newChild = newRow.getRows().newRow();
			newChild.setSelectable(false);
					
			newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
			newCell.setValue(problem[i]);
			newCell = newChild.getCells().newCell(columnCheck,DynamicCellType.BOOL);
			newCell.setReadOnly(false);
			newCell = newChild.getCells().newCell(columnComments,DynamicCellType.STRING);
			newCell.setReadOnly(false);
		}
		newRow = form.dyngrdAssesment().getRows().newRow();
		newRow.setSelectable(false);
		newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Interventions");
		for (int i = 0 ; i< interventions.length ; i++)
		{
			DynamicGridRow newChild = newRow.getRows().newRow();
			newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
			newChild.setSelectable(false);
			newCell.setValue(interventions[i]);
			newCell = newChild.getCells().newCell(columnCheck,DynamicCellType.BOOL);
			newCell.setReadOnly(false);
			newCell = newChild.getCells().newCell(columnComments,DynamicCellType.STRING);
			newCell.setReadOnly(false);
		}
		newRow = form.dyngrdAssesment().getRows().newRow();
		newRow.setSelectable(false);
		newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Pain Nurse Checks");
		for (int i = 0 ; i< pain.length ; i++)
		{
			DynamicGridRow newChild = newRow.getRows().newRow();
			newChild.setSelectable(false);
			newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
			newCell.setValue(pain[i]);
			newCell = newChild.getCells().newCell(columnCheck,DynamicCellType.BOOL);
			newCell.setReadOnly(false);
			newCell = newChild.getCells().newCell(columnComments,DynamicCellType.STRING);
			newCell.setReadOnly(false);
		}
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
		
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
}
