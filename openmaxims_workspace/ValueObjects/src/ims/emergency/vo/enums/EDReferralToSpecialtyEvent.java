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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.emergency.vo.enums;

public final class EDReferralToSpecialtyEvent extends ims.framework.utils.Enum
{
	public final static EDReferralToSpecialtyEvent NEW_REFERRAL = new EDReferralToSpecialtyEvent(0, "NEW_REFERRAL", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent SEEN = new EDReferralToSpecialtyEvent(1, "SEEN", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent NOT_ACCEPTED = new EDReferralToSpecialtyEvent(2, "NOT_ACCEPTED", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent COMPLETED = new EDReferralToSpecialtyEvent(3, "COMPLETED", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent ADMISSION = new EDReferralToSpecialtyEvent(4, "ADMISSION", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent TRANSFER = new EDReferralToSpecialtyEvent(5, "TRANSFER", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent DISCHARGE = new EDReferralToSpecialtyEvent(6, "DISCHARGE", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent SAVE = new EDReferralToSpecialtyEvent(7, "SAVE", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent CANCEL = new EDReferralToSpecialtyEvent(8, "CANCEL", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent CLOSE = new EDReferralToSpecialtyEvent(9, "CLOSE", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent EDIT = new EDReferralToSpecialtyEvent(10, "EDIT", null, ims.framework.utils.Color.Default);
	public final static EDReferralToSpecialtyEvent SAVE_AND_CLOSE = new EDReferralToSpecialtyEvent(11, "SAVE_AND_CLOSE", null, ims.framework.utils.Color.Default);

	private EDReferralToSpecialtyEvent(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
