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
public class Journee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Long idChampionat;

    @OneToMany(mappedBy = "journee")
    private List<Matches> matches;

    @ManyToOne
    private Championat championat;

    public Journee(Integer numero, Long idChampionat) {
        this.numero = numero;
        this.idChampionat = idChampionat;
    }

}
