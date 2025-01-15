package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Evenement;
import com.example.demo.repository.EvenementRepository;
//import com.example.demo.repository.OutilRepository;

import lombok.AllArgsConstructor;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class EvenementServiceApplication implements CommandLineRunner {

    @Autowired
    private EvenementRepository evenementRepository;

    public static void main(String[] args) {
        SpringApplication.run(EvenementServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Evenement evt1 = Evenement.builder()
                .titre("Événement 1")
                .lieu("Sfax")
                .dateDebut(new Date(2025 - 1900, 0, 15)) // 15 janvier 2025
                .dateFin(new Date(2025 - 1900, 0, 17))   // 17 janvier 2025
                .build();

        evenementRepository.save(evt1);

        Evenement evt2 = Evenement.builder()
                .titre("Événement 2")
                .lieu("Mahdia")
                .dateDebut(new Date(2025 - 1900, 1, 5)) // 5 février 2025
                .dateFin(new Date(2025 - 1900, 1, 7))   // 7 février 2025
                .build();

        evenementRepository.save(evt2);

        Evenement evt3 = Evenement.builder()
                .titre("Événement 3")
                .lieu("Sousse")
                .dateDebut(new Date(2025 - 1900, 2, 10)) // 10 mars 2025
                .dateFin(new Date(2025 - 1900, 2, 12))   // 12 mars 2025
                .build();

        evenementRepository.save(evt3);

        System.out.println("Les événements ont été ajoutés avec succès !");
    }
    
    
}