package com.example.footballtpspring.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private Long idStade;
    private String logo;
    private String nomEntraineur;
    private String president;
    private String status;
    private String siege;
    private String telephone;
    private String siteWeb;

    @ManyToMany(mappedBy = "equipes")
    private List<Championat> championats;

    @ManyToOne
    private Stade stade;
}
