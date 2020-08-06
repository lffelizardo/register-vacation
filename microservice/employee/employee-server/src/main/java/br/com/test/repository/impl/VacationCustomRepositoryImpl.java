package br.com.test.repository.impl;

import br.com.test.dto.VacationDto;
import br.com.test.repository.VacationCustomRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VacationCustomRepositoryImpl extends JdbcRepositoryImpl implements VacationCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VacationDto> findByRegistration(String registration) throws IllegalAccessException {

        String sql = "select v.id, v.start_date, v.finish_date from vacation v\n" +
                "join employee e on e.id = v.employee_id\n" +
                "where 1=1\n" +
                "and e.registration like ?";
        return getJdbcTemplate().query(sql, new Object[]{registration}, new BeanPropertyRowMapper<>(VacationDto.class));
    }
}
