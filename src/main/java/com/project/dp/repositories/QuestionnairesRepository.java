package com.project.dp.repositories;

import com.project.dp.models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnairesRepository extends JpaRepository<Questionnaire, Integer> {
}
