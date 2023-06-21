package com.project.dp.repositories;

import com.project.dp.models.PortfolioImage;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.TeamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamInfoRepository extends JpaRepository<TeamInfo, Integer> {
    Optional<TeamInfo> getByPerson_Id(int id);
}
