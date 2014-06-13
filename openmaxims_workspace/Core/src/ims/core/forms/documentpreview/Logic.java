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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.80 build 4091.21781)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.documentpreview;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientDocumentVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (args == null || args.length ==0)
			throw new PresentationLogicException("No valid document found in open arguments");
		String fileName = null;
		if (args[0] instanceof PatientDocumentVo)
		{
			fileName = ((PatientDocumentVo)args[0]).getServerDocument().getFileName();
		}

		showDocument(fileName);
		
	}
	private void showDocument(String fileName) throws ims.framework.exceptions.PresentationLogicException
	{
		if (fileName == null)
			throw new PresentationLogicException("No valid document found in open arguments");
		
		String fullPath = getFullPath(fileName);
		form.htmPreview().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + fullPath +  "'></IFRAME>");
	}
	private String getFullPath(String fileName)
	{
		//Hack at the moment to make documents saved in 3 different parts visible
		
		//FILE_SERVER_URL points to an http page
		return getFileServerURL() + fileName;
		
	}
	
	private String getFileServerURL()
	{ 
		return ConfigFlag.GEN.FILE_SERVER_URL.getValue();
	}	
	
	
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.ABORT);
	}
}
