package com.javasampleapproach.s3.listener;

import java.sql.Timestamp;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class TotalTimeJobListener implements JobExecutionListener{
	private Timestamp beforejob;
	private Timestamp afterjob;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		beforejob = new Timestamp(System.currentTimeMillis());
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		afterjob = new Timestamp(System.currentTimeMillis());
		//long diff = afterjob.getTime() - beforejob.getTime();
		 long milliseconds = afterjob.getTime() - beforejob.getTime();
		    int seconds = (int) milliseconds / 1000;
		 
		    // calculate hours minutes and seconds
		    int days = seconds/216000;
		    int hours = seconds / 3600;
		    int minutes = (seconds % 3600) / 60;
		    seconds = (seconds % 3600) % 60;
		 
		 
		    System.out.println("job starting time: " + beforejob);
		    System.out.println("job ending time: " + afterjob);
		 
		    System.out.println("Difference: ");
		    System.out.println(" Days: " + days);
		    System.out.println(" Hours: " + hours);
		    System.out.println(" Minutes: " + minutes);
		    System.out.println(" Seconds: " + seconds);
		//System.out.println("beforestep: "+beforestep +" afterstep: "+afterstep+" diff: "+diff);
        
        //System.out.println("Number of records completed::::::"+count);
       //System.out.println("Time taken for chunk to complete in milliseconds::::"+diff);
	}

}
