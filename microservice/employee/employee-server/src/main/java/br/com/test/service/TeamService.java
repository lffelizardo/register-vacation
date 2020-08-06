package br.com.test.service;

import br.com.test.dto.TeamDto;
import br.com.test.employeedomain.Team;

import java.util.List;

public interface TeamService {

    List<TeamDto> findAll();

    TeamDto save(TeamDto dto);

    TeamDto update(TeamDto dto, Integer id);

    TeamDto findById(Integer id);
}
