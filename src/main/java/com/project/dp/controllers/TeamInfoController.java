package com.project.dp.controllers;

import com.project.dp.models.Person;
import com.project.dp.models.TeamInfo;
import com.project.dp.services.PortfoliosService;
import com.project.dp.services.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/teaminfo")
public class TeamInfoController {
    private final TeamInfoService teamInfoService;
    private final PortfoliosService portfoliosService;
    @Autowired
    public TeamInfoController(TeamInfoService teamInfoService, PortfoliosService portfoliosService) {
        this.teamInfoService = teamInfoService;
        this.portfoliosService = portfoliosService;
    }

    @PostMapping("/save")
    public String save(@AuthenticationPrincipal UserDetails user,
                       @ModelAttribute("teamInfo") TeamInfo teamInfo,
                       @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        Person person = (Person) user;
        int id = ((Person) user).getId();
        if(imageFile.getBytes().length > 0){
            teamInfo.setTeamFile(imageFile.getBytes());
            teamInfo.setTeamFileName(imageFile.getOriginalFilename());
        }else{
            if(person.getTeamInfo() != null){
                teamInfo.setTeamFileName(person.getTeamInfo().getTeamFileName());
                teamInfo.setTeamFile(person.getTeamInfo().getTeamFile());
            }
        }
        portfoliosService.addImage(imageFile);
        teamInfoService.save(person, teamInfo);
        return "redirect:/" + person.getTeam();
    }
}
