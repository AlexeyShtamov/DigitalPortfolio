package com.project.dp.services;

import com.project.dp.repositories.PortfoliosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {
    private final PortfoliosRepository portfoliosRepository;

    @Autowired
    public ImagesService(PortfoliosRepository portfoliosRepository) {
        this.portfoliosRepository = portfoliosRepository;
    }

    public byte[] getImageByPortfolioId(int id){
        return portfoliosRepository.findById(id).get().getImage();
    }
}
