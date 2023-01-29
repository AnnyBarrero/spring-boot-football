package com.example.footballtpspring.services;

import com.example.footballtpspring.pojos.Journee;
import com.example.footballtpspring.pojos.Matches;

import java.util.List;

public interface JourneeService {

    Journee addJournee(Journee journee);
    Journee getJournee(Long idJournee);
    List<Journee> getAllJournee();
    List<Matches> getAllMatches(Journee journee);


}
