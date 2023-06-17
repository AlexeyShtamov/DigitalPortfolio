package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/teams")
public class TeamController {
    @GetMapping()
    public String index(Model model){
        model.addAttribute("email", new Emaill());
        model.addAttribute("rightPage", "commands");
        return "specialists";
    }
    @GetMapping("/red")
    public String show(){
        return "profile-teams";
    }
}
