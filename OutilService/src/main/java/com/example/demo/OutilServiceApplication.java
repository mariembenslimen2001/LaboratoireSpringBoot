package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entities.Outil;
import com.example.demo.repository.OutilRepository;

@SpringBootApplication
public class OutilServiceApplication implements CommandLineRunner {
	
	@Autowired
    private OutilRepository outilRepository;


	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}
	 @Override
	    public void run(String... args) throws Exception {
		 Outil out1 = Outil.builder()
	                .source("source1")
	                .date(new Date())
	                .build();
	        
		 outilRepository.save(out1);
	        
		 Outil out2 = Outil.builder()
	                
	                .source("source2")
	                .date(new Date())
	                .build();
	        
		 outilRepository.save(out2);
	        
	        
		 Outil out3 = Outil.builder()
	         
	                .source("source3")
	                .date(new Date())
	                .build();
	        
		 outilRepository.save(out3);
	    }
	    
}