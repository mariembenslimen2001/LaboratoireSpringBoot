package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member implements Serializable {

private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.DATE)
    private String grade;
    private String etablissement;

   

    @Builder
    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, 
                    String cv, String email, String password,  
                      String etablissement, String grade) {
        super(cin, nom, prenom, dateNaissance, cv, email, password);
        
        this.grade = grade;
        this.etablissement = etablissement;
        
    }
}
