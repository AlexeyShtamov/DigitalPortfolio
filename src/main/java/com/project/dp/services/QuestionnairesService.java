package com.project.dp.services;

import com.project.dp.models.Person;
import com.project.dp.models.Questionnaire;
import com.project.dp.repositories.QuestionnairesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionnairesService {
    private final QuestionnairesRepository questionnairesRepository;
    @Autowired
    public QuestionnairesService(QuestionnairesRepository questionnairesRepository) {
        this.questionnairesRepository = questionnairesRepository;
    }

    public void save(int id, Questionnaire questionnaire, Person person){
        questionnaire.setId(id);
        questionnaire.setPerson(person);
        person.setQuestionnaire(questionnaire);
        questionnairesRepository.save(questionnaire);
    }

    public void save(Questionnaire questionnaire, Person person){
        questionnaire.setPerson(person);
        questionnairesRepository.save(questionnaire);
    }

    public Questionnaire getByPersonId(int id){
        Optional<Questionnaire> optional = questionnairesRepository.getByPerson_Id(id);
        return optional.orElseGet(Questionnaire::new);
    }
}
