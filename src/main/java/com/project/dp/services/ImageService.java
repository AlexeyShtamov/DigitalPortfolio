package com.project.dp.services;

import com.project.dp.models.PortfolioImage;
import com.project.dp.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImagesRepository imagesRepository;
    @Autowired
    public ImageService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public PortfolioImage getById(int id){
        return imagesRepository.getById(id);
    }
}
