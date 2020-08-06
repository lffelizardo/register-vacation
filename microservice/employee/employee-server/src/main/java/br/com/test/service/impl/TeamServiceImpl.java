package br.com.test.service.impl;

import br.com.test.dto.TeamDto;
import br.com.test.employeedomain.Team;
import br.com.test.repository.TeamRepository;
import br.com.test.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDto> findAll(){
        List<TeamDto> teams = new ArrayList<>();

        List<Team> teamList = teamRepository.findAll();
        if(teamList != null && !teamList.isEmpty()){
            teams = teamList.stream().map(t -> new TeamDto(t.getId(),t.getName())).collect(Collectors.toList());
        }
        return teams;
    }

    @Override
    public TeamDto save(TeamDto dto){

        Team team = new Team();
        BeanUtils.copyProperties(dto, team);
        teamRepository.save(team);

        dto.setId(team.getId());
        return dto;
    }

    @Override
    public TeamDto update(TeamDto dto, Integer id){

        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(dto.getName());
                    teamRepository.save(team);
                    BeanUtils.copyProperties(dto, team);
                    return dto;
                }).orElseGet(() -> {
                    return null;
                });
    }

    @Override
    public TeamDto findById(Integer id) {

        TeamDto dto = new TeamDto();
        BeanUtils.copyProperties(teamRepository.findById(id).orElse(new Team()), dto);
        return dto;
    }
}
