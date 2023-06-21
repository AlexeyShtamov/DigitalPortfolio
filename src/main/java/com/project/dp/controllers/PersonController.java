package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Portfolio;
import com.project.dp.models.Person;
import com.project.dp.services.PersonDetailsService;
import com.project.dp.services.PortfoliosService;
import com.project.dp.services.QuestionnairesService;
import com.project.dp.services.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/0")
public class PersonController {
    private final PersonDetailsService personDetailsService;
    private final QuestionnairesService questionnairesService;
    private final PortfoliosService portfoliosService;
    @Autowired
    public PersonController(PersonDetailsService personDetailsService, QuestionnairesService questionnairesService, PortfoliosService portfoliosService) {
        this.personDetailsService = personDetailsService;
        this.questionnairesService = questionnairesService;
        this.portfoliosService = portfoliosService;
    }

    @GetMapping()
    public String userInfo(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("person", person);
        model.addAttribute("portfolio", portfoliosService.getPortfolioByPersonId(person.getId()));
        model.addAttribute("questionnaire", questionnairesService.getByPersonId(person.getId()));
        return "profile";
    }
    @GetMapping("/allUsers")
    public String allUsers(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("person", person);
        model.addAttribute("portfolios", portfoliosService.getPortfolios());
        model.addAttribute("email", new Emaill());
        return "specialists";
    }

    @PostMapping("/face")
    public String changeAvatar(@RequestParam("faceImage") MultipartFile file, @AuthenticationPrincipal UserDetails user) throws IOException {
        Person person = (Person) user;
        if(file.getBytes().length != 0){
            personDetailsService.addImage(file);
            personDetailsService.updateFace(person, file);
        }
        return "redirect:/" + person.getTeam();
    }
    @PostMapping("/update")
    public String save(@ModelAttribute("person") Person person, @AuthenticationPrincipal UserDetails user){
        int id = ((Person) user).getId();
        int team = ((Person) user).getTeam();
        if(person.getPassword().length() < 6)
            person.setPassword(((Person) user).getPassword());
        personDetailsService.updatePerson(id, team, person);
        return "redirect:/" + person.getTeam();
    }
}