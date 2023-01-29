package com.example.footballtpspring.dao;

import com.example.footballtpspring.pojos.Equipe;
import com.example.footballtpspring.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
    List<Equipe> findByStade(Stade stade);
}
