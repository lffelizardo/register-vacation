package br.com.test.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public interface JdbcRepository {

    JdbcTemplate getJdbcTemplate() throws IllegalAccessException;
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
