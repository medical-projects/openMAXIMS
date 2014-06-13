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

package ims.ocrr.forms.orderentrytemplatelist;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class cmbStatusComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.core.vo.lookups.PreActiveActiveInactiveStatus value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.core.vo.lookups.PreActiveActiveInactiveStatus value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.core.vo.lookups.PreActiveActiveInactiveStatus value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.core.vo.lookups.PreActiveActiveInactiveStatus value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
		{
			return super.control.removeRow(value);
		}
		public ims.core.vo.lookups.PreActiveActiveInactiveStatus getValue()
		{
			return (ims.core.vo.lookups.PreActiveActiveInactiveStatus)super.control.getValue();
		}
		public void setValue(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
		{
			super.control.setValue(value);
		}
	}
	public static class cmbSiteComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.core.vo.LocSiteShortVo value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.core.vo.LocSiteShortVo value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.core.vo.LocSiteShortVo value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.core.vo.LocSiteShortVo value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.core.vo.LocSiteShortVo value)
		{
			return super.control.removeRow(value);
		}
		public ims.core.vo.LocSiteShortVo getValue()
		{
			return (ims.core.vo.LocSiteShortVo)super.control.getValue();
		}
		public void setValue(ims.core.vo.LocSiteShortVo value)
		{
			super.control.setValue(value);
		}
	}
	public static class grdDetailsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdDetailsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolImageReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolImageReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolImageOpened()
		{
			super.row.showOpened(0);
		}
		public ims.framework.utils.Image getcolImage()
		{
			return (ims.framework.utils.Image)super.row.get(0);
		}
		public void setcolImage(ims.framework.utils.Image value)
		{
			super.row.set(0, value);
		}
		public void setCellcolImageTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolNameReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolNameReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolNameOpened()
		{
			super.row.showOpened(1);
		}
		public String getcolName()
		{
			return (String)super.row.get(1);
		}
		public void setcolName(String value)
		{
			super.row.set(1, value);
		}
		public void setCellcolNameTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setcolStatusReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean iscolStatusReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showcolStatusOpened()
		{
			super.row.showOpened(2);
		}
		public String getcolStatus()
		{
			return (String)super.row.get(2);
		}
		public void setcolStatus(String value)
		{
			super.row.set(2, value);
		}
		public void setCellcolStatusTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public ims.ocrr.vo.OrderEntryTemplateShortVo getValue()
		{
			return (ims.ocrr.vo.OrderEntryTemplateShortVo)super.row.getValue();
		}
		public void setValue(ims.ocrr.vo.OrderEntryTemplateShortVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdDetailsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdDetailsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdDetailsRow get(int index)
		{
			return new grdDetailsRow(super.collection.get(index));
		}
		public grdDetailsRow newRow()
		{
			return new grdDetailsRow(super.collection.newRow());
		}
		public grdDetailsRow newRow(boolean autoSelect)
		{
			return new grdDetailsRow(super.collection.newRow(autoSelect));
		}
		public grdDetailsRow newRowAt(int index)
		{
			return new grdDetailsRow(super.collection.newRowAt(index));
		}
		public grdDetailsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdDetailsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdDetailsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addImageColumn(String caption, int captionAlignment, int alignment, int width, boolean canGrow, int sortOrder)
		{
			super.grid.addImageColumn(caption, captionAlignment, alignment, width, canGrow, sortOrder);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public ims.ocrr.vo.OrderEntryTemplateShortVoCollection getValues()
		{
			ims.ocrr.vo.OrderEntryTemplateShortVoCollection listOfValues = new ims.ocrr.vo.OrderEntryTemplateShortVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.ocrr.vo.OrderEntryTemplateShortVo getValue()
		{
			return (ims.ocrr.vo.OrderEntryTemplateShortVo)super.grid.getValue();
		}
		public void setValue(ims.ocrr.vo.OrderEntryTemplateShortVo value)
		{
			super.grid.setValue(value);
		}
		public grdDetailsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdDetailsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdDetailsRowCollection getRows()
		{
			return new grdDetailsRowCollection(super.grid.getRows());
		}
		public grdDetailsRow getRowByValue(ims.ocrr.vo.OrderEntryTemplateShortVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdDetailsRow(row);
		}
		public void setcolImageHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolImageHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolNameHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolNameHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setcolStatusHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getcolStatusHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		form.setDarkHeight(45);
		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuOCRROrderEntryTemplateList = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuOCRROrderEntryTemplateListADDItem = factory.createMenuItem(startControlID.intValue() + 1, "Add Order Entry Template", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuOCRROrderEntryTemplateList.add(contextMenus.contextMenuOCRROrderEntryTemplateListADDItem);
		contextMenus.contextMenuOCRROrderEntryTemplateListEDITItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit Order Entry Template", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuOCRROrderEntryTemplateList.add(contextMenus.contextMenuOCRROrderEntryTemplateListEDITItem);
		contextMenus.contextMenuOCRROrderEntryTemplateListVIEWItem = factory.createMenuItem(startControlID.intValue() + 3, "View Order Entry Template", true, false, new Integer(102223), false, true);
		contextMenus.contextMenuOCRROrderEntryTemplateList.add(contextMenus.contextMenuOCRROrderEntryTemplateListVIEWItem);
		contextMenus.contextMenuOCRROrderEntryTemplateListPREVIEWItem = factory.createMenuItem(startControlID.intValue() + 4, "Preview", true, false, new Integer(102221), false, true);
		contextMenus.contextMenuOCRROrderEntryTemplateList.add(contextMenus.contextMenuOCRROrderEntryTemplateListPREVIEWItem);
		form.registerMenu(contextMenus.contextMenuOCRROrderEntryTemplateList);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 528, 16, 45, 17, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Status:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 224, 16, 30, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Site:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 41, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Name:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 757, 13, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.ENABLED, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, "Search", Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 64, 14, 144, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.FALSE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 584, 14, 160, 21, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		ComboBox m_cmbStatusTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPRIGHT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbStatusTemp);
		cmbStatusComboBox cmbStatus = (cmbStatusComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbStatusComboBox.class, m_cmbStatusTemp);
		super.addComboBox(cmbStatus);
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 264, 14, 248, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		ComboBox m_cmbSiteTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
		addControl(m_cmbSiteTemp);
		cmbSiteComboBox cmbSite = (cmbSiteComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbSiteComboBox.class, m_cmbSiteTemp);
		super.addComboBox(cmbSite);

		// Grid Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 16, 56, 816, 560, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdDetailsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.READONLY, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.contextMenuOCRROrderEntryTemplateList, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.TRUE, Boolean.TRUE});
		addControl(m_grdDetailsTemp);
		grdDetailsGrid grdDetails = (grdDetailsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdDetailsGrid.class, m_grdDetailsTemp);
		grdDetails.addImageColumn(" ", 0, 0, 24, false, 0);
		grdDetails.addStringColumn("Name", 0, 0, 450, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdDetails.addStringColumn("Status", 0, 0, -1, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdDetails);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnSearch()
	{
		return (Button)super.getControl(3);
	}
	public TextBox txtName()
	{
		return (TextBox)super.getControl(4);
	}
	public cmbStatusComboBox cmbStatus()
	{
		return (cmbStatusComboBox)super.getComboBox(0);
	}
	public cmbSiteComboBox cmbSite()
	{
		return (cmbSiteComboBox)super.getComboBox(1);
	}
	public grdDetailsGrid grdDetails()
	{
		return (grdDetailsGrid)super.getGrid(0);
	}

	public static class Forms implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			private LocalFormName(int name)
			{
				super(name);
			}
		}

		private Forms()
		{
			OCRR = new OCRRForms();
		}
		public final class OCRRForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private OCRRForms()
			{
				OrderEntryTemplateEdit = new LocalFormName(116121);
				OrderEntryTemplatePreviewDialog = new LocalFormName(116110);
			}
			public final FormName OrderEntryTemplateEdit;
			public final FormName OrderEntryTemplatePreviewDialog;
		}

		public OCRRForms OCRR;
	}


	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			OCRR = new OCRRImages();
			Admin = new AdminImages();
		}
		public final class OCRRImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private OCRRImages()
			{
				OrderEntryTemplate = new ImageHelper(116103, "Images/OCRR/OrderEntryTemplate.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image OrderEntryTemplate;
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				LocationSite = new ImageHelper(103100, "Images/Admin/location_site.png", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image LocationSite;
		}
		public final OCRRImages OCRR;
		public final AdminImages Admin;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class OCRROrderEntryTemplateList implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int ADD = 1;
			public static final int EDIT = 2;
			public static final int VIEW = 3;
			public static final int PREVIEW = 4;
		}
		public void disableAllOCRROrderEntryTemplateListMenuItems()
		{
			this.contextMenuOCRROrderEntryTemplateListADDItem.setEnabled(false);
			this.contextMenuOCRROrderEntryTemplateListEDITItem.setEnabled(false);
			this.contextMenuOCRROrderEntryTemplateListVIEWItem.setEnabled(false);
			this.contextMenuOCRROrderEntryTemplateListPREVIEWItem.setEnabled(false);
		}
		public void hideAllOCRROrderEntryTemplateListMenuItems()
		{
			this.contextMenuOCRROrderEntryTemplateListADDItem.setVisible(false);
			this.contextMenuOCRROrderEntryTemplateListEDITItem.setVisible(false);
			this.contextMenuOCRROrderEntryTemplateListVIEWItem.setVisible(false);
			this.contextMenuOCRROrderEntryTemplateListPREVIEWItem.setVisible(false);
		}
		private Menu contextMenuOCRROrderEntryTemplateList;
		public MenuItem getOCRROrderEntryTemplateListADDItem()
		{
			return this.contextMenuOCRROrderEntryTemplateListADDItem;
		}
		private MenuItem contextMenuOCRROrderEntryTemplateListADDItem;
		public MenuItem getOCRROrderEntryTemplateListEDITItem()
		{
			return this.contextMenuOCRROrderEntryTemplateListEDITItem;
		}
		private MenuItem contextMenuOCRROrderEntryTemplateListEDITItem;
		public MenuItem getOCRROrderEntryTemplateListVIEWItem()
		{
			return this.contextMenuOCRROrderEntryTemplateListVIEWItem;
		}
		private MenuItem contextMenuOCRROrderEntryTemplateListVIEWItem;
		public MenuItem getOCRROrderEntryTemplateListPREVIEWItem()
		{
			return this.contextMenuOCRROrderEntryTemplateListPREVIEWItem;
		}
		private MenuItem contextMenuOCRROrderEntryTemplateListPREVIEWItem;
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[71];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_CareUk.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
