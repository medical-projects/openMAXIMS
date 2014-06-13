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
package ims.rules.helper;

import java.util.List;
import java.util.ArrayList;

public final class InvestigationStatus extends ims.rules.types.RulesEngineEntity
{
	private static final long serialVersionUID = 1L;

	public InvestigationStatus(List<ims.rules.types.RulesEngineEntity> entities)
	{
		super.id = "1070100011";
		if(entities.contains(this))
			return;
		else
			entities.add(this);

		super.name = "Investigation Status";
		super.isPublic = true;
		super.supportsNotifications = false;
		super.description = "Investigation Status";
		super.businessObjectName = "ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus";
		super.fields = new ArrayList<ims.rules.types.RulesEngineField>();
		super.fields.add(new ims.rules.types.RulesEngineField("58954972006131122515536346212", "Status", "Status", false, ims.rules.types.RulesEngineFieldType.LOOKUP, null, 1161027, "OrdInvStatus", this));
		super.actions = new ArrayList<ims.rules.types.RulesEngineEntityMethod>();
	}
}
