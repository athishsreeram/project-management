package org.github.athishsreeram.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRespository employeeRespository;
    private final EmployeeMapper employeeMapper;


    public List<EmployeeDTO> findAll() {
        List<Employee> lstPjt =  employeeRespository.findAll();

        if(!lstPjt.isEmpty()) {
            return employeeMapper.projectsToProjectsDto(lstPjt);
        }

        return new ArrayList<EmployeeDTO>();

    }

    public Optional<EmployeeDTO> findById(Long id) {

        Optional<Employee> pjt = employeeRespository.findById(id);

        if(pjt.isPresent()) {
            return Optional.of(employeeMapper.projectToProjectDto(pjt.get()));
        }

        return Optional.empty();
    }

    public EmployeeDTO save(EmployeeDTO project) {

        Employee pjt = employeeMapper.projectDTOToProjectDomain(project);

        pjt = employeeRespository.save(pjt);

        return employeeMapper.projectToProjectDto(pjt);

    }

    public void deleteById(Long id) {
        employeeRespository.deleteById(id);
    }
}