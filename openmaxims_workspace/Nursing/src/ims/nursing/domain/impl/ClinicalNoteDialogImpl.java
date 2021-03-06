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
// This code was generated by Callum Wells using IMS Development Environment (version 1.20 build 40913.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;
import ims.nursing.domain.ClinicalNotes;
import ims.nursing.vo.NursingClinicalNotesVo;
import ims.core.vo.HcpLiteVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.core.vo.domain.HcpLiteVoAssembler;

public class ClinicalNoteDialogImpl extends DomainImpl implements ims.nursing.domain.ClinicalNoteDialog, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * saves a clinical note
	 */
	public NursingClinicalNotesVo saveClinicalNotes(NursingClinicalNotesVo voNotes) throws StaleObjectException
	{
		ClinicalNotes clinicalNotes = (ClinicalNotes)getDomainImpl(ClinicalNotesImpl.class);
		return clinicalNotes.saveClinicalNotes(voNotes);
	}

	public HcpLiteVo getHcpLite(Integer idHcp) {
		DomainFactory factory = getDomainFactory();
		Hcp hcp = (Hcp) factory.getDomainObject(Hcp.class,idHcp);
		return HcpLiteVoAssembler.create(hcp);
	}
}
