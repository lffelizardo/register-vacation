package br.com.test.repository;

import br.com.test.employeedomain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends BaseRepository<Team, Integer> {

}
