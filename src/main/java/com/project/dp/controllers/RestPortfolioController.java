package com.project.dp.controllers;
import com.project.dp.models.Person;
import com.project.dp.models.Portfolio;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPortfolioController {

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadFile(@AuthenticationPrincipal UserDetails user) {
        Person person = (Person) user;
        Portfolio portfolio = person.getPortfolio();
        byte[] byteArray = portfolio.getFile();// Ваш массив байт
        String name = portfolio.getPortfolioFileName();
        System.out.println(name);

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=" + name)
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .header("Pragma", "no-cache")
                .body(byteArray);
    }

}

