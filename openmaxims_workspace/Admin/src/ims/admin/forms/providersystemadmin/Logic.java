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
// This code was generated by Michael Noonan using IMS Development Environment (version 1.53 build 2511.27271)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.providersystemadmin;

import ims.admin.forms.providersystemadmin.GenForm.GroupIPHostEnumeration;
import ims.admin.vo.ConfigPropertyVo;
import ims.admin.vo.ConfigPropertyVoCollection;
import ims.configuration.ConfigItems;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.vo.ProviderSystemVo;
import ims.ocrr.vo.ProviderSystemVoCollection;
import ims.ocrr.vo.lookups.Category;

import java.util.StringTokenizer;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	/**
	 * WDEV-13988
	 */
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	/**
	 * WDEV-13988
	 */
	protected void onCmbCategoryValueChanged() throws PresentationLogicException
	{
		// If ClinicalImaging is selected then default to saved values, else clear values
		if (Category.CLINICALIMAGING.equals(form.cmbCategory().getValue()) && form.getLocalContext().getSelectedRecordIsNotNull())
		{
			form.chkAssociateReferralLetter().setValue(Boolean.TRUE.equals(form.getLocalContext().getSelectedRecord().getSendReferralLetter()));
			form.chkAssociateSafetyQuestionnaire().setValue(Boolean.TRUE.equals(form.getLocalContext().getSelectedRecord().getSendQuestionnaire()));
		}
		else
		{
			form.chkAssociateReferralLetter().setValue(null);
			form.chkAssociateSafetyQuestionnaire().setValue(null);
		}
		
		updateControlsState();
	}

	private void initialize()
	{
		form.cmbIdComponent().clear();
		form.cmbIdComponent().newRow(new Integer(4), "Component 4");
		form.cmbIdComponent().newRow(new Integer(5), "Component 5");
		form.GroupIPHost().setValue(GroupIPHostEnumeration.rdoIP);

		// Populate the configuration items grid
		form.grdConfigurationItems().getRows().clear();
		GenForm.grdConfigurationItemsRow row;
		String[] configItems = ConfigItems.getProviderSystemsConfigItems();
		if (configItems != null)
		{
			for (int i = 0; i < configItems.length; i++)
			{
				row = form.grdConfigurationItems().getRows().newRow();
				row.setProperty(configItems[i]);
				row.setTooltip(configItems[i]);
			}
		}
	}

	private void open()
	{
		populateListControl(domain.listProviderSystems());

		// set selection back
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			// need to get timestamp from record retrieved from List call.
			GenForm.grdProviderSystemsRow row = form.grdProviderSystems().getRowByValue(form.getLocalContext().getSelectedRecord());
			if (row != null && row.getValue() != null)
			{
				form.getLocalContext().setSelectedRecord(row.getValue());
				form.grdProviderSystems().setValue(form.getLocalContext().getSelectedRecord());
				populateInstanceControl(form.grdProviderSystems().getValue());
			}
			else
				clearInstanceControls();
		}
		updateControlsState();

	}

	private void populateListControl(ProviderSystemVoCollection voCollProviderSys)
	{

		clear();

		if (voCollProviderSys != null)
		{
			GenForm.grdProviderSystemsRow row;
			for (int i = 0; i < voCollProviderSys.size(); i++)
			{
				row = form.grdProviderSystems().getRows().newRow();

				row.setValue(voCollProviderSys.get(i));
				row.setcolSystem(voCollProviderSys.get(i).getSystemName());
			}
		}
	}

	private void clear()
	{
		form.grdProviderSystems().getRows().clear();
		clearInstanceControls();
	}

	private void updateControlsState()
	{
		// WDEV-13988
		boolean radiologySelected = Category.CLINICALIMAGING.equals(form.cmbCategory().getValue());

		// WDEV-13988
		form.chkAssociateReferralLetter().setVisible(radiologySelected);
		form.chkAssociateReferralLetter().setEnabled(FormMode.EDIT.equals(form.getMode()));
		// WDEV-13988
		form.chkAssociateSafetyQuestionnaire().setVisible(radiologySelected);
		form.chkAssociateSafetyQuestionnaire().setEnabled(FormMode.EDIT.equals(form.getMode()));
		

		form.getContextMenus().getLIPNewItem().setText("New");

		updateIPAndHostControlsState();

		if (form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().getLIPNewItem().setVisible(false);
			form.getContextMenus().getLIPUpdateItem().setVisible(false);
		}
		else
		{
			if (form.grdProviderSystems().getSelectedRowIndex() >= 0)
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(true);
				form.btnUpdate().setVisible(true);

			}
			else
			{
				form.getContextMenus().getLIPNewItem().setVisible(true);
				form.getContextMenus().getLIPUpdateItem().setVisible(false);
				form.btnUpdate().setVisible(false);
			}
		}
	}

	private void updateIPAndHostControlsState()
	{
		if (form.GroupIPHost().getValue() == null)
			throw new CodingRuntimeException("No Default Value supplied for radio button group");

		form.txtHostName().setEnabled(form.getMode().equals(FormMode.EDIT) && form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoHost));
		form.intIP1().setEnabled(form.getMode().equals(FormMode.EDIT) && form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP));
		form.intIP2().setEnabled(form.getMode().equals(FormMode.EDIT) && form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP));
		form.intIP3().setEnabled(form.getMode().equals(FormMode.EDIT) && form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP));
		form.intIP4().setEnabled(form.getMode().equals(FormMode.EDIT) && form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP));
		form.GroupIPHost().setEnabled(form.getMode().equals(FormMode.EDIT));
	}

	private void clearInstanceControls()
	{
		form.intIP1().setValue(null);
		form.intIP2().setValue(null);
		form.intIP3().setValue(null);
		form.intIP4().setValue(null);
		form.txtHostName().setValue(null);
		form.cmbIdComponent().setValue(null);
		clearConfigurationItemsControl();
		super.clearScreen();

	}

	private void clearConfigurationItemsControl()
	{
		GenForm.grdConfigurationItemsRow row;
		for (int i = 0; i < form.grdConfigurationItems().getRows().size(); i++)
		{
			row = form.grdConfigurationItems().getRows().get(i);
			row.setColValue(null);
			row.setValue(null);
		}

	}

	private void populateInstanceControl(ProviderSystemVo voProviderSystem)
	{
		clearInstanceControls();

		if (voProviderSystem != null)
		{
			populateIpAddressesInstanceControls(voProviderSystem);
			form.cmbIdComponent().setValue(voProviderSystem.getIdtypeComponent());
			super.populateScreenFromData(voProviderSystem);

			populateConfigurationItemsControl(voProviderSystem);
		}

	}

	private void populateConfigurationItemsControl(ProviderSystemVo voProviderSystem)
	{
		if (!voProviderSystem.getConfigItemsIsNotNull())
			return;

		GenForm.grdConfigurationItemsRow row;
		for (int i = 0; i < form.grdConfigurationItems().getRows().size(); i++)
		{
			row = form.grdConfigurationItems().getRows().get(i);
			ConfigPropertyVo vo = voProviderSystem.getConfigurationProperty(row.getProperty());
			if (vo != null)
			{
				row.setValue(vo);
				row.setColValue(vo.getPropertyValue());
			}
		}

	}

	private void populateIpAddressesInstanceControls(ProviderSystemVo voProviderSystem)
	{
		String ipAddress = voProviderSystem.getIPAddress();
		if (ipAddress != null)
		{
			StringTokenizer strTokeniser = new StringTokenizer(ipAddress, ".");
			if (strTokeniser.countTokens() == 3)
			{
				String[] ipAddresses = ipAddress.split("\\.");
				if (ipAddresses.length == 4)
				{
					int intCount = 0;
					for (int i = 0; i < ipAddresses.length; i++)
					{
						if (getIntegerFromString(ipAddresses[i]) != null)
							intCount++;
					}

					if (intCount != ipAddresses.length)
					{
						form.txtHostName().setValue(ipAddress);
						form.GroupIPHost().setValue(GroupIPHostEnumeration.rdoHost);
					}
				}
			}
			else
			{
				String[] ipAddresses = ipAddress.split("\\.");
				if (ipAddresses != null)
				{
					int addrLength = ipAddresses.length;

					if (addrLength != 4)
					{
						form.txtHostName().setValue(ipAddress);
						form.GroupIPHost().setValue(GroupIPHostEnumeration.rdoHost);
						return;
					}

					if (addrLength > 0)
						form.intIP1().setValue(getIntegerFromString(ipAddresses[0]));
					if (addrLength > 1)
						form.intIP2().setValue(getIntegerFromString(ipAddresses[1]));
					if (addrLength > 2)
						form.intIP3().setValue(getIntegerFromString(ipAddresses[2]));
					if (addrLength > 3)
						form.intIP4().setValue(getIntegerFromString(ipAddresses[3]));
				}
				form.GroupIPHost().setValue(GroupIPHostEnumeration.rdoIP);
			}
		}
	}

	private Integer getIntegerFromString(String port)
	{
		if (port == null || port.equals(""))
			return null;

		try
		{
			return Integer.valueOf(port);
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	protected void onGrdProviderSystemsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedRecord(form.grdProviderSystems().getValue());
		populateInstanceControl(form.grdProviderSystems().getValue());
		updateControlsState();
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			open();
		}

	}

	private boolean save()
	{
		// Holder for any invalid IP address error messages
		String[] arrErrors = new String[1];
		ProviderSystemVo voProviderSystem = populateInstanceData(arrErrors);
		if(null == arrErrors[0])
		{
			arrErrors= null;
		}
		// validate Vo
		
		arrErrors = voProviderSystem.validate(arrErrors);

		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		try
		{
			form.getLocalContext().setSelectedRecord(domain.saveProviderSystem(voProviderSystem));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			// open();
			return false;
		}

		form.setMode(FormMode.VIEW);

		return true;
	}

	private ProviderSystemVo populateInstanceData(String[] arrErrors)
	{
		ProviderSystemVo voProviderSystem = form.getLocalContext().getSelectedRecord();

		if (voProviderSystem == null)
			voProviderSystem = new ProviderSystemVo();

		voProviderSystem.setIPAddress(getIpAddressFromScreen(arrErrors));
		voProviderSystem.setIdtypeComponent(form.cmbIdComponent().getValue());
		super.populateDataFromScreen(voProviderSystem);
		populateConfigItemsFromScreen(voProviderSystem);

		return voProviderSystem;
	}

	private String getIpAddressFromScreen(String[] arrErrors)
	{
		StringBuffer ipAddress = new StringBuffer();

		if (form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP))
		{
			Integer ips[] = new Integer[]{form.intIP1().getValue(), form.intIP2().getValue(), form.intIP3().getValue(), form.intIP4().getValue()};

			for (int i = 0; i < ips.length; i++)
			{
				Integer ip = ips[i];
				if (ip != null)
				{
					if(ip.intValue()>255)
					{
						arrErrors[0]  = "Invalid IP Address" ;
					}
					ipAddress.append(ip.toString());
				}
				if (i < (ips.length - 1) && ip != null)
					ipAddress.append(".");
			}
		}
		else
			return form.txtHostName().getValue();

		if (ipAddress.length() == 0)
			return null;

		return ipAddress.toString();
	}

	/**
	 * @param voProviderSystem
	 */
	private void populateConfigItemsFromScreen(ProviderSystemVo voProviderSystem)
	{
		ConfigPropertyVoCollection voColl = null;
		GenForm.grdConfigurationItemsRow row;
		for (int i = 0; i < form.grdConfigurationItems().getRows().size(); i++)
		{
			row = form.grdConfigurationItems().getRows().get(i);
			ConfigPropertyVo vo = row.getValue();
			if (vo == null)
				vo = new ConfigPropertyVo();
			vo.setPropertyName(row.getProperty());
			String itemVal = row.getColValue();
			if (itemVal != null && !itemVal.equals(""))
			{
				if (itemVal.equalsIgnoreCase("TRUE") || itemVal.equalsIgnoreCase("YES") || itemVal.equalsIgnoreCase("1") || itemVal.equalsIgnoreCase("Y"))
				{
					itemVal = "TRUE";
				}
				else if (itemVal.equalsIgnoreCase("FALSE") || itemVal.equalsIgnoreCase("NO") || itemVal.equalsIgnoreCase("0") || itemVal.equalsIgnoreCase("N"))
				{
					itemVal = "FALSE";
				}
				if (voColl == null)
					voColl = new ConfigPropertyVoCollection();

				vo.setPropertyValue(itemVal);
				voColl.add(vo);
			}
		}
		voProviderSystem.setConfigItems(voColl);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();
	}

	protected void onRadioButtonGroupIPHostValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoHost))
		{
			form.txtHostName().setEnabled(form.getMode().equals(FormMode.EDIT));
			form.intIP1().setEnabled(!form.getMode().equals(FormMode.EDIT));
			form.intIP2().setEnabled(!form.getMode().equals(FormMode.EDIT));
			form.intIP3().setEnabled(!form.getMode().equals(FormMode.EDIT));
			form.intIP4().setEnabled(!form.getMode().equals(FormMode.EDIT));
			form.intIP1().setValue(null);
			form.intIP2().setValue(null);
			form.intIP3().setValue(null);
			form.intIP4().setValue(null);
		}
		else if ((form.GroupIPHost().getValue().equals(GroupIPHostEnumeration.rdoIP)))
		{
			form.txtHostName().setEnabled(!form.getMode().equals(FormMode.EDIT));
			form.txtHostName().setValue(null);
			form.intIP1().setEnabled(form.getMode().equals(FormMode.EDIT));
			form.intIP2().setEnabled(form.getMode().equals(FormMode.EDIT));
			form.intIP3().setEnabled(form.getMode().equals(FormMode.EDIT));
			form.intIP4().setEnabled(form.getMode().equals(FormMode.EDIT));
		}
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		if (menuItemID == form.getContextMenus().getLIPNewItem().getID())
			newInstance();
		else if (menuItemID == form.getContextMenus().getLIPUpdateItem().getID())
			updateInstance();
	}

	private void newInstance()
	{
		// initalise the screen for a new record
		form.getLocalContext().setSelectedRecord(new ProviderSystemVo());
		clearInstanceControls();
		// set the form mode
		form.setMode(FormMode.EDIT);
		updateIPAndHostControlsState();

	}

	private void updateInstance()
	{
		if (allowUpdate())
		{
			form.setMode(FormMode.EDIT);
			updateIPAndHostControlsState();
		}

	}

	private boolean allowUpdate()
	{
		return (form.getLocalContext().getSelectedRecordIsNotNull());
	}

	@Override
	protected void onChkAssociateSafetyQuestionnaireValueChanged() throws PresentationLogicException
	{
		// Set 'Send Associated Referral Letter' to false 
		if (Boolean.TRUE.equals(form.chkAssociateSafetyQuestionnaire().getValue()))
		{
			form.chkAssociateReferralLetter().setValue(Boolean.FALSE);
		}
	}

	@Override
	protected void onChkAssociateReferralLetterValueChanged() throws PresentationLogicException
	{
		// Set 'Send Associated Safety Questionnaire' to false
		if (Boolean.TRUE.equals(form.chkAssociateReferralLetter().getValue()))
		{
			form.chkAssociateSafetyQuestionnaire().setValue(Boolean.FALSE);
		}
	}
}
