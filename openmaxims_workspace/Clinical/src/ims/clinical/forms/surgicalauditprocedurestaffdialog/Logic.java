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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.surgicalauditprocedurestaffdialog;

import ims.clinical.forms.surgicalauditprocedurestaffdialog.GenForm.grdListedTestsRow;
import ims.clinical.forms.surgicalauditprocedurestaffdialog.GenForm.grdSelectedTestsRow;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.NurseVo;
import ims.core.vo.NurseVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.MedicGrade;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;

import java.util.ArrayList;
import java.util.Comparator;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		LocationLiteVo  locVo= null;
		LocSiteLiteVo	locSiteVo = null;
		initialize();
		if( domain.getCurrentLocation() instanceof LocationLiteVo)
		{
			locVo = (LocationLiteVo) domain.getCurrentLocation();
		}
		else if( domain.getCurrentLocation() instanceof LocSiteLiteVo)
		{
			locSiteVo = (LocSiteLiteVo) domain.getCurrentLocation();
		}
				
		//WDEV-15691
		if( form.getGlobalContext().Clinical.getSelectedHcpIsNotNull() && (form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) 
				|| form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.MEDICAL) ))
		{
			MedicLiteVoCollection medicColl = null;
			
			if( locVo != null )
			{
				if(locVo.getTypeIsNotNull() && locVo.getType().equals(LocationType.HOSP))
				{
					if(	form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && MedicGrade.CONS.equals(form.getGlobalContext().Clinical.getSelectedHcpGrade()))
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),MedicGrade.CONS);
					else if (form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && form.getGlobalContext().Clinical.getSelectedHcpGrade()==null)
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),null);
					else if( form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.MEDICAL))
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,null,null);
				}
				else if(locVo.getTypeIsNotNull() && !locVo.getType().equals(LocationType.HOSP))
				{
					locVo = domain.getLocationLite(locVo);
					if(	form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && MedicGrade.CONS.equals(form.getGlobalContext().Clinical.getSelectedHcpGrade()))
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),MedicGrade.CONS);
					else if (form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && form.getGlobalContext().Clinical.getSelectedHcpGrade()==null)
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),null);
					else if( form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.MEDICAL))
						medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,null,null);
					
				}
			}
			else if( locSiteVo != null)
			{
				locVo = domain.getLocationLite(locSiteVo);
				if(	form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && MedicGrade.CONS.equals(form.getGlobalContext().Clinical.getSelectedHcpGrade()))
					medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),MedicGrade.CONS);
				else if (form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.ANAESTHETIST) && form.getGlobalContext().Clinical.getSelectedHcpGrade()==null)
					medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,form.getGlobalContext().Clinical.getSelectedHcp(),null);
				else if( form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.MEDICAL))
					medicColl = domain.getMedics(locVo,HcpDisType.MEDICAL ,null,null);
			}
				
			if( medicColl != null)
			{
				if( form.getGlobalContext().Clinical.getMedicsSurgicalAuditIsNotNull() )
				{
					MedicLiteVoCollection tempColl = form.getGlobalContext().Clinical.getMedicsSurgicalAudit(); 
					for( int i = 0; tempColl != null && i < tempColl.size();i++)
					{
						if( medicColl != null && medicColl.contains(tempColl.get(i)))
							medicColl.remove(tempColl.get(i));
					}
				}
				medicColl.sort(new MedicComparator(SortOrder.ASCENDING));
				for(int i = 0; i < medicColl.size(); i++ )
				{
					grdListedTestsRow row = form.grdListedTests().getRows().newRow();
					row.setcolSelected(false);
					
					MedicLiteVo tempVo =  medicColl.get(i);
					row.setcolName(tempVo != null && tempVo.getMosIsNotNull() && tempVo.getMos().getNameIsNotNull() ? tempVo.getMos().getName().toString():"" );
					row.setValue(tempVo);
				}
			}
		}
		else if( form.getGlobalContext().Clinical.getSelectedHcpIsNotNull() && form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.NURSING))
		{
			NurseVoCollection nurseColl = null;
			if( locVo != null )
			{
				if(locVo.getTypeIsNotNull() && locVo.getType().equals(LocationType.HOSP))
				{
					nurseColl = domain.getNurses(locVo, form.getGlobalContext().Clinical.getSelectedHcp());
				}
				else if(locVo.getTypeIsNotNull() && !locVo.getType().equals(LocationType.HOSP))
				{
					locVo = domain.getLocationLite(locVo);
					nurseColl = domain.getNurses(locVo, form.getGlobalContext().Clinical.getSelectedHcp());
				}
			}
			else if( locSiteVo != null)
			{
				locVo = domain.getLocationLite(locSiteVo);
				nurseColl = domain.getNurses(locVo, form.getGlobalContext().Clinical.getSelectedHcp());
			}
			
			if( nurseColl != null)
			{
				if( form.getGlobalContext().Clinical.getNursessSurgicalAuditIsNotNull())
				{
					NurseVoCollection tempnColl = form.getGlobalContext().Clinical.getNursessSurgicalAudit();
					
					for(int j = 0;tempnColl != null && j < tempnColl.size();j++)
					{
						if( nurseColl.contains(tempnColl.get(j)) )
							nurseColl.remove(tempnColl.get(j));
					}
				}
				nurseColl.sort(new NurseComparator(SortOrder.ASCENDING));
				for(int i = 0; i < nurseColl.size(); i++ )
				{
					grdListedTestsRow row = form.grdListedTests().getRows().newRow();
					row.setcolSelected(false);
					
					NurseVo tempVo =  nurseColl.get(i);
					row.setcolName(tempVo != null && tempVo.getMosIsNotNull() && tempVo.getMos().getNameIsNotNull() ? tempVo.getMos().getName().toString():"" );
					row.setValue(tempVo);
				}
			}
		}
		//WDEV-15691
		else if( form.getGlobalContext().Clinical.getSelectedHcpIsNotNull() && form.getGlobalContext().Clinical.getSelectedHcp().equals(HcpDisType.RADIOGRAPHER))
		{
			HcpLiteVoCollection radiographerColl=null;//WDEV-15691
			if( locVo != null )
			{
				if(locVo.getTypeIsNotNull() && locVo.getType().equals(LocationType.HOSP))
				{
					radiographerColl = domain.getOtheDisciplineHcp(locVo,form.getGlobalContext().Clinical.getSelectedHcp());
				}
				else if(locVo.getTypeIsNotNull() && !locVo.getType().equals(LocationType.HOSP))
				{
					locVo = domain.getLocationLite(locVo);
					radiographerColl = domain.getOtheDisciplineHcp(locVo,form.getGlobalContext().Clinical.getSelectedHcp());
				}
			}
			else if( locSiteVo != null)
			{
				locVo = domain.getLocationLite(locSiteVo);
				radiographerColl = domain.getOtheDisciplineHcp(locVo,form.getGlobalContext().Clinical.getSelectedHcp());
			}
			
			if (radiographerColl!=null)
			{
				if( form.getGlobalContext().Clinical.getRadiographerSurgAuditProcDetailsIsNotNull())
				{
					HcpLiteVoCollection tempnColl = form.getGlobalContext().Clinical.getRadiographerSurgAuditProcDetails();
					
					for(int j = 0;tempnColl != null && j < tempnColl.size();j++)
					{
						if( radiographerColl.contains(tempnColl.get(j)) )
							radiographerColl.remove(tempnColl.get(j));
					}
				}
				
				for(int i = 0; i < radiographerColl.size(); i++ )
				{
					grdListedTestsRow row = form.grdListedTests().getRows().newRow();
					row.setcolSelected(false);
					
					HcpLiteVo tempVo = radiographerColl.get(i);
					row.setcolName(tempVo != null && tempVo.getMosIsNotNull() && tempVo.getMos().getNameIsNotNull() ? tempVo.getMos().getName().toString():"" );
					row.setValue(tempVo);
				}
			}
			
		}
		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Clinical.setSelectedHcp(null);
		form.getGlobalContext().Clinical.setSelectedHCPs(null);
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		buildSelection();
		engine.close(DialogResult.OK);
	}
	private void buildSelection()
	{
		ArrayList<Object> hcpArray = new ArrayList<Object>();
		
		for(int x = 0; x < form.grdSelectedTests().getRows().size(); x++)
		{
			Object item = form.grdSelectedTests().getRows().get(x).getValue();
			hcpArray.add(item);
		}
			
		form.getGlobalContext().Clinical.setSelectedHCPs(hcpArray);
	}
	
	protected void onImbRemoveFromListClick() throws ims.framework.exceptions.PresentationLogicException
	{
		removeSelectedItems();
	}
	
	protected void onImbAddToListClick() throws ims.framework.exceptions.PresentationLogicException
	{
		addSelectedItems();
	}
	
	private void initialize()
	{
		form.grdSelectedTests().getRows().clear();
		form.grdListedTests().getRows().clear();
		if(form.getGlobalContext().Clinical.getSelectedHCPsIsNotNull())
		{
			ArrayList<Object> tempArray = form.getGlobalContext().Clinical.getSelectedHCPs();
			for(int i = 0; i < tempArray.size(); i++ )
			{
				grdSelectedTestsRow row = form.grdSelectedTests().getRows().newRow();
				row.setcolSelected(false);
				if( tempArray.get(i) instanceof MedicLiteVo )
				{
					MedicLiteVo tempVo = (MedicLiteVo) tempArray.get(i);
					row.setcolName(tempVo != null && tempVo.getMosIsNotNull() && tempVo.getMos().getNameIsNotNull() ? tempVo.getMos().getName().toString():"" );
					row.setValue(tempVo);
				}
				else if( tempArray.get(i) instanceof NurseVo)
				{
					NurseVo tempNurseVo = (NurseVo) tempArray.get(i);
					row.setcolName(tempNurseVo != null && tempNurseVo.getMosIsNotNull() && tempNurseVo.getMos().getNameIsNotNull() ? tempNurseVo.getMos().getName().toString():"" );
					row.setValue(tempNurseVo);
				}
				else if( tempArray.get(i) instanceof HcpLiteVo)//WDEV-15691
				{
					HcpLiteVo tempRadiographerVo = (HcpLiteVo) tempArray.get(i);
					row.setcolName(tempRadiographerVo != null && tempRadiographerVo.getMosIsNotNull() && tempRadiographerVo.getMos().getNameIsNotNull() ? tempRadiographerVo.getMos().getName().toString():"" );
					row.setValue(tempRadiographerVo);
				}

			}
		}
	}
	private void removeSelectedItems()
	{	
		for(int x = 0; x < form.grdSelectedTests().getRows().size(); x++)
		{
			if(form.grdSelectedTests().getRows().get(x).getcolSelected())
			{
				Object existingItem = form.grdSelectedTests().getRows().get(x).getValue();
				
				if(existingItem instanceof MedicLiteVo)
				{
					MedicLiteVo item = (MedicLiteVo)existingItem;
					if(!isListed(item))
						addToList(item);					
				}
				if(existingItem instanceof NurseVo)
				{
					NurseVo item = (NurseVo)existingItem;
					if(!isListed(item))
						addToList(item);					
				}
				//WDEV-15691
				if(existingItem instanceof HcpLiteVo)
				{
					HcpLiteVo item = (HcpLiteVo)existingItem;
					if(!isListed(item))
						addToList(item);					
				}
			}
		}
		int size = form.grdSelectedTests().getRows().size();
		for(int x = size - 1; x >= 0 ; x--)
		{
			if(form.grdSelectedTests().getRows().get(x).getcolSelected())
				form.grdSelectedTests().getRows().remove(x);
		}
	}
	
	//WDEV-15691
	private void addToList(HcpLiteVo item)
	{
		if(	item == null)
			return;
		GenForm.grdListedTestsRow row = form.grdListedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );
	}

	private boolean isListed(Object value)
	{
		for(int x = 0; x < form.grdListedTests().getRows().size(); x++)
		{
			Object existingItem = form.grdListedTests().getRows().get(x).getValue();
			if(existingItem != null && existingItem.equals(value))
				return true;
		}
		return false;
	}
	private void addToList(MedicLiteVo item)
	{
		if(item == null)
			return;
		
		GenForm.grdListedTestsRow row = form.grdListedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );		
	}	

	private void addToList(NurseVo item)
	{
		if(	item == null)
			return;
		GenForm.grdListedTestsRow row = form.grdListedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );		
	}
	private void addSelectedItems()
	{	
		for(int x = 0; x < form.grdListedTests().getRows().size(); x++)
		{
			if(form.grdListedTests().getRows().get(x).getcolSelected())
			{
				Object existingItem = form.grdListedTests().getRows().get(x).getValue();
				
				if(existingItem instanceof MedicLiteVo)
				{
					MedicLiteVo item = (MedicLiteVo)existingItem;
					if(!isSelected(item))
						addToSelection(item);											
				}
				if(existingItem instanceof NurseVo)
				{
					NurseVo item = (NurseVo)existingItem;
					if(!isSelected(item))
						addToSelection(item);					
				}
				
				//WDEV-15691
				if(existingItem instanceof HcpLiteVo)
				{
					HcpLiteVo item = (HcpLiteVo)existingItem;
					if(!isSelected(item))
						addToSelection(item);					
				}
				
			}
		}
		int size = form.grdListedTests().getRows().size();
		for(int x = size - 1; x >= 0 ; x--)
		{
			if(form.grdListedTests().getRows().get(x).getcolSelected())
				form.grdListedTests().getRows().remove(x);
		}
	}
	
	//WDEV-15691
	private void addToSelection(HcpLiteVo item)
	{
		GenForm.grdSelectedTestsRow row = form.grdSelectedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );
	}

	private boolean isSelected(Object value)
	{
		for(int x = 0; x < form.grdSelectedTests().getRows().size(); x++)
		{
			Object existingItem = form.grdSelectedTests().getRows().get(x).getValue();
			if(existingItem != null && existingItem.equals(value))
				return true;
		}
		return false;
	}
	private void addToSelection(MedicLiteVo item)
	{
		GenForm.grdSelectedTestsRow row = form.grdSelectedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );
	}
	
	private void addToSelection( NurseVo item)
	{
		GenForm.grdSelectedTestsRow row = form.grdSelectedTests().getRows().newRow();
		row.setValue(item);
		row.setcolName(item != null && item.getMosIsNotNull() && item.getMos().getNameIsNotNull() ? item.getMos().getName().toString():"" );
	}
	public class MedicComparator implements Comparator
	{
		private int direction = 1;
		
		public MedicComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public MedicComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			PersonName pdate1 = null;
			PersonName pdate2 = null;
			if(ob1 instanceof MedicLiteVo )
			{
				MedicLiteVo ps1 = (MedicLiteVo)ob1;
				pdate1 = ps1.getMosIsNotNull() && ps1.getMos().getNameIsNotNull() ? ps1.getMos().getName():null;
			}
			if(ob2 instanceof MedicLiteVo)
			{
				MedicLiteVo ps2 = (MedicLiteVo)ob2;
				pdate2 = ps2.getMosIsNotNull() && ps2.getMos().getNameIsNotNull() ? ps2.getMos().getName():null;
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
	public class NurseComparator implements Comparator
	{
		private int direction = 1;
		
		public NurseComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public NurseComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			PersonName pdate1 = null;
			PersonName pdate2 = null;
			if(ob1 instanceof NurseVo )
			{
				NurseVo ps1 = (NurseVo)ob1;
				pdate1 = ps1.getMosIsNotNull() && ps1.getMos().getNameIsNotNull() ? ps1.getMos().getName():null;
			}
			if(ob2 instanceof NurseVo)
			{
				NurseVo ps2 = (NurseVo)ob2;
				pdate2 = ps2.getMosIsNotNull() && ps2.getMos().getNameIsNotNull() ? ps2.getMos().getName():null;
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}

	

}
