package com.example.footballtpspring.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private Integer capacite;
    private String telephone;

    @OneToMany(mappedBy = "stade")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "stade")
    private List<Matches> matches;

}
