package br.com.test.employeedomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="team")
public class Team implements Serializable {

    @Id
    @Column(name="id", nullable=false, length=11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name", nullable=true, length=300)
    private String name;

    @OneToMany(mappedBy="team", targetEntity=Employee.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Employee> employees;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
