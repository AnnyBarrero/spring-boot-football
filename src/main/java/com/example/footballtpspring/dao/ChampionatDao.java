package com.example.footballtpspring.dao;

import com.example.footballtpspring.pojos.Championat;
import com.example.footballtpspring.pojos.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionatDao extends JpaRepository<Championat, Long>{

    List<Championat> findByPays(Pays pays);

}
