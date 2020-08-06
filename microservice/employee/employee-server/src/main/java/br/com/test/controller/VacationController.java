package br.com.test.controller;

import br.com.test.dto.VacationDto;
import br.com.test.dto.VacationListDto;
import br.com.test.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/vacation")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @RequestMapping(value = "/createVacation", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewVacation(@RequestBody VacationDto vacationDto){
        return new ResponseEntity<>(vacationService.save(vacationDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/vacationById", method = RequestMethod.GET)
    public ResponseEntity<Object> getVacations(@RequestParam(value="id", required=true) Integer id){

        return new ResponseEntity<>(vacationService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/vacationByRegistration", method = RequestMethod.GET)
    public ResponseEntity<Object> getVacations(@RequestParam(value="registration", required=true) String registration){

        try {
            return new ResponseEntity<>(vacationService.findByRegistraion(registration), HttpStatus.OK);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
