package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.dao.ChampionatDao;
import com.example.footballtpspring.dao.JourneeDao;
import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Journee;
import com.example.footballtpspring.services.ChampionatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionatServiceImpl implements ChampionatService {

    @Autowired
    private ChampionatDao championatDao;

    @Autowired
    private JourneeDao journeeDao;

    @Override
    public Championat addChampionat(Championat championat) {
        return championatDao.save(championat);
    }

    @Override
    public Championat getChampionat(Long idChampionat) {
        return championatDao.findById(idChampionat).orElse(null);
    }

    @Override
    public List<Championat> getAllChampionat() {
        return championatDao.findAll();
    }

    @Override
    public List<Journee> getAllJournee(Championat championat) {
        return journeeDao.findByChampionat(championat);
    }

}
