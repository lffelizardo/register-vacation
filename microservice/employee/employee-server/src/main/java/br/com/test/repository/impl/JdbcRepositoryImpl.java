package br.com.test.repository.impl;

import br.com.test.repository.JdbcRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRepositoryImpl implements JdbcRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public JdbcTemplate getJdbcTemplate() throws IllegalAccessException {
        if (jdbcTemplate == null) {
            throw new IllegalAccessException("You must set the jdbcTemplate before execute operations");
        }
        return jdbcTemplate;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
