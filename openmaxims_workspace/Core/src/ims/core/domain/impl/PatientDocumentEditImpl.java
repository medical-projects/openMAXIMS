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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 3967.21051)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.documents.domain.objects.PatientDocument;
import ims.core.domain.DocumentWorklist;
import ims.core.domain.base.impl.BasePatientDocumentEditImpl;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class PatientDocumentEditImpl extends BasePatientDocumentEditImpl
{

	private static final long serialVersionUID = 1L;

	public Boolean isDocumentStillCheckedOut(ims.core.documents.vo.PatientDocumentRefVo documentId)
	{
		if(documentId == null || !documentId.getID_PatientDocumentIsNotNull())
			throw new CodingRuntimeException("Can not check if document is still checked out on a null Document Id.");
		
		DomainFactory factory = getDomainFactory();
		
		long isCheckedOut = factory.countWithHQL("select count(pd.id) from PatientDocument as pd where pd.id = :patientDocument and pd.isLockedForEditing = 1 and pd.lockedByUser.id =:currUser", new String[] {"patientDocument","currUser"}, new Object[] {documentId.getID_PatientDocument(),((MemberOfStaffShortVo)getMosUser()).getID_MemberOfStaff()});
		
		if (isCheckedOut==1)
			return true;
		return false;
		
	}

	public PatientDocumentVo savePatientDocument(PatientDocumentVo document) throws StaleObjectException 
	{
		DocumentWorklist impl = (DocumentWorklist) getDomainImpl(DocumentWorklistImpl.class);
		return impl.savePatientDocument(document);
	}

	public PatientDocumentVo refreshPatDoc(PatientDocumentVo patDoc)
	{
		DomainObject domainObject = getDomainFactory().getDomainObject(PatientDocument.class, patDoc.getID_PatientDocument());
		if (domainObject.getVersion()==patDoc.getBoVersion())
			return patDoc;
		return PatientDocumentVoAssembler.create((PatientDocument) domainObject);
	}
}
