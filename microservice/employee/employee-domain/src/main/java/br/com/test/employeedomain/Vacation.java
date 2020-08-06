package br.com.test.employeedomain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "vacation")
public class Vacation implements Serializable {

    @Id
    @Column(name="id", nullable=false, length=11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="start_date", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name="finish_date", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employees) {
        this.employee = employees;
    }
}
