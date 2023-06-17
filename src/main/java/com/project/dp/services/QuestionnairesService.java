package com.project.dp.services;

import com.project.dp.models.Questionnaire;
import com.project.dp.repositories.QuestionnairesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnairesService {
    @Autowired
    private final QuestionnairesRepository questionnairesRepository;

    public QuestionnairesService(QuestionnairesRepository questionnairesRepository) {
        this.questionnairesRepository = questionnairesRepository;
    }

    public void create(Questionnaire questionnaire){
        questionnairesRepository.save(questionnaire);
    }
}
