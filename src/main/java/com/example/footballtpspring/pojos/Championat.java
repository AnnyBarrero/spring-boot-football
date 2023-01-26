package com.example.footballtpspring.pojos;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Championat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String logo;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer pointGagne;
    private Integer pointPerdu;
    private Integer pointNul;
    private String typeClassement;

    @ManyToOne
    private Pays pays;

    @ManyToMany
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "championat")
    private List<Journee> journees;

}
