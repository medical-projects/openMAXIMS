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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.39 build 2166.24836)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.printreport;

import ims.admin.vo.ReportSeedParsedVo;
import ims.admin.vo.ReportSeedParsedVoCollection;
import ims.admin.vo.ReportSeedVo;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportVo;
import ims.admin.vo.ReportVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.forms.printreport.GenForm.grdReportsRow;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientDocumentStatusVo;
import ims.core.vo.PatientDocumentStatusVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.IReportField;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.PrinterScope;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

import java.io.File;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.tree.DefaultElement;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final int PREVIEW_REPORT = 1;
	private static final int PRINT_REPORT = 2;
	
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		
		form.ccPrinters().initialize(domain.getCurrentLocation(), PrinterScope.DEFAULT, false);		
		
		if(form.getGlobalContext().Core.getPrepareForPrintingIsNotNull() && form.getGlobalContext().Core.getPrepareForPrinting().equals(Boolean.TRUE))
		{
			form.btnPreview().setEnabled(false);
		}
		
		form.chkStoreCopy().setVisible(ConfigFlag.GEN.CREATE_NEW_PATIENTDOCUMENT_ON_PRINTREPORTDIALOG.getValue() && form.getGlobalContext().Core.getPatientShortIsNotNull());//WDEV-17772
		
		open();
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.ccPrinters().getSelectedPrinter() == null)
		{
			engine.showMessage("Please select a printer !");
			return;
		}

		if(!(form.grdReports().getValue() instanceof ReportTemplateVo))
		{
			engine.showMessage("Please select a template !");
			return;
		}
		
		if(form.getGlobalContext().Core.getPrepareForPrintingIsNotNull() && form.getGlobalContext().Core.getPrepareForPrinting().equals(Boolean.TRUE))
		{
			ReportTemplateVo template = (ReportTemplateVo)form.grdReports().getValue();

			form.getGlobalContext().Core.setPrinterSelect(form.ccPrinters().getSelectedPrinter().getIPrinterName());
			form.getGlobalContext().Core.setReport(template.getReport().getReportXml());
			form.getGlobalContext().Core.setTemplate(template.getTemplateXml());
			
			engine.close(DialogResult.OK);
			return;
		}
		
		if(buildReport(PRINT_REPORT))
		{
			engine.showMessage("The report was sent to the printer !");
			
			//WDEV-17772
			if (ConfigFlag.GEN.CREATE_NEW_PATIENTDOCUMENT_ON_PRINTREPORTDIALOG.getValue() && form.chkStoreCopy().getValue())
			{
				savePatientDocument();
			}
		}
	}

	//WDEV-17772
	private void savePatientDocument() 
	{
		
		if (form.getLocalContext().getServerDocument()==null)
			return;
		
		ReportTemplateVo template = (ReportTemplateVo)form.grdReports().getValue();
		
		PatientDocumentVo patientDocumentToSave = populatePatientDocumentVo(form.getLocalContext().getServerDocument(),template.getReport());
		
		// Validate Patient Assessment and Patient Document records
		String[] errors = patientDocumentToSave.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return ;
		}
		try
		{
			domain.savePatientDocument(patientDocumentToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			
			StringBuilder path = new StringBuilder();
			
			path.append(ConfigFlag.GEN.PDF_STORE_PATH.getValue());
			
			if(!(path.toString().endsWith("/") || path.toString().endsWith("\\")))
				path.append("/");
			
			path.append(patientDocumentToSave.getServerDocument().getFileName());
			
			// Attempt to delete uploaded document if stale occurs
			File file = new File(path.toString());
			
			if (file.exists() && file.canWrite())
				file.delete();
			
			return;
		}
	}
	
	//WDEV-17772
	private PatientDocumentVo populatePatientDocumentVo(ServerDocumentVo serverDocument, ReportVo reportVo)
	{
		if (serverDocument==null)
			return null;

		// Create Patient Document VO
		PatientDocumentVo patientDocument = new PatientDocumentVo();

		patientDocument.setPatient(form.getGlobalContext().Core.getPatientShort());

		patientDocument.setEpisodeofCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		patientDocument.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		patientDocument.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		
		if (reportVo!=null)
		{
			patientDocument.setName(reportVo.getReportName());
		}
		
		patientDocument.setServerDocument(serverDocument);
		patientDocument.setCreationType(DocumentCreationType.GENERATED);
	
		patientDocument.setCategory(DocumentCategory.ADHOC_DOCUMENT);
	
		patientDocument.setStatus(PreActiveActiveInactiveStatus.ACTIVE);
		
		patientDocument.setRecordingUser(domain.getMosUser() instanceof MemberOfStaffRefVo ? (MemberOfStaffRefVo) domain.getMosUser() : null);
		patientDocument.setRecordingDateTime(new DateTime());
		patientDocument.setAuthoringHCP(domain.getHcpLiteUser() instanceof HcpLiteVo ? (HcpRefVo)domain.getHcpLiteUser() : null);
		patientDocument.setAuthoringDateTime(new DateTime());
		
		// Create a new PatientDocumentStatusVo
		PatientDocumentStatusVo status = new PatientDocumentStatusVo();
		status.setCorrespondenceStatus(DocumentStatus.COMPLETED);
		status.setRecordingUser(patientDocument.getRecordingUser());
		status.setRecordingDateTime(patientDocument.getRecordingDateTime());

		patientDocument.setCurrentDocumentStatus(status);
		patientDocument.setDocumentStatusHistory(new PatientDocumentStatusVoCollection());
		patientDocument.getDocumentStatusHistory().add(status);
		
		patientDocument.setDocumentDate(form.getGlobalContext().Core.getCurrentCareContext() != null && form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime()!=null ? form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime().getDate() : patientDocument.getRecordingDateTime().getDate());
		patientDocument.setResponsibleHCP(form.getGlobalContext().Core.getEpisodeofCareShort()!=null ? form.getGlobalContext().Core.getEpisodeofCareShort().getResponsibleHCP():null);
		patientDocument.setSpecialty(form.getGlobalContext().Core.getEpisodeofCareShort()!=null ? form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty():null);
		
		return patientDocument;
	}
	
	protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		buildReport(PREVIEW_REPORT);
	}
	private boolean buildReport(int action)
	{
		if(!(form.grdReports().getValue() instanceof ReportTemplateVo))
		{
			engine.showMessage("Please select a template !");
			return false;
		}
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		ReportTemplateVo template = (ReportTemplateVo)form.grdReports().getValue();
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
		
		ReportSeedVo voReportSeed = new ReportSeedVo();

		IReportField[] reportField = engine.getFormData(engine.getPreviousNonDialogFormName(), voReportSeed.getIseeds(template.getReport().getSeeds()));
		
		if (reportField != null)
		{
			String seedName;
			
			ReportSeedParsedVoCollection seeds = null;
			
			try
			{
				seeds = parseSeedsFromXML(template.getReport().getReportXml());
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
				
				engine.showMessage(e.getMessage());
				return false;
			}
			
			for (int i = 0; i < reportField.length; i++)
			{
				try
				{
					seedName = getSeedName(reportField[i], seeds);
					
					client.addSeed(new SeedValue(seedName, reportField[i].getValue(), Class.forName(reportField[i].getType())));
				} 
				catch (ClassNotFoundException e)
				{
					engine.showMessage("Error building the report: " + e.toString());
				}
			}		
		}

		
		if(action == PREVIEW_REPORT)
		{
			String result = "";
			try
			{
				result = client.buildReportAsUrl(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", "",1);
			} 
			catch (QueryBuilderClientException e1)
			{
				engine.showMessage("Error building the report: " + e1.toString());
				return false;
			} 
	
			engine.openUrl(result);
		}
		else if(action == PRINT_REPORT)
		{
			try
			{
				//WDEV-17772
				byte[] reportContent = client.buildReport(template.getReport().getReportXml(), template.getTemplateXml(), urlReportServer, "PDF", form.ccPrinters().getSelectedPrinter().getIPrinterName(),1);
				
				String fileName = generateName() + ".pdf";
				engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), reportContent, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/");//WDEV-15470
				
				String path = null;// client.buildReportAndUpload(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, printerName, 1);
				
				int year  = new DateTime().getDate().getYear();
				int month = new DateTime().getDate().getMonth();
				int day   = new DateTime().getDate().getDay();
				
				if(fileName != null && fileName.length() > 0)
					path = year + "/" + month + "/" + day + "/" + fileName;//WDEV-15470

				// Create Server document VO if uploads succeeds
				ServerDocumentVo document = new ServerDocumentVo();
				document.setFileName(path);
				document.setFileType(FileType.PDF);
				
				form.getLocalContext().setServerDocument(document);
			} 
			catch (QueryBuilderClientException e1)
			{
				engine.showMessage("Error building the report: " + e1.toString());
				return false;
			} 
		}
		
		return true;
	}
	
	//WDEV-17772
	private String generateName() 
	{
		String str = "";

		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			//Get Third Random Segment
			byte bytes[] = new byte[16];
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}
		}
		catch (java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}

		return str;
	}
	
	private void open()
	{
		ReportVoCollection coll = domain.listReports(new Integer(engine.getPreviousNonDialogFormName().getID()));
		
		for(int i = 0; i < coll.size(); i++)
		{
			ReportVo report = coll.get(i);
			
			if(canBeSeeded(report) && report.getTemplatesIsNotNull() && report.getTemplates().size() > 0)
			{
				grdReportsRow row = form.grdReports().getRows().newRow();
				
				row.setBackColor(Color.Beige);
				row.setcolName(report.getReportName());
				row.setcolDescription(report.getReportDescription());
				row.setValue(report);
				
				for (int j = 0; j < report.getTemplates().size(); j++)
				{
					ReportTemplateVo template = report.getTemplates().get(j);
					
					grdReportsRow templateRow = row.getRows().newRow();
					templateRow.setcolName(template.getName());
					templateRow.setcolDescription(template.getDescription());
					templateRow.setValue(template);
				}
				
				row.setExpanded(true);
			}
		}
		
		if(form.grdReports().getRows().size() == 1 && form.grdReports().getRows().get(0).getRows().size() == 1)
			form.grdReports().setValue(form.grdReports().getRows().get(0).getRows().get(0).getValue());
	}
	private boolean canBeSeeded(ReportVo report)
	{
		//reports without seeds can always be printed
		if(!report.getSeedsIsNotNull())
			return true;
		
		if(report.getSeeds().size() == 0)
			return true;

		ReportSeedVo voReportSeed = new ReportSeedVo();
		
		return engine.formHasData(engine.getPreviousNonDialogFormName(), voReportSeed.getIseeds(report.getSeeds()));
	}
	protected void onChkAllValueChanged() throws PresentationLogicException
	{
		if(form.chkAll().getValue())
		{
			form.ccPrinters().initialize(null, PrinterScope.DEFAULT);			
		}
		else
		{
			form.ccPrinters().initialize(domain.getCurrentLocation(), PrinterScope.DEFAULT);			
		}		
	}
	
	private String getSeedName(IReportField field, ReportSeedParsedVoCollection seeds)
	{
		String ret = "";

		int pos = field.getName().lastIndexOf('.');
		ret = field.getName().substring(pos + 1);
		
		if(seeds != null)
		{
			for (int i = 0; i < seeds.size(); i++)
			{
				if(field.getName().equalsIgnoreCase(seeds.get(i).getBOName() + "_" + seeds.get(i).getBOField()))
				{
					ret = seeds.get(i).getName();
					break;
				}
			}
		}
		
		return  ret;
	}
	
	private ReportSeedParsedVoCollection parseSeedsFromXML(String reportXML) throws DocumentException
	{
		Document document = DocumentHelper.parseText(reportXML);

		ReportSeedParsedVoCollection seeds = new ReportSeedParsedVoCollection();
		List list = document.selectNodes("//Project/Seeds/Seed");
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			DefaultElement attribute = (DefaultElement) iter.next();

			ReportSeedParsedVo seed = new ReportSeedParsedVo();
			seed.setName(attribute.valueOf("Name"));
			seed.setType(attribute.valueOf("Type"));
			seed.setBOName(attribute.valueOf("BOName"));
			seed.setBOField(attribute.valueOf("BOField"));
			seed.setCanBeNull(new Boolean(attribute.valueOf("CanBeNull").equalsIgnoreCase("true")));
			seeds.add(seed);
		}

		return seeds;
	}
	
}
