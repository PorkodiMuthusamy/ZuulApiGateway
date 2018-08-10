package com.javasampleapproach.s3.listener;





import java.sql.Timestamp;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CutomStepListener implements StepExecutionListener {
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

}