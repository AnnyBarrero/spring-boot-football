package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Equipe;
import com.example.footballtpspring.pojos.Matches;
import com.example.footballtpspring.pojos.Stade;

import java.util.List;

public interface StadeService {

    Stade addStade(Stade stade);
    Stade getStade(Long idStade);
    List<Stade> getAllStade();
    List<Equipe> getAllEquipe(Stade stade);
    List<Matches> getAllMatch(Stade stade);

}
