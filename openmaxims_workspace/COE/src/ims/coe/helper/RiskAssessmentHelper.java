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
/*
 * Created on 15-Sep-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ims.coe.helper;

import ims.coe.vo.RiskAssessmentCollection;

import java.io.InputStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;
import ims.coe.vo.RiskAssessment;
import ims.coe.vo.RiskDescription;
import ims.coe.vo.RiskDescriptionCollection;

import java.util.Iterator;
import java.util.List;

/**
 * @author bworwood
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RiskAssessmentHelper 
{
	public  static RiskAssessmentCollection getMNARisks() throws DocumentException
	{
		return populateRisks("mna.xml"); 
	}
	
	public static RiskAssessmentCollection getBSRisks() throws DocumentException
	{
		return populateRisks("bradenscale.xml");
	}
	
	public static RiskAssessmentCollection getFARisks() throws DocumentException
	{
		return populateRisks("fallassessmentview.xml");
	}
	
	private static Document getXmlDocument(String file) throws DocumentException
	{
		InputStream stream = RiskAssessmentHelper.class.getResourceAsStream(file);
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(stream);
		return document;
	}
	

	private static synchronized RiskAssessmentCollection populateRisks(String fileName) throws DocumentException
	{	
		Document doc = getXmlDocument(fileName);
		
		RiskAssessmentCollection risks = new RiskAssessmentCollection();
		List list = doc.selectNodes("//risk_factors/risk_factor[@*]");
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			DefaultElement attribute = (DefaultElement) iter.next();
	
			RiskAssessment risk = new RiskAssessment();
			RiskDescriptionCollection coll = new RiskDescriptionCollection();
			risk.setName(attribute.valueOf("@name"));
			risk.setDescription(attribute.valueOf("@description"));
			risk.setMultiple(new Boolean(attribute.valueOf("@multiple").equalsIgnoreCase("Y")));
				
			List desc = attribute.selectNodes("description[@*]");
				
			for (Iterator it = desc.iterator(); it.hasNext();)
			{
				RiskDescription descr = new RiskDescription();
						
				DefaultElement description = (DefaultElement) it.next();
				descr.setId(description.valueOf("@id"));
				descr.setName(description.valueOf("@name"));
				descr.setScore(description.valueOf("@score"));
				descr.setDescription(description.valueOf("@description"));
				coll.add(descr);
			}
			risk.setRiskFactors(coll);
					
			risks.add(risk);
		}
		
		return risks;
	}
	

	
}
