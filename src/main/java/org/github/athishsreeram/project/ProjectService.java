package org.github.athishsreeram.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {


    private final ProjectRespository projectRespository;
    private final ProjectMapper projectMapper;


    public List<ProjectDTO> findAll() {
        List<Project> lstPjt =  projectRespository.findAll();

        if(!lstPjt.isEmpty()) {
            return projectMapper.projectsToProjectsDto(lstPjt);
        }

        return new ArrayList<ProjectDTO>();

    }

    public Optional<ProjectDTO> findById(String id) {

        Optional<Project> pjt = projectRespository.findById(id);

        if(pjt.isPresent()) {
            return Optional.of(projectMapper.projectToProjectDto(pjt.get()));
        }

        return Optional.empty();
    }

    public ProjectDTO save(ProjectDTO project) {

        Project pjt = projectMapper.projectDTOToProjectDomain(project);

        pjt = projectRespository.save(pjt);

        return projectMapper.projectToProjectDto(pjt);

    }

    public void deleteById(String id) {
        projectRespository.deleteById(id);
    }
}