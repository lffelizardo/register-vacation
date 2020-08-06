package br.com.test.controller;

import br.com.test.dto.TeamDto;
import br.com.test.dto.TeamListDto;
import br.com.test.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ResponseEntity<Object> getTeams(@RequestParam(value="name", required=false) String name){

        return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/teamById", method = RequestMethod.GET)
    public ResponseEntity<Object> getTeams(@RequestParam(value="teamId", required=false) Integer teamId){

        return new ResponseEntity<>(teamService.findById(teamId), HttpStatus.OK);
    }

    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewTeam(@RequestBody TeamDto teamDto){
        return new ResponseEntity<>(teamService.save(teamDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateTeam/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTeam(@RequestBody TeamDto teamDto, @PathVariable Integer id){
        return new ResponseEntity<>(teamService.update(teamDto,id), HttpStatus.OK);
    }
}
