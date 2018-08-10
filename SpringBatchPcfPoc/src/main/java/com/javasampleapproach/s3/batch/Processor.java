package com.javasampleapproach.s3.batch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.javasampleapproach.s3.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	private static final Map<String, String> DEPT_NAMES = new HashMap<>();
	
	public Processor() {
		/*DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002","Operations");
		DEPT_NAMES.put("003","Accounts");*/
	}
	
	@Override
	public User process(User user) throws Exception {
		TimeUnit.SECONDS.sleep(1);
		return user;
	}
	

}
