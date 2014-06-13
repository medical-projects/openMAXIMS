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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2418.19363)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.core.charting.domain.objects.DatasetType;
import ims.core.charting.vo.DatasetTypeRefVo;
import ims.core.domain.base.impl.BaseDataSetTypeAddEditImpl;
import ims.core.vo.DataSetTypeVo;
import ims.core.vo.domain.DataSetTypeVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UnqViolationUncheckedException;

public class DataSetTypeAddEditImpl extends BaseDataSetTypeAddEditImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* saveDataSetType
	*/
	public ims.core.vo.DataSetTypeVo saveDataSetType(ims.core.vo.DataSetTypeVo recordVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (!recordVo.isValidated())
			throw new DomainRuntimeException("DataSetType record has not been validated");
		
		DomainFactory factory = getDomainFactory();
		ims.core.charting.domain.objects.DatasetType bo = DataSetTypeVoAssembler.extractDatasetType(factory, recordVo);
		
		try
		{
			factory.save(bo);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new ims.domain.exceptions.UniqueKeyViolationException(e); 
		}

		return DataSetTypeVoAssembler.create(bo);
	}

	public DataSetTypeVo getDataSetType(DatasetTypeRefVo id)
	{
		return DataSetTypeVoAssembler.create((DatasetType) getDomainFactory().getDomainObject(ims.core.charting.domain.objects.DatasetType.class, id.getID_DatasetType()));
	}

}
