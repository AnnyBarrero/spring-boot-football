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

}
