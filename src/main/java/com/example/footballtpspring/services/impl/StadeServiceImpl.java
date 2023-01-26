package com.example.footballtpspring.services.impl;


import com.example.footballtpspring.pojos.Equipe;
import com.example.footballtpspring.pojos.Matches;
import com.example.footballtpspring.pojos.Stade;
import com.example.footballtpspring.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadeServiceImpl implements StadeService {

    @Autowired
    private StadeDao stadeDao;

    @Autowired
    private EquipeDao equipeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Stade addStade(Stade stade) {
        return stadeDao.save(stade);
    }

    @Override
    public Stade getStade(Long idStade) {
        return stadeDao.findById(idStade).orElse(null);
    }

    @Override
    public List<Stade> getAllStade() {
        return stadeDao.findAll();
    }

    @Override
    public List<Equipe> getAllEquipe(Stade stade) {
        return equipeDao.findByStade(stade);
    }

    @Override
    public List<Matches> getAllMatch(Stade stade) {
        return matchDao.findByStade(stade);
    }

}
