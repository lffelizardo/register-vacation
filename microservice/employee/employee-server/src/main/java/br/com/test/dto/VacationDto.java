package br.com.test.dto;

import br.com.test.employeedomain.Employee;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VacationDto implements Serializable {

    private Integer id;

    private Date startDate;

    private Date finishDate;

    private EmployeeDto employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployees(EmployeeDto employees) {
        this.employee = employees;
    }
}
