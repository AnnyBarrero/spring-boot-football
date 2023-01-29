package com.example.footballtpspring.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer pointsEquipe1;
    private Integer pointsEquipe2;
    private Long idStade;
    private Long idEquipe1;
    private Long idEquipe2;
    private Long idJournee;

    @ManyToOne
    private Stade stade;

    @ManyToOne
    private Journee journee;

    @ManyToOne
    private Equipe equipe1;

    @ManyToOne
    private Equipe equipe2;

    public Matches(Integer pointsEquipe1, Integer pointsEquipe2, Long idStade, Long idEquipe1, Long idEquipe2, Long idJournee) {
        this.pointsEquipe1 = pointsEquipe1;
        this.pointsEquipe2 = pointsEquipe2;
        this.idStade = idStade;
        this.idEquipe1 = idEquipe1;
        this.idEquipe2 = idEquipe2;
        this.idJournee = idJournee;
    }
}
