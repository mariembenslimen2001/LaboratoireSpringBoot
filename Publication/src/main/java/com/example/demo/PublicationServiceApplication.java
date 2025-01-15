
package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Publication;
import com.example.demo.repository.PublicationRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient

@AllArgsConstructor

@RepositoryRestController

@EnableFeignClients
public class PublicationServiceApplication implements CommandLineRunner {
	@Autowired
	PublicationRepository publicationRepository ;
	RepositoryRestConfiguration configuration;
	public static void main(String[] args) {
		
		SpringApplication.run(PublicationServiceApplication.class, args);
	}
	
	
    public void run(String... args) throws Exception {
    	configuration.exposeIdsFor(Publication.class);
		Publication pub1 = Publication.builder()
                .type("Article")
                .titre("Les nouveautés de Java 17")
                .lien("https://example.com/article-java-17")
                .date(new Date())
                .sourcePDF("https://example.com/article-java-17.pdf")
                .build();

         publicationRepository.save(pub1);

        
        Publication pub2 = Publication.builder()
                .type("Livre")
                .titre("Apprendre Spring Boot")
                .lien("https://example.com/livre")
                .date(new Date())
                .sourcePDF("https://example.com/livre.pdf")
                .build();

publicationRepository.save(pub2);

Publication pub3 = Publication.builder()
                .type("Conférence")
                .titre("Conférence sur les Microservices")
                .lien("https://example.com/conference")
                .date(new Date())
                .sourcePDF("https://example.com/conference.pdf")
                .build();

publicationRepository.save(pub3);

}
}