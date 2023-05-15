package com.project.dp.repositories;

import com.project.dp.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfoliosRepository extends JpaRepository<Portfolio, Integer> {
}
