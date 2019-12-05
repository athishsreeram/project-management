package org.github.athishsreeram.project;

import lombok.RequiredArgsConstructor;
import org.github.athishsreeram.exception.ResourceNotFoundException;
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

    public ProjectDTO save(ProjectDTO project) throws ResourceNotFoundException {

        Project pjt = projectMapper.projectDTOToProjectDomain(project);

        if(project.getParent_project_id() != null) {
            Optional<Project> pjtPr = projectRespository.findById(project.getParent_project_id());

            if (pjtPr.isPresent()) {
                pjt.setParent(pjtPr.get());
            }else{
                throw new ResourceNotFoundException("Parent Project id not found");
            }
        }

        pjt = projectRespository.save(pjt);

        return projectMapper.projectToProjectDto(pjt);

    }

    public void deleteById(String id) throws ResourceNotFoundException {

        Optional<Project> pjtPr = projectRespository.findById(id);

        if (pjtPr.isPresent()) {
            projectRespository.delete(pjtPr.get());
        }else{
            throw new ResourceNotFoundException(" Project id not found");
        }


    }
}