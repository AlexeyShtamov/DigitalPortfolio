package com.project.dp.controllers;

import com.project.dp.models.Questionnaire;
import com.project.dp.services.QuestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String save(@ModelAttribute("user_id") int user_id, @ModelAttribute("questionnaire")Questionnaire questionnaire){
        questionnairesService.create(questionnaire);
        return "";
    }

}
