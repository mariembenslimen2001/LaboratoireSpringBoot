package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {
	
	 //crud
    public Evenement addEvenement(Evenement e);
    public void deleteEvenement(Long id) ;
    public Evenement updateEvenement(Evenement e) ;
    public Evenement findEvenement(Long id) ;
    public List<Evenement> findAll();
    List<Evenement> findByTitre(String titre);
    List<Evenement> findByLieu(String lieu);
    List<Evenement> findByDateDebutBetween(Date startDate, Date endDate);
    List<Evenement> findByDateFinBetween(Date startDate, Date endDate);

    int[] getFullYearsEvents(int startYear, int endYear);

}
