package com.project.dp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/commands")
public class CommandController {
    @GetMapping()
    public String index(){
        return "teams";
    }
}
