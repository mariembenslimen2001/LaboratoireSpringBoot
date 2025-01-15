package com.example.demo.entities;

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
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Publication {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String type;
	@NonNull
	private String titre;
	@NonNull
	private String lien;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date date;
	@NonNull
	private String sourcePDF;
	
	@Builder
    public Publication(Long id, String type, String titre, Date date, 
                    String lien, String sourcePDF) {
       
        this.id = id;
        this.type = type;
        this.titre = titre;
        this.date = date;
        this.sourcePDF=sourcePDF;
    }
	
	
	
	
	
}
