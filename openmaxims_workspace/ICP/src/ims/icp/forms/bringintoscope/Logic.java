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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3478.14513)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.forms.bringintoscope;

import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.icp.forms.bringintoscope.GenForm.grdActionsRow;
import ims.icp.forms.bringintoscope.GenForm.grdActionsRowCollection;
import ims.icp.vo.ICPActionLiteVo;
import ims.icp.vo.ICPActionVo;
import ims.icp.vo.ICPConfigurationDisplayVo;
import ims.icp.vo.ICPPhaseDisplayVo;
import ims.icp.vo.ICPPhaseLiteVo;
import ims.icp.vo.ICPPhaseVo;
import ims.icp.vo.ICPStageDisplayVo;
import ims.icp.vo.ICPStageLiteVo;
import ims.icp.vo.ICPStageVo;
import ims.icp.vo.PatientICPActionLiteVo;
import ims.icp.vo.PatientICPPhasesLiteVo;
import ims.icp.vo.PatientICPShortVo;
import ims.icp.vo.PatientICPStagesLiteVo;
import ims.icp.vo.lookups.ICPPhaseStatus;
import ims.icp.vo.lookups.ICPStageStatus;
import ims.icps.configuration.vo.ICPPhaseRefVo;
import ims.icps.configuration.vo.ICPStageRefVo;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if ("S".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()))
		{
			engine.setCaption("Bring stage into scope");
		}
		else if ("P".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()))
		{
			engine.setCaption("Bring phase into scope");
		}

		open();
	}

	private void open()
	{
		form.grdActions().getRows().clear();

		form.btnSave().setEnabled(false);

		if (form.getGlobalContext().ICP.getPatientICPRecord() == null)
			return;

		PatientICPShortVo patientICP = null;
		ICPConfigurationDisplayVo configurationICP = null;

		try
		{
			patientICP = domain.getPatientICPShort(form.getGlobalContext().ICP.getPatientICPRecord());
			configurationICP = domain.getConfigurationICP(patientICP.getICP());
		}
		catch (DomainInterfaceException e1)
		{
			e1.printStackTrace();
			engine.showMessage(e1.getMessage());
			return;
		}

		// Populate the grid
		populateICP(configurationICP, patientICP);
		
		// Remove Inactive configuration ICP data
		removeConfigurationICPRows(form.grdActions().getRows());
	}

	private void removeConfigurationICPRows(grdActionsRowCollection rowCollection)
	{
		// Check row collection
		if (rowCollection == null)
			return;
		
		// Iterate backwards row collection
		for (int i = rowCollection.size() - 1; i >= 0; i--)
		{
			grdActionsRow row = rowCollection.get(i);

			// Skip null rows
			if (row == null)
				continue;
			
			// Check if the row is a non active ICP stage
			if (row.getValue() instanceof ICPStageLiteVo && !PreActiveActiveInactiveStatus.ACTIVE.equals(((ICPStageLiteVo)row.getValue()).getStatus()))
			{
				// Remove the row
				rowCollection.remove(i);
				// Move to next row - KEEP continue to reduce computation time
				continue;
			}
			// Check if the row is a non active ICP phase
			else if (row.getValue() instanceof ICPPhaseLiteVo && !PreActiveActiveInactiveStatus.ACTIVE.equals(((ICPPhaseLiteVo)row.getValue()).getStatus()))
			{
				// Remove the row
				rowCollection.remove(i);
				// Move to next row - KEEP continue to reduce computation time
				continue;
			}
			// Check if the row is a non active ICP Action
			else if (row.getValue() instanceof ICPActionVo && !PreActiveActiveInactiveStatus.ACTIVE.equals(((ICPActionVo)row.getValue()).getStatus()))
			{
				// Remove the row
				rowCollection.remove(i);
				// Move to next row - KEEP continue to reduce computation time
				continue;
			}

			// Check the child rows for rows needed to be removed
			removeConfigurationICPRows(row.getRows());
		}
	}

	private void populateICP(ICPConfigurationDisplayVo configurationICP, PatientICPShortVo patientICP)
	{
		// Clear grid
		form.grdActions().getRows().clear();

		// Test configuration ICP and patient ICP
		if (configurationICP == null && patientICP == null)
			return;

		// Populate configuration ICP
		populateConfigurationICP(configurationICP);
		
		// Update stages, phases and actions present in Patient ICP
		populatePatientICP(patientICP);
		
		// Collapse all rows
		form.grdActions().collapseAll();
	}

	private void populatePatientICP(PatientICPShortVo patientICP)
	{
		// Test patient ICP and stages
		if (patientICP == null || !patientICP.getStagesIsNotNull())
			return;
		
		// Sort the stages
		patientICP.getStages().sort(new StageComparator());
		
		// Iterate stages
		for (PatientICPStagesLiteVo stage : patientICP.getStages())
		{
			if (stage == null)
				continue;
			
			// Update configuration stage to Patient stage
			grdActionsRow stageRow = form.grdActions().getRowByValue(stage.getStage());
			
			if (stageRow == null)
			{
				stageRow = form.grdActions().getRows().newRow();
			}
			
			updatePatientICPStage(stageRow, stage);
		}
	}

	private void updatePatientICPStage(grdActionsRow row, PatientICPStagesLiteVo stage)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not populate null row (in function updatePatientICPStage");
		
		// Check stage
		if (stage == null)
			return;
		
		// Update stage name
		row.setColAction(stage.getStageIsNotNull() ? stage.getStage().getName() : "");
		
		// Update row value
		row.setValue(stage);
		
		// Update images
		row.setExpandedImage(form.getImages().ICP.Stage);
		row.setCollapsedImage(form.getImages().ICP.Stage);
		
		// Update row as selectable, read-only
		row.setReadOnly(true);
		row.setSelectable(ICPStageStatus.NOTINSCOPE.equals(stage.getCurrentStatusIsNotNull() ? stage.getCurrentStatus().getStatus() : null) 
//				&& !PreActiveActiveInactiveStatus.INACTIVE.equals(stage.getStageIsNotNull() ? stage.getStage().getStatus() : null) 
				&& "S".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()));
		
		// Update colors
		row.setBackColor(null);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(stage.getStageIsNotNull() ? stage.getStage().getStatus() : null) ? Color.Gray : Color.Black);
		
		// Test stage phases
		if (stage.getStagePhasesIsNotNull())
		{
			// Sort the phases
			stage.getStagePhases().sort(new PhaseComparator());
			
			// Iterate phases
			for (PatientICPPhasesLiteVo phase : stage.getStagePhases())
			{
				if (phase == null)
					continue;
				
				// Update phase row
				grdActionsRow phaseRow = form.grdActions().getRowByValue(phase.getPhase());
				
				if (phaseRow == null)
				{
					phaseRow = row.getRows().newRow();
				}
				
				updatePatientICPPhase(phaseRow, phase);
			}
		}
	}

	private void updatePatientICPPhase(grdActionsRow row, PatientICPPhasesLiteVo phase)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not populate null row (in function updatePatientICPPhase");
		
		// Check phase
		if (phase == null)
			return;
		
		// Update phase name
		row.setColAction(phase.getPhaseIsNotNull() ? phase.getPhase().getName() : "");
		
		// Update row value
		row.setValue(phase);
		
		// Update images
		row.setExpandedImage(form.getImages().ICP.Phase);
		row.setCollapsedImage(form.getImages().ICP.Phase);
		
		// Update row as selectable, read-only
		row.setReadOnly(true);
		row.setSelectable(ICPPhaseStatus.NOTINSCOPE.equals(phase.getCurrentStatusIsNotNull() ? phase.getCurrentStatus().getStatus() : null) 
//				&& !PreActiveActiveInactiveStatus.INACTIVE.equals(phase.getPhaseIsNotNull() ? phase.getPhase().getStatus() : null) 
				&& "P".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()));
		
		// Update colors
		row.setBackColor(null);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(phase.getPhaseIsNotNull() ? phase.getPhase().getStatus() : null) ? Color.Gray : Color.Black);
		
		// Test the actions
		if (phase.getPhaseActionsIsNotNull())
		{
			// Sort the actions
			phase.getPhaseActions().sort(new ActionComparator());
			
			// Iterate actions
			for (PatientICPActionLiteVo action : phase.getPhaseActions())
			{
				if (action == null)
					continue;
				
				// Update action row
				grdActionsRow actionRow = form.grdActions().getRowByValue(action.getAction());
				
				if (actionRow == null)
				{
					actionRow = row.getRows().newRow();
				}
				
				updatePatientICPAction(actionRow, action);
			}
		}
	}

	private void updatePatientICPAction(grdActionsRow row, PatientICPActionLiteVo action)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not populate null row (in function updatePatientICPAction");
		
		// Check action
		if (action == null)
			return;
		
		// Update action name
		row.setColAction(action.getActionIsNotNull() ? action.getAction().getName() : "");
		
		// Update row value
		row.setValue(action);
		
		// Update images
		row.setExpandedImage(form.getImages().ICP.Action);
		row.setCollapsedImage(form.getImages().ICP.Action);
		
		// Update row as selectable, read-only
		row.setSelectable(false);
		row.setReadOnly(true);
		
		// Update color
		row.setBackColor(null);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(action.getActionIsNotNull() ? action.getAction().getStatus() : null) ? Color.Gray : Color.Black);
		
	}

	private void populateConfigurationICP(ICPConfigurationDisplayVo configurationICP)
	{
		// Test configuration ICP and stages
		if (configurationICP == null || !configurationICP.getStagesIsNotNull())
			return;

		// Sort the stages
		configurationICP.getStages().sort(new StageComparator());

		// Iterate stages
		for (ICPStageDisplayVo stage : configurationICP.getStages())
		{
			if (stage == null)
				continue;

			// Populate configuration ICP stage
			populateConfigurationICPStage(form.grdActions().getRows().newRow(), stage);
		}
	}

	private void populateConfigurationICPStage(grdActionsRow row, ICPStageDisplayVo stage)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not populate null row (in function populateConfigurationICPStage");

		// Check stage
		if (stage == null)
			return;

		// Add stage name
		row.setColAction(stage.getNameIsNotNull() ? stage.getName() : "");

		// Add stage to row value
		row.setValue(stage);

		// Set images
		row.setExpandedImage(form.getImages().ICP.Stage);
		row.setCollapsedImage(form.getImages().ICP.Stage);

		// Set row as selectable, read-only
		row.setSelectable(!PreActiveActiveInactiveStatus.INACTIVE.equals(stage.getStatus()) && "S".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()));
		row.setReadOnly(true);
		
		// Set colors
		row.setBackColor(Color.Beige);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(stage.getStatus()) ? Color.Gray : Color.Black);
		

		// Test stage phases
		if (stage.getPhasesIsNotNull())
		{
			// Sort the phases
			stage.getPhases().sort(new PhaseComparator());

			// Iterate phases
			for (ICPPhaseDisplayVo phase : stage.getPhases())
			{
				if (phase == null)
					continue;

				// Add phase to stage row
				populateConfigurationICPPhase(row.getRows().newRow(), phase);
			}
		}
	}

	private void populateConfigurationICPPhase(grdActionsRow row, ICPPhaseDisplayVo phase)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error = Can not populate null row (in function populateConfigurationICPPhase");
		
		// Check phase
		if (phase == null)
			return;
		
		// Add phase name
		row.setColAction(phase.getNameIsNotNull() ? phase.getName() : "");
		
		// Add phase to row value
		row.setValue(phase);
		
		// Set images
		row.setExpandedImage(form.getImages().ICP.Phase);
		row.setCollapsedImage(form.getImages().ICP.Phase);
		
		// Set row as selectable, read-only
		row.setSelectable(!PreActiveActiveInactiveStatus.INACTIVE.equals(phase.getStatus()) && "P".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()));
		row.setReadOnly(true);
		
		// Set colors
		row.setBackColor(Color.Beige);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(phase.getStatus()) ? Color.Gray : Color.Black);
		
		// KEEP CODE AS ACTIONS MIGHT BE USED IN THE FUTURE
		
		// Test phase actions
		if (phase.getActionsIsNotNull())
		{
			// Sort the actions
			phase.getActions().sort(new ActionComparator());
			
			// Iterate actions
			for (ICPActionLiteVo action : phase.getActions())
			{
				if (action == null)
					continue;
				
				// Add action to phase row
				populateConfigurationICPAction(row.getRows().newRow(), action);
			}
		}
	}

	private void populateConfigurationICPAction(grdActionsRow row, ICPActionLiteVo action)
	{
		// Check row
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not populate null row (in function populateConfigurationICPAction");
		
		// Check action
		if (action == null)
			return;
		
		// Add action name
		row.setColAction(action.getNameIsNotNull() ? action.getName() : "");
		
		// Add action to row value
		row.setValue(action);
		
		// Set images
		row.setExpandedImage(form.getImages().ICP.Action);
		row.setCollapsedImage(form.getImages().ICP.Action);
		
		// Set row as selectable, read-only
		row.setSelectable(false);
		row.setReadOnly(true);
		
		// Set colors
		row.setBackColor(Color.Beige);
		row.setTextColor(PreActiveActiveInactiveStatus.INACTIVE.equals(action.getStatus()) ? Color.Gray : Color.Black);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			if ("S".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()))
			{
				if (form.grdActions().getValue() instanceof PatientICPStagesLiteVo)
				{
					domain.bringStageIntoScope(form.getGlobalContext().ICP.getPatientICPRecord(), ((PatientICPStagesLiteVo)form.grdActions().getValue()).getStage());
				}
				else if (form.grdActions().getValue() instanceof ICPStageRefVo)
				{
					domain.bringStageIntoScope(form.getGlobalContext().ICP.getPatientICPRecord(), (ICPStageRefVo) form.grdActions().getValue());
				}
			}
			else if ("P".equalsIgnoreCase(form.getGlobalContext().ICP.getTypeToSelect()))
			{
				if (form.grdActions().getValue() instanceof PatientICPPhasesLiteVo)
				{
					domain.bringPhaseIntoScope(form.getGlobalContext().ICP.getPatientICPRecord(), ((PatientICPPhasesLiteVo)form.grdActions().getValue()).getPhase());
				}
				else if (form.grdActions().getValue() instanceof ICPPhaseRefVo)
				{
					domain.bringPhaseIntoScope(form.getGlobalContext().ICP.getPatientICPRecord(), (ICPPhaseRefVo) form.grdActions().getValue());
				}
			}
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return;
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (DomainRuntimeException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return;
		}

		engine.close(DialogResult.OK);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onGrdActionsSelectionChanged() throws PresentationLogicException
	{
		form.btnSave().setEnabled(true);
	}

	@SuppressWarnings("unchecked")
	public class StageComparator implements Comparator
	{
		// PatientICPStagesLiteVo
		// ICPStageDisplayVo
		
		public int compare(Object arg0, Object arg1)
		{
			if (arg0 instanceof PatientICPStagesLiteVo && arg1 instanceof PatientICPStagesLiteVo)
			{
				return ((PatientICPStagesLiteVo) arg0).getStage().getSequence().compareTo(((PatientICPStagesLiteVo) arg1).getStage().getSequence());
			}
			
			if (arg0 instanceof ICPStageDisplayVo && arg1 instanceof ICPStageDisplayVo)
			{
				return ((ICPStageDisplayVo) arg0).getSequence().compareTo(((ICPStageDisplayVo)arg1).getSequence());
			}
			
			if (arg0 instanceof ICPStageDisplayVo && arg1 instanceof PatientICPStagesLiteVo)
			{
				return ((ICPStageDisplayVo) arg0).getSequence().compareTo(((PatientICPStagesLiteVo) arg1).getStage().getSequence());
			}
			
			if (arg0 instanceof PatientICPStagesLiteVo && arg1 instanceof ICPStageDisplayVo)
			{
				return ((PatientICPStagesLiteVo) arg0).getStage().getSequence().compareTo(((ICPStageDisplayVo)arg1).getSequence());
			}

			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public class PhaseComparator implements Comparator
	{
		// PatientICPPhasesLiteVo
		// ICPPhaseDisplayVo
		
		public int compare(Object arg0, Object arg1)
		{
			if (arg0 instanceof PatientICPPhasesLiteVo && arg1 instanceof PatientICPPhasesLiteVo)
			{
				return ((PatientICPPhasesLiteVo) arg0).getPhase().getSequence().compareTo(((PatientICPPhasesLiteVo) arg1).getPhase().getSequence());
			}
			
			if (arg0 instanceof ICPPhaseDisplayVo && arg1 instanceof ICPPhaseDisplayVo)
			{
				return ((ICPPhaseDisplayVo)arg0).getSequence().compareTo(((ICPPhaseDisplayVo)arg1).getSequence());
			}
			
			if (arg0 instanceof PatientICPPhasesLiteVo && arg1 instanceof ICPPhaseDisplayVo)
			{
				return ((PatientICPPhasesLiteVo) arg0).getPhase().getSequence().compareTo(((ICPPhaseDisplayVo)arg1).getSequence());
			}
			
			if (arg0 instanceof ICPPhaseDisplayVo && arg1 instanceof PatientICPPhasesLiteVo)
			{
				return ((ICPPhaseDisplayVo)arg0).getSequence().compareTo(((PatientICPPhasesLiteVo) arg1).getPhase().getSequence());
			}

			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public class ActionComparator implements Comparator
	{
		public int compare(Object arg0, Object arg1)
		{
			if (arg0 instanceof PatientICPActionLiteVo && arg1 instanceof PatientICPActionLiteVo)
			{
				return ((PatientICPActionLiteVo) arg0).getAction().getSequence().compareTo(((PatientICPActionLiteVo) arg1).getAction().getSequence());
			}
			
			if (arg0 instanceof ICPActionLiteVo && arg1 instanceof ICPActionLiteVo)
			{
				return ((ICPActionLiteVo) arg0).getSequence().compareTo(((ICPActionLiteVo)arg1).getSequence());
			}
			
			if (arg0 instanceof PatientICPActionLiteVo && arg1 instanceof ICPActionLiteVo)
			{
				return ((PatientICPActionLiteVo) arg0).getAction().getSequence().compareTo(((ICPActionLiteVo)arg1).getSequence());
			}
			
			if (arg0 instanceof ICPActionLiteVo && arg1 instanceof PatientICPActionLiteVo)
			{
				return ((ICPActionLiteVo) arg0).getSequence().compareTo(((PatientICPActionLiteVo) arg1).getAction().getSequence());
			}

			return 0;
		}
	}

}
