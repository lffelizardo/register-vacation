package br.com.test.controller;

import br.com.test.dto.*;
import br.com.test.employeedomain.Employee;
import br.com.test.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployees(){

        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeById", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeById(@RequestParam(value="employeeId", required=true) Integer employeeId){

        return new ResponseEntity<>(employeeService.findById(employeeId), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeByName", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeById(@RequestParam(value="name", required=true) String name){

        return new ResponseEntity<>(employeeService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeByRegistration", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeByRegistration(@RequestParam(value="registration", required=true) String registration){

        return new ResponseEntity<>(employeeService.findByRegistraion(registration), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeesNovacations", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeNoVacation(){

        return new ResponseEntity<>(new VacationListDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewEmployee(@RequestBody EmployeeDto employeeDto){


        return new ResponseEntity<>(employeeService.save(employeeDto), HttpStatus.OK);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

}
