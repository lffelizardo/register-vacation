package br.com.test.dto;

import java.io.Serializable;
import java.util.List;

public class TeamListDto implements Serializable {

    private List<TeamDto> teams;

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
}
