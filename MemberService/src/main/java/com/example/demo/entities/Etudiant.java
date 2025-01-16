package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@DiscriminatorValue("etd")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant extends Member implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    private String diplome;
    private String sujet;

    @ManyToOne
    private EnseignantChercheur encadrant;

    @Builder
    public Etudiant(String cin, String nom, String prenom, Date dateNaissance, 
                    String cv, String email, String password, Date dateInscription, 
                    String sujet, String diplome, EnseignantChercheur encadrant) {
        super(cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }
}
