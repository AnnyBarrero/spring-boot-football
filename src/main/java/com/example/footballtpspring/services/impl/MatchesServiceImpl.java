package com.example.footballtpspring.services.impl;

import com.example.footballtpspring.dao.MatchesDao;
import com.example.footballtpspring.pojos.Matches;
import com.example.footballtpspring.services.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesServiceImpl implements MatchesService {

    @Autowired
    private MatchesDao matchDao;

    @Override
    public Matches addMatch(Matches matches) {
        return matchDao.save(matches);
    }

    @Override
    public Matches getMatches(Long idMatch) {
        return matchDao.findById(idMatch).orElse(null);
    }

    @Override
    public List<Matches> getAllMatches() {
        return matchDao.findAll();
    }


}
