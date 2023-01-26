package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.pojos.Journee;
import com.example.footballtpspring.pojos.Matches;
import com.example.footballtpspring.services.JourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneeServiceImpl implements JourneeService {

    @Autowired
    private JourneeDao journeeDao;

    @Autowired
    private MatchDao matchDao;

    @Override
    public Journee addJournee(Journee journee) {
        return journeeDao.save(journee);
    }

    @Override
    public Journee getJournee(Long idJournee) {
        return journeeDao.findById(idJournee).orElse(null);
    }

    @Override
    public List<Journee> getAllJournee() {
        return journeeDao.findAll();
    }

    @Override
    public List<Matches> getAllMatches(Journee journee) {
        return matchDao.findByJournee(journee);
    }

}
