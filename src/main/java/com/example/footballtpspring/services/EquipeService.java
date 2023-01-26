package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Equipe;

import java.util.List;

public interface EquipeService {

    Equipe addEquipe(Equipe equipe);
    Equipe getEquipe(Long idEquipe);
    List<Equipe> getAllEquipe();
}
