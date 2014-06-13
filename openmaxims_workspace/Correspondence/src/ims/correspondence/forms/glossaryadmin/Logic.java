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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1921.23961)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.glossaryadmin;
 
import ims.correspondence.vo.GlossaryProfileVo;
import ims.correspondence.vo.GlossaryVo;
import ims.correspondence.vo.GlossaryVoCollection;
import ims.correspondence.vo.lookups.LookupHelper;
import ims.correspondence.vo.lookups.ProfileType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.LayerBridge;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.vo.interfaces.ICspTypeSpecifier;

public class Logic extends BaseLogic
{
	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.glossaryadmin.Handlers#onFormOpen()
	 */
	protected void onFormOpen() throws FormOpenException 
	{	
		initialize();
		open();
	}

	/**
	 * 
	 * @see ims.base.interfaces.IUILogicCode#initialize()
	 */
	public void initialize() throws FormOpenException
	{		
		//load glossary category lookups
		if (!populateGlossaryLookups())
			throw new FormOpenException("No Glossary Category lookups setup for this screen");
		
		form.ctnGlossaryText().setCollapsed(true);
	
		for ( int i = 0 ; i < form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValues().size() ; i++)
		{
			if ( ((ProfileType)form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValues().get(i)).getID() != ProfileType.SPECIALTY.getID()
				 || ((ProfileType)form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValues().get(i)).getID() != ProfileType.CONSULTANT.getID())
				 form.lyrGlossary().tabGlossaryProfile().cmbProfileType().removeRow((ProfileType)form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValues().get(i));
		}
		
		form.lyrGlossary().tabGlossaryProfile().cmbProfileType().setValue(ProfileType.SPECIALTY);
		populateProfileType(form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValue());
		
		updateContextMenus();
	}

	/**
	 * populate glossary grid
	 * 
	 */	
	private boolean populateGlossaryLookups()
	{
		//Local Context to hold the Glossary Category Lookup Collection
		form.getLocalContext().setGlossaryCategoryColl(LookupHelper.getGlossaryCategory(domain.getLookupService()));
		
		form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().clear();
		
		if (form.getLocalContext().getGlossaryCategoryCollIsNotNull() && form.getLocalContext().getGlossaryCategoryColl().size()>0)
		{
			for(int i=0;i<form.getLocalContext().getGlossaryCategoryColl().size();i++)
			{
				GenForm.lyrGlossaryLayer.tabGlossaryDefContainer.grdGlossaryRow row = form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().newRow();
				row.setcolCategory(form.getLocalContext().getGlossaryCategoryColl().get(i));
			}
			
			return true;
		}		
		
		return false;
	}
	
	/**
	 * 
	 * @see ims.base.interfaces.IUILogicCode#open()
	 */
	public void open()
	{		
		//select last updated item
		if (form.lyrGlossary().tabGlossaryDef().isVisible())
		{
			populateGlossaryDefGrid();
			populateGlossaryDefItems();
		}
		else if (form.lyrGlossary().tabGlossaryProfile().isVisible())
		{
			//TODO this doesn't work for Interfaces.
			//form.lyrGlossary().tabGlossaryProfile().grdSpecCons().setValue(form.getLocalContext().getprofileSpecifier());
			if (form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getRows() != null)
			{
				GenForm.lyrGlossaryLayer.tabGlossaryProfileContainer.grdSpecConsRow row = null;
				for(int i = 0; i < form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getRows().size();i++)
				{
					row = form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getRows().get(i);
					if ( (row.getValue() != null) && (row.getValue().getIGenericItemInfoID().intValue() == form.getLocalContext().getprofileSpecifier().getIGenericItemInfoID().intValue()))
					{
						form.lyrGlossary().tabGlossaryProfile().grdSpecCons().setValue(row.getValue());	
						grdSpecConsSelectionChange();
						break;
					}
				}
			}
		}
		
		form.setMode(FormMode.VIEW);
	}
	
	private void populateProfileType(ProfileType type)
	{
		form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getRows().clear();		
		ICspTypeSpecifier[] list = domain.listGlossaryProfiles(type);
		if(list == null)
			return;
		
		for(int x = 0; x < list.length; x++)
		{
			addProfileTypeRow(list[x]);
		}
	}
	
