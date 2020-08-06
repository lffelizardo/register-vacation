package br.com.test.repository;

import br.com.test.employeedomain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Integer> {

    Employee findByRegistration(String registration);

    List<Employee> findByNameContaining(String name);
}
