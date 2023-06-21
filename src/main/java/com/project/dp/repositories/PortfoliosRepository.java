package com.project.dp.repositories;

import com.project.dp.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;
import java.util.Optional;

@Repository
public interface PortfoliosRepository extends JpaRepository<Portfolio, Integer> {
    Optional<Portfolio> getPortfolioByPerson_Id(int id);
}
