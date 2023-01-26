package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Pays;
import com.example.footballtpspring.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {

    @Autowired
    private PaysDao paysDao;

    @Autowired
    private ChampionatDao championatDao;

    @Override
    public Pays addPays(Pays pays) {
        return paysDao.save(pays);
    }

    @Override
    public Pays getPays(Long idPays) {
        return paysDao.findById(idPays).orElse(null);
    }

    @Override
    public List<Pays> getAllPays() {
        return paysDao.findAll();
    }

    @Override
    public List<Championat> getAllChampionat(Pays pays) {
        return championatDao.findByPays(pays);
    }

}
