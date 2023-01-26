package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Pays;

import java.util.List;

public interface PaysService {

    Pays addPays(Pays pays);
    Pays getPays(Long idPays);
    List<Pays> getAllPays();
    List<Championat> getAllChampionat(Pays pays);



}
