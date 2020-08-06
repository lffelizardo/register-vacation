package br.com.test.repository.impl;

import br.com.test.dto.EmployeeDto;
import br.com.test.dto.VacationDto;
import br.com.test.repository.EmployeeCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeCustomRepositoryImpl extends JdbcRepositoryImpl implements EmployeeCustomRepository {

    @Override
    public List<EmployeeDto> findEmployeesNeedsVacation() throws IllegalAccessException {

        String sql = "select e.*, v.* from employee e\n" +
                "join employee_vacation ev on e.id = ev.employee_id\n" +
                "left join vacation v on v.id = ev.vacation_id\n" +
                "where 1=1\n" +
                "and e.contract_date < CURDATE()\n" +
                "and TIMESTAMPDIFF(YEAR, e.contract_date, CURDATE())";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(EmployeeDto.class));
    }
}
