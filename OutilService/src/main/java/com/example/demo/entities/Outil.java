package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "outils")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Outil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    @NonNull
    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
