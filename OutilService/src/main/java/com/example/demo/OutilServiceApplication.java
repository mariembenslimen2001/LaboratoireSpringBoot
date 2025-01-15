package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Outil;
import com.example.demo.repository.OutilRepository;
//import com.example.demo.repository.PublicationRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
@SpringBootApplication
@EnableDiscoveryClient

@AllArgsConstructor



@EnableFeignClients
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
	            .nom("nom1")  // Ajoutez le champ 'nom'
	            .date(new Date())
	            .build();
	    
	    outilRepository.save(out1);
	    
	    Outil out2 = Outil.builder()
	            .source("source2")
	            .nom("nom2")  // Ajoutez le champ 'nom'
	            .date(new Date())
	            .build();
	    
	    outilRepository.save(out2);
	    
	    Outil out3 = Outil.builder()
	            .source("source3")
	            .nom("nom3")  // Ajoutez le champ 'nom'
	            .date(new Date())
	            .build();
	    
	    outilRepository.save(out3);
	}

	    
}