	private void addProfileTypeRow(ICspTypeSpecifier profile) 
	{
		if(profile == null)
			return;
		
		GenForm.lyrGlossaryLayer.tabGlossaryProfileContainer.grdSpecConsRow row = form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getRows().newRow();
		row.setcolDescription(profile.getIGenericItemInfoName());
		row.setValue(profile);
	}

	/**
	 * overlay GlossaryVo items on the glossary category lookup list
	 * 
	 */	
	private void populateGlossaryDefItems()
	{
		//overlay GlossaryVo items on the glossary category lookup list
		
		GlossaryVoCollection collGlossary =  domain.listAllGlossaryItems();
		
		if (collGlossary == null)
			return;
				
		GenForm.lyrGlossaryLayer.tabGlossaryDefContainer.grdGlossaryRow row = null;		
		clearInstanceControls();
		
		for(int i=0 ; i <collGlossary.size() ; i++)
		{
			for(int j=0;j<form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().size();j++)
			{
				row = form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(j);
				if (row.getcolCategory().getId() == collGlossary.get(i).getGlossary().getId())
				{
					row.setValue(collGlossary.get(i));
					row.setcolCategory(collGlossary.get(i).getGlossary());
					row.setcolGlossaryText(form.getImages().Core.TextBox);
					row.setTooltipForcolGlossaryText(collGlossary.get(i).getGlossaryText());
				}
			}
		}		
		
		//set selection back
		if (form.getLocalContext().getvoGlossaryIsNotNull())
		{
			//need to get timestamp from record retrieved from List call.
			GenForm.lyrGlossaryLayer.tabGlossaryDefContainer.grdGlossaryRow glossaryrow = form.lyrGlossary().tabGlossaryDef().grdGlossary().getRowByValue(form.getLocalContext().getvoGlossary());			
			if (glossaryrow != null && glossaryrow.getValue() != null)
			{			
				form.getLocalContext().setvoGlossary(domain.getGlossary(form.getLocalContext().getvoGlossary()));
				form.lyrGlossary().tabGlossaryDef().grdGlossary().setValue(form.getLocalContext().getvoGlossary());
				populateInstanceControl(form.lyrGlossary().tabGlossaryDef().grdGlossary().getValue());
			}
			else
				clearInstanceControls();					
		}
				
		updateControlsState();
		
		form.setMode(FormMode.VIEW);

	}
	
