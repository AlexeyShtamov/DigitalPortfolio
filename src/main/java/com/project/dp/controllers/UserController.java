package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Portfolio;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.User;
import com.project.dp.services.PortfoliosService;
import com.project.dp.services.QuestionnairesService;
import com.project.dp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UsersService usersService;
    private final PortfoliosService portfoliosService;

    private final QuestionnairesService questionnairesService;
    @Autowired
    public UserController(UsersService usersService, PortfoliosService portfoliosService, QuestionnairesService questionnairesService) {
        this.usersService = usersService;
        this.portfoliosService = portfoliosService;
        this.questionnairesService = questionnairesService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("email", new Emaill());
        model.addAttribute("user", new User());
        model.addAttribute("portfolio", new Portfolio()); //будет в другом контроллере
        model.addAttribute("questionnaire", new Questionnaire()); //будет в другом контроллере
        return "profile";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         @ModelAttribute("portfolio") Portfolio portfolio, //будет в другом контроллере
                         @ModelAttribute("questionnaire") Questionnaire questionnaire) throws IOException {
        usersService.create(user, portfolio, questionnaire);

        return "redirect:/mainpage";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("email", new Emaill());
        return "login";
    }
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("email", new Emaill());
        return "registration";
    }
}