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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.65 build 3210.27143)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.forms.dnabatchupdate;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.scheduling.domain.impl.DnaBatchUpdateImpl;
import ims.scheduling.forms.dnabatchupdate.GenForm.grdJobRow;
import ims.scheduling.vo.DnaBatchUpdateVo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.quartz.old.CronTrigger;
import org.quartz.old.JobDetail;
import org.quartz.old.Scheduler;
import org.quartz.old.SchedulerException;
import org.quartz.old.SchedulerFactory;
import org.quartz.old.SimpleTrigger;
import org.quartz.old.impl.StdSchedulerFactory;

import com.ims.query.builder.client.PrinterAvailableCollection;
import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;
import com.thoughtworks.xstream.XStream;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static int dayWeek=1;
	private static JobDetail jd;
	private static boolean isRunning=false;
	private static Scheduler scheduling=null;
	private static String day="";

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		//The frecuency of the trigger can be daily weekly or monthly
		form.cmbFrecuency().newRow("Daily", "Daily");
		form.cmbFrecuency().newRow("Weekly", "Weekly");
		form.cmbFrecuency().newRow("Monthly", "Monthly");
		form.cmbFrecuency().setValue("Daily");
		form.dtim().setValue(new DateTime());
		form.lyr1().showDays();
		
		loadPrinterList();
		
		initialize();
	}

	private void loadPrinterList()
	{
		form.cmbPrintTo().clear();
	
		QueryBuilderClient qbc = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());

		try
		{
			PrinterAvailableCollection printers = qbc.listPrinters(ConfigFlag.GEN.REPORT_SERVER_URL.getValue());

			String[] printersColl = new String[printers.size()];

			for (int i = 0; i < printers.size(); i++)
			{
				form.cmbPrintTo().newRow(printers.get(i).getName(), printers.get(i).getName());
				printersColl[i] = printers.get(i).getName();
			}
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error getting the printers list: " + e.toString());
		}
	}

	private void initialize()
	{
		populateGrid(null);
		updateControlState();
	}

	private void populateGrid(DnaBatchUpdateVo batch)
	{
		//Populates the job information grid
		form.grdJob().getRows().clear();
		
		
		//If the argument is null then we get the info from the database
		DnaBatchUpdateVo batchVo=null;
		if (batch==null)
			batchVo = domain.getJob();
		else
			batchVo=batch;
		form.grdJob().setValue(batchVo);
		if (batchVo!=null)
		{
			grdJobRow row = form.grdJob().getRows().newRow();
			if (batchVo.getCreationDateIsNotNull())
				row.setcolCreatedOn(batchVo.getCreationDate());
			if (batchVo.getTriggerFrecuencyIsNotNull())
				row.setcolFrequency(batchVo.getTriggerFrecuency());
			if (batchVo.getNameIsNotNull())
				row.setcolJob(batchVo.getName());
			if (batchVo.getLastRunIsNotNull())
				row.setcolLastRun(batchVo.getLastRun().toString());
			if (batchVo.getNextRunIsNotNull())
				row.setcolNextRun(batchVo.getNextRun().toString());
			if (batchVo.getNumAppointmentsUpdatedIsNotNull())
				row.setcolNumberAppts(batchVo.getNumAppointmentsUpdated());
			isRunning=true;
			try
			{
				SchedulerFactory sf = new StdSchedulerFactory();
				Collection scheds = sf.getAllSchedulers();
				Iterator<Scheduler> iter=scheds.iterator();
				Scheduler scheduler=null;
				while (iter.hasNext())
				{
					scheduler=iter.next();
					for (int i=0; i<scheduler.getJobGroupNames().length;i++)
					{
						if (scheduler.getJobGroupNames()[i].equals("DNA"))
						{
							scheduling=scheduler;
							break;
						}
						
					}
					
				}
				
			}
			catch (SchedulerException e)
			{
				engine.showMessage(e.getMessage());
			}
		}
		else
		{
			form.grdJob().getRows().clear();
			form.grdJob().setVisible(false);
			isRunning=false;
		}
	}
	
		
		
	

	@SuppressWarnings("deprecation")
	@Override
	protected void onBtnSetClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ArrayList <String> errors=validateUILogic();
		//Check for the errors in the logic of the form
		if (errors!=null)
		{
			engine.showErrors(errors.toArray(new String[0]));
			return;
		}
		if(form.btnSet().getText().equals("Reset Task"))
			onBtnCancelClick();
		
		SchedulerFactory sf = new StdSchedulerFactory();
		Object repeatInterval=null;
		String intervalFebruary=null;
		String startTime=null;
		String triggerFrecuency=null;
		DateTime startDate=new ims.framework.utils.DateTime();
		String month="*";
		DnaBatchUpdateVo oldBatch = domain.getJob();
		DnaBatchUpdateVo dnaBatchVo=null;
		//If there is a batch job in the database we take and edit it, if not, we create a new one.
		//There will always be a maximum of 1 job in the database.
		if (oldBatch==null)
			dnaBatchVo=new DnaBatchUpdateVo();
		else
			dnaBatchVo=oldBatch;
		dnaBatchVo.setName("DNA Batch Update");
		dnaBatchVo.setLastRun(null);
		dnaBatchVo.setNumAppointmentsUpdated(null);

		dnaBatchVo.setPrintAgentTo(form.cmbPrintTo().getValue());
		
		CronTrigger cron=null;
		SimpleTrigger simpleCron=null;
		CronTrigger cronFebruary=null;
		int days=1;

		try
		{

			Scheduler sched = sf.getScheduler();
			//We create the job
		    jd= new JobDetail("bookings", "DNA", DnaBatchUpdateImpl.class);
		    XStream xS=new XStream();
		    
	        String fs = xS.toXML(jd);
	        dnaBatchVo.setJobDetail(fs);
	       

			if (form.dtim().getValue()!=null)
			{
				startDate=form.dtim().getValue();
				//StartTime will be a substring (the first three characters) of the cron expression we are going to use to set the trigger's data. 
				startTime=String.valueOf(startDate.getTime().getSecond()) + " " + String.valueOf(startDate.getTime().getMinute()) + " " + String.valueOf(startDate.getTime().getHour());
			}
			//Everytime the job is executed it will edit the appointments which date is between the current date and a given date. Here we set that given date.
			domain.setHours(form.intPreviousXhours().getValue());
		
			if (form.lyr1().Days().intEveryXdays().getValue()!=null)
				days=form.lyr1().Days().intEveryXdays().getValue();
			//We set the interval frecuency in the trigger
			if (form.cmbFrecuency().getValue()!=null)
				if (form.cmbFrecuency().getValue().equals("Daily"))
				{
					//If it's daily we set the number of days in miliseconds. For this I'm using a simpleTrigger because the crontrigger does not allow an interval bigger than 31 days.
					repeatInterval=days*24L*3600L*1000L;
					triggerFrecuency="Every " + days + " days";
				
					
					
				}
				//For weeks and months I will use the cronTrigger
				else if (form.cmbFrecuency().getValue().equals("Weekly"))
				{
					//I complete the cron expression
					repeatInterval=(String)(startTime + " ? * " + dayWeek);
					
					triggerFrecuency="Every " + day;
					
				}
				else if (form.cmbFrecuency().getValue().equals("Monthly"))
				{
					if (form.lyr1().Months().intDayOfTheMonth()!=null)
					{
						//I complete the cron expression. If the day of the month is higher than 30 I set the month as L=last day of month, as there are months that don't have 31 days
						if (form.lyr1().Months().intDayOfTheMonth().getValue()>30)
							month="L";
						else
							month=form.lyr1().Months().intDayOfTheMonth().getValue().toString();
						triggerFrecuency="Day number " + form.lyr1().Months().intDayOfTheMonth().getValue() + " of each Month";
					}
					repeatInterval=(String)(startTime + " " + month + " * ?") ;
					
					
				}
			dnaBatchVo.setTriggerFrecuency(triggerFrecuency);
			try
			{
				//If the repeat interval is a string I use the cron trigger, if not I use the simple trigger
				if (repeatInterval instanceof String)
				{
					cron=new CronTrigger("mytriggers",sched.DEFAULT_GROUP,repeatInterval.toString());
					if(dnaBatchVo.getID_DnaBactchJob()==null)
						sched.scheduleJob(jd,cron);
					XStream xST=new XStream();
					String cronn=xST.toXML(cron);
					dnaBatchVo.setCron(cronn);
					dnaBatchVo.setIsSimpleCron(false);
				}
				else
				{
					java.util.Calendar cal = new java.util.GregorianCalendar(startDate.getDate().getYear(),startDate.getDate().getMonth()-1,startDate.getDate().getDay(),startDate.getTime().getHour(),startDate.getTime().getMinute(),startDate.getTime().getSecond());
				

					Date startingTime = cal.getTime();
					simpleCron=new SimpleTrigger("simpleCron", sched.DEFAULT_GROUP, startingTime, null, SimpleTrigger.REPEAT_INDEFINITELY, Long.parseLong(repeatInterval.toString()));
					if(dnaBatchVo.getID_DnaBactchJob()==null)
						sched.scheduleJob(jd, simpleCron);
					XStream xST=new XStream();
					String cronn=xST.toXML(simpleCron);
					dnaBatchVo.setCron(cronn);
					dnaBatchVo.setIsSimpleCron(true);
				}
				//If the day is after 28, we get a problem with february. To fix it I launch another trigger only for this case.
				if (form.lyr1().Months().intDayOfTheMonth()!=null)
					if (form.lyr1().Months().intDayOfTheMonth().getValue()!=null)
						if (form.lyr1().Months().intDayOfTheMonth().getValue()>28)
						{
							intervalFebruary=startTime + " 28 2 ?";
							cronFebruary=new CronTrigger("triggerFebruary",sched.DEFAULT_GROUP,intervalFebruary);
							cronFebruary.setJobName("bookings");
							sched.scheduleJob(cronFebruary);
							XStream xST=new XStream();
							String cronn=xST.toXML(cronFebruary);
							dnaBatchVo.setCronFebruary(cronn);
							
							
						}
				sched.start();
				isRunning=true;
				scheduling=sched;
				
				//I set the next run information into the vo
				if (cronFebruary!=null)
				{
					Date today=new Date();
					if (today.getMonth()==1)
					{
						dnaBatchVo.setNextRun(new ims.framework.utils.DateTime(cronFebruary.getNextFireTime()));
					}
					else if (cron!=null)
						dnaBatchVo.setNextRun(new ims.framework.utils.DateTime(cron.getNextFireTime()));
					else
						dnaBatchVo.setNextRun(new ims.framework.utils.DateTime(simpleCron.getNextFireTime()));
				}
				else if (cron!=null)
					dnaBatchVo.setNextRun(new ims.framework.utils.DateTime(cron.getNextFireTime()));
				else{
					if(simpleCron.getNextFireTime()!=null)
						dnaBatchVo.setNextRun(new ims.framework.utils.DateTime(simpleCron.getNextFireTime()));
				}
				
				domain.setTriggerFrecuency(triggerFrecuency);
				dnaBatchVo.setTriggerFrecuency(triggerFrecuency);
				dnaBatchVo.setCreationDate(new ims.framework.utils.Date());
				try
				{
					domain.save(dnaBatchVo);
				}
				catch (StaleObjectException e)
				{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
				
				
				updateControlState();
				
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
		
		populateGrid(dnaBatchVo);
		form.grdJob().setVisible(true);
		
	}

	@Override
	protected void onCmbFrecuencyValueChanged() throws PresentationLogicException
	{
		if (form.cmbFrecuency().getValue()!=null)
			if(form.cmbFrecuency().getValue().equals("Daily"))
			{
				disableTabs();
				form.lyr1().Days().intEveryXdays().setValue(null); //WDEV-15377
				form.lyr1().showDays();
			}
			else if (form.cmbFrecuency().getValue().equals("Weekly"))
			{
				disableTabs();
				clearWeekDays();//WDEV-15377
				form.lyr1().showWeeks();
			}
			else 
			{
				disableTabs();
				form.lyr1().Months().intDayOfTheMonth().setValue(null); //WDEV-15377
				form.lyr1().showMonths();
			}

	}

	private void clearWeekDays()
	{
		form.lyr1().Weeks().chkMonday().setValue(null); 
		form.lyr1().Weeks().chkTuesday().setValue(null);
		form.lyr1().Weeks().chkWednesday().setValue(null);
		form.lyr1().Weeks().chkThursday().setValue(null);
		form.lyr1().Weeks().chkFriday().setValue(null);
		form.lyr1().Weeks().chkSaturday().setValue(null);
		form.lyr1().Weeks().chkSunday().setValue(null);
	}

	private void disableTabs()
	{
		form.lyr1().hide();
	}

	@Override
	protected void onChkFridayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkFriday().setValue(true);
		dayWeek=6;
		day="Friday";
	}

	@Override
	protected void onChkMondayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkMonday().setValue(true);
		dayWeek=2;
		day="Monday";
	}

	@Override
	protected void onChkSaturdayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkSaturday().setValue(true);
		dayWeek=7;
		day="Saturday";
	}

	@Override
	protected void onChkSundayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkSunday().setValue(true);
		dayWeek=1;
		day="Sunday";
	}

	@Override
	protected void onChkThursdayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkThursday().setValue(true);
		dayWeek=5;
		day="Thursday";
	}

	@Override
	protected void onChkTuesdayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkTuesday().setValue(true);
		dayWeek=3;
		day="Tuesday";
	}

	@Override
	protected void onChkWednesdayValueChanged() throws PresentationLogicException
	{
		disableCheckBoxes();
		form.lyr1().Weeks().chkWednesday().setValue(true);
		dayWeek=4;
		day="Wednesday";
	}

	private void disableCheckBoxes()
	{
		form.lyr1().Weeks().chkMonday().setValue(false);
		form.lyr1().Weeks().chkTuesday().setValue(false);
		form.lyr1().Weeks().chkWednesday().setValue(false);
		form.lyr1().Weeks().chkThursday().setValue(false);
		form.lyr1().Weeks().chkFriday().setValue(false);
		form.lyr1().Weeks().chkSaturday().setValue(false);
		form.lyr1().Weeks().chkSunday().setValue(false);
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		//When clicking the cancel button, the job will be stopped and deleted.
		try
		{
			Scheduler sched = scheduling;
			//-----------------------
			if(sched == null)
			{
				try
				{
					SchedulerFactory sf = new StdSchedulerFactory();
					Collection scheds = sf.getAllSchedulers();
					Iterator<Scheduler> iter=scheds.iterator();
					Scheduler scheduler=null;
					while (iter.hasNext())
					{
						scheduler=iter.next();
						for (int i=0; i<scheduler.getJobGroupNames().length;i++)
						{
							if (scheduler.getJobGroupNames()[i].equals("DNA"))
							{
								scheduling=scheduler;
								break;
							}
							
						}
						
					}
					sched = scheduling;
					
				}
				catch (SchedulerException e)
				{
					engine.showMessage(e.getMessage());
				}
			}
			//--------------------
			if(sched != null) //--------------------
				sched.deleteJob("bookings","DNA");
			else//--------------------
			{				
				return;   //------------------
			}//--------------------------
							
			try 
			{
				domain.removeTask();
			} 
			catch (ForeignKeyViolationException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			}
			isRunning=false;
			updateControlState();
			form.grdJob().setVisible(false);
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	
	protected void updateControlState()
	{
		if (isRunning)
		{
			form.btnSet().setEnabled(true);
			form.btnSet().setText("Reset Task");
			form.btnCancel().setEnabled(true);
		}
		else
		{
			form.btnSet().setEnabled(true);
			form.btnSet().setText("Set Task");
			form.btnCancel().setEnabled(false);
		}
	}
	

	public ArrayList<String> validateUILogic()
	{
		ArrayList <String> errors=new ArrayList<String>();
		if (form.cmbFrecuency().getValue()==null)
			errors.add("Frequency is Mandatory");
		if (form.dtim().getValue()==null||form.dtim().getValue().getDate()==null||form.dtim().getValue().getTime()==null)
			errors.add("Start date is Mandatory");
		if (form.dtim().getValue()!=null)
			if (form.dtim().getValue().compareTo(new DateTime())==-1)
				errors.add("Start Date must be a Future Date");
		if (form.intPreviousXhours().getValue()==null)
			errors.add("Number of hours is a Mandatory field");
		else
			if (form.intPreviousXhours().getValue()>100000000)
				errors.add("Number of previous hours cannot exceed 100000000");
		if (form.cmbFrecuency().getValue()!=null)
		{
			if (form.cmbFrecuency().getValue().equals("Daily"))
				if (form.lyr1().Days().intEveryXdays().getValue()==null)
					errors.add("If daily frequency is selected, the value Days is Mandatory");
			if (form.cmbFrecuency().getValue().equals("Weekly"))
				if (!form.lyr1().Weeks().chkFriday().getValue()&&!form.lyr1().Weeks().chkSaturday().getValue()&&!form.lyr1().Weeks().chkSunday().getValue()&&!form.lyr1().Weeks().chkMonday().getValue()&&!form.lyr1().Weeks().chkTuesday().getValue()&&!form.lyr1().Weeks().chkWednesday().getValue()&&!form.lyr1().Weeks().chkThursday().getValue())
					errors.add("If weekly frequency is selected, it is Mandatory to select a day of the week");
			if (form.cmbFrecuency().getValue().equals("Monthly"))
				if (form.lyr1().Months().intDayOfTheMonth().getValue()==null)
					errors.add("If monthly frequency is selected, the value Day of the Month is Mandatory");
				else if(form.lyr1().Months().intDayOfTheMonth().getValue()<1||form.lyr1().Months().intDayOfTheMonth().getValue()>31)
					errors.add("Not a valid Day of the Month. It must be between 1 and 31");
		}
		
		if(form.cmbPrintTo().getValue() == null)
			errors.add("Please select the printer where the report will be printed to.");
			
		if (errors.size()>0)
			return errors;
		else 
			return null;
	}

}
