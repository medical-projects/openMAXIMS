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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ims.clinical.domain.base.impl.BaseDiagnosisDialogImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.DiagLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.PatientDiagnosisAtConsultationVoCollection;
import ims.core.vo.domain.PatientDiagnosisAtConsultationVoAssembler;
import ims.domain.DomainFactory;

public class DiagnosisDialogImpl extends BaseDiagnosisDialogImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.DiagLiteVoCollection listDianosis(String diagSearch, String existingDiagnosis)
	{
		if(diagSearch == null)
			return null;
		
		diagSearch = diagSearch.trim().toUpperCase();
		
		if(diagSearch == null || diagSearch.length() == 0)
			return null;
		
		DomainFactory factory = getDomainFactory();
        Connection conection = factory.getJdbcConnection();
        
        StringBuffer sql = new StringBuffer();
        
        sql.append("select a.id, a.diagnosisn from core_diagnosis a LEFT OUTER JOIN core_diagnosis_keywords k ON a.id = k.id where (k.keyword like ? or a.diagnosisn like ?) and a.isactive = 1 ");
        
        if (existingDiagnosis != null && existingDiagnosis.trim().length() > 0)
		{
        	sql.append(" and a.id not in ("+existingDiagnosis+")");
		}
        
        sql.append(" order by upper(a.diagnosisn)");
        
        DiagLiteVoCollection diagnosisColl = new DiagLiteVoCollection();
        PreparedStatement ps;	
    		
        try 
        {
        	ps = conection.prepareCall(sql.toString());
        	ps.setString(1, diagSearch + "%");
        	ps.setString(2, diagSearch + "%");
        
        	ResultSet rs = ps.executeQuery();
        
        	while(rs.next())
        	{
        		DiagLiteVo vo = new DiagLiteVo();
        		vo.setID_Diagnosis(Integer.valueOf(rs.getString(1)));
        		vo.setDiagnosisName(rs.getString(2));
        		diagnosisColl.add(vo);
        	}
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
        
        return diagnosisColl;
	}

	public PatientDiagnosisAtConsultationVoCollection listPatientDiagnosis(CareContextRefVo attendance) 
	{
		if(attendance == null || attendance.getID_CareContext() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select pd from PatientDiagnosis as pd left join pd.careContext as cc where cc.id = :AttendenceId order by UPPER(pd.diagnosisDescription) asc";
		
		List<?> list = factory.find(query, new String[] {"AttendenceId"}, new Object[] {attendance.getID_CareContext()});
		
		return PatientDiagnosisAtConsultationVoAssembler.createPatientDiagnosisAtConsultationVoCollectionFromPatientDiagnosis(list);
	}
}
