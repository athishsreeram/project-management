package org.github.athishsreeram.project;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);


    ProjectDTO projectToProjectDto(Project project);

    List<ProjectDTO> projectsToProjectsDto(List<Project> project);

    @InheritInverseConfiguration
    Project projectDTOToProjectDomain(ProjectDTO project);

}