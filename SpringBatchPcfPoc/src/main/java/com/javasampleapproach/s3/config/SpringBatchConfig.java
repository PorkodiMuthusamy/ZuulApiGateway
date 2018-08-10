package com.javasampleapproach.s3.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.javasampleapproach.s3.listener.ItemCountListener;
import com.javasampleapproach.s3.listener.TotalTimeJobListener;
import com.javasampleapproach.s3.model.User;
import com.javasampleapproach.s3.tasklet.TaskletStep;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired
	public TaskletStep taskletStep;
	
	  @Autowired
	    public JobBuilderFactory jobBuilderFactory;
	 
	    @Autowired
	    public StepBuilderFactory stepBuilderFactory;

	    @Value("${dataString}")
		  private String dataString;
		
		@Value("${rangeValue}")
		  private String rangeValue;
		
		
		@Autowired
		private AmazonS3 s3client;

		@Value("${jsa.s3.bucket}")
		private String bucketName;

	
	@Value("${jsa.s3.key}")
	private String downloadKey;
	
	@Value("${jsa.aws.access_key_id}")
	private String awsId;

	@Value("${jsa.aws.secret_access_key}")
	private String awsKey;
	
	@Value("${jsa.s3.region}")
	private String region;
	

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<User> itemReader,
			ItemProcessor<User,User> itemProcessor,
			ItemWriter<User> itemWriter) {
		
		Step step2=stepBuilderFactory.get("step2")
				.<User,User>chunk(2)
				.reader(itemReader )
				.processor(itemProcessor)
				.writer(itemWriter).listener(listener()).build();
		
		return jobBuilderFactory.get("job")
		.incrementer(new RunIdIncrementer())
		.start(step1()).next(step2)
		.build();
		
	}
	//new AmazonS3Resource(amazons3client, bucketName, downloadKey)
	@Bean
	public FlatFileItemReader<User> itemReader() throws Exception{
		FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource((Resource) new ByteArrayResource(getBytes(), "s3 bytes"));
		
		flatFileItemReader.setName("CSV-Reader");
		//flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}        
	
	@Bean
	public LineMapper<User> lineMapper(){
		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
	
		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);
		
		defaultLineMapper.setLineTokenizer(fixedLengthTokenizer());
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}
	

	@Bean
    public LineTokenizer fixedLengthTokenizer() {
            FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
          ArrayList<Range> rangeArray  = new ArrayList<Range>();
            
            StringTokenizer st = new StringTokenizer(rangeValue,"|");
            while(st.hasMoreTokens()){
                String[] rangearray = st.nextToken().split("\\s*,\\s*");
            
                	if(rangearray.length==2) {
                		rangeArray.add(new Range(Integer.parseInt(rangearray[0]),Integer.parseInt(rangearray[1])));                		
                	}
            }
            Range[] r = new Range[rangeArray.size()];
            int i=0;
               for(Range range: rangeArray) {
            	   r[i]=range;
            	   i++;
               }
               StringTokenizer st1 = new StringTokenizer(dataString,",");
               ArrayList<String> dataArray  = new ArrayList<String>();
               
               while(st1.hasMoreTokens()){
            	   dataArray.add(st1.nextToken());
               }
               String[] dataarray = new String[dataArray.size()];
               int j=0;
               for(String data: dataArray) {
            	   dataarray[j]=data;
            	   j++;
               }
               tokenizer.setNames( dataarray);
           
            tokenizer.setColumns(r);
            return tokenizer;
    }
	

	
	@Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
        		.tasklet(taskletStep)
                .build();
    }
	
	
	public byte[] getBytes() throws IOException {
        S3Object object = s3client.getObject(bucketName, downloadKey);
        try (InputStream is = object.getObjectContent()) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copy(is, out);
            return out.toByteArray();
        }
    }


@Bean
public ItemCountListener listener() {
    return new ItemCountListener();
}

@Bean
public TotalTimeJobListener jobListener() {
    return new TotalTimeJobListener();
}
}


