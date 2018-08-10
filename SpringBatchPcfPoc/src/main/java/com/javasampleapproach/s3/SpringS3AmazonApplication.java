package com.javasampleapproach.s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringS3AmazonApplication /*implements CommandLineRunner*/{

	/*@Autowired
	S3Services s3Services;*/
	
	/*@Value("${jsa.s3.uploadfile}")
	private String uploadFilePath;*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringS3AmazonApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		//System.out.println("---------------- START UPLOAD FILE ----------------");
		//s3Services.uploadFile("jsa-s3-upload-file.txt", uploadFilePath);
		System.out.println("---------------- START DOWNLOAD FILE ----------------");
		s3Services.downloadFile(downloadKey);
	}*/
}
