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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.20 build 40820.730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.List;
import ims.admin.domain.DrawingConfiguration;
import ims.admin.domain.impl.DrawingConfigurationImpl;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.DrawingImageVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.nursing.domain.SkinBodyChart;
import ims.nursing.vo.SkinAssessment;
import ims.nursing.vo.SkinAssessmentCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;

public class SkinReviewImpl extends DomainImpl implements ims.nursing.domain.SkinReview, ims.domain.impl.Transactional
{
	/**
	 * Gets the drawing image
	 */
	public DrawingImageVo getDrawingImage(DrawingImageVo drawingImage) 
	{
		DrawingConfiguration drawingConfigImpl = (DrawingConfiguration)getDomainImpl(DrawingConfigurationImpl.class);
		return drawingConfigImpl.getDrawingImage(drawingImage);
	}

	/**
	* saves Skin Assessment + Review
	*/
	public void saveSkinAssessment(SkinAssessment skinAssVO) throws StaleObjectException
	{
		SkinBodyChart skinDomain = (SkinBodyChart)getDomainImpl(SkinBodyChartImpl.class);
		skinDomain.saveRecord(skinAssVO, null, null);
	}
	/**
	* call getReportAndTemplate form Core.Reports domainImpl
	*/	
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws DomainInterfaceException 
	{
		Reports impl = (Reports) getDomainImpl(ReportsImpl.class);
		return impl.getReportAndTemplate(nReportId, nTemplateId);
	}
	/**
	* Lists the Skin Assessments
	*/	
	public SkinAssessmentCollection listSkinAssessment(CareContextRefVo voCurrentCareContext)
	{
		SkinBodyChart skinDomain = (SkinBodyChart)getDomainImpl(SkinBodyChartImpl.class);
		return skinDomain.listSkinAssessment(voCurrentCareContext);
	}

	public CareContextShortVoCollection listSkinReviewCareContexts(Integer idPatient)
	{
		if (idPatient != null)
		{
			DomainFactory factory = getDomainFactory();
			List SkAsList  = factory.find(" select distinct scas.careContext from SkinAssessment scas where scas.careContext.episodeOfCare.careSpell.patient.id = :patId",
					new String[]{"patId"},
					new Object[]{idPatient});
	
			CareContextShortVoCollection voCareContextList = new CareContextShortVoCollection();
			for (int x = 0; x < SkAsList.size(); x++)
			{
				CareContext domSkAs = (CareContext) SkAsList.get(x);
				voCareContextList.add(CareContextShortVoAssembler.create(domSkAs));
			}
	
			return voCareContextList.sort();
		}
		
		return null;
		
	}

}
