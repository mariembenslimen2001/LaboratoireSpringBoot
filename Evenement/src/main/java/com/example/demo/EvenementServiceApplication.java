package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Evenement;
import com.example.demo.repository.EvenementRepository;

@SpringBootApplication
public class EvenementServiceApplication implements CommandLineRunner {

    @Autowired
    private EvenementRepository evenementRepository;

    public static void main(String[] args) {
        SpringApplication.run(EvenementServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Evenement evt1 = Evenement.builder()
                .titre("evenement1")
                .lieu("sfax")
                .date(new Date())
                .build();
        
        evenementRepository.save(evt1);
        
        Evenement evt2 = Evenement.builder()
                .titre("evenement2")
                .lieu("mahdia")
                .date(new Date())
                .build();
        
        evenementRepository.save(evt2);
        
        
        Evenement evt3 = Evenement.builder()
                .titre("evenement3")
                .lieu("sousssa")
                .date(new Date())
                .build();
        
        evenementRepository.save(evt3);
    }
    
    
}