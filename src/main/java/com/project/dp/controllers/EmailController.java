package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.services.EmailsService;
import com.project.dp.util.EmailValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailsService emailsService;
    private final EmailValidator emailValidator;

    @Autowired
    public EmailController(EmailsService emailsService, EmailValidator emailValidator) {
        this.emailsService = emailsService;
        this.emailValidator = emailValidator;
    }
    @PostMapping()
    public String saveEmail(@ModelAttribute("Email") @Valid Emaill emaill,
                            BindingResult bindingResult, Model model){
        emailValidator.validate(emaill, bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("email", new Emaill());
            return "index";
        }
        emailsService.save(emaill);
        return "redirect:/mainpage";
    }
}
