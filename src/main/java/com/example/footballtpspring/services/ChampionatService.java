package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Journee;

import java.util.List;

public interface ChampionatService {

    Championat addChampionat(Championat championat);
    Championat getChampionat(Long idChampionat);
    List<Championat> getAllChampionat();
    List<Journee> getAllJournee(Championat championat);

}
