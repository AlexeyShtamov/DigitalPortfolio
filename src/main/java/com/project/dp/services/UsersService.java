package com.project.dp.services;

import com.project.dp.models.Portfolio;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.User;
import com.project.dp.repositories.PortfoliosRepository;
import com.project.dp.repositories.QuestionnairesRepository;
import com.project.dp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;
    private final PortfoliosRepository portfoliosRepository;
    private final QuestionnairesRepository questionnairesRepository;

    public UsersService(UsersRepository usersRepository, PortfoliosRepository portfoliosRepository, QuestionnairesRepository questionnairesRepository) {
        this.usersRepository = usersRepository;
        this.portfoliosRepository = portfoliosRepository;
        this.questionnairesRepository = questionnairesRepository;
    }
    @Transactional
    public void create(User user, Portfolio portfolio, Questionnaire questionnaire){
        portfolio.setUser(user);
        questionnaire.setUser(user);
        user.setPortfolio(portfolio);
        user.setQuestionnaire(questionnaire);
        usersRepository.save(user);
    }
}
