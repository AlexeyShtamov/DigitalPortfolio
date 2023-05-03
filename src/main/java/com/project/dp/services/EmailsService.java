package com.project.dp.services;

import com.project.dp.models.Emaill;
import com.project.dp.repositories.EmailsRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmailsService {

    private final EmailsRepository emailsRepository;
    @Autowired
    public EmailsService(EmailsRepository emailsRepository) {
        this.emailsRepository = emailsRepository;
    }

    @Transactional
    public void save(Emaill emaill){
        emailsRepository.save(emaill);
    }

    public Emaill findByName(Emaill emaill){
        return emailsRepository.findByEmailName(emaill.getEmailName());
    }
}
