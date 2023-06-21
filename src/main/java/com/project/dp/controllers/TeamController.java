package com.project.dp.controllers;

import com.project.dp.models.Emaill;
import com.project.dp.models.Person;
import com.project.dp.models.TeamInfo;
import com.project.dp.services.PersonDetailsService;
import com.project.dp.services.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/1")
public class TeamController {

    private final TeamInfoService teamInfoService;
    private final PersonDetailsService personDetailsService;
    @Autowired
    public TeamController(TeamInfoService teamInfoService, PersonDetailsService personDetailsService) {
        this.teamInfoService = teamInfoService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping()
    public String team(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("person", person);
        model.addAttribute("teamInfo", teamInfoService.getByTeamId(person.getId()));
        return "profile-teams";
    }

    @GetMapping("/allTeams")
    public String allTeams(Model model, @AuthenticationPrincipal UserDetails user){
        Person person = (Person) user;
        model.addAttribute("person", person);
        model.addAttribute("teams", personDetailsService.getAllTeams());
        model.addAttribute("email", new Emaill());
        return "teams";
    }

    @GetMapping("/allTeams/{id}")
    public String teamInfo(Model model, @AuthenticationPrincipal UserDetails user,
                           @PathVariable("id") int id){
        Person person = (Person) user;
        Person team = personDetailsService.findById(id);
        model.addAttribute("person", person);
        model.addAttribute("teaminfo", team.getTeamInfo());
        model.addAttribute("team", team);
        model.addAttribute("email", new Emaill());
        return "add-view";
    }

}
