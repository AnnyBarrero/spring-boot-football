package com.example.footballtpspring.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private String pseudo;
    private String email;

    public User(String nom, String prenom, String login, String mdp, String pseudo, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.email = email;
    }


}
