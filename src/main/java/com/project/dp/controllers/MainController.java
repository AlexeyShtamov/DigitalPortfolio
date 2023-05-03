package com.project.dp.controllers;

import com.project.dp.services.EmailsService;
import com.project.dp.models.Emaill;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mainpage")
public class MainController {

    @GetMapping()
    public String mainPage(Model model){
        model.addAttribute("email", new Emaill());
        return "index";
    }

    @GetMapping("/learn-more")
    public String learnMore(Model model){
        model.addAttribute("email", new Emaill());
        return "learn-more";
    }

}
