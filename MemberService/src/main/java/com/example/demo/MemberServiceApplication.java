package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EnseignantChercheurRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.IMemberService;
import com.example.demo.service.MemberImpl;

import lombok.AllArgsConstructor;
@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class MemberServiceApplication implements CommandLineRunner {
	
	MemberRepository MemberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	IMemberService MemberService;
	
	MemberImpl MemberImpl;

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    // Création d'un étudiant avec le builder
	    Etudiant etd1 = Etudiant.builder()
	            .nom("Benslimen")
	            .prenom("Mariem")
	            .cin("12345678")
	            .cv("cv.pdf")
	            .dateNaissance(new Date())
	             // Ajout de la date d'inscription
	             // Ajout du diplôme
	             // Ajout du sujet
	            .email("benslimen.mariem@enis.tn")
	            .password("12345678")
	            .build();
	    
	    // Sauvegarde de l'étudiant dans la base de données
	    etudiantRepository.save(etd1);
	    
	    EnseignantChercheur ens1 = EnseignantChercheur.builder()
	            .nom("Sponge")
	            .prenom("Bob")
	            .cin("12345679")
	            .cv("cv1.pdf")
	            .dateNaissance(new Date())
	             // Ajout de la date d'inscription
	             // Ajout du diplôme
	             // Ajout du sujet
	            .email("sponge.bob@enis.tn")
	            .password("123456789")
	            .grade("prof")
	            .etablissement("ENIS")
	            .build();
	    
	    // Sauvegarde de l'étudiant dans la base de données
	    enseignantChercheurRepository.save(ens1);
	    
	    MemberService.affectEtudiantToEncadrant(1L, 2L);
		// void affecterEtudiantToEnseignant(1,2)
	    
	    MemberService.affecterAuteurToPublication(1L,3L);
		MemberService.affecterUserToOutil(1L, 2L);
		MemberService.affecterMemberToEvenement(2L,3L);
	}
	
	
   
	    	
	 

}
