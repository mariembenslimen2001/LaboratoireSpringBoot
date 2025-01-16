package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membre_Publication {
    @EmbeddedId 
    private Membre_Pub_Id id;
    
    @ManyToOne 
    @MapsId("auteur_id")
    private Member auteur;
}
