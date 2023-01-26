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

    public Equipe(String nom, LocalDate dateCreation, Long idStade, String logo, String nomEntraineur, String president, String status, String siege, String telephone, String siteWeb) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.idStade = idStade;
        this.logo = logo;
        this.nomEntraineur = nomEntraineur;
        this.president = president;
        this.status = status;
        this.siege = siege;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
    }
}
