package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Person;
import com.project.dp.services.PersonDetailsService;
import com.project.dp.services.PortfoliosService;
import com.project.dp.services.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/mainpage")
public class MainController {
    private final PortfoliosService portfoliosService;

    private final PersonDetailsService personDetailsService;
    @Autowired
    public MainController(PortfoliosService portfoliosService, PersonDetailsService personDetailsService) {
        this.portfoliosService = portfoliosService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping()
    public String index(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("portfolios", portfoliosService.getPortfolios());
        model.addAttribute("teams", personDetailsService.getAllTeams());
        model.addAttribute("people", personDetailsService.findAll());
        model.addAttribute("person", person);
        model.addAttribute("email", new Emaill());
        return "index";
    }

    @GetMapping("/learn-more")
    public String learnMore(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("person", person);
        model.addAttribute("email", new Emaill());
        model.addAttribute("teams", personDetailsService.getAllTeams());
        return "learn-more";
    }

}
