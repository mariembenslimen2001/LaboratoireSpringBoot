package com.example.demo.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Classe Java Bean représentant une publication.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PublicationBean {

    private Long id;
    
    @NonNull
    private String type;
    
    @NonNull
    private String titre;
    
    @NonNull
    private String lien;
    
    @NonNull
    private Date date;
    
    @NonNull
    private String sourcePDF;

}