	/**
	 * show all glossary items
	 * 
	 */		
	private void populateGlossaryProfileItems() 
	{
		GlossaryVoCollection collGlossary =  domain.listAllGlossaryItems();
		
		form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().clear();
		
		if (collGlossary == null)
			return;
		
		for(int i=0;i<collGlossary.size();i++)
		{
			GenForm.lyrGlossaryLayer.tabGlossaryProfileContainer.grdGlossaryProfileRow row = form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().newRow();
			row.setcolCategory(collGlossary.get(i).getGlossary());
			if (collGlossary.get(i).getGlossaryTextIsNotNull())
			{
				row.setcolGlossaryText(form.getImages().Core.TextBox);	
				row.setTooltipForcolGlossaryText(collGlossary.get(i).getGlossaryText());
				row.setValue(collGlossary.get(i));
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.glossaryadmin.Handlers#onBtnSaveClick()
	 */
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if(save())
			open();
	}

	/**
	 * save a glossary item
	 * @return boolean success
	 */
	private boolean saveGlossary() 
	{
		GlossaryVo voGlossary = new GlossaryVo();
		if (form.getLocalContext().getvoGlossaryIsNotNull())
			voGlossary = form.getLocalContext().getvoGlossary();		
		
		populateGlossaryFromScreen(voGlossary);
		
		String[] errors = voGlossary.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			try {
				voGlossary = domain.saveGlossary(voGlossary);
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				open();
				return false;
			} 
			catch (UniqueKeyViolationException e) 
			{
				engine.showMessage(e.getMessage());
				open();
				return false;
			}			
			form.getLocalContext().setvoGlossary(voGlossary);
			//update entry in grid
			
			form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).setValue(voGlossary);
			form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).setcolGlossaryText(form.getImages().Admin.Leaf);
			form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).setTooltipForcolGlossaryText(voGlossary.getGlossaryText());
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;				
		}	
		
		form.getLocalContext().setvoGlossary(voGlossary);
		
		return true;
	}

	/**
	 * show glossary text for selected glossary
	 * @param voGlossary
	 */
	private void populateGlossaryFromScreen(GlossaryVo voGlossary) 
	{
		voGlossary.setGlossary(form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).getcolCategory());
		voGlossary.setGlossaryText(form.ctnGlossaryText().richText().getValue());	
	}

	/**
	 * save the glossary progile for the type specifier
	 * @return boolean success
	 */
	private boolean saveGlossaryProfile() 
	{
		GlossaryProfileVo voGlossaryProfile =  populateGlossaryProfile(form.getLocalContext().getGlossaryProfile());
		if (voGlossaryProfile != null)
		{
			String arrErrors[] = voGlossaryProfile.validate();
			if(arrErrors != null)
			{
				engine.showErrors(arrErrors);
				return false;
			}
			
			try {
				form.getLocalContext().setGlossaryProfile(domain.saveGlossaryProfile(voGlossaryProfile));
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open();
				return false;
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				open();
				return false;
			} 
			catch (UniqueKeyViolationException e) 
			{
				engine.showMessage(e.getMessage());
				open();
				return false;
			}
		}
		return true;
	}
		
			
	/**
	 * get the glossary profile for the type specifier
	 * @param voGlossaryProfile 
	 * @return GlossaryProfileVo
	 */
	private GlossaryProfileVo populateGlossaryProfile(GlossaryProfileVo voGlossaryProfile) 
	{
		if (voGlossaryProfile == null)
		{
			voGlossaryProfile = new GlossaryProfileVo();
			voGlossaryProfile.setSpecifierID(form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getValue().getIGenericItemInfoID());
			voGlossaryProfile.setSpecifierType(form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getValue().getSpecifierType());
		}
				
		GlossaryVoCollection voCollGlossary = new GlossaryVoCollection();
		
		for (int i=0; i < form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().size(); i++)
		{
			if (form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().get(i).getcolLinked()==true)
			{
				voCollGlossary.add(form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().get(i).getValue());								
			}
		}
		if (voCollGlossary.size() == 0)
			voGlossaryProfile.setGlossaries(null);
		else
			voGlossaryProfile.setGlossaries(voCollGlossary);

		
		return voGlossaryProfile;
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.glossaryadmin.Handlers#onGrdGlossaryProfileSelectionChanged()
	 */
	protected void onGrdGlossaryProfileSelectionChanged() throws PresentationLogicException 
	{
		populateInstanceControl(form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getValue());
		updateContextMenus();
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.glossaryadmin.Handlers#onContextMenuItemClick(int, ims.framework.Control)
	 */
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException {

		  switch (menuItemID)
		  {
		  	case GenForm.ContextMenus.CorrespondenceNamespace.GlossaryConsultantGrid.AddUpdate:
		  		addUpdateGlossaryProfile();
		  		break;
		  	case GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Add:
		  		addGlossary();
		  		break;
		  	case GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Update:
		  		updateGlossary();
		  		break;
		  	case GenForm.ContextMenus.CorrespondenceNamespace.CorrespondenceGlossaryGrid.Delete:
		  		if (deleteGlossary())
		  			open();
		  		break;		  				  		
		  }	  
	}
	
	/**
	 * add or update a glossary profile
	 * 
	 */		
	protected void addUpdateGlossaryProfile()
	{		
		if (form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().size() > 0)
		{
			form.setMode(FormMode.EDIT);
			form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().setEnabled(true);
			form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().setReadOnly(false);
			form.lyrGlossary().tabGlossaryDef().setHeaderEnabled(false);
			form.lyrGlossary().tabGlossaryProfile().setHeaderEnabled(false);
			form.ctnGlossaryText().richText().setEnabled(false);
			form.ctnGlossaryText().setCollapsed(true);			
		}
		
	}
	
	/**
	 * prepair screen for adding a glossary text
	 * 
	 */		
	protected void addGlossary() throws PresentationLogicException
	{		
		newInstance();
	}
	
	/**
	 * prepair screen for updating the selected glossary text
	 * 
	 */			
	protected void updateGlossary()
	{
		updateInstance();
	}		
	
	/**
	 * delete a glossary text
	 * @return boolean success
	 * 
	 */			
	protected boolean deleteGlossary()
	{
		int index = form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex();
		if (index >= 0)
		{
			try 
			{
				domain.deleteGlossary(form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).getValue());
			}
			catch (ForeignKeyViolationException e) 
			{
				engine.showMessage(e.getMessage());
				return false;
			}
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue() + " " + e.getMessage());
				return false;
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return false;
			}
			form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRow().setValue(null);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.glossaryadmin.Handlers#onFormModeChanged()
	 */
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}
	
	protected void updateContextMenus()
	{		
		form.getContextMenus().Correspondence.hideAllGlossaryConsultantGridMenuItems();
		form.getContextMenus().Correspondence.hideAllCorrespondenceGlossaryGridMenuItems();
		
		if (form.lyrGlossary().tabGlossaryDef().isVisible())
		{
			if (form.lyrGlossary().tabGlossaryDef().grdGlossary().getValue() != null )
			{
				showGlossaryMenus(true);
			}
			else
			{
				//WDEV-2740
				if (form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex() != -1)
				{
					form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridAddItem().setVisible(true);
				}
			}
		}
		else if (form.lyrGlossary().tabGlossaryProfile().isVisible())
		{
			if (form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getValue() != null)
			{
					form.getContextMenus().Correspondence.getGlossaryConsultantGridAddUpdateItem().setVisible(true);
			}			
		}
						
	}	

	/**
	 * show/hide context menu for glossary grid
	 * @param bVisable
	 */
	private void showGlossaryMenus(boolean bVisible) 
	{
		form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridDeleteItem().setVisible(bVisible);
		form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridUpdateItem().setVisible(bVisible);
		form.getContextMenus().Correspondence.getCorrespondenceGlossaryGridAddItem().setVisible(!bVisible);		
	}
	
	protected void onCmbProfileTypeValueChanged() throws PresentationLogicException 
	{
		if (form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValue() == null)
			return;
		
		form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().clear();
		populateProfileType(form.lyrGlossary().tabGlossaryProfile().cmbProfileType().getValue());		
	}

	

	protected void onGrdSpecConsSelectionChanged() throws PresentationLogicException 
	{
		grdSpecConsSelectionChange();

		//WDEV-2742 
		populateInstanceControl(null);
	}

	private void grdSpecConsSelectionChange()
	{
		form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRows().clear();
		form.getLocalContext().setprofileSpecifier(form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getValue());
		populateGlossaryProfileItems();
		GlossaryProfileVo voGlossaryProfileColl = domain.getGlossaryProfile(form.lyrGlossary().tabGlossaryProfile().grdSpecCons().getValue());		
		form.getLocalContext().setGlossaryProfile(voGlossaryProfileColl);
		overlayLinkedGlossaryItems(form.getLocalContext().getGlossaryProfile());
		updateContextMenus();		

	}
	
	/**
	 * show linked glossary items
	 * 
	 */		
	private void overlayLinkedGlossaryItems(GlossaryProfileVo voCollSpecialtyProfile) 
	{
		if (voCollSpecialtyProfile != null && voCollSpecialtyProfile.getGlossariesIsNotNull())
		{
			GenForm.lyrGlossaryLayer.tabGlossaryProfileContainer.grdGlossaryProfileRow row;
			for (int i=0;i<voCollSpecialtyProfile.getGlossaries().size();i++)
			{
				row = form.lyrGlossary().tabGlossaryProfile().grdGlossaryProfile().getRowByValue(voCollSpecialtyProfile.getGlossaries().get(i));
				if (null != row)
				{
					row.setValue(voCollSpecialtyProfile.getGlossaries().get(i));
					row.setcolCategory(voCollSpecialtyProfile.getGlossaries().get(i).getGlossary());
					row.setcolGlossaryText(form.getImages().Core.TextBox);
					row.setcolLinked(true);
				}
			}	
		}
		
	}
	protected void onGrdGlossarySelectionChanged() throws PresentationLogicException 
	{
		populateInstanceControl(form.lyrGlossary().tabGlossaryDef().grdGlossary().getValue());
		form.getLocalContext().setvoGlossary(form.lyrGlossary().tabGlossaryDef().grdGlossary().getValue());
		updateContextMenus();
	}
	
	private void populateInstanceControl(GlossaryVo vo)
	{
		form.ctnGlossaryText().richText().setValue((vo!=null?vo.getGlossaryText():null));
		//WDEV-2742 
		form.ctnGlossaryText().setCollapsed((vo!=null?false:true));
	}
	
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		open();			
	}

	protected void onlyrGlossaryTabChanged(LayerBridge tab) 
	{
		form.ctnGlossaryText().richText().setValue(null);
		form.ctnGlossaryText().setCollapsed(true);
		updateContextMenus();
	}

	private void populateGlossaryDefGrid()
	{
		GenForm.lyrGlossaryLayer.tabGlossaryDefContainer.grdGlossaryRow row = null;
		//Blank all the Glossary text row entries
		for(int k=0 ; k < form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().size() ; k++)
		{
			row = form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(k);
			row.setcolGlossaryText(null);
			row.setTooltipForcolGlossaryText("");
		}

	}
	
	public void clearInstanceControls() 
	{
		//Blank Rich text control
		form.ctnGlossaryText().richText().setValue(null);		
	}

	/**
	 * 
	 * @see ims.base.interfaces.IUILIPLogicCode#newInstance()
	 */
	public void newInstance() throws PresentationLogicException 
	{
		form.getLocalContext().setvoGlossary(form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).getValue());
		form.setMode(FormMode.EDIT);
		form.lyrGlossary().tabGlossaryDef().setHeaderEnabled(false);
		form.lyrGlossary().tabGlossaryProfile().setHeaderEnabled(false);
		form.ctnGlossaryText().richText().setValue("");
		form.ctnGlossaryText().richText().setEnabled(true);
		form.ctnGlossaryText().setCollapsed(false);		
	}

	/**
	 *  (non-Javadoc)
	 * @see ims.base.interfaces.IUILIPLogicCode#save()
	 */
	public boolean save() throws PresentationLogicException 
	{
		if (form.lyrGlossary().tabGlossaryDef().isVisible())
		{
			return saveGlossary();
		}
		else if (form.lyrGlossary().tabGlossaryProfile().isVisible())
		{
			return saveGlossaryProfile();
		}
		
		return false;
	}

	public void updateControlsState() 
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.lyrGlossary().tabGlossaryDef().setHeaderEnabled(true);
			form.lyrGlossary().tabGlossaryProfile().setHeaderEnabled(true);
			
			form.lyrGlossary().tabGlossaryProfile().setEnabled(true);
			form.lyrGlossary().tabGlossaryDef().setEnabled(true);
			
		}
		else
		{
			form.lyrGlossary().tabGlossaryDef().setHeaderEnabled(false);
			form.lyrGlossary().tabGlossaryProfile().setHeaderEnabled(false);
			
		}
		
		updateContextMenus();		
	}

	/**
	 * 
	 * @see ims.base.interfaces.IUILIPLogicCode#updateInstance()
	 */
	public void updateInstance() 
	{
		int index =form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex();
		if (index>=0)
		{
			form.getLocalContext().setvoGlossary(form.lyrGlossary().tabGlossaryDef().grdGlossary().getRows().get(form.lyrGlossary().tabGlossaryDef().grdGlossary().getSelectedRowIndex()).getValue());
			form.setMode(FormMode.EDIT);
			//form.grdGlossary().setEnabled(false);
			//form.grdGlossary().setReadOnly(true);
			form.ctnGlossaryText().richText().setEnabled(true);
			//TODO waiting for FWUI-313 form.ctnGlossaryText().setValue("Glossary Text for : " + form.grdGlossary().getSelectedRowIndex()).getValue());
			form.ctnGlossaryText().setCollapsed(false);	
			form.lyrGlossary().tabGlossaryDef().setHeaderEnabled(false);
			form.lyrGlossary().tabGlossaryProfile().setHeaderEnabled(false);
		}		
	}
}


