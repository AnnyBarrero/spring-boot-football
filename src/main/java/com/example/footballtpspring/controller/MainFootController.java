package com.example.footballtpspring.controller;

import com.example.footballtpspring.pojos.*;
import com.example.footballtpspring.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainFootController {

    @Autowired
    private UserService userService;
    @Autowired
    private PaysService paysService;
    @Autowired
    private ChampionatService championatService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private JourneeService journeeService;
    @Autowired
    private StadeService stadeService;
    @Autowired
    private MatchesService matchesService;

    public MainFootController(
            UserService userService,
            PaysService paysService,
            ChampionatService championatService,
            EquipeService equipeService,
            JourneeService journeeService,
            StadeService stadeService,
            MatchesService matchesService) {
        super();
        this.userService = userService;
        this.paysService = paysService;
        this.championatService = championatService;
        this.equipeService = equipeService;
        this.journeeService = journeeService;
        this.stadeService = stadeService;
        this.matchesService = matchesService;
    }

    @PostConstruct
    private void init() {

        if (userService.getAllUser().isEmpty()) {
            Stade stade = new Stade("Juventus Stadium", "Corso Gaetano Scirea", 41507, "011 453 0486");
            Equipe equipe1 = new Equipe("JUVE", LocalDate.now(), 1L, "juve.png", "Paul", "Pogba", "test", "test", "07894548123", "test.it");
            Equipe equipe3 = new Equipe("test2", LocalDate.now(), 1L, "juve.png", "Dusan Vlahovic", "Pierre", "test", "test", "07894548123", "test.it");
            Equipe equipe2 = new Equipe("test1", LocalDate.now(), 1L, "juve.png", "Ángel Di María", "Charlotte", "test", "test", "07894548123", "test.it");
            Equipe equipe4 = new Equipe("test3", LocalDate.now(), 1L, "juve.png", "Michel", "Fred", "test", "test", "07894548123", "test.it");
            Equipe equipe5 = new Equipe("test4", LocalDate.now(), 1L, "juve.png", "Federico", "Chiesa", "test", "test", "07894548123", "test.it");
            Equipe equipe6 = new Equipe("test5", LocalDate.now(), 1L, "juve.png", "Leandro", "Paredes", "test", "test", "04789123", "test.it");

            Championat championat = new Championat("test1", "test", LocalDate.now(), LocalDate.now(), 10, 41, 3, "test");
            Championat championat2 = new Championat("test2", "test", LocalDate.now(), LocalDate.now(), 3, 5, 1, "test");
            Championat championat3 = new Championat("test3", "test", LocalDate.now(), LocalDate.now(), 25, 12, 5, "test");
            Championat championat4 = new Championat("test4", "test", LocalDate.now(), LocalDate.now(), 5, 6, 1, "test");


//
            List<Championat> championats = championatService.getAllChampionat();

            Pays pays = new Pays("Italia", "test", championats);
            Journee journee = new Journee(1, 1L);
            Matches matches = new Matches(2, 3, 1L, 2L, 1L, 1L);
            User user1 = new User("RICCI", "Francesco", "France1", "FranceMDP", "France", "Franceri@gmail.com");
            User user2 = new User("GRECCO", "Lorenzo", "Lore2", "LoreMDP", "Lore", "loregrec@gmail.com");
            User user3 = new User("ROSSI", "Leonardo", "Leona3", "LeonaMDP", "Leona", "leonaros@gmail.com");
            User user4 = new User("DE LUCA", "Alessandro", "Ale5", "AleMDP", "Ale", "aledelu@gmail.com");
            User user5 = new User("COSTA", "Mattia", "Matt6", "MattMDP", "Matt", "mattcosta@gmail.com");
            User user6 = new User("ESPOSITO", "Gabriele", "Gab7", "GabMDP", "Gab", "gabespo@gmail.com");


        }

    }


}
