package com.example.footballtpspring.dao;

import com.example.footballtpspring.pojos.Pays;
import com.example.footballtpspring.pojos.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaysDao extends JpaRepository<Pays, Long> {
}
