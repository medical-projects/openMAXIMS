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
// This code was generated by Michael Noonan using IMS Development Environment (version 1.53 build 2620.27330)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorComposite;
import com.jamonapi.MonitorFactory;

import ims.admin.domain.base.impl.BaseServiceStatsImpl;
import ims.framework.utils.DateTime;

import ims.admin.vo.ServiceMonitorVoCollection;
import ims.admin.vo.ServiceMonitorVo;
public class ServiceStatsImpl extends BaseServiceStatsImpl
{

	private static final long	serialVersionUID	= 1L;

	/**
	 * Resets all the Monitor counters
	 */
	public void resetMonitor()
	{
		MonitorFactory.getRootMonitor().reset();
	}

	/**
	 * Retrieves all the Service Monitor Values
	 */
	public ServiceMonitorVoCollection getServiceMonitors(String filter)
	{
		MonitorComposite rootMonitor = MonitorFactory.getRootMonitor();
		Monitor[] allMonitors = rootMonitor.getMonitors();
		ServiceMonitorVoCollection ret = new ServiceMonitorVoCollection();
		Monitor currentMonitor = null;
		String serviceName = null;
		for (int i = 0; i < allMonitors.length; i++)
		{
			currentMonitor = allMonitors[i];
			ServiceMonitorVo vo = new ServiceMonitorVo();
			List list = new ArrayList();
			currentMonitor.getMonKey().getRowData(list);
			serviceName = list.get(0).toString();

			if (filter == null || filter.equals("") || (serviceName.indexOf(filter) != -1))
			{
				vo.setServiceName(serviceName);

				vo.setHits(new Integer((int) currentMonitor.getHits()));
				vo.setAvg(new Integer((int) currentMonitor.getAvg()));
				vo.setTotal(new Integer((int) currentMonitor.getTotal()));
				vo.setStdDev(new Float((float) currentMonitor.getStdDev()));
				vo.setLast(new Float((float) currentMonitor.getLastValue()));
				vo.setMin(new Float((float) currentMonitor.getMin()));
				vo.setMax(new Float((float) currentMonitor.getMax()));
				vo.setActive(new Integer((int) currentMonitor.getActive()));
				vo.setAvgActive(new Float((float) currentMonitor.getAvgActive()));
				vo.setMaxActive(new Integer((int) currentMonitor.getMaxActive()));
				vo.setFirstAccess(new DateTime(currentMonitor.getFirstAccess()));
				vo.setLastAccess(new DateTime(currentMonitor.getLastAccess()));
				ret.add(vo);
			}
		}

		return ret;
	}
}
