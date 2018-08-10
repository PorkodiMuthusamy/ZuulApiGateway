package com.javasampleapproach.s3.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class TaskletStep implements Tasklet{
	
	
	/*
	@Autowired
	S3Services s3Services;*/
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		/*Boolean fileexists = s3Services.fileExists();
		if(!fileexists) {
			throw new UnexpectedJobExecutionException("The file doesn't exist in the location specified");
		}*/
		return RepeatStatus.FINISHED;
	}

}
