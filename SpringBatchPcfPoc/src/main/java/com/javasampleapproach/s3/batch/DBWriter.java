package com.javasampleapproach.s3.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javasampleapproach.s3.model.User;
import com.javasampleapproach.s3.repository.UserRepository;
@Component
public class DBWriter implements ItemWriter<User> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		// TODO Auto-generated method stub
		
		userRepository.saveAll(users);
	}

}
