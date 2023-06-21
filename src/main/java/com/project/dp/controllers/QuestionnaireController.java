package com.project.dp.controllers;

import com.project.dp.models.Person;
import com.project.dp.models.Questionnaire;
import com.project.dp.services.QuestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    private final QuestionnairesService questionnairesService;
    @Autowired
    public QuestionnaireController(QuestionnairesService questionnairesService) {
        this.questionnairesService = questionnairesService;
    }


    @PostMapping()
    public String save(@AuthenticationPrincipal UserDetails user,
                       @ModelAttribute("questionnaire") Questionnaire changedQuestionnaire){
        Person person = (Person) user;
        if(person.getQuestionnaire() != null){
            Questionnaire questionnaire = person.getQuestionnaire();
            questionnairesService.save(questionnaire.getId(), changedQuestionnaire, person);
        }else
            questionnairesService.save(changedQuestionnaire, person);



        return "redirect:/" + ((Person) user).getTeam();
    }

}
