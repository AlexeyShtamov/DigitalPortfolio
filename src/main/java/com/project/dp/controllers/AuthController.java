package com.project.dp.controllers;

import com.project.dp.models.Person;
import com.project.dp.services.RegistrationService;
import com.project.dp.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "registration";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors())
            return "registration";
        person.setUsername("User_" + ((int)(Math.random()*312)));
        registrationService.register(person);
        return "redirect:/login";
    }
}
