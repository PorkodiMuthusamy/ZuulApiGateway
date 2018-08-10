package com.javasampleapproach.s3.listener;

import java.sql.Timestamp;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
 
public class ItemCountListener implements ChunkListener {
	private Timestamp beforestep;
	private Timestamp afterstep;
    @Override
    public void beforeChunk(ChunkContext context) {

		beforestep = new Timestamp(System.currentTimeMillis());
    }
 
    @Override
    public void afterChunk(ChunkContext context) {

	//	System.out.println("StepExecutionListener - afterStep");
		afterstep = new Timestamp(System.currentTimeMillis());
		long diff = afterstep.getTime() - beforestep.getTime();
		//System.out.println("beforestep: "+beforestep +" afterstep: "+afterstep+" diff: "+diff);
        int count = context.getStepContext().getStepExecution().getReadCount();
        System.out.println("count of the chunk records: "+count);
        
        int seconds = (int) diff / 1000;
        System.out.println("no of seconds took"+seconds);
        int minutes = (seconds ) / 60;
	    seconds = (seconds % 3600) % 60;
        
        System.out.println("no of minutes took"+minutes);
    }
     
    @Override
    public void afterChunkError(ChunkContext context) {
    }
}
