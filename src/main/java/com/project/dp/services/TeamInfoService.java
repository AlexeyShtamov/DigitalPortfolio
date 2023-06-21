package com.project.dp.services;

import com.project.dp.models.Person;
import com.project.dp.models.Questionnaire;
import com.project.dp.models.TeamInfo;
import com.project.dp.repositories.TeamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamInfoService {
    private final TeamInfoRepository teamInfoRepository;
    @Autowired
    public TeamInfoService(TeamInfoRepository teamInfoRepository) {
        this.teamInfoRepository = teamInfoRepository;
    }

    public void save(Person person, TeamInfo teamInfo){
        if(person.getTeamInfo() != null)
            teamInfo.setId(person.getTeamInfo().getId());
        teamInfo.setPerson(person);
        teamInfoRepository.save(teamInfo);
    }

    public TeamInfo getByTeamId(int id){
        Optional<TeamInfo> optional = teamInfoRepository.getByPerson_Id(id);
        return optional.orElseGet(TeamInfo::new);
    }

    public List<TeamInfo> getAll(){
        return teamInfoRepository.findAll();
    }

    public TeamInfo getById(int id){
        return teamInfoRepository.findById(id).get();
    }
}
