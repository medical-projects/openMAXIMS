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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseEDSeenByAndCompleteDialogImpl;
import ims.emergency.domain.objects.SeenByHCP;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.SeenByHCPVo;
import ims.emergency.vo.TrackingForSeenByHCPVo;
import ims.emergency.vo.domain.EmergencyAttendanceForTrackingVoAssembler;
import ims.emergency.vo.domain.SeenByHCPVoAssembler;
import ims.emergency.vo.domain.TrackingForSeenByHCPVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class EDSeenByAndCompleteDialogImpl extends BaseEDSeenByAndCompleteDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.SeenByHCPVoCollection getAllSeenByHCP(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SeenByHCPVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select allSeenBy from SeenByHCP as allSeenBy where allSeenBy.attendance.id = :attID order by allSeenBy.allocatedDateTime desc ");

		List<?> list = factory.find(hql.toString(), new String[] { "attID" }, new Object[] { careContextRef.getID_CareContext() });

		return SeenByHCPVoAssembler.createSeenByHCPVoCollectionFromSeenByHCP(list);
	}

	public ims.emergency.vo.SeenByHCPVo getSeenByHCP(ims.emergency.vo.SeenByHCPRefVo seenByHCP)
	{
		if (seenByHCP == null || seenByHCP.getID_SeenByHCP() == null)
		{
			throw new CodingRuntimeException("Cannot get SeenByHCPVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		SeenByHCP domainSeenBy = (SeenByHCP) factory.getDomainObject(SeenByHCP.class, seenByHCP.getID_SeenByHCP());

		return SeenByHCPVoAssembler.create(domainSeenBy);
	}

	public SeenByHCPVo save(SeenByHCPVo seenByHcpToSave, TrackingForSeenByHCPVo trackingToSave, SeenByHCPVo seenByHcpMustSavedAsCompleted) throws StaleObjectException
	{
		if (seenByHcpToSave == null && trackingToSave == null)
			throw new CodingRuntimeException("Cannot save null ReferralToSpecialtyTeamVo or TrackingForReferalToSpecialtyVo ");

		DomainFactory factory = getDomainFactory();

		if (seenByHcpMustSavedAsCompleted!=null)
		{
			SeenByHCP domainSeenByHcpCompleted = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHcpMustSavedAsCompleted);
			factory.save(domainSeenByHcpCompleted);
		}
		
		if (seenByHcpToSave != null && trackingToSave == null)
		{
			if (!seenByHcpToSave.isValidated())
				throw new DomainRuntimeException("SeenByHCPVo Not Validated.");

			SeenByHCP domainSeenByHcpToSave = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHcpToSave);
			factory.save(domainSeenByHcpToSave);

			return SeenByHCPVoAssembler.create(domainSeenByHcpToSave);
			
		}
		else if (seenByHcpToSave == null && trackingToSave != null)
		{
			if (!trackingToSave.isValidated())
				throw new DomainRuntimeException("TrackingForSeenByHCPVoAssembler Not Validated.");

			Tracking domainTrackingforSeenByHcp = TrackingForSeenByHCPVoAssembler.extractTracking(factory, trackingToSave);
			factory.save(domainTrackingforSeenByHcp);

			TrackingForSeenByHCPVo track = TrackingForSeenByHCPVoAssembler.create(domainTrackingforSeenByHcp);

			if (track != null)
				return track.getSeenBy();
		}
		else if (seenByHcpToSave != null && trackingToSave != null)
		{
			if (!seenByHcpToSave.isValidated())
				throw new DomainRuntimeException("TrackingForReferalToSpecialtyVo Not Validated.");

			if (!trackingToSave.isValidated())
				throw new DomainRuntimeException("TrackingForAllocatedMedicVo Not Validated.");

			Tracking domainTrackingforSeenByHcp = TrackingForSeenByHCPVoAssembler.extractTracking(factory, trackingToSave);
			factory.save(domainTrackingforSeenByHcp);

			SeenByHCP domainSeenByHcpToSave = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHcpToSave);
			factory.save(domainSeenByHcpToSave);

			return SeenByHCPVoAssembler.create(domainSeenByHcpToSave);
		}

		return null;

	}

	public Boolean isStale(ims.emergency.vo.SeenByHCPVo seenByHcp)
	{
		if (seenByHcp == null || seenByHcp.getID_SeenByHCP() == null)
		{
			throw new CodingRuntimeException("Cannot get ReferralToSpecialtyTeamVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		SeenByHCP domainSeenByToSave = (SeenByHCP) factory.getDomainObject(SeenByHCP.class, seenByHcp.getID_SeenByHCP());

		if (domainSeenByToSave == null)
		{
			return true;
		}

		if (domainSeenByToSave.getVersion() > seenByHcp.getVersion_SeenByHCP())
		{
			return true;
		}

		return false;
	}

	public ims.framework.utils.DateTime getAttendanceRegistrationDateTime(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get AllocatedMedicVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select att from EmergencyAttendance as att where att.careContext.id = :careContextID ");

		List<?> list = factory.find(hql.toString(), new String[] { "careContextID" }, new Object[] { careContextRef.getID_CareContext() });

		return EmergencyAttendanceForTrackingVoAssembler.createEmergencyAttendanceForTrackingVoCollectionFromEmergencyAttendance(list).get(0).getRegistrationDateTime();
	}

	public ims.emergency.vo.TrackingForSeenByHCPVo getTracking(ims.emergency.vo.TrackingRefVo trackingRef)
	{
		if (trackingRef == null || trackingRef.getID_Tracking() == null)
		{
			throw new CodingRuntimeException("Cannot get TrackingAreaRefVo on null Id for Tracking ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select tracking from Tracking as tracking where tracking.id = :trackingID ");

		List<?> list = factory.find(hql.toString(), new String[] { "trackingID" }, new Object[] { trackingRef.getID_Tracking() });
	
		if (list!=null && list.size()>0)
		{
			return TrackingForSeenByHCPVoAssembler.create((Tracking) list.get(0));
		}

		return null;
	}

	public Boolean isMostRecentRecordCompleted(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public SeenByHCPVo getUncompletedSeenByHCPCareContext(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SeenByHCPVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select allSeenBy from SeenByHCP as allSeenBy where allSeenBy.attendance.id = :attID and allSeenBy.completedDateTime is null  order by allSeenBy.allocatedDateTime desc ");

		List<?> list = factory.find(hql.toString(), new String[] { "attID" }, new Object[] { careContextRef.getID_CareContext() });

		if (list!=null && list.size()>0)
			return SeenByHCPVoAssembler.create((SeenByHCP)list.get(0));
		
		return null;
	}

}
