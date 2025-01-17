package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Member;
@Repository
//@CrossOrigin("http://localhost:4200")
public interface MemberRepository extends JpaRepository<Member, Long> {

    // Recherche par CIN
    Member findByCin(String cin);

    // Recherche par email
    Member findByEmail(String email);

    // Recherche par nom commençant par un caractère
    List<Member> findByNomStartingWith(String caractere);
    
   // Member findById(Long id);

    // Recherche spécifique aux étudiants
    

    // Recherche spécifique aux enseignants
    

    // Recherche des enseignants par établissement
    

	

	List<Member> findByNom(String nom);

	
}
