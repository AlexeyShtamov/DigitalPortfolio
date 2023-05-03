package com.project.dp.util;

import com.project.dp.models.Emaill;
import com.project.dp.services.EmailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class EmailValidator implements Validator {

    private final EmailsService emailsService;
    @Autowired
    public EmailValidator(EmailsService emailsService) {
        this.emailsService = emailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Emaill.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Emaill emaill = (Emaill) target;
        Emaill foundEmail = emailsService.findByName(emaill);
        System.out.println(foundEmail);
        if(foundEmail != null){
            errors.rejectValue("email", "", "Email уже отправлен.");
        }
    }
}
