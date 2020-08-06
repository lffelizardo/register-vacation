package br.com.test.repository;

import br.com.test.dto.VacationDto;
import br.com.test.employeedomain.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends BaseRepository<Vacation, Integer> {

    List<Vacation> findAll();

//    Vacation findByRegistration(String registration);
}
