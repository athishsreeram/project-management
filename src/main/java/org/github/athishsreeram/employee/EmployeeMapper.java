package org.github.athishsreeram.employee;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDTO projectToProjectDto(Employee project);

    List<EmployeeDTO> projectsToProjectsDto(List<Employee> project);

    @InheritInverseConfiguration
    Employee projectDTOToProjectDomain(EmployeeDTO project);

}