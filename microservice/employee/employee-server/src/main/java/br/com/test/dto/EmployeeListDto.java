package br.com.test.dto;

import java.io.Serializable;
import java.util.List;

public class EmployeeListDto implements Serializable {

    private List<EmployeeDto> employees;

    public EmployeeListDto(){}

    public EmployeeListDto(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
