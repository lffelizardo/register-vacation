package br.com.test.service.impl;

import br.com.test.dto.EmployeeDto;
import br.com.test.dto.VacationDto;
import br.com.test.employeedomain.Employee;
import br.com.test.employeedomain.Vacation;
import br.com.test.repository.VacationCustomRepository;
import br.com.test.repository.VacationRepository;
import br.com.test.service.VacationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private VacationCustomRepository vacationCustomRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VacationDto> findAll(){
        List<VacationDto> target = new ArrayList<>();
        BeanUtils.copyProperties(vacationRepository.findAll(), target);
        return target;
    }

    @Override
    public void delete(VacationDto dto) {
        //TODO Implement delete method
    }

    @Override
    public VacationDto findById(Integer id){
        Vacation vacation = vacationRepository.findById(id).orElse(new Vacation());
        return getVacationDto(vacation);
    }

    @Override
    public List<VacationDto> findByRegistraion(String registration) throws IllegalAccessException {
        this.vacationCustomRepository.setJdbcTemplate(this.jdbcTemplate);
        return vacationCustomRepository.findByRegistration(registration);
    }

    @Override
    public VacationDto save(VacationDto dto) {
        Vacation vacation = new Vacation();
        BeanUtils.copyProperties(dto, vacation);
        EmployeeDto employee = dto.getEmployee();
        vacation.setEmployee(new Employee(employee.getId(), employee.getName(), employee.getDateBirth(), employee.getStreet(), employee.getNumber(), employee.getComplement(), employee.getNeighborhood(), employee.getCity(), employee.getState(), employee.getContractDate(), employee.getRegistration(), employee.getIamgeUrl(), null, null, employee.getEmail()));
        vacation = vacationRepository.save(vacation);
        dto.setId(vacation.getId());
        return dto;
    }

    private VacationDto getVacationDto(Vacation vacation) {
        if (vacation != null) {
            VacationDto dto = new VacationDto();
            BeanUtils.copyProperties(vacation, dto);
            return dto;
        }
        return null;
    }
}
