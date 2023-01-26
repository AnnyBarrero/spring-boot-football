package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Matches;

import java.util.List;

public interface MatchesService {

    Matches addMatch(Matches match);
    Matches getMatch(Long idMatch);
    List<Matches> getAllMatches();
}
