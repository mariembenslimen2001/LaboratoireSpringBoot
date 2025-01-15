package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Evenement implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String titre;
    
    @NonNull @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NonNull @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    @NonNull
    private String lieu;
    
    public Evenement(String titre, Date dateDebut, Date dateFin, String lieu) {
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
    }
}