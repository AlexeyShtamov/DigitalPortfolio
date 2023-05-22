package com.project.dp.controllers;

import com.project.dp.models.PortfolioImage;
import com.project.dp.models.PortfolioImage;
import com.project.dp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;


@RestController
public class ImageController {
    private final ImageService imageService;
    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image/{id}")
    private ResponseEntity<?> getImageById(@PathVariable int id){
        PortfolioImage image = imageService.getById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
