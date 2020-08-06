package br.com.test.dto;

import br.com.test.employeedomain.Team;
import br.com.test.employeedomain.Vacation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeDto implements Serializable {

    private Integer id;
    private String name;
    private Date dateBirth;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String registration;
    private String iamgeUrl;
    private TeamDto team;
    private Integer teamId;
    private Date contractDate;
    private String email;
    private List<VacationDto> vacations;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, Date dateBirth, String street, String number, String complement, String neighborhood, String city, String state, String registration, String iamgeUrl, TeamDto team, Integer teamId, Date contractDate, List<VacationDto> vacations, String email) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.registration = registration;
        this.iamgeUrl = iamgeUrl;
        this.team = team;
        this.teamId = teamId;
        this.contractDate = contractDate;
        this.vacations = vacations;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getIamgeUrl() {
        return iamgeUrl;
    }

    public void setIamgeUrl(String iamgeUrl) {
        this.iamgeUrl = iamgeUrl;
    }

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public List<VacationDto> getVacations() {
        return vacations;
    }

    public void setVacations(List<VacationDto> vacations) {
        this.vacations = vacations;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
