package br.com.test.employeedomain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="id", nullable=false, length=11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name", nullable=true, length=300)
    private String name;

    @Column(name="date_of_birth", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name="street", nullable=true, length=300)
    private String street;

    @Column(name="number", nullable=true, length=300)
    private String number;

    @Column(name="complement", nullable=true, length=300)
    private String complement;

    @Column(name="neighborhood", nullable=true, length=300)
    private String neighborhood;

    @Column(name="city", nullable=true, length=300)
    private String city;

    @Column(name="state", nullable=true, length=300)
    private String state;

    @Column(name="contractDate", nullable=false, length=300)
    @Temporal(TemporalType.DATE)
    private Date contractDate;

    @Column(name="registration", nullable=true, length=300, unique = true)
    private String registration;

    @Column(name="image_url", nullable=true, length=300)
    private String iamgeUrl;

    @ManyToOne(targetEntity=Team.class, fetch=FetchType.LAZY)
    @JoinColumn(name="team_id", nullable=false)
    private Team team;

    @Column(name="email", nullable=true, length=300)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Vacation> vacations;

    public Employee(){}

    public Employee(Integer id, String name, Date dateBirth, String street, String number, String complement, String neighborhood, String city, String state, Date contractDate, String registration, String iamgeUrl, Team team, List<Vacation> vacations, String email) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.contractDate = contractDate;
        this.registration = registration;
        this.iamgeUrl = iamgeUrl;
        this.team = team;
        this.vacations = vacations;
        this.email = email;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
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

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getIamgeUrl() {
        return iamgeUrl;
    }

    public void setIamgeUrl(String iamgeUrl) {
        this.iamgeUrl = iamgeUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
