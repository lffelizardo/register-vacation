package br.com.test.service.impl;

import br.com.test.dto.EmployeeDto;
import br.com.test.employeedomain.Employee;
import br.com.test.employeedomain.Team;
import br.com.test.repository.EmployeeCustomRepository;
import br.com.test.repository.EmployeeRepository;
import br.com.test.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCustomRepository employeeCustomRepository;

    @Override
    public List<EmployeeDto> findAll(){
        List<EmployeeDto> target = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList != null && !employeeList.isEmpty()){
            target = employeeList.stream()
                    .map(e -> new EmployeeDto(e.getId(),e.getName(),e.getDateBirth(), e.getStreet(), e.getNumber(), e.getComplement(), e.getNeighborhood(), e.getCity(),
                            e.getState(), e.getRegistration(), e.getIamgeUrl(), null, e.getTeam().getId(), e.getContractDate(), null, e.getEmail()))
                    .collect(Collectors.toList());
        }
        return target;
    }

    @Override
    public EmployeeDto findById(Integer id){
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        return getEmployeeDto(employee);
    }

    @Override
    public EmployeeDto findByRegistraion(String registration){
        Employee employee = employeeRepository.findByRegistration(registration);
       return getEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> findEmployeesNeedsVacation(){

        employeeCustomRepository.setJdbcTemplate(this.jdbcTemplate);
        try {
            List<EmployeeDto> employeeDtoList = employeeCustomRepository.findEmployeesNeedsVacation();
            if(employeeDtoList != null && !employeeDtoList.isEmpty()){
                //TODO Implement a mechanism to find employees eligible to the vacation
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeDto save(EmployeeDto dto){
        dto.setRegistration(UUID.randomUUID().toString());
        Employee employee = new Employee();
        BeanUtils.copyProperties(dto, employee);
        Team team = new Team();
        BeanUtils.copyProperties(dto.getTeam(), team);
        employee.setTeam(team);
        employeeRepository.save(employee);

        dto.setId(employee.getId());
        return dto;
    }

    @Override
    public List<EmployeeDto> findByName(String name) {
        List<Employee> employeeList = employeeRepository.findByNameContaining(name);
        List<EmployeeDto> dtoList = new ArrayList<>();
        if(employeeList != null && !employeeList.isEmpty()){
            dtoList = employeeList.stream().map(e -> new EmployeeDto(e.getId(),e.getName(),e.getDateBirth(), e.getStreet(), e.getNumber(), e.getComplement(), e.getNeighborhood(), e.getCity(),
                    e.getState(), e.getRegistration(), e.getIamgeUrl(), null, e.getTeam().getId(), e.getContractDate(), null, e.getEmail()))
                    .collect(Collectors.toList());
        }
        return dtoList;
    }

    private EmployeeDto getEmployeeDto(Employee employee) {
        if (employee != null) {
            EmployeeDto dto = new EmployeeDto();
            BeanUtils.copyProperties(employee, dto);
            return dto;
        }
        return null;
    }
}
