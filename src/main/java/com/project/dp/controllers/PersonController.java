package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Portfolio;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.Person;
import com.project.dp.services.PortfoliosService;
import com.project.dp.services.QuestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class PersonController {
    private final PortfoliosService portfoliosService;

    private final QuestionnairesService questionnairesService;
    @Autowired
    public PersonController( PortfoliosService portfoliosService, QuestionnairesService questionnairesService) {
        this.portfoliosService = portfoliosService;
        this.questionnairesService = questionnairesService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("email", new Emaill());
        model.addAttribute("user", new Person());
        model.addAttribute("portfolio", new Portfolio());
        model.addAttribute("questionnaire", new Questionnaire());
        return "profile";
    }
}