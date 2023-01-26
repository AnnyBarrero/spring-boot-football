package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.pojos.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.footballtpspring.services.EquipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeDao equipeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeDao.save(equipe);
    }

    @Override
    public Equipe getEquipe(Long idEquipe) {
        return equipeDao.findById(idEquipe).orElse(null);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeDao.findAll();
    }


}
