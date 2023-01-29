package com.example.footballtpspring.controller;

import com.example.footballtpspring.pojos.*;
import com.example.footballtpspring.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

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

   //Utilisateur, login
        @GetMapping({ "/","login"})
        public String login() {
            return "login";
        }

        @GetMapping({ "home_page"})
        public String accueil() {
            return "home_page";
        }

        @PostMapping({"loginUser"})
        public RedirectView loginUser(Model model, @RequestParam String uname, @RequestParam String psw) {
            List<User> users = userService.getAllUser();
            boolean connected = false;
            for (User userOfBdd : users) {
                if (Objects.equals(uname, userOfBdd.getLogin()) && Objects.equals(psw, userOfBdd.getMdp())) {
                    connected = true;
                    break;
                }
            }

            if(connected){
                return new RedirectView("home_page");
            }
            else{
                return new RedirectView("");
            }
        }
//        Creer un utilisateur
        @GetMapping({"addUser"})
        public String addUser() {
            return "register";
        }

        @PostMapping({"saveUser"})
        public RedirectView saveUser(Model model,@RequestParam String uname, @RequestParam String psw) {
            User user = new User();
            user.setLogin(uname);
            user.setMdp(psw);
            userService.addUser(user);
            return new RedirectView("/");

        }
//        details pour chaque equipe
        @GetMapping({ "equipe/{idEquipe}/detail"})
        public String details_equipe(Model model, @PathVariable long idEquipe) {
            Equipe equipe = equipeService.getEquipe(idEquipe);
            List<Stade> stades = stadeService.getAllStade();
            model.addAttribute("allStades", stades);

            model.addAttribute("equipe", equipe);

            return "details";
        }

        @GetMapping({ "equipe/newEquipe"})
        public String newEquipe(Model model, @ModelAttribute Equipe equipe) {
            List<Stade> stades = stadeService.getAllStade();
            model.addAttribute("allStades", stades);
            model.addAttribute("equipe", equipe);
            return "details";
        }

        @PostMapping(value = "equipe/saveEquipe")
        public RedirectView saveEquipe(Model model, @Validated @ModelAttribute Equipe equipe, @RequestParam long stadeId){
            Stade stade = stadeService.getStade(stadeId);
            equipe.setStade(stade);
            equipe = equipeService.addEquipe(equipe);
            model.addAttribute("equipe", equipe);
            return new RedirectView("" + equipe.getId() +"/detail");
        }

        //region Stade
        @GetMapping({ "stade/{id}/detail"})
        public String detailStade(Model model,@PathVariable long id) {
            List<Stade> stadeList = stadeService.getAllStade();
            Stade stade = stadeService.getStade(id);
            model.addAttribute("stade",stade);
            return "stadeDetail";
        }

        @GetMapping({ "stade/liste"})
        public String stadeList(Model model) {
            List<Stade> stadeList = stadeService.getAllStade();
            model.addAttribute("allStades",stadeList);
            return "stadeList";
        }

        @GetMapping({ "stade/newStade"})
        public String newStade(Model model, @ModelAttribute Stade stade) {
            model.addAttribute("stade", stade);
            return "stadeDetail";
        }

        @PostMapping(value = "stade/saveStade")
        public RedirectView saveStade(Model model, @Validated @ModelAttribute Stade stade){
            stade = stadeService.addStade(stade);
            model.addAttribute("stade", stade);
            return new RedirectView("" + stade.getId() +"/detail");
        }
        //endregion


        //region Championnat
        @GetMapping({ "details_championat"})
        public String details_championat(Model model, @RequestParam long idChampionat) {
            Championat championat = championatService.getChampionat(idChampionat);
            List<Equipe> equipes = championat.getEquipes();
            List<Journee> journees = championat.getJournees();
            journees.sort(Comparator.comparing(Journee::getNumero).reversed());
            List<Matches> matches = new ArrayList<>();
//            List<EquipeChampionatStats> equipeChampionatStats = new ArrayList<>();
            for (Journee journee: journees) {
                for (Matches match: journee.getMatches()) {
                    matches.add(match);
                }
            }
            for (Equipe equipe: equipes) {
                Integer totalPoint = 0;
                Integer matchGagnee = 0;
                Integer matchPerdu = 0;
                Integer matchNul = 0;
                Integer maxJournee = 0;
                for (Matches match: matches) {
                    if (equipe == match.getEquipe1()){
                        totalPoint += match.getPointsEquipe1();
                        if (match.getPointsEquipe1() > match.getPointsEquipe2()){
                            matchGagnee ++;
                        }
                        if (match.getPointsEquipe1() < match.getPointsEquipe2()){
                            matchPerdu ++;
                        }
                        if (match.getPointsEquipe1() == match.getPointsEquipe2()){
                            matchNul ++;
                        }
                        if (maxJournee < match.getJournee().getNumero()){
                            maxJournee = match.getJournee().getNumero();
                        }
                    }
                    if (equipe == match.getEquipe2()) {
                        totalPoint += match.getPointsEquipe2();
                        if (match.getPointsEquipe1() > match.getPointsEquipe2()) {
                            matchPerdu++;
                        }
                        if (match.getPointsEquipe1() < match.getPointsEquipe2()) {
                            matchGagnee++;
                        }
                        if (match.getPointsEquipe1() == match.getPointsEquipe2()) {
                            matchNul++;
                        }
                        if (maxJournee < match.getJournee().getNumero()){
                            maxJournee = match.getJournee().getNumero();
                        }
                    }
                }

            }

            model.addAttribute("championat", championat);
            return "indexClassement";
        }

        @PostMapping({ "championnat/{championnatId}/jours"})
        public RedirectView allMatchOfJourneeIdAndChampionnat(Model model, @RequestParam long championnatId, @RequestParam long journeeId) {
            return new RedirectView("/championnat/" + championnatId + "/jours/" + journeeId + "/resultatsListe");
        }

        @GetMapping({"/championnat/{championnatId}/jours/{journeeId}/resultatsListe"})
        public String listResultatsOfChampionnatAndJournee(Model model, @PathVariable long championnatId, @PathVariable long journeeId){
            Championat championat = championatService.getChampionat(championnatId);
            Journee journee = journeeService.getJournee(journeeId);
            HashMap<String,List<Matches>> allMatchOfChampionnat = new HashMap<>();
            List<Journee> journees = championat.getJournees();

            List<Matches> allMatchOfJournee = journee.getMatches();

            allMatchOfChampionnat.put(journee.getNumero().toString(),allMatchOfJournee);

            model.addAttribute("allJournees",journees);
            model.addAttribute("championnat",championat);
            model.addAttribute("allMatchForAllJournees",allMatchOfChampionnat);

            return "liste";
        }

        @GetMapping({"/championnat/{id}/resultatsListe"})
        public String listResultatsOfChampionnat(Model model, @PathVariable long id){
            Equipe equipe = equipeService.getEquipe(id);
            Championat championat = championatService.getChampionat(id);
            HashMap<String,List<Matches>> allMatchOfChampionnat = new HashMap<>();

            List<Journee> journees = championat.getJournees();
            for (Journee journee : journees) {
                List<Matches> allMatchOfJournee = journee.getMatches();

                allMatchOfChampionnat.put(journee.getNumero().toString(),allMatchOfJournee);
            }
            model.addAttribute("allJournees",journees);
            model.addAttribute("championnat",championat);
            model.addAttribute("allMatchForAllJournees",allMatchOfChampionnat);

            return "liste";
        }

        @GetMapping({ "championships"})
        public String championships(Model model) {
            List<Championat> championats = championatService.getAllChampionat();
            model.addAttribute("championats", championats);
            return "indexListeRes";
        }

        @GetMapping({ "championnat/newChampionnat"})
        public String newChampionnat(Model model, @ModelAttribute Championat championat) {
            List<Pays> pays = paysService.getAllPays();
            model.addAttribute("allPays", pays);
            model.addAttribute("championat", championat);
            return "championnatForm";
        }

        @PostMapping(value = "championnat/saveChampionnat")
        public RedirectView saveChampionnat(Model model, @Validated @ModelAttribute Championat championat, @RequestParam long paysId){
            Pays pays = paysService.getPays(paysId);
            championat.setPays(pays);
            championat = championatService.addChampionat(championat);
            model.addAttribute("championat", championat);
            return new RedirectView("/championships");
        }


}
