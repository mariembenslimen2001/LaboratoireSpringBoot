package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;

import jakarta.transaction.Transactional;
@Repository
public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
@CrossOrigin("http://localhost:4200")
	@Query("select m from Membre_Publication m where m.auteur.id = :x")
	List<Membre_Publication> findPubByAuteurId(@Param("x") Long auteurId);
	@Transactional
    void deleteAllByAuteur(Member auteur);
}
