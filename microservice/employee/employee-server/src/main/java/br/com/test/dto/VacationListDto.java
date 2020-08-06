package br.com.test.dto;

import br.com.test.employeedomain.Vacation;

import java.io.Serializable;
import java.util.List;

public class VacationListDto implements Serializable {

    private List<VacationDto> vacations;

    public VacationListDto(){}

    public VacationListDto(List<VacationDto> vacationDtoList) {
        this.vacations = vacationDtoList;
    }

    public List<VacationDto> getVacations() {
        return vacations;
    }

    public void setVacations(List<VacationDto> vacations) {
        this.vacations = vacations;
    }
}
