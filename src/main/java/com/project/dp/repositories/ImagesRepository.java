package com.project.dp.repositories;

import com.project.dp.models.PortfolioImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<PortfolioImage, Integer> {
}
