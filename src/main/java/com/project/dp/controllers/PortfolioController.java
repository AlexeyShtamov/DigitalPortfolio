package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Person;
import com.project.dp.models.Portfolio;
import com.project.dp.services.PortfoliosService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.modelmbean.ModelMBean;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfoliosService portfoliosService;
    @Autowired
    public PortfolioController(PortfoliosService portfoliosService) {
        this.portfoliosService = portfoliosService;
    }

    @GetMapping("/all")
    public String index(Model model, @AuthenticationPrincipal UserDetails user){
        model.addAttribute("email", new Emaill());
        model.addAttribute("person", ((Person) user));
        model.addAttribute("portfolios", portfoliosService.getPortfolios());
        return "specialists";
    }

    @GetMapping("/all/{id}")
    public String show(Model model, @PathVariable("id") int id, @AuthenticationPrincipal UserDetails user){
        Portfolio portfolio = portfoliosService.getPortfolio(id);
        model.addAttribute("person", ((Person) user));
        model.addAttribute("questionnaire", ((Person) user).getQuestionnaire());
        model.addAttribute("portfolio", portfolio);
        return "portfolio-view";
    }

    @PostMapping()
    public String save(@ModelAttribute("Portfolio") Portfolio portfolio,
                       @AuthenticationPrincipal UserDetails user,
                       @RequestParam("dataFile") MultipartFile file,
                       @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        Person person = (Person) user;
        if(file.getBytes().length == 0 && person.getPortfolio() != null){
            portfolio.setFile(person.getPortfolio().getFile());
            portfolio.setPortfolioFileName(person.getPortfolio().getPortfolioFileName());
        }else{
            portfolio.setFile(file.getBytes());
            portfolio.setPortfolioFileName(file.getOriginalFilename());
        }
        if(imageFile.getBytes().length == 0 && person.getPortfolio() != null)
            portfolio.setFileName(person.getPortfolio().getFileName());
        else
            portfolio.setFileName(imageFile.getOriginalFilename());

        portfoliosService.addImage(imageFile);

        if(person.getPortfolio() != null)
            portfoliosService.save(person.getPortfolio().getId(), portfolio, person);
        else
            portfoliosService.save(portfolio, person);
        return "redirect:/" + person.getTeam();
    }



    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response, @AuthenticationPrincipal UserDetails user) {
        Person person = (Person) user;
        try {
            byte[] byteArray = person.getPortfolio().getFile();

            response.setHeader("Content-Disposition", "attachment; filename=filename.ext");
            response.setContentType("application/octet-stream"); // или другой подходящий MIME-тип

            try (OutputStream outputStream = response.getOutputStream()) {
                outputStream.write(byteArray);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
