package com.project.dp.services;

import com.project.dp.models.PortfolioImage;
import com.project.dp.models.Portfolio;
import com.project.dp.models.PortfolioImage;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.User;
import com.project.dp.repositories.PortfoliosRepository;
import com.project.dp.repositories.QuestionnairesRepository;
import com.project.dp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public void create(User user, Portfolio portfolio, Questionnaire questionnaire) throws IOException {
//        PortfolioImage portfolioImage;
//        if(imageFile.getSize() != 0){
//            portfolioImage = toImageEntity(imageFile);
//             portfolio.setImage(portfolioImage);
//        }
        portfolio.setUser(user);
        questionnaire.setUser(user);
        user.setPortfolio(portfolio);
        user.setQuestionnaire(questionnaire);
        usersRepository.save(user);
    }


    private PortfolioImage toImageEntity(MultipartFile file) throws IOException {
        PortfolioImage image = new PortfolioImage();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
