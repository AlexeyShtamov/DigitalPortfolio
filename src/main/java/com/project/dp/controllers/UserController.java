package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Portfolio;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.User;
import com.project.dp.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String show(Model model){
        model.addAttribute("email", new Emaill());
        model.addAttribute("user", new User());
        model.addAttribute("portfolio", new Portfolio());
        model.addAttribute("questionnaire", new Questionnaire());
        return "profile";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         @ModelAttribute("portfolio") Portfolio portfolio,
                         @ModelAttribute("questionnaire") Questionnaire questionnaire){
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