package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Evenement;

import java.util.Date;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	    List<Evenement> findByTitre(String titre);
	    List<Evenement> findByLieu(String lieu);
	    List<Evenement> findByDateDebutBetween(Date startDate, Date endDate);
	    List<Evenement> findByDateFinBetween(Date startDate, Date endDate);
}