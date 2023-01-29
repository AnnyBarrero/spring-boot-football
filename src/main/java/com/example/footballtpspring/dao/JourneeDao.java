package com.example.footballtpspring.dao;

import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Journee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JourneeDao extends JpaRepository<Journee, Long> {

    List<Journee> findByChampionat(Championat championat);
}
