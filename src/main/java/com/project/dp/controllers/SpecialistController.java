package com.project.dp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/specialists")
public class SpecialistController {
    @GetMapping()
    public String index(){
        return "specialists";
    }

}
