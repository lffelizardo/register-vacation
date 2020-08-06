package br.com.test.service;

import br.com.test.dto.VacationDto;

import java.util.List;

public interface VacationService {

    List<VacationDto> findAll();

    VacationDto findById(Integer id);

    void delete(VacationDto dto);

    List<VacationDto> findByRegistraion(String registration) throws IllegalAccessException;

    VacationDto save(VacationDto dto);
}
