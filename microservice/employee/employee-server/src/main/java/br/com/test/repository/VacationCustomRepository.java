package br.com.test.repository;

import br.com.test.dto.VacationDto;

import java.util.List;

public interface VacationCustomRepository extends JdbcRepository {

    List<VacationDto> findByRegistration(String registration) throws IllegalAccessException;
}
