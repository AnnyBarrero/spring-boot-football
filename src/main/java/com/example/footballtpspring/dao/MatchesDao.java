package com.example.footballtpspring.dao;


import com.example.footballtpspring.pojos.Journee;
import com.example.footballtpspring.pojos.Matches;
import com.example.footballtpspring.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchesDao extends JpaRepository<Matches, Long> {

    List<Matches> findByJournee(Journee journee);

    List<Matches> findByStade(Stade stade);
}
