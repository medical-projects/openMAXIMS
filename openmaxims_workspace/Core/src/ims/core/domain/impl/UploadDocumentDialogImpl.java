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
// This code	 was generated by Catalin Tomozei using IMS Development Environment (version 1.65 build 3176.28343)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.careuk.domain.objects.CatsReferral;
import ims.careuk.vo.CatsReferralRefVo;
import ims.careuk.vo.CatsReferralWizardVo;
import ims.careuk.vo.domain.CatsReferralWizardVoAssembler;
import ims.core.documents.domain.objects.PatientDocument;
import ims.core.domain.base.impl.BaseUploadDocumentDialogImpl;
import ims.core.vo.PatientDocumentSaveVo;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class UploadDocumentDialogImpl extends BaseUploadDocumentDialogImpl
{
	private static final long serialVersionUID = 1L;

	public CatsReferralWizardVo getCatsReferral(CatsReferralRefVo voCatsRef) 
	{
		return CatsReferralWizardVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}

	public ims.core.vo.PatientDocumentSaveVo savePatientDocument(ims.core.vo.PatientDocumentVo document, CatsReferralWizardVo catReferral,CatsReferralRefVo voRef) throws ims.domain.exceptions.StaleObjectException
	{
		if (document != null)
		{
			if (!document.isValidated())
				throw new DomainRuntimeException("PatientDocumentVo not validated");
		}
				
		DomainFactory factory = getDomainFactory();
		PatientDocument doc = PatientDocumentVoAssembler.extractPatientDocument(factory, document);
		factory.save(doc);				

		if (catReferral != null || voRef != null)
		{
			CatsReferral doCatsReferral = CatsReferralWizardVoAssembler.extractCatsReferral(factory, catReferral);
			if (voRef != null) {						
				doCatsReferral.getReferralDocuments().add(doc);						
			}		
			factory.save(doCatsReferral);
			
			PatientDocumentSaveVo vo = new PatientDocumentSaveVo();
			vo.setPatientDocumentVo(PatientDocumentVoAssembler.create(doc));
			vo.setCatsReferralWizardVo(CatsReferralWizardVoAssembler.create(doCatsReferral));
			
			return vo;
		}
		
		PatientDocumentSaveVo vo = new PatientDocumentSaveVo();
		vo.setPatientDocumentVo(PatientDocumentVoAssembler.create(doc));		
		return vo;
	}



	
}
