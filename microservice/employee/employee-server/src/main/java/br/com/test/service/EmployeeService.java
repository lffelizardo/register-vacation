package br.com.test.service;

import br.com.test.dto.EmployeeDto;
import br.com.test.employeedomain.Employee;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();

    EmployeeDto findById(Integer id);

    EmployeeDto findByRegistraion(String registration);

    List<EmployeeDto> findEmployeesNeedsVacation();

    EmployeeDto save(EmployeeDto dto);

    List<EmployeeDto> findByName(String name);
}
