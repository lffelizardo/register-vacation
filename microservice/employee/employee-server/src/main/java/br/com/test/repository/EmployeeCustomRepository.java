package br.com.test.repository;

import br.com.test.dto.EmployeeDto;

import java.util.List;

public interface EmployeeCustomRepository extends JdbcRepository {

    List<EmployeeDto> findEmployeesNeedsVacation() throws IllegalAccessException;
}
