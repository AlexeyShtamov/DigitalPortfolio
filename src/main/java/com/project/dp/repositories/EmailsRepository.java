package com.project.dp.repositories;

import com.project.dp.models.Emaill;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsRepository extends JpaRepository<Emaill, Integer> {
    Emaill findByEmailName(String emailName);
}
