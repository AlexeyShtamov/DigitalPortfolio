package com.project.dp.services;

import com.project.dp.repositories.PortfoliosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfoliosService {
    @Autowired
    private final PortfoliosRepository portfoliosRepository;

    public PortfoliosService(PortfoliosRepository portfoliosRepository) {
        this.portfoliosRepository = portfoliosRepository;
    }
}
