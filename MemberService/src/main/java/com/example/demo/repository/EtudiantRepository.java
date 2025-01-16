package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
//@CrossOrigin("http://localhost:4200")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
	List<Etudiant> findByEncadrant(EnseignantChercheur ens);
	
    
}
